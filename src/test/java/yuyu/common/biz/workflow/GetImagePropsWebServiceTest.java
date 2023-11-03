package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImageProps;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse.ImagePropsBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;

/**
 * イメージプロパティ取得Webサービス {@link WSGetTargetImageProps#executeBizMain(WSGetTargetImagePropsRequest)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetImagePropsWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    private static boolean isSetupComplete = false;

    private final static String TOKEN1_GYOUMUKEY = IwfDateUtils.getSysDate() + "1";
    private final static String TOKEN1_FLOWID = "khjyuusyohenkou";
    private final static String TOKEN1_SYORUICD = "kk051";
    private static String TOKEN1_IMEGEID1;

    private final static String TOKEN2_GYOUMUKEY = IwfDateUtils.getSysDate() + "2";
    private final static String TOKEN2_FLOWID = "khgengaku";
    private final static String TOKEN2_SYORUICD = "kk055";
    private static String TOKEN2_IMEGEID1;

    private final static String TOKEN3_GYOUMUKEY = IwfDateUtils.getSysDate() + "3";
    private final static String TOKEN3_FLOWID = "khkaijyo";
    private final static String TOKEN3_SYORUICD = "kk163";
    private static String TOKEN3_IMEGEID1;

    private final static String PDF_SINGLE_PAGE = "Test.pdf";
    private final static String PDF_MANY_PAGE = "Test2.pdf";

    private final static String PRE_DATE = BizDate.getSysDate().getPreviousDay().toString();
    private final static String NEXT_DATE = BizDate.getSysDate().getNextDay().toString();

    private static String EXPARAM1_VALUE = IwfDateUtils.getSysDate();

    @Before
    public void Setup(){
        if(!isSetupComplete){
            createToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
            TOKEN1_IMEGEID1 = putImage(TOKEN1_GYOUMUKEY, TOKEN1_FLOWID, TOKEN1_SYORUICD, PDF_SINGLE_PAGE);
            createToken(TOKEN2_GYOUMUKEY,TOKEN2_FLOWID);
            TOKEN2_IMEGEID1 = putImage(TOKEN2_GYOUMUKEY, TOKEN2_FLOWID, TOKEN2_SYORUICD, PDF_MANY_PAGE);
            createToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID);
            TOKEN3_IMEGEID1 = putImage(TOKEN3_GYOUMUKEY, TOKEN3_FLOWID, TOKEN3_SYORUICD, PDF_SINGLE_PAGE);
            setimageRelation(TOKEN3_GYOUMUKEY, TOKEN1_IMEGEID1);
            isSetupComplete = true;
        }
    }

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfImageClient.execGetImageProps(null);
    }

    // 現状のロジックでは、IWF3020は返していない。
    //
    //    @Test
    //    public void testValidationNG02() {
    //        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
    //        getImagePropsInBean.setAccountid("Tt");
    //        getImagePropsInBean.setFlowid("09");
    //        getImagePropsInBean.setGyoumukey("業務キー1_4");
    //        getImagePropsInBean.setTorikomisyoruicd("200");
    //        getImagePropsInBean.setSyoruitoutyakuymdfrom("2015010100000099999999999999");
    //        getImagePropsInBean.setSyoruitoutyakuymdto("20151231235959999");
    //        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
    //        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
    //        getImagePropsInBean.setKouteijyoutai("10");
    //        WSExtParam extParam1 = new WSExtParam();
    //        extParam1.setValues("追加パラメータ１");
    //        getImagePropsInBean.setExtParam1(extParam1);
    //        WSExtParam extParam2 = new WSExtParam();
    //        extParam2.setValues("追加パラメータ２");
    //        getImagePropsInBean.setExtParam2(extParam2);
    //        WSExtParam extParam3 = new WSExtParam();
    //        extParam3.setValues("追加パラメータ３");
    //        getImagePropsInBean.setExtParam3(extParam3);
    //        WSExtParam extParam4 = new WSExtParam();
    //        extParam4.setValues("追加パラメータ４");
    //        getImagePropsInBean.setExtParam4(extParam4);
    //        WSExtParam extParam5 = new WSExtParam();
    //        extParam5.setValues("追加パラメータ５");
    //        getImagePropsInBean.setExtParam5(extParam5);
    //        WSExtParam extParam6 = new WSExtParam();
    //        extParam6.setValues("追加パラメータ６");
    //        getImagePropsInBean.setExtParam6(extParam6);
    //        WSExtParam extParam7 = new WSExtParam();
    //        extParam7.setValues("追加パラメータ７");
    //        getImagePropsInBean.setExtParam7(extParam7);
    //        WSExtParam extParam8 = new WSExtParam();
    //        extParam8.setValues("追加パラメータ８");
    //        getImagePropsInBean.setExtParam8(extParam8);
    //        WSExtParam extParam9 = new WSExtParam();
    //        extParam9.setValues("追加パラメータ９");
    //        getImagePropsInBean.setExtParam9(extParam9);
    //        WSExtParam extParam10 = new WSExtParam();
    //        extParam10.setValues("追加パラメータ１０");
    //        getImagePropsInBean.setExtParam10(extParam10);
    //        WSExtParam extParam11 = new WSExtParam();
    //        extParam11.setValues("追加パラメータ１１");
    //        getImagePropsInBean.setExtParam11(extParam11);
    //        WSExtParam extParam12 = new WSExtParam();
    //        extParam12.setValues("追加パラメータ１２");
    //        getImagePropsInBean.setExtParam12(extParam12);
    //        WSExtParam extParam13 = new WSExtParam();
    //        extParam13.setValues("追加パラメータ１３");
    //        getImagePropsInBean.setExtParam13(extParam13);
    //        WSExtParam extParam14 = new WSExtParam();
    //        extParam14.setValues("追加パラメータ１４");
    //        getImagePropsInBean.setExtParam14(extParam14);
    //        WSExtParam extParam15 = new WSExtParam();
    //        extParam15.setValues("追加パラメータ１５");
    //        getImagePropsInBean.setExtParam15(extParam15);
    //        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3020", getImagePropsOutBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着自年月日", getImagePropsOutBean.getSyousaimsg());
    //        assertEquals(null, getImagePropsOutBean.getImagepropslist());
    //
    //    }

    @Test
    public void testValidationNG03() {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid("09");
        getImagePropsInBean.setGyoumukey("業務キー1_5");
        getImagePropsInBean.setTorikomisyoruicd("200");
        getImagePropsInBean.setSyoruitoutyakuymdfrom("20150101000000000");
        getImagePropsInBean.setSyoruitoutyakuymdto(null);
        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
        getImagePropsInBean.setKouteijyoutai("10");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(null, getImagePropsOutBean.getImagepropslist());

    }

    @Test
    public void testValidationNG04() {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid("09");
        getImagePropsInBean.setGyoumukey("業務キー1_6");
        getImagePropsInBean.setTorikomisyoruicd("200");
        getImagePropsInBean.setSyoruitoutyakuymdfrom("20150101000000000");
        getImagePropsInBean.setSyoruitoutyakuymdto("");
        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
        getImagePropsInBean.setKouteijyoutai("10");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(null, getImagePropsOutBean.getImagepropslist());

    }

    //    @Test
    //    public void testValidationNG05() {
    //        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
    //        getImagePropsInBean.setAccountid("Tt");
    //        getImagePropsInBean.setFlowid("09");
    //        getImagePropsInBean.setGyoumukey("業務キー1_4");
    //        getImagePropsInBean.setTorikomisyoruicd("200");
    //        getImagePropsInBean.setSyoruitoutyakuymdfrom("20150101000000000");
    //        getImagePropsInBean.setSyoruitoutyakuymdto("20151231235959");
    //        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
    //        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
    //        getImagePropsInBean.setKouteijyoutai("10");
    //        WSExtParam extParam1 = new WSExtParam();
    //        extParam1.setValues("追加パラメータ１");
    //        getImagePropsInBean.setExtParam1(extParam1);
    //        WSExtParam extParam2 = new WSExtParam();
    //        extParam2.setValues("追加パラメータ２");
    //        getImagePropsInBean.setExtParam2(extParam2);
    //        WSExtParam extParam3 = new WSExtParam();
    //        extParam3.setValues("追加パラメータ３");
    //        getImagePropsInBean.setExtParam3(extParam3);
    //        WSExtParam extParam4 = new WSExtParam();
    //        extParam4.setValues("追加パラメータ４");
    //        getImagePropsInBean.setExtParam4(extParam4);
    //        WSExtParam extParam5 = new WSExtParam();
    //        extParam5.setValues("追加パラメータ５");
    //        getImagePropsInBean.setExtParam5(extParam5);
    //        WSExtParam extParam6 = new WSExtParam();
    //        extParam6.setValues("追加パラメータ６");
    //        getImagePropsInBean.setExtParam6(extParam6);
    //        WSExtParam extParam7 = new WSExtParam();
    //        extParam7.setValues("追加パラメータ７");
    //        getImagePropsInBean.setExtParam7(extParam7);
    //        WSExtParam extParam8 = new WSExtParam();
    //        extParam8.setValues("追加パラメータ８");
    //        getImagePropsInBean.setExtParam8(extParam8);
    //        WSExtParam extParam9 = new WSExtParam();
    //        extParam9.setValues("追加パラメータ９");
    //        getImagePropsInBean.setExtParam9(extParam9);
    //        WSExtParam extParam10 = new WSExtParam();
    //        extParam10.setValues("追加パラメータ１０");
    //        getImagePropsInBean.setExtParam10(extParam10);
    //        WSExtParam extParam11 = new WSExtParam();
    //        extParam11.setValues("追加パラメータ１１");
    //        getImagePropsInBean.setExtParam11(extParam11);
    //        WSExtParam extParam12 = new WSExtParam();
    //        extParam12.setValues("追加パラメータ１２");
    //        getImagePropsInBean.setExtParam12(extParam12);
    //        WSExtParam extParam13 = new WSExtParam();
    //        extParam13.setValues("追加パラメータ１３");
    //        getImagePropsInBean.setExtParam13(extParam13);
    //        WSExtParam extParam14 = new WSExtParam();
    //        extParam14.setValues("追加パラメータ１４");
    //        getImagePropsInBean.setExtParam14(extParam14);
    //        WSExtParam extParam15 = new WSExtParam();
    //        extParam15.setValues("追加パラメータ１５");
    //        getImagePropsInBean.setExtParam15(extParam15);
    //        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3023", getImagePropsOutBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着至年月日", getImagePropsOutBean.getSyousaimsg());
    //        assertEquals(null, getImagePropsOutBean.getImagepropslist());
    //
    //    }

    @Test
    public void testValidationNG06() {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid("09");
        getImagePropsInBean.setGyoumukey("業務キー1_5");
        getImagePropsInBean.setTorikomisyoruicd("200");
        getImagePropsInBean.setSyoruitoutyakuymdfrom(null);
        getImagePropsInBean.setSyoruitoutyakuymdto("20151231235959999");
        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
        getImagePropsInBean.setKouteijyoutai("10");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(null, getImagePropsOutBean.getImagepropslist());

    }

    @Test
    public void testValidationNG07() {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid("09");
        getImagePropsInBean.setGyoumukey("業務キー1_6");
        getImagePropsInBean.setTorikomisyoruicd("200");
        getImagePropsInBean.setSyoruitoutyakuymdfrom("");
        getImagePropsInBean.setSyoruitoutyakuymdto("20151231235959999");
        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
        getImagePropsInBean.setKouteijyoutai("10");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(null, getImagePropsOutBean.getImagepropslist());

    }

    @Test
    public void testValidationOK01() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertTrue(getImagePropsOutBean.getImagepropslist().size() >= 1);

    }

    @Test
    public void testValidationOK02() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid("");
        getImagePropsInBean.setGyoumukey("");
        getImagePropsInBean.setTorikomisyoruicd("");
        getImagePropsInBean.setSyoruitoutyakuymdfrom("");
        getImagePropsInBean.setSyoruitoutyakuymdto("");
        getImagePropsInBean.setSyzkdaibunruiid("");
        getImagePropsInBean.setSyzksyoubunruiid("");
        getImagePropsInBean.setKouteijyoutai("");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("");
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "データ整合性エラー（対象レコードが存在しません）：対象テーブル＝WM_TorikomiSyorui", getImagePropsOutBean.getSyousaimsg());

    }


    @Test
    public void testValidationOK03() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("testUser");
        getImagePropsInBean.setSyoruitoutyakuymdfrom("00000000000000000");
        getImagePropsInBean.setSyoruitoutyakuymdto("00000000000000000");

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationOK04() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("testUser");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setSyoruitoutyakuymdfrom("00000000000000000");
        getImagePropsInBean.setSyoruitoutyakuymdto("99999999999999999");

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationOK05() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("testUser");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setSyoruitoutyakuymdfrom("99999999999999999");
        getImagePropsInBean.setSyoruitoutyakuymdto("00000000000000000");

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());

    }

    @Test
    public void testValidationOK06() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("testUser");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setSyoruitoutyakuymdfrom("99999999999999999");
        getImagePropsInBean.setSyoruitoutyakuymdto("99999999999999999");

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());

    }

    @Test
    public void testInfoExistNG01() throws Exception {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("administrator");
        getImagePropsInBean.setFlowid("存在しないフローID");
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "データ整合性エラー（対象レコードが存在しません）：対象テーブル＝WM_TorikomiSyorui", getImagePropsOutBean.getSyousaimsg());
        assertEquals(null, getImagePropsOutBean.getImagepropslist());

    }

    //    @Test
    //    public void testInfoExistNG02() {
    //        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
    //        getImagePropsInBean.setAccountid("Tt");
    //        getImagePropsInBean.setFlowid("09");
    //        getImagePropsInBean.setGyoumukey("業務キー4_8");
    //        getImagePropsInBean.setTorikomisyoruicd("200");
    //        getImagePropsInBean.setSyoruitoutyakuymdfrom("20150101000000000");
    //        getImagePropsInBean.setSyoruitoutyakuymdto("20151231235959999");
    //        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ");
    //        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ");
    //        getImagePropsInBean.setKouteijyoutai("10");
    //        WSExtParam extParam1 = new WSExtParam();
    //        extParam1.setValues("追加パラメータ１");
    //        getImagePropsInBean.setExtParam1(extParam1);
    //        WSExtParam extParam2 = new WSExtParam();
    //        extParam2.setValues("追加パラメータ２");
    //        getImagePropsInBean.setExtParam2(extParam2);
    //        WSExtParam extParam3 = new WSExtParam();
    //        extParam3.setValues("追加パラメータ３");
    //        getImagePropsInBean.setExtParam3(extParam3);
    //        WSExtParam extParam4 = new WSExtParam();
    //        extParam4.setValues("追加パラメータ４");
    //        getImagePropsInBean.setExtParam4(extParam4);
    //        WSExtParam extParam5 = new WSExtParam();
    //        extParam5.setValues("追加パラメータ５");
    //        getImagePropsInBean.setExtParam5(extParam5);
    //        WSExtParam extParam6 = new WSExtParam();
    //        extParam6.setValues("追加パラメータ６");
    //        getImagePropsInBean.setExtParam6(extParam6);
    //        WSExtParam extParam7 = new WSExtParam();
    //        extParam7.setValues("追加パラメータ７");
    //        getImagePropsInBean.setExtParam7(extParam7);
    //        WSExtParam extParam8 = new WSExtParam();
    //        extParam8.setValues("追加パラメータ８");
    //        getImagePropsInBean.setExtParam8(extParam8);
    //        WSExtParam extParam9 = new WSExtParam();
    //        extParam9.setValues("追加パラメータ９");
    //        getImagePropsInBean.setExtParam9(extParam9);
    //        WSExtParam extParam10 = new WSExtParam();
    //        extParam10.setValues("追加パラメータ１０");
    //        getImagePropsInBean.setExtParam10(extParam10);
    //        WSExtParam extParam11 = new WSExtParam();
    //        extParam11.setValues("追加パラメータ１１");
    //        getImagePropsInBean.setExtParam11(extParam11);
    //        WSExtParam extParam12 = new WSExtParam();
    //        extParam12.setValues("追加パラメータ１２");
    //        getImagePropsInBean.setExtParam12(extParam12);
    //        WSExtParam extParam13 = new WSExtParam();
    //        extParam13.setValues("追加パラメータ１３");
    //        getImagePropsInBean.setExtParam13(extParam13);
    //        WSExtParam extParam14 = new WSExtParam();
    //        extParam14.setValues("追加パラメータ１４");
    //        getImagePropsInBean.setExtParam14(extParam14);
    //        WSExtParam extParam15 = new WSExtParam();
    //        extParam15.setValues("追加パラメータ１５");
    //        getImagePropsInBean.setExtParam15(extParam15);
    //        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getImagePropsOutBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3021", getImagePropsOutBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", getImagePropsOutBean.getSyousaimsg());
    //        assertEquals(null, getImagePropsOutBean.getImagepropslist());
    //
    //    }
    //
    //    @Test
    //    public void testInfoExistNG03() {
    //        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
    //        getImagePropsInBean.setAccountid("administrator");
    //        getImagePropsInBean.setFlowid("torikomi");
    //        getImagePropsInBean.setGyoumukey("業務キー2_2");
    //        WSExtParam extParam1 = new WSExtParam();
    //        extParam1.setValues("追加パラメータ１");
    //        getImagePropsInBean.setExtParam1(extParam1);
    //        WSExtParam extParam2 = new WSExtParam();
    //        extParam2.setValues("追加パラメータ２");
    //        getImagePropsInBean.setExtParam2(extParam2);
    //        WSExtParam extParam3 = new WSExtParam();
    //        extParam3.setValues("追加パラメータ３");
    //        getImagePropsInBean.setExtParam3(extParam3);
    //        WSExtParam extParam4 = new WSExtParam();
    //        extParam4.setValues("追加パラメータ４");
    //        getImagePropsInBean.setExtParam4(extParam4);
    //        WSExtParam extParam5 = new WSExtParam();
    //        extParam5.setValues("追加パラメータ５");
    //        getImagePropsInBean.setExtParam5(extParam5);
    //        WSExtParam extParam6 = new WSExtParam();
    //        extParam6.setValues("追加パラメータ６");
    //        getImagePropsInBean.setExtParam6(extParam6);
    //        WSExtParam extParam7 = new WSExtParam();
    //        extParam7.setValues("追加パラメータ７");
    //        getImagePropsInBean.setExtParam7(extParam7);
    //        WSExtParam extParam8 = new WSExtParam();
    //        extParam8.setValues("追加パラメータ８");
    //        getImagePropsInBean.setExtParam8(extParam8);
    //        WSExtParam extParam9 = new WSExtParam();
    //        extParam9.setValues("追加パラメータ９");
    //        getImagePropsInBean.setExtParam9(extParam9);
    //        WSExtParam extParam10 = new WSExtParam();
    //        extParam10.setValues("追加パラメータ１０");
    //        getImagePropsInBean.setExtParam10(extParam10);
    //        WSExtParam extParam11 = new WSExtParam();
    //        extParam11.setValues("追加パラメータ１１");
    //        getImagePropsInBean.setExtParam11(extParam11);
    //        WSExtParam extParam12 = new WSExtParam();
    //        extParam12.setValues("追加パラメータ１２");
    //        getImagePropsInBean.setExtParam12(extParam12);
    //        WSExtParam extParam13 = new WSExtParam();
    //        extParam13.setValues("追加パラメータ１３");
    //        getImagePropsInBean.setExtParam13(extParam13);
    //        WSExtParam extParam14 = new WSExtParam();
    //        extParam14.setValues("追加パラメータ１４");
    //        getImagePropsInBean.setExtParam14(extParam14);
    //        WSExtParam extParam15 = new WSExtParam();
    //        extParam15.setValues("追加パラメータ１５");
    //        getImagePropsInBean.setExtParam15(extParam15);
    //        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
    //            getImagePropsOutBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3022", getImagePropsOutBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", getImagePropsOutBean.getSyousaimsg());
    //    }

    @Test
    public void testInfoExistOK01() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setGyoumukey("存在しない業務キー");
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(0, getImagePropsOutBean.getImagepropslist().size());
    }

    @Test
    public void testInfoExistOK02() throws Exception {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(1, getImagePropsOutBean.getImagepropslist().size());

    }

    @Test
    public void testInfoExistOK03() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("Tt");
        getImagePropsInBean.setKouteijyoutai("10");

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertTrue(getImagePropsOutBean.getImagepropslist().size() > 1);

    }

    @Test
    public void testPageCountOK01() throws Exception {
        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("TestUser");
        getImagePropsInBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(1, getImagePropsOutBean.getImagepropslist().size());
        assertEquals("1", getImagePropsOutBean.getImagepropslist().get(0).getPagecount());
    }

    @Test
    public void testPageCountOK02() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("testUser");
        getImagePropsInBean.setGyoumukey(TOKEN2_GYOUMUKEY);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(getImagePropsOutBean.getImagepropslist().size(), 1);
        assertTrue(Integer.valueOf(getImagePropsOutBean.getImagepropslist().get(0).getPagecount()) > 1);

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("administrator");
        getImagePropsInBean.setFlowid(TOKEN1_FLOWID);
        getImagePropsInBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        getImagePropsInBean.setTorikomisyoruicd(TOKEN1_SYORUICD);
        getImagePropsInBean.setSyoruitoutyakuymdfrom(PRE_DATE);
        getImagePropsInBean.setSyoruitoutyakuymdto(NEXT_DATE);
        //        getImagePropsInBean.setSyzkdaibunruiid("所属大分類ＩＤ3_1");
        //        getImagePropsInBean.setSyzksyoubunruiid("所属小分類ＩＤ3_1");
        getImagePropsInBean.setKouteijyoutai("10");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(EXPARAM1_VALUE);
        getImagePropsInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("取込管理の追加パラメータ２");
        getImagePropsInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("取込管理の追加パラメータ３");
        getImagePropsInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("取込管理の追加パラメータ４");
        getImagePropsInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("取込管理の追加パラメータ５");
        getImagePropsInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("取込管理の追加パラメータ６");
        getImagePropsInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("取込管理の追加パラメータ７");
        getImagePropsInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("取込管理の追加パラメータ８");
        getImagePropsInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("取込管理の追加パラメータ９");
        getImagePropsInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("取込管理の追加パラメータ１０");
        getImagePropsInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("取込管理の追加パラメータ１１");
        getImagePropsInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("取込管理の追加パラメータ１２");
        getImagePropsInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("取込管理の追加パラメータ１３");
        getImagePropsInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("取込管理の追加パラメータ１４");
        getImagePropsInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("取込管理の追加パラメータ１５");
        getImagePropsInBean.setExtParam15(extParam15);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(1, getImagePropsOutBean.getImagepropslist().size());
        // 20170118変更, イメージIDはイメージ登録でUniqueKeyGenerator使用している為、固定値では検証不可能
        // assertEquals("イメージＩＤ3_1", getImagePropsOutBean.getImagepropslist().get(0).getImageid());
        assertEquals(TOKEN1_IMEGEID1, getImagePropsOutBean.getImagepropslist().get(0).getImageid());
        assertEquals(TOKEN1_GYOUMUKEY, getImagePropsOutBean.getImagepropslist().get(0).getGyoumukey());
        assertEquals(TOKEN1_SYORUICD, getImagePropsOutBean.getImagepropslist().get(0).getTorikomisyoruicd());
        //        assertEquals("20150807154208", getImagePropsOutBean.getImagepropslist().get(0).getSyoruitoutyakutime());
        // 20170118変更, 全角文字は工程履歴テーブル登録時バリデーションエラーになる
        // assertEquals("登録アカウントＩＤ3_1", getImagePropsOutBean.getImagepropslist().get(0).getTourokuaccountid());
        assertEquals("imageUser", getImagePropsOutBean.getImagepropslist().get(0).getTourokuaccountid());
    }

    @Test
    public void testSyoriLogicOK02() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("administrator");
        getImagePropsInBean.setGyoumukey(TOKEN3_GYOUMUKEY);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(2, getImagePropsOutBean.getImagepropslist().size());
        assertNotEquals(getImagePropsOutBean.getImagepropslist().get(1).getImageid(),getImagePropsOutBean.getImagepropslist().get(0).getImageid());
        assertEquals(getImagePropsOutBean.getImagepropslist().get(0).getGyoumukey(), getImagePropsOutBean.getImagepropslist().get(1).getGyoumukey());
    }

    @Test
    public void testSyoriLogicOK03() throws Exception {

        GetImagePropsInBean getImagePropsInBean = new GetImagePropsInBean();
        getImagePropsInBean.setAccountid("administrator");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(EXPARAM1_VALUE);
        getImagePropsInBean.setExtParam1(extParam1);
        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImagePropsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImagePropsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "対象イメージプロパティ取得正常終了しました。", getImagePropsOutBean.getSyousaimsg());
        assertEquals(4, getImagePropsOutBean.getImagepropslist().size());

        List<String> gyoumukeyList = new ArrayList<>();
        for(ImagePropsBean bean : getImagePropsOutBean.getImagepropslist()){
            gyoumukeyList.add(bean.getGyoumukey());
        }
        assertTrue(gyoumukeyList.remove(TOKEN1_GYOUMUKEY));
        assertTrue(gyoumukeyList.remove(TOKEN2_GYOUMUKEY));
        assertTrue(gyoumukeyList.remove(TOKEN3_GYOUMUKEY));
        assertTrue(gyoumukeyList.remove(TOKEN3_GYOUMUKEY));
        assertEquals(gyoumukeyList.size(), 0);
    }

    private ProcessUpdateForBatchBean setExtInfo(ProcessUpdateForBatchBean pBatchBean, String pKey,String pValue){
        List<Map<String, String>> poExtinfoMapList = new ArrayList<>();
        Map<String, String> poExtinfoMap = new HashMap<>();
        poExtinfoMap.put(pKey, pValue);
        poExtinfoMapList.add(poExtinfoMap);
        pBatchBean.setExtInfo(poExtinfoMapList);
        return pBatchBean;
    }

    private WSCommonRequest setExtParam(WSCommonRequest pBatchBean, boolean pIsNullUpdate){
        WSExtParam poExtparam1 = new WSExtParam();
        WSExtParam poExtparam2 = new WSExtParam();
        WSExtParam poExtparam3 = new WSExtParam();
        WSExtParam poExtparam4 = new WSExtParam();
        WSExtParam poExtparam5 = new WSExtParam();
        WSExtParam poExtparam6 = new WSExtParam();
        WSExtParam poExtparam7 = new WSExtParam();
        WSExtParam poExtparam8 = new WSExtParam();
        WSExtParam poExtparam9 = new WSExtParam();
        WSExtParam poExtparam10 = new WSExtParam();
        WSExtParam poExtparam11 = new WSExtParam();
        WSExtParam poExtparam12 = new WSExtParam();
        WSExtParam poExtparam13 = new WSExtParam();
        WSExtParam poExtparam14 = new WSExtParam();
        WSExtParam poExtparam15 = new WSExtParam();
        WSExtParam poExtparam16 = new WSExtParam();
        WSExtParam poExtparam17 = new WSExtParam();
        WSExtParam poExtparam18 = new WSExtParam();
        WSExtParam poExtparam19 = new WSExtParam();
        WSExtParam poExtparam20 = new WSExtParam();
        WSExtParam poExtparam21 = new WSExtParam();
        WSExtParam poExtparam22 = new WSExtParam();
        WSExtParam poExtparam23 = new WSExtParam();
        WSExtParam poExtparam24 = new WSExtParam();
        WSExtParam poExtparam25 = new WSExtParam();
        WSExtParam poExtparam26 = new WSExtParam();
        WSExtParam poExtparam27 = new WSExtParam();
        WSExtParam poExtparam28 = new WSExtParam();
        WSExtParam poExtparam29 = new WSExtParam();
        WSExtParam poExtparam30 = new WSExtParam();
        if(BooleanUtils.isFalse(pIsNullUpdate)){
            poExtparam1.setValues("デフォルト追加パラメータ１");
            poExtparam2.setValues("デフォルト追加パラメータ２");
            poExtparam3.setValues("デフォルト追加パラメータ３");
            poExtparam4.setValues("デフォルト追加パラメータ４");
            poExtparam5.setValues("デフォルト追加パラメータ５");
            poExtparam6.setValues("デフォルト追加パラメータ６");
            poExtparam7.setValues("デフォルト追加パラメータ７");
            poExtparam8.setValues("デフォルト追加パラメータ８");
            poExtparam9.setValues("デフォルト追加パラメータ９");
            poExtparam10.setValues("デフォルト追加パラメータ１０");
            poExtparam11.setValues("デフォルト追加パラメータ１１");
            poExtparam12.setValues("デフォルト追加パラメータ１２");
            poExtparam13.setValues("デフォルト追加パラメータ１３");
            poExtparam14.setValues("デフォルト追加パラメータ１４");
            poExtparam15.setValues("デフォルト追加パラメータ１５");
            poExtparam16.setValues("デフォルト追加パラメータ１６");
            poExtparam17.setValues("デフォルト追加パラメータ１７");
            poExtparam18.setValues("デフォルト追加パラメータ１８");
            poExtparam19.setValues("デフォルト追加パラメータ１９");
            poExtparam20.setValues("デフォルト追加パラメータ２０");
            poExtparam21.setValues("デフォルト追加パラメータ２１");
            poExtparam22.setValues("デフォルト追加パラメータ２２");
            poExtparam23.setValues("デフォルト追加パラメータ２３");
            poExtparam24.setValues("デフォルト追加パラメータ２４");
            poExtparam25.setValues("デフォルト追加パラメータ２５");
            poExtparam26.setValues("デフォルト追加パラメータ２６");
            poExtparam27.setValues("デフォルト追加パラメータ２７");
            poExtparam28.setValues("デフォルト追加パラメータ２８");
            poExtparam29.setValues("デフォルト追加パラメータ２９");
            poExtparam30.setValues("デフォルト追加パラメータ３０");
        }

        pBatchBean.setExtParam1(poExtparam1);
        pBatchBean.setExtParam2(poExtparam2);
        pBatchBean.setExtParam3(poExtparam3);
        pBatchBean.setExtParam4(poExtparam4);
        pBatchBean.setExtParam5(poExtparam5);
        pBatchBean.setExtParam6(poExtparam6);
        pBatchBean.setExtParam7(poExtparam7);
        pBatchBean.setExtParam8(poExtparam8);
        pBatchBean.setExtParam9(poExtparam9);
        pBatchBean.setExtParam10(poExtparam10);
        pBatchBean.setExtParam11(poExtparam11);
        pBatchBean.setExtParam12(poExtparam12);
        pBatchBean.setExtParam13(poExtparam13);
        pBatchBean.setExtParam14(poExtparam14);
        pBatchBean.setExtParam15(poExtparam15);
        pBatchBean.setExtParam16(poExtparam16);
        pBatchBean.setExtParam17(poExtparam17);
        pBatchBean.setExtParam18(poExtparam18);
        pBatchBean.setExtParam19(poExtparam19);
        pBatchBean.setExtParam20(poExtparam20);
        pBatchBean.setExtParam21(poExtparam21);
        pBatchBean.setExtParam22(poExtparam22);
        pBatchBean.setExtParam23(poExtparam23);
        pBatchBean.setExtParam24(poExtparam24);
        pBatchBean.setExtParam25(poExtparam25);
        pBatchBean.setExtParam26(poExtparam26);
        pBatchBean.setExtParam27(poExtparam27);
        pBatchBean.setExtParam28(poExtparam28);
        pBatchBean.setExtParam29(poExtparam29);
        pBatchBean.setExtParam30(poExtparam30);
        return pBatchBean;
    }

    private WSCommonRequest setTorikomiKanriExtParam(WSCommonRequest pBatchBean){
        WSExtParam poExtparam1 = new WSExtParam();
        WSExtParam poExtparam2 = new WSExtParam();
        WSExtParam poExtparam3 = new WSExtParam();
        WSExtParam poExtparam4 = new WSExtParam();
        WSExtParam poExtparam5 = new WSExtParam();
        WSExtParam poExtparam6 = new WSExtParam();
        WSExtParam poExtparam7 = new WSExtParam();
        WSExtParam poExtparam8 = new WSExtParam();
        WSExtParam poExtparam9 = new WSExtParam();
        WSExtParam poExtparam10 = new WSExtParam();
        WSExtParam poExtparam11 = new WSExtParam();
        WSExtParam poExtparam12 = new WSExtParam();
        WSExtParam poExtparam13 = new WSExtParam();
        WSExtParam poExtparam14 = new WSExtParam();
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam1.setValues(EXPARAM1_VALUE);
        poExtparam2.setValues("取込管理の追加パラメータ２");
        poExtparam3.setValues("取込管理の追加パラメータ３");
        poExtparam4.setValues("取込管理の追加パラメータ４");
        poExtparam5.setValues("取込管理の追加パラメータ５");
        poExtparam6.setValues("取込管理の追加パラメータ６");
        poExtparam7.setValues("取込管理の追加パラメータ７");
        poExtparam8.setValues("取込管理の追加パラメータ８");
        poExtparam9.setValues("取込管理の追加パラメータ９");
        poExtparam10.setValues("取込管理の追加パラメータ１０");
        poExtparam11.setValues("取込管理の追加パラメータ１１");
        poExtparam12.setValues("取込管理の追加パラメータ１２");
        poExtparam13.setValues("取込管理の追加パラメータ１３");
        poExtparam14.setValues("取込管理の追加パラメータ１４");
        poExtparam15.setValues("取込管理の追加パラメータ１５");

        pBatchBean.setExtParam1(poExtparam1);
        pBatchBean.setExtParam2(poExtparam2);
        pBatchBean.setExtParam3(poExtparam3);
        pBatchBean.setExtParam4(poExtparam4);
        pBatchBean.setExtParam5(poExtparam5);
        pBatchBean.setExtParam6(poExtparam6);
        pBatchBean.setExtParam7(poExtparam7);
        pBatchBean.setExtParam8(poExtparam8);
        pBatchBean.setExtParam9(poExtparam9);
        pBatchBean.setExtParam10(poExtparam10);
        pBatchBean.setExtParam11(poExtparam11);
        pBatchBean.setExtParam12(poExtparam12);
        pBatchBean.setExtParam13(poExtparam13);
        pBatchBean.setExtParam14(poExtparam14);
        pBatchBean.setExtParam15(poExtparam15);
        return pBatchBean;
    }

    private String createToken(String pKey,String pFlowid) {
        ProcessCreateInBean createInBean = new ProcessCreateInBean();
        createInBean.setRequestid(pKey);
        createInBean.setAccountid(pKey);
        createInBean.setFlowid(pFlowid);
        createInBean.setGyoumukey(pKey);
        setExtParam(createInBean,false);
        iwfKouteiClient.execProcessCreate(createInBean);
        return pKey;
    }

    private void lockToken(String pKey,String pFlowid) {
        LockProcessInBean lockInBean = new LockProcessInBean();
        lockInBean.setFlowid(pFlowid);
        lockInBean.setGyoumukey(pKey);
        lockInBean.setLockkey(pKey);
        iwfKouteiClient.execLockProcess(lockInBean);
    }

    private void unlockToken(String pKey,String pFlowid) {
        UnlockProcessInBean unlockInBean = new UnlockProcessInBean();
        unlockInBean.setFlowid(pFlowid);
        unlockInBean.setGyoumukey(pKey);
        unlockInBean.setLockkey(pKey);
        iwfKouteiClient.execUnlockProcess(unlockInBean);
    }

    private String forwardToken(String pKey,String pFlowid,String pSrcNode,String pDstNode) {
        ForceProcessForwardInBean forwardInBean = new ForceProcessForwardInBean();
        forwardInBean.setAccountid(pKey);
        forwardInBean.setFlowid(pFlowid);
        forwardInBean.setGyoumukey(pKey);
        forwardInBean.setSrcnodename(pSrcNode);
        forwardInBean.setDestnodename(pDstNode);
        forwardInBean.setLockkey(pKey);
        setExtParam(forwardInBean,false);
        iwfKouteiClient.execForceProcessForward(forwardInBean);
        return pKey;
    }

    private String putImage(String pKey,String pFlowid, String pSyoruiCd, String pPdfName) {
        PutImageInBean imageInBean = new PutImageInBean();
        imageInBean.setAccountid("imageUser");
        imageInBean.setFlowid(pFlowid);
        imageInBean.setGyoumukey(pKey);
        byte[] pbImagedata = readTestFile(pPdfName);
        imageInBean.setImagedata(pbImagedata);
        imageInBean.setSyoruicd(pSyoruiCd);
        setTorikomiKanriExtParam(imageInBean);
        return iwfImageClient.execPutImage(imageInBean).getImgid();
    }

    private void setimageRelation(String pKey,String pImageId) {
        SetImageReleationInBean inBean = new SetImageReleationInBean();
        inBean.setSyorikbn("14");
        inBean.setImageid(pImageId);
        String[] pkeys = new String[]{pKey};
        inBean.setGyoumukeys(pkeys);
        iwfImageClient.setImageRelation(inBean);
    }

    private byte[] readTestFile(String pdfName) {

        String sPath = this.getClass().getResource("").toString();
        if (sPath.startsWith("file:/")) {
            sPath = sPath.substring(6);
        }

        File oFile = new File(sPath + pdfName);

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) oFile.length());

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(oFile));) {

            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

}
