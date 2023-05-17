package clasesFifa;

import java.util.ArrayList;

public class Utils {
	public static String bgColor(int puntos){
		if (puntos<=49) {
			return "#F44336";
		}else if (puntos>=50 && puntos <=59) {
			return "#FB8C00";
		}else if (puntos>=60 && puntos <=69) {
			return "#E9BC0B";
		}else if (puntos>=70 && puntos <=89) {
			return "#4CAF50";
		}else{
			return "#008000";
		}
		
	}
	public static String textColor(int puntos){
		if (puntos>=60 && puntos <=69) {
			return "#000000";
		}else{
			return "#FFFFFF";
		}
		
	}
	public static Carta cartaSeleccionada(ArrayList<Carta>cartasJug, String tipo) {
		Carta result=new Carta();
		for (Carta carta : cartasJug) {
			if (carta.getNombre().equalsIgnoreCase(tipo)) {
				result=carta;
			}
		}
		return result;
	}
	public static String textCard(String nombre){
		if (nombre.equalsIgnoreCase("SIMPLE")) {
			return "#000000";
		}else {
			return "#FFFFFF";
		}
		
	}
	public static String equipoPorDefecto(int codEqActual, int codEquipoJug ) {
		String result="";
		if(codEqActual==codEquipoJug) {
			result="selected";
		}
		return result;
	}

}
