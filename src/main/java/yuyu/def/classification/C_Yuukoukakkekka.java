
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効確認結果 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Yuukoukakkekka</td><td colspan="3">有効確認結果</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKAK_OK}</td><td>&quot;1&quot;</td><td>有効確認ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKAK_NG}</td><td>&quot;2&quot;</td><td>有効確認ＮＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUGOUERROR}</td><td>&quot;3&quot;</td><td>照合エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDKAISYAHNTIERROR}</td><td>&quot;4&quot;</td><td>カード会社判定エラー</td></tr>
 * </table>
 */
public class C_Yuukoukakkekka extends Classification<C_Yuukoukakkekka> {

    private static final long serialVersionUID = 1L;


    public static final C_Yuukoukakkekka BLNK = new C_Yuukoukakkekka("0");

    public static final C_Yuukoukakkekka YUUKOUKAK_OK = new C_Yuukoukakkekka("1");

    public static final C_Yuukoukakkekka YUUKOUKAK_NG = new C_Yuukoukakkekka("2");

    public static final C_Yuukoukakkekka SYOUGOUERROR = new C_Yuukoukakkekka("3");

    public static final C_Yuukoukakkekka CARDKAISYAHNTIERROR = new C_Yuukoukakkekka("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUKOUKAK_OK, "YUUKOUKAK_OK", false);
        addPattern(PATTERN_DEFAULT, YUUKOUKAK_NG, "YUUKOUKAK_NG", false);
        addPattern(PATTERN_DEFAULT, SYOUGOUERROR, "SYOUGOUERROR", false);
        addPattern(PATTERN_DEFAULT, CARDKAISYAHNTIERROR, "CARDKAISYAHNTIERROR", false);


        lock(C_Yuukoukakkekka.class);
    }

    private C_Yuukoukakkekka(String value) {
        super(value);
    }

    public static C_Yuukoukakkekka valueOf(String value) {
        return valueOf(C_Yuukoukakkekka.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Yuukoukakkekka.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Yuukoukakkekka.class, patternId, value);
    }
}
