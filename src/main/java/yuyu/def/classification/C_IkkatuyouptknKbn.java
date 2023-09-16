
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 一括要Ｐ特認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IkkatuyouptknKbn</td><td colspan="3">一括要Ｐ特認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOURYAKU}</td><td>&quot;1&quot;</td><td>一括要Ｐ省略</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEITYOU}</td><td>&quot;2&quot;</td><td>一括要Ｐ併徴</td></tr>
 * </table>
 */
public class C_IkkatuyouptknKbn extends Classification<C_IkkatuyouptknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IkkatuyouptknKbn NONE = new C_IkkatuyouptknKbn("0");

    public static final C_IkkatuyouptknKbn SYOURYAKU = new C_IkkatuyouptknKbn("1");

    public static final C_IkkatuyouptknKbn HEITYOU = new C_IkkatuyouptknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SYOURYAKU, "SYOURYAKU", false);
        addPattern(PATTERN_DEFAULT, HEITYOU, "HEITYOU", false);


        lock(C_IkkatuyouptknKbn.class);
    }

    private C_IkkatuyouptknKbn(String value) {
        super(value);
    }

    public static C_IkkatuyouptknKbn valueOf(String value) {
        return valueOf(C_IkkatuyouptknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IkkatuyouptknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IkkatuyouptknKbn.class, patternId, value);
    }
}
