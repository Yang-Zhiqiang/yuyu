
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金共通処理エラー理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CommonNyuukinErrorRiyuuKbn</td><td colspan="3">入金共通処理エラー理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHUZAIERROR}</td><td>&quot;1&quot;</td><td>契約不在エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIHUNOERROR}</td><td>&quot;2&quot;</td><td>処理不能エラー</td></tr>
 * </table>
 */
public class C_CommonNyuukinErrorRiyuuKbn extends Classification<C_CommonNyuukinErrorRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CommonNyuukinErrorRiyuuKbn BLNK = new C_CommonNyuukinErrorRiyuuKbn("0");

    public static final C_CommonNyuukinErrorRiyuuKbn KYKHUZAIERROR = new C_CommonNyuukinErrorRiyuuKbn("1");

    public static final C_CommonNyuukinErrorRiyuuKbn SYORIHUNOERROR = new C_CommonNyuukinErrorRiyuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKHUZAIERROR, "KYKHUZAIERROR", false);
        addPattern(PATTERN_DEFAULT, SYORIHUNOERROR, "SYORIHUNOERROR", false);


        lock(C_CommonNyuukinErrorRiyuuKbn.class);
    }

    private C_CommonNyuukinErrorRiyuuKbn(String value) {
        super(value);
    }

    public static C_CommonNyuukinErrorRiyuuKbn valueOf(String value) {
        return valueOf(C_CommonNyuukinErrorRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CommonNyuukinErrorRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CommonNyuukinErrorRiyuuKbn.class, patternId, value);
    }
}
