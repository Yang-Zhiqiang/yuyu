package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * 契約保全 UiBean設定 別契約（年金支払契約）  のデータソースのデータ
 */
public class NenkinsiharaiInfoDataSourceBeanCommonParamImpl implements NenkinsiharaiInfoDataSourceBeanCommonParam {

    private String vbtkkdispbtkyknksysyno;

    @Override
    public String getVbtkkdispbtkyknksysyno() {
        return vbtkkdispbtkyknksysyno;
    }

    @Override
    public void setVbtkkdispbtkyknksysyno(String pVbtkkdispbtkyknksysyno) {
        vbtkkdispbtkyknksysyno = pVbtkkdispbtkyknksysyno;
    }


    private BizDate vbtkkdispbtkyknkshrsymd;

    @Override
    public BizDate getVbtkkdispbtkyknkshrsymd() {
        return vbtkkdispbtkyknkshrsymd;
    }

    @Override
    public void setVbtkkdispbtkyknkshrsymd(BizDate pVbtkkdispbtkyknkshrsymd) {
        vbtkkdispbtkyknkshrsymd = pVbtkkdispbtkyknkshrsymd;
    }


    private C_NkSyoumetuCd vbtkkdispbtkyknksymtjiyuu;

    @Override
    public C_NkSyoumetuCd getVbtkkdispbtkyknksymtjiyuu() {
        return vbtkkdispbtkyknksymtjiyuu;
    }

    @Override
    public void setVbtkkdispbtkyknksymtjiyuu(C_NkSyoumetuCd pVbtkkdispbtkyknksymtjiyuu) {
        vbtkkdispbtkyknksymtjiyuu = pVbtkkdispbtkyknksymtjiyuu;
    }


    private BizDate vbtkkdispbtkyknksymtymd;

    @Override
    public BizDate getVbtkkdispbtkyknksymtymd() {
        return vbtkkdispbtkyknksymtymd;
    }

    @Override
    public void setVbtkkdispbtkyknksymtymd(BizDate pVbtkkdispbtkyknksymtymd) {
        vbtkkdispbtkyknksymtymd = pVbtkkdispbtkyknksymtymd;
    }
}
