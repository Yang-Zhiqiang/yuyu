package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.sorter.SortDM_Jimutetuzuki;

/**
 * 業務共通 工程 業務共通工程作成
 */
public class BzProcessCreate {

    @Inject
    private BzLockProcess bzLockProcess;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private SetKouteiKanriId setKouteiKanriId;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private WorkflowDomManager workflowDomManager;

    public BzProcessCreate() {
        super();
    }

    public BzProcessCreateOutBean exec(BzProcessCreateInBean pBzProcessCreateInBean) {

        BzProcessCreateOutBean bzProcessCreateOutBean = new BzProcessCreateOutBean();

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = null;
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = null;

        BzLockProcessOutBean bzLockProcessOutBean = null;

        boolean syuKouteiFlag;

        if (BizUtil.isBlank(pBzProcessCreateInBean.getOyaKouteiKanriId()) &&
            BizUtil.isBlank(pBzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd())) {
            syuKouteiFlag = true;
        }
        else if (!BizUtil.isBlank(pBzProcessCreateInBean.getOyaKouteiKanriId()) &&
            !BizUtil.isBlank(pBzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd())) {
            syuKouteiFlag = false;
        }
        else {
            throw new BizAppException(MessageId.EBF0011);
        }

        if (syuKouteiFlag) {
        }
        else {
            bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(pBzProcessCreateInBean.getOyaKouteiKanriId());
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(pBzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd());
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
                bzProcessCreateOutBean.setKouteiKanriId("");

                return bzProcessCreateOutBean;
            }
        }

        String[] skNos = null;

        if (!BizUtil.isBlank(pBzProcessCreateInBean.getSkNo())) {
            skNos = new String[1];
            skNos[0] = pBzProcessCreateInBean.getSkNo();
        }

        bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pBzProcessCreateInBean.getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pBzProcessCreateInBean.getMosNo());
        bzGetProcessSummaryInBean.setSyoNo(pBzProcessCreateInBean.getSyoNo());
        bzGetProcessSummaryInBean.setSkNos(skNos);
        bzGetProcessSummaryInBean.setNkSysyNo(pBzProcessCreateInBean.getNkSysyNo());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() == 0) {
        }
        else if (bzGetProcessSummaryOutBeanLst.size() == 1) {
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            bzProcessCreateOutBean.setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

            return bzProcessCreateOutBean;
        }
        else {
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            bzProcessCreateOutBean.setKouteiKanriId("");

            return bzProcessCreateOutBean;
        }

        List<DM_Jimutetuzuki> jimutetuzukiLst =
            workflowDomManager.getJimutetuzukisByJimutetuzukicd(pBzProcessCreateInBean.getJimuTetuzukiCd());
        SortDM_Jimutetuzuki sortDM_Jimutetuzuki = new SortDM_Jimutetuzuki();
        jimutetuzukiLst = sortDM_Jimutetuzuki.OrderDM_JimutetuzukiByHyoujijyunAsc(jimutetuzukiLst);
        if (jimutetuzukiLst.size() == 0) {
            throw new BizAppException(
                MessageId.EBS0004, DM_Jimutetuzuki.TABLE_NAME, DM_Jimutetuzuki.JIMUTETUZUKICD, pBzProcessCreateInBean.getJimuTetuzukiCd());
        }

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = new SetKouteiKanriIdInBean();

        String wkSubSystemId;
        if (BizUtil.isBlank(pBzProcessCreateInBean.getSubSystemId())){
            wkSubSystemId = jimutetuzukiLst.get(0).getSubSystemId();
        }
        else {
            wkSubSystemId = pBzProcessCreateInBean.getSubSystemId();
        }

        setKouteiKanriIdInBean.setSubSystemId(wkSubSystemId);
        setKouteiKanriIdInBean.setJimutetuzukiCd(pBzProcessCreateInBean.getJimuTetuzukiCd());
        setKouteiKanriIdInBean.setMosNo(pBzProcessCreateInBean.getMosNo());
        setKouteiKanriIdInBean.setSyoNo(pBzProcessCreateInBean.getSyoNo());
        setKouteiKanriIdInBean.setSkNo(pBzProcessCreateInBean.getSkNo());
        setKouteiKanriIdInBean.setNkSysyNo(pBzProcessCreateInBean.getNkSysyNo());
        setKouteiKanriIdInBean.setOyaKouteiKanriId(pBzProcessCreateInBean.getOyaKouteiKanriId());
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd(pBzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd());

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        ProcessCreateInBean processCreateInBean = new ProcessCreateInBean();

        processCreateInBean.setGyoumukey(kouteiKanriId);
        processCreateInBean.setFlowid(pBzProcessCreateInBean.getJimuTetuzukiCd());
        processCreateInBean.setAccountid(baseUserInfo.getUserId());

        WSExtParam extParam12 = new WSExtParam();
        WSExtParam extParam8 = new WSExtParam();
        WSExtParam extParam13 = new WSExtParam();
        WSExtParam extParam14 = new WSExtParam();
        WSExtParam extParam1 = new WSExtParam();
        WSExtParam extParam2 = new WSExtParam();
        WSExtParam extParam3 = new WSExtParam();
        WSExtParam extParam4 = new WSExtParam();
        WSExtParam extParam5 = new WSExtParam();
        WSExtParam extParam7 = new WSExtParam();
        WSExtParam extParam9 = new WSExtParam();
        WSExtParam extParam11 = new WSExtParam();
        WSExtParam extParam10 = new WSExtParam();
        WSExtParam extParam15 = new WSExtParam();
        WSExtParam extParam16 = new WSExtParam();
        WSExtParam extParam17 = new WSExtParam();

        extParam12.setValues(pBzProcessCreateInBean.getSyoNo());

        if (pBzProcessCreateInBean.getJmycdMisetteiKbn() != null) {

            extParam8.setValues(pBzProcessCreateInBean.getJmycdMisetteiKbn().getValue());
        }
        else {

            extParam8.setValues(C_UmuKbn.ARI.getValue());
        }

        extParam13.setValues(pBzProcessCreateInBean.getNkSysyNo());

        extParam14.setValues(pBzProcessCreateInBean.getMosNo());

        if (pBzProcessCreateInBean.getSkeijimuKbn() != null) {

            extParam1.setValues(pBzProcessCreateInBean.getSkeijimuKbn().getValue());
        }

        if (pBzProcessCreateInBean.getMosUketukeKbn() != null) {

            extParam2.setValues(pBzProcessCreateInBean.getMosUketukeKbn().getValue());
        }

        if (pBzProcessCreateInBean.getHknsyuruiNo() != null) {

            extParam3.setValues(pBzProcessCreateInBean.getHknsyuruiNo().getValue());
        }

        if (!BizUtil.isBlank(pBzProcessCreateInBean.getDairitenCd1())) {

            extParam4.setValues(pBzProcessCreateInBean.getDairitenCd1());

        }

        if (!BizUtil.isBlank(pBzProcessCreateInBean.getDairitenCd2())) {

            extParam5.setValues(pBzProcessCreateInBean.getDairitenCd2());
        }

        if (!BizUtil.isBlank(pBzProcessCreateInBean.getJimuyouCd())) {

            extParam7.setValues(pBzProcessCreateInBean.getJimuyouCd());
        }

        if (pBzProcessCreateInBean.getDoujiMosumu() != null) {

            extParam9.setValues(pBzProcessCreateInBean.getDoujiMosumu().getValue());
        }

        if (!BizUtil.isBlank(pBzProcessCreateInBean.getJimustartYmd())) {

            extParam11.setValues(pBzProcessCreateInBean.getJimustartYmd());

        }

        if (pBzProcessCreateInBean.getMosymd() != null) {

            extParam10.setValues(pBzProcessCreateInBean.getMosymd().toString());
        }

        if (pBzProcessCreateInBean.getKetteiKbn() != null) {

            extParam15.setValues(pBzProcessCreateInBean.getKetteiKbn().getValue());
        }

        if (pBzProcessCreateInBean.getSeirituKbn() != null) {

            extParam16.setValues(pBzProcessCreateInBean.getSeirituKbn().getValue());
        }

        if (pBzProcessCreateInBean.getLincjkKbn() != null) {

            extParam17.setValues(pBzProcessCreateInBean.getLincjkKbn().getValue());
        }

        processCreateInBean.setExtParam12(extParam12);
        processCreateInBean.setExtParam8(extParam8);
        processCreateInBean.setExtParam13(extParam13);
        processCreateInBean.setExtParam14(extParam14);
        processCreateInBean.setExtParam1(extParam1);
        processCreateInBean.setExtParam2(extParam2);
        processCreateInBean.setExtParam3(extParam3);
        processCreateInBean.setExtParam4(extParam4);
        processCreateInBean.setExtParam5(extParam5);
        processCreateInBean.setExtParam7(extParam7);
        processCreateInBean.setExtParam9(extParam9);
        processCreateInBean.setExtParam11(extParam11);
        processCreateInBean.setExtParam10(extParam10);
        processCreateInBean.setExtParam15(extParam15);
        processCreateInBean.setExtParam16(extParam16);
        processCreateInBean.setExtParam17(extParam17);

        ProcessCreateOutBean processCreateOutBean = iwfKouteiClient.execProcessCreate(processCreateInBean);

        String kekkaStatus = processCreateOutBean.getKekkastatus();
        String syousaiMsgCd = processCreateOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程作成", "工程作成", syousaiMsgCd);
        }

        if (syuKouteiFlag) {

            bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(pBzProcessCreateInBean.getJimuTetuzukiCd());
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pBzProcessCreateInBean.getMosNo());
            bzGetProcessSummaryInBean.setSyoNo(pBzProcessCreateInBean.getSyoNo());
            bzGetProcessSummaryInBean.setSkNos(skNos);
            bzGetProcessSummaryInBean.setNkSysyNo(pBzProcessCreateInBean.getNkSysyNo());

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            boolean kyougouErrorFlag = false;

            for (BzGetProcessSummaryOutBean outBean : bzGetProcessSummaryOutBeanLst) {
                if (outBean.getKouteiKanriId().equals(kouteiKanriId)) {
                }
                else {
                    kyougouErrorFlag = true;
                    break;
                }
            }

            if (kyougouErrorFlag) {

                bzLockProcessOutBean = bzLockProcess.exec(kouteiKanriId, pBzProcessCreateInBean.getJimuTetuzukiCd());

                String kouteiCancelLockKey = "";
                if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                    kouteiCancelLockKey = bzLockProcessOutBean.getKouteiLockKey();
                }
                else {
                    throw new BizAppException(MessageId.EBF0011);
                }

                ProcessCancelInBean processCancelInBean = new ProcessCancelInBean();

                processCancelInBean.setGyoumukey(kouteiKanriId);
                processCancelInBean.setFlowid(pBzProcessCreateInBean.getJimuTetuzukiCd());
                processCancelInBean.setAccountid(baseUserInfo.getUserId());
                processCancelInBean.setLockkey(kouteiCancelLockKey);

                ProcessCancelOutBean processCancelOutBean = iwfKouteiClient.execProcessCancel(processCancelInBean);

                kekkaStatus = processCancelOutBean.getKekkastatus();
                syousaiMsgCd = processCancelOutBean.getSyousaimsgcd();

                if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
                }
                else {
                    throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程作成", "工程取消", syousaiMsgCd);
                }

                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
                bzProcessCreateOutBean.setKouteiKanriId("");

                return bzProcessCreateOutBean;
            }
        }
        else {
        }

        bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
        bzProcessCreateOutBean.setKouteiKanriId(kouteiKanriId);

        return bzProcessCreateOutBean;
    }
}
