package yuyu.def.biz.manager;

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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getHuriDenpyousBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getHuriDenpyousBySyoriYmd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_HuriDenpyou> beans =
                bizDomManager.getHuriDenpyousBySyoriYmd(BizDate.valueOf(20160714))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_HuriDenpyou huriDenpyou1 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 01);
        huriDenpyou1.setTorihikino("11111");
        huriDenpyou1.setHuridenatesakicd("999");
        huriDenpyou1.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou1.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou1.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou1.setDenkanjokamokucd("33");
        huriDenpyou1.setJigyouhiutiwakecd("333");
        huriDenpyou1.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou1.setSyoriYmd(BizDate.valueOf(20160714));

        bizDomManager.insert(huriDenpyou1);

        BT_HuriDenpyou huriDenpyou2 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 02);
        huriDenpyou2.setTorihikino("11111");
        huriDenpyou2.setHuridenatesakicd("999");
        huriDenpyou2.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou2.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou2.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou2.setDenkanjokamokucd("33");
        huriDenpyou2.setJigyouhiutiwakecd("333");
        huriDenpyou2.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou2.setSyoriYmd(BizDate.valueOf(20150714));

        bizDomManager.insert(huriDenpyou2);

        BT_HuriDenpyou huriDenpyou3 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 03);
        huriDenpyou3.setHuridenatesakicd("999");
        huriDenpyou3.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou3.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou3.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou3.setDenkanjokamokucd("33");
        huriDenpyou3.setJigyouhiutiwakecd("333");
        huriDenpyou3.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou3.setSyoriYmd(BizDate.valueOf(20160714));

        bizDomManager.insert(huriDenpyou3);

        BT_HuriDenpyou huriDenpyou4 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 04);
        huriDenpyou4.setTorihikino("99999");
        huriDenpyou4.setHuridenatesakicd("999");
        huriDenpyou4.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou4.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou4.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou4.setDenkanjokamokucd("33");
        huriDenpyou4.setJigyouhiutiwakecd("333");
        huriDenpyou4.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou4.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou4);

        BT_HuriDenpyou huriDenpyou5 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 05);
        huriDenpyou5.setTorihikino("88888");
        huriDenpyou5.setHuridenatesakicd("777");
        huriDenpyou5.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou5.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou5.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou5.setDenkanjokamokucd("33");
        huriDenpyou5.setJigyouhiutiwakecd("333");
        huriDenpyou5.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou5.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou5);

        BT_HuriDenpyou huriDenpyou6 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 06);
        huriDenpyou6.setTorihikino("77777");
        huriDenpyou6.setHuridenatesakicd("999");
        huriDenpyou6.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou6.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou6.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou6.setDenkanjokamokucd("33");
        huriDenpyou6.setJigyouhiutiwakecd("333");
        huriDenpyou6.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou6.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou6);

        BT_HuriDenpyou huriDenpyou7 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 07);
        huriDenpyou7.setTorihikino("77777");
        huriDenpyou7.setHuridenatesakicd("888");
        huriDenpyou7.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou7.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou7.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou7.setDenkanjokamokucd("33");
        huriDenpyou7.setJigyouhiutiwakecd("333");
        huriDenpyou7.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou7.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou7);

        BT_HuriDenpyou huriDenpyou8 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 21);
        huriDenpyou8.setTorihikino("77777");
        huriDenpyou8.setHuridenatesakicd("777");
        huriDenpyou8.setTantocd(C_TantouCdKbn.valueOf("5"));
        huriDenpyou8.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou8.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou8.setDenkanjokamokucd("33");
        huriDenpyou8.setJigyouhiutiwakecd("333");
        huriDenpyou8.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou8.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou8);

        BT_HuriDenpyou huriDenpyou9 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 22);
        huriDenpyou9.setTorihikino("77777");
        huriDenpyou9.setHuridenatesakicd("777");
        huriDenpyou9.setTantocd(C_TantouCdKbn.valueOf("4"));
        huriDenpyou9.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou9.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou9.setDenkanjokamokucd("33");
        huriDenpyou9.setJigyouhiutiwakecd("333");
        huriDenpyou9.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou9.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou9);

        BT_HuriDenpyou huriDenpyou10 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 10);
        huriDenpyou10.setTorihikino("77777");
        huriDenpyou10.setHuridenatesakicd("777");
        huriDenpyou10.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou10.setDenymd(BizDate.valueOf(20190714));
        huriDenpyou10.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou10.setDenkanjokamokucd("33");
        huriDenpyou10.setJigyouhiutiwakecd("333");
        huriDenpyou10.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou10.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou10);

        BT_HuriDenpyou huriDenpyou11 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 11);
        huriDenpyou11.setTorihikino("77777");
        huriDenpyou11.setHuridenatesakicd("777");
        huriDenpyou11.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou11.setDenymd(BizDate.valueOf(20180714));
        huriDenpyou11.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou11.setDenkanjokamokucd("33");
        huriDenpyou11.setJigyouhiutiwakecd("333");
        huriDenpyou11.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou11.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou11);

        BT_HuriDenpyou huriDenpyou12 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 12);
        huriDenpyou12.setTorihikino("77777");
        huriDenpyou12.setHuridenatesakicd("777");
        huriDenpyou12.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou12.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou12.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou12.setDenkanjokamokucd("33");
        huriDenpyou12.setJigyouhiutiwakecd("333");
        huriDenpyou12.setHuridenskskbn(C_HuridensksKbn.valueOf("4"));
        huriDenpyou12.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou12);

        BT_HuriDenpyou huriDenpyou13 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 13);
        huriDenpyou13.setTorihikino("77777");
        huriDenpyou13.setHuridenatesakicd("777");
        huriDenpyou13.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou13.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou13.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou13.setDenkanjokamokucd("33");
        huriDenpyou13.setJigyouhiutiwakecd("333");
        huriDenpyou13.setHuridenskskbn(C_HuridensksKbn.valueOf("3"));
        huriDenpyou13.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou13);

        BT_HuriDenpyou huriDenpyou14 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 14);
        huriDenpyou14.setTorihikino("77777");
        huriDenpyou14.setHuridenatesakicd("777");
        huriDenpyou14.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou14.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou14.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        huriDenpyou14.setDenkanjokamokucd("33");
        huriDenpyou14.setJigyouhiutiwakecd("333");
        huriDenpyou14.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou14.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou14);

        BT_HuriDenpyou huriDenpyou15 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 15);
        huriDenpyou15.setTorihikino("77777");
        huriDenpyou15.setHuridenatesakicd("777");
        huriDenpyou15.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou15.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou15.setTaisyakukbn(C_TaisyakuKbn.valueOf("1"));
        huriDenpyou15.setDenkanjokamokucd("11");
        huriDenpyou15.setJigyouhiutiwakecd("333");
        huriDenpyou15.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou15.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou15);

        BT_HuriDenpyou huriDenpyou16 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 16);
        huriDenpyou16.setTorihikino("77777");
        huriDenpyou16.setHuridenatesakicd("777");
        huriDenpyou16.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou16.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou16.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou16.setDenkanjokamokucd("33");
        huriDenpyou16.setJigyouhiutiwakecd("333");
        huriDenpyou16.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou16.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou16);

        BT_HuriDenpyou huriDenpyou17 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 17);
        huriDenpyou17.setTorihikino("77777");
        huriDenpyou17.setHuridenatesakicd("777");
        huriDenpyou17.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou17.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou17.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou17.setDenkanjokamokucd("22");
        huriDenpyou17.setJigyouhiutiwakecd("111");
        huriDenpyou17.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou17.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou17);

        BT_HuriDenpyou huriDenpyou18 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 18);
        huriDenpyou18.setTorihikino("77777");
        huriDenpyou18.setHuridenatesakicd("777");
        huriDenpyou18.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou18.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou18.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou18.setDenkanjokamokucd("11");
        huriDenpyou18.setJigyouhiutiwakecd("333");
        huriDenpyou18.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou18.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou18);

        BT_HuriDenpyou huriDenpyou19 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 19);
        huriDenpyou19.setTorihikino("77777");
        huriDenpyou19.setHuridenatesakicd("777");
        huriDenpyou19.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou19.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou19.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou19.setDenkanjokamokucd("11");
        huriDenpyou19.setJigyouhiutiwakecd("222");
        huriDenpyou19.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou19.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou19);

        BT_HuriDenpyou huriDenpyou20 = new BT_HuriDenpyou(C_DensysKbn.valueOf("0"), "1111", 20);
        huriDenpyou20.setTorihikino("77777");
        huriDenpyou20.setHuridenatesakicd("777");
        huriDenpyou20.setTantocd(C_TantouCdKbn.valueOf("3"));
        huriDenpyou20.setDenymd(BizDate.valueOf(20170714));
        huriDenpyou20.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        huriDenpyou20.setDenkanjokamokucd("11");
        huriDenpyou20.setJigyouhiutiwakecd("111");
        huriDenpyou20.setHuridenskskbn(C_HuridensksKbn.valueOf("2"));
        huriDenpyou20.setSyoriYmd(BizDate.valueOf(20160814));

        bizDomManager.insert(huriDenpyou20);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHuriDenpyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_HuriDenpyou> beans =
                bizDomManager.getHuriDenpyousBySyoriYmd(BizDate.valueOf(19960714))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousBySyoriYmd(BizDate.valueOf(20160714)))
        {

            int iCount = 0;
            Iterator<BT_HuriDenpyou> iter = beans.iterator();
            BT_HuriDenpyou huriDenpyou = null;
            while (iter.hasNext()) {

                huriDenpyou = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(01, huriDenpyou.getEdano().intValue());
                    continue;
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousBySyoriYmd(BizDate.valueOf(20160814)))
        {

            int iCount = 0;
            Iterator<BT_HuriDenpyou> iter = beans.iterator();
            BT_HuriDenpyou huriDenpyou = null;
            while (iter.hasNext()) {

                huriDenpyou = iter.next();
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(20, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("11", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("111", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(19, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("11", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("222", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(18, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("11", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(17, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("22", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("111", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(16, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(15, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KARIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("11", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(14, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(13, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(12, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(11, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(10, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(22, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.SOUKATU1, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20170714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(21, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(07, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("888", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (15 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(06, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("77777", huriDenpyou.getTorihikino());
                    Assert.assertEquals("999", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(05, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("88888", huriDenpyou.getTorihikino());
                    Assert.assertEquals("777", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }

                if (17 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, huriDenpyou.getDensyskbn());
                    Assert.assertEquals("1111", huriDenpyou.getDenrenno());
                    Assert.assertEquals(04, huriDenpyou.getEdano().intValue());

                    Assert.assertEquals("99999", huriDenpyou.getTorihikino());
                    Assert.assertEquals("999", huriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, huriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20190714), huriDenpyou.getDenymd());
                    Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                    Assert.assertEquals("33", huriDenpyou.getDenkanjokamokucd());
                    Assert.assertEquals("333", huriDenpyou.getJigyouhiutiwakecd());
                    Assert.assertEquals(C_HuridensksKbn.ONLINEFB, huriDenpyou.getHuridenskskbn());

                    continue;
                }
            }
            Assert.assertEquals(17, iCount);
        }
    }

}

