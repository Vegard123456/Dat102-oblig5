package Uke17_18;

import Uke17_18.BinaerTreNode;

public class BinaerTre<T extends Comparable<T>> {
    private BinaerTreNode<T> rot;

    public void leggTil(T verdi) {
        rot = leggTil(rot, verdi);
    }

    private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T verdi) {
        if (p == null) {
            return new BinaerTreNode<>(verdi);
        }

        if (verdi.compareTo(p.getVerdi()) < 0) {
            p.setVenstre(leggTil(p.getVenstre(), verdi));
        } else {
            p.setHoyre(leggTil(p.getHoyre(), verdi));
        }

        int v = (p.getVenstre() != null) ? p.getVenstre().getHogdeU() : 0;
        int h = (p.getHoyre() != null) ? p.getHoyre().getHogdeU() : 0;

        p.setHogdeU(1 + Math.max(v, h));

        return p;
    }

    public boolean erBalansert() {
        return erBalansert(rot);
    }

    private boolean erBalansert(BinaerTreNode<T> p) {
        if (p == null) return true;

        int v = (p.getVenstre() != null) ? p.getVenstre().getHogdeU() : 0;
        int h = (p.getHoyre() != null) ? p.getHoyre().getHogdeU() : 0;

        if (Math.abs(v - h) > 1) return false;

        return erBalansert(p.getVenstre()) && erBalansert(p.getHoyre());
    }
}