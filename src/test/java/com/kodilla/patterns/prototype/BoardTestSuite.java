package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString(){
        //Given
        //Creating TaskList toDos
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n+1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task Number" + n)));
        //Creating TaskList inProgress
        TaskList listInProgress = new TaskList("In Progress Tasks");
        IntStream.iterate(1, n-> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task Number" + n)));
        //Creating TaskList done
        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1, n-> n+1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task Number " + n)));

        //Creating board and assigning lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //Shallow copy
        Board clonedBoard = null;
        try{
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch(CloneNotSupportedException e){
            System.out.println(e);
        }

        //Deep copy
        Board deepClonedBoard = null;
        try{
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When

        board.getLists().remove(listToDo);

        //Then
        System.out.println("Board: " + board);
        System.out.println("Cloned board: " + clonedBoard);
        System.out.println("deepClonedBoard" + deepClonedBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
