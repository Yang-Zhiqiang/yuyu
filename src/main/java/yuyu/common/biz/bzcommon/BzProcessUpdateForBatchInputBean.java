package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程情報更新（バッチ用）入力Beanクラス
 */
public class BzProcessUpdateForBatchInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimuTetuzukiCd;

    private String kouteiKanriId;

    private C_UmuKbn kokouteiUpdumu;

    private TuikaParamForBatchInputBean tuikaParamForBatchInputBean;

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }

    public C_UmuKbn getKokouteiUpdumu() {
        return kokouteiUpdumu;
    }

    public void setKokouteiUpdumu(C_UmuKbn pKokouteiUpdumu) {
        kokouteiUpdumu = pKokouteiUpdumu;
    }

    public TuikaParamForBatchInputBean getTuikaParamForBatchInputBean() {
        return tuikaParamForBatchInputBean;
    }

    public void setTuikaParamForBatchInputBean(TuikaParamForBatchInputBean pTuikaParamForBatchInputBean) {
        this.tuikaParamForBatchInputBean = pTuikaParamForBatchInputBean;
    }
}
