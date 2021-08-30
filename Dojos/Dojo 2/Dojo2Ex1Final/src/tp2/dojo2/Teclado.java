package tp2.dojo2;

public class Teclado {
    private Boolean wireless;
    private Boolean abnt;
    private Boolean macro;

    // setters
    public void setWireless(Boolean wireless) { this.wireless = wireless;}
    public void setAbnt(Boolean abnt) { this.abnt = abnt;}
    public void setMacro(Boolean macro) { this.macro = macro;}

    public void imprimir() {
        System.out.println("Wireless: " + wireless);
        System.out.println("ABNT: "+ abnt);
        System.out.println("Macro: " + macro);
    }
}