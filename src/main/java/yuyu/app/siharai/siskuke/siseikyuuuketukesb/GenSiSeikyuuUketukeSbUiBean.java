package yuyu.app.siharai.siskuke.siseikyuuuketukesb;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
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
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * （死亡）請求受付 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiSeikyuuUketukeSbUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<ViewSindansyoinfoSibouInfo1DataSourceBean> viewSindansyoinfoSibouInfo1DataSource = new DataSource<>();
    public DataSource<ViewSindansyoinfoSibouInfo1DataSourceBean> getViewSindansyoinfoSibouInfo1DataSource() {
        return viewSindansyoinfoSibouInfo1DataSource;
    }

    @Deprecated
    public List<ViewSindansyoinfoSibouInfo1DataSourceBean> getViewSindansyoinfoSibouInfo1() {
        return viewSindansyoinfoSibouInfo1DataSource.getDatas();
    }

    public void setViewSindansyoinfoSibouInfo1(List<ViewSindansyoinfoSibouInfo1DataSourceBean> pViewSindansyoinfoSibouInfo1) {
        viewSindansyoinfoSibouInfo1DataSource.setDatas(pViewSindansyoinfoSibouInfo1);
    }

    private String vktifdispjimutetuzukinm;

    public String getVktifdispjimutetuzukinm() {
        return vktifdispjimutetuzukinm;
    }

    public void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm) {
        vktifdispjimutetuzukinm = pVktifdispjimutetuzukinm;
    }

    private String vktifdisptasknm;

    public String getVktifdisptasknm() {
        return vktifdisptasknm;
    }

    public void setVktifdisptasknm(String pVktifdisptasknm) {
        vktifdisptasknm = pVktifdisptasknm;
    }

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String syoukaibtn;

    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private C_SaisateiKbn saisateikbn;

    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @ValidDate
    private BizDate syoruiukeymd;

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private C_SeikyuusyaKbn seikyuusyakbn;

    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn() {
        return sihonninkakninkbn;
    }

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn) {
        sihonninkakninkbn = pSihonninkakninkbn;
    }

    @ValidDate
    private BizDate seikyuusyaseiymd;

    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    private C_Seibetu seikyuusyasei;

    public C_Seibetu getSeikyuusyasei() {
        return seikyuusyasei;
    }

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei) {
        seikyuusyasei = pSeikyuusyasei;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String seikyuusyanmkn;

    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String seikyuusyanmkj;

    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikennmkj;

    public String getSaikennmkj() {
        return saikennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    @Length(length=7)
    @Digit
    private String saikennyno;

    public String getSaikennyno() {
        return saikennyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr1kj;

    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr2kj;

    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr3kj;

    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String skskknnmkn;

    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String skskknnmkj;

    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    private C_SkskknsyubetuKbn skskknsyubetu;

    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    private C_SouhusakiKbn souhusakikbn;

    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String tsinyno;

    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr1kj;

    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr2kj;

    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr3kj;

    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String tsintelno;

    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    private C_SiharaiTuukaKbn siharaituukakbn;

    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private String dispbanknmkj;

    public String getDispbanknmkj() {
        return dispbanknmkj;
    }

    public void setDispbanknmkj(String pDispbanknmkj) {
        dispbanknmkj = pDispbanknmkj;
    }

    private String dispsitennmkj;

    public String getDispsitennmkj() {
        return dispsitennmkj;
    }

    public void setDispsitennmkj(String pDispsitennmkj) {
        dispsitennmkj = pDispsitennmkj;
    }

    @Length(length=4)
    @Digit
    private String bankcd;

    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String banknmkj;

    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    @Length(length=3)
    @Digit
    private String sitencd;

    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sitennmkj;

    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private C_YokinKbn yokinkbn;

    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    @MaxLength(max=12)
    @HostInvalidCharacter
    private String kouzano;

    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_Kzdou kzdoukbn;

    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kzmeiginmkn;

    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_GeninKbn geninkbn;

    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @ValidDate
    private BizDate sibouymd;

    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_SibouBasyoKbn siboubasyokbn;

    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String siboubasyo;

    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }

    private Boolean sateikaksaigaikanousei;

    public Boolean getSateikaksaigaikanousei() {
        return (sateikaksaigaikanousei == null) ? Boolean.FALSE : sateikaksaigaikanousei;
    }

    public void setSateikaksaigaikanousei(Boolean pSateikaksaigaikanousei) {
        sateikaksaigaikanousei = (pSateikaksaigaikanousei == null) ? Boolean.FALSE : pSateikaksaigaikanousei;
    }

    private C_UmuKbn sateikaksaigaikanouseikbn;

    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    private Boolean sateikakkaigaisb;

    public Boolean getSateikakkaigaisb() {
        return (sateikakkaigaisb == null) ? Boolean.FALSE : sateikakkaigaisb;
    }

    public void setSateikakkaigaisb(Boolean pSateikakkaigaisb) {
        sateikakkaigaisb = (pSateikakkaigaisb == null) ? Boolean.FALSE : pSateikakkaigaisb;
    }

    private C_UmuKbn sateikakkaigaisbkbn;

    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {
        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    private Boolean sateikakhusyousi;

    public Boolean getSateikakhusyousi() {
        return (sateikakhusyousi == null) ? Boolean.FALSE : sateikakhusyousi;
    }

    public void setSateikakhusyousi(Boolean pSateikakhusyousi) {
        sateikakhusyousi = (pSateikakhusyousi == null) ? Boolean.FALSE : pSateikakhusyousi;
    }

    private C_UmuKbn sateikakhusyousikbn;

    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    private Boolean sateikakmeigihnk;

    public Boolean getSateikakmeigihnk() {
        return (sateikakmeigihnk == null) ? Boolean.FALSE : sateikakmeigihnk;
    }

    public void setSateikakmeigihnk(Boolean pSateikakmeigihnk) {
        sateikakmeigihnk = (pSateikakmeigihnk == null) ? Boolean.FALSE : pSateikakmeigihnk;
    }

    private C_YouhiKbn sateikakmeigihnkkbn;

    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {
        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    public C_KanryotuutioutKbn getShrdtlsyooutkbn() {
        return shrdtlsyooutkbn;
    }

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn) {
        shrdtlsyooutkbn = pShrdtlsyooutkbn;
    }

    private C_HassouKbn hassoukbn;

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    @Length(length=3)
    @Digit
    private String uktmnmeigibangou;

    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    @Length(length=3)
    @Digit
    private String kykmnmeigibangou;

    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    @MaxLength(max=1500)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String syanaicomment;

    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }
}
