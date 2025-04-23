public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    public boolean insertar(Object elempadre, Object elemPadre, char lugar) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoArbol(elempadre, null, null);
        } else {
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elempadre, null, null));
                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elempadre, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }

        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }

        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoArbol nodo) {
        int alt = 0;
        if (nodo != null) {
            int hi = alturaAux(nodo.getIzquierdo());
            int hd = alturaAux(nodo.getDerecho());
            if (hi > hd) {
                alt = hi + 1;
            } else {
                alt = hd + 1;
            }
        } else {
            alt = -1;
        }
        return alt;
    }

    public int nivel(Object elem) {
        return nivelAux(this.raiz, elem, 0);
    }

    private int nivelAux(NodoArbol nodo, Object elem, int nivelActual) {
        int nivel = -1;

        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = nivelActual;
            } else {
                nivel = nivelAux(nodo.getIzquierdo(), elem, nivelActual + 1);
                if (nivel == -1) {
                    nivel = nivelAux(nodo.getDerecho(), elem, nivelActual + 1);
                }
            }
        }
        return nivel;
    }

    public boolean insertarPorPosicion(Object elem, int posPadre, char posHijo) {

        boolean exito = false;
        NodoArbol nodo = iPPaux(this.raiz, elem, posPadre, 1);

        if (nodo != null) {
            if (nodo.getIzquierdo() == null && posHijo == 'I') {
                nodo.setIzquierdo(new NodoArbol(elem, null, null));
                exito = true;
            } else if (nodo.getDerecho() == null && posHijo == 'D') {
                nodo.setDerecho(new NodoArbol(elem, null, null));
                exito = true;
            }
        }

        return exito;
    }

    private NodoArbol iPPaux(NodoArbol nodo, Object elem, int posPadre, int pos) {
        NodoArbol padre = null;
        if (nodo != null) {
            if (posPadre == pos) {
                padre = nodo;
            } else {
                pos++;
                padre = iPPaux(nodo.getIzquierdo(), elem, posPadre, pos);
                if (padre == null) {
                    pos++;
                    padre = iPPaux(nodo.getDerecho(), elem, posPadre, pos);
                }
            }
        }
        return padre;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public Object padre(Object elem) {
        Object elem2 = null;
        if (!esVacio()) {
            elem2 = padrastro(this.raiz, elem);
        }
        return elem2;
    }

    private Object padrastro(NodoArbol nodo, Object elem) {
        Object papi = null;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(elem)) {
                papi = nodo.getElem();
            } else if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(elem)) {
                papi = nodo.getElem();
            } else {
                papi = padrastro(nodo.getIzquierdo(), elem);
                if (papi == null) {
                    papi = padrastro(nodo.getDerecho(), elem);
                }
            }
        }
        return papi;
    }

    public Lista ListarInorden() {
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            listarPosordenAux(nodo.getDerecho(), lis);
            listarPosordenAux(nodo.getIzquierdo(), lis);
        }
    }

    public Lista PorNivel() {
        Cola q = new Cola();
        Lista lis = new Lista();
        if (this.raiz != null) {
            q.poner(this.raiz);
            while (!q.esVacia()) {
                NodoArbol nodoActual = (NodoArbol) q.obtenerFrente();
                q.sacar();

                lis.insertar(nodoActual.getElem(), lis.longitud() + 1);

                if (nodoActual != null) {
                    if (nodoActual.getIzquierdo() != null) {
                        q.poner(nodoActual.getIzquierdo());
                    }
                    if (nodoActual.getDerecho() != null) {
                        q.poner(nodoActual.getDerecho());
                    }
                }
            }
        }

        return lis;
    }

    // clone(): ArbolBinario
    // Genera y devuelve un árbol binario que es equivalente (igual estructura y
    // contenido de los nodos) que el árbol original.

    public String toString() {
        return toStringAux(this.raiz);
    }

    // es priv
    private String toStringAux(NodoArbol recorre) {
        String cadena = "";

        if (recorre != null) {
            cadena += recorre.getElem() + " ";

            if (recorre.getIzquierdo() != null) {
                cadena += " HI: " + recorre.getIzquierdo().getElem();
            } else {
                cadena += " HI: - ";
            }

            if (recorre.getDerecho() != null) {
                cadena += " HD: " + recorre.getDerecho().getElem();
            } else {
                cadena += " HD: -";
            }

            cadena += "\n";// salto de linea
            cadena += toStringAux(recorre.getIzquierdo()); // recorre primero lado izq
            cadena += toStringAux(recorre.getDerecho()); // despues se pasa al der
        }

        return cadena;
    }

}
