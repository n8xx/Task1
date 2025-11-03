package org.example.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.repository.ArrayRepository;
import org.example.task1.service.observer.impl.ArrayObserverIpml;
import org.example.task1.service.reader.impl.ArrayReaderService;
import org.example.task1.service.parser.impl.ArrayParserService;
import org.example.task1.factory.ArrayEntityFactory;

public class Main {
    private final static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayReaderService fileReader = new ArrayReaderService();

        ArrayParserService parser= new ArrayParserService();
        ArrayObserverIpml observer = new ArrayObserverIpml();
        ArrayRepository arrayRepository = ArrayRepository.getInstance();
        try {
            ArrayEntity array = ArrayEntityFactory.createWithData(parser.parseIdFromString("data/data.txt"),
                    parser.parseArrayFromString("data/data.txt"));
            array.attach(observer);
            arrayRepository.addArray(array);
        }
        catch(ArrayException e){
            logger.error("Can't access file");
            e.printStackTrace();
        }

    }

}
