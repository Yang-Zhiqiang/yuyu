
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通算種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsnsyuruiKbn</td><td colspan="3">通算種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSDKHG}</td><td>&quot;1&quot;</td><td>がん診断給付金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYYKTRYKHG}</td><td>&quot;2&quot;</td><td>腫瘍用薬治療給付月額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONKHG}</td><td>&quot;3&quot;</td><td>基本給付金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNTIKKT}</td><td>&quot;4&quot;</td><td>限定告知</td></tr>
 * </table>
 */
public class C_TsnsyuruiKbn extends Classification<C_TsnsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsnsyuruiKbn BLNK = new C_TsnsyuruiKbn("0");

    public static final C_TsnsyuruiKbn GANSDKHG = new C_TsnsyuruiKbn("1");

    public static final C_TsnsyuruiKbn SYYKTRYKHG = new C_TsnsyuruiKbn("2");

    public static final C_TsnsyuruiKbn KIHONKHG = new C_TsnsyuruiKbn("3");

    public static final C_TsnsyuruiKbn GNTIKKT = new C_TsnsyuruiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GANSDKHG, "GANSDKHG", false);
        addPattern(PATTERN_DEFAULT, SYYKTRYKHG, "SYYKTRYKHG", false);
        addPattern(PATTERN_DEFAULT, KIHONKHG, "KIHONKHG", false);
        addPattern(PATTERN_DEFAULT, GNTIKKT, "GNTIKKT", false);


        lock(C_TsnsyuruiKbn.class);
    }

    private C_TsnsyuruiKbn(String value) {
        super(value);
    }

    public static C_TsnsyuruiKbn valueOf(String value) {
        return valueOf(C_TsnsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsnsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsnsyuruiKbn.class, patternId, value);
    }
}
