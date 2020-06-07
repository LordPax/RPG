package src;

import java.util.*;
import java.lang.Math;

public class TextWindow {
    private Map map;

    public TextWindow(Map map) {
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void choice() {
        Scanner sc = new Scanner(System.in);
        String str = "";
        boolean ok = true;

        while(ok) {
            System.out.print("RPG : Quel est votre choie > ");
            // sc.useDelimiter(" ");
            //str = sc.nextLine();

            switch(sc.next()) {
                case "help" :
                    this.help();
                    break;
                case "quit" :
                    System.out.println("RPG : Fermeture");
                    ok = false;
                    break;
                case "move" :
                    try {
                        String move = sc.nextLine();
                        int aleax = (int) (Math.random()*(3-1+1))-1;
                        int aleay = (int) (Math.random()*(3-1+1))-1;
                        int aleaxDeux = (int) (Math.random()*(3-1+1))-1;
                        int aleayDeux = (int) (Math.random()*(3-1+1))-1;
                        int aleaxTrois = (int) (Math.random()*(3-1+1))-1;
                        int aleayTrois = (int) (Math.random()*(3-1+1))-1;
                        int aleaxQuatre = (int) (Math.random()*(3-1+1))-1;
                        int aleayQuatre = (int) (Math.random()*(3-1+1))-1;
                        //int x = this.map.getPlayer().getX(), y = this.map.getPlayer().getY();
                        if (move.contains("q")) {
                          this.map.moveEntity(1, 0, -1, 0);
                          this.map.moveEntity(2, 3, aleax, aleay);
                          this.map.moveEntity(2, 2, aleaxDeux, aleayDeux);
                          this.map.moveEntity(2, 1, aleaxTrois, aleayTrois);
                          this.map.moveEntity(2, 0, aleaxQuatre, aleayQuatre);
                          System.out.println(aleax);
                        }
                        else if (move.contains("d")) {
                          this.map.moveEntity(1, 0, 1, 0);
                          this.map.moveEntity(2, 3, aleax, aleay);
                          this.map.moveEntity(2, 2, aleaxDeux, aleayDeux);
                          this.map.moveEntity(2, 1, aleaxTrois, aleayTrois);
                          this.map.moveEntity(2, 0, aleaxQuatre, aleayQuatre);
                        }
                        else if (move.contains("z")) {
                          this.map.moveEntity(1, 0, 0, -1);
                          this.map.moveEntity(2, 3, aleax, aleay);
                          this.map.moveEntity(2, 2, aleaxDeux, aleayDeux);
                          this.map.moveEntity(2, 1, aleaxTrois, aleayTrois);
                          this.map.moveEntity(2, 0, aleaxQuatre, aleayQuatre);
                        }
                        else if (move.contains("s")) {
                          this.map.moveEntity(1, 0, 0, 1);
                          this.map.moveEntity(2, 3, aleax, aleay);
                          this.map.moveEntity(2, 2, aleaxDeux, aleayDeux);
                          this.map.moveEntity(2, 1, aleaxTrois, aleayTrois);
                          this.map.moveEntity(2, 0, aleaxQuatre, aleayQuatre);
                        }
                        else {
                          System.out.println("Touche non enregistrée, recommencer svp!"); }

                        //this.map.moveEntity(1, 0, x, y);
                        this.showMap();
                    } catch(InputMismatchException e) {
                        System.out.println("RPG error : " + e);
                    }

                    break;
                default :
                    System.out.println("RPG : Votre requete n'a pas été comprise");
                    break;
            }
        }
    }

    public void help() {
        System.out.println("\n=============== Help ================");
        System.out.println("help ................. Affiche l'aide");
        System.out.println("quit ................... Ferme le jeu");
        System.out.println("move <q>(gauche)/<d>(droite)/<z>(haut)/<s>(bas) ...... Déplace le joueur");
        System.out.println("=====================================\n");
    }

    public void titre() {
        System.out.println("▒▒▒╔═══╦═══╦═══╗▒╔╗▒▒▒▒▒▒▒╔╗▒▒▒▒▒▒╔╗▒▒▒▒");
        System.out.println("▒▒▒║╔═╗║╔═╗║╔═╗║╔╝╚╗▒▒▒▒▒╔╝╚╗▒▒▒▒▒║║▒▒▒▒");
        System.out.println("▒▒▒║╚═╝║╚═╝║║▒╚╝╚╗╔╬══╦╗╔╬╗╔╬╗╔╦══╣║▒▒▒▒");
        System.out.println("▒▒▒║╔╗╔╣╔══╣║╔═╗▒║║║║═╬╬╬╝║║║║║║║═╣║▒▒▒▒");
        System.out.println("▒▒▒║║║╚╣║▒▒║╚╩═║▒║╚╣║═╬╬╬╗║╚╣╚╝║║═╣╚╗▒▒▒");
        System.out.println("▒▒▒╚╝╚═╩╝▒▒╚═══╝▒╚═╩══╩╝╚╝╚═╩══╩══╩═╝▒▒▒");
    }

    public void showMap() {
        String aff = "";

        for (int i = 0; i < this.map.getHeight(); i++) { // parcoure chaques lignes
            for (int j = 0; j < this.map.getWidth(); j++) // parcoure chaques colonnes
                aff += showTexture(this.map.getCase(j, i));

            System.out.println(aff);
            aff = "";
        }
    }

    public String showTexture(Case c) {
        String ground = "", entity = " ";

        switch(c.getGround()) {
            case 0 :
                ground = "\033[42m"; // couleur du sol
                break;
        }

        switch(c.getTypeEntity()) {
            case 1 :
                entity = "\033[34m" + this.map.getPlayer().getSymbol() + " "; // couleur et symbole du joueur
                break;
            case 2 :
                entity = "\033[31m" + this.map.getMob(c.getIdEntity()).getSymbol() + " "; // couleur et symbole des mob
                break;
            default :
                entity = "  "; // case sans entité
                break;
        }

        return ground + entity + "\033[0m";
    }
}
