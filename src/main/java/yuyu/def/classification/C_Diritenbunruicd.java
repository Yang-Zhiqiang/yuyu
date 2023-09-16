
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店分類コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Diritenbunruicd</td><td colspan="3">代理店分類コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="24">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAITOGIN}</td><td>&quot;11&quot;</td><td>銀行系代理店(都銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAI1CHIGIN}</td><td>&quot;12&quot;</td><td>銀行系代理店(第１地銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAI2CHIGIN}</td><td>&quot;13&quot;</td><td>銀行系代理店(第２地銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAISINKIN}</td><td>&quot;14&quot;</td><td>銀行系代理店(信金系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAIETC}</td><td>&quot;15&quot;</td><td>銀行系代理店(その他)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAISINKUMI}</td><td>&quot;16&quot;</td><td>銀行系代理店（信組系）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKEN}</td><td>&quot;21&quot;</td><td>証券会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEIRIKOJIN}</td><td>&quot;27&quot;</td><td>税理士(個人)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEIRIHOUJIN}</td><td>&quot;28&quot;</td><td>税理士(法人)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENDAI}</td><td>&quot;30&quot;</td><td>専業代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGYODAI}</td><td>&quot;40&quot;</td><td>企業代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINTOGIN}</td><td>&quot;51&quot;</td><td>銀行(都銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIN1CHIGIN}</td><td>&quot;52&quot;</td><td>銀行(第１地銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIN2CHIGIN}</td><td>&quot;53&quot;</td><td>銀行(第２地銀系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINSINKIN}</td><td>&quot;54&quot;</td><td>銀行(信金系)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINCYOUSIN}</td><td>&quot;55&quot;</td><td>銀行(長信銀・その他)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINSINKUMI}</td><td>&quot;56&quot;</td><td>銀行（信組系）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDIRECT}</td><td>&quot;57&quot;</td><td>銀行（ダイレクト）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKANPO}</td><td>&quot;71&quot;</td><td>郵政（かんぽ生命）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIYUUCYO}</td><td>&quot;72&quot;</td><td>郵政（ゆうちょ銀行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIYUUBIN}</td><td>&quot;73&quot;</td><td>郵政（郵便局会社）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKANI}</td><td>&quot;74&quot;</td><td>郵政（簡易郵便局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BROKER}</td><td>&quot;99&quot;</td><td>ブローカー</td></tr>
 * </table>
 */
public class C_Diritenbunruicd extends Classification<C_Diritenbunruicd> {

    private static final long serialVersionUID = 1L;


    public static final C_Diritenbunruicd BLNK = new C_Diritenbunruicd("00");

    public static final C_Diritenbunruicd GINDAITOGIN = new C_Diritenbunruicd("11");

    public static final C_Diritenbunruicd GINDAI1CHIGIN = new C_Diritenbunruicd("12");

    public static final C_Diritenbunruicd GINDAI2CHIGIN = new C_Diritenbunruicd("13");

    public static final C_Diritenbunruicd GINDAISINKIN = new C_Diritenbunruicd("14");

    public static final C_Diritenbunruicd GINDAIETC = new C_Diritenbunruicd("15");

    public static final C_Diritenbunruicd GINDAISINKUMI = new C_Diritenbunruicd("16");

    public static final C_Diritenbunruicd SYOUKEN = new C_Diritenbunruicd("21");

    public static final C_Diritenbunruicd ZEIRIKOJIN = new C_Diritenbunruicd("27");

    public static final C_Diritenbunruicd ZEIRIHOUJIN = new C_Diritenbunruicd("28");

    public static final C_Diritenbunruicd SENDAI = new C_Diritenbunruicd("30");

    public static final C_Diritenbunruicd KIGYODAI = new C_Diritenbunruicd("40");

    public static final C_Diritenbunruicd GINTOGIN = new C_Diritenbunruicd("51");

    public static final C_Diritenbunruicd GIN1CHIGIN = new C_Diritenbunruicd("52");

    public static final C_Diritenbunruicd GIN2CHIGIN = new C_Diritenbunruicd("53");

    public static final C_Diritenbunruicd GINSINKIN = new C_Diritenbunruicd("54");

    public static final C_Diritenbunruicd GINCYOUSIN = new C_Diritenbunruicd("55");

    public static final C_Diritenbunruicd GINSINKUMI = new C_Diritenbunruicd("56");

    public static final C_Diritenbunruicd GINDIRECT = new C_Diritenbunruicd("57");

    public static final C_Diritenbunruicd YUUSEIKANPO = new C_Diritenbunruicd("71");

    public static final C_Diritenbunruicd YUUSEIYUUCYO = new C_Diritenbunruicd("72");

    public static final C_Diritenbunruicd YUUSEIYUUBIN = new C_Diritenbunruicd("73");

    public static final C_Diritenbunruicd YUUSEIKANI = new C_Diritenbunruicd("74");

    public static final C_Diritenbunruicd BROKER = new C_Diritenbunruicd("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GINDAITOGIN, "GINDAITOGIN", false);
        addPattern(PATTERN_DEFAULT, GINDAI1CHIGIN, "GINDAI1CHIGIN", false);
        addPattern(PATTERN_DEFAULT, GINDAI2CHIGIN, "GINDAI2CHIGIN", false);
        addPattern(PATTERN_DEFAULT, GINDAISINKIN, "GINDAISINKIN", false);
        addPattern(PATTERN_DEFAULT, GINDAIETC, "GINDAIETC", false);
        addPattern(PATTERN_DEFAULT, GINDAISINKUMI, "GINDAISINKUMI", false);
        addPattern(PATTERN_DEFAULT, SYOUKEN, "SYOUKEN", false);
        addPattern(PATTERN_DEFAULT, ZEIRIKOJIN, "ZEIRIKOJIN", false);
        addPattern(PATTERN_DEFAULT, ZEIRIHOUJIN, "ZEIRIHOUJIN", false);
        addPattern(PATTERN_DEFAULT, SENDAI, "SENDAI", false);
        addPattern(PATTERN_DEFAULT, KIGYODAI, "KIGYODAI", false);
        addPattern(PATTERN_DEFAULT, GINTOGIN, "GINTOGIN", false);
        addPattern(PATTERN_DEFAULT, GIN1CHIGIN, "GIN1CHIGIN", false);
        addPattern(PATTERN_DEFAULT, GIN2CHIGIN, "GIN2CHIGIN", false);
        addPattern(PATTERN_DEFAULT, GINSINKIN, "GINSINKIN", false);
        addPattern(PATTERN_DEFAULT, GINCYOUSIN, "GINCYOUSIN", false);
        addPattern(PATTERN_DEFAULT, GINSINKUMI, "GINSINKUMI", false);
        addPattern(PATTERN_DEFAULT, GINDIRECT, "GINDIRECT", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKANPO, "YUUSEIKANPO", false);
        addPattern(PATTERN_DEFAULT, YUUSEIYUUCYO, "YUUSEIYUUCYO", false);
        addPattern(PATTERN_DEFAULT, YUUSEIYUUBIN, "YUUSEIYUUBIN", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKANI, "YUUSEIKANI", false);
        addPattern(PATTERN_DEFAULT, BROKER, "BROKER", false);


        lock(C_Diritenbunruicd.class);
    }

    private C_Diritenbunruicd(String value) {
        super(value);
    }

    public static C_Diritenbunruicd valueOf(String value) {
        return valueOf(C_Diritenbunruicd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Diritenbunruicd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Diritenbunruicd.class, patternId, value);
    }
}
