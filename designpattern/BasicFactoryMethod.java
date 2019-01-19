package designpattern;

enum CType{
    PC,SERVER
}

abstract class Computer{
    public abstract String getCPU();
    public abstract String getGPU();
    public abstract String getRAM();
    public abstract String getSSD();

    @Override

    public String toString() {
        return "RAM="+this.getRAM()
                +" CPU="+this.getCPU()
                +" GPU="+this.getGPU()
                +" SSD="+this.getSSD();
    }

}

class PC extends Computer{
    private String cpu;
    private String gpu;
    private String ram;
    private String ssd;

    public PC(String cpu, String gpu, String ram, String ssd) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.ssd = ssd;
    }

    public String getCPU() {
        return this.cpu;
    }

    public String getGPU() {
        return this.gpu;
    }

    public String getRAM() {
        return this.ram;
    }

    public String getSSD() {
        return this.ssd;
    }
}

class Server extends Computer{
    private String cpu;
    private String gpu;
    private String ram;
    private String ssd;

    public Server(String cpu, String gpu, String ram, String ssd) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.ssd = ssd;
    }

    public String getCPU() {
        return cpu;
    }

    public String getGPU() {
        return gpu;
    }

    public String getRAM() {
        return ram;
    }

    public String getSSD() {
        return ssd;
    }
}

class ComputerFactory{
    public static Computer produceComputer(CType type,String cpu,String gpu,String ram,String ssd) {
        Computer computer = null;

        if(CType.PC == type){
            computer = new PC(cpu,gpu,ram,ssd);
        }else if(CType.SERVER == type){
            computer = new Server(cpu,gpu,ram,ssd);
        }
        return computer;
    }
}

public class BasicFactoryMethod {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.produceComputer(CType.PC, "Intel i9", "geForce 9000", "32G", "512G");
        System.out.println(pc);
        Computer server = ComputerFactory.produceComputer(CType.SERVER, "xeon 100", "geForce 10000", "1T", "100T");
        System.out.println(server);

    }
}
