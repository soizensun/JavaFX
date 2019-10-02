package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class MainModel {
    public static void main(String[] args) {
        File testFile = new File("test.txt");
        File year1_1 = new File("subjectYear1_1.txt");
        File year1_2 = new File("subjectYear1_2.txt");
        File year2_1 = new File("subjectYear2_1.txt");
        File year2_2 = new File("subjectYear2_2.txt");
        File year3_1 = new File("subjectYear3_1.txt");
        File year3_2 = new File("subjectYear3_2.txt");
        File year4_1 = new File("subjectYear4_1.txt");
        File year4_2 = new File("subjectYear4_2.txt");

        FileManaging f = new FileManaging();
        HashSet<Subject> subjectArrayListTest = f.readFromTXTFile(testFile);
        System.out.println("Test : " +  subjectArrayListTest);

        HashSet<Subject> subject1_1 = f.readFromTXTFile(year1_1);
        System.out.println("Year1_1 : " + subject1_1);

        HashSet<Subject> subject1_2 = f.readFromTXTFile(year1_2);
        System.out.println("Year1_2 : " + subject1_2);

        HashSet<Subject> subject2_1 = f.readFromTXTFile(year2_1);
        System.out.println("Year2_1 : " + subject2_1);

        HashSet<Subject> subject2_2 = f.readFromTXTFile(year2_2);
        System.out.println("Year2_2 : " + subject2_2);

        HashSet<Subject> subject3_1 = f.readFromTXTFile(year3_1);
        System.out.println("Year3_1 : " + subject3_1);

        HashSet<Subject> subject3_2 = f.readFromTXTFile(year3_2);
        System.out.println("Year3_2 : " + subject2_1);

        HashSet<Subject> subject4_1 = f.readFromTXTFile(year4_1);
        System.out.println("Year4_1 : " + subject4_1);

        HashSet<Subject> subject4_2 = f.readFromTXTFile(year4_2);
        System.out.println("Year4_2 : " + subject4_2);

//        f.clearAllSubjectArrayList();
    }
}
