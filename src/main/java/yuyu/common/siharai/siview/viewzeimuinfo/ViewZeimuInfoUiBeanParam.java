package yuyu.common.siharai.siview.viewzeimuinfo;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_ZeitratkiKbn;

/**
 * 保険金給付金支払 支払画面部品 税務情報 <br />
 */
public interface ViewZeimuInfoUiBeanParam extends CommonViewUiBeanParam {

    public C_ZeitratkiKbn getZeitratkikbn();

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn);

    public BizCurrency getGoukeihituyoukeihi();

    public void setGoukeihituyoukeihi(BizCurrency pGoukeihituyoukeihi);

    public Integer getKykhnkkaisuu();

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu);

    public BizCurrency getShrkykhtykeihi();

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi);

    public boolean isViewZeimuInfoSeigyo();

    public boolean isViewZeimuInfoDispFlg();
}
