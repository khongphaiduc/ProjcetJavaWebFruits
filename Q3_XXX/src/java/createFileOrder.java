
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class createFileOrder {

    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return now.format(formatter);
    }

    public static void writeToFile(String fileName, String content) {
        String storagpath = "D:\\OrderFruits";  // Sửa lỗi đánh vần "Fruis" -> "Fruits"

        try {
            // Tạo thư mục nếu chưa tồn tại
            File directory = new File(storagpath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Ghi file với UTF-8
            File file = new File(storagpath + File.separator + fileName);
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8))) {
                writer.write(content);
            }

            System.out.println("Ghi vào tệp thành công: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp: " + e.getMessage());
        }
    }



// tìm file và đọc nội dung
public static String findAndReadFileContent(String fileName) {
        String storagpath = "D:\\OrderFruis";
        File directory = new File(storagpath);

        // Kiểm tra thư mục tồn tại
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Thư mục không tồn tại: " + storagpath);
            return null;
        }

        // Lấy danh sách các file trong thư mụcc
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Tìm thấy tệp: " + file.getAbsolutePath());
                    try {
                        // Đọc nội dung của file
                        String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
                        return content;
                    } catch (IOException e) {
                        System.out.println("Lỗi khi đọc file: " + e.getMessage());
                    }
                }
            }
        }

        System.out.println("Không tìm thấy tệp: " + fileName);
        return null;
    }
    
    
    public static void main(String[] args) {
        // Đường dẫn thư mục
        String folderPath = "C:\\Users\\Public\\MyFiles";  // Thay đổi đường dẫn theo ý muốn

        // Tên file và nội dung
        String fileName = "example.txt";
        String content = "Xin chào! Đây là nội dung của tệp.";

        // Ghi vào file
        createFileOrder s = new createFileOrder();
        s.writeToFile(s.getCurrentTime(), "anh đức anh test");
    }

}
