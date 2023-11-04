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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払不備詳細テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiHubiDetailEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pHubisikibetukey = "1111111111";

    private static final Integer pRenno3keta = 111;
    private static final C_SyoruiCdKbn pSyoruiCdKbn = C_SyoruiCdKbn.CM_HOJYOBOLIST;
    private static final String pGyoumuKousinsyaId = "1111111111";
    private static final Integer pRenno3keta2 = 222;
    private static final C_SyoruiCdKbn pSyoruiCdKbn2 = C_SyoruiCdKbn.CM_BATCH_FBFURIKOMIKEI_4;
    private static final String pGyoumuKousinsyaId2 = "2222222222";
    private static final Integer pRenno3keta3 = 333;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JT_SiHubi JT_SiHubi1 = new JT_SiHubi(pHubisikibetukey);

        JT_SiHubiDetail JT_SiHubiDetail2 = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail2.setRenno3keta(pRenno3keta2);
        JT_SiHubiDetail2.setHubisyoruicd(pSyoruiCdKbn2);
        JT_SiHubiDetail2.setGyoumuKousinsyaId(pGyoumuKousinsyaId2);

        JT_SiHubiDetail JT_SiHubiDetail3 = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail3.setRenno3keta(pRenno3keta3);

        JT_SiHubiDetail JT_SiHubiDetail = JT_SiHubi1.createSiHubiDetail();
        JT_SiHubiDetail.setRenno3keta(pRenno3keta);
        JT_SiHubiDetail.setHubisyoruicd(pSyoruiCdKbn);
        JT_SiHubiDetail.setGyoumuKousinsyaId(pGyoumuKousinsyaId);

        siharaiDomManager.insert(JT_SiHubi1);

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_SyoruiZokusei AM_SyoruiZokusei1 = new AM_SyoruiZokusei(pSyoruiCdKbn);
        baseDomManager.insert(AM_SyoruiZokusei1);

        String password1 = "11111111";
        String pUserNm1 = "ああああああ";
        AM_User AM_User = new AM_User(pGyoumuKousinsyaId);
        AM_User.setPassword(password1);
        AM_User.setUserNm(pUserNm1);
        baseDomManager.insert(AM_User);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);

        siharaiDomManager.delete(JT_SiHubi1);
    }

    @Test
    @TestOrder(10)
    public void getSiHubi() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();
        JT_SiHubiDetail JT_SiHubiDetail1 = JT_SiHubiDetails.get(0);
        JT_SiHubi JT_SiHubi2 = JT_SiHubiDetail1.getSiHubi();

        Assert.assertEquals(pHubisikibetukey, JT_SiHubi2.getHubisikibetukey());
    }

    @Test
    @TestOrder(20)
    public void getSyoruiZokusei() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();
        JT_SiHubiDetail JT_SiHubiDetail1 = JT_SiHubiDetails.get(0);
        AM_SyoruiZokusei AM_SyoruiZokusei1 = JT_SiHubiDetail1.getSyoruiZokusei();

        Assert.assertEquals(pSyoruiCdKbn, AM_SyoruiZokusei1.getSyoruiCd());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void getSyoruiZokuseiNull01() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_SyoruiZokusei AM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCdKbn);

        if(AM_SyoruiZokusei1 != null) {
            baseDomManager.delete(AM_SyoruiZokusei1);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void getSyoruiZokuseiNull02() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();
        JT_SiHubiDetail JT_SiHubiDetail1 = JT_SiHubiDetails.get(0);
        AM_SyoruiZokusei AM_SyoruiZokusei1 = JT_SiHubiDetail1.getSyoruiZokusei();

        Assert.assertNull(AM_SyoruiZokusei1);

        JT_SiHubiDetail JT_SiHubiDetail2 = JT_SiHubiDetails.get(1);
        AM_SyoruiZokusei AM_SyoruiZokusei2 = JT_SiHubiDetail2.getSyoruiZokusei();

        Assert.assertNull(AM_SyoruiZokusei2);

        JT_SiHubiDetail JT_SiHubiDetail3 = JT_SiHubiDetails.get(2);
        AM_SyoruiZokusei AM_SyoruiZokusei3 = JT_SiHubiDetail3.getSyoruiZokusei();

        Assert.assertNull(AM_SyoruiZokusei3);
    }

    @Test
    @TestOrder(50)
    public void getUser() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();
        JT_SiHubiDetail JT_SiHubiDetail1 = JT_SiHubiDetails.get(0);
        AM_User AM_User1 = JT_SiHubiDetail1.getUser();

        Assert.assertEquals(pGyoumuKousinsyaId, AM_User1.getUserId());
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void getUserNull01() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User AM_User1 = baseDomManager.getUser(pGyoumuKousinsyaId);

        if(AM_User1 != null) {
            baseDomManager.delete(AM_User1);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getUserNull02() {

        JT_SiHubi JT_SiHubi1 = siharaiDomManager.getSiHubi(pHubisikibetukey);
        List<JT_SiHubiDetail> JT_SiHubiDetails = JT_SiHubi1.getSiHubiDetails();
        JT_SiHubiDetail JT_SiHubiDetail1 = JT_SiHubiDetails.get(0);
        AM_User AM_User1 = JT_SiHubiDetail1.getUser();

        Assert.assertNull(AM_User1);

        JT_SiHubiDetail JT_SiHubiDetail2 = JT_SiHubiDetails.get(1);
        AM_User AM_User2 = JT_SiHubiDetail2.getUser();

        Assert.assertNull(AM_User2);

        JT_SiHubiDetail JT_SiHubiDetail3 = JT_SiHubiDetails.get(2);
        AM_User AM_User3 = JT_SiHubiDetail3.getUser();

        Assert.assertNull(AM_User3);
    }

}
