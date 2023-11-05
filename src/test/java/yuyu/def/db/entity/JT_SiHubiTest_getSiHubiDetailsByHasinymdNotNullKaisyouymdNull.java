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
public class JT_SiHubiTest_getSiHubiDetailsByHasinymdNotNullKaisyouymdNull {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_HUBISIKIBETUKEY_01 = "HBKEY001";
    static String P_HUBISIKIBETUKEY_02 = "HBKEY002";
    static String P_HUBISIKIBETUKEY_03 = "HBKEY003";
    static Integer P_RENNO3KETA_01 = new Integer(111);
    static Integer P_RENNO3KETA_02 = new Integer(222);
    static Integer P_RENNO3KETA_03 = new Integer(333);
    static BizDate P_HASINYMD_01 = BizDate.valueOf(20160303);
    static BizDate P_KAISYOUYMD_01 = BizDate.valueOf(20160303);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi jT_SiHubi1 = new JT_SiHubi(P_HUBISIKIBETUKEY_01);

        Assert.assertEquals(0, jT_SiHubi1.getSiHubiDetailsByHasinymdNotNullKaisyouymdNull().size());

        JT_SiHubiDetail siHubiDetail11 = jT_SiHubi1.createSiHubiDetail();
        siHubiDetail11.setRenno3keta(P_RENNO3KETA_01);
        siHubiDetail11.setHasinymd(P_HASINYMD_01);
        siHubiDetail11.setKaisyouymd(P_KAISYOUYMD_01);

        JT_SiHubiDetail siHubiDetail12 = jT_SiHubi1.createSiHubiDetail();
        siHubiDetail12.setRenno3keta(P_RENNO3KETA_02);

        JT_SiHubiDetail siHubiDetail13 = jT_SiHubi1.createSiHubiDetail();
        siHubiDetail13.setRenno3keta(P_RENNO3KETA_03);
        siHubiDetail13.setHasinymd(P_HASINYMD_01);

        siharaiDomManager.insert(jT_SiHubi1);

        JT_SiHubi jT_SiHubi2 = new JT_SiHubi(P_HUBISIKIBETUKEY_02);

        JT_SiHubiDetail siHubiDetail21 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail21.setRenno3keta(P_RENNO3KETA_01);
        siHubiDetail21.setHasinymd(P_HASINYMD_01);

        JT_SiHubiDetail siHubiDetail22 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail22.setRenno3keta(P_RENNO3KETA_02);
        siHubiDetail22.setHasinymd(P_HASINYMD_01);

        JT_SiHubiDetail siHubiDetail23 = jT_SiHubi2.createSiHubiDetail();
        siHubiDetail23.setRenno3keta(P_RENNO3KETA_03);
        siHubiDetail23.setHasinymd(P_HASINYMD_01);

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

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(0, siHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubi(P_HUBISIKIBETUKEY_01);

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(1, siHubiDetailLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_01, siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_03, siHubiDetailLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(0).getHasinymd());
        Assert.assertNull(siHubiDetailLst.get(0).getKaisyouymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubi(P_HUBISIKIBETUKEY_02);

        List<JT_SiHubiDetail> siHubiDetailLst = jT_SiHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(3, siHubiDetailLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_01, siHubiDetailLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(0).getHasinymd());
        Assert.assertNull(siHubiDetailLst.get(0).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_02, siHubiDetailLst.get(1).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(1).getHasinymd());
        Assert.assertNull(siHubiDetailLst.get(1).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_02, siHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_03, siHubiDetailLst.get(2).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_01, siHubiDetailLst.get(2).getHasinymd());
        Assert.assertNull(siHubiDetailLst.get(2).getKaisyouymd());
    }
}
