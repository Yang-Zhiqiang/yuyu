
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 削除フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Delflag</td><td colspan="3">削除フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;1&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_Delflag extends Classification<C_Delflag> {

    private static final long serialVersionUID = 1L;


    public static final C_Delflag BLNK = new C_Delflag("0");

    public static final C_Delflag SAKUJYO = new C_Delflag("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_Delflag.class);
    }

    private C_Delflag(String value) {
        super(value);
    }

    public static C_Delflag valueOf(String value) {
        return valueOf(C_Delflag.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Delflag.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Delflag.class, patternId, value);
    }
}
