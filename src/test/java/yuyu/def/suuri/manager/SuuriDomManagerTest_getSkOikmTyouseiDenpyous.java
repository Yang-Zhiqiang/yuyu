package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約追込調整伝票データテーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkOikmTyouseiDenpyous {

    @Inject
    SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ExDBResults<ST_SkOikmTyouseiDenpyou> beans = suuriDomManager.getSkOikmTyouseiDenpyous();

        int iCount = 0;
        for (ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou1 = new ST_SkOikmTyouseiDenpyou();
        skOikmTyouseiDenpyou1.setMosno("101");
        skOikmTyouseiDenpyou1.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        skOikmTyouseiDenpyou1.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmTyouseiDenpyou1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmTyouseiDenpyou1.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmTyouseiDenpyou1.setSeg1cd(C_Segcd.BLNK);
        suuriDomManager.insert(skOikmTyouseiDenpyou1);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal10() {

        ExDBResults<ST_SkOikmTyouseiDenpyou> beans = suuriDomManager.getSkOikmTyouseiDenpyous();

        int iCount = 0;
        for (ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("101", skOikmTyouseiDenpyou.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.BLNK, skOikmTyouseiDenpyou.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, skOikmTyouseiDenpyou.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skOikmTyouseiDenpyou.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, skOikmTyouseiDenpyou.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, skOikmTyouseiDenpyou.getSeg1cd());

            }
        }

        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(11)
    @Transactional
    public void normal11(){

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        suuriDomManager.delete(suuriDomManager.getAllSkOikmTyouseiDenpyou());

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou3 = new ST_SkOikmTyouseiDenpyou();
        skOikmTyouseiDenpyou3.setMosno("103");
        skOikmTyouseiDenpyou3.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        skOikmTyouseiDenpyou3.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmTyouseiDenpyou3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmTyouseiDenpyou3.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmTyouseiDenpyou3.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        suuriDomManager.insert(skOikmTyouseiDenpyou3);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou4 = new ST_SkOikmTyouseiDenpyou();
        skOikmTyouseiDenpyou4.setMosno("104");
        skOikmTyouseiDenpyou4.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        skOikmTyouseiDenpyou4.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmTyouseiDenpyou4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmTyouseiDenpyou4.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmTyouseiDenpyou4.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        suuriDomManager.insert(skOikmTyouseiDenpyou4);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou5 = new ST_SkOikmTyouseiDenpyou();
        skOikmTyouseiDenpyou5.setMosno("105");
        skOikmTyouseiDenpyou5.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        skOikmTyouseiDenpyou5.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmTyouseiDenpyou5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmTyouseiDenpyou5.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmTyouseiDenpyou5.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        suuriDomManager.insert(skOikmTyouseiDenpyou5);
    }

    @Test
    @TestOrder(20)
    public void normal20() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("103",C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY,C_TaisyakuKbn.KASIKATA,C_NaibuKeiyakuKbn.BLNK,C_TekiyouKbn.BLNK,C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI), "1");
        datamap.put($("104",C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD,C_TaisyakuKbn.KASIKATA,C_NaibuKeiyakuKbn.BLNK,C_TekiyouKbn.BLNK,C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI), "1");
        datamap.put($("105",C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD,C_TaisyakuKbn.KASIKATA,C_NaibuKeiyakuKbn.BLNK,C_TekiyouKbn.BLNK,C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI), "1");


        ExDBResults<ST_SkOikmTyouseiDenpyou> beans = suuriDomManager.getSkOikmTyouseiDenpyous();

        int iCount = 0;
        for (ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou : beans) {
            iCount++;
            datamap.remove($(skOikmTyouseiDenpyou.getMosno(),skOikmTyouseiDenpyou.getKanjyoukmkcd(),skOikmTyouseiDenpyou.getTaisyakukbn(),skOikmTyouseiDenpyou.getNaibukeiyakukbn(),skOikmTyouseiDenpyou.getTekiyoukbn(),skOikmTyouseiDenpyou.getSeg1cd()));
            //
            //            if (1 == iCount) {
            //
            //                Assert.assertEquals("103", skOikmTyouseiDenpyou.getMosno());
            //                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, skOikmTyouseiDenpyou.getKanjyoukmkcd());
            //                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skOikmTyouseiDenpyou.getTaisyakukbn());
            //                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skOikmTyouseiDenpyou.getNaibukeiyakukbn());
            //                Assert.assertEquals(C_TekiyouKbn.BLNK, skOikmTyouseiDenpyou.getTekiyoukbn());
            //                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, skOikmTyouseiDenpyou.getSeg1cd());
            //
            //            }
            //
            //            if (2 == iCount) {
            //                Assert.assertEquals("104", skOikmTyouseiDenpyou.getMosno());
            //                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, skOikmTyouseiDenpyou.getKanjyoukmkcd());
            //                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skOikmTyouseiDenpyou.getTaisyakukbn());
            //                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skOikmTyouseiDenpyou.getNaibukeiyakukbn());
            //                Assert.assertEquals(C_TekiyouKbn.BLNK, skOikmTyouseiDenpyou.getTekiyoukbn());
            //                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, skOikmTyouseiDenpyou.getSeg1cd());
            //            }
            //
            //            if (3 == iCount) {
            //                Assert.assertEquals("105", skOikmTyouseiDenpyou.getMosno());
            //                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, skOikmTyouseiDenpyou.getKanjyoukmkcd());
            //                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skOikmTyouseiDenpyou.getTaisyakukbn());
            //                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skOikmTyouseiDenpyou.getNaibukeiyakukbn());
            //                Assert.assertEquals(C_TekiyouKbn.BLNK, skOikmTyouseiDenpyou.getTekiyoukbn());
            //                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, skOikmTyouseiDenpyou.getSeg1cd());
            //            }
        }

        Assert.assertEquals(3, iCount);
        Assert.assertTrue(datamap.isEmpty());
    }


    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouList = suuriDomManager.getAllSkOikmTyouseiDenpyou();
        if(skOikmTyouseiDenpyouList.size() > 0){
            suuriDomManager.delete(skOikmTyouseiDenpyouList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}

