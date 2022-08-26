package com.hxx.commandline.strategy.impl;

import com.hxx.commandline.constant.ZkCommandLineConsts;
import com.hxx.commandline.folder.FolderManager;
import com.hxx.commandline.strategy.AbstractStrategy;
import com.hxx.commandline.strategy.CommandStrategy;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:41 </li>
 * </ul>
 */
public class CdStrategy extends AbstractStrategy implements CommandStrategy {
    private static CdStrategy cdStrategy = null;

    private CdStrategy() {
        this.setCommand("cd");
        this.setDescription("进入下一级目录或上一级目录");
    }

    public static CdStrategy getInstance() {
        if (null == cdStrategy) {
            return new CdStrategy();
        }
        return cdStrategy;
    }

    @Override
    public void handle(ZkClient zkClient, String[] command) {
        if (command.length != 2 || StringUtils.isBlank(command[1])) {
            System.out.println("The parameter is wrong, please confirm.");
            return;
        }
        if (ZkCommandLineConsts.CD_BACK.equals(command[1])) {
            System.out.println(FolderManager.pop());
            return;
        }
        if (!zkClient.exists(FolderManager.concatFolders(command[1]))) {
            System.out.println("The path is not exists, please confirm!");
        }
        String path = FolderManager.push(command[1]);
        System.out.println(path);
    }
}
