
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 伝票用返金方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DenhnknhouKbn</td><td colspan="3">伝票用返金方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUBINHARAIDASI}</td><td>&quot;1&quot;</td><td>郵便払出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKEKAETUUTI}</td><td>&quot;2&quot;</td><td>付替通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAHURIKOMI}</td><td>&quot;3&quot;</td><td>当座口振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENKIN}</td><td>&quot;4&quot;</td><td>その他返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHENKIN_MINUSURIAGE}</td><td>&quot;5&quot;</td><td>クレカ返金（マイナス売上）</td></tr>
 * </table>
 */
public class C_DenhnknhouKbn extends Classification<C_DenhnknhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DenhnknhouKbn BLNK = new C_DenhnknhouKbn("0");

    public static final C_DenhnknhouKbn YUBINHARAIDASI = new C_DenhnknhouKbn("1");

    public static final C_DenhnknhouKbn TUKEKAETUUTI = new C_DenhnknhouKbn("2");

    public static final C_DenhnknhouKbn KOUZAHURIKOMI = new C_DenhnknhouKbn("3");

    public static final C_DenhnknhouKbn SONOTAHENKIN = new C_DenhnknhouKbn("4");

    public static final C_DenhnknhouKbn CREDITHENKIN_MINUSURIAGE = new C_DenhnknhouKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUBINHARAIDASI, "YUBINHARAIDASI", false);
        addPattern(PATTERN_DEFAULT, TUKEKAETUUTI, "TUKEKAETUUTI", false);
        addPattern(PATTERN_DEFAULT, KOUZAHURIKOMI, "KOUZAHURIKOMI", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENKIN, "SONOTAHENKIN", false);
        addPattern(PATTERN_DEFAULT, CREDITHENKIN_MINUSURIAGE, "CREDITHENKIN_MINUSURIAGE", false);


        lock(C_DenhnknhouKbn.class);
    }

    private C_DenhnknhouKbn(String value) {
        super(value);
    }

    public static C_DenhnknhouKbn valueOf(String value) {
        return valueOf(C_DenhnknhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DenhnknhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DenhnknhouKbn.class, patternId, value);
    }
}
