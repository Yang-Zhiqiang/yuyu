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
 * 組織情報取得クラスのメソッド {@link BzGetSosikiDataBean#exec(String)} テスト用クラスです。 <br />
 */
@RunWith(OrderedRunner.class)
public class BzGetSosikiDataTest_exec1 {

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

            testDataAndTblMap = testDataMaker.getInData(BzGetSosikiDataTest_exec1.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void testExce_B1() {

        String pSosikicd = "9123456";
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd);

        exClassificationEquals(bzGetSosikiDataBean.getSosikimasterumukbn(), C_SosikimasterUmuKbn.ARI, "組織マスタ有無区分");
        exClassificationEquals(bzGetSosikiDataBean.getSosikiyuukshantkbn(), C_SosikiYuuksHantKbn.HANTEIHUKA,
            "組織有効性判定区分");
        exStringEquals(bzGetSosikiDataBean.getSosikicd(), "9123456", "組織コード");
        exClassificationEquals(bzGetSosikiDataBean.getSosikinmkbn(), C_SosikiNmKbn.BU, "組織名区分");
        exStringEquals(bzGetSosikiDataBean.getSosikinm20(), "組織名", "組織名（２０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjisosikinm20(), "漢字組織名", "漢字組織名（２０文字）");
        exDateYMEquals(bzGetSosikiDataBean.getSosikisinsetuym(), BizDateYM.valueOf("201603"), "組織新設年月");
        exDateYMEquals(bzGetSosikiDataBean.getSosikihaisiym(), BizDateYM.valueOf("201603"), "組織廃止年月");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyouusosikicd(), "7654321", "当月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getTougetukeisyoueigyoubucd(), "321", "当月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyousosikicd(), "1234567", "前月継承組織コード");
        exStringEquals(bzGetSosikiDataBean.getZengetukeisyoueigyoubucd(), "123", "前月継承営業推進部コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikihontikucd(), "10000001", "組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getSosikikanjikaijyuusyo30(), "組織漢字下位住所", "組織漢字下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getKanjibirunm15(), "漢字ビル名称", "漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getSosikinyuukyokaisuu(), "999", "組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getSosikitelno(), "123456789-0123456789", "組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getSosikifaxno(), "0123456789-123456789", "組織ＦＡＸ番号");
        exDateEquals(bzGetSosikiDataBean.getKouryokukaisiymd(), BizDate.valueOf("20160225"), "効力開始年月日");
        exStringEquals(bzGetSosikiDataBean.getHensosikikihontikucd(), "12345678", "(変更後)組織基本地区コード");
        exStringEquals(bzGetSosikiDataBean.getHenkanjisosikikaijyuusyo30(), "変更後漢字組織下位住所", "(変更後)漢字組織下位住所（３０文字）");
        exStringEquals(bzGetSosikiDataBean.getHenkanjibirunm15(), "変更後漢字ビル名称", "(変更後)漢字ビル名称（１５文字）");
        exStringEquals(bzGetSosikiDataBean.getHensosikinyuukyokaisuu(), "888", "(変更後)組織入居階数");
        exStringEquals(bzGetSosikiDataBean.getHensosikitelno(), "0123456789-123456789", "(変更後)組織電話番号");
        exStringEquals(bzGetSosikiDataBean.getHensosikifaxno(), "123456789-0123456789", "(変更後)組織ＦＡＸ番号");
    }

    @AfterClass
    @Transactional
    public static void BzGetSousasyaSyozokuSosikiData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());

    }
}