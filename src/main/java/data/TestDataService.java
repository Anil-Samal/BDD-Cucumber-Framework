package data;

import testdata.TestDataManager;
import utils.ExcelUtil;

public class TestDataService {


    private final ExcelDataSource excelDataSource;



    public TestDataService() {


        TestDataManager manager =
                new TestDataManager(
                        new ExcelUtil("LoginData.xlsx")
                );


        excelDataSource =
                new ExcelDataSource(manager);

    }



    public LoginData getLoginData(String testCaseId) {


        return excelDataSource
                .getLoginData(testCaseId);

    }

}