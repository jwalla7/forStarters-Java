# ADTs
Abstract Data Types are also known as ADTs. Two types of ADTs include Stacks, Queues, and Deques.
<br>
<br>
Stacks, Queues, and Deques are limited by their ADT operations.
<br>
<br>
Stacks, Queues, and Deques are not ideal for accessing or searching because they are designed to only reach the data that is immediately accessible by the remove operation.
## Queues
FIFO Model - (First In, First Out)
## Priority Queues

## Deques

## Stacks
LIFO Model - (Last In, First Out)
<p>
Stacks are Linear ADTs. They can be implemented with or backed by various data structures such as Arrays or some type of LinkedList.
</p>

## Binary Tree
Binary Trees are trees with a shape restriction. This restriction allows each node to have at most two children.
<br>
1. At most 2 children
2. Children are labeled left and right.
3. Left child precedes right child.
#### Nodes in a Binary Tree can store:
1. a reference to it's parent
2. the node's depth in the tree.
3. the node's height in the tree.
### Binary Search trees
Binary Search Trees are a subclass of Binary Trees that: 
<br> 
1. Impose an order property. 
   1. left child data is less than direct parent data
   2. right child data is larger than (sibling) left child data, and larger than it's direct parent data.
   3. All data in a (root/subtree root) node's left subtree must be less than the data in the (root/subtree root) node.
   4. All data in a (root/subtree root) node's right subtree must be greater than the data in the (root/subtree root) node.
