package projetReseau.appliReseau;

import java.io.IOException;
import java.util.Vector;

import javax.bluetooth.*;

public class bluetoothDeviceDiscovery {

	public static void getDevice() {

		private static Object lock = new Object();

		try {
			// 1
			LocalDevice localDevice = LocalDevice.getLocalDevice();

			// 2
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();

			// 3
			agent.startInquiry(DiscoveryAgent.GIAC, new MyDiscoveryListener());

			try {
				synchronized (lock) {
					lock.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Device Inquiry Completed. ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}