package com.ygafarov.oldexcelconverter;

import java.io.InputStream;

public interface OldFormatConverter {

    /**
     * Метод для конвертации InputStream excel-файла старого формата (5.0 / 7.0 (BIFF5))
     * в InputStream нового формата для передачи в APACHE POI для дальнейшей обработки excel.
     *
     * @param oldFormatInputStream InputStream excel-файла в старом формате
     * @param encoding             Кодировка используемая внутри excel-файла
     * @return InputStream excel-файла в новом формате
     */
    InputStream convertToNewFormat(InputStream oldFormatInputStream, String encoding) throws Exception;
}
