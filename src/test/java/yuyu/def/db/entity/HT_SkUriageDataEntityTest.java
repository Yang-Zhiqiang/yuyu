package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_SkUriageDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0, sinkeiyakuDomManager.getAllSkUriageData().size());

        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        C_AnsyuusysKbn Ansyuusyskbn2 = C_AnsyuusysKbn.HOZEN;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
        String pMosno1 = "Mosno0001";
        String pMosno2 = "Mosno0002";
        Integer pAuthorikaisuu1 = Integer.valueOf("1");
        Integer pAuthorikaisuu2 = Integer.valueOf("2");

        HT_SkUriageData hT_SkUriageData5 = new HT_SkUriageData();
        hT_SkUriageData5.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkUriageData5.setSyoriYmd(pSyoriYmd2);
        hT_SkUriageData5.setMosno(pMosno2);
        hT_SkUriageData5.setAuthorikaisuu(pAuthorikaisuu2);
        sinkeiyakuDomManager.insert(hT_SkUriageData5);

        HT_SkUriageData hT_SkUriageData4 = new HT_SkUriageData();
        hT_SkUriageData4.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkUriageData4.setSyoriYmd(pSyoriYmd2);
        hT_SkUriageData4.setMosno(pMosno2);
        hT_SkUriageData4.setAuthorikaisuu(pAuthorikaisuu1);
        sinkeiyakuDomManager.insert(hT_SkUriageData4);

        HT_SkUriageData hT_SkUriageData3 = new HT_SkUriageData();
        hT_SkUriageData3.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkUriageData3.setSyoriYmd(pSyoriYmd2);
        hT_SkUriageData3.setMosno(pMosno1);
        hT_SkUriageData3.setAuthorikaisuu(pAuthorikaisuu1);
        sinkeiyakuDomManager.insert(hT_SkUriageData3);

        HT_SkUriageData hT_SkUriageData2 = new HT_SkUriageData();
        hT_SkUriageData2.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkUriageData2.setSyoriYmd(pSyoriYmd1);
        hT_SkUriageData2.setMosno(pMosno1);
        hT_SkUriageData2.setAuthorikaisuu(pAuthorikaisuu1);
        sinkeiyakuDomManager.insert(hT_SkUriageData2);

        HT_SkUriageData hT_SkUriageData1 = new HT_SkUriageData();
        hT_SkUriageData1.setAnsyuusyskbn(Ansyuusyskbn1);
        hT_SkUriageData1.setSyoriYmd(pSyoriYmd1);
        hT_SkUriageData1.setMosno(pMosno1);
        hT_SkUriageData1.setAuthorikaisuu(pAuthorikaisuu1);
        sinkeiyakuDomManager.insert(hT_SkUriageData1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkUriageData());

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
        Integer pAuthorikaisuu1 = Integer.valueOf("1");
        Integer pAuthorikaisuu2 = Integer.valueOf("2");

        List<HT_SkUriageData> hT_SkUriageDatas = sinkeiyakuDomManager.getAllSkUriageData();
        Assert.assertEquals(Ansyuusyskbn1, hT_SkUriageDatas.get(0).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkUriageDatas.get(0).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkUriageDatas.get(0).getMosno());
        Assert.assertEquals(pAuthorikaisuu1, hT_SkUriageDatas.get(0).getAuthorikaisuu());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkUriageDatas.get(1).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkUriageDatas.get(1).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkUriageDatas.get(1).getMosno());
        Assert.assertEquals(pAuthorikaisuu1, hT_SkUriageDatas.get(1).getAuthorikaisuu());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkUriageDatas.get(2).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkUriageDatas.get(2).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkUriageDatas.get(2).getMosno());
        Assert.assertEquals(pAuthorikaisuu1, hT_SkUriageDatas.get(2).getAuthorikaisuu());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkUriageDatas.get(3).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkUriageDatas.get(3).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkUriageDatas.get(3).getMosno());
        Assert.assertEquals(pAuthorikaisuu1, hT_SkUriageDatas.get(3).getAuthorikaisuu());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkUriageDatas.get(4).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkUriageDatas.get(4).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkUriageDatas.get(4).getMosno());
        Assert.assertEquals(pAuthorikaisuu2, hT_SkUriageDatas.get(4).getAuthorikaisuu());

        Assert.assertEquals(5, hT_SkUriageDatas.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        String pMosno1 = "Mosno0001";
        Integer pAuthorikaisuu1 = Integer.valueOf("1");;
        HT_SkUriageData hT_SkUriageData = sinkeiyakuDomManager.getSkUriageData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, pAuthorikaisuu1);

        Assert.assertEquals(Ansyuusyskbn1, hT_SkUriageData.getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkUriageData.getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkUriageData.getMosno());
        Assert.assertEquals(pAuthorikaisuu1, hT_SkUriageData.getAuthorikaisuu());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosno1 = "Mosno0003";
        Integer pAuthorikaisuu1 = Integer.valueOf("4");

        HT_SkUriageData hT_SkUriageData = sinkeiyakuDomManager.getSkUriageData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, pAuthorikaisuu1);
        Assert.assertNull(hT_SkUriageData);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosnoBlank = "";
        Integer pAuthorikaisuu1 = Integer.valueOf("1");

        HT_SkUriageData hT_SkUriageData = sinkeiyakuDomManager.getSkUriageData(Ansyuusyskbn1,
            pSyoriYmd1, pMosnoBlank, pAuthorikaisuu1);
        Assert.assertNull(hT_SkUriageData);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);

    }
}
