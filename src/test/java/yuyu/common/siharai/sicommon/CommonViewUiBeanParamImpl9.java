package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 重過失チェックParamインターフェース実装クラス
 */
public class CommonViewUiBeanParamImpl9 implements ViewJyuukasituInfoUiBeanParam, ViewSiharaiSateiUiBeanParam {

    private Boolean juukasitucheck1;

    private String juukasitucheckcomment1;

    private Boolean juukasitucheck2;

    private String juukasitucheckcomment2;

    private Boolean juukasitucheck3;

    private String juukasitucheckcomment3;

    private Boolean juukasitucheck4;

    private String juukasitucheckcomment4;

    private String hokenkinsyurui;

    private C_SyorikekkaKbn syorikekkakbn;

    private String tennousakisousasyacd;

    private C_HushrGeninKbn hushrgeninkbn;

    private C_YouhiblnkKbn sessyouyhkbn;

    private String sessyousisyacd;

    private String sisyanm;

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    private Integer rikoukityuutuudannissuu;

    private Boolean sindansyoryoushryouhi;

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    private String syanaicomment;

    private boolean viewSiharaiSateiInputDispFlg;

    private boolean viewSiharaiSateiSeigyo;

    private boolean viewSiharaiSateiDispFlg;

    private boolean kinouModeSisateiSeigyo;

    private C_BlnktkumuKbn saigaimousideumukbn;

    @Override
    public Boolean getJuukasitucheck1() {
        return juukasitucheck1;
    }

    @Override
    public void setJuukasitucheck1(Boolean pJuukasitucheck1) {
        juukasitucheck1 = pJuukasitucheck1;
    }

    @Override
    public String getJuukasitucheckcomment1() {
        return juukasitucheckcomment1;
    }

    @Override
    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1) {
        juukasitucheckcomment1 = pJuukasitucheckcomment1;
    }

    @Override
    public Boolean getJuukasitucheck2() {
        return juukasitucheck2;
    }

    @Override
    public void setJuukasitucheck2(Boolean pJuukasitucheck2) {
        juukasitucheck2 = pJuukasitucheck2;
    }

    @Override
    public String getJuukasitucheckcomment2() {
        return juukasitucheckcomment2;
    }

    @Override
    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2) {
        juukasitucheckcomment2 = pJuukasitucheckcomment2;
    }

    @Override
    public Boolean getJuukasitucheck3() {
        return juukasitucheck3;
    }

    @Override
    public void setJuukasitucheck3(Boolean pJuukasitucheck3) {
        juukasitucheck3 = pJuukasitucheck3;
    }

    @Override
    public String getJuukasitucheckcomment3() {
        return juukasitucheckcomment3;
    }

    @Override
    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3) {
        juukasitucheckcomment3 = pJuukasitucheckcomment3;
    }


    @Override
    public Boolean getJuukasitucheck4() {
        return juukasitucheck4;
    }

    @Override
    public void setJuukasitucheck4(Boolean pJuukasitucheck4) {
        juukasitucheck4 = pJuukasitucheck4;
    }

    @Override
    public String getJuukasitucheckcomment4() {
        return juukasitucheckcomment4;
    }

    @Override
    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4) {
        juukasitucheckcomment4 = pJuukasitucheckcomment4;
    }


    @Override
    public boolean isViewJyuukasituInfoFlg() {
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoDispFlg() {
        return false;
    }
    @Override
    public boolean isViewJyuukasituInfoInputDispFlg(){
        return false;
    }

    @Override
    public String getHokenkinsyurui() {
        return hokenkinsyurui;
    }

    @Override
    public void setHokenkinsyurui(String pHokenkinsyurui) {
        hokenkinsyurui = pHokenkinsyurui;
    }

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    @Override
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    @Override
    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    @Override
    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    @Override
    public C_YouhiblnkKbn getSessyouyhkbn() {
        return sessyouyhkbn;
    }

    @Override
    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn) {
        sessyouyhkbn = pSessyouyhkbn;
    }

    @Override
    public String getSessyousisyacd() {
        return sessyousisyacd;
    }

    @Override
    public void setSessyousisyacd(String pSessyousisyacd) {
        sessyousisyacd = pSessyousisyacd;
    }

    @Override
    public String getSisyanm() {
        return sisyanm;
    }

    @Override
    public void setSisyanm(String pSisyanm) {
        sisyanm = pSisyanm;
    }

    @Override
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    @Override
    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    @Override
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Override
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    @Override
    public Boolean getSindansyoryoushryouhi() {
        return sindansyoryoushryouhi;
    }

    @Override
    public void setSindansyoryoushryouhi(Boolean pSindansyoryoushryouhi) {
        sindansyoryoushryouhi = pSindansyoryoushryouhi;
    }

    @Override
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }

    @Override
    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Override
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }

    @Override
    public boolean isViewSiharaiSateiInputDispFlg() {
        return viewSiharaiSateiInputDispFlg;
    }

    @Override
    public boolean isViewSiharaiSateiSeigyo() {
        return viewSiharaiSateiSeigyo;
    }

    @Override
    public boolean isViewSiharaiSateiDispFlg() {
        return viewSiharaiSateiDispFlg;
    }

    public boolean isKinouModeSisateiSeigyo() {
        return kinouModeSisateiSeigyo;
    }

    @Override
    public boolean isKinouModeSisateiitijiSeigyo() {
        return false;
    }

    @Override
    public C_BlnktkumuKbn getSaigaimousideumukbn() {
        return saigaimousideumukbn;
    }

    @Override
    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn) {
        saigaimousideumukbn = pSaigaimousideumukbn;
    }

    @Override
    public C_SyorikekkaKbn getSatei1Syorikekkakbn() {
        return null;
    }

    @Override
    public void setSatei1Syorikekkakbn(C_SyorikekkaKbn pSatei1syorikekkakbn) {

    }

    @Override
    public boolean isViewSiharaiSateiHokenkinSyuruiDispFlg() {
        return false;
    }
}
