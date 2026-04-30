package Uke16;

public class Oppgave2b {
    public void skrivVerdier(T nedre, T ovre) {
            skrivVerdierRek(rot, nedre, ovre);
    }
    private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
        if (t == null) return;

        int cmpMin = t.getElement().compareTo(min);
        int cmpMax = t.getElement().compareTo(maks);

        if (cmpMin > 0) {
                skrivVerdierRek(t.getVenstre(), min, maks);
        }

        if (cmpMin >= 0 && cmpMax <= 0) {
                System.out.print(t.getElement() + " ");
        }

        if (cmpMax < 0) {
                skrivVerdierRek(t.getHogre(), min, maks);
        }
    }
}
