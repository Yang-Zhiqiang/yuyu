package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 基礎項目設定クラスのメソッド {@link SetKisoKoumoku#setkykymdHantei(HT_MosKihon, HT_MosSyouhn, BizDate,
        BizDate, BizDate, BizDate, C_SysKbn, C_YoteikykymdKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKisoKoumokuTest_setkykymdHantei {

    @Inject
    private SetKisoKoumoku setKisoKoumoku;

    @Test
    @TestOrder(10)
    public void testSetkykymdHantei_A1() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160401"));
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160420");
        BizDate syoriymd = BizDate.valueOf("20160420");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.SITEI;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160401"), "契約日");
    }

    @Test
    @TestOrder(20)
    public void testSetkykymdHantei_A2() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(null);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160414");
        BizDate syoriymd = BizDate.valueOf("20160420");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.SITEI;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(30)
    public void testSetkykymdHantei_A3() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160416"));
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160415");
        BizDate syoriymd = BizDate.valueOf("20160420");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(40)
    public void testSetkykymdHantei_A4() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160416"));
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160420");
        BizDate syoriymd = BizDate.valueOf("20160416");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160516"), "契約日");
    }

    @Test
    @TestOrder(50)
    public void testSetkykymdHantei_A5() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160416"));
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160420");
        BizDate syoriymd = BizDate.valueOf("20160401");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(60)
    public void testSetkykymdHantei_A6() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160416"));
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.NEN);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160401");
        BizDate syoriymd = BizDate.valueOf("20160420");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160401"), "契約日");
    }

    @Test
    @TestOrder(70)
    public void testSetkykymdHantei_A7() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = null;
        BizDate sknnkaisiymd = null;
        BizDate syoriymd = BizDate.valueOf("20160401");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160402"), "契約日");
    }

    @Test
    @TestOrder(80)
    public void testSetkykymdHantei_A8() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160527");
        BizDate sknnkaisiymd = BizDate.valueOf("20160602");
        BizDate syoriymd = BizDate.valueOf("20160531");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160606"), "契約日");
    }

    @Test
    @TestOrder(90)
    public void testSetkykymdHantei_A9() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20161223");
        BizDate sknnkaisiymd = BizDate.valueOf("20170101");
        BizDate syoriymd = BizDate.valueOf("20161231");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20170104"), "契約日");
    }

    @Test
    @TestOrder(100)
    public void testSetkykymdHantei_A10() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160222");
        BizDate sknnkaisiymd = BizDate.valueOf("20160301");
        BizDate syoriymd = BizDate.valueOf("20160228");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160301"), "契約日");
    }

    @Test
    @TestOrder(110)
    public void testSetkykymdHantei_A11() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160221");
        BizDate sknnkaisiymd = BizDate.valueOf("20160302");
        BizDate syoriymd = BizDate.valueOf("20160229");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160302"), "契約日");
    }

    @Test
    @TestOrder(120)
    public void testSetkykymdHantei_A12() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ｳ1");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20170221");
        BizDate sknnkaisiymd = BizDate.valueOf("20170228");
        BizDate syoriymd = BizDate.valueOf("20170228");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20170301"), "契約日");
    }

    @Test
    @TestOrder(130)
    public void testSetkykymdHantei_A13() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾍ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = null;
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(140)
    public void testSetkykymdHantei_A14() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160415");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(150)
    public void testSetkykymdHantei_A15() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160516"), "契約日");
    }

    @Test
    @TestOrder(160)
    public void testSetkykymdHantei_A16() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.KOUHURI);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = null;
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(170)
    public void testSetkykymdHantei_A17() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.KOUHURI);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20160301");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(180)
    public void testSetkykymdHantei_A18() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20160301");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(190)
    public void testSetkykymdHantei_A19() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.KOUHURI);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20160302");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(200)
    public void testSetkykymdHantei_A20() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.NEN);
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        BizDate ryosyuymd = BizDate.valueOf("20160302");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160416");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160416"), "契約日");
    }

    @Test
    @TestOrder(210)
    public void testSetkykymdHantei_A21() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setKykymd(BizDate.valueOf("20160416"));
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾁ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160815");
        BizDate sknnkaisiymd = BizDate.valueOf("20160420");
        BizDate syoriymd = BizDate.valueOf("20160401");
        C_SysKbn sysKbn = C_SysKbn.ESHIEN;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }


    @Test
    @TestOrder(220)
    public void testSetkykymdHantei_A22() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾁ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = null;
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }

    @Test
    @TestOrder(230)
    public void testSetkykymdHantei_A23() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾁ");
        BizDate ryosyuymd = BizDate.valueOf("20170401");
        BizDate Mosymd = BizDate.valueOf("20160414");
        BizDate sknnkaisiymd = BizDate.valueOf("20160415");
        BizDate syoriymd = BizDate.valueOf("20160415");
        C_SysKbn sysKbn = C_SysKbn.SKEI;
        C_YoteikykymdKbn yoteiKykymdKbn = C_YoteikykymdKbn.AUTO;

        BizDate kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, ryosyuymd, Mosymd, sknnkaisiymd, syoriymd,
            sysKbn, yoteiKykymdKbn);

        exDateEquals(kykYmd, BizDate.valueOf("20160501"), "契約日");
    }
}
