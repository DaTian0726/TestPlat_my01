package com.juhe.my01.utils;


import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * ClassName: ShellUtil
 * Description: 操作Linux系统Shell脚本
 * date: 2020/11/19 16:45
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class ShellUtil {

    public static Session initSession(ShellModel shellModel){

        Session session = null;
        JSch jsch = new JSch();
        try {
            if (shellModel.getPort() == 0)
                session = jsch.getSession(shellModel.getUsername(), shellModel.getIp(), 22);
            else
                session = jsch.getSession(shellModel.getUsername(), shellModel.getIp(), shellModel.getPort());
            session.setPassword(shellModel.getPassword());

            //关闭主机秘钥检查，否则会导致直接连接失败
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            System.out.println("连接服务器" + session.getHost());//____________________//

            session.connect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return session;
    }

    public static int execute(ShellModel shellModel ,String command){
        int returnCode = 0;
        ChannelExec channelExec = null;
        BufferedReader input = null;

        //创建Session并且打开连接，创建session之后要主动打开连接
        try {
            Session session = initSession(shellModel);
            //打开通道和设置通道类型、执行响应的内容
            channelExec = (ChannelExec)session.openChannel("exec");
            channelExec.setCommand(command);

            channelExec.setInputStream(null);
            input = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
            channelExec.connect();
            System.out.println("command is -----  " + command);

            //接受远程服务器执行结果
            String line = null;
            System.out.println("开始打印 ------ ---- --- --- --- -- - - -");
            while ((line = input.readLine()) != null){
                shellModel.getStdout().add(line);
                System.out.println(line);
            }
            if (channelExec.isClosed()){
                returnCode = channelExec.getExitStatus();
            }
            session.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            channelExec.disconnect();

        }
        return  returnCode;

    }


    @Test
    public void test(){
        ShellModel shell = new ShellModel();
        shell.setIp("192.168.67.130");
        shell.setUsername("root");
        shell.setPassword("123456");
//        shell.setPort(22);
        System.out.println(shell.getPort());
        System.out.println(ShellUtil.execute(shell,"cd /opt/app/test_case"));
//        System.out.println(ShellUtil.execute(shell,"pwd"));
    }






}
