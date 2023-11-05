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
 * 手術マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_SyujyutuEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyujyututourokuno1 = "111111111";
    private static final String pSyujyututourokuno2 = "222222222";
    private static final String pSyujyututourokuno3 = "333333333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_Syujyutu JM_Syujyutu2 = new JM_Syujyutu(pSyujyututourokuno2);

        siharaiDomManager.insert(JM_Syujyutu2);

        JM_Syujyutu JM_Syujyutu3 = new JM_Syujyutu(pSyujyututourokuno3);

        siharaiDomManager.insert(JM_Syujyutu3);

        JM_Syujyutu JM_Syujyutu1 = new JM_Syujyutu(pSyujyututourokuno1);

        siharaiDomManager.insert(JM_Syujyutu1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_Syujyutu JM_Syujyutu1 = siharaiDomManager.getSyujyutu(pSyujyututourokuno1);

        siharaiDomManager.delete(JM_Syujyutu1);

        JM_Syujyutu JM_Syujyutu2 = siharaiDomManager.getSyujyutu(pSyujyututourokuno2);

        siharaiDomManager.delete(JM_Syujyutu2);

        JM_Syujyutu JM_Syujyutu3 = siharaiDomManager.getSyujyutu(pSyujyututourokuno3);

        siharaiDomManager.delete(JM_Syujyutu3);
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_Syujyutu> JM_Syujyutus = siharaiDomManager.getAllSyujyutu();

        Assert.assertEquals(3, JM_Syujyutus.size());

        Assert.assertEquals(JM_Syujyutus.get(0), siharaiDomManager.getSyujyutu(pSyujyututourokuno1));
        Assert.assertEquals(JM_Syujyutus.get(1), siharaiDomManager.getSyujyutu(pSyujyututourokuno2));
        Assert.assertEquals(JM_Syujyutus.get(2), siharaiDomManager.getSyujyutu(pSyujyututourokuno3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JM_Syujyutu JM_Syujyutu1 = siharaiDomManager.getSyujyutu(pSyujyututourokuno1);

        Assert.assertEquals(pSyujyututourokuno1, JM_Syujyutu1.getSyujyututourokuno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyujyututourokuno9 = "222222";

        JM_Syujyutu JM_Syujyutu1 = siharaiDomManager.getSyujyutu(pSyujyututourokuno9);

        Assert.assertNull(JM_Syujyutu1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyujyututourokunoBlank = "";

        JM_Syujyutu JM_Syujyutu1 = siharaiDomManager.getSyujyutu(pSyujyututourokunoBlank);

        Assert.assertNull(JM_Syujyutu1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
