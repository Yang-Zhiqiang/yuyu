package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 死亡率統計整備後連動情報作成<br />
 * getSibourituToukeiSeibigosBySyoriYmdSyutkkbn() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrSibourituToukeiSeibigoRendouDaoTest_getSibourituToukeiSeibigosBySyoriYmdSyutkkbn {

    @Inject
    private SrSibourituToukeiSeibigoRendouDao srSibourituToukeiSeibigoRendouDao;
    @Inject
    private HozenDomManager hozenDomManager;
    @Inject
    private SiharaiDomManager siharaiDomManager;


    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        SrSibourituToukeiSeibigoRendouDao srSibourituToukeiSeibigoRendouDao = SWAKInjector.getInstance(SrSibourituToukeiSeibigoRendouDao.class);

        try (ExDBResults<SV_SibourituToukeiSeibigo> sV_SibourituToukeiSeibigoResults =
            srSibourituToukeiSeibigoRendouDao.getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(BizDate.valueOf(20160921),BizDate.valueOf(20160921),C_SyutkKbn.SYU)) {

            Assert.assertFalse(sV_SibourituToukeiSeibigoResults.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("201609210000000000");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki1.setGyoumuKousinKinou("khkaiyaku");
        khTtdkRireki1.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("201609210000000000");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160920));
        khTtdkRireki2.setGyoumuKousinKinou("khkaiyaku");
        khTtdkRireki2.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201609210000000000");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160919));
        khTtdkRireki3.setGyoumuKousinKinou("khkaiyaku");
        khTtdkRireki3.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("201609210000000000");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki4.setGyoumuKousinKinou("khkaiyaku");
        khTtdkRireki4.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);
        kykSyouhn5.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("201609210000000000");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkRireki5.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki5.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);
        kykSyouhn6.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("201609210000000000");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki6.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki6.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki6.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(1);
        kykSyouhn7.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("201609210000000000");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki7.setSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkRireki7.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki7.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("A100");
        kykSyouhn8.setSyouhnsdno(10);
        kykSyouhn8.setKyksyouhnrenno(1);
        kykSyouhn8.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("201609210000000000");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki8.setSyorikbn(C_SyoriKbn.MUKOU);
        khTtdkRireki8.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki8.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("A100");
        kykSyouhn9.setSyouhnsdno(10);
        kykSyouhn9.setKyksyouhnrenno(1);
        kykSyouhn9.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("201609210000000000");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki9.setSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkRireki9.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki9.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("00", "11807111200");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("A100");
        kykSyouhn10.setSyouhnsdno(10);
        kykSyouhn10.setKyksyouhnrenno(1);
        kykSyouhn10.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon10.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("201609210000000000");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki10.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkRireki10.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki10.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("01", "11807111211");

        IT_KykSyouhn kykSyouhn11 = kykKihon11.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn11.setSyouhncd("A100");
        kykSyouhn11.setSyouhnsdno(10);
        kykSyouhn11.setKyksyouhnrenno(1);
        kykSyouhn11.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("201609210000000000");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki11.setSyorikbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        khTtdkRireki11.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki11.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("02", "11807111222");

        IT_KykSyouhn kykSyouhn12 = kykKihon12.createKykSyouhn();
        kykSyouhn12.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn12.setSyouhncd("A100");
        kykSyouhn12.setSyouhnsdno(10);
        kykSyouhn12.setKyksyouhnrenno(1);
        kykSyouhn12.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon12.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("201609210000000000");
        khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki12.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkRireki12.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki12.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon12);

        IT_KykKihon kykKihon13 = new IT_KykKihon("03", "11807111233");

        IT_KykSyouhn kykSyouhn13 = kykKihon13.createKykSyouhn();
        kykSyouhn13.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn13.setSyouhncd("A100");
        kykSyouhn13.setSyouhnsdno(10);
        kykSyouhn13.setKyksyouhnrenno(1);
        kykSyouhn13.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon13.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("201609210000000000");
        khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki13.setSyorikbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        khTtdkRireki13.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki13.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon13);

        IT_KykKihon kykKihon14 = new IT_KykKihon("04", "11807111244");

        IT_KykSyouhn kykSyouhn14 = kykKihon14.createKykSyouhn();
        kykSyouhn14.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn14.setSyouhncd("A100");
        kykSyouhn14.setSyouhnsdno(10);
        kykSyouhn14.setKyksyouhnrenno(1);
        kykSyouhn14.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki14 = kykKihon14.createKhTtdkRireki();
        khTtdkRireki14.setHenkousikibetukey("201609210000000000");
        khTtdkRireki14.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki14.setSyorikbn(C_SyoriKbn.SBMUKOU);
        khTtdkRireki14.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki14.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon14);

        IT_KykKihon kykKihon15 = new IT_KykKihon("05", "11807111255");

        IT_KykSyouhn kykSyouhn15 = kykKihon15.createKykSyouhn();
        kykSyouhn15.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn15.setSyouhncd("A100");
        kykSyouhn15.setSyouhnsdno(10);
        kykSyouhn15.setKyksyouhnrenno(1);
        kykSyouhn15.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);

        IT_KhTtdkRireki khTtdkRireki15 = kykKihon15.createKhTtdkRireki();
        khTtdkRireki15.setHenkousikibetukey("201609210000000000");
        khTtdkRireki15.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki15.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki15.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki15.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon15);

        IT_KykKihon kykKihon16 = new IT_KykKihon("06", "11807111266");

        IT_KykSyouhn kykSyouhn16 = kykKihon16.createKykSyouhn();
        kykSyouhn16.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn16.setSyouhncd("A100");
        kykSyouhn16.setSyouhnsdno(10);
        kykSyouhn16.setKyksyouhnrenno(1);
        kykSyouhn16.setSyoumetujiyuu(C_Syoumetujiyuu.CLGOFF);

        IT_KhTtdkRireki khTtdkRireki16 = kykKihon16.createKhTtdkRireki();
        khTtdkRireki16.setHenkousikibetukey("201609210000000000");
        khTtdkRireki16.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki16.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki16.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki16.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon16);

        IT_KykKihon kykKihon17 = new IT_KykKihon("07", "11807111277");

        IT_KykSyouhn kykSyouhn17 = kykKihon17.createKykSyouhn();
        kykSyouhn17.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn17.setSyouhncd("A100");
        kykSyouhn17.setSyouhnsdno(10);
        kykSyouhn17.setKyksyouhnrenno(1);
        kykSyouhn17.setSyoumetujiyuu(C_Syoumetujiyuu.KAIJO);

        IT_KhTtdkRireki khTtdkRireki17 = kykKihon17.createKhTtdkRireki();
        khTtdkRireki17.setHenkousikibetukey("201609210000000000");
        khTtdkRireki17.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki17.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki17.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki17.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon17);

        IT_KykKihon kykKihon18 = new IT_KykKihon("08", "11807111288");

        IT_KykSyouhn kykSyouhn18 = kykKihon18.createKykSyouhn();
        kykSyouhn18.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn18.setSyouhncd("A100");
        kykSyouhn18.setSyouhnsdno(10);
        kykSyouhn18.setKyksyouhnrenno(1);
        kykSyouhn18.setSyoumetujiyuu(C_Syoumetujiyuu.MUKOU);

        IT_KhTtdkRireki khTtdkRireki18 = kykKihon18.createKhTtdkRireki();
        khTtdkRireki18.setHenkousikibetukey("201609210000000000");
        khTtdkRireki18.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki18.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki18.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki18.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon18);

        IT_KykKihon kykKihon19 = new IT_KykKihon("09", "11807111299");

        IT_KykSyouhn kykSyouhn19 = kykKihon19.createKykSyouhn();
        kykSyouhn19.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn19.setSyouhncd("A100");
        kykSyouhn19.setSyouhnsdno(10);
        kykSyouhn19.setKyksyouhnrenno(1);
        kykSyouhn19.setSyoumetujiyuu(C_Syoumetujiyuu.SBKAIJO);

        IT_KhTtdkRireki khTtdkRireki19 = kykKihon19.createKhTtdkRireki();
        khTtdkRireki19.setHenkousikibetukey("201609210000000000");
        khTtdkRireki19.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki19.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki19.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki19.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon19);

        IT_KykKihon kykKihon20 = new IT_KykKihon("00", "11807111303");

        IT_KykSyouhn kykSyouhn20 = kykKihon20.createKykSyouhn();
        kykSyouhn20.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn20.setSyouhncd("A100");
        kykSyouhn20.setSyouhnsdno(10);
        kykSyouhn20.setKyksyouhnrenno(1);
        kykSyouhn20.setSyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);

        IT_KhTtdkRireki khTtdkRireki20 = kykKihon20.createKhTtdkRireki();
        khTtdkRireki20.setHenkousikibetukey("201609210000000000");
        khTtdkRireki20.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki20.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki20.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki20.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon20);

        IT_KykKihon kykKihon21 = new IT_KykKihon("01", "11807111314");

        IT_KykSyouhn kykSyouhn21 = kykKihon21.createKykSyouhn();
        kykSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn21.setSyouhncd("A100");
        kykSyouhn21.setSyouhnsdno(10);
        kykSyouhn21.setKyksyouhnrenno(1);
        kykSyouhn21.setSyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU);

        IT_KhTtdkRireki khTtdkRireki21 = kykKihon21.createKhTtdkRireki();
        khTtdkRireki21.setHenkousikibetukey("201609210000000000");
        khTtdkRireki21.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki21.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki21.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki21.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon21);

        IT_KykKihon kykKihon22 = new IT_KykKihon("02", "11807111325");

        IT_KykSyouhn kykSyouhn22 = kykKihon22.createKykSyouhn();
        kykSyouhn22.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn22.setSyouhncd("A100");
        kykSyouhn22.setSyouhnsdno(10);
        kykSyouhn22.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon22);

        IT_KykKihon kykKihon23 = new IT_KykKihon("03", "11807111336");

        IT_KykSyouhn kykSyouhn23 = kykKihon23.createKykSyouhn();
        kykSyouhn23.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn23.setSyouhncd("A100");
        kykSyouhn23.setSyouhnsdno(10);
        kykSyouhn23.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon23);

        JT_SkKihon skKihon1 = new JT_SkKihon("10000", "11807111325");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("10");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.BLNK);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160921));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("10000", "11807111336");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("10");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf(20160921));

        siharaiDomManager.insert(skKihon2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<SV_SibourituToukeiSeibigo> sV_SibourituToukeiSeibigoResults =
            srSibourituToukeiSeibigoRendouDao.getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(BizDate.valueOf(20160921),BizDate.valueOf(20160922),C_SyutkKbn.TK)) {

            Assert.assertFalse(sV_SibourituToukeiSeibigoResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal10() {
        try (ExDBResults<SV_SibourituToukeiSeibigo> sV_SibourituToukeiSeibigoResults =
            srSibourituToukeiSeibigoRendouDao.getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(BizDate.valueOf(20160921),BizDate.valueOf(20160921),C_SyutkKbn.SYU)) {

            int iCount = 0;
            Iterator<SV_SibourituToukeiSeibigo> iter = sV_SibourituToukeiSeibigoResults.iterator();
            SV_SibourituToukeiSeibigo SV_SibourituToukeiSeibigo = null;
            while (iter.hasNext()) {

                SV_SibourituToukeiSeibigo = iter.next();
                iCount++;

                Assert.assertEquals("11807111118", SV_SibourituToukeiSeibigo.getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, SV_SibourituToukeiSeibigo.getSyutkkbn());
                Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                Assert.assertEquals("khkaiyaku", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                Assert.assertEquals("20160921000000000", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("201609210000000000");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160929));
        khTtdkRireki1.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkRireki1.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki1.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);
        kykSyouhn2.setSyoumetujiyuu(C_Syoumetujiyuu.CLGOFF);

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("201609210000000000");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160928));
        khTtdkRireki2.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki2.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki2.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);
        kykSyouhn3.setSyoumetujiyuu(C_Syoumetujiyuu.KAIJO);

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201609210000000000");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160927));
        khTtdkRireki3.setSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkRireki3.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki3.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(1);
        kykSyouhn4.setSyoumetujiyuu(C_Syoumetujiyuu.MUKOU);

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("201609210000000000");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160926));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.MUKOU);
        khTtdkRireki4.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki4.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);
        kykSyouhn5.setSyoumetujiyuu(C_Syoumetujiyuu.SBKAIJO);

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("201609210000000000");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160925));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkRireki5.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki5.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);
        kykSyouhn6.setSyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("201609210000000000");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160924));
        khTtdkRireki6.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkRireki6.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki6.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(1);
        kykSyouhn7.setSyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("201609210000000000");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160923));
        khTtdkRireki7.setSyorikbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        khTtdkRireki7.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki7.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn8.setSyouhncd("A100");
        kykSyouhn8.setSyouhnsdno(10);
        kykSyouhn8.setKyksyouhnrenno(1);
        kykSyouhn8.setSyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU);

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("201609210000000000");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160922));
        khTtdkRireki8.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkRireki8.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki8.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("02", "11807111222");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn9.setSyouhncd("A100");
        kykSyouhn9.setSyouhnsdno(10);
        kykSyouhn9.setKyksyouhnrenno(1);
        kykSyouhn9.setSyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU);

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("201609210000000000");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki9.setSyorikbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        khTtdkRireki9.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki9.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("01", "11807111211");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn10.setSyouhncd("A100");
        kykSyouhn10.setSyouhnsdno(10);
        kykSyouhn10.setKyksyouhnrenno(1);
        kykSyouhn10.setSyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU);

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon10.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("201609210000000000");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki10.setSyorikbn(C_SyoriKbn.SBMUKOU);
        khTtdkRireki10.setGyoumuKousinKinou("khjyuusyohenkou");
        khTtdkRireki10.setGyoumuKousinTime("20160921000000002");

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("00", "11807111200");

        IT_KykSyouhn kykSyouhn11 = kykKihon11.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn11.setSyouhncd("A100");
        kykSyouhn11.setSyouhnsdno(10);
        kykSyouhn11.setKyksyouhnrenno(1);
        kykSyouhn11.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("201609210000000000");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki11.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki11.setGyoumuKousinKinou("khkaiyaku");
        khTtdkRireki11.setGyoumuKousinTime("20160921000000002");

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("201609210000000001");
        khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki12.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki12.setGyoumuKousinKinou("khgengaku");
        khTtdkRireki12.setGyoumuKousinTime("20160921000000001");

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("201609210000000002");
        khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki13.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki13.setGyoumuKousinKinou("khseinengappiseiteisei");
        khTtdkRireki13.setGyoumuKousinTime("20160921000000000");

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn12 = kykKihon12.createKykSyouhn();
        kykSyouhn12.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn12.setSyouhncd("A100");
        kykSyouhn12.setSyouhnsdno(10);
        kykSyouhn12.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon12);

        JT_SkKihon skKihon1 = new JT_SkKihon("09", "11807111196");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("10");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20161001));
        siRireki1.setKossyoricd("khjyuusyohenkou");
        siRireki1.setGyoumuKousinTime("20160921000000002");

        siharaiDomManager.insert(skKihon1);
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        try (ExDBResults<SV_SibourituToukeiSeibigo> sV_SibourituToukeiSeibigoResults =
            srSibourituToukeiSeibigoRendouDao.getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(BizDate.valueOf(20160921),BizDate.valueOf(20161001),C_SyutkKbn.TK)) {

            int iCount = 0;
            Iterator<SV_SibourituToukeiSeibigo> iter = sV_SibourituToukeiSeibigoResults.iterator();
            SV_SibourituToukeiSeibigo SV_SibourituToukeiSeibigo = null;
            while (iter.hasNext()) {

                SV_SibourituToukeiSeibigo = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("11807111200", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.BLNK, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khseinengappiseiteisei", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000000", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.BLNK, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("11807111200", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.BLNK, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khgengaku", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000001", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.BLNK, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("11807111200", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.BLNK, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khkaiyaku", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.BLNK, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("11807111211", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.SBMUKOU, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBMUKOU, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("11807111222", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.SBMUKOU, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160921), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBMUKOU_SHRNASI, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("11807111185", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.SBMUKOU, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160922), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBMUKOU_KIHRKPSHR, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("11807111174", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.MENSEKI, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160923), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBMENSEKI_SHRNASI, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("11807111163", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.MENSEKI, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160924), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBMENSEKI, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("11807111152", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.SBKAIJO, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160925), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.SBKAIJO, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("11807111141", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.MUKOU, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160926), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.MUKOU, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals("11807111130", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.KAIJO, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160927), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.KAIJO, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals("11807111129", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.CLGOFF, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160928), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.CLGOFF, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals("11807111118", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(C_Syoumetujiyuu.KYKTORIKESI, SV_SibourituToukeiSeibigo.getSyoumetujiyuu());
                    Assert.assertEquals(BizDate.valueOf(20160929), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SyoriKbn.KYKTORIKESI, SV_SibourituToukeiSeibigo.getSyorikbn());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals("11807111196", SV_SibourituToukeiSeibigo.getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, SV_SibourituToukeiSeibigo.getSyutkkbn());
                    Assert.assertEquals(BizDate.valueOf(20161001), SV_SibourituToukeiSeibigo.getSyoriYmd());
                    Assert.assertEquals("khjyuusyohenkou", SV_SibourituToukeiSeibigo.getGyoumuKousinKinou());
                    Assert.assertEquals("20160921000000002", SV_SibourituToukeiSeibigo.getGyoumuKousinTime());
                    Assert.assertEquals(C_SeikyuuSyubetu.SB, SV_SibourituToukeiSeibigo.getSeikyuusyubetu());

                    continue;
                }
            }
            Assert.assertEquals(14, iCount);
        }
    }
}

