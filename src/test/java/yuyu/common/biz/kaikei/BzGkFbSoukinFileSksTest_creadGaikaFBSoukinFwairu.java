package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.file.fixedlength.BzGkFbsoukinFixedlengthRecordLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ送金ファイル作成 {@link BzGkFbSoukinFileSks#creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn,C_Gkgyoumucd,BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkFbSoukinFileSksTest_creadGaikaFBSoukinFwairu {

    @Inject
    BzGkFbSoukinFileSks bzGkFbSoukinFileSks;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_外貨ＦＢ送金ファイル作成";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGkFbSoukinFileSksTest_creadGaikaFBSoukinFwairu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGkFBSoukinData());
    }

    @Test
    @TestOrder(10)
    public void testcreadGaikaFBSoukinFwairu_A1() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.BLNK,
                C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, BizDate.valueOf(20161212), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          00000009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         00000", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(), "800000000000000000000                                                                                                                                                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(), "9                                                                                                                                                                                                                                                         ", "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 0, "データレコード件数");

    }

    @Test
    @TestOrder(20)
    public void testcreadGaikaFBSoukinFwairu_A2() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_2EIGYOUBI,
                C_Gkgyoumucd.BLNK, BizDate.valueOf(20160101), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(),  "13512100234007SUMITOMOSEIMEI                          01020009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         56500", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(),  "2010001987654321       USD2000000123456789                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345672", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(),  "20201010101USD2000000123456789                                   JPY20002035036                                                                                                                                                                           ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbgkfixedlengthdata(),  "2030006000103192BNN070口座名義人名                                                                BNA070JAPAN                                                                 ACT034101010101010                                                                ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbgkfixedlengthdata(),  "2030006000203158BAN035ginkoumei                          BAB035shitenmei                          BAA070JAPAN BK1001 BR101                                                                                                                         1001101", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbgkfixedlengthdata(),  "2030006000301146APN140                                                                                                                                                                                                                                    ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbgkfixedlengthdata(),  "2030006000401146MSG140                                                                                                                                                                                                                                    ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(7).getIffFbgkfixedlengthdata(),  "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(8).getIffFbgkfixedlengthdata(),  "2030006000603228ZZ1035                                   ZZ2035                                   ZZ3140                                                                                                                                                  ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(9).getIffFbgkfixedlengthdata(),  "800000000080000000001                                                                                                                                                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(10).getIffFbgkfixedlengthdata(), "9                                                                                                                                                                                                                                                         ", "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 8, "データレコード件数");
    }

    @Test
    @TestOrder(30)
    public void testcreadGaikaFBSoukinFwairu_A3() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_3EIGYOUBI,
                C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, BizDate.valueOf(20160202), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(),  "13512100234007SUMITOMOSEIMEI                          00000009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         00000", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(),  "800000000000000000000                                                                                                                                                                                                                                     ", "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(),  "9                                                                                                                                                                                                                                                         ", "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 0, "データレコード件数");
    }

    @Test
    @TestOrder(40)
    public void testcreadGaikaFBSoukinFwairu_A4() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_3EIGYOUBI,
                C_Gkgyoumucd.BLNK, BizDate.valueOf(20190325), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         51600" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(), "2010001123457          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(7).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(8).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(9).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(10).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         51601" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(11).getIffFbgkfixedlengthdata(), "2010002123463          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(12).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(13).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(14).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(15).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(16).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(17).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(18).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(19).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(20).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         56400" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(21).getIffFbgkfixedlengthdata(), "2010003123464          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(22).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(23).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(24).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(25).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(26).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(27).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(28).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(29).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(30).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         56500" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(31).getIffFbgkfixedlengthdata(), "2010004123456          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(32).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(33).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(34).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(35).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(36).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(37).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(38).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(39).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(40).getIffFbgkfixedlengthdata(), "9                                                                                                                                                                                                                                                         " , "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 32, "データレコード件数");
    }

    @Test
    @TestOrder(50)
    public void testcreadGaikaFBSoukinFwairu_A5() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_3EIGYOUBI,
                C_Gkgyoumucd.BLNK, BizDate.valueOf(20200512), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         51600" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(), "2010001123467          AUD2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(), "20201010101AUD2000000987654321                                   JPY20002035044                                                                                                                                                                           " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK0001 BR204                                                                                                                         0001204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbgkfixedlengthdata(), "2030006000401146MSG140CHG 0                                                                                                                                                                                                                               " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(7).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(8).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(9).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(10).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         56500" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(11).getIffFbgkfixedlengthdata(), "2010002123470          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(12).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(13).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(14).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(15).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(16).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(17).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(18).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(19).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(20).getIffFbgkfixedlengthdata(), "9                                                                                                                                                                                                                                                         " , "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 16, "データレコード件数");
    }

    @Test
    @TestOrder(60)
    public void testcreadGaikaFBSoukinFwairu_A6() {

        List<BzGkFbsoukinFixedlengthRecordLayoutFile> bzGkFbsoukinFixedlengthRecordLayoutFileLst =
            bzGkFbSoukinFileSks.creadGaikaFBSoukinFwairu(C_ShrhousiteiKbn.FB_3EIGYOUBI,
                C_Gkgyoumucd.BLNK, BizDate.valueOf(20190512), "RGEFD000");

        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(0).getIffFbgkfixedlengthdata(),  "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         51600" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(1).getIffFbgkfixedlengthdata(), "2010001123471          AUD2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(2).getIffFbgkfixedlengthdata(), "20201010101AUD2000000987654321                                   JPY20002035044                                                                                                                                                                           " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(3).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(4).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK0001 BR204                                                                                                                         0001204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(5).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(6).getIffFbgkfixedlengthdata(), "2030006000401146MSG140CHG 0                                                                                                                                                                                                                               " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(7).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(8).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(9).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(10).getIffFbgkfixedlengthdata(), "13512100234007SUMITOMOSEIMEI                          02060009MITSUISUMITOMO 101OSAKA HONTEN                                                                                                                                                         56500" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(11).getIffFbgkfixedlengthdata(), "2010002123472          JPY2000000987654321                  1 120316SUMISEI SIHARAI SOUKIN                                                                                                                                                     12806345719" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(12).getIffFbgkfixedlengthdata(), "20201010101JPY2000000987654321                                                                                                                                                                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(13).getIffFbgkfixedlengthdata(), "2030006000103192BNN070口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義+++BNA070JAPAN                                                                 ACT034505050505050                                                                " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(14).getIffFbgkfixedlengthdata(), "2030006000203158BAN035ginkoumei4ginkoumei4ginkoumei4gink+BAB035shitenmei4shitenmei4shitenmei4shi++BAA070JAPAN BK2004 BR204                                                                                                                         2004204" , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(15).getIffFbgkfixedlengthdata(), "2030006000301146APN140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(16).getIffFbgkfixedlengthdata(), "2030006000401146MSG140                                                                                                                                                                                                                                    " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(17).getIffFbgkfixedlengthdata(), "2030006000503158BTN035                                   BTB035                                   BTA070                                                                                                                                                  " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(18).getIffFbgkfixedlengthdata(), "2030006000603228ZZ1035+oumei4ginkoumei4ginkoumei4        ZZ2035++tenmei4shitenmei4shitenmei4      ZZ3140+++人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口座名義人名4口                                                                            " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(19).getIffFbgkfixedlengthdata(), "800000000080000000001                                                                                                                                                                                                                                     " , "データレコード（固定長）");
        exStringEquals(bzGkFbsoukinFixedlengthRecordLayoutFileLst.get(20).getIffFbgkfixedlengthdata(), "9                                                                                                                                                                                                                                                         " , "データレコード（固定長）");

        exNumericEquals(bzGkFbSoukinFileSks.getDateCount(), 16, "データレコード件数");
    }

}