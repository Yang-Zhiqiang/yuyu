package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHenkouRirekiCountBySyonoGyoumuKousinKinou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenkouRirekiCountBySyonoGyoumuKousinKinou {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        Long count = hozenDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou("10000000001", "hozen");
        Assert.assertEquals(new Long(0), count);

        IT_KykKihon kykKihon1 = new IT_KykKihon("21", "10000000001");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");

        IT_KhHenkouRireki khHenkouRireki1 = khTtdkRireki1.createKhHenkouRireki();
        khHenkouRireki1.setRenno3keta(11);
        khHenkouRireki1.setHenkoukoumokunm("効力発生日");
        khHenkouRireki1.setGyoumuKousinKinou("hozen");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("21", "10000000002");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");

        IT_KhHenkouRireki khHenkouRireki2 = khTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki2.setRenno3keta(11);
        khHenkouRireki2.setHenkoukoumokunm("効力発生日");
        khHenkouRireki2.setGyoumuKousinKinou("hozen");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("22", "10000000001");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161001");

        IT_KhHenkouRireki khHenkouRireki3 = khTtdkRireki3.createKhHenkouRireki();
        khHenkouRireki3.setRenno3keta(11);
        khHenkouRireki3.setHenkoukoumokunm("効力発生日");
        khHenkouRireki3.setGyoumuKousinKinou("biz");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("23", "10000000001");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161001");

        IT_KhHenkouRireki khHenkouRireki4 = khTtdkRireki4.createKhHenkouRireki();
        khHenkouRireki4.setRenno3keta(11);
        khHenkouRireki4.setHenkoukoumokunm("変更発生日");
        khHenkouRireki4.setGyoumuKousinKinou("hozen");

        hozenDomManager.insert(kykKihon4);


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

        Long count = hozenDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou("10000000002", "biz");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        Long count = hozenDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou("10000000001", "hozen");
        Assert.assertEquals(new Long(1), count);
    }
    @Test
    @TestOrder(30)
    public void blankCondition1(){

        Long count = hozenDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou("", "hozen");
        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(40)
    public void blankCondition2() {

        Long count = hozenDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou("10000000001", "");
        Assert.assertEquals(new Long(0), count);

    }
}

