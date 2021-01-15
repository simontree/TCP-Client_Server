package sensordata;

import java.io.IOException;
import java.io.InputStream;

public interface SensorDataReceiver {
    /**
     * Receive data from stream and create new sensor data object
     * @param is
     * @return
     */
    SensorData receiveSensorData(InputStream is) throws IOException;
}
