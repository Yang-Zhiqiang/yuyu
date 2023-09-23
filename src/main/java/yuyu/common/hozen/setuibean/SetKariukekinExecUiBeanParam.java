package yuyu.common.hozen.setuibean;

import java.util.List;

/**
 * 契約保全 UiBean設定 仮受金情報設定UiBeanパラメータインターフェース
 */
public interface SetKariukekinExecUiBeanParam {

    String getSyono();

    KariukekinInfoDataSourceBeanCommonParam createKariukekinInfoDataSourceBean();

    void convertKariukekinInfoForCommonParam(List<KariukekinInfoDataSourceBeanCommonParam> pKariukekinInfo);
}
