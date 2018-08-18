package base.service;

import base.entity.DocumentUnit;

public interface ExternalCommandService {
    void stopService();

    void addFile(DocumentUnit document);

    void cancelPrintFile(String fileName);

    void getSortedDocument(String sortType);

    void getAverage();
}
