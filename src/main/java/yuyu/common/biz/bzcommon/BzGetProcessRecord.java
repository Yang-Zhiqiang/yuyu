package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 業務共通工程履歴取得
 */
public class BzGetProcessRecord {

    @Inject
    private static Logger logger;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzGetProcessRecord() {
        super();
    }

    public BzGetProcessRecordOutputBean exec(BzGetProcessRecordInputBean pBzGetKouteiRirekiInBean) {

        logger.debug("▽ 業務共通工程履歴取得 開始");

        GetProcessRecordInBean getProcessRecordInBean = SWAKInjector.getInstance(GetProcessRecordInBean.class);
        getProcessRecordInBean.setFlowid(pBzGetKouteiRirekiInBean.getJimuTetuzukiCd());
        getProcessRecordInBean.setGyoumukey(pBzGetKouteiRirekiInBean.getKouteiKanriId());
        getProcessRecordInBean.setRirekikbn(String.valueOf(pBzGetKouteiRirekiInBean.getRirekiKbn()));

        GetProcessRecordOutBean getProcessRecordOutBean =
            iwfKouteiClient.execGetProcessRecord(getProcessRecordInBean);

        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean
        = SWAKInjector.getInstance(BzGetProcessRecordOutputBean.class);

        bzGetProcessRecordOutputBean.setKekkaStatus(getProcessRecordOutBean.getKekkastatus());
        bzGetProcessRecordOutputBean.setSyousaiMsgCd(getProcessRecordOutBean.getSyousaimsgcd());
        bzGetProcessRecordOutputBean.setSyousaiMsg(getProcessRecordOutBean.getSyousaimsg());

        if (getProcessRecordOutBean.getProcessRecordBeanList() != null) {
            List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
            for (ProcessRecordBean processRecordBean : getProcessRecordOutBean.getProcessRecordBeanList()) {
                String syorikekkaKbn = "0";
                if (processRecordBean.getExtinfo() != null) {
                    for (Map<String, String> map : processRecordBean.getExtinfo()) {
                        if (map.get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN) != null) {
                            syorikekkaKbn = map.get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN);
                            break;
                        }
                    }
                }

                C_IwfSyoriKbn iwfSyoriKbn = null;
                C_RirekiKbn rirekiKbn = null;
                if (!BizUtil.isBlank(processRecordBean.getSyoriKbn())) {
                    iwfSyoriKbn = C_IwfSyoriKbn.valueOf(processRecordBean.getSyoriKbn());
                }
                if (!BizUtil.isBlank(processRecordBean.getRirekiKbn())) {
                    rirekiKbn = C_RirekiKbn.valueOf(processRecordBean.getRirekiKbn());
                }

                BzGetProcessRecordBean bzGetProcessRecordBean = SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setSyoriTime(processRecordBean.getSyoriTime());
                bzGetProcessRecordBean.setKouteiKanriId(processRecordBean.getGyoumukey());
                bzGetProcessRecordBean.setJimutetuzukicd(processRecordBean.getFlowId());
                bzGetProcessRecordBean.setJimutetuzukinm(processRecordBean.getFlowName());
                bzGetProcessRecordBean.setTasknmId(processRecordBean.getNodeName());
                bzGetProcessRecordBean.setTasknm(processRecordBean.getNodeLocalName());
                bzGetProcessRecordBean.setUserId(processRecordBean.getAccountId());
                bzGetProcessRecordBean.setIwfSyoriKbn(iwfSyoriKbn);
                bzGetProcessRecordBean.setRirekiKbn(rirekiKbn);
                bzGetProcessRecordBean.setRirekiMessage(processRecordBean.getRirekiMessage());
                bzGetProcessRecordBean.setSyorikekkaKbn(C_SyorikekkaKbn.valueOf(syorikekkaKbn));

                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
            }
            bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
        }

        logger.debug("△ 業務共通工程履歴取得 終了");
        return bzGetProcessRecordOutputBean;
    }
}
