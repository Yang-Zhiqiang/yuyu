package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払情報設定Paramインターフェースと支払査定設定Paramインターフェース実現クラス
 */
public class CommonViewUiBeanParamImpl7 implements ViewSiharaiInfoUiBeanParam, ViewSiharaiSateiUiBeanParam, ViewSkKihonUiBeanParam {

    private C_Tuukasyu shrtuukasyu;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private BizDate dispsyoruiukeymd;

    private BizDate disphubikanryouymd;

    private BizDate shrymd;

    private C_SinsaGendoKknKbn dispsinsagendokknkbn;

    private Integer disprkktydnnissuu;

    private boolean viewSiharaiInfoDispHantei;

    private boolean viewSiharaiInfoSeigyo;

    private boolean viewSiharaiInfoDispFlg;

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

    private String syono;

    private String syoukaibtn;

    private String skno;

    private String kouteikanriid;

    private boolean viewSkKihonSeigyo;

    private boolean viewSkKihonDispFlg;

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
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    @Override
    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    @Override
    public String getSkno() {
        return skno;
    }

    @Override
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    @Override
    public String getKouteikanriid() {
        return kouteikanriid;
    }

    @Override
    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Override
    public boolean isViewSkKihonSeigyo() {
        return viewSkKihonSeigyo;
    }

    @Override
    public boolean isViewSkKihonDispFlg() {
        return viewSkKihonDispFlg;
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

    @Override
    public boolean isViewSiharaiInfoYenknsnKijyunYmdFlg() {
        return false;
    }

    @Override
    public BizDate getGaikaknsnkwsratekjymd() {
        return null;
    }

    @Override
    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {

    }

    @Override
    public BizNumber getGaikaknsnkwsrate() {
        return null;
    }

    @Override
    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {

    }

    @Override
    public boolean isViewSiharaiInfoGaikaknsnKijyunYmdFlg() {
        return false;
    }
}
