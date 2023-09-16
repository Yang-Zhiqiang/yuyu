
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 精査不要表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeisaHuyouHyj</td><td colspan="3">精査不要表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISA_HUYOU}</td><td>&quot;1&quot;</td><td>精査不要</td></tr>
 * </table>
 */
public class C_SeisaHuyouHyj extends Classification<C_SeisaHuyouHyj> {

    private static final long serialVersionUID = 1L;


    public static final C_SeisaHuyouHyj BLANK = new C_SeisaHuyouHyj("0");

    public static final C_SeisaHuyouHyj SEISA_HUYOU = new C_SeisaHuyouHyj("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, SEISA_HUYOU, "SEISA_HUYOU", false);


        lock(C_SeisaHuyouHyj.class);
    }

    private C_SeisaHuyouHyj(String value) {
        super(value);
    }

    public static C_SeisaHuyouHyj valueOf(String value) {
        return valueOf(C_SeisaHuyouHyj.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeisaHuyouHyj.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeisaHuyouHyj.class, patternId, value);
    }
}
