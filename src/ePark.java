import java.util.ArrayList;

public class ePark {
    String name;
    ArrayList<Device> deviceList;

    public ePark(String name) {
        this.name = name;
        this.deviceList = new ArrayList<>();
    }

    public void addDevice(Device device) {
        this.deviceList.add(device);
    }

    public Device getDevice(int deviceCode){
        /**
         *get device by deviceCode
         * return:
         * If exists a device with this deviceCode in the park - return it
         * else return null
         *
         */
        for (Device device:this.getDeviceList())
        {
            if(device.getDeviceCode() == deviceCode)
            {
                return device;
            }

        }
        return null;
    }

    public Device getDeviceByManufactorerCode(int manufactorerCode){
        /**
         *get device by manufactorerCode
         * return:
         * If exists a device with this manufactorerCode in the park - return it
         * else return null
         */
        for (Device device:this.getDeviceList())
        {
            if(device.getManufactorerCode() == manufactorerCode)
            {
                return device;
            }
        }
        return null;
    }


    public Device getDevice(String name){
        /**
         *get device by name
         * return:
         * If exists a device with this namme in the park - return it
         * else return null
         */
        for (Device device:this.getDeviceList())
        {
            if(device.getName().equals(name))
            {
                return device;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Device> getDeviceList() {
        return deviceList;
    }

    @Override
    public String toString(){
        return "ePark - " + this.getName() ;
    }

}
