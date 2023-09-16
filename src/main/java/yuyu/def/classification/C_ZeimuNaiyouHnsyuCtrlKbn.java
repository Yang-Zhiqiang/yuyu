
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 税務内容編集制御区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZeimuNaiyouHnsyuCtrlKbn</td><td colspan="3">税務内容編集制御区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHENKOUKAISUUNASI}</td><td>&quot;1&quot;</td><td>契約者変更回数なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHENKOUKAISUUARI}</td><td>&quot;2&quot;</td><td>契約者変更回数あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYASIBOUKAIYAKU}</td><td>&quot;3&quot;</td><td>契約者死亡解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTSZEIGK_ARI}</td><td>&quot;4&quot;</td><td>源泉徴収税額あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHENKOUKAISUUARI_HASSEIJI}</td><td>&quot;5&quot;</td><td>契約者変更回数あり（発生時）</td></tr>
 * </table>
 */
public class C_ZeimuNaiyouHnsyuCtrlKbn extends Classification<C_ZeimuNaiyouHnsyuCtrlKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZeimuNaiyouHnsyuCtrlKbn BLNK = new C_ZeimuNaiyouHnsyuCtrlKbn("0");

    public static final C_ZeimuNaiyouHnsyuCtrlKbn KYKHENKOUKAISUUNASI = new C_ZeimuNaiyouHnsyuCtrlKbn("1");

    public static final C_ZeimuNaiyouHnsyuCtrlKbn KYKHENKOUKAISUUARI = new C_ZeimuNaiyouHnsyuCtrlKbn("2");

    public static final C_ZeimuNaiyouHnsyuCtrlKbn KYKSYASIBOUKAIYAKU = new C_ZeimuNaiyouHnsyuCtrlKbn("3");

    public static final C_ZeimuNaiyouHnsyuCtrlKbn GSTSZEIGK_ARI = new C_ZeimuNaiyouHnsyuCtrlKbn("4");

    public static final C_ZeimuNaiyouHnsyuCtrlKbn KYKHENKOUKAISUUARI_HASSEIJI = new C_ZeimuNaiyouHnsyuCtrlKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKHENKOUKAISUUNASI, "KYKHENKOUKAISUUNASI", false);
        addPattern(PATTERN_DEFAULT, KYKHENKOUKAISUUARI, "KYKHENKOUKAISUUARI", false);
        addPattern(PATTERN_DEFAULT, KYKSYASIBOUKAIYAKU, "KYKSYASIBOUKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GSTSZEIGK_ARI, "GSTSZEIGK_ARI", false);
        addPattern(PATTERN_DEFAULT, KYKHENKOUKAISUUARI_HASSEIJI, "KYKHENKOUKAISUUARI_HASSEIJI", false);


        lock(C_ZeimuNaiyouHnsyuCtrlKbn.class);
    }

    private C_ZeimuNaiyouHnsyuCtrlKbn(String value) {
        super(value);
    }

    public static C_ZeimuNaiyouHnsyuCtrlKbn valueOf(String value) {
        return valueOf(C_ZeimuNaiyouHnsyuCtrlKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZeimuNaiyouHnsyuCtrlKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZeimuNaiyouHnsyuCtrlKbn.class, patternId, value);
    }
}
