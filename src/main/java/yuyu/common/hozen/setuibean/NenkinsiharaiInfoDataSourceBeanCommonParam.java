package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * 契約保全 UiBean設定 別契約情報設定
 */
public interface NenkinsiharaiInfoDataSourceBeanCommonParam {

    public String getVbtkkdispbtkyknksysyno();

    public void setVbtkkdispbtkyknksysyno(String pVbtkkdispbtkyknksysyno);

    public BizDate getVbtkkdispbtkyknkshrsymd();

    public void setVbtkkdispbtkyknkshrsymd(BizDate pVbtkkdispbtkyknkshrsymd);

    public C_NkSyoumetuCd getVbtkkdispbtkyknksymtjiyuu();

    public void setVbtkkdispbtkyknksymtjiyuu(C_NkSyoumetuCd pVbtkkdispbtkyknksymtjiyuu);

    public BizDate getVbtkkdispbtkyknksymtymd();

    public void setVbtkkdispbtkyknksymtymd(BizDate pVbtkkdispbtkyknksymtymd);


}
