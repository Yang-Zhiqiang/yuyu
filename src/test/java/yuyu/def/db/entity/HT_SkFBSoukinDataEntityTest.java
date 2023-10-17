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
public class HT_SkFBSoukinDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSkFBSoukinData().size());

        String pFbsoukindatasikibetukey22 = "Fb22";

        HT_SkFBSoukinData hT_SkFBSoukinData22 = new HT_SkFBSoukinData(pFbsoukindatasikibetukey22);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData22);

        String pFbsoukindatasikibetukey21 = "Fb21";

        HT_SkFBSoukinData hT_SkFBSoukinData21 = new HT_SkFBSoukinData(pFbsoukindatasikibetukey21);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData21);

        String pFbsoukindatasikibetukey12 = "Fb12";

        HT_SkFBSoukinData hT_SkFBSoukinData12 = new HT_SkFBSoukinData(pFbsoukindatasikibetukey12);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData12);

        String pFbsoukindatasikibetukey11 = "Fb11";

        HT_SkFBSoukinData hT_SkFBSoukinData11 = new HT_SkFBSoukinData(pFbsoukindatasikibetukey11);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkFBSoukinData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pFbsoukindatasikibetukey22 = "Fb22";
        String pFbsoukindatasikibetukey21 = "Fb21";
        String pFbsoukindatasikibetukey12 = "Fb12";
        String pFbsoukindatasikibetukey11 = "Fb11";

        List<HT_SkFBSoukinData> HT_SkFBSoukinDatas = sinkeiyakuDomManager.getAllSkFBSoukinData();
        Assert.assertEquals(pFbsoukindatasikibetukey11,HT_SkFBSoukinDatas.get(0).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey12,HT_SkFBSoukinDatas.get(1).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey21,HT_SkFBSoukinDatas.get(2).getFbsoukindatasikibetukey());
        Assert.assertEquals(pFbsoukindatasikibetukey22,HT_SkFBSoukinDatas.get(3).getFbsoukindatasikibetukey());

        Assert.assertEquals(4,HT_SkFBSoukinDatas.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pFbsoukindatasikibetukey22 = "Fb22";
        HT_SkFBSoukinData hT_SkFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinData(pFbsoukindatasikibetukey22);

        Assert.assertEquals(pFbsoukindatasikibetukey22, hT_SkFBSoukinData.getFbsoukindatasikibetukey());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pFbsoukindatasikibetukey33 = "Fb33";
        HT_SkFBSoukinData hT_SkFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinData(pFbsoukindatasikibetukey33);

        Assert.assertNull(hT_SkFBSoukinData);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pFbsoukindatasikibetukey = "";
        HT_SkFBSoukinData hT_SkFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinData(pFbsoukindatasikibetukey);

        Assert.assertNull(hT_SkFBSoukinData);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);

    }
}
