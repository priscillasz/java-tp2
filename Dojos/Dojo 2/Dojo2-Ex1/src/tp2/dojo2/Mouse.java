package tp2.dojo2;

public class Mouse {
    private String cor;
    private String marca;
    private boolean rgb;
    private boolean wireless;

    public Mouse(String cor, String marca, boolean rgb, boolean wireless){
        this.cor = cor;
        this.marca = marca;
        this.rgb = rgb;
        this.wireless = wireless;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isRgb() {
        return rgb;
    }

    public boolean isWireless() {
        return wireless;
    }
}
