package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 契約保全共通パラメータUiBeanパラメータ（払方変更）
 */
public interface KhozenCommonParamKhHaraikataHenkouUiBeanParam {

    C_UmuKbn getHrkkeirohnkumu();

    C_UmuKbn getHrkkaisuuhnkumu();

    C_Hrkkeiro getNewhrkkeiro();
}