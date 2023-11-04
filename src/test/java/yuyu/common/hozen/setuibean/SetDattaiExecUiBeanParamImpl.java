package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 脱退情報設定UiBean
 */
public class SetDattaiExecUiBeanParamImpl implements SetDattaiExecUiBeanParam{

    private String syono;

    private C_UmuKbn vdtumukbn;

    private BizDate vdtdattaisyoriymd;

    private C_DattairiyuuKbn vdtdattairiyuukbn;

    private String vdtcomment;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public C_UmuKbn getVdtumukbn() {
        return vdtumukbn;
    }

    @Override
    public void setVdtumukbn(C_UmuKbn pVdtumukbn) {
        this.vdtumukbn = pVdtumukbn;
    }

    public BizDate getVdtdattaisyoriymd() {
        return vdtdattaisyoriymd;
    }

    @Override
    public void setVdtdattaisyoriymd(BizDate vdtdattaisyoriymd) {
        this.vdtdattaisyoriymd = vdtdattaisyoriymd;
    }

    public C_DattairiyuuKbn getVdtdattairiyuukbn() {
        return vdtdattairiyuukbn;
    }

    @Override
    public void setVdtdattairiyuukbn(C_DattairiyuuKbn vdtdattairiyuukbn) {
        this.vdtdattairiyuukbn = vdtdattairiyuukbn;
    }

    public String getVdtcomment() {
        return vdtcomment;
    }

    @Override
    public void setVdtcomment(String vdtcomment) {
        this.vdtcomment = vdtcomment;
    }
}
