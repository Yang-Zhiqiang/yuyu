package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * エンティティユーティリティのメソッド {@link BizEntityUtil#merge(List<E>, List<E>)} テスト用クラスです。<br />
 * テスト実行用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizEntityUtilTest_merge {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_エンティティユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizEntityUtilTest_merge.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testMerge_A1() {
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> targetEntitys = null;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        srcEntitys = kykKihon.getKoujyoSymKanris();

        BizEntityUtil.merge(null, srcEntitys);

        assertNull(targetEntitys);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testMerge_A2() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> srcEntitys = null;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        BizEntityUtil.merge(targetEntitys, srcEntitys);

        exNumericEquals(targetEntitys.size(), 1, "ターゲットエンティティリストの件数");

        exStringEquals(targetEntitys.get(0).getSyono(), "17806000013", "証券番号");
        exStringEquals(targetEntitys.get(0).getNendo(), "2011", "年度");
        exDateYMEquals(targetEntitys.get(0).getLastsyoumeiendym(), BizDateYM.valueOf("201705"), "最終証明終了年月");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testMerge_A3() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<>();

        BizEntityUtil.merge(targetEntitys, srcEntitys);

        exNumericEquals(targetEntitys.size(), 0, "ターゲットエンティティリストの件数");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testMerge_A4() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        srcEntitys = kykKihon.getKoujyoSymKanris();

        BizEntityUtil.merge(targetEntitys, srcEntitys);

        exNumericEquals(targetEntitys.size(), 1, "ターゲットエンティティリストの件数");

        exStringEquals(targetEntitys.get(0).getSyono(), "17806000013", "証券番号");
        exStringEquals(targetEntitys.get(0).getNendo(), "2011", "年度");
        exDateYMEquals(targetEntitys.get(0).getLastsyoumeiendym(), BizDateYM.valueOf("201705"), "最終証明終了年月");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testMerge_A5() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        srcEntitys = kykKihon.getKoujyoSymKanris();

        IT_KoujyoSymKanri targetEntity = new IT_KoujyoSymKanri();
        targetEntity.setKbnkey("02");
        targetEntity.setSyono("17806000024");
        targetEntity.setNendo("2013");
        targetEntity.setLastsyoumeiendym(BizDateYM.valueOf("199912"));
        targetEntitys.add(targetEntity);

        BizEntityUtil.merge(targetEntitys, srcEntitys);

        exNumericEquals(targetEntitys.size(), 2, "ターゲットエンティティリストの件数");

        exStringEquals(targetEntitys.get(0).getSyono(), "17806000024", "証券番号");
        exStringEquals(targetEntitys.get(0).getNendo(), "2013", "年度");
        exDateYMEquals(targetEntitys.get(0).getLastsyoumeiendym(), BizDateYM.valueOf("201707"), "最終証明終了年月");

        exStringEquals(targetEntitys.get(1).getSyono(), "17806000024", "証券番号");
        exStringEquals(targetEntitys.get(1).getNendo(), "2012", "年度");
        exDateYMEquals(targetEntitys.get(1).getLastsyoumeiendym(), BizDateYM.valueOf("201706"), "最終証明終了年月");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testMerge_A6() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        srcEntitys = new ArrayList<IT_KoujyoSymKanri>(kykKihon.getKoujyoSymKanris());
        srcEntitys.remove(kykKihon.getKoujyoSymKanriByNendo("2017"));
        targetEntitys.remove(kykKihon.getKoujyoSymKanriByNendo("2015"));

        BizEntityUtil.merge(targetEntitys, srcEntitys);

        exNumericEquals(targetEntitys.size(), 4, "ターゲットエンティティリストの件数");

        exStringEquals(targetEntitys.get(0).getSyono(), "17806000035", "証券番号");
        exStringEquals(targetEntitys.get(0).getNendo(), "2014", "年度");
        exDateYMEquals(targetEntitys.get(0).getLastsyoumeiendym(), BizDateYM.valueOf("201708"), "最終証明終了年月");

        exStringEquals(targetEntitys.get(1).getSyono(), "17806000035", "証券番号");
        exStringEquals(targetEntitys.get(1).getNendo(), "2016", "年度");
        exDateYMEquals(targetEntitys.get(1).getLastsyoumeiendym(), BizDateYM.valueOf("201710"), "最終証明終了年月");

        exStringEquals(targetEntitys.get(2).getSyono(), "17806000035", "証券番号");
        exStringEquals(targetEntitys.get(2).getNendo(), "2017", "年度");
        exDateYMEquals(targetEntitys.get(2).getLastsyoumeiendym(), BizDateYM.valueOf("201711"), "最終証明終了年月");

        exStringEquals(targetEntitys.get(3).getSyono(), "17806000035", "証券番号");
        exStringEquals(targetEntitys.get(3).getNendo(), "2015", "年度");
        exDateYMEquals(targetEntitys.get(3).getLastsyoumeiendym(), BizDateYM.valueOf("201709"), "最終証明終了年月");
    }
}