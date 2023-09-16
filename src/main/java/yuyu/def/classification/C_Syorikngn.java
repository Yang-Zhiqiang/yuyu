
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理権限区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syorikngn</td><td colspan="3">処理権限区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORI_KA}</td><td>&quot;1&quot;</td><td>処理可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI_ONLY}</td><td>&quot;2&quot;</td><td>照会のみ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">&nbsp;</td><td>{@link #SYORI_KA}</td><td>&quot;1&quot;</td><td>処理可能</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SYOUKAI_ONLY}</td><td>&quot;2&quot;</td><td>照会のみ</td></tr>
 * </table>
 */
public class C_Syorikngn extends Classification<C_Syorikngn> {

    private static final long serialVersionUID = 1L;


    public static final C_Syorikngn BLNK = new C_Syorikngn("0");

    public static final C_Syorikngn SYORI_KA = new C_Syorikngn("1");

    public static final C_Syorikngn SYOUKAI_ONLY = new C_Syorikngn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORI_KA, "SYORI_KA", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI_ONLY, "SYOUKAI_ONLY", false);


        addPattern(PATTERN_SYOUKAI, SYORI_KA, "SYORI_KA", false);
        addPattern(PATTERN_SYOUKAI, SYOUKAI_ONLY, "SYOUKAI_ONLY", true);


        lock(C_Syorikngn.class);
    }

    private C_Syorikngn(String value) {
        super(value);
    }

    public static C_Syorikngn valueOf(String value) {
        return valueOf(C_Syorikngn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syorikngn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syorikngn.class, patternId, value);
    }
}
