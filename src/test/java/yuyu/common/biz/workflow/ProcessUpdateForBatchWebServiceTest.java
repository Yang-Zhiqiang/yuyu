package yuyu.common.biz.workflow;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import net.arnx.jsonic.JSON;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 工程情報更新(バッチ用）Webサービス {@link WSexecProcessUpdateForBatchForBatch#executeBizMain(WSexecProcessUpdateForBatchRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessUpdateForBatchWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    @Inject
    UniqueKeyGenerator uniqueKeyGenerator;

    private static boolean isSetupComplete = false;

    private final ProcessUpdateForBatchOutBean checkBean_Success = createSuccessCheckBean();

    private final static String TOKEN1_GYOUMUKEY = IwfDateUtils.getSysDate();
    private final static String TOKEN1_FLOWID = "nksssaihakkou";
    private final static String TOKEN2_GYOUMUKEY = IwfDateUtils.getSysDate();
    private final static String TOKEN2_FLOWID = "khjyuusyohenkou";

    @Before
    public void beforeSetUp(){
        if(!isSetupComplete){
            createToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
            createToken(TOKEN2_GYOUMUKEY,TOKEN2_FLOWID);
            isSetupComplete = true;
        }
    }

    @Test(expected = RuntimeException.class)
    public void ChkValidate_Required_InBean() {
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(null);
    }

    @Test
    public void Success_ChkKouteiSummary() {

        WT_KouteiSummary before1WT_KouteiSummary = new WT_KouteiSummary();
        WT_KouteiSummary after1WT_KouteiSummary = iwfCoreDomManager.getKouteiSummary(TOKEN1_GYOUMUKEY);
        BeanUtil.copyProperties(before1WT_KouteiSummary, after1WT_KouteiSummary);

        String accountId = uniqueKeyGenerator.generateUniqueKey();
        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid(accountId);
        List<ProcessUpdateForBatchBean> updateBeans = new ArrayList<>();

        ProcessUpdateForBatchBean updateBean = new ProcessUpdateForBatchBean();
        updateBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        updateBean.setFlowid(TOKEN1_FLOWID);
        setExtInfo(updateBean, "SUCCESS付加情報のキー", "SUCCESS付加情報の値");
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
        String extParamValue1 = "追加パラメータ１";
        String extParamValue2 = "追加パラメータ２";
        String extParamValue3 = "追加パラメータ３";
        String extParamValue4 = "追加パラメータ４";
        String extParamValue5 = "追加パラメータ５";
        String extParamValue6 = "追加パラメータ６";
        String extParamValue7 = "追加パラメータ７";
        String extParamValue8 = "追加パラメータ８";
        String extParamValue9 = "追加パラメータ９";
        String extParamValue10 = "追加パラメータ１０";
        String extParamValue11 = "追加パラメータ１１";
        String extParamValue12 = "追加パラメータ１２";
        String extParamValue13 = "追加パラメータ１３";
        String extParamValue14 = "追加パラメータ１４";
        String extParamValue15 = "追加パラメータ１５";
        String extParamValue16 = "追加パラメータ１６";
        String extParamValue17 = "追加パラメータ１７";
        String extParamValue18 = "追加パラメータ１８";
        String extParamValue19 = "追加パラメータ１９";
        String extParamValue20 = "追加パラメータ２０";
        String extParamValue21 = "追加パラメータ２１";
        String extParamValue22 = "追加パラメータ２２";
        String extParamValue23 = "追加パラメータ２３";
        String extParamValue24 = "追加パラメータ２４";
        String extParamValue25 = "追加パラメータ２５";
        String extParamValue26 = "追加パラメータ２６";
        String extParamValue27 = "追加パラメータ２７";
        String extParamValue28 = "追加パラメータ２８";
        String extParamValue29 = "追加パラメータ２９";
        String extParamValue30 = "追加パラメータ３０";
        poExtparam1.setValues(extParamValue1);
        poExtparam2.setValues(extParamValue2);
        poExtparam3.setValues(extParamValue3);
        poExtparam4.setValues(extParamValue4);
        poExtparam5.setValues(extParamValue5);
        poExtparam6.setValues(extParamValue6);
        poExtparam7.setValues(extParamValue7);
        poExtparam8.setValues(extParamValue8);
        poExtparam9.setValues(extParamValue9);
        poExtparam10.setValues(extParamValue10);
        poExtparam11.setValues(extParamValue11);
        poExtparam12.setValues(extParamValue12);
        poExtparam13.setValues(extParamValue13);
        poExtparam14.setValues(extParamValue14);
        poExtparam15.setValues(extParamValue15);
        poExtparam16.setValues(extParamValue16);
        poExtparam17.setValues(extParamValue17);
        poExtparam18.setValues(extParamValue18);
        poExtparam19.setValues(extParamValue19);
        poExtparam20.setValues(extParamValue20);
        poExtparam21.setValues(extParamValue21);
        poExtparam22.setValues(extParamValue22);
        poExtparam23.setValues(extParamValue23);
        poExtparam24.setValues(extParamValue24);
        poExtparam25.setValues(extParamValue25);
        poExtparam26.setValues(extParamValue26);
        poExtparam27.setValues(extParamValue27);
        poExtparam28.setValues(extParamValue28);
        poExtparam29.setValues(extParamValue29);
        poExtparam30.setValues(extParamValue30);
        updateBean.setExtParam1(poExtparam1);
        updateBean.setExtParam2(poExtparam2);
        updateBean.setExtParam3(poExtparam3);
        updateBean.setExtParam4(poExtparam4);
        updateBean.setExtParam5(poExtparam5);
        updateBean.setExtParam6(poExtparam6);
        updateBean.setExtParam7(poExtparam7);
        updateBean.setExtParam8(poExtparam8);
        updateBean.setExtParam9(poExtparam9);
        updateBean.setExtParam10(poExtparam10);
        updateBean.setExtParam11(poExtparam11);
        updateBean.setExtParam12(poExtparam12);
        updateBean.setExtParam13(poExtparam13);
        updateBean.setExtParam14(poExtparam14);
        updateBean.setExtParam15(poExtparam15);
        updateBean.setExtParam16(poExtparam16);
        updateBean.setExtParam17(poExtparam17);
        updateBean.setExtParam18(poExtparam18);
        updateBean.setExtParam19(poExtparam19);
        updateBean.setExtParam20(poExtparam20);
        updateBean.setExtParam21(poExtparam21);
        updateBean.setExtParam22(poExtparam22);
        updateBean.setExtParam23(poExtparam23);
        updateBean.setExtParam24(poExtparam24);
        updateBean.setExtParam25(poExtparam25);
        updateBean.setExtParam26(poExtparam26);
        updateBean.setExtParam27(poExtparam27);
        updateBean.setExtParam28(poExtparam28);
        updateBean.setExtParam29(poExtparam29);
        updateBean.setExtParam30(poExtparam30);
        updateBeans.add(updateBean);
        inBean.setProcessUpdateForBatchBeanList(updateBeans);

        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));

        boolean a = iwfCoreDomManager.isManaged(after1WT_KouteiSummary);

        assertThat(before1WT_KouteiSummary.getGyoumuKey(),is(after1WT_KouteiSummary.getGyoumuKey()));
        assertThat(before1WT_KouteiSummary.getFlowId(),is(after1WT_KouteiSummary.getFlowId()));
        assertThat(before1WT_KouteiSummary.getSyokaiAccountId(),is(after1WT_KouteiSummary.getSyokaiAccountId()));
        assertThat(before1WT_KouteiSummary.getZenkaiAccountId(),is(after1WT_KouteiSummary.getZenkaiAccountId()));
        assertThat(before1WT_KouteiSummary.getZenkaiNodeNm(),is(after1WT_KouteiSummary.getZenkaiNodeNm()));
        assertThat(before1WT_KouteiSummary.getZenkaiTaskLocalNm(),is(after1WT_KouteiSummary.getZenkaiTaskLocalNm()));
        assertThat(before1WT_KouteiSummary.getNodeNm(),is(after1WT_KouteiSummary.getNodeNm()));
        assertThat(before1WT_KouteiSummary.getGenzaiAccountId(),is(after1WT_KouteiSummary.getGenzaiAccountId()));
        assertThat(before1WT_KouteiSummary.getGenzaiTaskLocalNm(),is(after1WT_KouteiSummary.getGenzaiTaskLocalNm()));
        assertThat(before1WT_KouteiSummary.getIwfKouteiKaisiYmd(),is(after1WT_KouteiSummary.getIwfKouteiKaisiYmd()));
        assertThat(before1WT_KouteiSummary.getKouteiKanryouYmd(),is(after1WT_KouteiSummary.getKouteiKanryouYmd()));
        assertThat(before1WT_KouteiSummary.getSyoriStatus(),is(after1WT_KouteiSummary.getSyoriStatus()));

        assertThat(before1WT_KouteiSummary.getLastSyoriTime(),is(not(after1WT_KouteiSummary.getLastSyoriTime())));

        assertThat(after1WT_KouteiSummary.getExtParam1(),is(extParamValue1));
        assertThat(after1WT_KouteiSummary.getExtParam2(),is(extParamValue2));
        assertThat(after1WT_KouteiSummary.getExtParam3(),is(extParamValue3));
        assertThat(after1WT_KouteiSummary.getExtParam4(),is(extParamValue4));
        assertThat(after1WT_KouteiSummary.getExtParam5(),is(extParamValue5));
        assertThat(after1WT_KouteiSummary.getExtParam6(),is(extParamValue6));
        assertThat(after1WT_KouteiSummary.getExtParam7(),is(extParamValue7));
        assertThat(after1WT_KouteiSummary.getExtParam8(),is(extParamValue8));
        assertThat(after1WT_KouteiSummary.getExtParam9(),is(extParamValue9));
        assertThat(after1WT_KouteiSummary.getExtParam10(),is(extParamValue10));
        assertThat(after1WT_KouteiSummary.getExtParam11(),is(extParamValue11));
        assertThat(after1WT_KouteiSummary.getExtParam12(),is(extParamValue12));
        assertThat(after1WT_KouteiSummary.getExtParam13(),is(extParamValue13));
        assertThat(after1WT_KouteiSummary.getExtParam14(),is(extParamValue14));
        assertThat(after1WT_KouteiSummary.getExtParam15(),is(extParamValue15));
        assertThat(after1WT_KouteiSummary.getExtParam16(),is(extParamValue16));
        assertThat(after1WT_KouteiSummary.getExtParam17(),is(extParamValue17));
        assertThat(after1WT_KouteiSummary.getExtParam18(),is(extParamValue18));
        assertThat(after1WT_KouteiSummary.getExtParam19(),is(extParamValue19));
        assertThat(after1WT_KouteiSummary.getExtParam20(),is(extParamValue20));
        assertThat(after1WT_KouteiSummary.getExtParam21(),is(extParamValue21));
        assertThat(after1WT_KouteiSummary.getExtParam22(),is(extParamValue22));
        assertThat(after1WT_KouteiSummary.getExtParam23(),is(extParamValue23));
        assertThat(after1WT_KouteiSummary.getExtParam24(),is(extParamValue24));
        assertThat(after1WT_KouteiSummary.getExtParam25(),is(extParamValue25));
        assertThat(after1WT_KouteiSummary.getExtParam26(),is(extParamValue26));
        assertThat(after1WT_KouteiSummary.getExtParam27(),is(extParamValue27));
        assertThat(after1WT_KouteiSummary.getExtParam28(),is(extParamValue28));
        assertThat(after1WT_KouteiSummary.getExtParam29(),is(extParamValue29));
        assertThat(after1WT_KouteiSummary.getExtParam30(),is(extParamValue30));
    }

    @Test
    public void Success_ChkKouteiRireki(){
        String accountId = uniqueKeyGenerator.generateUniqueKey();
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid(accountId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));

        WT_KouteiSummary wt_KouteiSummary = iwfCoreDomManager.getKouteiSummary(TOKEN1_GYOUMUKEY);
        WT_GyoumuKey wt_GyoumuKey = iwfCoreDomManager.getGyoumuKey(TOKEN1_FLOWID,TOKEN1_GYOUMUKEY);
        List<WT_KouteiRireki> wt_KouteiRirekiList = iwfCoreDomManager.getKouteiRirekis(TOKEN1_GYOUMUKEY, TOKEN1_FLOWID, C_RirekiKbn.SYSTEM);
        for(WT_KouteiRireki wt_KouteiRireki : wt_KouteiRirekiList){
            if(accountId.equals(wt_KouteiRireki.getUserId())){
                assertThat(wt_KouteiRireki.getTokenId(),is(wt_GyoumuKey.getTokenId()));
                assertThat(wt_KouteiRireki.getGyoumuKey(),is(TOKEN1_GYOUMUKEY));
                assertThat(wt_KouteiRireki.getSyoriTime(),is(wt_KouteiSummary.getLastSyoriTime()));
                assertThat(wt_KouteiRireki.getFlowId(),is(TOKEN1_FLOWID));
                assertThat(wt_KouteiRireki.getNodeNm(),is(wt_KouteiSummary.getNodeNm()));
                assertThat(wt_KouteiRireki.getIwfSyoriKbn(),is(C_IwfSyoriKbn.UPDATE));
                assertThat(wt_KouteiRireki.getRrkMsg(),is(C_IwfSyoriKbn.UPDATE.getContent()));

                List<Map<String, String>> extInfoList = new ArrayList<>();
                if (null != wt_KouteiRireki.getExtInfo()) {
                    try{
                        String sExtInfo = IwfBase64Urls.encodeFromString(new String(wt_KouteiRireki.getExtInfo(), "UTF-8"));
                        extInfoList = (List<Map<String, String>>) JSON.decode(IwfBase64Urls
                            .decodeToString(sExtInfo));
                    } catch(Exception e){
                        assertThat(true,is(false));
                    }
                }
                assertThat(extInfoList.get(0),hasEntry("付加情報のキー", "付加情報の値"));

                break;
            }
        }
    }

    @Test
    public void Success_AllExtParam_Null(){
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().set(0, (ProcessUpdateForBatchBean) setExtParam(inBean.getProcessUpdateForBatchBeanList().get(0),true));
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));

        WT_KouteiSummary wt_KouteiSummary = iwfCoreDomManager.getKouteiSummary(TOKEN1_GYOUMUKEY);
        assertThat(wt_KouteiSummary.getExtParam1(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam2(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam3(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam4(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam5(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam6(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam7(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam8(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam9(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam10(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam11(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam12(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam13(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam14(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam15(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam16(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam17(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam18(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam19(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam20(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam21(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam22(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam23(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam24(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam25(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam26(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam27(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam28(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam29(),is(nullValue()));
        assertThat(wt_KouteiSummary.getExtParam30(),is(nullValue()));
    }

    @Test
    public void Success_Required_Min(){

        WT_KouteiSummary before1WT_KouteiSummary = new WT_KouteiSummary();
        WT_KouteiSummary after1WT_KouteiSummary = iwfCoreDomManager.getKouteiSummary(TOKEN1_GYOUMUKEY);
        BeanUtil.copyProperties(before1WT_KouteiSummary, after1WT_KouteiSummary);

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();
        ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
        bean.setGyoumukey(TOKEN1_GYOUMUKEY);
        bean.setFlowid(TOKEN1_FLOWID);
        beanList.add(bean);
        inBean.setProcessUpdateForBatchBeanList(beanList);

        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
        assertThat(before1WT_KouteiSummary.getLastSyoriTime(),is(not(after1WT_KouteiSummary.getLastSyoriTime())));
        assertThat(after1WT_KouteiSummary.getExtParam1(),is(before1WT_KouteiSummary.getExtParam1()));
        assertThat(after1WT_KouteiSummary.getExtParam2(),is(before1WT_KouteiSummary.getExtParam2()));
        assertThat(after1WT_KouteiSummary.getExtParam3(),is(before1WT_KouteiSummary.getExtParam3()));
        assertThat(after1WT_KouteiSummary.getExtParam4(),is(before1WT_KouteiSummary.getExtParam4()));
        assertThat(after1WT_KouteiSummary.getExtParam5(),is(before1WT_KouteiSummary.getExtParam5()));
        assertThat(after1WT_KouteiSummary.getExtParam6(),is(before1WT_KouteiSummary.getExtParam6()));
        assertThat(after1WT_KouteiSummary.getExtParam7(),is(before1WT_KouteiSummary.getExtParam7()));
        assertThat(after1WT_KouteiSummary.getExtParam8(),is(before1WT_KouteiSummary.getExtParam8()));
        assertThat(after1WT_KouteiSummary.getExtParam9(),is(before1WT_KouteiSummary.getExtParam9()));
        assertThat(after1WT_KouteiSummary.getExtParam10(),is(before1WT_KouteiSummary.getExtParam10()));
        assertThat(after1WT_KouteiSummary.getExtParam11(),is(before1WT_KouteiSummary.getExtParam11()));
        assertThat(after1WT_KouteiSummary.getExtParam12(),is(before1WT_KouteiSummary.getExtParam12()));
        assertThat(after1WT_KouteiSummary.getExtParam13(),is(before1WT_KouteiSummary.getExtParam13()));
        assertThat(after1WT_KouteiSummary.getExtParam14(),is(before1WT_KouteiSummary.getExtParam14()));
        assertThat(after1WT_KouteiSummary.getExtParam15(),is(before1WT_KouteiSummary.getExtParam15()));
        assertThat(after1WT_KouteiSummary.getExtParam16(),is(before1WT_KouteiSummary.getExtParam16()));
        assertThat(after1WT_KouteiSummary.getExtParam17(),is(before1WT_KouteiSummary.getExtParam17()));
        assertThat(after1WT_KouteiSummary.getExtParam18(),is(before1WT_KouteiSummary.getExtParam18()));
        assertThat(after1WT_KouteiSummary.getExtParam19(),is(before1WT_KouteiSummary.getExtParam19()));
        assertThat(after1WT_KouteiSummary.getExtParam20(),is(before1WT_KouteiSummary.getExtParam20()));
        assertThat(after1WT_KouteiSummary.getExtParam21(),is(before1WT_KouteiSummary.getExtParam21()));
        assertThat(after1WT_KouteiSummary.getExtParam22(),is(before1WT_KouteiSummary.getExtParam22()));
        assertThat(after1WT_KouteiSummary.getExtParam23(),is(before1WT_KouteiSummary.getExtParam23()));
        assertThat(after1WT_KouteiSummary.getExtParam24(),is(before1WT_KouteiSummary.getExtParam24()));
        assertThat(after1WT_KouteiSummary.getExtParam25(),is(before1WT_KouteiSummary.getExtParam25()));
        assertThat(after1WT_KouteiSummary.getExtParam26(),is(before1WT_KouteiSummary.getExtParam26()));
        assertThat(after1WT_KouteiSummary.getExtParam27(),is(before1WT_KouteiSummary.getExtParam27()));
        assertThat(after1WT_KouteiSummary.getExtParam28(),is(before1WT_KouteiSummary.getExtParam28()));
        assertThat(after1WT_KouteiSummary.getExtParam29(),is(before1WT_KouteiSummary.getExtParam29()));
        assertThat(after1WT_KouteiSummary.getExtParam30(),is(before1WT_KouteiSummary.getExtParam30()));
    }

    @Test
    public void ChkReturnErrGyoumukey_Varidation(){

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();

        for(int i = 0; i <= 10 ; i++  ){
            ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
            bean.setGyoumukey(createToken(null,TOKEN1_FLOWID));
            bean.setFlowid(TOKEN1_FLOWID);
            beanList.add(bean);
        }

        String errGyoumukey = beanList.get(4).getGyoumukey();
        beanList.get(4).setFlowid(null);

        inBean.setProcessUpdateForBatchBeanList(beanList);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：フローＩＤ"
            ,errGyoumukey);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkReturnErrGyoumukey_Main(){

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();

        for(int i = 0; i <= 10 ; i++  ){
            ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
            bean.setGyoumukey(createToken(null,TOKEN1_FLOWID));
            bean.setFlowid(TOKEN1_FLOWID);
            beanList.add(bean);
        }

        String errGyoumukey = beanList.get(6).getGyoumukey();
        beanList.get(6).setFlowid("存在しないフローID");

        inBean.setProcessUpdateForBatchBeanList(beanList);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF2022
            ,"プロセス定義が取得できませんでした。"
            ,errGyoumukey);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void Success_ManyBean(){

        Map<String, WSExtParam> map = new HashMap<>();
        List<WT_KouteiSummary> kouteiSummaryList = iwfCoreDomManager.getKouteiSummarys(new String[]{TOKEN1_GYOUMUKEY,TOKEN2_GYOUMUKEY},null,null,null,null,null,null,null,null,null,null,null,map);
        WT_KouteiSummary after1WT_KouteiSummary = kouteiSummaryList.get(0);
        WT_KouteiSummary after2WT_KouteiSummary = kouteiSummaryList.get(1);
        WT_KouteiSummary before1WT_KouteiSummary = new WT_KouteiSummary();
        WT_KouteiSummary before2WT_KouteiSummary = new WT_KouteiSummary();
        BeanUtil.copyProperties(before1WT_KouteiSummary, after1WT_KouteiSummary);
        BeanUtil.copyProperties(before2WT_KouteiSummary, after2WT_KouteiSummary);

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();

        ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
        bean.setGyoumukey(TOKEN1_GYOUMUKEY);
        bean.setFlowid(TOKEN1_FLOWID);
        WSExtParam poExtparam15 = new WSExtParam();
        String valueProperty1 = "複数更新テスト１";
        poExtparam15.setValues(valueProperty1);
        bean.setExtParam15(poExtparam15);
        beanList.add(bean);

        ProcessUpdateForBatchBean bean2 = new ProcessUpdateForBatchBean();
        bean2.setGyoumukey(TOKEN2_GYOUMUKEY);
        bean2.setFlowid(TOKEN2_FLOWID);
        WSExtParam poExtparam30 = new WSExtParam();
        String valueProperty2 = "複数更新テスト２";
        poExtparam30.setValues(valueProperty2);
        bean2.setExtParam30(poExtparam30);
        beanList.add(bean2);

        inBean.setProcessUpdateForBatchBeanList(beanList);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));

        assertThat(before1WT_KouteiSummary.getLastSyoriTime(),is(not(after1WT_KouteiSummary.getLastSyoriTime())));
        assertThat(after1WT_KouteiSummary.getExtParam1(),is(before1WT_KouteiSummary.getExtParam1()));
        assertThat(after1WT_KouteiSummary.getExtParam2(),is(before1WT_KouteiSummary.getExtParam2()));
        assertThat(after1WT_KouteiSummary.getExtParam3(),is(before1WT_KouteiSummary.getExtParam3()));
        assertThat(after1WT_KouteiSummary.getExtParam4(),is(before1WT_KouteiSummary.getExtParam4()));
        assertThat(after1WT_KouteiSummary.getExtParam5(),is(before1WT_KouteiSummary.getExtParam5()));
        assertThat(after1WT_KouteiSummary.getExtParam6(),is(before1WT_KouteiSummary.getExtParam6()));
        assertThat(after1WT_KouteiSummary.getExtParam7(),is(before1WT_KouteiSummary.getExtParam7()));
        assertThat(after1WT_KouteiSummary.getExtParam8(),is(before1WT_KouteiSummary.getExtParam8()));
        assertThat(after1WT_KouteiSummary.getExtParam9(),is(before1WT_KouteiSummary.getExtParam9()));
        assertThat(after1WT_KouteiSummary.getExtParam10(),is(before1WT_KouteiSummary.getExtParam10()));
        assertThat(after1WT_KouteiSummary.getExtParam11(),is(before1WT_KouteiSummary.getExtParam11()));
        assertThat(after1WT_KouteiSummary.getExtParam12(),is(before1WT_KouteiSummary.getExtParam12()));
        assertThat(after1WT_KouteiSummary.getExtParam13(),is(before1WT_KouteiSummary.getExtParam13()));
        assertThat(after1WT_KouteiSummary.getExtParam14(),is(before1WT_KouteiSummary.getExtParam14()));
        assertThat(after1WT_KouteiSummary.getExtParam15(),is(valueProperty1));
        assertThat(after1WT_KouteiSummary.getExtParam16(),is(before1WT_KouteiSummary.getExtParam16()));
        assertThat(after1WT_KouteiSummary.getExtParam17(),is(before1WT_KouteiSummary.getExtParam17()));
        assertThat(after1WT_KouteiSummary.getExtParam18(),is(before1WT_KouteiSummary.getExtParam18()));
        assertThat(after1WT_KouteiSummary.getExtParam19(),is(before1WT_KouteiSummary.getExtParam19()));
        assertThat(after1WT_KouteiSummary.getExtParam20(),is(before1WT_KouteiSummary.getExtParam20()));
        assertThat(after1WT_KouteiSummary.getExtParam21(),is(before1WT_KouteiSummary.getExtParam21()));
        assertThat(after1WT_KouteiSummary.getExtParam22(),is(before1WT_KouteiSummary.getExtParam22()));
        assertThat(after1WT_KouteiSummary.getExtParam23(),is(before1WT_KouteiSummary.getExtParam23()));
        assertThat(after1WT_KouteiSummary.getExtParam24(),is(before1WT_KouteiSummary.getExtParam24()));
        assertThat(after1WT_KouteiSummary.getExtParam25(),is(before1WT_KouteiSummary.getExtParam25()));
        assertThat(after1WT_KouteiSummary.getExtParam26(),is(before1WT_KouteiSummary.getExtParam26()));
        assertThat(after1WT_KouteiSummary.getExtParam27(),is(before1WT_KouteiSummary.getExtParam27()));
        assertThat(after1WT_KouteiSummary.getExtParam28(),is(before1WT_KouteiSummary.getExtParam28()));
        assertThat(after1WT_KouteiSummary.getExtParam29(),is(before1WT_KouteiSummary.getExtParam29()));
        assertThat(after1WT_KouteiSummary.getExtParam30(),is(before1WT_KouteiSummary.getExtParam30()));

        assertThat(before2WT_KouteiSummary.getLastSyoriTime(),is(not(after2WT_KouteiSummary.getLastSyoriTime())));
        assertThat(after2WT_KouteiSummary.getExtParam1(),is(before2WT_KouteiSummary.getExtParam1()));
        assertThat(after2WT_KouteiSummary.getExtParam2(),is(before2WT_KouteiSummary.getExtParam2()));
        assertThat(after2WT_KouteiSummary.getExtParam3(),is(before2WT_KouteiSummary.getExtParam3()));
        assertThat(after2WT_KouteiSummary.getExtParam4(),is(before2WT_KouteiSummary.getExtParam4()));
        assertThat(after2WT_KouteiSummary.getExtParam5(),is(before2WT_KouteiSummary.getExtParam5()));
        assertThat(after2WT_KouteiSummary.getExtParam6(),is(before2WT_KouteiSummary.getExtParam6()));
        assertThat(after2WT_KouteiSummary.getExtParam7(),is(before2WT_KouteiSummary.getExtParam7()));
        assertThat(after2WT_KouteiSummary.getExtParam8(),is(before2WT_KouteiSummary.getExtParam8()));
        assertThat(after2WT_KouteiSummary.getExtParam9(),is(before2WT_KouteiSummary.getExtParam9()));
        assertThat(after2WT_KouteiSummary.getExtParam10(),is(before2WT_KouteiSummary.getExtParam10()));
        assertThat(after2WT_KouteiSummary.getExtParam11(),is(before2WT_KouteiSummary.getExtParam11()));
        assertThat(after2WT_KouteiSummary.getExtParam12(),is(before2WT_KouteiSummary.getExtParam12()));
        assertThat(after2WT_KouteiSummary.getExtParam13(),is(before2WT_KouteiSummary.getExtParam13()));
        assertThat(after2WT_KouteiSummary.getExtParam14(),is(before2WT_KouteiSummary.getExtParam14()));
        assertThat(after2WT_KouteiSummary.getExtParam15(),is(before2WT_KouteiSummary.getExtParam15()));
        assertThat(after2WT_KouteiSummary.getExtParam16(),is(before2WT_KouteiSummary.getExtParam16()));
        assertThat(after2WT_KouteiSummary.getExtParam17(),is(before2WT_KouteiSummary.getExtParam17()));
        assertThat(after2WT_KouteiSummary.getExtParam18(),is(before2WT_KouteiSummary.getExtParam18()));
        assertThat(after2WT_KouteiSummary.getExtParam19(),is(before2WT_KouteiSummary.getExtParam19()));
        assertThat(after2WT_KouteiSummary.getExtParam20(),is(before2WT_KouteiSummary.getExtParam20()));
        assertThat(after2WT_KouteiSummary.getExtParam21(),is(before2WT_KouteiSummary.getExtParam21()));
        assertThat(after2WT_KouteiSummary.getExtParam22(),is(before2WT_KouteiSummary.getExtParam22()));
        assertThat(after2WT_KouteiSummary.getExtParam23(),is(before2WT_KouteiSummary.getExtParam23()));
        assertThat(after2WT_KouteiSummary.getExtParam24(),is(before2WT_KouteiSummary.getExtParam24()));
        assertThat(after2WT_KouteiSummary.getExtParam25(),is(before2WT_KouteiSummary.getExtParam25()));
        assertThat(after2WT_KouteiSummary.getExtParam26(),is(before2WT_KouteiSummary.getExtParam26()));
        assertThat(after2WT_KouteiSummary.getExtParam27(),is(before2WT_KouteiSummary.getExtParam27()));
        assertThat(after2WT_KouteiSummary.getExtParam28(),is(before2WT_KouteiSummary.getExtParam28()));
        assertThat(after2WT_KouteiSummary.getExtParam29(),is(before2WT_KouteiSummary.getExtParam29()));
        assertThat(after2WT_KouteiSummary.getExtParam30(),is(valueProperty2));

    }

    @Test
    public void ChkValidate_Required_Accountid_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：アカウントＩＤ"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Accountid_Blank() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid("");
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：アカウントＩＤ"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_ProcessUpdateForBatchBeanList_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setProcessUpdateForBatchBeanList(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：バッチ工程情報更新Beanリスト"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_ProcessUpdateForBatchBeanList_Blank(){
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setProcessUpdateForBatchBeanList(new ArrayList<ProcessUpdateForBatchBean>());
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：バッチ工程情報更新Beanリスト"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Gyoumukey_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：業務キー"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Gyoumukey_Blank() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey("");
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：業務キー"
            ,"");

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Flowid_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：フローＩＤ"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Flowid_Blank() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid("");
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：フローＩＤ"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Lockkey_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn("1");
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：ロックキー"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Required_Lockkey_Blank() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn("1");
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey("");
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：ロックキー"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Accountid_29() {

        String accountId = "12345678901234567890123456789";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid(accountId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(accountId.length(), is(29));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Accountid_30() {

        String accountId = "123456789012345678901234567890";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid(accountId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(accountId.length(), is(30));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Accountid_31() {

        String accountId = "1234567890123456789012345678901";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setAccountid(accountId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF0008
            ,"アカウントＩＤは30文字以内で入力してください。"
            ,null);

        assertThat(accountId.length(), is(31));
        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Gyoumukey_19() {

        String gyoumuKey = "1234567890123456789";
        createToken(gyoumuKey, TOKEN1_FLOWID);

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(gyoumuKey.length(), is(19));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Gyoumukey_20() {

        String gyoumuKey = "12345678901234567890";
        createToken(gyoumuKey, TOKEN1_FLOWID);

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(gyoumuKey.length(), is(20));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Gyoumukey_21() {

        String gyoumuKey = "123456789012345678901";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF0008
            ,"業務キーは20文字以内で入力してください。"
            ,gyoumuKey);

        assertThat(gyoumuKey.length(), is(21));
        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Flowid_18() {

        String gyoumuKey = IwfDateUtils.getSysDate();
        String flowId = "khnenkinshrtkykhnk";

        createToken(gyoumuKey, flowId);

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid(flowId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(flowId.length(), is(18));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Flowid_19() {

        String gyoumuKey = IwfDateUtils.getSysDate();
        String flowId = "khsiboumukoukbrpari";

        createToken(gyoumuKey, flowId);

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid(flowId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(flowId.length(), is(19));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_Flowid_20() {

        String flowId = "12345678901234567890";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid(flowId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF0008
            ,"フローＩＤは19文字以内で入力してください。"
            ,TOKEN1_GYOUMUKEY);

        assertThat(flowId.length(), is(20));
        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_ExtParam_49() {

        String extParamValue = "1234567890123456789012345678901234567890123456789";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).getExtParam1().setValues(extParamValue);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(extParamValue.length(), is(49));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_ExtParam_50() {

        String extParamValue = "12345678901234567890123456789012345678901234567890";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).getExtParam1().setValues(extParamValue);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(extParamValue.length(), is(50));
        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_Length_ExtParam_51() {

        String extParamValue = "123456789012345678901234567890123456789012345678901";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).getExtParam1().setValues(extParamValue);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF0008
            ,"拡張パラメータ 1は50文字以内で入力してください。"
            ,TOKEN1_GYOUMUKEY);

        assertThat(extParamValue.length(), is(51));
        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_LockConfirmKbn_Null() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_LockConfirmKbn_Blank() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn("");
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkValidate_LockConfirmKbn_3() {

        String lockComfirmKbn = "3";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockComfirmKbn);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF0006
            ,"区分値入力チェックエラー（項目[ロック確認区分]の値が不正です）"
            ,null);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkMain_LockKey() {

        String lockConfirmKbn = "1";
        String lockKey = "LOCKKEY";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockConfirmKbn);
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(lockKey);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF2021
            ,"ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkMain_Gyoumukey() {

        String gyoumuKey = "存在しない業務キー";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setGyoumukey(gyoumuKey);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF2025
            ,"指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。"
            ,gyoumuKey);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void ChkMain_Flowid() {

        String flowId = "存在しないフローＩＤ";

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setFlowid(flowId);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF2022
            ,"プロセス定義が取得できませんでした。"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void LockPattern_Test_111() {

        String lockConfirmKbn = "1";
        lockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockConfirmKbn);
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(TOKEN1_GYOUMUKEY);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
        unlockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
    }

    @Test
    public void LockPattern_Test_110() {

        String lockConfirmKbn = "1";
        lockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockConfirmKbn);
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：ロックキー"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
        unlockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
    }

    @Test
    public void LockPattern_Test_101() {

        lockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(TOKEN1_GYOUMUKEY);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
        unlockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
    }

    @Test
    public void LockPattern_Test_100() {

        lockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
        unlockToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID);
    }

    @Test
    public void LockPattern_Test_011() {

        String lockConfirmKbn = "1";
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockConfirmKbn);
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(TOKEN1_GYOUMUKEY);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean_Error = createErrorCheckBean(
            IwfMessageCd.IWF2021
            ,"ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean_Error, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void LockPattern_Test_010() {

        String lockConfirmKbn = "1";
        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.setLockConfirmKbn(lockConfirmKbn);
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(null);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0002
            ,"必須入力チェックエラー：ロックキー"
            ,TOKEN1_GYOUMUKEY);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void LockPattern_Test_001() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        inBean.getProcessUpdateForBatchBeanList().get(0).setLockkey(TOKEN1_GYOUMUKEY);
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void LockPattern_Test_000() {

        ProcessUpdateForBatchInBean inBean = createInBeanFullSet();
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(checkBean_Success, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void CauseUnKnownTest() {

        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(createInBeanFullSet());

        ProcessUpdateForBatchOutBean checkBean = createErrorCheckBean(
            IwfMessageCd.IWF0001
            ,"工程情報更新（バッチ用）異常終了しました。"
            ,null);

        assertThat(checkBean, is(samePropertyValuesAs(outBean)));
    }

    @Test
    public void Transactional_RollBack_Test() {

        Map<String, WSExtParam> map = new HashMap<>();
        List<WT_KouteiSummary> kouteiSummaryList = iwfCoreDomManager.getKouteiSummarys(new String[]{TOKEN1_GYOUMUKEY,TOKEN2_GYOUMUKEY},null,null,null,null,null,null,null,null,null,null,null,map);
        WT_KouteiSummary after1WT_KouteiSummary = kouteiSummaryList.get(0);
        WT_KouteiSummary after2WT_KouteiSummary = kouteiSummaryList.get(1);
        WT_KouteiSummary before1WT_KouteiSummary = new WT_KouteiSummary();
        WT_KouteiSummary before2WT_KouteiSummary = new WT_KouteiSummary();
        BeanUtil.copyProperties(before1WT_KouteiSummary, after1WT_KouteiSummary);
        BeanUtil.copyProperties(before2WT_KouteiSummary, after2WT_KouteiSummary);

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();

        ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
        bean.setGyoumukey(createToken(TOKEN1_GYOUMUKEY,TOKEN1_FLOWID));
        bean.setFlowid(TOKEN1_FLOWID);
        WSExtParam extParam = new WSExtParam();
        String value = "トランザクションロールバックテスト１";
        extParam.setValues(value);
        bean.setExtParam2(extParam);

        ProcessUpdateForBatchBean bean2 = new ProcessUpdateForBatchBean();
        bean2.setGyoumukey(createToken(TOKEN2_GYOUMUKEY,TOKEN2_FLOWID));
        bean2.setFlowid("存在しないフローID");
        WSExtParam extParam2 = new WSExtParam();
        String value2 = "トランザクションロールバックテスト２";
        extParam2.setValues(value2);
        bean2.setExtParam28(extParam2);

        beanList.add(bean);
        beanList.add(bean2);
        inBean.setProcessUpdateForBatchBeanList(beanList);

        boolean isError = false;
        try{
            TransactionalTestexec(inBean);
        } catch(RuntimeException e){
            isError = true;
        }
        if(isError){
            assertThat(before1WT_KouteiSummary.getLastSyoriTime(), is(after1WT_KouteiSummary.getLastSyoriTime()));
            assertThat(after1WT_KouteiSummary.getExtParam1(),is(before1WT_KouteiSummary.getExtParam1()));
            assertThat(after1WT_KouteiSummary.getExtParam2(),is(before1WT_KouteiSummary.getExtParam2()));
            assertThat(after1WT_KouteiSummary.getExtParam3(),is(before1WT_KouteiSummary.getExtParam3()));
            assertThat(after1WT_KouteiSummary.getExtParam4(),is(before1WT_KouteiSummary.getExtParam4()));
            assertThat(after1WT_KouteiSummary.getExtParam5(),is(before1WT_KouteiSummary.getExtParam5()));
            assertThat(after1WT_KouteiSummary.getExtParam6(),is(before1WT_KouteiSummary.getExtParam6()));
            assertThat(after1WT_KouteiSummary.getExtParam7(),is(before1WT_KouteiSummary.getExtParam7()));
            assertThat(after1WT_KouteiSummary.getExtParam8(),is(before1WT_KouteiSummary.getExtParam8()));
            assertThat(after1WT_KouteiSummary.getExtParam9(),is(before1WT_KouteiSummary.getExtParam9()));
            assertThat(after1WT_KouteiSummary.getExtParam10(),is(before1WT_KouteiSummary.getExtParam10()));
            assertThat(after1WT_KouteiSummary.getExtParam11(),is(before1WT_KouteiSummary.getExtParam11()));
            assertThat(after1WT_KouteiSummary.getExtParam12(),is(before1WT_KouteiSummary.getExtParam12()));
            assertThat(after1WT_KouteiSummary.getExtParam13(),is(before1WT_KouteiSummary.getExtParam13()));
            assertThat(after1WT_KouteiSummary.getExtParam14(),is(before1WT_KouteiSummary.getExtParam14()));
            assertThat(after1WT_KouteiSummary.getExtParam15(),is(before1WT_KouteiSummary.getExtParam15()));
            assertThat(after1WT_KouteiSummary.getExtParam16(),is(before1WT_KouteiSummary.getExtParam16()));
            assertThat(after1WT_KouteiSummary.getExtParam17(),is(before1WT_KouteiSummary.getExtParam17()));
            assertThat(after1WT_KouteiSummary.getExtParam18(),is(before1WT_KouteiSummary.getExtParam18()));
            assertThat(after1WT_KouteiSummary.getExtParam19(),is(before1WT_KouteiSummary.getExtParam19()));
            assertThat(after1WT_KouteiSummary.getExtParam20(),is(before1WT_KouteiSummary.getExtParam20()));
            assertThat(after1WT_KouteiSummary.getExtParam21(),is(before1WT_KouteiSummary.getExtParam21()));
            assertThat(after1WT_KouteiSummary.getExtParam22(),is(before1WT_KouteiSummary.getExtParam22()));
            assertThat(after1WT_KouteiSummary.getExtParam23(),is(before1WT_KouteiSummary.getExtParam23()));
            assertThat(after1WT_KouteiSummary.getExtParam24(),is(before1WT_KouteiSummary.getExtParam24()));
            assertThat(after1WT_KouteiSummary.getExtParam25(),is(before1WT_KouteiSummary.getExtParam25()));
            assertThat(after1WT_KouteiSummary.getExtParam26(),is(before1WT_KouteiSummary.getExtParam26()));
            assertThat(after1WT_KouteiSummary.getExtParam27(),is(before1WT_KouteiSummary.getExtParam27()));
            assertThat(after1WT_KouteiSummary.getExtParam28(),is(before1WT_KouteiSummary.getExtParam28()));
            assertThat(after1WT_KouteiSummary.getExtParam29(),is(before1WT_KouteiSummary.getExtParam29()));
            assertThat(after1WT_KouteiSummary.getExtParam30(),is(before1WT_KouteiSummary.getExtParam30()));

            assertThat(before2WT_KouteiSummary.getLastSyoriTime(), is(after2WT_KouteiSummary.getLastSyoriTime()));
            assertThat(after2WT_KouteiSummary.getExtParam1(),is(before2WT_KouteiSummary.getExtParam1()));
            assertThat(after2WT_KouteiSummary.getExtParam2(),is(before2WT_KouteiSummary.getExtParam2()));
            assertThat(after2WT_KouteiSummary.getExtParam3(),is(before2WT_KouteiSummary.getExtParam3()));
            assertThat(after2WT_KouteiSummary.getExtParam4(),is(before2WT_KouteiSummary.getExtParam4()));
            assertThat(after2WT_KouteiSummary.getExtParam5(),is(before2WT_KouteiSummary.getExtParam5()));
            assertThat(after2WT_KouteiSummary.getExtParam6(),is(before2WT_KouteiSummary.getExtParam6()));
            assertThat(after2WT_KouteiSummary.getExtParam7(),is(before2WT_KouteiSummary.getExtParam7()));
            assertThat(after2WT_KouteiSummary.getExtParam8(),is(before2WT_KouteiSummary.getExtParam8()));
            assertThat(after2WT_KouteiSummary.getExtParam9(),is(before2WT_KouteiSummary.getExtParam9()));
            assertThat(after2WT_KouteiSummary.getExtParam10(),is(before2WT_KouteiSummary.getExtParam10()));
            assertThat(after2WT_KouteiSummary.getExtParam11(),is(before2WT_KouteiSummary.getExtParam11()));
            assertThat(after2WT_KouteiSummary.getExtParam12(),is(before2WT_KouteiSummary.getExtParam12()));
            assertThat(after2WT_KouteiSummary.getExtParam13(),is(before2WT_KouteiSummary.getExtParam13()));
            assertThat(after2WT_KouteiSummary.getExtParam14(),is(before2WT_KouteiSummary.getExtParam14()));
            assertThat(after2WT_KouteiSummary.getExtParam15(),is(before2WT_KouteiSummary.getExtParam15()));
            assertThat(after2WT_KouteiSummary.getExtParam16(),is(before2WT_KouteiSummary.getExtParam16()));
            assertThat(after2WT_KouteiSummary.getExtParam17(),is(before2WT_KouteiSummary.getExtParam17()));
            assertThat(after2WT_KouteiSummary.getExtParam18(),is(before2WT_KouteiSummary.getExtParam18()));
            assertThat(after2WT_KouteiSummary.getExtParam19(),is(before2WT_KouteiSummary.getExtParam19()));
            assertThat(after2WT_KouteiSummary.getExtParam20(),is(before2WT_KouteiSummary.getExtParam20()));
            assertThat(after2WT_KouteiSummary.getExtParam21(),is(before2WT_KouteiSummary.getExtParam21()));
            assertThat(after2WT_KouteiSummary.getExtParam22(),is(before2WT_KouteiSummary.getExtParam22()));
            assertThat(after2WT_KouteiSummary.getExtParam23(),is(before2WT_KouteiSummary.getExtParam23()));
            assertThat(after2WT_KouteiSummary.getExtParam24(),is(before2WT_KouteiSummary.getExtParam24()));
            assertThat(after2WT_KouteiSummary.getExtParam25(),is(before2WT_KouteiSummary.getExtParam25()));
            assertThat(after2WT_KouteiSummary.getExtParam26(),is(before2WT_KouteiSummary.getExtParam26()));
            assertThat(after2WT_KouteiSummary.getExtParam27(),is(before2WT_KouteiSummary.getExtParam27()));
            assertThat(after2WT_KouteiSummary.getExtParam28(),is(before2WT_KouteiSummary.getExtParam28()));
            assertThat(after2WT_KouteiSummary.getExtParam29(),is(before2WT_KouteiSummary.getExtParam29()));
            assertThat(after2WT_KouteiSummary.getExtParam30(),is(before2WT_KouteiSummary.getExtParam30()));
        } else{
            assertThat(true,is(false));
        }
    }
    @Transactional
    public void TransactionalTestexec(ProcessUpdateForBatchInBean inBean){
        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);
        if(outBean.getKekkastatus() == "9"){
            throw new RuntimeException();
        }
    }

    @Test
    public void Transactional_Commit_Test() {

        Map<String, WSExtParam> map = new HashMap<>();
        List<WT_KouteiSummary> kouteiSummaryList = iwfCoreDomManager.getKouteiSummarys(new String[]{TOKEN1_GYOUMUKEY,TOKEN2_GYOUMUKEY},null,null,null,null,null,null,null,null,null,null,null,map);
        WT_KouteiSummary after1WT_KouteiSummary = kouteiSummaryList.get(0);
        WT_KouteiSummary after2WT_KouteiSummary = kouteiSummaryList.get(1);
        WT_KouteiSummary before1WT_KouteiSummary = new WT_KouteiSummary();
        WT_KouteiSummary before2WT_KouteiSummary = new WT_KouteiSummary();
        BeanUtil.copyProperties(before1WT_KouteiSummary, after1WT_KouteiSummary);
        BeanUtil.copyProperties(before2WT_KouteiSummary, after2WT_KouteiSummary);

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();
        inBean.setAccountid("ACCOUNTID");
        List<ProcessUpdateForBatchBean> beanList = new ArrayList<>();

        ProcessUpdateForBatchBean bean = new ProcessUpdateForBatchBean();
        bean.setGyoumukey(TOKEN1_GYOUMUKEY);
        bean.setFlowid(TOKEN1_FLOWID);
        WSExtParam extParam = new WSExtParam();
        String value = "トランザクションコミットテスト１";
        extParam.setValues(value);
        bean.setExtParam2(extParam);

        ProcessUpdateForBatchBean bean2 = new ProcessUpdateForBatchBean();
        bean2.setGyoumukey(TOKEN2_GYOUMUKEY);
        bean2.setFlowid("存在しないフローID");
        WSExtParam extParam2 = new WSExtParam();
        String value2 = "トランザクションコミットテスト２";
        extParam2.setValues(value2);
        bean2.setExtParam28(extParam2);

        beanList.add(bean);
        beanList.add(bean2);
        inBean.setProcessUpdateForBatchBeanList(beanList);

        ProcessUpdateForBatchOutBean outBean = iwfKouteiClient.execProcessUpdateForBatch(inBean);

        assertThat(before1WT_KouteiSummary.getLastSyoriTime(), is(not(after1WT_KouteiSummary.getLastSyoriTime())));
        assertThat(after1WT_KouteiSummary.getExtParam1(),is(before1WT_KouteiSummary.getExtParam1()));
        assertThat(after1WT_KouteiSummary.getExtParam2(),is(value));
        assertThat(after1WT_KouteiSummary.getExtParam3(),is(before1WT_KouteiSummary.getExtParam3()));
        assertThat(after1WT_KouteiSummary.getExtParam4(),is(before1WT_KouteiSummary.getExtParam4()));
        assertThat(after1WT_KouteiSummary.getExtParam5(),is(before1WT_KouteiSummary.getExtParam5()));
        assertThat(after1WT_KouteiSummary.getExtParam6(),is(before1WT_KouteiSummary.getExtParam6()));
        assertThat(after1WT_KouteiSummary.getExtParam7(),is(before1WT_KouteiSummary.getExtParam7()));
        assertThat(after1WT_KouteiSummary.getExtParam8(),is(before1WT_KouteiSummary.getExtParam8()));
        assertThat(after1WT_KouteiSummary.getExtParam9(),is(before1WT_KouteiSummary.getExtParam9()));
        assertThat(after1WT_KouteiSummary.getExtParam10(),is(before1WT_KouteiSummary.getExtParam10()));
        assertThat(after1WT_KouteiSummary.getExtParam11(),is(before1WT_KouteiSummary.getExtParam11()));
        assertThat(after1WT_KouteiSummary.getExtParam12(),is(before1WT_KouteiSummary.getExtParam12()));
        assertThat(after1WT_KouteiSummary.getExtParam13(),is(before1WT_KouteiSummary.getExtParam13()));
        assertThat(after1WT_KouteiSummary.getExtParam14(),is(before1WT_KouteiSummary.getExtParam14()));
        assertThat(after1WT_KouteiSummary.getExtParam15(),is(before1WT_KouteiSummary.getExtParam15()));
        assertThat(after1WT_KouteiSummary.getExtParam16(),is(before1WT_KouteiSummary.getExtParam16()));
        assertThat(after1WT_KouteiSummary.getExtParam17(),is(before1WT_KouteiSummary.getExtParam17()));
        assertThat(after1WT_KouteiSummary.getExtParam18(),is(before1WT_KouteiSummary.getExtParam18()));
        assertThat(after1WT_KouteiSummary.getExtParam19(),is(before1WT_KouteiSummary.getExtParam19()));
        assertThat(after1WT_KouteiSummary.getExtParam20(),is(before1WT_KouteiSummary.getExtParam20()));
        assertThat(after1WT_KouteiSummary.getExtParam21(),is(before1WT_KouteiSummary.getExtParam21()));
        assertThat(after1WT_KouteiSummary.getExtParam22(),is(before1WT_KouteiSummary.getExtParam22()));
        assertThat(after1WT_KouteiSummary.getExtParam23(),is(before1WT_KouteiSummary.getExtParam23()));
        assertThat(after1WT_KouteiSummary.getExtParam24(),is(before1WT_KouteiSummary.getExtParam24()));
        assertThat(after1WT_KouteiSummary.getExtParam25(),is(before1WT_KouteiSummary.getExtParam25()));
        assertThat(after1WT_KouteiSummary.getExtParam26(),is(before1WT_KouteiSummary.getExtParam26()));
        assertThat(after1WT_KouteiSummary.getExtParam27(),is(before1WT_KouteiSummary.getExtParam27()));
        assertThat(after1WT_KouteiSummary.getExtParam28(),is(before1WT_KouteiSummary.getExtParam28()));
        assertThat(after1WT_KouteiSummary.getExtParam29(),is(before1WT_KouteiSummary.getExtParam29()));
        assertThat(after1WT_KouteiSummary.getExtParam30(),is(before1WT_KouteiSummary.getExtParam30()));

        assertThat(before2WT_KouteiSummary.getLastSyoriTime(), is(samePropertyValuesAs(after2WT_KouteiSummary.getLastSyoriTime())));
        assertThat(after2WT_KouteiSummary.getExtParam1(),is(before2WT_KouteiSummary.getExtParam1()));
        assertThat(after2WT_KouteiSummary.getExtParam2(),is(before2WT_KouteiSummary.getExtParam2()));
        assertThat(after2WT_KouteiSummary.getExtParam3(),is(before2WT_KouteiSummary.getExtParam3()));
        assertThat(after2WT_KouteiSummary.getExtParam4(),is(before2WT_KouteiSummary.getExtParam4()));
        assertThat(after2WT_KouteiSummary.getExtParam5(),is(before2WT_KouteiSummary.getExtParam5()));
        assertThat(after2WT_KouteiSummary.getExtParam6(),is(before2WT_KouteiSummary.getExtParam6()));
        assertThat(after2WT_KouteiSummary.getExtParam7(),is(before2WT_KouteiSummary.getExtParam7()));
        assertThat(after2WT_KouteiSummary.getExtParam8(),is(before2WT_KouteiSummary.getExtParam8()));
        assertThat(after2WT_KouteiSummary.getExtParam9(),is(before2WT_KouteiSummary.getExtParam9()));
        assertThat(after2WT_KouteiSummary.getExtParam10(),is(before2WT_KouteiSummary.getExtParam10()));
        assertThat(after2WT_KouteiSummary.getExtParam11(),is(before2WT_KouteiSummary.getExtParam11()));
        assertThat(after2WT_KouteiSummary.getExtParam12(),is(before2WT_KouteiSummary.getExtParam12()));
        assertThat(after2WT_KouteiSummary.getExtParam13(),is(before2WT_KouteiSummary.getExtParam13()));
        assertThat(after2WT_KouteiSummary.getExtParam14(),is(before2WT_KouteiSummary.getExtParam14()));
        assertThat(after2WT_KouteiSummary.getExtParam15(),is(before2WT_KouteiSummary.getExtParam15()));
        assertThat(after2WT_KouteiSummary.getExtParam16(),is(before2WT_KouteiSummary.getExtParam16()));
        assertThat(after2WT_KouteiSummary.getExtParam17(),is(before2WT_KouteiSummary.getExtParam17()));
        assertThat(after2WT_KouteiSummary.getExtParam18(),is(before2WT_KouteiSummary.getExtParam18()));
        assertThat(after2WT_KouteiSummary.getExtParam19(),is(before2WT_KouteiSummary.getExtParam19()));
        assertThat(after2WT_KouteiSummary.getExtParam20(),is(before2WT_KouteiSummary.getExtParam20()));
        assertThat(after2WT_KouteiSummary.getExtParam21(),is(before2WT_KouteiSummary.getExtParam21()));
        assertThat(after2WT_KouteiSummary.getExtParam22(),is(before2WT_KouteiSummary.getExtParam22()));
        assertThat(after2WT_KouteiSummary.getExtParam23(),is(before2WT_KouteiSummary.getExtParam23()));
        assertThat(after2WT_KouteiSummary.getExtParam24(),is(before2WT_KouteiSummary.getExtParam24()));
        assertThat(after2WT_KouteiSummary.getExtParam25(),is(before2WT_KouteiSummary.getExtParam25()));
        assertThat(after2WT_KouteiSummary.getExtParam26(),is(before2WT_KouteiSummary.getExtParam26()));
        assertThat(after2WT_KouteiSummary.getExtParam27(),is(before2WT_KouteiSummary.getExtParam27()));
        assertThat(after2WT_KouteiSummary.getExtParam28(),is(before2WT_KouteiSummary.getExtParam28()));
        assertThat(after2WT_KouteiSummary.getExtParam29(),is(before2WT_KouteiSummary.getExtParam29()));
        assertThat(after2WT_KouteiSummary.getExtParam30(),is(before2WT_KouteiSummary.getExtParam30()));
    }

    private ProcessUpdateForBatchOutBean createErrorCheckBean(IwfMessageCd pIwfMessageCd, String pMessage, String pGyoumukey) {
        ProcessUpdateForBatchOutBean checkBean_Error = new ProcessUpdateForBatchOutBean();
        checkBean_Error.setKekkastatus(C_ResultCdKbn.NG.toString());
        checkBean_Error.setSyousaimsgcd(pIwfMessageCd.toString());
        checkBean_Error.setSyousaimsg(pMessage);
        checkBean_Error.setErrGyoumukey(pGyoumukey);
        return checkBean_Error;
    }

    private ProcessUpdateForBatchOutBean createSuccessCheckBean() {
        ProcessUpdateForBatchOutBean checkBean_success = new ProcessUpdateForBatchOutBean();
        checkBean_success.setKekkastatus(C_ResultCdKbn.OK.toString());
        checkBean_success.setSyousaimsgcd(IwfMessageCd.IWF0000.toString());
        checkBean_success.setSyousaimsg("工程情報更新（バッチ用）正常終了しました。");
        return checkBean_success;
    }

    private ProcessUpdateForBatchInBean createInBeanFullSet(){

        ProcessUpdateForBatchInBean inBean = new ProcessUpdateForBatchInBean();

        inBean.setAccountid("ACCOUNTID");
        inBean.setLockConfirmKbn("0");

        List<ProcessUpdateForBatchBean> updateBeans = new ArrayList<>();
        ProcessUpdateForBatchBean updateBean = new ProcessUpdateForBatchBean();
        updateBean.setGyoumukey(TOKEN1_GYOUMUKEY);
        updateBean.setFlowid(TOKEN1_FLOWID);
        updateBean.setLockkey("");
        setExtInfo(updateBean, "付加情報のキー", "付加情報の値");
        setExtParam(updateBean,false);

        updateBeans.add(updateBean);
        inBean.setProcessUpdateForBatchBeanList(updateBeans);

        return inBean;
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

    private String createToken(String pKey,String pFlowid) {
        if(StringUtil.isNullOrBlank(pKey)){
            pKey = uniqueKeyGenerator.generateUniqueKey();
        }
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
}