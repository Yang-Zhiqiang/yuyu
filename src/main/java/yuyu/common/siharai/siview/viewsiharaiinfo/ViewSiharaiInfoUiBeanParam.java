package yuyu.common.siharai.siview.viewsiharaiinfo;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 支払画面部品 支払情報 <br />
 */
public interface ViewSiharaiInfoUiBeanParam extends CommonViewUiBeanParam {

    public C_Tuukasyu getShrtuukasyu();

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu);

    public BizDate getShrkwsratekjnymd();

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd);

    public BizNumber getShrkwsrate();

    public void setShrkwsrate(BizNumber pShrkwsrate);

    public BizDate getGaikaknsnkwsratekjymd();

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd);

    public BizNumber getGaikaknsnkwsrate();

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate);

    public BizDate getDispsyoruiukeymd();

    public void setDispsyoruiukeymd(BizDate pDispsyoruiukeymd);

    public BizDate getDisphubikanryouymd();

    public void setDisphubikanryouymd(BizDate pDisphubikanryouymd);

    public BizDate getShrymd();

    public void setShrymd(BizDate pShrymd);

    public C_SinsaGendoKknKbn getDispsinsagendokknkbn();

    public void setDispsinsagendokknkbn(C_SinsaGendoKknKbn pDispsinsagendokknkbn);

    public Integer getDisprkktydnnissuu();

    public void setDisprkktydnnissuu(Integer pDisprkktydnnissuu);

    public boolean isViewSiharaiInfoDispHantei();

    public boolean isViewSiharaiInfoSeigyo();

    public boolean isViewSiharaiInfoDispFlg();

    public boolean isViewSiharaiInfoYenknsnKijyunYmdFlg();

    public boolean isViewSiharaiInfoGaikaknsnKijyunYmdFlg();
}
