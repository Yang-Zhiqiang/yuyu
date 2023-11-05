package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhTtdkRirekiInfoBySyonoHenkousikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekiInfoBySyonoHenkousikibetukey {

    @Inject
    HozenDomManager hozenDomManager;
    BaseDomManager baseDomManager;

    private static String pUserId1 = "UI00000001";
    private static String pUserId2 = "UI00000002";

    private static String pUserNm1 = "テストユーザ１";
    private static String pUserNm2 = "テストユーザ２";

    private static String pPassword1 = "PWD0000001";
    private static String pPassword2 = "PWD0000002";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);


        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("11807111118", "20161001");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");
        khTtdkRireki1.setGyoumuKousinKinou("10000000001");
        khTtdkRireki1.setGyoumuKousinsyaId("UI00000001");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161002");
        khTtdkRireki3.setGyoumuKousinKinou("10000000001");
        khTtdkRireki3.setGyoumuKousinsyaId("UI00000001");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");
        khTtdkRireki2.setGyoumuKousinKinou("10000000001");
        khTtdkRireki2.setGyoumuKousinsyaId("UI00000001");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("12", "11807111130");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161003");
        khTtdkRireki4.setGyoumuKousinKinou("10000000002");
        khTtdkRireki4.setGyoumuKousinsyaId("UI00000002");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("13", "11807111130");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20161003");
        khTtdkRireki5.setGyoumuKousinKinou("10000000002");
        khTtdkRireki5.setGyoumuKousinsyaId("UI00000002");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("14", "11807111130");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20161003");
        khTtdkRireki6.setGyoumuKousinKinou("10000000002");
        khTtdkRireki6.setGyoumuKousinsyaId("UI00000002");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("15", "11807111130");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("20161003");
        khTtdkRireki7.setGyoumuKousinKinou("10000000002");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("16", "11807111130");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("20161003");
        khTtdkRireki8.setGyoumuKousinsyaId("UI00000002");

        hozenDomManager.insert(kykKihon7);

        AS_Kinou kinou1 = new AS_Kinou("10000000001");

        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("10000000002");

        baseDomManager.insert(kinou2);

        AM_User user1 = new AM_User(pUserId1);
        user1.setUserNm(pUserNm1);
        user1.setPassword(pPassword1);

        baseDomManager.insert(user1);

        AM_User user2 = new AM_User(pUserId2);
        user2.setUserNm(pUserNm2);
        user2.setPassword(pPassword2);

        baseDomManager.insert(user2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllUsers());
        baseDomManager.delete(baseDomManager.getAllKinous());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("11807111129", "20161002");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("11807111118", "20161001");

        Assert.assertEquals(1,KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.size());

        Assert.assertEquals("11", KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.get(0).getIT_KhTtdkRireki().getKbnkey());
        Assert.assertEquals("11807111118", KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.get(0).getIT_KhTtdkRireki().getSyono());
        Assert.assertEquals("20161001", KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.get(0).getIT_KhTtdkRireki().getHenkousikibetukey());
        Assert.assertEquals("10000000001", KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.get(0).getAS_Kinou().getKinouId());
        Assert.assertEquals(pUserId1, KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.get(0).getAM_User().getUserId());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("12"), "1");
        datamap.put($("13"), "2");
        datamap.put($("14"), "3");
        datamap.put($("15"), "3");
        datamap.put($("16"), "3");

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("11807111130", "20161003");

        for(KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean Bean:KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst){
            datamap.remove($(Bean.getIT_KhTtdkRireki().getKbnkey()));

        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("", "20161001");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst = hozenDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey("11807111118", "");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoHenkousikibetukeyBeanLst.size());

    }
}


