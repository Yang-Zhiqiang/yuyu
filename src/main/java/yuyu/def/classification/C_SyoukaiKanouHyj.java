
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 照会可能表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukaiKanouHyj</td><td colspan="3">照会可能表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIKANOU}</td><td>&quot;1&quot;</td><td>照会可能</td></tr>
 * </table>
 */
public class C_SyoukaiKanouHyj extends Classification<C_SyoukaiKanouHyj> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukaiKanouHyj BLNK = new C_SyoukaiKanouHyj("0");

    public static final C_SyoukaiKanouHyj SYOUKAIKANOU = new C_SyoukaiKanouHyj("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKAIKANOU, "SYOUKAIKANOU", false);


        lock(C_SyoukaiKanouHyj.class);
    }

    private C_SyoukaiKanouHyj(String value) {
        super(value);
    }

    public static C_SyoukaiKanouHyj valueOf(String value) {
        return valueOf(C_SyoukaiKanouHyj.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukaiKanouHyj.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukaiKanouHyj.class, patternId, value);
    }
}
