package yuyu.common.biz.bzfiledl;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

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

import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * ファイルアップロードユーティリティー メソッド{@link BzFileUploadUtil#exec(C_FileSyuruiCdKbn, List<T>, boolean, String)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFileUploadUtilTest2_exec extends AbstractTest {

    @Inject
    private BzFileUploadUtil bzFileUploadUtil;

    @Inject
    private BaseDomManager manager;

    @Inject
    private BzBatchParam bzBatchParam;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        AS_FileSyurui fileSyurui1 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk001"));
        fileSyurui1.setFileSyuruiNm("訂正項目リスト");
        fileSyurui1.setFileType("CSV");
        fileSyurui1.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui1.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan1 = fileSyurui1.createFileHozonKikan();
        fileHozonKikan1.setHozonKikan(1);
        fileHozonKikan1.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui1);

        AS_FileSyurui fileSyurui2 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk002"));
        fileSyurui2.setFileSyuruiNm("新契約不備未解消リスト");
        fileSyurui2.setDownloadFileNm("Test.csv");
        fileSyurui2.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui2.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan2 = fileSyurui2.createFileHozonKikan();
        fileHozonKikan2.setHozonKikan(1);
        fileHozonKikan2.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui2);

        AS_FileSyurui fileSyurui3 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk003"));
        fileSyurui3.setFileSyuruiNm("新契約不備分析リスト");
        fileSyurui3.setDownloadFileNm("Test.csv");
        fileSyurui3.setFileType("CSV");
        fileSyurui3.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui3.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan3 = fileSyurui3.createFileHozonKikan();
        fileHozonKikan3.setHozonKikan(1);
        fileHozonKikan3.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui3);

        AS_FileSyurui fileSyurui4 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk004"));
        fileSyurui4.setFileSyuruiNm("構成員契約リスト");
        fileSyurui4.setDownloadFileNm("Test.csv");
        fileSyurui4.setFileType("CSV");
        fileSyurui4.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui4.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("1"));

        AS_FileHozonKikan fileHozonKikan4 = fileSyurui4.createFileHozonKikan();
        fileHozonKikan4.setHozonKikan(1);
        fileHozonKikan4.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui4);

        AS_FileSyurui fileSyurui5 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk005"));
        fileSyurui5.setFileSyuruiNm("交換契約リスト");
        fileSyurui5.setDownloadFileNm("Test.csv");
        fileSyurui5.setFileType("CSV");
        fileSyurui5.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui5.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan5 = fileSyurui5.createFileHozonKikan();
        fileHozonKikan5.setHozonKikan(1);
        fileHozonKikan5.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui5);

        AS_FileSyurui fileSyurui6 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk006"));
        fileSyurui6.setFileSyuruiNm("一時払増額特約付契約Ｐ集計リスト");
        fileSyurui6.setDownloadFileNm("Test.csv");
        fileSyurui6.setFileType("CSV");
        fileSyurui6.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan6 = fileSyurui6.createFileHozonKikan();
        fileHozonKikan6.setHozonKikan(1);
        fileHozonKikan6.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui6);

        AS_FileSyurui fileSyurui7 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk007"));
        fileSyurui7.setFileSyuruiNm("前月一時払増額特約付契約Ｐ集計リスト");
        fileSyurui7.setDownloadFileNm("Test.csv");
        fileSyurui7.setFileType("CSV");
        fileSyurui7.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");

        AS_FileHozonKikan fileHozonKikan7 = fileSyurui7.createFileHozonKikan();
        fileHozonKikan7.setHozonKikan(1);
        fileHozonKikan7.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui7);

        AS_FileSyurui fileSyurui8 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk008"));
        fileSyurui8.setFileSyuruiNm("構死亡原因未反映リスト");
        fileSyurui8.setDownloadFileNm("Test.csv");
        fileSyurui8.setFileType("CSV");
        fileSyurui8.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui8.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("1"));

        AS_FileHozonKikan fileHozonKikan8 = fileSyurui8.createFileHozonKikan();
        fileHozonKikan8.setHozonKikan(1);
        fileHozonKikan8.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui8);

        AS_FileSyurui fileSyurui9 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk009"));
        fileSyurui9.setFileSyuruiNm("申込書類未到着ＣＳＶ");
        fileSyurui9.setDownloadFileNm("Test");
        fileSyurui9.setFileType("CSV");
        fileSyurui9.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkTskmlistLayoutFile");
        fileSyurui9.setCreateEmptyFileUmuKbn(C_UmuKbn.valueOf("0"));

        AS_FileHozonKikan fileHozonKikan9 = fileSyurui9.createFileHozonKikan();
        fileHozonKikan9.setHozonKikan(1);
        fileHozonKikan9.setNengappiKbn(C_NengappiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(fileSyurui9);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        changeSystemDate(BizDate.valueOf(20160106));
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        changeSystemDate(BizDate.valueOf(20160106));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20160325));
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = null;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20160106.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        changeSystemDate(BizDate.valueOf(20160106));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20160325));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20160325.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_01.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_KOUKANKYKLST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "12345687901234568790123456879012345687901234568790123456879012345687901234568790123456879012";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        changeSystemDate(BizDate.valueOf(20160106));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20160325));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_SIBOUGENINMIHANEILIST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "1234568790123456879012345687901234568790123456879012345687901234568790123456879012";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_20160325_1234568790123456879012345687901234568790123456879012345687901234568790123456879012.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_SIBOUGENINMIHANEILIST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "1234568790123456879012345687901234568790123456879012345687901234568790123456879012345687901";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 2, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(1).getFileNm(), "Test_1234568790123456879012345687901234568790123456879012345687901234568790123456879012345687901.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(1).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_KOUKANKYKLST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(1).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        String exFileNm = "12345687901234568790123456879012345687901234568790123456879012345687901234568790123";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 2, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(1).getFileNm(), "Test_１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１.csv", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(1).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(1).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        changeSystemDate(BizDate.valueOf(20160106));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_MOSMATICSV;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = false;

        String exFileNm = "01";

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg, exFileNm);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        List<AT_FileHozonInfo> fileHozonInfoLst = manager.getFileHozonInfoByFileSyuruiCd(fileSyuruiCdKbn);
        exNumericEquals(fileHozonInfoLst.size(), 1, "ファイル保存情報テーブルエンティティリストの件数");

        exStringEquals(fileHozonInfoLst.get(0).getFileNm(), "Test_01", "ファイル名");
        exClassificationEquals(fileHozonInfoLst.get(0).getFileSyuruiCd(), C_FileSyuruiCdKbn.SK_MOSMATICSV, "ファイル種類コード");

        AT_FileHozon fileHozon = fileHozonInfoLst.get(0).getFileHozon();
        assertNotNull(fileHozon.getFileContents());
    }

    @Test(expected = BizAppException.class)
    @TestOrder(140)
    public void testExec_B1() {
        YuyuBizConfig.getInstance().setItijiFileHozonsaki("main\\webapp\\test");
        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_KOUKANKYKLST;
        List<SkTskmlistLayoutFile> beanLst = Lists.newArrayList();
        SkTskmlistLayoutFile skTskmlistLayoutFile = new SkTskmlistLayoutFile();
        skTskmlistLayoutFile.setIfcSyorinm("処理名");
        skTskmlistLayoutFile.setIfcTskmnm("訂正項目名");
        skTskmlistLayoutFile.setIfcTntnm("王鵬");
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
