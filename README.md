Assignment #2: AutoComplete
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Stubs provided by Travis Wheeler, Doug Brinkerhoff

Implementation done by Jacob Olson
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Write a program to implement autocomplete for a given set of N terms, 
where a term is a query string and an associated nonnegative weight. 
That is, given a prefix, find all queries that start with the given prefix, 
in descending order of weight.

Given an input file of terms, and their associated weight, write a program that
reads a prefix, and outputs the X top terms based off of lexigraphical order,
followed by reverse weight order.

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


Term.java API

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight)

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder()

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r)

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that)

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString()

    // unit testing (you should have some Unit Testing here to confirm that your methods work)
    public static void main(String[] args)

    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


BinarySearchDeluxe.java API

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)

    // unit testing (you should have some Unit Testing here to confirm that your methods work)
    public static void main(String[] args)
    
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    
AutoComplete.java API

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms)

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) //return an empty array if no matches

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)
    
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
