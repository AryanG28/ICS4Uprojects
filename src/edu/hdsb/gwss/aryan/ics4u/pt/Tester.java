package edu.hdsb.gwss.aryan.ics4u.pt;

/**
 * Open Hash Table Tester
 *
 * @version v2014.S1
 */
public class Tester {

    /**
     */
    public static void main( String[] args ) {

        CSStudent studentTA = new CSStudent( "Tami", "A", 7110, 12 );
        CSStudent studentSA = new CSStudent( "Sami", "A", 2221, 12 );
        CSStudent studentKB = new CSStudent( "Kael", "B", 2332, 12 );
        CSStudent studentAG = new CSStudent( "Aryan", "G", 1443, 12 );
        CSStudent studentFH = new CSStudent( "Farzan", "H", 2554, 12 );
        CSStudent studentAK = new CSStudent( "Adriana", "K", 6665, 12 );
        CSStudent studentAL = new CSStudent( "Alex", "L", 7976, 12 );
        CSStudent studentSL = new CSStudent( "Steven", "L", 8387, 12 );
        CSStudent studentAM = new CSStudent( "Adil", "M", 9098, 12 );
        CSStudent studentSN = new CSStudent( "Sam", "N", 1120, 12 );
        CSStudent studentRQ = new CSStudent( "Rasheed", "Q", 2231, 12 );
        CSStudent studentFR = new CSStudent( "Farjaad", "R", 1342, 12 );
        CSStudent studentFR2 = new CSStudent( "Francis", "R", 4453, 12 );
        CSStudent studentSS = new CSStudent( "Scott", "S", 5564, 12 );
        CSStudent studentDS = new CSStudent( "Dan", "S", 6675, 12 );
        CSStudent studentLW = new CSStudent( "Leon", "W", 2896, 12 );


        
        LinkedListPT pt = new LinkedListPT();
        System.out.println("--------is empty-----------------------");
        System.out.println(pt.isEmpty());
        System.out.println("--------addAtEnd-----------------------");
        pt.addAtEnd(studentLW);
        pt.addAtEnd(studentTA);
        pt.addAtEnd(studentFH);
        pt.addAtEnd(studentAG);
        System.out.println(pt.size());
        System.out.println(pt.toString());
        
        System.out.println("--------get-----------------------");
        System.out.println(pt.get(123));
        System.out.println("--------remove-----------------------");
        pt.remove(studentLW.getKey());
        System.out.println(pt.toString());
        System.out.println("------------size-------------------");
        System.out.println(pt.size());
        System.out.println("-------------------------------");
        System.out.println("------------makeEmpty-------------------");
        pt.makeEmpty();
        System.out.println(pt.toString());
        System.out.println(pt.size());
        System.out.println("LINKED LIST PASSES TEST");
        
        OpenHashTable ht = new OpenHashTable();
        System.out.println("--------is empty-----------------------");
        System.out.println(ht.isEmpty());
        System.out.println(ht.size());
        System.out.println("-------------put------------------");
        ht.put(studentTA);
        ht.put(studentSA);
        ht.put(studentKB);
        ht.put(studentAG);
        ht.put(studentFH);
        ht.put(studentAK);
        ht.put(studentAL);
        ht.put(studentSL);
        ht.put(studentAM);
        ht.put(studentSN);
        ht.put(studentRQ);
        ht.put(studentFR2);
        ht.put(studentFR);
        ht.put(studentFR);
        ht.put(studentFR);
        System.out.println(ht.size());
        
        System.out.println("----------Get---------------------");
        System.out.println(ht.get(studentSL.getKey()));
        System.out.println(ht.get(studentKB.getKey()));
        System.out.println(ht.isEmpty());
        
        System.out.println("----------ContainsKey---------------------");
        System.out.println(ht.containsKey(studentKB.getKey()));
        System.out.println(ht.containsKey(1));
        
        System.out.println("-------------------------------");
        System.out.println( ht.toString() );
        System.out.println("----------makeempty---------------------");
        ht.makeEmpty();
        System.out.println(ht.isEmpty());
        System.out.println( ht.toString() );
        System.out.println(" OPEN HASH TABLE PASSES TEST");
        

    }

}
