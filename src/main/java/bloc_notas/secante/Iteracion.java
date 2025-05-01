package bloc_notas.secante;

public class Iteracion {
    private int numero;
    private double xnm1, xn, fxnm1, fxn, xnp1, error;

    public Iteracion(int numero, double xnm1, double xn, double fxnm1, double fxn, double xnp1, double error) {
        this.numero = numero;
        this.xnm1 = xnm1;
        this.xn = xn;
        this.fxnm1 = fxnm1;
        this.fxn = fxn;
        this.xnp1 = xnp1;
        this.error = error;
    }

    // Getters
    public int getNumero() { return numero; }
    public double getXnm1() { return xnm1; }
    public double getXn() { return xn; }
    public double getFxnm1() { return fxnm1; }
    public double getFxn() { return fxn; }
    public double getXnp1() { return xnp1; }
    public double getError() { return error; }
}