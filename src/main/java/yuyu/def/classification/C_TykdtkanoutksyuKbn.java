
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 着脱可能特約種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TykdtkanoutksyuKbn</td><td colspan="3">着脱可能特約種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKATUSYUUKANBYOU}</td><td>&quot;1&quot;</td><td>生活習慣病特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDAN}</td><td>&quot;2&quot;</td><td>女性疾病特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSINIRYOU}</td><td>&quot;3&quot;</td><td>先進医療特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOSEISIPPEI}</td><td>&quot;4&quot;</td><td>女性疾病特約</td></tr>
 * </table>
 */
public class C_TykdtkanoutksyuKbn extends Classification<C_TykdtkanoutksyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TykdtkanoutksyuKbn BLNK = new C_TykdtkanoutksyuKbn("0");

    public static final C_TykdtkanoutksyuKbn SEIKATUSYUUKANBYOU = new C_TykdtkanoutksyuKbn("1");

    public static final C_TykdtkanoutksyuKbn GANSINDAN = new C_TykdtkanoutksyuKbn("2");

    public static final C_TykdtkanoutksyuKbn SENSINIRYOU = new C_TykdtkanoutksyuKbn("3");

    public static final C_TykdtkanoutksyuKbn JYOSEISIPPEI = new C_TykdtkanoutksyuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIKATUSYUUKANBYOU, "SEIKATUSYUUKANBYOU", false);
        addPattern(PATTERN_DEFAULT, GANSINDAN, "GANSINDAN", false);
        addPattern(PATTERN_DEFAULT, SENSINIRYOU, "SENSINIRYOU", false);
        addPattern(PATTERN_DEFAULT, JYOSEISIPPEI, "JYOSEISIPPEI", false);


        lock(C_TykdtkanoutksyuKbn.class);
    }

    private C_TykdtkanoutksyuKbn(String value) {
        super(value);
    }

    public static C_TykdtkanoutksyuKbn valueOf(String value) {
        return valueOf(C_TykdtkanoutksyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TykdtkanoutksyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TykdtkanoutksyuKbn.class, patternId, value);
    }
}
