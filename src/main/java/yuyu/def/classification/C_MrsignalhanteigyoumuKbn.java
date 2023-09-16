
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＲシグナル判定業務区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MrsignalhanteigyoumuKbn</td><td colspan="3">ＭＲシグナル判定業務区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_SAKUSEI}</td><td>&quot;1&quot;</td><td>申込書作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;2&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;3&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_MrsignalhanteigyoumuKbn extends Classification<C_MrsignalhanteigyoumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MrsignalhanteigyoumuKbn BLNK = new C_MrsignalhanteigyoumuKbn("0");

    public static final C_MrsignalhanteigyoumuKbn MOS_SAKUSEI = new C_MrsignalhanteigyoumuKbn("1");

    public static final C_MrsignalhanteigyoumuKbn SKEI = new C_MrsignalhanteigyoumuKbn("2");

    public static final C_MrsignalhanteigyoumuKbn OTHER = new C_MrsignalhanteigyoumuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOS_SAKUSEI, "MOS_SAKUSEI", false);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        lock(C_MrsignalhanteigyoumuKbn.class);
    }

    private C_MrsignalhanteigyoumuKbn(String value) {
        super(value);
    }

    public static C_MrsignalhanteigyoumuKbn valueOf(String value) {
        return valueOf(C_MrsignalhanteigyoumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MrsignalhanteigyoumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MrsignalhanteigyoumuKbn.class, patternId, value);
    }
}
