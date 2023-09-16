
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * １次決定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ItijiketKbn</td><td colspan="3">１次決定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MND_NONE}</td><td>&quot;1&quot;</td><td>問題なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJIKET_KIBOU}</td><td>&quot;2&quot;</td><td>２次決定希望（ハンド決定）</td></tr>
 * </table>
 */
public class C_ItijiketKbn extends Classification<C_ItijiketKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ItijiketKbn MND_NONE = new C_ItijiketKbn("1");

    public static final C_ItijiketKbn NIJIKET_KIBOU = new C_ItijiketKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MND_NONE, "MND_NONE", true);
        addPattern(PATTERN_DEFAULT, NIJIKET_KIBOU, "NIJIKET_KIBOU", false);


        lock(C_ItijiketKbn.class);
    }

    private C_ItijiketKbn(String value) {
        super(value);
    }

    public static C_ItijiketKbn valueOf(String value) {
        return valueOf(C_ItijiketKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ItijiketKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ItijiketKbn.class, patternId, value);
    }
}
