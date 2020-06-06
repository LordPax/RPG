package src;

import java.util.*;

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
                        int x = sc.nextInt(), y = sc.nextInt();
                        this.map.moveEntity(1, 0, x, y);
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
        System.out.println("move <x> <y> ...... Déplace le joueur");
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