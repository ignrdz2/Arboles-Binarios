package com.example;

public class TElementoAB<T> implements IElementoAB<T> {
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    public TElementoAB<T> padre;

    private Comparable etiqueta;
    private T dato;

    public TElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;

        padre = null;
        hijoIzq = null;
        hijoDer = null;
    }

    @Override
    public String toString(){
        return etiqueta.toString();
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public T getDato(){
        return this.dato;
    }

    @Override
    public void setDato(T value){
        this.dato = value;
    }

    // @Override
    // public TElementoAB<T> getPadre(){
    //     return this.padre;
    // }

    // public void setPadre(TElementoAB<T> padre){
    //     this.padre = padre;
    // }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public String preOrden() {
        String tempStr = etiqueta + " ";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    public String inOrden() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrden'");
    }

    @Override
    public String postOrden() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrden'");
    }

    @Override
    public T getDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDatos'");
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
}
