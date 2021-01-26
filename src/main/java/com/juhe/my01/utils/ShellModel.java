package com.juhe.my01.utils;

import java.util.ArrayList;

/**
 * ClassName: ShellModel
 * Description:
 * date: 2020/11/20 14:02
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class ShellModel {

    private String ip;
    private String username;
    private String password;
    private int port;
    private static  int DEFAULT_SSH_PORT = 22;
    private ArrayList stdout;

    public ArrayList getStdout() {
        return stdout;
    }

    public static int getDefaultSshPort() {
        return DEFAULT_SSH_PORT;
    }

    public ShellModel(String ip, String username, String password, int port) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ShellModel() {
        stdout = new ArrayList();
    }
}
