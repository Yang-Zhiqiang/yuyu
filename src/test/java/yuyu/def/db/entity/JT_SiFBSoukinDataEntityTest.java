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

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払ＦＢ送金データテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiFBSoukinDataEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pFbsoukindatasikibetukey = "1111111111";
    private static final String pFbsoukindatasikibetukey2 = "2222222222";
    private static final String pFbsoukindatasikibetukey3 = "3333333333";


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiFBSoukinData JT_SiFBSoukinData2 = new JT_SiFBSoukinData(pFbsoukindatasikibetukey2);

        siharaiDomManager.insert(JT_SiFBSoukinData2);

        JT_SiFBSoukinData JT_SiFBSoukinData3 = new JT_SiFBSoukinData(pFbsoukindatasikibetukey3);

        siharaiDomManager.insert(JT_SiFBSoukinData3);

        JT_SiFBSoukinData JT_SiFBSoukinData1 = new JT_SiFBSoukinData(pFbsoukindatasikibetukey);

        siharaiDomManager.insert(JT_SiFBSoukinData1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiFBSoukinData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiFBSoukinData> JT_SiFBSoukinDatas = siharaiDomManager.getAllSiFBSoukinData();

        Assert.assertEquals(3, JT_SiFBSoukinDatas.size());

        Assert.assertEquals(JT_SiFBSoukinDatas.get(0), siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey));
        Assert.assertEquals(JT_SiFBSoukinDatas.get(1), siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey2));
        Assert.assertEquals(JT_SiFBSoukinDatas.get(2), siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiFBSoukinData JT_SiFBSoukinData1 = siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey);


        Assert.assertEquals(pFbsoukindatasikibetukey, JT_SiFBSoukinData1.getFbsoukindatasikibetukey());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pFbsoukindatasikibetukey9 = "9999999999";

        JT_SiFBSoukinData JT_SiFBSoukinData1 = siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey9);

        Assert.assertNull(JT_SiFBSoukinData1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pFbsoukindatasikibetukeyBlank = "";

        JT_SiFBSoukinData JT_SiFBSoukinData1 = siharaiDomManager.getSiFBSoukinData(pFbsoukindatasikibetukeyBlank);

        Assert.assertNull(JT_SiFBSoukinData1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
