package com.mozcalti.gamingapp.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validaciones {


    public static String validaStringCellValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().length() >= Numeros.TRES.getNumero())
            return cell.getStringCellValue();
        else
            throw new IllegalArgumentException(String.format("El valor ubicado en la columna %s fila %s no es una cadena de texto", CellReference.convertNumToColString(cell.getColumnIndex()), cell.getRowIndex() + 1));
    }

    public static String validaVacio(Cell cell) {
        if (cell.getCellType() == CellType.STRING || cell.getCellType() == CellType.BLANK)
            return cell.getStringCellValue();
        else
            throw new IllegalArgumentException(String.format("El valor ubicado en la columna %s fila %s no es una cadena de texto/VACIA", CellReference.convertNumToColString(cell.getColumnIndex()), cell.getRowIndex() + 1));
    }
    public static String validaEmailCellValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING && (patternMatches(cell.getStringCellValue()) || patternMatchesLarge(cell.getStringCellValue()) || patternMatchesExtraLarge(cell.getStringCellValue())) || cell.getStringCellValue().isBlank())
            return cell.getStringCellValue();
        else
            throw new IllegalArgumentException(String.format("El valor ubicado en la columna %s fila %s no es un correo valido", CellReference.convertNumToColString(cell.getColumnIndex()), cell.getRowIndex() + 1));
    }
    public static boolean patternMatches(String emailAddress) {
        return Pattern.matches("([a-z0-9].{1,64})@([a-z0-9]{4,255}.[a-z0-9]{2,4}){0,256}$",emailAddress);
    }
    public static boolean patternMatchesLarge(String emailAddress) {
        return Pattern.matches("([a-z0-9].{1,64})@([a-z0-9]{3,255}.[a-z0-9]{2,5}.[a-z0-9]{2,5}){0,256}$",emailAddress);
    }
    public static boolean patternMatchesExtraLarge(String emailAddress) {
        return Pattern.matches("([a-z0-9].{1,64})@([a-z0-9]{3,255}.[a-z0-9]{2,5}.[a-z0-9]{2,5}.[a-z0-9]{2,5}){0,256}$",emailAddress);
    }
    public static XSSFWorkbook getWorkbook(String nombre, InputStream inputStream) throws IOException {
        if (inputStream == null || nombre == null)
            throw new IllegalArgumentException("Agrega un archivo para validar");
        else if (nombre.endsWith("xlsx") || nombre.endsWith("xls") || nombre.endsWith("csv"))
            return new XSSFWorkbook(inputStream);
        throw new IllegalArgumentException(String.format("El formato del Archivo '%s' no es un archivo de Excel o CSV", nombre));

    }

    public static String validaStringValue(String stringValue) {
        if (stringValue.length() >= Numeros.TRES.getNumero())
            return stringValue;
        else
            throw new IllegalArgumentException(String.format("El nombre de la institución '%s' debe ser mayor a 3 caracteres y menor a 255", stringValue));
    }

    public static String validaEmailValue(String stringValue) {
        if (patternMatches(stringValue) || stringValue.isBlank())
            return stringValue;
        else
            throw new IllegalArgumentException(String.format("El correo '%s' no es un correo valido", stringValue));
    }
}
