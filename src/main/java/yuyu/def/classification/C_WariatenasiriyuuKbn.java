
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 割当無し理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WariatenasiriyuuKbn</td><td colspan="3">割当無し理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIATENASI}</td><td>&quot;1&quot;</td><td>割当無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINCSYOUKAI}</td><td>&quot;2&quot;</td><td>ＬＩＮＣ照会中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAITOUMATI}</td><td>&quot;3&quot;</td><td>不備作成待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNIN}</td><td>&quot;4&quot;</td><td>契約確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRHORYUHUBI}</td><td>&quot;5&quot;</td><td>成立保留不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETHORYUHUBI}</td><td>&quot;6&quot;</td><td>決定保留不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRHORYU}</td><td>&quot;7&quot;</td><td>成立保留</td></tr>
 * </table>
 */
public class C_WariatenasiriyuuKbn extends Classification<C_WariatenasiriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WariatenasiriyuuKbn BLNK = new C_WariatenasiriyuuKbn("0");

    public static final C_WariatenasiriyuuKbn WARIATENASI = new C_WariatenasiriyuuKbn("1");

    public static final C_WariatenasiriyuuKbn LINCSYOUKAI = new C_WariatenasiriyuuKbn("2");

    public static final C_WariatenasiriyuuKbn HUBIKAITOUMATI = new C_WariatenasiriyuuKbn("3");

    public static final C_WariatenasiriyuuKbn KYKKAKUNIN = new C_WariatenasiriyuuKbn("4");

    public static final C_WariatenasiriyuuKbn SRHORYUHUBI = new C_WariatenasiriyuuKbn("5");

    public static final C_WariatenasiriyuuKbn KETHORYUHUBI = new C_WariatenasiriyuuKbn("6");

    public static final C_WariatenasiriyuuKbn SRHORYU = new C_WariatenasiriyuuKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WARIATENASI, "WARIATENASI", false);
        addPattern(PATTERN_DEFAULT, LINCSYOUKAI, "LINCSYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAITOUMATI, "HUBIKAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, KYKKAKUNIN, "KYKKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, SRHORYUHUBI, "SRHORYUHUBI", false);
        addPattern(PATTERN_DEFAULT, KETHORYUHUBI, "KETHORYUHUBI", false);
        addPattern(PATTERN_DEFAULT, SRHORYU, "SRHORYU", false);


        lock(C_WariatenasiriyuuKbn.class);
    }

    private C_WariatenasiriyuuKbn(String value) {
        super(value);
    }

    public static C_WariatenasiriyuuKbn valueOf(String value) {
        return valueOf(C_WariatenasiriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WariatenasiriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WariatenasiriyuuKbn.class, patternId, value);
    }
}
