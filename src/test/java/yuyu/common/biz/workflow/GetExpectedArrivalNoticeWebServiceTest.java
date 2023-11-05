package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 到着予定通知取得Webサービスのゲットメソッド {@link WSCreateExpectedArrivalNotice(WSGetExpectedArrivalNoticeRequest} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetExpectedArrivalNoticeWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    private static String arriveKey = null;

    @Test
    @TestOrder(1)
    public void testOK() {
        try {

            String psArrivekey = "Tt-20150709";

            GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

            inBean.setArrivekey(psArrivekey);

            GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

            assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(1)
    public void testWARN() {
        try {

            String psArrivekey = "Tt-20150713";

            GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

            inBean.setArrivekey(psArrivekey);

            GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

            assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test(expected = RuntimeException.class)
    @TestOrder(2)
    public void test_GetExpectedArrivalNotice_01() {
        GetExpectedArrivalNoticeInBean inBean = null;

        iwfImageClient.GetExpectedArrivalNotice(inBean);
    }

    @Test
    @TestOrder(3)
    public void test_GetExpectedArrivalNotice_02() {

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(null);
        inBean.setGyoumukey("テスト02");
        inBean.setFlowid("テスト02");
        inBean.setTorikomisyoruicd("テスト02");
        inBean.setSubsystemid("テスト02");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0002", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(4)
    public void test_GetExpectedArrivalNotice_03() {

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey("");
        inBean.setGyoumukey("テスト03");
        inBean.setFlowid("テスト03");
        inBean.setTorikomisyoruicd("テスト03");
        inBean.setSubsystemid("テスト03");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0002", ouBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(5)
    public void test_GetExpectedArrivalNotice_04() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey(null);

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(6)
    public void test_GetExpectedArrivalNotice_05() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey("");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(7)
    public void test_GetExpectedArrivalNotice_06() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setTorikomisyoruicd(null);

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(8)
    public void test_GetExpectedArrivalNotice_07() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setTorikomisyoruicd("");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(9)
    public void test_GetExpectedArrivalNotice_08() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setFlowid(null);

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(10)
    public void test_GetExpectedArrivalNotice_09() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setFlowid("");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(11)
    public void test_GetExpectedArrivalNotice_10() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setSubsystemid(null);

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(12)
    public void test_GetExpectedArrivalNotice_11() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setSubsystemid("");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(13)
    public void test_GetExpectedArrivalNotice_12() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(14)
    public void test_GetExpectedArrivalNotice_13() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey + "一");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(15)
    public void test_GetExpectedArrivalNotice_14() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(16)
    public void test_GetExpectedArrivalNotice_15() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(17)
    public void test_GetExpectedArrivalNotice_16() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setTorikomisyoruicd("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(18)
    public void test_GetExpectedArrivalNotice_17() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setTorikomisyoruicd("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(19)
    public void test_GetExpectedArrivalNotice_18() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(20)
    public void test_GetExpectedArrivalNotice_19() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九十");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(21)
    public void test_GetExpectedArrivalNotice_20() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setSubsystemid("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(22)
    public void test_GetExpectedArrivalNotice_21() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setSubsystemid("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(23)
    public void test_GetExpectedArrivalNotice_22() {

        _createTestData();

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey(arriveKey);
        inBean.setTorikomisyoruicd("到着予定取得");
        inBean.setFlowid("到着予定取得");
        inBean.setSubsystemid("到着予定取得");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), ouBean.getKekkastatus());
        assertEquals("IWF0000", ouBean.getSyousaimsgcd());

    }

    @Test
    @TestOrder(24)
    public void test_GetExpectedArrivalNotice_23() {

        GetExpectedArrivalNoticeInBean inBean = new GetExpectedArrivalNoticeInBean();

        inBean.setArrivekey("NoData");

        GetExpectedArrivalNoticeOutBean ouBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.WARN.toString(), ouBean.getKekkastatus());
        assertEquals("IWF3081", ouBean.getSyousaimsgcd());

    }

    public void _createTestData() {

        arriveKey = BizDate.getSysDateTimeMilli()+"一二三";

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(arriveKey);
        inBean.setGyoumukey(arriveKey);
        inBean.setTorikomisyoruicd("到着予定取得");
        inBean.setFlowid("到着予定取得");
        inBean.setSubsystemid("到着予定取得");

        iwfImageClient.CreateExpectedArrivalNotice(inBean);
    }

}
