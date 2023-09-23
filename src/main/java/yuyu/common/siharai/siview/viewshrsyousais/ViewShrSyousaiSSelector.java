package yuyu.common.siharai.siview.viewshrsyousais;

/**
 * 保険金給付金支払 支払画面部品 支払詳細表示（保険金） JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 */
public class ViewShrSyousaiSSelector {


    public static final String HKTSHRMEISAISINFO = "'#hktshrMeisaisInfo'";

    public static final String SYOUHNNMGM_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.syouhnnmgm'";
    }

    public static final String KYHKG_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.kyhkg'";
    }

    public static final String BIKOUMSG1_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.bikoumsg1'";
    }

    public static final String BIKOUMSG2_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.bikoumsg2'";
    }

    public static final String BIKOUMSG3_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.bikoumsg3'";
    }

    public static final String BIKOUMSG4_HKTSHRMEISAISINFO(int index) {
        return "'#hktshrMeisaisInfo\\\\[" + index + "\\\\]\\\\.bikoumsg4'";
    }

    public static final String SHR_SYOUSAI_S_LIST_CELL = "'.listCell'";
}
