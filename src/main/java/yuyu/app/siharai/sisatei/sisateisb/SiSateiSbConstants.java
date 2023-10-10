package yuyu.app.siharai.sisatei.sisateisb;

import java.util.HashMap;
import java.util.Map;

import yuyu.def.classification.C_SikinouModeIdKbn;
/**
 * （死亡）査定 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SiSateiSbConstants extends GenSiSateiSbConstants {

    static final int GROUP_WARNING_MESSAGE_ONE = 5;

    static final int GROUP_WARNING_MESSAGE_TWO = 10;

    public static final int MAX_ROW_COUNT = 10;

    public static final String FULL_SPACE = "　";

    @SuppressWarnings("serial")
    public static final Map<String,String[]> KAKUNIN_KOUMOKU_MAP  = new HashMap<String, String[]>() {

        {
            put(C_SikinouModeIdKbn.SATEI2.getValue() , new String[] {C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.SATEI3.getValue() , new String[] {C_SikinouModeIdKbn.SATEI2.getContent(),
                C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.SATEI4.getValue() , new String[] {C_SikinouModeIdKbn.SATEI3.getContent(),
                C_SikinouModeIdKbn.SATEI2.getContent(),C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.SESSYOU1.getValue() , new String[] {C_SikinouModeIdKbn.SATEI4.getContent(),
                C_SikinouModeIdKbn.SATEI3.getContent(),C_SikinouModeIdKbn.SATEI2.getContent(),C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.SESSYOU2.getValue() , new String[] {C_SikinouModeIdKbn.SESSYOU1.getContent(),
                C_SikinouModeIdKbn.SATEI4.getContent(),C_SikinouModeIdKbn.SATEI3.getContent(),C_SikinouModeIdKbn.SATEI2.getContent(),
                C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue() , new String[] {C_SikinouModeIdKbn.SESSYOU2.getContent(),
                C_SikinouModeIdKbn.SESSYOU1.getContent(), C_SikinouModeIdKbn.SATEI4.getContent(),C_SikinouModeIdKbn.SATEI3.getContent(),
                C_SikinouModeIdKbn.SATEI2.getContent(),C_SikinouModeIdKbn.SATEI1.getContent()});
        }

        {
            put(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue() , new String[] {C_SikinouModeIdKbn.SATEI4.getContent(),
                C_SikinouModeIdKbn.SATEI3.getContent(),C_SikinouModeIdKbn.SATEI2.getContent(),C_SikinouModeIdKbn.SATEI1.getContent()});
        }

    };
}
