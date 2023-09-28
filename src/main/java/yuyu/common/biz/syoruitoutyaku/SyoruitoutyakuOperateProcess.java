package yuyu.common.biz.syoruitoutyaku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.SetWariateHukaInfo;
import yuyu.common.biz.koutei.UpdateJimustartymd;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.workflow.manager.WorkflowDomManager;

/**
 * 業務共通 書類到着 書類到着時工程操作処理
 */
public abstract class SyoruitoutyakuOperateProcess {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzLockProcess bzLockProcess;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    @Inject
    private IwfImageClient iwfImageClient;

    @Inject
    private BaseUserInfo userInfo;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BzOutputProcessRecord bzOutputProcessRecord;

    @Inject
    private UpdateJimustartymd updateJimustartymd;

    @Inject
    private SetWariateHukaInfo setWariateHukaInfo;

    @Inject
    private WorkflowDomManager workflowDomManager;

    public SyoruitoutyakuOperateProcess() {
        super();
    }

    public void exec(String pToutyakuKey, String pAppKey, String pSyoruiCd, String pFlowId, String pSubsystemId, String pImageId) {

        if (BizUtil.isBlank(pSyoruiCd)) {
            throw new BizAppException(MessageId.EBF0011);
        }

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.valueOf(pSyoruiCd);

        operateProcess(pAppKey, syoruiCdKbn, pFlowId, pSubsystemId);

        doujiSeikyuu(pImageId, pAppKey, syoruiCdKbn);

        operateProcessForMultipleBranch(pImageId, pAppKey, syoruiCdKbn);
    }

    public void operateProcess(String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn, String pJimutetuzukicd, String pSubsystemId) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBeanSelf = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBeanSelf.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBeanSelf.setJimuTetuzukiCd(pJimutetuzukicd);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanSelfLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBeanSelf);

        if (C_Kouteikanristatus.TORIKESI.eq(bzGetProcessSummaryOutBeanSelfLst.get(0).getKouteiKanriStatus())) {
            throw new BizLogicException(MessageId.EBA1037);
        }

        boolean processForwardflag = false;
        BzLockProcessOutBean bzLockProcessOutBean = null ;
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBeanSelf = null;
        String syuKouteikanriId = "";
        String syuKouteiJimutetuzukiCd = "";

        boolean result = hanteiToutyakuProcessForwardSyoruiCd(pSyoruiCdKbn);

        if (result) {
            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(pKouteiKanriId);
            syuKouteikanriId = gyoumuKouteiInfo.getSyukouteikanriid();
            syuKouteiJimutetuzukiCd = gyoumuKouteiInfo.getSyukouteijimutetuzukicd();

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(syuKouteikanriId);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(syuKouteiJimutetuzukiCd);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

            if (C_Kouteikanristatus.SYORITYUU.eq(bzGetProcessSummaryOutBean.getKouteiKanriStatus())) {
                bzGetProcessSummaryInBeanSelf = new BzGetProcessSummaryInBean();

                bzGetProcessSummaryInBeanSelf.setKouteiKanriId(pKouteiKanriId);
                bzGetProcessSummaryInBeanSelf.setJimuTetuzukiCd(pJimutetuzukicd);

                bzGetProcessSummaryOutBeanSelfLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBeanSelf);

                bzGetProcessSummaryOutBeanSelf = bzGetProcessSummaryOutBeanSelfLst.get(0);

                if (bzGetProcessSummaryOutBeanSelf.getNowNodoId().equals(getSyoruitoutyakuNodeId())) {
                    bzLockProcessOutBean = bzLockProcess.exec(syuKouteikanriId, syuKouteiJimutetuzukiCd);

                    if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                    }
                    else {
                        throw new BizLogicException(MessageId.EBA0110);
                    }

                    processForwardflag = true;
                }
                else {
                    if (!YuyuBizConfig.getInstance().getSyoruiToutyakuErrorTsgList().contains(pSyoruiCdKbn.getValue())) {
                        throw new BizLogicException(MessageId.EBA1060);
                    }
                }
            }
            else {
                bzGetProcessSummaryInBeanSelf = new BzGetProcessSummaryInBean();

                bzGetProcessSummaryInBeanSelf.setKouteiKanriId(pKouteiKanriId);
                bzGetProcessSummaryInBeanSelf.setJimuTetuzukiCd(pJimutetuzukicd);

                bzGetProcessSummaryOutBeanSelfLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBeanSelf);

                bzGetProcessSummaryOutBeanSelf = bzGetProcessSummaryOutBeanSelfLst.get(0);

                if (C_Kouteikanristatus.KANRYOU.eq(bzGetProcessSummaryOutBeanSelf.getKouteiKanriStatus())) {
                    if (!YuyuBizConfig.getInstance().getSyoruiToutyakuErrorTsgList().contains(pSyoruiCdKbn.getValue())) {
                        throw new BizLogicException(MessageId.EBA1060);
                    }
                }

                processForwardflag = false;
            }
        }
        else {
            processForwardflag = false;
        }

        String torikomiSyoruiNm = "";
        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();

        getTorikomiSyoruiMstInBean.setTorikomisyoruicd(pSyoruiCdKbn.getValue());
        getTorikomiSyoruiMstInBean.setFlowid(pJimutetuzukicd);

        WSGetTorikomiSyoruiMstResponse getTorikomiSyoruiMstOutBean =
                iwfImageClient.execGetTorikomiSyoruiMst(getTorikomiSyoruiMstInBean);

        String kekkaStatus = getTorikomiSyoruiMstOutBean.getKekkastatus();
        String syousaiMsgCd = getTorikomiSyoruiMstOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            torikomiSyoruiNm = getTorikomiSyoruiMstOutBean.getTorikomisyoruilist().get(0).getTorikomisyoruinm();
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "書類到着時工程操作処理", "取込書類マスタ取得", syousaiMsgCd);
        }

        if (processForwardflag) {

            if (bzGetProcessSummaryOutBeanSelf.getJimuStartYmd() == null) {
                updateJimustartymd.exec(pJimutetuzukicd, pKouteiKanriId, bzLockProcessOutBean.getKouteiLockKey(),
                        BizDate.getSysDateTimeMilli());
            }

            bzOutputProcessRecord.exec(pKouteiKanriId, pJimutetuzukicd, torikomiSyoruiNm,
                    "書類到着", C_SyorikekkaKbn.BLNK);

            List<Map<String, String>> extInfoLst = new ArrayList<>();
            Map<String, String> extInfoMp = new HashMap<>();

            extInfoMp.put(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN, C_SyorikekkaKbn.KANRYOU.getValue());
            extInfoLst.add(extInfoMp);

            ProcessForwardInBean processForwardInBean = new ProcessForwardInBean();

            processForwardInBean.setGyoumukey(pKouteiKanriId);
            processForwardInBean.setFlowid(pJimutetuzukicd);
            processForwardInBean.setAccountid(userInfo.getUserId());
            processForwardInBean.setExtInfo(extInfoLst);
            processForwardInBean.setLockkey(bzLockProcessOutBean.getKouteiLockKey());

            ProcessForwardOutBean processForwardOutBean = iwfKouteiClient.execProcessForward(processForwardInBean);

            String kekkaStatusByPF = processForwardOutBean.getKekkastatus();
            String syousaiMsgCdByPF = processForwardOutBean.getSyousaimsgcd();

            if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatusByPF)) {
            }
            else {
                throw new BizAppException(
                        MessageId.EBS0007, "書類到着時工程操作処理", "工程遷移", syousaiMsgCdByPF);
            }

            bzGetProcessSummaryOutBeanSelfLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBeanSelf);

            bzGetProcessSummaryOutBeanSelf = bzGetProcessSummaryOutBeanSelfLst.get(0);

            setWariateHukaInfo.exec(pKouteiKanriId,
                    bzGetProcessSummaryOutBeanSelf.getSubSystemId(),
                    pJimutetuzukicd,
                    bzGetProcessSummaryOutBeanSelf.getZnkNodoId(),
                    bzGetProcessSummaryOutBeanSelf.getNowNodoId());

            bzUnlockProcess.exec(syuKouteikanriId, syuKouteiJimutetuzukiCd, bzLockProcessOutBean.getKouteiLockKey());
        }
        else {
            bzOutputProcessRecord.exec(pKouteiKanriId, pJimutetuzukicd, torikomiSyoruiNm, "書類到着", C_SyorikekkaKbn.BLNK);
        }
    }

    public abstract boolean hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn pSyoruiCdKbn);

    public abstract String getSyoruitoutyakuNodeId();

    public void doujiSeikyuu(String pImageId, String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn) {
    }

    public void operateProcessForMultipleBranch(String pImageId, String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn) {
    }

}
