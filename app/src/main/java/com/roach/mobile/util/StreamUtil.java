package com.roach.mobile.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StreamUtil {
    private static final Logger log = Logger.getLogger(String.valueOf(StreamUtil.class));

    public static void safelyCloseStream(OutputStream ops) {

        try {
            if (ops != null) {
                ops.close();
            }
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "ERROR Closing OutputStream: " + e.getMessage(),e);
        }
    }

    public static void safelyCloseStream(InputStream ips) {
        try {

            if (ips != null) {
                ips.close();
            }
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "ERROR Closing InputStream: " + e.getMessage(),e);
        }
    }

    public static void safelyCloseStream(Reader ips) {
        try {

            if (ips != null) {
                ips.close();
            }
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "ERROR Closing Reader: " + e.getMessage(), e);
        }
    }

    public static void safelyCloseStream(Writer writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "ERROR Closing Writer: " + e.getMessage(), e);
        }
    }

    public static void safelyCloseStream(HttpURLConnection con) {

        try {
            if (con != null) {
                con.disconnect();
            }
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "ERROR Closing HttpURLConnection: " + e.getMessage(), e);
        }
    }

    public static void safelyCloseStream(BufferedReader con) {

        try {
            if (con != null) {
                con.close();
            }
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "ERROR Closing BufferedReader: " + e.getMessage(), e);
        }
    }

}
