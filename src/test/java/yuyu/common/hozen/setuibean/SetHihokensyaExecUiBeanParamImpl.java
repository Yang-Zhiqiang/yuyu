package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;

/**
 * 契約保全 UiBean設定 被保険者情報設定UiBean
 */
public class SetHihokensyaExecUiBeanParamImpl implements SetHihokensyaExecUiBeanParam{

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private String vhhkshhknnmkn;

    public String getVhhkshhknnmkn() {
        return vhhkshhknnmkn;
    }

    @Override
    public void setVhhkshhknnmkn(String pVhhkshhknnmkn) {
        this.vhhkshhknnmkn = pVhhkshhknnmkn;
    }

    private String vhhkshhknnmkj;

    public String getVhhkshhknnmkj() {
        return vhhkshhknnmkj;
    }

    @Override
    public void setVhhkshhknnmkj(String pVhhkshhknnmkj) {
        this.vhhkshhknnmkj = pVhhkshhknnmkj;
    }

    private C_KjkhukaKbn vhhkshhknnmkjkhukakbn;

    public C_KjkhukaKbn getVhhkshhknnmkjkhukakbn() {
        return vhhkshhknnmkjkhukakbn;
    }

    @Override
    public void setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn pVhhkshhknnmkjkhukakbn) {
        this.vhhkshhknnmkjkhukakbn = pVhhkshhknnmkjkhukakbn;
    }

    private BizDate vhhkshhknseiymd;

    public BizDate getVhhkshhknseiymd() {
        return vhhkshhknseiymd;
    }

    @Override
    public void setVhhkshhknseiymd(BizDate pVhhkshhknseiymd) {
        this.vhhkshhknseiymd = pVhhkshhknseiymd;
    }

    private C_Hhknsei vhhkshhknsei;

    public C_Hhknsei getVhhkshhknsei() {
        return vhhkshhknsei;
    }

    @Override
    public void setVhhkshhknsei(C_Hhknsei pVhhkshhknsei) {
        this.vhhkshhknsei = pVhhkshhknsei;
    }

}
