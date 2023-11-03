package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.account.UpdImageAuthorityInBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 書類権限情報更新Webサービス {@link WSUpdImageAuthority#executeBizMain(WSUpdImageAuthorityRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class UpdImageAuthorityWebServiceTest {

    @Inject
    IwfAccountClient iwfAccountClient;

    @Test(expected=RuntimeException.class)
    @TestOrder(1)
    public void test_UpdImageAuthority_1_1() {
        UpdImageAuthorityInBean inBean = null;

        iwfAccountClient.execUpdImageAuthority(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_UpdImageAuthority_1_2() {
        String psImageauthid = null;
        String[] psTorikomisyoruicds = {"TRKMSRCD0001"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージ権限ＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void test_UpdImageAuthority_1_3() {
        String psImageauthid = "JunitTester1";
        String[] psTorikomisyoruicds =  null;

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：取込書類コード配列", outBean.getSyousaimsg());

        psImageauthid = "JunitTester1";
        psTorikomisyoruicds =  new String[]{""};

        inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);

        outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：取込書類コード配列", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(4)
    public void test_UpdImageAuthority_2_1() {
        String psImageauthid = "KRID000000000000000000000000019";
        String[] psTorikomisyoruicds =  {"TRKM00000000000000000000000001"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限ＩＤは30文字以内で入力してください。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(5)
    public void test_UpdImageAuthority_2_2() {
        String psImageauthid = "KRID00000000000000000000000001";
        String[] psTorikomisyoruicds =  {"TRKM000000000000000000000000019"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取込書類コードは30文字以内で入力してください。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(6)
    public void test_UpdImageAuthority_2_3() {
        String psImageauthid = "KRID00000000000000000000000001";
        String[] psTorikomisyoruicds =  {"TRKM00000000000000000000000001"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限更新正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(7)
    public void test_UpdImageAuthority_4_1() {
        String psImageauthid = "KENGENID0001";
        String[] psTorikomisyoruicds =  {"TRKMSRCD0001","TRKMSRCD0002"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限更新正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(8)
    public void test_UpdImageAuthority_4_2() {
        String psImageauthid = "KENGENID0001";
        String[] psTorikomisyoruicds =  {"TRKMSRCD0001"};

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);


        WSUpdImageAuthorityResponse outBean = iwfAccountClient.execUpdImageAuthority(inBean);


        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限更新正常終了しました。", outBean.getSyousaimsg());
    }

}
