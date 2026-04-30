package Uke17_18;

class BinaerTreNode<T> {
    private T verdi;
    private BinaerTreNode<T> venstre;
    private BinaerTreNode<T> hoyre;
    private int hogdeU;

    public BinaerTreNode(T verdi) {
        this.verdi = verdi;
        this.venstre = null;
        this.hoyre = null;
        this.hogdeU = 1;
    }

    public T getVerdi() {
        return verdi;
    }

    public BinaerTreNode<T> getVenstre() {
        return venstre;
    }

    public BinaerTreNode<T> getHoyre() {
        return hoyre;
    }

    public void setVenstre(BinaerTreNode<T> venstre) {
        this.venstre = venstre;
    }

    public void setHoyre(BinaerTreNode<T> hoyre) {
        this.hoyre = hoyre;
    }

    public int getHogdeU() {
        return hogdeU;
    }

    public void setHogdeU(int hogdeU) {
        this.hogdeU = hogdeU;
    }
}