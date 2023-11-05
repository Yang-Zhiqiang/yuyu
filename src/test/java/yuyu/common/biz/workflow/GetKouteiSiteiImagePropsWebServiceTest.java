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
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse.ImagePropsBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetkouteiSiteiImageProps;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 工程情報指定イメージプロパティ取得Webサービス {@link WSGetkouteiSiteiImageProps#executeBizMain(WSGetKouteiSiteiImagePropsRequest)}
 * テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetKouteiSiteiImagePropsWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    @Inject
    UniqueKeyGenerator uniqueKeyGenerator;

    private static boolean isSetupComplete = false;

    private final static String TOKEN1_GYOUMUKEY = IwfDateUtils.getSysDate() + "1";
    private final static String TOKEN1_FLOWID = "khjyuusyohenkou";
    private final static String TOKEN1_SYORUICD = "kk051";
    private static String TOKEN1_IMAGEID1;

    private final static String TOKEN2_GYOUMUKEY = IwfDateUtils.getSysDate() + "2";
    private final static String TOKEN2_FLOWID = "khgengaku";
    private final static String TOKEN2_SYORUICD = "kk055";
    private static String TOKEN2_IMAGEID1;

    private final static String TOKEN3_GYOUMUKEY = IwfDateUtils.getSysDate() + "3";
    private final static String TOKEN3_FLOWID = "khkaijyo";
    private final static String TOKEN3_SYORUICD = "kk163";
    private final static String TOKEN3_TSKUSER = "54010100";
    private static String TOKEN3_IMAGEID1;

    private final static String PRE_DATE = BizDate.getSysDate().getPreviousDay().toString();
    private final static String NEXT_DATE = BizDate.getSysDate().getNextDay().toString();

    private static String EXPARAM1_VALUE = IwfDateUtils.getSysDate();

    @Before
    public void Setup(){
        if(!isSetupComplete){
            createToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
            TOKEN1_IMAGEID1 = putImage(TOKEN1_GYOUMUKEY, TOKEN1_FLOWID, TOKEN1_SYORUICD);
            createToken(TOKEN2_GYOUMUKEY,TOKEN2_FLOWID);
            lockToken(TOKEN2_GYOUMUKEY, TOKEN2_FLOWID);
            forwardToken(TOKEN2_GYOUMUKEY,TOKEN2_FLOWID,"state-syoruitoutyaku","end-state1");
            TOKEN2_IMAGEID1 = putImage(TOKEN2_GYOUMUKEY, TOKEN2_FLOWID, TOKEN2_SYORUICD);
            updateKouteiKanryouYmd(TOKEN2_GYOUMUKEY);
            unlockToken(TOKEN2_GYOUMUKEY, TOKEN2_FLOWID);
            createToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID);
            lockToken(TOKEN3_GYOUMUKEY, TOKEN3_FLOWID);
            TOKEN3_IMAGEID1 = putImage(TOKEN3_GYOUMUKEY, TOKEN3_FLOWID, TOKEN3_SYORUICD);
            forwardToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID,"state-syoruitoutyaku","input");
            startTask(TOKEN3_GYOUMUKEY, TOKEN3_FLOWID, TOKEN3_TSKUSER, "input");
            unlockToken(TOKEN3_GYOUMUKEY, TOKEN3_FLOWID);
            setimageRelation(TOKEN3_GYOUMUKEY,TOKEN1_IMAGEID1);

            isSetupComplete = true;
        }
    }


    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {

        iwfImageClient.GetKouteiSiteiImageProps(null);
    }

    @Test
    public void testValidationNG02() {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        GetKouteiSiteiImagePropsOutBean outBean =iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    public void testValidationNG03(){

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("");
        inBean.setFlowid("");
        String[] flowIdsList= {""};
        inBean.setFlowids(flowIdsList);
        inBean.setGyoumukey("");
        String[] gyomuKeysList= {""};
        inBean.setGyoumukeys(gyomuKeysList);
        inBean.setTorikomisyoruicd("");
        inBean.setNodename("");
        inBean.setAccountwariateumu("");
        inBean.setKekkajyougenkensu("");
        inBean.setLastsyoritimefrom("");
        inBean.setLastsyoritimeto("");
        inBean.setKouteikaisibifrom("");
        inBean.setKouteikaisibito("");
        inBean.setKouteikanryoubifrom("");
        inBean.setKouteikanryoubito("");
        inBean.setSyoruitoutyakuymdfrom("");
        inBean.setSyoruitoutyakuymdto("");
        String[] sysriStatusList= {""};
        inBean.setSyoristatus(sysriStatusList);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("");
        inBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("");
        inBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("");
        inBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("");
        inBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("");
        inBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("");
        inBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("");
        inBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("");
        inBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("");
        inBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("");
        inBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("");
        inBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("");
        inBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("");
        inBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("");
        inBean.setExtParam14(extParam14);
        WSExtParam extParam15= new WSExtParam();
        extParam15.setValues("");
        inBean.setExtParam15(extParam15);
        WSExtParam extParam16= new WSExtParam();
        extParam16.setValues("");
        inBean.setExtParam16(extParam16);
        WSExtParam extParam17= new WSExtParam();
        extParam17.setValues("");
        inBean.setExtParam17(extParam17);
        WSExtParam extParam18= new WSExtParam();
        extParam18.setValues("");
        inBean.setExtParam18(extParam18);
        WSExtParam extParam19= new WSExtParam();
        extParam19.setValues("");
        inBean.setExtParam19(extParam19);
        WSExtParam extParam20= new WSExtParam();
        extParam20.setValues("");
        inBean.setExtParam20(extParam20);
        WSExtParam extParam21= new WSExtParam();
        extParam21.setValues("");
        inBean.setExtParam21(extParam21);
        WSExtParam extParam22= new WSExtParam();
        extParam22.setValues("");
        inBean.setExtParam22(extParam22);
        WSExtParam extParam23= new WSExtParam();
        extParam23.setValues("");
        inBean.setExtParam23(extParam23);
        WSExtParam extParam24= new WSExtParam();
        extParam24.setValues("");
        inBean.setExtParam24(extParam24);
        WSExtParam extParam25= new WSExtParam();
        extParam25.setValues("");
        inBean.setExtParam25(extParam25);
        WSExtParam extParam26= new WSExtParam();
        extParam26.setValues("");
        inBean.setExtParam26(extParam26);
        WSExtParam extParam27= new WSExtParam();
        extParam27.setValues("");
        inBean.setExtParam27(extParam27);
        WSExtParam extParam28= new WSExtParam();
        extParam28.setValues("");
        inBean.setExtParam28(extParam28);
        WSExtParam extParam29= new WSExtParam();
        extParam29.setValues("");
        inBean.setExtParam29(extParam29);
        WSExtParam extParam30= new WSExtParam();
        extParam30.setValues("");
        inBean.setExtParam30(extParam30);


        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    public void testValidationNG04() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG05() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(updateTime_);
        inBean.setLastsyoritimeto("");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG06() {

        String updateTime_ = "20152427101307068168185466";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(updateTime_);
        inBean.setLastsyoritimeto("20160901122025999");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2165", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：最終処理時間(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG07() {

        String updateTime_ = "20152427101307068";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(updateTime_);
        inBean.setLastsyoritimeto("20160901122025999");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2165", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：最終処理時間(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG08() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(null);
        inBean.setLastsyoritimeto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG09() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom("");
        inBean.setLastsyoritimeto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2169", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "最終処理時間(自)と最終処理時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG10() {

        String updateTime_ = "20152427101307068167817";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom("20000301120235999");
        inBean.setLastsyoritimeto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2166", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：最終処理時間(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG11() {

        String updateTime_ = "20152427101307068";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom("20000301120235999");
        inBean.setLastsyoritimeto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2166", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：最終処理時間(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG12() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom(updateTime_);
        inBean.setKouteikaisibito(null);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG13() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom(updateTime_);
        inBean.setKouteikaisibito("");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG14() {

        String updateTime_ = "201524271013070681736736";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom(updateTime_);
        inBean.setKouteikaisibito("20160915");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2161", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG15() {

        String updateTime_ = "20152427";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom(updateTime_);
        inBean.setKouteikaisibito("20160915");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2161", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG16() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG17() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom("");
        inBean.setKouteikaisibito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2167", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程開始日付(自)と工程開始日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG18() {

        String updateTime_ = "20152427101307068164346";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom("20000301");
        inBean.setKouteikaisibito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2162", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG19() {

        String updateTime_ = "20152427";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom("20000301");
        inBean.setKouteikaisibito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2162", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程開始日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG20() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG21() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(updateTime_);
        inBean.setKouteikanryoubito("");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG22() {

        String updateTime_ = "201524271013070684944344";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(updateTime_);
        inBean.setKouteikanryoubito("20160930");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2163", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG23() {

        String updateTime_ = "20152427";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(updateTime_);
        inBean.setKouteikanryoubito("20160930");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2163", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(自)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG24() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(null);
        inBean.setKouteikanryoubito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG25() {

        String updateTime_ = "20150101";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom("");
        inBean.setKouteikanryoubito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2168", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程完了日付(自)と工程完了日付(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG26() {

        String updateTime_ = "201524271013070687662334";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom("20000301");
        inBean.setKouteikanryoubito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2164", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG27() {

        String updateTime_ = "20152427";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom("20000301");
        inBean.setKouteikanryoubito(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2164", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：工程完了日付(至)", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG28() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(updateTime_);
        inBean.setSyoruitoutyakuymdto(null);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG29() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(updateTime_);
        inBean.setSyoruitoutyakuymdto("");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG30() {

        String updateTime_ = "20152427101307068482626";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(updateTime_);
        inBean.setSyoruitoutyakuymdto("20160902000000000");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3020", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着自年月日", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG31() {

        String updateTime_ = "20152427101307068";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(updateTime_);
        inBean.setSyoruitoutyakuymdto("20160902000000000");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3020", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着自年月日", outBean.getSyousaimsg());

    }


    @Test
    public void testValidationNG32() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(null);
        inBean.setSyoruitoutyakuymdto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG33() {

        String updateTime_ = "20150101000000000";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom("");
        inBean.setSyoruitoutyakuymdto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3024", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "書類到着日時(自)と書類到着日時(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG34() {

        String updateTime_ = "2015242710130706848484";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom("20000801000000000");
        inBean.setSyoruitoutyakuymdto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着至年月日", outBean.getSyousaimsg());

    }

    @Test
    public void testValidationNG35() {

        String updateTime_ = "20152427101307068";

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom("20000801000000000");
        inBean.setSyoruitoutyakuymdto(updateTime_);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF3023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "日付チェックエラー：書類到着至年月日", outBean.getSyousaimsg());

    }

    @Test
    public void testSyoriLogicNG01() {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setKekkajyougenkensu("0");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2160", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "取得数が、上限件数を超えています。", outBean.getSyousaimsg());

    }

    // testSyoriLogicNG02、testSyoriLogicNG03は
    // #143962によって当該チェック、及びエラーの返却をしなくなったため、コメントアウト
    //
    //    @Test
    //    public void testSyoriLogicNG02() throws Exception {
    //
    //        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
    //
    //        inBean.setAccountid("01000001");
    //        inBean.setFlowid("test3");
    //
    //        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
    //            .GetKouteiSiteiImageProps(inBean);
    //
    //        System.out.println(outBean.getKekkastatus());
    //        System.out.println(outBean.getSyousaimsgcd());
    //        System.out.println(outBean.getSyousaimsg());
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
    //            outBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3021", outBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "トークンIDが取得できませんでした。", outBean.getSyousaimsg());
    //    }
    //
    //    @Test
    //    public void testSyoriLogicNG03() throws Exception {
    //
    //        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
    //
    //        inBean.setAccountid("01000001");
    //        inBean.setGyoumukey("00e2e9auhzqfp7uv9a");
    //
    //        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
    //            .GetKouteiSiteiImageProps(inBean);
    //
    //        System.out.println(outBean.getKekkastatus());
    //        System.out.println(outBean.getSyousaimsgcd());
    //        System.out.println(outBean.getSyousaimsg());
    //
    //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
    //            outBean.getKekkastatus());
    //        assertEquals("詳細メッセージコード:", "IWF3022", outBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", outBean.getSyousaimsg());
    //    }

    @Test
    public void testSyoriLogicNG04() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setFlowid("test");
        inBean.setGyoumukey("00e2e9auhzqfp7uv9a");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF9004", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "データ整合性エラー（対象レコードが存在しません）：対象テーブル＝WM_TorikomiSyorui", outBean.getSyousaimsg());
    }


    @Test
    public void testValidationOK01() throws Exception {


        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void testValidationOK02() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setFlowid("");
        String[] flowIdsList= {""};
        inBean.setFlowids(flowIdsList);
        inBean.setGyoumukey("");
        String[] gyomuKeysList= {""};
        inBean.setGyoumukeys(gyomuKeysList);
        inBean.setTorikomisyoruicd("");
        inBean.setNodename("");
        inBean.setAccountwariateumu("");
        inBean.setKekkajyougenkensu("");
        inBean.setLastsyoritimefrom("");
        inBean.setLastsyoritimeto("");
        inBean.setKouteikaisibifrom("");
        inBean.setKouteikaisibito("");
        inBean.setKouteikanryoubifrom("");
        inBean.setKouteikanryoubito("");
        inBean.setSyoruitoutyakuymdfrom("");
        inBean.setSyoruitoutyakuymdto("");
        String[] sysriStatusList= {""};
        inBean.setSyoristatus(sysriStatusList);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("");
        inBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("");
        inBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("");
        inBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("");
        inBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("");
        inBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("");
        inBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("");
        inBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("");
        inBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("");
        inBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("");
        inBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("");
        inBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("");
        inBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("");
        inBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("");
        inBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("");
        inBean.setExtParam15(extParam15);
        WSExtParam extParam16= new WSExtParam();
        extParam16.setValues("");
        inBean.setExtParam16(extParam16);
        WSExtParam extParam17= new WSExtParam();
        extParam17.setValues("");
        inBean.setExtParam17(extParam17);
        WSExtParam extParam18= new WSExtParam();
        extParam18.setValues("");
        inBean.setExtParam18(extParam18);
        WSExtParam extParam19= new WSExtParam();
        extParam19.setValues("");
        inBean.setExtParam19(extParam19);
        WSExtParam extParam20= new WSExtParam();
        extParam20.setValues("");
        inBean.setExtParam20(extParam20);
        WSExtParam extParam21= new WSExtParam();
        extParam21.setValues("");
        inBean.setExtParam21(extParam21);
        WSExtParam extParam22= new WSExtParam();
        extParam22.setValues("");
        inBean.setExtParam22(extParam22);
        WSExtParam extParam23= new WSExtParam();
        extParam23.setValues("");
        inBean.setExtParam23(extParam23);
        WSExtParam extParam24= new WSExtParam();
        extParam24.setValues("");
        inBean.setExtParam24(extParam24);
        WSExtParam extParam25= new WSExtParam();
        extParam25.setValues("");
        inBean.setExtParam25(extParam25);
        WSExtParam extParam26= new WSExtParam();
        extParam26.setValues("");
        inBean.setExtParam26(extParam26);
        WSExtParam extParam27= new WSExtParam();
        extParam27.setValues("");
        inBean.setExtParam27(extParam27);
        WSExtParam extParam28= new WSExtParam();
        extParam28.setValues("");
        inBean.setExtParam28(extParam28);
        WSExtParam extParam29= new WSExtParam();
        extParam29.setValues("");
        inBean.setExtParam29(extParam29);
        WSExtParam extParam30= new WSExtParam();
        extParam30.setValues("");
        inBean.setExtParam30(extParam30);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        // フローIDがブランクの取込書類コードが存在するため、対象レコード未存在時エラーにはならない。
        // データ上存在することが可能のため、ここは正常終了が正しい
        //        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(),
        //            outBean.getKekkastatus());
        //        assertEquals("詳細メッセージコード:", "IWF9004", outBean.getSyousaimsgcd());
        //        assertEquals("詳細メッセージ:", "データ整合性エラー（対象レコードが存在しません）：対象テーブル＝WM_TorikomiSyorui", outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void testValidationOK03() {

        String psGyoumukey = TOKEN1_GYOUMUKEY;

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setGyoumukey(psGyoumukey);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals(TOKEN1_GYOUMUKEY, psGyoumukey, outBean.getImagepropslist().get(0).getGyoumukey());

    }

    @Test
    public void testValidationOK04() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        String[] gyomuKeysList= {TOKEN1_GYOUMUKEY,TOKEN2_GYOUMUKEY};
        inBean.setGyoumukeys(gyomuKeysList);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() > 1);
    }

    @Test
    public void testValidationOK05() {

        String psGyoumukey = TOKEN1_GYOUMUKEY;
        String[] psGyoumukeys = { TOKEN2_GYOUMUKEY };

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setGyoumukey(psGyoumukey);
        inBean.setGyoumukeys(psGyoumukeys);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals(TOKEN2_GYOUMUKEY, psGyoumukeys[0], outBean
            .getImagepropslist().get(0).getGyoumukey());

    }

    @Test
    public void testValidationOK06() {
        String psFlowId = TOKEN1_FLOWID;

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setFlowid(psFlowId);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals(TOKEN1_FLOWID, psFlowId,
            outBean.getImagepropslist().get(0).getFlowid());

    }

    @Test
    public void testValidationOK07() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        String[] flowIdsList= {TOKEN1_FLOWID,TOKEN2_FLOWID};
        inBean.setFlowids(flowIdsList);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() > 1);
    }

    @Test
    public void testValidationOK08() {

        String psFlowId = TOKEN1_FLOWID;
        String flowId = TOKEN2_FLOWID;
        String[] psFlowIds = { flowId };

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setFlowid(psFlowId);
        inBean.setFlowids(psFlowIds);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(),
            outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals(TOKEN2_FLOWID, flowId, outBean.getImagepropslist()
            .get(0).getFlowid());

    }

    @Test
    public void testValidationOK09() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setLastsyoritimefrom(PRE_DATE + "000000000");
        inBean.setLastsyoritimeto(NEXT_DATE + "000000000");
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() > 1);
    }

    @Test
    public void testValidationOK10() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setKouteikaisibifrom(PRE_DATE);
        inBean.setKouteikaisibito(NEXT_DATE);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK11() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setKouteikanryoubifrom(PRE_DATE);
        inBean.setKouteikanryoubito(NEXT_DATE);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK12() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setSyoruitoutyakuymdfrom(PRE_DATE + "000000000");
        inBean.setSyoruitoutyakuymdto(NEXT_DATE + "000000000");
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK13() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        String[] sysriStatusList= {"90"};
        inBean.setSyoristatus(sysriStatusList);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
        assertEquals("90", outBean.getImagepropslist().get(0).getKouteijyoutai());
    }

    @Test
    public void testValidationOK14() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        String[] sysriStatusList= {"99","90"};
        inBean.setSyoristatus(sysriStatusList);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK15() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setTantousyaAccountid(TOKEN3_TSKUSER);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);
        lockToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID);
        forwardToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID,"input","tenken");
        unlockToken(TOKEN3_GYOUMUKEY,TOKEN3_FLOWID);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals(TOKEN3_GYOUMUKEY, outBean.getImagepropslist().get(0).getGyoumukey());
        assertEquals(TOKEN3_FLOWID, outBean.getImagepropslist().get(0).getFlowid());
    }

    @Test
    public void testValidationOK16() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setNodename("end-state1");
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK17() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setAccountwariateumu("1");
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    @Test
    public void testValidationOK18() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setAccountwariateumu("1");
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
    }

    // testSyoriLogicNG01で同じテストを実行しているため、コメントアウト
    //
    //    @Test
    //    public void testValidationOK19() {
    //
    //        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
    //        inBean.setAccountid("01000001");
    //        String[] gyomuKeysList= {TOKEN1_GYOUMUKEY,TOKEN2_GYOUMUKEY};
    //        inBean.setGyoumukeys(gyomuKeysList);
    //
    //        inBean.setKekkajyougenkensu("1");
    //
    //        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
    //            .GetKouteiSiteiImageProps(inBean);
    //
    //        System.out.println(outBean.getKekkastatus());
    //        System.out.println(outBean.getSyousaimsgcd());
    //        System.out.println(outBean.getSyousaimsg());
    //
    //        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
    //        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
    //
    //    }

    @Test
    public void testValidationOK20() {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("01000001");
        inBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        String jougenKensu = "1";
        inBean.setKekkajyougenkensu(jougenKensu);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient
            .GetKouteiSiteiImageProps(inBean);

        System.out.println(outBean.getKekkastatus());
        System.out.println(outBean.getSyousaimsgcd());
        System.out.println(outBean.getSyousaimsg());

        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals("件数比較", Integer.parseInt(jougenKensu), outBean.getImagepropslist().size());

    }

    @Test
    public void testValidationOK21() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        String value = "デフォルト追加パラメータ８";

        WSExtParam extParam8 = new WSExtParam();
        inBean.setAccountid("01000001");
        extParam8.setValues(value);
        inBean.setExtParam8(extParam8);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
        assertEquals(value, outBean.getImagepropslist().get(0).getExtparamBean().getExtparam8());
    }

    @Test
    public void testValidationOK22() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        inBean.setTorikomisyoruicd(TOKEN1_SYORUICD);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue(outBean.getImagepropslist().size() >= 1);
        assertEquals(TOKEN1_SYORUICD, outBean.getImagepropslist().get(0).getTorikomisyoruicd());
    }

    @Test
    public void testValidationOK23() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();

        inBean.setAccountid("01000001");
        String[] flowIdsList= {TOKEN2_FLOWID};
        inBean.setFlowids(flowIdsList);
        String[] gyomuKeysList= {TOKEN2_GYOUMUKEY};
        inBean.setGyoumukeys(gyomuKeysList);
        inBean.setTorikomisyoruicd(TOKEN2_SYORUICD);
        inBean.setNodename("end-state1");
        inBean.setAccountwariateumu("1");
        inBean.setKekkajyougenkensu("100");
        inBean.setLastsyoritimefrom(PRE_DATE + "000000000");
        inBean.setLastsyoritimeto(NEXT_DATE + "000000000");
        inBean.setKouteikaisibifrom(PRE_DATE);
        inBean.setKouteikaisibito(NEXT_DATE);
        inBean.setKouteikanryoubifrom(PRE_DATE);
        inBean.setKouteikanryoubito(NEXT_DATE);
        inBean.setSyoruitoutyakuymdfrom(PRE_DATE + "000000000");
        inBean.setSyoruitoutyakuymdto(NEXT_DATE + "000000000");
        String[] sysriStatusList= {"90"};
        inBean.setSyoristatus(sysriStatusList);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(EXPARAM1_VALUE);
        inBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("デフォルト追加パラメータ２");
        inBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("デフォルト追加パラメータ３");
        inBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("デフォルト追加パラメータ４");
        inBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("デフォルト追加パラメータ５");
        inBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("デフォルト追加パラメータ６");
        inBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("デフォルト追加パラメータ７");
        inBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("デフォルト追加パラメータ８");
        inBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("デフォルト追加パラメータ９");
        inBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("デフォルト追加パラメータ１０");
        inBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("デフォルト追加パラメータ１１");
        inBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("デフォルト追加パラメータ１２");
        inBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("デフォルト追加パラメータ１３");
        inBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("デフォルト追加パラメータ１４");
        inBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("デフォルト追加パラメータ１５");
        inBean.setExtParam15(extParam15);
        WSExtParam extParam16 = new WSExtParam();
        extParam16.setValues("デフォルト追加パラメータ１６");
        inBean.setExtParam16(extParam16);
        WSExtParam extParam17 = new WSExtParam();
        extParam17.setValues("デフォルト追加パラメータ１７");
        inBean.setExtParam17(extParam17);
        WSExtParam extParam18 = new WSExtParam();
        extParam18.setValues("デフォルト追加パラメータ１８");
        inBean.setExtParam18(extParam18);
        WSExtParam extParam19 = new WSExtParam();
        extParam19.setValues("デフォルト追加パラメータ１９");
        inBean.setExtParam19(extParam19);
        WSExtParam extParam20 = new WSExtParam();
        extParam20.setValues("デフォルト追加パラメータ２０");
        inBean.setExtParam20(extParam20);
        WSExtParam extParam21 = new WSExtParam();
        extParam21.setValues("デフォルト追加パラメータ２１");
        inBean.setExtParam21(extParam21);
        WSExtParam extParam22 = new WSExtParam();
        extParam22.setValues("デフォルト追加パラメータ２２");
        inBean.setExtParam22(extParam22);
        WSExtParam extParam23 = new WSExtParam();
        extParam23.setValues("デフォルト追加パラメータ２３");
        inBean.setExtParam23(extParam23);
        WSExtParam extParam24 = new WSExtParam();
        extParam24.setValues("デフォルト追加パラメータ２４");
        inBean.setExtParam24(extParam24);
        WSExtParam extParam25 = new WSExtParam();
        extParam25.setValues("デフォルト追加パラメータ２５");
        inBean.setExtParam25(extParam25);
        WSExtParam extParam26 = new WSExtParam();
        extParam26.setValues("デフォルト追加パラメータ２６");
        inBean.setExtParam26(extParam26);
        WSExtParam extParam27 = new WSExtParam();
        extParam27.setValues("デフォルト追加パラメータ２７");
        inBean.setExtParam27(extParam27);
        WSExtParam extParam28 = new WSExtParam();
        extParam28.setValues("デフォルト追加パラメータ２８");
        inBean.setExtParam28(extParam28);
        WSExtParam extParam29 = new WSExtParam();
        extParam29.setValues("デフォルト追加パラメータ２９");
        inBean.setExtParam29(extParam29);
        WSExtParam extParam30 = new WSExtParam();
        extParam30.setValues("デフォルト追加パラメータ３０");
        inBean.setExtParam30(extParam30);

        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals(1, outBean.getImagepropslist().size());
        //        assertEquals("イメージＩＤ1_11", outBean.getImagepropslist().get(0).getImageid());
        assertEquals(TOKEN2_GYOUMUKEY, outBean.getImagepropslist().get(0).getGyoumukey());
        assertEquals(TOKEN2_SYORUICD, outBean.getImagepropslist().get(0).getTorikomisyoruicd());
        //        assertEquals("20170201000000000", outBean.getImagepropslist().get(0).getSyoruitoutyakutime());
        //        assertEquals("20160817144146277", outBean.getImagepropslist().get(0).getTourokutime());
        assertEquals("90", outBean.getImagepropslist().get(0).getKouteijyoutai());
        assertEquals("0", outBean.getImagepropslist().get(0).getKengenumu());
        assertEquals("imageUser", outBean.getImagepropslist().get(0).getTourokuaccountid());
        assertEquals(TOKEN2_FLOWID, outBean.getImagepropslist().get(0).getFlowid());
        assertEquals(EXPARAM1_VALUE, outBean.getImagepropslist().get(0).getExtparamBean().getExtparam1());
        assertEquals("デフォルト追加パラメータ２", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam2());
        assertEquals("デフォルト追加パラメータ３", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam3());
        assertEquals("デフォルト追加パラメータ４", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam4());
        assertEquals("デフォルト追加パラメータ５", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam5());
        assertEquals("デフォルト追加パラメータ６", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam6());
        assertEquals("デフォルト追加パラメータ７", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam7());
        assertEquals("デフォルト追加パラメータ８", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam8());
        assertEquals("デフォルト追加パラメータ９", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam9());
        assertEquals("デフォルト追加パラメータ１０", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam10());
        assertEquals("デフォルト追加パラメータ１１", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam11());
        assertEquals("デフォルト追加パラメータ１２", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam12());
        assertEquals("デフォルト追加パラメータ１３", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam13());
        assertEquals("デフォルト追加パラメータ１４", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam14());
        assertEquals("デフォルト追加パラメータ１５", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam15());
        assertEquals("デフォルト追加パラメータ１６", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam16());
        assertEquals("デフォルト追加パラメータ１７", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam17());
        assertEquals("デフォルト追加パラメータ１８", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam18());
        assertEquals("デフォルト追加パラメータ１９", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam19());
        assertEquals("デフォルト追加パラメータ２０", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam20());
        assertEquals("デフォルト追加パラメータ２１", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam21());
        assertEquals("デフォルト追加パラメータ２２", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam22());
        assertEquals("デフォルト追加パラメータ２３", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam23());
        assertEquals("デフォルト追加パラメータ２４", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam24());
        assertEquals("デフォルト追加パラメータ２５", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam25());
        assertEquals("デフォルト追加パラメータ２６", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam26());
        assertEquals("デフォルト追加パラメータ２７", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam27());
        assertEquals("デフォルト追加パラメータ２８", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam28());
        assertEquals("デフォルト追加パラメータ２９", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam29());
        assertEquals("デフォルト追加パラメータ３０", outBean.getImagepropslist().get(0).getExtparamBean().getExtparam30());

    }

    @Test
    public void testSyoriLogicOK01() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("administrator");
        inBean.setGyoumukey(TOKEN3_GYOUMUKEY);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals(2, outBean.getImagepropslist().size());
        assertNotEquals(outBean.getImagepropslist().get(1).getImageid(),outBean.getImagepropslist().get(0).getImageid());
        assertEquals(outBean.getImagepropslist().get(0).getGyoumukey(), outBean.getImagepropslist().get(1).getGyoumukey());
    }

    @Test
    public void testSyoriLogicOK02() throws Exception {

        GetKouteiSiteiImagePropsInBean inBean = new GetKouteiSiteiImagePropsInBean();
        inBean.setAccountid("administrator");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(EXPARAM1_VALUE);
        inBean.setExtParam1(extParam1);
        GetKouteiSiteiImagePropsOutBean outBean = iwfImageClient.GetKouteiSiteiImageProps(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", outBean.getSyousaimsg());
        assertEquals(4, outBean.getImagepropslist().size());
        List<String> gyoumukeyList = new ArrayList<>();
        for(ImagePropsBean bean : outBean.getImagepropslist()){
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
            poExtparam1.setValues(EXPARAM1_VALUE);
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

    @Transactional
    public void updateKouteiKanryouYmd(String pGyoumukey){
        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(pGyoumukey);
        kouteiSummary.setKouteiKanryouYmd(BizDate.getSysDate().toString());
        iwfCoreDomManager.update(kouteiSummary);
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

    private String startTask(String pKey,String pFlowid,String pWariateUser, String pTaskId) {
        StartTaskInBean taskInBean = new StartTaskInBean();
        taskInBean.setAccountid(pWariateUser);
        taskInBean.setFlowid(pFlowid);
        taskInBean.setGyoumukey(pKey);
        taskInBean.setTaskname(pTaskId);
        taskInBean.setLockkey(pKey);
        iwfKouteiClient.execStartTask(taskInBean);
        return pKey;
    }

    private String putImage(String pKey,String pFlowid, String pSyoruiCd) {
        PutImageInBean imageInBean = new PutImageInBean();
        imageInBean.setAccountid("imageUser");
        imageInBean.setFlowid(pFlowid);
        imageInBean.setGyoumukey(pKey);
        byte[] pbImagedata = readTestFile("putimage/Test.pdf");
        imageInBean.setImagedata(pbImagedata);
        imageInBean.setSyoruicd(pSyoruiCd);
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