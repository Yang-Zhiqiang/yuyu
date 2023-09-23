package yuyu.common.siharai.siview.viewsateikekka;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金支払 支払画面部品 査定結果 クラス <br />
 */
public class ViewSateiKekkaUiBeanParamImpl implements ViewSateiKekkaUiBeanParam{

    private C_SyorikekkaKbn sateisyorikekkakbn;

    private String sateitennousakisousasyacd;

    private BizDate kaiketuymd;

    private String sateisyanaicomment;

    private boolean viewSateiKekkaSeigyo;

    private boolean viewSateiKekkaDispFlg;

    private boolean sessyouInputHanteiFlg;

    private boolean syouninInputHanteiFlg;

    private boolean kaiketuInputHanteiFlg;
    @Override
    public C_SyorikekkaKbn getSateisyorikekkakbn() {
        return sateisyorikekkakbn;
    }

    @Override
    public void setSateisyorikekkakbn(C_SyorikekkaKbn pSateisyorikekkakbn) {
        sateisyorikekkakbn = pSateisyorikekkakbn;
    }

    @Override
    public String getSateitennousakisousasyacd() {
        return sateitennousakisousasyacd;
    }

    @Override
    public void setSateitennousakisousasyacd(String pSateitennousakisousasyacd) {
        sateitennousakisousasyacd = pSateitennousakisousasyacd;
    }

    @Override
    public BizDate getKaiketuymd() {
        return kaiketuymd;
    }

    @Override
    public void setKaiketuymd(BizDate pKaiketuymd) {
        kaiketuymd = pKaiketuymd;
    }

    @Override
    public String getSateisyanaicomment() {
        return sateisyanaicomment;
    }

    @Override
    public void setSateisyanaicomment(String pSateisyanaicomment) {
        sateisyanaicomment = pSateisyanaicomment;
    }

    @Override
    public boolean isViewSateiKekkaSeigyo() {
        return viewSateiKekkaSeigyo;
    }

    @Override
    public boolean isViewSateiKekkaDispFlg() {
        return viewSateiKekkaDispFlg;
    }

    @Override
    public boolean isSyouninInputHanteiFlg() {
        return syouninInputHanteiFlg;
    }

    @Override
    public boolean isSessyouInputHanteiFlg() {
        return sessyouInputHanteiFlg;
    }

    @Override
    public boolean isKaiketuInputHanteiFlg() {
        return kaiketuInputHanteiFlg;
    }
}
