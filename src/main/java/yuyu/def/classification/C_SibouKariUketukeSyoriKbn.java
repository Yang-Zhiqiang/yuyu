
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡仮受付処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SibouKariUketukeSyoriKbn</td><td colspan="3">死亡仮受付処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;2&quot;</td><td>取消</td></tr>
 * </table>
 */
public class C_SibouKariUketukeSyoriKbn extends Classification<C_SibouKariUketukeSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SibouKariUketukeSyoriKbn TOUROKU = new C_SibouKariUketukeSyoriKbn("1");

    public static final C_SibouKariUketukeSyoriKbn TORIKESI = new C_SibouKariUketukeSyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", true);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);


        lock(C_SibouKariUketukeSyoriKbn.class);
    }

    private C_SibouKariUketukeSyoriKbn(String value) {
        super(value);
    }

    public static C_SibouKariUketukeSyoriKbn valueOf(String value) {
        return valueOf(C_SibouKariUketukeSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SibouKariUketukeSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SibouKariUketukeSyoriKbn.class, patternId, value);
    }
}
