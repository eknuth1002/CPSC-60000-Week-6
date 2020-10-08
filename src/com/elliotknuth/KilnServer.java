package com.elliotknuth;

import java.rmi.*;
import java.rmi.server.*;

public class KilnServer extends UnicastRemoteObject implements KilnRemote {

	private static final long serialVersionUID = 1L;
	
	private boolean isFiring = false;
	private FiringSpeed speed = FiringSpeed.SLOW;
	private int cone = 04;
	private double temp = 500; //pretend the temp changes based on observer
	
	public KilnServer() throws RemoteException {
		super();
	}

	@Override
	public boolean startKiln() throws RemoteException {
		if (isFiring == false) {
			System.out.println("We've started the kiln");
			isFiring = true;
			return true;
		}
		else {
			System.out.println("Cannot start the kiln, it is already firing.");
			return false;
		}
	}

	@Override
	public boolean stopKiln() throws RemoteException {
		if (isFiring == true) {
			System.out.println("We are stopping the kiln");
			isFiring = false;
			return true;
		}
		else {
			System.out.println("Cannot stop the kiln, it is not currently firing");
			return false;
		}
	}

	@Override
	public boolean setCone(int cone) throws RemoteException {
		if (isFiring == false) {
			if (cone <= 10 && cone >= -22) {
				System.out.println("Setting the cone to " + cone);
				this.cone = cone;
				return true;
			}
			else {
				System.out.println("Cone " + cone + " is not valid.  It must be between 022 and 10");
				return false;
			}
		}
		else {
			System.out.println("Cannot change the cone while the kiln is firing");
			return false;
		}
	}
	
	@Override
	public int getCone() throws RemoteException {
		return cone;
	}

	@Override
	public boolean setFiringSpeed(FiringSpeed speed) throws RemoteException {
		if (isFiring == false) {
			System.out.println("Setting firing speed to " + speed.toString());
			this.speed = speed;
			return true;
		}
		else {
			System.out.println("Cannot change firing speed while kiln is firing.");
			return false;
		}
	}
	
	@Override
	public FiringSpeed getFiringSpeed() throws RemoteException {
		return speed;
	}

	@Override
	public double getCurrentTemp() throws RemoteException {
		return temp;
	}

	@Override
	public boolean isFiring() throws RemoteException {
		return isFiring;
	}

}
