package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomisyoimage;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 新契約 申込入力 ペーパーレス申込書イメージ取込バッチパラメータ
 */
@BatchScoped
public class SkPaperlessMousikomisyoImageBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String torikomumotocd;

    public String getTorikomumotocd() {

        return torikomumotocd;
    }

    public void setTorikomumotocd(String pTorikomumotocd) {

        this.torikomumotocd = pTorikomumotocd;
    }
}
