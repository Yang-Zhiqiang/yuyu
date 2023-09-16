
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者代理特約手続区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykdrtkykttdkKbn</td><td colspan="3">契約者代理特約手続区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUTOHUKA}</td><td>&quot;1&quot;</td><td>中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUKAIYAKU}</td><td>&quot;3&quot;</td><td>特約解約</td></tr>
 * </table>
 */
public class C_KykdrtkykttdkKbn extends Classification<C_KykdrtkykttdkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykdrtkykttdkKbn BLNK = new C_KykdrtkykttdkKbn("0");

    public static final C_KykdrtkykttdkKbn TYUUTOHUKA = new C_KykdrtkykttdkKbn("1");

    public static final C_KykdrtkykttdkKbn HENKOU = new C_KykdrtkykttdkKbn("2");

    public static final C_KykdrtkykttdkKbn TOKUYAKUKAIYAKU = new C_KykdrtkykttdkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYUUTOHUKA, "TYUUTOHUKA", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKUKAIYAKU, "TOKUYAKUKAIYAKU", false);


        lock(C_KykdrtkykttdkKbn.class);
    }

    private C_KykdrtkykttdkKbn(String value) {
        super(value);
    }

    public static C_KykdrtkykttdkKbn valueOf(String value) {
        return valueOf(C_KykdrtkykttdkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykdrtkykttdkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykdrtkykttdkKbn.class, patternId, value);
    }
}
