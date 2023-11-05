package yuyu.def.hozen.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 契約保全不備内容マスタエンティティデタッチ(契約保全不備内容マスタエンティティリスト)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IM_KhHubiNaiyouDetacherTest_detachKhHubiNaiyoutouchedList {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_JIMUTETUZUKICD_01 = "11807111118";
    static String P_JIMUTETUZUKICD_02 = "11807111129";
    static String P_JIMUTETUZUKICD_03 = "11807111130";

    static C_SyoruiCdKbn P_SYORUICD_01 = C_SyoruiCdKbn.WF_HYOUSI;
    static C_SyoruiCdKbn P_SYORUICD_02 = C_SyoruiCdKbn.WF_QRSEAL;
    static C_SyoruiCdKbn P_SYORUICD_03 = C_SyoruiCdKbn.USERITIRANHYOU;

    static String P_HUBINAIYOUCD_01 = "10001";
    static String P_HUBINAIYOUCD_02 = "10002";
    static String P_HUBINAIYOUCD_03 = "10003";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IM_KhHubiNaiyou iM_KhHubiNaiyou1 = new IM_KhHubiNaiyou(P_JIMUTETUZUKICD_01,P_SYORUICD_01,P_HUBINAIYOUCD_01);
        iM_KhHubiNaiyou1.setHassinsakikbn(C_HassinsakiKbn.BLNK);
        iM_KhHubiNaiyou1.setGenponhnkykumu(C_UmuKbn.NONE);
        iM_KhHubiNaiyou1.setHubinaiyouhyoujijyun(1);
        hozenDomManager.insert(iM_KhHubiNaiyou1);

        IM_KhHubiNaiyou iM_KhHubiNaiyou2 = new IM_KhHubiNaiyou(P_JIMUTETUZUKICD_02,P_SYORUICD_02,P_HUBINAIYOUCD_02);
        iM_KhHubiNaiyou2.setHassinsakikbn(C_HassinsakiKbn.SYA);
        iM_KhHubiNaiyou2.setGenponhnkykumu(C_UmuKbn.ARI);
        iM_KhHubiNaiyou2.setHubinaiyouhyoujijyun(2);
        hozenDomManager.insert(iM_KhHubiNaiyou2);

        IM_KhHubiNaiyou iM_KhHubiNaiyou3 = new IM_KhHubiNaiyou(P_JIMUTETUZUKICD_03,P_SYORUICD_03,P_HUBINAIYOUCD_03);
        iM_KhHubiNaiyou3.setHassinsakikbn(C_HassinsakiKbn.KOK);
        iM_KhHubiNaiyou3.setGenponhnkykumu(C_UmuKbn.ARI);
        iM_KhHubiNaiyou3.setHubinaiyouhyoujijyun(3);
        hozenDomManager.insert(iM_KhHubiNaiyou3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhHubiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<IM_KhHubiNaiyou> iM_KhHubiNaiyouList = hozenDomManager.getAllKhHubiNaiyou();

        List<IM_KhHubiNaiyou> entityList = IM_KhHubiNaiyouDetacher.detachKhHubiNaiyoutouched(iM_KhHubiNaiyouList);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for (IM_KhHubiNaiyou entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<IM_KhHubiNaiyou> iM_KhHubiNaiyouList = new ArrayList<>();
        iM_KhHubiNaiyouList.add(null);
        iM_KhHubiNaiyouList.add(null);

        List<IM_KhHubiNaiyou> entityList = IM_KhHubiNaiyouDetacher.detachKhHubiNaiyoutouched(iM_KhHubiNaiyouList);

        for (IM_KhHubiNaiyou entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
