package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名", BizDate.valueOf(19921112), C_Seibetu.FEMALE);
        Assert.assertEquals(0, fatcaInfoLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_FatcaInfo fatcaInfo1 = kykKihon1.createFatcaInfo();
        fatcaInfo1.setRenno(11);
        fatcaInfo1.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
        fatcaInfo1.setSeionnmkn("氏名");
        fatcaInfo1.setSeiymd(BizDate.valueOf(19921112));
        fatcaInfo1.setSeibetu(C_Seibetu.FEMALE);

        IT_FatcaInfo fatcaInfo2 = kykKihon1.createFatcaInfo();
        fatcaInfo2.setRenno(31);
        fatcaInfo2.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
        fatcaInfo2.setSeionnmkn("氏名");
        fatcaInfo2.setSeiymd(BizDate.valueOf(19921112));
        fatcaInfo2.setSeibetu(C_Seibetu.HJN);

        IT_FatcaInfo fatcaInfo3 = kykKihon1.createFatcaInfo();
        fatcaInfo3.setRenno(71);
        fatcaInfo3.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
        fatcaInfo3.setSeionnmkn("氏名");
        fatcaInfo3.setSeiymd(BizDate.valueOf(19941112));
        fatcaInfo3.setSeibetu(C_Seibetu.FEMALE);

        IT_FatcaInfo fatcaInfo4 = kykKihon1.createFatcaInfo();
        fatcaInfo4.setRenno(51);
        fatcaInfo4.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
        fatcaInfo4.setSeionnmkn("名氏名");
        fatcaInfo4.setSeiymd(BizDate.valueOf(19921112));
        fatcaInfo4.setSeibetu(C_Seibetu.FEMALE);

        IT_FatcaInfo fatcaInfo5 = kykKihon1.createFatcaInfo();
        fatcaInfo5.setRenno(61);
        fatcaInfo5.setFatcakekkbn(C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU);
        fatcaInfo5.setSeionnmkn("氏名");
        fatcaInfo5.setSeiymd(BizDate.valueOf(19921112));
        fatcaInfo5.setSeibetu(C_Seibetu.FEMALE);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("04", "11807111141");

        IT_FatcaInfo fatcaInfo8 = kykKihon3.createFatcaInfo();
        fatcaInfo8.setRenno(41);
        fatcaInfo8.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIHUYOU);
        fatcaInfo8.setSeionnmkn("清音氏");
        fatcaInfo8.setSeiymd(BizDate.valueOf(19900101));
        fatcaInfo8.setSeibetu(C_Seibetu.MALE);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("05", "11807111152");

        IT_FatcaInfo fatcaInfo7 = kykKihon4.createFatcaInfo();
        fatcaInfo7.setRenno(21);
        fatcaInfo7.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIHUYOU);
        fatcaInfo7.setSeionnmkn("清音氏");
        fatcaInfo7.setSeiymd(BizDate.valueOf(19900101));
        fatcaInfo7.setSeibetu(C_Seibetu.HUMEI);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("06", "11807111163");

        IT_FatcaInfo fatcaInfo6 = kykKihon5.createFatcaInfo();
        fatcaInfo6.setRenno(31);
        fatcaInfo6.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIHUYOU);
        fatcaInfo6.setSeionnmkn("清音氏");
        fatcaInfo6.setSeiymd(BizDate.valueOf(19900101));
        fatcaInfo6.setSeibetu(C_Seibetu.HUMEI);

        hozenDomManager.insert(kykKihon5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名清音", BizDate.valueOf(19921112), C_Seibetu.FEMALE);
        Assert.assertEquals(0, fatcaInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名", BizDate.valueOf(19921112), C_Seibetu.FEMALE);
        Assert.assertEquals(1, fatcaInfoLst.size());

        Assert.assertEquals("01", fatcaInfoLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", fatcaInfoLst.get(0).getSyono());
        Assert.assertEquals(11, fatcaInfoLst.get(0).getRenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.TOKUTEIAMERICAN, "清音氏", BizDate.valueOf(19900101), C_Seibetu.MALE);
        Assert.assertEquals(3, fatcaInfoLst.size());

        Assert.assertEquals("04", fatcaInfoLst.get(0).getKbnkey());
        Assert.assertEquals("11807111141", fatcaInfoLst.get(0).getSyono());
        Assert.assertEquals(41, fatcaInfoLst.get(0).getRenno().intValue());

        Assert.assertEquals("05", fatcaInfoLst.get(1).getKbnkey());
        Assert.assertEquals("11807111152", fatcaInfoLst.get(1).getSyono());
        Assert.assertEquals(21, fatcaInfoLst.get(1).getRenno().intValue());

        Assert.assertEquals("06", fatcaInfoLst.get(2).getKbnkey());
        Assert.assertEquals("11807111163", fatcaInfoLst.get(2).getSyono());
        Assert.assertEquals(31, fatcaInfoLst.get(2).getRenno().intValue());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        Map<String,String> fatcaInfoMap = new HashMap<String, String>();
        fatcaInfoMap.put($("01", "11807111118", 11),"1");
        fatcaInfoMap.put($("01", "11807111118", 71),"1");

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名", null, C_Seibetu.FEMALE);
        Assert.assertEquals(2, fatcaInfoLst.size());

        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue()));
        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue()));

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Map<String,String> fatcaInfoMap = new HashMap<String, String>();
        fatcaInfoMap.put($("01", "11807111118", 11),"1");
        fatcaInfoMap.put($("01", "11807111118", 31),"1");

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名", BizDate.valueOf(19921112), null);
        Assert.assertEquals(2, fatcaInfoLst.size());

        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue()));
        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue()));

    }
    @Test
    @TestOrder(50)
    public void blankCondition3() {

        Map<String,String> fatcaInfoMap = new HashMap<String, String>();
        fatcaInfoMap.put($("01", "11807111118", 11),"1");
        fatcaInfoMap.put($("01", "11807111118", 31),"1");

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "氏名", BizDate.valueOf(19921112), C_Seibetu.BLNK);
        Assert.assertEquals(2, fatcaInfoLst.size());

        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(0).getKbnkey(), fatcaInfoLst.get(0).getSyono(), fatcaInfoLst.get(0).getRenno().intValue()));
        assertTrue(fatcaInfoMap.containsKey($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue())));
        fatcaInfoMap.remove($(fatcaInfoLst.get(1).getKbnkey(), fatcaInfoLst.get(1).getSyono(), fatcaInfoLst.get(1).getRenno().intValue()));

    }
    @Test
    @TestOrder(60)
    public void blankCondition4() {

        List<IT_FatcaInfo> fatcaInfoLst =
            hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU, "", BizDate.valueOf(19921112), C_Seibetu.FEMALE);
        Assert.assertEquals(0, fatcaInfoLst.size());

    }

}
