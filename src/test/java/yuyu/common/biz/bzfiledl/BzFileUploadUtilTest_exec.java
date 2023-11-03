package yuyu.common.biz.bzfiledl;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * ファイルアップロードユーティリティー メソッドテスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFileUploadUtilTest_exec extends AbstractTest {

    @Inject
    private BzFileUploadUtil bzFileUploadUtil;

    @Inject
    private BaseDomManager manager;

    @Inject
    private BzBatchParam bzBatchParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ファイルアップロードユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzFileUploadUtilTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {


        changeSystemDate(BizDate.valueOf(20170818));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = null;

        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {


        changeSystemDate(BizDate.valueOf(20170818));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_QRTIGINGLOBAL;

        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {


        changeSystemDate(BizDate.valueOf(20170818));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {


        changeSystemDate(BizDate.valueOf(20170818));
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {


        changeSystemDate(BizDate.valueOf(20170818));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {


        changeSystemDate(BizDate.valueOf(20170818));
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }


    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        changeSystemDate(BizDate.valueOf(20170818));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170801));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;


        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");
        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20170801.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_KOUKANKYKLST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileHozonInfo());

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        changeSystemDate(BizDate.valueOf(20170818));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170801));
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");
        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20170818", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileHozonInfo());


    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        changeSystemDate(BizDate.valueOf(20170818));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170801));
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;


        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");
        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileHozonInfo());


    }
    @Test(expected = BizAppException.class)
    @TestOrder(220)
    public void testExec_B1() {

        YuyuBizConfig.getInstance().setItijiFileHozonsaki("main\\webapp\\test");
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_MOSMATICSV;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        try {
            bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "ファイル操作中にエラーが発生しました。 ファイル名=Test.csv", "エラーメッセー");
            throw e;
        }

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_C1() {


        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = null;

        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_C2() {


        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_QRTIGINGLOBAL;

        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_C3() {


        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_C4() {


        changeSystemDate(BizDate.valueOf(20170817));
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_C5() {


        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_C6() {


        changeSystemDate(BizDate.valueOf(20170817));
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }


    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_C7() {


        changeSystemDate(BizDate.valueOf(20170817));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170701));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = null;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");
        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20170701.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_KOUKANKYKLST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_C8() {


        changeSystemDate(BizDate.valueOf(20170817));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170701));
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");
        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20170817", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_C9() {
        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_01.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());


    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_C10() {
        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "12345687901234568790123456879012345687901234568790123456879012345687901234568790123456879012";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_C11() {
        changeSystemDate(BizDate.valueOf(20170817));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20170701));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_SIBOUGENINMIHANEILIST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "1234568790123456879012345687901234568790123456879012345687901234568790123456879012";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20170701_1234568790123456879012345687901234568790123456879012345687901234568790123456879012.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_SIBOUGENINMIHANEILIST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_C12() {
        changeSystemDate(BizDate.valueOf(20170817));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_MOSMATICSV;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "123456879012345687901234568790123456879012345687901234568790123456879012345687901234568790";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_123456879012345687901234568790123456879012345687901234568790123456879012345687901234568790.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_MOSMATICSV, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());

    }

    @Test(expected = BizAppException.class)
    @TestOrder(230)
    @Transactional
    public void testExec_D1() {

        YuyuBizConfig.getInstance().setItijiFileHozonsaki("main\\webapp\\test");
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "01";

        try {
            bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "ファイル操作中にエラーが発生しました。 ファイル名=Test_01.csv", "エラーメッセー");
            throw e;
        }

    }

}