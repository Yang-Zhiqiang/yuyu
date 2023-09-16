
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * レート適用目的 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Ratetekimktk</td><td colspan="3">レート適用目的</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NSYKN}</td><td>&quot;1&quot;</td><td>実入出金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEIMU_IPPAN}</td><td>&quot;2&quot;</td><td>税務一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEIMU_SOUZOKU}</td><td>&quot;3&quot;</td><td>税務（相続税）</td></tr>
 * </table>
 */
public class C_Ratetekimktk extends Classification<C_Ratetekimktk> {

    private static final long serialVersionUID = 1L;


    public static final C_Ratetekimktk BLNK = new C_Ratetekimktk("0");

    public static final C_Ratetekimktk NSYKN = new C_Ratetekimktk("1");

    public static final C_Ratetekimktk ZEIMU_IPPAN = new C_Ratetekimktk("2");

    public static final C_Ratetekimktk ZEIMU_SOUZOKU = new C_Ratetekimktk("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NSYKN, "NSYKN", false);
        addPattern(PATTERN_DEFAULT, ZEIMU_IPPAN, "ZEIMU_IPPAN", false);
        addPattern(PATTERN_DEFAULT, ZEIMU_SOUZOKU, "ZEIMU_SOUZOKU", false);


        lock(C_Ratetekimktk.class);
    }

    private C_Ratetekimktk(String value) {
        super(value);
    }

    public static C_Ratetekimktk valueOf(String value) {
        return valueOf(C_Ratetekimktk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Ratetekimktk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Ratetekimktk.class, patternId, value);
    }
}
