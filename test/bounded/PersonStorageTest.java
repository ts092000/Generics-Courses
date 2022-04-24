package com.bkitsolution.test.bounded;

import com.bkitsolution.main.bounded.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class PersonStorageTest
{
    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @org.junit.Test
    public void cannotLoadFromEmptyFile() throws Exception
    {
        PersonLoader loader = new PersonLoader(file);

        Assert.assertNull(loader.load());
    }

    @org.junit.Test
    public void savesAndLoadsPerson() throws Exception
    {
        PersonSaver saver = new PersonSaver(file);
        PersonLoader loader = new PersonLoader(file);

        saver.save(donDraper);

        assertEquals(donDraper, loader.load());

//        saver.save(peggyOlson);
//
//        assertEquals(peggyOlson, loader.load());
    }

    @org.junit.Test
    public void savesAndLoadsTwoPeople() throws Exception
    {
        saver.save(donDraper);
        saver.save(peggyOlson);

        assertEquals(donDraper, loader.load());
        assertEquals(peggyOlson, loader.load());
    }

    @org.junit.Test
    public void savesArraysOfPeople() throws Exception
    {
        /*Employee[] employees = new Employee[2];
        Person[] people = employees;*/
//        List<Person> persons = new ArrayList<>();
//        persons.add(donDraper);
//        persons.add(bertCooper);
        Partner[] people = new Partner[2];
        people[0] = donDraper;
        people[1] = bertCooper;

//        saver.saveAll(persons);
        saver.saveAll(people);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @org.junit.Test
    public void savesListsOfPeople() throws Exception
    {
        List<Partner> people = new ArrayList<>();
        people.add(donDraper);
        people.add(bertCooper);

        saver.saveAll(people);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void loadsListsOfPeople() throws Exception
    {
        saver.save(donDraper);
        saver.save(bertCooper);

//        List<Person> people = new ArrayList<>();
        List<Object> people = new ArrayList<>();
        loader.loadAll(people);

//        assertEquals(donDraper, people.get(0));
//        assertEquals(bertCooper, people.get(1));

        Assert.assertEquals(asList(donDraper, bertCooper), people);
    }

    @Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }
}
