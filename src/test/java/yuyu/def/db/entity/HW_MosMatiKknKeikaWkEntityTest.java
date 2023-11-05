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
public class HW_MosMatiKknKeikaWkEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate pNyksyoriymd22 = BizDate.MAX_VALID_DATE;
        String pItirenno22 = "Itirenno22";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk22 = new HW_MosMatiKknKeikaWk(pNyksyoriymd22,pItirenno22);
        sinkeiyakuDomManager.insert(hW_MosMatiKknKeikaWk22);

        String pItirenno21 = "Itirenno21";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk21 = new HW_MosMatiKknKeikaWk(pNyksyoriymd22,pItirenno21);
        sinkeiyakuDomManager.insert(hW_MosMatiKknKeikaWk21);

        String pItirenno12 = "Itirenno12";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk12 = new HW_MosMatiKknKeikaWk(pNyksyoriymd22,pItirenno12);
        sinkeiyakuDomManager.insert(hW_MosMatiKknKeikaWk12);

        String pItirenno11 = "Itirenno11";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk11 = new HW_MosMatiKknKeikaWk(pNyksyoriymd22,pItirenno11);
        sinkeiyakuDomManager.insert(hW_MosMatiKknKeikaWk11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMatiKknKeikaWk());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        BizDate pNyksyoriymd22 = BizDate.MAX_VALID_DATE;
        String pItirenno22 = "Itirenno22";
        String pItirenno21 = "Itirenno21";
        String pItirenno12 = "Itirenno12";
        String pItirenno11 = "Itirenno11";

        List<HW_MosMatiKknKeikaWk> hW_MosMatiKknKeikaWks = sinkeiyakuDomManager.getAllMosMatiKknKeikaWk();
        Assert.assertEquals(pNyksyoriymd22,hW_MosMatiKknKeikaWks.get(0).getNyksyoriymd());
        Assert.assertEquals(pItirenno11,hW_MosMatiKknKeikaWks.get(0).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_MosMatiKknKeikaWks.get(1).getNyksyoriymd());
        Assert.assertEquals(pItirenno12,hW_MosMatiKknKeikaWks.get(1).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_MosMatiKknKeikaWks.get(2).getNyksyoriymd());
        Assert.assertEquals(pItirenno21,hW_MosMatiKknKeikaWks.get(2).getItirenno());
        Assert.assertEquals(pNyksyoriymd22,hW_MosMatiKknKeikaWks.get(3).getNyksyoriymd());
        Assert.assertEquals(pItirenno22,hW_MosMatiKknKeikaWks.get(3).getItirenno());

        Assert.assertEquals(4, hW_MosMatiKknKeikaWks.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        BizDate pNyksyoriymd22 = BizDate.MAX_VALID_DATE;
        String pItirenno22 = "Itirenno22";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk11 = sinkeiyakuDomManager.getMosMatiKknKeikaWk(pNyksyoriymd22, pItirenno22);

        Assert.assertEquals(pNyksyoriymd22, hW_MosMatiKknKeikaWk11.getNyksyoriymd());
        Assert.assertEquals(pItirenno22, hW_MosMatiKknKeikaWk11.getItirenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        BizDate pNyksyoriymd22 = BizDate.MAX_VALID_DATE;
        String pItirenno33 = "Itirenno33";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk11 = sinkeiyakuDomManager.getMosMatiKknKeikaWk(pNyksyoriymd22, pItirenno33);

        Assert.assertNull(hW_MosMatiKknKeikaWk11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        BizDate pNyksyoriymd22 = BizDate.MAX_VALID_DATE;
        String pItirenno22 = "";

        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk11 = sinkeiyakuDomManager.getMosMatiKknKeikaWk(pNyksyoriymd22, pItirenno22);

        Assert.assertNull(hW_MosMatiKknKeikaWk11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
