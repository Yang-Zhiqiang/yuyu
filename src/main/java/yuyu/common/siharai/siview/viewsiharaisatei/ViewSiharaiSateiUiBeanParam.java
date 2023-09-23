package yuyu.common.siharai.siview.viewsiharaisatei;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 支払画面部品 支払査定 <br />
 */
public interface ViewSiharaiSateiUiBeanParam extends CommonViewUiBeanParam {

    public String getHokenkinsyurui();

    public void setHokenkinsyurui(String pHokenkinsyurui);

    public C_SyorikekkaKbn getSyorikekkakbn();

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn);

    public String getTennousakisousasyacd();

    public void setTennousakisousasyacd(String pTennousakisousasyacd);

    public C_HushrGeninKbn getHushrgeninkbn();

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn);

    public C_YouhiblnkKbn getSessyouyhkbn();

    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn);

    public String getSessyousisyacd();

    public void setSessyousisyacd(String pSessyousisyacd);

    public String getSisyanm();

    public void setSisyanm(String pSisyanm);

    public C_SinsaGendoKknKbn getSinsagendokknkbn();

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn);

    public Integer getRikoukityuutuudannissuu();

    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu);


    public C_BlnktkumuKbn getSaigaimousideumukbn();

    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn);

    public Boolean getSindansyoryoushryouhi();

    public void setSindansyoryoushryouhi(Boolean pSindansyoryoushryouhi);

    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn();

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn);

    public String getSyanaicomment();

    public void setSyanaicomment(String pSyanaicomment);

    public boolean isViewSiharaiSateiInputDispFlg();

    public boolean isViewSiharaiSateiSeigyo();

    public boolean isViewSiharaiSateiDispFlg();

    public boolean isKinouModeSisateiitijiSeigyo();

    public C_SyorikekkaKbn getSatei1Syorikekkakbn();

    public void setSatei1Syorikekkakbn(C_SyorikekkaKbn pSatei1syorikekkakbn);

    public boolean isViewSiharaiSateiHokenkinSyuruiDispFlg();
}
