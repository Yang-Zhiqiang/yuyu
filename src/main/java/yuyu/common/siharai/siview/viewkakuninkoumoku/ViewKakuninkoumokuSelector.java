package yuyu.common.siharai.siview.viewkakuninkoumoku;

/**
 * 保険金給付金支払 支払画面部品 確認項目 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 */
public class ViewKakuninkoumokuSelector {


    public static final String VIEWKAKUNINKOUMOKUINFO = "'#viewKakuninkoumokuInfo'";

    public static final String DISPSYORIYMD_VIEWKAKUNINKOUMOKUINFO(int index) {
        return "'#viewKakuninkoumokuInfo\\\\[" + index + "\\\\]\\\\.dispsyoriymd'";
    }

    public static final String DISPTASKNM_VIEWKAKUNINKOUMOKUINFO(int index) {
        return "'#viewKakuninkoumokuInfo\\\\[" + index + "\\\\]\\\\.disptasknm'";
    }

    public static final String DISPSYORIKEKKAKBN_VIEWKAKUNINKOUMOKUINFO(int index) {
        return "'#viewKakuninkoumokuInfo\\\\[" + index + "\\\\]\\\\.dispsyorikekkakbn'";
    }

    public static final String DISPSOUSASYANM_VIEWKAKUNINKOUMOKUINFO(int index) {
        return "'#viewKakuninkoumokuInfo\\\\[" + index + "\\\\]\\\\.dispsousasyanm'";
    }

    public static final String DISPCOMMENT_VIEWKAKUNINKOUMOKUINFO(int index) {
        return "'#viewKakuninkoumokuInfo\\\\[" + index + "\\\\]\\\\.dispcomment'";
    }
}
