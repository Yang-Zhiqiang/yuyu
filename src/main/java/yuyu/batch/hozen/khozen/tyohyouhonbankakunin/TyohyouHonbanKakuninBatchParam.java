package yuyu.batch.hozen.khozen.tyohyouhonbankakunin;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 契約保全 帳票本番確認パラメータ
 */
@BatchScoped
public class TyohyouHonbanKakuninBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String tyouhyouybdskinou;

}
