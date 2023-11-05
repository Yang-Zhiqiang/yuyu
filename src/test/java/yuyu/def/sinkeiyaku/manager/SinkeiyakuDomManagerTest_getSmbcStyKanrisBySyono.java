package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＳＭＢＣ進捗管理テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisBySyono {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono("10000000001");

        Assert.assertEquals(0,smbcStyKanriLst.size());


        HT_SmbcStyKanri smbcStyKanri = new HT_SmbcStyKanri();
        smbcStyKanri.setDatarenymd(BizDate.valueOf("20160101"));
        smbcStyKanri.setDatasakuseirenno(BizNumber.valueOf(1));
        smbcStyKanri.setSyono("10000000001");
        sinkeiyakuDomManager.insert(smbcStyKanri);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri();
        smbcStyKanri2.setDatarenymd(BizDate.valueOf("20160102"));
        smbcStyKanri2.setDatasakuseirenno(BizNumber.valueOf(2));
        smbcStyKanri2.setSyono("10000000002");
        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri();
        smbcStyKanri3.setDatarenymd(BizDate.valueOf("20160103"));
        smbcStyKanri3.setDatasakuseirenno(BizNumber.valueOf(3));
        smbcStyKanri3.setSyono("10000000003");
        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri();
        smbcStyKanri4.setDatarenymd(BizDate.valueOf("20160104"));
        smbcStyKanri4.setDatasakuseirenno(BizNumber.valueOf(4));
        smbcStyKanri4.setSyono("10000000003");
        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri();
        smbcStyKanri5.setDatarenymd(BizDate.valueOf("20160105"));
        smbcStyKanri5.setDatasakuseirenno(BizNumber.valueOf(5));
        smbcStyKanri5.setSyono("10000000003");
        sinkeiyakuDomManager.insert(smbcStyKanri5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono("10000000004");

        assertEquals(0, smbcStyKanriLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono("10000000001");

        assertEquals(1, smbcStyKanriLst.size());
        assertEquals(BizDate.valueOf("20160101"),smbcStyKanriLst.get(0).getDatarenymd());
        assertEquals(BizNumber.valueOf(1),smbcStyKanriLst.get(0).getDatasakuseirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(BizDate.valueOf("20160103"),BizNumber.valueOf(3)), "1");
        datamap.put($(BizDate.valueOf("20160104"),BizNumber.valueOf(4)), "1");
        datamap.put($(BizDate.valueOf("20160105"),BizNumber.valueOf(5)), "1");

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono("10000000003");
        for(HT_SmbcStyKanri smbcStyKanri:smbcStyKanriLst){
            datamap.remove($(
                smbcStyKanri.getDatarenymd(),
                smbcStyKanri.getDatasakuseirenno()));
        }

        assertEquals(3, smbcStyKanriLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono("");

        assertEquals(0, smbcStyKanriLst.size());

    }
}
