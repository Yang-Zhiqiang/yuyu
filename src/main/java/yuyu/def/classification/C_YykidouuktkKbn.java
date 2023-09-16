
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予約異動受付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YykidouuktkKbn</td><td colspan="3">予約異動受付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU}</td><td>&quot;1&quot;</td><td>対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAI}</td><td>&quot;2&quot;</td><td>対象外</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(照会画面用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #TAISYOU}</td><td>&quot;1&quot;</td><td>対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAI}</td><td>&quot;2&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_YykidouuktkKbn extends Classification<C_YykidouuktkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YykidouuktkKbn BLNK = new C_YykidouuktkKbn("0");

    public static final C_YykidouuktkKbn TAISYOU = new C_YykidouuktkKbn("1");

    public static final C_YykidouuktkKbn TAISYOUGAI = new C_YykidouuktkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", false);
        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, TAISYOU, "TAISYOU", true);
        addPattern(PATTERN_SELECT, TAISYOUGAI, "TAISYOUGAI", false);


        lock(C_YykidouuktkKbn.class);
    }

    private C_YykidouuktkKbn(String value) {
        super(value);
    }

    public static C_YykidouuktkKbn valueOf(String value) {
        return valueOf(C_YykidouuktkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YykidouuktkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YykidouuktkKbn.class, patternId, value);
    }
}
