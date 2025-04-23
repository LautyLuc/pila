public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
        public NodoArbol(Object elem, NodoArbol i, NodoArbol d){
            this.elem=elem;
            this.izquierdo=i;
            this.derecho=d;
        }
    
        public Object getElem(){
            return this.elem;
        }
    
        public NodoArbol getIzquierdo(){
            return this.izquierdo;
        }
    
        public NodoArbol getDerecho(){
            return this.derecho;
        }
    
        public void setElem (Object el){
            this.elem=el;
        }
    
        public void setIzquierdo (NodoArbol i){
            this.izquierdo= i;
        }
    
        public void setDerecho (NodoArbol d){
            this.derecho=d;
        }
    }










    