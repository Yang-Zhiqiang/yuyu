
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡受取人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SbuktKbn</td><td colspan="3">死亡受取人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNK_OR_HUKUSUU}</td><td>&quot;1&quot;</td><td>その他関係者または複数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;2&quot;</td><td>契約者のみ</td></tr>
 * </table>
 */
public class C_SbuktKbn extends Classification<C_SbuktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SbuktKbn BLNK = new C_SbuktKbn("0");

    public static final C_SbuktKbn KNK_OR_HUKUSUU = new C_SbuktKbn("1");

    public static final C_SbuktKbn KYK = new C_SbuktKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KNK_OR_HUKUSUU, "KNK_OR_HUKUSUU", false);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);


        lock(C_SbuktKbn.class);
    }

    private C_SbuktKbn(String value) {
        super(value);
    }

    public static C_SbuktKbn valueOf(String value) {
        return valueOf(C_SbuktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SbuktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SbuktKbn.class, patternId, value);
    }
}
