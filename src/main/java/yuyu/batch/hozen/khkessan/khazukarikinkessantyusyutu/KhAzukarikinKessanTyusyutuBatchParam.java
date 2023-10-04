package yuyu.batch.hozen.khkessan.khazukarikinkessantyusyutu;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 預り金決算情報抽出パラメータ
 */
@BatchScoped
public class KhAzukarikinKessanTyusyutuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate kessanYmd;
}
