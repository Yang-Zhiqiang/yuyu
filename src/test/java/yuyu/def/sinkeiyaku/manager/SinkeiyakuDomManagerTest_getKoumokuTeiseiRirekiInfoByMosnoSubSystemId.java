package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getKoumokuTeiseiRirekiInfoByMosnoSubSystemId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKoumokuTeiseiRirekiInfoByMosnoSubSystemId {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("791112220", "base");

        Assert.assertEquals(0, KTRIBMSSBeanLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_KmTsRireki smbcStyKanri1 = syoriCTL1.createKmTsRireki();
        smbcStyKanri1.setSyoriTime("20180901");
        smbcStyKanri1.setRenno3keta(001);
        smbcStyKanri1.setKinouId("login");
        smbcStyKanri1.setTskmnm("xxxx");
        smbcStyKanri1.setTsmaenaiyou("before0");
        smbcStyKanri1.setTsgonaiyou("after0");
        smbcStyKanri1.setKinouModeId("default");
        smbcStyKanri1.setTantid("user001");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112501");

        HT_KmTsRireki smbcStyKanri2 = syoriCTL2.createKmTsRireki();
        smbcStyKanri2.setSyoriTime("20180901");
        smbcStyKanri2.setRenno3keta(111);
        smbcStyKanri2.setKinouId("login");
        smbcStyKanri2.setTskmnm("eeee");
        smbcStyKanri2.setTsmaenaiyou("before5");
        smbcStyKanri2.setTsgonaiyou("after5");
        smbcStyKanri2.setKinouModeId("default");
        smbcStyKanri2.setTantid("user001");

        HT_KmTsRireki smbcStyKanri3 = syoriCTL2.createKmTsRireki();
        smbcStyKanri3.setSyoriTime("20180901");
        smbcStyKanri3.setRenno3keta(112);
        smbcStyKanri3.setKinouId("login");
        smbcStyKanri3.setTskmnm("ffff");
        smbcStyKanri3.setTsmaenaiyou("before6");
        smbcStyKanri3.setTsgonaiyou("after6");
        smbcStyKanri3.setKinouModeId("default");
        smbcStyKanri3.setTantid("user001");

        HT_KmTsRireki smbcStyKanri4 = syoriCTL2.createKmTsRireki();
        smbcStyKanri4.setSyoriTime("20180902");
        smbcStyKanri4.setRenno3keta(222);
        smbcStyKanri4.setKinouId("login");
        smbcStyKanri4.setTskmnm("cccc");
        smbcStyKanri4.setTsmaenaiyou("before3");
        smbcStyKanri4.setTsgonaiyou("after3");
        smbcStyKanri4.setKinouModeId("default");
        smbcStyKanri4.setTantid("user001");

        HT_KmTsRireki smbcStyKanri5 = syoriCTL2.createKmTsRireki();
        smbcStyKanri5.setSyoriTime("20180902");
        smbcStyKanri5.setRenno3keta(223);
        smbcStyKanri5.setKinouId("login");
        smbcStyKanri5.setTskmnm("dddd");
        smbcStyKanri5.setTsmaenaiyou("before4");
        smbcStyKanri5.setTsgonaiyou("after4");
        smbcStyKanri5.setKinouModeId("default");
        smbcStyKanri5.setTantid("user001");

        HT_KmTsRireki smbcStyKanri6 = syoriCTL2.createKmTsRireki();
        smbcStyKanri6.setSyoriTime("20180903");
        smbcStyKanri6.setRenno3keta(333);
        smbcStyKanri6.setKinouId("login");
        smbcStyKanri6.setTskmnm("aaaa");
        smbcStyKanri6.setTsmaenaiyou("before1");
        smbcStyKanri6.setTsgonaiyou("after1");
        smbcStyKanri6.setKinouModeId("default");
        smbcStyKanri6.setTantid("user001");

        HT_KmTsRireki smbcStyKanri7 = syoriCTL2.createKmTsRireki();
        smbcStyKanri7.setSyoriTime("20180903");
        smbcStyKanri7.setRenno3keta(334);
        smbcStyKanri7.setKinouId("login");
        smbcStyKanri7.setTskmnm("bbbb");
        smbcStyKanri7.setTsmaenaiyou("before2");
        smbcStyKanri7.setTsgonaiyou("after2");
        smbcStyKanri7.setKinouModeId("default");
        smbcStyKanri7.setTantid("user001");

        HT_KmTsRireki smbcStyKanri8 = syoriCTL2.createKmTsRireki();
        smbcStyKanri8.setSyoriTime("20180903");
        smbcStyKanri8.setRenno3keta(335);
        smbcStyKanri8.setKinouId("addressmasterhanei");
        smbcStyKanri8.setTskmnm("gggg");
        smbcStyKanri8.setTsmaenaiyou("before7");
        smbcStyKanri8.setTsgonaiyou("after7");
        smbcStyKanri8.setKinouModeId("default");
        smbcStyKanri8.setTantid("user001");

        sinkeiyakuDomManager.insert(syoriCTL2);

        AS_Kinou kinou1 = new AS_Kinou("login");
        kinou1.setSubSystemId("base");
        kinou1.setKinouNm("ログイン");

        AS_KinouMode kinouMode1 = kinou1.createKinouMode();
        kinouMode1.setKinouModeId("default");
        kinouMode1.setKinouModeNm("デフォルトモード");

        AS_KinouMode kinouMode2 = kinou1.createKinouMode();
        kinouMode2.setKinouModeId("aaaaaa");
        kinouMode2.setKinouModeNm("アアアアアア");

        sinkeiyakuDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("menu");
        kinou2.setSubSystemId("base");
        kinou2.setKinouNm("メニュー");

        AS_KinouMode kinouMode3 = kinou2.createKinouMode();
        kinouMode3.setKinouModeId("default");
        kinouMode3.setKinouModeNm("デフォルトモード");

        sinkeiyakuDomManager.insert(kinou2);

        AS_Kinou kinou3 = new AS_Kinou("addressmasterhanei");
        kinou3.setSubSystemId("consumer");
        kinou3.setKinouNm("住所マスタ反映");

        AS_KinouMode kinouMode4 = kinou3.createKinouMode();
        kinouMode4.setKinouModeId("default");
        kinouMode4.setKinouModeNm("デフォルトモード");

        sinkeiyakuDomManager.insert(kinou3);

        AS_Kinou kinou4 = new AS_Kinou("accesslogsyoukai");
        kinou4.setSubSystemId("base");
        kinou4.setKinouNm("アクセスログ照会");

        sinkeiyakuDomManager.insert(kinou4);

        AS_SubSystem subSystem1 = new AS_SubSystem("base");
        sinkeiyakuDomManager.insert(subSystem1);

        AS_SubSystem subSystem2 = new AS_SubSystem("consumer");
        sinkeiyakuDomManager.insert(subSystem2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllKinous());

        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("791112238", "base");

        assertEquals(0, KTRIBMSSBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("791112220", "base");

        assertEquals(1, KTRIBMSSBeanLst.size());

        assertEquals("20180901", KTRIBMSSBeanLst.get(0).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(0).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(0).getKinouModeNm());
        assertEquals("xxxx",KTRIBMSSBeanLst.get(0).getTskmnm());
        assertEquals("before0",KTRIBMSSBeanLst.get(0).getTsmaenaiyou());
        assertEquals("after0",KTRIBMSSBeanLst.get(0).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(0).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(0).getTantid());
    }

    @Test
    @TestOrder(20)
    public void normal2(){

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("791112501", "base");

        assertEquals(6, KTRIBMSSBeanLst.size());
        assertEquals("20180903", KTRIBMSSBeanLst.get(0).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(0).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(0).getKinouModeNm());
        assertEquals("aaaa",KTRIBMSSBeanLst.get(0).getTskmnm());
        assertEquals("before1",KTRIBMSSBeanLst.get(0).getTsmaenaiyou());
        assertEquals("after1",KTRIBMSSBeanLst.get(0).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(0).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(0).getTantid());

        assertEquals("20180903", KTRIBMSSBeanLst.get(1).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(1).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(1).getKinouModeNm());
        assertEquals("bbbb",KTRIBMSSBeanLst.get(1).getTskmnm());
        assertEquals("before2",KTRIBMSSBeanLst.get(1).getTsmaenaiyou());
        assertEquals("after2",KTRIBMSSBeanLst.get(1).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(1).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(1).getTantid());

        assertEquals("20180902", KTRIBMSSBeanLst.get(2).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(2).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(2).getKinouModeNm());
        assertEquals("cccc",KTRIBMSSBeanLst.get(2).getTskmnm());
        assertEquals("before3",KTRIBMSSBeanLst.get(2).getTsmaenaiyou());
        assertEquals("after3",KTRIBMSSBeanLst.get(2).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(2).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(2).getTantid());

        assertEquals("20180902", KTRIBMSSBeanLst.get(3).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(3).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(3).getKinouModeNm());
        assertEquals("dddd",KTRIBMSSBeanLst.get(3).getTskmnm());
        assertEquals("before4",KTRIBMSSBeanLst.get(3).getTsmaenaiyou());
        assertEquals("after4",KTRIBMSSBeanLst.get(3).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(3).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(3).getTantid());

        assertEquals("20180901", KTRIBMSSBeanLst.get(4).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(4).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(4).getKinouModeNm());
        assertEquals("eeee",KTRIBMSSBeanLst.get(4).getTskmnm());
        assertEquals("before5",KTRIBMSSBeanLst.get(4).getTsmaenaiyou());
        assertEquals("after5",KTRIBMSSBeanLst.get(4).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(4).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(4).getTantid());

        assertEquals("20180901", KTRIBMSSBeanLst.get(5).getSyoriTime());
        assertEquals("default", KTRIBMSSBeanLst.get(5).getKinouModeId());
        assertEquals("デフォルトモード", KTRIBMSSBeanLst.get(5).getKinouModeNm());
        assertEquals("ffff",KTRIBMSSBeanLst.get(5).getTskmnm());
        assertEquals("before6",KTRIBMSSBeanLst.get(5).getTsmaenaiyou());
        assertEquals("after6",KTRIBMSSBeanLst.get(5).getTsgonaiyou());
        assertEquals("ログイン",KTRIBMSSBeanLst.get(5).getKinouNm());
        assertEquals("user001",KTRIBMSSBeanLst.get(5).getTantid());

    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("", "base");

        assertEquals(0, KTRIBMSSBeanLst.size());

    }

    @Test
    @TestOrder(40)
    public void blankCondition2() {

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> KTRIBMSSBeanLst = sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId("791112501", "");

        assertEquals(0, KTRIBMSSBeanLst.size());

    }
}

