package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouInBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouOutBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousai;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

/**
 * 前回処理結果取得（機能指定）Webサービス {@link WSGetKouteiRirekiSyousai#executeBizMain(WSGetKouteiRirekiSyousaiRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetLastRecordByKinouWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfKouteiClient.execGetLastRecordByKinou(null);
    }

    @Test
    public void testValidationNG02() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey(null);
        getLastRecordByKinouInBean.setFlowid(null);
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG03() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey(null);
        getLastRecordByKinouInBean.setFlowid("");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG04() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("");
        getLastRecordByKinouInBean.setFlowid(null);
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG05() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("");
        getLastRecordByKinouInBean.setFlowid("");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationNG06() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_6");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn("履歴区分");
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "区分値入力チェックエラー（項目[履歴区分]の値が不正です）", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testValidationOK01() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey(null);
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        //別件Junit実行のため、毎回内容を更新するため、下記結果判定ソースが不要になる。
        //        assertEquals("20160412155320320", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        //        assertEquals("業務キー3_3", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        //        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        //        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        //        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        //        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        //        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        //        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        //        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testValidationOK02() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        //別件Junit実行のため、毎回内容を更新するため、下記結果判定ソースが不要になる。
        //        assertEquals("20160310093828", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        //        assertEquals("業務キー3_3", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        //        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        //        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        //        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        //        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        //        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        //        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        //        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        //        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testValidationOK03() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_9");
        getLastRecordByKinouInBean.setFlowid(null);
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411150532", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー1_9", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testValidationOK04() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_10");
        getLastRecordByKinouInBean.setFlowid("");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411091200", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー1_10", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testValidationOK05() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_11");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId(null);
        getLastRecordByKinouInBean.setKinouSSId(null);
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411091200", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー1_11", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testValidationOK06() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_11");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("");
        getLastRecordByKinouInBean.setKinouSSId("");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411091200", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー1_11", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testValidationNG07() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー1_13");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn("2");
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "区分値入力チェックエラー（項目[履歴区分]の値が不正です）", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG01() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_1");
        getLastRecordByKinouInBean.setFlowid("無効なフローＩＤ");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2131", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG02() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("無効な業務キー");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("機能ＩＤ");
        getLastRecordByKinouInBean.setKinouSSId("機能詳細ＩＤ");
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2132", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーが取得できませんでした。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistNG03() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("");
        getLastRecordByKinouInBean.setKinouSSId("");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(1);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2130", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals(null, getLastRecordByKinouOutBean.getProcessRecordBean());

    }

    @Test
    public void testInfoExistOK01() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_4");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411091151", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_4", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }

    @Test
    public void testInfoExistOK02() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_5");
        getLastRecordByKinouInBean.setFlowid("12");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("KINOUID01");
        getLastRecordByKinouInBean.setKinouSSId("");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160310090127", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_5", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("KINOUID01-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査１回目", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testInfoExistOK03() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_6");
        getLastRecordByKinouInBean.setFlowid("12");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("");
        getLastRecordByKinouInBean.setKinouSSId("KINOUID01");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160310090127", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_6", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("check1-KINOUID01", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査２回目", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testInfoExistOK04() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_7");
        getLastRecordByKinouInBean.setFlowid("12");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("KINOUID02");
        getLastRecordByKinouInBean.setKinouSSId("check2");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160310090127", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_7", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("KINOUID02-check2", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査３回目", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testInfoExistOK05() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_8");
        getLastRecordByKinouInBean.setFlowid("12");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("");
        getLastRecordByKinouInBean.setKinouSSId("");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160310090128", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_8", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("KINOUID01-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査１回目", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程中断", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testInfoExistOK06() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー2_8");
        getLastRecordByKinouInBean.setFlowid("12");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.GYOUMU.toString());
        getLastRecordByKinouInBean.setKinouId("");
        getLastRecordByKinouInBean.setKinouSSId("");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160310090128", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー2_8", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("12", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("workflowcore", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("check1-KINOUID01", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("審査２回目", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("Tt", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.GYOUMU.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程情報更新", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());
        assertEquals("付加情報", getLastRecordByKinouOutBean.getProcessRecordBean().getExtinfo().get(0).get("extinfo"));

    }

    @Test
    public void testSyoriLogicOK01() {
        GetLastRecordByKinouInBean getLastRecordByKinouInBean = new GetLastRecordByKinouInBean();
        getLastRecordByKinouInBean.setGyoumukey("業務キー3_1");
        getLastRecordByKinouInBean.setFlowid("09");
        getLastRecordByKinouInBean.setRirekikbn(C_RirekiKbn.SYSTEM.toString());
        getLastRecordByKinouInBean.setKinouId("torikesi");
        getLastRecordByKinouInBean.setKinouSSId("check1");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(10000);
        GetLastRecordByKinouOutBean getLastRecordByKinouOutBean = iwfKouteiClient.execGetLastRecordByKinou(getLastRecordByKinouInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getLastRecordByKinouOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getLastRecordByKinouOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", getLastRecordByKinouOutBean.getSyousaimsg());
        assertEquals("20160411131050", getLastRecordByKinouOutBean.getProcessRecordBean().getSyoriTime());
        assertEquals("業務キー3_1", getLastRecordByKinouOutBean.getProcessRecordBean().getGyoumukey());
        assertEquals("09", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowId());
        assertEquals("施設申込取消@20150708", getLastRecordByKinouOutBean.getProcessRecordBean().getFlowName());
        assertEquals("torikesi-check1", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeName());
        assertEquals("施設申込取消（書類審査１次）", getLastRecordByKinouOutBean.getProcessRecordBean().getNodeLocalName());
        assertEquals("administrator", getLastRecordByKinouOutBean.getProcessRecordBean().getAccountId());
        assertEquals(C_RirekiKbn.SYSTEM.toString(), getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiKbn());
        assertEquals("工程開始", getLastRecordByKinouOutBean.getProcessRecordBean().getRirekiMessage());

    }
}
