
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * １ＰＣＬ利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_1pclriyouKbn</td><td colspan="3">１ＰＣＬ利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOU}</td><td>&quot;1&quot;</td><td>利用する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>利用しない</td></tr>
 * </table>
 */
public class C_1pclriyouKbn extends Classification<C_1pclriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_1pclriyouKbn BLNK = new C_1pclriyouKbn("0");

    public static final C_1pclriyouKbn RIYOU = new C_1pclriyouKbn("1");

    public static final C_1pclriyouKbn NONE = new C_1pclriyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RIYOU, "RIYOU", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_1pclriyouKbn.class);
    }

    private C_1pclriyouKbn(String value) {
        super(value);
    }

    public static C_1pclriyouKbn valueOf(String value) {
        return valueOf(C_1pclriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_1pclriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_1pclriyouKbn.class, patternId, value);
    }
}
