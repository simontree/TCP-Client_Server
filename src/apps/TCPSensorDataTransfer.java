package apps;

import sensordata.SensorData;

import java.io.IOException;

public interface TCPSensorDataTransfer {
    /**
     * send sensor data to host
     * @param data
     * @param hostName
     * @param portNumber
     */
    void sendSensorData(SensorData data, String hostName, int portNumber) throws IOException;

    /**
     * receive sensor data via portNumber
     * @param portNumber
     */
    void receiveSensorData(int portNumber) throws IOException;
}
