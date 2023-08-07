public class Computador {
    private int ram;
    private int hd;
    static int contador;

    public Computador(int ram, int hd) {
        this.ram = ram;
        this.hd = hd;
        contador++;
        System.out.println("contador: " + Computador.contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }
}
