package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 契約保全共通 契約保全共通パラメータUiBeanパラメータ（契約取消）
 */
public interface KhozenCommonParamKhKeiyakuTorikesiUiBeanParam {

    C_KyktrksKbn getKyktrkskbn();

    C_Tdk getKkkyktdk();

    C_YuukousyoumetuKbn getYuukousyoumetukbn();
}