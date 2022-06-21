package com.xy124.templatecallback.callculate;

import com.xy124.templatecallback.callculate.template.BufferedReaderCallback;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Calculator {

    public Integer calcSum(String filePath) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            Integer sum = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.valueOf(line);

            }
            return sum;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }

    /**
     * 객체지향의 대한
     *
     * @param filePath
     * @param callback
     * @return
     */
    public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            int ret = callback.doSomethingWithReader(br);
            return ret;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Integer calcSumWithTemplate(String filePath) throws IOException {
        BufferedReaderCallback sumCallback =
                new BufferedReaderCallback() {
                    @Override
                    public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                        Integer sum = 0;
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            sum += Integer.valueOf(line);

                        }

                        return sum;
                    }
                };
        return fileReadTemplate(filePath, sumCallback);

    }

    public Integer calcMultiWithTemplate(String filePath) throws IOException {
        BufferedReaderCallback multiCallback =
                new BufferedReaderCallback() {
                    @Override
                    public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                        Integer sum = 1;
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            sum *= Integer.valueOf(line);
                        }
                        return sum;
                    }
                };
        return fileReadTemplate(filePath,multiCallback);
    }
}
