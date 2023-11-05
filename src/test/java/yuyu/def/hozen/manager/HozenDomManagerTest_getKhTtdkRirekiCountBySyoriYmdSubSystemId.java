package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.TestOrder;

/**
 * サブシステムＩＤ別の契約保全手続履歴件数のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekiCountBySyoriYmdSubSystemId {

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String subSystemId0 = "06";
    private final static String subSystemId1 = "01";
    private final static String subSystemId3 = "03";
    private final static String subSystemId5 = "05";

    private final static BizDate syoriYmd1 = BizDate.valueOf(20150525);
    private final static BizDate syoriYmd2 = BizDate.valueOf(20150425);
    private final static BizDate syoriYmd3 = BizDate.valueOf(20150112);



    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd2, subSystemId1);
        Assert.assertEquals(0, objectsLst.size());

        AS_SubSystem subSystem1 = new AS_SubSystem("01");
        AS_SubSystem subSystem2 = new AS_SubSystem("02");
        AS_SubSystem subSystem3 = new AS_SubSystem("03");
        AS_SubSystem subSystem4 = new AS_SubSystem("04");
        AS_SubSystem subSystem5 = new AS_SubSystem("05");
        baseDomManager.insert(subSystem1);
        baseDomManager.insert(subSystem2);
        baseDomManager.insert(subSystem3);
        baseDomManager.insert(subSystem4);
        baseDomManager.insert(subSystem5);

        AS_Kinou kinou1 = new AS_Kinou();
        kinou1.setKinouId("101");
        kinou1.setSubSystemId("01");
        kinou1.setKinouNm(null);
        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou();
        kinou2.setKinouId("102");
        kinou2.setSubSystemId("01");
        kinou2.setKinouNm("機能名1");
        baseDomManager.insert(kinou2);

        AS_Kinou kinou4 = new AS_Kinou();
        kinou4.setKinouId("104");
        kinou4.setSubSystemId("01");
        kinou4.setKinouNm("機能名3");
        baseDomManager.insert(kinou4);

        AS_Kinou kinou5 = new AS_Kinou();
        kinou5.setKinouId("105");
        kinou5.setSubSystemId("01");
        kinou5.setKinouNm("機能名6");
        baseDomManager.insert(kinou5);

        AS_Kinou kinou6 = new AS_Kinou();
        kinou6.setKinouId("106");
        kinou6.setSubSystemId("01");
        kinou6.setKinouNm("機能名2");
        baseDomManager.insert(kinou6);

        AS_Kinou kinou7 = new AS_Kinou();
        kinou7.setKinouId("107");
        kinou7.setSubSystemId("01");
        kinou7.setKinouNm("機能名2");
        baseDomManager.insert(kinou7);

        AS_Kinou kinou9 = new AS_Kinou();
        kinou9.setKinouId("109");
        kinou9.setSubSystemId("01");
        kinou9.setKinouNm("機能名4");
        baseDomManager.insert(kinou9);

        AS_Kinou kinou10 = new AS_Kinou();
        kinou10.setKinouId("110");
        kinou10.setSubSystemId("01");
        kinou10.setKinouNm("機能名7");
        baseDomManager.insert(kinou10);

        AS_Kinou kinou11 = new AS_Kinou();
        kinou11.setKinouId("111");
        kinou11.setSubSystemId("01");
        kinou11.setKinouNm("機能名8");
        baseDomManager.insert(kinou11);

        AS_Kinou kinou12 = new AS_Kinou();
        kinou12.setKinouId("112");
        kinou12.setSubSystemId("01");
        kinou12.setKinouNm("機能名9");
        baseDomManager.insert(kinou12);

        AS_Kinou kinou13 = new AS_Kinou();
        kinou13.setKinouId("114");
        kinou13.setSubSystemId("02");
        kinou13.setKinouNm("機能名14");
        baseDomManager.insert(kinou13);

        AS_Kinou kinou14 = new AS_Kinou();
        kinou14.setKinouId("201");
        kinou14.setSubSystemId("03");
        kinou14.setKinouNm("機能名21");
        baseDomManager.insert(kinou14);

        AS_Kinou kinou15 = new AS_Kinou();
        kinou15.setKinouId("203");
        kinou15.setSubSystemId("04");
        kinou15.setKinouNm("機能名22");
        baseDomManager.insert(kinou15);

        AS_Kinou kinou16 = new AS_Kinou();
        kinou16.setKinouId("204");
        kinou16.setSubSystemId("05");
        kinou16.setKinouNm("機能名22");
        baseDomManager.insert(kinou16);

        AS_Kinou kinou17 = new AS_Kinou();
        kinou17.setKinouId("205");
        kinou17.setSubSystemId("05");
        kinou17.setKinouNm("機能名23");
        baseDomManager.insert(kinou17);

        AS_Kinou kinou18 = new AS_Kinou();
        kinou18.setKinouId("206");
        kinou18.setSubSystemId("05");
        kinou18.setKinouNm("機能名24");
        baseDomManager.insert(kinou18);

        BT_KinouHukaInfo kinouHukaInfo1 = new BT_KinouHukaInfo();
        kinouHukaInfo1.setKinouId("101");
        kinouHukaInfo1.setKensuuhyoujijyun(2);
        bizDomManager.insert(kinouHukaInfo1);

        BT_KinouHukaInfo kinouHukaInfo2 = new BT_KinouHukaInfo();
        kinouHukaInfo2.setKinouId("102");
        kinouHukaInfo2.setKensuuhyoujijyun(0);
        bizDomManager.insert(kinouHukaInfo2);

        BT_KinouHukaInfo kinouHukaInfo4 = new BT_KinouHukaInfo();
        kinouHukaInfo4.setKinouId("104");
        kinouHukaInfo4.setKensuuhyoujijyun(4);
        bizDomManager.insert(kinouHukaInfo4);

        BT_KinouHukaInfo kinouHukaInfo5 = new BT_KinouHukaInfo();
        kinouHukaInfo5.setKinouId("105");
        kinouHukaInfo5.setKensuuhyoujijyun(3);
        bizDomManager.insert(kinouHukaInfo5);

        BT_KinouHukaInfo kinouHukaInfo6 = new BT_KinouHukaInfo();
        kinouHukaInfo6.setKinouId("106");
        kinouHukaInfo6.setKensuuhyoujijyun(4);
        bizDomManager.insert(kinouHukaInfo6);

        BT_KinouHukaInfo kinouHukaInfo7 = new BT_KinouHukaInfo();
        kinouHukaInfo7.setKinouId("107");
        kinouHukaInfo7.setKensuuhyoujijyun(-1);
        bizDomManager.insert(kinouHukaInfo7);

        BT_KinouHukaInfo kinouHukaInfo9 = new BT_KinouHukaInfo();
        kinouHukaInfo9.setKinouId("109");
        kinouHukaInfo9.setKensuuhyoujijyun(1);
        bizDomManager.insert(kinouHukaInfo9);

        BT_KinouHukaInfo kinouHukaInfo10 = new BT_KinouHukaInfo();
        kinouHukaInfo10.setKinouId("110");
        kinouHukaInfo10.setKensuuhyoujijyun(7);
        bizDomManager.insert(kinouHukaInfo10);

        BT_KinouHukaInfo kinouHukaInfo11 = new BT_KinouHukaInfo();
        kinouHukaInfo11.setKinouId("111");
        kinouHukaInfo11.setKensuuhyoujijyun(6);
        bizDomManager.insert(kinouHukaInfo11);

        BT_KinouHukaInfo kinouHukaInfo15 = new BT_KinouHukaInfo();
        kinouHukaInfo15.setKinouId("119");
        kinouHukaInfo15.setKensuuhyoujijyun(2);
        bizDomManager.insert(kinouHukaInfo15);

        BT_KinouHukaInfo kinouHukaInfo16 = new BT_KinouHukaInfo();
        kinouHukaInfo16.setKinouId("120");
        kinouHukaInfo16.setKensuuhyoujijyun(1);
        bizDomManager.insert(kinouHukaInfo16);

        BT_KinouHukaInfo kinouHukaInfo12 = new BT_KinouHukaInfo();
        kinouHukaInfo12.setKinouId("115");
        kinouHukaInfo12.setKensuuhyoujijyun(9);
        bizDomManager.insert(kinouHukaInfo12);

        BT_KinouHukaInfo kinouHukaInfo13 = new BT_KinouHukaInfo();
        kinouHukaInfo13.setKinouId("201");
        kinouHukaInfo13.setKensuuhyoujijyun(10);
        bizDomManager.insert(kinouHukaInfo13);

        BT_KinouHukaInfo kinouHukaInfo14 = new BT_KinouHukaInfo();
        kinouHukaInfo14.setKinouId("202");
        kinouHukaInfo14.setKensuuhyoujijyun(9);
        bizDomManager.insert(kinouHukaInfo14);

        BT_KinouHukaInfo kinouHukaInfo18 = new BT_KinouHukaInfo();
        kinouHukaInfo18.setKinouId("204");
        kinouHukaInfo18.setKensuuhyoujijyun(9);
        bizDomManager.insert(kinouHukaInfo18);

        BT_KinouHukaInfo kinouHukaInfo19 = new BT_KinouHukaInfo();
        kinouHukaInfo19.setKinouId("205");
        kinouHukaInfo19.setKensuuhyoujijyun(7);
        bizDomManager.insert(kinouHukaInfo19);

        BT_KinouHukaInfo kinouHukaInfo17 = new BT_KinouHukaInfo();
        kinouHukaInfo17.setKinouId("206");
        kinouHukaInfo17.setKensuuhyoujijyun(8);
        bizDomManager.insert(kinouHukaInfo17);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000003");
        if (null == kykKihon1) {

            kykKihon1 = new IT_KykKihon("10000000003");

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("20141210143615501");
            khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki1.setGyoumuKousinKinou(null);

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("20141210143615502");
            khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki2.setGyoumuKousinKinou("101");

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("20141210143615503");
            khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki3.setGyoumuKousinKinou("101");

            IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki4.setHenkousikibetukey("20141210143615504");
            khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki4.setGyoumuKousinKinou("102");

            IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki5.setHenkousikibetukey("20141210143615505");
            khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki5.setGyoumuKousinKinou("102");

            IT_KhTtdkRireki khTtdkRireki6 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki6.setHenkousikibetukey("20141210143615506");
            khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki6.setGyoumuKousinKinou("103");

            IT_KhTtdkRireki khTtdkRireki7 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki7.setHenkousikibetukey("20141210143615507");
            khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki7.setGyoumuKousinKinou("104");

            IT_KhTtdkRireki khTtdkRireki8 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki8.setHenkousikibetukey("20141210143615508");
            khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki8.setGyoumuKousinKinou("105");

            IT_KhTtdkRireki khTtdkRireki9 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki9.setHenkousikibetukey("20141210143615509");
            khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki9.setGyoumuKousinKinou("106");

            IT_KhTtdkRireki khTtdkRireki16 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki16.setHenkousikibetukey("20141210143615516");
            khTtdkRireki16.setSyoriYmd(BizDate.valueOf(20150426));
            khTtdkRireki16.setGyoumuKousinKinou("106");

            IT_KhTtdkRireki khTtdkRireki17 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki17.setHenkousikibetukey("20141210143615517");
            khTtdkRireki17.setSyoriYmd(BizDate.valueOf(20150424));
            khTtdkRireki17.setGyoumuKousinKinou("106");

            IT_KhTtdkRireki khTtdkRireki18 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki18.setHenkousikibetukey("20141210143615518");
            khTtdkRireki18.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki18.setGyoumuKousinKinou("106");

            IT_KhTtdkRireki khTtdkRireki19 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki19.setHenkousikibetukey("20141210143615519");
            khTtdkRireki19.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki19.setGyoumuKousinKinou("106");

            IT_KhTtdkRireki khTtdkRireki10 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki10.setHenkousikibetukey("20141210143615510");
            khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki10.setGyoumuKousinKinou("107");

            IT_KhTtdkRireki khTtdkRireki11 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki11.setHenkousikibetukey("20141210143615511");
            khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki11.setGyoumuKousinKinou("108");

            IT_KhTtdkRireki khTtdkRireki12 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki12.setHenkousikibetukey("20141210143615512");
            khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki12.setGyoumuKousinKinou("109");

            IT_KhTtdkRireki khTtdkRireki13 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki13.setHenkousikibetukey("20141210143615513");
            khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki13.setGyoumuKousinKinou("110");

            IT_KhTtdkRireki khTtdkRireki14 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki14.setHenkousikibetukey("20141210143615514");
            khTtdkRireki14.setSyoriYmd(BizDate.valueOf(20150501));
            khTtdkRireki14.setGyoumuKousinKinou("113");

            IT_KhTtdkRireki khTtdkRireki15 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki15.setHenkousikibetukey("20141210143615515");
            khTtdkRireki15.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki15.setGyoumuKousinKinou("114");

            IT_KhTtdkRireki khTtdkRireki20 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki20.setHenkousikibetukey("20141210143615520");
            khTtdkRireki20.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki20.setGyoumuKousinKinou("119");

            IT_KhTtdkRireki khTtdkRireki21 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki21.setHenkousikibetukey("20141210143615521");
            khTtdkRireki21.setSyoriYmd(BizDate.valueOf(20150425));
            khTtdkRireki21.setGyoumuKousinKinou("120");

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000004");
        if (null == kykKihon2) {

            kykKihon2 = new IT_KykKihon("10000000004");

            IT_KhTtdkRireki khTtdkRireki13 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki13.setHenkousikibetukey("20141210143615501");
            khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20150112));
            khTtdkRireki13.setGyoumuKousinKinou("201");

            IT_KhTtdkRireki khTtdkRireki14 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki14.setHenkousikibetukey("20141210143615502");
            khTtdkRireki14.setSyoriYmd(BizDate.valueOf(20150112));
            khTtdkRireki14.setGyoumuKousinKinou("null");

            IT_KhTtdkRireki khTtdkRireki15 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki15.setHenkousikibetukey("20141210143615503");
            khTtdkRireki15.setSyoriYmd(BizDate.valueOf(20150113));
            khTtdkRireki15.setGyoumuKousinKinou("202");

            hozenDomManager.insert(kykKihon2);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllKinous());
        baseDomManager.delete(baseDomManager.getAllSubSystems());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKinouHukaInfo());

    }


    @Test
    @TestOrder(10)
    public void noResult1() {
        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd1, subSystemId0);
        Assert.assertEquals(0, objectsLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd3, subSystemId3);
        Assert.assertEquals(1, objectsLst.size());

        Assert.assertEquals("機能名21", objectsLst.get(0)[0]);
        Assert.assertEquals(new Long(1), objectsLst.get(0)[1]);

    }

    @Test

    @TestOrder(30)
    public void normal2() {
        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(
            BizDate.valueOf(20150419), subSystemId5);
        Assert.assertEquals(3, objectsLst.size());

        Assert.assertEquals("機能名23", objectsLst.get(0)[0]);
        Assert.assertEquals(new Long(0), objectsLst.get(0)[1]);

        Assert.assertEquals("機能名24", objectsLst.get(1)[0]);
        Assert.assertEquals(new Long(0), objectsLst.get(1)[1]);

        Assert.assertEquals("機能名22", objectsLst.get(2)[0]);
        Assert.assertEquals(new Long(0), objectsLst.get(2)[1]);

    }


    @Test

    @TestOrder(40)
    public void normal3() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("機能名2",new Long(3)), "1");
        map.put($("機能名3",new Long(1)), "1");

        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd2, subSystemId1);
        Assert.assertEquals(7, objectsLst.size());

        Assert.assertEquals("機能名4", objectsLst.get(0)[0]);
        Assert.assertEquals(new Long(1), objectsLst.get(0)[1]);

        Assert.assertEquals(null, objectsLst.get(1)[0]);
        Assert.assertEquals(new Long(2), objectsLst.get(1)[1]);

        Assert.assertEquals("機能名6", objectsLst.get(2)[0]);
        Assert.assertEquals(new Long(1), objectsLst.get(2)[1]);

        assertTrue(map.containsKey($(objectsLst.get(3)[0], objectsLst.get(3)[1])));
        assertTrue(map.containsKey($(objectsLst.get(4)[0], objectsLst.get(4)[1])));

        map.remove($(objectsLst.get(3)[0], objectsLst.get(3)[1]));
        map.remove($(objectsLst.get(4)[0], objectsLst.get(4)[1]));

        assertTrue(map.isEmpty());

        Assert.assertEquals("機能名8", objectsLst.get(5)[0]);
        Assert.assertEquals(new Long(0), objectsLst.get(5)[1]);

        Assert.assertEquals("機能名7", objectsLst.get(6)[0]);
        Assert.assertEquals(new Long(1), objectsLst.get(6)[1]);

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {
        List<Object[]> objectsLst = hozenDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd2, "");
        Assert.assertEquals(0, objectsLst.size());
    }

}
