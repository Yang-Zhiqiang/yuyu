package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.junit.AfterClass;
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
 * 保険金給付金備金管理テーブルエンティティリスト取得　証券番号、決算基準日、備金時効区分、備金例外区分指定<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe";

    private final static String sheetName = "INデータ";

    @Inject
    private SiharaiDomManager siharaiDomManager;


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> siBikinkanris =
            siharaiDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(
                "99806056102",BizDate.valueOf(20201231),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL);
        assertEquals(0, siBikinkanris.size());
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiDomManagerTest_getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe.class,
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
    public void noResult() {

        siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> siBikinkanris =
            siharaiDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(
                "99806056102",BizDate.valueOf(20201231),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL);
        assertEquals(0, siBikinkanris.size());


    }

    @Test
    @TestOrder(20)
    public void normal1() {


        siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> siBikinkanris =
            siharaiDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(
                "99806001010",BizDate.valueOf(20201231),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL);


        for(JT_SiBikinkanri siBikinkanri: siBikinkanris){

            assertEquals("B004", siBikinkanri.getSkno());
            assertEquals("99806001010", siBikinkanri.getSyono());
            assertEquals(BizDate.valueOf(20201231), siBikinkanri.getKessankijyunymd());
            assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
            assertEquals(BizDate.valueOf(20170401), siBikinkanri.getBknkktymd());
            assertEquals("A010", siBikinkanri.getKyuuhucd());
        }

        assertEquals(1, siBikinkanris.size());

    }

    @Test
    @TestOrder(30)
    public void norma3() {

        Set<String> dataSet = new HashSet<>();
        dataSet.add($("B005","99806001065",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A010"));
        dataSet.add($("B006","99806001065",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A010"));
        dataSet.add($("B007","99806001065",BizDate.valueOf(20201231),C_BkncdKbn.SIBOUUKETUKE,BizDate.valueOf(20170401),"A010"));

        siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> siBikinkanris =
            siharaiDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(
                "99806001065",BizDate.valueOf(20201231),C_BknJkuKbn.SAISAISAIBI,C_BknrigiKbn.DEL);
        for(JT_SiBikinkanri siBikinkanri: siBikinkanris){
            dataSet.remove(
                $(siBikinkanri.getSkno(),
                    siBikinkanri.getSyono(),
                    siBikinkanri.getKessankijyunymd(),
                    siBikinkanri.getBkncdkbn(),
                    siBikinkanri.getBknkktymd(),
                    siBikinkanri.getKyuuhucd()));
        }

        assertEquals(3, siBikinkanris.size());
        assertEquals(0, dataSet.size());


    }
}
