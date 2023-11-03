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
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払契約基本テーブル エンティティのテストクラス<br />
 * Junitテストのサンプルとしては、
 * 依存リレーション【親○→●子】
 * 参照リレーション【子●→◇親】
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiKykKihonEntityTest implements EntityTestInterface {

    @Inject
    private BizDomManager bizDomManager;
    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String BANKCD_001 = "0001";
    private static final String SITENCD_001 = "001";
    private static final String SITENCD_002 = "002";

    private static final String SYONO_001 = "SYONO000001";
    private static final String SYONO_002 = "SYONO000002";
    private static final String SYONO_003 = "SYONO000003";
    private static final String SYONO_099 = "SYONO000099";
    private static final String SYONO_NOTHING = "";

    private static final C_Hkuktsyu HKUKTSYU_001 = C_Hkuktsyu.KYFKUKT;
    private static final C_Hkuktsyu HKUKTSYU_002 = C_Hkuktsyu.SBHKKUKT;
    private static final Integer UKTSYURENNO_001 = 11;
    private static final Integer UKTSYURENNO_002 = 22;


    private static final C_SyutkKbn SyutkKbn_001 = C_SyutkKbn.NONE;
    private static final C_SyutkKbn SyutkKbn_002 = C_SyutkKbn.SYU;
    private static final String SYOUHNCD_001 = "SH01";
    private static final String SYOUHNCD_002 = "SH02";
    private static final C_KyhgndkataKbn KYHGNDKATAKBN_001 = C_KyhgndkataKbn.BLNK;
    private static final C_KyhgndkataKbn KYHGNDKATAKBN_002 = C_KyhgndkataKbn.TYPE120;
    private static final Integer SYOUHNSDNO_001 = 3;
    private static final Integer SYOUHNSDNO_002 = 4;
    private static final Integer KYKSYOUHNRENNO_001 = 1;
    private static final Integer KYKSYOUHNRENNO_002 = 2;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiKykKihon> jT_SiKykKihons = siharaiDomManager.getAllSiKykKihon();
        Assert.assertEquals(0, jT_SiKykKihons.size());

        bizDomManager.insert(new BM_Ginkou(BANKCD_001, SITENCD_001));
        bizDomManager.insert(new BM_Ginkou(BANKCD_001, SITENCD_002));

        JT_SiKykKihon jT_SiKykKihon_002 = new JT_SiKykKihon(SYONO_002);
        jT_SiKykKihon_002.setBankcd(BANKCD_001);
        jT_SiKykKihon_002.setSitencd(SITENCD_002);

        siharaiDomManager.insert(jT_SiKykKihon_002);

        JT_SiKykKihon jT_SiKykKihon_003 = new JT_SiKykKihon(SYONO_003);

        siharaiDomManager.insert(jT_SiKykKihon_003);

        JT_SiKykKihon jT_SiKykKihon_001 = new JT_SiKykKihon(SYONO_001);
        jT_SiKykKihon_001.setBankcd(BANKCD_001);
        jT_SiKykKihon_001.setSitencd(SITENCD_001);
        JT_SiUkt jT_SiUkt_112 = jT_SiKykKihon_001.createSiUkt();
        jT_SiUkt_112.setHkuktsyu(HKUKTSYU_001);
        jT_SiUkt_112.setUktsyurenno(UKTSYURENNO_002);
        JT_SiUkt jT_SiUkt_121 = jT_SiKykKihon_001.createSiUkt();
        jT_SiUkt_121.setHkuktsyu(HKUKTSYU_002);
        jT_SiUkt_121.setUktsyurenno(UKTSYURENNO_001);
        JT_SiUkt jT_SiUkt_111 = jT_SiKykKihon_001.createSiUkt();
        jT_SiUkt_111.setHkuktsyu(HKUKTSYU_001);
        jT_SiUkt_111.setUktsyurenno(UKTSYURENNO_001);


        JT_SiKykSyouhn jT_SiKykSyouhn_1 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_1.setSyutkkbn(SyutkKbn_002);
        jT_SiKykSyouhn_1.setSyouhncd(SYOUHNCD_002);
        jT_SiKykSyouhn_1.setKyhgndkatakbn(KYHGNDKATAKBN_002);
        jT_SiKykSyouhn_1.setSyouhnsdno(SYOUHNSDNO_002);
        jT_SiKykSyouhn_1.setKyksyouhnrenno(KYKSYOUHNRENNO_002);
        JT_SiKykSyouhn jT_SiKykSyouhn_2 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_2.setSyutkkbn(SyutkKbn_002);
        jT_SiKykSyouhn_2.setSyouhncd(SYOUHNCD_002);
        jT_SiKykSyouhn_2.setKyhgndkatakbn(KYHGNDKATAKBN_002);
        jT_SiKykSyouhn_2.setSyouhnsdno(SYOUHNSDNO_002);
        jT_SiKykSyouhn_2.setKyksyouhnrenno(KYKSYOUHNRENNO_001);
        JT_SiKykSyouhn jT_SiKykSyouhn_3 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_3.setSyutkkbn(SyutkKbn_002);
        jT_SiKykSyouhn_3.setSyouhncd(SYOUHNCD_002);
        jT_SiKykSyouhn_3.setKyhgndkatakbn(KYHGNDKATAKBN_002);
        jT_SiKykSyouhn_3.setSyouhnsdno(SYOUHNSDNO_001);
        jT_SiKykSyouhn_3.setKyksyouhnrenno(KYKSYOUHNRENNO_002);
        JT_SiKykSyouhn jT_SiKykSyouhn_4 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_4.setSyutkkbn(SyutkKbn_002);
        jT_SiKykSyouhn_4.setSyouhncd(SYOUHNCD_002);
        jT_SiKykSyouhn_4.setKyhgndkatakbn(KYHGNDKATAKBN_001);
        jT_SiKykSyouhn_4.setSyouhnsdno(SYOUHNSDNO_002);
        jT_SiKykSyouhn_4.setKyksyouhnrenno(KYKSYOUHNRENNO_002);
        JT_SiKykSyouhn jT_SiKykSyouhn_5 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_5.setSyutkkbn(SyutkKbn_002);
        jT_SiKykSyouhn_5.setSyouhncd(SYOUHNCD_001);
        jT_SiKykSyouhn_5.setKyhgndkatakbn(KYHGNDKATAKBN_002);
        jT_SiKykSyouhn_5.setSyouhnsdno(SYOUHNSDNO_002);
        jT_SiKykSyouhn_5.setKyksyouhnrenno(KYKSYOUHNRENNO_002);
        JT_SiKykSyouhn jT_SiKykSyouhn_6 = jT_SiKykKihon_001.createSiKykSyouhn();
        jT_SiKykSyouhn_6.setSyutkkbn(SyutkKbn_001);
        jT_SiKykSyouhn_6.setSyouhncd(SYOUHNCD_002);
        jT_SiKykSyouhn_6.setKyhgndkatakbn(KYHGNDKATAKBN_002);
        jT_SiKykSyouhn_6.setSyouhnsdno(SYOUHNSDNO_002);
        jT_SiKykSyouhn_6.setKyksyouhnrenno(KYKSYOUHNRENNO_002);

        siharaiDomManager.insert(jT_SiKykKihon_001);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGinkou());

        siharaiDomManager.delete(siharaiDomManager.getAllSiKykKihon());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiKykKihon> jT_SiKykKihons = siharaiDomManager.getAllSiKykKihon();

        Assert.assertEquals(3, jT_SiKykKihons.size());

        Assert.assertEquals(jT_SiKykKihons.get(0), siharaiDomManager.getSiKykKihon(SYONO_001));
        Assert.assertEquals(jT_SiKykKihons.get(1), siharaiDomManager.getSiKykKihon(SYONO_002));
        Assert.assertEquals(jT_SiKykKihons.get(2), siharaiDomManager.getSiKykKihon(SYONO_003));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        Assert.assertEquals(SYONO_001, siharaiDomManager.getSiKykKihon(SYONO_001).getSyono());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        Assert.assertNull(siharaiDomManager.getSiKykKihon(SYONO_099));
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        Assert.assertNull(siharaiDomManager.getSiKykKihon(SYONO_NOTHING));
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getSiUkts() {

        JT_SiKykKihon jT_SiKykKihon_001 = siharaiDomManager.getSiKykKihon(SYONO_001);
        JT_SiKykKihon jT_SiKykKihon_002 = siharaiDomManager.getSiKykKihon(SYONO_002);
        JT_SiKykKihon jT_SiKykKihon_003 = siharaiDomManager.getSiKykKihon(SYONO_003);

        List<JT_SiUkt> jT_SiUkts = jT_SiKykKihon_001.getSiUkts();
        Assert.assertEquals(3, jT_SiUkts.size());

        Assert.assertEquals(SYONO_001, jT_SiUkts.get(0).getSyono());
        Assert.assertEquals(HKUKTSYU_001, jT_SiUkts.get(0).getHkuktsyu());
        Assert.assertEquals(UKTSYURENNO_001, jT_SiUkts.get(0).getUktsyurenno());
        Assert.assertEquals(SYONO_001, jT_SiUkts.get(1).getSyono());
        Assert.assertEquals(HKUKTSYU_001, jT_SiUkts.get(1).getHkuktsyu());
        Assert.assertEquals(UKTSYURENNO_002, jT_SiUkts.get(1).getUktsyurenno());
        Assert.assertEquals(SYONO_001, jT_SiUkts.get(2).getSyono());
        Assert.assertEquals(HKUKTSYU_002, jT_SiUkts.get(2).getHkuktsyu());
        Assert.assertEquals(UKTSYURENNO_001, jT_SiUkts.get(2).getUktsyurenno());

        Assert.assertEquals(0, jT_SiKykKihon_002.getSiKykSyouhns().size());
        Assert.assertEquals(0, jT_SiKykKihon_003.getSiKykSyouhns().size());
    }


    @Test
    @TestOrder(60)
    public void getSiKykSyouhn() {

        JT_SiKykKihon jT_SiKykKihon_001 = siharaiDomManager.getSiKykKihon(SYONO_001);
        JT_SiKykKihon jT_SiKykKihon_002 = siharaiDomManager.getSiKykKihon(SYONO_002);
        JT_SiKykKihon jT_SiKykKihon_003 = siharaiDomManager.getSiKykKihon(SYONO_003);

        List<JT_SiKykSyouhn> jT_SiKykSyouhns = jT_SiKykKihon_001.getSiKykSyouhns();
        Assert.assertEquals(6, jT_SiKykSyouhns.size());

        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(0).getSyono());
        Assert.assertEquals(SyutkKbn_001, jT_SiKykSyouhns.get(0).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_002, jT_SiKykSyouhns.get(0).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_002, jT_SiKykSyouhns.get(0).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_002, jT_SiKykSyouhns.get(0).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_002, jT_SiKykSyouhns.get(0).getKyksyouhnrenno());
        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(1).getSyono());
        Assert.assertEquals(SyutkKbn_002, jT_SiKykSyouhns.get(1).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_001, jT_SiKykSyouhns.get(1).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_002, jT_SiKykSyouhns.get(1).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_002, jT_SiKykSyouhns.get(1).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_002, jT_SiKykSyouhns.get(1).getKyksyouhnrenno());
        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(2).getSyono());
        Assert.assertEquals(SyutkKbn_002, jT_SiKykSyouhns.get(2).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_002, jT_SiKykSyouhns.get(2).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_001, jT_SiKykSyouhns.get(2).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_002, jT_SiKykSyouhns.get(2).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_002, jT_SiKykSyouhns.get(2).getKyksyouhnrenno());
        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(3).getSyono());
        Assert.assertEquals(SyutkKbn_002, jT_SiKykSyouhns.get(3).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_002, jT_SiKykSyouhns.get(3).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_002, jT_SiKykSyouhns.get(3).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_001, jT_SiKykSyouhns.get(3).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_002, jT_SiKykSyouhns.get(3).getKyksyouhnrenno());
        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(4).getSyono());
        Assert.assertEquals(SyutkKbn_002, jT_SiKykSyouhns.get(4).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_002, jT_SiKykSyouhns.get(4).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_002, jT_SiKykSyouhns.get(4).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_002, jT_SiKykSyouhns.get(4).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_001, jT_SiKykSyouhns.get(4).getKyksyouhnrenno());
        Assert.assertEquals(SYONO_001, jT_SiKykSyouhns.get(5).getSyono());
        Assert.assertEquals(SyutkKbn_002, jT_SiKykSyouhns.get(5).getSyutkkbn());
        Assert.assertEquals(SYOUHNCD_002, jT_SiKykSyouhns.get(5).getSyouhncd());
        Assert.assertEquals(KYHGNDKATAKBN_002, jT_SiKykSyouhns.get(5).getKyhgndkatakbn());
        Assert.assertEquals(SYOUHNSDNO_002, jT_SiKykSyouhns.get(5).getSyouhnsdno());
        Assert.assertEquals(KYKSYOUHNRENNO_002, jT_SiKykSyouhns.get(5).getKyksyouhnrenno());

        Assert.assertEquals(0, jT_SiKykKihon_002.getSiKykSyouhns().size());
        Assert.assertEquals(0, jT_SiKykKihon_003.getSiKykSyouhns().size());
    }

    @Test
    @TestOrder(70)
    public void getGinkou() {

        Assert.assertEquals(bizDomManager.getGinkou(BANKCD_001, SITENCD_001), siharaiDomManager.getSiKykKihon(SYONO_001).getGinkou());
        Assert.assertEquals(bizDomManager.getGinkou(BANKCD_001, SITENCD_002), siharaiDomManager.getSiKykKihon(SYONO_002).getGinkou());

        Assert.assertNull(siharaiDomManager.getSiKykKihon(SYONO_003).getGinkou());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getGinkouNull01() {

        bizDomManager.delete(bizDomManager.getGinkou(BANKCD_001, SITENCD_002));
    }

    @Test
    @TestOrder(90)
    public void getGinkouNull02() {

        Assert.assertEquals(bizDomManager.getGinkou(BANKCD_001, SITENCD_001), siharaiDomManager.getSiKykKihon(SYONO_001).getGinkou());

        Assert.assertNull(siharaiDomManager.getSiKykKihon(SYONO_002).getGinkou());

        Assert.assertNull(siharaiDomManager.getSiKykKihon(SYONO_002).getGinkou());
    }
}
