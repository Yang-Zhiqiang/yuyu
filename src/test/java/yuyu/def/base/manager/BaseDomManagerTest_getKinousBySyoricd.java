package yuyu.def.base.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 仮受計上明細リスト作成<br />
 * 機能基幹テーブルエンティティリスト取得(処理コード)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getKinousBySyoricd {

    @Inject
    private BaseDomManager baseDomManager;

    static String P_KINOUID_01 = "K00000000001";
    static String P_KINOUID_02 = "K00000000002";
    static String P_KINOUID_03 = "K00000000003";
    static String P_KINOUID_04 = "K00000000004";
    static String P_KINOUID_05 = "K00000000005";
    static String P_KINOUID_BLANK = "";
    static String P_SYORICD_01 = "CD01";
    static String P_SYORICD_02 = "CD02";
    static String P_SYORICD_03 = "CD03";
    static String P_SYORICD_04 = "CD04";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AS_Kinou> aS_Kinous = baseDomManager.getKinousBySyoricd(P_SYORICD_02);

        Assert.assertEquals(0, aS_Kinous.size());

        AS_Kinou aS_Kinou1 = new AS_Kinou(P_KINOUID_01);
        aS_Kinou1.setSyoricd(P_SYORICD_01);

        baseDomManager.insert(aS_Kinou1);

        AS_Kinou aS_Kinou2 = new AS_Kinou(P_KINOUID_02);
        aS_Kinou2.setSyoricd(P_SYORICD_02);

        baseDomManager.insert(aS_Kinou2);

        AS_Kinou aS_Kinou3 = new AS_Kinou(P_KINOUID_03);
        aS_Kinou3.setSyoricd(P_SYORICD_03);

        baseDomManager.insert(aS_Kinou3);

        AS_Kinou aS_Kinou4 = new AS_Kinou(P_KINOUID_04);
        aS_Kinou4.setSyoricd(P_SYORICD_03);

        baseDomManager.insert(aS_Kinou4);

        AS_Kinou aS_Kinou5 = new AS_Kinou(P_KINOUID_05);
        aS_Kinou5.setSyoricd(P_SYORICD_03);

        baseDomManager.insert(aS_Kinou5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllKinous());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<AS_Kinou> aS_Kinous = baseDomManager.getKinousBySyoricd(P_SYORICD_04);

        Assert.assertEquals(0, aS_Kinous.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AS_Kinou> aS_Kinous = baseDomManager.getKinousBySyoricd(P_SYORICD_02);

        Assert.assertEquals(1, aS_Kinous.size());

        Assert.assertEquals(P_KINOUID_02, aS_Kinous.get(0).getKinouId());
        Assert.assertEquals(P_SYORICD_02, aS_Kinous.get(0).getSyoricd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AS_Kinou> aS_Kinous = baseDomManager.getKinousBySyoricd(P_SYORICD_03);

        Assert.assertEquals(3, aS_Kinous.size());

        Assert.assertEquals(P_KINOUID_03, aS_Kinous.get(0).getKinouId());
        Assert.assertEquals(P_SYORICD_03, aS_Kinous.get(0).getSyoricd());

        Assert.assertEquals(P_KINOUID_04, aS_Kinous.get(1).getKinouId());
        Assert.assertEquals(P_SYORICD_03, aS_Kinous.get(1).getSyoricd());

        Assert.assertEquals(P_KINOUID_05, aS_Kinous.get(2).getKinouId());
        Assert.assertEquals(P_SYORICD_03, aS_Kinous.get(2).getSyoricd());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<AS_Kinou> aS_Kinous = baseDomManager.getKinousBySyoricd(P_KINOUID_BLANK);

        Assert.assertEquals(0, aS_Kinous.size());
    }
}
