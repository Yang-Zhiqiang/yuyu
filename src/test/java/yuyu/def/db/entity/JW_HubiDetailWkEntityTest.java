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
 * 支払不備詳細ワークテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JW_HubiDetailWkEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pKouteikanriid = "1111111111";

        JW_HubiWk JW_HubiWk1 = new JW_HubiWk(pKouteikanriid);

        Integer pRenno3keta = 111;

        JW_HubiDetailWk JW_HubiDetailWk1 = JW_HubiWk1.createHubiDetailWk();
        JW_HubiDetailWk1.setRenno3keta(pRenno3keta);

        siharaiDomManager.insert(JW_HubiWk1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pKouteikanriid = "1111111111";

        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriid);

        siharaiDomManager.delete(JW_HubiWk1);
    }

    @Test
    @TestOrder(10)
    public void getHubiWk() {

        String pKouteikanriid = "1111111111";
        JW_HubiWk JW_HubiWk1 = siharaiDomManager.getHubiWk(pKouteikanriid);
        List<JW_HubiDetailWk> JW_HubiDetailWks = JW_HubiWk1.getHubiDetailWks();
        JW_HubiDetailWk JW_HubiDetailWk1 = JW_HubiDetailWks.get(0);
        JW_HubiWk JW_HubiWk2 = JW_HubiDetailWk1.getHubiWk();

        Assert.assertEquals(pKouteikanriid, JW_HubiWk2.getKouteikanriid());
    }

}
