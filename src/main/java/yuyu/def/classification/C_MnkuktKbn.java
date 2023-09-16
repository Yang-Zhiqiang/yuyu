
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 満期受取人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MnkuktKbn</td><td colspan="3">満期受取人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNK_OR_HUKUSUU}</td><td>&quot;1&quot;</td><td>その他関係者または複数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;2&quot;</td><td>契約者のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;3&quot;</td><td>被保険者のみ</td></tr>
 * </table>
 */
public class C_MnkuktKbn extends Classification<C_MnkuktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MnkuktKbn BLNK = new C_MnkuktKbn("0");

    public static final C_MnkuktKbn KNK_OR_HUKUSUU = new C_MnkuktKbn("1");

    public static final C_MnkuktKbn KYK = new C_MnkuktKbn("2");

    public static final C_MnkuktKbn HHKN = new C_MnkuktKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KNK_OR_HUKUSUU, "KNK_OR_HUKUSUU", false);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);


        lock(C_MnkuktKbn.class);
    }

    private C_MnkuktKbn(String value) {
        super(value);
    }

    public static C_MnkuktKbn valueOf(String value) {
        return valueOf(C_MnkuktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MnkuktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MnkuktKbn.class, patternId, value);
    }
}
