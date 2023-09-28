package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程情報更新入力Beanクラス
 */
public class BzProcessUpdateInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimuTetuzukiCd;

    private String kouteiKanriId;

    private String kouteiLockKey;

    private C_UmuKbn kokouteiUpdumu;

    private TuikaParamInputBean tuikaParamInputBean;

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

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        kouteiLockKey = pKouteiLockKey;
    }

    public C_UmuKbn getKokouteiUpdumu() {
        return kokouteiUpdumu;
    }

    public void setKokouteiUpdumu(C_UmuKbn pKokouteiUpdumu) {
        kokouteiUpdumu = pKokouteiUpdumu;
    }

    public TuikaParamInputBean getTuikaParamInputBean() {
        return tuikaParamInputBean;
    }

    public void setTuikaParamInputBean(TuikaParamInputBean pTuikaParamInputBean) {
        this.tuikaParamInputBean = pTuikaParamInputBean;
    }
}
