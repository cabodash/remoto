package clasesFifa;

public class Carta {
	private String nombre;
	private int cod_jugador;
	private int rat;
	private String pos;
	private int precio;
	private int pac;
	private int sho;
	private int pas;
	private int dri;
	private int def;
	private int phy;
	private int pierna_mala;
	private int filigranas;

	public Carta() {
	}

	public Carta(String nombre, int cod_jugador, int rat, String pos, int precio, int pac, int sho, int pas, int dri,
			int def, int phy, int pierna_mala, int filigranas) {
		super();
		this.nombre = nombre;
		this.cod_jugador = cod_jugador;
		this.rat = rat;
		this.pos = pos;
		this.precio = precio;
		this.pac = pac;
		this.sho = sho;
		this.pas = pas;
		this.dri = dri;
		this.def = def;
		this.phy = phy;
		this.pierna_mala = pierna_mala;
		this.filigranas = filigranas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCod_jugador() {
		return cod_jugador;
	}

	public void setCod_jugador(int cod_jugador) {
		this.cod_jugador = cod_jugador;
	}

	public int getRat() {
		return rat;
	}

	public void setRat(int rat) {
		if(rat>=0 && rat<=99) {
		this.rat = rat;
		}else {
			this.rat=0;
			System.out.println("El ratio introducido es inválido, por defecto se establecerá a 0");
		}
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPac() {
		return pac;
	}

	public void setPac(int pac) {
		if(pac>=0 && pac<=99) {
			this.pac = pac;
			}else {
				this.pac=0;
				System.out.println("El ritmo (pac) introducido es inválido, por defecto se establecerá a 0");
			}
	}

	public int getSho() {
		return sho;
	}

	public void setSho(int sho) {
		if(sho>=0 && sho<=99) {
			this.sho = sho;
			}else {
				this.sho=0;
				System.out.println("El tiro (sho) introducido es inválido, por defecto se establecerá a 0");
			}
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		if(pas>=0 && pas<=99) {
			this.pas = pas;
			}else {
				this.pas=0;
				System.out.println("El pase (pas) introducido es inválido, por defecto se establecerá a 0");
			}
	}

	public int getDri() {
		return dri;
	}

	public void setDri(int dri) {
		if(dri>=0 && dri<=99) {
			this.dri = dri;
			}else {
				this.dri=0;
				System.out.println("El regate (dri) introducido es inválido, por defecto se establecerá a 0");
			}
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		if(def>=0 && def<=99) {
			this.def = def;
			}else {
				this.def=0;
				System.out.println("La defensa (def) introducida es inválida, por defecto se establecerá a 0");
			}
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		if(phy>=0 && phy<=99) {
			this.phy = phy;
			}else {
				this.phy=0;
				System.out.println("El físico (phy) introducido es inválido, por defecto se establecerá a 0");
			}
	}

	public int getPierna_mala() {
		return pierna_mala;
	}

	public void setPierna_mala(int pierna_mala) {
		if(pierna_mala>=0 && pierna_mala<=5) {
			this.pierna_mala = pierna_mala;
			}else {
				this.pierna_mala=0;
				System.out.println("El valor introducido para la pierna mala es inválido, por defecto se establecerá a 0");
			}
	}

	public int getFiligranas() {
		return filigranas;
	}

	public void setFiligranas(int filigranas) {
		if(filigranas>=0 && filigranas<=5) {
			this.filigranas = filigranas;
			}else {
				this.filigranas=0;
				System.out.println("El valor introducido para la filigranas es inválido, por defecto se establecerá a 0");
			}
	}

}
