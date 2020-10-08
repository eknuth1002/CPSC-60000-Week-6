package com.elliotknuth;

import java.net.MalformedURLException;
import java.rmi.*;

public class KilnRunner {
	public static void main(String[] args) {
		new KilnRunner().go();
	}
	
	public void go() {
		try {
			KilnRemote service = (KilnRemote) Naming.lookup("rmi://localhost:300/KilnServer");
			
			if (!service.isFiring()) {
				service.setCone(3);
				service.setFiringSpeed(FiringSpeed.FAST);
				service.startKiln();
			}
			
			System.out.println("The current temp  is: " + service.getCurrentTemp());
			if (service.isFiring()) {
				service.stopKiln();
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
