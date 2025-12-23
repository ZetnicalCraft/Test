package com.guatedroid;

import com.vaadin.ui.Upload;
import java.io.IOException;
import java.io.OutputStream;

public class LineBreakCounter implements Upload.Receiver {
    private int counter;
    private int total;
    private boolean sleep;
    private String todoElTexto = "";

    /**
     * return an OutputStream that simply counts lineends
     */
    @Override
    public OutputStream receiveUpload(final String filename, final String MIMEType) {
        counter = 0;
        total = 0;

        OutputStream output = new OutputStream()
        {
            private static final int searchedByte = '\n';
            private StringBuilder string = new StringBuilder();
            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b );
                todoElTexto = toString();
                total++;
                if (b == searchedByte) {
                    counter++;
                }
                if (sleep && total % 1000 == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Netbeans IDE automatically overrides this toString()
            public String toString(){
                return this.string.toString();
            }

        };
        return output;/*6
        return new OutputStream() {
            private static final int searchedByte = '\n';
            @Override
            public void write(final int b) {
                total++;
                if (b == searchedByte) {
                    counter++;
                }
                if (sleep && total % 1000 == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String bst = Integer.toString(b);
                String[] arrbst = bst.split("\n");
                System.out.println(Integer.toString(b));
            }
        };*/

    }

    public int getLineBreakCount() {
        return counter+1;
    }

    public String getTodoElTexto(){
        return todoElTexto;
    }
    public void setSlow(boolean value) {
        sleep = value;
    }
}