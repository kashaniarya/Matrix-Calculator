# Matrix-Calculator
Coded in Java, a calculator for performing matrix operations that exploits the (expected) sparseness of it’s matrix operands

Arya Kashani
kashaniarya@gmail.com
UCSC ~ cmps101
pa3

Files Committed:
Sparse.java
Matrix.java
List.java
MatrixTest.java
ListTest.java
Makefile
README

Brief Description of role of each file in project:
An n n square matrix is said to be sparse if the number of non-zero entries (abbreviated NNZ) 
is small compared to the total number of entries, 𝑛2. The result will be a Java program capable 
of performing fast matrix operations, even on very large matrices, provided they are sparse.
 The top level client module for this project will be called Sparse.java. It will take two 
 command line arguments giving the names of the input and output files, respectively. 
 The input file will begin with a single line containing three integers n, a, and b, separated by spaces. 
 The second line will be blank, and the following a lines will specify the non-zero entries of an n n matrix A. 
 Each of these lines will contain a space separated list of three numbers: two integers and a double, 
 giving the row, column, and value of the corresponding matrix entry. After another blank line, 
 will follow b lines specifying the non-zero entries of an n n matrix B.
