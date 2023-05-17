package clasesFifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {
	private Connection conexion;

	public BDController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/fifa23", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	/**
	 * Devuelve una Liga de la base de datos por su código
	 * 
	 * @param cod_liga el código de la Liga
	 * @return el Objeto Liga
	 */
	public Liga consultaLiga(int cod_liga) {
		String sql = "SELECT * FROM ligas where cod_liga='" + cod_liga + "'";
		Liga result = new Liga();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = new Liga(rs.getInt("cod_liga"), rs.getString("nombre"), rs.getString("pais"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaLiga: " + e.getMessage());
			return new Liga();
		}
		return result;

	}

	/**
	 * Devuelve un Equipo de la base de datos por su código
	 * 
	 * @param cod_equipo el código de el Equipo
	 * @return el Objeto Equipo
	 */
	public Equipo consultaEquipo(int cod_equipo) {
		String sql = "SELECT * FROM equipos where cod_equipo='" + cod_equipo + "'";
		Equipo result = new Equipo();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = new Equipo(rs.getInt("cod_equipo"), rs.getString("nombre"), rs.getInt("cod_liga"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaEquipo: " + e.getMessage());
			return new Equipo();
		}
		return result;

	}

	/**
	 * Devuelve un Jugador de la base de datos por su código
	 * 
	 * @param cod_jugador el código de el Jugador
	 * @return el Objeto Jugador
	 */
	public Jugador consultaJugador(int cod_jugador) {
		String sql = "SELECT * FROM jugadores where cod_jugador='" + cod_jugador + "'";
		Jugador result = new Jugador();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = new Jugador(rs.getInt("cod_jugador"), rs.getString("nombre"), rs.getInt("cod_equipo"),
						rs.getString("pierna"), rs.getInt("altura"), rs.getString("pais"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaJugador: " + e.getMessage());
			return new Jugador();
		}
		return result;

	}

	/**
	 * Devuelve una Carta de la base de datos por su código
	 * 
	 * @param cod_liga el código de la Carta
	 * @return el Objeto Carta
	 */
	public Carta consultaCarta(int cod_jugador, String nombre) {
		String sql = "SELECT * FROM cartas where cod_jugador='" + cod_jugador + "' AND nombre='" + nombre + "'";
		Carta result = new Carta();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = new Carta(rs.getString("nombre"), rs.getInt("cod_jugador"), rs.getInt("rat"),
						rs.getString("pos"), rs.getInt("precio"), rs.getInt("pac"), rs.getInt("sho"), rs.getInt("pas"),
						rs.getInt("dri"), rs.getInt("def"), rs.getInt("phy"), rs.getInt("pierna_mala"),
						rs.getInt("filigranas"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaCarta: " + e.getMessage());
			return new Carta();
		}
		return result;

	}

	
	
	/**
	 * Devuelve todas las Ligas de la base de datos
	 * 
	 * @return un ArrayList de Objetos Liga
	 */
	public ArrayList<Liga> consultaLigas() {
		String sql = "SELECT * FROM ligas";
		ArrayList<Liga> result = new ArrayList<Liga>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Liga(rs.getInt("cod_liga"), rs.getString("nombre"), rs.getString("pais")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaLigas: " + e.getMessage());
			return result;
		}
		return result;

	}

	/**
	 * Devuelve todos los Equipos de la base de datos
	 * 
	 * @return Un ArrayList de Objetos Equipo
	 */
	public ArrayList<Equipo> consultaEquipos() {
		String sql = "SELECT * FROM equipos";
		ArrayList<Equipo> result = new ArrayList<Equipo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Equipo(rs.getInt("cod_equipo"), rs.getString("nombre"), rs.getInt("cod_liga")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaEquipos: " + e.getMessage());
			return result;
		}
		return result;

	}

	/**
	 * Devuelve un Jugador de la base de datos por su código
	 * 
	 * @return Un ArrayList de Objetos Jugador
	 */
	public ArrayList<Jugador> consultaJugadores() {
		String sql = "SELECT * FROM jugadores";
		ArrayList<Jugador> result = new ArrayList<Jugador>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Jugador(rs.getInt("cod_jugador"), rs.getString("nombre"), rs.getInt("cod_equipo"),
						rs.getString("pierna"), rs.getInt("altura"), rs.getString("pais")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaJugadores: " + e.getMessage());
			return result;
		}
		return result;

	}

	/**
	 * Devuelve todas las Cartas de la base de datos
	 * 
	 * @return Un ArrayList de Objetos Carta
	 */
	public ArrayList<Carta> consultaCartas() {
		String sql = "SELECT * FROM cartas";
		ArrayList<Carta> result = new ArrayList<Carta>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Carta(rs.getString("nombre"), rs.getInt("cod_jugador"), rs.getInt("rat"),
						rs.getString("pos"), rs.getInt("precio"), rs.getInt("pac"), rs.getInt("sho"), rs.getInt("pas"),
						rs.getInt("dri"), rs.getInt("def"), rs.getInt("phy"), rs.getInt("pierna_mala"),
						rs.getInt("filigranas")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaCartas: " + e.getMessage());
			return result;
		}
		return result;

	}

	
	
	/**
	 * Comprueba si la Liga existe por su código 
	 * @param cod_liga el codigo de la Liga
	 * @return Verdadero si existe / Falso si no existe
	 */
	public boolean existeLiga(int cod_liga) {
		String sql = "SELECT nombre FROM ligas WHERE cod_liga='" + cod_liga + "'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			boolean existe = rs.next();
			st.close();
			rs.close();
			return existe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeLiga: " + e.getMessage());
			return false;
		}

	}

	/**
	 * Comprueba si el Equipo existe por su código 
	 * @param cod_equipo el codigo del Equipo
	 * @return Verdadero si existe / Falso si no existe
	 */
	public boolean existeEquipo(int cod_equipo) {
		String sql = "SELECT nombre FROM equipos WHERE cod_equipo='" + cod_equipo + "'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			boolean existe = rs.next();
			st.close();
			rs.close();
			return existe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeEquipo: " + e.getMessage());
			return false;
		}

	}
	
	/**
	 * Comprueba si el Jugador existe por su código 
	 * @param cod_jugador el codigo del Jugador
	 * @return Verdadero si existe / Falso si no existe
	 */
	public boolean existeJugador(int cod_jugador) {
		String sql = "SELECT nombre FROM jugadores WHERE cod_jugador='" + cod_jugador + "'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			boolean existe = rs.next();
			st.close();
			rs.close();
			return existe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeJugador: " + e.getMessage());
			return false;
		}

	}
	
	/**
	 * Comprueba si la Carta existe por el codigo del Jugador y el nombre de Carta 
	 * @param cod_jugador el codigo del Jugador
	 * @param nombre el nombre de la carta
	 * @return Verdadero si existe / Falso si no existe
	 */
	public boolean existeCarta(int cod_jugador, String nombre) {
		String sql = "SELECT nombre FROM cartas WHERE cod_jugador='" + cod_jugador + "' AND nombre='"+ nombre +"'";
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			boolean existe = rs.next();
			st.close();
			rs.close();
			return existe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeCarta: " + e.getMessage());
			return false;
		}

	}
	
	public ArrayList<Equipo> equiposDeUnaLiga(int codLiga) {
		String sql = "SELECT * FROM equipos where cod_liga="+ codLiga +"";
		ArrayList<Equipo> result = new ArrayList<Equipo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Equipo(rs.getInt("cod_equipo"), rs.getString("nombre"), rs.getInt("cod_liga")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en equiposDeUnaLiga: " + e.getMessage());
			return result;
		}
		return result;

	}
	
	
	public ArrayList<Jugador> jugadoresDeUnEquipo(int codEq) {
		String sql = "SELECT * FROM jugadores where cod_equipo='"+ codEq +"'";
		ArrayList<Jugador> result = new ArrayList<Jugador>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Jugador(rs.getInt("cod_jugador"), rs.getString("nombre"), rs.getInt("cod_equipo"),
						rs.getString("pierna"), rs.getInt("altura"), rs.getString("pais")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en jugadoresDeUnEquipo: " + e.getMessage());
			return result;
		}
		return result;

	}
	public ArrayList<Carta> cartasDeUnJug(int codJug) {
		String sql = "SELECT * FROM cartas where cod_jugador='" + codJug + "'";
		ArrayList<Carta> result = new ArrayList<Carta>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(new Carta(rs.getString("nombre"), rs.getInt("cod_jugador"), rs.getInt("rat"),
						rs.getString("pos"), rs.getInt("precio"), rs.getInt("pac"), rs.getInt("sho"), rs.getInt("pas"),
						rs.getInt("dri"), rs.getInt("def"), rs.getInt("phy"), rs.getInt("pierna_mala"),
						rs.getInt("filigranas")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en consultaCartas: " + e.getMessage());
			return result;
		}
		return result;

	}
	public int maxcodJugador() {
		int codigoMasAlto = 0;
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(cod_jugador) FROM jugadores");
			if (rs.next()) {
				codigoMasAlto = rs.getInt("MAX(cod_jugador)");
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Error en maxcodJugador: " + e.getMessage());
		}
		return codigoMasAlto;
	}
	public void altaJugador(int cod_jug, String nombre, int cod_equipo, String pierna, int altura, String pais) {
		String sql = "INSERT INTO jugadores values("+ cod_jug +",'" + nombre + "'," + cod_equipo + ",'" + pierna + "'," + altura + 
				",'" + pais + "')";
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Jugador insertado en la tabla jugadores");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en altaJugador: " + e.getMessage());
		}
	}
	public void bajaJugador(int cod_jug) {
		String sql = "DELETE FROM jugadores where cod_jugador='"+ cod_jug +"'";
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Jugador eliminado de la tabla jugadores");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaJugador: " + e.getMessage());
		}
	}
	
	public int maxcodEquipo() {
		int codigoMasAlto = 0;
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(cod_equipo) FROM equipos");
			if (rs.next()) {
				codigoMasAlto = rs.getInt("MAX(cod_equipo)");
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Error en maxcodEquipo: " + e.getMessage());
		}
		return codigoMasAlto;
	}
	
	public void altaEquipo(int cod_equipo, String nombre, int cod_liga) {
		String sql = "INSERT INTO equipos values(" + cod_equipo + ",'" + nombre + "', "+ cod_liga +")";
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Equipo insertado en la tabla equipos");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en altaEquipo: " + e.getMessage());
		}
	}
	
	public void bajaEquipo(int cod_equipo) {
		String sql = "DELETE FROM equipos where cod_equipo='"+ cod_equipo +"'";
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Equipo eliminado de la tabla equipos");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaEquipo: " + e.getMessage());
		}
	}
	
	public void editarEquipo(int cod_equipo, String nombre, int cod_liga) {
	    String sql = "UPDATE equipos SET nombre = '" + nombre + "', cod_liga = " + cod_liga + " WHERE cod_equipo = " + cod_equipo;
	    
	    try {
	        Statement st = this.conexion.createStatement();
	        // System.out.println(sql);

	        st.executeUpdate(sql);
	        System.out.println("Equipo actualizado en la tabla equipos");

	        st.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        System.out.println("Error en editarEquipo: " + e.getMessage());
	    }
	}
	
	public int maxcodLiga() {
		int codigoMasAlto = 0;
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(cod_liga) FROM ligas");
			if (rs.next()) {
				codigoMasAlto = rs.getInt("MAX(cod_liga)");
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Error en maxcodLiga: " + e.getMessage());
		}
		return codigoMasAlto;
	}
	
	public void altaLiga(int cod_liga, String nombre, String pais) {
		String sql = "INSERT INTO ligas values(" + cod_liga + ",'" + nombre + "', '"+ pais +"')";
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Liga insertada en la tabla ligas");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en altaEquipo: " + e.getMessage());
		}
	}
	
	public void bajaLiga(int cod_liga) {
		String sql = "DELETE FROM ligas where cod_liga="+ cod_liga;
		try {
			Statement st = this.conexion.createStatement();
			// System.out.println(sql);

			st.execute(sql);
			System.out.println("Liga eliminada de la tabla ligas");

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaLiga: " + e.getMessage());
		}
	}
	
	public void editarLiga(int cod_liga, String nombre, String pais) {
	    String sql = "UPDATE ligas SET nombre = '" + nombre + "', pais = '" + pais + "' WHERE cod_liga = " + cod_liga;
	    
	    try {
	        Statement st = this.conexion.createStatement();
	        // System.out.println(sql);

	        st.executeUpdate(sql);
	        System.out.println("Liga actualizada en la tabla ligas");

	        st.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        System.out.println("Error en editarLiga: " + e.getMessage());
	    }
	}
	
	public void editarJugador(int cod_jugador, String nombre, int cod_equipo, String pierna, int altura, String pais) {
	    String sql = "UPDATE jugadores SET nombre = '" + nombre + "', cod_equipo = " + cod_equipo + ", pierna = '" + pierna + 
	                 "', altura = " + altura + ", pais = '" + pais + "' WHERE cod_jugador = " + cod_jugador;
	    
	    try {
	        Statement st = this.conexion.createStatement();
	        // System.out.println(sql);

	        st.executeUpdate(sql);
	        System.out.println("Jugador actualizado en la tabla jugadores");

	        st.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        System.out.println("Error en editarJugador: " + e.getMessage());
	    }
	}

}