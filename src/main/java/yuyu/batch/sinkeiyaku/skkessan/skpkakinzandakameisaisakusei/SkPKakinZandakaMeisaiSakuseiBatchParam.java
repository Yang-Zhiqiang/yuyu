package yuyu.batch.sinkeiyaku.skkessan.skpkakinzandakameisaisakusei;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 新契約 決算 新契約Ｐ過金残高明細作成バッチパラメータ
 */
@BatchScoped
public class SkPKakinZandakaMeisaiSakuseiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String syoriKbn;

    public String getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(String pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }
}
