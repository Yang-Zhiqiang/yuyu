
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被保険者年齢区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HhknNenKbn</td><td colspan="3">被保険者年齢区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NANAJYUUGOSAIIKA}</td><td>&quot;1&quot;</td><td>７５歳以下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NANAJYUUROKUSAIIJYOU}</td><td>&quot;2&quot;</td><td>７６歳以上</td></tr>
 * </table>
 */
public class C_HhknNenKbn extends Classification<C_HhknNenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HhknNenKbn BLNK = new C_HhknNenKbn("0");

    public static final C_HhknNenKbn NANAJYUUGOSAIIKA = new C_HhknNenKbn("1");

    public static final C_HhknNenKbn NANAJYUUROKUSAIIJYOU = new C_HhknNenKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NANAJYUUGOSAIIKA, "NANAJYUUGOSAIIKA", false);
        addPattern(PATTERN_DEFAULT, NANAJYUUROKUSAIIJYOU, "NANAJYUUROKUSAIIJYOU", false);


        lock(C_HhknNenKbn.class);
    }

    private C_HhknNenKbn(String value) {
        super(value);
    }

    public static C_HhknNenKbn valueOf(String value) {
        return valueOf(C_HhknNenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HhknNenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HhknNenKbn.class, patternId, value);
    }
}
