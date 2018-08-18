package base.management;

import base.entity.DocumentUnit;
import base.tools.PrintTask;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ExternalCommandImpl implements ExternalCommand {
    private static final BlockingQueue<DocumentUnit> PRINTQUEUE = new LinkedBlockingQueue<>();
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public void init() {
        EXECUTOR.submit(new PrintTask(PRINTQUEUE));
    }

    @Override
    public List<DocumentUnit> stopService() {
        List<DocumentUnit> unprintedFiles = new ArrayList<>();
        EXECUTOR.shutdownNow();
        for (int i = 0; i < PRINTQUEUE.size(); i++) {
            unprintedFiles.add(PRINTQUEUE.iterator().next());
        }
        return unprintedFiles;
    }

    @Override
    public boolean addFile(DocumentUnit document) {
        return PRINTQUEUE.offer(document);
    }

    @Override
    public boolean cancelPrintFile(String fileName) {
        DocumentUnit documentUnit = PRINTQUEUE.iterator().next();
        return documentUnit.getName().equals(fileName) && PRINTQUEUE.remove(documentUnit);
    }

    @Override
    public List<DocumentUnit> getSortedDocument(String sortType) {
        return PrintTask.getCompletePrintDoc(sortType);
    }

    @Override
    public double getAverage() {
        return PrintTask.getAverage();
    }
}
