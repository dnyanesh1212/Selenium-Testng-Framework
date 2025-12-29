package dataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProviderUtils {

    private DataProviderUtils() {}

    @DataProvider(name = "testData")
    public static Object[][] getData(Method method) {

        String testClassName =
                method.getDeclaringClass().getSimpleName();

        List<Map<String, String>> allData =
                ExcelUtils.getTestData("Test Data");

        List<Map<String, String>> filteredData =
                allData.stream()
                        .filter(data ->
                                data.get("ClassName")
                                        .equalsIgnoreCase(testClassName))
                        .collect(Collectors.toList());

        Object[][] result = new Object[filteredData.size()][1];

        for (int i = 0; i < filteredData.size(); i++) {
            result[i][0] = filteredData.get(i);
        }

        return result;
    }
}
