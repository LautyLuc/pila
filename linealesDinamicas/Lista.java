public class Lista {
    private Nodo cab = null;
    private int longitud = 0;

    public Lista() {
        this.cab = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean b = false;
        Nodo nuevoNodo = new Nodo(null, null);
        nuevoNodo.setElem(elem);
        if (pos <= longitud + 1) {
            if (pos == 1) {
                nuevoNodo.setEnlace(cab);
                cab = nuevoNodo;
                longitud++;
            } else {
                Nodo aux = cab;
                int acum = 1;
                while (acum != pos - 1) {
                    aux = aux.getEnlace();
                    acum++;
                }
                nuevoNodo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevoNodo);
                longitud++;
                b = true;
            }
        }
        return b;
    }

    public boolean eliminar(int pos) {
        boolean b = false;
        if (!esVacia()) {
            if (pos == 1) {
                cab = cab.getEnlace();
                longitud--;
            } else {
                Nodo aux = cab;
                int i = 1;
                while (i <= pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return b;
    }

    public boolean esVacia() {
        return this.longitud == 0;
    }

    public Object recuperar(int pos) {
        Object elem = null;
        Nodo n = this.cab;
        int i = 0;
        if (!esVacia() && pos <= this.longitud) {
            while (i <= pos) {
                n = n.getEnlace();
                i++;
            }
            elem = n.getElem();
        }
        return elem;
    }

    public int localizar(Object elem) {
        int pos = 0;
        Nodo n = this.cab;
        if (!esVacia()) {
            while (elem != n.getElem() || pos > this.longitud) {
                n = n.getEnlace();
                pos++;
            }
            if (elem != n.getElem()) {
                pos = -1;
            }
        }
        return pos;
    }

    public int longitud() {
        return this.longitud;
    }

    public void vaciar(){
        this.cab=null;
        this.longitud=0;
    }

    public Lista clone(){
        Lista li = new Lista();      
        if (this.cab != null) {
            li.cab=cloneNodo(this.cab);
        }
        li.longitud=this.longitud;
        return li;
    }

    private Nodo cloneNodo(Nodo nP){
        Nodo copia = new Nodo(null, null);
        Nodo aux= nP;
        if (!esVacia()) {
            if (aux.getEnlace()==null) {
                copia=aux;
            } else {
                copia= new Nodo(aux.getElem(),cloneNodo(aux.getEnlace()));
            }            
        }
        return copia;
    }
    @Override
    public String toString() {
        String s = "";
        Nodo aux = cab;
        if (!esVacia()) {
            while (aux != null) {
                if (aux.getEnlace() == null) {
                    s += aux.getElem() + " -> null";
                }else{
                s += aux.getElem() + " -> ";
            }
            aux = aux.getEnlace();
            }
        } else {
            s = "Lista vacia";
        }
        return s;
    }
}