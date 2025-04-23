public class TestAlbolBin {
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        ArbolBin arbol2 = new ArbolBin();

        //sexo

        arbol.insertar("A", null, 'I');
        arbol.insertar("B", "A", 'I');
        arbol.insertar("C", "A", 'D');
        arbol.insertar("D", "B", 'I');
        arbol.insertar("E", "B", 'D');
        arbol.insertar("F", "C", 'I');
        arbol.insertar("G", "C", 'D');  


        System.out.println("por niveles: " + arbol.PorNivel().toString());
        
        System.out.println("Preorden: " + arbol.listarPreorden().toString());
        System.out.println("Inorden: " + arbol.ListarInorden().toString());
        System.out.println("Posorden: "+ arbol.listarPosorden().toString());


        System.out.println("Altura: " + arbol.altura());
        System.out.println("Altura: " + arbol2.altura());
        System.out.println("Nivel: " + arbol.nivel("C"));
        System.out.println("Nivel: " + arbol2.nivel("A"));
        System.out.println("Nivel: " + arbol.nivel("D"));
        System.out.println("Nivel: " + arbol2.nivel("B"));
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Preorden: " + arbol2.listarPreorden().toString());
        System.out.println("Nivel: " + arbol2.nivel(4));
        System.out.println("Nivel: " + arbol2.nivel(5));
        System.out.println("Nivel: " + arbol2.nivel(6));
        System.out.println("Nivel: " + arbol2.nivel(9));


        ArbolBin arbolito= new ArbolBin();

        arbolito.insertar(1,null,'I');
        arbolito.insertar(2,1,'I');
        arbolito.insertar(3,1,'D');
        arbolito.insertar(4,3,'D');

        arbolito.insertarPorPosicion(5, 2, 'I');
        arbolito.insertarPorPosicion(6, 2, 'D');
        arbolito.insertarPorPosicion(7, 3, 'I');
        arbolito.insertarPorPosicion(8, 4, 'D');

        System.out.println(arbolito.toString());
        
        Object n=arbol.padre("F");
        System.out.println(n);
    }


}
