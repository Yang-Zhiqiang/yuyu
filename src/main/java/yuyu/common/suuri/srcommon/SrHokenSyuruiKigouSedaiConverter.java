package yuyu.common.suuri.srcommon;

import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;

/**
 * 数理統計 数理共通 保険種類記号世代区分変換
 * @version 2017/11/29 杉山：新規作成
 */
public class SrHokenSyuruiKigouSedaiConverter {

    public String convert(String pHokenSyuruiKigouSedaiKbn) {
        if (C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue().equals(pHokenSyuruiKigouSedaiKbn)) {
            return C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue();
        }

        return pHokenSyuruiKigouSedaiKbn;
    }
}
