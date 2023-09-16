
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennouSyoriKbn</td><td colspan="3">前納処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_NYUUKIN}</td><td>&quot;1&quot;</td><td>前納入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_TYUUSI}</td><td>&quot;2&quot;</td><td>前納中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_SEISAN}</td><td>&quot;3&quot;</td><td>前納精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_MANRYOU}</td><td>&quot;4&quot;</td><td>前納満了</td></tr>
 * </table>
 */
public class C_ZennouSyoriKbn extends Classification<C_ZennouSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennouSyoriKbn BLNK = new C_ZennouSyoriKbn("0");

    public static final C_ZennouSyoriKbn ZENNOU_NYUUKIN = new C_ZennouSyoriKbn("1");

    public static final C_ZennouSyoriKbn ZENNOU_TYUUSI = new C_ZennouSyoriKbn("2");

    public static final C_ZennouSyoriKbn ZENNOU_SEISAN = new C_ZennouSyoriKbn("3");

    public static final C_ZennouSyoriKbn ZENNOU_MANRYOU = new C_ZennouSyoriKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENNOU_NYUUKIN, "ZENNOU_NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, ZENNOU_TYUUSI, "ZENNOU_TYUUSI", false);
        addPattern(PATTERN_DEFAULT, ZENNOU_SEISAN, "ZENNOU_SEISAN", false);
        addPattern(PATTERN_DEFAULT, ZENNOU_MANRYOU, "ZENNOU_MANRYOU", false);


        lock(C_ZennouSyoriKbn.class);
    }

    private C_ZennouSyoriKbn(String value) {
        super(value);
    }

    public static C_ZennouSyoriKbn valueOf(String value) {
        return valueOf(C_ZennouSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennouSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennouSyoriKbn.class, patternId, value);
    }
}
