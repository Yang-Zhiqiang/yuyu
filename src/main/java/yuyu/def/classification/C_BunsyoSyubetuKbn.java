
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 文書種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BunsyoSyubetuKbn</td><td colspan="3">文書種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIORIYAKKAN}</td><td>&quot;2&quot;</td><td>しおり・約款</td></tr>
 * </table>
 */
public class C_BunsyoSyubetuKbn extends Classification<C_BunsyoSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BunsyoSyubetuKbn BLNK = new C_BunsyoSyubetuKbn("0");

    public static final C_BunsyoSyubetuKbn SIORIYAKKAN = new C_BunsyoSyubetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIORIYAKKAN, "SIORIYAKKAN", false);


        lock(C_BunsyoSyubetuKbn.class);
    }

    private C_BunsyoSyubetuKbn(String value) {
        super(value);
    }

    public static C_BunsyoSyubetuKbn valueOf(String value) {
        return valueOf(C_BunsyoSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BunsyoSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BunsyoSyubetuKbn.class, patternId, value);
    }
}
