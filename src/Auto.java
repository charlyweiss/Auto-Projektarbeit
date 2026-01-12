public class Auto {
    private String marke;
    private String modell;;
    private int ps;
    private double preis;
    private boolean eAuto;

    public Auto(String marke, String modell, int ps, double preis, boolean eAuto) {
        this.marke = marke;
        this.modell = modell;
        this.ps = ps;
        this.preis = preis;
        this.eAuto = eAuto;
    }

    public double getPreis() {
        return preis;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getPs() {
        return ps;
    }

    public boolean isEAuto() {
        return eAuto;
    }

    @Override
    public String toString() {
        return marke + "," + modell + " " + preis + " € ," + ps + " PS " + "," + (eAuto? "Elektro" : "Verbrenner");
    }

    public boolean istLuxusauto() {
        return preis >= 100000 || ps >= 400;
    }
}

