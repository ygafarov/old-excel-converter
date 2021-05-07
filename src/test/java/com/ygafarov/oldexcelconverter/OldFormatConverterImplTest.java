package com.ygafarov.oldexcelconverter;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class OldFormatConverterImplTest {

    @Test
    void convertToNewFormat() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("old_format_excel.xls");
        OldFormatConverterImpl oldFormatConverter = new OldFormatConverterImpl();
        oldFormatConverter.convertToNewFormat(resourceAsStream, "WINDOWS-1251");
    }
}