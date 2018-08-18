package base.tools;

import java.util.Scanner;


public class InputCommandReaderImpl implements InputCommandReader {

    @Override
    public String getInputCommand(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

