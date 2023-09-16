
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ保険料払込方法変更可否制御区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsPhrkhouhenkouKahiSeigyoKbn</td><td colspan="3">ＤＳ保険料払込方法変更可否制御区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;0&quot;</td><td>不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURIHENKOUNOMIKA}</td><td>&quot;2&quot;</td><td>口座振替扱変更のみ可</td></tr>
 * </table>
 */
public class C_DsPhrkhouhenkouKahiSeigyoKbn extends Classification<C_DsPhrkhouhenkouKahiSeigyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsPhrkhouhenkouKahiSeigyoKbn HUKA = new C_DsPhrkhouhenkouKahiSeigyoKbn("0");

    public static final C_DsPhrkhouhenkouKahiSeigyoKbn KA = new C_DsPhrkhouhenkouKahiSeigyoKbn("1");

    public static final C_DsPhrkhouhenkouKahiSeigyoKbn KOUHURIHENKOUNOMIKA = new C_DsPhrkhouhenkouKahiSeigyoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);
        addPattern(PATTERN_DEFAULT, KOUHURIHENKOUNOMIKA, "KOUHURIHENKOUNOMIKA", false);


        lock(C_DsPhrkhouhenkouKahiSeigyoKbn.class);
    }

    private C_DsPhrkhouhenkouKahiSeigyoKbn(String value) {
        super(value);
    }

    public static C_DsPhrkhouhenkouKahiSeigyoKbn valueOf(String value) {
        return valueOf(C_DsPhrkhouhenkouKahiSeigyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsPhrkhouhenkouKahiSeigyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsPhrkhouhenkouKahiSeigyoKbn.class, patternId, value);
    }
}
