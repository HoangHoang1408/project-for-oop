package com.company.TestManager;

import com.company.BaseURL;
import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// chứa các thuộc tính và phương thức cần cho 1 test để chạy (các class test khác phải kế thừa class này)
public abstract class Test {
    protected String apiName;
    protected BaseURL baseURL;
    protected String fullURLString; //nên lưu ý thuộc tính này để gửi request nếu url cần phải bổ sung thêm route nhỏ (giá trị ví dụ: https://auctions-app-2.herokuapp.com/api/login)
    protected ArrayList<UnitTest> unitTests;

    public Test(BaseURL baseURL, String apiName) {
        this.baseURL = baseURL;
        this.apiName = apiName;
        this.fullURLString = baseURL.getBaseURL() + '/' + apiName;
        this.unitTests = new ArrayList<>();
    }


    protected void startTest() throws IOException {
        initUnitTests();
        introduceUnitTests();
        if (this.unitTests.size() <= 0) {
            System.out.println(ANSI.YELLOW + "This api has no test" + ANSI.RESET);
            return;
        }
        executeUnitTests();
    }

    //  phương thức này phải đc ghi đề ở class con
    protected void initUnitTests() {
    }

    private void introduceUnitTests() {
        if (unitTests.size() <= 0) return;
        System.out.print(ANSI.YELLOW);
        System.out.println("\nUnit tests for " + this.apiName + ": ");
        for (int i = 0; i < unitTests.size(); i++) {
            System.out.println("Unit test " + (i + 1) + ": " + unitTests.get(i).getExpectation());
        }
        System.out.println(ANSI.RESET);
    }

    private void executeUnitTests() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> chosenUnitTests = new ArrayList<>();
        System.out.println("Input unit tests to start testing (end with -1):");
        while (scanner.hasNextInt()) {
            String input = scanner.next();
            if (input.equals("-1")) break;
            int temp = Integer.parseInt(input);
            if (temp > this.unitTests.size()) {
                System.out.println("Invalid unit test id");
                continue;
            }
            chosenUnitTests.add(temp);
        }
        System.out.println(ANSI.YELLOW + "\nTesting for " + this.apiName + " api..." + ANSI.RESET);
        int totalTestsPassed = 0;
        for (int testId : chosenUnitTests) {
            boolean passed = this.unitTests.get(testId - 1).startUnitTest();
            if (passed) totalTestsPassed += 1;
        }
        String color = totalTestsPassed == chosenUnitTests.size() ? ANSI.GREEN : ANSI.RED;
        System.out.println("\n" + color + "Finished: " + totalTestsPassed + "/" + chosenUnitTests.size() + " tests passed!" + ANSI.RESET);
    }

    public String getFullURLString() {
        return fullURLString;
    }
}