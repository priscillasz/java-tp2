package tp2.dojo3;

import java.util.Date;

public interface TransacaoEmConta {

    // nao precisa do public pq a ide diz que é redundante

    void setValor(double valorOp);

    void setDescricao(String descOp);
    void setTipoOperacao(int operacao);

    void setData(Date dataOp);

    double getValor();

    String getDescricao();

    int getTipoOperacao();

    Date getData();

}
