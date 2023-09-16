
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 積立金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tmttknsyuruikbn</td><td colspan="3">積立金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUU_RENDOU_NENKIN}</td><td>&quot;01&quot;</td><td>指数連動（たのしみグローバル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITU_TMTT_NENKIN}</td><td>&quot;02&quot;</td><td>定率積立（たのしみグローバル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUU_RENDOU_NENKIN2}</td><td>&quot;03&quot;</td><td>指数連動（たのしみグローバルⅡ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITU_TMTT_NENKIN2_TKSHR_NONE}</td><td>&quot;04&quot;</td><td>定率積立（たのしみグローバルⅡ）・定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITU_TMTT_NENKIN2_TKSHR_ARI}</td><td>&quot;05&quot;</td><td>定率積立（たのしみグローバルⅡ）・定期支払あり</td></tr>
 * </table>
 */
public class C_Tmttknsyuruikbn extends Classification<C_Tmttknsyuruikbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Tmttknsyuruikbn BLNK = new C_Tmttknsyuruikbn("0");

    public static final C_Tmttknsyuruikbn SISUU_RENDOU_NENKIN = new C_Tmttknsyuruikbn("01");

    public static final C_Tmttknsyuruikbn TEIRITU_TMTT_NENKIN = new C_Tmttknsyuruikbn("02");

    public static final C_Tmttknsyuruikbn SISUU_RENDOU_NENKIN2 = new C_Tmttknsyuruikbn("03");

    public static final C_Tmttknsyuruikbn TEIRITU_TMTT_NENKIN2_TKSHR_NONE = new C_Tmttknsyuruikbn("04");

    public static final C_Tmttknsyuruikbn TEIRITU_TMTT_NENKIN2_TKSHR_ARI = new C_Tmttknsyuruikbn("05");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SISUU_RENDOU_NENKIN, "SISUU_RENDOU_NENKIN", false);
        addPattern(PATTERN_DEFAULT, TEIRITU_TMTT_NENKIN, "TEIRITU_TMTT_NENKIN", false);
        addPattern(PATTERN_DEFAULT, SISUU_RENDOU_NENKIN2, "SISUU_RENDOU_NENKIN2", false);
        addPattern(PATTERN_DEFAULT, TEIRITU_TMTT_NENKIN2_TKSHR_NONE, "TEIRITU_TMTT_NENKIN2_TKSHR_NONE", false);
        addPattern(PATTERN_DEFAULT, TEIRITU_TMTT_NENKIN2_TKSHR_ARI, "TEIRITU_TMTT_NENKIN2_TKSHR_ARI", false);


        lock(C_Tmttknsyuruikbn.class);
    }

    private C_Tmttknsyuruikbn(String value) {
        super(value);
    }

    public static C_Tmttknsyuruikbn valueOf(String value) {
        return valueOf(C_Tmttknsyuruikbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tmttknsyuruikbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tmttknsyuruikbn.class, patternId, value);
    }
}
