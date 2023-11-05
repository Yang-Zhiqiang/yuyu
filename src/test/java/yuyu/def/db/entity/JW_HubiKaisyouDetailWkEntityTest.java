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
 * 支払不備解消詳細ワークテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JW_HubiKaisyouDetailWkEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pKouteikanriid = "1111";
    private static final Integer pRenno3keta = 111;

    private static final String pKouteikanriid2 = "2222";
    private static final Integer pRenno3keta2 = 222;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk2 = new JW_HubiKaisyouDetailWk(pKouteikanriid2, pRenno3keta2);

        siharaiDomManager.insert(JW_HubiKaisyouDetailWk2);

        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk3 = new JW_HubiKaisyouDetailWk(pKouteikanriid2, pRenno3keta);

        siharaiDomManager.insert(JW_HubiKaisyouDetailWk3);


        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk1 = new JW_HubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);

        siharaiDomManager.insert(JW_HubiKaisyouDetailWk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllHubiKaisyouDetailWk());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JW_HubiKaisyouDetailWk> JW_HubiKaisyouDetailWks = siharaiDomManager.getAllHubiKaisyouDetailWk();

        Assert.assertEquals(3, JW_HubiKaisyouDetailWks.size());

        Assert.assertEquals(JW_HubiKaisyouDetailWks.get(0), siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta));
        Assert.assertEquals(JW_HubiKaisyouDetailWks.get(1), siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriid2, pRenno3keta));
        Assert.assertEquals(JW_HubiKaisyouDetailWks.get(2), siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriid2, pRenno3keta2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk1 = siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);

        Assert.assertEquals(pKouteikanriid, JW_HubiKaisyouDetailWk1.getKouteikanriid());
        Assert.assertEquals(pRenno3keta, JW_HubiKaisyouDetailWk1.getRenno3keta());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pKouteikanriid9 = "9999";
        Integer pRenno3keta9 = 999;

        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk1 = siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriid9, pRenno3keta9);

        Assert.assertNull(JW_HubiKaisyouDetailWk1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pKouteikanriidBlank = "";

        JW_HubiKaisyouDetailWk JW_HubiKaisyouDetailWk1 = siharaiDomManager.getHubiKaisyouDetailWk(pKouteikanriidBlank, pRenno3keta);

        Assert.assertNull(JW_HubiKaisyouDetailWk1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
