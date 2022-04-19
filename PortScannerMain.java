public class PortScannerMain {
    
    public static void main(String[] args) {
        
        PortScanner scan = new PortScanner("127.0.0.1", 400,450, true);

        scan.startScan();

    }

}