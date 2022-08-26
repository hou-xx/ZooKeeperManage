package com.hxx.commandline;

import com.hxx.commandline.constant.ZkCommandLineConsts;
import com.hxx.commandline.strategy.AbstractStrategy;
import com.hxx.commandline.strategy.StrategyManager;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * <ul>
 * <li>功能说明：zk命令行管理程序入口</li>
 * <li>作者：Tal on 2022\7\20 0020 22:27 </li>
 * </ul>
 */
public class CommandLineApplication {


    public static void main(String[] args) {
        System.out.println("Please enter command.");
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
            AbstractStrategy strategy = StrategyManager.getByCommand(command[0]);
            if (null == strategy) {
                System.out.println("Unsupported command.");
                continue;
            }
            strategy.handle(zkClient, command);
        }


    }
}
