package yuyu.def.hozen.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcditemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 *（契約ＭＦヒストリーＦ）手数料情報作成<br />
 * 手数料情報Beanリスト（大量）取得　拡張ジョブコードかつ処理年月日などのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getTesuuryouInfosByKakutyoujobcditems {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_Tesuuryou tesuuryou1 = kykKihon1.createTesuuryou();
        tesuuryou1.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou1.setRenno(1);
        tesuuryou1.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou1.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou1.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn1 = tesuuryou1.createTesuuryouSyouhn();
        tesuuryouSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn1.setSyouhncd("A100");
        tesuuryouSyouhn1.setSyouhnsdno(10);
        tesuuryouSyouhn1.setKyksyouhnrenno(1);

        IT_TesuuryouSyouhn tesuuryouSyouhn2 = tesuuryou1.createTesuuryouSyouhn();
        tesuuryouSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        tesuuryouSyouhn2.setSyouhncd("A100");
        tesuuryouSyouhn2.setSyouhnsdno(10);
        tesuuryouSyouhn2.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou2 = kykKihon1.createTesuuryou();
        tesuuryou2.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou2.setRenno(2);
        tesuuryou2.setSyoriYmd(BizDate.valueOf(20151009));
        tesuuryou2.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou2.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn21 = tesuuryou2.createTesuuryouSyouhn();
        tesuuryouSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn21.setSyouhncd("A100");
        tesuuryouSyouhn21.setSyouhnsdno(10);
        tesuuryouSyouhn21.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou3 = kykKihon1.createTesuuryou();
        tesuuryou3.setTsrysyorikbn(C_TsrysyoriKbn.SIBOU);
        tesuuryou3.setRenno(1);
        tesuuryou3.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou3.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou3.setGyoumuKousinTime("20161009130800100");

        IT_Tesuuryou tesuuryou4 = kykKihon1.createTesuuryou();
        tesuuryou4.setTsrysyorikbn(C_TsrysyoriKbn.KEIYAKUTORIKESI);
        tesuuryou4.setRenno(1);
        tesuuryou4.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou4.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou4.setGyoumuKousinTime("20161009130800100");

        IT_Tesuuryou tesuuryou5 = kykKihon1.createTesuuryou();
        tesuuryou5.setTsrysyorikbn(C_TsrysyoriKbn.CLGOFF);
        tesuuryou5.setRenno(1);
        tesuuryou5.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou5.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou5.setGyoumuKousinTime("20161009130800100");

        IT_Tesuuryou tesuuryou7 = kykKihon1.createTesuuryou();
        tesuuryou7.setTsrysyorikbn(C_TsrysyoriKbn.SEINENGAPPISEI);
        tesuuryou7.setRenno(1);
        tesuuryou7.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou7.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou7.setGyoumuKousinTime("20161009130800100");

        IT_Tesuuryou tesuuryou8 = kykKihon1.createTesuuryou();
        tesuuryou8.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou8.setRenno(3);
        tesuuryou8.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou8.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou8.setGyoumuKousinTime("20161009130800100");

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_Tesuuryou tesuuryou6 = kykKihon2.createTesuuryou();
        tesuuryou6.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou6.setRenno(1);
        tesuuryou6.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou6.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou6.setGyoumuKousinTime("20161009130800100");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSya kykSya2 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon3.createHhknSya();

        IT_KykDairiten kykDairiten2 = kykKihon3.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_Tesuuryou tesuuryou9 = kykKihon4.createTesuuryou();
        tesuuryou9.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou9.setRenno(1);
        tesuuryou9.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou9.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou9.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn3 = tesuuryou9.createTesuuryouSyouhn();
        tesuuryouSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn3.setSyouhncd("A100");
        tesuuryouSyouhn3.setSyouhnsdno(10);
        tesuuryouSyouhn3.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon4.createHhknSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_Tesuuryou tesuuryou10 = kykKihon5.createTesuuryou();
        tesuuryou10.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou10.setRenno(1);
        tesuuryou10.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou10.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou10.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn4 = tesuuryou10.createTesuuryouSyouhn();
        tesuuryouSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn4.setSyouhncd("A100");
        tesuuryouSyouhn4.setSyouhnsdno(10);
        tesuuryouSyouhn4.setKyksyouhnrenno(1);

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_KykDairiten kykDairiten3 = kykKihon5.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_Tesuuryou tesuuryou11 = kykKihon6.createTesuuryou();
        tesuuryou11.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou11.setRenno(1);
        tesuuryou11.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou11.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou11.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn5 = tesuuryou11.createTesuuryouSyouhn();
        tesuuryouSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn5.setSyouhncd("A100");
        tesuuryouSyouhn5.setSyouhnsdno(10);
        tesuuryouSyouhn5.setKyksyouhnrenno(1);

        IT_HhknSya hhknSya4 = kykKihon6.createHhknSya();

        IT_KykDairiten kykDairiten4 = kykKihon6.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_Tesuuryou tesuuryou12 = kykKihon7.createTesuuryou();
        tesuuryou12.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou12.setRenno(1);
        tesuuryou12.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou12.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou12.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn6 = tesuuryou12.createTesuuryouSyouhn();
        tesuuryouSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn6.setSyouhncd("A100");
        tesuuryouSyouhn6.setSyouhnsdno(10);
        tesuuryouSyouhn6.setKyksyouhnrenno(1);

        IT_KykSya kykSya5 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya5 = kykKihon7.createHhknSya();

        IT_KykDairiten kykDairiten5 = kykKihon7.createKykDairiten();
        kykDairiten5.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20171009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {


        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            int iCount = 0;
            Iterator<TesuuryouInfosByKakutyoujobcditemsBean> iter = exDBResBean.iterator();
            TesuuryouInfosByKakutyoujobcditemsBean tKTBSDbean = null;
            while (iter.hasNext()) {

                tKTBSDbean = iter.next();
                iCount++;

                Assert.assertEquals("01", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_Tesuuryou().getSyono());
                Assert.assertEquals(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                Assert.assertEquals(1, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                Assert.assertEquals(BizDateYM.valueOf(201610), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                Assert.assertEquals("20161009130800100", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                Assert.assertEquals("01", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                Assert.assertEquals(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("01", tKTBSDbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", tKTBSDbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykSya().getSyono());

                Assert.assertEquals("01", tKTBSDbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_HhknSya().getSyono());

                Assert.assertEquals("01", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykDairiten().getSyono());
                Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("03", "11807111130");

        IT_Tesuuryou tesuuryou1 = kykKihon1.createTesuuryou();
        tesuuryou1.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
        tesuuryou1.setRenno(1);
        tesuuryou1.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou1.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou1.setGyoumuKousinTime("20161009130800101");

        IT_TesuuryouSyouhn tesuuryouSyouhn1 = tesuuryou1.createTesuuryouSyouhn();
        tesuuryouSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn1.setSyouhncd("A100");
        tesuuryouSyouhn1.setSyouhnsdno(10);
        tesuuryouSyouhn1.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou2 = kykKihon1.createTesuuryou();
        tesuuryou2.setTsrysyorikbn(C_TsrysyoriKbn.SEINENGAPPISEI);
        tesuuryou2.setRenno(2);
        tesuuryou2.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou2.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou2.setGyoumuKousinTime("20161009130800102");

        IT_TesuuryouSyouhn tesuuryouSyouhn2 = tesuuryou2.createTesuuryouSyouhn();
        tesuuryouSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn2.setSyouhncd("A100");
        tesuuryouSyouhn2.setSyouhnsdno(10);
        tesuuryouSyouhn2.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou3 = kykKihon1.createTesuuryou();
        tesuuryou3.setTsrysyorikbn(C_TsrysyoriKbn.GENGAKU);
        tesuuryou3.setRenno(3);
        tesuuryou3.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou3.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou3.setGyoumuKousinTime("20161009130800103");

        IT_TesuuryouSyouhn tesuuryouSyouhn3 = tesuuryou3.createTesuuryouSyouhn();
        tesuuryouSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn3.setSyouhncd("A100");
        tesuuryouSyouhn3.setSyouhnsdno(10);
        tesuuryouSyouhn3.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou4 = kykKihon1.createTesuuryou();
        tesuuryou4.setTsrysyorikbn(C_TsrysyoriKbn.KAIJO);
        tesuuryou4.setRenno(4);
        tesuuryou4.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou4.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou4.setGyoumuKousinTime("20161009130800104");

        IT_TesuuryouSyouhn tesuuryouSyouhn4 = tesuuryou4.createTesuuryouSyouhn();
        tesuuryouSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn4.setSyouhncd("A100");
        tesuuryouSyouhn4.setSyouhnsdno(10);
        tesuuryouSyouhn4.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou5 = kykKihon1.createTesuuryou();
        tesuuryou5.setTsrysyorikbn(C_TsrysyoriKbn.MUKOU);
        tesuuryou5.setRenno(5);
        tesuuryou5.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou5.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou5.setGyoumuKousinTime("20161009130800105");

        IT_TesuuryouSyouhn tesuuryouSyouhn5 = tesuuryou5.createTesuuryouSyouhn();
        tesuuryouSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn5.setSyouhncd("A100");
        tesuuryouSyouhn5.setSyouhnsdno(10);
        tesuuryouSyouhn5.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou6 = kykKihon1.createTesuuryou();
        tesuuryou6.setTsrysyorikbn(C_TsrysyoriKbn.KAIYAKU);
        tesuuryou6.setRenno(6);
        tesuuryou6.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou6.setBosyuuym(BizDateYM.valueOf(201608));
        tesuuryou6.setGyoumuKousinTime("20161009130800106");

        IT_TesuuryouSyouhn tesuuryouSyouhn6 = tesuuryou6.createTesuuryouSyouhn();
        tesuuryouSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn6.setSyouhncd("A100");
        tesuuryouSyouhn6.setSyouhnsdno(10);
        tesuuryouSyouhn6.setKyksyouhnrenno(1);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_Tesuuryou tesuuryou7 = kykKihon2.createTesuuryou();
        tesuuryou7.setTsrysyorikbn(C_TsrysyoriKbn.KEIYAKUTORIKESI);
        tesuuryou7.setRenno(7);
        tesuuryou7.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou7.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou7.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn7 = tesuuryou7.createTesuuryouSyouhn();
        tesuuryouSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn7.setSyouhncd("A100");
        tesuuryouSyouhn7.setSyouhnsdno(10);
        tesuuryouSyouhn7.setKyksyouhnrenno(1);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("01", "11807111118");

        IT_Tesuuryou tesuuryou8 = kykKihon3.createTesuuryou();
        tesuuryou8.setTsrysyorikbn(C_TsrysyoriKbn.KEIYAKUTORIKESI);
        tesuuryou8.setRenno(8);
        tesuuryou8.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou8.setBosyuuym(BizDateYM.valueOf(201609));
        tesuuryou8.setGyoumuKousinTime("20161009130800100");

        IT_TesuuryouSyouhn tesuuryouSyouhn8 = tesuuryou8.createTesuuryouSyouhn();
        tesuuryouSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn8.setSyouhncd("A100");
        tesuuryouSyouhn8.setSyouhnsdno(10);
        tesuuryouSyouhn8.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou9 = kykKihon3.createTesuuryou();
        tesuuryou9.setTsrysyorikbn(C_TsrysyoriKbn.CLGOFF);
        tesuuryou9.setRenno(9);
        tesuuryou9.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou9.setBosyuuym(BizDateYM.valueOf(201610));
        tesuuryou9.setGyoumuKousinTime("20161009130800099");

        IT_TesuuryouSyouhn tesuuryouSyouhn9 = tesuuryou9.createTesuuryouSyouhn();
        tesuuryouSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn9.setSyouhncd("A100");
        tesuuryouSyouhn9.setSyouhnsdno(10);
        tesuuryouSyouhn9.setKyksyouhnrenno(1);

        IT_Tesuuryou tesuuryou10 = kykKihon3.createTesuuryou();
        tesuuryou10.setTsrysyorikbn(C_TsrysyoriKbn.CLGOFF);
        tesuuryou10.setRenno(10);
        tesuuryou10.setSyoriYmd(BizDate.valueOf(20161009));
        tesuuryou10.setBosyuuym(BizDateYM.valueOf(201609));
        tesuuryou10.setGyoumuKousinTime("20161009130800098");

        IT_TesuuryouSyouhn tesuuryouSyouhn10 = tesuuryou10.createTesuuryouSyouhn();
        tesuuryouSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        tesuuryouSyouhn10.setSyouhncd("A100");
        tesuuryouSyouhn10.setSyouhnsdno(10);
        tesuuryouSyouhn10.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon3);
    }

    @Test
    @TestOrder(31)
    public void normal31() {


        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            int iCount = 0;
            Iterator<TesuuryouInfosByKakutyoujobcditemsBean> iter = exDBResBean.iterator();
            TesuuryouInfosByKakutyoujobcditemsBean tKTBSDbean = null;
            while (iter.hasNext()) {

                tKTBSDbean = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("01", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.CLGOFF, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(10, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201609), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800098", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("01", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.CLGOFF, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("01", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.CLGOFF, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(9, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201610), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800099", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("01", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.CLGOFF, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(9, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("01", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KEIYAKUTORIKESI, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(8, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201609), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800100", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("01", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KEIYAKUTORIKESI, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(8, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("01", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111118", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("02", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KEIYAKUTORIKESI, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(7, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201610), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800100", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("02", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KEIYAKUTORIKESI, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(7, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("02", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("02", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("02", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("02", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111129", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }



                if (5 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(1, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800101", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.SEINENGAPPISEI, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(2, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800102", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.SEINENGAPPISEI, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(2, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.GENGAKU, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(3, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800103", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.GENGAKU, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(3, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KAIJO, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(4, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800104", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KAIJO, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(4, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.MUKOU, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(5, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800105", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.MUKOU, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(5, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("03", tKTBSDbean.getIT_Tesuuryou().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_Tesuuryou().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KAIYAKU, tKTBSDbean.getIT_Tesuuryou().getTsrysyorikbn());
                    Assert.assertEquals(6, tKTBSDbean.getIT_Tesuuryou().getRenno().intValue());
                    Assert.assertEquals(BizDate.valueOf(20161009), tKTBSDbean.getIT_Tesuuryou().getSyoriYmd());
                    Assert.assertEquals(BizDateYM.valueOf(201608), tKTBSDbean.getIT_Tesuuryou().getBosyuuym());
                    Assert.assertEquals("20161009130800106", tKTBSDbean.getIT_Tesuuryou().getGyoumuKousinTime());

                    Assert.assertEquals("03", tKTBSDbean.getIT_TesuuryouSyouhn().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_TesuuryouSyouhn().getSyono());
                    Assert.assertEquals(C_TsrysyoriKbn.KAIYAKU, tKTBSDbean.getIT_TesuuryouSyouhn().getTsrysyorikbn());
                    Assert.assertEquals(6, tKTBSDbean.getIT_TesuuryouSyouhn().getRenno().intValue());
                    Assert.assertEquals(C_SyutkKbn.SYU, tKTBSDbean.getIT_TesuuryouSyouhn().getSyutkkbn());
                    Assert.assertEquals("A100", tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhncd());
                    Assert.assertEquals(10, tKTBSDbean.getIT_TesuuryouSyouhn().getSyouhnsdno().intValue());
                    Assert.assertEquals(1, tKTBSDbean.getIT_TesuuryouSyouhn().getKyksyouhnrenno().intValue());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("03", tKTBSDbean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111130", tKTBSDbean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(1, tKTBSDbean.getIT_KykDairiten().getDrtenrenno().intValue());

                    continue;
                }
            }
            Assert.assertEquals(10, iCount);
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            int iCount = 0;
            Iterator<TesuuryouInfosByKakutyoujobcditemsBean> iter = exDBResBean.iterator();
            while (iter.hasNext()) {

                iter.next();
                iCount++;
            }

            Assert.assertEquals(10, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBO0");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("01");
        skipKey1.setRecoveryfilterkey2("11807111118");

        hozenDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            int iCount = 0;
            for (TesuuryouInfosByKakutyoujobcditemsBean tKTBSDbean : exDBResBean) {

                Assert.assertNotEquals(tKTBSDbean.getIT_KykKihon().getSyono(), "11807111118");

                iCount++;
            }

            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBO0");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("02");
        skipKey2.setRecoveryfilterkey2("11807111129");

        hozenDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try(ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResBean = hozenDomManager.
            getTesuuryouInfosByKakutyoujobcditems("RBO0", BizDate.valueOf(20161009), BizDateYM.valueOf(201609), C_SyutkKbn.SYU)) {

            int iCount = 0;
            for (TesuuryouInfosByKakutyoujobcditemsBean tKTBSDbean : exDBResBean) {

                Assert.assertNotEquals(tKTBSDbean.getIT_KykKihon().getSyono(), "11807111118");
                Assert.assertNotEquals(tKTBSDbean.getIT_KykKihon().getSyono(), "11807111129");

                iCount++;
            }

            Assert.assertEquals(6, iCount);
        }
    }
}
