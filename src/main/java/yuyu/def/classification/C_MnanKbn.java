
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 満了案内区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MnanKbn</td><td colspan="3">満了案内区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUU}</td><td>&quot;1&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAIMISAKUSEI}</td><td>&quot;2&quot;</td><td>案内未作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUUZUMI}</td><td>&quot;3&quot;</td><td>請求済</td></tr>
 * </table>
 */
public class C_MnanKbn extends Classification<C_MnanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MnanKbn BLNK = new C_MnanKbn("0");

    public static final C_MnanKbn ANNAITYUU = new C_MnanKbn("1");

    public static final C_MnanKbn ANNAIMISAKUSEI = new C_MnanKbn("2");

    public static final C_MnanKbn SEIKYUUZUMI = new C_MnanKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAITYUU, "ANNAITYUU", false);
        addPattern(PATTERN_DEFAULT, ANNAIMISAKUSEI, "ANNAIMISAKUSEI", false);
        addPattern(PATTERN_DEFAULT, SEIKYUUZUMI, "SEIKYUUZUMI", false);


        lock(C_MnanKbn.class);
    }

    private C_MnanKbn(String value) {
        super(value);
    }

    public static C_MnanKbn valueOf(String value) {
        return valueOf(C_MnanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MnanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MnanKbn.class, patternId, value);
    }
}
