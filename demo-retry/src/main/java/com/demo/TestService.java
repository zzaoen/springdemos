package com.demo;

import org.springframework.stereotype.Service;

/**
 * Author: zzhao3@stubhub.com
 * Date: 2019-07-05 09:36
 * Desc:
 */

@Service
public class TestService {
    public void runShell(String cmd) {
        try{
            Thread.sleep(1);
            while(true)
                System.out.println("Running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1);
            while (true) {
                long x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                x = 239234839 * 23849349 * 2349234;
                System.out.println("Running");
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
//        StringBuffer buf = new StringBuffer();
//        String rt = "-1";
//        Process conn = null;
//        try {
//            Thread.sleep(1);
//            conn = Runtime.getRuntime().exec(cmd);
//            conn.waitFor();
//            InputStreamReader ir = new InputStreamReader(conn.getInputStream());
//            LineNumberReader input = new LineNumberReader(ir);
//            String ln = "";
//            while ((ln = input.readLine()) != null) {
//                buf.append(ln + "\n");
//            }
//            rt = buf.toString();
//            input.close();
//            ir.close();
//        } catch (java.io.IOException e) {
//            rt = e.toString();
//        } catch (InterruptedException e){
//            conn.destroy();
//            throw e;
//        } catch (Exception e) {
//            rt = e.toString();
//        }
    }
}
