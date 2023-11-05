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

import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getBAKSmbcStyKanrisBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSmbcStyKanrisBySyonoTrkssikibetukey {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "SNK0003");

        Assert.assertEquals(0,bAK_SmbcStyKanriLst.size());

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri.setDatarenymd(BizDate.valueOf("20160202"));
        hT_BAK_SmbcStyKanri.setTrkssikibetukey("SNK0002");
        hT_BAK_SmbcStyKanri.setDatasakuseirenno(BizNumber.valueOf(2));
        hT_BAK_SmbcStyKanri.setSyono("10000000060");
        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri);

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri2 = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri2.setDatarenymd(BizDate.valueOf("20160203"));
        hT_BAK_SmbcStyKanri2.setTrkssikibetukey("SNK0003");
        hT_BAK_SmbcStyKanri2.setDatasakuseirenno(BizNumber.valueOf(2));
        hT_BAK_SmbcStyKanri2.setSyono("10000000060");
        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri2);

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri3 = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri3.setDatarenymd(BizDate.valueOf("20160204"));
        hT_BAK_SmbcStyKanri3.setTrkssikibetukey("SNK0003");
        hT_BAK_SmbcStyKanri3.setDatasakuseirenno(BizNumber.valueOf(2));
        hT_BAK_SmbcStyKanri3.setSyono("10000000060");
        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri3);

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri4 = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri4.setDatarenymd(BizDate.valueOf("20160205"));
        hT_BAK_SmbcStyKanri4.setTrkssikibetukey("SNK0003");
        hT_BAK_SmbcStyKanri4.setDatasakuseirenno(BizNumber.valueOf(2));
        hT_BAK_SmbcStyKanri4.setSyono("10000000060");
        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri4);

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri5 = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri5.setDatarenymd(BizDate.valueOf("20160206"));
        hT_BAK_SmbcStyKanri5.setTrkssikibetukey("SNK0003");
        hT_BAK_SmbcStyKanri5.setDatasakuseirenno(BizNumber.valueOf(2));
        hT_BAK_SmbcStyKanri5.setSyono("10000000070");
        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSmbcStyKanri());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000080", "SNK0003");

        assertEquals(0, bAK_SmbcStyKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "SNK0002");

        assertEquals(1, bAK_SmbcStyKanriLst.size());
        assertEquals("20160202", bAK_SmbcStyKanriLst.get(0).getDatarenymd().toString());
        assertEquals("SNK0002",bAK_SmbcStyKanriLst.get(0).getTrkssikibetukey());
        assertEquals(BizNumber.valueOf(2),bAK_SmbcStyKanriLst.get(0).getDatasakuseirenno());
        assertEquals("10000000060",bAK_SmbcStyKanriLst.get(0).getSyono());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("", "SNK0002");
        Assert.assertEquals(0, bAK_SmbcStyKanriLst.size());

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "");
        Assert.assertEquals(0, bAK_SmbcStyKanriLst.size());

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("20160203","SNK0003",BizNumber.valueOf(2),"10000000060"), "1");
        datamap.put($("20160204","SNK0003",BizNumber.valueOf(2),"10000000060"), "1");
        datamap.put($("20160205","SNK0003",BizNumber.valueOf(2),"10000000060"), "1");

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "SNK0003");

        for(HT_BAK_SmbcStyKanri baksmbcStyKanri:bAK_SmbcStyKanriLst){
            datamap.remove($(
                baksmbcStyKanri.getDatarenymd().toString(),
                baksmbcStyKanri.getTrkssikibetukey(),
                baksmbcStyKanri.getDatasakuseirenno(),
                baksmbcStyKanri.getSyono()));
        }

        assertEquals(3, bAK_SmbcStyKanriLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void noResult2(){

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst1 = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "SNK0003");
        sinkeiyakuDomManager.delete(bAK_SmbcStyKanriLst1);

        List<HT_BAK_SmbcStyKanri> bAK_SmbcStyKanriLst = sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey("10000000060", "SNK0003");

        assertEquals(0, bAK_SmbcStyKanriLst.size());
    }
}
