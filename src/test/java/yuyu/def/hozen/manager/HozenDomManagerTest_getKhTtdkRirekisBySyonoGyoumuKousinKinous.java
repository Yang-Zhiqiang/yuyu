
package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhTtdkRirekisBySyonoGyoumuKousinKinous() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekisBySyonoGyoumuKousinKinous {

    @Inject
    HozenDomManager hozenDomManager;

    private static String[] S = {"00000","11111","22222","33333","44444","55555","66666","77777"};
    private static String[] N = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("11807111118",S );

        Assert.assertEquals(0,IT_KhTtdkRirekiList.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("3333");
        khTtdkRireki1.setGyoumuKousinKinou("00000");
        khTtdkRireki1.setGyoumuKousinTime("20160511");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("2222");
        khTtdkRireki2.setGyoumuKousinKinou("11111");
        khTtdkRireki2.setGyoumuKousinTime("20160512");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("1111");
        khTtdkRireki3.setGyoumuKousinKinou("77777");
        khTtdkRireki3.setGyoumuKousinTime("20160513");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("5555");
        khTtdkRireki5.setGyoumuKousinKinou("88888");
        khTtdkRireki5.setGyoumuKousinTime("20160509");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("4444");
        khTtdkRireki4.setGyoumuKousinKinou("11111");
        khTtdkRireki4.setGyoumuKousinTime("20160510");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("6666");
        khTtdkRireki6.setGyoumuKousinKinou("11111");
        khTtdkRireki6.setGyoumuKousinTime("20160508");

        hozenDomManager.insert(kykKihon3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("11807111141",S );

        Assert.assertEquals(0,IT_KhTtdkRirekiList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("11807111130",S );

        Assert.assertEquals(1,IT_KhTtdkRirekiList.size());

        Assert.assertEquals("03",IT_KhTtdkRirekiList.get(0).getKbnkey());
        Assert.assertEquals("11807111130",IT_KhTtdkRirekiList.get(0).getSyono());
        Assert.assertEquals("6666",IT_KhTtdkRirekiList.get(0).getHenkousikibetukey());
        Assert.assertEquals("20160508",IT_KhTtdkRirekiList.get(0).getGyoumuKousinTime());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("11807111118",S );

        Assert.assertEquals(3,IT_KhTtdkRirekiList.size());

        Assert.assertEquals("01",IT_KhTtdkRirekiList.get(0).getKbnkey());
        Assert.assertEquals("11807111118",IT_KhTtdkRirekiList.get(0).getSyono());
        Assert.assertEquals("1111",IT_KhTtdkRirekiList.get(0).getHenkousikibetukey());
        Assert.assertEquals("20160513",IT_KhTtdkRirekiList.get(0).getGyoumuKousinTime());

        Assert.assertEquals("01",IT_KhTtdkRirekiList.get(1).getKbnkey());
        Assert.assertEquals("11807111118",IT_KhTtdkRirekiList.get(1).getSyono());
        Assert.assertEquals("2222",IT_KhTtdkRirekiList.get(1).getHenkousikibetukey());
        Assert.assertEquals("20160512",IT_KhTtdkRirekiList.get(1).getGyoumuKousinTime());

        Assert.assertEquals("01",IT_KhTtdkRirekiList.get(2).getKbnkey());
        Assert.assertEquals("11807111118",IT_KhTtdkRirekiList.get(2).getSyono());
        Assert.assertEquals("3333",IT_KhTtdkRirekiList.get(2).getHenkousikibetukey());
        Assert.assertEquals("20160511",IT_KhTtdkRirekiList.get(2).getGyoumuKousinTime());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("",S);

        Assert.assertEquals(0,IT_KhTtdkRirekiList.size());
    }
    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_KhTtdkRireki> IT_KhTtdkRirekiList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous("11807111118",N);

        Assert.assertEquals(0,IT_KhTtdkRirekiList.size());
    }

}


