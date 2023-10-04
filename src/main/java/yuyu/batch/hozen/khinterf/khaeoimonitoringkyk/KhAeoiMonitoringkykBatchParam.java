package yuyu.batch.hozen.khinterf.khaeoimonitoringkyk;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 インターフェイス ＡＥＯＩモニタリング契約抽出パラメータ
 */
@BatchScoped
public class KhAeoiMonitoringkykBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private int tysytKikan;

}
