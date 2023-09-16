
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 勧奨完了区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KanskanryouKbn</td><td colspan="3">勧奨完了区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANSKANRYOU}</td><td>&quot;1&quot;</td><td>勧奨完了</td></tr>
 * </table>
 */
public class C_KanskanryouKbn extends Classification<C_KanskanryouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KanskanryouKbn BLNK = new C_KanskanryouKbn("0");

    public static final C_KanskanryouKbn KANSKANRYOU = new C_KanskanryouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANSKANRYOU, "KANSKANRYOU", false);


        lock(C_KanskanryouKbn.class);
    }

    private C_KanskanryouKbn(String value) {
        super(value);
    }

    public static C_KanskanryouKbn valueOf(String value) {
        return valueOf(C_KanskanryouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KanskanryouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KanskanryouKbn.class, patternId, value);
    }
}
