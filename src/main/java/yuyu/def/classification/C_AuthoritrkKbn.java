
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オーソリ登録区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AuthoritrkKbn</td><td colspan="3">オーソリ登録区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JITUGAKU}</td><td>&quot;1&quot;</td><td>実金額オーソリ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIYEN}</td><td>&quot;2&quot;</td><td>１円オーソリ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面表示用)</td><td align="center">○</td><td>{@link #JITUGAKU}</td><td>&quot;1&quot;</td><td>実金額オーソリ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIYEN}</td><td>&quot;2&quot;</td><td>１円オーソリ</td></tr>
 * </table>
 */
public class C_AuthoritrkKbn extends Classification<C_AuthoritrkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AuthoritrkKbn BLNK = new C_AuthoritrkKbn("0");

    public static final C_AuthoritrkKbn JITUGAKU = new C_AuthoritrkKbn("1");

    public static final C_AuthoritrkKbn ITIYEN = new C_AuthoritrkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JITUGAKU, "JITUGAKU", false);
        addPattern(PATTERN_DEFAULT, ITIYEN, "ITIYEN", false);


        addPattern(PATTERN_SELECT, JITUGAKU, "JITUGAKU", true);
        addPattern(PATTERN_SELECT, ITIYEN, "ITIYEN", false);


        lock(C_AuthoritrkKbn.class);
    }

    private C_AuthoritrkKbn(String value) {
        super(value);
    }

    public static C_AuthoritrkKbn valueOf(String value) {
        return valueOf(C_AuthoritrkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AuthoritrkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AuthoritrkKbn.class, patternId, value);
    }
}
