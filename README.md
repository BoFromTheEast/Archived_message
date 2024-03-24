Archived Message Reconstruction
## Purpose
The objective of this project is to reconstruct/unzip a message archived with a binary-tree-
based algorithm. The program would ask for a single filename at the start: "Please
enter filename to decode: ", decode the message in the file and print it out to the
console. The name of the compressed message file will end in .arch, e.g. “monalisa.arch”.
The file consists of two or three lines: the first one or two lines contain the encoding
scheme, and the second or third line contains the archived message.

## Encoding
The archival algorithm uses a binary tree. The edges of the tree represent bits, and the leaf
nodes contain one character each. Internal nodes are empty. An edge to a left child
always represents a 0, and an edge to a right child always represents a 1. The sequence of bits encodes characters along a path from the root to a particular leaf. <br>
![Screenshot 2024-03-24 034024](https://github.com/BoFromTheEast/Archived_message/assets/116685199/1f1b372b-8740-4b60-90b5-f2125d5d97d3)<br>


## Examples

 Prev:<br>
![Screenshot 2024-03-24 041630](https://github.com/BoFromTheEast/Archived_message/assets/116685199/2dc5dfb7-b233-4ba6-8292-9be7a891fce0)<br>

 After:<br>
![Screenshot 2024-03-24 041552](https://github.com/BoFromTheEast/Archived_message/assets/116685199/3dfc4fe4-6b31-4ebd-a218-a7ab1fa1aa66)



## Input Format
The archive file consists of two lines: the first line contains the encoding scheme, and
the second line contains the compressed string. For ease of development and to make the
archive file human-readable, each bit is represented as the character ‘0’ or ‘1’, rather
than as an actual bit from a binary file.
The encoding scheme can be represented as a string. For example, the tree from section 2
can be represented as:
^a^^!^dc^rb
where ^ indicates an internal node. The above code represents a preorder traversal of
the tree.
The cadbard! message is encoded in the following file (“cadbard.arch”):
^a^^!^dc^rb
10110101011101101010100
