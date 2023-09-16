
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 確認状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KakuninjyoutaiKbn</td><td colspan="3">確認状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYORI}</td><td>&quot;1&quot;</td><td>未処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;2&quot;</td><td>処理済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINZUMI}</td><td>&quot;3&quot;</td><td>確認済</td></tr>
 * </table>
 */
public class C_KakuninjyoutaiKbn extends Classification<C_KakuninjyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KakuninjyoutaiKbn BLNK = new C_KakuninjyoutaiKbn("0");

    public static final C_KakuninjyoutaiKbn MISYORI = new C_KakuninjyoutaiKbn("1");

    public static final C_KakuninjyoutaiKbn SYORIZUMI = new C_KakuninjyoutaiKbn("2");

    public static final C_KakuninjyoutaiKbn KAKUNINZUMI = new C_KakuninjyoutaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", false);
        addPattern(PATTERN_DEFAULT, SYORIZUMI, "SYORIZUMI", false);
        addPattern(PATTERN_DEFAULT, KAKUNINZUMI, "KAKUNINZUMI", false);


        lock(C_KakuninjyoutaiKbn.class);
    }

    private C_KakuninjyoutaiKbn(String value) {
        super(value);
    }

    public static C_KakuninjyoutaiKbn valueOf(String value) {
        return valueOf(C_KakuninjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KakuninjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KakuninjyoutaiKbn.class, patternId, value);
    }
}
