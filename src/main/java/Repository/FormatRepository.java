/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.CSVFileDAO;
import Model.CSVFile;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class FormatRepository implements IFormatRepository{
    
    @Override
    public void importFile(ArrayList<CSVFile> list) {
        CSVFileDAO.Instance().importFile(list);
    }

    @Override
    public void formatAddress(ArrayList<CSVFile> list) {
        CSVFileDAO.Instance().formatAddress(list);
    }

    @Override
    public void formatName(ArrayList<CSVFile> list) {
        CSVFileDAO.Instance().formatName(list);
    }

    @Override
    public void exportFile(ArrayList<CSVFile> list) {
        CSVFileDAO.Instance().exportFile(list);
    }

    @Override
    public void print(ArrayList<CSVFile> list) {
        CSVFileDAO.Instance().print(list);
    } 
}
