
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * スクリーニング結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ScreeningkekkaKbn</td><td colspan="3">スクリーニング結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MRINFOCHKARI}</td><td>&quot;1&quot;</td><td>モラルリスク情報チェック有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SLMRINFOCHKARI}</td><td>&quot;2&quot;</td><td>ＳＬＭＲ情報チェック有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SLSIGNALINFOCHKARI}</td><td>&quot;3&quot;</td><td>ＳＬシグナル情報チェック有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIHOKYOUKAIHNSYINFOCHKARI}</td><td>&quot;4&quot;</td><td>生保協会反社情報チェック有</td></tr>
 * </table>
 */
public class C_ScreeningkekkaKbn extends Classification<C_ScreeningkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ScreeningkekkaKbn BLNK = new C_ScreeningkekkaKbn("0");

    public static final C_ScreeningkekkaKbn MRINFOCHKARI = new C_ScreeningkekkaKbn("1");

    public static final C_ScreeningkekkaKbn SLMRINFOCHKARI = new C_ScreeningkekkaKbn("2");

    public static final C_ScreeningkekkaKbn SLSIGNALINFOCHKARI = new C_ScreeningkekkaKbn("3");

    public static final C_ScreeningkekkaKbn SEIHOKYOUKAIHNSYINFOCHKARI = new C_ScreeningkekkaKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MRINFOCHKARI, "MRINFOCHKARI", false);
        addPattern(PATTERN_DEFAULT, SLMRINFOCHKARI, "SLMRINFOCHKARI", false);
        addPattern(PATTERN_DEFAULT, SLSIGNALINFOCHKARI, "SLSIGNALINFOCHKARI", false);
        addPattern(PATTERN_DEFAULT, SEIHOKYOUKAIHNSYINFOCHKARI, "SEIHOKYOUKAIHNSYINFOCHKARI", false);


        lock(C_ScreeningkekkaKbn.class);
    }

    private C_ScreeningkekkaKbn(String value) {
        super(value);
    }

    public static C_ScreeningkekkaKbn valueOf(String value) {
        return valueOf(C_ScreeningkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ScreeningkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ScreeningkekkaKbn.class, patternId, value);
    }
}
