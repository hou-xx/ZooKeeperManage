package com.hxx.commandline.folder;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:54 </li>
 * </ul>
 */
public class FolderManager {
    public final static List<String> FOLDERS = new ArrayList<>();

    public static String concatFolders() {
        if (CollectionUtils.isEmpty(FOLDERS)) {
            return "";
        }
        StringBuilder ss = new StringBuilder();
        for (String folder : FOLDERS) {
            if (!folder.startsWith("/")) {
                ss.append("/");
            }
            ss.append(folder);
        }
        return ss.toString();
    }

}
