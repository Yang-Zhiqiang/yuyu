
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 告知扱チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KktatkichkkekkaKbn</td><td colspan="3">告知扱チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTJGSOV}</td><td>&quot;1&quot;</td><td>告知上限Ｓオーバー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKHKSGERR}</td><td>&quot;2&quot;</td><td>特約付加制限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTTSSOV}</td><td>&quot;3&quot;</td><td>告知通算Ｓオーバー</td></tr>
 * </table>
 */
public class C_KktatkichkkekkaKbn extends Classification<C_KktatkichkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KktatkichkkekkaKbn NONE = new C_KktatkichkkekkaKbn("0");

    public static final C_KktatkichkkekkaKbn KKTJGSOV = new C_KktatkichkkekkaKbn("1");

    public static final C_KktatkichkkekkaKbn TKHKSGERR = new C_KktatkichkkekkaKbn("2");

    public static final C_KktatkichkkekkaKbn KKTTSSOV = new C_KktatkichkkekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KKTJGSOV, "KKTJGSOV", false);
        addPattern(PATTERN_DEFAULT, TKHKSGERR, "TKHKSGERR", false);
        addPattern(PATTERN_DEFAULT, KKTTSSOV, "KKTTSSOV", false);


        lock(C_KktatkichkkekkaKbn.class);
    }

    private C_KktatkichkkekkaKbn(String value) {
        super(value);
    }

    public static C_KktatkichkkekkaKbn valueOf(String value) {
        return valueOf(C_KktatkichkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KktatkichkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KktatkichkkekkaKbn.class, patternId, value);
    }
}
