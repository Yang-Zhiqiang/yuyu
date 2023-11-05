package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation.WSSetImageRelationResponse;

/**
 * イメージ関連設定Webサービスのゲットメソッド {@link WSSetImageRelationResponse(WSSetImageRelationRequest} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SetImageRelationWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @Test(expected = RuntimeException.class)
    public void test_NG_01() {
        SetImageReleationInBean inBean = null;
        iwfImageClient.setImageRelation(inBean);

    }

    @Test
    public void test_NG_02() {

        String psImageid = null;
        String psSyorikbn = "13";
        String[] psGyoumukeys = { "111" };

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_03() {

        String psImageid = "";
        String psSyorikbn = "13";
        String[] psGyoumukeys = { "111" };

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_04() {

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { null };
        String psSyorikbn = "13";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_05() {

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { "" };
        String psSyorikbn = "13";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_06() {

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { "111" };
        String psSyorikbn = null;

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_07() {

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { "111" };
        String psSyorikbn = "";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_08() {
        String gyoumukey = TestUtil.nString_zenkaku(21);

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { gyoumukey };
        String psSyorikbn = "";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_09() {

        String psImageid = "2ciqbhy7qci4y6w";
        String[] psGyoumukeys = { "111" };
        String psSyorikbn = "18";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0006", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_10() {

        String psImageid = "88iqbxsdqci4y6w";
        String[] psGyoumukeys = { "業務キー3_1" };
        String psSyorikbn = "14";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3073", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_11() {

        String psImageid = "イメージＩＤ2_2";
        String[] psGyoumukeys = { "業務キー3_1_no" };
        String psSyorikbn = "14";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3074", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_12() {

        String psImageid = "イメージＩＤ3_1";
        String[] psGyoumukeys = { "業務キー3_1" };
        String psSyorikbn = "14";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);
        iwfImageClient.setImageRelation(inBean);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3075", response.getSyousaimsgcd());

    }

    @Test
    public void test_NG_13() {

        String psImageid = "イメージＩＤ3_1";
        String[] psGyoumukeys = { "業務キー3_1" };
        String psSyorikbn = "15";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);
        iwfImageClient.setImageRelation(inBean);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3076", response.getSyousaimsgcd());

    }

    @Test
    public void test_OK_01() {

        String psImageid = "イメージＩＤ10_1";
        String[] psGyoumukeys = { "業務キー3_1" };
        String psSyorikbn = "14";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());

    }

    @Test
    public void test_OK_02() {

        String psImageid = "イメージＩＤ10_1";
        String[] psGyoumukeys = { "業務キー3_1" };
        String psSyorikbn = "15";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());

    }

    @Test
    public void test_OK_03() {

        String psImageid = "イメージＩＤ10_2";
        String[] psGyoumukeys = { "業務キー3_2", "GKID000000000000001" };
        String psSyorikbn = "14";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());

    }

    @Test
    public void test_OK_04() {

        String psImageid = "イメージＩＤ10_2";
        String[] psGyoumukeys = { "業務キー3_2", "GKID000000000000001" };
        String psSyorikbn = "15";

        SetImageReleationInBean inBean = new SetImageReleationInBean();

        inBean.setSyorikbn(psSyorikbn);
        inBean.setImageid(psImageid);
        inBean.setGyoumukeys(psGyoumukeys);

        WSSetImageRelationResponse response = iwfImageClient.setImageRelation(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());

    }
}
