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
            str = sc.nextLine();

            switch(str) {
                case "help" :
                    this.help();
                    break;
                case "quit" :
                    System.out.println("RPG : Fermeture");
                    ok = false;
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

        for (int i = 0; i < this.map.getHeight(); i++) {
            for (int j = 0; j < this.map.getWidth(); j++)
                aff += showTexture(this.map.getCase(j, i));
            
            System.out.println(aff);
            aff = "";
        }
    }

    public String showTexture(Case c) {
        String ground = "", entity = " ";

        switch(c.getGround()) {
            case 0 :
                ground = "\033[42m";
                break;
        }

        switch(c.getTypeEntity()) {
            case 1 :
                entity = "\033[34m◉ ";
                break;
            case 2 :
                entity = "\033[31m▲ ";
                break;
            default :
                entity = "  ";
                break;
        }

        return ground + entity + "\033[0m";
    }
}