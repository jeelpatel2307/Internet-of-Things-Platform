import java.util.HashMap;
import java.util.Map;

// Device representation
class Device {
    String id;
    String name;
    Map<String, Object> properties;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.properties = new HashMap<>();
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }
}

// IoT platform
class IoTPlatform {
    Map<String, Device> devices;

    public IoTPlatform() {
        devices = new HashMap<>();
    }

    public void registerDevice(String id, String name) {
        if (!devices.containsKey(id)) {
            devices.put(id, new Device(id, name));
            System.out.println("Device registered: " + name + " (ID: " + id + ")");
        } else {
            System.out.println("Device with ID " + id + " already registered.");
        }
    }

    public void updateDeviceProperty(String id, String key, Object value) {
        Device device = devices.get(id);
        if (device != null) {
            device.setProperty(key, value);
            System.out.println("Property updated for device " + device.name + " (ID: " + id + "): " + key + " = " + value);
        } else {
            System.out.println("Device with ID " + id + " not found.");
        }
    }

    public Object getDeviceProperty(String id, String key) {
        Device device = devices.get(id);
        if (device != null) {
            return device.getProperty(key);
        } else {
            System.out.println("Device with ID " + id + " not found.");
            return null;
        }
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        IoTPlatform platform = new IoTPlatform();

        // Register devices
        platform.registerDevice("dev001", "Temperature Sensor");
        platform.registerDevice("dev002", "Light Sensor");
        platform.registerDevice("dev002", "Light Sensor"); // Duplicate registration

        // Update device properties
        platform.updateDeviceProperty("dev001", "temperature", 25.5);
        platform.updateDeviceProperty("dev002", "brightness", 800);
        platform.updateDeviceProperty("dev003", "humidity", 60.0); // Non-existent device

        // Retrieve device properties
        System.out.println("Temperature: " + platform.getDeviceProperty("dev001", "temperature"));
        System.out.println("Brightness: " + platform.getDeviceProperty("dev002", "brightness"));
        System.out.println("Humidity: " + platform.getDeviceProperty("dev003", "humidity")); // Non-existent device
    }
	}
