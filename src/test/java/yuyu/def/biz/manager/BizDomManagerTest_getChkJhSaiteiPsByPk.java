package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 最低Ｐチェック<br />
 * 最低Ｐ事方書チェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhSaiteiPsByPk {


    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkJhSaiteiPsByPk";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";
    static String P_SYOUHNCD_04 = "SH04";
    static Integer P_SYOUHNSDNO = new Integer(10);
    static String P_SYOUHINBETUKEY_10000 = "10000";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_ChkJhSaiteiP> chkJhSaiteiPList = bizDomManager.getChkJhSaiteiPsByPk(P_SYOUHNCD_03, C_Channelcd.BLNK,
            C_Hrkkaisuu.BLNK, new Integer(17), new Integer(10), C_Tuukasyu.USD, P_SYOUHINBETUKEY_10000);

        Assert.assertEquals(0, chkJhSaiteiPList.size());

        insertTestData();
    }
    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiP());

    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkJhSaiteiPsByPk.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhSaiteiP> chkJhSaiteiPList = bizDomManager.getChkJhSaiteiPsByPk(P_SYOUHNCD_03, C_Channelcd.BLNK,
            C_Hrkkaisuu.BLNK, new Integer(20), new Integer(10), C_Tuukasyu.USD, P_SYOUHINBETUKEY_10000);

        Assert.assertEquals(0, chkJhSaiteiPList.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkJhSaiteiP> chkJhSaiteiPList = bizDomManager.getChkJhSaiteiPsByPk(P_SYOUHNCD_03, C_Channelcd.BLNK,
            C_Hrkkaisuu.BLNK, new Integer(17), new Integer(10), C_Tuukasyu.USD, P_SYOUHINBETUKEY_10000);

        Assert.assertEquals(1, chkJhSaiteiPList.size());

        Assert.assertEquals(P_SYOUHNCD_03, chkJhSaiteiPList.get(0).getSyouhncd());
        Assert.assertEquals(C_Hrkkaisuu.BLNK, chkJhSaiteiPList.get(0).getHrkkaisuu());
        Assert.assertEquals(BizNumber.valueOf(17), chkJhSaiteiPList.get(0).getHrkkknfrom());
        Assert.assertEquals(BizNumber.valueOf(17), chkJhSaiteiPList.get(0).getHrkkknto());
        Assert.assertEquals(new Integer(10), chkJhSaiteiPList.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(new Integer(10), chkJhSaiteiPList.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(C_Channelcd.BLNK, chkJhSaiteiPList.get(0).getChannelcd());
        Assert.assertEquals(C_Tuukasyu.USD, chkJhSaiteiPList.get(0).getTuukasyu());
        Assert.assertEquals(P_SYOUHINBETUKEY_10000, chkJhSaiteiPList.get(0).getSyouhinbetukey1());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkJhSaiteiP> chkJhSaiteiPList = bizDomManager.getChkJhSaiteiPsByPk("SH01", C_Channelcd.BLNK,
            C_Hrkkaisuu.BLNK, new Integer(17), new Integer(10), C_Tuukasyu.USD, P_SYOUHINBETUKEY_10000);

        Assert.assertEquals(5, chkJhSaiteiPList.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("SH01", "0", 17, 17, 9, 10, "00", "USD", "10000"), "1");
        map.put($("SH01", "0", 17, 17, 10, 10, "00", "USD", "10000"), "1");
        map.put($("SH01", "0", 17, 17, 10, 11, "00", "USD", "10000"), "1");
        map.put($("SH01", "0", 16, 17, 10, 10, "00", "USD", "10000"), "1");
        map.put($("SH01", "0", 17, 18, 10, 10, "00", "USD", "10000"), "1");

        for (BM_ChkJhSaiteiP chkJhSaiteiP : chkJhSaiteiPList) {
            map.remove($(chkJhSaiteiP.getSyouhncd(), chkJhSaiteiP.getHrkkaisuu(), chkJhSaiteiP.getHrkkknfrom(),
                chkJhSaiteiP.getHrkkknto(), chkJhSaiteiP.getSyusyouhnsdnofrom(), chkJhSaiteiP.getSyusyouhnsdnoto(),
                chkJhSaiteiP.getChannelcd(), chkJhSaiteiP.getTuukasyu(), chkJhSaiteiP.getSyouhinbetukey1()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_ChkJhSaiteiP> beans = bizDomManager.getChkJhSaiteiPsByPk("", C_Channelcd.BLNK, C_Hrkkaisuu.BLNK,
            new Integer(17), new Integer(10), C_Tuukasyu.USD, P_SYOUHINBETUKEY_10000);

        Assert.assertEquals(0, beans.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BM_ChkJhSaiteiP> beans = bizDomManager.getChkJhSaiteiPsByPk("SH01", C_Channelcd.BLNK, C_Hrkkaisuu.BLNK,
            new Integer(17), new Integer(10), C_Tuukasyu.USD, "");

        Assert.assertEquals(0, beans.size());
    }
}

