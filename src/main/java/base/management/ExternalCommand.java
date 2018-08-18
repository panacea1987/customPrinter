package base.management;

import base.entity.DocumentUnit;

import java.util.List;

public interface ExternalCommand {

    List<DocumentUnit> stopService();

    boolean addFile(DocumentUnit document);

    boolean cancelPrintFile(String fileName);

    List<DocumentUnit> getSortedDocument(String sortType);

    double getAverage();
}
