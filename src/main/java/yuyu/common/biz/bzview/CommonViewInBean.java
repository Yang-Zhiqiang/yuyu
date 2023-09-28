package yuyu.common.biz.bzview;

import java.io.Serializable;

import yuyu.def.classification.C_HyoujiptnKbn;

import com.google.inject.servlet.RequestScoped;

/**
 * 業務共通 業務共通画面部品 共通画面部品入力Bean <br />
 * UiBeanパラメータ共通インターフェイス型のアクセサを実装 <br />
 * UiBean以外に表示制御に必要なパラメータを保持することも可
 */
@RequestScoped
public class CommonViewInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public CommonViewInBean() {
    }

    CommonViewUiBeanParam commonViewUiBeanParam;

    public CommonViewUiBeanParam getCommonViewUiBeanParam() {
        return commonViewUiBeanParam;
    }

    public void setCommonViewUiBeanParam(CommonViewUiBeanParam pCommonViewUiBeanParam) {
        commonViewUiBeanParam = pCommonViewUiBeanParam;
    }

    private C_HyoujiptnKbn hyoujiptnkbn;

    public C_HyoujiptnKbn getHyoujiptnKbn() {
        return hyoujiptnkbn;
    }

    public void setHyoujiptnKbn(C_HyoujiptnKbn pHyoujiptnkbn) {
        hyoujiptnkbn = pHyoujiptnkbn;
    }

    private boolean viewKouzaInfoInputDispFlg;

    public boolean isViewKouzaInfoInputDispFlg() {
        return viewKouzaInfoInputDispFlg;
    }

    public void setViewKouzaInfoInputDispFlg(boolean pViewKouzaInfoInputDispFlg) {
        viewKouzaInfoInputDispFlg = pViewKouzaInfoInputDispFlg;
    }

    private boolean viewSiharaiSyoukaiGamenFlg;

    public boolean isViewSiharaiSyoukaiGamenFlg() {
        return viewSiharaiSyoukaiGamenFlg;
    }

    public void setViewSiharaiSyoukaiGamenFlg(boolean pViewSiharaiSyoukaiGamenFlg) {
        viewSiharaiSyoukaiGamenFlg = pViewSiharaiSyoukaiGamenFlg;
    }

    private boolean viewSouhuInfoInputDispFlg;

    public boolean isViewSouhuInfoInputDispFlg() {
        return viewSouhuInfoInputDispFlg;
    }

    public void setViewSouhuInfoInputDispFlg(boolean pViewSouhuInfoInputDispFlg) {
        viewSouhuInfoInputDispFlg = pViewSouhuInfoInputDispFlg;
    }

    private boolean viewKsKanskekkaInputDispFlg;

    public boolean isViewKsKanskekkaInputDispFlg() {
        return viewKsKanskekkaInputDispFlg;
    }

    public void setViewKsKanskekkaInputDispFlg(boolean pViewKsKanskekkaInputDispFlg) {
        viewKsKanskekkaInputDispFlg = pViewKsKanskekkaInputDispFlg;
    }

    private boolean viewShAnnaiInputDispFlg;

    public boolean isViewShAnnaiInputDispFlg() {
        return viewShAnnaiInputDispFlg;
    }

    public void setViewShAnnaiInputDispFlg(boolean pViewShAnnaiInputDispFlg) {
        viewShAnnaiInputDispFlg = pViewShAnnaiInputDispFlg;
    }

    private boolean viewSknaiyouInputDispFlg;

    public boolean isViewSknaiyouInputDispFlg() {
        return viewSknaiyouInputDispFlg;
    }

    public void setViewSknaiyouInputDispFlg(boolean pViewSknaiyouInputDispFlg) {
        viewSknaiyouInputDispFlg = pViewSknaiyouInputDispFlg;
    }

    private boolean viewShrGoukeiSyokaiFlg;

    public boolean isViewShrGoukeiSyokaiFlg() {
        return viewShrGoukeiSyokaiFlg;
    }

    public void setViewShrGoukeiSyokaiFlg(boolean pViewShrGoukeiSyokaiFlg) {
        viewShrGoukeiSyokaiFlg = pViewShrGoukeiSyokaiFlg;
    }

}