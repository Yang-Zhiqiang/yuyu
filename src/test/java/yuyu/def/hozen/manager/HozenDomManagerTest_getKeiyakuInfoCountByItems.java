package yuyu.def.hozen.manager;

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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKeiyakuInfoCountByItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKeiyakuInfoCountByItems {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-1234-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(0), count);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(20);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn1.setKykymd(BizDate.valueOf(20161130));

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(20);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn2.setKykymd(BizDate.valueOf(20161130));

        IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("A200");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(20);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn3.setKykymd(BizDate.valueOf(20161130));

        IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(20);
        kykSyouhn4.setKyksyouhnrenno(20);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn4.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya1 = kykKihon1.createKykSya();
        kykSya1.setKyknmkn("ナカナ");
        kykSya1.setKyknmkj("氏五氏");
        kykSya1.setKykseiymd(BizDate.valueOf(19920810));
        kykSya1.setTsinyno("1234567");
        kykSya1.setTsintelno("010-123-5678");
        kykSya1.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();
        hhknSya1.setHhknnmkn("エイエ");
        hhknSya1.setHhknnmkj("名字名");
        hhknSya1.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(5);
        kykDairiten1.setDrtencd("D100");

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(3);
        kykDairiten2.setDrtencd("D200");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn5 = kykKihon2.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(20);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn5.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya2 = kykKihon2.createKykSya();
        kykSya2.setKyknmkn("カナカ");
        kykSya2.setKyknmkj("五氏五");
        kykSya2.setKykseiymd(BizDate.valueOf(19920810));
        kykSya2.setTsinyno("1234567");
        kykSya2.setTsintelno("010-567-1234");
        kykSya2.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();
        hhknSya2.setHhknnmkn("イエイ");
        hhknSya2.setHhknnmkj("字名字");
        hhknSya2.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten3 = kykKihon2.createKykDairiten();
        kykDairiten3.setDrtenrenno(5);
        kykDairiten3.setDrtencd("D100");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn6 = kykKihon3.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(20);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn6.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya3 = kykKihon3.createKykSya();
        kykSya3.setKyknmkn("カ");
        kykSya3.setKyknmkj("五");
        kykSya3.setKykseiymd(BizDate.valueOf(19920810));
        kykSya3.setTsinyno("1234567");
        kykSya3.setTsintelno("010-568-1234");
        kykSya3.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();
        hhknSya3.setHhknnmkn("イ");
        hhknSya3.setHhknnmkj("字");
        hhknSya3.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten4 = kykKihon3.createKykDairiten();
        kykDairiten4.setDrtenrenno(5);
        kykDairiten4.setDrtencd("D100");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn7 = kykKihon4.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(20);
        kykSyouhn7.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn7.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya4 = kykKihon4.createKykSya();
        kykSya4.setKyknmkn("ナ");
        kykSya4.setKyknmkj("氏");
        kykSya4.setKykseiymd(BizDate.valueOf(19920810));
        kykSya4.setTsinyno("1234567");
        kykSya4.setTsintelno("010-567-1234");
        kykSya4.setDai2tsintelno("010-124-5678");

        IT_HhknSya hhknSya4 = kykKihon4.createHhknSya();
        hhknSya4.setHhknnmkn("エ");
        hhknSya4.setHhknnmkj("名");
        hhknSya4.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten5 = kykKihon4.createKykDairiten();
        kykDairiten5.setDrtenrenno(5);
        kykDairiten5.setDrtencd("D100");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn8 = kykKihon5.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("A100");
        kykSyouhn8.setSyouhnsdno(10);
        kykSyouhn8.setKyksyouhnrenno(20);
        kykSyouhn8.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn8.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya5 = kykKihon5.createKykSya();
        kykSya5.setKyknmkn("カカカ");
        kykSya5.setKyknmkj("五五五");
        kykSya5.setKykseiymd(BizDate.valueOf(19920810));
        kykSya5.setTsinyno("1234567");
        kykSya5.setTsintelno("010-5367-1234");
        kykSya5.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();
        hhknSya5.setHhknnmkn("イイイ");
        hhknSya5.setHhknnmkj("字字字");
        hhknSya5.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten6 = kykKihon5.createKykDairiten();
        kykDairiten6.setDrtenrenno(5);
        kykDairiten6.setDrtencd("D100");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn9 = kykKihon6.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("A100");
        kykSyouhn9.setSyouhnsdno(10);
        kykSyouhn9.setKyksyouhnrenno(20);
        kykSyouhn9.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn9.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya6 = kykKihon6.createKykSya();
        kykSya6.setKyknmkn("ナナナ");
        kykSya6.setKyknmkj("氏氏氏");
        kykSya6.setKykseiymd(BizDate.valueOf(19920810));
        kykSya6.setTsinyno("1234567");
        kykSya6.setTsintelno("010-567-1234");
        kykSya6.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya6 = kykKihon6.createHhknSya();
        hhknSya6.setHhknnmkn("エエエ");
        hhknSya6.setHhknnmkj("名名名");
        hhknSya6.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten7 = kykKihon6.createKykDairiten();
        kykDairiten7.setDrtenrenno(5);
        kykDairiten7.setDrtencd("D100");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn10 = kykKihon7.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("A100");
        kykSyouhn10.setSyouhnsdno(10);
        kykSyouhn10.setKyksyouhnrenno(20);
        kykSyouhn10.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn10.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya7 = kykKihon7.createKykSya();
        kykSya7.setKyknmkn("アイウ");
        kykSya7.setKyknmkj("且丕世");
        kykSya7.setKykseiymd(BizDate.valueOf(19920810));
        kykSya7.setTsinyno("1234567");
        kykSya7.setTsintelno("010-567-1234");
        kykSya7.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya7 = kykKihon7.createHhknSya();
        hhknSya7.setHhknnmkn("オレラ");
        hhknSya7.setHhknnmkj("保険者");
        hhknSya7.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten8 = kykKihon7.createKykDairiten();
        kykDairiten8.setDrtenrenno(5);
        kykDairiten8.setDrtencd("D100");

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn11 = kykKihon8.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn11.setSyouhncd("A100");
        kykSyouhn11.setSyouhnsdno(10);
        kykSyouhn11.setKyksyouhnrenno(20);
        kykSyouhn11.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn11.setKykymd(BizDate.valueOf(20161230));

        IT_KykSya kykSya8 = kykKihon8.createKykSya();
        kykSya8.setKyknmkn("カカカ");
        kykSya8.setKyknmkj("五五五");
        kykSya8.setKykseiymd(BizDate.valueOf(19920810));
        kykSya8.setTsinyno("1234567");
        kykSya8.setTsintelno("010-567-1234");
        kykSya8.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya8 = kykKihon8.createHhknSya();
        hhknSya8.setHhknnmkn("イイイ");
        hhknSya8.setHhknnmkj("字字字");
        hhknSya8.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten9 = kykKihon8.createKykDairiten();
        kykDairiten9.setDrtenrenno(5);
        kykDairiten9.setDrtencd("D100");

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn12 = kykKihon9.createKykSyouhn();
        kykSyouhn12.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn12.setSyouhncd("A100");
        kykSyouhn12.setSyouhnsdno(10);
        kykSyouhn12.setKyksyouhnrenno(20);
        kykSyouhn12.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn12.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya9 = kykKihon9.createKykSya();
        kykSya9.setKyknmkn("カカカ");
        kykSya9.setKyknmkj("五五五");
        kykSya9.setKykseiymd(BizDate.valueOf(19920810));
        kykSya9.setTsinyno("1234567");
        kykSya9.setTsintelno("010-567-1234");
        kykSya9.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya9 = kykKihon9.createHhknSya();
        hhknSya9.setHhknnmkn("イイイ");
        hhknSya9.setHhknnmkj("字字字");
        hhknSya9.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten10 = kykKihon9.createKykDairiten();
        kykDairiten10.setDrtenrenno(5);
        kykDairiten10.setDrtencd("D100");

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("00", "11807111200");

        IT_KykSyouhn kykSyouhn13 = kykKihon10.createKykSyouhn();
        kykSyouhn13.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn13.setSyouhncd("A100");
        kykSyouhn13.setSyouhnsdno(10);
        kykSyouhn13.setKyksyouhnrenno(20);
        kykSyouhn13.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn13.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya10 = kykKihon10.createKykSya();
        kykSya10.setKyknmkn("ハヘフ");
        kykSya10.setKyknmkj("五五五");
        kykSya10.setKykseiymd(BizDate.valueOf(19920810));
        kykSya10.setTsinyno("1234567");
        kykSya10.setTsintelno("010-567-1234");
        kykSya10.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya10 = kykKihon10.createHhknSya();
        hhknSya10.setHhknnmkn("イイイ");
        hhknSya10.setHhknnmkj("字字字");
        hhknSya10.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten11 = kykKihon10.createKykDairiten();
        kykDairiten11.setDrtenrenno(5);
        kykDairiten11.setDrtencd("D100");

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("01", "11807111211");

        IT_KykSyouhn kykSyouhn14 = kykKihon11.createKykSyouhn();
        kykSyouhn14.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn14.setSyouhncd("A100");
        kykSyouhn14.setSyouhnsdno(10);
        kykSyouhn14.setKyksyouhnrenno(20);
        kykSyouhn14.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn14.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya11 = kykKihon11.createKykSya();
        kykSya11.setKyknmkn("カカカ");
        kykSya11.setKyknmkj("亜入雨");
        kykSya11.setKykseiymd(BizDate.valueOf(19920810));
        kykSya11.setTsinyno("1234567");
        kykSya11.setTsintelno("010-567-1234");
        kykSya11.setDai2tsintelno("010-123-5678");

        IT_HhknSya hhknSya11 = kykKihon11.createHhknSya();
        hhknSya11.setHhknnmkn("イイイ");
        hhknSya11.setHhknnmkj("字字字");
        hhknSya11.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten12 = kykKihon11.createKykDairiten();
        kykDairiten12.setDrtenrenno(5);
        kykDairiten12.setDrtencd("D100");

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("02", "11807111222");

        IT_KykSyouhn kykSyouhn15 = kykKihon12.createKykSyouhn();
        kykSyouhn15.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn15.setSyouhncd("A100");
        kykSyouhn15.setSyouhnsdno(10);
        kykSyouhn15.setKyksyouhnrenno(20);
        kykSyouhn15.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn15.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya12 = kykKihon12.createKykSya();
        kykSya12.setKyknmkn("カカカ");
        kykSya12.setKyknmkj("五五五");
        kykSya12.setKykseiymd(BizDate.valueOf(19920811));
        kykSya12.setTsinyno("1234567");
        kykSya12.setTsintelno("010-123-5678");
        kykSya12.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya12 = kykKihon12.createHhknSya();
        hhknSya12.setHhknnmkn("イイイ");
        hhknSya12.setHhknnmkj("字字字");
        hhknSya12.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten13 = kykKihon12.createKykDairiten();
        kykDairiten13.setDrtenrenno(5);
        kykDairiten13.setDrtencd("D100");

        hozenDomManager.insert(kykKihon12);

        IT_KykKihon kykKihon13 = new IT_KykKihon("03", "11807111233");

        IT_KykSyouhn kykSyouhn16 = kykKihon13.createKykSyouhn();
        kykSyouhn16.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn16.setSyouhncd("A100");
        kykSyouhn16.setSyouhnsdno(10);
        kykSyouhn16.setKyksyouhnrenno(20);
        kykSyouhn16.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn16.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya13 = kykKihon13.createKykSya();
        kykSya13.setKyknmkn("カカカ");
        kykSya13.setKyknmkj("五五五");
        kykSya13.setKykseiymd(BizDate.valueOf(19920810));
        kykSya13.setTsinyno("1234567");
        kykSya13.setTsintelno("010-123-5678");
        kykSya13.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya13 = kykKihon13.createHhknSya();
        hhknSya13.setHhknnmkn("イイイ");
        hhknSya13.setHhknnmkj("字字字");
        hhknSya13.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten14 = kykKihon13.createKykDairiten();
        kykDairiten14.setDrtenrenno(5);
        kykDairiten14.setDrtencd("D100");

        hozenDomManager.insert(kykKihon13);

        IT_KykKihon kykKihon14 = new IT_KykKihon("04", "11807111244");

        IT_KykSyouhn kykSyouhn17 = kykKihon14.createKykSyouhn();
        kykSyouhn17.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn17.setSyouhncd("A100");
        kykSyouhn17.setSyouhnsdno(10);
        kykSyouhn17.setKyksyouhnrenno(20);
        kykSyouhn17.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn17.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya14 = kykKihon14.createKykSya();
        kykSya14.setKyknmkn("カカカ");
        kykSya14.setKyknmkj("五五五");
        kykSya14.setKykseiymd(BizDate.valueOf(19920810));
        kykSya14.setTsinyno("7654321");
        kykSya14.setTsintelno("010-123-5678");
        kykSya14.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya14 = kykKihon14.createHhknSya();
        hhknSya14.setHhknnmkn("イイイ");
        hhknSya14.setHhknnmkj("字字字");
        hhknSya14.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten15 = kykKihon14.createKykDairiten();
        kykDairiten15.setDrtenrenno(5);
        kykDairiten15.setDrtencd("D100");

        hozenDomManager.insert(kykKihon14);

        IT_KykKihon kykKihon15 = new IT_KykKihon("05", "11807111255");

        IT_KykSyouhn kykSyouhn18 = kykKihon15.createKykSyouhn();
        kykSyouhn18.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn18.setSyouhncd("A100");
        kykSyouhn18.setSyouhnsdno(10);
        kykSyouhn18.setKyksyouhnrenno(20);
        kykSyouhn18.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn18.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya15 = kykKihon15.createKykSya();
        kykSya15.setKyknmkn("カカカ");
        kykSya15.setKyknmkj("五五五");
        kykSya15.setKykseiymd(BizDate.valueOf(19920810));
        kykSya15.setTsinyno("1234567");
        kykSya15.setTsintelno("010-123-5678");
        kykSya15.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya15 = kykKihon15.createHhknSya();
        hhknSya15.setHhknnmkn("ガギキ");
        hhknSya15.setHhknnmkj("字字字");
        hhknSya15.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten16 = kykKihon15.createKykDairiten();
        kykDairiten16.setDrtenrenno(5);
        kykDairiten16.setDrtencd("D100");

        hozenDomManager.insert(kykKihon15);

        IT_KykKihon kykKihon16 = new IT_KykKihon("06", "11807111266");

        IT_KykSyouhn kykSyouhn19 = kykKihon16.createKykSyouhn();
        kykSyouhn19.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn19.setSyouhncd("A100");
        kykSyouhn19.setSyouhnsdno(10);
        kykSyouhn19.setKyksyouhnrenno(20);
        kykSyouhn19.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn19.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya16 = kykKihon16.createKykSya();
        kykSya16.setKyknmkn("カカカ");
        kykSya16.setKyknmkj("五五五");
        kykSya16.setKykseiymd(BizDate.valueOf(19920810));
        kykSya16.setTsinyno("1234567");
        kykSya16.setTsintelno("010-123-5678");
        kykSya16.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya16 = kykKihon16.createHhknSya();
        hhknSya16.setHhknnmkn("イイイ");
        hhknSya16.setHhknnmkj("羽李呉");
        hhknSya16.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten17 = kykKihon16.createKykDairiten();
        kykDairiten17.setDrtenrenno(5);
        kykDairiten17.setDrtencd("D100");

        hozenDomManager.insert(kykKihon16);

        IT_KykKihon kykKihon17 = new IT_KykKihon("07", "11807111277");

        IT_KykSyouhn kykSyouhn20 = kykKihon17.createKykSyouhn();
        kykSyouhn20.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn20.setSyouhncd("A100");
        kykSyouhn20.setSyouhnsdno(10);
        kykSyouhn20.setKyksyouhnrenno(20);
        kykSyouhn20.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn20.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya17 = kykKihon17.createKykSya();
        kykSya17.setKyknmkn("カカカ");
        kykSya17.setKyknmkj("五五五");
        kykSya17.setKykseiymd(BizDate.valueOf(19920810));
        kykSya17.setTsinyno("1234567");
        kykSya17.setTsintelno("010-123-5678");
        kykSya17.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya17 = kykKihon17.createHhknSya();
        hhknSya17.setHhknnmkn("イイイ");
        hhknSya17.setHhknnmkj("字字字");
        hhknSya17.setHhknseiymd(BizDate.valueOf(20121212));

        IT_KykDairiten kykDairiten18 = kykKihon17.createKykDairiten();
        kykDairiten18.setDrtenrenno(5);
        kykDairiten18.setDrtencd("D100");

        hozenDomManager.insert(kykKihon17);

        IT_KykKihon kykKihon18 = new IT_KykKihon("08", "11807111288");

        IT_KykSya kykSya18 = kykKihon18.createKykSya();
        kykSya18.setKyknmkn("カカカ");
        kykSya18.setKyknmkj("五五五");
        kykSya18.setKykseiymd(BizDate.valueOf(19920810));
        kykSya18.setTsinyno("1234567");
        kykSya18.setTsintelno("010-123-5678");
        kykSya18.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya18 = kykKihon18.createHhknSya();
        hhknSya18.setHhknnmkn("イイイ");
        hhknSya18.setHhknnmkj("字字字");
        hhknSya18.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten19 = kykKihon18.createKykDairiten();
        kykDairiten19.setDrtenrenno(5);
        kykDairiten19.setDrtencd("D100");

        hozenDomManager.insert(kykKihon18);

        IT_KykKihon kykKihon19 = new IT_KykKihon("09", "11807111299");

        IT_KykSyouhn kykSyouhn21 = kykKihon19.createKykSyouhn();
        kykSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn21.setSyouhncd("A100");
        kykSyouhn21.setSyouhnsdno(10);
        kykSyouhn21.setKyksyouhnrenno(20);
        kykSyouhn21.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn21.setKykymd(BizDate.valueOf(20161130));

        IT_HhknSya hhknSya19 = kykKihon19.createHhknSya();
        hhknSya19.setHhknnmkn("イイイ");
        hhknSya19.setHhknnmkj("字字字");
        hhknSya19.setHhknseiymd(BizDate.valueOf(20001010));

        IT_KykDairiten kykDairiten20 = kykKihon19.createKykDairiten();
        kykDairiten20.setDrtenrenno(5);
        kykDairiten20.setDrtencd("D100");

        hozenDomManager.insert(kykKihon19);

        IT_KykKihon kykKihon20 = new IT_KykKihon("00", "11807111303");

        IT_KykSyouhn kykSyouhn22 = kykKihon20.createKykSyouhn();
        kykSyouhn22.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn22.setSyouhncd("A100");
        kykSyouhn22.setSyouhnsdno(10);
        kykSyouhn22.setKyksyouhnrenno(20);
        kykSyouhn22.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn22.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya19 = kykKihon20.createKykSya();
        kykSya19.setKyknmkn("カカカ");
        kykSya19.setKyknmkj("五五五");
        kykSya19.setKykseiymd(BizDate.valueOf(19920810));
        kykSya19.setTsinyno("1234567");
        kykSya19.setTsintelno("011-123-5678");
        kykSya19.setDai2tsintelno("010-567-1234");

        IT_KykDairiten kykDairiten21 = kykKihon20.createKykDairiten();
        kykDairiten21.setDrtenrenno(5);
        kykDairiten21.setDrtencd("D100");

        hozenDomManager.insert(kykKihon20);

        IT_KykKihon kykKihon21 = new IT_KykKihon("01", "11807111314");

        IT_KykSyouhn kykSyouhn23 = kykKihon21.createKykSyouhn();
        kykSyouhn23.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn23.setSyouhncd("A100");
        kykSyouhn23.setSyouhnsdno(10);
        kykSyouhn23.setKyksyouhnrenno(20);
        kykSyouhn23.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn23.setKykymd(BizDate.valueOf(20161130));

        IT_KykSya kykSya20 = kykKihon21.createKykSya();
        kykSya20.setKyknmkn("カカカ");
        kykSya20.setKyknmkj("五五五");
        kykSya20.setKykseiymd(BizDate.valueOf(19920810));
        kykSya20.setTsinyno("1234567");
        kykSya20.setTsintelno("010-1234-5678");
        kykSya20.setDai2tsintelno("010-567-1234");

        IT_HhknSya hhknSya20 = kykKihon21.createHhknSya();
        hhknSya20.setHhknnmkn("イイイ");
        hhknSya20.setHhknnmkj("字字字");
        hhknSya20.setHhknseiymd(BizDate.valueOf(20001010));

        hozenDomManager.insert(kykKihon21);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("A100", 10);

        bizDomManager.insert(syouhnZokusei1);

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

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(20000810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カカ", "五五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イイ", "字字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(2), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(5), count);

    }

    @Test
    @TestOrder(40)
    public void normal3() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "イ", "丕", BizDate.valueOf(19920810), "010-123-5678", "1234567", "レ", "険", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(50)
    public void normal4() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(null, C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(60)
    public void normal5() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.BLNK,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(70)
    public void normal6() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), null,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(80)
    public void normal7() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            null, "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(90)
    public void normal8() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(100)
    public void normal9() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", null, BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(110)
    public void normal10() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(120)
    public void normal11() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", null, "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(130)
    public void normal12() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), null, "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(5), count);

    }

    @Test
    @TestOrder(140)
    public void normal13() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "", "1234567", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(5), count);

    }

    @Test
    @TestOrder(150)
    public void normal14() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", null, "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(160)
    public void normal15() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "", "イ", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(170)
    public void normal16() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", null, "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(180)
    public void normal17() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "", "字", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(190)
    public void normal18() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", null, BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(200)
    public void normal19() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "", BizDate.valueOf(20001010), "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(210)
    public void normal20() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", null, "D100");

        Assert.assertEquals(new Long(6), count);

    }

    @Test
    @TestOrder(220)
    public void normal21() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), null);

        Assert.assertEquals(new Long(5), count);

    }

    @Test
    @TestOrder(230)
    public void normal22() {

        Long count = hozenDomManager.getKeiyakuInfoCountByItems(BizDateYM.valueOf(201611), C_YuukousyoumetuKbn.YUUKOU,
            "カ", "五", BizDate.valueOf(19920810), "010-123-5678", "1234567", "イ", "字", BizDate.valueOf(20001010), "");

        Assert.assertEquals(new Long(5), count);

    }
}
