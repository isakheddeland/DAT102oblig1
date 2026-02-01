package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
    private T data;
    private LinearNode<T> neste;

    public LinearNode(T data){
        this.data = data;
        this.neste = null;
    }

    public T getData(){
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public LinearNode<T> getNeste() {
        return neste;
    } public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
