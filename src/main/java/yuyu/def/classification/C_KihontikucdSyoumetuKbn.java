
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 基本地区コード消滅理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KihontikucdSyoumetuKbn</td><td colspan="3">基本地区コード消滅理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YUUKOUTYUU}</td><td>&quot;0&quot;</td><td>有効中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YNOHENKOU}</td><td>&quot;1&quot;</td><td>郵便番号変更による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUKYOHYOUJIJISSI}</td><td>&quot;2&quot;</td><td>住居表示実施による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIKUWARIHENKOU}</td><td>&quot;3&quot;</td><td>地区割変更による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;4&quot;</td><td>その他による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YNO7KETAKA}</td><td>&quot;5&quot;</td><td>郵便番号７桁化による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONTIKUCDSETTEI}</td><td>&quot;8&quot;</td><td>基本地区コード設定による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRCD}</td><td>&quot;9&quot;</td><td>住所コードの消滅</td></tr>
 * </table>
 */
public class C_KihontikucdSyoumetuKbn extends Classification<C_KihontikucdSyoumetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KihontikucdSyoumetuKbn YUUKOUTYUU = new C_KihontikucdSyoumetuKbn("0");

    public static final C_KihontikucdSyoumetuKbn YNOHENKOU = new C_KihontikucdSyoumetuKbn("1");

    public static final C_KihontikucdSyoumetuKbn JYUUKYOHYOUJIJISSI = new C_KihontikucdSyoumetuKbn("2");

    public static final C_KihontikucdSyoumetuKbn TIKUWARIHENKOU = new C_KihontikucdSyoumetuKbn("3");

    public static final C_KihontikucdSyoumetuKbn SONOTA = new C_KihontikucdSyoumetuKbn("4");

    public static final C_KihontikucdSyoumetuKbn YNO7KETAKA = new C_KihontikucdSyoumetuKbn("5");

    public static final C_KihontikucdSyoumetuKbn KIHONTIKUCDSETTEI = new C_KihontikucdSyoumetuKbn("8");

    public static final C_KihontikucdSyoumetuKbn ADRCD = new C_KihontikucdSyoumetuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOUTYUU, "YUUKOUTYUU", true);
        addPattern(PATTERN_DEFAULT, YNOHENKOU, "YNOHENKOU", false);
        addPattern(PATTERN_DEFAULT, JYUUKYOHYOUJIJISSI, "JYUUKYOHYOUJIJISSI", false);
        addPattern(PATTERN_DEFAULT, TIKUWARIHENKOU, "TIKUWARIHENKOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, YNO7KETAKA, "YNO7KETAKA", false);
        addPattern(PATTERN_DEFAULT, KIHONTIKUCDSETTEI, "KIHONTIKUCDSETTEI", false);
        addPattern(PATTERN_DEFAULT, ADRCD, "ADRCD", false);


        lock(C_KihontikucdSyoumetuKbn.class);
    }

    private C_KihontikucdSyoumetuKbn(String value) {
        super(value);
    }

    public static C_KihontikucdSyoumetuKbn valueOf(String value) {
        return valueOf(C_KihontikucdSyoumetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KihontikucdSyoumetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KihontikucdSyoumetuKbn.class, patternId, value);
    }
}
