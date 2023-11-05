package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getSeirituJyouhouHanbaiNm(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getSeirituJyouhouHanbaiNm {

    private final static String fileName = "UT_SP_単体テスト仕様書_商品属性ユーティリティ";

    private final static String sheetName = "テストデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_getSeirituJyouhouHanbaiNm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testGetSeirituJyouhouHanbaiNm_L1() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd(null);

        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");
    }

    @Test
    @TestOrder(20)
    public void testGetSeirituJyouhouHanbaiNm_L2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        syouhnZokusei.setSyouhncd("");

        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");
    }

    @Test
    @TestOrder(30)
    public void testGetSeirituJyouhouHanbaiNm_L3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("a1", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");
    }

    @Test
    @TestOrder(40)
    public void testGetSeirituJyouhouHanbaiNm_L4() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ1", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "B6", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(50)
    public void testGetSeirituJyouhouHanbaiNm_L5() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ1", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "B7", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(60)
    public void testGetSeirituJyouhouHanbaiNm_L6() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｳ1", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "B8", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(70)
    public void testGetSeirituJyouhouHanbaiNm_L7() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C0", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(80)
    public void testGetSeirituJyouhouHanbaiNm_L8() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C1", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(90)
    public void testGetSeirituJyouhouHanbaiNm_L9() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(100)
    public void testGetSeirituJyouhouHanbaiNm_L10() {

        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(null, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(110)
    public void testGetSeirituJyouhouHanbaiNm_L11() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C2", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(120)
    public void testGetSeirituJyouhouHanbaiNm_L12() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾄ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C4", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(130)
    public void testGetSeirituJyouhouHanbaiNm_L13() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾈ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C6", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(140)
    public void testGetSeirituJyouhouHanbaiNm_L14() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾁ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C3", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(150)
    public void testGetSeirituJyouhouHanbaiNm_L15() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C5", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(160)
    public void testGetSeirituJyouhouHanbaiNm_L16() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾃ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(170)
    public void testGetSeirituJyouhouHanbaiNm_L17() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾉ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C8", "成立情報ＤＢ用販売名称コード");

    }

    @Test
    @TestOrder(180)
    public void testGetSeirituJyouhouHanbaiNm_L18() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "C9", "成立情報ＤＢ用販売名称コード");
    }


    @Test
    @TestOrder(190)
    public void testGetSeirituJyouhouHanbaiNm_L19() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "CA", "成立情報ＤＢ用販売名称コード");
    }


    @Test
    @TestOrder(200)
    public void testGetSeirituJyouhouHanbaiNm_L20() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.USD);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "CB", "成立情報ＤＢ用販売名称コード");
    }

    @Test
    @TestOrder(210)
    public void testGetSeirituJyouhouHanbaiNm_L21() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 0);
        String seiriTujyouhouhanbaiNmCd  = SyouhinUtil.getSeirituJyouhouHanbaiNm(syouhnZokusei, C_Tuukasyu.BLNK);
        exStringEquals(seiriTujyouhouhanbaiNmCd, "", "成立情報ＤＢ用販売名称コード");
    }
}
