
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 健保対象外（効果未承認）区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KnptsgkkmsnKbn</td><td colspan="3">健保対象外（効果未承認）区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKYHMSN}</td><td>&quot;1&quot;</td><td>効果・効能や用法・用量が未承認</td></tr>
 * </table>
 */
public class C_KnptsgkkmsnKbn extends Classification<C_KnptsgkkmsnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KnptsgkkmsnKbn BLNK = new C_KnptsgkkmsnKbn("0");

    public static final C_KnptsgkkmsnKbn KKYHMSN = new C_KnptsgkkmsnKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKYHMSN, "KKYHMSN", false);


        lock(C_KnptsgkkmsnKbn.class);
    }

    private C_KnptsgkkmsnKbn(String value) {
        super(value);
    }

    public static C_KnptsgkkmsnKbn valueOf(String value) {
        return valueOf(C_KnptsgkkmsnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KnptsgkkmsnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KnptsgkkmsnKbn.class, patternId, value);
    }
}
