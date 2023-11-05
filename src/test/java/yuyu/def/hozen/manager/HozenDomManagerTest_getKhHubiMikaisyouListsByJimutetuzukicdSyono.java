package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全不備解消<br />
 * 契約保全不備未解消リストテーブルエンティティリスト取得（事務手続コード、証券番号）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubiMikaisyouListsByJimutetuzukicdSyono {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_JIMUTETUZUKICD_01 = "JI111";
    static String P_JIMUTETUZUKICD_02 = "JI112";
    static String P_JIMUTETUZUKICD_03 = "JI113";
    static String P_SYONO_01 = "11807111118";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono(P_JIMUTETUZUKICD_01, P_SYONO_01);

        Assert.assertEquals(0, iT_KhHubiMikaisyouListLst.size());

        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList1 = new IT_KhHubiMikaisyouList(P_JIMUTETUZUKICD_01, P_SYONO_01,
            C_HassinsakiKbn.BLNK);
        hozenDomManager.insert(iT_KhHubiMikaisyouList1);

        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList2 = new IT_KhHubiMikaisyouList(P_JIMUTETUZUKICD_02, P_SYONO_01,
            C_HassinsakiKbn.SYA);
        hozenDomManager.insert(iT_KhHubiMikaisyouList2);

        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList3 = new IT_KhHubiMikaisyouList(P_JIMUTETUZUKICD_02, P_SYONO_01,
            C_HassinsakiKbn.KOK);
        hozenDomManager.insert(iT_KhHubiMikaisyouList3);

        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList4 = new IT_KhHubiMikaisyouList(P_JIMUTETUZUKICD_02, P_SYONO_01,
            C_HassinsakiKbn.DRTEN);
        hozenDomManager.insert(iT_KhHubiMikaisyouList4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhHubiMikaisyouList());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono(P_JIMUTETUZUKICD_03, P_SYONO_01);

        assertEquals(0, iT_KhHubiMikaisyouListLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono(P_JIMUTETUZUKICD_01, P_SYONO_01);
        Assert.assertEquals(1, iT_KhHubiMikaisyouListLst.size());

        Assert.assertEquals(P_JIMUTETUZUKICD_01, iT_KhHubiMikaisyouListLst.get(0).getJimutetuzukicd());
        Assert.assertEquals(P_SYONO_01, iT_KhHubiMikaisyouListLst.get(0).getSyono());
        Assert.assertEquals(C_HassinsakiKbn.BLNK, iT_KhHubiMikaisyouListLst.get(0).getHassinsakikbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("JI112","11807111118","1"), "1");
        datamap.put($("JI112","11807111118","2"), "2");
        datamap.put($("JI112","11807111118","3"), "3");

        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono(P_JIMUTETUZUKICD_02, P_SYONO_01);

        for(IT_KhHubiMikaisyouList khHubiMikaisyouList:iT_KhHubiMikaisyouListLst){
            datamap.remove($(
                khHubiMikaisyouList.getJimutetuzukicd(),
                khHubiMikaisyouList.getSyono(),
                khHubiMikaisyouList.getHassinsakikbn()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono("", P_SYONO_01);

        assertEquals(0, iT_KhHubiMikaisyouListLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<IT_KhHubiMikaisyouList> iT_KhHubiMikaisyouListLst = hozenDomManager
            .getKhHubiMikaisyouListsByJimutetuzukicdSyono(P_JIMUTETUZUKICD_01, "");

        assertEquals(0, iT_KhHubiMikaisyouListLst.size());
    }
}
