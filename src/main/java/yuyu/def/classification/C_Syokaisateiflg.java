
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 初回査定フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syokaisateiflg</td><td colspan="3">初回査定フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SECOND}</td><td>&quot;0&quot;</td><td>2回目以降査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAISATEI}</td><td>&quot;1&quot;</td><td>初回査定</td></tr>
 * </table>
 */
public class C_Syokaisateiflg extends Classification<C_Syokaisateiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Syokaisateiflg SECOND = new C_Syokaisateiflg("0");

    public static final C_Syokaisateiflg SYOKAISATEI = new C_Syokaisateiflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SECOND, "SECOND", true);
        addPattern(PATTERN_DEFAULT, SYOKAISATEI, "SYOKAISATEI", false);


        lock(C_Syokaisateiflg.class);
    }

    private C_Syokaisateiflg(String value) {
        super(value);
    }

    public static C_Syokaisateiflg valueOf(String value) {
        return valueOf(C_Syokaisateiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syokaisateiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syokaisateiflg.class, patternId, value);
    }
}
