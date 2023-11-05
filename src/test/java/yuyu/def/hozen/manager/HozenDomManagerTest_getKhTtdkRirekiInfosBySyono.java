package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfosBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhTtdkRirekiInfosBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekiInfosBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);


        List<KhTtdkRirekiInfosBySyonoBean> KhTtdkRirekiInfoBySyonoBeanLst = hozenDomManager.getKhTtdkRirekiInfosBySyono("11807111118");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoBeanLst.size());

        IT_KykKihon kykKihon2 = new IT_KykKihon("11807111119");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf("20170216"));
        khTtdkRireki2.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki2.setSyorisosikicd("C1");
        khTtdkRireki2.setHenkourrkumu(C_UmuKbn.ARI);
        khTtdkRireki2.setShrsyousaiumu(C_UmuKbn.ARI);
        khTtdkRireki2.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki2.setGyoumuKousinKinou("10000000002");
        khTtdkRireki2.setGyoumuKousinsyaId("UI00000002");
        khTtdkRireki2.setGyoumuKousinTime("20160105");

        IT_KhHenkouRireki henkourireki21 = khTtdkRireki2.createKhHenkouRireki();
        henkourireki21.setRenno3keta(11);
        IT_KhHenkouRireki henkourireki22 = khTtdkRireki2.createKhHenkouRireki();
        henkourireki22.setRenno3keta(22);
        IT_KhHenkouRireki henkourireki23 = khTtdkRireki2.createKhHenkouRireki();
        henkourireki23.setRenno3keta(33);

        IT_KhShrRireki siharairireki21 = khTtdkRireki2.createKhShrRireki();

        AM_User user2 = new AM_User("UI00000002");
        user2.setUserNm("ゆう２");
        user2.setPassword("password2");
        baseDomManager.insert(user2);
        AS_Kinou kinou2 = new AS_Kinou("10000000002");
        kinou2.setKinouNm("機能２");
        baseDomManager.insert(kinou2);

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161003");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf("20170216"));
        khTtdkRireki3.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki3.setSyorisosikicd("C1");
        khTtdkRireki3.setHenkourrkumu(C_UmuKbn.ARI);
        khTtdkRireki3.setShrsyousaiumu(C_UmuKbn.ARI);
        khTtdkRireki3.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki3.setGyoumuKousinKinou("10000000003");
        khTtdkRireki3.setGyoumuKousinsyaId("UI00000003");
        khTtdkRireki3.setGyoumuKousinTime("20160104");

        IT_KhHenkouRireki henkourireki31 = khTtdkRireki3.createKhHenkouRireki();
        henkourireki31.setRenno3keta(11);

        IT_KhShrRireki siharairireki31 = khTtdkRireki3.createKhShrRireki();


        IT_KhTtdkRireki khTtdkRireki4 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161004");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf("20170216"));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki4.setSyorisosikicd("C1");
        khTtdkRireki4.setHenkourrkumu(C_UmuKbn.ARI);
        khTtdkRireki4.setShrsyousaiumu(C_UmuKbn.ARI);
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki4.setGyoumuKousinKinou("10000000004");
        khTtdkRireki4.setGyoumuKousinsyaId("UI00000004");
        khTtdkRireki4.setGyoumuKousinTime("20160103");

        IT_KhShrRireki siharairireki41 = khTtdkRireki4.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20161005");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf("20170216"));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki5.setSyorisosikicd("C1");
        khTtdkRireki5.setHenkourrkumu(C_UmuKbn.ARI);
        khTtdkRireki5.setShrsyousaiumu(C_UmuKbn.ARI);
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki5.setGyoumuKousinKinou("10000000005");
        khTtdkRireki5.setGyoumuKousinsyaId("UI00000005");
        khTtdkRireki5.setGyoumuKousinTime("20160102");

        hozenDomManager.insert(kykKihon2);


        IT_KykKihon kykKihon1 = new IT_KykKihon("11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf("20170216"));
        khTtdkRireki1.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki1.setSyorisosikicd("C1");
        khTtdkRireki1.setHenkourrkumu(C_UmuKbn.ARI);
        khTtdkRireki1.setShrsyousaiumu(C_UmuKbn.ARI);
        khTtdkRireki1.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki1.setGyoumuKousinKinou("10000000001");
        khTtdkRireki1.setGyoumuKousinsyaId("UI00000001");
        khTtdkRireki1.setGyoumuKousinTime("20160101");

        IT_KhHenkouRireki henkourireki11 = khTtdkRireki1.createKhHenkouRireki();
        henkourireki11.setRenno3keta(11);
        IT_KhHenkouRireki henkourireki12 = khTtdkRireki1.createKhHenkouRireki();
        henkourireki12.setRenno3keta(22);
        IT_KhHenkouRireki henkourireki13 = khTtdkRireki1.createKhHenkouRireki();
        henkourireki13.setRenno3keta(33);

        IT_KhShrRireki siharairireki1 = khTtdkRireki1.createKhShrRireki();

        hozenDomManager.insert(kykKihon1);
        AM_User user1 = new AM_User("UI00000001");
        user1.setUserNm("ゆう１");
        user1.setPassword("password1");
        baseDomManager.insert(user1);
        AS_Kinou kinou1 = new AS_Kinou("10000000001");
        kinou1.setKinouNm("機能１");
        baseDomManager.insert(kinou1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllUsers());
        baseDomManager.delete(baseDomManager.getAllKinous());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<KhTtdkRirekiInfosBySyonoBean> KhTtdkRirekiInfoBySyonoBeanLst = hozenDomManager.getKhTtdkRirekiInfosBySyono("11807111141");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<KhTtdkRirekiInfosBySyonoBean> KhTtdkRirekiInfoBySyonoBeanLst = hozenDomManager.getKhTtdkRirekiInfosBySyono("11807111118");

        Assert.assertEquals(1,KhTtdkRirekiInfoBySyonoBeanLst.size());
        KhTtdkRirekiInfosBySyonoBean bean = KhTtdkRirekiInfoBySyonoBeanLst.get(0);

        Assert.assertEquals("20161001", bean.getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf("20170216"), bean.getSyoriYmd());
        Assert.assertEquals(C_SyoriKbn.CLGOFF, bean.getSyorikbn());
        Assert.assertEquals("C1", bean.getSyorisosikicd());
        Assert.assertEquals(C_UmuKbn.ARI, bean.getHenkourrkumu());
        Assert.assertEquals(C_UmuKbn.ARI, bean.getShrsyousaiumu());
        Assert.assertEquals("ゆう１", bean.getUserNm());
        Assert.assertEquals("機能１", bean.getKinouNm());
        Assert.assertEquals(Long.valueOf(3), bean.getKhHenkouRirekisCount());
        Assert.assertEquals(Long.valueOf(1), bean.getKhShrRirekiCount());

    }
    @Test
    @TestOrder(30)
    public void normal2(){


        List<KhTtdkRirekiInfosBySyonoBean> KhTtdkRirekiInfoBySyonoBeanLst = hozenDomManager.getKhTtdkRirekiInfosBySyono("11807111119");

        Assert.assertEquals(4,KhTtdkRirekiInfoBySyonoBeanLst.size());

        Assert.assertEquals("20161001", KhTtdkRirekiInfoBySyonoBeanLst.get(0).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf("20170216"), KhTtdkRirekiInfoBySyonoBeanLst.get(0).getSyoriYmd());
        Assert.assertEquals(C_SyoriKbn.CLGOFF,  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getSyorikbn());
        Assert.assertEquals("C1",  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getSyorisosikicd());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getHenkourrkumu());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getShrsyousaiumu());
        Assert.assertEquals("ゆう２",  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getUserNm());
        Assert.assertEquals("機能２",  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getKinouNm());
        Assert.assertEquals(Long.valueOf(3),  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getKhHenkouRirekisCount());
        Assert.assertEquals(Long.valueOf(1),  KhTtdkRirekiInfoBySyonoBeanLst.get(0).getKhShrRirekiCount());


        Assert.assertEquals("20161003", KhTtdkRirekiInfoBySyonoBeanLst.get(1).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf("20170216"), KhTtdkRirekiInfoBySyonoBeanLst.get(1).getSyoriYmd());
        Assert.assertEquals(C_SyoriKbn.CLGOFF,  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getSyorikbn());
        Assert.assertEquals("C1",  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getSyorisosikicd());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getHenkourrkumu());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getShrsyousaiumu());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getUserNm());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getKinouNm());
        Assert.assertEquals(Long.valueOf(1),  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getKhHenkouRirekisCount());
        Assert.assertEquals(Long.valueOf(1),  KhTtdkRirekiInfoBySyonoBeanLst.get(1).getKhShrRirekiCount());


        Assert.assertEquals("20161004", KhTtdkRirekiInfoBySyonoBeanLst.get(2).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf("20170216"), KhTtdkRirekiInfoBySyonoBeanLst.get(2).getSyoriYmd());
        Assert.assertEquals(C_SyoriKbn.CLGOFF,  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getSyorikbn());
        Assert.assertEquals("C1",  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getSyorisosikicd());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getHenkourrkumu());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getShrsyousaiumu());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getUserNm());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getKinouNm());
        Assert.assertEquals(Long.valueOf(0),  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getKhHenkouRirekisCount());
        Assert.assertEquals(Long.valueOf(1),  KhTtdkRirekiInfoBySyonoBeanLst.get(2).getKhShrRirekiCount());


        Assert.assertEquals("20161005", KhTtdkRirekiInfoBySyonoBeanLst.get(3).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf("20170216"), KhTtdkRirekiInfoBySyonoBeanLst.get(3).getSyoriYmd());
        Assert.assertEquals(C_SyoriKbn.CLGOFF,  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getSyorikbn());
        Assert.assertEquals("C1",  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getSyorisosikicd());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getHenkourrkumu());
        Assert.assertEquals(C_UmuKbn.ARI,  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getShrsyousaiumu());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getUserNm());
        Assert.assertEquals(null,  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getKinouNm());
        Assert.assertEquals(Long.valueOf(0),  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getKhHenkouRirekisCount());
        Assert.assertEquals(Long.valueOf(0),  KhTtdkRirekiInfoBySyonoBeanLst.get(3).getKhShrRirekiCount());



    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KhTtdkRirekiInfosBySyonoBean> KhTtdkRirekiInfoBySyonoBeanLst = hozenDomManager.getKhTtdkRirekiInfosBySyono("");

        Assert.assertEquals(0,KhTtdkRirekiInfoBySyonoBeanLst.size());

    }

}


