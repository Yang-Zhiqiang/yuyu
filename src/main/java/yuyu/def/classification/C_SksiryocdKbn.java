
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求資料コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SksiryocdKbn</td><td colspan="3">請求資料コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSA}</td><td>&quot;S03&quot;</td><td>医療終身保険A</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSA_FE}</td><td>&quot;S04&quot;</td><td>医療終身保険A（女性専用パック）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSB}</td><td>&quot;S05&quot;</td><td>医療終身保険B</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKIB}</td><td>&quot;S06&quot;</td><td>定期保険B</td></tr>
 * </table>
 */
public class C_SksiryocdKbn extends Classification<C_SksiryocdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SksiryocdKbn BLNK = new C_SksiryocdKbn("0");

    public static final C_SksiryocdKbn IRSSA = new C_SksiryocdKbn("S03");

    public static final C_SksiryocdKbn IRSSA_FE = new C_SksiryocdKbn("S04");

    public static final C_SksiryocdKbn IRSSB = new C_SksiryocdKbn("S05");

    public static final C_SksiryocdKbn TEIKIB = new C_SksiryocdKbn("S06");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IRSSA, "IRSSA", false);
        addPattern(PATTERN_DEFAULT, IRSSA_FE, "IRSSA_FE", false);
        addPattern(PATTERN_DEFAULT, IRSSB, "IRSSB", false);
        addPattern(PATTERN_DEFAULT, TEIKIB, "TEIKIB", false);


        lock(C_SksiryocdKbn.class);
    }

    private C_SksiryocdKbn(String value) {
        super(value);
    }

    public static C_SksiryocdKbn valueOf(String value) {
        return valueOf(C_SksiryocdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SksiryocdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SksiryocdKbn.class, patternId, value);
    }
}
