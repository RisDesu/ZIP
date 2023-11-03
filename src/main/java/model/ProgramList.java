/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author HP
 */
public class ProgramList {

    public void zipFile() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Source Folder: ");
        String pathSrc = Validation.checkString();
        System.out.print("Enter Destination Folder: ");
        String pathCompress = Validation.checkString();
        System.out.print("Enter Name: ");
        String fileZipName = in.nextLine();

        boolean check = compressTo(pathSrc, fileZipName, pathCompress);
        if (check) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean compressTo(String pathSrc, String fileZipName, String pathCompress) {
        try {
            String sourceFile = pathSrc;
            String nameFos = pathCompress + "/" + fileZipName + ".zip";
            FileOutputStream fos = new FileOutputStream(nameFos);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unzipFile() {
        System.out.print("Enter Source file: ");
        String pathZipFile = Validation.checkString();
        System.out.print("Enter Destination Folder: ");
        String pathExtract = Validation.checkString();

        boolean check = extractTo(pathZipFile, pathExtract);
        if (check) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean extractTo(String pathZipFile, String pathExtract) {
        try {
            String fileZip = pathZipFile;
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                File newFile = new File(pathExtract + fileName);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
