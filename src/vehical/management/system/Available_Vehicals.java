
package vehical.management.system;

class Available_Vehicals {
    private String vehical_No;
    private String driver_name;
    private int meter_reading;
private String driverID;
    /**
     * @return the vehical_No
     */
    public String getVehical_No() {
        return vehical_No;
    }

    /**
     * @param vehical_No the vehical_No to set
     */
    public void setVehical_No(String vehical_No) {
        this.vehical_No = vehical_No;
    }

    /**
     * @return the driver_name
     */
    public String getDriver_name() {
        return driver_name;
    }

    /**
     * @param driver_name the driver_name to set
     */
    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    /**
     * @return the meter_reading
     */
    public int getMeter_reading() {
        return meter_reading;
    }

    /**
     * @param meter_reading the meter_reading to set
     */
    public void setMeter_reading(int meter_reading) {
        this.meter_reading = meter_reading;
    }

    /**
     * @return the driverID
     */
    public String getDriverID() {
        return driverID;
    }

    /**
     * @param driverID the driverID to set
     */
    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }
}
