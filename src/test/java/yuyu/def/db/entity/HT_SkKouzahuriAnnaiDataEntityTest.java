package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_SkKouzahuriAnnaiDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0, sinkeiyakuDomManager.getAllSkKouzahuriAnnaiData().size());

        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        C_AnsyuusysKbn Ansyuusyskbn2 = C_AnsyuusysKbn.HOZEN;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
        String pMosno1 = "Mosno0001";
        String pMosno2 = "Mosno0002";
        C_NyknaiyouKbn NyknaiyouKbn1 = C_NyknaiyouKbn.HARAIHENYOUP;
        C_NyknaiyouKbn NyknaiyouKbn2 = C_NyknaiyouKbn.HUKKATUYOUP;
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        BizDateYM pJyuutouym2 = BizDateYM.valueOf("201502");

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData6 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData6.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkKouzahuriAnnaiData6.setSyoriYmd(pSyoriYmd2);
        hT_SkKouzahuriAnnaiData6.setMosno(pMosno2);
        hT_SkKouzahuriAnnaiData6.setNyknaiyoukbn(NyknaiyouKbn2);
        hT_SkKouzahuriAnnaiData6.setJyuutouym(pJyuutouym2);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData6);

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData5 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData5.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkKouzahuriAnnaiData5.setSyoriYmd(pSyoriYmd2);
        hT_SkKouzahuriAnnaiData5.setMosno(pMosno2);
        hT_SkKouzahuriAnnaiData5.setNyknaiyoukbn(NyknaiyouKbn2);
        hT_SkKouzahuriAnnaiData5.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData5);

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData4 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData4.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkKouzahuriAnnaiData4.setSyoriYmd(pSyoriYmd2);
        hT_SkKouzahuriAnnaiData4.setMosno(pMosno2);
        hT_SkKouzahuriAnnaiData4.setNyknaiyoukbn(NyknaiyouKbn1);
        hT_SkKouzahuriAnnaiData4.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData4);

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData3 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData3.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkKouzahuriAnnaiData3.setSyoriYmd(pSyoriYmd2);
        hT_SkKouzahuriAnnaiData3.setMosno(pMosno1);
        hT_SkKouzahuriAnnaiData3.setNyknaiyoukbn(NyknaiyouKbn1);
        hT_SkKouzahuriAnnaiData3.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData3);

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData2 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData2.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkKouzahuriAnnaiData2.setSyoriYmd(pSyoriYmd1);
        hT_SkKouzahuriAnnaiData2.setMosno(pMosno1);
        hT_SkKouzahuriAnnaiData2.setNyknaiyoukbn(NyknaiyouKbn1);
        hT_SkKouzahuriAnnaiData2.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData2);

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData1 = new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData1.setAnsyuusyskbn(Ansyuusyskbn1);
        hT_SkKouzahuriAnnaiData1.setSyoriYmd(pSyoriYmd1);
        hT_SkKouzahuriAnnaiData1.setMosno(pMosno1);
        hT_SkKouzahuriAnnaiData1.setNyknaiyoukbn(NyknaiyouKbn1);
        hT_SkKouzahuriAnnaiData1.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkKouzahuriAnnaiData1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkKouzahuriAnnaiData());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        C_AnsyuusysKbn Ansyuusyskbn2 = C_AnsyuusysKbn.HOZEN;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
        String pMosno1 = "Mosno0001";
        String pMosno2 = "Mosno0002";
        C_NyknaiyouKbn NyknaiyouKbn1 = C_NyknaiyouKbn.HARAIHENYOUP;
        C_NyknaiyouKbn NyknaiyouKbn2 = C_NyknaiyouKbn.HUKKATUYOUP;
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        BizDateYM pJyuutouym2 = BizDateYM.valueOf("201502");

        List<HT_SkKouzahuriAnnaiData> hT_SkKouzahuriAnnaiDatas = sinkeiyakuDomManager.getAllSkKouzahuriAnnaiData();
        Assert.assertEquals(Ansyuusyskbn1, hT_SkKouzahuriAnnaiDatas.get(0).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkKouzahuriAnnaiDatas.get(0).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkKouzahuriAnnaiDatas.get(0).getMosno());
        Assert.assertEquals(NyknaiyouKbn1, hT_SkKouzahuriAnnaiDatas.get(0).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiDatas.get(0).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkKouzahuriAnnaiDatas.get(1).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkKouzahuriAnnaiDatas.get(1).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkKouzahuriAnnaiDatas.get(1).getMosno());
        Assert.assertEquals(NyknaiyouKbn1, hT_SkKouzahuriAnnaiDatas.get(1).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiDatas.get(1).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkKouzahuriAnnaiDatas.get(2).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkKouzahuriAnnaiDatas.get(2).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkKouzahuriAnnaiDatas.get(2).getMosno());
        Assert.assertEquals(NyknaiyouKbn1, hT_SkKouzahuriAnnaiDatas.get(2).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiDatas.get(2).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkKouzahuriAnnaiDatas.get(3).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkKouzahuriAnnaiDatas.get(3).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkKouzahuriAnnaiDatas.get(3).getMosno());
        Assert.assertEquals(NyknaiyouKbn1, hT_SkKouzahuriAnnaiDatas.get(3).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiDatas.get(3).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkKouzahuriAnnaiDatas.get(4).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkKouzahuriAnnaiDatas.get(4).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkKouzahuriAnnaiDatas.get(4).getMosno());
        Assert.assertEquals(NyknaiyouKbn2, hT_SkKouzahuriAnnaiDatas.get(4).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiDatas.get(4).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkKouzahuriAnnaiDatas.get(5).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkKouzahuriAnnaiDatas.get(5).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkKouzahuriAnnaiDatas.get(5).getMosno());
        Assert.assertEquals(NyknaiyouKbn2, hT_SkKouzahuriAnnaiDatas.get(5).getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym2, hT_SkKouzahuriAnnaiDatas.get(5).getJyuutouym());

        Assert.assertEquals(6, hT_SkKouzahuriAnnaiDatas.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        String pMosno1 = "Mosno0001";
        C_NyknaiyouKbn NyknaiyouKbn1 = C_NyknaiyouKbn.HARAIHENYOUP;
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, NyknaiyouKbn1, pJyuutouym1);

        Assert.assertEquals(Ansyuusyskbn1, hT_SkKouzahuriAnnaiData.getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkKouzahuriAnnaiData.getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkKouzahuriAnnaiData.getMosno());
        Assert.assertEquals(NyknaiyouKbn1, hT_SkKouzahuriAnnaiData.getNyknaiyoukbn());
        Assert.assertEquals(pJyuutouym1, hT_SkKouzahuriAnnaiData.getJyuutouym());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosno1 = "Mosno0003";
        C_NyknaiyouKbn NyknaiyouKbn1 = C_NyknaiyouKbn.KEIZOKUP;
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201505");

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, NyknaiyouKbn1, pJyuutouym1);
        Assert.assertNull(hT_SkKouzahuriAnnaiData);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosnoBlank = "";
        C_NyknaiyouKbn NyknaiyouKbn1 = C_NyknaiyouKbn.KEIZOKUP;
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201505");

        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiData(Ansyuusyskbn1,
            pSyoriYmd1, pMosnoBlank, NyknaiyouKbn1, pJyuutouym1);
        Assert.assertNull(hT_SkKouzahuriAnnaiData);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);

    }
}
