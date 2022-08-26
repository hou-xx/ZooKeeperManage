package com.hxx.commandline.strategy;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\8\26 0026 22:15 </li>
 * </ul>
 */
public abstract class AbstractStrategy implements CommandStrategy {

    /**
     * 命令
     */
    private String command;

    /**
     * 描述
     */
    private String description;

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
