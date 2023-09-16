
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＥＯＩ処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AeoiSyoriKbn</td><td colspan="3">ＡＥＯＩ処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKU}</td><td>&quot;01&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;02&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_AeoiSyoriKbn extends Classification<C_AeoiSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AeoiSyoriKbn BLNK = new C_AeoiSyoriKbn("0");

    public static final C_AeoiSyoriKbn SINKEIYAKU = new C_AeoiSyoriKbn("01");

    public static final C_AeoiSyoriKbn MEIGIHENKOU = new C_AeoiSyoriKbn("02");

    public static final C_AeoiSyoriKbn SONOTA = new C_AeoiSyoriKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKU, "SINKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_AeoiSyoriKbn.class);
    }

    private C_AeoiSyoriKbn(String value) {
        super(value);
    }

    public static C_AeoiSyoriKbn valueOf(String value) {
        return valueOf(C_AeoiSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AeoiSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AeoiSyoriKbn.class, patternId, value);
    }
}
