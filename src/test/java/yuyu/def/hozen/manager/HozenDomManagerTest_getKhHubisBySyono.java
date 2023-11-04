package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.IT_KhHubi;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHubisBySyono() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class HozenDomManagerTest_getKhHubisBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono("11807111118");

        Assert.assertEquals(0,khHubiLst.size());

        IT_KhHubi khHubi1 = new IT_KhHubi("201520161001");
        khHubi1.setSyono("11807111118");

        hozenDomManager.insert(khHubi1);

        IT_KhHubi khHubi2 = new IT_KhHubi("201520161002");
        khHubi2.setSyono("11807111129");

        hozenDomManager.insert(khHubi2);

        IT_KhHubi khHubi3 = new IT_KhHubi("201520161003");
        khHubi3.setSyono("11807111130");

        hozenDomManager.insert(khHubi3);

        IT_KhHubi khHubi4 = new IT_KhHubi("201520161004");
        khHubi4.setSyono("11807111130");

        hozenDomManager.insert(khHubi4);

        IT_KhHubi khHubi5 = new IT_KhHubi("201520161005");
        khHubi5.setSyono("11807111130");

        hozenDomManager.insert(khHubi5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono("11807111141");

        assertEquals(0, khHubiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono("11807111118");

        assertEquals(1, khHubiLst.size());
        assertEquals("201520161001", khHubiLst.get(0).getHubisikibetukey());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("201520161003"), "1");
        datamap.put($("201520161004"), "2");
        datamap.put($("201520161005"), "3");

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono("11807111130");

        for(IT_KhHubi khHubi:khHubiLst){
            datamap.remove($(khHubi.getHubisikibetukey()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono("");

        assertEquals(0, khHubiLst.size());

    }
}
