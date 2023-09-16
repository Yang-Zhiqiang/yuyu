
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新設変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsetuhenkouKbn</td><td colspan="3">新設変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SINSETU}</td><td>&quot;1&quot;</td><td>新設</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;3&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_SinsetuhenkouKbn extends Classification<C_SinsetuhenkouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsetuhenkouKbn SINSETU = new C_SinsetuhenkouKbn("1");

    public static final C_SinsetuhenkouKbn HENKOU = new C_SinsetuhenkouKbn("2");

    public static final C_SinsetuhenkouKbn SYOUMETU = new C_SinsetuhenkouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SINSETU, "SINSETU", true);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_SinsetuhenkouKbn.class);
    }

    private C_SinsetuhenkouKbn(String value) {
        super(value);
    }

    public static C_SinsetuhenkouKbn valueOf(String value) {
        return valueOf(C_SinsetuhenkouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsetuhenkouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsetuhenkouKbn.class, patternId, value);
    }
}
