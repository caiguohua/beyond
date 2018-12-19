package designpattern;

abstract class CPU {}
class EmberCPU extends CPU {}
class EnginolaCPU extends CPU {}

abstract class MMU{}
class EmberMMU extends MMU{}
class EnginolaMMU extends MMU{}

enum Architecture{
    ENGINOLA,EMBER
}

class EmberFactory extends AbstractFactory{
   @Override
    public CPU createCPU(){
       return new EmberCPU();
   }
   @Override
   public MMU createMMU(){
       return new EmberMMU();
   }
}

class EnginolaFactory extends AbstractFactory{
    @Override
    public CPU createCPU(){
        return new EnginolaCPU();
    }
    @Override
    public MMU createMMU(){
        return new EnginolaMMU();
    }
}



abstract class AbstractFactory{
    private static final AbstractFactory EMBER_FACTORY = new EmberFactory();
    private static final AbstractFactory ENGINOLA_FACTORY = new EnginolaFactory();
    static  AbstractFactory getFactory(Architecture architecture){
        AbstractFactory factory = null;
        switch (architecture){
            case EMBER:
                factory = EMBER_FACTORY;
                break;
            case ENGINOLA:
                factory = ENGINOLA_FACTORY;
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();
    public abstract MMU createMMU();
}

public class BasicAbstractFactory{
    public static void main(String[] args) {
        AbstractFactory enginolaFactory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        CPU cpu = enginolaFactory.createCPU();
        System.out.println(cpu);
    }
}
