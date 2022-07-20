package com.hxx.commandline;

import com.hxx.commandline.constant.ZkCommandLineConsts;
import com.hxx.commandline.strategy.impl.CdStrategy;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <ul>
 * <li>功能说明：zk命令行管理程序入口</li>
 * <li>作者：Tal on 2022\7\20 0020 22:27 </li>
 * </ul>
 */
public class CommandLineApplication {

    private static List<String> folders = new ArrayList<>();

    public static void main(String[] args) {

        ZkClient zkClient = new ZkClient("");

        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().trim();
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase(ZkCommandLineConsts.EXIT_COMMAND, line)) {
                flag = false;
                continue;
            }
            String[] command = line.split(ZkCommandLineConsts.COMMAND_SEPARATOR);
            if (StringUtils.equalsIgnoreCase("cd", command[0])) {
                CdStrategy.ISNTANCE.handle(zkClient, command);
            }


        }


    }
}
