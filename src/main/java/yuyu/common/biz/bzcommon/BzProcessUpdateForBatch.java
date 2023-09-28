package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程情報更新（バッチ用）クラス
 */
public class BzProcessUpdateForBatch {

    @Inject
    private static Logger logger;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    public BzProcessUpdateForBatch() {
        super();
    }

    @Transactional
    public BzProcessUpdateForBatchOutputBean exec(List<BzProcessUpdateForBatchInputBean> pBzProcessUpdateForBatchInputBeanLst) {

        logger.debug("▽ 業務共通工程情報更新（バッチ用） 開始");

        if (pBzProcessUpdateForBatchInputBeanLst == null || pBzProcessUpdateForBatchInputBeanLst.size() == 0) {
            throw new BizAppException(MessageId.EBF0010, "業務共通工程情報更新（バッチ用）入力Beanリスト");
        }

        ProcessUpdateForBatchInBean processUpdateForBatchInBean = SWAKInjector.getInstance(ProcessUpdateForBatchInBean.class);
        List<ProcessUpdateForBatchBean> processUpdateForBatchBeanList = new ArrayList<>();
        processUpdateForBatchInBean.setProcessUpdateForBatchBeanList(processUpdateForBatchBeanList);

        processUpdateForBatchInBean.setAccountid(baseUserInfo.getUser().getUserId());
        processUpdateForBatchInBean.setLockConfirmKbn("0");

        for (int i = 0; i < pBzProcessUpdateForBatchInputBeanLst.size(); i++) {

            GetProcessSummaryOutBean wkGetProcessSummaryOutBean = null;

            if (pBzProcessUpdateForBatchInputBeanLst.get(i).getKokouteiUpdumu() != null &&
                pBzProcessUpdateForBatchInputBeanLst.get(i).getKokouteiUpdumu().eq(C_UmuKbn.ARI)) {

                List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean> gyoumuKouteiInfoLst =
                    bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(pBzProcessUpdateForBatchInputBeanLst.get(i).getKouteiKanriId(),
                        pBzProcessUpdateForBatchInputBeanLst.get(i).getJimuTetuzukiCd());

                if (gyoumuKouteiInfoLst.size() <= 1) {

                    wkGetProcessSummaryOutBean = SWAKInjector.getInstance(GetProcessSummaryOutBean.class);
                    List<ProcessSummaryBean> processSummaryBeanList = new ArrayList<>();
                    ProcessSummaryBean wkProcessSummaryBean = new ProcessSummaryBean();
                    wkGetProcessSummaryOutBean.setProcessSummaryBeanList(processSummaryBeanList);

                    wkProcessSummaryBean.setGyoumukey(pBzProcessUpdateForBatchInputBeanLst.get(i).getKouteiKanriId());
                    wkProcessSummaryBean.setFlowId(pBzProcessUpdateForBatchInputBeanLst.get(i).getJimuTetuzukiCd());
                    wkGetProcessSummaryOutBean.getProcessSummaryBeanList().add(wkProcessSummaryBean);

                } else {

                    String[] arrayKouteiKanriIds = new String[gyoumuKouteiInfoLst.size()];
                    String[] arrayJimutetuzukiCds = new String[gyoumuKouteiInfoLst.size()];
                    for (int m = 0; m < gyoumuKouteiInfoLst.size(); m++) {
                        arrayKouteiKanriIds[m] = gyoumuKouteiInfoLst.get(m).getKouteikanriid();
                        arrayJimutetuzukiCds[m] = gyoumuKouteiInfoLst.get(m).getJimutetuzukicd();
                    }

                    GetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector.getInstance(GetProcessSummaryInBean.class);

                    getProcessSummaryInBean.setGyoumukeys(arrayKouteiKanriIds);
                    getProcessSummaryInBean.setFlowids(arrayJimutetuzukiCds);
                    String[] kouteikanristatus = {C_Kouteikanristatus.SYORITYUU.getValue()};
                    getProcessSummaryInBean.setSyoristatus(kouteikanristatus);

                    wkGetProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

                    if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(wkGetProcessSummaryOutBean.getKekkastatus()) ||
                        wkGetProcessSummaryOutBean.getProcessSummaryBeanList().size() == 0) {

                        BzProcessUpdateForBatchOutputBean bzProcessUpdateForBatchOutputBean = SWAKInjector.getInstance(BzProcessUpdateForBatchOutputBean.class);

                        bzProcessUpdateForBatchOutputBean.setKekkaStatus(wkGetProcessSummaryOutBean.getKekkastatus());
                        bzProcessUpdateForBatchOutputBean.setSyousaiMsgCd(wkGetProcessSummaryOutBean.getSyousaimsgcd());
                        bzProcessUpdateForBatchOutputBean.setSyousaiMsg(wkGetProcessSummaryOutBean.getSyousaimsg());
                        bzProcessUpdateForBatchOutputBean.setErrKouteiKanriId(pBzProcessUpdateForBatchInputBeanLst.get(i).getKouteiKanriId());

                        logger.debug("△ 業務共通工程情報更新（バッチ用） 終了");

                        return bzProcessUpdateForBatchOutputBean;
                    } else {
                    }
                }

            } else {

                wkGetProcessSummaryOutBean = SWAKInjector.getInstance(GetProcessSummaryOutBean.class);
                List<ProcessSummaryBean> processSummaryBeanList = new ArrayList<>();
                ProcessSummaryBean wkProcessSummaryBean = new ProcessSummaryBean();
                wkGetProcessSummaryOutBean.setProcessSummaryBeanList(processSummaryBeanList);

                wkProcessSummaryBean.setGyoumukey(pBzProcessUpdateForBatchInputBeanLst.get(i).getKouteiKanriId());
                wkProcessSummaryBean.setFlowId(pBzProcessUpdateForBatchInputBeanLst.get(i).getJimuTetuzukiCd());
                wkGetProcessSummaryOutBean.getProcessSummaryBeanList().add(wkProcessSummaryBean);

            }

            for (int j = 0; j < wkGetProcessSummaryOutBean.getProcessSummaryBeanList().size(); j++) {

                ProcessUpdateForBatchBean wkProcessUpdateForBatchBean = new ProcessUpdateForBatchBean();
                wkProcessUpdateForBatchBean.setGyoumukey(wkGetProcessSummaryOutBean.getProcessSummaryBeanList().get(j).getGyoumukey());
                wkProcessUpdateForBatchBean.setFlowid(wkGetProcessSummaryOutBean.getProcessSummaryBeanList().get(j).getFlowId());

                WSExtParam extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSkeijimukbn() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSkeijimukbn().getValue());
                    wkProcessUpdateForBatchBean.setExtParam1(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosuketukekbn() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosuketukekbn().getValue());
                    wkProcessUpdateForBatchBean.setExtParam2(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getHknsyuruiNo() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getHknsyuruiNo().getValue());
                    wkProcessUpdateForBatchBean.setExtParam3(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd1())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam4(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd1())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd1());
                    wkProcessUpdateForBatchBean.setExtParam4(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd2())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam5(extParam);

                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd2())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDairitencd2());
                    wkProcessUpdateForBatchBean.setExtParam5(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimuyoucd())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam7(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimuyoucd())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimuyoucd());
                    wkProcessUpdateForBatchBean.setExtParam7(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimuyoucd())) {
                    extParam.setValues("1");
                    wkProcessUpdateForBatchBean.setExtParam8(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimuyoucd())) {
                    extParam.setValues("0");
                    wkProcessUpdateForBatchBean.setExtParam8(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDoujimosumu() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getDoujimosumu().getValue());
                    wkProcessUpdateForBatchBean.setExtParam9(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosymd() != null) {
                    if ("00000000".equals(String.valueOf(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosymd()))) {
                        extParam.setValues((String[]) null);
                    }
                    else {
                        extParam.setValues(String.valueOf(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosymd()));
                    }
                    wkProcessUpdateForBatchBean.setExtParam10(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimustartymd())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam11(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimustartymd())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getJimustartymd());
                    wkProcessUpdateForBatchBean.setExtParam11(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSyono())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam12(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSyono())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSyono());
                    wkProcessUpdateForBatchBean.setExtParam12(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getNksysyno())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam13(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getNksysyno())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getNksysyno());
                    wkProcessUpdateForBatchBean.setExtParam13(extParam);
                }

                extParam = new WSExtParam();
                if ("".equals(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosno())) {
                    extParam.setValues((String[]) null);
                    wkProcessUpdateForBatchBean.setExtParam14(extParam);
                }
                else if (!BizUtil.isBlank(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosno())) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getMosno());
                    wkProcessUpdateForBatchBean.setExtParam14(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getKetteiKbn() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getKetteiKbn().getValue());
                    wkProcessUpdateForBatchBean.setExtParam15(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSeirituKbn() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getSeirituKbn().getValue());
                    wkProcessUpdateForBatchBean.setExtParam16(extParam);
                }

                extParam = new WSExtParam();
                if (pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getLincjkKbn() != null) {
                    extParam.setValues(pBzProcessUpdateForBatchInputBeanLst.get(i).getTuikaParamForBatchInputBean().getLincjkKbn().getValue());
                    wkProcessUpdateForBatchBean.setExtParam17(extParam);
                }

                processUpdateForBatchInBean.getProcessUpdateForBatchBeanList().add(wkProcessUpdateForBatchBean);
            }
        }

        ProcessUpdateForBatchOutBean processUpdateForBatchOutBean = iwfKouteiClient.execProcessUpdateForBatch(processUpdateForBatchInBean);

        BzProcessUpdateForBatchOutputBean bzProcessUpdateForBatchOutputBean = SWAKInjector.getInstance(BzProcessUpdateForBatchOutputBean.class);

        bzProcessUpdateForBatchOutputBean.setKekkaStatus(processUpdateForBatchOutBean.getKekkastatus());
        bzProcessUpdateForBatchOutputBean.setSyousaiMsgCd(processUpdateForBatchOutBean.getSyousaimsgcd());
        bzProcessUpdateForBatchOutputBean.setSyousaiMsg(processUpdateForBatchOutBean.getSyousaimsg());
        bzProcessUpdateForBatchOutputBean.setErrKouteiKanriId(processUpdateForBatchOutBean.getErrGyoumukey());

        logger.debug("△ 業務共通工程情報更新（バッチ用） 終了");

        return bzProcessUpdateForBatchOutputBean;

    }
}
