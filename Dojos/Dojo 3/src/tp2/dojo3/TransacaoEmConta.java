package tp2.dojo3;

import java.time.LocalDate;

public interface TransacaoEmConta {

    void setValor(double valorOp);

    void setDescricao(String descOp);

    void setTipoOperacao(String operacao);

    void setData(LocalDate dataOp);

    double getValor();

    String getDescricao();

    String getTipoOperacao();

    LocalDate getData();
}
