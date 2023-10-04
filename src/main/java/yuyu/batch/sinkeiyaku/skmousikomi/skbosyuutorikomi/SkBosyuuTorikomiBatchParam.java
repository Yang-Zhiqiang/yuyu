package yuyu.batch.sinkeiyaku.skmousikomi.skbosyuutorikomi;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 新契約 申込入力 募集情報取込バッチパラメータ
 */
@BatchScoped
public class SkBosyuuTorikomiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String torikomumotocd;

    public String getTorikomumotocd() {
        return torikomumotocd;
    }

    public void setTorikomumotocd(String pTorikomumotocd) {
        torikomumotocd = pTorikomumotocd;
    }
}
