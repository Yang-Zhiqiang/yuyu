package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_SkGaikaFBSoukinDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSkGaikaFBSoukinData().size());

        String pFbsoukindatasikibetukey22 = "Fb22";

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData22 = new HT_SkGaikaFBSoukinData(pFbsoukindatasikibetukey22);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData22);

        String pFbsoukindatasikibetukey21 = "Fb21";

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData21 = new HT_SkGaikaFBSoukinData(pFbsoukindatasikibetukey21);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData21);

        String pFbsoukindatasikibetukey12 = "Fb12";

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData12 = new HT_SkGaikaFBSoukinData(pFbsoukindatasikibetukey12);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData12);

        String pFbsoukindatasikibetukey11 = "Fb11";

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData11 = new HT_SkGaikaFBSoukinData(pFbsoukindatasikibetukey11);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkGaikaFBSoukinData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pFbsoukindatasikibetukey22 = "Fb22";
        String pFbsoukindatasikibetukey21 = "Fb21";
        String pFbsoukindatasikibetukey12 = "Fb12";
        String pFbsoukindatasikibetukey11 = "Fb11";

        List<HT_SkGaikaFBSoukinData> hT_SkGaikaFBSoukinDatas = sinkeiyakuDomManager.getAllSkGaikaFBSoukinData();
        Assert.assertEquals(pFbsoukindatasikibetukey11,hT_SkGaikaFBSoukinDatas.get(0).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey12,hT_SkGaikaFBSoukinDatas.get(1).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey21,hT_SkGaikaFBSoukinDatas.get(2).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey22,hT_SkGaikaFBSoukinDatas.get(3).getFbsoukindatasikibetukey());

        Assert.assertEquals(4,hT_SkGaikaFBSoukinDatas.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pFbsoukindatasikibetukey22 = "Fb22";
        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinData(pFbsoukindatasikibetukey22);

        Assert.assertEquals(pFbsoukindatasikibetukey22, hT_SkGaikaFBSoukinData.getFbsoukindatasikibetukey());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pFbsoukindatasikibetukey33 = "Fb33";
        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinData(pFbsoukindatasikibetukey33);

        Assert.assertNull(hT_SkGaikaFBSoukinData);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pFbsoukindatasikibetukeyBlank = "";
        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinData(pFbsoukindatasikibetukeyBlank);

        Assert.assertNull(hT_SkGaikaFBSoukinData);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);

    }
}
