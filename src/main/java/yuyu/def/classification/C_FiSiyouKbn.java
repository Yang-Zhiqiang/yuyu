
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ファンドインデックス使用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FiSiyouKbn</td><td colspan="3">ファンドインデックス使用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TJTSI}</td><td>&quot;1&quot;</td><td>当日始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TJTMATU}</td><td>&quot;2&quot;</td><td>当日末</td></tr>
 * </table>
 */
public class C_FiSiyouKbn extends Classification<C_FiSiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FiSiyouKbn BLNK = new C_FiSiyouKbn("0");

    public static final C_FiSiyouKbn TJTSI = new C_FiSiyouKbn("1");

    public static final C_FiSiyouKbn TJTMATU = new C_FiSiyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TJTSI, "TJTSI", false);
        addPattern(PATTERN_DEFAULT, TJTMATU, "TJTMATU", false);


        lock(C_FiSiyouKbn.class);
    }

    private C_FiSiyouKbn(String value) {
        super(value);
    }

    public static C_FiSiyouKbn valueOf(String value) {
        return valueOf(C_FiSiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FiSiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FiSiyouKbn.class, patternId, value);
    }
}
