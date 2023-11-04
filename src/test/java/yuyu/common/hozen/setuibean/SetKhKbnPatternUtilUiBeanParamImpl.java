package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_KhkinouModeIdKbn;

/**
 * 契約保全 UiBean設定 契約保全区分パターン設定UiBeanパラメータ
 */
public class SetKhKbnPatternUtilUiBeanParamImpl implements SetKhKbnPatternUtilUiBeanParam {

    private C_KhkinouModeIdKbn khkinouModeIdKbn = null;

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    private String patternSyorikekkakbn;

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

}
