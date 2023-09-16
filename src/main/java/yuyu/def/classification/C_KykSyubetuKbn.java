
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykSyubetuKbn</td><td colspan="3">契約種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJIN}</td><td>&quot;2&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUHOUJIN}</td><td>&quot;3&quot;</td><td>別法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU}</td><td>&quot;4&quot;</td><td>対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAI}</td><td>&quot;5&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_KykSyubetuKbn extends Classification<C_KykSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykSyubetuKbn BLNK = new C_KykSyubetuKbn("0");

    public static final C_KykSyubetuKbn KOJIN = new C_KykSyubetuKbn("1");

    public static final C_KykSyubetuKbn HOUJIN = new C_KykSyubetuKbn("2");

    public static final C_KykSyubetuKbn BETUHOUJIN = new C_KykSyubetuKbn("3");

    public static final C_KykSyubetuKbn TAISYOU = new C_KykSyubetuKbn("4");

    public static final C_KykSyubetuKbn TAISYOUGAI = new C_KykSyubetuKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", false);
        addPattern(PATTERN_DEFAULT, HOUJIN, "HOUJIN", false);
        addPattern(PATTERN_DEFAULT, BETUHOUJIN, "BETUHOUJIN", false);
        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", false);
        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", false);


        lock(C_KykSyubetuKbn.class);
    }

    private C_KykSyubetuKbn(String value) {
        super(value);
    }

    public static C_KykSyubetuKbn valueOf(String value) {
        return valueOf(C_KykSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykSyubetuKbn.class, patternId, value);
    }
}
