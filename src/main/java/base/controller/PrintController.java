package base.controller;

import base.entity.DocumentUnit;
import base.service.ExternalCommandService;
import base.tools.InputCommandReader;

import java.util.regex.Pattern;

public class PrintController {
    private InputCommandReader reader;
    private ExternalCommandService service;
    private String txtDescr;
    private int txtDuration;
    private int txtSize;
    private String pdfDescr;
    private int pdfDuration;
    private int pdfSize;
    private String xlsDescr;
    private int xlsDuration;
    private int xlsSize;
    public PrintController(InputCommandReader reader,
                           ExternalCommandService service,
                           String txtDescr,
                           int txtDuration,
                           int txtSize,
                           String pdfDescr,
                           int pdfDuration,
                           int pdfSize,
                           String xlsDescr,
                           int xlsDuration,
                           int xlsSize) {
        this.reader = reader;
        this.service = service;
        this.txtDescr = txtDescr;
        this.txtDuration = txtDuration;
        this.txtSize = txtSize;
        this.pdfDescr = pdfDescr;
        this.pdfDuration = pdfDuration;
        this.pdfSize = pdfSize;
        this.xlsDescr = xlsDescr;
        this.xlsDuration = xlsDuration;
        this.xlsSize = xlsSize;
    }

    public void getInputCommand() {
        String command;
        String fileType;
        String fileName;
        String sortType;
        while (true) {
            command = reader.getInputCommand("Enter command:");
            switch (command) {
                case "add":
                    fileType = reader.getInputCommand("input file name");
                    if (fileType.contains(".") && fileType.split(Pattern.quote("."))[1].equals("txt")) {
                        service.addFile(new DocumentUnit(fileType, txtDescr, txtDuration, txtSize));
                    } else if (fileType.contains(".") && fileType.split(Pattern.quote("."))[1].equals("pdf")) {
                        service.addFile(new DocumentUnit(fileType, pdfDescr, pdfDuration, pdfSize));
                    } else if (fileType.contains(".") && fileType.split(Pattern.quote("."))[1].equals("xls")) {
                        service.addFile(new DocumentUnit(fileType, xlsDescr, xlsDuration, xlsSize));
                    } else System.out.println("unknown file format");


                    break;
                case "stop":
                    service.stopService();
                    break;
                case "rem":
                    fileName = reader.getInputCommand("input file name");
                    service.cancelPrintFile(fileName);
                    break;
                case "view":
                    sortType = reader.getInputCommand("input sortType(typeOrder, durationOrder, sizeOrder or press enter by default sort)");
                    service.getSortedDocument(sortType);
                    break;
                case "stat":
                    service.getAverage();
                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }
        }


    }
}
