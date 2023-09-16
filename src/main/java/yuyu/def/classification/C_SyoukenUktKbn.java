
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 証券受取人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukenUktKbn</td><td colspan="3">証券受取人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;01&quot;</td><td>何もしない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;02&quot;</td><td>被保険者　様</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;03&quot;</td><td>保険契約者　様</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKU}</td><td>&quot;04&quot;</td><td>法定相続人　様</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUJIRANNOTOORI}</td><td>&quot;05&quot;</td><td>表面の表示欄のとおり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NASI}</td><td>&quot;06&quot;</td><td>指定されていません</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;07&quot;</td><td>特定名義</td></tr>
 * </table>
 */
public class C_SyoukenUktKbn extends Classification<C_SyoukenUktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukenUktKbn BLNK = new C_SyoukenUktKbn("0");

    public static final C_SyoukenUktKbn NONE = new C_SyoukenUktKbn("01");

    public static final C_SyoukenUktKbn HHKN = new C_SyoukenUktKbn("02");

    public static final C_SyoukenUktKbn KYK = new C_SyoukenUktKbn("03");

    public static final C_SyoukenUktKbn SOUZOKU = new C_SyoukenUktKbn("04");

    public static final C_SyoukenUktKbn HYOUJIRANNOTOORI = new C_SyoukenUktKbn("05");

    public static final C_SyoukenUktKbn NASI = new C_SyoukenUktKbn("06");

    public static final C_SyoukenUktKbn TOKUTEIMEIGI = new C_SyoukenUktKbn("07");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, SOUZOKU, "SOUZOKU", false);
        addPattern(PATTERN_DEFAULT, HYOUJIRANNOTOORI, "HYOUJIRANNOTOORI", false);
        addPattern(PATTERN_DEFAULT, NASI, "NASI", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        lock(C_SyoukenUktKbn.class);
    }

    private C_SyoukenUktKbn(String value) {
        super(value);
    }

    public static C_SyoukenUktKbn valueOf(String value) {
        return valueOf(C_SyoukenUktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukenUktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukenUktKbn.class, patternId, value);
    }
}
