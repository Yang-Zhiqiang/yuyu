package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd extends AbstractTest {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    BizDomManager bizDomManager;

    public final static long version=1L;
    public final static String pBosyuusosikicd100="100";
    public final static String pBosyuusosikicd104="104";

    public final static String pSeirekinen2keta10="10";
    public final static String pSeirekinen2keta13="13";
	public final static String pSeirekinen2keta15="15";

    private final static String fileName = "UT-SP_単体テスト仕様書（Manager）_getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        Integer result = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta10,pBosyuusosikicd100);
        Assert.assertNull(result);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyonokanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void noResult1() {

    	
        Integer result1 = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta10,pBosyuusosikicd104);
        Assert.assertNull(result1);

    	
    	Integer result2 = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta15,pBosyuusosikicd100);
        Assert.assertNull(result2);

    	
    	Integer result3 = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta15,pBosyuusosikicd100);
        Assert.assertNull(result3);
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        Integer result = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta13,pBosyuusosikicd100);
        Assert.assertEquals(Integer.valueOf(10003), result);
    }

    @Test
    @TestOrder(40)
    public void noResult2() {
        Integer result = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd("","");
        Assert.assertNull(result);
    }

}
