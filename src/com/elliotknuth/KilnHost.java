package com.elliotknuth;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class KilnHost {
	public static void main(String[] args) {
		try {
			KilnRemote service = new KilnServer();
			LocateRegistry.createRegistry(300);
			Naming.rebind("rmi://localhost:300/KilnServer", service);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
