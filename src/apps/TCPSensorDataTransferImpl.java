package apps;

import sensordata.SensorData;
import sensordata.SensorDataReceiver;
import sensordata.SensorDataSender;
import sensordata.SensorDataTransferMachine;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPMachine;

import java.io.IOException;

public class TCPSensorDataTransferImpl implements TCPSensorDataTransfer{
    @Override
    public void sendSensorData(SensorData data, String hostName, int portNumber) throws IOException {
        Client client = new TCPMachine();
        Connection connection = client.connect(hostName,portNumber);

        SensorDataSender sensorDataSender = new SensorDataTransferMachine();
        sensorDataSender.sendSensorData(data, connection.getOutputStream());
    }

    @Override
    public void receiveSensorData(int portNumber) throws IOException {
        Server server = new TCPMachine();
        Connection connection = server.acceptConnection(portNumber);

        SensorDataReceiver sensorDataReceiver = new SensorDataTransferMachine();
        sensorDataReceiver.receiveSensorData(connection.getInputStream());
    }
}
