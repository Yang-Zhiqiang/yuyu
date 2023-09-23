package yuyu.common.siharai.siview.viewsiharaiinfo;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 支払画面部品 支払情報クラス <br />
 */
public class ViewSiharaiInfoUiBeanParamImpl implements ViewSiharaiInfoUiBeanParam{

    private C_Tuukasyu shrtuukasyu;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private BizDate gaikaknsnkwsratekjymd;

    private BizNumber gaikaknsnkwsrate;

    private BizDate dispsyoruiukeymd;

    private BizDate disphubikanryouymd;

    private BizDate shrymd;

    private C_SinsaGendoKknKbn dispsinsagendokknkbn;

    private Integer disprkktydnnissuu;

    private boolean viewSiharaiInfoDispHantei;

    private boolean viewSiharaiInfoSeigyo;

    private boolean viewSiharaiInfoDispFlg;

    private boolean viewSiharaiInfoYenknsnKijyunYmdFlg;

    private boolean viewSiharaiInfoGaikaknsnKijyunYmdFlg;

    @Override
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    @Override
    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    @Override
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    @Override
    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    @Override
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    @Override
    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    @Override
    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    @Override
    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    @Override
    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    @Override
    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    @Override
    public BizDate getDispsyoruiukeymd() {
        return dispsyoruiukeymd;
    }

    @Override
    public void setDispsyoruiukeymd(BizDate pDispsyoruiukeymd) {
        dispsyoruiukeymd = pDispsyoruiukeymd;
    }

    @Override
    public BizDate getDisphubikanryouymd() {
        return disphubikanryouymd;
    }

    @Override
    public void setDisphubikanryouymd(BizDate pDisphubikanryouymd) {
        disphubikanryouymd = pDisphubikanryouymd;
    }

    @Override
    public BizDate getShrymd() {
        return shrymd;
    }

    @Override
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    @Override
    public C_SinsaGendoKknKbn getDispsinsagendokknkbn() {
        return dispsinsagendokknkbn;
    }

    @Override
    public void setDispsinsagendokknkbn(C_SinsaGendoKknKbn pDispsinsagendokknkbn) {
        dispsinsagendokknkbn = pDispsinsagendokknkbn;
    }

    @Override
    public Integer getDisprkktydnnissuu() {
        return disprkktydnnissuu;
    }

    @Override
    public void setDisprkktydnnissuu(Integer pDisprkktydnnissuu) {
        disprkktydnnissuu = pDisprkktydnnissuu;
    }

    @Override
    public boolean isViewSiharaiInfoDispHantei() {
        return viewSiharaiInfoDispHantei;
    }

    @Override
    public boolean isViewSiharaiInfoSeigyo() {
        return viewSiharaiInfoSeigyo;
    }

    @Override
    public boolean isViewSiharaiInfoDispFlg() {
        return viewSiharaiInfoDispFlg;
    }

    @Override
    public boolean isViewSiharaiInfoYenknsnKijyunYmdFlg() {
        return viewSiharaiInfoYenknsnKijyunYmdFlg;
    }

    @Override
    public boolean isViewSiharaiInfoGaikaknsnKijyunYmdFlg() {
        return viewSiharaiInfoGaikaknsnKijyunYmdFlg;
    }
}
