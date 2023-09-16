
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効性確認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukoukakujkKbn</td><td colspan="3">有効性確認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUU}</td><td>&quot;1&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;2&quot;</td><td>確認済</td></tr>
 * </table>
 */
public class C_YuukoukakujkKbn extends Classification<C_YuukoukakujkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukoukakujkKbn BLNK = new C_YuukoukakujkKbn("0");

    public static final C_YuukoukakujkKbn ANNAITYUU = new C_YuukoukakujkKbn("1");

    public static final C_YuukoukakujkKbn SUMI = new C_YuukoukakujkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAITYUU, "ANNAITYUU", false);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_YuukoukakujkKbn.class);
    }

    private C_YuukoukakujkKbn(String value) {
        super(value);
    }

    public static C_YuukoukakujkKbn valueOf(String value) {
        return valueOf(C_YuukoukakujkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukoukakujkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukoukakujkKbn.class, patternId, value);
    }
}
