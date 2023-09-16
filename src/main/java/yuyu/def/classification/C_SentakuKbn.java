
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SentakuKbn</td><td colspan="3">選択区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOSIKI}</td><td>&quot;1&quot;</td><td>組織指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUNIN}</td><td>&quot;2&quot;</td><td>募集人指定</td></tr>
 * </table>
 */
public class C_SentakuKbn extends Classification<C_SentakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SentakuKbn NONE = new C_SentakuKbn("0");

    public static final C_SentakuKbn SOSIKI = new C_SentakuKbn("1");

    public static final C_SentakuKbn BOSYUUNIN = new C_SentakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SOSIKI, "SOSIKI", false);
        addPattern(PATTERN_DEFAULT, BOSYUUNIN, "BOSYUUNIN", false);


        lock(C_SentakuKbn.class);
    }

    private C_SentakuKbn(String value) {
        super(value);
    }

    public static C_SentakuKbn valueOf(String value) {
        return valueOf(C_SentakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SentakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SentakuKbn.class, patternId, value);
    }
}
