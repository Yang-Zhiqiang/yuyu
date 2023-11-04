package yuyu.def.suuri.manager;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getHokenryouTmttkns メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getHokenryouTmttkns {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHokenryouTmttkns";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<IT_HokenryouTmttkn> hokenryouTmttkn = srCommonKinouDao.
            getHokenryouTmttkns("60806000011", BizDateYM.valueOf(201606));

        exNumericEquals(0, hokenryouTmttkn.size(), "取得件数");

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "60806000011");
        IT_KykKihon kykKihon2 = new IT_KykKihon("00", "17806000301");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getHokenryouTmttkns.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_HokenryouTmttkn").executeUpdate();
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        // HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        //IT_HokenryouTmttkn kykSyouhnHnkmae = hozenDomManager.
        //    getHokenryouTmttknBySyonoTmttkntaisyouym("60806000011", BizDateYM.valueOf(201606));
        //if (kykSyouhnHnkmae != null) {
        //    hozenDomManager.delete(kykSyouhnHnkmae);
        //}
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_HokenryouTmttkn> hokenryouTmttkn = srCommonKinouDao
            .getHokenryouTmttkns("17806000323", BizDateYM.valueOf(201606));

        Assert.assertEquals(0, hokenryouTmttkn.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_HokenryouTmttkn> hokenryouTmttkn = srCommonKinouDao
            .getHokenryouTmttkns("60806000011", BizDateYM.valueOf(201606));

        exNumericEquals(1, hokenryouTmttkn.size(), "取得件数");

        exStringEquals("01", hokenryouTmttkn.get(0).getKbnkey(), "区分キー");
        exStringEquals("60806000011", hokenryouTmttkn.get(0).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201605), hokenryouTmttkn.get(0).getTmttkntaisyouym(), "積立金対象年月");
        exNumericEquals(Integer.valueOf(1), hokenryouTmttkn.get(0).getRenno(), "連番");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_HokenryouTmttkn> hokenryouTmttkn = srCommonKinouDao
            .getHokenryouTmttkns("17806000301", BizDateYM.valueOf(201606));


        exNumericEquals(4, hokenryouTmttkn.size(), "取得件数");

        exStringEquals("00", hokenryouTmttkn.get(0).getKbnkey(), "区分キー");
        exStringEquals("17806000301", hokenryouTmttkn.get(0).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201606), hokenryouTmttkn.get(0).getTmttkntaisyouym(), "積立金対象年月");
        exNumericEquals(Integer.valueOf(5), hokenryouTmttkn.get(0).getRenno(), "連番");

        exStringEquals("00", hokenryouTmttkn.get(1).getKbnkey(), "区分キー");
        exStringEquals("17806000301", hokenryouTmttkn.get(1).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201606), hokenryouTmttkn.get(1).getTmttkntaisyouym(), "積立金対象年月");
        exNumericEquals(Integer.valueOf(4), hokenryouTmttkn.get(1).getRenno(), "連番");

        exStringEquals("00", hokenryouTmttkn.get(2).getKbnkey(), "区分キー");
        exStringEquals("17806000301", hokenryouTmttkn.get(2).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201605), hokenryouTmttkn.get(2).getTmttkntaisyouym(), "積立金対象年月");
        exNumericEquals(Integer.valueOf(7), hokenryouTmttkn.get(2).getRenno(), "連番");

        exStringEquals("00", hokenryouTmttkn.get(3).getKbnkey(), "区分キー");
        exStringEquals("17806000301", hokenryouTmttkn.get(3).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201604), hokenryouTmttkn.get(3).getTmttkntaisyouym(), "積立金対象年月");
        exNumericEquals(Integer.valueOf(7), hokenryouTmttkn.get(3).getRenno(), "連番");

    }


    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_HokenryouTmttkn> hokenryouTmttkn = srCommonKinouDao
            .getHokenryouTmttkns("", BizDateYM.valueOf(201606));

        Assert.assertEquals(0, hokenryouTmttkn.size());
    }
}
