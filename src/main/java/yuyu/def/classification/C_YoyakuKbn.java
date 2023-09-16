
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoyakuKbn</td><td colspan="3">予約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU_YOYAKU}</td><td>&quot;1&quot;</td><td>登録予約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU_YOYAKU}</td><td>&quot;2&quot;</td><td>変更予約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO_YOYAKU}</td><td>&quot;3&quot;</td><td>削除予約</td></tr>
 * </table>
 */
public class C_YoyakuKbn extends Classification<C_YoyakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoyakuKbn BLNK = new C_YoyakuKbn("0");

    public static final C_YoyakuKbn TOUROKU_YOYAKU = new C_YoyakuKbn("1");

    public static final C_YoyakuKbn HENKOU_YOYAKU = new C_YoyakuKbn("2");

    public static final C_YoyakuKbn SAKUJYO_YOYAKU = new C_YoyakuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU_YOYAKU, "TOUROKU_YOYAKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU_YOYAKU, "HENKOU_YOYAKU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO_YOYAKU, "SAKUJYO_YOYAKU", false);


        lock(C_YoyakuKbn.class);
    }

    private C_YoyakuKbn(String value) {
        super(value);
    }

    public static C_YoyakuKbn valueOf(String value) {
        return valueOf(C_YoyakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoyakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoyakuKbn.class, patternId, value);
    }
}
