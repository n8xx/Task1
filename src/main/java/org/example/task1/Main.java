package org.example.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.repository.impl.ArrayRepositoryImpl;
import org.example.task1.service.observer.impl.;
import org.example.task1.service.reader.impl.ArrayReaderService;
import org.example.task1.service.parser.impl.ArrayParserService;
import org.example.task1.factory.ArrayEntityFactory;

public class Main {
    private final static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayReaderService fileReader = new ArrayReaderService();

        ArrayParserService parser= new ArrayParserService();
        ArrayObserverIpml observer = new ArrayObserverIpml();
        ArrayRepositoryImpl arrayRepository = ArrayRepositoryImpl.getInstance();
        try {
            ArrayEntity array = ArrayEntityFactory.createWithData(parser.parseEntityFromString(data.))
            array.attach(observer);
            arrayRepository.addArray(array);
        }
        catch(FileException e){
            logger.error("Can't access file");
            e.printStackTrace();
        }
        catch(ArrayException e){
            logger.error("Can't create the array");
            e.printStackTrace();
        }

    }

}
