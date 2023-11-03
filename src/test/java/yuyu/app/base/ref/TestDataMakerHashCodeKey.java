package yuyu.app.base.ref;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * Junitテストデータの取扱のクラスです。
 */
public class TestDataMakerHashCodeKey {

    private static final int tableIdIndx = 3;
    private static final int dataNameIndx = 1;

    private static final int dataIdIndx = 0;
    @Inject
    private static Logger logger = SWAKInjector.getInstance(Logger.class);
    private boolean entitySyokikaFlag = false;


    public HashMap<Key, Map<Key, List<Map<Key, String>>>> getInData(Class<?> testObjClass, String fileName, String sheetName) throws TestDataMakerException {

        FileInputStream utDocumentIs = null;
        BufferedInputStream utDocumentBis = null;

        XSSFWorkbook utDocument = null;
        XSSFSheet dataSheet = null;

        System.gc();
        HashMap<Key, Map<Key, List<Map<Key, String>>>> testDataAndTblMap = new HashMap<Key, Map<Key, List<Map<Key, String>>>>();
        logger.debug("[ReflectTester]----- getInData()処理開始  ファイル名前 = " + fileName + "シート名前 = " + sheetName);
        String packageName = testObjClass.getPackage().getName();
        String fliePath = testObjClass.getResource("/").getPath();
        fliePath = fliePath.substring(1);
        fliePath = fliePath.replace("target/test-classes/", "").replace("/", "\\");

        String fileFullName = fliePath + "src\\test\\java\\" + packageName.replace(".", "\\") + "\\" + fileName + ".xlsx";
        logger.debug("ファイルPath = " + fileFullName );

        try {

            utDocumentIs = new FileInputStream(new File(fileFullName));
            utDocumentBis = new BufferedInputStream(utDocumentIs);

            if("D:\\develop\\reps\\bazaar\\ray-DL\\product\\sources\\application\\src\\test\\java\\yuyu\\common\\siharai\\siedittyouhyou\\UT_SP_単体テスト仕様書_ご提出書類について編集.xlsx".equals(fileFullName)){
                System.out.println("lalalal---------------------------" + sheetName);
            }

            utDocument = new XSSFWorkbook(utDocumentBis);

            dataSheet = utDocument.getSheet(sheetName);
            if(dataSheet == null){
                throw new TestDataMakerException("テストデータのシート名間違った テストデータシート名= " + sheetName);
            }
            String testDataName = "";
            String tableID;
            System.out.println(dataSheet.getLastRowNum());
            int biggestRow = dataSheet.getLastRowNum() + 1;
            HashMap<Key, List<Map<Key, String>>> tableIdAndContentMap = new HashMap<Key, List<Map<Key, String>>>();
            int currentLine = 0;

            System.gc();

            while (currentLine < biggestRow) {
                logger.debug("[ReflectTester]-----当該処理行目 = "+  currentLine);
                XSSFRow currentRow = dataSheet.getRow(currentLine);
                if (currentRow == null) {
                    currentLine++;
                    continue;
                }

                XSSFCell cellAValue = currentRow.getCell(dataIdIndx);

                if(cellAValue != null && "DEL".equals(cellAValue.getStringCellValue())){
                    currentLine ++;
                    continue;
                }
                if (cellAValue != null && cellAValue.toString().contains("データ") && !cellAValue.toString().contains("■INデータ")) {

                    if ("".equals(testDataName.trim()) && tableIdAndContentMap.size() > 0) {
                        throw new TestDataMakerException("テストデータIDをご記入ください。行目 = " + (currentLine+1));
                    }
                    if (!"".equals(testDataName)) {
                        testDataAndTblMap.put(new Key(testDataName), tableIdAndContentMap);
                        logger.debug("[ReflectTester]----- テストデータ読め済み テストデータID = " + testDataName + "テストデータ = " + tableIdAndContentMap);
                    }
                    testDataName = cellAValue.getStringCellValue();
                    tableIdAndContentMap = new HashMap<Key, List<Map<Key, String>>>();
                }

                XSSFCell cellBValue = currentRow.getCell(dataNameIndx);
                List<Map<Key, String>> tableRecordList = new ArrayList<Map<Key, String>>();
                if (cellBValue != null && cellBValue.toString().contains("■")) {
                    XSSFCell cellDValue = currentRow.getCell(tableIdIndx);

                    if (cellDValue != null) {
                        tableID = cellDValue.getStringCellValue();
                        currentLine = getTableContent(dataSheet, testDataName, tableID, currentLine,tableRecordList);
                        tableIdAndContentMap.put(new Key(tableID), tableRecordList);
                    } else {
                        throw new TestDataMakerException("テーブルIDをご記入ください。");
                    }
                }
                currentLine++;
            }
            if (!"".equals(testDataName)) {
                testDataAndTblMap.put(new Key(testDataName), tableIdAndContentMap);
                logger.debug("[ReflectTester]----- テストデータ読め済み テストデータID = " + testDataName + "テストデータ = " + tableIdAndContentMap);
            }
        }catch(FileNotFoundException e){
            throw new TestDataMakerException("当該ファイルが存在しません。fileName = " + fileFullName,e);
        } catch (IOException e) {
            throw new TestDataMakerException("当該ファイルが実例化できません。fileName = " + fileFullName,e);
        }finally{
            if (utDocumentBis != null){
                try {
                    utDocumentBis.close();
                } catch (IOException e) {
                    throw new TestDataMakerException("当該ファイルが閉めできません。fileName = " + fileFullName,e);
                }
            }

            if (utDocumentIs != null){
                try {
                    utDocumentIs.close();
                } catch (IOException e) {
                    throw new TestDataMakerException("当該ファイルが閉めできません。fileName = " + fileFullName,e);
                }
            }
        }
        logger.debug("[ReflectTester]----- getInData()処理終了  ファイル名前 = " + fileName + "シート名前 = " + sheetName);

        return testDataAndTblMap;
    }

    public void insDataByDataId(String testDataId,
        HashMap<Key, Map<Key, List<Map<Key, String>>>> testDataAndTblMap,
        boolean entitySyokikaYouhi) throws TestDataMakerException {

        entitySyokikaFlag = entitySyokikaYouhi;

        Map<Key, List<Map<Key, String>>> tableIdAndContentMap = testDataAndTblMap.get(new Key(testDataId));

        Set<Key> tableIdList = tableIdAndContentMap.keySet();
        Iterator<Key> tableIdIterator = tableIdList.iterator();
        while (tableIdIterator.hasNext()) {
            String tableId = tableIdIterator.next().getKeyValue();
            insDataByDataIdAndTableId(testDataId, tableId, tableIdAndContentMap);
            logger.debug("[ReflectTester]-----当該テーブルが削除しました。データID = " + testDataId + " テーブルID = " + tableId);
        }

        tableIdAndContentMap.remove(new Key(testDataId));
    }

    public void insDataByDataId(String testDataId, HashMap<Key, Map<Key, List<Map<Key, String>>>> testDataAndTblMap) throws TestDataMakerException{
        insDataByDataId(testDataId, testDataAndTblMap, false);
    }

    public void insDataByDataIdAndTableId(String testDataId, String tableId,
        Map<Key, List<Map<Key, String>>> tableIdAndContentMap) throws TestDataMakerException {

        insertDataToDb(testDataId, tableIdAndContentMap, tableId);
    }

    @SuppressWarnings("rawtypes")
    public List<AbstractExDBEntity> createEntityList(String testDataId, String tableId,
        Map<Key, List<Map<Key, String>>> tableIdAndContentMap ) throws TestDataMakerException{

        return createEntityList("yuyu.def.db.entity", testDataId, tableId, tableIdAndContentMap);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void insertDataToDb(String testDataId, Map<Key, List<Map<Key, String>>> tableIdAndContentMap,
        String tableId) throws TestDataMakerException {

        List<AbstractExDBEntity> dbEntityList = createEntityList(testDataId, tableId, tableIdAndContentMap);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        String jpql = "delete from " + tableId + " as q1";
        em.createJPQL(jpql).executeUpdate();
        em.flush();
        em.clear();
        if (dbEntityList.size() > 0) {
            hozenDomManager.insert(dbEntityList);
            hozenDomManager.flush();
        }
        hozenDomManager.clear();
    }

    private HashMap<String, String> getSetterMethodParamTypeMap(AbstractExDBEntity<?, ?> entityBean) {

        HashMap<String, String> setterMethodParamTypeMap = new HashMap<String, String>();
        Class<?> classType = entityBean.getClass();
        Method method[] = classType.getMethods();
        for (int i = 0; i < method.length; i++) {
            String methodName = method[i].getName();
            Class<?> para[] = method[i].getParameterTypes();
            if (para != null && para.length == 1) {
                setterMethodParamTypeMap.put(methodName, para[0].getName().toString());
            }
        }
        return setterMethodParamTypeMap;
    }

    @SuppressWarnings("rawtypes")
    private List<AbstractExDBEntity> createEntityList(String entityPackage, String testDataId, String tableId,
        Map<Key, List<Map<Key, String>>> tableIdAndContentMap) throws TestDataMakerException{

        List<AbstractExDBEntity> entityList = new ArrayList<AbstractExDBEntity>();
        List<Map<Key, String>> tableRecordList = tableIdAndContentMap.get(new Key(tableId));
        if (tableRecordList == null || tableRecordList.size() == 0) {
            return entityList;
        }

        String tableFullName = entityPackage + "." + tableId;
        AbstractExDBEntity dBEntity;
        try {
            Class dbEntityClass = Class.forName(tableFullName);
            dBEntity = (AbstractExDBEntity) dbEntityClass.newInstance();
            HashMap<String, String> methodIdParamTypeMap = getSetterMethodParamTypeMap(dBEntity);
            for (int i = 0; i < tableRecordList.size(); i++) {
                Map colIdContentMap = tableRecordList.get(i);
                dBEntity = createEntity(testDataId,tableId,dBEntity, colIdContentMap, methodIdParamTypeMap);
                entityList.add(dBEntity);
                dBEntity = (AbstractExDBEntity) Class.forName(tableFullName).newInstance();
            }
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException         ");
            throw new TestDataMakerException("当該エンティティが実例化不可 テーブルID = " +
                tableFullName ,e);
        } catch (InstantiationException e) {
            throw new TestDataMakerException("当該エンティティが実例化不可 テーブルID = " +
                tableFullName ,e);
        } catch (IllegalAccessException e) {
            throw new TestDataMakerException("当該エンティティが実例化不可 テーブルID = " +
                tableFullName ,e);
        }catch (NoClassDefFoundError e) {
            throw new TestDataMakerException("当該エンティティが実例化不可 テーブルID = " +
                tableFullName ,e);
        }

        return entityList;
    }

    @SuppressWarnings("rawtypes")
    private AbstractExDBEntity createEntity( String testDataId, String tableId,AbstractExDBEntity entityObj, Map colIdContentMap,
        Map setterMethodParamTypeMap) throws TestDataMakerException{

        Class<?> classType = entityObj.getClass();

        Set<?> entries = colIdContentMap.entrySet();
        if (entries != null) {
            Iterator iterator = entries.iterator();
            while (iterator.hasNext()) {

                Map.Entry entry = (Map.Entry) iterator.next();
                String colID = ((Key)(entry.getKey())).getKeyValue();
                String colValue  = entry.getValue().toString();
                if (colID.contains("$")) {
                    continue;
                }
                if (colID.length() < 1) {
                    throw new TestDataMakerException("TblClumnId が間違った、ClumnId 未記入 データID = " + testDataId + "tableId" + tableId);
                }
                String setNethodName = "set" + colID.substring(0, 1).toUpperCase() + colID.substring(1);
                String paramType = (String) setterMethodParamTypeMap.get(setNethodName);
                if(paramType == null || "".equals(paramType)){
                    throw new TestDataMakerException("当該項目がエンティティに存在しません。データID = " + testDataId + "tableId" + tableId + "項目ID = " + colID);
                }
                Object[] tobeSetValue = new Object[1];
                if ("jp.co.slcs.swak.number.BizCurrency".equals(paramType)) {
                    String currencyTypeId = colID.toUpperCase() + "$";
                    String currencyType = (String) colIdContentMap.get(currencyTypeId);
                    tobeSetValue[0] = invokeValue(tableId,colID, colValue,paramType, currencyType);
                } else {
                    tobeSetValue[0] = invokeValue(tableId,colID, colValue, paramType);
                }
                Method setMethod;
                try {
                    Class<?> paramClass;
                    if("long".equals(paramType)){
                        paramClass =  Long.TYPE;
                    }else{
                        paramClass =  Class.forName(paramType);
                    }
                    setMethod = classType.getMethod(setNethodName, paramClass);
                    setMethod.invoke(entityObj , tobeSetValue);
                } catch (ClassNotFoundException e) {
                    throw new TestDataMakerException("当該メソッドパラメータが実例化不可 メソッド名 = " +
                        setNethodName + ";パラメータ名 = " + paramType,e);
                } catch (NoSuchMethodException | SecurityException e){
                    throw new TestDataMakerException("当該項目がエンティティに存在しません。エンティティID = " + tableId +  "項目ID = " + colID,e);
                }catch (IllegalAccessException e) {
                    throw new TestDataMakerException("当該項目がエンティティに設定できません。エンティティID = " + tableId +  "項目ID = " + colID + "メソッド名 = " + setNethodName,e);
                } catch (IllegalArgumentException e) {
                    throw new TestDataMakerException("当該項目の値がエンティティに設定できません。エンティティID = " + tableId +  "項目ID = " + colID + "メソッド名 = " + setNethodName,e);
                } catch (InvocationTargetException e) {
                    throw new TestDataMakerException("当該項目の値がエンティティに設定できません。エンティティID = " + tableId +  "項目ID = " + colID + "メソッド名 = " + setNethodName,e);
                }
            }
        }

        if (entitySyokikaFlag) {
            BizPropertyInitializer.initialize(entityObj);
        }

        return entityObj;
    }

    private Object invokeValue(String tableId,String colId, String colValue,String colType) throws TestDataMakerException {
        return invokeValue(tableId,colId,colValue,colType,null);
    }

    private Object invokeValue(String tableId,String colId, String colValue,String colType, String currencyType) throws TestDataMakerException {
        Object tobeSetValue;
        if ("java.lang.String".equals(colType)) {
            if("ブランク".equals(colValue)){
                tobeSetValue = "";
            }else{
                tobeSetValue = colValue;
            }
        } else if ("int".equals(colType)) {
            tobeSetValue = new Integer(colValue);
        } else if ("jp.co.slcs.swak.number.BizNumber".equals(colType)) {
            BizNumber bizNumber = BizNumber.valueOf(new BigDecimal(colValue));
            tobeSetValue = bizNumber;

        } else if ("jp.co.slcs.swak.number.BizCurrency".equals(colType)) {
            if (currencyType != null && !"".equals(currencyType)) {
                if ("YEN".equals(currencyType)) {
                    BizCurrency bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue), BizCurrencyTypes.YEN);
                    tobeSetValue = bizCurrency;
                }else if ("MANYEN".equals(currencyType)) {
                    BizCurrency bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue), BizCurrencyTypes.MANYEN );
                    tobeSetValue = bizCurrency;
                }else if ("DOLLAR".equals(currencyType)) {
                    BizCurrency bizCurrency = null;
                    if(!"0".equals(colValue)){
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue).divide(new BigDecimal("100")), BizCurrencyTypes.DOLLAR);
                    }else{
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue), BizCurrencyTypes.DOLLAR);
                    }
                    tobeSetValue = bizCurrency;
                }else if ("AU_DOLLAR".equals(currencyType)) {
                    BizCurrency bizCurrency = null;
                    if(!"0".equals(colValue)){
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue).divide(new BigDecimal("100")), BizCurrencyTypes.AU_DOLLAR);
                    }else{
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue), BizCurrencyTypes.AU_DOLLAR);
                    }
                    tobeSetValue = bizCurrency;
                }else if ("EURO".equals(currencyType)) {
                    BizCurrency bizCurrency = null;
                    if(!"0".equals(colValue)){
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue).divide(new BigDecimal("100")), BizCurrencyTypes.EURO);
                    }else{
                        bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue), BizCurrencyTypes.EURO);
                    }
                    tobeSetValue = bizCurrency;
                } else {
                    throw new TestDataMakerException("当該項目の通貨種類が間違った。エンティティID = " + tableId + "項目ID = " + colId
                        + "通貨種類が " + colType + "下記の通貨種類中に選んでください｛YEN;MANYEN;DOLLAR;AU_DOLLAR;EURO｝");
                }
            } else {
                BizCurrency bizCurrency = BizCurrency.valueOf(new BigDecimal(colValue));
                tobeSetValue = bizCurrency;
            }
        } else if("long".equals(colType)){
            Long longValue = new Long(colValue);
            tobeSetValue = longValue;
        }else {
            try {
                Class<?> objClass = Class.forName(colType);
                Method kbnMethod = objClass.getMethod("valueOf", String.class);
                if("ブランク".equals(colValue)){
                    tobeSetValue = kbnMethod.invoke(null, new Object[] { "" });
                }else{
                    tobeSetValue = kbnMethod.invoke(null, new Object[] { colValue });
                }
            } catch (ClassNotFoundException e) {
                throw new TestDataMakerException("当該項目値は実例化不可 エンティティID = " + tableId +  "項目ID = " + colId  + ";項目型 = " + colType,e);
            } catch (NoSuchMethodException | SecurityException e){
                throw new TestDataMakerException("当該項目値は実例化不可 エンティティID = " + tableId +  "項目ID = " + colId  + ";項目型 = " + colType,e);
            }catch (IllegalAccessException e) {
                throw new TestDataMakerException("当該項目値は実例化不可 エンティティID = " + tableId +  "項目ID = " + colId  + ";項目型 = " + colType,e);
            } catch (IllegalArgumentException e) {
                throw new TestDataMakerException("当該項目値は実例化不可 エンティティID = " + tableId +  "項目ID = " + colId  + ";項目型 = " + colType,e);
            } catch (InvocationTargetException e) {
                throw new TestDataMakerException("当該項目値は実例化不可 エンティティID = " + tableId +  "項目ID = " + colId  + ";項目型 = " + colType,e);
            }
        }
        return tobeSetValue;
    }

    private int getTableContent(XSSFSheet dataSheet, String testDataName, String tableID,
        int readedLine,List<Map<Key, String>> tableRecordList) throws TestDataMakerException {

        int currentLine = readedLine + 1;
        boolean isColumnNmReaded = false;
        boolean isColumnIdReaded = false;

        XSSFRow columnIdRow = null;

        XSSFRow curentRow = null;
        logger.debug("[ReflectTester]----- getTableContent()処理開始  テストデータのID = " + testDataName + " テーブルID = " + tableID);

        while(!isColumnIdReaded){
            curentRow = dataSheet.getRow(currentLine);
            logger.debug("[ReflectTester]----- getTableContent(),当該処理行目 = " + currentLine);
            if(curentRow == null){
                logger.debug("[ReflectTester]----- getTableContent()処理終了  テストデータのID = " + testDataName + " テーブルID = " + tableID);
                return currentLine;
            }
            XSSFCell cellAValue = curentRow.getCell(dataIdIndx);
            if(!isColumnNmReaded){
                currentLine ++;
                if(cellAValue != null && "DEL".equals(cellAValue.getStringCellValue())){
                    continue;
                }
                logger.debug("[ReflectTester]----- getTableContent(),テーブル項目名行目 = " + currentLine);
                isColumnNmReaded = true;
            }else if(!isColumnIdReaded){
                if(cellAValue != null && "DEL".equals(cellAValue.getStringCellValue())){
                    currentLine ++;
                    continue;
                }
                columnIdRow = dataSheet.getRow(currentLine);
                logger.debug("[ReflectTester]----- getTableContent(),テーブル項目ID行目 = " + currentLine);
                currentLine ++;
                isColumnIdReaded = true;
            }

        }

        int colNum = columnIdRow.getPhysicalNumberOfCells();

        curentRow = dataSheet.getRow(currentLine);

        while (curentRow != null) {
            logger.debug("[ReflectTester]----- getTableContent(),当該処理行目 = " + currentLine);
            XSSFCell cellAValue = curentRow.getCell(0);

            if(cellAValue != null && "DEL".equals(cellAValue.getStringCellValue())){
                currentLine ++;
                curentRow = dataSheet.getRow(currentLine);
                continue;
            }

            Map<Key, String> idContentMap = new HashMap<Key, String>();

            String colContent = "";
            String colId = "";
            for (int colIdx = 1; colIdx <= colNum; colIdx++) {

                if (curentRow.getCell(colIdx) == null || "".equals(String.valueOf(curentRow.getCell(colIdx)))) {
                    continue;
                }

                if (curentRow.getCell(colIdx).getCellType() == 0) {
                    double cellV = curentRow.getCell(colIdx).getNumericCellValue();
                    colContent = new DecimalFormat().format(cellV);
                    colContent = colContent.replaceAll(",","");
                }
                else {
                    colContent = String.valueOf(curentRow.getCell(colIdx));
                }

                colId = columnIdRow.getCell(colIdx).toString();
                if("kousinsyaid".equals(colId)){
                    colId = "kousinsyaId";
                }else if("KOUSINTIME".equals(colId)){
                    colId ="kousinTime";
                }else if("KOUSINKINOU".equals(colId)){
                    colId ="kousinKinou";
                }else if("VERSION".equals(colId)){
                    colId ="version";
                }

                if(colId.contains("$")){
                    colId = colId.toUpperCase();
                }
                idContentMap.put(new Key(colId), colContent);
            }

            if (idContentMap.entrySet().size() != 0) {
                logger.debug("[ReflectTester]----- getTableContent()、下記レコードを読め済み,レコード = " + idContentMap);
                tableRecordList.add(idContentMap);
            }
            else {
                break;
            }
            currentLine ++;
            curentRow = dataSheet.getRow(currentLine);
        }
        logger.debug("[ReflectTester]----- getTableContent()処理終了  テストデータのID = " + testDataName + " テーブルID = " + tableID);
        return currentLine;
    }

}
