/******************************************************************************
 *  Name: Jacob Olson
 *
 *  Hours to complete assignment (optional): alot
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

In most simplest way to describe the methodology, all it does is use the binary
search that we are all familiar with, except instead of looking for a singular
value and returning it, its looking for a value that has a different value pre-
ceeding it within the data structure. Knowing the value its pointing at isnt
enough to determine if its what im looking for, it needs to look at the value
prior to it as well.

lastIndexOf() follows this philosophy, but instead looks ahead by 1 position,
rather than behind by 1.



/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor:
O( n * logn)

allMatches():
O( m * logn )

numberOfMatches():
O( logn ) I believe? It only binary searches twice, which is Log n...



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Searching for all values takes two return carriages instead of one. Unsure as to
why this is the case. Maybe something to do with number of characters a return
carriage actually is? No idea.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/

Briefly explained to my brother (Daniel Olson) of what the assignment was, and
after explaining the first two parts and minimally described what the assignment
as a whole was, he correctly inferred what the third part of the assignment was,
as well as inferring what my methodology was for implementation. Although he was
interested in knowing what it was I was working on, I didn't get any benefitting
knowledge towards this assignment from my discussion with him.

Outside of this, a quick read on a simplified implementation of binary searching,
and briefly inquiring my peer's progress, I worked on this assignment completely
independently.


/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/

Binary Searching was troublesome to implement without recursion and to specifically
spot the first and last indexes, without getting stack over/under-flow.


Terms had a small bug relating to comparing objects of different lengths, but I
managed to (as far as I know) resolve the issue after discovering it in the 3rd
part.

I for some reason set autocomplete searching to look for first index twice,
instead of looking for the first index and the last, which resulted in some
headscratches.

By the end of the assignment's due date, I realized with Term's toString
function, I was supposed to supply a raw string that contained the weight AND
the query, rather than returning the weight followed by the query, each in their
raw data types.

I was also really confused why the reverse weight sort methodology was outputing
the results in reverse weight rather than by weight (that was not a good day for
me).


Manipulation of "comparators" also still escapes me

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/

This assignment was not quite as "fun" as the previous one, but I suspect this
one is significantly more applicable, perhaps even useful. It did present more
confusing bugs and errors that I definitely had a harder time with.

I feel like I should have learned alot more about comparators than what I do
actually know.


