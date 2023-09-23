package yuyu.common.siharai.kyk;

import java.util.List;

import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 契約情報取得 契約情報
 */
public interface KeiyakuInfo {

    void getInfos(KeiyakuPrm pKp);

    List<JT_SiKykKihon> getKykKihons();
}
