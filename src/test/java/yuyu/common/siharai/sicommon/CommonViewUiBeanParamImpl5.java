package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定結果Paramインターフェース実現クラス
 */
public class CommonViewUiBeanParamImpl5 implements ViewSateiKekkaUiBeanParam, ViewSkKihonUiBeanParam, ViewSiharaiSateiUiBeanParam {
    public C_SyorikekkaKbn syorikekkaKbn;

    private C_SyorikekkaKbn sateisyorikekkakbn;

    private String sateitennousakisousasyacd;

    private BizDate kaiketuymd;

    private String sateisyanaicomment;

    private boolean viewSateiKekkaSeigyo;

    private boolean viewSateiKekkaDispFlg;

    private boolean sessyouInputHanteiFlg;

    private boolean syouninInputHanteiFlg;

    private boolean kaiketuInputHanteiFlg;

    private String syono;

    private String syoukaibtn;

    private String skno;

    private String kouteikanriid;

    private boolean viewSkKihonSeigyo;

    private boolean viewSkKihonDispFlg;

    @Override
    public C_SyorikekkaKbn getSateisyorikekkakbn() {
        return sateisyorikekkakbn;
    }

    @Override
    public void setSateisyorikekkakbn(C_SyorikekkaKbn pSateisyorikekkakbn) {
        sateisyorikekkakbn = pSateisyorikekkakbn;
    }

    @Override
    public String getSateitennousakisousasyacd() {
        return sateitennousakisousasyacd;
    }

    @Override
    public void setSateitennousakisousasyacd(String pSateitennousakisousasyacd) {
        sateitennousakisousasyacd = pSateitennousakisousasyacd;
    }

    @Override
    public BizDate getKaiketuymd() {
        return kaiketuymd;
    }

    @Override
    public void setKaiketuymd(BizDate pKaiketuymd) {
        kaiketuymd = pKaiketuymd;
    }

    @Override
    public String getSateisyanaicomment() {
        return sateisyanaicomment;
    }

    @Override
    public void setSateisyanaicomment(String pSateisyanaicomment) {
        sateisyanaicomment = pSateisyanaicomment;
    }

    @Override
    public boolean isViewSateiKekkaSeigyo() {
        return viewSateiKekkaSeigyo;
    }

    @Override
    public boolean isViewSateiKekkaDispFlg() {
        return viewSateiKekkaDispFlg;
    }

    @Override
    public boolean isSyouninInputHanteiFlg() {
        return syouninInputHanteiFlg;
    }

    @Override
    public boolean isSessyouInputHanteiFlg() {
        return sessyouInputHanteiFlg;
    }

    @Override
    public boolean isKaiketuInputHanteiFlg() {
        return kaiketuInputHanteiFlg;
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
    public String getHokenkinsyurui() {
        return null;
    }

    @Override
    public void setHokenkinsyurui(String pHokenkinsyurui) {

    }

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return this.syorikekkaKbn;
    }

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        this.syorikekkaKbn = pSyorikekkakbn;
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
    public boolean isViewSiharaiSateiHokenkinSyuruiDispFlg() {
        return false;
    }
}
