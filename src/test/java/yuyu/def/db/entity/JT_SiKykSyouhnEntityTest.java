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
public class JT_SiKykSyouhnEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyono1 = "SYONO000001";

    private static final C_SyutkKbn syutKbn1 = C_SyutkKbn.SYU;
    private static final String syouhncd1 = "1111";
    private static final C_KyhgndkataKbn kyhgndkataKbn1 = C_KyhgndkataKbn.TYPE120;
    private static final Integer syouhnsdno1 = 11;
    private static final Integer kyksyouhnrenno1 = 11;

    private static final C_SyutkKbn syutKbn2 = C_SyutkKbn.TK;
    private static final String syouhncd2 = "2222";
    private static final C_KyhgndkataKbn kyhgndkataKbn2 = C_KyhgndkataKbn.TYPE180;
    private static final Integer syouhnsdno2 = 22;
    private static final Integer kyksyouhnrenno2 = 22;


    private static final String pHtnpbuicd1 = "111";
    private static final String pHtnpbuicd2 = "222";
    private static final String pHtnpbuicd3 = "333";
    private static final String pHtnpbuicd4 = "444";

    private static final String pHtnpbuicd9 = "999";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiKykKihon jT_SiKykKihon1 = new JT_SiKykKihon(pSyono1);

        JT_SiKykSyouhn jT_SiKykSyouhns2 = jT_SiKykKihon1.createSiKykSyouhn();
        jT_SiKykSyouhns2.setSyutkkbn(syutKbn2);
        jT_SiKykSyouhns2.setSyouhncd(syouhncd2);
        jT_SiKykSyouhns2.setKyhgndkatakbn(kyhgndkataKbn2);
        jT_SiKykSyouhns2.setSyouhnsdno(syouhnsdno2);
        jT_SiKykSyouhns2.setKyksyouhnrenno(kyksyouhnrenno2);
        jT_SiKykSyouhns2.setHtnpbuicd1(pHtnpbuicd9);
        jT_SiKykSyouhns2.setHtnpbuicd2(pHtnpbuicd9);
        jT_SiKykSyouhns2.setHtnpbuicd3(pHtnpbuicd9);
        jT_SiKykSyouhns2.setHtnpbuicd4(pHtnpbuicd9);

        JT_SiKykSyouhn jT_SiKykSyouhns3 = jT_SiKykKihon1.createSiKykSyouhn();
        jT_SiKykSyouhns3.setSyutkkbn(syutKbn2);
        jT_SiKykSyouhns3.setSyouhncd(syouhncd1);
        jT_SiKykSyouhns3.setKyhgndkatakbn(kyhgndkataKbn1);
        jT_SiKykSyouhns3.setSyouhnsdno(syouhnsdno1);
        jT_SiKykSyouhns3.setKyksyouhnrenno(kyksyouhnrenno1);

        siharaiDomManager.insert(jT_SiKykKihon1);
        JT_SiKykSyouhn jT_SiKykSyouhns1 = jT_SiKykKihon1.createSiKykSyouhn();
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
        BM_HutanpoBui bM_HutanpoBui2 = new BM_HutanpoBui(pHtnpbuicd2);
        bizDomManager.insert(bM_HutanpoBui2);
        BM_HutanpoBui bM_HutanpoBui3 = new BM_HutanpoBui(pHtnpbuicd3);
        bizDomManager.insert(bM_HutanpoBui3);
        BM_HutanpoBui bM_HutanpoBui4 = new BM_HutanpoBui(pHtnpbuicd4);
        bizDomManager.insert(bM_HutanpoBui4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiKykKihon jT_SiKykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);

        siharaiDomManager.delete(jT_SiKykKihon1);

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHutanpoBui());
    }

    @Test
    @TestOrder(10)
    public void getSiKykKihon() {

        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        JT_SiKykKihon iT_KykKihon2 = jT_SiKykSyouhn1.getSiKykKihon();
        Assert.assertEquals(pSyono1, iT_KykKihon2.getSyono());
    }

    @Test
    @TestOrder(20)
    public void getHutanpoBui() {

        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        BM_HutanpoBui BM_HutanpoBui1 = jT_SiKykSyouhn1.getHutanpoBui1();

        Assert.assertEquals(pHtnpbuicd1, BM_HutanpoBui1.getHtnpbuicd());

        JT_SiKykSyouhn jT_SiKykSyouhn2 = jT_SiKykSyouhns1.get(1);
        BM_HutanpoBui BM_HutanpoBui2 = jT_SiKykSyouhn2.getHutanpoBui1();

        Assert.assertNull(BM_HutanpoBui2);

        JT_SiKykSyouhn jT_SiKykSyouhn3 = jT_SiKykSyouhns1.get(2);
        BM_HutanpoBui BM_HutanpoBui3 = jT_SiKykSyouhn3.getHutanpoBui1();

        Assert.assertNull(BM_HutanpoBui3);

        BM_HutanpoBui BM_HutanpoBui12 = jT_SiKykSyouhn1.getHutanpoBui2();

        Assert.assertEquals(pHtnpbuicd2, BM_HutanpoBui12.getHtnpbuicd());

        BM_HutanpoBui BM_HutanpoBui22 = jT_SiKykSyouhn2.getHutanpoBui2();

        Assert.assertNull(BM_HutanpoBui22);

        BM_HutanpoBui BM_HutanpoBui32 = jT_SiKykSyouhn3.getHutanpoBui2();

        Assert.assertNull(BM_HutanpoBui32);

        BM_HutanpoBui BM_HutanpoBui13 = jT_SiKykSyouhn1.getHutanpoBui3();

        Assert.assertEquals(pHtnpbuicd3, BM_HutanpoBui13.getHtnpbuicd());

        BM_HutanpoBui BM_HutanpoBui2_3 = jT_SiKykSyouhn2.getHutanpoBui3();

        Assert.assertNull(BM_HutanpoBui2_3);

        BM_HutanpoBui BM_HutanpoBui33 = jT_SiKykSyouhn3.getHutanpoBui3();

        Assert.assertNull(BM_HutanpoBui33);

        BM_HutanpoBui BM_HutanpoBui14 = jT_SiKykSyouhn1.getHutanpoBui4();

        Assert.assertEquals(pHtnpbuicd4, BM_HutanpoBui14.getHtnpbuicd());

        BM_HutanpoBui BM_HutanpoBui24 = jT_SiKykSyouhn2.getHutanpoBui4();

        Assert.assertNull(BM_HutanpoBui24);

        BM_HutanpoBui BM_HutanpoBui34 = jT_SiKykSyouhn3.getHutanpoBui4();

        Assert.assertNull(BM_HutanpoBui34);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void getHutanpoBuiNull01() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_HutanpoBui bM_HutanpoBui1 = bizDomManager.getHutanpoBui(pHtnpbuicd1);

        if(bM_HutanpoBui1 != null) {
            bizDomManager.delete(bM_HutanpoBui1);
        }

        BM_HutanpoBui bM_HutanpoBui2 = bizDomManager.getHutanpoBui(pHtnpbuicd2);

        if(bM_HutanpoBui2 != null) {
            bizDomManager.delete(bM_HutanpoBui2);
        }

        BM_HutanpoBui bM_HutanpoBui3 = bizDomManager.getHutanpoBui(pHtnpbuicd3);

        if(bM_HutanpoBui3 != null) {
            bizDomManager.delete(bM_HutanpoBui3);
        }

        BM_HutanpoBui bM_HutanpoBui4 = bizDomManager.getHutanpoBui(pHtnpbuicd4);

        if(bM_HutanpoBui4 != null) {
            bizDomManager.delete(bM_HutanpoBui4);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void getHutanpoBuiNull02() {

        JT_SiKykKihon iT_KykKihon1 = siharaiDomManager.getSiKykKihon(pSyono1);
        List<JT_SiKykSyouhn> jT_SiKykSyouhns1 = iT_KykKihon1.getSiKykSyouhns();
        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykSyouhns1.get(0);
        BM_HutanpoBui BM_HutanpoBui1 = jT_SiKykSyouhn1.getHutanpoBui1();

        Assert.assertNull(BM_HutanpoBui1);

        BM_HutanpoBui BM_HutanpoBui2 = jT_SiKykSyouhn1.getHutanpoBui2();

        Assert.assertNull(BM_HutanpoBui2);

        BM_HutanpoBui BM_HutanpoBui3 = jT_SiKykSyouhn1.getHutanpoBui3();

        Assert.assertNull(BM_HutanpoBui3);

        BM_HutanpoBui BM_HutanpoBui4 = jT_SiKykSyouhn1.getHutanpoBui4();

        Assert.assertNull(BM_HutanpoBui4);
    }
}
