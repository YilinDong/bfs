package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.DigitalDocument;

public interface DigitalDocumentDao {
    DigitalDocument getDigitalDocumentByType(String type);
}
