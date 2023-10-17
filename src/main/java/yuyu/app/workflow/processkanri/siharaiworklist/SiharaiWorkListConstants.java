package yuyu.app.workflow.processkanri.siharaiworklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 保険金給付金支払工程ワークリスト の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SiharaiWorkListConstants extends GenSiharaiWorkListConstants {
    public static final String BLANK = "";

    public static final String NYUURYOKU_LINK = "入力";

    public static final String ITIRAN_LINK = "一覧";

    public static final String KOJIN = "0";

    public static final String KYOYO = "1";

    public static final String SIHARAI = "siharai";

    @SuppressWarnings("serial")
    public static final Map<String, String> SIHARAI_KINOUIDMAP = new HashMap<String, String>() {

        {
            put("sisibouinput", SiharaiWorkListConstants.FORWARDNAME_GOTOSISEIKYUUUKETUKESB);
        }
        {
            put("sisiboutenken", SiharaiWorkListConstants.FORWARDNAME_GOTOSISEIKYUUUKETUKESB);
        }
        {
            put("sisiboutetuduki_sateihuyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousyounin_sateihuyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousatei1", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousatei2", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousatei3", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousatei4", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisiboutetuduki_sateiyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousyounin_sateiyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousessyou1", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibousessyou2", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisiboukaiketu_sessyouhuyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisiboukaiketu_sessyouyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisiboukakuniniraityuu", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sisibouhubikanrityuu", SiharaiWorkListConstants.FORWARDNAME_GOTOSISATEISB);
        }
        {
            put("sihubisibouhubitouroku", SiharaiWorkListConstants.FORWARDNAME_GOTOSIHUBITOUROKU);
        }
        {
            put("sihubisibouhubisyounin", SiharaiWorkListConstants.FORWARDNAME_GOTOSIHUBITOUROKU);
        }
        {
            put("sihubisibouhubikaitoumati", SiharaiWorkListConstants.FORWARDNAME_GOTOSIHUBIKAISYOU);
        }
        {
            put("sihubisibouhubikaisyou", SiharaiWorkListConstants.FORWARDNAME_GOTOSIHUBIKAISYOU);
        }
        {
            put("sisindansyoryouinput", SiharaiWorkListConstants.FORWARDNAME_GOTOSISINDANSYORYOUSIHARAI);
        }
        {
            put("sisindansyoryoutenken", SiharaiWorkListConstants.FORWARDNAME_GOTOSISINDANSYORYOUSIHARAI);
        }

    };
}
