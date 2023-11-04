package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定一般判定Paramインターフェース実装クラス
 */
public class CommonViewUiBeanParamImpl1 implements SiSateiIppanHanteiParam, ViewSiharaiSateiUiBeanParam, ViewSkKihonUiBeanParam {

    private String ippanhanteitensuu1;

    private String ippanhanteicomment1;

    private String ippanhanteitensuu2;

    private String ippanhanteicomment2;

    private String ippanhanteitensuu3;

    private String ippanhanteicomment3;

    private String ippanhanteitensuu4;

    private String ippanhanteicomment4;

    private String ippanhanteitensuu5;

    private String ippanhanteicomment5;

    private String ippanhanteitensuu6;

    private String ippanhanteicomment6;

    private String ippanhanteitensuugoukei;

    private String ippanhanteigoukeicomment;

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
    public String getIppanhanteitensuu1() {
        return ippanhanteitensuu1;
    }

    @Override
    public void setIppanhanteitensuu1(String pIppanhanteitensuu1) {
        ippanhanteitensuu1 = pIppanhanteitensuu1;
    }

    @Override
    public String getIppanhanteicomment1() {
        return ippanhanteicomment1;
    }

    @Override
    public void setIppanhanteicomment1(String pIppanhanteicomment1) {
        ippanhanteicomment1 = pIppanhanteicomment1;
    }

    @Override
    public String getIppanhanteitensuu2() {
        return ippanhanteitensuu2;
    }

    @Override
    public void setIppanhanteitensuu2(String pIppanhanteitensuu2) {
        ippanhanteitensuu2 = pIppanhanteitensuu2;
    }

    @Override
    public String getIppanhanteicomment2() {
        return ippanhanteicomment2;
    }

    @Override
    public void setIppanhanteicomment2(String pIppanhanteicomment2) {
        ippanhanteicomment2 = pIppanhanteicomment2;
    }

    @Override
    public String getIppanhanteitensuu3() {
        return ippanhanteitensuu3;
    }

    @Override
    public void setIppanhanteitensuu3(String pIppanhanteitensuu3) {
        ippanhanteitensuu3 = pIppanhanteitensuu3;
    }

    @Override
    public String getIppanhanteicomment3() {
        return ippanhanteicomment3;
    }

    @Override
    public void setIppanhanteicomment3(String pIppanhanteicomment3) {
        ippanhanteicomment3 = pIppanhanteicomment3;
    }

    @Override
    public String getIppanhanteitensuu4() {
        return ippanhanteitensuu4;
    }

    @Override
    public void setIppanhanteitensuu4(String pIppanhanteitensuu4) {
        ippanhanteitensuu4 = pIppanhanteitensuu4;
    }

    @Override
    public String getIppanhanteicomment4() {
        return ippanhanteicomment4;
    }

    @Override
    public void setIppanhanteicomment4(String pIppanhanteicomment4) {
        ippanhanteicomment4 = pIppanhanteicomment4;
    }

    @Override
    public String getIppanhanteitensuu5() {
        return ippanhanteitensuu5;
    }

    @Override
    public void setIppanhanteitensuu5(String pIppanhanteitensuu5) {
        ippanhanteitensuu5 = pIppanhanteitensuu5;
    }

    @Override
    public String getIppanhanteicomment5() {
        return ippanhanteicomment5;
    }

    @Override
    public void setIppanhanteicomment5(String pIppanhanteicomment5) {
        ippanhanteicomment5 = pIppanhanteicomment5;
    }

    @Override
    public String getIppanhanteitensuu6() {
        return ippanhanteitensuu6;
    }

    @Override
    public void setIppanhanteitensuu6(String pIppanhanteitensuu6) {
        ippanhanteitensuu6 = pIppanhanteitensuu6;
    }

    @Override
    public String getIppanhanteicomment6() {
        return ippanhanteicomment6;
    }

    @Override
    public void setIppanhanteicomment6(String pIppanhanteicomment6) {
        ippanhanteicomment6 = pIppanhanteicomment6;
    }

    @Override
    public String getIppanhanteitensuugoukei() {
        return ippanhanteitensuugoukei;
    }

    @Override
    public void setIppanhanteitensuugoukei(String pIppanhanteitensuugoukei) {
        ippanhanteitensuugoukei = pIppanhanteitensuugoukei;
    }

    @Override
    public String getIppanhanteigoukeicomment() {
        return ippanhanteigoukeicomment;
    }

    @Override
    public void setIppanhanteigoukeicomment(String pIppanhanteigoukeicomment) {
        ippanhanteigoukeicomment = pIppanhanteigoukeicomment;
    }

    public boolean isAllBlnk() {

        if (BizUtil.isBlank(ippanhanteitensuu1) && BizUtil.isBlank(ippanhanteicomment1) &&
            BizUtil.isBlank(ippanhanteitensuu2) && BizUtil.isBlank(ippanhanteicomment2) &&
            BizUtil.isBlank(ippanhanteitensuu3) && BizUtil.isBlank(ippanhanteicomment3) &&
            BizUtil.isBlank(ippanhanteitensuu4) && BizUtil.isBlank(ippanhanteicomment4) &&
            BizUtil.isBlank(ippanhanteitensuu5) && BizUtil.isBlank(ippanhanteicomment5) &&
            BizUtil.isBlank(ippanhanteitensuu6) && BizUtil.isBlank(ippanhanteicomment6) &&
            BizUtil.isBlank(ippanhanteitensuugoukei) && BizUtil.isBlank(ippanhanteigoukeicomment)) {
            return true;
        }
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
}
