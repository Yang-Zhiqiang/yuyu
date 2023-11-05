package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.def.classification.C_SosikiYuuksHantKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 組織情報取得クラスのメソッド {@link BzGetSosikiDataBean#exec(String,BizDate)} テスト用クラスです。 <br />
 */
@RunWith(OrderedRunner.class)
public class BzGetSosikiDataTest_exec {

    @Inject
    private BzGetSosikiData bzGetSosikiData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_組織情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetSosikiDataTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void BzGetSousasyaSyozokuSosikiData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());

    }

    @Test
    @TestOrder(10)
    public void testExce_A1() {

        String pSosikicd = "";
        BizDate pKijyunymd = BizDate.valueOf("20160113");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.NONE, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), null, "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), null, "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), null, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), null, "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), null, "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), null, "組織廃止年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), null, "組織新設年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), null, "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), null, "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), null, "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), null, "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), null, "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), null, "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), null, "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), null, "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), null, "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), null, "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), null, "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), null, "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), null, "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), null, "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), null, "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), null, "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(20)
    public void testExce_A2() {

        String pSosikicd = null;
        BizDate pKijyunymd = BizDate.valueOf("20160113");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.NONE, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), null, "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), null, "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), null, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), null, "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), null, "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), null, "組織廃止年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), null, "組織新設年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), null, "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), null, "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), null, "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), null, "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), null, "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), null, "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), null, "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), null, "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), null, "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), null, "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), null, "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), null, "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), null, "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), null, "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), null, "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), null, "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(30)
    public void testExce_A3() {

        String pSosikicd = "1110000";
        BizDate pKijyunymd = BizDate.valueOf("20160113");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.NONE, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), null, "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), null, "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), null, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), null, "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), null, "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), null, "組織廃止年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), null, "組織新設年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), null, "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), null, "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), null, "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), null, "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), null, "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), null, "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), null, "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), null, "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), null, "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), null, "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), null, "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), null, "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), null, "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), null, "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), null, "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), null, "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(40)
    public void testExce_A4() {

        String pSosikicd = "6123456";
        BizDate pKijyunymd = BizDate.valueOf("20160213");

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "6123456", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), C_SosikiNmKbn.BU, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "組織名３", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "漢字組織名３", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), BizDateYM.valueOf("201602"), "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), BizDateYM.valueOf("201602"), "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "7654321", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "321", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "1234567", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "123", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "10000003", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "組織漢字下位住所３", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "漢字ビル名称３", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "999", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "123456789-0123456789", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "0123456789-123456789", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), BizDate.valueOf("20160226"), "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "61234567", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "変更後漢字組織下位住所３", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "変更後漢字ビル名称３", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "888", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "0123456789-123456789", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "123456789-0123456789", "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(50)
    public void testExce_A5() {

        String pSosikicd =  "6123456";
        BizDate pKijyunymd = null;
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");

    }


    @Test
    @TestOrder(60)
    public void testExce_A6() {

        String pSosikicd = "4123456";
        BizDate pKijyunymd = BizDate.valueOf("20160301");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(70)
    public void testExce_A7() {

        String pSosikicd = "4123456";
        BizDate pKijyunymd = BizDate.valueOf("20160131");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(80)
    public void testExce_A8() {

        String pSosikicd = "5123456";
        BizDate pKijyunymd = BizDate.valueOf("20160301");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(90)
    public void testExce_A9() {

        String pSosikicd = "5123456";
        BizDate pKijyunymd = BizDate.valueOf("20160131");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(100)
    public void testExce_A10() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160215");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(110)
    public void testExce_A11() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160101");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(120)
    public void testExce_A12() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160331");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(130)
    public void testExce_A13() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20151231");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(140)
    public void testExce_A14() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20170401");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");

    }

    @Test
    @TestOrder(150)
    public void testExce_A15() {

        String pSosikicd = "4123456";
        BizDate pKijyunymd = BizDate.valueOf("20160227");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "10000001", "基準日時点組織基本地区コード");

    }

    @Test
    @TestOrder(160)
    public void testExce_A16() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160226");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "10000004", "基準日時点組織基本地区コード");

    }

    @Test
    @TestOrder(170)
    public void testExce_A17() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160227");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "71234567", "基準日時点組織基本地区コード");

    }

    @Test
    @TestOrder(180)
    public void testExce_A18() {

        String pSosikicd = "7123456";
        BizDate pKijyunymd = BizDate.valueOf("20160228");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "71234567", "基準日時点組織基本地区コード");

    }

    @Test
    @TestOrder(190)
    public void testExce_A19() {

        String pSosikicd = "6123456";
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "6123456", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), C_SosikiNmKbn.BU, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "組織名３", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "漢字組織名３", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), BizDateYM.valueOf("201602"), "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), BizDateYM.valueOf("201602"), "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "7654321", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "321", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "1234567", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "123", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "10000003", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "組織漢字下位住所３", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "漢字ビル名称３", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "999", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "123456789-0123456789", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "0123456789-123456789", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), BizDate.valueOf("20160226"), "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "61234567", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "変更後漢字組織下位住所３", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "変更後漢字ビル名称３", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "888", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "0123456789-123456789", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "123456789-0123456789", "(変更後)組織ＦＡＸ番号");
    }

    @Test
    @TestOrder(200)
    public void testExce_A20() {

        String pSosikicd = "AAAAAAA";
        BizDate pKijyunymd = BizDate.valueOf("20170101");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "91234560", "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "AAAAAAA", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), C_SosikiNmKbn.A2, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "組織名ＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "漢字組織名ＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), BizDateYM.valueOf("201614"), "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), BizDateYM.valueOf("201613"), "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "7654322", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "322", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "1234568", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "124", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "10000008", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "下位住所ＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "ビルＸＸＸＸＸＸＸ１ＸＸＸＸＥ", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "998", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "123456789-0123456780", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "0123456789-123456780", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), BizDate.valueOf("20160231"), "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "91234560", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "変更後下位ＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "変更後ビルＸＸＸＸ１ＸＸＸＸＥ", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "889", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "9876543210-123456789", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "987654321-0123456789", "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(210)
    public void testExce_A21() {

        String pSosikicd = "AAAAAAA";
        BizDate pKijyunymd = BizDate.valueOf("20170231");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.NG,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "91234560", "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "AAAAAAA", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), C_SosikiNmKbn.A2, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "組織名ＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "漢字組織名ＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), BizDateYM.valueOf("201614"), "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), BizDateYM.valueOf("201613"), "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "7654322", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "322", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "1234568", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "124", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "10000008", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "下位住所ＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "ビルＸＸＸＸＸＸＸ１ＸＸＸＸＥ", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "998", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "123456789-0123456780", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "0123456789-123456780", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), BizDate.valueOf("20160231"), "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "91234560", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "変更後下位ＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "変更後ビルＸＸＸＸ１ＸＸＸＸＥ", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "889", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "9876543210-123456789", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "987654321-0123456789", "(変更後)組織ＦＡＸ番号");

    }

    @Test
    @TestOrder(220)
    public void testExce_A22() {

        String pSosikicd = "0000000";
        BizDate pKijyunymd = BizDate.valueOf("20170101");
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.OK,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getKijyunymdjdsosikikihontikucd(), "", "基準日時点組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "0000000", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), null, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), null, "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), null, "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "", "(変更後)組織ＦＡＸ番号");

    }

}
