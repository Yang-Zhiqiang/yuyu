
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 個別変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KbthnkKbn</td><td colspan="3">個別変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSIBOU}</td><td>&quot;1&quot;</td><td>被保険者死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTRSIBOU}</td><td>&quot;2&quot;</td><td>受取人死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKAISUUHNK}</td><td>&quot;3&quot;</td><td>支払回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI}</td><td>&quot;4&quot;</td><td>手続注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SS_SAIHAKOU}</td><td>&quot;5&quot;</td><td>年金証書再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTORIKOMI}</td><td>&quot;6&quot;</td><td>年金情報取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIJYUUSYOHNK}</td><td>&quot;8&quot;</td><td>名義住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SEIKYUSYO_SAKUSEI}</td><td>&quot;9&quot;</td><td>年金請求書作成</td></tr>
 * </table>
 */
public class C_KbthnkKbn extends Classification<C_KbthnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KbthnkKbn BLNK = new C_KbthnkKbn("0");

    public static final C_KbthnkKbn HHKNSIBOU = new C_KbthnkKbn("1");

    public static final C_KbthnkKbn UKTRSIBOU = new C_KbthnkKbn("2");

    public static final C_KbthnkKbn SHRKAISUUHNK = new C_KbthnkKbn("3");

    public static final C_KbthnkKbn TTDKTYUUI = new C_KbthnkKbn("4");

    public static final C_KbthnkKbn SS_SAIHAKOU = new C_KbthnkKbn("5");

    public static final C_KbthnkKbn NKTORIKOMI = new C_KbthnkKbn("6");

    public static final C_KbthnkKbn MEIGIJYUUSYOHNK = new C_KbthnkKbn("8");

    public static final C_KbthnkKbn NK_SEIKYUSYO_SAKUSEI = new C_KbthnkKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKNSIBOU, "HHKNSIBOU", false);
        addPattern(PATTERN_DEFAULT, UKTRSIBOU, "UKTRSIBOU", false);
        addPattern(PATTERN_DEFAULT, SHRKAISUUHNK, "SHRKAISUUHNK", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI, "TTDKTYUUI", false);
        addPattern(PATTERN_DEFAULT, SS_SAIHAKOU, "SS_SAIHAKOU", false);
        addPattern(PATTERN_DEFAULT, NKTORIKOMI, "NKTORIKOMI", false);
        addPattern(PATTERN_DEFAULT, MEIGIJYUUSYOHNK, "MEIGIJYUUSYOHNK", false);
        addPattern(PATTERN_DEFAULT, NK_SEIKYUSYO_SAKUSEI, "NK_SEIKYUSYO_SAKUSEI", false);


        lock(C_KbthnkKbn.class);
    }

    private C_KbthnkKbn(String value) {
        super(value);
    }

    public static C_KbthnkKbn valueOf(String value) {
        return valueOf(C_KbthnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KbthnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KbthnkKbn.class, patternId, value);
    }
}
