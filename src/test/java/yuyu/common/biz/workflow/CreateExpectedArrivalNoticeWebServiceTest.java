package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 到着予定通知作成Webサービスのゲットメソッド {@link WSCreateExpectedArrivalNotice(WSCreateExpectedArrivalNoticeRequest} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreateExpectedArrivalNoticeWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @TestOrder(0)
    public void testOK() {
        try {

            String psArrivekey = "Tt-20150709";
            String psGyoumukey = "tt1";
            String psSyoruicd = "AB0000101";
            String psFlowid = "09";
            String psSubsystemid = "sub@01";

            CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

            inBean.setArrivekey(psArrivekey);
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setTorikomisyoruicd(psSyoruicd);
            inBean.setSubsystemid(psSubsystemid);

            WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(response.getKekkastatus());

            assertTrue(result);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void test_CreateExpectedArrivalNotice_01() {

        CreateExpectedArrivalNoticeInBean inBean = null;

        iwfImageClient.CreateExpectedArrivalNotice(inBean);

    }

    @Test
    @TestOrder(2)
    public void test_CreateExpectedArrivalNotice_02() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(null);
        inBean.setGyoumukey("テスト02");
        inBean.setFlowid("テスト02");
        inBean.setTorikomisyoruicd("テスト02");
        inBean.setSubsystemid("テスト02");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(3)
    public void test_CreateExpectedArrivalNotice_03() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("");
        inBean.setGyoumukey("テスト03");
        inBean.setFlowid("テスト03");
        inBean.setTorikomisyoruicd("テスト03");
        inBean.setSubsystemid("テスト03");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(4)
    public void test_CreateExpectedArrivalNotice_04() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト04");
        inBean.setGyoumukey(null);
        inBean.setFlowid("テスト04");
        inBean.setTorikomisyoruicd("テスト04");
        inBean.setSubsystemid("テスト04");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(5)
    public void test_CreateExpectedArrivalNotice_05() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト05");
        inBean.setGyoumukey("");
        inBean.setFlowid("テスト05");
        inBean.setTorikomisyoruicd("テスト05");
        inBean.setSubsystemid("テスト05");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(6)
    public void test_CreateExpectedArrivalNotice_06() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト06");
        inBean.setGyoumukey("テスト06");
        inBean.setTorikomisyoruicd(null);
        inBean.setFlowid("テスト06");
        inBean.setSubsystemid("テスト06");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(7)
    public void test_CreateExpectedArrivalNotice_07() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト07");
        inBean.setGyoumukey("テスト07");
        inBean.setTorikomisyoruicd("");
        inBean.setFlowid("テスト07");
        inBean.setSubsystemid("テスト07");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(8)
    public void test_CreateExpectedArrivalNotice_08() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト08");
        inBean.setGyoumukey("テスト08");
        inBean.setTorikomisyoruicd("テスト08");
        inBean.setFlowid(null);
        inBean.setSubsystemid("テスト08");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(9)
    public void test_CreateExpectedArrivalNotice_09() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト09");
        inBean.setGyoumukey("テスト09");
        inBean.setTorikomisyoruicd("テスト09");
        inBean.setFlowid("");
        inBean.setSubsystemid("テスト09");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(10)
    public void test_CreateExpectedArrivalNotice_10() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト10");
        inBean.setGyoumukey("テスト10");
        inBean.setTorikomisyoruicd("テスト10");
        inBean.setFlowid("テスト10");
        inBean.setSubsystemid(null);

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());
    }

    @Test
    @TestOrder(11)
    public void test_CreateExpectedArrivalNotice_11() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト11");
        inBean.setGyoumukey("テスト11");
        inBean.setTorikomisyoruicd("テスト11");
        inBean.setFlowid("テスト11");
        inBean.setSubsystemid("");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0002", response.getSyousaimsgcd());
    }

    @Test
    @TestOrder(12)
    public void test_CreateExpectedArrivalNotice_12() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
        inBean.setGyoumukey("テスト12");
        inBean.setTorikomisyoruicd("テスト12");
        inBean.setFlowid("テスト12");
        inBean.setSubsystemid("テスト12");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(13)
    public void test_CreateExpectedArrivalNotice_13() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");
        inBean.setGyoumukey("テスト13");
        inBean.setTorikomisyoruicd("テスト13");
        inBean.setFlowid("テスト13");
        inBean.setSubsystemid("テスト13");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(14)
    public void test_CreateExpectedArrivalNotice_14() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli()+"一二三");
        inBean.setTorikomisyoruicd("テスト14");
        inBean.setFlowid("テスト14");
        inBean.setSubsystemid("テスト14");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(15)
    public void test_CreateExpectedArrivalNotice_15() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト15");
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli()+"八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");
        inBean.setTorikomisyoruicd("テスト15");
        inBean.setFlowid("テスト15");
        inBean.setSubsystemid("テスト15");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(16)
    public void test_CreateExpectedArrivalNotice_16() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setTorikomisyoruicd("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
        inBean.setFlowid("テスト16");
        inBean.setSubsystemid("テスト16");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(17)
    public void test_CreateExpectedArrivalNotice_17() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト17");
        inBean.setGyoumukey("テスト17");
        inBean.setTorikomisyoruicd("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");
        inBean.setFlowid("テスト17");
        inBean.setSubsystemid("テスト17");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(18)
    public void test_CreateExpectedArrivalNotice_18() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setTorikomisyoruicd("テスト18");
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九");
        inBean.setSubsystemid("テスト18");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(19)
    public void test_CreateExpectedArrivalNotice_19() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト19");
        inBean.setGyoumukey("テスト19");
        inBean.setTorikomisyoruicd("テスト19");
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九十");
        inBean.setSubsystemid("テスト19");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(20)
    public void test_CreateExpectedArrivalNotice_20() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setTorikomisyoruicd("テスト20");
        inBean.setFlowid("テスト20");
        inBean.setSubsystemid("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(21)
    public void test_CreateExpectedArrivalNotice_21() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey("テスト21");
        inBean.setGyoumukey("テスト21");
        inBean.setTorikomisyoruicd("テスト21");
        inBean.setFlowid("テスト21");
        inBean.setSubsystemid("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF0008", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(22)
    public void test_CreateExpectedArrivalNotice_22() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setTorikomisyoruicd("１２３４５６７８９０");
        inBean.setFlowid("１２３４５６７８９０");
        inBean.setSubsystemid("１２３４５６７８９０");

        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("IWF0000", response.getSyousaimsgcd());

    }

    @Test
    @TestOrder(23)
    public void test_CreateExpectedArrivalNotice_23() {

        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();

        inBean.setArrivekey(BizDate.getSysDateTimeMilli());
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setTorikomisyoruicd("１２３４５６７８９０");
        inBean.setFlowid("１２３４５６７８９０");
        inBean.setSubsystemid("１２３４５６７８９０");

        iwfImageClient.CreateExpectedArrivalNotice(inBean);
        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        assertEquals(C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("IWF3080", response.getSyousaimsgcd());

    }

}
