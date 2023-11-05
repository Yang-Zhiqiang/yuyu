package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

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

import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd {

    @Inject
    SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ExDBResults<ST_SkOikmKaikei> beans = suuriDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate.valueOf(20160227), BizDate.valueOf(20160316));

        int iCount = 0;
        for (ST_SkOikmKaikei skOikmKaikei : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ST_SkOikmKaikei skOikmKaikei1 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("0"), "201520161001", 1);
        skOikmKaikei1.setDenymd(BizDate.valueOf(20160228));
        skOikmKaikei1.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        skOikmKaikei1.setSyoriYmd(BizDate.valueOf(20160315));
        skOikmKaikei1.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei1);

        ST_SkOikmKaikei skOikmKaikei2 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("0"), "201520161001", 2);
        skOikmKaikei2.setDenymd(BizDate.valueOf(20160228));
        skOikmKaikei2.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei2.setSyoriYmd(BizDate.valueOf(20160315));
        skOikmKaikei2.setDensyorikbn(C_DensyoriKbn.valueOf("0"));

        suuriDomManager.insert(skOikmKaikei2);

        ST_SkOikmKaikei skOikmKaikei3 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("0"), "201520161001", 3);
        skOikmKaikei3.setDenymd(BizDate.valueOf(20160228));
        skOikmKaikei3.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        skOikmKaikei3.setSyoriYmd(BizDate.valueOf(20160315));
        skOikmKaikei3.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei3);

        ST_SkOikmKaikei skOikmKaikei4 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("0"), "201520161001", 4);
        skOikmKaikei4.setDenymd(BizDate.valueOf(20160209));
        skOikmKaikei4.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei4.setSyoriYmd(BizDate.valueOf(20160315));
        skOikmKaikei4.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei4);

        ST_SkOikmKaikei skOikmKaikei5 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("0"), "201520161001", 5);
        skOikmKaikei5.setDenymd(BizDate.valueOf(20160228));
        skOikmKaikei5.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei5.setSyoriYmd(BizDate.valueOf(20160326));
        skOikmKaikei5.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei5);

        ST_SkOikmKaikei skOikmKaikei6 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("10"), "201520161002", 1);
        skOikmKaikei6.setDenymd(BizDate.valueOf(20160211));
        skOikmKaikei6.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
        skOikmKaikei6.setSyoriYmd(BizDate.valueOf(20160324));
        skOikmKaikei6.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei6);

        ST_SkOikmKaikei skOikmKaikei7 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("20"), "201520161002", 1);
        skOikmKaikei7.setDenymd(BizDate.valueOf(20160210));
        skOikmKaikei7.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
        skOikmKaikei7.setSyoriYmd(BizDate.valueOf(20160325));
        skOikmKaikei7.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei7);

        ST_SkOikmKaikei skOikmKaikei8 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("10"), "202012021001", 1);
        skOikmKaikei8.setDenymd(BizDate.valueOf(20201202));
        skOikmKaikei8.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU);
        skOikmKaikei8.setSyoriYmd(BizDate.valueOf(20201202));
        skOikmKaikei8.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei8);


        ST_SkOikmKaikei skOikmKaikei9 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("10"), "202012021001", 2);
        skOikmKaikei9.setDenymd(BizDate.valueOf(20201202));
        skOikmKaikei9.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU);
        skOikmKaikei9.setSyoriYmd(BizDate.valueOf(20201202));
        skOikmKaikei9.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei9);

    	ST_SkOikmKaikei skOikmKaikei10 = new ST_SkOikmKaikei(C_DensysKbn.valueOf("10"), "202012021001", 3);
        skOikmKaikei10.setDenymd(BizDate.valueOf(20201202));
        skOikmKaikei10.setKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU);
        skOikmKaikei10.setSyoriYmd(BizDate.valueOf(20201202));
        skOikmKaikei10.setDensyorikbn(C_DensyoriKbn.valueOf("1070"));

        suuriDomManager.insert(skOikmKaikei10);
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        ExDBResults<ST_SkOikmKaikei> beans = suuriDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate.valueOf(20160301), BizDate.valueOf(20160314));

        int iCount = 0;
        for (ST_SkOikmKaikei skOikmKaikei : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        ExDBResults<ST_SkOikmKaikei> beans = suuriDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate.valueOf(20160227), BizDate.valueOf(20160316));

        int iCount = 0;
        for (ST_SkOikmKaikei skOikmKaikei : beans) {
            iCount++;
            if (1 == iCount) {

                Assert.assertEquals(C_DensysKbn.BLNK, skOikmKaikei.getDensyskbn());
                Assert.assertEquals("201520161001", skOikmKaikei.getDenrenno());
                Assert.assertEquals(1, skOikmKaikei.getEdano().intValue());

            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        ExDBResults<ST_SkOikmKaikei> beans = suuriDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate.valueOf(20160210), BizDate.valueOf(20160325));

        HashMap<String,String> skOikmKaikeiMaps = new HashMap<String,String>();
        skOikmKaikeiMaps.put($(C_DensysKbn.BLNK,"201520161001",1), "1");
        skOikmKaikeiMaps.put($(C_DensysKbn.SKEI,"201520161002",1), "2");
        skOikmKaikeiMaps.put($(C_DensysKbn.HOZEN,"201520161002",1), "3");

        int iCount = 0;
        for (ST_SkOikmKaikei skOikmKaikei : beans) {
            iCount++;
            skOikmKaikeiMaps.remove($(skOikmKaikei.getDensyskbn(),skOikmKaikei.getDenrenno(),skOikmKaikei.getEdano().intValue()));
        }

        assertTrue(skOikmKaikeiMaps.isEmpty());
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        ExDBResults<ST_SkOikmKaikei> beans = suuriDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate.valueOf(20201202), BizDate.valueOf(20201202));

        HashMap<String,String> skOikmKaikeiMaps = new HashMap<String,String>();
        skOikmKaikeiMaps.put($(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU), "1");
        skOikmKaikeiMaps.put($(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU), "2");
        skOikmKaikeiMaps.put($(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU), "3");

        int iCount = 0;
        for (ST_SkOikmKaikei skOikmKaikei : beans) {
            iCount++;
            skOikmKaikeiMaps.remove($(skOikmKaikei.getKanjyoukmkcd()));
        }

        assertTrue(skOikmKaikeiMaps.isEmpty());
        Assert.assertEquals(3, iCount);
    }

    @Transactional
    public static void deleteTestSubData() {
        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkOikmKaikei> skOikmKaikeiList = suuriDomManager.getAllSkOikmKaikei();
        if(skOikmKaikeiList.size() > 0){
            suuriDomManager.delete(skOikmKaikeiList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}

