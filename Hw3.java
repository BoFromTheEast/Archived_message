package Hw3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Hw3 class is the entry point of the program for decoding an encoded message.
 * It reads the input file, constructs the Huffman tree, decodes the message, and prints the results.
 * @author bohte
 */
public class Hw3 {
    /**
     * The main method is the entry point of the program.
     *
     * @param args The command-line arguments (not used).
     * @throws FileNotFoundException If the input file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        double avgofBits;
        double calculations;
        String codeMsg = "";
        String archived = null;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input the file name to decode: ");
            String filename = scanner.nextLine();
            scanner.close();
            
            
            File file = new File(filename);
            //I had trouble with scanning the file as the file could not be found even though it was in the directory
            // it will only work when the absolute path is given
            
            
//            File file = new File("C:\\Users\\bohte\\OneDrive\\Desktop\\Workspace\\HW3\\src\\Hw3\\constitution.arch");

            Scanner fileScan = new Scanner(file);
            Scanner fileCheck = new Scanner(file);

            // Read the encoded message from the file
            while (fileCheck.hasNextLine() && fileCheck.nextLine().contains("^")) {
                codeMsg += fileScan.nextLine();
                codeMsg += "\n";
            }
            fileCheck.close();

            // Read the archived message from the file
            archived = fileScan.nextLine();
            fileScan.close();
        } catch (Exception E) {
            System.out.println("File not found please check again.");
            E.printStackTrace();
        }

        // Construct the Huffman tree
        MsgTree tree = new MsgTree(codeMsg);

        System.out.println("character code");
        System.out.println("-------------------------");

        // Print the character codes
        MsgTree.printCodes(tree, "");

        System.out.println();
        System.out.println("MESSAGE: ");

        // Decode and print the message
        tree.decode(tree, archived);

        System.out.println();
        System.out.println();
        System.out.println("STATISTICS: ");

        // Calculate and print the statistics
        avgofBits = (1.0 * archived.length()) / tree.getNumChar();
        System.out.printf("Avg bits/char:        %.1f", avgofBits);
        System.out.println();
        System.out.println("Total characters:     " + tree.getNumChar());

        calculations = (1.0 - (avgofBits / 16.0)) * 100.0;
        System.out.printf("Space savings:        %.1f", calculations);
        System.out.println("%");
    }
}