
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidouJtKbn</td><td colspan="3">資金移動状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINIDOUMIRYOU}</td><td>&quot;1&quot;</td><td>資金移動未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINIDOUKANRYOU}</td><td>&quot;2&quot;</td><td>資金移動完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINIDOUTORIKESI}</td><td>&quot;3&quot;</td><td>資金移動取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINIDOUTORIKESIKANRYOU}</td><td>&quot;4&quot;</td><td>資金移動取消完了</td></tr>
 * </table>
 */
public class C_SikinidouJtKbn extends Classification<C_SikinidouJtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidouJtKbn BLNK = new C_SikinidouJtKbn("0");

    public static final C_SikinidouJtKbn SIKINIDOUMIRYOU = new C_SikinidouJtKbn("1");

    public static final C_SikinidouJtKbn SIKINIDOUKANRYOU = new C_SikinidouJtKbn("2");

    public static final C_SikinidouJtKbn SIKINIDOUTORIKESI = new C_SikinidouJtKbn("3");

    public static final C_SikinidouJtKbn SIKINIDOUTORIKESIKANRYOU = new C_SikinidouJtKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIKINIDOUMIRYOU, "SIKINIDOUMIRYOU", false);
        addPattern(PATTERN_DEFAULT, SIKINIDOUKANRYOU, "SIKINIDOUKANRYOU", false);
        addPattern(PATTERN_DEFAULT, SIKINIDOUTORIKESI, "SIKINIDOUTORIKESI", false);
        addPattern(PATTERN_DEFAULT, SIKINIDOUTORIKESIKANRYOU, "SIKINIDOUTORIKESIKANRYOU", false);


        lock(C_SikinidouJtKbn.class);
    }

    private C_SikinidouJtKbn(String value) {
        super(value);
    }

    public static C_SikinidouJtKbn valueOf(String value) {
        return valueOf(C_SikinidouJtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidouJtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidouJtKbn.class, patternId, value);
    }
}
