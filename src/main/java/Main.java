/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.Manager;
import view.Menu;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        String title = "========= Zipper program =========";
        String[] s = new String[]{"Compression", "Extraction","Exit"};
        Menu<String> menu = new Manager(title, s);
        menu.run();
    }
}
