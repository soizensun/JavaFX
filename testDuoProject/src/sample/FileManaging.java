package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FileManaging {

    private FileReader reader;
    private BufferedReader buffer;
    private HashSet<Subject> allSubjectHashMap;

    public FileManaging() {
        allSubjectHashMap = new HashSet<>();
    }


//    public void clearAllSubjectArrayList(){
//        allSubjectHashMap.clear();
//    }

    public HashSet<Subject> getAllSubjectHashMap() {
        return allSubjectHashMap;
    }

    public void  readAll(){
        File f1_1 = new File("subjectYear1_1.txt");
        File f1_2 = new File("subjectYear1_2.txt");
        File f2_1 = new File("subjectYear2_1.txt");
        File f2_2 = new File("subjectYear2_2.txt");
        File f3_1 = new File("subjectYear3_1.txt");
        File f3_2 = new File("subjectYear3_2.txt");
        File f4_1 = new File("subjectYear4_1.txt");
        File f4_2 = new File("subjectYear4_2.txt");

        HashSet set1_1 = readFromTXTFile(f1_1);
        HashSet set1_2 = readFromTXTFile(f1_2);
        HashSet set2_1 = readFromTXTFile(f2_1);
        HashSet set2_2 = readFromTXTFile(f2_2);
        HashSet set3_1 = readFromTXTFile(f3_1);
        HashSet set3_2 = readFromTXTFile(f3_2);
        HashSet set4_1 = readFromTXTFile(f4_1);
        HashSet set4_2 = readFromTXTFile(f4_2);

        allSubjectHashMap.addAll(set1_1);
        allSubjectHashMap.addAll(set1_2);
        allSubjectHashMap.addAll(set2_1);
        allSubjectHashMap.addAll(set2_2);
        allSubjectHashMap.addAll(set3_1);
        allSubjectHashMap.addAll(set3_2);
        allSubjectHashMap.addAll(set4_1);
        allSubjectHashMap.addAll(set4_2);
    }


    public HashSet readFromTXTFile(File file){
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        buffer = new BufferedReader(reader);
        HashSet<Subject> subjectHashSet = new HashSet<>();
        try {
            String line = "";
            while((line =  buffer.readLine()) != null){
                String objN = "";
                String name = "";
                String code = "";
                int credit = 0;
                String typeOfSubject = null;
                Subject[] duplicateSubject = null;
                int level = 0;
                Subject[] pre = null;
                if((line.split(" >> ")[1]).split(" ; ")[4].equals("none") && (line.split(" >> ")[1]).split(" ; ")[6].equals("none")){
                    objN = (line.split(" >> ")[0]).split(" ; ")[0];
                    name = (line.split(" >> ")[1]).split(" ; ")[0];
                    code = (line.split(" >> ")[1]).split(" ; ")[1];
                    credit = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[2]);
                    typeOfSubject = (line.split(" >> ")[1]).split(" ; ")[3];
                    level = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[5]);
                    Subject s = new Subject(objN,name,code,credit,typeOfSubject,level);
                    allSubjectHashMap.add(s);
                    subjectHashSet.add(s);
                }
                if ( (line.split(" >> ")[1]).split(" ; ")[4].equals("none")){
                    objN = (line.split(" >> ")[0]).split(" ; ")[0];
                    name = (line.split(" >> ")[1]).split(" ; ")[0];
                    code = (line.split(" >> ")[1]).split(" ; ")[1];
                    credit = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[2]);
                    typeOfSubject = (line.split(" >> ")[1]).split(" ; ")[3];
                    level = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[5]);
                    int size = (((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")).length;
                    if(size == 1){
                        String preObj0 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[0];
                        for (Subject e : allSubjectHashMap) {
                            if(e.getObjectName().equals(preObj0)){
                                Subject s = new Subject(objN,name,code,credit,typeOfSubject,level, new Subject[]{e});
                                subjectHashSet.add(s);
                                allSubjectHashMap.add(s);
                                break;
                            }
                        }
                    }
                    else if(size == 2){
                        ArrayList<Subject> temp = new ArrayList<>(allSubjectHashMap); // copy arraylist
                        String preObj0 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[0];
                        String preObj1 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[1];
                        Subject[] arr = new Subject[2];
                        for (Subject e : temp) {
                            if(e.getObjectName().equals(preObj0)){
                                arr[0] = e;
                                temp.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp) {
                            if (e.getObjectName().equals(preObj1)) {
                                arr[1] = e;
                                temp.remove(e);
                                break;
                            }
                        }
                        Subject s = new Subject(objN,name,code,credit,typeOfSubject,level,arr);
                        allSubjectHashMap.add(s);
                        subjectHashSet.add(s);
                    }
                    else if(size == 3){
                        ArrayList<Subject> temp1 = new ArrayList<>(allSubjectHashMap); // copy arraylist
                        String preObj0 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[0];
                        String preObj1 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[1];
                        String preObj2 = ((line.split(" >> ")[1]).split(" ; ")[6]).split(" , ")[2];
                        Subject[] arr = new Subject[3];
                        for (Subject e : temp1) {
                            if(e.getObjectName().equals(preObj0)){
                                arr[0] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp1) {
                            if (e.getObjectName().equals(preObj1)) {
                                arr[1] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp1) {
                            if (e.getObjectName().equals(preObj2)) {
                                arr[2] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        Subject s = new Subject(objN,name,code,credit,typeOfSubject,level,arr);
                        subjectHashSet.add(s);
                        allSubjectHashMap.add(s);
                    }
                }


                if(  (line.split(" >> ")[1]).split(" ; ")[6].equals("none")){
                    objN = (line.split(" >> ")[0]).split(" ; ")[0];
                    name = (line.split(" >> ")[1]).split(" ; ")[0];
                    code = (line.split(" >> ")[1]).split(" ; ")[1];
                    credit = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[2]);
                    typeOfSubject = (line.split(" >> ")[1]).split(" ; ")[3];
                    int size = (((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")).length;
                    level = Integer.parseInt((line.split(" >> ")[1]).split(" ; ")[5]);

                    if(size == 1){
                        String preObj0 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[0];
                        for (Subject e : allSubjectHashMap) {
                            if(e.getObjectName().equals(preObj0)){
                                Subject s = new Subject(objN,name,code,credit,typeOfSubject, new Subject[]{e}, level);
                                allSubjectHashMap.add(s);
                                subjectHashSet.add(s);
                                break;
                            }
                        }
                    }
                    else if(size == 2){
                        ArrayList<Subject> temp = new ArrayList<>(allSubjectHashMap); // copy arraylist
                        String dupObj0 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[0];
                        String dupObj1 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[1];
                        Subject[] arrdup = new Subject[2];
                        for (Subject e : temp) {
                            if(e.getObjectName().equals(dupObj0)){
                                arrdup[0] = e;
                                temp.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp) {
                            if (e.getObjectName().equals(dupObj1)) {
                                arrdup[1] = e;
                                temp.remove(e);
                                break;
                            }
                        }
                        Subject s = new Subject(objN, name, code, credit, typeOfSubject, arrdup, level);
                        allSubjectHashMap.add(s);
                        subjectHashSet.add(s);
                    }
                    else if(size == 3){
                        ArrayList<Subject> temp1 = new ArrayList<>(allSubjectHashMap); // copy arraylist
                        String dupObj0 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[0];
                        String dupObj1 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[1];
                        String dupObj2 = ((line.split(" >> ")[1]).split(" ; ")[4]).split(" , ")[2];
                        Subject[] arrDup = new Subject[3];
                        for (Subject e : temp1) {
                            if(e.getObjectName().equals(dupObj0)){
                                arrDup[0] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp1) {
                            if (e.getObjectName().equals(dupObj1)) {
                                arrDup[1] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        for (Subject e : temp1) {
                            if (e.getObjectName().equals(dupObj2)) {
                                arrDup[2] = e;
                                temp1.remove(e);
                                break;
                            }
                        }
                        Subject s = new Subject(objN,name,code,credit,typeOfSubject, arrDup, level);
                        subjectHashSet.add(s);
                        allSubjectHashMap.add(s);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  subjectHashSet;
    }
}
