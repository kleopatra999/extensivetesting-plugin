/**
 * The MIT License

 Copyright (c) 2016, Gfi Informatique, Inc., Blaise Cador

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */
package xtc.jenkins.extensiveTesting.Tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hasher {


    /**
     * Hash a string using sha1.
     *
     * @param input String to hash.
     * @return hashed string.
     */
    public static String sha1(String input) {
        StringBuffer stringBuffer = null;
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(input.getBytes());
            stringBuffer = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                stringBuffer.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
        }catch (NoSuchAlgorithmException e){
            System.out.println(e);
        }finally {
            return stringBuffer.toString();
        }
    }
}
