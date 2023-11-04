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

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全不備テーブルエンティティから、<br />
 * 契約保全不備詳細テーブルエンティティリストを取得のテストクラス。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhHubiTest_getKhHubiDetailsByHasinymdKaisyouymdNotNull {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_HUBISIKIBETUKEY_1 = "HK1111";
    static String P_HUBISIKIBETUKEY_2 = "HK2222";
    static String P_HUBISIKIBETUKEY_3 = "HK3333";
    static Integer P_RENNO3KETA_1 = new Integer(111);
    static Integer P_RENNO3KETA_2 = new Integer(112);
    static Integer P_RENNO3KETA_3 = new Integer(113);
    static Integer P_RENNO3KETA_4 = new Integer(114);
    static BizDate P_HASINYMD_1 = BizDate.valueOf("20160308");
    static BizDate P_KAISYOUYMD_1 = BizDate.valueOf("20160309");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHubi iT_KhHubi_1 = new IT_KhHubi(P_HUBISIKIBETUKEY_1);

        List<IT_KhHubiDetail> iT_KhHubiDetailLst = iT_KhHubi_1.getKhHubiDetailsByHasinymdKaisyouymdNotNull();

        Assert.assertEquals(0, iT_KhHubiDetailLst.size());

        IT_KhHubiDetail iT_KhHubiDetail_1 = iT_KhHubi_1.createKhHubiDetail();
        iT_KhHubiDetail_1.setRenno3keta(P_RENNO3KETA_1);
        iT_KhHubiDetail_1.setHasinymd(P_HASINYMD_1);
        iT_KhHubiDetail_1.setKaisyouymd(P_KAISYOUYMD_1);

        hozenDomManager.insert(iT_KhHubi_1);

        IT_KhHubi iT_KhHubi_2 = new IT_KhHubi(P_HUBISIKIBETUKEY_3);

        IT_KhHubiDetail iT_KhHubiDetail_2 = iT_KhHubi_2.createKhHubiDetail();
        iT_KhHubiDetail_2.setRenno3keta(P_RENNO3KETA_2);
        iT_KhHubiDetail_2.setKaisyouymd(P_KAISYOUYMD_1);

        IT_KhHubiDetail iT_KhHubiDetail_3 = iT_KhHubi_2.createKhHubiDetail();
        iT_KhHubiDetail_3.setRenno3keta(P_RENNO3KETA_3);
        iT_KhHubiDetail_3.setHasinymd(P_HASINYMD_1);

        IT_KhHubiDetail iT_KhHubiDetail_4 = iT_KhHubi_2.createKhHubiDetail();
        iT_KhHubiDetail_4.setRenno3keta(P_RENNO3KETA_4);

        hozenDomManager.insert(iT_KhHubi_2);

        IT_KhHubi iT_KhHubi_3 = new IT_KhHubi(P_HUBISIKIBETUKEY_2);

        IT_KhHubiDetail iT_KhHubiDetail_5 = iT_KhHubi_3.createKhHubiDetail();
        iT_KhHubiDetail_5.setRenno3keta(P_RENNO3KETA_1);
        iT_KhHubiDetail_5.setHasinymd(P_HASINYMD_1);
        iT_KhHubiDetail_5.setKaisyouymd(P_KAISYOUYMD_1);

        IT_KhHubiDetail iT_KhHubiDetail_6 = iT_KhHubi_3.createKhHubiDetail();
        iT_KhHubiDetail_6.setRenno3keta(P_RENNO3KETA_2);
        iT_KhHubiDetail_6.setHasinymd(P_HASINYMD_1);
        iT_KhHubiDetail_6.setKaisyouymd(P_KAISYOUYMD_1);

        IT_KhHubiDetail iT_KhHubiDetail_7 = iT_KhHubi_3.createKhHubiDetail();
        iT_KhHubiDetail_7.setRenno3keta(P_RENNO3KETA_3);
        iT_KhHubiDetail_7.setHasinymd(P_HASINYMD_1);
        iT_KhHubiDetail_7.setKaisyouymd(P_KAISYOUYMD_1);

        hozenDomManager.insert(iT_KhHubi_3);
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

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_3);

        List<IT_KhHubiDetail> iT_KhHubiLst = iT_KhHubi.getKhHubiDetailsByHasinymdKaisyouymdNotNull();

        Assert.assertEquals(0, iT_KhHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_1);

        List<IT_KhHubiDetail> iT_KhHubiLst = iT_KhHubi.getKhHubiDetailsByHasinymdKaisyouymdNotNull();

        Assert.assertEquals(1, iT_KhHubiLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_1, iT_KhHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_1, iT_KhHubiLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, iT_KhHubiLst.get(0).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_1, iT_KhHubiLst.get(0).getKaisyouymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_2);

        List<IT_KhHubiDetail> iT_KhHubiLst = iT_KhHubi.getKhHubiDetailsByHasinymdKaisyouymdNotNull();

        Assert.assertEquals(3, iT_KhHubiLst.size());

        Assert.assertEquals(P_HUBISIKIBETUKEY_2, iT_KhHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_1, iT_KhHubiLst.get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, iT_KhHubiLst.get(0).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_1, iT_KhHubiLst.get(0).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_2, iT_KhHubiLst.get(1).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_2, iT_KhHubiLst.get(1).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, iT_KhHubiLst.get(1).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_1, iT_KhHubiLst.get(1).getKaisyouymd());

        Assert.assertEquals(P_HUBISIKIBETUKEY_2, iT_KhHubiLst.get(2).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_3, iT_KhHubiLst.get(2).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, iT_KhHubiLst.get(2).getHasinymd());
        Assert.assertEquals(P_KAISYOUYMD_1, iT_KhHubiLst.get(2).getKaisyouymd());
    }
}
