package reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getInstance() {

        if (extent == null) {

            String timestamp =
                    LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String reportPath =
                    "test-output/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setReportName("BDD Cucumber Automation Report");

            spark.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Selenium BDD");

            extent.setSystemInfo("Language", "Java 21");

            extent.setSystemInfo("Automation", "Selenium 4");

            extent.setSystemInfo("Build Tool", "Maven");

            extent.setSystemInfo("Tester", "Anil Samal");

            extent.setSystemInfo(
                    "Operating System",
                    System.getProperty("os.name"));

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version"));

        }

        return extent;
    }
}