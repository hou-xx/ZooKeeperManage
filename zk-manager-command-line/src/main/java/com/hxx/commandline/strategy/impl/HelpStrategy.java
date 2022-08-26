package com.hxx.commandline.strategy.impl;

import com.hxx.commandline.strategy.AbstractStrategy;
import com.hxx.commandline.strategy.CommandStrategy;
import com.hxx.commandline.strategy.StrategyManager;

import org.I0Itec.zkclient.ZkClient;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:41 </li>
 * </ul>
 */
public class HelpStrategy extends AbstractStrategy implements CommandStrategy {
    private static HelpStrategy strategy = null;

    private HelpStrategy() {
        this.setCommand("help");
        this.setDescription("帮助");
    }

    public static HelpStrategy getInstance() {
        if (null == strategy) {
            return new HelpStrategy();
        }
        return strategy;
    }

    @Override
    public void handle(ZkClient zkClient, String[] command) {
        StrategyManager.printStrategy();
    }
}
