package com.hxx.commandline.folder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:54 </li>
 * </ul>
 */
public class FolderManager {
    private final static Stack<String> FOLDERS = new Stack<>();

    public static String concatFolders(String... paths) {
        StringBuilder ss = new StringBuilder();
        if (!CollectionUtils.isEmpty(FOLDERS)) {
            for (String folder : FOLDERS) {
                if (!folder.startsWith("/")) {
                    ss.append("/");
                }
                ss.append(folder);
            }
        }
        if (paths.length == 0) {
            return ss.toString();
        }
        for (String path : paths) {
            if (!path.startsWith("/")) {
                ss.append("/");
            }
            ss.append(path);
        }
        return ss.toString();
    }

    public static String push(String folder) {
        if (StringUtils.isBlank(folder)) {
            return concatFolders();
        }
        FOLDERS.push(folder);
        return concatFolders();
    }

    public static String pop() {
        if (FOLDERS.size() > 0) {
            FOLDERS.pop();
        }
        return concatFolders();
    }


}
