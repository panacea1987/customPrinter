package base.service;

import base.entity.DocumentUnit;
import base.management.ExternalCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalCommandServiceImpl implements ExternalCommandService {
    private static final Log logger = LogFactory.getLog(ExternalCommandServiceImpl.class);
    private ExternalCommand command;


    public void setCommand(ExternalCommand command) {
        this.command = command;
    }

    @Override
    public void stopService() {
        List<DocumentUnit> unprintedFiles = command.stopService();
        if(!unprintedFiles.isEmpty()){
            logger.info("Unprinted files list: ");
            for(DocumentUnit unit: unprintedFiles){
                logger.info(unit);
            }
        }else logger.info("Don`t have unprinted files");
<<<<<<< HEAD
=======
        try {
            logger.info("system turns off after 10 sec");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.warn("Error call Thread.sleep()");
            e.printStackTrace();
        }
        System.exit(500);
>>>>>>> 3 commit
    }

    @Override
    public void addFile(DocumentUnit document) {
        if(command.addFile(document)){
          logger.info(document.getName()+" added to queue");
        }else logger.info("Error add file " + document.getName());


    }

    @Override
    public void cancelPrintFile(String fileName) {
        if(command.cancelPrintFile(fileName)){
            logger.info(fileName + " has be delete from queue");
        }else logger.info("file not found");

    }

    @Override
    public void getSortedDocument(String sortType) {
        for (DocumentUnit unit : command.getSortedDocument(sortType)) {
<<<<<<< HEAD
            System.out.println(unit);
=======
            logger.info(unit);
>>>>>>> 3 commit
        }
    }

    @Override
    public void getAverage() {
        logger.info("average duration print: " + command.getAverage()/1000 + " sec");
    }
}
