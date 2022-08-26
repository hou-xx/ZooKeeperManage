package com.hxx.commandline.strategy;

import com.hxx.commandline.strategy.impl.CdStrategy;
import com.hxx.commandline.strategy.impl.HelpStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>功能说明：命令管理</li>
 * <li>作者：Tal on 2022\8\26 0026 22:12 </li>
 * </ul>
 */
public class StrategyManager {

    private static final Map<String, AbstractStrategy> strategyMap = new HashMap<>(12);

    static {
        strategyMap.put(CdStrategy.getInstance().getCommand(), CdStrategy.getInstance());
        strategyMap.put(HelpStrategy.getInstance().getCommand(), HelpStrategy.getInstance());
    }


    public static AbstractStrategy getByCommand(String command) {
        if (!strategyMap.containsKey(command)) {
            return null;
        }
        return strategyMap.get(command);
    }

    public static void printStrategy() {
        for (AbstractStrategy value : strategyMap.values()) {
            System.out.println(value.getCommand() + "\t" + value.getDescription());
        }
    }


}
