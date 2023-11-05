package yuyu.def.db.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhLincSousinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全ＬＩＮＣ送信データテーブルエンティティリストのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKhLincSousinDatas {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getKhLincSousinDatas";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");

        if (kykKihon == null) {

            kykKihon = new IT_KykKihon("99806001010");

            List<IT_KhLincSousinData> KhLincSousinDataLst = kykKihon.getKhLincSousinDatas(BizDate.valueOf(20200101));

            Assert.assertEquals(0, KhLincSousinDataLst.size());
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_KykKihonTest_getKhLincSousinDatas.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");

        List<IT_KhLincSousinData> KhLincSousinDataLst = kykKihon.getKhLincSousinDatas(BizDate.valueOf(20201217));

        Assert.assertEquals(0, KhLincSousinDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");

        List<IT_KhLincSousinData> KhLincSousinDataLst = kykKihon.getKhLincSousinDatas(BizDate.valueOf(20201217));

        SortIT_KhLincSousinData khLincSousinDataSort = SWAKInjector.getInstance(SortIT_KhLincSousinData.class);
        KhLincSousinDataLst = khLincSousinDataSort.OrderIT_KhLincSousinDataByPkDesc(KhLincSousinDataLst);

        Assert.assertEquals(1, KhLincSousinDataLst.size());

        Assert.assertEquals("99806001021", KhLincSousinDataLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20201217), KhLincSousinDataLst.get(0).getSyoriYmd());
        Assert.assertEquals(1, KhLincSousinDataLst.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");

        List<IT_KhLincSousinData> KhLincSousinDataLst = kykKihon.getKhLincSousinDatas(BizDate.valueOf(20201218));
        SortIT_KhLincSousinData khLincSousinDataSort = SWAKInjector.getInstance(SortIT_KhLincSousinData.class);
        KhLincSousinDataLst = khLincSousinDataSort.OrderIT_KhLincSousinDataByPkDesc(KhLincSousinDataLst);

        Assert.assertEquals(3, KhLincSousinDataLst.size());

        Assert.assertEquals("99806001032", KhLincSousinDataLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20201218), KhLincSousinDataLst.get(0).getSyoriYmd());
        Assert.assertEquals(3, KhLincSousinDataLst.get(0).getRenno().intValue());

        Assert.assertEquals("99806001032", KhLincSousinDataLst.get(1).getSyono());
        Assert.assertEquals(BizDate.valueOf(20201218), KhLincSousinDataLst.get(1).getSyoriYmd());
        Assert.assertEquals(2, KhLincSousinDataLst.get(1).getRenno().intValue());

        Assert.assertEquals("99806001032", KhLincSousinDataLst.get(2).getSyono());
        Assert.assertEquals(BizDate.valueOf(20201218), KhLincSousinDataLst.get(2).getSyoriYmd());
        Assert.assertEquals(1, KhLincSousinDataLst.get(2).getRenno().intValue());

    }
}
