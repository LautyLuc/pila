import javax.lang.model.util.ElementScanner6;

public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAM = 10;

    public Cola() {
        this.arreglo = new Object[this.TAM];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object n) {
        boolean b = false;
        if (esVacia()) {
            arreglo[this.fin] = n;
            this.fin = (this.fin + 1) % TAM;
            b=true;
        } else if ((this.fin + 1) % TAM != (this.frente) % TAM) {
            b=false;
        }else{
            arreglo[this.fin] = n;
            this.fin = (this.fin + 1) % TAM;
            b = true;
        }
        return b;
    }

    public boolean sacar() {
        boolean b = true;

        if (this.esVacia()) {
            b = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAM;
        }
        return b;
    }

    public Object obtenerTope(){
        Object elem=null;
        if (!esVacia()) {
        elem=arreglo[this.frente];   
        }
        return elem;
    }

    public boolean esVacia() {
        return (this.frente == this.fin);
    }

    public void vaciar() {
        int i = 0;
        if (!esVacia()) {
            while (i != this.TAM) {
                if (this.arreglo[i] != null) {
                    this.arreglo[i] = null;
                }
                i++;
            }
        }
    }

}
