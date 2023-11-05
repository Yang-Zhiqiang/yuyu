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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HW_JidouNyknTaisyougaiWkEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate pNyksyoriymd22 =  BizDate.MAX_VALID_DATE;
        String Itirenno22 = "Itirenno22";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk22 = new HW_JidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno22);
        sinkeiyakuDomManager.insert(hW_JidouNyknTaisyougaiWk22);

        String Itirenno21 = "Itirenno21";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk21 = new HW_JidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno21);
        sinkeiyakuDomManager.insert(hW_JidouNyknTaisyougaiWk21);

        String Itirenno12 = "Itirenno12";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk12 = new HW_JidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno12);
        sinkeiyakuDomManager.insert(hW_JidouNyknTaisyougaiWk12);

        String Itirenno11 = "Itirenno11";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk11 = new HW_JidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno11);
        sinkeiyakuDomManager.insert(hW_JidouNyknTaisyougaiWk11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJidouNyknTaisyougaiWk());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        BizDate pNyksyoriymd22 =  BizDate.MAX_VALID_DATE;
        String Itirenno22 = "Itirenno22";
        String Itirenno21 = "Itirenno21";
        String Itirenno12 = "Itirenno12";
        String Itirenno11 = "Itirenno11";

        List<HW_JidouNyknTaisyougaiWk> hW_JidouNyknTaisyougaiWks = sinkeiyakuDomManager.getAllJidouNyknTaisyougaiWk();
        Assert.assertEquals(pNyksyoriymd22,hW_JidouNyknTaisyougaiWks.get(0).getNyksyoriymd());
        Assert.assertEquals(Itirenno11,hW_JidouNyknTaisyougaiWks.get(0).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_JidouNyknTaisyougaiWks.get(1).getNyksyoriymd());
        Assert.assertEquals(Itirenno12,hW_JidouNyknTaisyougaiWks.get(1).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_JidouNyknTaisyougaiWks.get(2).getNyksyoriymd());
        Assert.assertEquals(Itirenno21,hW_JidouNyknTaisyougaiWks.get(2).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_JidouNyknTaisyougaiWks.get(3).getNyksyoriymd());
        Assert.assertEquals(Itirenno22,hW_JidouNyknTaisyougaiWks.get(3).getItirenno());

        Assert.assertEquals(4, hW_JidouNyknTaisyougaiWks.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        BizDate pNyksyoriymd22 =  BizDate.MAX_VALID_DATE;
        String Itirenno22 = "Itirenno22";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk11 = sinkeiyakuDomManager.getJidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno22);

        Assert.assertEquals(pNyksyoriymd22, hW_JidouNyknTaisyougaiWk11.getNyksyoriymd());
        Assert.assertEquals(Itirenno22, hW_JidouNyknTaisyougaiWk11.getItirenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        BizDate pNyksyoriymd22 =  BizDate.MAX_VALID_DATE;
        String Itirenno33 = "Itirenno33";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk11 = sinkeiyakuDomManager.getJidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno33);

        Assert.assertNull(hW_JidouNyknTaisyougaiWk11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        BizDate pNyksyoriymd22 =  BizDate.MAX_VALID_DATE;
        String Itirenno22 = "";

        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk11 = sinkeiyakuDomManager.getJidouNyknTaisyougaiWk(pNyksyoriymd22,Itirenno22);

        Assert.assertNull(hW_JidouNyknTaisyougaiWk11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
