package yuyu.def.db.entity;

import java.util.Iterator;
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

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全不備テーブルエンティティから、<br />
 * 発信日、発信先区分を指定して、<br />
 * 契約保全不備詳細テーブルエンティティリストを取得します。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhHubiTest_getKhHubiDetailsByHasinymdHassinsakikbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_HUBISIKIBETUKEY_001 = "HK1111";
    static String P_HUBISIKIBETUKEY_002 = "HK2222";
    static Integer P_RENNO3KETA_001 = 111;
    static Integer P_RENNO3KETA_002 = 222;
    static Integer P_RENNO3KETA_003 = 333;
    static BizDate P_HASINYMD_001 = BizDate.valueOf("20160309");
    static BizDate P_HASINYMD_002 = BizDate.valueOf("20160310");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHubi iT_KhHubi1 = new IT_KhHubi(P_HUBISIKIBETUKEY_001);

        List<IT_KhHubiDetail> iT_KhHubiDetailLst = iT_KhHubi1.getKhHubiDetailsByHasinymdHassinsakikbn(P_HASINYMD_001, C_HassinsakiKbn.KOK);

        Assert.assertEquals(0, iT_KhHubiDetailLst.size());

        IT_KhHubiDetail iT_KhHubiDetail1 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetail1.setRenno3keta(P_RENNO3KETA_001);
        iT_KhHubiDetail1.setHasinymd(P_HASINYMD_001);

        IT_KhHubiDetail iT_KhHubiDetail2 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetail2.setRenno3keta(P_RENNO3KETA_002);
        iT_KhHubiDetail2.setHassinsakikbn(C_HassinsakiKbn.SYA);

        IT_KhHubiDetail iT_KhHubiDetail3 = iT_KhHubi1.createKhHubiDetail();
        iT_KhHubiDetail3.setRenno3keta(P_RENNO3KETA_003);
        iT_KhHubiDetail3.setHasinymd(P_HASINYMD_001);
        iT_KhHubiDetail3.setHassinsakikbn(C_HassinsakiKbn.KOK);

        hozenDomManager.insert(iT_KhHubi1);

        IT_KhHubi iT_KhHubi2 = new IT_KhHubi(P_HUBISIKIBETUKEY_002);

        IT_KhHubiDetail iT_KhHubiDetail4 = iT_KhHubi2.createKhHubiDetail();
        iT_KhHubiDetail4.setRenno3keta(P_RENNO3KETA_001);
        iT_KhHubiDetail4.setHasinymd(P_HASINYMD_002);
        iT_KhHubiDetail4.setHassinsakikbn(C_HassinsakiKbn.KOK);

        IT_KhHubiDetail iT_KhHubiDetail5 = iT_KhHubi2.createKhHubiDetail();
        iT_KhHubiDetail5.setRenno3keta(P_RENNO3KETA_002);
        iT_KhHubiDetail5.setHasinymd(P_HASINYMD_002);
        iT_KhHubiDetail5.setHassinsakikbn(C_HassinsakiKbn.KOK);

        IT_KhHubiDetail iT_KhHubiDetail6 = iT_KhHubi2.createKhHubiDetail();
        iT_KhHubiDetail6.setRenno3keta(P_RENNO3KETA_003);
        iT_KhHubiDetail6.setHasinymd(P_HASINYMD_002);
        iT_KhHubiDetail6.setHassinsakikbn(C_HassinsakiKbn.KOK);

        hozenDomManager.insert(iT_KhHubi2);

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

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_001);

        List<IT_KhHubiDetail> iT_KhHubiDetailLst = iT_KhHubi.getKhHubiDetailsByHasinymdHassinsakikbn(P_HASINYMD_001, C_HassinsakiKbn.SYA);

        Assert.assertEquals(0, iT_KhHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_001);

        List<IT_KhHubiDetail> iT_KhHubiDetailLst = iT_KhHubi.getKhHubiDetailsByHasinymdHassinsakikbn(P_HASINYMD_001, C_HassinsakiKbn.KOK);

        Iterator<IT_KhHubiDetail> iter = iT_KhHubiDetailLst.iterator();
        IT_KhHubiDetail iT_KhHubiDetail = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            iT_KhHubiDetail = iter.next();

            Assert.assertEquals(P_HUBISIKIBETUKEY_001, iT_KhHubiDetail.getHubisikibetukey());
            Assert.assertEquals(P_RENNO3KETA_003, iT_KhHubiDetail.getRenno3keta());
            Assert.assertEquals(P_HASINYMD_001, iT_KhHubiDetail.getHasinymd());
            Assert.assertEquals(C_HassinsakiKbn.KOK, iT_KhHubiDetail.getHassinsakikbn());
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KhHubi iT_KhHubi = hozenDomManager.getKhHubi(P_HUBISIKIBETUKEY_002);

        List<IT_KhHubiDetail> iT_KhHubiDetailLst = iT_KhHubi.getKhHubiDetailsByHasinymdHassinsakikbn(P_HASINYMD_002, C_HassinsakiKbn.KOK);

        Iterator<IT_KhHubiDetail> iter = iT_KhHubiDetailLst.iterator();
        IT_KhHubiDetail iT_KhHubiDetail = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            iT_KhHubiDetail = iter.next();
            if (1 == iCount) {

                Assert.assertEquals(P_HUBISIKIBETUKEY_002, iT_KhHubiDetail.getHubisikibetukey());
                Assert.assertEquals(P_RENNO3KETA_001, iT_KhHubiDetail.getRenno3keta());
                Assert.assertEquals(P_HASINYMD_002, iT_KhHubiDetail.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.KOK, iT_KhHubiDetail.getHassinsakikbn());

                continue;
            }
            if (2 == iCount) {

                Assert.assertEquals(P_HUBISIKIBETUKEY_002, iT_KhHubiDetail.getHubisikibetukey());
                Assert.assertEquals(P_RENNO3KETA_002, iT_KhHubiDetail.getRenno3keta());
                Assert.assertEquals(P_HASINYMD_002, iT_KhHubiDetail.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.KOK, iT_KhHubiDetail.getHassinsakikbn());

                continue;
            }
            if (3 == iCount) {

                Assert.assertEquals(P_HUBISIKIBETUKEY_002, iT_KhHubiDetail.getHubisikibetukey());
                Assert.assertEquals(P_RENNO3KETA_003, iT_KhHubiDetail.getRenno3keta());
                Assert.assertEquals(P_HASINYMD_002, iT_KhHubiDetail.getHasinymd());
                Assert.assertEquals(C_HassinsakiKbn.KOK, iT_KhHubiDetail.getHassinsakikbn());

                continue;
            }
        }

        Assert.assertEquals(3, iCount);
    }
}
