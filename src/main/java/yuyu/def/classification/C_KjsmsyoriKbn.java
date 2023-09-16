
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjsmsyoriKbn</td><td colspan="3">控除証明処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KJSMBATCH}</td><td>&quot;1&quot;</td><td>控除証明書作成（バッチ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KJSMSAIHAKKOU}</td><td>&quot;2&quot;</td><td>控除証明書再作成（オンライン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUINFO}</td><td>&quot;3&quot;</td><td>契約情報取込</td></tr>
 * </table>
 */
public class C_KjsmsyoriKbn extends Classification<C_KjsmsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjsmsyoriKbn BLNK = new C_KjsmsyoriKbn("0");

    public static final C_KjsmsyoriKbn KJSMBATCH = new C_KjsmsyoriKbn("1");

    public static final C_KjsmsyoriKbn KJSMSAIHAKKOU = new C_KjsmsyoriKbn("2");

    public static final C_KjsmsyoriKbn KEIYAKUINFO = new C_KjsmsyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KJSMBATCH, "KJSMBATCH", false);
        addPattern(PATTERN_DEFAULT, KJSMSAIHAKKOU, "KJSMSAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUINFO, "KEIYAKUINFO", false);


        lock(C_KjsmsyoriKbn.class);
    }

    private C_KjsmsyoriKbn(String value) {
        super(value);
    }

    public static C_KjsmsyoriKbn valueOf(String value) {
        return valueOf(C_KjsmsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjsmsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjsmsyoriKbn.class, patternId, value);
    }
}
