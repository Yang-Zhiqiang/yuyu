
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納回数判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Znnkaisuukekka</td><td colspan="3">前納回数判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ZENKI}</td><td>&quot;0&quot;</td><td>全期前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBU}</td><td>&quot;1&quot;</td><td>一部前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OVER}</td><td>&quot;2&quot;</td><td>前納回数オーバー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKOVER}</td><td>&quot;3&quot;</td><td>特約前納回数オーバー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKI_ARI_HUITTI}</td><td>&quot;4&quot;</td><td>全期前納あり前納回数不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKI_NASI_ITTI}</td><td>&quot;5&quot;</td><td>全期前納なし前納回数一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKZENKI_ARI_HUITTI}</td><td>&quot;6&quot;</td><td>全期前納あり特約前納回数不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKZENKI_NASI_ITTI}</td><td>&quot;7&quot;</td><td>全期前納なし特約前納回数一致</td></tr>
 * </table>
 */
public class C_Znnkaisuukekka extends Classification<C_Znnkaisuukekka> {

    private static final long serialVersionUID = 1L;


    public static final C_Znnkaisuukekka ZENKI = new C_Znnkaisuukekka("0");

    public static final C_Znnkaisuukekka ITIBU = new C_Znnkaisuukekka("1");

    public static final C_Znnkaisuukekka OVER = new C_Znnkaisuukekka("2");

    public static final C_Znnkaisuukekka TKOVER = new C_Znnkaisuukekka("3");

    public static final C_Znnkaisuukekka ZENKI_ARI_HUITTI = new C_Znnkaisuukekka("4");

    public static final C_Znnkaisuukekka ZENKI_NASI_ITTI = new C_Znnkaisuukekka("5");

    public static final C_Znnkaisuukekka TKZENKI_ARI_HUITTI = new C_Znnkaisuukekka("6");

    public static final C_Znnkaisuukekka TKZENKI_NASI_ITTI = new C_Znnkaisuukekka("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ZENKI, "ZENKI", true);
        addPattern(PATTERN_DEFAULT, ITIBU, "ITIBU", false);
        addPattern(PATTERN_DEFAULT, OVER, "OVER", false);
        addPattern(PATTERN_DEFAULT, TKOVER, "TKOVER", false);
        addPattern(PATTERN_DEFAULT, ZENKI_ARI_HUITTI, "ZENKI_ARI_HUITTI", false);
        addPattern(PATTERN_DEFAULT, ZENKI_NASI_ITTI, "ZENKI_NASI_ITTI", false);
        addPattern(PATTERN_DEFAULT, TKZENKI_ARI_HUITTI, "TKZENKI_ARI_HUITTI", false);
        addPattern(PATTERN_DEFAULT, TKZENKI_NASI_ITTI, "TKZENKI_NASI_ITTI", false);


        lock(C_Znnkaisuukekka.class);
    }

    private C_Znnkaisuukekka(String value) {
        super(value);
    }

    public static C_Znnkaisuukekka valueOf(String value) {
        return valueOf(C_Znnkaisuukekka.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Znnkaisuukekka.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Znnkaisuukekka.class, patternId, value);
    }
}
