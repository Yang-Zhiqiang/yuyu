
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 勘定種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KanjyousyuKbn</td><td colspan="3">勘定種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NK}</td><td>&quot;1&quot;</td><td>年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIENRSK}</td><td>&quot;2&quot;</td><td>遅延利息</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSY}</td><td>&quot;3&quot;</td><td>源泉徴収</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKTKJ}</td><td>&quot;4&quot;</td><td>一括支払控除額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SJKKKTYS}</td><td>&quot;5&quot;</td><td>市場価格調整額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MBR}</td><td>&quot;6&quot;</td><td>未払金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJ}</td><td>&quot;7&quot;</td><td>一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKUK_IKTSHR}</td><td>&quot;8&quot;</td><td>特勘受入（一括支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKUK_IKTKJ}</td><td>&quot;9&quot;</td><td>特勘受入（一括支払控除）</td></tr>
 * </table>
 */
public class C_KanjyousyuKbn extends Classification<C_KanjyousyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KanjyousyuKbn NK = new C_KanjyousyuKbn("1");

    public static final C_KanjyousyuKbn TIENRSK = new C_KanjyousyuKbn("2");

    public static final C_KanjyousyuKbn GSTYSY = new C_KanjyousyuKbn("3");

    public static final C_KanjyousyuKbn IKTKJ = new C_KanjyousyuKbn("4");

    public static final C_KanjyousyuKbn SJKKKTYS = new C_KanjyousyuKbn("5");

    public static final C_KanjyousyuKbn MBR = new C_KanjyousyuKbn("6");

    public static final C_KanjyousyuKbn ITJ = new C_KanjyousyuKbn("7");

    public static final C_KanjyousyuKbn TKUK_IKTSHR = new C_KanjyousyuKbn("8");

    public static final C_KanjyousyuKbn TKUK_IKTKJ = new C_KanjyousyuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NK, "NK", true);
        addPattern(PATTERN_DEFAULT, TIENRSK, "TIENRSK", false);
        addPattern(PATTERN_DEFAULT, GSTYSY, "GSTYSY", false);
        addPattern(PATTERN_DEFAULT, IKTKJ, "IKTKJ", false);
        addPattern(PATTERN_DEFAULT, SJKKKTYS, "SJKKKTYS", false);
        addPattern(PATTERN_DEFAULT, MBR, "MBR", false);
        addPattern(PATTERN_DEFAULT, ITJ, "ITJ", false);
        addPattern(PATTERN_DEFAULT, TKUK_IKTSHR, "TKUK_IKTSHR", false);
        addPattern(PATTERN_DEFAULT, TKUK_IKTKJ, "TKUK_IKTKJ", false);


        lock(C_KanjyousyuKbn.class);
    }

    private C_KanjyousyuKbn(String value) {
        super(value);
    }

    public static C_KanjyousyuKbn valueOf(String value) {
        return valueOf(C_KanjyousyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KanjyousyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KanjyousyuKbn.class, patternId, value);
    }
}
