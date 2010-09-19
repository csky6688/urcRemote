/*
 *    This file is part of urcRemote. urcRemote turns your mobile phone into
 *    a touch-pad and keyboard for your computer.
 *
 *    Copyright  2010 Carl Lobo <carllobo@gmail.com>
 *
 *    urcRemote is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    urcRemote is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with urcRemote.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package carl.urc.common.network.bluetooth;


public class BluetoothCommon {

	public static final String uuid = "501ae0a7065f4d97b9a3eabe5f6ef825";

	public static String getAdditionalConnectionInfo(boolean forServer) {
		String s = ";encrypt=" + BluetoothCommonPreferences.preferenceEncrypt;
		if (forServer)
			s = s + ";name=UltimateRemoteControl;master=false;authenticate="
					+ BluetoothCommonPreferences.preferenceAuthenticate;
		return s;
	}
}
