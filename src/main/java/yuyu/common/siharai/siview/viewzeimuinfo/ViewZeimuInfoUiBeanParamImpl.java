package yuyu.common.siharai.siview.viewzeimuinfo;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ZeitratkiKbn;

/**
 * 保険金給付金支払 支払画面部品 税務情報クラス <br />
 */
public class ViewZeimuInfoUiBeanParamImpl implements ViewZeimuInfoUiBeanParam{

    private C_ZeitratkiKbn zeitratkikbn;

    private BizCurrency goukeihituyoukeihi;

    private int kykhnkkaisuu;

    private BizCurrency shrkykhtykeihi;

    private boolean viewZeimuInfoSeigyo;

    private boolean viewZeimuInfoDispFlg;

    @Override
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    @Override
    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    @Override
    public BizCurrency getGoukeihituyoukeihi() {
        return goukeihituyoukeihi;
    }

    @Override
    public void setGoukeihituyoukeihi(BizCurrency pGoukeihituyoukeihi) {
        goukeihituyoukeihi = pGoukeihituyoukeihi;
    }

    @Override
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    @Override
    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    @Override
    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    @Override
    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
    }

    @Override
    public boolean isViewZeimuInfoSeigyo() {
        return viewZeimuInfoSeigyo;
    }

    @Override
    public boolean isViewZeimuInfoDispFlg() {
        return viewZeimuInfoDispFlg;
    }

}
