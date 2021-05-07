package com.ygafarov.oldexcelconverter;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static java.util.Objects.nonNull;

/**
 * Имплементация конвертера старого фаормата Excel в новый формат
 * на основе библиотеки Java Excel API (<a href="http://jexcelapi.sourceforge.net">jexcelapi.sourceforge.net</a>)
 * Кодировка для кириллицы: Windows-1251.
 */

public class OldFormatConverterImpl implements OldFormatConverter {
    @Override
    public InputStream convertToNewFormat(InputStream oldFormatInputStream, String encoding) throws Exception {
        WorkbookSettings settings = new WorkbookSettings();
        settings.setEncoding(encoding);
        ByteArrayOutputStream newFormatOutputStream = new ByteArrayOutputStream();
        Workbook workbook = null;
        WritableWorkbook writableWorkbook = null;
        try {
            workbook = Workbook.getWorkbook(oldFormatInputStream, settings);
            writableWorkbook = Workbook.createWorkbook(newFormatOutputStream, workbook, settings);
            writableWorkbook.write();
        } finally {
            if (nonNull(writableWorkbook)) {
                writableWorkbook.close();
            }
            if (nonNull(workbook)) {
                workbook.close();
            }
        }

        return new ByteArrayInputStream(newFormatOutputStream.toByteArray());
    }
}
