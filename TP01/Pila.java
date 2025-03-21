public class Pila {
    private Nodo tope;

    public Pila (){
        this.tope=null;
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public boolean apilar(Object tipElem){
        Nodo nuevo = new Nodo(tipElem, tope);
        this.tope=nuevo;
        return true;
    }

    public boolean desapilar(){
        boolean b = false;

        //     if(esVacia()){
        //         b=false;
        //     }else{
        //         this.tope=this.tope.getEnlace();
        //         b=true;
        //     }
        // return b;

        if(this.tope !=null){
            Nodo aux =this.tope.getEnlace();
            this.tope = aux;
            b = true;
        }
        return b;
    }

    public Object obtenerTope(){
        return this.tope == null ? null : this.tope.getElem();
    }

    public void vaciar(){
        while(this.tope!=null){
            this.tope.setElem(null);
            this.tope=this.tope.getEnlace();
        }
        System.out.println("pila vacia");
    }

    public Pila clone(){
        Pila copia = new Pila();
        copia.tope = cloneNodo(this.tope);
        
        return copia;
    }

    public Nodo cloneNodo(Nodo top){
        Nodo copiaTope=top;
        if (copiaTope.getEnlace()==null) {
            copiaTope=new Nodo(top.getElem(),null);
        } else {
            copiaTope=new Nodo(top.getElem(), cloneNodo(copiaTope.getEnlace()));
        }
        return copiaTope;
    }

    @Override
    public String toString(){
        String s="";

        if (this.tope==null) {
            s="pila vacia";
        } else {
            Nodo aux=this.tope;
            s="[";

            while(aux !=null){
                s+=aux.getElem().toString();
                aux= aux.getEnlace();
                if(aux !=null){
                    s+=",";
                }

            }
            s+="]";
        }
        return s;
    }
}
