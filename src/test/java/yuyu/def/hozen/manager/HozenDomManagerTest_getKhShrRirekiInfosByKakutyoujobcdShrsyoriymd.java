package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

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

import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            Assert.assertFalse(khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki1.createKhShrRireki();
        khShrRireki1.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki1.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("201609180002");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();
        khShrRireki2.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki2.setShrtysysyuruikbn(C_HtsiryosyuKbn.BLNK);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki3.createKhShrRireki();
        khShrRireki3.setShrsyoriymd(BizDate.valueOf(20160919));
        khShrRireki3.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(1);

        IT_KykSya kykSya4 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya4 = kykKihon4.createHhknSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki4 = khTtdkRireki6.createKhShrRireki();
        khShrRireki4.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki4.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki5 = khTtdkRireki7.createKhShrRireki();
        khShrRireki5.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki5.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("09", "11807111196");

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon7.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki6 = khTtdkRireki8.createKhShrRireki();
        khShrRireki6.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki6.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("00", "11807111200");

        IT_KykSyouhn kykSyouhn7 = kykKihon8.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(1);

        IT_KykSya kykSya7 = kykKihon8.createKykSya();

        IT_HhknSya hhknSya7 = kykKihon8.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki7 = khTtdkRireki9.createKhShrRireki();
        khShrRireki7.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki7.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon8);
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
        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20150918))){

            Assert.assertFalse(khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional()
    public void normal20() {

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            int iCount = 0;
            for (KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean bean : khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals("01", bean.getIT_KhShrRireki().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KhShrRireki().getSyono());
                    Assert.assertEquals("201609180001", bean.getIT_KhShrRireki().getHenkousikibetukey());

                    Assert.assertEquals("01", bean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("01", bean.getIT_KykSyouhn().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.SYU, bean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", bean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(10, bean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, bean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("01", bean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykSya().getSyono());

                    Assert.assertEquals("01", bean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("01", bean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("201609180001", bean.getIT_KhTtdkRireki().getHenkousikibetukey());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional()
    public void normal30() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki1.createKhShrRireki();
        khShrRireki3.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki3.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();
        khShrRireki2.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki2.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201609180001");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki3.createKhShrRireki();
        khShrRireki1.setShrsyoriymd(BizDate.valueOf(20160918));
        khShrRireki1.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

        hozenDomManager.insert(kykKihon3);
    }

    @Test
    @TestOrder(31)
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("01","11807111118","201609180001","01","11807111118","01","11807111118","1","A100","10","1","01","11807111118","01","11807111118","01","11807111118","201609180001"), "1");
        datamap.put($("02","11807111129","201609180001","02","11807111129","02","11807111129","1","A100","10","1","02","11807111129","02","11807111129","02","11807111129","201609180001"), "2");
        datamap.put($("03","11807111130","201609180001","03","11807111130","03","11807111130","1","A100","10","1","03","11807111130","03","11807111130","03","11807111130","201609180001"), "3");

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            for (KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean bean : khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst) {

                datamap.remove($(bean.getIT_KhShrRireki().getKbnkey(),
                    bean.getIT_KhShrRireki().getSyono(),
                    bean.getIT_KhShrRireki().getHenkousikibetukey(),
                    bean.getIT_KykKihon().getKbnkey(),
                    bean.getIT_KykKihon().getSyono(),
                    bean.getIT_KykSyouhn().getKbnkey(),
                    bean.getIT_KykSyouhn().getSyono(),
                    bean.getIT_KykSyouhn().getSyutkkbn(),
                    bean.getIT_KykSyouhn().getSyouhncd(),
                    bean.getIT_KykSyouhn().getSyouhnsdno().intValue(),
                    bean.getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
                    bean.getIT_KykSya().getKbnkey(),
                    bean.getIT_KykSya().getSyono(),
                    bean.getIT_HhknSya().getKbnkey(),
                    bean.getIT_HhknSya().getSyono(),
                    bean.getIT_KhTtdkRireki().getKbnkey(),
                    bean.getIT_KhTtdkRireki().getSyono(),
                    bean.getIT_KhTtdkRireki().getHenkousikibetukey()));
            }

            Assert.assertTrue(datamap.isEmpty());
        }
    }

    @Test
    @TestOrder(39)
    @Transactional()
    public void testSkippedFilter39() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            Iterator<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> iter = khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
    @Test
    @TestOrder(50)
    @Transactional()
    public void testSkippedFilter50() {

        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBG0");
        skipKey1.setTableid("IT_KhShrRireki");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("03");
        skipKey1.setRecoveryfilterkey2("11807111130");

        hozenDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            int iCount = 0;
            for (KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean bean : khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst) {

                assertNotEquals("11807111130", bean.getIT_KhShrRireki().getSyono());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional()
    public void testSkippedFilter60() {


        BT_SkipKey skipKey2 = new BT_SkipKey("A01");
        skipKey2.setKakutyoujobcd("RBG0");
        skipKey2.setTableid("IT_KhShrRireki");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("02");
        skipKey2.setRecoveryfilterkey2("11807111129");

        hozenDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst =
            hozenDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd("RBG0", BizDate.valueOf(20160918))){

            int iCount = 0;
            for (KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean bean : khShrRirekiInfosByKakutyoujobcdShrsyoriymdBeanLst) {

                assertNotEquals("11807111130", bean.getIT_KhShrRireki().getSyono());
                assertNotEquals("11807111129", bean.getIT_KhShrRireki().getSyono());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
