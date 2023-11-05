package yuyu.def.siharai.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getDoujiSeikyuuInfosBySknoSyonoNe() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getDoujiSeikyuuInfosBySknoSyonoNe {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("10000000001", "11807111129");

        Assert.assertEquals(0,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon();
        skKihon1.setSkno("10000000001");
        skKihon1.setSyono("11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon1.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon1.setHubijyoukyoukbn(C_HubiJyoukyouKbn.HUBI);
        skKihon1.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.TYOUSA);

        JT_TtdkRireki ttdkRireki1 = skKihon1.createTtdkRireki();
        ttdkRireki1.setTtdkrrkskbtkey("20161001");
        ttdkRireki1.setSyoriYmd(BizDate.valueOf(20160228));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("10000000002", "11807111118");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon2.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon2.setHubijyoukyoukbn(C_HubiJyoukyouKbn.HUBI);
        skKihon2.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.TYOUSA);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("10000000001", "11807111129");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon3.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon3.setHubijyoukyoukbn(C_HubiJyoukyouKbn.HUBI);
        skKihon3.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.TYOUSA);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("10000000003", "11807111130");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon4.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.BLNK);
        skKihon4.setHubijyoukyoukbn(C_HubiJyoukyouKbn.BLNK);
        skKihon4.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.BLNK);

        JT_TtdkRireki ttdkRireki2 = skKihon4.createTtdkRireki();
        ttdkRireki2.setTtdkrrkskbtkey("20161002");
        ttdkRireki2.setSyoriYmd(BizDate.valueOf(20160227));

        JT_TtdkRireki ttdkRireki3 = skKihon4.createTtdkRireki();
        ttdkRireki3.setTtdkrrkskbtkey("20161005");
        ttdkRireki3.setSyoriYmd(BizDate.valueOf(20160226));

        JT_TtdkRireki ttdkRireki4 = skKihon4.createTtdkRireki();
        ttdkRireki4.setTtdkrrkskbtkey("20161006");
        ttdkRireki4.setSyoriYmd(BizDate.valueOf(20160225));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("10000000003", "11807111141");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        skKihon5.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.KANRYOU);
        skKihon5.setHubijyoukyoukbn(C_HubiJyoukyouKbn.KAISYOU);
        skKihon5.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.KAITOU);

        JT_TtdkRireki ttdkRireki5 = skKihon5.createTtdkRireki();
        ttdkRireki5.setTtdkrrkskbtkey("20161003");
        ttdkRireki5.setSyoriYmd(BizDate.valueOf(20160328));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("10000000003", "11807111152");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.LN);
        skKihon6.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.KANRYOU);
        skKihon6.setHubijyoukyoukbn(C_HubiJyoukyouKbn.HUBI);
        skKihon6.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.HUBI);

        JT_TtdkRireki ttdkRireki6 = skKihon6.createTtdkRireki();
        ttdkRireki6.setTtdkrrkskbtkey("20161004");
        ttdkRireki6.setSyoriYmd(BizDate.valueOf(20160428));

        siharaiDomManager.insert(skKihon6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("10000000002", "11807111118");

        Assert.assertEquals(0,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("10000000001", "11807111129");

        Assert.assertEquals(1,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());
        Assert.assertEquals("10000000001", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSkno());
        Assert.assertEquals("11807111118", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.KYH, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.HUBI, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.TYOUSA, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getTyousajyoukyoukbn());
        Assert.assertEquals(BizDate.valueOf(20160228), doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSaisinSyoriYmd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("10000000003", "11807111129");

        Assert.assertEquals(3,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());
        Assert.assertEquals("10000000003", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSkno());
        Assert.assertEquals("11807111130", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.SB, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.BLNK, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.BLNK, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.BLNK, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getTyousajyoukyoukbn());
        Assert.assertEquals(BizDate.valueOf(20160227), doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSaisinSyoriYmd());

        Assert.assertEquals("10000000003", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSkno());
        Assert.assertEquals("11807111141", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.KOUSG, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.KANRYOU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.KAISYOU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.KAITOU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getTyousajyoukyoukbn());
        Assert.assertEquals(BizDate.valueOf(20160328), doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSaisinSyoriYmd());

        Assert.assertEquals("10000000003", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getSkno());
        Assert.assertEquals("11807111152", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.LN, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.KANRYOU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.HUBI, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.HUBI, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getTyousajyoukyoukbn());
        Assert.assertEquals(BizDate.valueOf(20160428), doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(2).getSaisinSyoriYmd());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("10000000001", "");

        Assert.assertEquals(2,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());
        Assert.assertEquals("10000000001", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSkno());
        Assert.assertEquals("11807111118", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.KYH, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.HUBI, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.TYOUSA, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getTyousajyoukyoukbn());
        Assert.assertEquals(BizDate.valueOf(20160228), doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(0).getSaisinSyoriYmd());

        Assert.assertEquals("10000000001", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSkno());
        Assert.assertEquals("11807111129", doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.KYH, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSeikyuusyubetu());
        Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSyorijyoutaikbn());
        Assert.assertEquals(C_HubiJyoukyouKbn.HUBI, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getHubijyoukyoukbn());
        Assert.assertEquals(C_TyousaJyoukyouKbn.TYOUSA, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getTyousajyoukyoukbn());
        Assert.assertEquals(null, doujiSeikyuuInfosBySknoSyonoNeBeanLst.get(1).getSaisinSyoriYmd());
    }

    @Test
    @TestOrder(10)
    public void noResult2(){

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe("", "11807111129");

        Assert.assertEquals(0,doujiSeikyuuInfosBySknoSyonoNeBeanLst.size());

    }
}

