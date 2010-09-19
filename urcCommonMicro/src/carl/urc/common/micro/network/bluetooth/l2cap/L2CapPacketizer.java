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
 
package carl.urc.common.micro.network.bluetooth.l2cap;

import java.io.IOException;
import java.io.OutputStream;

import javax.bluetooth.L2CAPConnection;

public class L2CapPacketizer extends OutputStream {

	private L2CAPConnection connection;
	private byte[] buffer;
	private int position;

	public L2CapPacketizer(L2CAPConnection connection)
			throws IOException {
		this.connection = connection;
		this.buffer = new byte[connection.getTransmitMTU()];
	}

	public void write(int b) throws IOException {
		buffer[position++] = (byte) b;
		if (position == buffer.length) {
			position = 0;
			connection.send(buffer);
		}
	}

	public void flush() throws IOException {
		byte[] b = new byte[position];
		System.arraycopy(buffer, 0, b, 0, position);
		position = 0;
		connection.send(b);
		super.flush();
	}

}
