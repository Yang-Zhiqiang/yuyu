
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 削減支払確認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakugenshrkakKbn</td><td colspan="3">削減支払確認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINKANRYOU}</td><td>&quot;1&quot;</td><td>確認完了</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_INPUT INPUT}<br />(入力画面用)</td><td align="center">&nbsp;</td><td>{@link #KAKUNINKANRYOU}</td><td>&quot;1&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_SakugenshrkakKbn extends Classification<C_SakugenshrkakKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakugenshrkakKbn BLNK = new C_SakugenshrkakKbn("0");

    public static final C_SakugenshrkakKbn KAKUNINKANRYOU = new C_SakugenshrkakKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_INPUT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUNINKANRYOU, "KAKUNINKANRYOU", false);


        addPattern(PATTERN_INPUT, KAKUNINKANRYOU, "KAKUNINKANRYOU", false);


        lock(C_SakugenshrkakKbn.class);
    }

    private C_SakugenshrkakKbn(String value) {
        super(value);
    }

    public static C_SakugenshrkakKbn valueOf(String value) {
        return valueOf(C_SakugenshrkakKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakugenshrkakKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakugenshrkakKbn.class, patternId, value);
    }
}
