package yuyu.app.base.ref;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 入力の業務データ取得のクラスです。<br />
 * WEBサービス機能の入力項目「業務データ」が単体テスト仕様書（Execl）側で編集するので、
 * テストケース実行時、業務データをExcelから取得する用機能です。<br />
 */
public class GetInputGyoumuData {

    @Inject
    private static Logger logger = SWAKInjector.getInstance(Logger.class);


    @SuppressWarnings("resource")
    public  Map<String, String> getGyoumuDataMap(Class<?> pTestObjClass, String pFileName, String pRequestSheetName) throws Exception {

        logger.debug("｜ ▽ 業務データ情報取得処理開始  ファイル名前 = " + pFileName + " シート名前 = " + pRequestSheetName);

        Map<String, String> gyoumuDataMap = new HashMap<String, String>();

        FileInputStream inputStream = null;

        String packageName = pTestObjClass.getPackage().getName();
        String fliePath = pTestObjClass.getResource("/").getPath();
        fliePath = fliePath.substring(1);
        fliePath = fliePath.replace("target/test-classes/", "").replace("/", "\\");
        String fileFullName = fliePath + "src\\test\\java\\" + packageName.replace(".", "\\") + "\\" + pFileName + ".xlsx";

        try {
            inputStream = new FileInputStream(new File(fileFullName));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet(pRequestSheetName);

            if(sheet == null){
                throw new TestDataMakerException(
                    "リクエストデータのシート名間違った リクエストデータシート名 = " + pRequestSheetName);
            }

            XSSFRow currentKey = sheet.getRow(10);
            XSSFRow currentVal = sheet.getRow(1);

            for (int index = 8; index <= 16384; index++) {

                XSSFCell cell = currentKey.getCell(index);

                if (cell != null) {
                    String key = cell.getStringCellValue();

                    if (!"end".equals(key) && !BizUtil.isBlank(key)) {
                        gyoumuDataMap.put(key, currentVal.getCell(index).getStringCellValue());
                    }
                    else if ("end".equals(key)) {
                        break;
                    }
                }
                else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new TestDataMakerException("当該ファイルが存在しません。fileName = " + fileFullName,e);

        } catch (IOException e) {
            throw new TestDataMakerException("当該ファイルが実例化できません。fileName = " + fileFullName,e);

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new TestDataMakerException("当該ファイルが閉めできません。fileName = " + fileFullName,e);
                }
            }
        }

        logger.debug("｜ △ 業務データ情報取得処理終了  ファイル名前 = " + pFileName + " シート名前 = " + pRequestSheetName);

        return gyoumuDataMap;
    }
}
