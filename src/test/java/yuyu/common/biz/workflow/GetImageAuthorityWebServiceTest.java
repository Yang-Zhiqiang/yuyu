package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.account.GetImageAuthorityInBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 書類権限情報取得Webサービス {@link WSGetImageAuthority#executeBizMain(WSGetImageAuthorityRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetImageAuthorityWebServiceTest {

    @Inject
    IwfAccountClient iwfAccountClient;

    @Test(expected=RuntimeException.class)
    @TestOrder(1)
    public void test_GetImageAuthority_1_1() {
        GetImageAuthorityInBean inBean = null;

        iwfAccountClient.execGetImageAuthority(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_GetImageAuthority_1_2() {
        String psImageauthid = null;

        GetImageAuthorityInBean inBean = new GetImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);

        WSGetImageAuthorityResponse outBean = iwfAccountClient.execGetImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージ権限ＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void test_GetImageAuthority_4_1() {
        String psImageauthid = "ADMIN_NO_DATA";

        GetImageAuthorityInBean inBean = new GetImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);

        WSGetImageAuthorityResponse outBean = iwfAccountClient.execGetImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4040", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定された書類権限情報は存在しません。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(4)
    public void test_GetImageAuthority_4_2() {
        String psImageauthid = "KRID00000000000000000000000001";

        GetImageAuthorityInBean inBean = new GetImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);

        WSGetImageAuthorityResponse outBean = iwfAccountClient.execGetImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類権限情報取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("件数", 1, outBean.getTorikomiSyoruiCds().length);
    }

    @Test
    @TestOrder(5)
    public void test_GetImageAuthority_4_3() {
        String psImageauthid = "KENGENID0001";

        GetImageAuthorityInBean inBean = new GetImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);

        WSGetImageAuthorityResponse outBean = iwfAccountClient.execGetImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類権限情報取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("件数", 2, outBean.getTorikomiSyoruiCds().length);
    }

}
