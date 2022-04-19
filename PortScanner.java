import java.net.*;

/**
 * PortScanner.java
 * @author William.T
 * @version 1.2.0
 * - no copyright
 * A basic inplementation of a port scanner. Inspiration from nmap.
 */

public class PortScanner{

    private static int TIMEOUT = 200;
    private int lowerPort = 0;
    private int highPort = 0;
    private boolean includeClosedPortsOnOutput = false;
    private String ipAddress = "";

    /**
     * Constructor for PortScanner. Acepts a single port
     * @param ipAddress
     * @param portNum
    */

    public PortScanner(String ipAddress, int portNum) {

        this.highPort = portNum;
        this.lowerPort = portNum;
        this.ipAddress = ipAddress;

    }

    /**
     * Constructor for PortScanner. Accepts a port range
     * @param ipAddress
     * @param portRangeLow
     * @param portRangeHigh
    */

    public PortScanner(String ipAddress, int portRangeLow, int portRangeHigh) {

        this.highPort = portRangeHigh;
        this.lowerPort = portRangeLow;
        this.ipAddress = ipAddress;

    }

    /**
     * Constructor for PortScanner. Accepts a port range a boolean for closed ports on output.
     * @param ipAddress
     * @param portRangeLow
     * @param portRangeHigh
     * @param includeClosePorts
    */

    public PortScanner(String ipAddress, int portRangeLow, int portRangeHigh, boolean includeClosedPorts) {

        this.highPort = portRangeHigh;
        this.lowerPort = portRangeLow;
        this.ipAddress = ipAddress;
        this.includeClosedPortsOnOutput = includeClosedPorts;

    }

    /**
     * Starts the port scanner. Increments through port range sending a tcp request and checking for open ports
    */

    public void startScan() {

        for (int i = lowerPort; i <= highPort; i++) {

            boolean portState = isPortOpen(ipAddress, i);

            if (portState) {
                
                System.out.println("Port: " + i + " is open!");

            } else if (!portState && includeClosedPortsOnOutput) {

                System.out.println("Port: " + i + " is closed!");

            }

        }

    }

    /**
     * Creates a socket and attempts a connection to the speicified IP address and port
     * @param ipAddress
     * @param portNum
     * @return boolean, if true then the port is open, if false the port is not open
    */

    public boolean isPortOpen(String ipAddress, int portNum) {

        try {

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, portNum), TIMEOUT);
            socket.close();

        }  catch (Exception ex) {

            return false;

        }

        return true;

    }

    /**
     * Return the current Lower Port range
     * @return lowerPort
    */

    public int getLowerPort() {

        return this.lowerPort;

    }

    /**
     * Return the current Higher Port range
     * @return highport
    */

    public int getHigherPort() {

        return this.highPort;

    }

    /**
     * Return the current IPAddress
     * @return ipAddress
    */

    public String getipAddress() {

        return this.ipAddress;

    }

    /**
     * return the current boolean of include closed ports
     * @return includeClosedPortsOnOutput
    */

    public boolean getIncludeClosedPorts() {

        return this.includeClosedPortsOnOutput;

    }

    /**
     * Set the lower port range
     * @param lowPortRange
    */

    public void setLowerPort(int lowPortRange) {

        this.lowerPort = lowPortRange;

    }

    /**
     * Set the higher port range
     * @param highPortRange
    */

    public void setHigherPort(int highPortRange) {

        this.highPort = highPortRange;

    }

    /**
     * Set the ipAddress
     * @param newipAddress
    */

    public void setipAddress(String newipAddress) {

        this.ipAddress = newipAddress;

    }

    /**
     * Set include closed ports on Ouput
     * @param includeClosedPorts
    */

    public void setIncludeClosedPorts(boolean includeClosedPorts) {

        this.includeClosedPortsOnOutput = includeClosedPorts;

    }

}

