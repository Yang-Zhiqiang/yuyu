
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 直送判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyokusouhtkekKbn</td><td colspan="3">直送判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOKUSOUTSYGAI}</td><td>&quot;1&quot;</td><td>直送対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOKUSOUTSY}</td><td>&quot;2&quot;</td><td>直送対象</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #TYOKUSOUTSYGAI}</td><td>&quot;1&quot;</td><td>直送対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOKUSOUTSY}</td><td>&quot;2&quot;</td><td>直送対象</td></tr>
 * </table>
 */
public class C_TyokusouhtkekKbn extends Classification<C_TyokusouhtkekKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyokusouhtkekKbn BLNK = new C_TyokusouhtkekKbn("0");

    public static final C_TyokusouhtkekKbn TYOKUSOUTSYGAI = new C_TyokusouhtkekKbn("1");

    public static final C_TyokusouhtkekKbn TYOKUSOUTSY = new C_TyokusouhtkekKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYOKUSOUTSYGAI, "TYOKUSOUTSYGAI", false);
        addPattern(PATTERN_DEFAULT, TYOKUSOUTSY, "TYOKUSOUTSY", false);


        addPattern(PATTERN_NOBLNK, TYOKUSOUTSYGAI, "TYOKUSOUTSYGAI", true);
        addPattern(PATTERN_NOBLNK, TYOKUSOUTSY, "TYOKUSOUTSY", false);


        lock(C_TyokusouhtkekKbn.class);
    }

    private C_TyokusouhtkekKbn(String value) {
        super(value);
    }

    public static C_TyokusouhtkekKbn valueOf(String value) {
        return valueOf(C_TyokusouhtkekKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyokusouhtkekKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyokusouhtkekKbn.class, patternId, value);
    }
}
