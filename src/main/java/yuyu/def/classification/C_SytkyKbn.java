
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 種別適用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SytkyKbn</td><td colspan="3">種別適用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETUTEKIYOU}</td><td>&quot;01&quot;</td><td>種別適用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIKITUDUKI}</td><td>&quot;02&quot;</td><td>引き続き</td></tr>
 * </table>
 */
public class C_SytkyKbn extends Classification<C_SytkyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SytkyKbn NONE = new C_SytkyKbn("00");

    public static final C_SytkyKbn SYUBETUTEKIYOU = new C_SytkyKbn("01");

    public static final C_SytkyKbn HIKITUDUKI = new C_SytkyKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SYUBETUTEKIYOU, "SYUBETUTEKIYOU", false);
        addPattern(PATTERN_DEFAULT, HIKITUDUKI, "HIKITUDUKI", false);


        lock(C_SytkyKbn.class);
    }

    private C_SytkyKbn(String value) {
        super(value);
    }

    public static C_SytkyKbn valueOf(String value) {
        return valueOf(C_SytkyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SytkyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SytkyKbn.class, patternId, value);
    }
}
