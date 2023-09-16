
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店チャネル種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtenChannelSyurui</td><td colspan="3">代理店チャネル種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINHONTAIMADO}</td><td>&quot;01&quot;</td><td>銀行本体（窓販）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUKEIDAI}</td><td>&quot;02&quot;</td><td>銀行系代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKENGAISYA}</td><td>&quot;03&quot;</td><td>証券会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEIRISI}</td><td>&quot;04&quot;</td><td>税理士</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENGYOUDAI}</td><td>&quot;05&quot;</td><td>専業代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGYOUDAI}</td><td>&quot;06&quot;</td><td>企業代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEI}</td><td>&quot;07&quot;</td><td>郵政</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BROKER}</td><td>&quot;99&quot;</td><td>ブローカー</td></tr>
 * </table>
 */
public class C_DrtenChannelSyurui extends Classification<C_DrtenChannelSyurui> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtenChannelSyurui BLNK = new C_DrtenChannelSyurui("00");

    public static final C_DrtenChannelSyurui GINHONTAIMADO = new C_DrtenChannelSyurui("01");

    public static final C_DrtenChannelSyurui GINKOUKEIDAI = new C_DrtenChannelSyurui("02");

    public static final C_DrtenChannelSyurui SYOUKENGAISYA = new C_DrtenChannelSyurui("03");

    public static final C_DrtenChannelSyurui ZEIRISI = new C_DrtenChannelSyurui("04");

    public static final C_DrtenChannelSyurui SENGYOUDAI = new C_DrtenChannelSyurui("05");

    public static final C_DrtenChannelSyurui KIGYOUDAI = new C_DrtenChannelSyurui("06");

    public static final C_DrtenChannelSyurui YUUSEI = new C_DrtenChannelSyurui("07");

    public static final C_DrtenChannelSyurui BROKER = new C_DrtenChannelSyurui("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GINHONTAIMADO, "GINHONTAIMADO", false);
        addPattern(PATTERN_DEFAULT, GINKOUKEIDAI, "GINKOUKEIDAI", false);
        addPattern(PATTERN_DEFAULT, SYOUKENGAISYA, "SYOUKENGAISYA", false);
        addPattern(PATTERN_DEFAULT, ZEIRISI, "ZEIRISI", false);
        addPattern(PATTERN_DEFAULT, SENGYOUDAI, "SENGYOUDAI", false);
        addPattern(PATTERN_DEFAULT, KIGYOUDAI, "KIGYOUDAI", false);
        addPattern(PATTERN_DEFAULT, YUUSEI, "YUUSEI", false);
        addPattern(PATTERN_DEFAULT, BROKER, "BROKER", false);


        lock(C_DrtenChannelSyurui.class);
    }

    private C_DrtenChannelSyurui(String value) {
        super(value);
    }

    public static C_DrtenChannelSyurui valueOf(String value) {
        return valueOf(C_DrtenChannelSyurui.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtenChannelSyurui.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtenChannelSyurui.class, patternId, value);
    }
}
