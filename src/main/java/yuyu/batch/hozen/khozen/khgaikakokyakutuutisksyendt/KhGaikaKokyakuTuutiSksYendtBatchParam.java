package yuyu.batch.hozen.khozen.khgaikakokyakutuutisksyendt;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 契約保全 外貨建顧客通知作成（円建変更後）のパラメータ
 */
@BatchScoped
public class KhGaikaKokyakuTuutiSksYendtBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String campaignUmuKbn;
}
