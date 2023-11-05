package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnToriatukaiTuukasByPk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnToriatukaiTuukasByPk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSyouhnToriatukaiTuukasByPk";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20191202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getSyouhnToriatukaiTuukasByPk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnToriatukaiTuuka());
    }

    @Test
    @TestOrder(10)
    public void noResult() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20201202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20191202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 1, "商品取扱通貨マスタ エンティティリストのサイズ");
        exStringEquals(syouhnToriatukaiTuukaList.get(0).getSyouhncd(), "ｱ1", "商品コード");
        exDateEquals(syouhnToriatukaiTuukaList.get(0).getTkyfromymd(), BizDate.valueOf(20191201), "適用日自");
        exDateEquals(syouhnToriatukaiTuukaList.get(0).getTkytoymd(), BizDate.valueOf(20191203), "適用日至");
        exClassificationEquals(syouhnToriatukaiTuukaList.get(0).getZenkizennouumu(), C_BlnktkumuKbn.ARI, "全期前納有無");
        exClassificationEquals(syouhnToriatukaiTuukaList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(syouhnToriatukaiTuukaList.get(0).getHrktuukasyu(), C_Tuukasyu.USD, "払込通貨種類");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20211202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 3, "商品取扱通貨マスタ エンティティリストのサイズ");

        Map<String,String> map = new HashMap<String,String>();
        map.put($("ｱ1",BizDate.valueOf(20211202),BizDate.valueOf(20211202),C_BlnktkumuKbn.ARI,C_Tuukasyu.JPY,C_Tuukasyu.USD), "1");
        map.put($("ｱ1",BizDate.valueOf(20211201),BizDate.valueOf(20211202),C_BlnktkumuKbn.ARI,C_Tuukasyu.JPY,C_Tuukasyu.USD), "1");
        map.put($("ｱ1",BizDate.valueOf(20211202),BizDate.valueOf(20211203),C_BlnktkumuKbn.ARI,C_Tuukasyu.JPY,C_Tuukasyu.USD), "1");

        for(BM_SyouhnToriatukaiTuuka syouhnToriatukaiTuuka : syouhnToriatukaiTuukaList){
            map.remove($(syouhnToriatukaiTuuka.getSyouhncd(),
                syouhnToriatukaiTuuka.getTkyfromymd(),
                syouhnToriatukaiTuuka.getTkytoymd(),
                syouhnToriatukaiTuuka.getZenkizennouumu(),
                syouhnToriatukaiTuuka.getKyktuukasyu(),
                syouhnToriatukaiTuuka.getHrktuukasyu()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "",
            BizDate.valueOf(20211202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");

        syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            null,
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");

        syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20211202),
            null,
            C_Tuukasyu.JPY,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");

        syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20211202),
            C_BlnktkumuKbn.ARI,
            null,
            C_Tuukasyu.USD);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");

        syouhnToriatukaiTuukaList = bizDomManager.getSyouhnToriatukaiTuukasByPk(
            "ｱ1",
            BizDate.valueOf(20211202),
            C_BlnktkumuKbn.ARI,
            C_Tuukasyu.JPY,
            null);

        exNumericEquals(syouhnToriatukaiTuukaList.size(), 0, "商品取扱通貨マスタ エンティティリストのサイズ");
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
