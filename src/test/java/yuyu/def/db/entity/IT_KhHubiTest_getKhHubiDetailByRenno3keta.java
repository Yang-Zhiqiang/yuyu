package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全不備テーブルエンティティから、<br />
 * 連番（３桁）を指定して、<br />
 * 契約保全不備詳細テーブルエンティティ取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhHubiTest_getKhHubiDetailByRenno3keta {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_HUBISIKIBETUKEY_01 = "1118120714";
    static Integer P_RENNO3KETA_01 = new Integer(111);
    static Integer P_RENNO3KETA_02 = new Integer(222);
    static Integer P_RENNO3KETA_03 = new Integer(333);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHubi iT_KhHubi = new IT_KhHubi(P_HUBISIKIBETUKEY_01);

        Assert.assertEquals(null, iT_KhHubi.getKhHubiDetailByRenno3keta(P_RENNO3KETA_01));

        IT_KhHubiDetail iT_KhHubiDetail1 = iT_KhHubi.createKhHubiDetail();
        iT_KhHubiDetail1.setRenno3keta(P_RENNO3KETA_01);

        IT_KhHubiDetail iT_KhHubiDetail2 = iT_KhHubi.createKhHubiDetail();
        iT_KhHubiDetail2.setRenno3keta(P_RENNO3KETA_03);

        hozenDomManager.insert(iT_KhHubi);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_01);

        Assert.assertEquals(null, khHubi.getKhHubiDetailByRenno3keta(P_RENNO3KETA_02));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_01);

        IT_KhHubiDetail iT_KhHubiDetail = khHubi.getKhHubiDetailByRenno3keta(P_RENNO3KETA_01);

        Assert.assertEquals(P_HUBISIKIBETUKEY_01,iT_KhHubiDetail.getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_01,iT_KhHubiDetail.getRenno3keta());
    }
}
