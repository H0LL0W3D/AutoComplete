import java.util.Arrays;

public class Autocomplete {

    private final Term[] array;


    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        array = new Term[terms.length];

        Arrays.sort(terms);

        for (int i = 0; i < terms.length; i++)
            array[i] = terms[i];


        /*
        //double check to make sure everything works
        for (int i = 0; i < terms.length; i++)
            System.out.println(terms[i] + " " + i);
         */

    }




    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {

        Term searchTerm = new Term(prefix, prefix.length());

        int lowerBound = BinarySearchDeluxe.firstIndexOf(array, searchTerm, Term.byPrefixOrder(prefix.length()) );
        int upperBound = BinarySearchDeluxe.lastIndexOf(array, searchTerm, Term.byPrefixOrder(prefix.length()) );
        int searchLength = upperBound - lowerBound;



        //build the search results
        Term[] searchResultsReversed = new Term[searchLength];
        for (int i = 0; i < searchLength; i++)
            searchResultsReversed[i] = array[lowerBound + i];


        /* error checking
        for (int i = 0; i < searchLength; i++)
            System.out.println(searchResultsReversed[i] + " " + i);
         */

        //sorts based off of REVERSE weight
        Arrays.sort(searchResultsReversed, Term.byReverseWeightOrder());

        Term[] searchResults = new Term[searchLength];

        for (int i = 0; i < searchLength; i++)
            searchResults[i] = searchResultsReversed[searchLength - i - 1];



        return searchResults;
    }




    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        int searchLength;
        Term searchTerm = new Term(prefix, prefix.length() );

        int lowerBound = BinarySearchDeluxe.firstIndexOf(array, searchTerm, Term.byPrefixOrder(prefix.length()) );
        int upperBound = BinarySearchDeluxe.lastIndexOf(array, searchTerm, Term.byPrefixOrder(prefix.length()) );
        searchLength = upperBound - lowerBound + 1;

        return searchLength;
    }
    





    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);

        StdOut.print("Top " + k + " results\n");

        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}