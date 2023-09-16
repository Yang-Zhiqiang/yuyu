
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジット払エラーコード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Creditbrerrorcd</td><td colspan="3">クレジット払エラーコード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="42">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #K01}</td><td>&quot;K01&quot;</td><td>緊急停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #K02}</td><td>&quot;K02&quot;</td><td>無効カードチェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #K03}</td><td>&quot;K03&quot;</td><td>オンラインオーソリ未完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #K04}</td><td>&quot;K04&quot;</td><td>送信先カード会社判定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #S01}</td><td>&quot;S01&quot;</td><td>緊急停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #S02}</td><td>&quot;S02&quot;</td><td>当月はカード支払不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #S03}</td><td>&quot;S03&quot;</td><td>無効カード・事故カード等</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #S04}</td><td>&quot;S04&quot;</td><td>有効期限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #S05}</td><td>&quot;S05&quot;</td><td>送信先判定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G12}</td><td>&quot;G12&quot;</td><td>無効カード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G22}</td><td>&quot;G22&quot;</td><td>支払永久禁止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G30}</td><td>&quot;G30&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G46}</td><td>&quot;G46&quot;</td><td>ＪＩＳ２面情報エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G54}</td><td>&quot;G54&quot;</td><td>総合限度額エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G55}</td><td>&quot;G55&quot;</td><td>利用回数エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G56}</td><td>&quot;G56&quot;</td><td>事故カード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G60}</td><td>&quot;G60&quot;</td><td>事故・口振カード使用停止口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G61}</td><td>&quot;G61&quot;</td><td>契約解除口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G65}</td><td>&quot;G65&quot;</td><td>口座番号エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G67}</td><td>&quot;G67&quot;</td><td>商品コードエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G68}</td><td>&quot;G68&quot;</td><td>金額エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G69}</td><td>&quot;G69&quot;</td><td>税・その他エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G70}</td><td>&quot;G70&quot;</td><td>ボーナス回数エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G71}</td><td>&quot;G71&quot;</td><td>ボーナス月エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G72}</td><td>&quot;G72&quot;</td><td>ボーナス金額エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G73}</td><td>&quot;G73&quot;</td><td>支払開始月エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G74}</td><td>&quot;G74&quot;</td><td>分割回数エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G75}</td><td>&quot;G75&quot;</td><td>分割金額エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G76}</td><td>&quot;G76&quot;</td><td>初回金額エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G77}</td><td>&quot;G77&quot;</td><td>業務区分エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G78}</td><td>&quot;G78&quot;</td><td>支払区分エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G81}</td><td>&quot;G81&quot;</td><td>取扱区分・取引区分エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G83}</td><td>&quot;G83&quot;</td><td>有効期限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G92}</td><td>&quot;G92&quot;</td><td>カード会社の独自チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G95}</td><td>&quot;G95&quot;</td><td>該当業務オンライン終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G97}</td><td>&quot;G97&quot;</td><td>該当要求拒否</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #G98}</td><td>&quot;G98&quot;</td><td>該当自社対象業務エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #C12}</td><td>&quot;C12&quot;</td><td>被仕向センタビジー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #C13}</td><td>&quot;C13&quot;</td><td>被仕向センタ障害中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #C14}</td><td>&quot;C14&quot;</td><td>被仕向センタ個別終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #C50}</td><td>&quot;C50&quot;</td><td>タイムアウト</td></tr>
 * </table>
 */
public class C_Creditbrerrorcd extends Classification<C_Creditbrerrorcd> {

    private static final long serialVersionUID = 1L;


    public static final C_Creditbrerrorcd BLNK = new C_Creditbrerrorcd("0");

    public static final C_Creditbrerrorcd K01 = new C_Creditbrerrorcd("K01");

    public static final C_Creditbrerrorcd K02 = new C_Creditbrerrorcd("K02");

    public static final C_Creditbrerrorcd K03 = new C_Creditbrerrorcd("K03");

    public static final C_Creditbrerrorcd K04 = new C_Creditbrerrorcd("K04");

    public static final C_Creditbrerrorcd S01 = new C_Creditbrerrorcd("S01");

    public static final C_Creditbrerrorcd S02 = new C_Creditbrerrorcd("S02");

    public static final C_Creditbrerrorcd S03 = new C_Creditbrerrorcd("S03");

    public static final C_Creditbrerrorcd S04 = new C_Creditbrerrorcd("S04");

    public static final C_Creditbrerrorcd S05 = new C_Creditbrerrorcd("S05");

    public static final C_Creditbrerrorcd G12 = new C_Creditbrerrorcd("G12");

    public static final C_Creditbrerrorcd G22 = new C_Creditbrerrorcd("G22");

    public static final C_Creditbrerrorcd G30 = new C_Creditbrerrorcd("G30");

    public static final C_Creditbrerrorcd G46 = new C_Creditbrerrorcd("G46");

    public static final C_Creditbrerrorcd G54 = new C_Creditbrerrorcd("G54");

    public static final C_Creditbrerrorcd G55 = new C_Creditbrerrorcd("G55");

    public static final C_Creditbrerrorcd G56 = new C_Creditbrerrorcd("G56");

    public static final C_Creditbrerrorcd G60 = new C_Creditbrerrorcd("G60");

    public static final C_Creditbrerrorcd G61 = new C_Creditbrerrorcd("G61");

    public static final C_Creditbrerrorcd G65 = new C_Creditbrerrorcd("G65");

    public static final C_Creditbrerrorcd G67 = new C_Creditbrerrorcd("G67");

    public static final C_Creditbrerrorcd G68 = new C_Creditbrerrorcd("G68");

    public static final C_Creditbrerrorcd G69 = new C_Creditbrerrorcd("G69");

    public static final C_Creditbrerrorcd G70 = new C_Creditbrerrorcd("G70");

    public static final C_Creditbrerrorcd G71 = new C_Creditbrerrorcd("G71");

    public static final C_Creditbrerrorcd G72 = new C_Creditbrerrorcd("G72");

    public static final C_Creditbrerrorcd G73 = new C_Creditbrerrorcd("G73");

    public static final C_Creditbrerrorcd G74 = new C_Creditbrerrorcd("G74");

    public static final C_Creditbrerrorcd G75 = new C_Creditbrerrorcd("G75");

    public static final C_Creditbrerrorcd G76 = new C_Creditbrerrorcd("G76");

    public static final C_Creditbrerrorcd G77 = new C_Creditbrerrorcd("G77");

    public static final C_Creditbrerrorcd G78 = new C_Creditbrerrorcd("G78");

    public static final C_Creditbrerrorcd G81 = new C_Creditbrerrorcd("G81");

    public static final C_Creditbrerrorcd G83 = new C_Creditbrerrorcd("G83");

    public static final C_Creditbrerrorcd G92 = new C_Creditbrerrorcd("G92");

    public static final C_Creditbrerrorcd G95 = new C_Creditbrerrorcd("G95");

    public static final C_Creditbrerrorcd G97 = new C_Creditbrerrorcd("G97");

    public static final C_Creditbrerrorcd G98 = new C_Creditbrerrorcd("G98");

    public static final C_Creditbrerrorcd C12 = new C_Creditbrerrorcd("C12");

    public static final C_Creditbrerrorcd C13 = new C_Creditbrerrorcd("C13");

    public static final C_Creditbrerrorcd C14 = new C_Creditbrerrorcd("C14");

    public static final C_Creditbrerrorcd C50 = new C_Creditbrerrorcd("C50");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, K01, "K01", false);
        addPattern(PATTERN_DEFAULT, K02, "K02", false);
        addPattern(PATTERN_DEFAULT, K03, "K03", false);
        addPattern(PATTERN_DEFAULT, K04, "K04", false);
        addPattern(PATTERN_DEFAULT, S01, "S01", false);
        addPattern(PATTERN_DEFAULT, S02, "S02", false);
        addPattern(PATTERN_DEFAULT, S03, "S03", false);
        addPattern(PATTERN_DEFAULT, S04, "S04", false);
        addPattern(PATTERN_DEFAULT, S05, "S05", false);
        addPattern(PATTERN_DEFAULT, G12, "G12", false);
        addPattern(PATTERN_DEFAULT, G22, "G22", false);
        addPattern(PATTERN_DEFAULT, G30, "G30", false);
        addPattern(PATTERN_DEFAULT, G46, "G46", false);
        addPattern(PATTERN_DEFAULT, G54, "G54", false);
        addPattern(PATTERN_DEFAULT, G55, "G55", false);
        addPattern(PATTERN_DEFAULT, G56, "G56", false);
        addPattern(PATTERN_DEFAULT, G60, "G60", false);
        addPattern(PATTERN_DEFAULT, G61, "G61", false);
        addPattern(PATTERN_DEFAULT, G65, "G65", false);
        addPattern(PATTERN_DEFAULT, G67, "G67", false);
        addPattern(PATTERN_DEFAULT, G68, "G68", false);
        addPattern(PATTERN_DEFAULT, G69, "G69", false);
        addPattern(PATTERN_DEFAULT, G70, "G70", false);
        addPattern(PATTERN_DEFAULT, G71, "G71", false);
        addPattern(PATTERN_DEFAULT, G72, "G72", false);
        addPattern(PATTERN_DEFAULT, G73, "G73", false);
        addPattern(PATTERN_DEFAULT, G74, "G74", false);
        addPattern(PATTERN_DEFAULT, G75, "G75", false);
        addPattern(PATTERN_DEFAULT, G76, "G76", false);
        addPattern(PATTERN_DEFAULT, G77, "G77", false);
        addPattern(PATTERN_DEFAULT, G78, "G78", false);
        addPattern(PATTERN_DEFAULT, G81, "G81", false);
        addPattern(PATTERN_DEFAULT, G83, "G83", false);
        addPattern(PATTERN_DEFAULT, G92, "G92", false);
        addPattern(PATTERN_DEFAULT, G95, "G95", false);
        addPattern(PATTERN_DEFAULT, G97, "G97", false);
        addPattern(PATTERN_DEFAULT, G98, "G98", false);
        addPattern(PATTERN_DEFAULT, C12, "C12", false);
        addPattern(PATTERN_DEFAULT, C13, "C13", false);
        addPattern(PATTERN_DEFAULT, C14, "C14", false);
        addPattern(PATTERN_DEFAULT, C50, "C50", false);


        lock(C_Creditbrerrorcd.class);
    }

    private C_Creditbrerrorcd(String value) {
        super(value);
    }

    public static C_Creditbrerrorcd valueOf(String value) {
        return valueOf(C_Creditbrerrorcd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Creditbrerrorcd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Creditbrerrorcd.class, patternId, value);
    }
}
