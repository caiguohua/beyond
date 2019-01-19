package designpattern;

import java.io.IOException;

/**
 * ����ģʽ
 */

interface CommandExecutor{
    void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor{

    @Override
    public void runCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd); //ִ������
        System.out.println("'" + cmd + "' command executed");
    }
}

class CommandExecutorProxy implements CommandExecutor{

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user,String pwd) {
        if("dharma".equals(user) && "2018".equals(pwd)){
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception{
        if(!isAdmin && cmd.trim().startsWith("rm")){  //trim()��������ȥ���ַ������˵Ķ���Ŀո�
            throw new Exception("rm command is not allowed for non-admin");
        }else{
            executor.runCommand(cmd);
        }
    }
}

public class SimpleProxy {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("dharma","2018");

        try{
            executor.runCommand("ls -l");
            executor.runCommand("rm -rf test.pdf");
        }catch (Exception e){
            System.out.println("Exception Message" + e.getMessage());
        }

    }
}
