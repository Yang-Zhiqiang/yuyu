
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 円貨払込額案内通知区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YnkHrkmgkAnniTuutiKbn</td><td colspan="3">円貨払込額案内通知区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSOUKIBOU}</td><td>&quot;1&quot;</td><td>郵送を希望する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSOUKIBOUSHINAI}</td><td>&quot;2&quot;</td><td>郵送を希望しない</td></tr>
 * </table>
 */
public class C_YnkHrkmgkAnniTuutiKbn extends Classification<C_YnkHrkmgkAnniTuutiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YnkHrkmgkAnniTuutiKbn BLNK = new C_YnkHrkmgkAnniTuutiKbn("0");

    public static final C_YnkHrkmgkAnniTuutiKbn YUUSOUKIBOU = new C_YnkHrkmgkAnniTuutiKbn("1");

    public static final C_YnkHrkmgkAnniTuutiKbn YUUSOUKIBOUSHINAI = new C_YnkHrkmgkAnniTuutiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUSOUKIBOU, "YUUSOUKIBOU", false);
        addPattern(PATTERN_DEFAULT, YUUSOUKIBOUSHINAI, "YUUSOUKIBOUSHINAI", false);


        lock(C_YnkHrkmgkAnniTuutiKbn.class);
    }

    private C_YnkHrkmgkAnniTuutiKbn(String value) {
        super(value);
    }

    public static C_YnkHrkmgkAnniTuutiKbn valueOf(String value) {
        return valueOf(C_YnkHrkmgkAnniTuutiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YnkHrkmgkAnniTuutiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YnkHrkmgkAnniTuutiKbn.class, patternId, value);
    }
}
