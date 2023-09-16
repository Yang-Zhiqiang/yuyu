
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 返金理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HenkinriyuuKbn</td><td colspan="3">返金理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASEENKI}</td><td>&quot;1&quot;</td><td>見合わせ延期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;2&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKKA}</td><td>&quot;3&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKINKIBOU}</td><td>&quot;4&quot;</td><td>返金希望</td></tr>
 * </table>
 */
public class C_HenkinriyuuKbn extends Classification<C_HenkinriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HenkinriyuuKbn BLNK = new C_HenkinriyuuKbn("0");

    public static final C_HenkinriyuuKbn MIAWASEENKI = new C_HenkinriyuuKbn("1");

    public static final C_HenkinriyuuKbn MOS_TORIKESI = new C_HenkinriyuuKbn("2");

    public static final C_HenkinriyuuKbn YUUKOUKKNKKA = new C_HenkinriyuuKbn("3");

    public static final C_HenkinriyuuKbn HENKINKIBOU = new C_HenkinriyuuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MIAWASEENKI, "MIAWASEENKI", false);
        addPattern(PATTERN_DEFAULT, MOS_TORIKESI, "MOS_TORIKESI", false);
        addPattern(PATTERN_DEFAULT, YUUKOUKKNKKA, "YUUKOUKKNKKA", false);
        addPattern(PATTERN_DEFAULT, HENKINKIBOU, "HENKINKIBOU", false);


        lock(C_HenkinriyuuKbn.class);
    }

    private C_HenkinriyuuKbn(String value) {
        super(value);
    }

    public static C_HenkinriyuuKbn valueOf(String value) {
        return valueOf(C_HenkinriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HenkinriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HenkinriyuuKbn.class, patternId, value);
    }
}
