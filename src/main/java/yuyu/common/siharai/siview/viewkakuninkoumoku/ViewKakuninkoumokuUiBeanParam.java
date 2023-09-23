package yuyu.common.siharai.siview.viewkakuninkoumoku;

import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 確認項目 <br />
 */
public interface ViewKakuninkoumokuUiBeanParam extends CommonViewUiBeanParam {

    public DataSource<?> getViewKakuninkoumokuInfoDataSource();

    public boolean isViewKakuninkoumokuSeigyo();

    public boolean isViewKakuninkoumokuDispFlg();
}
