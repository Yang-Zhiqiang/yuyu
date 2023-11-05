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

import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全不備解消<br />
 * 契約保全不備テーブルエンティティリスト取得（証券番号、不備識別キー）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubisBySyonoHubisikibetukeys {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_HUBISIKIBETUKEY_1 = "791112221";
    static String P_HUBISIKIBETUKEY_2 = "791112222";
    static String P_HUBISIKIBETUKEY_3 = "791112223";
    static String P_HUBISIKIBETUKEY_4 = "791112224";
    static String P_HUBISIKIBETUKEY1[] = {P_HUBISIKIBETUKEY_1};
    static String P_HUBISIKIBETUKEY2[] = {P_HUBISIKIBETUKEY_1, P_HUBISIKIBETUKEY_2, P_HUBISIKIBETUKEY_3};
    static String P_HUBISIKIBETUKEY3[] = {P_HUBISIKIBETUKEY_4};
    static String P_HUBISIKIBETUKEY4[] = {""};
    static String P_SYONO_1 = "11807111118";
    static String P_SYONO_2 = "";
    static BizDate P_SKSREADYMD1 = BizDate.valueOf("20160309");
    static BizDate P_SKSREADYMD2 = BizDate.valueOf("20160303");
    static BizDate P_SKSREADYMD3 = BizDate.valueOf("20160311");
    static BizDate P_HASINYMD1 = BizDate.valueOf("20160309");
    static BizDate P_KAISYOUYMD1 = BizDate.valueOf("20160314");
    static Integer P_RENNO3KETA_0 = new Integer(0);
    static Integer P_RENNO3KETA_1 = new Integer(1);
    static Integer P_RENNO3KETA_2 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(P_SYONO_1, P_HUBISIKIBETUKEY1);
        Assert.assertEquals(0,khHubiLst.size());

        IT_KhHubi iT_KhHubi1 = new IT_KhHubi(P_HUBISIKIBETUKEY_1);
        iT_KhHubi1.setSyono(P_SYONO_1);
        iT_KhHubi1.setSksreadymd(P_SKSREADYMD1);

        IT_KhHubiDetail iT_KhHubiDetail = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetail.setHubisikibetukey(P_HUBISIKIBETUKEY_1);
        iT_KhHubiDetail.setRenno3keta(P_RENNO3KETA_0);
        iT_KhHubiDetail.setKaisyouymd(P_KAISYOUYMD1);

        IT_KhHubiDetail iT_KhHubiDetai2 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetai2.setHubisikibetukey(P_HUBISIKIBETUKEY_1);
        iT_KhHubiDetai2.setRenno3keta(P_RENNO3KETA_1);
        iT_KhHubiDetai2.setHasinymd(P_HASINYMD1);

        IT_KhHubiDetail iT_KhHubiDetai3 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetai3.setHubisikibetukey(P_HUBISIKIBETUKEY_1);
        iT_KhHubiDetai3.setRenno3keta(P_RENNO3KETA_2);
        iT_KhHubiDetai3.setHasinymd(P_HASINYMD1);
        iT_KhHubiDetai3.setKaisyouymd(P_KAISYOUYMD1);

        IT_KhHubiDetail iT_KhHubiDetai4 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetai4.setHubisikibetukey(P_HUBISIKIBETUKEY_1);
        iT_KhHubiDetai4.setRenno3keta(new Integer(3));
        iT_KhHubiDetai4.setHasinymd(P_HASINYMD1);
        hozenDomManager.insert(iT_KhHubi1);

        IT_KhHubi iT_KhHubi2 = new IT_KhHubi(P_HUBISIKIBETUKEY_2);
        iT_KhHubi2.setSyono(P_SYONO_1);
        iT_KhHubi2.setSksreadymd(P_SKSREADYMD2);

        IT_KhHubiDetail iT_KhHubiDetai5 = iT_KhHubi2.createKhHubiDetail();
        iT_KhHubiDetai5.setHubisikibetukey(P_HUBISIKIBETUKEY_2);
        iT_KhHubiDetai5.setRenno3keta(P_RENNO3KETA_0);
        iT_KhHubiDetai5.setHasinymd(P_HASINYMD1);
        hozenDomManager.insert(iT_KhHubi2);

        IT_KhHubi iT_KhHubi3 = new IT_KhHubi(P_HUBISIKIBETUKEY_3);
        iT_KhHubi3.setSyono(P_SYONO_1);
        iT_KhHubi3.setSksreadymd(P_SKSREADYMD3);

        IT_KhHubiDetail iT_KhHubiDetai6 = iT_KhHubi3.createKhHubiDetail();
        iT_KhHubiDetai6.setHubisikibetukey(P_HUBISIKIBETUKEY_3);
        iT_KhHubiDetai6.setRenno3keta(P_RENNO3KETA_0);
        iT_KhHubiDetai6.setHasinymd(P_HASINYMD1);
        hozenDomManager.insert(iT_KhHubi3);

        IT_KhHubi iT_KhHubi4 = new IT_KhHubi(P_HUBISIKIBETUKEY_4);
        iT_KhHubi4.setSyono(P_SYONO_1);
        iT_KhHubi4.setSksreadymd(P_SKSREADYMD3);
        hozenDomManager.insert(iT_KhHubi4);
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

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(P_SYONO_1, P_HUBISIKIBETUKEY3);

        Assert.assertEquals(0, khHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(P_SYONO_1, P_HUBISIKIBETUKEY1);

        Assert.assertEquals(1, khHubiLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_1, khHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_SYONO_1, khHubiLst.get(0).getSyono());
        Assert.assertEquals(P_SKSREADYMD1, khHubiLst.get(0).getSksreadymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(P_SYONO_1, P_HUBISIKIBETUKEY2);

        Assert.assertEquals(3,khHubiLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_2, khHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_SYONO_1, khHubiLst.get(0).getSyono());
        Assert.assertEquals(P_SKSREADYMD2, khHubiLst.get(0).getSksreadymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_1, khHubiLst.get(1).getHubisikibetukey());
        Assert.assertEquals(P_SYONO_1, khHubiLst.get(1).getSyono());
        Assert.assertEquals(P_SKSREADYMD1, khHubiLst.get(1).getSksreadymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_3, khHubiLst.get(2).getHubisikibetukey());
        Assert.assertEquals(P_SYONO_1, khHubiLst.get(2).getSyono());
        Assert.assertEquals(P_SKSREADYMD3, khHubiLst.get(2).getSksreadymd());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(P_SYONO_2, P_HUBISIKIBETUKEY1);

        Assert.assertEquals(0,khHubiLst.size());
    }
}
