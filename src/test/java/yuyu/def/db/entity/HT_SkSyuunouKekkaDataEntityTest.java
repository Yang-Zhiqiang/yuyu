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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_SkSyuunouKekkaDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0, sinkeiyakuDomManager.getAllSkSyuunouKekkaData().size());

        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        C_AnsyuusysKbn Ansyuusyskbn2 = C_AnsyuusysKbn.HOZEN;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
        String pMosno1 = "Mosno0001";
        String pMosno2 = "Mosno0002";
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        BizDateYM pJyuutouym2 = BizDateYM.valueOf("201502");

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData5 = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData5.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkSyuunouKekkaData5.setSyoriYmd(pSyoriYmd2);
        hT_SkSyuunouKekkaData5.setMosno(pMosno2);
        hT_SkSyuunouKekkaData5.setJyuutouym(pJyuutouym2);
        sinkeiyakuDomManager.insert(hT_SkSyuunouKekkaData5);

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData4 = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData4.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkSyuunouKekkaData4.setSyoriYmd(pSyoriYmd2);
        hT_SkSyuunouKekkaData4.setMosno(pMosno2);
        hT_SkSyuunouKekkaData4.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkSyuunouKekkaData4);

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData3 = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData3.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkSyuunouKekkaData3.setSyoriYmd(pSyoriYmd2);
        hT_SkSyuunouKekkaData3.setMosno(pMosno1);
        hT_SkSyuunouKekkaData3.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkSyuunouKekkaData3);

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData2 = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData2.setAnsyuusyskbn(Ansyuusyskbn2);
        hT_SkSyuunouKekkaData2.setSyoriYmd(pSyoriYmd1);
        hT_SkSyuunouKekkaData2.setMosno(pMosno1);
        hT_SkSyuunouKekkaData2.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkSyuunouKekkaData2);

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData1 = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData1.setAnsyuusyskbn(Ansyuusyskbn1);
        hT_SkSyuunouKekkaData1.setSyoriYmd(pSyoriYmd1);
        hT_SkSyuunouKekkaData1.setMosno(pMosno1);
        hT_SkSyuunouKekkaData1.setJyuutouym(pJyuutouym1);
        sinkeiyakuDomManager.insert(hT_SkSyuunouKekkaData1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkSyuunouKekkaData());

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
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        BizDateYM pJyuutouym2 = BizDateYM.valueOf("201502");

        List<HT_SkSyuunouKekkaData> hT_SkSyuunouKekkaDatas = sinkeiyakuDomManager.getAllSkSyuunouKekkaData();
        Assert.assertEquals(Ansyuusyskbn1, hT_SkSyuunouKekkaDatas.get(0).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkSyuunouKekkaDatas.get(0).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkSyuunouKekkaDatas.get(0).getMosno());
        Assert.assertEquals(pJyuutouym1, hT_SkSyuunouKekkaDatas.get(0).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkSyuunouKekkaDatas.get(1).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkSyuunouKekkaDatas.get(1).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkSyuunouKekkaDatas.get(1).getMosno());
        Assert.assertEquals(pJyuutouym1, hT_SkSyuunouKekkaDatas.get(1).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkSyuunouKekkaDatas.get(2).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkSyuunouKekkaDatas.get(2).getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkSyuunouKekkaDatas.get(2).getMosno());
        Assert.assertEquals(pJyuutouym1, hT_SkSyuunouKekkaDatas.get(2).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkSyuunouKekkaDatas.get(3).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkSyuunouKekkaDatas.get(3).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkSyuunouKekkaDatas.get(3).getMosno());
        Assert.assertEquals(pJyuutouym1, hT_SkSyuunouKekkaDatas.get(3).getJyuutouym());

        Assert.assertEquals(Ansyuusyskbn2, hT_SkSyuunouKekkaDatas.get(4).getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd2, hT_SkSyuunouKekkaDatas.get(4).getSyoriYmd());
        Assert.assertEquals(pMosno2, hT_SkSyuunouKekkaDatas.get(4).getMosno());
        Assert.assertEquals(pJyuutouym2, hT_SkSyuunouKekkaDatas.get(4).getJyuutouym());

        Assert.assertEquals(5, hT_SkSyuunouKekkaDatas.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.SKEI;
        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
        String pMosno1 = "Mosno0001";
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201501");
        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData = sinkeiyakuDomManager.getSkSyuunouKekkaData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, pJyuutouym1);

        Assert.assertEquals(Ansyuusyskbn1, hT_SkSyuunouKekkaData.getAnsyuusyskbn());
        Assert.assertEquals(pSyoriYmd1, hT_SkSyuunouKekkaData.getSyoriYmd());
        Assert.assertEquals(pMosno1, hT_SkSyuunouKekkaData.getMosno());
        Assert.assertEquals(pJyuutouym1, hT_SkSyuunouKekkaData.getJyuutouym());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosno1 = "Mosno0003";
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201505");

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData = sinkeiyakuDomManager.getSkSyuunouKekkaData(Ansyuusyskbn1,
            pSyoriYmd1, pMosno1, pJyuutouym1);
        Assert.assertNull(hT_SkSyuunouKekkaData);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        C_AnsyuusysKbn Ansyuusyskbn1 = C_AnsyuusysKbn.ALL;
        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
        String pMosnoBlank = "";
        BizDateYM pJyuutouym1 = BizDateYM.valueOf("201505");

        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData = sinkeiyakuDomManager.getSkSyuunouKekkaData(Ansyuusyskbn1,
            pSyoriYmd1, pMosnoBlank, pJyuutouym1);
        Assert.assertNull(hT_SkSyuunouKekkaData);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }
}
