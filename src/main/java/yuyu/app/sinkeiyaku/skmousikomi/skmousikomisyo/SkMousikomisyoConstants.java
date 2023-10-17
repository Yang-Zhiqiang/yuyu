package yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * 申込書入力 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkMousikomisyoConstants extends GenSkMousikomisyoConstants {

    public static final int MAX_TOKUYAKU = 10;
    public static final int MAX_UKT_SIBOU = 4;
    public static final int MAX_DAIRITEN = 2;
    public static final BizNumber BUNWARI_100 = BizNumber.valueOf(100);

    public static final int UKTSYURENNO_BEGIN = 1;
    public static final BizNumber UKTBNWARI_100 = BizNumber.valueOf(100);

    public static final String AJAX_POST_EVENTHANDLER_COMMON = "_eventHandler=callAjaxCommon";

    public static final String AJAX_POST_PARAM_SYORIKBN = "ajaxSyoriKbn";
    public static final String AJAX_POST_PARAM_POSTALCD = "ajaxPostalCd";
    public static final String AJAX_POST_PARAM_HKNSYURUINO = "ajaxHknsyuruiNo";
    public static final String AJAX_POST_PARAM_HKNSYURUINOSD = "ajaxHknsyuruiNoSd";
    public static final String AJAX_POST_PARAM_SKEIJIMUKBN = "ajaxSkeiJimuKbn";
    public static final String AJAX_POST_PARAM_SYOKUGYOUCD = "ajaxSyokugyouCd";
    public static final String AJAX_POST_PARAM_TUUKASYU = "ajaxTuukasyu";
    public static final String AJAX_POST_PARAM_TUUKAHENKANKM = "ajaxTuukaHenkanKoumokuMei";
    public static final String AJAX_POST_PARAM_SYOUHNCD = "ajaxSyouhncd";
    public static final String AJAX_POST_PARAM_SWAK_CID = "\"swak-cid\"";

    public static final String AJAX_POST_SYORIKBN_ADDRESSSRCH = "ajaxAddressSrch";
    public static final String AJAX_POST_SYORIKBN_AISYOUMEISET = "ajaxAisyoumeiSet";
    public static final String AJAX_POST_SYORIKBN_SYOKUGYOUMEISET = "ajaxSyokugyoumeiSet";

    public static final String AJAX_POST_SYORIKBN_CURRENCYCHANGE = "ajaxCurrencyChange";
    public static final String AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS = "ajaxSyukihons";

    public static final String AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI = "ajaxHrktuukasyukykpBei";
    public static final String AJAX_POST_SYORIKBN_MOSIKKATUP_BEI = "ajaxMosikkatupBei";
    public static final String AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI = "ajaxMossyukykpBei";
    public static final String AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI = "ajaxMoszennoupsyokaiariBei";
    public static final String AJAX_POST_PARAM_HRKTUUKASYUKYKP = "ajaxHrktuukasyukykp";
    public static final String AJAX_POST_PARAM_MOSIKKATUP = "ajaxmosikkatup";
    public static final String AJAX_POST_PARAM_MOSSYUKYKP = "ajaxMossyukykp";
    public static final String AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI = "ajaxMoszennoupsyokaiari";

    public static final String AJAX_POST_SYORIKBN_CURRENCYCHANGE_GOU = "ajaxCurrencyChangeGou";
    public static final String AJAX_POST_TUUKAHENKANKMNM_KIHONS2 = "ajaxKihons2";

    public static final String AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_GOU = "ajaxHrktuukasyukykpGou";
    public static final String AJAX_POST_SYORIKBN_MOSIKKATUP_GOU = "ajaxMosikkatupGou";
    public static final String AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_GOU = "ajaxMoszennoupsyokaiariGou";
    public static final String AJAX_POST_PARAM_HRKTUUKASYUKYKPM2 = "ajaxHrktuukasyukykp2";
    public static final String AJAX_POST_PARAM_MOSIKKATUP2 = "ajaxmosikkatup2";
    public static final String AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI2 = "ajaxMoszennoupsyokaiari2";

    static final String FORWARDNAME_NESTEDEND  = "nestedEnd";

    static final String TUUSINSAKIINFO_TSINADRKJ  = "通信先住所（漢字）";

    static final String HIHOKENSYAINFO_HHKNADRKJ  = "被保険者住所（漢字）";

    public static enum E_SyoriKbn {
        MOUSIKOMISYO_1JI,

        MOUSIKOMISYO_2JI,

        MOUSIKOMISYO_3JI,

        SYORI_UPD,

        SYORI_UPD_SYOUKAI,

        SYORI_INPUT_UPD
    }

    public static enum E_InsUpdKbn {
        INSUPDCTRL_INS,

        INSUPDCTRL_UPD
    }

    public static enum E_TuukasyuKbn {
        USD,

        AUD
    }

    public static final BizCurrency MAX_KYOYOUKINGAKUYEN = BizCurrency.valueOf(10000000000L, BizCurrencyTypes.YEN);

    public static final BizCurrency MAX_KYOYOUKINGAKUDOLLAR = BizCurrency.valueOf(1000000000.00, BizCurrencyTypes.DOLLAR);

    public static final BizCurrency MAX_KYOYOUKINGAKUAUDOLLAR = BizCurrency.valueOf(1000000000.00, BizCurrencyTypes.AU_DOLLAR);

    public static final String  DISPHRKKKNTRL = "保険料払込満了年齢";

    public static final String  DISPHKNKKNtRL = "年金支払開始年齢";

    public static final Integer  DISPSEIGENNEN_19 = 19;

    public static final String  ITIBUZENNOUEN  = "一部前納";

    public static final String  PZENKIZENNOU  = "全期前納";

    public static final String KAIGYOU  = "</BR>";

    public static final String HRKKKN  = "払込期間";

    public static final String HKNKKN  = "保険期間";

    public static final String SYUKEIYAKUHOSYOUINFO_BEI = "主契約保障情報（米ドル）　";

    public static final String SYUKEIYAKUHOSYOUINFO_GOU = "主契約保障情報（豪ドル）　";

    public static enum E_CreditCardhnsyuKbn {
        ADD,

        ADD_INPUT_UPD,

        ADD_PAPER_LESS,

        UPD_INPUT_UPD
    }
}