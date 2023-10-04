package yuyu.batch.sinkeiyaku.skkessan.skiktnknkwsseklistsakusei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 新契約 決算 一括入金為替差益リスト作成バッチパラメータ
 */
@BatchScoped
public class SkIktNknKwsSekListSakuseiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String kessanFlg;

    public String getKessanFlg() {
        return kessanFlg;
    }

    public void setKessanFlg(String pKessanFlg) {
        kessanFlg = pKessanFlg;
    }
}
