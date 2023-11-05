package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.account.DelImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.UpdImageAuthorityInBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 書類権限情報削除Webサービス {@link WSDelImageAuthority#executeBizMain(WSDelImageAuthorityRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class DelImageAuthorityWebServiceTest {

    @Inject
    IwfAccountClient iwfAccountClient;

    @Test(expected=RuntimeException.class)
    @TestOrder(1)
    public void test_DelImageAuthority_1_1() {
        DelImageAuthorityInBean inBean = null;

        iwfAccountClient.execDelImageAuthority(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_DelImageAuthority_1_2() {
        String[] psImageauthids = null;

        DelImageAuthorityInBean inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(psImageauthids);

        WSDelImageAuthorityResponse outBean = iwfAccountClient.execDelImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：イメージ権限ＩＤ", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(3)
    public void test_DelImageAuthority_1_3() {
        String[] psImageauthids = {"AAA",null,"BBB"};

        DelImageAuthorityInBean inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(psImageauthids);

        WSDelImageAuthorityResponse outBean = iwfAccountClient.execDelImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0001", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限削除異常終了しました。", outBean.getSyousaimsg());

        psImageauthids = new String[] {""} ;

        inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(psImageauthids);

        outBean = iwfAccountClient.execDelImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0001", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限削除異常終了しました。", outBean.getSyousaimsg());
    }


    @Test
    @TestOrder(4)
    public void test_DelImageAuthority_4_1() {
        createImageAuthoritySingle();

        String[] psImageauthids = {"JunitTester1"};

        DelImageAuthorityInBean inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(psImageauthids);

        WSDelImageAuthorityResponse outBean = iwfAccountClient.execDelImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限削除正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(5)
    public void test_DelImageAuthority_4_2() {
        createImageAuthorityMulti();

        String[] psImageauthids = {"JunitTester2","JunitTester3"};

        DelImageAuthorityInBean inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(psImageauthids);

        WSDelImageAuthorityResponse outBean = iwfAccountClient.execDelImageAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "イメージ権限削除正常終了しました。", outBean.getSyousaimsg());
    }


    private void createImageAuthoritySingle() {
        String psImageauthid = "JunitTester1";
        String[] psTorikomisyoruicds = { "TRKM01" };

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(psImageauthid);
        inBean.setTorikomisyoruicds(psTorikomisyoruicds);

        iwfAccountClient.execUpdImageAuthority(inBean);
    }

    private void createImageAuthorityMulti() {
        String psImageauthid1 = "JunitTester2";
        String[] psTorikomisyoruicds1 = { "TRKM02" };

        UpdImageAuthorityInBean inBean1 = new UpdImageAuthorityInBean();
        inBean1.setImageauthid(psImageauthid1);
        inBean1.setTorikomisyoruicds(psTorikomisyoruicds1);

        String psImageauthid2 = "JunitTester3";
        String[] psTorikomisyoruicds2 = { "TRKM03" };

        UpdImageAuthorityInBean inBean2 = new UpdImageAuthorityInBean();
        inBean2.setImageauthid(psImageauthid2);
        inBean2.setTorikomisyoruicds(psTorikomisyoruicds2);

        iwfAccountClient.execUpdImageAuthority(inBean1);
        iwfAccountClient.execUpdImageAuthority(inBean2);
    }

}
