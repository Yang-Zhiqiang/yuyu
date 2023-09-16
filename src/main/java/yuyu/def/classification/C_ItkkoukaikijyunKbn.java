
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 委託更改基準区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ItkkoukaikijyunKbn</td><td colspan="3">委託更改基準区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKJYN1}</td><td>&quot;1&quot;</td><td>委託基準１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKJYN2}</td><td>&quot;2&quot;</td><td>委託基準２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKJYN3}</td><td>&quot;3&quot;</td><td>委託基準３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKJYN4}</td><td>&quot;4&quot;</td><td>委託基準４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKJYN5}</td><td>&quot;5&quot;</td><td>委託基準５</td></tr>
 * </table>
 */
public class C_ItkkoukaikijyunKbn extends Classification<C_ItkkoukaikijyunKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ItkkoukaikijyunKbn BLNK = new C_ItkkoukaikijyunKbn("0");

    public static final C_ItkkoukaikijyunKbn ITKJYN1 = new C_ItkkoukaikijyunKbn("1");

    public static final C_ItkkoukaikijyunKbn ITKJYN2 = new C_ItkkoukaikijyunKbn("2");

    public static final C_ItkkoukaikijyunKbn ITKJYN3 = new C_ItkkoukaikijyunKbn("3");

    public static final C_ItkkoukaikijyunKbn ITKJYN4 = new C_ItkkoukaikijyunKbn("4");

    public static final C_ItkkoukaikijyunKbn ITKJYN5 = new C_ItkkoukaikijyunKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITKJYN1, "ITKJYN1", false);
        addPattern(PATTERN_DEFAULT, ITKJYN2, "ITKJYN2", false);
        addPattern(PATTERN_DEFAULT, ITKJYN3, "ITKJYN3", false);
        addPattern(PATTERN_DEFAULT, ITKJYN4, "ITKJYN4", false);
        addPattern(PATTERN_DEFAULT, ITKJYN5, "ITKJYN5", false);


        lock(C_ItkkoukaikijyunKbn.class);
    }

    private C_ItkkoukaikijyunKbn(String value) {
        super(value);
    }

    public static C_ItkkoukaikijyunKbn valueOf(String value) {
        return valueOf(C_ItkkoukaikijyunKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ItkkoukaikijyunKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ItkkoukaikijyunKbn.class, patternId, value);
    }
}
