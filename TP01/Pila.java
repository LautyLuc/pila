public class Pila {
    private Nodo tope;

    public Pila (){
        this.tope=null;
    }

    public boolean apilar(Object tipElem){
        Nodo nuevo = new Nodo(tipElem, tope);
        this.tope=nuevo;
        return true;
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
                    s+=")";
                }
                s+=",";
            }
            s+="]";
        }
        return s;
    }
}
