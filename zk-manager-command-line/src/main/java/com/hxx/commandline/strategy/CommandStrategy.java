package com.hxx.commandline.strategy;

import org.I0Itec.zkclient.ZkClient;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:43 </li>
 * </ul>
 */
public interface CommandStrategy {

    /**
     * 处理命令
     *
     * @param zkClient
     * @param command
     */
    public void handle(ZkClient zkClient, String... params);

}
