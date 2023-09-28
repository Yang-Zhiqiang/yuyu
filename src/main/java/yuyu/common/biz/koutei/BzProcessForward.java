package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 業務共通 工程 業務共通工程遷移
 */
public class BzProcessForward {

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo userInfo;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzOutputProcessRecord bzOutputProcessRecord;

    @Inject
    private UpdateJimustartymd updateJimustartymd;

    @Inject
    private BzTaskStart bzTaskStart;

    @Inject
    private SetWariateHukaInfo setWariateHukaInfo;

    @Inject
    private BzEndProcess bzEndProcess;

    public BzProcessForward() {
        super();
    }

    public void exec(BzProcessForwardInBean pBzProcessForwardInBean) {

        String kouteiKanriId = pBzProcessForwardInBean.getKouteiKanriId();
        String jimuTetuzukiCd = pBzProcessForwardInBean.getJimuTetuzukiCd();
        String kouteiLockKey = pBzProcessForwardInBean.getKouteiLockKey();
        String syoriComment = pBzProcessForwardInBean.getSyoriComment();
        C_SyorikekkaKbn syorikekkaKbn = pBzProcessForwardInBean.getSyorikekkaKbn();

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (C_YouhiKbn.YOU.eq(pBzProcessForwardInBean.getJimuStartYmdYouhiKbn()) || pBzProcessForwardInBean.getJimuStartYmdYouhiKbn() == null) {
            if (bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd() == null) {
                updateJimustartymd.exec(jimuTetuzukiCd, kouteiKanriId, kouteiLockKey, BizDate.getSysDateTimeMilli());
            }
        }

        if(pBzProcessForwardInBean.getProcessRecordOutYouhiKbn() == null || C_YouhiKbn.YOU.eq(pBzProcessForwardInBean.getProcessRecordOutYouhiKbn())){
            bzOutputProcessRecord.exec(kouteiKanriId,
                jimuTetuzukiCd,
                syoriComment,
                bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm(),
                syorikekkaKbn);
        }

        List<Map<String, String>> extInfoLst = new ArrayList<>();
        Map<String, String> extInfoMp = new HashMap<>();

        extInfoMp.put(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN, syorikekkaKbn.getValue());
        extInfoLst.add(extInfoMp);

        ProcessForwardInBean processForwardInBean = new ProcessForwardInBean();

        processForwardInBean.setGyoumukey(kouteiKanriId);
        processForwardInBean.setFlowid(jimuTetuzukiCd);
        processForwardInBean.setAccountid(userInfo.getUserId());
        processForwardInBean.setExtInfo(extInfoLst);
        processForwardInBean.setLockkey(kouteiLockKey);

        ProcessForwardOutBean processForwardOutBean =
            iwfKouteiClient.execProcessForward(processForwardInBean, pBzProcessForwardInBean.getIwfApiRuleBean());

        String kekkaStatus = processForwardOutBean.getKekkastatus();
        String syousaiMsgCd = processForwardOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程遷移", "工程遷移", syousaiMsgCd);
        }

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        if (!BizUtil.isBlank(pBzProcessForwardInBean.getSaiwariateUserId())) {
            bzTaskStart.exec(kouteiKanriId,
                jimuTetuzukiCd,
                bzGetProcessSummaryOutBean.getNowNodoId(),
                kouteiLockKey,
                pBzProcessForwardInBean.getSaiwariateUserId());
        }

        setWariateHukaInfo.exec(kouteiKanriId,
            bzGetProcessSummaryOutBean.getSubSystemId(),
            jimuTetuzukiCd,
            bzGetProcessSummaryOutBean.getZnkNodoId(),
            bzGetProcessSummaryOutBean.getNowNodoId());

        if (C_YesNoKbn.YES.eq(bzGetProcessSummaryOutBean.getSyukouteiKbn()) &&
            BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {
            bzEndProcess.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, C_YouhiKbn.HUYOU);
        }
    }
}
