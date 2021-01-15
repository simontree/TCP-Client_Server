package sensordata;

import java.io.IOException;
import java.io.OutputStream;

public interface SensorDataSender {
    /**
     * send sensor data via output stream
     * @param data
     * @param os stream to recipient
     */
    void sendSensorData(SensorData data, OutputStream os) throws IOException;
}
