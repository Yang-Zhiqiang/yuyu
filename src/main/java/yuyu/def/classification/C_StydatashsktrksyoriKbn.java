
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗データ送付先登録処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StydatashsktrksyoriKbn</td><td colspan="3">進捗データ送付先登録処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;3&quot;</td><td>削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSAKU}</td><td>&quot;4&quot;</td><td>検索</td></tr>
 * </table>
 */
public class C_StydatashsktrksyoriKbn extends Classification<C_StydatashsktrksyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StydatashsktrksyoriKbn BLNK = new C_StydatashsktrksyoriKbn("0");

    public static final C_StydatashsktrksyoriKbn TOUROKU = new C_StydatashsktrksyoriKbn("1");

    public static final C_StydatashsktrksyoriKbn HENKOU = new C_StydatashsktrksyoriKbn("2");

    public static final C_StydatashsktrksyoriKbn SAKUJYO = new C_StydatashsktrksyoriKbn("3");

    public static final C_StydatashsktrksyoriKbn KENSAKU = new C_StydatashsktrksyoriKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);
        addPattern(PATTERN_DEFAULT, KENSAKU, "KENSAKU", false);


        lock(C_StydatashsktrksyoriKbn.class);
    }

    private C_StydatashsktrksyoriKbn(String value) {
        super(value);
    }

    public static C_StydatashsktrksyoriKbn valueOf(String value) {
        return valueOf(C_StydatashsktrksyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StydatashsktrksyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StydatashsktrksyoriKbn.class, patternId, value);
    }
}
