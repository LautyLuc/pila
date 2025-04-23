public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elem) {
        Nodo nuevoNodo = new Nodo(elem, null);
        if (this.frente != null) {
            fin.setEnlace(nuevoNodo);
            fin = nuevoNodo;
        } else {
            frente = nuevoNodo;
            fin = nuevoNodo;
        }
        return true;
    }

    public boolean sacar() {
        boolean b = false;
        if (this.frente != null) {
            this.frente = this.frente.getEnlace();
            b = true;
            if (this.frente == null) {
                this.fin = null;
            }
        } else {
            System.out.println("null");
        }
        return b;
    }

    public Object obtenerFrente() {
        Object elem = null;
        if (this.frente != null) {
            elem = this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        return (this.frente == this.fin && this.frente == null);
    }

    public void vaciar() {
        while (this.frente != null) {
            this.frente = this.frente.getEnlace();
        }
    }

    public Cola cloneRec() {
        Cola colacha = new Cola();
        if (this.frente != null) {
            colacha.frente = cloneNodos(this.frente);
            Nodo aux = colacha.frente;
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
            }
            colacha.fin = aux;
        }
        return colacha;
    }

    public Nodo cloneNodos(Nodo n1) {
        Nodo nodito = null;
        if (n1 != null) {
            nodito = new Nodo(n1.getElem(), null);
            if (n1.getEnlace() != null) {
                nodito.setEnlace(cloneNodos(n1.getEnlace()));
            }
        }
        return nodito;
    }

    public Cola clone() {
        Cola colacha = new Cola();
        Nodo aux = this.frente;
        Nodo nodito = new Nodo(aux.getElem(), null);

        colacha.frente = nodito;
        colacha.fin = nodito;
        while (aux != null) {
            aux = aux.getEnlace();
            nodito = new Nodo(aux.getElem(), null);

        }
        return colacha;
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = this.frente;
        if (esVacia()) {
            s = "la cola esta vacia";
        } else {
            s = "[";

            while (aux != null) {
                s += aux.getElem();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }

}
