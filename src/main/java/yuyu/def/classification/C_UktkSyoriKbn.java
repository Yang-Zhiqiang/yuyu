
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受付処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktkSyoriKbn</td><td colspan="3">受付処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;1&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITEN}</td><td>&quot;2&quot;</td><td>積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;3&quot;</td><td>目標額到達時円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINISEIKYUU}</td><td>&quot;4&quot;</td><td>任意請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKHNK}</td><td>&quot;5&quot;</td><td>目標額変更</td></tr>
 * </table>
 */
public class C_UktkSyoriKbn extends Classification<C_UktkSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UktkSyoriKbn BLNK = new C_UktkSyoriKbn("0");

    public static final C_UktkSyoriKbn KAIYAKU = new C_UktkSyoriKbn("1");

    public static final C_UktkSyoriKbn TMTTKNITEN = new C_UktkSyoriKbn("2");

    public static final C_UktkSyoriKbn MKHGKTTTYENDTHNK = new C_UktkSyoriKbn("3");

    public static final C_UktkSyoriKbn NINISEIKYUU = new C_UktkSyoriKbn("4");

    public static final C_UktkSyoriKbn MKHGKHNK = new C_UktkSyoriKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITEN, "TMTTKNITEN", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_DEFAULT, NINISEIKYUU, "NINISEIKYUU", false);
        addPattern(PATTERN_DEFAULT, MKHGKHNK, "MKHGKHNK", false);


        lock(C_UktkSyoriKbn.class);
    }

    private C_UktkSyoriKbn(String value) {
        super(value);
    }

    public static C_UktkSyoriKbn valueOf(String value) {
        return valueOf(C_UktkSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktkSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktkSyoriKbn.class, patternId, value);
    }
}
