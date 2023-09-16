
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ属性番号チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsZokuseinochkkekkaKbn</td><td colspan="3">ＤＳ属性番号チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIYMD}</td><td>&quot;1&quot;</td><td>生年月日チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TELNO}</td><td>&quot;2&quot;</td><td>電話番号チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKETADOUTI}</td><td>&quot;3&quot;</td><td>全桁同値チェックエラー</td></tr>
 * </table>
 */
public class C_DsZokuseinochkkekkaKbn extends Classification<C_DsZokuseinochkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsZokuseinochkkekkaKbn BLNK = new C_DsZokuseinochkkekkaKbn("0");

    public static final C_DsZokuseinochkkekkaKbn SEIYMD = new C_DsZokuseinochkkekkaKbn("1");

    public static final C_DsZokuseinochkkekkaKbn TELNO = new C_DsZokuseinochkkekkaKbn("2");

    public static final C_DsZokuseinochkkekkaKbn ZENKETADOUTI = new C_DsZokuseinochkkekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIYMD, "SEIYMD", false);
        addPattern(PATTERN_DEFAULT, TELNO, "TELNO", false);
        addPattern(PATTERN_DEFAULT, ZENKETADOUTI, "ZENKETADOUTI", false);


        lock(C_DsZokuseinochkkekkaKbn.class);
    }

    private C_DsZokuseinochkkekkaKbn(String value) {
        super(value);
    }

    public static C_DsZokuseinochkkekkaKbn valueOf(String value) {
        return valueOf(C_DsZokuseinochkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsZokuseinochkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsZokuseinochkkekkaKbn.class, patternId, value);
    }
}
