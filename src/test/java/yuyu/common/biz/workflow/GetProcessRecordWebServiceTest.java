package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousai;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;

/**
 * 工程履歴取得取得Webサービス {@link WSGetKouteiRirekiSyousai#executeBizMain(WSGetKouteiRirekiSyousaiRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetProcessRecordWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetProcessRecord_1_1() {

        iwfKouteiClient.execGetProcessRecord(null);
    }

    @Test
    public void test_GetProcessRecord_1_2() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キーまたはフローＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetProcessRecord_1_3() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setFlowid("98");

        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2131", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetProcessRecord_1_4() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setGyoumukey("GKID000000000099996");

        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2132", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーが取得できませんでした。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetProcessRecord_1_5() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setGyoumukey("GKID00000000000007");
        inBean.setRirekikbn("3");

        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "区分値入力チェックエラー（項目[履歴区分]の値が不正です）", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetProcessRecord_2_1() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setFlowid("09");
        inBean.setGyoumukey("GKID000000000000005");
        inBean.setRirekikbn("1");

        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);


        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("取得件数:", true, outBean.getProcessRecordBeanList().size() >= 1);

        ProcessRecordBean dateBean = outBean.getProcessRecordBeanList().get(0);

        assertEquals("処理日時:", "20150324184805", dateBean.getSyoriTime());
        assertEquals("業務キー:", "GKID000000000000005", dateBean.getGyoumukey());
        assertEquals("フローID:", "09", dateBean.getFlowId());
        assertEquals("フロー名:", "施設申込取消@20150708", dateBean.getFlowName());
        assertEquals("ノード名:", "torikesi-check1", dateBean.getNodeName());
        assertEquals("ノード表示名:", "施設申込取消（書類審査１次）", dateBean.getNodeLocalName());
        assertEquals("アカウントID:", "Tt", dateBean.getAccountId());
        assertEquals("処理区分:", "08", dateBean.getSyoriKbn());
        assertEquals("履歴区分:", "1", dateBean.getRirekiKbn());
        assertEquals("履歴メッセージ:", "工程を開始しました。", dateBean.getRirekiMessage());
        assertEquals("付加情報:", "付加情報", String.valueOf(dateBean.getExtinfo().get(0).get("extinfo")));

    }

    @Test
    public void test_GetProcessRecord_2_2() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setGyoumukey("GKID000000000000007");
        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);


        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("取得件数:", true, outBean.getProcessRecordBeanList().size() >= 1);

        ProcessRecordBean dateBean = outBean.getProcessRecordBeanList().get(0);

        assertEquals("処理日時:", "20150724154654", dateBean.getSyoriTime());
        assertEquals("業務キー:", "GKID000000000000007", dateBean.getGyoumukey());
        assertEquals("フローID:", "09", dateBean.getFlowId());
        assertEquals("フロー名:", "施設申込取消@20150708", dateBean.getFlowName());
        assertEquals("ノード名:", "torikesi-check1", dateBean.getNodeName());
        assertEquals("ノード表示名:", "施設申込取消（書類審査１次）", dateBean.getNodeLocalName());
        assertEquals("アカウントID:", "ACID00000000000000000000000001", dateBean.getAccountId());
        assertEquals("処理区分:", "08", dateBean.getSyoriKbn());
        assertEquals("履歴区分:", "0", dateBean.getRirekiKbn());
        assertEquals("履歴メッセージ:", "工程開始", dateBean.getRirekiMessage());
        String extingfo = "";
        for(Map<String,String> map :dateBean.getExtinfo()){
            extingfo = extingfo + map.get("extinfo");
        }
        assertEquals("付加情報:", "付加情報1", extingfo);

    }

    @Test
    public void test_GetProcessRecord_3_1() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setFlowid("09");
        inBean.setGyoumukey("GKID000000000000007");
        inBean.setRirekikbn("1");
        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);


        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("取得件数:", 0, outBean.getProcessRecordBeanList().size());

    }

    @Test
    public void test_GetProcessRecord_3_2() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setFlowid("09");
        inBean.setGyoumukey("GKID000000000000005");
        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);


        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴詳細取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("取得件数:", true, outBean.getProcessRecordBeanList().size() >= 2);

    }

    @Test
    public void test_GetProcessRecord_3_3() {

        GetProcessRecordInBean inBean = new GetProcessRecordInBean();

        inBean.setFlowid("09");
        inBean.setGyoumukey("GKID000000000000005");
        IwfCoreConfig.getInstance().setMaxKouteiRirekiKensu(1);
        GetProcessRecordOutBean outBean = iwfKouteiClient.execGetProcessRecord(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2130", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "このサービスの最大取得件数を超えました。（最大取得件数=1, 取得件数=2）", outBean.getSyousaimsg());

    }
}
