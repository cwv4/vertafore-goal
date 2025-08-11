/*
 *  Copyright 2025 Vertafore, Inc.   All rights reserved.
 *
 *  Disclaimers:
 *   This software is provided "as is," without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and non-infringement.  This source code
 *   should not be relied upon as the sole basis for solving a problem whose
 *   incorrect solution could result in injury to person or property. In no
 *   event shall the author or contributors be held liable for any damages
 *   arising in any way from the use of this software. The entire risk as to the
 *   results and performance of this source code is assumed by the user.
 *
 *   Permission is granted to use this software for internal use only, subject
 *   to the following restrictions:
 *     1.  This source code MUST retain the above copyright notice, disclaimer,
 *         and this list of conditions.
 *     2.  This source code may be used ONLY within the scope of the original
 *         agreement under which this source code was provided and may not be
 *         distributed to any third party without the express written consent of
 *         Vertafore, Inc.
 *     3.  This source code along with all obligations and rights under the
 *         original License Agreement may not be assigned to any third party
 *         without the expressed written consent of Vertafore, Inc., except that
 *         assignment may be made to a  successor to the business or
 *         substantially all of its assets. All parties bind their successors,
 *         executors, administrators, and assignees to all covenants of this
 *         Agreement.
 *
 *   All advertising materials mentioning features or use of this software must
 *   display the following acknowledgment:
 *
 *     Trademark Disclaimer:
 *     All patent, copyright, trademark and other intellectual property rights
 *     included in the source code are owned exclusively by Vertafore, Inc.
 */

package com.vertafore.todelete.model;

import jakarta.ws.rs.core.StreamingOutput;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MyPrinter {
    
    private String message1;
    private String message2;

    public static MyPrinterBuilder builder() {
        return new MyPrinterBuilder();
    }

    public void printMessages() {
        System.out.println(message1 + " " + message2);
    }

    public StreamingOutput getStreamingOutputMessage() {
        String finalMessage = message1 + " " + message2;

        return os -> {
            os.write(finalMessage.getBytes(StandardCharsets.UTF_8));
            os.flush();
        };
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPrinter myPrinter = (MyPrinter) o;
        return Objects.equals(message1, myPrinter.message1) && Objects.equals(message2, myPrinter.message2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message1, message2);
    }

    @Override
    public String toString() {
        return "MyPrinter{" +
                "message1='" + message1 + '\'' +
                ", message2='" + message2 + '\'' +
                '}';
    }
    
    public static class MyPrinterBuilder {
        private String message1;
        private String message2;
        
        public MyPrinterBuilder message1(String message1) {
            this.message1 = message1;
            return this;
        }
        
        public MyPrinterBuilder message2(String message2) {
            this.message2 = message2;
            return this;
        }
        
        public MyPrinter build() {
            MyPrinter myPrinter = new MyPrinter();
            myPrinter.setMessage1(message1);
            myPrinter.setMessage2(message2);
            return myPrinter;
        }
    }
}
