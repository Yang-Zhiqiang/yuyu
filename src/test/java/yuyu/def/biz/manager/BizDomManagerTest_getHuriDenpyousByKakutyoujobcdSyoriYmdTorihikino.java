package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino {

    @Inject
    BizDomManager bizDomManager;

    private static String P_JOB_CD_02 = "RGBC";
    private static String P_FILTER_ID = "Bz105";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_HuriDenpyou> beans =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(P_JOB_CD_02, BizDate.valueOf(20160215))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_HuriDenpyou huriDenpyou1 = new BT_HuriDenpyou(C_DensysKbn.SKEI, "1000000001", 1);
        huriDenpyou1.setTorihikino("1000001");
        huriDenpyou1.setHuridenatesakicd("101");
        huriDenpyou1.setTantocd(C_TantouCdKbn.BLNK0);
        huriDenpyou1.setDenymd(BizDate.valueOf(20160315));
        huriDenpyou1.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou1.setDenkanjokamokucd("10001");
        huriDenpyou1.setJigyouhiutiwakecd("1000001");
        huriDenpyou1.setHuridenskskbn(C_HuridensksKbn.BLNK);
        huriDenpyou1.setSyoriYmd(BizDate.valueOf(20160215));

        bizDomManager.insert(huriDenpyou1);

        BT_HuriDenpyou huriDenpyou2 = new BT_HuriDenpyou(C_DensysKbn.SKEI, "1000000001", 2);
        huriDenpyou2.setTorihikino("");
        huriDenpyou2.setHuridenatesakicd("101");
        huriDenpyou2.setTantocd(C_TantouCdKbn.BLNK0);
        huriDenpyou2.setDenymd(BizDate.valueOf(20160315));
        huriDenpyou2.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou2.setDenkanjokamokucd("10001");
        huriDenpyou2.setJigyouhiutiwakecd("1000001");
        huriDenpyou2.setHuridenskskbn(C_HuridensksKbn.BLNK);
        huriDenpyou2.setSyoriYmd(BizDate.valueOf(20160215));

        bizDomManager.insert(huriDenpyou2);

        BT_HuriDenpyou huriDenpyou3 = new BT_HuriDenpyou(C_DensysKbn.SKEI, "1000000001", 3);
        huriDenpyou3.setHuridenatesakicd("101");
        huriDenpyou3.setTantocd(C_TantouCdKbn.BLNK0);
        huriDenpyou3.setDenymd(BizDate.valueOf(20160315));
        huriDenpyou3.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou3.setDenkanjokamokucd("10001");
        huriDenpyou3.setJigyouhiutiwakecd("1000001");
        huriDenpyou3.setHuridenskskbn(C_HuridensksKbn.BLNK);
        huriDenpyou3.setSyoriYmd(BizDate.valueOf(20160215));

        bizDomManager.insert(huriDenpyou3);

        BT_HuriDenpyou huriDenpyou21 = new BT_HuriDenpyou(C_DensysKbn.SKEI, "1000000001", 4);
        huriDenpyou21.setTorihikino("1000001");
        huriDenpyou21.setHuridenatesakicd("101");
        huriDenpyou21.setTantocd(C_TantouCdKbn.BLNK0);
        huriDenpyou21.setDenymd(BizDate.valueOf(20160315));
        huriDenpyou21.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou21.setDenkanjokamokucd("10001");
        huriDenpyou21.setJigyouhiutiwakecd("1000001");
        huriDenpyou21.setHuridenskskbn(C_HuridensksKbn.BLNK);
        huriDenpyou21.setSyoriYmd(BizDate.valueOf(20160214));

        bizDomManager.insert(huriDenpyou21);

        BT_HuriDenpyou huriDenpyou4 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000002", 4);
        huriDenpyou4.setTorihikino("1000002");
        huriDenpyou4.setHuridenatesakicd("104");
        huriDenpyou4.setTantocd(C_TantouCdKbn.IMUSATEI);
        huriDenpyou4.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou4.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou4.setDenkanjokamokucd("10002");
        huriDenpyou4.setJigyouhiutiwakecd("1000002");
        huriDenpyou4.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou4.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou4);

        BT_HuriDenpyou huriDenpyou5 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000003", 5);
        huriDenpyou5.setTorihikino("1000004");
        huriDenpyou5.setHuridenatesakicd("102");
        huriDenpyou5.setTantocd(C_TantouCdKbn.IMUSATEI);
        huriDenpyou5.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou5.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou5.setDenkanjokamokucd("10002");
        huriDenpyou5.setJigyouhiutiwakecd("1000002");
        huriDenpyou5.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou5.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou5);

        BT_HuriDenpyou huriDenpyou6 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000004", 6);
        huriDenpyou6.setTorihikino("1000003");
        huriDenpyou6.setHuridenatesakicd("102");
        huriDenpyou6.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou6.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou6.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou6.setDenkanjokamokucd("10002");
        huriDenpyou6.setJigyouhiutiwakecd("1000002");
        huriDenpyou6.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou6.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou6);

        BT_HuriDenpyou huriDenpyou7 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000005", 7);
        huriDenpyou7.setTorihikino("1000004");
        huriDenpyou7.setHuridenatesakicd("104");
        huriDenpyou7.setTantocd(C_TantouCdKbn.IMUSATEI);
        huriDenpyou7.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou7.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou7.setDenkanjokamokucd("10002");
        huriDenpyou7.setJigyouhiutiwakecd("1000002");
        huriDenpyou7.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou7.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou7);

        BT_HuriDenpyou huriDenpyou8 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000006", 8);
        huriDenpyou8.setTorihikino("1000004");
        huriDenpyou8.setHuridenatesakicd("103");
        huriDenpyou8.setTantocd(C_TantouCdKbn.IMUSATEI);
        huriDenpyou8.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou8.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou8.setDenkanjokamokucd("10002");
        huriDenpyou8.setJigyouhiutiwakecd("1000002");
        huriDenpyou8.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou8.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou8);

        BT_HuriDenpyou huriDenpyou9 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000007", 9);
        huriDenpyou9.setTorihikino("1000004");
        huriDenpyou9.setHuridenatesakicd("104");
        huriDenpyou9.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou9.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou9.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou9.setDenkanjokamokucd("10002");
        huriDenpyou9.setJigyouhiutiwakecd("1000002");
        huriDenpyou9.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou9.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou9);

        BT_HuriDenpyou huriDenpyou10 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000008", 10);
        huriDenpyou10.setTorihikino("1000004");
        huriDenpyou10.setHuridenatesakicd("104");
        huriDenpyou10.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        huriDenpyou10.setDenymd(BizDate.valueOf(20160316));
        huriDenpyou10.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou10.setDenkanjokamokucd("10002");
        huriDenpyou10.setJigyouhiutiwakecd("1000002");
        huriDenpyou10.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou10.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou10);

        BT_HuriDenpyou huriDenpyou11 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000009", 11);
        huriDenpyou11.setTorihikino("1000004");
        huriDenpyou11.setHuridenatesakicd("104");
        huriDenpyou11.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou11.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou11.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou11.setDenkanjokamokucd("10002");
        huriDenpyou11.setJigyouhiutiwakecd("1000002");
        huriDenpyou11.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou11.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou11);

        BT_HuriDenpyou huriDenpyou12 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000010", 12);
        huriDenpyou12.setTorihikino("1000004");
        huriDenpyou12.setHuridenatesakicd("104");
        huriDenpyou12.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou12.setDenymd(BizDate.valueOf(20160317));
        huriDenpyou12.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou12.setDenkanjokamokucd("10004");
        huriDenpyou12.setJigyouhiutiwakecd("1000002");
        huriDenpyou12.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        huriDenpyou12.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou12);

        BT_HuriDenpyou huriDenpyou13 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000011", 13);
        huriDenpyou13.setTorihikino("1000004");
        huriDenpyou13.setHuridenatesakicd("104");
        huriDenpyou13.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou13.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou13.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou13.setDenkanjokamokucd("10002");
        huriDenpyou13.setJigyouhiutiwakecd("1000002");
        huriDenpyou13.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou13.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou13);

        BT_HuriDenpyou huriDenpyou14 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000012", 14);
        huriDenpyou14.setTorihikino("1000004");
        huriDenpyou14.setHuridenatesakicd("104");
        huriDenpyou14.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou14.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou14.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        huriDenpyou14.setDenkanjokamokucd("10002");
        huriDenpyou14.setJigyouhiutiwakecd("1000002");
        huriDenpyou14.setHuridenskskbn(C_HuridensksKbn.HOZENYAKAN);
        huriDenpyou14.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou14);

        BT_HuriDenpyou huriDenpyou15 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000013", 15);
        huriDenpyou15.setTorihikino("1000004");
        huriDenpyou15.setHuridenatesakicd("104");
        huriDenpyou15.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou15.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou15.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou15.setDenkanjokamokucd("10004");
        huriDenpyou15.setJigyouhiutiwakecd("1000002");
        huriDenpyou15.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou15.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou15);

        BT_HuriDenpyou huriDenpyou16 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000014", 16);
        huriDenpyou16.setTorihikino("1000004");
        huriDenpyou16.setHuridenatesakicd("104");
        huriDenpyou16.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou16.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou16.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        huriDenpyou16.setDenkanjokamokucd("10003");
        huriDenpyou16.setJigyouhiutiwakecd("1000004");
        huriDenpyou16.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou16.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou16);

        BT_HuriDenpyou huriDenpyou17 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000015", 17);
        huriDenpyou17.setTorihikino("1000004");
        huriDenpyou17.setHuridenatesakicd("104");
        huriDenpyou17.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou17.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou17.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        huriDenpyou17.setDenkanjokamokucd("10004");
        huriDenpyou17.setJigyouhiutiwakecd("1000002");
        huriDenpyou17.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou17.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou17);

        BT_HuriDenpyou huriDenpyou18 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000016", 18);
        huriDenpyou18.setTorihikino("1000004");
        huriDenpyou18.setHuridenatesakicd("104");
        huriDenpyou18.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou18.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou18.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        huriDenpyou18.setDenkanjokamokucd("10004");
        huriDenpyou18.setJigyouhiutiwakecd("1000002");
        huriDenpyou18.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou18.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou18);

        BT_HuriDenpyou huriDenpyou19 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000017", 19);
        huriDenpyou19.setTorihikino("1000004");
        huriDenpyou19.setHuridenatesakicd("104");
        huriDenpyou19.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou19.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou19.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        huriDenpyou19.setDenkanjokamokucd("10004");
        huriDenpyou19.setJigyouhiutiwakecd("1000004");
        huriDenpyou19.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou19.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou19);

        BT_HuriDenpyou huriDenpyou20 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, "1000000018", 20);
        huriDenpyou20.setTorihikino("1000004");
        huriDenpyou20.setHuridenatesakicd("104");
        huriDenpyou20.setTantocd(C_TantouCdKbn.IMUIMU);
        huriDenpyou20.setDenymd(BizDate.valueOf(20160318));
        huriDenpyou20.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        huriDenpyou20.setDenkanjokamokucd("10004");
        huriDenpyou20.setJigyouhiutiwakecd("1000003");
        huriDenpyou20.setHuridenskskbn(C_HuridensksKbn.KOBETU);
        huriDenpyou20.setSyoriYmd(BizDate.valueOf(20160220));

        bizDomManager.insert(huriDenpyou20);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllHuriDenpyou());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_HuriDenpyou> beans =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(P_JOB_CD_02, BizDate.valueOf(20160228))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(P_JOB_CD_02,
            BizDate.valueOf(20160215));

        int iCount = 0;
        for (BT_HuriDenpyou huriDenpyou : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000001", huriDenpyou.getDenrenno());
                Assert.assertEquals(1, huriDenpyou.getEdano().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(P_JOB_CD_02,
            BizDate.valueOf(20160220));

        int iCount = 0;
        for (BT_HuriDenpyou huriDenpyou : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000002", huriDenpyou.getDenrenno());
                Assert.assertEquals(4, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000002", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (2 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000004", huriDenpyou.getDenrenno());
                Assert.assertEquals(6, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000003", huriDenpyou.getTorihikino());
                Assert.assertEquals("102", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (3 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000003", huriDenpyou.getDenrenno());
                Assert.assertEquals(5, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("102", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (4 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000006", huriDenpyou.getDenrenno());
                Assert.assertEquals(8, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("103", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (5 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000005", huriDenpyou.getDenrenno());
                Assert.assertEquals(7, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }
            if (6 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000008", huriDenpyou.getDenrenno());
                Assert.assertEquals(10, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (7 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000007", huriDenpyou.getDenrenno());
                Assert.assertEquals(9, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160316), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (8 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000010", huriDenpyou.getDenrenno());
                Assert.assertEquals(12, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160317), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (9 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000009", huriDenpyou.getDenrenno());
                Assert.assertEquals(11, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (10 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000012", huriDenpyou.getDenrenno());
                Assert.assertEquals(14, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (11 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000011", huriDenpyou.getDenrenno());
                Assert.assertEquals(13, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10002", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (12 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000014", huriDenpyou.getDenrenno());
                Assert.assertEquals(16, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10003", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000004", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (13 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000013", huriDenpyou.getDenrenno());
                Assert.assertEquals(15, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }
            if (14 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000016", huriDenpyou.getDenrenno());
                Assert.assertEquals(18, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }
            if (15 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000015", huriDenpyou.getDenrenno());
                Assert.assertEquals(17, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000002", huriDenpyou.getJigyouhiutiwakecd());
            }

            if (16 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000018", huriDenpyou.getDenrenno());
                Assert.assertEquals(20, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000003", huriDenpyou.getJigyouhiutiwakecd());
            }
            if (17 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, huriDenpyou.getDensyskbn());
                Assert.assertEquals("1000000017", huriDenpyou.getDenrenno());
                Assert.assertEquals(19, huriDenpyou.getEdano().intValue());
                Assert.assertEquals("1000004", huriDenpyou.getTorihikino());
                Assert.assertEquals("104", huriDenpyou.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, huriDenpyou.getTantocd());
                Assert.assertEquals(BizDate.valueOf(20160318), huriDenpyou.getDenymd());
                Assert.assertEquals(C_HuridensksKbn.KOBETU, huriDenpyou.getHuridenskskbn());
                Assert.assertEquals("10004", huriDenpyou.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, huriDenpyou.getTaisyakukbn());
                Assert.assertEquals("1000004", huriDenpyou.getJigyouhiutiwakecd());
            }
        }
        Assert.assertEquals(17, iCount);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(
            P_JOB_CD_02, BizDate.valueOf(20160220));){
            for(BT_HuriDenpyou huriDenpyou : beans){

                iCount++;
            }

            Assert.assertEquals(17, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("densyskbn");
        filter.setRecoveryfilterkeykmid2("denrenno");
        filter.setRecoveryfilternm("伝票データフィルタ");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        key3.setRecoveryfilterkey2("1000000017");
        key3.setTableid("BT_HuriDenpyou");
        bizDomManager.insert(key3);
    }
    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(
            P_JOB_CD_02, BizDate.valueOf(20160220));){
            for(BT_HuriDenpyou huriDenpyou : beans){
                assertNotEquals(huriDenpyou.getDenrenno(), "1000000017");

                iCount++;
            }
            Assert.assertEquals(16, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey2("1000000018");
        key1.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        key1.setTableid("BT_HuriDenpyou");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<BT_HuriDenpyou> beans = bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(
            P_JOB_CD_02, BizDate.valueOf(20160220));){
            for(BT_HuriDenpyou huriDenpyou : beans){
                assertNotEquals(huriDenpyou.getDenrenno(), "1000000017");
                assertNotEquals(huriDenpyou.getDenrenno(), "1000000018");

                iCount++;
            }
            assertEquals(15, iCount);
        }
    }
}


