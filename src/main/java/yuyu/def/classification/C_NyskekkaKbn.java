
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyskekkaKbn</td><td colspan="3">名寄せ結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITUKENONLY}</td><td>&quot;1&quot;</td><td>１件のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEHUMEI}</td><td>&quot;2&quot;</td><td>名寄せ不明</td></tr>
 * </table>
 */
public class C_NyskekkaKbn extends Classification<C_NyskekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyskekkaKbn ITUKENONLY = new C_NyskekkaKbn("1");

    public static final C_NyskekkaKbn NAYOSEHUMEI = new C_NyskekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITUKENONLY, "ITUKENONLY", true);
        addPattern(PATTERN_DEFAULT, NAYOSEHUMEI, "NAYOSEHUMEI", false);


        lock(C_NyskekkaKbn.class);
    }

    private C_NyskekkaKbn(String value) {
        super(value);
    }

    public static C_NyskekkaKbn valueOf(String value) {
        return valueOf(C_NyskekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyskekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyskekkaKbn.class, patternId, value);
    }
}
