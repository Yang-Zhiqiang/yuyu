package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkSyuunouKekkaDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkSyuunouKekkaDatasByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkSyuunouKekkaData> skSyuunouKekkaDataLLst = sinkeiyakuDomManager
            .getSkSyuunouKekkaDatasByMosno("791112220");

        Assert.assertEquals(0, skSyuunouKekkaDataLLst.size());

        HT_SkSyuunouKekkaData skSyuunouKekkaData1 = new HT_SkSyuunouKekkaData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160503), "791112220", BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skSyuunouKekkaData1);

        HT_SkSyuunouKekkaData skSyuunouKekkaData2 = new HT_SkSyuunouKekkaData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160503), "791112238", BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skSyuunouKekkaData2);

        HT_SkSyuunouKekkaData skSyuunouKekkaData3 = new HT_SkSyuunouKekkaData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160504), "791112246", BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skSyuunouKekkaData3);

        HT_SkSyuunouKekkaData skSyuunouKekkaData4 = new HT_SkSyuunouKekkaData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160505), "791112246", BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skSyuunouKekkaData4);

        HT_SkSyuunouKekkaData skSyuunouKekkaData5 = new HT_SkSyuunouKekkaData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160506), "791112246", BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skSyuunouKekkaData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkSyuunouKekkaData());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SkSyuunouKekkaData> skSyuunouKekkaDataLLst = sinkeiyakuDomManager.getSkSyuunouKekkaDatasByMosno(
            "791112279");

        assertEquals(0, skSyuunouKekkaDataLLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkSyuunouKekkaData> skSyuunouKekkaDataLLst = sinkeiyakuDomManager.getSkSyuunouKekkaDatasByMosno(
            "791112220");

        assertEquals(1, skSyuunouKekkaDataLLst.size());

        assertEquals(C_AnsyuusysKbn.valueOf("1"), skSyuunouKekkaDataLLst.get(0).getAnsyuusyskbn());
        assertEquals( BizDate.valueOf(20160503), skSyuunouKekkaDataLLst.get(0).getSyoriYmd());
        assertEquals("791112220", skSyuunouKekkaDataLLst.get(0).getMosno());
        assertEquals(BizDateYM.valueOf(201605), skSyuunouKekkaDataLLst.get(0).getJyuutouym());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_AnsyuusysKbn.valueOf("1"),BizDate.valueOf(20160504),"791112246",BizDateYM.valueOf(201605)), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("1"),BizDate.valueOf(20160505),"791112246",BizDateYM.valueOf(201605)), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("1"),BizDate.valueOf(20160506),"791112246",BizDateYM.valueOf(201605)), "1");

        List<HT_SkSyuunouKekkaData> skSyuunouKekkaDataLLst = sinkeiyakuDomManager.getSkSyuunouKekkaDatasByMosno(
            "791112246");

        for(HT_SkSyuunouKekkaData skSyuunouKekkaData:skSyuunouKekkaDataLLst){
            datamap.remove($(
                skSyuunouKekkaData.getAnsyuusyskbn(),
                skSyuunouKekkaData.getSyoriYmd(),
                skSyuunouKekkaData.getMosno(),
                skSyuunouKekkaData.getJyuutouym()));
        }

        assertEquals(3, skSyuunouKekkaDataLLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SkSyuunouKekkaData> skSyuunouKekkaDataLLst = sinkeiyakuDomManager.getSkSyuunouKekkaDatasByMosno(
            "");
        Assert.assertEquals(0, skSyuunouKekkaDataLLst.size());

    }
}
