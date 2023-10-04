package yuyu.batch.hozen.khozen.khrin1;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 契約保全 契約保全臨時処理１パラメータ
 */
@BatchScoped
public class KhRin1BatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate rinji1Ymd;

}
