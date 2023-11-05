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
 * 支払不備ワークテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JW_HubiWkEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pKouteikanriid = "1111111111";
    private static final String pKouteikanriid2 = "2222222222";
    private static final String pKouteikanriid3 = "3333333333";

    private static final Integer pRenno3keta = 111;
    private static final Integer pRenno3keta2 = 222;
    private static final Integer pRenno3keta3 = 333;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JW_HubiWk JW_HubiWk2 = new JW_HubiWk(pKouteikanriid2);
        siharaiDomManager.insert(JW_HubiWk2);

        JW_HubiWk JW_HubiWk3 = new JW_HubiWk(pKouteikanriid3);
        siharaiDomManager.insert(JW_HubiWk3);

        JW_HubiWk JW_HubiWk1 = new JW_HubiWk(pKouteikanriid);

        JW_HubiDetailWk JW_HubiDetailWk2 = JW_HubiWk1.createHubiDetailWk();
        JW_HubiDetailWk2.setRenno3keta(pRenno3keta2);

        JW_HubiDetailWk JW_HubiDetailWk3 = JW_HubiWk1.createHubiDetailWk();
        JW_HubiDetailWk3.setRenno3keta(pRenno3keta3);

        JW_HubiDetailWk JW_HubiDetailWk1 = JW_HubiWk1.createHubiDetailWk();
        JW_HubiDetailWk1.setRenno3keta(pRenno3keta);

        siharaiDomManager.insert(JW_HubiWk1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllHubiWk());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JW_HubiWk> JW_HubiWk1 = siharaiDomManager.getAllHubiWk();

        Assert.assertEquals(3, JW_HubiWk1.size());

        Assert.assertEquals(JW_HubiWk1.get(0), siharaiDomManager.getHubiWk(pKouteikanriid));
        Assert.assertEquals(JW_HubiWk1.get(1), siharaiDomManager.getHubiWk(pKouteikanriid2));
        Assert.assertEquals(JW_HubiWk1.get(2), siharaiDomManager.getHubiWk(pKouteikanriid3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriid);

        Assert.assertEquals(pKouteikanriid, JW_HubiWk1.getKouteikanriid());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pKouteikanriid9 = "9999999999";
        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriid9);

        Assert.assertNull(JW_HubiWk1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pKouteikanriidBlank = "";
        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriidBlank);

        Assert.assertNull(JW_HubiWk1);
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

        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriid);
        List<JW_HubiDetailWk> JW_HubiDetailWks = JW_HubiWk1.getHubiDetailWks();

        Assert.assertEquals(3, JW_HubiDetailWks.size());

        Assert.assertEquals(pKouteikanriid, JW_HubiDetailWks.get(0).getKouteikanriid());
        Assert.assertEquals(pRenno3keta, JW_HubiDetailWks.get(0).getRenno3keta());
        Assert.assertEquals(pKouteikanriid, JW_HubiDetailWks.get(1).getKouteikanriid());
        Assert.assertEquals(pRenno3keta2, JW_HubiDetailWks.get(1).getRenno3keta());
        Assert.assertEquals(pKouteikanriid, JW_HubiDetailWks.get(2).getKouteikanriid());
        Assert.assertEquals(pRenno3keta3, JW_HubiDetailWks.get(2).getRenno3keta());

        JW_HubiWk JW_HubiWk2 = siharaiDomManager.getHubiWk(pKouteikanriid2);
        List<JW_HubiDetailWk> JW_HubiDetailWks2 = JW_HubiWk2.getHubiDetailWks();

        Assert.assertEquals(0, JW_HubiDetailWks2.size());

        JW_HubiWk JW_HubiWk3 = siharaiDomManager.getHubiWk(pKouteikanriid3);
        List<JW_HubiDetailWk> JW_HubiDetailWks3 = JW_HubiWk3.getHubiDetailWks();

        Assert.assertEquals(0, JW_HubiDetailWks3.size());
    }

}
