package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KykInfosByKykymDrtencdItemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約情報取得のテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykInfosByKykymDrtencdItems {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(0, kykInfosByKykymDrtencdItemsBeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("11808111409");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("M110");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn1.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya1 = kykKihon1.createKykSya();
        kykSya1.setKyknmkn("アイア");
        kykSya1.setKyknmkj("契約契");
        kykSya1.setKykseiymd(BizDate.valueOf(20000602));
        kykSya1.setTsinyno("1234567");
        kykSya1.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();
        hhknSya1.setHhknnmkn("ウエウ");
        hhknSya1.setHhknnmkj("被保被");
        hhknSya1.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);
        kykDairiten1.setDrtencd("dt0001");

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);
        kykDairiten2.setDrtencd("dt0001");

        IT_KykDairiten kykDairiten3 = kykKihon1.createKykDairiten();
        kykDairiten3.setDrtenrenno(3);
        kykDairiten3.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11808111395");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("M110");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(1);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn2.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya2 = kykKihon2.createKykSya();
        kykSya2.setKyknmkn("イアイ");
        kykSya2.setKyknmkj("約契約");
        kykSya2.setKykseiymd(BizDate.valueOf(20000602));
        kykSya2.setTsinyno("1234567");
        kykSya2.setDai2tsintelno("011-1234-5678");

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();
        hhknSya2.setHhknnmkn("エウエ");
        hhknSya2.setHhknnmkj("保被保");
        hhknSya2.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten4 = kykKihon2.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);
        kykDairiten4.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon( "11808111384");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("M110");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(1);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn3.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya3 = kykKihon3.createKykSya();
        kykSya3.setKyknmkn("ア");
        kykSya3.setKyknmkj("契");
        kykSya3.setKykseiymd(BizDate.valueOf(20000602));
        kykSya3.setTsinyno("1234567");
        kykSya3.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();
        hhknSya3.setHhknnmkn("ウエウ");
        hhknSya3.setHhknnmkj("被");
        hhknSya3.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten5 = kykKihon3.createKykDairiten();
        kykDairiten5.setDrtenrenno(1);
        kykDairiten5.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("11808111373");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("M110");
        kykSyouhn4.setSyouhnsdno(1);
        kykSyouhn4.setKyksyouhnrenno(1);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn4.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya4 = kykKihon4.createKykSya();
        kykSya4.setKyknmkn("イ");
        kykSya4.setKyknmkj("約");
        kykSya4.setKykseiymd(BizDate.valueOf(20000602));
        kykSya4.setTsinyno("1234567");
        kykSya4.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya4 = kykKihon4.createHhknSya();
        hhknSya4.setHhknnmkn("エ");
        hhknSya4.setHhknnmkj("保");
        hhknSya4.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten6 = kykKihon4.createKykDairiten();
        kykDairiten6.setDrtenrenno(1);
        kykDairiten6.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon( "11808111362");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("M110");
        kykSyouhn5.setSyouhnsdno(1);
        kykSyouhn5.setKyksyouhnrenno(1);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn5.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya5 = kykKihon5.createKykSya();
        kykSya5.setKyknmkn("アアア");
        kykSya5.setKyknmkj("契契契");
        kykSya5.setKykseiymd(BizDate.valueOf(20000602));
        kykSya5.setTsinyno("1234567");
        kykSya5.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();
        hhknSya5.setHhknnmkn("ウウウ");
        hhknSya5.setHhknnmkj("被被被");
        hhknSya5.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten7 = kykKihon5.createKykDairiten();
        kykDairiten7.setDrtenrenno(1);
        kykDairiten7.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon( "11808111351");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("M110");
        kykSyouhn6.setSyouhnsdno(1);
        kykSyouhn6.setKyksyouhnrenno(1);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn6.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya6 = kykKihon6.createKykSya();
        kykSya6.setKyknmkn("イイイ");
        kykSya6.setKyknmkj("約約約");
        kykSya6.setKykseiymd(BizDate.valueOf(20000602));
        kykSya6.setTsinyno("1234567");
        kykSya6.setTsintelno("011-1234-5678");
        kykSya6.setDai2tsintelno("011-1234-5679");

        IT_HhknSya hhknSya6 = kykKihon6.createHhknSya();
        hhknSya6.setHhknnmkn("エエエ");
        hhknSya6.setHhknnmkj("保保保");
        hhknSya6.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten8 = kykKihon6.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);
        kykDairiten8.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon( "11808111340");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("M110");
        kykSyouhn7.setSyouhnsdno(1);
        kykSyouhn7.setKyksyouhnrenno(1);
        kykSyouhn7.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn7.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya7 = kykKihon7.createKykSya();
        kykSya7.setKyknmkn("カナホ");
        kykSya7.setKyknmkj("漢字名");
        kykSya7.setKykseiymd(BizDate.valueOf(20000602));
        kykSya7.setTsinyno("1234567");
        kykSya7.setTsintelno("011-1234-5678");
        kykSya7.setDai2tsintelno("011-1234-5679");

        IT_HhknSya hhknSya7 = kykKihon7.createHhknSya();
        hhknSya7.setHhknnmkn("サビス");
        hhknSya7.setHhknnmkj("険者名");
        hhknSya7.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten9 = kykKihon7.createKykDairiten();
        kykDairiten9.setDrtenrenno(1);
        kykDairiten9.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon( "11808111339");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("M110");
        kykSyouhn8.setSyouhnsdno(1);
        kykSyouhn8.setKyksyouhnrenno(1);
        kykSyouhn8.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn8.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya8 = kykKihon8.createKykSya();
        kykSya8.setKyknmkn("ハイカ");
        kykSya8.setKyknmkj("契約契");
        kykSya8.setKykseiymd(BizDate.valueOf(20000301));
        kykSya8.setTsinyno("1234567");
        kykSya8.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya8 = kykKihon8.createHhknSya();
        hhknSya8.setHhknnmkn("ヲエカ");
        hhknSya8.setHhknnmkj("被保被");
        hhknSya8.setHhknseiymd(BizDate.valueOf(20000401));

        IT_KykDairiten kykDairiten10 = kykKihon8.createKykDairiten();
        kykDairiten10.setDrtenrenno(1);
        kykDairiten10.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("11808111328");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("M110");
        kykSyouhn9.setSyouhnsdno(1);
        kykSyouhn9.setKyksyouhnrenno(1);
        kykSyouhn9.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn9.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya9 = kykKihon9.createKykSya();
        kykSya9.setKyknmkn("ハイカ");
        kykSya9.setKyknmkj("契約契");
        kykSya9.setKykseiymd(BizDate.valueOf(20000208));
        kykSya9.setTsinyno("1234567");
        kykSya9.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya9 = kykKihon9.createHhknSya();
        hhknSya9.setHhknnmkn("ヲエカ");
        hhknSya9.setHhknnmkj("被保被");
        hhknSya9.setHhknseiymd(BizDate.valueOf(20000301));

        IT_KykDairiten kykDairiten11 = kykKihon9.createKykDairiten();
        kykDairiten11.setDrtenrenno(1);
        kykDairiten11.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon( "11808111317");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("M110");
        kykSyouhn10.setSyouhnsdno(1);
        kykSyouhn10.setKyksyouhnrenno(1);
        kykSyouhn10.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn10.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya10 = kykKihon10.createKykSya();
        kykSya10.setKyknmkn("ハイカ");
        kykSya10.setKyknmkj("契約契");
        kykSya10.setKykseiymd(BizDate.valueOf(20000208));
        kykSya10.setTsinyno("1234567");
        kykSya10.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya10 = kykKihon10.createHhknSya();
        hhknSya10.setHhknnmkn("ヲエカ");
        hhknSya10.setHhknnmkj("被保被");
        hhknSya10.setHhknseiymd(BizDate.valueOf(20000301));

        IT_KykDairiten kykDairiten12 = kykKihon10.createKykDairiten();
        kykDairiten12.setDrtenrenno(1);
        kykDairiten12.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon( "11808111292");

        IT_KykSyouhn kykSyouhn11 = kykKihon11.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn11.setSyouhncd("M110");
        kykSyouhn11.setSyouhnsdno(1);
        kykSyouhn11.setKyksyouhnrenno(1);
        kykSyouhn11.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn11.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya11 = kykKihon11.createKykSya();
        kykSya11.setKyknmkn("マイカ");
        kykSya11.setKyknmkj("契約契");
        kykSya11.setKykseiymd(BizDate.valueOf(20000301));
        kykSya11.setTsinyno("1234567");
        kykSya11.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya11 = kykKihon11.createHhknSya();
        hhknSya11.setHhknnmkn("ラエカ");
        hhknSya11.setHhknnmkj("被保被");
        hhknSya11.setHhknseiymd(BizDate.valueOf(20000401));

        IT_KykDairiten kykDairiten13 = kykKihon11.createKykDairiten();
        kykDairiten13.setDrtenrenno(1);
        kykDairiten13.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon( "11808111281");

        IT_KykSyouhn kykSyouhn12 = kykKihon12.createKykSyouhn();
        kykSyouhn12.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn12.setSyouhncd("M110");
        kykSyouhn12.setSyouhnsdno(1);
        kykSyouhn12.setKyksyouhnrenno(1);
        kykSyouhn12.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn12.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya12 = kykKihon12.createKykSya();
        kykSya12.setKyknmkn("マイカ");
        kykSya12.setKyknmkj("契約契");
        kykSya12.setKykseiymd(BizDate.valueOf(20000208));
        kykSya12.setTsinyno("1234567");
        kykSya12.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya12 = kykKihon12.createHhknSya();
        hhknSya12.setHhknnmkn("ラエカ");
        hhknSya12.setHhknnmkj("被保被");
        hhknSya12.setHhknseiymd(BizDate.valueOf(20000301));

        IT_KykDairiten kykDairiten14 = kykKihon12.createKykDairiten();
        kykDairiten14.setDrtenrenno(1);
        kykDairiten14.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon12);

        IT_KykKihon kykKihon13 = new IT_KykKihon("11808111270");

        IT_KykSyouhn kykSyouhn13 = kykKihon13.createKykSyouhn();
        kykSyouhn13.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn13.setSyouhncd("M110");
        kykSyouhn13.setSyouhnsdno(1);
        kykSyouhn13.setKyksyouhnrenno(1);
        kykSyouhn13.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn13.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya13 = kykKihon13.createKykSya();
        kykSya13.setKyknmkn("マイカ");
        kykSya13.setKyknmkj("契約契");
        kykSya13.setKykseiymd(BizDate.valueOf(20000208));
        kykSya13.setTsinyno("1234567");
        kykSya13.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya13 = kykKihon13.createHhknSya();
        hhknSya13.setHhknnmkn("ラエカ");
        hhknSya13.setHhknnmkj("被保被");
        hhknSya13.setHhknseiymd(BizDate.valueOf(20000301));

        IT_KykDairiten kykDairiten15 = kykKihon13.createKykDairiten();
        kykDairiten15.setDrtenrenno(1);
        kykDairiten15.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon13);

        IT_KykKihon kykKihon14 = new IT_KykKihon( "11808111269");

        IT_KykSyouhn kykSyouhn14 = kykKihon14.createKykSyouhn();
        kykSyouhn14.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn14.setSyouhncd("M110");
        kykSyouhn14.setSyouhnsdno(1);
        kykSyouhn14.setKyksyouhnrenno(1);
        kykSyouhn14.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn14.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya14 = kykKihon14.createKykSya();
        kykSya14.setKyknmkn("アイア");
        kykSya14.setKyknmkj("契約契");
        kykSya14.setKykseiymd(BizDate.valueOf(20000602));
        kykSya14.setTsinyno("1234567");
        kykSya14.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya14 = kykKihon14.createHhknSya();
        hhknSya14.setHhknnmkn("ウエウ");
        hhknSya14.setHhknnmkj("被保被");
        hhknSya14.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten16 = kykKihon14.createKykDairiten();
        kykDairiten16.setDrtenrenno(1);
        kykDairiten16.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon14);

        IT_KykKihon kykKihon15 = new IT_KykKihon("11808111258");

        IT_KykSyouhn kykSyouhn15 = kykKihon15.createKykSyouhn();
        kykSyouhn15.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn15.setSyouhncd("M110");
        kykSyouhn15.setSyouhnsdno(1);
        kykSyouhn15.setKyksyouhnrenno(1);
        kykSyouhn15.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn15.setKykymd(BizDate.valueOf(20160205));

        IT_KykSya kykSya15 = kykKihon15.createKykSya();
        kykSya15.setKyknmkn("アイア");
        kykSya15.setKyknmkj("契約契");
        kykSya15.setKykseiymd(BizDate.valueOf(20000602));
        kykSya15.setTsinyno("1234567");
        kykSya15.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya15 = kykKihon15.createHhknSya();
        hhknSya15.setHhknnmkn("ウエウ");
        hhknSya15.setHhknnmkj("被保被");
        hhknSya15.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten17 = kykKihon15.createKykDairiten();
        kykDairiten17.setDrtenrenno(1);
        kykDairiten17.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon15);

        IT_KykKihon kykKihon16 = new IT_KykKihon( "11808111247");

        IT_KykSyouhn kykSyouhn16 = kykKihon16.createKykSyouhn();
        kykSyouhn16.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn16.setSyouhncd("M110");
        kykSyouhn16.setSyouhnsdno(1);
        kykSyouhn16.setKyksyouhnrenno(1);
        kykSyouhn16.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn16.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya16 = kykKihon16.createKykSya();
        kykSya16.setKyknmkn("ソノタ");
        kykSya16.setKyknmkj("契約契");
        kykSya16.setKykseiymd(BizDate.valueOf(20000602));
        kykSya16.setTsinyno("1234567");
        kykSya16.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya16 = kykKihon16.createHhknSya();
        hhknSya16.setHhknnmkn("ウエウ");
        hhknSya16.setHhknnmkj("被保被");
        hhknSya16.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten18 = kykKihon16.createKykDairiten();
        kykDairiten18.setDrtenrenno(1);
        kykDairiten18.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon16);

        IT_KykKihon kykKihon17 = new IT_KykKihon( "11808111236");

        IT_KykSyouhn kykSyouhn17 = kykKihon17.createKykSyouhn();
        kykSyouhn17.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn17.setSyouhncd("M110");
        kykSyouhn17.setSyouhnsdno(1);
        kykSyouhn17.setKyksyouhnrenno(1);
        kykSyouhn17.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn17.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya17 = kykKihon17.createKykSya();
        kykSya17.setKyknmkn("アイア");
        kykSya17.setKyknmkj("顧客番");
        kykSya17.setKykseiymd(BizDate.valueOf(20000602));
        kykSya17.setTsinyno("1234567");
        kykSya17.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya17 = kykKihon17.createHhknSya();
        hhknSya17.setHhknnmkn("ウエウ");
        hhknSya17.setHhknnmkj("被保被");
        hhknSya17.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten19 = kykKihon17.createKykDairiten();
        kykDairiten19.setDrtenrenno(1);
        kykDairiten19.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon17);

        IT_KykKihon kykKihon18 = new IT_KykKihon( "11808111225");

        IT_KykSyouhn kykSyouhn18 = kykKihon18.createKykSyouhn();
        kykSyouhn18.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn18.setSyouhncd("M110");
        kykSyouhn18.setSyouhnsdno(1);
        kykSyouhn18.setKyksyouhnrenno(1);
        kykSyouhn18.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn18.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya18 = kykKihon18.createKykSya();
        kykSya18.setKyknmkn("アイア");
        kykSya18.setKyknmkj("契約契");
        kykSya18.setKykseiymd(BizDate.valueOf(20050203));
        kykSya18.setTsinyno("1234567");
        kykSya18.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya18 = kykKihon18.createHhknSya();
        hhknSya18.setHhknnmkn("ウエウ");
        hhknSya18.setHhknnmkj("被保被");
        hhknSya18.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten20 = kykKihon18.createKykDairiten();
        kykDairiten20.setDrtenrenno(1);
        kykDairiten20.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon18);

        IT_KykKihon kykKihon19 = new IT_KykKihon("11808111214");

        IT_KykSyouhn kykSyouhn19 = kykKihon19.createKykSyouhn();
        kykSyouhn19.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn19.setSyouhncd("M110");
        kykSyouhn19.setSyouhnsdno(1);
        kykSyouhn19.setKyksyouhnrenno(1);
        kykSyouhn19.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn19.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya19 = kykKihon19.createKykSya();
        kykSya19.setKyknmkn("アイア");
        kykSya19.setKyknmkj("契約契");
        kykSya19.setKykseiymd(BizDate.valueOf(20000602));
        kykSya19.setTsinyno("1234568");
        kykSya19.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya19 = kykKihon19.createHhknSya();
        hhknSya19.setHhknnmkn("ウエウ");
        hhknSya19.setHhknnmkj("被保被");
        hhknSya19.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten21 = kykKihon19.createKykDairiten();
        kykDairiten21.setDrtenrenno(1);
        kykDairiten21.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon19);

        IT_KykKihon kykKihon20 = new IT_KykKihon("11808111203");

        IT_KykSyouhn kykSyouhn20 = kykKihon20.createKykSyouhn();
        kykSyouhn20.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn20.setSyouhncd("M110");
        kykSyouhn20.setSyouhnsdno(1);
        kykSyouhn20.setKyksyouhnrenno(1);
        kykSyouhn20.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn20.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya20 = kykKihon20.createKykSya();
        kykSya20.setKyknmkn("アイア");
        kykSya20.setKyknmkj("契約契");
        kykSya20.setKykseiymd(BizDate.valueOf(20000602));
        kykSya20.setTsinyno("1234567");
        kykSya20.setTsintelno("011-1234-5679");

        IT_HhknSya hhknSya20 = kykKihon20.createHhknSya();
        hhknSya20.setHhknnmkn("ウエウ");
        hhknSya20.setHhknnmkj("被保被");
        hhknSya20.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten22 = kykKihon20.createKykDairiten();
        kykDairiten22.setDrtenrenno(1);
        kykDairiten22.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon20);

        IT_KykKihon kykKihon21 = new IT_KykKihon("11808111199");

        IT_KykSyouhn kykSyouhn21 = kykKihon21.createKykSyouhn();
        kykSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn21.setSyouhncd("M110");
        kykSyouhn21.setSyouhnsdno(1);
        kykSyouhn21.setKyksyouhnrenno(1);
        kykSyouhn21.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn21.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya21 = kykKihon21.createKykSya();
        kykSya21.setKyknmkn("アイア");
        kykSya21.setKyknmkj("契約契");
        kykSya21.setKykseiymd(BizDate.valueOf(20000602));
        kykSya21.setTsinyno("1234567");
        kykSya21.setDai2tsintelno("011-1234-5666");

        IT_HhknSya hhknSya21 = kykKihon21.createHhknSya();
        hhknSya21.setHhknnmkn("ウエウ");
        hhknSya21.setHhknnmkj("被保被");
        hhknSya21.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten23 = kykKihon21.createKykDairiten();
        kykDairiten23.setDrtenrenno(1);
        kykDairiten23.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon21);

        IT_KykKihon kykKihon22 = new IT_KykKihon( "11808111188");

        IT_KykSyouhn kykSyouhn22 = kykKihon22.createKykSyouhn();
        kykSyouhn22.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn22.setSyouhncd("M110");
        kykSyouhn22.setSyouhnsdno(1);
        kykSyouhn22.setKyksyouhnrenno(1);
        kykSyouhn22.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn22.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya22 = kykKihon22.createKykSya();
        kykSya22.setKyknmkn("アイア");
        kykSya22.setKyknmkj("契約契");
        kykSya22.setKykseiymd(BizDate.valueOf(20000602));
        kykSya22.setTsinyno("1234567");
        kykSya22.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya22 = kykKihon22.createHhknSya();
        hhknSya22.setHhknnmkn("クラス");
        hhknSya22.setHhknnmkj("被保被");
        hhknSya22.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten24 = kykKihon22.createKykDairiten();
        kykDairiten24.setDrtenrenno(1);
        kykDairiten24.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon22);

        IT_KykKihon kykKihon23 = new IT_KykKihon("11808111177");

        IT_KykSyouhn kykSyouhn23 = kykKihon23.createKykSyouhn();
        kykSyouhn23.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn23.setSyouhncd("M110");
        kykSyouhn23.setSyouhnsdno(1);
        kykSyouhn23.setKyksyouhnrenno(1);
        kykSyouhn23.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn23.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya23 = kykKihon23.createKykSya();
        kykSya23.setKyknmkn("アイア");
        kykSya23.setKyknmkj("契約契");
        kykSya23.setKykseiymd(BizDate.valueOf(20000602));
        kykSya23.setTsinyno("1234567");
        kykSya23.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya23 = kykKihon23.createHhknSya();
        hhknSya23.setHhknnmkn("ウエウ");
        hhknSya23.setHhknnmkj("区分区");
        hhknSya23.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten25 = kykKihon23.createKykDairiten();
        kykDairiten25.setDrtenrenno(1);
        kykDairiten25.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon23);

        IT_KykKihon kykKihon24 = new IT_KykKihon("11808111166");

        IT_KykSyouhn kykSyouhn24 = kykKihon24.createKykSyouhn();
        kykSyouhn24.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn24.setSyouhncd("M110");
        kykSyouhn24.setSyouhnsdno(1);
        kykSyouhn24.setKyksyouhnrenno(1);
        kykSyouhn24.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn24.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya24 = kykKihon24.createKykSya();
        kykSya24.setKyknmkn("アイア");
        kykSya24.setKyknmkj("契約契");
        kykSya24.setKykseiymd(BizDate.valueOf(20000602));
        kykSya24.setTsinyno("1234567");
        kykSya24.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya24 = kykKihon24.createHhknSya();
        hhknSya24.setHhknnmkn("ウエウ");
        hhknSya24.setHhknnmkj("被保被");
        hhknSya24.setHhknseiymd(BizDate.valueOf(20050816));

        IT_KykDairiten kykDairiten26 = kykKihon24.createKykDairiten();
        kykDairiten26.setDrtenrenno(1);
        kykDairiten26.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon24);

        IT_KykKihon kykKihon25 = new IT_KykKihon("11808111111");

        IT_KykSyouhn kykSyouhn25 = kykKihon25.createKykSyouhn();
        kykSyouhn25.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn25.setSyouhncd("M110");
        kykSyouhn25.setSyouhnsdno(1);
        kykSyouhn25.setKyksyouhnrenno(1);
        kykSyouhn25.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn25.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya25 = kykKihon25.createKykSya();
        kykSya25.setKyknmkn("アイア");
        kykSya25.setKyknmkj("契約契");
        kykSya25.setKykseiymd(BizDate.valueOf(20000602));
        kykSya25.setTsinyno("1234567");
        kykSya25.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya25 = kykKihon25.createHhknSya();
        hhknSya25.setHhknnmkn("ウエウ");
        hhknSya25.setHhknnmkj("被保被");
        hhknSya25.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten27 = kykKihon25.createKykDairiten();
        kykDairiten27.setDrtenrenno(1);
        kykDairiten27.setDrtencd("dt0002");

        hozenDomManager.insert(kykKihon25);

        IT_KykKihon kykKihon26 = new IT_KykKihon( "11808111155");

        IT_KykSya kykSya26 = kykKihon26.createKykSya();
        kykSya26.setKyknmkn("アイア");
        kykSya26.setKyknmkj("契約契");
        kykSya26.setKykseiymd(BizDate.valueOf(20000602));
        kykSya26.setTsinyno("1234567");
        kykSya26.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya26 = kykKihon26.createHhknSya();
        hhknSya26.setHhknnmkn("ウエウ");
        hhknSya26.setHhknnmkj("被保被");
        hhknSya26.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten28 = kykKihon26.createKykDairiten();
        kykDairiten28.setDrtenrenno(1);
        kykDairiten28.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon26);

        IT_KykKihon kykKihon27 = new IT_KykKihon("11808111144");

        IT_KykSyouhn kykSyouhn26 = kykKihon27.createKykSyouhn();
        kykSyouhn26.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn26.setSyouhncd("M110");
        kykSyouhn26.setSyouhnsdno(1);
        kykSyouhn26.setKyksyouhnrenno(1);
        kykSyouhn26.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn26.setKykymd(BizDate.valueOf(20150608));

        IT_HhknSya hhknSya27 = kykKihon27.createHhknSya();
        hhknSya27.setHhknnmkn("ウエウ");
        hhknSya27.setHhknnmkj("被保被");
        hhknSya27.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten29 = kykKihon27.createKykDairiten();
        kykDairiten29.setDrtenrenno(1);
        kykDairiten29.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon27);

        IT_KykKihon kykKihon28 = new IT_KykKihon("11808111133");

        IT_KykSyouhn kykSyouhn27 = kykKihon28.createKykSyouhn();
        kykSyouhn27.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn27.setSyouhncd("M110");
        kykSyouhn27.setSyouhnsdno(1);
        kykSyouhn27.setKyksyouhnrenno(1);
        kykSyouhn27.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn27.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya27 = kykKihon28.createKykSya();
        kykSya27.setKyknmkn("アイア");
        kykSya27.setKyknmkj("契約契");
        kykSya27.setKykseiymd(BizDate.valueOf(20000602));
        kykSya27.setTsinyno("1234567");
        kykSya27.setTsintelno("011-1234-5678");

        IT_KykDairiten kykDairiten30 = kykKihon28.createKykDairiten();
        kykDairiten30.setDrtenrenno(1);
        kykDairiten30.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon28);

        IT_KykKihon kykKihon29 = new IT_KykKihon( "11808111122");

        IT_KykSyouhn kykSyouhn28 = kykKihon29.createKykSyouhn();
        kykSyouhn28.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn28.setSyouhncd("M110");
        kykSyouhn28.setSyouhnsdno(1);
        kykSyouhn28.setKyksyouhnrenno(1);
        kykSyouhn28.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn28.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya28 = kykKihon29.createKykSya();
        kykSya28.setKyknmkn("アイア");
        kykSya28.setKyknmkj("契約契");
        kykSya28.setKykseiymd(BizDate.valueOf(20000602));
        kykSya28.setTsinyno("1234567");
        kykSya28.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya28 = kykKihon29.createHhknSya();
        hhknSya28.setHhknnmkn("ウエウ");
        hhknSya28.setHhknnmkj("被保被");
        hhknSya28.setHhknseiymd(BizDate.valueOf(20000501));

        hozenDomManager.insert(kykKihon29);

        IT_KykKihon kykKihon30 = new IT_KykKihon("11808111487");

        IT_KykSyouhn kykSyouhn29 = kykKihon30.createKykSyouhn();
        kykSyouhn29.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn29.setSyouhncd("M110");
        kykSyouhn29.setSyouhnsdno(1);
        kykSyouhn29.setKyksyouhnrenno(1);
        kykSyouhn29.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn29.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya29 = kykKihon30.createKykSya();
        kykSya29.setKyknmkn("アイア");
        kykSya29.setKyknmkj("契約契");
        kykSya29.setKykseiymd(BizDate.valueOf(20000602));
        kykSya29.setTsinyno("1234567");
        kykSya29.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya29 = kykKihon30.createHhknSya();
        hhknSya29.setHhknnmkn("ウエウ");
        hhknSya29.setHhknnmkj("被保被");
        hhknSya29.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten31 = kykKihon30.createKykDairiten();
        kykDairiten31.setDrtenrenno(1);
        kykDairiten31.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon30);

        IT_KykKihon kykKihon31 = new IT_KykKihon("11808111498");

        IT_KykSyouhn kykSyouhn30 = kykKihon31.createKykSyouhn();
        kykSyouhn30.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn30.setSyouhncd("M130");
        kykSyouhn30.setSyouhnsdno(1);
        kykSyouhn30.setKyksyouhnrenno(1);
        kykSyouhn30.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn30.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya30 = kykKihon31.createKykSya();
        kykSya30.setKyknmkn("アイア");
        kykSya30.setKyknmkj("契約契");
        kykSya30.setKykseiymd(BizDate.valueOf(20000602));
        kykSya30.setTsinyno("1234567");
        kykSya30.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya30 = kykKihon31.createHhknSya();
        hhknSya30.setHhknnmkn("ウエウ");
        hhknSya30.setHhknnmkj("被保被");
        hhknSya30.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten32 = kykKihon31.createKykDairiten();
        kykDairiten32.setDrtenrenno(1);
        kykDairiten32.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon31);

        IT_KykKihon kykKihon32 = new IT_KykKihon( "11808111502");

        IT_KykSyouhn kykSyouhn31 = kykKihon32.createKykSyouhn();
        kykSyouhn31.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn31.setSyouhncd("M110");
        kykSyouhn31.setSyouhnsdno(2);
        kykSyouhn31.setKyksyouhnrenno(1);
        kykSyouhn31.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn31.setKykymd(BizDate.valueOf(20150608));

        IT_KykSya kykSya31 = kykKihon32.createKykSya();
        kykSya31.setKyknmkn("アイア");
        kykSya31.setKyknmkj("契約契");
        kykSya31.setKykseiymd(BizDate.valueOf(20000602));
        kykSya31.setTsinyno("1234567");
        kykSya31.setTsintelno("011-1234-5678");

        IT_HhknSya hhknSya31 = kykKihon32.createHhknSya();
        hhknSya31.setHhknnmkn("ウエウ");
        hhknSya31.setHhknnmkj("被保被");
        hhknSya31.setHhknseiymd(BizDate.valueOf(20000501));

        IT_KykDairiten kykDairiten33 = kykKihon32.createKykDairiten();
        kykDairiten33.setDrtenrenno(1);
        kykDairiten33.setDrtencd("dt0001");

        hozenDomManager.insert(kykKihon32);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("M110", 1);
        syouhnZokusei1.setSyouhnnm("ゆうゆう保険");

        hozenDomManager.insert(syouhnZokusei1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201509),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(0, kykInfosByKykymDrtencdItemsBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イイ", "約約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エエ", "保保", BizDate.valueOf(20000501));

        Assert.assertEquals(1, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst2 = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "ナ", "字", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "ビ", "者", BizDate.valueOf(20000501));

        Assert.assertEquals(1, kykInfosByKykymDrtencdItemsBeanLst2.size());

        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getSyono());
        Assert.assertEquals("カナホ", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getKyknmkn());
        Assert.assertEquals("漢字名", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst2.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getDai2tsintelno());
        Assert.assertEquals("サビス", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getHhknnmkn());
        Assert.assertEquals("険者名", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst2.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst2.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst2.get(0).getYuukousyoumetukbn());


    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(4, kykInfosByKykymDrtencdItemsBeanLst.size());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());


        Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("ソノタ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("顧客番", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(6, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals("011-1234-5666", kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(80)
    public void blankCondition5() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(90)
    public void blankCondition6() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("クラス", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(100)
    public void blankCondition7() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("区分区", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(110)
    public void nullCondition1() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(null,
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(120)
    public void nullCondition2() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            null, C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(130)
    public void nullCondition3() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", null, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.SYOUMETU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());


    }

    @Test
    @TestOrder(140)
    public void nullCondition4() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, null, "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("ソノタ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(150)
    public void nullCondition5() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", null, BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("顧客番", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(160)
    public void nullCondition6() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", null, "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20050203"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(170)
    public void nullCondition7() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), null, "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(6, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals("011-1234-5666", kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(180)
    public void nullCondition8() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", null, "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());
        Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(190)
    public void nullCondition9() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", null, "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("クラス", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(200)
    public void nullCondition10() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", null, BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("区分区", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());


    }

    @Test
    @TestOrder(210)
    public void nullCondition11() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", null);

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20050816"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());


        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());


    }

    @Test
    @TestOrder(220)
    public void nullCondition12() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, null, "約", null, "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(6, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20050203"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("ソノタ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(230)
    public void nullCondition13() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "", "約", null, "011-1234-5678", "1234567", "エ", "保", null);

        Assert.assertEquals(13, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20050203"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("ソノタ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20050816"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(6).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(6).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(6).getYuukousyoumetukbn());


        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(7).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(7).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(7).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(7).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(7).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(7).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(7).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(7).getYuukousyoumetukbn());

        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(8).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(8).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(8).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(8).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(8).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(8).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(8).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(8).getYuukousyoumetukbn());


        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(9).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(9).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(9).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(9).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(9).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(9).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000401"), kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(9).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(9).getYuukousyoumetukbn());


        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(10).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(10).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(10).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(10).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(10).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(10).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(10).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(10).getYuukousyoumetukbn());


        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(11).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(11).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(11).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(11).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(11).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(11).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(11).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(11).getYuukousyoumetukbn());


        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(12).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(12).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(12).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(12).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(12).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(12).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(12).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(12).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000401"), kykInfosByKykymDrtencdItemsBeanLst.get(12).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(12).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(12).getYuukousyoumetukbn());

    }

    @Test
    @TestOrder(240)
    public void nullCondition14() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.YUUKOU, "イ", "約", null, "011-1234-5678", "1234567", "エ", "保", null);

        Assert.assertEquals(12, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20050816"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());


        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20050203"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());

        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("イ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("約", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("エ", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("保", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());


        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("イアイ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("約契約", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("エウエ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("保被保", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("イイイ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("約約約", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("エエエ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("保保保", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());

        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(6).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(6).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(6).getYuukousyoumetukbn());

        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(7).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(7).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(7).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(7).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(7).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(7).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(7).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(7).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(7).getYuukousyoumetukbn());


        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(8).getSyono());
        Assert.assertEquals("ハイカ", kykInfosByKykymDrtencdItemsBeanLst.get(8).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(8).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(8).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(8).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(8).getDai2tsintelno());
        Assert.assertEquals("ヲエカ", kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000401"), kykInfosByKykymDrtencdItemsBeanLst.get(8).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(8).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(8).getYuukousyoumetukbn());

        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(9).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(9).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(9).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(9).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(9).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(9).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(9).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(9).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(9).getYuukousyoumetukbn());

        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(10).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(10).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(10).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000208"), kykInfosByKykymDrtencdItemsBeanLst.get(10).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(10).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(10).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(10).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(10).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(10).getYuukousyoumetukbn());


        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(11).getSyono());
        Assert.assertEquals("マイカ", kykInfosByKykymDrtencdItemsBeanLst.get(11).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(11).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000301"), kykInfosByKykymDrtencdItemsBeanLst.get(11).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(11).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(11).getDai2tsintelno());
        Assert.assertEquals("ラエカ", kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000401"), kykInfosByKykymDrtencdItemsBeanLst.get(11).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(11).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(11).getYuukousyoumetukbn());

    }


    @Test
    @TestOrder(250)
    public void nullCondition15() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(null,
            "",null, "", "", null, "", "", "", "", null);

        Assert.assertEquals(25, kykInfosByKykymDrtencdItemsBeanLst.size());

        Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(0).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(0).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(0).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(0).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(0).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(1).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(1).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(1).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20050816"), kykInfosByKykymDrtencdItemsBeanLst.get(1).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(1).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(2).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(2).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(2).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkn());
        Assert.assertEquals("区分区", kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(2).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(2).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getYuukousyoumetukbn());


        Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(3).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(3).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(3).getDai2tsintelno());
        Assert.assertEquals("クラス", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(3).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(3).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getYuukousyoumetukbn());

        Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(4).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getKykseiymd());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(4).getTsintelno());
        Assert.assertEquals("011-1234-5666", kykInfosByKykymDrtencdItemsBeanLst.get(4).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(4).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(4).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getYuukousyoumetukbn());

        Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(5).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getKykseiymd());
        Assert.assertEquals("011-1234-5679", kykInfosByKykymDrtencdItemsBeanLst.get(5).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(5).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(5).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(5).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getYuukousyoumetukbn());

        Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyono());
        Assert.assertEquals("アイア", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkn());
        Assert.assertEquals("契約契", kykInfosByKykymDrtencdItemsBeanLst.get(6).getKyknmkj());
        Assert.assertEquals(BizDate.valueOf("20000602"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getKykseiymd());
        Assert.assertEquals("011-1234-5678", kykInfosByKykymDrtencdItemsBeanLst.get(6).getTsintelno());
        Assert.assertEquals(null, kykInfosByKykymDrtencdItemsBeanLst.get(6).getDai2tsintelno());
        Assert.assertEquals("ウエウ", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkn());
        Assert.assertEquals("被保被", kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknnmkj());
        Assert.assertEquals(BizDate.valueOf("20000501"), kykInfosByKykymDrtencdItemsBeanLst.get(6).getHhknseiymd());
        Assert.assertEquals("ゆうゆう保険", kykInfosByKykymDrtencdItemsBeanLst.get(6).getSyouhnnm());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykInfosByKykymDrtencdItemsBeanLst.get(6).getYuukousyoumetukbn());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(7).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(8).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(9).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(10).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(11).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(12).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(13).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(14).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(15).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(16).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(17).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(18).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(19).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(20).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(21).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(22).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(23).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(24).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getDrtenrenno());

    }

    @Test
    @TestOrder(260)
    public void nullCondition16() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(null,
            null, null, null, null, null, null, null, null, null, null);

        Assert.assertEquals(25, kykInfosByKykymDrtencdItemsBeanLst.size());

        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(0).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111111", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(1).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111166", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(2).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111177", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(3).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111188", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(4).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111199", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(5).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(5).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111203", kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(5).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(6).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(6).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111214", kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(6).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(7).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111225", kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(7).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(8).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111236", kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(8).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(9).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111247", kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(9).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(10).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111258", kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(10).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(11).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(11).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(12).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111270", kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(12).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(13).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111281", kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(13).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(14).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111292", kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(14).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(15).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111317", kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(15).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(16).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111328", kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(16).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(17).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111339", kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(17).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(18).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111340", kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(18).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(19).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(19).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(20).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111362", kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(20).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(21).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(21).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(22).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111384", kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(22).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(23).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(23).getIT_KykDairiten().getDrtenrenno());
        //
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykKihon().getKbnkey());
        //            Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykKihon().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSya().getKbnkey());
        //            Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSya().getSyono());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_HhknSya().getKbnkey());
        //            Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_HhknSya().getSyono());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(24).getBM_SyouhnZokusei().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getBM_SyouhnZokusei().getSyouhnsdno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getKbnkey());
        //            Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyono());
        //            Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyutkkbn());
        //            Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyouhncd());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getSyouhnsdno());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykSyouhn().getKyksyouhnrenno());
        //            Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getKbnkey());
        //            Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getSyono());
        //            Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(24).getIT_KykDairiten().getDrtenrenno());
        //
    }

    @Test
    @TestOrder(270)
    public void blankCondition8() {

        List<KykInfosByKykymDrtencdItemsBean>  kykInfosByKykymDrtencdItemsBeanLst = hozenDomManager.getKykInfosByKykymDrtencdItems(BizDateYM.valueOf(201506),
            "dt0001", C_YuukousyoumetuKbn.BLNK, "イ", "約", BizDate.valueOf(20000602), "011-1234-5678", "1234567", "エ", "保", BizDate.valueOf(20000501));

        Assert.assertEquals(5, kykInfosByKykymDrtencdItemsBeanLst.size());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(0).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111269", kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(0).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(1).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111409", kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(1).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(2).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111373", kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(2).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(3).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111395", kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(3).getIT_KykDairiten().getDrtenrenno());
        //
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykKihon().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykKihon().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSya().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSya().getSyono());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_HhknSya().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_HhknSya().getSyono());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(4).getBM_SyouhnZokusei().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getBM_SyouhnZokusei().getSyouhnsdno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyono());
        //        Assert.assertEquals(C_SyutkKbn.SYU, kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyutkkbn());
        //        Assert.assertEquals("M110", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyouhncd());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getSyouhnsdno());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykSyouhn().getKyksyouhnrenno());
        //        Assert.assertEquals("01", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getKbnkey());
        //        Assert.assertEquals("11808111351", kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getSyono());
        //        Assert.assertEquals(Integer.valueOf(1), kykInfosByKykymDrtencdItemsBeanLst.get(4).getIT_KykDairiten().getDrtenrenno());
        //
    }
}
