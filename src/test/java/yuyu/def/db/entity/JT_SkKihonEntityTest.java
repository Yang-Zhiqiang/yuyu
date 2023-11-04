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
 * 請求基本テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SkKihonEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSkno1 = "1111111111";
    private static final String pSyono1 = "SYONO000001";
    private static final String pSkno2 = "2222222222";
    private static final String pSyono2 = "SYONO000002";

    private static final Integer pSeikyuurirekino = 111;
    private static final Integer pSeikyuurirekino2 = 222;
    private static final Integer pSeikyuurirekino3 = 333;

    private static final String pShrsikibetukey1 = "11111111111";
    private static final String pShrsikibetukey2 = "22222222222";
    private static final String pShrsikibetukey3 = "33333333333";

    private static final String pTtdkrrkskbtkey1 = "11111111111";
    private static final String pTtdkrrkskbtkey2 = "22222222222";
    private static final String pTtdkrrkskbtkey3 = "33333333333";

    private static final String pSateisyouninskbtkey1 = "11111111111";
    private static final String pSateisyouninskbtkey2 = "22222222222";
    private static final String pSateisyouninskbtkey3 = "33333333333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SkKihon> JT_SkKihons = siharaiDomManager.getAllSkKihon();
        Assert.assertEquals(0, JT_SkKihons.size());

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(pSkno2, pSyono2);
        siharaiDomManager.insert(jT_SkKihon2);

        JT_SkKihon jT_SkKihon3 = new JT_SkKihon(pSkno2, pSyono1);
        siharaiDomManager.insert(jT_SkKihon3);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        JT_Sk jT_Sk2 = jT_SkKihon1.createSk();
        jT_Sk2.setSeikyuurirekino(pSeikyuurirekino2);

        JT_Sk jT_Sk3 = jT_SkKihon1.createSk();
        jT_Sk3.setSeikyuurirekino(pSeikyuurirekino3);

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);

        jT_SkKihon1.createMouside();

        JT_SiRireki jT_SiRireki2 = jT_SkKihon1.createSiRireki();
        jT_SiRireki2.setShrsikibetukey(pShrsikibetukey2);

        JT_SiRireki jT_SiRireki3 = jT_SkKihon1.createSiRireki();
        jT_SiRireki3.setShrsikibetukey(pShrsikibetukey3);

        JT_SiRireki jT_SiRireki1 = jT_SkKihon1.createSiRireki();
        jT_SiRireki1.setShrsikibetukey(pShrsikibetukey1);

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(pTtdkrrkskbtkey2);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(pTtdkrrkskbtkey3);

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(pTtdkrrkskbtkey1);

        JT_SateiSyouninRireki jT_SateiSyouninRireki2 = jT_SkKihon1.createSateiSyouninRireki();
        jT_SateiSyouninRireki2.setSateisyouninskbtkey(pSateisyouninskbtkey2);

        JT_SateiSyouninRireki jT_SateiSyouninRireki3 = jT_SkKihon1.createSateiSyouninRireki();
        jT_SateiSyouninRireki3.setSateisyouninskbtkey(pSateisyouninskbtkey3);

        JT_SateiSyouninRireki jT_SateiSyouninRireki1 = jT_SkKihon1.createSateiSyouninRireki();
        jT_SateiSyouninRireki1.setSateisyouninskbtkey(pSateisyouninskbtkey1);

        JT_SibouKariuketsuke jT_SibouKariuketsuke1 = jT_SkKihon1.createSibouKariuketsuke();
        jT_SibouKariuketsuke1.setSyono(pSyono1);
        jT_SibouKariuketsuke1.setSkno(pSkno1);

        siharaiDomManager.insert(jT_SkKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SkKihon> jT_SkKihons = siharaiDomManager.getAllSkKihon();

        Assert.assertEquals(3, jT_SkKihons.size());

        Assert.assertEquals(jT_SkKihons.get(0), siharaiDomManager.getSkKihon(pSkno1, pSyono1));
        Assert.assertEquals(jT_SkKihons.get(1), siharaiDomManager.getSkKihon(pSkno2, pSyono1));
        Assert.assertEquals(jT_SkKihons.get(2), siharaiDomManager.getSkKihon(pSkno2, pSyono2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        Assert.assertEquals(pSkno1, jT_SkKihon1.getSkno());
        Assert.assertEquals(pSyono1, jT_SkKihon1.getSyono());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSkno9 = "99999";
        String pSyono9 = "SYONO000999";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno9, pSyono9);

        Assert.assertNull(jT_SkKihon1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSknoBlank = "";
        String pSyonoBlank = "";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSknoBlank, pSyonoBlank);

        Assert.assertNull(jT_SkKihon1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void getSks() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sk1 = jT_SkKihon1.getSks();

        Assert.assertEquals(3, jT_Sk1.size());

        Assert.assertEquals(pSkno1, jT_Sk1.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_Sk1.get(0).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_Sk1.get(0).getSeikyuurirekino());

        Assert.assertEquals(pSkno1, jT_Sk1.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_Sk1.get(1).getSyono());
        Assert.assertEquals(pSeikyuurirekino2, jT_Sk1.get(1).getSeikyuurirekino());

        Assert.assertEquals(pSkno1, jT_Sk1.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_Sk1.get(2).getSyono());
        Assert.assertEquals(pSeikyuurirekino3, jT_Sk1.get(2).getSeikyuurirekino());

        JT_SkKihon jT_SkKihon2 = siharaiDomManager.getSkKihon(pSkno2, pSyono1);
        List<JT_Sk> jT_Sk2 = jT_SkKihon2.getSks();

        Assert.assertEquals(0, jT_Sk2.size());

        JT_SkKihon jT_SkKihon3 = siharaiDomManager.getSkKihon(pSkno2, pSyono2);
        List<JT_Sk> jT_Sk3 = jT_SkKihon3.getSks();

        Assert.assertEquals(0, jT_Sk3.size());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getMousides() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        JT_Mouside jT_Mouside1 = jT_SkKihon1.getMouside();

        Assert.assertEquals(pSkno1, jT_Mouside1.getSkno());
        Assert.assertEquals(pSyono1, jT_Mouside1.getSyono());
    }

    @Test
    @TestOrder(80)
    public void getSiRireki() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_SiRireki> jT_SiRirekis = jT_SkKihon1.getSiRirekis();

        Assert.assertEquals(3, jT_SiRirekis.size());

        Assert.assertEquals(pSkno1, jT_SiRirekis.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_SiRirekis.get(0).getSyono());
        Assert.assertEquals(pShrsikibetukey1, jT_SiRirekis.get(0).getShrsikibetukey());

        Assert.assertEquals(pSkno1, jT_SiRirekis.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_SiRirekis.get(1).getSyono());
        Assert.assertEquals(pShrsikibetukey2, jT_SiRirekis.get(1).getShrsikibetukey());

        Assert.assertEquals(pSkno1, jT_SiRirekis.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_SiRirekis.get(2).getSyono());
        Assert.assertEquals(pShrsikibetukey3, jT_SiRirekis.get(2).getShrsikibetukey());

        JT_SkKihon jT_SkKihon2 = siharaiDomManager.getSkKihon(pSkno2, pSyono1);
        List<JT_SiRireki> jT_SiRirekis2 = jT_SkKihon2.getSiRirekis();

        Assert.assertEquals(0, jT_SiRirekis2.size());

        JT_SkKihon jT_SkKihon3 = siharaiDomManager.getSkKihon(pSkno2, pSyono2);
        List<JT_SiRireki> jT_SiRirekis3 = jT_SkKihon3.getSiRirekis();

        Assert.assertEquals(0, jT_SiRirekis3.size());

    }

    @Test
    @TestOrder(90)
    public void getTtdkRireki() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_TtdkRireki> jT_TtdkRirekis1 = jT_SkKihon1.getTtdkRirekis();

        Assert.assertEquals(3, jT_TtdkRirekis1.size());

        Assert.assertEquals(pSkno1, jT_TtdkRirekis1.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_TtdkRirekis1.get(0).getSyono());
        Assert.assertEquals(pTtdkrrkskbtkey1, jT_TtdkRirekis1.get(0).getTtdkrrkskbtkey());

        Assert.assertEquals(pSkno1, jT_TtdkRirekis1.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_TtdkRirekis1.get(1).getSyono());
        Assert.assertEquals(pTtdkrrkskbtkey2, jT_TtdkRirekis1.get(1).getTtdkrrkskbtkey());

        Assert.assertEquals(pSkno1, jT_TtdkRirekis1.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_TtdkRirekis1.get(2).getSyono());
        Assert.assertEquals(pTtdkrrkskbtkey3, jT_TtdkRirekis1.get(2).getTtdkrrkskbtkey());

        JT_SkKihon jT_SkKihon2 = siharaiDomManager.getSkKihon(pSkno2, pSyono1);
        List<JT_TtdkRireki> jT_TtdkRirekis2 = jT_SkKihon2.getTtdkRirekis();

        Assert.assertEquals(0, jT_TtdkRirekis2.size());

        JT_SkKihon jT_SkKihon3 = siharaiDomManager.getSkKihon(pSkno2, pSyono2);
        List<JT_TtdkRireki> jT_TtdkRirekis3 = jT_SkKihon3.getTtdkRirekis();

        Assert.assertEquals(0, jT_TtdkRirekis3.size());

    }

    @Test
    @TestOrder(100)
    public void getSateiSyouninRireki() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_SateiSyouninRireki> jT_SateiSyouninRirekis = jT_SkKihon1.getSateiSyouninRirekis();

        Assert.assertEquals(3, jT_SateiSyouninRirekis.size());

        Assert.assertEquals(pSkno1, jT_SateiSyouninRirekis.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_SateiSyouninRirekis.get(0).getSyono());
        Assert.assertEquals(pSateisyouninskbtkey1, jT_SateiSyouninRirekis.get(0).getSateisyouninskbtkey());

        Assert.assertEquals(pSkno1, jT_SateiSyouninRirekis.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_SateiSyouninRirekis.get(1).getSyono());
        Assert.assertEquals(pSateisyouninskbtkey2, jT_SateiSyouninRirekis.get(1).getSateisyouninskbtkey());

        Assert.assertEquals(pSkno1, jT_SateiSyouninRirekis.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_SateiSyouninRirekis.get(2).getSyono());
        Assert.assertEquals(pSateisyouninskbtkey3, jT_SateiSyouninRirekis.get(2).getSateisyouninskbtkey());

        JT_SkKihon jT_SkKihon2 = siharaiDomManager.getSkKihon(pSkno2, pSyono1);
        List<JT_SateiSyouninRireki> jT_SateiSyouninRirekis2 = jT_SkKihon2.getSateiSyouninRirekis();

        Assert.assertEquals(0, jT_SateiSyouninRirekis2.size());

        JT_SkKihon jT_SkKihon3 = siharaiDomManager.getSkKihon(pSkno2, pSyono2);
        List<JT_SateiSyouninRireki> jT_SateiSyouninRirekis3 = jT_SkKihon3.getSateiSyouninRirekis();

        Assert.assertEquals(0, jT_SateiSyouninRirekis3.size());

    }

    @Test
    @TestOrder(110)
    public void getSibouKariuketsuke() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        JT_SibouKariuketsuke jT_SibouKariuketsuke1 = jT_SkKihon1.getSibouKariuketsuke();

        Assert.assertEquals(pSkno1, jT_SibouKariuketsuke1.getSkno());
        Assert.assertEquals(pSyono1, jT_SibouKariuketsuke1.getSyono());

    }
}
