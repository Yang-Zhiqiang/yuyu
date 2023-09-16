
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ドキュメント状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Documentstatus</td><td colspan="3">ドキュメント状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUTYAKUMATI}</td><td>&quot;10&quot;</td><td>到着待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUTYAKUZUMI}</td><td>&quot;90&quot;</td><td>到着済</td></tr>
 * </table>
 */
public class C_Documentstatus extends Classification<C_Documentstatus> {

    private static final long serialVersionUID = 1L;


    public static final C_Documentstatus BLNK = new C_Documentstatus("0");

    public static final C_Documentstatus TOUTYAKUMATI = new C_Documentstatus("10");

    public static final C_Documentstatus TOUTYAKUZUMI = new C_Documentstatus("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUTYAKUMATI, "TOUTYAKUMATI", false);
        addPattern(PATTERN_DEFAULT, TOUTYAKUZUMI, "TOUTYAKUZUMI", false);


        lock(C_Documentstatus.class);
    }

    private C_Documentstatus(String value) {
        super(value);
    }

    public static C_Documentstatus valueOf(String value) {
        return valueOf(C_Documentstatus.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Documentstatus.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Documentstatus.class, patternId, value);
    }
}
