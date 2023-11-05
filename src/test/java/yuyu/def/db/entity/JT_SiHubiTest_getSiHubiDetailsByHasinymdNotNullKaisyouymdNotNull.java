package yuyu.def.db.entity;

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

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払不備テーブルエンティティから、<br />
 * 支払不備詳細テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SiHubiTest_getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_HUBISIKIBETUKEY_01 = "HBKEY001";
    static String P_HUBISIKIBETUKEY_02 = "HBKEY002";
    static String P_HUBISIKIBETUKEY_03 = "HBKEY003";
    static Integer P_RENNO3KETA_01 = new Integer(111);
    static Integer P_RENNO3KETA_02 = new Integer(222);
    static Integer P_RENNO3KETA_03 = new Integer(333);
    static Integer P_RENNO3KETA_04 = new Integer(444);
    static Integer P_RENNO3KETA_05 = new Integer(555);
    static Integer P_RENNO3KETA_06 = new Integer(666);
    static BizDate P_HASINYMD_01 = BizDate.valueOf(20160328);
    static BizDate P_KAISYOUYMD_01 = BizDate.valueOf(20160329);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi jT_SiHubi1 = new JT_SiHubi(P_HUBISIKIBETUKEY_01);

        Assert.assertEquals(0, jT_SiHubi1.getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull().size());

        JT_SiHubiDetail siHubiDetail1 = jT_SiHubi1.createSiHubiDetail();
        siHubiDetail1.setRenno3keta(P_RENNO3KETA_01);
        siHubiDetail1.setHasinymd(P_HASINYMD_01);
        siHubiDetail1.setKaisyouymd(P_KAISYOUYMD_01);

        siharaiDomManager.insert(jT_SiHubi1);

        JT_SiHubi jT_SiHubi2 = new JT_SiHubi(P_HUBISIKIBETUKEY_02);

        JT_SiHubiDetail siHubiDetail2 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail2.setRenno3keta(P_RENNO3KETA_02);
        siHubiDetail2.setHasinymd(P_HASINYMD_01);
        siHubiDetail2.setKaisyouymd(P_KAISYOUYMD_01);

        JT_SiHubiDetail siHubiDetail3 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail3.setRenno3keta(P_RENNO3KETA_03);
        siHubiDetail3.setHasinymd(P_HASINYMD_01);
        siHubiDetail3.setKaisyouymd(P_KAISYOUYMD_01);

        JT_SiHubiDetail siHubiDetail4 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail4.setRenno3keta(P_RENNO3KETA_04);
        siHubiDetail4.setHasinymd(P_HASINYMD_01);
        siHubiDetail4.setKaisyouymd(P_KAISYOUYMD_01);

        JT_SiHubiDetail siHubiDetail5 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail5.setRenno3keta(P_RENNO3KETA_05);
        siHubiDetail5.setKaisyouymd(P_KAISYOUYMD_01);

        JT_SiHubiDetail siHubiDetail6 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail6.setRenno3keta(P_RENNO3KETA_06);
        siHubiDetail6.setHasinymd(P_HASINYMD_01);

        siharaiDomManager.insert(jT_SiHubi2);

        JT_SiHubi jT_SiHubi3 = new JT_SiHubi(P_HUBISIKIBETUKEY_03);

        siharaiDomManager.insert(jT_SiHubi3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubi(P_HUBISIKIBETUKEY_03);

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull();

        Assert.assertEquals(0, siHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubi(P_HUBISIKIBETUKEY_01);

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull();

        Assert.assertEquals(1, siHubiDetailLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_01, siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_01, siHubiDetailLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(0).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_01, siHubiDetailLst.get(0).getKaisyouymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubi(P_HUBISIKIBETUKEY_02);

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull();

        Assert.assertEquals(3, siHubiDetailLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_02, siHubiDetailLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(0).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_01, siHubiDetailLst.get(0).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_03, siHubiDetailLst.get(1).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(1).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_01, siHubiDetailLst.get(1).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_04, siHubiDetailLst.get(2).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(2).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_01, siHubiDetailLst.get(2).getKaisyouymd());
    }
}
