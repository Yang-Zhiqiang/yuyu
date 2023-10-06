package yuyu.batch.biz.bzinterf.bzlinckyknaiyousks;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 業務共通 インターフェイス 契約内容ＬＩＮＣ送信Ｆ作成パラメータ
 */
@BatchScoped
public class BzLincKykNaiyouSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String lincsousindatasyurui;

    public String getLincsousindatasyurui() {
        return lincsousindatasyurui;
    }

    public void setLincsousindatasyurui(String pLincsousindatasyurui) {
        lincsousindatasyurui = pLincsousindatasyurui;
    }
}
