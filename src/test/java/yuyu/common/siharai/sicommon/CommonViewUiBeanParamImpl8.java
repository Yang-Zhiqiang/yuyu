package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.edittbl.SiMeigihenkouSateiParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 名義変更査定Paramインターフェース実現クラス
 */
public class CommonViewUiBeanParamImpl8 implements CommonViewUiBeanParam, SiMeigihenkouSateiParam, ViewSiharaiSateiUiBeanParam, ViewSkKihonUiBeanParam {

    private C_MeihenYuukouMukouKbn meihenyuukoumukoukbn;

    private C_MeihenUktKbn meihenuktkbn;

    private String meihenuktnm;

    @Override
    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn() {
        return meihenyuukoumukoukbn;
    }

    @Override
    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn) {
        meihenyuukoumukoukbn = pMeihenyuukoumukoukbn;
    }

    @Override
    public C_MeihenUktKbn getMeihenuktkbn() {
        return meihenuktkbn;
    }

    @Override
    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn) {
        meihenuktkbn = pMeihenuktkbn;
    }

    @Override
    public String getMeihenuktnm() {
        return meihenuktnm;
    }

    @Override
    public void setMeihenuktnm(String pMeihenuktnm) {
        meihenuktnm = pMeihenuktnm;
    }

    public boolean isAllBlnk() {

        if (C_MeihenYuukouMukouKbn.BLNK.eq(meihenyuukoumukoukbn) &&
            C_MeihenUktKbn.BLNK.eq(meihenuktkbn) &&
            BizUtil.isBlank(meihenuktnm)) {
            return true;
        }
        return false;
    }

    @Override
    public String getHokenkinsyurui() {
        return null;
    }

    @Override
    public void setHokenkinsyurui(String pHokenkinsyurui) {

    }

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return null;
    }

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {

    }

    @Override
    public String getTennousakisousasyacd() {
        return null;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {

    }

    @Override
    public C_HushrGeninKbn getHushrgeninkbn() {
        return null;
    }

    @Override
    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {

    }

    @Override
    public C_YouhiblnkKbn getSessyouyhkbn() {
        return null;
    }

    @Override
    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn) {

    }

    @Override
    public String getSessyousisyacd() {
        return null;
    }

    @Override
    public void setSessyousisyacd(String pSessyousisyacd) {

    }

    @Override
    public String getSisyanm() {
        return null;
    }

    @Override
    public void setSisyanm(String pSisyanm) {

    }

    @Override
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return null;
    }

    @Override
    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {

    }

    @Override
    public Integer getRikoukityuutuudannissuu() {
        return null;
    }

    @Override
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {

    }

    @Override
    public C_BlnktkumuKbn getSaigaimousideumukbn() {
        return null;
    }

    @Override
    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn) {

    }

    @Override
    public Boolean getSindansyoryoushryouhi() {
        return null;
    }

    @Override
    public void setSindansyoryoushryouhi(Boolean pSindansyoryoushryouhi) {

    }

    @Override
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return null;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {

    }

    @Override
    public String getSyanaicomment() {
        return null;
    }

    @Override
    public void setSyanaicomment(String pSyanaicomment) {

    }

    @Override
    public boolean isViewSiharaiSateiInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiharaiSateiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSiharaiSateiDispFlg() {
        return false;
    }

    @Override
    public boolean isKinouModeSisateiitijiSeigyo() {
        return false;
    }

    @Override
    public C_SyorikekkaKbn getSatei1Syorikekkakbn() {
        return null;
    }

    @Override
    public void setSatei1Syorikekkakbn(C_SyorikekkaKbn pSatei1syorikekkakbn) {

    }

    @Override
    public String getSyono() {
        return null;
    }

    @Override
    public void setSyono(String pSyono) {

    }

    @Override
    public String getSyoukaibtn() {
        return null;
    }

    @Override
    public void setSyoukaibtn(String pSyoukaibtn) {

    }

    @Override
    public String getSkno() {
        return null;
    }

    @Override
    public void setSkno(String pSkno) {

    }

    @Override
    public String getKouteikanriid() {
        return null;
    }

    @Override
    public void setKouteikanriid(String pKouteikanriid) {

    }

    @Override
    public boolean isViewSkKihonSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSkKihonDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiharaiSateiHokenkinSyuruiDispFlg() {
        return false;
    }
}
