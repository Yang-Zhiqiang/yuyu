
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＮ請求区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LnSeikyuuKbn</td><td colspan="3">ＬＮ請求区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LIMITHGAKU}</td><td>&quot;1&quot;</td><td>限度保険金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEIHGAKU}</td><td>&quot;2&quot;</td><td>指定保険金額</td></tr>
 * </table>
 */
public class C_LnSeikyuuKbn extends Classification<C_LnSeikyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LnSeikyuuKbn BLNK = new C_LnSeikyuuKbn("0");

    public static final C_LnSeikyuuKbn LIMITHGAKU = new C_LnSeikyuuKbn("1");

    public static final C_LnSeikyuuKbn SITEIHGAKU = new C_LnSeikyuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, LIMITHGAKU, "LIMITHGAKU", false);
        addPattern(PATTERN_DEFAULT, SITEIHGAKU, "SITEIHGAKU", false);


        lock(C_LnSeikyuuKbn.class);
    }

    private C_LnSeikyuuKbn(String value) {
        super(value);
    }

    public static C_LnSeikyuuKbn valueOf(String value) {
        return valueOf(C_LnSeikyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LnSeikyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LnSeikyuuKbn.class, patternId, value);
    }
}
