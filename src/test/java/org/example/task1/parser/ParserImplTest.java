package org.example.task1.parser;

import org.example.task1.entity.ArrayEntity;
import org.example.task1.exception.ArrayException;
import org.example.task1.parser.impl.ArrayParserImpl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserImplTest {

    @Test
    void provideLinesForParseToCustomArrayFromStringList() throws ArrayException {
        ArrayParserImpl parser = new ArrayParserImpl();
        List<String> lines = Arrays.asList(
                "arr1:1 2 3 4",
                "arr2:-5, 10, -3",
                "arr3:7;-8;9",
                "arr4:10, -11, 12",
                "arr5:text",
                "arr6:1, 2, a",
                "",
                "abc xyz"
        );

        List<ArrayEntity> expected =new ArrayList<ArrayEntity>();
        List<ArrayEntity> actual = new ArrayList<ArrayEntity>();
        expected.add(new ArrayEntity("arr1", new int[]{1,2,3,4}));
        expected.add(new ArrayEntity("arr2", new int[]{-5,10,-3}));
        expected.add(new ArrayEntity("arr3", new int[]{7,-8,9}));
        expected.add(new ArrayEntity("arr4", new int[]{10,-11,12}));

        for(String line:lines){
             actual.add(parser.parseEntityFromString(line));
        }
        for(int i =0; i<expected.size();i++){
            assertArrayEquals(expected.get(i).getArray(), actual.get(i).getArray());
        }

    }

}