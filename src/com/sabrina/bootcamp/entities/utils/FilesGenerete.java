package com.sabrina.bootcamp.entities.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class FilesGenerete {
    protected final String actualDir = System.getProperty("user.dir");
    protected String fileName;
    protected String newDirectory ;

    public FilesGenerete(String fileName, String newDirectory) {
        this.fileName = fileName;
        this.newDirectory = newDirectory;
    }

    public void createDirectory() throws IOException {
        File path = new File(actualDir + newDirectory);
        if (!path.exists() && !path.mkdirs()) throw new IOException();

        createFile();
    }
    public void createFile(){
        try (OutputStream outputStream = new FileOutputStream(actualDir + newDirectory + fileName)){
            System.out.printf("File created with sucess (%s)", actualDir + newDirectory + fileName);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
