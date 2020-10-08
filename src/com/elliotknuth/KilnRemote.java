package com.elliotknuth;

import java.rmi.*;

public interface KilnRemote extends Remote {
	
	public boolean startKiln() throws RemoteException;
	public boolean stopKiln() throws RemoteException;
	public boolean setCone(int cone) throws RemoteException;
	public int getCone() throws RemoteException;
	public boolean setFiringSpeed(FiringSpeed speed) throws RemoteException;
	public FiringSpeed getFiringSpeed() throws RemoteException;
	public double getCurrentTemp() throws RemoteException;
	public boolean isFiring() throws RemoteException;

}
