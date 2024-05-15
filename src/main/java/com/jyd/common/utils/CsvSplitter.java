package com.jyd.common.utils;

import java.io.*;

public class CsvSplitter {

    public static void splitCSVByLine(String inputFileName, String outputPrefix, int linesPerFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            int fileNumber = 1;
            int lineCount = 0;

            // 创建第一个输出文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPrefix + "_" + fileNumber + ".csv"));

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                lineCount++;

                // 如果达到了指定的行数，则关闭当前输出文件，创建新的输出文件
                if (lineCount >= linesPerFile) {
                    writer.close();
                    fileNumber++;
                    writer = new BufferedWriter(new FileWriter(outputPrefix + "_" + fileNumber + ".csv"));
                    lineCount = 0;
                }
            }

            // 关闭最后一个输出文件
            writer.close();
        }
    }

    public static void main(String[] args) {
        String inputFileName = "D:\\zbdata\\t_sales_info453543.csv"; // 输入文件名
        String outputPrefix = "D:\\zbdata\\outputFile";

        int linesPerFile = 100000; // 每个输出文件的行数

        try {
            splitCSVByLine(inputFileName, outputPrefix, linesPerFile);
            System.out.println("CSV 文件已成功按行数分割。");
        } catch (IOException e) {
            System.err.println("分割 CSV 文件时出现错误：" + e.getMessage());
        }
    }
}
