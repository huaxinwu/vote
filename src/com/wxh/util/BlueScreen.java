/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;

import java.io.IOException;

/**
 * ��������
 * @author wxh
 * @version $Id: BlueScreen.java, v 0.1 2017��9��8�� ����10:45:02 wxh Exp $
 */
public class BlueScreen {

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\shutdown.exe -s -f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
