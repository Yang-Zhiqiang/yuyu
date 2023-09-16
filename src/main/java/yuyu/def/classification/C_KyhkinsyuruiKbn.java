
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyhkinsyuruiKbn</td><td colspan="3">給付金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIPNYINKYHKIN}</td><td>&quot;1&quot;</td><td>疾病入院給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIPSYUJYUTUKYHKIN}</td><td>&quot;2&quot;</td><td>疾病手術給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SNDNKYHKIN}</td><td>&quot;3&quot;</td><td>診断等給付金</td></tr>
 * </table>
 */
public class C_KyhkinsyuruiKbn extends Classification<C_KyhkinsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyhkinsyuruiKbn BLNK = new C_KyhkinsyuruiKbn("0");

    public static final C_KyhkinsyuruiKbn SIPNYINKYHKIN = new C_KyhkinsyuruiKbn("1");

    public static final C_KyhkinsyuruiKbn SIPSYUJYUTUKYHKIN = new C_KyhkinsyuruiKbn("2");

    public static final C_KyhkinsyuruiKbn SNDNKYHKIN = new C_KyhkinsyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIPNYINKYHKIN, "SIPNYINKYHKIN", false);
        addPattern(PATTERN_DEFAULT, SIPSYUJYUTUKYHKIN, "SIPSYUJYUTUKYHKIN", false);
        addPattern(PATTERN_DEFAULT, SNDNKYHKIN, "SNDNKYHKIN", false);


        lock(C_KyhkinsyuruiKbn.class);
    }

    private C_KyhkinsyuruiKbn(String value) {
        super(value);
    }

    public static C_KyhkinsyuruiKbn valueOf(String value) {
        return valueOf(C_KyhkinsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyhkinsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyhkinsyuruiKbn.class, patternId, value);
    }
}
