package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuKanrisByDskokyakujtkbnNe() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisByDskokyakujtkbnNe {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "亜伊雨画", BizDate.valueOf(20161010), "1234567");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

        insertSubData();

    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("100");
        dsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri1.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri1.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri1.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("101");
        dsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.KAIYAKU);
        dsKokyakuKanri2.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri2.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri2.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("102");
        dsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
        dsKokyakuKanri3.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri3.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri3.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("103");
        dsKokyakuKanri4.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri4.setDskokyakunmkn("カキク");
        dsKokyakuKanri4.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri4.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri4.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("104");
        dsKokyakuKanri5.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri5.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri5.setDskokyakunmkj("亜伊雨");
        dsKokyakuKanri5.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri5.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("105");
        dsKokyakuKanri6.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri6.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri6.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri6.setDskokyakuseiymd(BizDate.valueOf(20161011));
        dsKokyakuKanri6.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri6);

        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("106");
        dsKokyakuKanri7.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri7.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri7.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri7.setDskokyakuseiymd(BizDate.valueOf(20161010));
        dsKokyakuKanri7.setDskokyakuyno("1234568");

        directDomManager.insert(dsKokyakuKanri7);

        MT_DsKokyakuKanri dsKokyakuKanri8 = new MT_DsKokyakuKanri("107");
        dsKokyakuKanri8.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri8.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri8.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri8.setDskokyakuseiymd(BizDate.valueOf(20161012));
        dsKokyakuKanri8.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri8);

        MT_DsKokyakuKanri dsKokyakuKanri9 = new MT_DsKokyakuKanri("108");
        dsKokyakuKanri9.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri9.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri9.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri9.setDskokyakuseiymd(BizDate.valueOf(20161012));
        dsKokyakuKanri9.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri9);

        MT_DsKokyakuKanri dsKokyakuKanri10 = new MT_DsKokyakuKanri("109");
        dsKokyakuKanri10.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        dsKokyakuKanri10.setDskokyakunmkn("カキクケ");
        dsKokyakuKanri10.setDskokyakunmkj("亜伊雨画");
        dsKokyakuKanri10.setDskokyakuseiymd(BizDate.valueOf(20161012));
        dsKokyakuKanri10.setDskokyakuyno("1234567");

        directDomManager.insert(dsKokyakuKanri10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "亜伊雨画", BizDate.valueOf(20171010), "1234567");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "亜伊雨画", BizDate.valueOf(20161010), "1234567");

        Assert.assertEquals(1, dsKokyakuKanriLst.size());
        Assert.assertEquals("100", dsKokyakuKanriLst.get(0).getDskokno());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("107"), "1");
        datamap.put($("108"), "2");
        datamap.put($("109"), "3");

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "亜伊雨画", BizDate.valueOf(20161012), "1234567");

        for(MT_DsKokyakuKanri dsKokyakuKanri:dsKokyakuKanriLst){
            datamap.remove($(dsKokyakuKanri.getDskokno()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "", "亜伊雨画", BizDate.valueOf(20171010), "1234567");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "", BizDate.valueOf(20171010), "1234567");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(
            "カキクケ", "亜伊雨画", BizDate.valueOf(20171010), "");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

    }
}
