package src;

public class Case {
    private int typeEntity;
    private int idEntity;
    private int ground;
    private int build;
    private String test;

    public Case() {
        this.typeEntity = 0; // type de l'entité : 0 -> rien, 1 -> player, 2 -> mob
        this.idEntity = 0; // id de l'entité : pour retrouver l'entité dans l'ArrayList (le player n'a pas besoin d'id car il est le seule player)
        this.ground = 0; // sole : 0 -> herbe
        this.build = 0; // construction : 0 -> rien
        this.test = "0";
    }

    public Case(int typeEntity, int idEntity, int ground, int build) {
        this.typeEntity = typeEntity;
        this.idEntity = idEntity;
        this.ground = ground;
        this.build = build;
        this.test = "0";
    }

    // public Case(Entity entity) {
    //     this.typeEntity = entity.getType();
    //     this.idEntity = entity.getId();
    //     this.ground = ;
    //     this.build = ;
    //     this.test = "0";
    // }

    public int getTypeEntity() {
        return this.typeEntity;
    }

    public void setTypeEntity(int te) {
        this.typeEntity = te;
    }

    public int getIdEntity() {
        return this.idEntity;
    }

    public void setIdEntity(int ie) {
        this.idEntity = ie;
    }

    public int getGround() {
        return this.ground;
    }

    public void setGround(int g) {
        this.ground = g;
    }

    public int getBuild() {
        return this.build;
    }

    public void setBuild(int b) {
        this.build = b;
    }

    public String getTest() {
        return this.test;
    }
}
