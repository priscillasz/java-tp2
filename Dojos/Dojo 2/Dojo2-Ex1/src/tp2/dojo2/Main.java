package tp2.dojo2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // nova instancia/objeto da classe Scanner
        Scanner scan = new Scanner(System.in);

        // MOUSE //
        System.out.println("Mouse");
        System.out.println("Cor:");
        String corMouse = scan.nextLine();
        System.out.println("Marca:");
        String marcaMouse = scan.nextLine();
        System.out.println("RGB: (0 - não, 1 - sim)");
        int rgbInput = scan.nextInt();
        boolean rgbMouse;
        if (rgbInput == 1)
            rgbMouse = true;
        else
            rgbMouse = false;
        System.out.println("Wireless: (0 - não, 1 - sim)");
        int wirelessInput = scan.nextInt();
        boolean wirelessMouse;
        if (rgbInput == 1)
            wirelessMouse = true;
        else
            wirelessMouse = false;

        // criação da instância mouse da Classe Livro com os atributos inseridos pelo usuário.
        Mouse mouse = new Mouse(corMouse, marcaMouse, rgbMouse, wirelessMouse);

        // LIVRO //
        System.out.println("Livro");
        System.out.println("Título:");
        String tituloLivro = scan.nextLine(); // buffer do teclado
        tituloLivro = scan.nextLine();
        System.out.println("Autor:");
        String autorLivro = scan.nextLine();
        System.out.println("Idioma:");
        String idiomaLivro = scan.nextLine();
        System.out.println("Número de páginas:");
        int numPagLivro = scan.nextInt();
        System.out.println("Ano de lançamento:");
        int anoLancamentoLivro = scan.nextInt();

        // criação do objeto livro da Classe Livro com os atributos inseridos pelo usuário.
        Livro livro = new Livro(tituloLivro, autorLivro, idiomaLivro, numPagLivro, anoLancamentoLivro);

        // RELÓGIO //
        System.out.println("Relógio");
        System.out.println("Digital: (0 - não, 1 - sim)");
        int digitalInput = scan.nextInt();
        boolean digitalRelogio;
        if (digitalInput == 1)
            digitalRelogio = true;
        else
            digitalRelogio = false;
        System.out.println("Cor:");
        String corRelogio = scan.nextLine(); // buffer do teclado
        corRelogio = scan.nextLine();
        System.out.println("Marca:");
        String marcaRelogio = scan.nextLine();
        System.out.println("Bluetooth: (0 - não, 1 - sim)");
        int bluetoothInput = scan.nextInt();
        boolean bluetoothRelogio;
        if (bluetoothInput == 1)
            bluetoothRelogio = true;
        else
            bluetoothRelogio = false;

        // criação do objeto relogio da Classe Relogio com os atributos inseridos pelo usuário.
        Relogio relogio = new Relogio(digitalRelogio, corRelogio, marcaRelogio, bluetoothRelogio);

        // TECLADO //
        System.out.println("Teclado");
        System.out.println("Cor:");
        String corTeclado = scan.nextLine(); // buffer do teclado
        corTeclado = scan.nextLine();
        System.out.println("Marca:");
        String marcaTeclado = scan.nextLine();
        System.out.println("Número de teclas:");
        int numTeclas = scan.nextInt();
        System.out.println("Tipo de switches:");
        String tipoSwitches = scan.nextLine(); // buffer do teclado
        tipoSwitches = scan.nextLine();

        // criação da instância teclado da classe Teclado com os atributos inseridos pelo usuário.
        Teclado teclado = new Teclado(corTeclado, marcaTeclado, numTeclas, tipoSwitches);

        // CELULAR //
        System.out.println("Celular");
        System.out.println("Modelo:");
        String modeloCelular = scan.nextLine();
        System.out.println("Marca:");
        String marcaCelular = scan.nextLine();
        System.out.println("Cor:");
        String corCelular = scan.nextLine();
        System.out.println("Capacidade de armazenamento interno (em GB):");
        int capacidadeArmazenamento = scan.nextInt();

        // criação do objeto celular da classe Celular com os atributos inseridos pelo usuário
        Celular celular = new Celular(modeloCelular, marcaCelular, corCelular, capacidadeArmazenamento);

        // Imprime as características/atributos de cada objeto
        // Mouse
        System.out.println("-------Especificações do Mouse-------");
        System.out.println("Cor: "+ mouse.getCor());
        System.out.println("Marca: "+mouse.getMarca());
        System.out.println("RGB: "+mouse.isRgb());
        System.out.println("Wireless: "+mouse.isWireless());

        // Livro
        System.out.println("-------Especificações do Livro-------");
        System.out.println("Título: "+livro.getTitulo());
        System.out.println("Autor: "+livro.getAutor());
        System.out.println("Idioma: "+livro.getIdioma());
        System.out.println("Número de páginas: "+livro.getNumeroPaginas());
        System.out.println("Ano de lançamento: "+livro.getAnoLancamento());

        // Relógio
        System.out.println("-------Especificações do Relógio-------");
        System.out.println("Digital: "+relogio.isDigital());
        System.out.println("Cor: "+relogio.getCor());
        System.out.println("Marca: "+relogio.getMarca());
        System.out.println("Bluetooth: "+relogio.isBluetooth());

        // Teclado
        System.out.println("-------Especificações do Teclado-------");
        System.out.println("Cor: "+teclado.getCor());
        System.out.println("Marca: "+teclado.getMarca());
        System.out.println("Número de teclas: "+teclado.getNumeroDeTeclas());
        System.out.println("Tipo de switches: "+teclado.getTipoDeSwitches());

        // Celular
        System.out.println("-------Especificações do Celular-------");
        System.out.println("Modelo: "+celular.getModelo());
        System.out.println("Marca: "+celular.getMarca());
        System.out.println("Cor: "+celular.getCor());
        System.out.println("Capacidade de armazenamento: "+celular.getArmazenamento());
    }
}
