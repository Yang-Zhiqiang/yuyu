package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiKekkasBySyonoSyoumetujiyuuNe() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiKekkasBySyonoSyoumetujiyuuNe {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSiKekkasBySyonoSyoumetujiyuuNe";

    private final static String sheetName = "INデータ";

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyonoSyoumetujiyuuNe("99806001021", C_Syoumetujiyuu .CLGOFF);

        Assert.assertEquals(0, siKekkaLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiDomManagerTest_getSiKekkasBySyonoSyoumetujiyuuNe.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiKekka());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyonoSyoumetujiyuuNe("99806001010", C_Syoumetujiyuu .KYKTORIKESI);

        Assert.assertEquals(0, siKekkaLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyonoSyoumetujiyuuNe("99806001021", C_Syoumetujiyuu .CLGOFF);

        Assert.assertEquals(1, siKekkaLst.size());

        Assert.assertEquals(C_ShiharaikekkadataKbn.SYOUMETU, siKekkaLst.get(0).getShiharaikekkadatakbn());
        Assert.assertEquals("99806001021", siKekkaLst.get(0).getSyono());
        Assert.assertEquals("ﾕｳ", siKekkaLst.get(0).getSyouhncd());
        Assert.assertEquals(1, siKekkaLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, siKekkaLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals(C_SyutkKbn.SYU, siKekkaLst.get(0).getSyutkkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyonoSyoumetujiyuuNe("99806001032", C_Syoumetujiyuu .KAIJO);

        assertEquals(3, siKekkaLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(C_ShiharaikekkadataKbn.SYOUMETU, "99806001032", "ﾕｴ", 1, 1, C_SyutkKbn.SYU), "1");
        map.put($(C_ShiharaikekkadataKbn.PMEN, "99806001032", "ﾕｴ", 2, 1, C_SyutkKbn.SYU), "1");
        map.put($(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, "99806001032", "ﾕｴ", 3, 1, C_SyutkKbn.SYU), "1");

        assertTrue(map.containsKey($(siKekkaLst.get(0).getShiharaikekkadatakbn(), siKekkaLst.get(0).getSyono(), siKekkaLst.get(0).getSyouhncd(), siKekkaLst.get(0).getSyouhnsdno().intValue(),
            siKekkaLst.get(0).getKyksyouhnrenno().intValue(), siKekkaLst.get(0).getSyutkkbn())));
        assertTrue(map.containsKey($(siKekkaLst.get(1).getShiharaikekkadatakbn(), siKekkaLst.get(1).getSyono(), siKekkaLst.get(1).getSyouhncd(), siKekkaLst.get(1).getSyouhnsdno().intValue(),
            siKekkaLst.get(1).getKyksyouhnrenno().intValue(), siKekkaLst.get(1).getSyutkkbn())));
        assertTrue(map.containsKey($(siKekkaLst.get(2).getShiharaikekkadatakbn(), siKekkaLst.get(2).getSyono(), siKekkaLst.get(2).getSyouhncd(), siKekkaLst.get(2).getSyouhnsdno().intValue(),
            siKekkaLst.get(2).getKyksyouhnrenno().intValue(), siKekkaLst.get(2).getSyutkkbn())));

        map.remove($(siKekkaLst.get(0).getShiharaikekkadatakbn(), siKekkaLst.get(0).getSyono(), siKekkaLst.get(0).getSyouhncd(), siKekkaLst.get(0).getSyouhnsdno().intValue(),
            siKekkaLst.get(0).getKyksyouhnrenno().intValue(), siKekkaLst.get(0).getSyutkkbn()));
        map.remove($(siKekkaLst.get(1).getShiharaikekkadatakbn(), siKekkaLst.get(1).getSyono(), siKekkaLst.get(1).getSyouhncd(), siKekkaLst.get(1).getSyouhnsdno().intValue(),
            siKekkaLst.get(1).getKyksyouhnrenno().intValue(), siKekkaLst.get(1).getSyutkkbn()));
        map.remove($(siKekkaLst.get(2).getShiharaikekkadatakbn(), siKekkaLst.get(2).getSyono(), siKekkaLst.get(2).getSyouhncd(), siKekkaLst.get(2).getSyouhnsdno().intValue(),
            siKekkaLst.get(2).getKyksyouhnrenno().intValue(), siKekkaLst.get(2).getSyutkkbn()));

        assertTrue(map.isEmpty());
    }
}
