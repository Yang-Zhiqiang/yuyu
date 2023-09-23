package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 契約保全共通パラメータUiBeanパラメータ（名義変更）
 */
public interface KhozenCommonParamKhMeigiHenkouUiBeanParam {

    C_Meigihnkjiyuu getMeigihnkjiyuu();

    C_Hrkkaisuu getHrkkaisuu();

    C_UmuKbn getDaisennintdkumukbn();
}