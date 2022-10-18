package jy.common;


import static javax.xml.bind.JAXBIntrospector.getValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
    public static void main(String[] args) {
        doExcelTest();

    }

    private static void doExcelTest() {
        try {
            String filePath = "D:\\ProGramFiles\\wecaht\\Files\\WeChat Files\\wxid_k8dlitw372h222\\FileStorage\\File\\2022-09\\1.xlsx";
            XSSFWorkbook xwb = new XSSFWorkbook(filePath);
            //循环工作表sheet
            Map<String, Integer> map = new HashMap<String, Integer>();
            // 名字单独计数
            Map<String, Integer> aloneMap = new HashMap<String, Integer>();
            for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
                XSSFSheet xSheet = xwb.getSheetAt(numSheet);
                if (xSheet == null) {
                    continue;
                }
                //循环行row
                for (int numRow = 1; numRow <= xSheet.getLastRowNum(); numRow++) {
                    XSSFRow xRow = xSheet.getRow(numRow);
                    if (xRow == null) {
                        continue;
                    }
                    //循环列cell
//                    for (int numCell = 0; numCell <= xRow.getLastCellNum(); numCell++) {
//                        XSSFCell xCell = xRow.getCell(numCell);
//                        if (xCell == null) {
//                            continue;
//                        }
//                        //输出值
//                        System.out.println("excel表格中取出的数据" + getValue(xCell));
//                    }
                    // 取第三列 numCell=2
                    XSSFCell xCell = xRow.getCell(2);
                    if (xCell == null) {
                        continue;
                    } else {
                        String cellValue = String.valueOf(getValue(xCell)).trim();
                        if (map.get(cellValue) != null && !"".equals(cellValue)) {
                            map.put(cellValue, map.get(cellValue) + 1);
                        } else {
                            map.put(cellValue, 1);
                        }
                        String[] cellValueArray = cellValue.split(",");
                        for (int i = 0; i < cellValueArray.length; i++) {
                            String aloneCellValue = cellValueArray[i];
                            if (aloneMap.get(aloneCellValue) != null && !"".equals(aloneCellValue)) {
                                aloneMap.put(aloneCellValue, aloneMap.get(aloneCellValue) + 1);
                            } else {
                                aloneMap.put(aloneCellValue, 1);
                            }
                        }
                    }

                    //输出值
                    // System.out.println("excel表格中取出的数据: " + getValue(xCell));
                }
            }

            //利用Map的entrySet方法，转化为list进行排序
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(aloneMap.entrySet());
            //利用Collections的sort方法对list排序
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    //正序排列，倒序反过来
                    return o2.getValue() - o1.getValue();
                }
            });
            //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> e : entryList
            ) {
                linkedHashMap.put(e.getKey(), e.getValue());
            }

            for (Map.Entry entry : linkedHashMap.entrySet()) {
                System.out.println(entry.getKey() + "出现" + entry.getValue() + "次");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
