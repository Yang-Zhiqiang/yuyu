package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_YuukoukknKykListAtukaiSya> exDBResults = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(BizDate.valueOf(20150101), C_KeikaKbn.YOKOKUKIKAN, "101012");

        int iCount = 0;
        for (HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya : exDBResults) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_YuukoukknKykList yuukoukknKykList1 = new HT_YuukoukknKykList("791112246", BizDate.valueOf(20150101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya3 = yuukoukknKykList1.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya3.setKeikakbn(C_KeikaKbn.valueOf("0"));
        yuukoukknKykListAtukaiSya3.setRenno(1);
        yuukoukknKykListAtukaiSya3.setTratkiagcd("401101");
        yuukoukknKykListAtukaiSya3.setOyadrtencd("101013");

        sinkeiyakuDomManager.insert(yuukoukknKykList1);

        HT_YuukoukknKykList yuukoukknKykList2 = new HT_YuukoukknKykList("791112220", BizDate.valueOf(20150101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya1 = yuukoukknKykList2.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya1.setKeikakbn(C_KeikaKbn.valueOf("0"));
        yuukoukknKykListAtukaiSya1.setRenno(1);
        yuukoukknKykListAtukaiSya1.setTratkiagcd("401101");
        yuukoukknKykListAtukaiSya1.setOyadrtencd("101012");

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya4 = yuukoukknKykList2.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya4.setKeikakbn(C_KeikaKbn.valueOf("1"));
        yuukoukknKykListAtukaiSya4.setRenno(1);
        yuukoukknKykListAtukaiSya4.setTratkiagcd("401101");
        yuukoukknKykListAtukaiSya4.setOyadrtencd("101012");

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya5 = yuukoukknKykList2.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya5.setKeikakbn(C_KeikaKbn.valueOf("0"));
        yuukoukknKykListAtukaiSya5.setRenno(2);
        yuukoukknKykListAtukaiSya5.setTratkiagcd("401101");
        yuukoukknKykListAtukaiSya5.setOyadrtencd("101012");

        sinkeiyakuDomManager.insert(yuukoukknKykList2);

        HT_YuukoukknKykList yuukoukknKykList3 = new HT_YuukoukknKykList("791112220", BizDate.valueOf(20140101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya2 = yuukoukknKykList3.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya2.setKeikakbn(C_KeikaKbn.valueOf("0"));
        yuukoukknKykListAtukaiSya2.setRenno(1);
        yuukoukknKykListAtukaiSya2.setTratkiagcd("401101");
        yuukoukknKykListAtukaiSya2.setOyadrtencd("101012");

        sinkeiyakuDomManager.insert(yuukoukknKykList3);

        HT_YuukoukknKykList yuukoukknKykList4 = new HT_YuukoukknKykList("791112238", BizDate.valueOf(20110101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya7 = yuukoukknKykList4.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya7.setKeikakbn(C_KeikaKbn.valueOf("2"));
        yuukoukknKykListAtukaiSya7.setRenno(1);
        yuukoukknKykListAtukaiSya7.setTratkiagcd("201101");
        yuukoukknKykListAtukaiSya7.setOyadrtencd("211012");

        sinkeiyakuDomManager.insert(yuukoukknKykList4);

        HT_YuukoukknKykList yuukoukknKykList5 = new HT_YuukoukknKykList("791112246", BizDate.valueOf(20110101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya6 = yuukoukknKykList5.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya6.setKeikakbn(C_KeikaKbn.valueOf("2"));
        yuukoukknKykListAtukaiSya6.setRenno(1);
        yuukoukknKykListAtukaiSya6.setTratkiagcd("301101");
        yuukoukknKykListAtukaiSya6.setOyadrtencd("211012");

        sinkeiyakuDomManager.insert(yuukoukknKykList5);

        HT_YuukoukknKykList yuukoukknKykList6 = new HT_YuukoukknKykList("791112279", BizDate.valueOf(20110101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya10 = yuukoukknKykList6.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya10.setKeikakbn(C_KeikaKbn.valueOf("2"));
        yuukoukknKykListAtukaiSya10.setRenno(1);
        yuukoukknKykListAtukaiSya10.setTratkiagcd("101101");
        yuukoukknKykListAtukaiSya10.setOyadrtencd("211012");

        sinkeiyakuDomManager.insert(yuukoukknKykList6);

        HT_YuukoukknKykList yuukoukknKykList7 = new HT_YuukoukknKykList("791112287", BizDate.valueOf(20110101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya9 = yuukoukknKykList7.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya9.setKeikakbn(C_KeikaKbn.valueOf("2"));
        yuukoukknKykListAtukaiSya9.setRenno(1);
        yuukoukknKykListAtukaiSya9.setTratkiagcd("101101");
        yuukoukknKykListAtukaiSya9.setOyadrtencd("211012");

        sinkeiyakuDomManager.insert(yuukoukknKykList7);

        HT_YuukoukknKykList yuukoukknKykList8 = new HT_YuukoukknKykList("791112295", BizDate.valueOf(20110101));

        HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya8 = yuukoukknKykList8.createYuukoukknKykListAtukaiSya();
        yuukoukknKykListAtukaiSya8.setKeikakbn(C_KeikaKbn.valueOf("2"));
        yuukoukknKykListAtukaiSya8.setRenno(1);
        yuukoukknKykListAtukaiSya8.setTratkiagcd("101101");
        yuukoukknKykListAtukaiSya8.setOyadrtencd("211012");

        sinkeiyakuDomManager.insert(yuukoukknKykList8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllYuukoukknKykList());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        ExDBResults<HT_YuukoukknKykListAtukaiSya> exDBResults = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
                BizDate.valueOf(20090101), C_KeikaKbn.YOKOKUKIKAN, "101012");

        int iCount = 0;
        for (HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya : exDBResults) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal1(){

        ExDBResults<HT_YuukoukknKykListAtukaiSya> exDBResults = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
                BizDate.valueOf(20150101), C_KeikaKbn.YOKOKUKIKAN, "101012");

        int iCount = 0;
        for (HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya : exDBResults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20150101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("401101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("101012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());

            }
        }
        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(40)
    public void normal2(){

        ExDBResults<HT_YuukoukknKykListAtukaiSya> exDBResults = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
                BizDate.valueOf(20110101), C_KeikaKbn.YOKOKUKIKAN_WEB, "211012");

        int iCount = 0;
        for (HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya : exDBResults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112279", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20110101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("101101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("211012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());
            }

            if (2 == iCount) {
                Assert.assertEquals("791112287", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20110101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("101101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("211012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());
            }

            if (3 == iCount) {
                Assert.assertEquals("791112295", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20110101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("101101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("211012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());
            }

            if (4 == iCount) {
                Assert.assertEquals("791112238", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20110101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("201101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("211012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());
            }
            if (5 == iCount) {
                Assert.assertEquals("791112246", hT_YuukoukknKykListAtukaiSya.getMosno());
                Assert.assertEquals(BizDate.valueOf(20110101), hT_YuukoukknKykListAtukaiSya.getTyouhyouymd());
                Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, hT_YuukoukknKykListAtukaiSya.getKeikakbn());
                Assert.assertEquals(1, hT_YuukoukknKykListAtukaiSya.getRenno().intValue());
                Assert.assertEquals("301101", hT_YuukoukknKykListAtukaiSya.getTratkiagcd());
                Assert.assertEquals("211012", hT_YuukoukknKykListAtukaiSya.getOyadrtencd());
            }

        }
        Assert.assertEquals(5, iCount);
    }

    @Test
    @TestOrder(50)
    public void blankCondition(){

        ExDBResults<HT_YuukoukknKykListAtukaiSya> exDBResults = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
                BizDate.valueOf(20150101), C_KeikaKbn.YOKOKUKIKAN, "");

        int iCount = 0;
        for (HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya : exDBResults) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }
}

