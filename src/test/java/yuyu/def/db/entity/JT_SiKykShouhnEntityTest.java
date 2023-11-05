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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払契約商品テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiKykShouhnEntityTest {

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

        C_SyutkKbn syutKbn1 = C_SyutkKbn.SYU;
        String syouhncd1 = "1111";
        C_KyhgndkataKbn kyhgndkataKbn1 = C_KyhgndkataKbn.TYPE120;
        Integer syouhnsdno1 = 11;
        Integer kyksyouhnrenno1 = 11;
        String pHtnpbuicd1 = "111";
        String pHtnpbuicd2 = "222";
        String pHtnpbuicd3 = "333";
        String pHtnpbuicd4 = "444";

        JT_SiKykSyouhn jT_SiKykSyouhns1 = jT_SiKykKihon1.createSiKykSyouhn();
        jT_SiKykSyouhns1.setSyono(pSyono1);
        jT_SiKykSyouhns1.setSyutkkbn(syutKbn1);
        jT_SiKykSyouhns1.setSyouhncd(syouhncd1);
        jT_SiKykSyouhns1.setKyhgndkatakbn(kyhgndkataKbn1);
        jT_SiKykSyouhns1.setSyouhnsdno(syouhnsdno1);
        jT_SiKykSyouhns1.setKyksyouhnrenno(kyksyouhnrenno1);
        jT_SiKykSyouhns1.setHtnpbuicd1(pHtnpbuicd1);
        jT_SiKykSyouhns1.setHtnpbuicd2(pHtnpbuicd2);
        jT_SiKykSyouhns1.setHtnpbuicd3(pHtnpbuicd3);
        jT_SiKykSyouhns1.setHtnpbuicd4(pHtnpbuicd4);

        siharaiDomManager.insert(jT_SiKykKihon1);

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_HutanpoBui bM_HutanpoBui1 = new BM_HutanpoBui(pHtnpbuicd1);
        bizDomManager.insert(bM_HutanpoBui1);

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
        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        JT_SiKykKihon iT_KykKihon2 = jT_SiKykSyouhn1.getSiKykKihon();
        Assert.assertEquals(pSyono1, iT_KykKihon2.getSyono());
    }

    @Test
    @TestOrder(20)
    public void getHutanpoBui() {

        String pSyono1 = "SYONO000001";
        String pHtnpbuicd1 = "111";

        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        BM_HutanpoBui bM_Ginkou1 = jT_SiKykSyouhn1.getHutanpoBui1();

        Assert.assertEquals(pHtnpbuicd1, bM_Ginkou1.getHtnpbuicd());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void getHutanpoBuiNull01() {

        String pHtnpbuicd1 = "111";

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_HutanpoBui bM_HutanpoBui1 = bizDomManager.getHutanpoBui(pHtnpbuicd1);

        if(bM_HutanpoBui1 != null) {
            bizDomManager.delete(bM_HutanpoBui1);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void getHutanpoBuiNull02() {

        String pSyono1 = "SYONO000001";

        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        BM_HutanpoBui bM_Ginkou1 = jT_SiKykSyouhn1.getHutanpoBui1();

        Assert.assertNull(bM_Ginkou1);
    }
}
