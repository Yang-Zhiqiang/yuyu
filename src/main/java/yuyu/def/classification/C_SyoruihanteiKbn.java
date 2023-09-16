
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 書類判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoruihanteiKbn</td><td colspan="3">書類判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSYUBETU}</td><td>&quot;1&quot;</td><td>請求種別</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;2&quot;</td><td>申出人区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENIN}</td><td>&quot;3&quot;</td><td>原因区分</td></tr>
 * </table>
 */
public class C_SyoruihanteiKbn extends Classification<C_SyoruihanteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoruihanteiKbn BLNK = new C_SyoruihanteiKbn("0");

    public static final C_SyoruihanteiKbn SKSYUBETU = new C_SyoruihanteiKbn("1");

    public static final C_SyoruihanteiKbn MOUSIDE = new C_SyoruihanteiKbn("2");

    public static final C_SyoruihanteiKbn GENIN = new C_SyoruihanteiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKSYUBETU, "SKSYUBETU", false);
        addPattern(PATTERN_DEFAULT, MOUSIDE, "MOUSIDE", false);
        addPattern(PATTERN_DEFAULT, GENIN, "GENIN", false);


        lock(C_SyoruihanteiKbn.class);
    }

    private C_SyoruihanteiKbn(String value) {
        super(value);
    }

    public static C_SyoruihanteiKbn valueOf(String value) {
        return valueOf(C_SyoruihanteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoruihanteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoruihanteiKbn.class, patternId, value);
    }
}
