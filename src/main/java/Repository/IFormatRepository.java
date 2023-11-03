/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.CSVFile;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public interface IFormatRepository {
    void importFile(ArrayList<CSVFile> lits);

    void formatAddress(ArrayList<CSVFile> lits);

    void formatName(ArrayList<CSVFile> lits);

    void exportFile(ArrayList<CSVFile> lits);

    void print(ArrayList<CSVFile> lits);
}
