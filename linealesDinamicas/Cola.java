public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola(){
        this.frente=null;
        this.fin=null;
    }    

    public boolean poner(Object elem){
        Nodo nuevoNodo = new Nodo(elem, null);
        if (this.frente!=null) {
            fin.setEnlace(nuevoNodo);
            fin=nuevoNodo;
        }else{
            frente=nuevoNodo;
            fin=nuevoNodo;
        }
        return true;
    }
    public boolean sacar(){
        boolean b=false;
        if (this.frente != null) {
            this.frente=this.frente.getEnlace();
            b=true;
            if(this.frente==null){
                this.fin=null;
            }
        }else{
            System.out.println("null");
        }
        return b;
    }

    public Object obtenerFrente(){
        Object elem=null;
        if (this.frente!=null) {
            elem=this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia(){
        return (this.frente==this.fin && this.frente==null);
    }

    public void vaciar(){
        while(!esVacia()){
            this.frente=this.frente.getEnlace();
        }
    }

    public Cola clone(){
        Cola colacha=new Cola();
        if(colacha.fin.getEnlace()!=null){
            colacha.cloneNodos(this.frente);
        }
        return colacha = new Cola();
    }

    public Nodo cloneNodos(Nodo n1){
        Nodo nodito=n1;
        if (nodito.getEnlace()==null) {
            nodito=new Nodo(n1.getElem(),null);
        } else {
            nodito=new Nodo(n1.getElem(), cloneNodos(nodito.getEnlace()));
        }
        return nodito;
    }
    
    @Override
    public String toString(){
        String s="";
        Nodo aux=this.frente;
        if(esVacia()){
            s="la cola esta vacia";
        }else{
            s="[";

            while(aux!=null){
                s+=aux.getElem();
                aux=aux.getEnlace();
                if (aux!=null) {
                    s+=",";
                }
            }
            s+="]";
        }
        return s;
    }

}
