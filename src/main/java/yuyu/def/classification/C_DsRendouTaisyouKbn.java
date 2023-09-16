
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ連動対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsRendouTaisyouKbn</td><td colspan="3">ＤＳ連動対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENDOUTAISYOU}</td><td>&quot;1&quot;</td><td>連動対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENDOUTAISYOUGAI}</td><td>&quot;2&quot;</td><td>連動対象外</td></tr>
 * </table>
 */
public class C_DsRendouTaisyouKbn extends Classification<C_DsRendouTaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsRendouTaisyouKbn BLNK = new C_DsRendouTaisyouKbn("0");

    public static final C_DsRendouTaisyouKbn RENDOUTAISYOU = new C_DsRendouTaisyouKbn("1");

    public static final C_DsRendouTaisyouKbn RENDOUTAISYOUGAI = new C_DsRendouTaisyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RENDOUTAISYOU, "RENDOUTAISYOU", false);
        addPattern(PATTERN_DEFAULT, RENDOUTAISYOUGAI, "RENDOUTAISYOUGAI", false);


        lock(C_DsRendouTaisyouKbn.class);
    }

    private C_DsRendouTaisyouKbn(String value) {
        super(value);
    }

    public static C_DsRendouTaisyouKbn valueOf(String value) {
        return valueOf(C_DsRendouTaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsRendouTaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsRendouTaisyouKbn.class, patternId, value);
    }
}
