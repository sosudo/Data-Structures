# Assignment: Baby's First Database
Start writing a generic class, called BST (short for binary search tree) that stores and operates on binary search trees. The class should be able to store any data type that implements compareTo().
Class Name: BST <T>
Methods:
void insert(T insertMe) – insert object insertMe into the current tree (if the tree is empty, it becomes the root)
void inOrderPrint() – prints the whole tree in in-order traversal order – USE PRINTLN – each element on its own line
boolean exists(T checkMe) – returns true if an element in the BST is equivalent to checkMe; returns false otherwise.
Other Conditions:
Your “node” class MUST be an nested class within BST. (Look at the canonical stack for syntax info!)
