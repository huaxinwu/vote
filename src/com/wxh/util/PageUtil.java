/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;
/**
 * ��ҳ������:������ҳ����ȡÿҳ�ļ�¼������ȡ��ҳ������ȡ�ܼ�¼������ȡ��ʼ����λ�ã��Ƿ�����һҳ���Ƿ�����һҳ
 * @author wxh
 * @version $Id: PageUtil.java, v 0.1 2017��7��18�� ����9:55:34 wxh Exp $
 */
public class PageUtil {

    /**
     * ����ÿҳ��ʾ��������¼�����ܼ�¼������ǰҳ�룬��ȡ��ҳ��Ϣ
     * @param everyPage
     * @param totalCount
     * @param currentPage
     * @return Page
     */
    public static Page createPage(int everyPage,int totalCount,int currentPage){
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        int beginIndex = getBeginIndex(everyPage, currentPage);
        boolean hasPrePage = getPrePage(currentPage);
        boolean hasNextPage = getNextPage(totalPage, currentPage);
        return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
    }
    
    /** 
     * ��ȡÿҳ��ʾ��������¼
     * @param everyPage
     * @return
     */
    public static int getEveryPage(int everyPage){
        return everyPage == 0 ? 10 : everyPage;
    }
    /**
     * ��ȡ��ǰҳ��
     * @param currentPage
     * @return
     */
    public static int getCurrentPage(int currentPage){
        return currentPage == 0 ? 1 : currentPage;
    }
    
    /**
     * ��ȡ��ҳ��
     * @param everyPage
     * @param totalCount
     * @return
     */
    public static int getTotalPage(int everyPage,int totalCount){
        return totalCount % everyPage == 0 ? totalCount / everyPage : totalCount / everyPage +1;
    }
    /**
     * ��ȡ��ʼ����λ��
     * @param everyPage
     * @param currentPage
     * @return
     */
    public static int getBeginIndex(int everyPage,int currentPage){
        return (currentPage - 1) * everyPage;
    }
    
    /**
     * �Ƿ�����һҳ
     * @param currentPage
     * @return
     */
    public static boolean getPrePage(int currentPage){
        return currentPage == 1 ? false : true;
    }
    /**
     * �Ƿ�����һҳ
     * @param totalPage
     * @param currentPage
     * @return
     */
    public static boolean getNextPage(int totalPage,int currentPage){
        return currentPage == totalPage || totalPage == 0 ? false : true;
    }
}
