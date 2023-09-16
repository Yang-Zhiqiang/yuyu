
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 診査区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsaKbn</td><td colspan="3">診査区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAI_SYOKUTAKUI}</td><td>&quot;1&quot;</td><td>社医・嘱託医</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINGENDOKKU}</td><td>&quot;2&quot;</td><td>人間ドック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSINDANKEKKATUUTIS}</td><td>&quot;3&quot;</td><td>健康診断結果通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUKANRISYOUMEISY}</td><td>&quot;4&quot;</td><td>健康管理証明書</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSINDANKEKKATUUTIS}</td><td>&quot;3&quot;</td><td>健康診断結果通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUKANRISYOUMEISY}</td><td>&quot;4&quot;</td><td>健康管理証明書</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SEKI SEKI}<br />(表示用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINGENDOKKU}</td><td>&quot;2&quot;</td><td>人間ドック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKSINDANKEKKATUUTIS}</td><td>&quot;3&quot;</td><td>健康診断結果通知書</td></tr>
 * </table>
 */
public class C_SinsaKbn extends Classification<C_SinsaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsaKbn BLNK = new C_SinsaKbn("0");

    public static final C_SinsaKbn SYAI_SYOKUTAKUI = new C_SinsaKbn("1");

    public static final C_SinsaKbn NINGENDOKKU = new C_SinsaKbn("2");

    public static final C_SinsaKbn KNKSINDANKEKKATUUTIS = new C_SinsaKbn("3");

    public static final C_SinsaKbn KENKOUKANRISYOUMEISY = new C_SinsaKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_SEKI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYAI_SYOKUTAKUI, "SYAI_SYOKUTAKUI", false);
        addPattern(PATTERN_DEFAULT, NINGENDOKKU, "NINGENDOKKU", false);
        addPattern(PATTERN_DEFAULT, KNKSINDANKEKKATUUTIS, "KNKSINDANKEKKATUUTIS", false);
        addPattern(PATTERN_DEFAULT, KENKOUKANRISYOUMEISY, "KENKOUKANRISYOUMEISY", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KNKSINDANKEKKATUUTIS, "KNKSINDANKEKKATUUTIS", false);
        addPattern(PATTERN_SELECT, KENKOUKANRISYOUMEISY, "KENKOUKANRISYOUMEISY", false);


        addPattern(PATTERN_SEKI, BLNK, "BLNK", false);
        addPattern(PATTERN_SEKI, NINGENDOKKU, "NINGENDOKKU", false);
        addPattern(PATTERN_SEKI, KNKSINDANKEKKATUUTIS, "KNKSINDANKEKKATUUTIS", false);


        lock(C_SinsaKbn.class);
    }

    private C_SinsaKbn(String value) {
        super(value);
    }

    public static C_SinsaKbn valueOf(String value) {
        return valueOf(C_SinsaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsaKbn.class, patternId, value);
    }
}
