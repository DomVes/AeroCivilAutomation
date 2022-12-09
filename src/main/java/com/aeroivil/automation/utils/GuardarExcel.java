package com.aeroivil.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarExcel {
    public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String ResultText) throws  IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell celda = row.createCell(cellNumber);

        celda.setCellValue(ResultText);

        System.out.println("URL guardada: "+celda.getStringCellValue());

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);

        outputStream.close();


    }



}