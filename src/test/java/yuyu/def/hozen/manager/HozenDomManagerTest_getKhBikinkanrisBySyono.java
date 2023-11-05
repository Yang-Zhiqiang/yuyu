package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 解約返戻金相当額情報作成<br />
 * 契約保全備金管理テーブルエンティティリスト取得（証券番号）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisBySyono {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static BizDate P_KESSANKIJYUNYMD_01 = BizDate.valueOf("20160101");
    static BizDate P_BKNKKTYMD_01 = BizDate.valueOf("20160201");
    static Integer P_RENNO_01 = new Integer(10);

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(P_SYONO_01);

        assertEquals(0, iT_KhBikinkanriLst.size());

        IT_KhBikinkanri iT_KhBikinkanri1 = new IT_KhBikinkanri(P_SYONO_01, P_KESSANKIJYUNYMD_01,
            C_BkncdKbn.GENGK, P_BKNKKTYMD_01, P_RENNO_01);
        hozenDomManager.insert(iT_KhBikinkanri1);

        IT_KhBikinkanri iT_KhBikinkanri2 = new IT_KhBikinkanri(P_SYONO_02, P_KESSANKIJYUNYMD_01,
            C_BkncdKbn.GENGK, P_BKNKKTYMD_01, P_RENNO_01);
        hozenDomManager.insert(iT_KhBikinkanri2);

        IT_KhBikinkanri iT_KhBikinkanri3 = new IT_KhBikinkanri(P_SYONO_02, P_KESSANKIJYUNYMD_01,
            C_BkncdKbn.KAIYAKU, P_BKNKKTYMD_01, P_RENNO_01);
        hozenDomManager.insert(iT_KhBikinkanri3);

        IT_KhBikinkanri iT_KhBikinkanri4 = new IT_KhBikinkanri(P_SYONO_02, P_KESSANKIJYUNYMD_01,
            C_BkncdKbn.KOUDOSYOUGAIUKETUKE, P_BKNKKTYMD_01, P_RENNO_01);
        hozenDomManager.insert(iT_KhBikinkanri4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(P_SYONO_03);

        assertEquals(0, iT_KhBikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(P_SYONO_01);
        Iterator<IT_KhBikinkanri> iter = iT_KhBikinkanriLst.iterator();
        IT_KhBikinkanri iT_KhBikinkanri = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            iT_KhBikinkanri = iter.next();
            Assert.assertEquals(P_SYONO_01, iT_KhBikinkanri.getSyono());
            Assert.assertEquals(P_KESSANKIJYUNYMD_01, iT_KhBikinkanri.getKessankijyunymd());
            Assert.assertEquals(C_BkncdKbn.GENGK, iT_KhBikinkanri.getBkncdkbn());
            Assert.assertEquals(P_BKNKKTYMD_01, iT_KhBikinkanri.getBknkktymd());
            Assert.assertEquals(P_RENNO_01, iT_KhBikinkanri.getRenno());
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111129","20160101","PC02","20160201","10"), "1");
        datamap.put($("11807111129","20160101","PC12","20160201","10"), "2");
        datamap.put($("11807111129","20160101","PED2","20160201","10"), "3");

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(P_SYONO_02);
        Iterator<IT_KhBikinkanri> iter = iT_KhBikinkanriLst.iterator();
        IT_KhBikinkanri iT_KhBikinkanri = null;

        while (iter.hasNext()) {

            iT_KhBikinkanri = iter.next();
            datamap.remove($(
                iT_KhBikinkanri.getSyono(),
                iT_KhBikinkanri.getKessankijyunymd(),
                iT_KhBikinkanri.getBkncdkbn(),
                iT_KhBikinkanri.getBknkktymd(),
                iT_KhBikinkanri.getRenno()));

        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono("");

        assertEquals(0, iT_KhBikinkanriLst.size());
    }
}
