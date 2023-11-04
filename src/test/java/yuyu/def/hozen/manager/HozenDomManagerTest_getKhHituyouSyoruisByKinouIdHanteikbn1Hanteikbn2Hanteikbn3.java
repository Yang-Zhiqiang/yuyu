package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class HozenDomManagerTest_getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3 extends AbstractTest {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        Assert.assertEquals(0,
            hozenDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3("10", 10, 11, 12).size());
        IM_KhHituyouSyorui iM_KhHituyouSyorui1 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui1.setKinouId("10");
        iM_KhHituyouSyorui1.setHanteikbn1(10);
        iM_KhHituyouSyorui1.setHanteikbn2(11);
        iM_KhHituyouSyorui1.setHanteikbn3(12);
        iM_KhHituyouSyorui1.setHtysrirenno(1);
        hozenDomManager.insert(iM_KhHituyouSyorui1);

        IM_KhHituyouSyorui iM_KhHituyouSyorui2 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui2.setKinouId("10");
        iM_KhHituyouSyorui2.setHanteikbn1(10);
        iM_KhHituyouSyorui2.setHanteikbn2(11);
        iM_KhHituyouSyorui2.setHanteikbn3(12);
        iM_KhHituyouSyorui2.setHtysrirenno(2);
        hozenDomManager.insert(iM_KhHituyouSyorui2);

        IM_KhHituyouSyorui iM_KhHituyouSyorui3 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui3.setKinouId("10");
        iM_KhHituyouSyorui3.setHanteikbn1(10);
        iM_KhHituyouSyorui3.setHanteikbn2(11);
        iM_KhHituyouSyorui3.setHanteikbn3(12);
        iM_KhHituyouSyorui3.setHtysrirenno(3);
        hozenDomManager.insert(iM_KhHituyouSyorui3);

        IM_KhHituyouSyorui iM_KhHituyouSyorui4 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui4.setKinouId("11");
        iM_KhHituyouSyorui4.setHanteikbn1(10);
        iM_KhHituyouSyorui4.setHanteikbn2(11);
        iM_KhHituyouSyorui4.setHanteikbn3(12);
        iM_KhHituyouSyorui4.setHtysrirenno(1);
        hozenDomManager.insert(iM_KhHituyouSyorui4);

        IM_KhHituyouSyorui iM_KhHituyouSyorui5 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui5.setKinouId("10");
        iM_KhHituyouSyorui5.setHanteikbn1(20);
        iM_KhHituyouSyorui5.setHanteikbn2(11);
        iM_KhHituyouSyorui5.setHanteikbn3(12);
        iM_KhHituyouSyorui5.setHtysrirenno(1);
        hozenDomManager.insert(iM_KhHituyouSyorui5);

        IM_KhHituyouSyorui iM_KhHituyouSyorui6 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui6.setKinouId("10");
        iM_KhHituyouSyorui6.setHanteikbn1(10);
        iM_KhHituyouSyorui6.setHanteikbn2(10);
        iM_KhHituyouSyorui6.setHanteikbn3(12);
        iM_KhHituyouSyorui6.setHtysrirenno(1);
        hozenDomManager.insert(iM_KhHituyouSyorui6);

        IM_KhHituyouSyorui iM_KhHituyouSyorui7 = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui7.setKinouId("10");
        iM_KhHituyouSyorui7.setHanteikbn1(10);
        iM_KhHituyouSyorui7.setHanteikbn2(10);
        iM_KhHituyouSyorui7.setHanteikbn3(11);
        iM_KhHituyouSyorui7.setHtysrirenno(1);
        hozenDomManager.insert(iM_KhHituyouSyorui7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHituyouSyorui());
    }

    @Test
    @Transactional
    public void noResult1() {
        List<IM_KhHituyouSyorui> result = hozenDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(
            "10", 1, 1, 1);
        Assert.assertEquals(0,result.size());
    }

    @Test
    @TestOrder(10)
    public void normal1() {
        List<IM_KhHituyouSyorui> result = hozenDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(
            "11", 10, 11, 12);
        Assert.assertEquals(1, result.size());

        Assert.assertEquals("11", result.get(0).getKinouId());
        Assert.assertEquals(10, result.get(0).getHanteikbn1().intValue());
        Assert.assertEquals(11, result.get(0).getHanteikbn2().intValue());
        Assert.assertEquals(12, result.get(0).getHanteikbn3().intValue());
        Assert.assertEquals(1, result.get(0).getHtysrirenno().intValue());
    }

    @Test
    @TestOrder(20)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10","10","11","12","1"), "1");
        datamap.put($("10","10","11","12","2"), "2");
        datamap.put($("10","10","11","12","3"), "3");

        List<IM_KhHituyouSyorui> result = hozenDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(
            "10", 10, 11, 12);

        for(IM_KhHituyouSyorui khHituyouSyorui:result){
            datamap.remove($(
                khHituyouSyorui.getKinouId(),
                khHituyouSyorui.getHanteikbn1().intValue(),
                khHituyouSyorui.getHanteikbn2().intValue(),
                khHituyouSyorui.getHanteikbn3().intValue(),
                khHituyouSyorui.getHtysrirenno().intValue()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void noResult2() {
        List<IM_KhHituyouSyorui> result = hozenDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(
            "", 10, 11, 12);
        Assert.assertEquals(0, result.size());
    }
}
