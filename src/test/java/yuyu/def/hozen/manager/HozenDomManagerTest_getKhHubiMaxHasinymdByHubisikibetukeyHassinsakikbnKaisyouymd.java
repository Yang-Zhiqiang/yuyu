package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全不備解消<br />
 * 契約保全不備詳細テーブルエンティティ取得（不備識別キー、発信先区分）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_HUBISIKIBETUKEY_001 = "HK1111";
    static String P_HUBISIKIBETUKEY_002 = "HK2222";
    static String P_HUBISIKIBETUKEY_003 = "";
    static Integer P_RENNO3KETA_001 = 111;
    static Integer P_RENNO3KETA_002 = 222;
    static Integer P_RENNO3KETA_003 = 333;
    static BizDate P_HASINYMD_001 = BizDate.valueOf("20160309");
    static BizDate P_HASINYMD_002 = BizDate.valueOf("20160310");
    static BizDate P_HASINYMD_003 = BizDate.valueOf("20160311");
    static BizDate P_HASINYMD_004 = BizDate.valueOf("20160312");
    static BizDate P_KAISYOUYMD_001 = BizDate.valueOf("20160313");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        BizDate maxHasinymd = hozenDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(P_HUBISIKIBETUKEY_001, C_HassinsakiKbn.SYA);
        Assert.assertEquals(null, maxHasinymd);

        IT_KhHubi iT_KhHubi1 = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_001);
        if (iT_KhHubi1 == null) {
            iT_KhHubi1 = new IT_KhHubi(P_HUBISIKIBETUKEY_001);

            IT_KhHubiDetail iT_KhHubiDetail1 = iT_KhHubi1.createKhHubiDetail();
            iT_KhHubiDetail1.setRenno3keta(P_RENNO3KETA_001);
            iT_KhHubiDetail1.setHasinymd(P_HASINYMD_001);

            IT_KhHubiDetail iT_KhHubiDetail2 = iT_KhHubi1.createKhHubiDetail();
            iT_KhHubiDetail2.setRenno3keta(P_RENNO3KETA_002);
            iT_KhHubiDetail2.setHasinymd(P_HASINYMD_001);
            iT_KhHubiDetail2.setKaisyouymd(P_KAISYOUYMD_001);
            iT_KhHubiDetail2.setHassinsakikbn(C_HassinsakiKbn.SYA);

            IT_KhHubiDetail iT_KhHubiDetail3 = iT_KhHubi1.createKhHubiDetail();
            iT_KhHubiDetail3.setRenno3keta(P_RENNO3KETA_003);
            iT_KhHubiDetail3.setHasinymd(P_HASINYMD_001);
            iT_KhHubiDetail3.setHassinsakikbn(C_HassinsakiKbn.KOK);

            hozenDomManager.insert(iT_KhHubi1);
        }

        IT_KhHubi iT_KhHubi2 = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_002);
        if (iT_KhHubi2 == null) {
            iT_KhHubi2 = new IT_KhHubi(P_HUBISIKIBETUKEY_002);

            IT_KhHubiDetail iT_KhHubiDetail4 = iT_KhHubi2.createKhHubiDetail();
            iT_KhHubiDetail4.setRenno3keta(P_RENNO3KETA_001);
            iT_KhHubiDetail4.setHasinymd(P_HASINYMD_002);
            iT_KhHubiDetail4.setHassinsakikbn(C_HassinsakiKbn.KOK);

            IT_KhHubiDetail iT_KhHubiDetail5 = iT_KhHubi2.createKhHubiDetail();
            iT_KhHubiDetail5.setRenno3keta(P_RENNO3KETA_002);
            iT_KhHubiDetail5.setHasinymd(P_HASINYMD_003);
            iT_KhHubiDetail5.setHassinsakikbn(C_HassinsakiKbn.KOK);

            IT_KhHubiDetail iT_KhHubiDetail6 = iT_KhHubi2.createKhHubiDetail();
            iT_KhHubiDetail6.setRenno3keta(P_RENNO3KETA_003);
            iT_KhHubiDetail6.setHasinymd(P_HASINYMD_004);
            iT_KhHubiDetail6.setHassinsakikbn(C_HassinsakiKbn.KOK);

            hozenDomManager.insert(iT_KhHubi2);
        }
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

        BizDate maxHasinymd = hozenDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(P_HUBISIKIBETUKEY_001, C_HassinsakiKbn.SYA);

        Assert.assertEquals(null, maxHasinymd);
    }

    @Test
    @TestOrder(20)
    public void blankCondition() {

        BizDate maxHasinymd = hozenDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(P_HUBISIKIBETUKEY_003, C_HassinsakiKbn.SYA);

        Assert.assertEquals(null, maxHasinymd);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        BizDate maxHasinymd = hozenDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(P_HUBISIKIBETUKEY_001, C_HassinsakiKbn.KOK);

        Assert.assertEquals(20160309, maxHasinymd.intValue());
    }

    @Test
    @TestOrder(40)
    public void normal2() {

        BizDate maxHasinymd = hozenDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(P_HUBISIKIBETUKEY_002, C_HassinsakiKbn.KOK);

        Assert.assertEquals(20160312, maxHasinymd.intValue());
    }
}
