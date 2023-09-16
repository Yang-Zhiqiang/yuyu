
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払調書保険種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrtysyhknsyuKbn</td><td colspan="3">支払調書保険種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOU}</td><td>&quot;1&quot;</td><td>医療保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKI}</td><td>&quot;2&quot;</td><td>定期保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUSIN}</td><td>&quot;3&quot;</td><td>終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN}</td><td>&quot;4&quot;</td><td>個人年金</td></tr>
 * </table>
 */
public class C_ShrtysyhknsyuKbn extends Classification<C_ShrtysyhknsyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrtysyhknsyuKbn BLNK = new C_ShrtysyhknsyuKbn("0");

    public static final C_ShrtysyhknsyuKbn IRYOU = new C_ShrtysyhknsyuKbn("1");

    public static final C_ShrtysyhknsyuKbn TEIKI = new C_ShrtysyhknsyuKbn("2");

    public static final C_ShrtysyhknsyuKbn SYUUSIN = new C_ShrtysyhknsyuKbn("3");

    public static final C_ShrtysyhknsyuKbn KOJINNENKIN = new C_ShrtysyhknsyuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IRYOU, "IRYOU", false);
        addPattern(PATTERN_DEFAULT, TEIKI, "TEIKI", false);
        addPattern(PATTERN_DEFAULT, SYUUSIN, "SYUUSIN", false);
        addPattern(PATTERN_DEFAULT, KOJINNENKIN, "KOJINNENKIN", false);


        lock(C_ShrtysyhknsyuKbn.class);
    }

    private C_ShrtysyhknsyuKbn(String value) {
        super(value);
    }

    public static C_ShrtysyhknsyuKbn valueOf(String value) {
        return valueOf(C_ShrtysyhknsyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrtysyhknsyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrtysyhknsyuKbn.class, patternId, value);
    }
}
