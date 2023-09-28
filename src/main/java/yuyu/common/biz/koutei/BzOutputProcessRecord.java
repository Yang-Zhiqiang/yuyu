package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 業務共通工程履歴出力
 */
public class BzOutputProcessRecord {

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo userInfo;

    public BzOutputProcessRecord() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pSyoriComment, String pTaskName,
            C_SyorikekkaKbn pSyorikekkaKbn) {

        List<Map<String, String>> extInfoLst = new ArrayList<>();
        Map<String, String> extInfoMp = new HashMap<>();

        extInfoMp.put(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN, pSyorikekkaKbn.getValue());
        extInfoLst.add(extInfoMp);

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();

        createProcessRecordInBean.setGyoumukey(pKouteiKanriId);
        createProcessRecordInBean.setFlowid(pJimuTetuzukiCd);
        createProcessRecordInBean.setAccountid(userInfo.getUserId());
        createProcessRecordInBean.setRirekimsg(pSyoriComment);
        createProcessRecordInBean.setTaskname(pTaskName);
        createProcessRecordInBean.setExtInfo(extInfoLst);

        CreateProcessRecordOutBean createProcessRecordOutBean =
                iwfKouteiClient.execCcreateProcessRecord(createProcessRecordInBean);

        String kekkaStatus = createProcessRecordOutBean.getKekkastatus();
        String syousaiMsgCd = createProcessRecordOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "業務共通工程履歴出力", "工程履歴作成", syousaiMsgCd);
        }
    }
}
