
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料円換算額通知方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PyenTutHouKbn</td><td colspan="3">保険料円換算額通知方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILYUUSOUKIBOU}</td><td>&quot;1&quot;</td><td>希望する（メール、郵送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSOUKIBOU}</td><td>&quot;2&quot;</td><td>希望する（郵送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILKIBOU}</td><td>&quot;3&quot;</td><td>希望する（メール）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIBOUSINAI}</td><td>&quot;4&quot;</td><td>希望しない</td></tr>
 * </table>
 */
public class C_PyenTutHouKbn extends Classification<C_PyenTutHouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PyenTutHouKbn BLNK = new C_PyenTutHouKbn("0");

    public static final C_PyenTutHouKbn MAILYUUSOUKIBOU = new C_PyenTutHouKbn("1");

    public static final C_PyenTutHouKbn YUUSOUKIBOU = new C_PyenTutHouKbn("2");

    public static final C_PyenTutHouKbn MAILKIBOU = new C_PyenTutHouKbn("3");

    public static final C_PyenTutHouKbn KIBOUSINAI = new C_PyenTutHouKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MAILYUUSOUKIBOU, "MAILYUUSOUKIBOU", false);
        addPattern(PATTERN_DEFAULT, YUUSOUKIBOU, "YUUSOUKIBOU", false);
        addPattern(PATTERN_DEFAULT, MAILKIBOU, "MAILKIBOU", false);
        addPattern(PATTERN_DEFAULT, KIBOUSINAI, "KIBOUSINAI", false);


        lock(C_PyenTutHouKbn.class);
    }

    private C_PyenTutHouKbn(String value) {
        super(value);
    }

    public static C_PyenTutHouKbn valueOf(String value) {
        return valueOf(C_PyenTutHouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PyenTutHouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PyenTutHouKbn.class, patternId, value);
    }
}
