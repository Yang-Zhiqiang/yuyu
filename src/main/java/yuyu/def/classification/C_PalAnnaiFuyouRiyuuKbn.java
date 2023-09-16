
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬ案内不要理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalAnnaiFuyouRiyuuKbn</td><td colspan="3">ＰＡＬ案内不要理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUU}</td><td>&quot;1&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;2&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIMN_KRISG}</td><td>&quot;3&quot;</td><td>払満・繰下げ</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUU}</td><td>&quot;1&quot;</td><td>００：案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;2&quot;</td><td>０１：一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIMN_KRISG}</td><td>&quot;3&quot;</td><td>０２：払満・繰下げ</td></tr>
 * </table>
 */
public class C_PalAnnaiFuyouRiyuuKbn extends Classification<C_PalAnnaiFuyouRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalAnnaiFuyouRiyuuKbn BLNK = new C_PalAnnaiFuyouRiyuuKbn("0");

    public static final C_PalAnnaiFuyouRiyuuKbn ANNAITYUU = new C_PalAnnaiFuyouRiyuuKbn("1");

    public static final C_PalAnnaiFuyouRiyuuKbn ITIJI = new C_PalAnnaiFuyouRiyuuKbn("2");

    public static final C_PalAnnaiFuyouRiyuuKbn HRIMN_KRISG = new C_PalAnnaiFuyouRiyuuKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAITYUU, "ANNAITYUU", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, HRIMN_KRISG, "HRIMN_KRISG", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, ANNAITYUU, "ANNAITYUU", false);
        addPattern(PATTERN_SELECT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_SELECT, HRIMN_KRISG, "HRIMN_KRISG", false);


        lock(C_PalAnnaiFuyouRiyuuKbn.class);
    }

    private C_PalAnnaiFuyouRiyuuKbn(String value) {
        super(value);
    }

    public static C_PalAnnaiFuyouRiyuuKbn valueOf(String value) {
        return valueOf(C_PalAnnaiFuyouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalAnnaiFuyouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalAnnaiFuyouRiyuuKbn.class, patternId, value);
    }
}
