package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMst;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * 取込書類マスタ取得Webサービス {@link WSGetTorikomiSyoruiMst#executeBizMain(WSGetTorikomiSyoruiMstRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTorikomiSyoruiMstWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @Test(expected = RuntimeException.class)
    public void test_GetTorikomiSyoruiMst_01() {

        iwfImageClient.execGetTorikomiSyoruiMst(null);
    }

    @Test
    public void test_GetTorikomiSyoruiMst_02() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setTorikomisyoruicd(null);

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_03() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setTorikomisyoruicd("");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_04() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzkdaibunruiid(null);

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_05() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzkdaibunruiid("");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_06() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzksyoubunruiid(null);

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_07() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzksyoubunruiid("");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_08() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setFlowid(null);

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_09() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setFlowid("");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_10() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setNodeid(null);

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_11() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setNodeid("");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_12() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertTrue(response.getTorikomisyoruilist().size() > 1);
    }

    @Test
    public void test_GetTorikomiSyoruiMst_13() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzkdaibunruiid("torikomi");
        inBean.setSyzksyoubunruiid("torikomi");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertTrue(response.getTorikomisyoruilist().size() > 1);
    }

    @Test
    public void test_GetTorikomiSyoruiMst_14() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setTorikomisyoruicd("torikomi");
        inBean.setSyzkdaibunruiid("torikomi");
        inBean.setSyzksyoubunruiid("torikomi");
        inBean.setFlowid("torikomi");
        inBean.setNodeid("torikomi");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals(1, response.getTorikomisyoruilist().size());

    }

    @Test
    public void test_GetTorikomiSyoruiMst_15() {

        GetTorikomiSyoruiMstInBean inBean = new GetTorikomiSyoruiMstInBean();
        inBean.setSyzkdaibunruiid("torikomi_nasi");

        WSGetTorikomiSyoruiMstResponse response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", response.getSyousaimsgcd());
        assertEquals(null, response.getTorikomisyoruilist());

    }

}
