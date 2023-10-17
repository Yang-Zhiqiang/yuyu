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

import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_JidouSyuunouMeisaiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_JidouSyuunouMeisai> hT_JidouSyuunouMeisais = sinkeiyakuDomManager.getAllJidouSyuunouMeisai();

        Assert.assertEquals(0, hT_JidouSyuunouMeisais.size());

        BizDate pSyoriYmd22 =  BizDate.MAX_VALID_DATE;
        C_KessanKbn pKessankbn22 = C_KessanKbn.TUUJYOU;
        C_Tuukasyu  pRstuukasyu22 = C_Tuukasyu.JPY;
        HT_JidouSyuunouMeisai hT_JidouSyuunouMeisai22 = new HT_JidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu22);
        sinkeiyakuDomManager.insert(hT_JidouSyuunouMeisai22);

        C_Tuukasyu  pRstuukasyu21 = C_Tuukasyu.USD;
        HT_JidouSyuunouMeisai hT_JidouSyuunouMeisai21 = new HT_JidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu21);
        sinkeiyakuDomManager.insert(hT_JidouSyuunouMeisai21);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJidouSyuunouMeisai());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        BizDate pSyoriYmd22 =  BizDate.MAX_VALID_DATE;
        C_Tuukasyu  pRstuukasyu22 = C_Tuukasyu.JPY;
        C_KessanKbn pKessankbn22 = C_KessanKbn.TUUJYOU;
        C_Tuukasyu  pRstuukasyu21 = C_Tuukasyu.USD;
        List<HT_JidouSyuunouMeisai> hT_JidouSyuunouMeisais = sinkeiyakuDomManager.getAllJidouSyuunouMeisai();
        Assert.assertSame(hT_JidouSyuunouMeisais.get(0), sinkeiyakuDomManager.getJidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu22));
        Assert.assertSame(hT_JidouSyuunouMeisais.get(1), sinkeiyakuDomManager.getJidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu21));

        Assert.assertEquals(2, hT_JidouSyuunouMeisais.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        BizDate pSyoriYmd22 =  BizDate.MAX_VALID_DATE;
        C_KessanKbn pKessankbn22 = C_KessanKbn.TUUJYOU;
        C_Tuukasyu  pRstuukasyu22 = C_Tuukasyu.JPY;

        HT_JidouSyuunouMeisai hT_JidouSyuunouMeisai11 = sinkeiyakuDomManager.getJidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu22);

        Assert.assertEquals(pSyoriYmd22, hT_JidouSyuunouMeisai11.getSyoriYmd());
        Assert.assertEquals(pRstuukasyu22, hT_JidouSyuunouMeisai11.getRstuukasyu());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        BizDate pSyoriYmd22 =  BizDate.MAX_VALID_DATE;
        C_KessanKbn pKessankbn22 = C_KessanKbn.TUUJYOU;
        C_Tuukasyu  pRstuukasyu33 = C_Tuukasyu.AUD;

        HT_JidouSyuunouMeisai hW_JidouNyknTaisyougaiWk11 = sinkeiyakuDomManager.getJidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu33);

        Assert.assertNull(hW_JidouNyknTaisyougaiWk11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        BizDate pSyoriYmd22 =  BizDate.MAX_VALID_DATE;
        C_KessanKbn pKessankbn22 = C_KessanKbn.TUUJYOU;
        C_Tuukasyu  pRstuukasyu22 = C_Tuukasyu.BLNK;

        HT_JidouSyuunouMeisai hT_JidouSyuunouMeisai11 = sinkeiyakuDomManager.getJidouSyuunouMeisai(pSyoriYmd22,pKessankbn22,pRstuukasyu22);

        Assert.assertNull(hT_JidouSyuunouMeisai11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
