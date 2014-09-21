/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author yaokun.mok.2013
 */
public class Unzip {

    public static void unzip(String fileName) {
        String source = "d:/data/";
        String destination = "d:/unzip/";
        
        source += fileName;

        try {
            ZipFile zipFile = new ZipFile(source);

            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

}
