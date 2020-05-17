public class Case {
	private int typeId;
	private int ground;
	private int build;
	private String test;

	public Case() {
		this.typeId = 0;
		this.ground = 0;
		this.build = 0;
		this.test = "0";
	}

	public Case(int e, int g, int b) {
		this.typeId = e;
		this.ground = g;
		this.build = b;
		this.test = "0";
	}

	public int getTypeId() {
		return this.typeId;
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
