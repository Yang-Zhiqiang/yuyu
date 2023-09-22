package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 新契約共通 申込書入力画面共通制御設定
 */
public class SetMosGamenctrl {

    private static final String[][] DAI1_HKNKKN_SELECT = {{ "0", "" }, { "5", "5" }, { "10", "10" }};

    private static final String[][] DAI1_HKNKKN_SELECT2 = {{ "2", "2" }};

    private static final String[][] DAI1_HKNKKN_SELECT3 = {{ "5", "5" }};

    private static final String[][] TARGET_MOKUHYOU_SYUSIN = {{ "0", "" }, { "110", "１１０％" }, { "120", "１２０％" },
        { "130", "１３０％" }, { "140", "１４０％" }, { "150", "１５０％" }, { "160", "１６０％" }, { "170", "１７０％" }
        , { "180", "１８０％" }, { "190", "１９０％" }, { "200", "２００％" }, { "999", "設定しない" }};

    private static final String[][] TARGET_MOKUHYOU_NENKIN = {{ "0", "" }, { "105", "１０５％" }, { "110", "１１０％" },
        { "120", "１２０％" }, { "130", "１３０％" }, { "140", "１４０％" }, { "150", "１５０％" }, { "160", "１６０％" },
        { "170", "１７０％" }, { "180", "１８０％" }, { "190", "１９０％" }, { "200", "２００％" }, { "999", "設定しない" }};

    private static final String[][] NENKIN_SYU_SELECT = {{ "0", "" }, { "1", "５年確定" }, { "2", "１０年確定" },
        { "3", "１５年確定" }, { "8", "年金総額保証付終身" }};

    private static final String[][] SUEO_KIKKN_SELECT = {{ "0", "" }, { "5", "５年" }, { "10", "１０年" }};

    private static final String[][] NENKIN_SYU_SELECT_A = {{ "0", "" }, { "1", "５年確定" }, { "2", "１０年確定" },
        { "3", "１５年確定" }, { "A", "５年確定（第１回年金倍額型）" }};

    private static final String[][] HRK_TUUKA_SELECT = { { "0", "" }, { "JPY", "円" }, { "USD", "米ドル" },
        { "AUD", "豪ドル" } };

    private static final String[][] HRK_TUUKA_SELECT2 = { { "0", "" }, { "JPY", "円" }, { "USD", "米ドル" } };

    private static final String[][] HRK_TUUKA_SELECT_JPY = { { "JPY", "円" } };

    private static final String[][] HRK_KEIRO_SELECT = { { "1", "口座振替" }, { "4", "振替" } };

    private static final String[][] KYK_TUUKASYU_SELECT1 = { { "USD", "米ドル" } };

    private static final String[][] KYK_TUUKASYU_SELECT2 = { { "0", "" }, { "USD", "米ドル" }, { "AUD", "豪ドル" } };

    private static final String[][] KYK_TUUKASYU_SELECT3 =  { { "JPY", "円" } };

    private static final String[][] KYK_TUUKASYU_2_SELECT = { { "AUD", "豪ドル" } };

    private static final String[][] HRKKAISUU_SELECT = { { "1", "月払" } };

    private static final String[][] HRKKAISUU_SELECT2 = { { "0", "" }, { "1", "月払" }, { "6", "年２回払" }, { "12", "年１回払" } };

    private static final String[][] IKKATUBARAIKAISU_SELECT = { { "0", "" }, { "6", "６か月定期一括払" }, { "12", "１２か月定期一括払" } };

    private static final String[][] ZENKIZENNOU_SELECT = { { "1", "あり" }, { "2", "なし" } };

    @Inject
    private static Logger logger;

    public SetMosGamenctrl() {
        super();
    }

    public UserDefsList getDai1HknkknSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 第１保険期間選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();


        if(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(DAI1_HKNKKN_SELECT));
        }

        else if(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(DAI1_HKNKKN_SELECT2));
        }

        else if(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(DAI1_HKNKKN_SELECT3));
        }

        logger.debug("△ 第１保険期間選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getTargettkmkhtSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ ターゲット目標値選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(TARGET_MOKUHYOU_SYUSIN));
        }

        else if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(TARGET_MOKUHYOU_NENKIN));
        }
        logger.debug("△ ターゲット目標値選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getNenkinsyuSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 年金種類選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(NENKIN_SYU_SELECT));
        }
        else if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(NENKIN_SYU_SELECT_A));
        }
        logger.debug("△ 年金種類選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getSueokikknSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 据置期間選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(SUEO_KIKKN_SELECT));
        }
        logger.debug("△ 据置期間選択肢取得処理 終了");
        return list;
    }

    public C_HknkknsmnKbn getHknkknsmnKbn(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 保険期間歳満期区分取得処理 開始");
        C_HknkknsmnKbn hknKknsmnKbn = C_HknkknsmnKbn.BLNK;

        if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            hknKknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        }
        else if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            hknKknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        }
        logger.debug("△ 保険期間歳満期区分取得処理 終了");
        return hknKknsmnKbn;
    }

    public UserDefsList getHrktuukasyuSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 払込通貨選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKAINDEXNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(HRK_TUUKA_SELECT));
        }
        else if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ) {
            list.addAll(convertUserDefsList(HRK_TUUKA_SELECT_JPY));
        }
        else if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(HRK_TUUKA_SELECT2));
        }
        logger.debug("△ 払込通貨選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getHrkkeiroSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 払込経路選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(HRK_KEIRO_SELECT));
        }
        logger.debug("△ 払込経路選択肢取得処理 終了");
        return list;
    }

    public C_HrkkknsmnKbn getHrkkknsmnKbn(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 払込期間歳満期区分取得処理 開始");
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;

        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;
        }

        logger.debug("△ 払込期間歳満期区分取得処理 終了");
        return hrkkknsmnKbn;
    }

    public C_UmuKbn getMos2hyoujiumuKbn(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 申込２表示有無区分取得処理 開始");
        C_UmuKbn mos2hyoujiumuKbn = C_UmuKbn.NONE;

        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) &&
            C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getMos2hyoujiumuKbn())) {
            mos2hyoujiumuKbn = C_UmuKbn.ARI;
        }

        logger.debug("△ 申込２表示有無区分取得処理 終了");
        return mos2hyoujiumuKbn;
    }

    public UserDefsList getKyktuukasyuSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 契約通貨種類選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) &&
            C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getMos2hyoujiumuKbn())) {
            list.addAll(convertUserDefsList(KYK_TUUKASYU_SELECT1));
        }
        else if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(KYK_TUUKASYU_SELECT3));
        }
        else if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(KYK_TUUKASYU_SELECT1));
        }
        else {
            list.addAll(convertUserDefsList(KYK_TUUKASYU_SELECT2));
        }
        logger.debug("△ 契約通貨種類選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getKyktuukasyu2Select(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 契約通貨種類＿２選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(KYK_TUUKASYU_2_SELECT));
        }
        logger.debug("△ 契約通貨種類＿２選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getHrkkaisuuSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 払込回数選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(HRKKAISUU_SELECT));
        }
        else if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(HRKKAISUU_SELECT2));
        }
        logger.debug("△ 払込回数選択肢取得処理 終了");
        return list;
    }

    public UserDefsList getIkkatubaraikaisuuSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 一括払回数選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(IKKATUBARAIKAISU_SELECT));
        }
        logger.debug("△ 一括払回数選択肢取得処理 終了");
        return list;
    }


    public UserDefsList getZenkizennouSelect(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        logger.debug("▽ 全期前納選択肢取得処理 開始");
        UserDefsList list = new UserDefsList();
        if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(pGetSyouhnZokuseiCtrlOutBean.getHknsyuruino())) {
            list.addAll(convertUserDefsList(ZENKIZENNOU_SELECT));
        }
        logger.debug("△ 全期前納選択肢取得処理 終了");
        return list;
    }


    private UserDefsList convertUserDefsList(String[][] pArrayStr) {
        UserDefsList list = new UserDefsList();
        for (int i = 0; i < pArrayStr.length; i++) {
            LabelValuePair pair = new LabelValuePair();
            pair.setValue(pArrayStr[i][0]);
            pair.setLabel(pArrayStr[i][1]);
            list.add(pair);
        }
        return list;
    }
}