package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiTyouhyoumsgsByBunrui1Bunrui2() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiTyouhyoumsgsByBunrui1Bunrui2 {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("A01", "B01");

        Assert.assertEquals(0,jM_SiTyouhyoumsgLst.size());

        JM_SiTyouhyoumsg siTyouhyoumsg1 = new JM_SiTyouhyoumsg("A01", "B01", 1);

        siharaiDomManager.insert(siTyouhyoumsg1);

        JM_SiTyouhyoumsg siTyouhyoumsg2 = new JM_SiTyouhyoumsg("A02", "B02", 2);

        siharaiDomManager.insert(siTyouhyoumsg2);

        JM_SiTyouhyoumsg siTyouhyoumsg3 = new JM_SiTyouhyoumsg("A02", "B03", 1);

        siharaiDomManager.insert(siTyouhyoumsg3);

        JM_SiTyouhyoumsg siTyouhyoumsg4 = new JM_SiTyouhyoumsg("A03", "B02", 2);

        siharaiDomManager.insert(siTyouhyoumsg4);

        JM_SiTyouhyoumsg siTyouhyoumsg5 = new JM_SiTyouhyoumsg("A02", "B02", 1);

        siharaiDomManager.insert(siTyouhyoumsg5);

        JM_SiTyouhyoumsg siTyouhyoumsg6 = new JM_SiTyouhyoumsg("A02", "B02", 3);

        siharaiDomManager.insert(siTyouhyoumsg6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiTyouhyoumsg());
    }

    @Test
    @Transactional
    public void noResult1(){

        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("A03", "B01");

        assertEquals(0, jM_SiTyouhyoumsgLst.size());

    }

    @Test
    @TestOrder(10)
    public void normal1(){
        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("A01", "B01");

        assertEquals(1, jM_SiTyouhyoumsgLst.size());

        assertEquals("A01", jM_SiTyouhyoumsgLst.get(0).getBunrui1());

        assertEquals("B01",jM_SiTyouhyoumsgLst.get(0).getBunrui2());

        assertEquals(1, jM_SiTyouhyoumsgLst.get(0).getTyouhyoulineno().intValue());

    }

    @Test
    @TestOrder(20)
    public void normal2(){

        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("A02", "B02");

        assertEquals(3, jM_SiTyouhyoumsgLst.size());

        assertEquals("A02", jM_SiTyouhyoumsgLst.get(0).getBunrui1());
        assertEquals("A02", jM_SiTyouhyoumsgLst.get(1).getBunrui1());
        assertEquals("A02", jM_SiTyouhyoumsgLst.get(2).getBunrui1());

        assertEquals("B02",jM_SiTyouhyoumsgLst.get(0).getBunrui2());
        assertEquals("B02",jM_SiTyouhyoumsgLst.get(1).getBunrui2());
        assertEquals("B02",jM_SiTyouhyoumsgLst.get(2).getBunrui2());

        assertEquals(1, jM_SiTyouhyoumsgLst.get(0).getTyouhyoulineno().intValue());
        assertEquals(2, jM_SiTyouhyoumsgLst.get(1).getTyouhyoulineno().intValue());
        assertEquals(3, jM_SiTyouhyoumsgLst.get(2).getTyouhyoulineno().intValue());

    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("", "B01");

        assertEquals(0, jM_SiTyouhyoumsgLst.size());

    }

    @Test
    @TestOrder(40)
    public void blankCondition2() {

        List<JM_SiTyouhyoumsg> jM_SiTyouhyoumsgLst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("A01", "");

        assertEquals(0, jM_SiTyouhyoumsgLst.size());

    }
}
