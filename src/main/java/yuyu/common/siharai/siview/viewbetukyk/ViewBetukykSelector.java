package yuyu.common.siharai.siview.viewbetukyk;

/**
 * 保険金給付金支払 支払画面部品 別契約情報表示 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 */
public class ViewBetukykSelector {


    public static final String BETUKYKINFO = "'#betukykInfo'";

    public static final String BTKYKSYONO_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.btkyksyono'";
    }

    public static final String SYSCDKBN_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.syscdkbn'";
    }

    public static final String BETUKUTIKEIYAKUKBN_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.betukutikeiyakukbn'";
    }

    public static final String KANKEISYAKBNNAME_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.kankeisyakbnname'";
    }

    public static final String SYOUMETUYMD_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.syoumetuymd'";
    }

    public static final String SYOUMETUJIYUUNAME_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.syoumetujiyuuname'";
    }

    public static final String SYOUHNNM_BETUKYKINFO(int index) {
        return "'#betukykInfo\\\\[" + index + "\\\\]\\\\.syouhnnm'";
    }
}
