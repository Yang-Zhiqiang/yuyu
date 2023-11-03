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
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 処理年月日を指定して、新契約振替伝票作成用テーブルエンティティリスト（大量）を取得します。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSinkeiyakuHurikaeDensBySyoriYmd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try(ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResBean = bizDomManager.
        		getSinkeiyakuHurikaeDensBySyoriYmd(BizDate.valueOf(20160707))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen1 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0000", 00);
        sinkeiyakuHurikaeDen1.setHuridenatesakicd("000");
        sinkeiyakuHurikaeDen1.setDenymd(BizDate.valueOf(20160606));
        sinkeiyakuHurikaeDen1.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen1.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen1.setSyoriYmd(BizDate.valueOf(20160707));
        sinkeiyakuHurikaeDen1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen1.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen1);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen2 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0001", 01);
        sinkeiyakuHurikaeDen2.setHuridenatesakicd("001");
        sinkeiyakuHurikaeDen2.setDenymd(BizDate.valueOf(20160607));
        sinkeiyakuHurikaeDen2.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen2.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen2.setSyoriYmd(BizDate.valueOf(20160708));
        sinkeiyakuHurikaeDen2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen2.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen2);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen3 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0002", 02);
        sinkeiyakuHurikaeDen3.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen3.setDenymd(BizDate.valueOf(20160610));
        sinkeiyakuHurikaeDen3.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen3.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen3.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen3.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen3);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen4 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0003", 03);
        sinkeiyakuHurikaeDen4.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen4.setDenymd(BizDate.valueOf(20160609));
        sinkeiyakuHurikaeDen4.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen4.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen4.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen4.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen4);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen5 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0004", 04);
        sinkeiyakuHurikaeDen5.setHuridenatesakicd("013");
        sinkeiyakuHurikaeDen5.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen5.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen5.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen5.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen5.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen5);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen6 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0005", 05);
        sinkeiyakuHurikaeDen6.setHuridenatesakicd("012");
        sinkeiyakuHurikaeDen6.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen6.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen6.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen6.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen6.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen6.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen6);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen7 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0006", 06);
        sinkeiyakuHurikaeDen7.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen7.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen7.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        sinkeiyakuHurikaeDen7.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen7.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen7.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen7.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen7);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen8 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0007", 07);
        sinkeiyakuHurikaeDen8.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen8.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen8.setTaisyakukbn(C_TaisyakuKbn.valueOf("1"));
        sinkeiyakuHurikaeDen8.setDenkanjokamokucd("000");
        sinkeiyakuHurikaeDen8.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen8.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen8.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen8);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen9 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0008", 12);
        sinkeiyakuHurikaeDen9.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen9.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen9.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen9.setDenkanjokamokucd("006");
        sinkeiyakuHurikaeDen9.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen9.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen9.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen9);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen10 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0009", 13);
        sinkeiyakuHurikaeDen10.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen10.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen10.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen10.setDenkanjokamokucd("005");
        sinkeiyakuHurikaeDen10.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen10.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen10.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen10);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen11 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.valueOf("10"), "0010", 14);
        sinkeiyakuHurikaeDen11.setHuridenatesakicd("011");
        sinkeiyakuHurikaeDen11.setDenymd(BizDate.valueOf(20160608));
        sinkeiyakuHurikaeDen11.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen11.setDenkanjokamokucd("004");
        sinkeiyakuHurikaeDen11.setSyoriYmd(BizDate.valueOf(20160709));
        sinkeiyakuHurikaeDen11.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        sinkeiyakuHurikaeDen11.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(sinkeiyakuHurikaeDen11);


    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSinkeiyakuHurikaeDen());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResBean = bizDomManager.
        		getSinkeiyakuHurikaeDensBySyoriYmd(BizDate.valueOf(20160701))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        try(ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResBean = bizDomManager.
        		getSinkeiyakuHurikaeDensBySyoriYmd(BizDate.valueOf(20160707))) {

            int iCount = 0;
            Iterator<BT_SinkeiyakuHurikaeDen> iter = exDBResBean.iterator();
            BT_SinkeiyakuHurikaeDen tKTBSDbean = null;
            while (iter.hasNext()) {

                tKTBSDbean = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.valueOf("10"), tKTBSDbean.getDensyskbn());
                Assert.assertEquals("0000", tKTBSDbean.getDenrenno());
                Assert.assertEquals(00, tKTBSDbean.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160606), tKTBSDbean.getDenymd());
                Assert.assertEquals("000", tKTBSDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), tKTBSDbean.getTaisyakukbn());
                Assert.assertEquals("000", tKTBSDbean.getDenkanjokamokucd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), tKTBSDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.valueOf("0"), tKTBSDbean.getTekiyoukbn());

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResBean = bizDomManager.
        		getSinkeiyakuHurikaeDensBySyoriYmd(BizDate.valueOf(20160709))) {

            int iCount = 0;
            for (BT_SinkeiyakuHurikaeDen entityBean : exDBResBean) {

                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                    Assert.assertEquals("0010", entityBean.getDenrenno());
                    Assert.assertEquals(14, entityBean.getEdano().intValue());
                    Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                    Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                    Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                    Assert.assertEquals("004", entityBean.getDenkanjokamokucd());
                    Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                    Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
                }

                if (2 == iCount) {
                   Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                   Assert.assertEquals("0009", entityBean.getDenrenno());
                   Assert.assertEquals(13, entityBean.getEdano().intValue());
                   Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                   Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                   Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                   Assert.assertEquals("005", entityBean.getDenkanjokamokucd());
                   Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                   Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
               }

                if (3 == iCount) {
                   Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                   Assert.assertEquals("0008", entityBean.getDenrenno());
                   Assert.assertEquals(12, entityBean.getEdano().intValue());
                   Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                   Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                   Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                   Assert.assertEquals("006", entityBean.getDenkanjokamokucd());
                   Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                   Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
               }

                if (4 == iCount) {
                   Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                   Assert.assertEquals("0007", entityBean.getDenrenno());
                   Assert.assertEquals(07, entityBean.getEdano().intValue());
                   Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                   Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                   Assert.assertEquals(C_TaisyakuKbn.valueOf("1"), entityBean.getTaisyakukbn());
                   Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                   Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                   Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
               }

                if (5 == iCount) {
                   Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                   Assert.assertEquals("0006", entityBean.getDenrenno());
                   Assert.assertEquals(06, entityBean.getEdano().intValue());
                   Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                   Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                   Assert.assertEquals(C_TaisyakuKbn.valueOf("2"), entityBean.getTaisyakukbn());
                   Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                   Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                   Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
               }

                if (6 == iCount) {
                      Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                      Assert.assertEquals("0005", entityBean.getDenrenno());
                      Assert.assertEquals(05, entityBean.getEdano().intValue());
                      Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                      Assert.assertEquals("012", entityBean.getHuridenatesakicd());
                      Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                      Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                      Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                      Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
                  }

                if (7 == iCount) {
                      Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                      Assert.assertEquals("0004", entityBean.getDenrenno());
                      Assert.assertEquals(04, entityBean.getEdano().intValue());
                      Assert.assertEquals(BizDate.valueOf(20160608), entityBean.getDenymd());
                      Assert.assertEquals("013", entityBean.getHuridenatesakicd());
                      Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                      Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                      Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                      Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
                  }

                if (8 == iCount) {
                      Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                      Assert.assertEquals("0003", entityBean.getDenrenno());
                      Assert.assertEquals(03, entityBean.getEdano().intValue());
                      Assert.assertEquals(BizDate.valueOf(20160609), entityBean.getDenymd());
                      Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                      Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                      Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                      Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                      Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
                  }

                if (9 == iCount) {
                     Assert.assertEquals(C_DensysKbn.valueOf("10"), entityBean.getDensyskbn());
                     Assert.assertEquals("0002", entityBean.getDenrenno());
                     Assert.assertEquals(02, entityBean.getEdano().intValue());
                     Assert.assertEquals(BizDate.valueOf(20160610), entityBean.getDenymd());
                     Assert.assertEquals("011", entityBean.getHuridenatesakicd());
                     Assert.assertEquals(C_TaisyakuKbn.valueOf("0"), entityBean.getTaisyakukbn());
                     Assert.assertEquals("000", entityBean.getDenkanjokamokucd());
                     Assert.assertEquals(C_NaibuKeiyakuKbn.valueOf("0"), entityBean.getNaibukeiyakukbn());
                     Assert.assertEquals(C_TekiyouKbn.valueOf("0"), entityBean.getTekiyoukbn());
                 }


            }
            Assert.assertEquals(9, iCount);
        }
    }
}