package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 請求内容チェックメイン（死亡）パラメータ（（死亡）請求内容チェックParam）実現クラス
 */
public class CheckSbSkNaiyouParamImpl implements CheckSbSkNaiyouParam {

    private String syono;

    private C_SeikyuusyaKbn seikyuusyakbn;

    private String seikyuusyanmkn;

    private String seikyuusyanmkj;

    private BizDate seikyuusyaseiymd;

    private C_Seibetu seikyuusyasei;

    private String skskknnmkn;

    private String skskknnmkj;

    private C_SkskknsyubetuKbn skskknsyubetu;

    private C_SouhusakiKbn souhusakikbn;

    private String tsinyno;

    private String tsinadr1kj;

    private String tsinadr2kj;

    private String tsinadr3kj;

    private String tsintelno;

    private C_SiharaiTuukaKbn siharaituukakbn;

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private C_Kzdou kzdoukbn;

    private String kzmeiginmkn;

    private BizDate syoruiukeymd;

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    //private C_Tkhukaumu nstkhukaumukbn;

    //private C_Nstknsyu nksyukbn;

    //private Integer nknshry;

    //private C_Bnshrkaisuu bnshrkaisuu;

    //private BizCurrency nkkknjyutougk;

    //private C_NkHaitoukinuketorihouKbn nkhaitoukinuketorihoukbn;

    private BizDate sibouymd;

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    private C_HassouKbn hassoukbn;

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    private BizDate hubikanryouymd;

    private C_GeninKbn geninkbn;

    private List<String> byoumeitourokunolist;

    private C_YouhiKbn sateikakmeigihnkkbn;

    private C_UmuKbn sateikakhusyousikbn;

    private C_UmuKbn sateikakkaigaisbkbn;

    private JT_SkKihon skkihon;

    private C_SaisateiKbn saisateikbn;

    private String saikennmkj;

    private String saikennyno;

    private String saikenadr1kj;

    private String saikenadr2kj;

    private String saikenadr3kj;

    private C_UmuKbn sateikaksaigaikanouseikbn;

    private String skno;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    @Override
    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Override
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @Override
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Override
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    @Override
    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Override
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    @Override
    public C_Seibetu getSeikyuusyasei() {
        return seikyuusyasei;
    }

    @Override
    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei) {
        seikyuusyasei = pSeikyuusyasei;
    }

    @Override
    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Override
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    @Override
    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Override
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    @Override
    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    @Override
    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    @Override
    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    @Override
    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
    }

    @Override
    public String getTsinyno() {
        return tsinyno;
    }

    @Override
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    @Override
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Override
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @Override
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Override
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @Override
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Override
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    @Override
    public String getTsintelno() {
        return tsintelno;
    }

    @Override
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    @Override
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    @Override
    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    @Override
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    @Override
    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    @Override
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    @Override
    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    @Override
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    @Override
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    @Override
    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Override
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    @Override
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Override
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    @Override
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    @Override
    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    //    @Override
    //    public C_Tkhukaumu getNstkhukaumukbn() {
    //        return nstkhukaumukbn;
    //    }

    //    @Override
    //    public void setNstkhukaumukbn(C_Tkhukaumu pNstkhukaumukbn) {
    //        nstkhukaumukbn = pNstkhukaumukbn;
    //    }

    //    @Override
    //    public C_Nstknsyu getNksyukbn() {
    //        return nksyukbn;
    //    }

    //    @Override
    //    public void setNksyukbn(C_Nstknsyu pNksyukbn) {
    //        nksyukbn = pNksyukbn;
    //    }

    //    @Override
    //    public Integer getNknshry() {
    //        return nknshry;
    //    }

    //    @Override
    //    public void setNknshry(Integer pNknshry) {
    //        nknshry = pNknshry;
    //    }

    //    @Override
    //    public C_Bnshrkaisuu getBnshrkaisuu() {
    //        return bnshrkaisuu;
    //    }

    //    @Override
    //    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
    //        bnshrkaisuu = pBnshrkaisuu;
    //    }

    //    @Override
    //    public BizCurrency getNkkknjyutougk() {
    //        return nkkknjyutougk;
    //    }

    //    @Override
    //    public void setNkkknjyutougk(BizCurrency pNkkknjyutougk) {
    //        nkkknjyutougk = pNkkknjyutougk;
    //    }

    //    @Override
    //    public C_NkHaitoukinuketorihouKbn getNkhaitoukinuketorihoukbn() {
    //        return nkhaitoukinuketorihoukbn;
    //    }

    //    @Override
    //    public void setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn pNkhaitoukinuketorihoukbn) {
    //        nkhaitoukinuketorihoukbn = pNkhaitoukinuketorihoukbn;
    //    }

    @Override
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Override
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    @Override
    public C_KanryotuutioutKbn getShrdtlsyooutkbn() {
        return shrdtlsyooutkbn;
    }

    @Override
    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn) {
        shrdtlsyooutkbn = pShrdtlsyooutkbn;
    }

    @Override
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    @Override
    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    @Override
    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn() {
        return sihonninkakninkbn;
    }

    @Override
    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn) {
        sihonninkakninkbn = pSihonninkakninkbn;
    }

    @Override
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Override
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    @Override
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    @Override
    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @Override
    public List<String> getByoumeitourokunolist() {
        return byoumeitourokunolist;
    }

    @Override
    public void setByoumeitourokunolist(List<String> pByoumeitourokunolist) {
        byoumeitourokunolist = pByoumeitourokunolist;
    }

    @Override
    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    @Override
    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {
        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    @Override
    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    @Override
    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    @Override
    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    @Override
    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {
        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    @Override
    public JT_SkKihon getSkkihon() {
        return skkihon;
    }

    @Override
    public void setSkkihon(JT_SkKihon pSkkihon) {
        skkihon = pSkkihon;
    }

    @Override
    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    @Override
    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;

    }

    @Override
    public String getSaikennmkj() {
        return saikennmkj;
    }

    @Override
    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    @Override
    public String getSaikennyno() {
        return saikennyno;
    }

    @Override
    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    @Override
    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    @Override
    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    @Override
    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    @Override
    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    @Override
    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    @Override
    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }

    @Override
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    @Override
    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    @Override
    public String getSkno() {
        return skno;
    }

    @Override
    public void setSkno(String pSkno) {
        skno = pSkno;
    }
}
