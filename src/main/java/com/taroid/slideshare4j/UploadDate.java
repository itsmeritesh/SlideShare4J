package com.taroid.slideshare4j;

/**
 * Created with IntelliJ IDEA.
 * User: ritesh
 * Date: 10/8/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public enum UploadDate {

    ANY, WEEK, MONTH, YEAR;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
