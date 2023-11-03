package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetLastRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousai;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;

/**
 * 前回処理結果取得Webサービス {@link WSGetKouteiRirekiSyousai#executeBizMain(WSGetKouteiRirekiSyousaiRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetLastRecordWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfKouteiClient.execGetLastRecord(null);
    }

    @Test
    public void testValidationNG02() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey(null);
        getLastRecordInBean.setFlowid(null);
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG03() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey(null);
        getLastRecordInBean.setFlowid("");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG04() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("");
        getLastRecordInBean.setFlowid(null);
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG05() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("");
        getLastRecordInBean.setFlowid("");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG06() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー1_6");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn("履歴区分");
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "区分値入力チェックエラー（項目[履歴区分]の値が不正です）", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationOK01() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey(null);
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160308114740", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_4", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("administrator", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testValidationOK02() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160308114740", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_4", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("administrator", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testValidationOK03() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー2_3");
        getLastRecordInBean.setFlowid(null);
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160304085749", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_3", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testValidationOK04() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー2_3");
        getLastRecordInBean.setFlowid("");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160304085749", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_3", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testValidationNG07() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー1_11");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn("2");
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "区分値入力チェックエラー（項目[履歴区分]の値が不正です）", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG01() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー2_1");
        getLastRecordInBean.setFlowid("無効なフローＩＤ");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2131", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG02() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("無効な業務キー");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2132", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーが取得できませんでした。", getLastRecordOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG03() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(1);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2130", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals(null, getLastRecordOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistOK01() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー2_4");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160308114740", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_4", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("administrator", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testInfoExistOK02() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー2_8");
        getLastRecordInBean.setFlowid("12");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.GYOUMU.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160310090128", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_8", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("check1-KINOUID01", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査２回目", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.GYOUMU.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testSyoriLogicOK01() {
        GetLastRecordInBean getLastRecordInBean = new GetLastRecordInBean();
        getLastRecordInBean.setGyoumukey("業務キー3_1");
        getLastRecordInBean.setFlowid("09");
        getLastRecordInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordOutBean getLastRecordOutBean = iwfKouteiClient.execGetLastRecord(getLastRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordOutBean.getSyousaimsg());
        assertEquals("20160308114740", getLastRecordOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー3_1", getLastRecordOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("administrator", getLastRecordOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }
}
