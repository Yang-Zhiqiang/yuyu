package yuyu.common.biz.bzcommon;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * エンティティユーティリティのメソッド {@link BizEntityUtil#copyEntity(T)} テスト用クラスです。<br />
 * テスト実行用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizEntityUtilTest_copyEntity {

    @Inject
    private ExDBEntityManager em;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_エンティティユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizEntityUtilTest_copyEntity.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4));
        bizDomManager.delete(bizDomManager.getSyoritanto("S001"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("KR001"));
        bizDomManager.delete(bizDomManager.getTjtIdouNyKh("17806000013",10));
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.BLNK10));
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testCopyEntity_A1() {

        BT_TyouhyouOutputKengen kengen1 = bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_TyouhyouOutputKengen kengen2 = BizEntityUtil.copyEntity(kengen1);

        Assert.assertEquals(kengen1, kengen2);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCopyEntity_A2() {

        BM_Syoritanto tanto1 = bizDomManager.getSyoritanto("S001");
        BM_Syoritanto tanto2  = BizEntityUtil.copyEntity(tanto1);

        Assert.assertEquals(tanto1, tanto2);
        Assert.assertEquals(tanto1.getTantouCd(), tanto2.getTantouCd());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCopyEntity_A3() {

        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        BT_HituyouSyoruiKanri koutei2 = BizEntityUtil.copyEntity(koutei1);

        Assert.assertEquals(koutei1, koutei2);
        Assert.assertEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        exNumericEquals(koutei1.getGyoumuKouteiInfo().getHituyouSyoruiKanris().size(), 2, "親Entityの子Entityの件数");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCopyEntity_A4() {
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("17806000013",10);
        nykh1.getIdouKhMeigi();
        nykh1.getIdouKhBosyuudr();
        BT_TjtIdouNyKh nykh2 = BizEntityUtil.copyEntity(nykh1);

        Assert.assertEquals(nykh1, nykh2);
        Assert.assertEquals(nykh1.getIdouKhMeigi(), nykh2.getIdouKhMeigi());
        Assert.assertEquals(nykh1.getIdouKhBosyuudr(), nykh2.getIdouKhBosyuudr());

    }
}
