
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受給権発生事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Jykyknhsijiyuu</td><td colspan="3">受給権発生事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKM}</td><td>&quot;1&quot;</td><td>年金取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKM_IZOKU}</td><td>&quot;2&quot;</td><td>年金取込（遺族）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB}</td><td>&quot;3&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETORININHENKOU}</td><td>&quot;4&quot;</td><td>受取人変更</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_TYOUSYO TYOUSYO}<br />(調書用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKM}</td><td>&quot;1&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKM_IZOKU}</td><td>&quot;2&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB}</td><td>&quot;3&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETORININHENKOU}</td><td>&quot;4&quot;</td><td>受取人変更</td></tr>
 * </table>
 */
public class C_Jykyknhsijiyuu extends Classification<C_Jykyknhsijiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Jykyknhsijiyuu BLNK = new C_Jykyknhsijiyuu("0");

    public static final C_Jykyknhsijiyuu TRKM = new C_Jykyknhsijiyuu("1");

    public static final C_Jykyknhsijiyuu TRKM_IZOKU = new C_Jykyknhsijiyuu("2");

    public static final C_Jykyknhsijiyuu SB = new C_Jykyknhsijiyuu("3");

    public static final C_Jykyknhsijiyuu UKETORININHENKOU = new C_Jykyknhsijiyuu("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TYOUSYO = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TRKM, "TRKM", false);
        addPattern(PATTERN_DEFAULT, TRKM_IZOKU, "TRKM_IZOKU", false);
        addPattern(PATTERN_DEFAULT, SB, "SB", false);
        addPattern(PATTERN_DEFAULT, UKETORININHENKOU, "UKETORININHENKOU", false);


        addPattern(PATTERN_TYOUSYO, BLNK, "BLNK", true);
        addPattern(PATTERN_TYOUSYO, TRKM, "TRKM", false);
        addPattern(PATTERN_TYOUSYO, TRKM_IZOKU, "TRKM_IZOKU", false);
        addPattern(PATTERN_TYOUSYO, SB, "SB", false);
        addPattern(PATTERN_TYOUSYO, UKETORININHENKOU, "UKETORININHENKOU", false);


        lock(C_Jykyknhsijiyuu.class);
    }

    private C_Jykyknhsijiyuu(String value) {
        super(value);
    }

    public static C_Jykyknhsijiyuu valueOf(String value) {
        return valueOf(C_Jykyknhsijiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Jykyknhsijiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Jykyknhsijiyuu.class, patternId, value);
    }
}
