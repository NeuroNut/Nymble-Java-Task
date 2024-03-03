package com.travel.travel;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleOutputCapture {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    public void startCapture() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public void stopCapture() {
        System.setOut(standardOut);
    }

    public String getCapturedOutput() {
        return outputStreamCaptor.toString().trim();
    }

    public String captureConsoleOutput(Runnable block) {
        startCapture();
        block.run();
        stopCapture();
        return getCapturedOutput();
    }
}
