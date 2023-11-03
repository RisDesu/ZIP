/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import model.ProgramList;
import view.Menu;
/**
 *
 * @author HP
 */
public class Manager extends Menu<String>{
    private ProgramList list= new ProgramList();
    public Manager(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n){
        switch (n) {
           
            case 1:
                list.zipFile();
                break;
            case 2: 
                list.unzipFile();
                break;
            case 3:
                System.exit(0);        
        }
    }
}
