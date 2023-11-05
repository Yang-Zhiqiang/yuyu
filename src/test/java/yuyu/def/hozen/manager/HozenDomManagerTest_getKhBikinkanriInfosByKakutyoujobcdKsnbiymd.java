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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhBikinkanriInfosByKakutyoujobcdKsnbiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanriInfosByKakutyoujobcdKsnbiymd {

    @Inject
    HozenDomManager hozenDomManager;
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> beans = hozenDomManager.
            getKhBikinkanriInfosByKakutyoujobcdKsnbiymd("RBG0", BizDate.valueOf(20160215));

        int iCount = 0;
        for (KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean kHBean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("1001");
        kykSyouhn1.setSyouhnsdno(21);
        kykSyouhn1.setKyksyouhnrenno(31);

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki1.createKhShrRireki();
        khShrRireki1.setShrymd(BizDate.valueOf(20160216));
        khShrRireki1.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki1.setSyoruiukeymd(BizDate.valueOf(20160215));

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161002");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki4.createKhShrRireki();
        khShrRireki3.setShrymd(BizDate.valueOf(20160216));
        khShrRireki3.setShrsyorikbn(C_ShrsyoriKbn.BLNK);
        khShrRireki3.setSyoruiukeymd(BizDate.valueOf(20160215));

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20161004");

        IT_KhShrRireki khShrRireki4 = khTtdkRireki5.createKhShrRireki();
        khShrRireki4.setShrymd(BizDate.valueOf(20160215));
        khShrRireki4.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki4.setSyoruiukeymd(BizDate.valueOf(20160215));

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20161005");

        IT_KhShrRireki khShrRireki5 = khTtdkRireki6.createKhShrRireki();
        khShrRireki5.setShrymd(BizDate.valueOf(20160214));
        khShrRireki5.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki5.setSyoruiukeymd(BizDate.valueOf(20160215));

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("20161006");

        IT_KhShrRireki khShrRireki6 = khTtdkRireki7.createKhShrRireki();
        khShrRireki6.setShrymd(BizDate.valueOf(20160216));
        khShrRireki6.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki6.setSyoruiukeymd(BizDate.valueOf(20160216));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();
        khShrRireki2.setShrymd(BizDate.valueOf(20160216));
        khShrRireki2.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki2.setSyoruiukeymd(BizDate.valueOf(20160215));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn2 = kykKihon3.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(21);
        kykSyouhn2.setKyksyouhnrenno(31);

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("20161007");

        IT_KhShrRireki khShrRireki7 = khTtdkRireki8.createKhShrRireki();
        khShrRireki7.setShrymd(BizDate.valueOf(20161020));
        khShrRireki7.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki7.setSyoruiukeymd(BizDate.valueOf(20161019));

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn3 = kykKihon4.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1001");
        kykSyouhn3.setSyouhnsdno(21);
        kykSyouhn3.setKyksyouhnrenno(31);

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("20161008");

        IT_KhShrRireki khShrRireki8 = khTtdkRireki9.createKhShrRireki();
        khShrRireki8.setShrymd(BizDate.valueOf(20161021));
        khShrRireki8.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
        khShrRireki8.setSyoruiukeymd(BizDate.valueOf(20161018));

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("1001");
        kykSyouhn4.setSyouhnsdno(21);
        kykSyouhn4.setKyksyouhnrenno(31);

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("20161009");

        IT_KhShrRireki khShrRireki9 = khTtdkRireki10.createKhShrRireki();
        khShrRireki9.setShrymd(BizDate.valueOf(20161022));
        khShrRireki9.setShrsyorikbn(C_ShrsyoriKbn.GENGAKU);
        khShrRireki9.setSyoruiukeymd(BizDate.valueOf(20161017));

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn5 = kykKihon6.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("1001");
        kykSyouhn5.setSyouhnsdno(21);
        kykSyouhn5.setKyksyouhnrenno(31);

        hozenDomManager.insert(kykKihon6);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("1001", 21);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("1002", 21);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("1001", 22);

        bizDomManager.insert(syouhnZokusei3);

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160216), C_BkncdKbn.BLNK, BizDate.valueOf(20160312), 11);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111406", BizDate.valueOf(20160215), C_BkncdKbn.BLNK, BizDate.valueOf(20160312), 11);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111406", BizDate.valueOf(20160216), C_BkncdKbn.BLNK, BizDate.valueOf(20160312), 11);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160215), C_BkncdKbn.BLNK, BizDate.valueOf(20160312), 11);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.BLNK);

        hozenDomManager.insert(khBikinkanri4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> beans = hozenDomManager.
            getKhBikinkanriInfosByKakutyoujobcdKsnbiymd("RBG0", BizDate.valueOf(20170221));

        int iCount = 0;
        for (KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean kHBean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> beans = hozenDomManager.
            getKhBikinkanriInfosByKakutyoujobcdKsnbiymd("RBG0", BizDate.valueOf(20160215));

        int iCount = 0;
        for (KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean kHBean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", kHBean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", kHBean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", kHBean.getIT_KhTtdkRireki().getKbnkey());
                Assert.assertEquals("11807111118", kHBean.getIT_KhTtdkRireki().getSyono());
                Assert.assertEquals("20161001", kHBean.getIT_KhTtdkRireki().getHenkousikibetukey());

                Assert.assertEquals("01", kHBean.getIT_KhShrRireki().getKbnkey());
                Assert.assertEquals("11807111118", kHBean.getIT_KhShrRireki().getSyono());
                Assert.assertEquals("20161001", kHBean.getIT_KhShrRireki().getHenkousikibetukey());

                Assert.assertEquals("01", kHBean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", kHBean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, kHBean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1001", kHBean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(21, kHBean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(31, kHBean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("1001", kHBean.getBM_SyouhnZokusei().getSyouhncd());
                Assert.assertEquals(21, kHBean.getBM_SyouhnZokusei().getSyouhnsdno().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("03","11807111130","03","11807111130","20161007","03","11807111130","20161007","03","11807111130","1","1001","21","31","1001","21"), "1");
        datamap.put($("04","11807111141","04","11807111141","20161008","04","11807111141","20161008","04","11807111141","1","1001","21","31","1001","21"), "2");
        datamap.put($("05","11807111152","05","11807111152","20161009","05","11807111152","20161009","05","11807111152","1","1001","21","31","1001","21"), "3");

        ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> beans = hozenDomManager.
            getKhBikinkanriInfosByKakutyoujobcdKsnbiymd("RBG0", BizDate.valueOf(20161019));

        for (KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean kHBean : beans) {

            datamap.remove($(
                kHBean.getIT_KykKihon().getKbnkey(),
                kHBean.getIT_KykKihon().getSyono(),
                kHBean.getIT_KhShrRireki().getKbnkey(),
                kHBean.getIT_KhShrRireki().getSyono(),
                kHBean.getIT_KhShrRireki().getHenkousikibetukey(),
                kHBean.getIT_KhTtdkRireki().getKbnkey(),
                kHBean.getIT_KhTtdkRireki().getSyono(),
                kHBean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                kHBean.getIT_KykSyouhn().getKbnkey(),
                kHBean.getIT_KykSyouhn().getSyono(),
                kHBean.getIT_KykSyouhn().getSyutkkbn(),
                kHBean.getIT_KykSyouhn().getSyouhncd(),
                kHBean.getIT_KykSyouhn().getSyouhnsdno().intValue(),
                kHBean.getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
                kHBean.getBM_SyouhnZokusei().getSyouhncd(),
                kHBean.getBM_SyouhnZokusei().getSyouhnsdno().intValue()));
        }
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(39)
    @Transactional
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
    public void testSkippedFilter40() {

        int iCount = 0;
        try(ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> kHBean =
            hozenDomManager.getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(
                "RBG0", BizDate.valueOf(20161019));){
            for(KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean bean : kHBean){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RBG0");
        skipKey1.setTableid("IT_KykKihon");
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

        int iCount = 0;
        try(ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> kHBean =
            hozenDomManager.getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(
                "RBG0", BizDate.valueOf(20161019));){
            for(KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean bean : kHBean){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111130");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey skipKey2 = new BT_SkipKey("A02");
        skipKey2.setKakutyoujobcd("RBG0");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("04");
        skipKey2.setRecoveryfilterkey2("11807111141");

        hozenDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> kHBean =
            hozenDomManager.getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(
                "RBG0", BizDate.valueOf(20161019));){
            for(KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean bean : kHBean){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111130");
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111141");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}


