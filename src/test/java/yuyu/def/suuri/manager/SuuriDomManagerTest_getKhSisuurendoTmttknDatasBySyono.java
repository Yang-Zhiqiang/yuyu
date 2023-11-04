package  yuyu.def.suuri.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getKhSisuurendoTmttknDatasBySyono メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKhSisuurendoTmttknDatasBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhSisuurendoTmttknDatasBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setKbnkey("01");
        kykKihon.setSyono("11807111118");
        hozenDomManager.insert(kykKihon);

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao.getKhSisuurendoTmttknDatasBySyono("11807111118");

        Assert.assertEquals(0,khSisuurendoTmttknLst.size());
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getKhSisuurendoTmttknDatasBySyono.class,
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

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao.getKhSisuurendoTmttknDatasBySyono("11807111370");
        Assert.assertEquals(0,khSisuurendoTmttknLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao.getKhSisuurendoTmttknDatasBySyono("11807111118");

        Assert.assertEquals(1, khSisuurendoTmttknLst.size());

        Assert.assertEquals("01", khSisuurendoTmttknLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khSisuurendoTmttknLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201101), khSisuurendoTmttknLst.get(0).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(20), khSisuurendoTmttknLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao.getKhSisuurendoTmttknDatasBySyono("11807111129");

        Assert.assertEquals(5,khSisuurendoTmttknLst.size());

        Assert.assertEquals("02", khSisuurendoTmttknLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", khSisuurendoTmttknLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201106), khSisuurendoTmttknLst.get(0).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(3), khSisuurendoTmttknLst.get(0).getRenno());

        Assert.assertEquals("02", khSisuurendoTmttknLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", khSisuurendoTmttknLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201102), khSisuurendoTmttknLst.get(1).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(2), khSisuurendoTmttknLst.get(1).getRenno());

        Assert.assertEquals("02", khSisuurendoTmttknLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", khSisuurendoTmttknLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201101), khSisuurendoTmttknLst.get(2).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(1), khSisuurendoTmttknLst.get(2).getRenno());

        Assert.assertEquals("02", khSisuurendoTmttknLst.get(3).getKbnkey());
        Assert.assertEquals("11807111129", khSisuurendoTmttknLst.get(3).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201104), khSisuurendoTmttknLst.get(3).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(2), khSisuurendoTmttknLst.get(3).getRenno());

        Assert.assertEquals("02", khSisuurendoTmttknLst.get(4).getKbnkey());
        Assert.assertEquals("11807111129", khSisuurendoTmttknLst.get(4).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201105), khSisuurendoTmttknLst.get(4).getTmttkntaisyouym());
        Assert.assertEquals(Integer.valueOf(3), khSisuurendoTmttknLst.get(4).getRenno());
    }
}
