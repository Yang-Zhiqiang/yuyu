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
 * 支払不備テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiHubiEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pHubisikibetukey = "1111111111";
    private static final String pHubisikibetukey2 = "2222222222";
    private static final String pHubisikibetukey3 = "3333333333";

    private static final Integer pRenno3keta = 111;
    private static final Integer pRenno3keta2 = 222;
    private static final Integer pRenno3keta3 = 333;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi JT_SiHubi2 = new JT_SiHubi(pHubisikibetukey2);
        siharaiDomManager.insert(JT_SiHubi2);

        JT_SiHubi JT_SiHubi3 = new JT_SiHubi(pHubisikibetukey3);
        siharaiDomManager.insert(JT_SiHubi3);

        JT_SiHubi JT_SiHubi1 = new JT_SiHubi(pHubisikibetukey);

        JT_SiHubiDetail JT_SiHubiDetail2 = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail2.setRenno3keta(pRenno3keta3);

        JT_SiHubiDetail JT_SiHubiDetail3 = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail3.setRenno3keta(pRenno3keta2);

        JT_SiHubiDetail JT_SiHubiDetail = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail.setRenno3keta(pRenno3keta);

        siharaiDomManager.insert(JT_SiHubi1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiHubi());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiHubi> JT_SiHubis = siharaiDomManager.getAllSiHubi();

        Assert.assertEquals(3, JT_SiHubis.size());

        Assert.assertEquals(JT_SiHubis.get(0), siharaiDomManager.getSiHubi(pHubisikibetukey));
        Assert.assertEquals(JT_SiHubis.get(1), siharaiDomManager.getSiHubi(pHubisikibetukey2));
        Assert.assertEquals(JT_SiHubis.get(2), siharaiDomManager.getSiHubi(pHubisikibetukey3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);

        Assert.assertEquals(pHubisikibetukey, JT_SiHubi1.getHubisikibetukey());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pHubisikibetukey9 = "9999999999";
        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey9);

        Assert.assertNull(JT_SiHubi1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pHubisikibetukeyBlank = "";
        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukeyBlank);

        Assert.assertNull(JT_SiHubi1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getSiHubiDetail() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();

        Assert.assertEquals(3, JT_SiHubiDetails.size());

        Assert.assertEquals(pHubisikibetukey, JT_SiHubiDetails.get(0).getHubisikibetukey());
        Assert.assertEquals(pRenno3keta, JT_SiHubiDetails.get(0).getRenno3keta());
        Assert.assertEquals(pHubisikibetukey, JT_SiHubiDetails.get(1).getHubisikibetukey());
        Assert.assertEquals(pRenno3keta2, JT_SiHubiDetails.get(1).getRenno3keta());
        Assert.assertEquals(pHubisikibetukey, JT_SiHubiDetails.get(2).getHubisikibetukey());
        Assert.assertEquals(pRenno3keta3, JT_SiHubiDetails.get(2).getRenno3keta());

        JT_SiHubi JT_SiHubi2 = siharaiDomManager.getSiHubi(pHubisikibetukey2);
        List<JT_SiHubiDetail> JT_SiHubiDetails2 = JT_SiHubi2.getSiHubiDetails();

        Assert.assertEquals(0, JT_SiHubiDetails2.size());

        JT_SiHubi JT_SiHubi3 = siharaiDomManager.getSiHubi(pHubisikibetukey3);
        List<JT_SiHubiDetail> JT_SiHubiDetails3 = JT_SiHubi3.getSiHubiDetails();

        Assert.assertEquals(0, JT_SiHubiDetails3.size());
    }

}
