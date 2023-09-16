
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ積立金移転共通チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsTmttknitenchkkekkaKbn</td><td colspan="3">ＤＳ積立金移転共通チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKYMDMITOURAI}</td><td>&quot;1&quot;</td><td>契約日未到来チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRATKITISYSYOUHN}</td><td>&quot;2&quot;</td><td>取扱対象商品チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTKKKN}</td><td>&quot;3&quot;</td><td>受付期間チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITUTUMITATE}</td><td>&quot;4&quot;</td><td>定率積立部分割合チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISYUUHOKENNENDO}</td><td>&quot;5&quot;</td><td>最終保険年度チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITENUKTKUMU}</td><td>&quot;6&quot;</td><td>積立金移転受付有無チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENJYOUTAI}</td><td>&quot;7&quot;</td><td>保全有効状態チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKITYUUI}</td><td>&quot;8&quot;</td><td>手続注意チェックエラー</td></tr>
 * </table>
 */
public class C_DsTmttknitenchkkekkaKbn extends Classification<C_DsTmttknitenchkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsTmttknitenchkkekkaKbn BLNK = new C_DsTmttknitenchkkekkaKbn("0");

    public static final C_DsTmttknitenchkkekkaKbn KYKYMDMITOURAI = new C_DsTmttknitenchkkekkaKbn("1");

    public static final C_DsTmttknitenchkkekkaKbn TRATKITISYSYOUHN = new C_DsTmttknitenchkkekkaKbn("2");

    public static final C_DsTmttknitenchkkekkaKbn UKTKKKN = new C_DsTmttknitenchkkekkaKbn("3");

    public static final C_DsTmttknitenchkkekkaKbn TEIRITUTUMITATE = new C_DsTmttknitenchkkekkaKbn("4");

    public static final C_DsTmttknitenchkkekkaKbn SAISYUUHOKENNENDO = new C_DsTmttknitenchkkekkaKbn("5");

    public static final C_DsTmttknitenchkkekkaKbn TMTTKNITENUKTKUMU = new C_DsTmttknitenchkkekkaKbn("6");

    public static final C_DsTmttknitenchkkekkaKbn HOZENJYOUTAI = new C_DsTmttknitenchkkekkaKbn("7");

    public static final C_DsTmttknitenchkkekkaKbn TETUDUKITYUUI = new C_DsTmttknitenchkkekkaKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKYMDMITOURAI, "KYKYMDMITOURAI", false);
        addPattern(PATTERN_DEFAULT, TRATKITISYSYOUHN, "TRATKITISYSYOUHN", false);
        addPattern(PATTERN_DEFAULT, UKTKKKN, "UKTKKKN", false);
        addPattern(PATTERN_DEFAULT, TEIRITUTUMITATE, "TEIRITUTUMITATE", false);
        addPattern(PATTERN_DEFAULT, SAISYUUHOKENNENDO, "SAISYUUHOKENNENDO", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITENUKTKUMU, "TMTTKNITENUKTKUMU", false);
        addPattern(PATTERN_DEFAULT, HOZENJYOUTAI, "HOZENJYOUTAI", false);
        addPattern(PATTERN_DEFAULT, TETUDUKITYUUI, "TETUDUKITYUUI", false);


        lock(C_DsTmttknitenchkkekkaKbn.class);
    }

    private C_DsTmttknitenchkkekkaKbn(String value) {
        super(value);
    }

    public static C_DsTmttknitenchkkekkaKbn valueOf(String value) {
        return valueOf(C_DsTmttknitenchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsTmttknitenchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsTmttknitenchkkekkaKbn.class, patternId, value);
    }
}
