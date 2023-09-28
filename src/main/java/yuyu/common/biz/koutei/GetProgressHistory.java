package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

import com.google.common.collect.Ordering;

/**
 * 業務共通 工程 進捗履歴情報取得
 */
public class GetProgressHistory {

    private final String GETPROGRESSHISTORY = "業務共通進捗履歴情報取得";

    private final String KOUTEIPROGRESSHISTORY = "工程履歴取得";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public List<GetProgressHistoryOutBean> exec(String pKouteiKanriId) {

        logger.debug("▽ 進捗履歴情報取得　開始");

        List<GetProgressHistoryOutBean> getProgressHistoryOutBeanLst = new ArrayList<>();

        List<ProcessRecordBean> processRecordBeanLst = new ArrayList<>();

        String[] syukouteiKanriIds = new String[]{pKouteiKanriId};

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst =
                bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(syukouteiKanriIds);

        for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoLst) {
            GetProcessRecordInBean getProcessRecordInBean = SWAKInjector.getInstance(GetProcessRecordInBean.class);

            IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

            getProcessRecordInBean.setGyoumukey(gyoumuKouteiInfo.getKouteikanriid());

            getProcessRecordInBean.setRirekikbn(C_RirekiKbn.GYOUMU.getValue());

            GetProcessRecordOutBean getProcessRecordOutBean =
                    iwfKouteiClient.execGetProcessRecord(getProcessRecordInBean);

            if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(getProcessRecordOutBean.getKekkastatus())) {
                throw new BizAppException(MessageId.EBS0007, GETPROGRESSHISTORY, KOUTEIPROGRESSHISTORY,
                        getProcessRecordOutBean.getSyousaimsgcd());
            }

            processRecordBeanLst.addAll(getProcessRecordOutBean.getProcessRecordBeanList());
        }

        for (ProcessRecordBean processRecordBean : processRecordBeanLst) {

            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

            AM_User user = baseDomManager.getUser(processRecordBean.getAccountId());

            String tantousyaName = null;
            if (user != null) {
                tantousyaName = user.getUserNm();
            }

            GetProgressHistoryOutBean getProgressHistoryOutBean =
                    SWAKInjector.getInstance(GetProgressHistoryOutBean.class);

            List<Map<String, String>> extinfos = processRecordBean.getExtinfo();

            for (Map<String, String> extinfo : extinfos) {
                if (extinfo.containsKey(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN)) {
                    getProgressHistoryOutBean.setSyorikekkaKbn(C_SyorikekkaKbn.valueOf(
                            extinfo.get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN)));
                    break;
                }
            }

            getProgressHistoryOutBean.setSyoriTime(processRecordBean.getSyoriTime());
            getProgressHistoryOutBean.setTaskName(processRecordBean.getNodeLocalName());
            getProgressHistoryOutBean.setTantousyaName(tantousyaName);
            getProgressHistoryOutBean.setComment(processRecordBean.getRirekiMessage());

            getProgressHistoryOutBeanLst.add(getProgressHistoryOutBean);
        }


        GetProgressHistoryComparatorSyoritime getProgressHistoryComparatorSyoritime =
                SWAKInjector.getInstance(GetProgressHistoryComparatorSyoritime.class);

        Ordering<GetProgressHistoryOutBean> ordering = Ordering.from(getProgressHistoryComparatorSyoritime);

        logger.debug("△ 進捗履歴情報取得　終了");

        return  ordering.sortedCopy(getProgressHistoryOutBeanLst);

    }

}
