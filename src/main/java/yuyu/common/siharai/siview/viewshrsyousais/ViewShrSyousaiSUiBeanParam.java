package yuyu.common.siharai.siview.viewshrsyousais;

import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 支払詳細表示（保険金） <br />
 */
public interface ViewShrSyousaiSUiBeanParam extends CommonViewUiBeanParam{

    public DataSource<?> getHktshrMeisaisInfoDataSource();

    public boolean isViewShrSyousaiSSeigyo();

    public boolean isViewShrSyousaiSDispFlg();
}
