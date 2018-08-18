package base.tools;

import base.entity.DocumentUnit;
<<<<<<< HEAD

import java.util.ArrayList;
=======
import base.service.ExternalCommandServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
>>>>>>> 3 commit
import java.util.List;
import java.util.concurrent.BlockingQueue;


public class PrintTask implements Runnable {
<<<<<<< HEAD
=======
    private static final Log logger = LogFactory.getLog(PrintTask.class);
>>>>>>> 3 commit
    private final static List<DocumentUnit> DONEFILES = new ArrayList<>();
    private static double duration = 0;
    private static double count = 0;
    private BlockingQueue<DocumentUnit> PRINTQUEUE;

    public PrintTask(BlockingQueue<DocumentUnit> PRINTQUEUE) {
        this.PRINTQUEUE = PRINTQUEUE;
    }

    public PrintTask() {

    }

    public static double getAverage() {
        return duration / count;
    }

    public static List<DocumentUnit> getCompletePrintDoc(String typeSort) {
        switch (typeSort) {
            case "typeOrder":
<<<<<<< HEAD
                DONEFILES.sort(DocumentUnit.COMPARE_BY_TYPE);
                break;
            case "durationOrder":
                DONEFILES.sort(DocumentUnit.COMPARE_BY_DURATION);
                break;
            case "sizeOrder":
                DONEFILES.sort(DocumentUnit.COMPARE_BY_SIZE);
=======
                Collections.sort(DONEFILES,DocumentUnit.COMPARE_BY_TYPE);
                break;
            case "durationOrder":
                Collections.sort(DONEFILES,DocumentUnit.COMPARE_BY_DURATION);
                break;
            case "sizeOrder":
                Collections.sort(DONEFILES,DocumentUnit.COMPARE_BY_SIZE);
>>>>>>> 3 commit
                break;
        }
        return DONEFILES;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                DocumentUnit documentUnit = PRINTQUEUE.take();
                Thread.sleep(documentUnit.getDuration());
                duration += documentUnit.getDuration();
                count++;
                DONEFILES.add(documentUnit);

            }


        } catch (InterruptedException e) {
<<<<<<< HEAD
=======
            logger.warn("Error call Thread.sleep()");
>>>>>>> 3 commit
            e.printStackTrace();
        }

    }
}
