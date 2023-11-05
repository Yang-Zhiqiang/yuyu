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

import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiKekkasBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiKekkasBySyono {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono("11807111118");

        Assert.assertEquals(0, siKekkaLst.size());

        JT_SiKekka siKekka1 = new JT_SiKekka(C_ShiharaikekkadataKbn.SYOUMETU, "11807111118", "SH01", 1, 11, C_SyutkKbn.SYU);

        siharaiDomManager.insert(siKekka1);

        JT_SiKekka siKekka2 = new JT_SiKekka(C_ShiharaikekkadataKbn.SYOUMETU, "11807111129", "SH01", 1, 11, C_SyutkKbn.SYU);

        siharaiDomManager.insert(siKekka2);

        JT_SiKekka siKekka3 = new JT_SiKekka(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH02", 2, 12, C_SyutkKbn.TK);

        siharaiDomManager.insert(siKekka3);

        JT_SiKekka siKekka4 = new JT_SiKekka(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH03", 3, 13, C_SyutkKbn.TK);

        siharaiDomManager.insert(siKekka4);

        JT_SiKekka siKekka5 = new JT_SiKekka(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH04", 4, 14, C_SyutkKbn.TK);

        siharaiDomManager.insert(siKekka5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiKekka());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono("11807111141");

        Assert.assertEquals(0, siKekkaLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono("11807111118");

        Assert.assertEquals(1, siKekkaLst.size());
        Assert.assertEquals(C_ShiharaikekkadataKbn.SYOUMETU, siKekkaLst.get(0).getShiharaikekkadatakbn());
        Assert.assertEquals("11807111118", siKekkaLst.get(0).getSyono());
        Assert.assertEquals("SH01", siKekkaLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), siKekkaLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(11), siKekkaLst.get(0).getKyksyouhnrenno());
        Assert.assertEquals(C_SyutkKbn.SYU, siKekkaLst.get(0).getSyutkkbn());


    }

    @Test
    @TestOrder(30)
    public void normal2(){

        Map<String,String> siKekkaMap = new HashMap<String,String>();
        siKekkaMap.put($(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH02", 2, "12",  C_SyutkKbn.TK), "1");
        siKekkaMap.put($(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH03", 3, "13",  C_SyutkKbn.TK), "1");
        siKekkaMap.put($(C_ShiharaikekkadataKbn.PMEN, "11807111130", "SH04", 4, "14",  C_SyutkKbn.TK), "1");

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono("11807111130");

        Assert.assertEquals(3, siKekkaLst.size());

        siKekkaMap.remove($(siKekkaLst.get(0).getShiharaikekkadatakbn(), siKekkaLst.get(0).getSyono(),siKekkaLst.get(0).getSyouhncd(),
            siKekkaLst.get(0).getSyouhnsdno(), siKekkaLst.get(0).getKyksyouhnrenno(), siKekkaLst.get(0).getSyutkkbn()));

        siKekkaMap.remove($(siKekkaLst.get(1).getShiharaikekkadatakbn(), siKekkaLst.get(1).getSyono(),siKekkaLst.get(1).getSyouhncd(),
            siKekkaLst.get(1).getSyouhnsdno(), siKekkaLst.get(1).getKyksyouhnrenno(), siKekkaLst.get(1).getSyutkkbn()));

        siKekkaMap.remove($(siKekkaLst.get(2).getShiharaikekkadatakbn(), siKekkaLst.get(2).getSyono(),siKekkaLst.get(2).getSyouhncd(),
            siKekkaLst.get(2).getSyouhnsdno(), siKekkaLst.get(2).getKyksyouhnrenno(), siKekkaLst.get(2).getSyutkkbn()));

        assertTrue(siKekkaMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono("");
        Assert.assertEquals(0, siKekkaLst.size());
    }

}
