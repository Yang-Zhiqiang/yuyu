package yuyu.def.siharai.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 時効対象リスト作成<br />
 * 保険金給付金備金管理テーブルエンティティリスト（大量）取得　決算基準日、備金時効区分、備金例外区分指定<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx";

    private final static String sheetName = "INデータ";

    @Inject
    private SiharaiDomManager siharaiDomManager;


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate.valueOf(20200930),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiDomManagerTest_getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate.valueOf(20200630),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate.valueOf(20200930),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                siBikinkanri=iter.next();

                Assert.assertEquals("B001", siBikinkanri.getSkno());
                Assert.assertEquals("99806001319", siBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20200930), siBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20170401), siBikinkanri.getBknkktymd());
                Assert.assertEquals("A010", siBikinkanri.getKyuuhucd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<JT_SiBikinkanri> datalist = new ArrayList<>();
        datalist.add(new JT_SiBikinkanri("B009","99806001043",BizDate.valueOf(20201231),C_BkncdKbn.GENGK,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B008","99806001054",BizDate.valueOf(20201231),C_BkncdKbn.GENGK,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B007","99806001065",BizDate.valueOf(20201231),C_BkncdKbn.GENGK,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B006","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.KAIYAKU,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B005","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUKARIUKETUKE,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B004","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B003","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B002","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A001"));
        datalist.add(new JT_SiBikinkanri("B001","99806001010",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"9999"));

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate.valueOf(20201231),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;
            int iCount = 0;
            while(iter.hasNext()) {
                siBikinkanri=iter.next();

                Assert.assertEquals(datalist.get(iCount).getSkno(), siBikinkanri.getSkno());
                Assert.assertEquals(datalist.get(iCount).getSyono(), siBikinkanri.getSyono());
                Assert.assertEquals(datalist.get(iCount).getKessankijyunymd(), siBikinkanri.getKessankijyunymd());
                Assert.assertEquals(datalist.get(iCount).getBkncdkbn(), siBikinkanri.getBkncdkbn());
                Assert.assertEquals(datalist.get(iCount).getBknkktymd(), siBikinkanri.getBknkktymd());
                Assert.assertEquals(datalist.get(iCount).getKyuuhucd(), siBikinkanri.getKyuuhucd());

                iCount++;
            }

            Assert.assertEquals(9, iCount);
        }
    }
}
