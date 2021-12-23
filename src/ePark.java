import java.util.List;

public class ePark {
    String name;
    List<Device> deviceList;

    public ePark(String name) {
        this.name = name;
    }


    public Boolean addDevice(int deviceCode, double price, String name, boolean isOpen, boolean isExtreme, int manufactorerCode, double weightLimit, double heightLimit, int ageLimit){
        /**
         * create and add device to deviceList
         * return:
         * Boolean
         * If a error is thrown return false
         * else return true
         */
        try{
            Device deviceToAdd = this.CreateDevice(deviceCode,price,name, isOpen, isExtreme,  manufactorerCode, weightLimit,heightLimit, ageLimit);
            if (deviceToAdd == null){return false;};
            deviceList.add(this.CreateDevice(deviceCode,price,name, isOpen, isExtreme,  manufactorerCode, weightLimit,heightLimit, ageLimit));
        }catch (Exception e){
            return false;
        }
        return true;
    }



    private Device CreateDevice(int deviceCode, double price, String name, boolean isOpen, boolean isExtreme, int manufactorerCode, double weightLimit, double heightLimit, int ageLimit){
        /**
         * Create Device and this park as device part(setPark(this))
         * return:
         * Device
         *
         */
        Device device;
        try{
            device = new Device(deviceCode,price,name, isOpen, isExtreme,  manufactorerCode, weightLimit,heightLimit, ageLimit);
            device.setPark(this);
        }catch(Exception e){
            return null;
        }
        return device;
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

    public List<Device> getDeviceList() {
        return deviceList;
    }

    /*    public void setDeviceList(List<Device> deviceList) {
            this.deviceList = deviceList;
        }*/
}
