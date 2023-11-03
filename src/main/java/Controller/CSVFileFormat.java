/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CSVFile;
import Repository.FormatRepository;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class CSVFileFormat extends Menu<String>{
    static String[] mc = {"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"};
    FormatRepository program;
    ArrayList<CSVFile> ls;

    public CSVFileFormat() {
        super("\nFormat CSV Program", mc);
        program = new FormatRepository();
        ls = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                program.importFile(ls);
                program.print(ls);
                break;
            case 2:
                program.formatAddress(ls);
                program.print(ls);
                break;
            case 3:
                program.formatName(ls);
                program.print(ls);
                break;
            case 4:
                program.exportFile(ls);
                break;
            case 5:
                System.exit(0);
        }
    }
}
