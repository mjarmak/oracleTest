// Create new int[] variable reference and assign it intArray
int[] intArray2 = intArray;
 
// Create new Integer[] variable reference and assign it intArray
Integer[] integerArray2 = integerArray;
 
System.out.println("\n---------- Final Values -----------");
 
// Arrays.toString() prints elements as comma delimited String
System.out.println("intArray = "
        + Arrays.toString(intArray));
System.out.println("integerArray ="
        + Arrays.toString(integerArray));
 
System.out.println("\n---------- Print Arrays -----------");
 
// Printing the array references confirm that these variables
// reference the same set of elements
System.out.println("intArray = " + intArray);
System.out.println("intArray2 = " + intArray2);
System.out.println("integerArray = " + integerArray);
System.out.println("integerArray2 = " + integerArray2);
 
// Make a change to data on first array references
integerArray[0] = 55;
intArray[0] = 66;
 
// Make a change to data on second array references
integerArray2[1] = 77;
intArray2[1] = 88;
 
System.out.println("\n-------- Print Array Values ---------");
 
// You can see both references show the data changes
System.out.println("integerArray = " +
        Arrays.toString(integerArray));
System.out.println("integerArray2 = " +
        Arrays.toString(integerArray2));
System.out.println("intArray = " + Arrays.toString(intArray));
System.out.println("intArray2 = " + Arrays.toString(intArray2));