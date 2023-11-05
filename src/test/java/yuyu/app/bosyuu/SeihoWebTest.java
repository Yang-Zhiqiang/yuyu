package yuyu.app.bosyuu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMakerException;
import yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzanImpl;
import yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuiiImpl;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiImpl;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiImpl;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosImpl;
import yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisanImpl;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiImpl;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.OrderedRunner;

import com.beust.jcommander.internal.Lists;

/**
 * 生保Webテストツール <br />
 *
 */
@RunWith(OrderedRunner.class)
public class SeihoWebTest {

    @Inject
    private static Logger logger;

    private static enum E_SyoriPatten {
        SEKMOS,
        MOSSYOUKAI,
        KAIYAKUHRSUII,
        NENKINKAIYAKUHRSUII,
        GAIKAKANZAN,
        HEIJYUNKAIYAKUHRSUII,
        ZENNOUKEISAN
    }

    private static final String OPERATOR_ID  = "015100001110000001";
    private static final String ORG_CODE     = "5438117";
    private static final String COOPCLASS    = "09";
    private static final Map<E_SyoriPatten, String> METHOD_NAME_MAP  = new HashMap<E_SyoriPatten, String>();

    private final static String FILE_PATH        = "";
    private final static String FILE_NAME        = "生保Webテストツール";
    private final static String FILE_EXTENSOPM   = ".xlsm";

    private final static int COLUMN_MAX_NUM = 16384;

    private final static String SET_SHEET_NAME = "設定";

    private final static Map<E_SyoriPatten, String> REQUEST_SHEET_NAME_MAP = new HashMap<E_SyoriPatten, String>();
    private final static Map<E_SyoriPatten, Integer> GYOUMUDATA_START_ROW_NUM_MAP = new HashMap<E_SyoriPatten, Integer>();
    private final static Map<E_SyoriPatten, Integer> GYOUMUDATA_START_COLUMN_NUM_MAP = new HashMap<E_SyoriPatten, Integer>();

    private final static Map<E_SyoriPatten, String> OPERATORID_START_ROW_NUM_MAP = new HashMap<E_SyoriPatten, String>();
    private final static Map<E_SyoriPatten, String> ORGCODE_START_ROW_NUM_MAP = new HashMap<E_SyoriPatten, String>();
    private final static Map<E_SyoriPatten, String> COOPCLASS_START_ROW_NUM_MAP = new HashMap<E_SyoriPatten, String>();

    private final static Map<E_SyoriPatten, String> RESPONSE_SHEET_NAME_MAP = new HashMap<E_SyoriPatten, String>();
    private final static Map<E_SyoriPatten, Integer> RESPONSESTR_START_ROW_NUM_MAP = new HashMap<E_SyoriPatten, Integer>();
    private final static Map<E_SyoriPatten, Integer> RESPONSESTR_START_COLUMN_NUM_MAP = new HashMap<E_SyoriPatten, Integer>();

    static {
        METHOD_NAME_MAP.put(E_SyoriPatten.SEKMOS,              "yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMos\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.MOSSYOUKAI,          "yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukai\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,       "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII, "yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuii\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.GAIKAKANZAN, "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII, "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii\\execPostForm");
        METHOD_NAME_MAP.put(E_SyoriPatten.ZENNOUKEISAN,         "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan\\execPostForm");

        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.SEKMOS,                        "リクエスト_生保WEB設計書申込書作成");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.MOSSYOUKAI,                    "リクエスト_生保WEB申込状況照会");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,                 "リクエスト_生保Ｗｅｂ解約返戻金推移表作成");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,           "リクエスト_生保WEB年金用解約返戻金推移表作成");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.GAIKAKANZAN,                   "リクエスト_生保Ｗｅｂ外貨換算");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,          "リクエスト_生保Ｗｅｂ平準払終身用解約返戻金推移表作成");
        REQUEST_SHEET_NAME_MAP.put(E_SyoriPatten.ZENNOUKEISAN,                  "リクエスト_生保Ｗｅｂ前納保険料計算");

        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.SEKMOS,                  1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,              1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,           1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,     1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,             1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,    1);
        GYOUMUDATA_START_ROW_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,            1);

        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.SEKMOS,               11);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,           11);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,        7);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,  8);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,          8);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII, 8);
        GYOUMUDATA_START_COLUMN_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,         8);

        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.SEKMOS,                  "3");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,              "");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,           "3");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,     "3");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,             "3");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,    "3");
        OPERATORID_START_ROW_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,            "3");

        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.SEKMOS,                     "4");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,                 "");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,              "4");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,        "4");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,                "4");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,       "4");
        ORGCODE_START_ROW_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,               "4");

        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.SEKMOS,                   "5");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,               "");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,            "5");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,      "5");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,              "5");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,     "5");
        COOPCLASS_START_ROW_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,             "5");

        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.SEKMOS,                       "レスポンス_生保WEB設計書申込書作成");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.MOSSYOUKAI,                   "レスポンス_生保WEB申込状況照会");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,                "レスポンス_生保Ｗｅｂ解約返戻金推移表作成");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,          "レスポンス_生保WEB年金用解約返戻金推移表作成");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.GAIKAKANZAN,                  "レスポンス_生保Ｗｅｂ外貨換算");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,         "レスポンス_生保Ｗｅｂ平準払終身用解約返戻金推移表作成");
        RESPONSE_SHEET_NAME_MAP.put(E_SyoriPatten.ZENNOUKEISAN,                 "レスポンス_生保Ｗｅｂ前納保険料計算");

        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.SEKMOS,                 1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,             1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,          1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII,    1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,            1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,   1);
        RESPONSESTR_START_ROW_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,           1);

        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.SEKMOS,              9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.MOSSYOUKAI,          9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.KAIYAKUHRSUII,       9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.NENKINKAIYAKUHRSUII, 9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.GAIKAKANZAN,         9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.HEIJYUNKAIYAKUHRSUII,9);
        RESPONSESTR_START_COLUMN_NUM_MAP.put(E_SyoriPatten.ZENNOUKEISAN,        9);
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    public void exec() {

        logger.debug("▽ 生保Webテストツール 処理開始");

        long kensuu = 0l;
        List<String> resultStrList = Lists.newArrayList();

        try {
            E_SyoriPatten execKinou = getExecKinou();

            MultivaluedMap<String, String> pMap;

            List<String[]> requestInfoList = getRequestInfo(execKinou);

            for (String requestInfo[] : requestInfoList) {

                pMap = (MultivaluedMap<String, String>) Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

                String[] param = requestInfo[0].split(",");

                if (BizUtil.isBlank(param[0])){
                    pMap.add("operatorId", OPERATOR_ID);
                }
                else {
                    pMap.add("operatorId", param[0]);
                }

                if (BizUtil.isBlank(param[1])) {
                    pMap.add("orgCode", ORG_CODE);
                }
                else {
                    pMap.add("orgCode", param[1]);
                }

                if (BizUtil.isBlank(param[2])) {
                    pMap.add("coopClass", COOPCLASS);
                }
                else {
                    pMap.add("coopClass", param[2]);
                }

                pMap.add("methodName", METHOD_NAME_MAP.get(execKinou));
                pMap.add("gyoumuData", requestInfo[1]);

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = null;

                if (execKinou == E_SyoriPatten.SEKMOS) {
                    HbSeihoWebSekMosImpl sekMosImpl = SWAKInjector.getInstance(HbSeihoWebSekMosImpl.class);
                    wsBzWebserviceResParamBean = sekMosImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.MOSSYOUKAI) {
                    HbSeihoWebMosSyoukaiImpl mosSyoukaiImpl = SWAKInjector.getInstance(HbSeihoWebMosSyoukaiImpl.class);
                    wsBzWebserviceResParamBean = mosSyoukaiImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.KAIYAKUHRSUII) {
                    HbSeihoWebKaiyakuhrSuiiImpl kaiyakuhrSuiiImpl  = SWAKInjector.getInstance(HbSeihoWebKaiyakuhrSuiiImpl.class);
                    wsBzWebserviceResParamBean = kaiyakuhrSuiiImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.NENKINKAIYAKUHRSUII) {
                    HbSeihoWebNenkinKaiyakuhrSuiiImpl nkKaiyakuhrSuiiImpl = SWAKInjector.getInstance(HbSeihoWebNenkinKaiyakuhrSuiiImpl.class);
                    wsBzWebserviceResParamBean = nkKaiyakuhrSuiiImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.GAIKAKANZAN) {
                    HbSeihoWebGaikaKanzanImpl hbSeihoWebGaikaKanzanImpl = SWAKInjector.getInstance(HbSeihoWebGaikaKanzanImpl.class);
                    wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.HEIJYUNKAIYAKUHRSUII) {
                    HbSeihoWebHeijyunKaiyakuhrSuiiImpl hbSeihoWebHeijyunKaiyakuhrSuiiImpl = SWAKInjector.getInstance(HbSeihoWebHeijyunKaiyakuhrSuiiImpl.class);
                    wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);
                }
                else if (execKinou == E_SyoriPatten.ZENNOUKEISAN) {
                    HbSeihoWebZennouKeisanImpl hbSeihoWebZennouKeisanImpl = SWAKInjector.getInstance(HbSeihoWebZennouKeisanImpl.class);
                    wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);
                }
                resultStrList.add(JSON.encode(wsBzWebserviceResParamBean));

                kensuu += 1;
            }

            writeResultData(resultStrList, execKinou);

            if (execKinou == E_SyoriPatten.SEKMOS) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Web申込書作成）");
            }
            else if (execKinou == E_SyoriPatten.MOSSYOUKAI) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Web申込状況照会）");
            }
            else if (execKinou == E_SyoriPatten.KAIYAKUHRSUII) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Web解約返戻金推移表作成）");
            }
            else if (execKinou == E_SyoriPatten.NENKINKAIYAKUHRSUII) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Web年金用解約返戻金推移表作成）");
            }
            else if (execKinou == E_SyoriPatten.GAIKAKANZAN) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Ｗｅｂ外貨換算）");
            }
            else if (execKinou == E_SyoriPatten.HEIJYUNKAIYAKUHRSUII) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Ｗｅｂ平準払終身用解約返戻金推移表作成）");
            }
            else if (execKinou == E_SyoriPatten.ZENNOUKEISAN) {
                logger.debug("｜ 処理件数 " + kensuu + " 件（生保Ｗｅｂ前納保険料計算）");
            }
            logger.debug("△ 生保Webテストツール 処理正常終了");

        } catch (Exception e1) {

            logger.debug("｜ 生保Webテストツール 処理中にエラーが発生しました。");
            logger.debug("△ 生保Webテストツール 処理異常終了");
            e1.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    private E_SyoriPatten getExecKinou() throws Exception {

        logger.debug("｜ ▽ 実行機能取得処理開始  ファイル名前 = " + FILE_NAME + " シート名前 = " + SET_SHEET_NAME);

        E_SyoriPatten syoriPatten = null;

        FileInputStream inputStream = null;
        String fileFullName = getFileFullName();

        try {
            inputStream = new FileInputStream(new File(fileFullName));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet(SET_SHEET_NAME);

            if(sheet == null){
                throw new TestDataMakerException(
                    "設定情報のシート名間違った 設定情報シート名 = " + SET_SHEET_NAME);
            }

            XSSFRow currentRow = sheet.getRow(1);
            XSSFCell cell = currentRow.getCell(2);

            if (cell != null) {
                String value = cell.getStringCellValue();

                if (BizUtil.isBlank(value)) {
                    throw new TestDataMakerException("ファイル「" + FILE_NAME + FILE_EXTENSOPM +
                        "」⇒シート「"+ SET_SHEET_NAME + "」のC2セルで、実行対象を入力してください。");
                }
                else if ("生保Web設計書申込書作成".equals(value)) {
                    syoriPatten = E_SyoriPatten.SEKMOS;
                }
                else if ("生保Web申込状況照会".equals(value)) {
                    syoriPatten = E_SyoriPatten.MOSSYOUKAI;
                }
                else if ("生保Web解約返戻金推移表作成".equals(value)) {
                    syoriPatten = E_SyoriPatten.KAIYAKUHRSUII;
                }
                else if ("生保Web年金用解約返戻金推移表作成".equals(value)) {
                    syoriPatten = E_SyoriPatten.NENKINKAIYAKUHRSUII;
                }
                else if ("生保Ｗｅｂ外貨換算".equals(value)) {
                    syoriPatten = E_SyoriPatten.GAIKAKANZAN;
                }
                else if ("生保Ｗｅｂ平準払終身用解約返戻金推移表作成".equals(value)) {
                    syoriPatten = E_SyoriPatten.HEIJYUNKAIYAKUHRSUII;
                }
                else if ("生保Ｗｅｂ前納保険料計算".equals(value)) {
                    syoriPatten = E_SyoriPatten.ZENNOUKEISAN;
                }
                else {
                    throw new TestDataMakerException("実行対象が取得できません。");
                }
            }
            else {
                throw new TestDataMakerException("実行対象が取得できません。");
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

        logger.debug("｜ △ 実行機能取得処理終了  ファイル名前 = " + FILE_NAME + " シート名前 = " + SET_SHEET_NAME);

        return syoriPatten;
    }

    @SuppressWarnings("resource")
    private List<String[]> getRequestInfo(E_SyoriPatten pSyoriPatten) throws Exception {

        String requestSheetName = REQUEST_SHEET_NAME_MAP.get(pSyoriPatten);

        logger.debug("｜ ▽ リクエスト情報取得処理開始  ファイル名前 = " + FILE_NAME + " シート名前 = " + requestSheetName);

        List<String[]> requestInfo = Lists.newArrayList();

        FileInputStream inputStream = null;
        String fileFullName = getFileFullName();

        try {
            inputStream = new FileInputStream(new File(fileFullName));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet(requestSheetName);

            if(sheet == null){
                throw new TestDataMakerException(
                    "リクエストデータのシート名間違った リクエストデータシート名 = " + requestSheetName);
            }

            XSSFRow currentRow = sheet.getRow(GYOUMUDATA_START_ROW_NUM_MAP.get(pSyoriPatten));
            XSSFRow operatorIdRow = null;
            XSSFRow orgCodeRow = null;
            XSSFRow coopClassRow = null;

            if (!BizUtil.isBlank(OPERATORID_START_ROW_NUM_MAP.get(pSyoriPatten))) {
                operatorIdRow = sheet.getRow(Integer.valueOf(OPERATORID_START_ROW_NUM_MAP.get(pSyoriPatten)));
            }
            if (!BizUtil.isBlank(ORGCODE_START_ROW_NUM_MAP.get(pSyoriPatten))) {
                orgCodeRow = sheet.getRow(Integer.valueOf(ORGCODE_START_ROW_NUM_MAP.get(pSyoriPatten)));
            }
            if (!BizUtil.isBlank(COOPCLASS_START_ROW_NUM_MAP.get(pSyoriPatten))) {
                coopClassRow = sheet.getRow(Integer.valueOf(COOPCLASS_START_ROW_NUM_MAP.get(pSyoriPatten)));
            }

            for (int index = GYOUMUDATA_START_COLUMN_NUM_MAP.get(pSyoriPatten); index <= COLUMN_MAX_NUM; index++) {

                XSSFCell cell = currentRow.getCell(index);

                if (cell != null) {
                    String value = cell.getStringCellValue();

                    if (!"end".equals(value) && !BizUtil.isBlank(value)) {

                        String[] yousos = new String[2];

                        StringBuffer sb = new StringBuffer();
                        if (operatorIdRow != null) {
                            sb.append(operatorIdRow.getCell(index).getStringCellValue());
                        }
                        else {
                            sb.append("");
                        }
                        sb.append(",");
                        if (orgCodeRow != null) {
                            sb.append(orgCodeRow.getCell(index).getStringCellValue());
                        }
                        else {
                            sb.append("");
                        }
                        sb.append(",");
                        if (coopClassRow != null) {
                            sb.append(coopClassRow.getCell(index).getStringCellValue());
                        }
                        else {
                            sb.append("");
                        }
                        sb.append(",");
                        sb.append("END");

                        yousos[0] = sb.toString();

                        yousos[1] = value;

                        requestInfo.add(yousos);
                    }
                    else {
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

        logger.debug("｜ △ リクエスト情報取得処理終了  ファイル名前 = " + FILE_NAME + " シート名前 = " + requestSheetName);

        return requestInfo;
    }

    @SuppressWarnings("resource")
    private void writeResultData(List<String> pResultLst, E_SyoriPatten pSyoriPatten) throws Exception {

        String responseSheetName = RESPONSE_SHEET_NAME_MAP.get(pSyoriPatten);

        logger.debug("｜ ▽ 結果データの書き込み開始 ファイル名前 = " + FILE_NAME + " シート名前 = " + responseSheetName);

        OutputStream out = null;
        String fileFullName = getFileFullName();

        try {
            FileInputStream inputStream = new FileInputStream(new File(fileFullName));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet(responseSheetName);

            Row row = sheet.getRow(RESPONSESTR_START_ROW_NUM_MAP.get(pSyoriPatten));

            int responseColumnCount = 0;
            for (int index = RESPONSESTR_START_COLUMN_NUM_MAP.get(pSyoriPatten); index < COLUMN_MAX_NUM; index++) {
                Cell cell = row.getCell(index);
                if (!"end".equals(cell.getStringCellValue())) {
                    if (!BizUtil.isBlank(cell.getStringCellValue())) {
                        cell.setCellValue("");
                    }
                    responseColumnCount += 1;
                }
                else {
                    break;
                }
            }
            if (responseColumnCount != pResultLst.size()) {
                throw new TestDataMakerException(
                    "「レスポンス」シートのレスポンス文字列の列数と結果リストの件数が不一致です。fileName = "
                        + fileFullName);
            }

            int sequence = RESPONSESTR_START_COLUMN_NUM_MAP.get(pSyoriPatten);

            for (String result : pResultLst) {
                Cell cell = row.getCell(sequence);
                cell.setCellValue(result);
                sequence += 1;
            }
            sheet.setForceFormulaRecalculation(true);

            out = new FileOutputStream(fileFullName);
            wb.write(out);

        } catch (FileNotFoundException e) {
            throw new TestDataMakerException("当該ファイルが存在しません。fileName = " + fileFullName, e);

        } catch (IOException e) {
            throw new TestDataMakerException("当該ファイルが実例化できません。fileName = " + fileFullName, e);

        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new TestDataMakerException("当該ファイルが閉めできません。fileName = " + fileFullName,e);
                }
            }
        }

        logger.debug("｜ △ 結果データの書き込み終了 ファイル名前 = " +
            FILE_NAME + " シート名前 = " + responseSheetName);
    }

    private String getFileFullName() {

        String packageName = this.getClass().getPackage().getName();
        String fliePath = this.getClass().getResource("/").getPath();
        fliePath = fliePath.substring(1);
        fliePath = fliePath.replace("target/test-classes/", "").replace("/", "\\");

        String fileFullName = "";
        if (!BizUtil.isBlank(FILE_PATH)) {
            fileFullName = FILE_PATH + "\\" + FILE_NAME + FILE_EXTENSOPM;
        }
        else {
            fileFullName = fliePath + "src\\test\\java\\" +
                packageName.replace(".", "\\") + "\\" + FILE_NAME + FILE_EXTENSOPM;
        }

        logger.debug("｜ ｜ ファイルPath = " + fileFullName );
        return fileFullName;
    }
}
