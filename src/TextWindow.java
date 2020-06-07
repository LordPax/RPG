package src;

import java.util.*;
import java.lang.Math;

public class TextWindow {
    private Map map;
    public static String TITLE = "\033[1m\033[31mRPG : \033[0m";

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
            System.out.print(TextWindow.TITLE + "Quel est votre choie > ");
            // sc.useDelimiter(" ");
            //str = sc.nextLine();

            switch(sc.next()) {
                case "help" :
                    this.help();
                    break;
                case "quit" :
                    System.out.println(TextWindow.TITLE + "Fermeture");
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
                        this.showPlayerInfo(40);
                    } catch(InputMismatchException e) {
                        System.out.println(TextWindow.TITLE + e);
                    }

                    break;
                default :
                    System.out.println(TextWindow.TITLE + "Votre requete n'a pas été comprise");
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

    public void showPlayerInfo(int width) {
        Entity entity = this.map.getPlayer();

        int wHp = (width * entity.getHealth()) / entity.getMaxHealth();
        int wMana = (width * entity.getMana()) / entity.getMaxMana();

        this.textLine(" Pseudo : " + entity.getName(), width, "\033[46m", "\033[37m");
        this.voidLine(width);
        this.progressBarre(wHp, width - 2, " PV : " + entity.getHealth(), "\033[41m", "\033[37m");
        this.progressBarre(wMana, width - 2, " Mana : " + entity.getMana(), "\033[44m", "\033[37m");
        this.voidLine(width);
        this.textLine(" Damage : " + entity.getDamage(), width, "\033[47m", "\033[30m");
        this.voidLine(width);
    }

    public void textLine(String text, int width, String bgColor, String fgColor) {
        String line = bgColor + fgColor;
        for (int i = 0; i < width; i++){
            if (i < text.length())
                line += text.charAt(i);
            else
                line += " ";
        }
        line += "\033[0m";
        System.out.println(line);
    }

    public void voidLine(int width) {
        String line = "\033[47m";
        for (int i = 0; i < width; i++)
            line += " ";
        line += "\033[0m";
        System.out.println(line);
    }

    public void progressBarre(int sub, int max, String text, String bgColor, String fgColor) {
        String barre = "\033[47m " + bgColor + fgColor;
        for (int i = 0; i < max; i++){
            if (i == sub){
                barre += "\033[37m";
                barre += "\033[40m";
            }
            if (i < text.length())
                barre += text.charAt(i);
            else
                barre += " ";
        }
        barre += "\033[47m \033[0m";
        System.out.println(barre);
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
