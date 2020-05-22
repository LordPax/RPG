package src;

public class Case {
    private int typeEntity;
    private int idEntity;
    private int ground;
    private int build;
    private String test;

    public Case() {
        this.typeEntity = 0;
        this.idEntity = 0;
        this.ground = 0;
        this.build = 0;
        this.test = "0";
    }

    public Case(int te, int ie, int g, int b) {
        this.typeEntity = te;
        this.idEntity = ie;
        this.ground = g;
        this.build = b;
        this.test = "0";
    }

    public int getTypeEntity() {
        return this.typeEntity;
    }

    public int getIdEntity() {
        return this.idEntity;
    }

    public int getGround() {
        return this.ground;
    }

    public int getBuild() {
        return this.build;
    }

    public String getTest() {
        return this.test;
    }
}
