package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 確認登録リスト出力<br />
 * 支払不備テーブルエンティティ取得（不備識別キー、発信日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiHubiByHubisikibetukeyHasinymd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_HUBISIKIBETUKEY_01 = "11111";
    static String P_HUBISIKIBETUKEY_02 = "22222";
    static Integer P_RENNO3KETA_01 = new Integer(123);
    static Integer P_RENNO3KETA_02 = new Integer(124);
    static BizDate P_HASINYMD_01 = BizDate.valueOf("20160301");
    static BizDate P_HASINYMD_02 = BizDate.valueOf("20160302");
    static BizDate P_HASINYMD_03 = BizDate.valueOf("20160303");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubiByHubisikibetukeyHasinymd(P_HUBISIKIBETUKEY_01, P_HASINYMD_01);
        Assert.assertEquals(null, jT_SiHubi);

        JT_SiHubi jT_SiHubi1 = new JT_SiHubi(P_HUBISIKIBETUKEY_01);

        JT_SiHubiDetail jT_SiHubiDetail11 = jT_SiHubi1.createSiHubiDetail();
        jT_SiHubiDetail11.setHasinymd(P_HASINYMD_01);
        jT_SiHubiDetail11.setRenno3keta(P_RENNO3KETA_01);

        JT_SiHubiDetail jT_SiHubiDetail12 = jT_SiHubi1.createSiHubiDetail();
        jT_SiHubiDetail12.setHasinymd(P_HASINYMD_02);
        jT_SiHubiDetail12.setRenno3keta(P_RENNO3KETA_02);

        siharaiDomManager.insert(jT_SiHubi1);

        JT_SiHubi jT_SiHubi2 = new JT_SiHubi(P_HUBISIKIBETUKEY_02);

        JT_SiHubiDetail jT_SiHubiDetail21 = jT_SiHubi2.createSiHubiDetail();
        jT_SiHubiDetail21.setHasinymd(P_HASINYMD_01);
        jT_SiHubiDetail21.setRenno3keta(P_RENNO3KETA_01);

        siharaiDomManager.insert(jT_SiHubi2);
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

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubiByHubisikibetukeyHasinymd(P_HUBISIKIBETUKEY_01, P_HASINYMD_03);
        Assert.assertEquals(null, jT_SiHubi);
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubiByHubisikibetukeyHasinymd(P_HUBISIKIBETUKEY_01, P_HASINYMD_01);
        Assert.assertEquals(P_HUBISIKIBETUKEY_01, jT_SiHubi.getHubisikibetukey());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        JT_SiHubi jT_SiHubi = siharaiDomManager.getSiHubiByHubisikibetukeyHasinymd("", P_HASINYMD_01);
        Assert.assertEquals(null, jT_SiHubi);
    }
}
