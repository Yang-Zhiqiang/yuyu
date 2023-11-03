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

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 手続履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_TtdkRirekiEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        String pTtdkrrkskbtkey1 = "11111111111";
        String pSateisyouninskbtkey1 = "1111111111";
        String pGyoumuKousinsyaId1 = "111111111";
        String pTtdkrrkskbtkey2 = "2222222222";
        String pSateisyouninskbtkey2 = "2222222222";
        String pGyoumuKousinsyaId2 = "2222222222";
        String pTtdkrrkskbtkey3 = "3333333333";

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(pTtdkrrkskbtkey2);
        jT_TtdkRireki2.setSateisyouninskbtkey(pSateisyouninskbtkey2);
        jT_TtdkRireki2.setGyoumuKousinsyaId(pGyoumuKousinsyaId2);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(pTtdkrrkskbtkey3);

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(pTtdkrrkskbtkey1);
        jT_TtdkRireki1.setSateisyouninskbtkey(pSateisyouninskbtkey1);
        jT_TtdkRireki1.setGyoumuKousinsyaId(pGyoumuKousinsyaId1);

        siharaiDomManager.insert(jT_SkKihon1);

        String pUserId1 = "111111111";
        String pPassword = "2222222222";
        String pUserNm = "ああああああ";
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        AM_User aM_User1 = new AM_User(pUserId1);
        aM_User1.setPassword(pPassword);
        aM_User1.setUserNm(pUserNm);

        baseDomManager.insert(aM_User1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        siharaiDomManager.delete(jT_SkKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSkKihon() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_TtdkRireki> JT_TtdkRirekis = jT_SkKihon1.getTtdkRirekis();
        JT_TtdkRireki JT_TtdkRireki1 = JT_TtdkRirekis.get(0);
        JT_SkKihon jT_SkKihon2 = JT_TtdkRireki1.getSkKihon();
        Assert.assertEquals(pSyono1, jT_SkKihon2.getSyono());
        Assert.assertEquals(pSkno1, jT_SkKihon2.getSkno());
    }

    @Test
    @TestOrder(20)
    public void getUser() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        String pUserId1 = "111111111";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_TtdkRireki> JT_TtdkRirekis = jT_SkKihon1.getTtdkRirekis();
        JT_TtdkRireki JT_TtdkRireki1 = JT_TtdkRirekis.get(0);
        AM_User aM_User1 = JT_TtdkRireki1.getUser();

        Assert.assertEquals(pUserId1, aM_User1.getUserId());

        JT_TtdkRireki JT_TtdkRireki2 = JT_TtdkRirekis.get(1);
        AM_User aM_User2 = JT_TtdkRireki2.getUser();
        Assert.assertNull(aM_User2);

        JT_TtdkRireki JT_TtdkRireki3 = JT_TtdkRirekis.get(2);
        AM_User aM_User3 = JT_TtdkRireki3.getUser();
        Assert.assertNull(aM_User3);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void getUserNull01() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        String pUserId1 = "111111111";
        AM_User aM_User1 = baseDomManager.getUser(pUserId1);

        if(aM_User1 != null) {
            baseDomManager.delete(aM_User1);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void getUserNull02() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        String pUserId1 = "111111111";
        AM_User aM_User1 = baseDomManager.getUser(pUserId1);

        Assert.assertNull(aM_User1);
    }
}
