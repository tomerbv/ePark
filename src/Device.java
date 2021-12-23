public class Device {
    int deviceCode;
    double price;
    String name;
    boolean isOpen;
    boolean isExtreme;
    int manufactorerCode;
    double weightLimit;
    double heightLimit;
    int ageLimit;

    public void setDeviceCode(int deviceCode) {
        this.deviceCode = deviceCode;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setExtreme(boolean extreme) {
        isExtreme = extreme;
    }

    public void setManufactorerCode(int manufactorerCode) {
        this.manufactorerCode = manufactorerCode;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public void setHeightLimit(double heightLimit) {
        this.heightLimit = heightLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getDeviceCode() {
        return deviceCode;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isExtreme() {
        return isExtreme;
    }

    public int getManufactorerCode() {
        return manufactorerCode;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public double getHeightLimit() {
        return heightLimit;
    }

    public int getAgeLimit() {
        return ageLimit;
    }
}
