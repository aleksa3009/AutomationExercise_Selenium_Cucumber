package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get(filePath).getParent());
            Files.copy(screenshot.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
