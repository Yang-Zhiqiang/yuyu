package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";

    private final static String[] gyoumuKousinKinou1 = {"qwert","qdvfr"};
    private final static String[] gyoumuKousinKinou2 = {"12345","qdvfr"};
    private final static String[] gyoumuKousinKinou3 = {"asdfg","qazws","qwsxc"};
    private final static String[] gyoumuKousinKinou4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou1);

        int iCount = 0;
        for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20141210143615501");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki1.setGyoumuKousinKinou("qwert");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20141210143615502");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160320));
        khTtdkRireki2.setGyoumuKousinKinou("qwert");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20141210143615503");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki3.setGyoumuKousinKinou("zxcvb");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("20141210143615506");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki11.setGyoumuKousinKinou("asdfg");

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("20141210143615505");
        khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki12.setGyoumuKousinKinou("qazws");

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("20141210143615504");
        khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki13.setGyoumuKousinKinou("qwsxc");

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20141210143615501");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki4.setGyoumuKousinKinou("qwert");

        IT_KykDairiten kykDairiten3 = kykKihon2.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20141210143615501");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki5.setGyoumuKousinKinou("qwert");

        IT_KykDairiten kykDairiten4 = kykKihon3.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn4 = kykKihon3.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk3 = kykKihon3.createKykSonotaTkyk();

        IT_HhknSya hhknSya2 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20141210143615501");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki6.setGyoumuKousinKinou("qwert");

        IT_KykDairiten kykDairiten5 = kykKihon4.createKykDairiten();
        kykDairiten5.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn5 = kykKihon4.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon4.createHhknSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("20141210143615501");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki7.setGyoumuKousinKinou("qwert");

        IT_KykDairiten kykDairiten6 = kykKihon5.createKykDairiten();
        kykDairiten6.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk4 = kykKihon5.createKykSonotaTkyk();

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_HhknSya hhknSya4 = kykKihon5.createHhknSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("20141210143615501");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki8.setGyoumuKousinKinou("qwert");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk5 = kykKihon6.createKykSonotaTkyk();

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_HhknSya hhknSya5 = kykKihon6.createHhknSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykDairiten kykDairiten7 = kykKihon7.createKykDairiten();
        kykDairiten7.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk6 = kykKihon7.createKykSonotaTkyk();

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon7.createHhknSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("00", "11807111406");

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("20141210143615506");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki9.setGyoumuKousinKinou("asdfg");

        IT_KykDairiten kykDairiten8 = kykKihon8.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn8.setSyouhncd("A100");
        kykSyouhn8.setSyouhnsdno(10);
        kykSyouhn8.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk7 = kykKihon8.createKykSonotaTkyk();

        IT_KykSya kykSya7 = kykKihon8.createKykSya();

        IT_HhknSya hhknSya7 = kykKihon8.createHhknSya();

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111392");

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("20141210143615506");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki10.setGyoumuKousinKinou("asdfg");

        IT_KykDairiten kykDairiten9 = kykKihon9.createKykDairiten();
        kykDairiten9.setDrtenrenno(1);

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn9.setSyouhncd("A100");
        kykSyouhn9.setSyouhnsdno(10);
        kykSyouhn9.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk8 = kykKihon9.createKykSonotaTkyk();

        IT_KykSya kykSya8 = kykKihon9.createKykSya();

        IT_HhknSya hhknSya8 = kykKihon9.createHhknSya();

        hozenDomManager.insert(kykKihon9);



    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou2);

        int iCount = 0;
        for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou1);

        int iCount = 0;
        for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", KHTRbean.getIT_KhTtdkRireki().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KhTtdkRireki().getSyono());
                Assert.assertEquals("20141210143615501", KHTRbean.getIT_KhTtdkRireki().getHenkousikibetukey());

                Assert.assertEquals("01", KHTRbean.getIT_KykDairiten().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KykDairiten().getSyono());
                Assert.assertEquals(1, KHTRbean.getIT_KykDairiten().getDrtenrenno().intValue());

                Assert.assertEquals("01", KHTRbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", KHTRbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, KHTRbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", KHTRbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(10, KHTRbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, KHTRbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("01", KHTRbean.getIT_KykSonotaTkyk().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KykSonotaTkyk().getSyono());

                Assert.assertEquals("01", KHTRbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_KykSya().getSyono());

                Assert.assertEquals("01", KHTRbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111118", KHTRbean.getIT_HhknSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("01","11807111118","20141210143615504","01","11807111118","1","01","11807111118","01","11807111118","1","A100","10","1","01","11807111118","01","11807111118","01","11807111118"), "1");
        datamap.put($("01","11807111118","20141210143615505","01","11807111118","1","01","11807111118","01","11807111118","1","A100","10","1","01","11807111118","01","11807111118","01","11807111118"), "2");
        datamap.put($("01","11807111118","20141210143615506","01","11807111118","1","01","11807111118","01","11807111118","1","A100","10","1","01","11807111118","01","11807111118","01","11807111118"), "3");
        datamap.put($("09","11807111392","20141210143615506","09","11807111392","1","09","11807111392","09","11807111392","1","A100","10","1","09","11807111392","09","11807111392","09","11807111392"), "4");
        datamap.put($("00","11807111406","20141210143615506","00","11807111406","1","00","11807111406","00","11807111406","1","A100","10","1","00","11807111406","00","11807111406","00","11807111406"), "5");

        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou3);

        int iCount = 0;
        for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {

            datamap.remove($(KHTRbean.getIT_KhTtdkRireki().getKbnkey(),
                KHTRbean.getIT_KhTtdkRireki().getSyono(),
                KHTRbean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                KHTRbean.getIT_KykDairiten().getKbnkey(),
                KHTRbean.getIT_KykDairiten().getSyono(),
                KHTRbean.getIT_KykDairiten().getDrtenrenno().intValue(),
                KHTRbean.getIT_KykKihon().getKbnkey(),
                KHTRbean.getIT_KykKihon().getSyono(),
                KHTRbean.getIT_KykSyouhn().getKbnkey(),
                KHTRbean.getIT_KykSyouhn().getSyono(),
                KHTRbean.getIT_KykSyouhn().getSyutkkbn(),
                KHTRbean.getIT_KykSyouhn().getSyouhncd(),
                KHTRbean.getIT_KykSyouhn().getSyouhnsdno().intValue(),
                KHTRbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
                KHTRbean.getIT_KykSonotaTkyk().getKbnkey(),
                KHTRbean.getIT_KykSonotaTkyk().getSyono(),
                KHTRbean.getIT_KykSya().getKbnkey(),
                KHTRbean.getIT_KykSya().getSyono(),
                KHTRbean.getIT_HhknSya().getKbnkey(),
                KHTRbean.getIT_HhknSya().getSyono()));

        }
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank() {

        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou4);

        int iCount = 0;
        for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(49)
    @Transactional
    public void testSkippedFilter49(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {

        int iCount = 0;
        try( ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous("RBO1", BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou3);){
            for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){

        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBO1");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("09");
        skipKey1.setRecoveryfilterkey2("11807111392");

        hozenDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try( ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous("RBO1", BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou3);){
            for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
                assertNotEquals(KHTRbean.getIT_HhknSya().getSyono(), "11807111392");
                iCount++;
            }
            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testSkippedFilter70(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A04");
        skipKey2.setKakutyoujobcd("RBO1");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("00");
        skipKey2.setRecoveryfilterkey2("11807111406");

        hozenDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(71)
    public void testSkippedFilter71(){

        int iCount = 0;
        try( ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> beans = hozenDomManager.
            getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous("RBO1", BizDate.valueOf(20160315), C_SyutkKbn.SYU, gyoumuKousinKinou3);){
            for (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean KHTRbean : beans) {
                assertNotEquals(KHTRbean.getIT_HhknSya().getSyono(), "11807111392");
                assertNotEquals(KHTRbean.getIT_HhknSya().getSyono(), "11807111406");

                iCount++;
            }
            assertEquals(3, iCount);
        }
    }
}


