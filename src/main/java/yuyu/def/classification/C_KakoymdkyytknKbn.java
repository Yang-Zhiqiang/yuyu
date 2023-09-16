
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 過去日付許容特認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KakoymdkyytknKbn</td><td colspan="3">過去日付許容特認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 * </table>
 */
public class C_KakoymdkyytknKbn extends Classification<C_KakoymdkyytknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KakoymdkyytknKbn NONE = new C_KakoymdkyytknKbn("0");

    public static final C_KakoymdkyytknKbn ARI = new C_KakoymdkyytknKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_KakoymdkyytknKbn.class);
    }

    private C_KakoymdkyytknKbn(String value) {
        super(value);
    }

    public static C_KakoymdkyytknKbn valueOf(String value) {
        return valueOf(C_KakoymdkyytknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KakoymdkyytknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KakoymdkyytknKbn.class, patternId, value);
    }
}
