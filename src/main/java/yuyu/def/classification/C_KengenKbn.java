
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 権限区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KengenKbn</td><td colspan="3">権限区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGOU}</td><td>&quot;1&quot;</td><td>総合職権限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN}</td><td>&quot;2&quot;</td><td>一般職権限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PART}</td><td>&quot;3&quot;</td><td>パート権限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOU}</td><td>&quot;4&quot;</td><td>営業職員権限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN}</td><td>&quot;5&quot;</td><td>代理店権限</td></tr>
 * </table>
 */
public class C_KengenKbn extends Classification<C_KengenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KengenKbn BLNK = new C_KengenKbn("0");

    public static final C_KengenKbn SOUGOU = new C_KengenKbn("1");

    public static final C_KengenKbn IPPAN = new C_KengenKbn("2");

    public static final C_KengenKbn PART = new C_KengenKbn("3");

    public static final C_KengenKbn EIGYOU = new C_KengenKbn("4");

    public static final C_KengenKbn DAIRITEN = new C_KengenKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOUGOU, "SOUGOU", false);
        addPattern(PATTERN_DEFAULT, IPPAN, "IPPAN", false);
        addPattern(PATTERN_DEFAULT, PART, "PART", false);
        addPattern(PATTERN_DEFAULT, EIGYOU, "EIGYOU", false);
        addPattern(PATTERN_DEFAULT, DAIRITEN, "DAIRITEN", false);


        lock(C_KengenKbn.class);
    }

    private C_KengenKbn(String value) {
        super(value);
    }

    public static C_KengenKbn valueOf(String value) {
        return valueOf(C_KengenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KengenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KengenKbn.class, patternId, value);
    }
}
