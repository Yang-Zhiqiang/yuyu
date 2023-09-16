
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 収入Ｐマイナスデータ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SnpminusdataKbn</td><td colspan="3">収入Ｐマイナスデータ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #PLUS}</td><td>&quot;0&quot;</td><td>プラス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINUS}</td><td>&quot;1&quot;</td><td>マイナス</td></tr>
 * </table>
 */
public class C_SnpminusdataKbn extends Classification<C_SnpminusdataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SnpminusdataKbn PLUS = new C_SnpminusdataKbn("0");

    public static final C_SnpminusdataKbn MINUS = new C_SnpminusdataKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, PLUS, "PLUS", true);
        addPattern(PATTERN_DEFAULT, MINUS, "MINUS", false);


        lock(C_SnpminusdataKbn.class);
    }

    private C_SnpminusdataKbn(String value) {
        super(value);
    }

    public static C_SnpminusdataKbn valueOf(String value) {
        return valueOf(C_SnpminusdataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SnpminusdataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SnpminusdataKbn.class, patternId, value);
    }
}
