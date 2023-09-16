
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ顧客状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKokyakuJtKbn</td><td colspan="3">ＤＳ顧客状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効取引中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI_TEISI}</td><td>&quot;2&quot;</td><td>一時停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;3&quot;</td><td>ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISA_SYOUMETU}</td><td>&quot;4&quot;</td><td>精査による消滅</td></tr>
 * </table>
 */
public class C_DsKokyakuJtKbn extends Classification<C_DsKokyakuJtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKokyakuJtKbn BLANK = new C_DsKokyakuJtKbn("0");

    public static final C_DsKokyakuJtKbn YUUKOU = new C_DsKokyakuJtKbn("1");

    public static final C_DsKokyakuJtKbn ITIJI_TEISI = new C_DsKokyakuJtKbn("2");

    public static final C_DsKokyakuJtKbn KAIYAKU = new C_DsKokyakuJtKbn("3");

    public static final C_DsKokyakuJtKbn SEISA_SYOUMETU = new C_DsKokyakuJtKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, ITIJI_TEISI, "ITIJI_TEISI", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SEISA_SYOUMETU, "SEISA_SYOUMETU", false);


        lock(C_DsKokyakuJtKbn.class);
    }

    private C_DsKokyakuJtKbn(String value) {
        super(value);
    }

    public static C_DsKokyakuJtKbn valueOf(String value) {
        return valueOf(C_DsKokyakuJtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKokyakuJtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKokyakuJtKbn.class, patternId, value);
    }
}
