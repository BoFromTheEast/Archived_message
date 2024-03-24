package Hw3;

/**
 * The MsgTree class represents a node in a Huffman tree used for message encoding and decoding.
 * Each node can either be a non-leaf node (internal node) or a leaf node (representing a character).
 * @author bohte
 */
public class MsgTree {

	public char payloadChar;
	public MsgTree left;
	public MsgTree right;
	private static int staticCharIdx = 0;
	private static int numChar = 0;
	

	/**
     * Constructs a MsgTree object from an encodingString.
     *
     * @param encodingString The string representation of the tree structure and character encodings.
     *                       Each character represents a node, and '^' represents a non-leaf node.
     */
    public MsgTree(String encodingString) {
        if (encodingString.charAt(staticCharIdx) == '^') {
            staticCharIdx++;
            left = new MsgTree(encodingString);
            right = new MsgTree(encodingString);
        } else {
            payloadChar = encodingString.charAt(staticCharIdx);
            staticCharIdx++;
        }
    }

    /**
     * Constructs a MsgTree object representing a leaf node with the given payload character.
     *
     * @param payloadChar The character payload of the leaf node.
     */
    public MsgTree(char payloadChar) {
        this.left = null;
        this.right = null;
        this.payloadChar = payloadChar;
    }

    /**
     * Recursively prints the character codes of the Huffman tree.
     *
     * @param root The root of the Huffman tree.
     * @param code The current code string representing the path from the root to a character.
     */
    public static void printCodes(MsgTree root, String code) {
        if (root == null) {
            return;
        }

        if (root.payloadChar != '^' && root.payloadChar != '\0') {
            if (root.payloadChar == '\n') {
                String newLine = "\\n";
                System.out.println("   " + newLine + "     " + code);
            } else {
                System.out.println("   " + root.payloadChar + "      " + code);
            }
        }

        if (root.left != null) {
            printCodes(root.left, code + "0");
        }

        if (root.right != null) {
            printCodes(root.right, code + "1");
        }
    }

    /**
     * Decodes the given message using the provided Huffman tree.
     * Prints the decoded message to the console.
     *
     * @param codes The root of the Huffman tree.
     * @param msg   The encoded message to be decoded.
     */
    public void decode(MsgTree codes, String msg) {
        MsgTree tempTree = codes;
        int msgLength = msg.length();

        int i = 0;
        while (i < msgLength) {
            while (i < msgLength && tempTree.left != null && tempTree.right != null) {
                if (msg.charAt(i) == '0') {
                    tempTree = tempTree.left;
                } else if (msg.charAt(i) == '1') {
                    tempTree = tempTree.right;
                }
                i++;
            }
            if (tempTree.left != null || tempTree.right != null) {
                System.out.println("Incomplete code at the end of the message.");
                return;
            }
            System.out.print(tempTree.payloadChar);
            tempTree = codes;
            numChar++;
        }
    }

    /**
     * Returns the total number of characters encountered during decoding.
     *
     * @return The total number of characters encountered during decoding.
     */
    public int getNumChar() {
        return numChar;
    }
}