package com.novatronic.sca.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que contienes los atributos del menú de la interfaz principal del sistema
 */
public enum Menu {

	MENU_EMPRESA(1),
	MENU_APLICACION(2),
	MENU_ROL(3),
	MENU_PERMISO(4),
	MENU_USUARIO(5),
	MENU_POLITICA(6),
	MENU_BLOQUEO(7),
	MENU_DESBLOQUEO(8),
	MENU_TEMPLATE(9),
	MENU_AUDITORIA(10),
	MENU_HORARIO(11);	
	
	private static final List<Menu> list = new ArrayList<Menu>();
	private static final Map<Integer, Menu> lookup = new HashMap<Integer, Menu>();
	
	static{
		for (Menu s : EnumSet.allOf(Menu.class)) {
			list.add(s);
			lookup.put(s.getCodigo(), s);
		}
	}
	
	private Integer codigo;

	
	private Menu(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
