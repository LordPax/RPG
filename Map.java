import java.util.ArrayList;
import java.util.List;

public class Map {
    private Case[] matrice;
    private int w;
    private int h;

    public Map() {
    }

    public Map(int w, int h) {
        this.w = w;
        this.h = h;
        this.initMap();
    }

    public void initMap() {
        int size = this.w * this.h;
        this.matrice = new Case[size];

        for (int i = 0; i < size; i++) {
            this.matrice[i] = new Case();
        }
    }

    public Case getCase(int x, int y) {
        int indice = y * this.w + x;
        return this.matrice[indice];
    }

    public Case[] getMatrice() {
        return this.matrice;
    }

    public void afficheMap() {
        String aff = "";

        for (int i = 0; i < this.h; i++) {
            for (int j = 0; j < this.w; j++) {
                aff += this.getCase(j, i).getTest();
            }
            System.out.println(aff);
            aff = "";
        }
    }
}
