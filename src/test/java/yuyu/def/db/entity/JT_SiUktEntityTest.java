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

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払受取人テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiUktEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSyono1 = "SYONO000001";
        String pBankcd1 = "1111";
        String pSitencd1 = "111";
        String pDrtencd1 = "1111111";
        JT_SiKykKihon jT_SiKykKihon1 = new JT_SiKykKihon(pSyono1);
        jT_SiKykKihon1.setBankcd(pBankcd1);
        jT_SiKykKihon1.setSitencd(pSitencd1);
        jT_SiKykKihon1.setDrtencd(pDrtencd1);

        C_Hkuktsyu hkuktsyu1 = C_Hkuktsyu.KYFKUKT;
        Integer uktsyurenno1 = 11;

        JT_SiUkt jT_SiUkt1 = jT_SiKykKihon1.createSiUkt();
        jT_SiUkt1.setHkuktsyu(hkuktsyu1);
        jT_SiUkt1.setUktsyurenno(uktsyurenno1);

        siharaiDomManager.insert(jT_SiKykKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSyono1 = "SYONO000001";
        JT_SiKykKihon jT_SiKykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);

        siharaiDomManager.delete(jT_SiKykKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSiKykKihon() {

        String pSyono1 = "SYONO000001";
        JT_SiKykKihon jT_SiKykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiUkt> jT_SiUkts1 = jT_SiKykKihon1.getSiUkts();
        JT_SiUkt jT_SiUkt1 = jT_SiUkts1.get(0);
        JT_SiKykKihon jT_SiUkt2 = jT_SiUkt1.getSiKykKihon();
        Assert.assertEquals(pSyono1, jT_SiUkt2.getSyono());
    }
}
