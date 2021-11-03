import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

    private final String query;
    private final long weight;



    // Initializes a term with the given query string and weight.
    public Term(String q, long w) {
        this.weight = w;
        this.query = q;
    }




    //compare by verse weight order
    public static Comparator<Term> byReverseWeightOrder() {

        return new Comparator<Term>() {

            public int compare(Term v, Term w) {

                //if initial weight is less than the latter
                if (v.weight < w.weight)
                    return -1;

                //if initial weight is more than the latter
                else if (v.weight > w.weight)
                    return 1;

                //if the weight is same
                else
                    return 0;

            }

        };
    }




    // Compares the two terms in lexicographic order
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {


                char[] charV = v.query.toCharArray();
                char[] charW = w.query.toCharArray();
                int shortestTerm = r;


                // THIS SEEMS TO BREAK IT AND IDK WHY
                if (charV.length < shortestTerm)
                    shortestTerm = charV.length;

                else if (charW.length < shortestTerm)
                    shortestTerm = charW.length;

                // */

                //iterate through array of characters
                for (int i = 0; i < shortestTerm; i++) {
                    if ( charV[i] == charW[i] )
                        continue;

                    else if ( charV[i] > charW[i] )
                        return 1; //if 1st term > 2nd term, return 1


                    else if ( charV[i] < charW[i] )
                        return -1; //if 2nd term > 1st term, return -1

                }//end of char array iterate loop


                /* THIS SEEMS TO BREAK IT AND IDK WHY

                if one term is shorter than the other, and in all other ways
                equivalent, the shorter one preceeds the longer one

                if (charV.length != charW.length){

                    //if 1st term shorter than 2nd
                    if (charV.length < charW.length)
                        return 1;


                    //if 2nd term shorter than 1st
                    if (charV.length > charW.length)
                        return -1;

                }
*/


                //if all values equal, and same length, return zero
                return 0;
            }
        };
    }




    // Compares the two terms in lexicographic order by query.
    //basic implementation

    public int compareTo(Term that) {

        //PRECEDENT == THIS
        char[] precedent = new char[ this.query.toCharArray().length ];
        precedent = this.query.toCharArray();

        //CONSEQUENT == THAT
        char[] consequent = new char[ that.query.toCharArray().length ];
        consequent = that.query.toCharArray();


        int shorterQuery = precedent.length;
        if ( consequent.length < precedent.length ) //if THAT is longer than THIS
            shorterQuery = consequent.length;


        for (int i = 0; i < shorterQuery; i++) {
            if (precedent[i] != consequent[i])
                return precedent[i] - consequent[i];
        }

        if ( precedent.length != consequent.length)
            return precedent.length - consequent.length;

        return 0;


        /*
        //value checkers
        for (int i = 0; i < shorterQuery; i++) {

            if (consequent[i] == precedent[i])
                continue;

            if (consequent[i] > precedent[i])
                return -1;

            if (consequent[i] < precedent[i])
                return 1;

        }//end of query checker


        if (consequent.length < precedent.length)
            return -1;

        else if (consequent.length > precedent.length)
            return 1;

        else
            return 0;

         */
    }





    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        String output = this.weight + "\t" + this.query;


        return output;
    }




    //INTERNALS
    //is this worth implementing????
    /*
    private int queryCheck(Term precedent, Term consequent) {

        return 0;
    } */


    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[7];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        terms[5] = new Term("Ell", 14);
        terms[6] = new Term("Trevor", 44);
        
        Arrays.sort(terms);

        StdOut.println("Sort by lexigraphical order");
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("\nSort by Reverse Weight");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("\nSort by prefixOrder of 1");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }
}