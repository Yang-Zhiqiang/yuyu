package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SyosaiKbn;

/**
 * 新契約 新契約共通 訂正履歴情報登録RgstrHoujyouインタフェース
 */
public interface TsRrkInfoTourokuRgstrHoujyouUiBeanParam {

    String getMosno();

    C_SyosaiKbn getSyosaikbn();

    BizDate getKktymd();

    Integer getSintyou();

    Integer getTaijyuu();

    C_SinsaKbn getSinsakbn();

    BizDate getSinsaymd();

    String getHbcmnt();
}