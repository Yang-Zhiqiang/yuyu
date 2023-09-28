package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;

/**
 * ユーザー別工程履歴取得サービスのBeanです。<br/>
 */
@SuppressWarnings("serial")
public class ProcessRecordAndSummaryByUserBean implements Serializable {
    WT_KouteiRireki kouteirireki;
    WT_KouteiSummary kouteiSummary;

    public WT_KouteiRireki getKouteiRireki() {
        return kouteirireki;
    }

    public void setKouteiRireki(WT_KouteiRireki pKouteiRireki) {
        kouteirireki = pKouteiRireki;
    }

    public WT_KouteiSummary getKouteiSummary() {
        return kouteiSummary;
    }

    public void setKouteiSummary(WT_KouteiSummary pKouteiSummary) {
        kouteiSummary = pKouteiSummary;
    }
}
