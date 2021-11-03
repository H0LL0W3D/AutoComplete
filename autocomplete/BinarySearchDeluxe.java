import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {



    
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        //initalizations
        int midPoint = (int)(a.length / 2);
        int lowPoint = 0;
        int highPoint = a.length - 1;

        int loopCount = binarySearchLoopCount( a.length ) + 1;


        //our binary searching loop
        while ( loopCount != 0 ){
            loopCount--;

            //if midpoint is at target
            if (comparator.compare(a[midPoint], key) == 0 ) {
                //System.out.println(midPoint);

                if ( checkIfEdge(a, midPoint, midPoint - 1, comparator, key) )
                    return midPoint;

            }


            //if key is smaller than the middle
            if (comparator.compare(a[midPoint], key) >= 0 ) {
                highPoint = midPoint;
                midPoint = ( ( highPoint - lowPoint ) / 2 ) + lowPoint;

            }


            //if key is larger than the middle
            else if (comparator.compare(a[midPoint], key) <= 0 ) {
                lowPoint = midPoint;

                if ( highPoint + midPoint % 2 != 0 )
                    midPoint++;

                midPoint = ( highPoint + midPoint ) / 2;

            }




        }//end of searching loop



        return -1;
    }




    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        //initalizations
        int midPoint = (int)(a.length / 2);
        int lowPoint = 0;
        int highPoint = a.length - 1;

        int loopCount = binarySearchLoopCount( a.length ) + 1;


        //our binary searching loop
        while ( loopCount != 0 ){
            loopCount--;

            //if midpoint is at target
            if (comparator.compare(a[midPoint], key) == 0 ) {
                //System.out.println(midPoint);

                if ( checkIfEdge(a, midPoint, midPoint + 1, comparator, key) )
                    return midPoint;

            }


            //if key is larger than the middle
            if (comparator.compare(a[midPoint], key) <= 0 ) {
                lowPoint = midPoint;

                if ( highPoint + midPoint % 2 != 0 )
                    midPoint++;

                midPoint = ( highPoint + midPoint ) / 2;

            }

            //if key is smaller than the middle
            else if (comparator.compare(a[midPoint], key) >= 0 ) {
                highPoint = midPoint;
                midPoint = ( ( highPoint - lowPoint ) / 2 ) + lowPoint;

            }




        }//end of searching loop



        return -1;
    }




    // - - - - - internals - - - - - - -

    //helps get the amount of times we need to loop into our array
    private static int binarySearchLoopCount(int maxLength) {
        int binarySearchValue = 1;
        int binarySearchLoopCount = 1;

        while (binarySearchValue < maxLength) {
            binarySearchValue *= 2;
            binarySearchLoopCount++;
        }


        return binarySearchLoopCount;
    }

    //shamelessly stole off of my percolation assignment
    private static <Key> boolean coordinateValidate(Key[] array, int index) {
        boolean bool = true;

        try { if ( array[index] == "" ); }
        catch (ArrayIndexOutOfBoundsException a) { bool = false; }

        return bool;
    }

    //helps check if a value is at the edge
    private static <Key> boolean checkIfEdge(Key[] array, int indexPointer, int adjacentPointer, Comparator<Key> comparator, Key key){
        boolean isAtEdge = false;


        //if at zero and checking behind
        if ( indexPointer == 0 && adjacentPointer < 0 )
            isAtEdge = true;

        //if at max, and checking ahead
        else if ( indexPointer == array.length - 1 && adjacentPointer > array.length - 1 )
            isAtEdge = true;


        else if ( coordinateValidate(array, adjacentPointer) ) //valid adjacentpoint
                if (coordinateValidate(array, indexPointer) ) //valid midpoint
                    if ( comparator.compare(array[indexPointer], key) == 0 ) //midpoint same as key
                        if (comparator.compare(array[adjacentPointer], key) != 0) //adjacentpoint not same as key
                            isAtEdge = true;

        return isAtEdge;
    }






    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[9];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);

        terms[5] = new Term("TrevorALPHA", 400);
        terms[6] = new Term("trevorBETA", 200);
        terms[7] = new Term("Trevor ", 300);
        terms[8] = new Term("Jackie", 250);


        Arrays.sort(terms);


        for (int i = 0; i < terms.length; i++)
            System.out.println(terms[i] + " " + i); //display the stuff
        System.out.println();



        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("Trevor",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}