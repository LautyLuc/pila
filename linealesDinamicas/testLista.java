
//import LIsta.java;
public class testLista{
    
    public static void main (String[] args){
        Lista unaLista = new Lista();
        for(int i=1;i<6;i++){
            unaLista.insertar(i,i);
        }
        Lista cloneL=unaLista.clone();
        unaLista.insertar(5, 6);
        cloneL.eliminar(3);
        System.out.println("["+unaLista.toString()+"]" + " // " + "[" + cloneL.toString()+"]");
        cloneL.vaciar();
        System.out.println("recup: " + unaLista.recuperar(4));
        System.out.println("post vaciar " +"["+ cloneL.toString()+" ]");
        System.out.println("Localizar: " + unaLista.localizar(2));
        
    }
}
