package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 脱退情報設定UiBeanパラメータ
 */
public interface SetDattaiExecUiBeanParam {

    String getSyono();

    public void setVdtumukbn(C_UmuKbn pVdtumukbn);

    public void setVdtdattaisyoriymd(BizDate pVdtdattaisyoriymd);

    public void setVdtdattairiyuukbn(C_DattairiyuuKbn pVdtdattairiyuukbn);

    public void setVdtcomment(String pVdtcomment);
}
