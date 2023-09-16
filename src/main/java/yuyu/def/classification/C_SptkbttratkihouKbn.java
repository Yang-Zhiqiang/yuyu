
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * SP特別取扱方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SptkbttratkihouKbn</td><td colspan="3">SP特別取扱方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>特別取扱なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPDOUGAKU}</td><td>&quot;1&quot;</td><td>SP同額</td></tr>
 * </table>
 */
public class C_SptkbttratkihouKbn extends Classification<C_SptkbttratkihouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SptkbttratkihouKbn NONE = new C_SptkbttratkihouKbn("0");

    public static final C_SptkbttratkihouKbn SPDOUGAKU = new C_SptkbttratkihouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SPDOUGAKU, "SPDOUGAKU", false);


        lock(C_SptkbttratkihouKbn.class);
    }

    private C_SptkbttratkihouKbn(String value) {
        super(value);
    }

    public static C_SptkbttratkihouKbn valueOf(String value) {
        return valueOf(C_SptkbttratkihouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SptkbttratkihouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SptkbttratkihouKbn.class, patternId, value);
    }
}
