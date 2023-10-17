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

import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払処理結果テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiKekkaEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final C_ShiharaikekkadataKbn pShiharaikekkadatakbn = C_ShiharaikekkadataKbn.SYOUMETU;
    private static final String pSyono = "1111111111";
    private static final String pSyouhncd = "1111";
    private static final Integer pSyouhnsdno = 11;
    private static final Integer pKyksyouhnrenno = 11;
    private static final C_SyutkKbn pSyutkkbn = C_SyutkKbn.SYU;

    private static final C_ShiharaikekkadataKbn pShiharaikekkadatakbn2 = C_ShiharaikekkadataKbn.PMEN;
    private static final String pSyono2 = "2222222222";
    private static final String pSyouhncd2 = "2222";
    private static final Integer pSyouhnsdno2 = 22;
    private static final Integer pKyksyouhnrenno2 = 22;
    private static final C_SyutkKbn pSyutkkbn2 = C_SyutkKbn.TK;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiKekka JT_SiKekka2 = new JT_SiKekka(pShiharaikekkadatakbn2, pSyono2, pSyouhncd2, pSyouhnsdno2, pKyksyouhnrenno2, pSyutkkbn2);

        siharaiDomManager.insert(JT_SiKekka2);

        JT_SiKekka JT_SiKekka3 = new JT_SiKekka(pShiharaikekkadatakbn2, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn);

        siharaiDomManager.insert(JT_SiKekka3);

        JT_SiKekka JT_SiKekka1 = new JT_SiKekka(pShiharaikekkadatakbn, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn);

        siharaiDomManager.insert(JT_SiKekka1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiKekka());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiKekka> JT_SiKekkas = siharaiDomManager.getAllSiKekka();

        Assert.assertEquals(3, JT_SiKekkas.size());

        Assert.assertEquals(JT_SiKekkas.get(0), siharaiDomManager.getSiKekka(pShiharaikekkadatakbn, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn));
        Assert.assertEquals(JT_SiKekkas.get(1), siharaiDomManager.getSiKekka(pShiharaikekkadatakbn2, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn));
        Assert.assertEquals(JT_SiKekkas.get(2), siharaiDomManager.getSiKekka(pShiharaikekkadatakbn2, pSyono2, pSyouhncd2, pSyouhnsdno2, pKyksyouhnrenno2, pSyutkkbn2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiKekka JT_SiKekka1 = siharaiDomManager.getSiKekka(pShiharaikekkadatakbn, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn);


        Assert.assertEquals(pShiharaikekkadatakbn, JT_SiKekka1.getShiharaikekkadatakbn());
        Assert.assertEquals(pSyono, JT_SiKekka1.getSyono());
        Assert.assertEquals(pSyouhncd, JT_SiKekka1.getSyouhncd());
        Assert.assertEquals(pSyouhnsdno, JT_SiKekka1.getSyouhnsdno());
        Assert.assertEquals(pKyksyouhnrenno, JT_SiKekka1.getKyksyouhnrenno());
        Assert.assertEquals(pSyutkkbn, JT_SiKekka1.getSyutkkbn());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        C_ShiharaikekkadataKbn pShiharaikekkadatakbn9 = C_ShiharaikekkadataKbn.TSNGNDTYOUKA;
        String pSyono9 = "9999999999";
        String pSyouhncd9 = "9999";
        Integer pSyouhnsdno9 = 0;
        Integer pKyksyouhnrenno9 = 0;
        C_SyutkKbn pSyutkkbn9 = C_SyutkKbn.NONE;

        JT_SiKekka JT_SiKekka1 = siharaiDomManager.getSiKekka(pShiharaikekkadatakbn9, pSyono9, pSyouhncd9, pSyouhnsdno9, pKyksyouhnrenno9, pSyutkkbn9);

        Assert.assertNull(JT_SiKekka1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";
        String pSyouhncdBlank = "";


        JT_SiKekka JT_SiKekka1 = siharaiDomManager.getSiKekka(pShiharaikekkadatakbn, pSyonoBlank, pSyouhncdBlank, pSyouhnsdno, pKyksyouhnrenno, pSyutkkbn);

        Assert.assertNull(JT_SiKekka1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
