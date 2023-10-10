package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

/**
 * ＤＳメール配信予約 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class DsMailHaisinYoyakuConstants extends GenDsMailHaisinYoyakuConstants {

    public static final String BLANK = "";

    public static final String SYOUNIN_LINK = "承認";

    public static final String SAKUJYO_LINK = "削除";

    public static final String STATUS_HENKOU = "ステータス変更";

    public static final String SYOUNIN_LINK_HTML = "syounin";

    public static final String SAKUJYO_LINK_HTML = "sakujyo";

    public static final int DS_MAIL_HAISINYOYAKU_TOUROKU_GAMEN    = 40;

    public static final int DS_MAIL_HAISINYOYAKU_SYONIN_GAMEN     = 50;

    public static final int DS_MAIL_HAISINYOYAKU_SAKUJYO_GAMEN    = 60;

    public static final int MAIL_HAISINYOYAKU_SIKIBETUKEY_RENBAN_KETASU = 3;

    public static final int MIN_INT_VALUE_VALID_YOYAKUKENSAKU = 19000101;

    public static final int MAX_INT_VALUE_VALID_YOYAKUKENSAKU = 21991231;

    public static enum E_SyoriKbn {
        KENSAKU,

        TOUROKU,

        SYOUNIN,

        SAKUJYO,
    }
}
