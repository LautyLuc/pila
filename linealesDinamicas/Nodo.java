class Nodo{
    private Object elem;
    private Nodo enlace;
    
    //constructor
    public Nodo (Object elem, Nodo enlace){
        this.elem=elem;
        this.enlace=enlace;
    
    }

    //mod
    public void setElem(Object elem){
        this.elem=elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace=enlace;
    }

    //obs
    public Object getElem(){
        return elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }
}



