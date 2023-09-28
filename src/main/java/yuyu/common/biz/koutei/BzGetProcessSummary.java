package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.dao.DM_JimutetuzukiTaskDao;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;

import com.google.common.collect.Ordering;

/**
 * 業務共通 工程 業務共通工程サマリ取得
 */
public class BzGetProcessSummary {

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BizDomManager bizDomManager;

    private static List<DM_Jimutetuzuki> jimutetuzukiList = null;

    private static List<DM_JimutetuzukiTask> jimutetuzukiTaskList = null;

    private static boolean readFlg = false;

    public BzGetProcessSummary() {
        super();
    }

    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
            getProcessSummaryInBean.setFlowid(pBzGetProcessSummaryInBean.getJimuTetuzukiCd());
        }

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getKouteiKanriId())) {
            getProcessSummaryInBean.setGyoumukey(pBzGetProcessSummaryInBean.getKouteiKanriId());
        }

        if (pBzGetProcessSummaryInBean.getKouteiKanriIds() != null) {
            getProcessSummaryInBean.setGyoumukeys(pBzGetProcessSummaryInBean.getKouteiKanriIds());
        }

        if (pBzGetProcessSummaryInBean.getKouteiStartYmdFrom() != null) {
            getProcessSummaryInBean.setKouteikaisibifrom(pBzGetProcessSummaryInBean.getKouteiStartYmdFrom().toString());
            getProcessSummaryInBean.setKouteikaisibito(pBzGetProcessSummaryInBean.getKouteiStartYmdTo().toString());
        }

        if (pBzGetProcessSummaryInBean.getKouteEndYmdFrom() != null) {
            getProcessSummaryInBean.setKouteikanryoubifrom(pBzGetProcessSummaryInBean.getKouteEndYmdFrom().toString());
            getProcessSummaryInBean.setKouteikanryoubito(pBzGetProcessSummaryInBean.getKouteEndYmdTo().toString());
        }

        if (pBzGetProcessSummaryInBean.getKouteiKanriStatuss() != null) {
            String[] kouteiKanriStatuss = new String[pBzGetProcessSummaryInBean.getKouteiKanriStatuss().length];
            for (int index = 0; index < pBzGetProcessSummaryInBean.getKouteiKanriStatuss().length; index++) {
                kouteiKanriStatuss[index] = pBzGetProcessSummaryInBean.getKouteiKanriStatuss()[index].getValue();
            }
            getProcessSummaryInBean.setSyoristatus(kouteiKanriStatuss);
        }

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getJimuKaisiYmdFrom()) || !BizUtil.isBlank(pBzGetProcessSummaryInBean.getJimuKaisiYmdTo())) {
            WSExtParam extParam11 = new WSExtParam();

            if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getJimuKaisiYmdFrom())){
                String tempJimuKaisiYmdFrom = null;
                if(pBzGetProcessSummaryInBean.getJimuKaisiYmdFrom().length()!=17){
                    tempJimuKaisiYmdFrom = pBzGetProcessSummaryInBean.getJimuKaisiYmdFrom() + "000000000";
                }else{
                    tempJimuKaisiYmdFrom = pBzGetProcessSummaryInBean.getJimuKaisiYmdFrom();
                }
                extParam11.setValueFrom(tempJimuKaisiYmdFrom);
            }

            if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getJimuKaisiYmdTo())){
                String tempJimuKaisiYmdTo = null;
                if(pBzGetProcessSummaryInBean.getJimuKaisiYmdTo().length()!=17){
                    tempJimuKaisiYmdTo = pBzGetProcessSummaryInBean.getJimuKaisiYmdTo() + "235959999";
                }else{
                    tempJimuKaisiYmdTo = pBzGetProcessSummaryInBean.getJimuKaisiYmdTo();
                }
                extParam11.setValueTo(tempJimuKaisiYmdTo);
            }
            getProcessSummaryInBean.setExtParam11(extParam11);
        }

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getSyoNo())) {
            WSExtParam extParam = new WSExtParam();
            extParam.setValues(pBzGetProcessSummaryInBean.getSyoNo());
            getProcessSummaryInBean.setExtParam12(extParam);
        }

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getNkSysyNo())) {
            WSExtParam extParam1 = new WSExtParam();
            extParam1.setValues(pBzGetProcessSummaryInBean.getNkSysyNo());
            getProcessSummaryInBean.setExtParam13(extParam1);
        }

        if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getMosNo())) {
            WSExtParam extParam2 = new WSExtParam();
            extParam2.setValues(pBzGetProcessSummaryInBean.getMosNo());
            getProcessSummaryInBean.setExtParam14(extParam2);
        }

        if (pBzGetProcessSummaryInBean.getKetteiKbn() != null) {
            WSExtParam extParam15 = new WSExtParam();
            String[] tempKetteiKbn = new String[pBzGetProcessSummaryInBean.getKetteiKbn().length];
            for (int index = 0; index < pBzGetProcessSummaryInBean.getKetteiKbn().length; index++) {
                tempKetteiKbn[index] = pBzGetProcessSummaryInBean.getKetteiKbn()[index].getValue();
            }
            extParam15.setValues(tempKetteiKbn);
            getProcessSummaryInBean.setExtParam15(extParam15);
        }

        if (pBzGetProcessSummaryInBean.getSeirituKbn() != null) {
            WSExtParam extParam16 = new WSExtParam();
            String[] tempSeirituKbn = new String[pBzGetProcessSummaryInBean.getSeirituKbn().length];
            for (int index = 0; index < pBzGetProcessSummaryInBean.getSeirituKbn().length; index++) {
                tempSeirituKbn[index] = pBzGetProcessSummaryInBean.getSeirituKbn()[index].getValue();
            }
            extParam16.setValues(tempSeirituKbn);
            getProcessSummaryInBean.setExtParam16(extParam16);
        }

        if (pBzGetProcessSummaryInBean.getLincjkKbn() != null) {
            WSExtParam extParam17 = new WSExtParam();
            String[] tempLincjkKbn = new String[pBzGetProcessSummaryInBean.getLincjkKbn().length];
            for (int index = 0; index < pBzGetProcessSummaryInBean.getLincjkKbn().length; index++) {
                tempLincjkKbn[index] = pBzGetProcessSummaryInBean.getLincjkKbn()[index].getValue();
            }
            extParam17.setValues(tempLincjkKbn);
            getProcessSummaryInBean.setExtParam17(extParam17);
        }

        getProcessSummaryInBean.setKekkajyougenkensu(pBzGetProcessSummaryInBean.getKekkajyougenkensu());

        if(pBzGetProcessSummaryInBean.getTaskIds() == null && pBzGetProcessSummaryInBean.getTaskId() != null){
            getProcessSummaryInBean.setNodename(pBzGetProcessSummaryInBean.getTaskId());
        }

        GetProcessSummaryOutBean getProcessSummaryOutBean =
            iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

        String kekkaStatus = getProcessSummaryOutBean.getKekkastatus();
        String syousaiMsgCd = getProcessSummaryOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            if(!BizUtil.isBlank(pBzGetProcessSummaryInBean.getKekkajyougenkensu()) && syousaiMsgCd.equals("IWF2160")){
                throw new BizAppException(MessageId.EBS1010);
            }
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程サマリ取得", "工程サマリ取得", syousaiMsgCd);
        }

        List<ProcessSummaryBean> processSummaryBeanLst = getProcessSummaryOutBean.getProcessSummaryBeanList();

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (processSummaryBeanLst != null) {

            getJimutetuzukiDataList();

            for (ProcessSummaryBean processSummaryBean : processSummaryBeanLst) {
                if (pBzGetProcessSummaryInBean.getTaskIds() != null) {
                    List<String> taskIdLst = Arrays.asList(pBzGetProcessSummaryInBean.getTaskIds());
                    if (!taskIdLst.contains(processSummaryBean.getCurrentNodeName())) {
                        continue;
                    }
                }

                BT_GyoumuKouteiInfo gyoumuKouteiInfo =
                    bizDomManager.getGyoumuKouteiInfo(processSummaryBean.getGyoumukey());

                C_YesNoKbn syukouteiKbn = null;
                if (gyoumuKouteiInfo.getSyukouteikanriid().equals(gyoumuKouteiInfo.getKouteikanriid())) {
                    syukouteiKbn = C_YesNoKbn.YES;
                }
                else {
                    if (C_UmuKbn.ARI.eq(pBzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu())) {
                        continue;
                    }
                    syukouteiKbn = C_YesNoKbn.NO;
                }

                if (!BizUtil.isBlank(pBzGetProcessSummaryInBean.getSubSystemId())) {
                    if (!pBzGetProcessSummaryInBean.getSubSystemId().equals(gyoumuKouteiInfo.getSubSystemId())) {
                        continue;
                    }
                }

                if (pBzGetProcessSummaryInBean.getSkNos() != null) {
                    List<String> skNoLst = Arrays.asList(pBzGetProcessSummaryInBean.getSkNos());
                    if (!skNoLst.contains(gyoumuKouteiInfo.getSkno())) {
                        continue;
                    }
                }

                DM_Jimutetuzuki jimutetuzuki = null;
                for (int i = 0; i < jimutetuzukiList.size(); i++) {
                    if (jimutetuzukiList.get(i).getJimutetuzukicd().equals(processSummaryBean.getFlowId()) &&
                        jimutetuzukiList.get(i).getSubSystemId().equals(gyoumuKouteiInfo.getSubSystemId())) {
                        jimutetuzuki = jimutetuzukiList.get(i);
                        break;
                    }
                }

                String previousNodeNm = "";

                DM_JimutetuzukiTask jimutetuzukiTaskPrevious = null;
                for (int i = 0; i < jimutetuzukiTaskList.size(); i++) {
                    if (jimutetuzukiTaskList.get(i).getJimutetuzukicd().equals(processSummaryBean.getFlowId()) &&
                        jimutetuzukiTaskList.get(i).getWorkflowTskId().equals(processSummaryBean.getPreviousNodeName())) {
                        jimutetuzukiTaskPrevious = jimutetuzukiTaskList.get(i);
                        break;
                    }
                }

                if (jimutetuzukiTaskPrevious != null) {
                    previousNodeNm = jimutetuzukiTaskPrevious.getWorkflowTskNm();
                }

                String currentNodeName = "";
                int hyoujiJyun = 0;
                if (BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT.equals(processSummaryBean.getCurrentNodeName())) {
                }
                else {
                    DM_JimutetuzukiTask jimutetuzukiTaskCurrent = null;
                    for (int i = 0; i < jimutetuzukiTaskList.size(); i++) {
                        if (jimutetuzukiTaskList.get(i).getJimutetuzukicd().equals(processSummaryBean.getFlowId()) &&
                            jimutetuzukiTaskList.get(i).getWorkflowTskId().equals(processSummaryBean.getCurrentNodeName())) {
                            jimutetuzukiTaskCurrent = jimutetuzukiTaskList.get(i);
                            break;
                        }
                    }

                    if (jimutetuzukiTaskCurrent != null) {
                        currentNodeName = jimutetuzukiTaskCurrent.getWorkflowTskNm();
                        hyoujiJyun = jimutetuzukiTaskCurrent.getHyoujijyun();
                    }
                }

                BizDate jimustartYmd = null;
                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam11())) {
                    jimustartYmd = BizDate
                        .valueOf(processSummaryBean.getExtparamBean().getExtparam11().substring(0, 8));
                }

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();

                bzGetProcessSummaryOutBean.setJimuTetuzukiCd(processSummaryBean.getFlowId());
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm(jimutetuzuki.getJimutetuzukinm());
                bzGetProcessSummaryOutBean.setKouteiKanriId(processSummaryBean.getGyoumukey());

                if (!BizUtil.isBlank(processSummaryBean.getKouteiKaisiYmd())) {
                    bzGetProcessSummaryOutBean.setKouteiStartYmd(BizDate.valueOf(processSummaryBean.getKouteiKaisiYmd()));
                }
                else {
                    bzGetProcessSummaryOutBean.setKouteiStartYmd(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getKouteikanryouYmd())) {
                    bzGetProcessSummaryOutBean.setKouteEndYmd(BizDate.valueOf(processSummaryBean.getKouteikanryouYmd()));
                }
                else {
                    bzGetProcessSummaryOutBean.setKouteEndYmd(null);
                }

                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.valueOf(processSummaryBean.getProcessstatus()));
                bzGetProcessSummaryOutBean.setLastKosTime(processSummaryBean.getUpdateTime());
                bzGetProcessSummaryOutBean.setFirstTantId(processSummaryBean.getFirstAccountId());
                bzGetProcessSummaryOutBean.setZnkTantId(processSummaryBean.getPreviousAccountId());
                bzGetProcessSummaryOutBean.setZnkNodoId(processSummaryBean.getPreviousNodeName());
                bzGetProcessSummaryOutBean.setZnkNodoNm(previousNodeNm);
                bzGetProcessSummaryOutBean.setNowTantId(processSummaryBean.getCurrentAccountId());
                bzGetProcessSummaryOutBean.setNowNodoId(processSummaryBean.getCurrentNodeName());
                bzGetProcessSummaryOutBean.setNowNodoNm(currentNodeName);
                bzGetProcessSummaryOutBean.setJimuStartYmd(jimustartYmd);
                bzGetProcessSummaryOutBean.setMosNo(processSummaryBean.getExtparamBean().getExtparam14());
                bzGetProcessSummaryOutBean.setSyoNo(processSummaryBean.getExtparamBean().getExtparam12());
                bzGetProcessSummaryOutBean.setSkNo(gyoumuKouteiInfo.getSkno());
                bzGetProcessSummaryOutBean.setNkSysyNo(processSummaryBean.getExtparamBean().getExtparam13());

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam1())) {
                    bzGetProcessSummaryOutBean.setSkeijimuKbn(C_SkeijimuKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam1()));
                }
                else {
                    bzGetProcessSummaryOutBean.setSkeijimuKbn(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam2())) {
                    bzGetProcessSummaryOutBean.setMosUketukeKbn(C_MosUketukeKbn.valueOf(processSummaryBean
                        .getExtparamBean().getExtparam2()));
                }
                else {
                    bzGetProcessSummaryOutBean.setMosUketukeKbn(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam3())) {
                    bzGetProcessSummaryOutBean.setHknsyuruiNo(C_HknsyuruiNo.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam3()));
                }
                else {
                    bzGetProcessSummaryOutBean.setHknsyuruiNo(null);
                }

                bzGetProcessSummaryOutBean.setDairitencd1(processSummaryBean.getExtparamBean().getExtparam4());
                bzGetProcessSummaryOutBean.setDairitencd2(processSummaryBean.getExtparamBean().getExtparam5());
                bzGetProcessSummaryOutBean.setJimuyoucd(processSummaryBean.getExtparamBean().getExtparam7());

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam8())) {
                    bzGetProcessSummaryOutBean.setJmycdMisetteiKbn(C_UmuKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam8()));
                }
                else {
                    bzGetProcessSummaryOutBean.setJmycdMisetteiKbn(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam9())) {
                    bzGetProcessSummaryOutBean.setDoujimosumu(C_UmuKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam9()));
                }
                else {
                    bzGetProcessSummaryOutBean.setDoujimosumu(null);
                }

                bzGetProcessSummaryOutBean.setJimuStartYmdTime(processSummaryBean.getExtparamBean().getExtparam11());

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam10())) {
                    bzGetProcessSummaryOutBean.setMosymd(BizDate.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam10()));
                }
                else {
                    bzGetProcessSummaryOutBean.setMosymd(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam15())) {
                    bzGetProcessSummaryOutBean.setKetteiKbn(C_KetteiKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam15()));
                }
                else {
                    bzGetProcessSummaryOutBean.setKetteiKbn(null);
                }


                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam16())) {
                    bzGetProcessSummaryOutBean.setSeirituKbn(C_SeirituKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam16()));
                }
                else {
                    bzGetProcessSummaryOutBean.setSeirituKbn(null);
                }

                if (!BizUtil.isBlank(processSummaryBean.getExtparamBean().getExtparam17())) {
                    bzGetProcessSummaryOutBean.setLincjkKbn(C_LincjkKbn.valueOf(processSummaryBean.getExtparamBean()
                        .getExtparam17()));
                }
                else {
                    bzGetProcessSummaryOutBean.setLincjkKbn(null);
                }

                bzGetProcessSummaryOutBean.setSyukouteiKbn(syukouteiKbn);
                bzGetProcessSummaryOutBean.setSubSystemId(gyoumuKouteiInfo.getSubSystemId());
                bzGetProcessSummaryOutBean.setJimutetuzukiDispOrder(jimutetuzuki.getHyoujijyun());
                bzGetProcessSummaryOutBean.setTaskDispOrder(hyoujiJyun);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
        }

        if (pBzGetProcessSummaryInBean.getBzGetProcessSummaryComparator() != null) {
            Ordering<BzGetProcessSummaryOutBean> ordering = Ordering.from(pBzGetProcessSummaryInBean.getBzGetProcessSummaryComparator());
            return ordering.sortedCopy(bzGetProcessSummaryOutBeanLst);

        }

        return bzGetProcessSummaryOutBeanLst;
    }

    private static synchronized void getJimutetuzukiDataList() {

        if (readFlg == false) {
            jimutetuzukiList =  SWAKInjector.getInstance(WorkflowDomManager.class).getAllJimutetuzuki();

            for (DM_Jimutetuzuki entity : jimutetuzukiList) {
                if (entity != null) {
                    entity.detach();
                }
            }

            jimutetuzukiTaskList = SWAKInjector.getInstance(DM_JimutetuzukiTaskDao.class).selectAll();

            for (DM_JimutetuzukiTask entity : jimutetuzukiTaskList) {
                if (entity != null) {
                    entity.detach();
                }
            }

            readFlg = true;
        }
    }

}
