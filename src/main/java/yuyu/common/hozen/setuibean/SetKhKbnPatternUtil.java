package yuyu.common.hozen.setuibean;

import javax.inject.Inject;

import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AS_Kinou;

/**
 * 契約保全 UiBean設定 契約保全区分パターン設定
 */
public class SetKhKbnPatternUtil {

    @Inject
    private AS_Kinou kinou;

    public void exec(SetKhKbnPatternUtilUiBeanParam pUiBean) {

        if (IKhozenCommonConstants.KINOUID_HUBITOUROKU.equals(kinou.getKinouId())) {

            if (C_KhkinouModeIdKbn.HUBITOUROKU.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHHUBITOUROKU);
            }
            else if (C_KhkinouModeIdKbn.HUBISYOUNIN.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHHUBISYOUNIN);
            }
        }
        else if (IKhozenCommonConstants.KINOUID_HUBIKAISYOU.equals(kinou.getKinouId())) {

            pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHHUBIKAISYOU);
        }
        else {
            if (C_KhkinouModeIdKbn.INPUT.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHINPUT);
            }
            else if (C_KhkinouModeIdKbn.TENKEN.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHTENKEN);
            }
            else if (C_KhkinouModeIdKbn.SYOUNIN.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHSYOUNIN);
            }
            else if (C_KhkinouModeIdKbn.INPUTKEY.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHINPUTKEY);
            }
            else if ( C_KhkinouModeIdKbn.KYUUKZANNAIMATI.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHKYUUKZANNAIMATI);
            }
            else if (C_KhkinouModeIdKbn.CARDTOUROKUMATI.eq(pUiBean.getKhkinouModeIdKbn())) {

                pUiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHCARDTOUROKUMATI);
            }
        }
    }

}
