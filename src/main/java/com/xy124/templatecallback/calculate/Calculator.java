package com.xy124.templatecallback.calculate;

import com.xy124.templatecallback.calculate.template.BufferedReaderCallback;
import com.xy124.templatecallback.calculate.template.LineCallback;

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
    private Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {

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
                        Integer calculateResult = 0;
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            calculateResult += Integer.valueOf(line);

                        }

                        return calculateResult;
                    }
                };
        return fileReadTemplate(filePath, sumCallback);

    }

    public Integer calcMultiWithTemplate(String filePath) throws IOException {
        BufferedReaderCallback multiCallback =
                new BufferedReaderCallback() {
                    @Override
                    public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                        Integer calculateResult = 1;
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            calculateResult *= Integer.valueOf(line);
                        }
                        return calculateResult;
                    }
                };
        return fileReadTemplate(filePath, multiCallback);
    }



    private Integer lineReadTemplate(String filePath, LineCallback lineCallback, Integer initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = null;
            Integer calculateResult = initVal;
            while ((line = br.readLine()) != null) {
                calculateResult = lineCallback.doSomethingWithLine(line, calculateResult);
            }
            return calculateResult;
        } catch (IOException e) {
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

    public Integer calcSumWithLineCallback(String filePath) throws IOException {
        LineCallback lineCallback =new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer calculateResult) throws IOException {
                return calculateResult += Integer.valueOf(line);
            }

        };
        return lineReadTemplate(filePath,lineCallback,0);
    }

    public Integer calcMultiWithLineCallback(String filePath) throws IOException {
        LineCallback lineCallback =new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer calculateResult) throws IOException {
                return calculateResult *= Integer.valueOf(line);
            }

        };
        return lineReadTemplate(filePath,lineCallback,1);
    }



}
