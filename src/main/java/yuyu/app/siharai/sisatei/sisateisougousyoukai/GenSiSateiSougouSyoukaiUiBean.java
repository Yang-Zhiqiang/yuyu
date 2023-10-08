package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 査定総合照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiSateiSougouSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SyoruiInfoListDataSourceBean> syoruiInfoListDataSource = new DataSource<>();
    public DataSource<SyoruiInfoListDataSourceBean> getSyoruiInfoListDataSource() {
        return syoruiInfoListDataSource;
    }

    @Deprecated
    public List<SyoruiInfoListDataSourceBean> getSyoruiInfoList() {
        return syoruiInfoListDataSource.getDatas();
    }

    public void setSyoruiInfoList(List<SyoruiInfoListDataSourceBean> pSyoruiInfoList) {
        syoruiInfoListDataSource.setDatas(pSyoruiInfoList);
    }

    private DataSource<SkKihonKanriInfoDataSourceBean> skKihonKanriInfoDataSource = new DataSource<>();
    public DataSource<SkKihonKanriInfoDataSourceBean> getSkKihonKanriInfoDataSource() {
        return skKihonKanriInfoDataSource;
    }

    @Deprecated
    public List<SkKihonKanriInfoDataSourceBean> getSkKihonKanriInfo() {
        return skKihonKanriInfoDataSource.getDatas();
    }

    public void setSkKihonKanriInfo(List<SkKihonKanriInfoDataSourceBean> pSkKihonKanriInfo) {
        skKihonKanriInfoDataSource.setDatas(pSkKihonKanriInfo);
    }

    private DataSource<ProgresshistoryinfoDataSourceBean> progresshistoryinfoDataSource = new DataSource<>();
    public DataSource<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfoDataSource() {
        return progresshistoryinfoDataSource;
    }

    @Deprecated
    public List<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfo() {
        return progresshistoryinfoDataSource.getDatas();
    }

    public void setProgresshistoryinfo(List<ProgresshistoryinfoDataSourceBean> pProgresshistoryinfo) {
        progresshistoryinfoDataSource.setDatas(pProgresshistoryinfo);
    }

    private DataSource<HubiListDataSourceBean> hubiListDataSource = new DataSource<>();
    public DataSource<HubiListDataSourceBean> getHubiListDataSource() {
        return hubiListDataSource;
    }

    @Deprecated
    public List<HubiListDataSourceBean> getHubiList() {
        return hubiListDataSource.getDatas();
    }

    public void setHubiList(List<HubiListDataSourceBean> pHubiList) {
        hubiListDataSource.setDatas(pHubiList);
    }

    private DataSource<BetukykInfoDataSourceBean> betukykInfoDataSource = new DataSource<>();
    public DataSource<BetukykInfoDataSourceBean> getBetukykInfoDataSource() {
        return betukykInfoDataSource;
    }

    @Deprecated
    public List<BetukykInfoDataSourceBean> getBetukykInfo() {
        return betukykInfoDataSource.getDatas();
    }

    public void setBetukykInfo(List<BetukykInfoDataSourceBean> pBetukykInfo) {
        betukykInfoDataSource.setDatas(pBetukykInfo);
    }

    private DataSource<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfoDataSource = new DataSource<>();
    public DataSource<TtdktyuuikbnInfoDataSourceBean> getTtdktyuuikbnInfoDataSource() {
        return ttdktyuuikbnInfoDataSource;
    }

    @Deprecated
    public List<TtdktyuuikbnInfoDataSourceBean> getTtdktyuuikbnInfo() {
        return ttdktyuuikbnInfoDataSource.getDatas();
    }

    public void setTtdktyuuikbnInfo(List<TtdktyuuikbnInfoDataSourceBean> pTtdktyuuikbnInfo) {
        ttdktyuuikbnInfoDataSource.setDatas(pTtdktyuuikbnInfo);
    }

    private String siharairirekisyoukaibtn;

    public String getSiharairirekisyoukaibtn() {
        return siharairirekisyoukaibtn;
    }

    public void setSiharairirekisyoukaibtn(String pSiharairirekisyoukaibtn) {
        siharairirekisyoukaibtn = pSiharairirekisyoukaibtn;
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

    private String skno;

    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    private C_SeikyuusyaKbn seikyuusyakbn;

    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
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

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
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

    private C_MousideninKbn mousideninkbn;

    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String mousideninnmkj;

    public String getMousideninnmkj() {
        return mousideninnmkj;
    }

    @Trim("right")
    public void setMousideninnmkj(String pMousideninnmkj) {
        mousideninnmkj = pMousideninnmkj;
    }

    private C_UketorininSibouUmuKbn uketorininsibouumukbn;

    public C_UketorininSibouUmuKbn getUketorininsibouumukbn() {
        return uketorininsibouumukbn;
    }

    public void setUketorininsibouumukbn(C_UketorininSibouUmuKbn pUketorininsibouumukbn) {
        uketorininsibouumukbn = pUketorininsibouumukbn;
    }

    private C_KyksyaSibouUmuKbn kyksyasibouumukbn;

    public C_KyksyaSibouUmuKbn getKyksyasibouumukbn() {
        return kyksyasibouumukbn;
    }

    public void setKyksyasibouumukbn(C_KyksyaSibouUmuKbn pKyksyasibouumukbn) {
        kyksyasibouumukbn = pKyksyasibouumukbn;
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
    private String disptsinyno;

    public String getDisptsinyno() {
        return disptsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisptsinyno(String pDisptsinyno) {
        disptsinyno = pDisptsinyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String disptsinadr1kj;

    public String getDisptsinadr1kj() {
        return disptsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDisptsinadr1kj(String pDisptsinadr1kj) {
        disptsinadr1kj = pDisptsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String disptsinadr2kj;

    public String getDisptsinadr2kj() {
        return disptsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDisptsinadr2kj(String pDisptsinadr2kj) {
        disptsinadr2kj = pDisptsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String disptsinadr3kj;

    public String getDisptsinadr3kj() {
        return disptsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDisptsinadr3kj(String pDisptsinadr3kj) {
        disptsinadr3kj = pDisptsinadr3kj;
    }

    private String disptsintelno;

    public String getDisptsintelno() {
        return disptsintelno;
    }

    public void setDisptsintelno(String pDisptsintelno) {
        disptsintelno = pDisptsintelno;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
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

    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    private String syoubyounmkjgamen;

    public String getSyoubyounmkjgamen() {
        return syoubyounmkjgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoubyounmkjgamen(String pSyoubyounmkjgamen) {
        syoubyounmkjgamen = pSyoubyounmkjgamen;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Kykjyoutai kykjyoutai;

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    @ValidDate
    private BizDate mosymd;

    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    @ValidDate
    private BizDate kktymd;

    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    @ValidDate
    private BizDate mosukeymd;

    public BizDate getMosukeymd() {
        return mosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosukeymd(BizDate pMosukeymd) {
        mosukeymd = pMosukeymd;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    private String vkykskyknmkn;

    public String getVkykskyknmkn() {
        return vkykskyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVkykskyknmkn(String pVkykskyknmkn) {
        vkykskyknmkn = pVkykskyknmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String vkykskyknmkj;

    public String getVkykskyknmkj() {
        return vkykskyknmkj;
    }

    @Trim("right")
    public void setVkykskyknmkj(String pVkykskyknmkj) {
        vkykskyknmkj = pVkykskyknmkj;
    }

    @ValidDate
    private BizDate vkykskykseiymd;

    public BizDate getVkykskykseiymd() {
        return vkykskykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVkykskykseiymd(BizDate pVkykskykseiymd) {
        vkykskykseiymd = pVkykskykseiymd;
    }

    private String dispmskmjskjkyknen;

    public String getDispmskmjskjkyknen() {
        return dispmskmjskjkyknen;
    }

    public void setDispmskmjskjkyknen(String pDispmskmjskjkyknen) {
        dispmskmjskjkyknen = pDispmskmjskjkyknen;
    }

    private C_Kyksei vkykskyksei;

    public C_Kyksei getVkykskyksei() {
        return vkykskyksei;
    }

    public void setVkykskyksei(C_Kyksei pVkykskyksei) {
        vkykskyksei = pVkykskyksei;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String vtssktsinyno;

    public String getVtssktsinyno() {
        return vtssktsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVtssktsinyno(String pVtssktsinyno) {
        vtssktsinyno = pVtssktsinyno;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    private String vtssktsintelno;

    public String getVtssktsintelno() {
        return vtssktsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVtssktsintelno(String pVtssktsintelno) {
        vtssktsintelno = pVtssktsintelno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vtssktsinadr1kj;

    public String getVtssktsinadr1kj() {
        return vtssktsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtssktsinadr1kj(String pVtssktsinadr1kj) {
        vtssktsinadr1kj = pVtssktsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vtssktsinadr2kj;

    public String getVtssktsinadr2kj() {
        return vtssktsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtssktsinadr2kj(String pVtssktsinadr2kj) {
        vtssktsinadr2kj = pVtssktsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vtssktsinadr3kj;

    public String getVtssktsinadr3kj() {
        return vtssktsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtssktsinadr3kj(String pVtssktsinadr3kj) {
        vtssktsinadr3kj = pVtssktsinadr3kj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    private String vhhkshhknnmkn;

    public String getVhhkshhknnmkn() {
        return vhhkshhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVhhkshhknnmkn(String pVhhkshhknnmkn) {
        vhhkshhknnmkn = pVhhkshhknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String vhhkshhknnmkj;

    public String getVhhkshhknnmkj() {
        return vhhkshhknnmkj;
    }

    @Trim("right")
    public void setVhhkshhknnmkj(String pVhhkshhknnmkj) {
        vhhkshhknnmkj = pVhhkshhknnmkj;
    }

    @ValidDate
    private BizDate vhhkshhknseiymd;

    public BizDate getVhhkshhknseiymd() {
        return vhhkshhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhhkshhknseiymd(BizDate pVhhkshhknseiymd) {
        vhhkshhknseiymd = pVhhkshhknseiymd;
    }

    private String dispmskmjskjhhknnen;

    public String getDispmskmjskjhhknnen() {
        return dispmskmjskjhhknnen;
    }

    public void setDispmskmjskjhhknnen(String pDispmskmjskjhhknnen) {
        dispmskmjskjhhknnen = pDispmskmjskjhhknnen;
    }

    private C_Hhknsei vhhkshhknsei;

    public C_Hhknsei getVhhkshhknsei() {
        return vhhkshhknsei;
    }

    public void setVhhkshhknsei(C_Hhknsei pVhhkshhknsei) {
        vhhkshhknsei = pVhhkshhknsei;
    }

    private String vhsyusyusyouhnnm;

    public String getVhsyusyusyouhnnm() {
        return vhsyusyusyouhnnm;
    }

    public void setVhsyusyusyouhnnm(String pVhsyusyusyouhnnm) {
        vhsyusyusyouhnnm = pVhsyusyusyouhnnm;
    }

    private C_Tuukasyu vhsyusyukyktuukasyu;

    public C_Tuukasyu getVhsyusyukyktuukasyu() {
        return vhsyusyukyktuukasyu;
    }

    public void setVhsyusyukyktuukasyu(C_Tuukasyu pVhsyusyukyktuukasyu) {
        vhsyusyukyktuukasyu = pVhsyusyukyktuukasyu;
    }

    @Range(min="0", max="99")
    private Integer vhsyusyuhknkkn;

    public Integer getVhsyusyuhknkkn() {
        return vhsyusyuhknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhsyusyuhknkkn(Integer pVhsyusyuhknkkn) {
        vhsyusyuhknkkn = pVhsyusyuhknkkn;
    }

    private C_HknkknsmnKbn vhsyusyuhknkknsmnkbn;

    public C_HknkknsmnKbn getVhsyusyuhknkknsmnkbn() {
        return vhsyusyuhknkknsmnkbn;
    }

    public void setVhsyusyuhknkknsmnkbn(C_HknkknsmnKbn pVhsyusyuhknkknsmnkbn) {
        vhsyusyuhknkknsmnkbn = pVhsyusyuhknkknsmnkbn;
    }

    @Range(min="0", max="99")
    private Integer vhsyusyuhrkkkn;

    public Integer getVhsyusyuhrkkkn() {
        return vhsyusyuhrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhsyusyuhrkkkn(Integer pVhsyusyuhrkkkn) {
        vhsyusyuhrkkkn = pVhsyusyuhrkkkn;
    }

    private C_HrkkknsmnKbn vhsyusyuhrkkknsmnkbn;

    public C_HrkkknsmnKbn getVhsyusyuhrkkknsmnkbn() {
        return vhsyusyuhrkkknsmnkbn;
    }

    public void setVhsyusyuhrkkknsmnkbn(C_HrkkknsmnKbn pVhsyusyuhrkkknsmnkbn) {
        vhsyusyuhrkkknsmnkbn = pVhsyusyuhrkkknsmnkbn;
    }

    private Integer vhsyudai1hknkkn;

    public Integer getVhsyudai1hknkkn() {
        return vhsyudai1hknkkn;
    }

    public void setVhsyudai1hknkkn(Integer pVhsyudai1hknkkn) {
        vhsyudai1hknkkn = pVhsyudai1hknkkn;
    }

    private BizDate vhsyusyukykymd;

    public BizDate getVhsyusyukykymd() {
        return vhsyusyukykymd;
    }

    public void setVhsyusyukykymd(BizDate pVhsyusyukykymd) {
        vhsyusyukykymd = pVhsyusyukykymd;
    }

    private BizDate vhsyusyusknnkaisiymd;

    public BizDate getVhsyusyusknnkaisiymd() {
        return vhsyusyusknnkaisiymd;
    }

    public void setVhsyusyusknnkaisiymd(BizDate pVhsyusyusknnkaisiymd) {
        vhsyusyusknnkaisiymd = pVhsyusyusknnkaisiymd;
    }

    private BizDate vhsyusyufktsknnkaisiymd;

    public BizDate getVhsyusyufktsknnkaisiymd() {
        return vhsyusyufktsknnkaisiymd;
    }

    public void setVhsyusyufktsknnkaisiymd(BizDate pVhsyusyufktsknnkaisiymd) {
        vhsyusyufktsknnkaisiymd = pVhsyusyufktsknnkaisiymd;
    }

    @PositiveNumberBizCalcble
    private BizCurrency vhsyusyukihons;

    public BizCurrency getVhsyusyukihons() {
        return vhsyusyukihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhsyusyukihons(BizCurrency pVhsyusyukihons) {
        vhsyusyukihons = pVhsyusyukihons;
    }

    private BizCurrency vhsyusyup;

    public BizCurrency getVhsyusyup() {
        return vhsyusyup;
    }

    public void setVhsyusyup(BizCurrency pVhsyusyup) {
        vhsyusyup = pVhsyusyup;
    }

    private String vhsyusyuhtnpbuicd1;

    public String getVhsyusyuhtnpbuicd1() {
        return vhsyusyuhtnpbuicd1;
    }

    public void setVhsyusyuhtnpbuicd1(String pVhsyusyuhtnpbuicd1) {
        vhsyusyuhtnpbuicd1 = pVhsyusyuhtnpbuicd1;
    }

    private String vhsyusyuhtnpbuinm1;

    public String getVhsyusyuhtnpbuinm1() {
        return vhsyusyuhtnpbuinm1;
    }

    public void setVhsyusyuhtnpbuinm1(String pVhsyusyuhtnpbuinm1) {
        vhsyusyuhtnpbuinm1 = pVhsyusyuhtnpbuinm1;
    }

    private C_Htnpkkn vhsyusyuhtnpkkn1;

    public C_Htnpkkn getVhsyusyuhtnpkkn1() {
        return vhsyusyuhtnpkkn1;
    }

    public void setVhsyusyuhtnpkkn1(C_Htnpkkn pVhsyusyuhtnpkkn1) {
        vhsyusyuhtnpkkn1 = pVhsyusyuhtnpkkn1;
    }

    private String vhsyusyuhtnpbuicd2;

    public String getVhsyusyuhtnpbuicd2() {
        return vhsyusyuhtnpbuicd2;
    }

    public void setVhsyusyuhtnpbuicd2(String pVhsyusyuhtnpbuicd2) {
        vhsyusyuhtnpbuicd2 = pVhsyusyuhtnpbuicd2;
    }

    private String vhsyusyuhtnpbuinm2;

    public String getVhsyusyuhtnpbuinm2() {
        return vhsyusyuhtnpbuinm2;
    }

    public void setVhsyusyuhtnpbuinm2(String pVhsyusyuhtnpbuinm2) {
        vhsyusyuhtnpbuinm2 = pVhsyusyuhtnpbuinm2;
    }

    private C_Htnpkkn vhsyusyuhtnpkkn2;

    public C_Htnpkkn getVhsyusyuhtnpkkn2() {
        return vhsyusyuhtnpkkn2;
    }

    public void setVhsyusyuhtnpkkn2(C_Htnpkkn pVhsyusyuhtnpkkn2) {
        vhsyusyuhtnpkkn2 = pVhsyusyuhtnpkkn2;
    }

    private String vhsyusyuhtnpbuicd3;

    public String getVhsyusyuhtnpbuicd3() {
        return vhsyusyuhtnpbuicd3;
    }

    public void setVhsyusyuhtnpbuicd3(String pVhsyusyuhtnpbuicd3) {
        vhsyusyuhtnpbuicd3 = pVhsyusyuhtnpbuicd3;
    }

    private String vhsyusyuhtnpbuinm3;

    public String getVhsyusyuhtnpbuinm3() {
        return vhsyusyuhtnpbuinm3;
    }

    public void setVhsyusyuhtnpbuinm3(String pVhsyusyuhtnpbuinm3) {
        vhsyusyuhtnpbuinm3 = pVhsyusyuhtnpbuinm3;
    }

    private C_Htnpkkn vhsyusyuhtnpkkn3;

    public C_Htnpkkn getVhsyusyuhtnpkkn3() {
        return vhsyusyuhtnpkkn3;
    }

    public void setVhsyusyuhtnpkkn3(C_Htnpkkn pVhsyusyuhtnpkkn3) {
        vhsyusyuhtnpkkn3 = pVhsyusyuhtnpkkn3;
    }

    private String vhsyusyuhtnpbuicd4;

    public String getVhsyusyuhtnpbuicd4() {
        return vhsyusyuhtnpbuicd4;
    }

    public void setVhsyusyuhtnpbuicd4(String pVhsyusyuhtnpbuicd4) {
        vhsyusyuhtnpbuicd4 = pVhsyusyuhtnpbuicd4;
    }

    private String vhsyusyuhtnpbuinm4;

    public String getVhsyusyuhtnpbuinm4() {
        return vhsyusyuhtnpbuinm4;
    }

    public void setVhsyusyuhtnpbuinm4(String pVhsyusyuhtnpbuinm4) {
        vhsyusyuhtnpbuinm4 = pVhsyusyuhtnpbuinm4;
    }

    private C_Htnpkkn vhsyusyuhtnpkkn4;

    public C_Htnpkkn getVhsyusyuhtnpkkn4() {
        return vhsyusyuhtnpkkn4;
    }

    public void setVhsyusyuhtnpkkn4(C_Htnpkkn pVhsyusyuhtnpkkn4) {
        vhsyusyuhtnpkkn4 = pVhsyusyuhtnpkkn4;
    }

    private C_TokkoudosghtnpKbn vhsyusyutokkdsghtnpkbn;

    public C_TokkoudosghtnpKbn getVhsyusyutokkdsghtnpkbn() {
        return vhsyusyutokkdsghtnpkbn;
    }

    public void setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn pVhsyusyutokkdsghtnpkbn) {
        vhsyusyutokkdsghtnpkbn = pVhsyusyutokkdsghtnpkbn;
    }

    private String vhsyudisptksyouhnnm1;

    public String getVhsyudisptksyouhnnm1() {
        return vhsyudisptksyouhnnm1;
    }

    public void setVhsyudisptksyouhnnm1(String pVhsyudisptksyouhnnm1) {
        vhsyudisptksyouhnnm1 = pVhsyudisptksyouhnnm1;
    }

    private Integer vhsyudisptkhknkkn1;

    public Integer getVhsyudisptkhknkkn1() {
        return vhsyudisptkhknkkn1;
    }

    public void setVhsyudisptkhknkkn1(Integer pVhsyudisptkhknkkn1) {
        vhsyudisptkhknkkn1 = pVhsyudisptkhknkkn1;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn1;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn1() {
        return vhsyudisptkhknkknsmnkbn1;
    }

    public void setVhsyudisptkhknkknsmnkbn1(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn1) {
        vhsyudisptkhknkknsmnkbn1 = pVhsyudisptkhknkknsmnkbn1;
    }

    private Integer vhsyudisptkhrkkkn1;

    public Integer getVhsyudisptkhrkkkn1() {
        return vhsyudisptkhrkkkn1;
    }

    public void setVhsyudisptkhrkkkn1(Integer pVhsyudisptkhrkkkn1) {
        vhsyudisptkhrkkkn1 = pVhsyudisptkhrkkkn1;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn1;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn1() {
        return vhsyudisptkhrkkknsmnkbn1;
    }

    public void setVhsyudisptkhrkkknsmnkbn1(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn1) {
        vhsyudisptkhrkkknsmnkbn1 = pVhsyudisptkhrkkknsmnkbn1;
    }

    private BizDate vhsyudisptkkykymd1;

    public BizDate getVhsyudisptkkykymd1() {
        return vhsyudisptkkykymd1;
    }

    public void setVhsyudisptkkykymd1(BizDate pVhsyudisptkkykymd1) {
        vhsyudisptkkykymd1 = pVhsyudisptkkykymd1;
    }

    private BizDate vhsyudisptksknnkaisiymd1;

    public BizDate getVhsyudisptksknnkaisiymd1() {
        return vhsyudisptksknnkaisiymd1;
    }

    public void setVhsyudisptksknnkaisiymd1(BizDate pVhsyudisptksknnkaisiymd1) {
        vhsyudisptksknnkaisiymd1 = pVhsyudisptksknnkaisiymd1;
    }

    private BizDate vhsyudisptkhkskkaisiymd1;

    public BizDate getVhsyudisptkhkskkaisiymd1() {
        return vhsyudisptkhkskkaisiymd1;
    }

    public void setVhsyudisptkhkskkaisiymd1(BizDate pVhsyudisptkhkskkaisiymd1) {
        vhsyudisptkhkskkaisiymd1 = pVhsyudisptkhkskkaisiymd1;
    }

    private BizCurrency vhsyudisptkkihons1;

    public BizCurrency getVhsyudisptkkihons1() {
        return vhsyudisptkkihons1;
    }

    public void setVhsyudisptkkihons1(BizCurrency pVhsyudisptkkihons1) {
        vhsyudisptkkihons1 = pVhsyudisptkkihons1;
    }

    private BizCurrency vhsyudisptktkjyp1;

    public BizCurrency getVhsyudisptktkjyp1() {
        return vhsyudisptktkjyp1;
    }

    public void setVhsyudisptktkjyp1(BizCurrency pVhsyudisptktkjyp1) {
        vhsyudisptktkjyp1 = pVhsyudisptktkjyp1;
    }

    private String vhsyudisptkhtnpbuicd11;

    public String getVhsyudisptkhtnpbuicd11() {
        return vhsyudisptkhtnpbuicd11;
    }

    public void setVhsyudisptkhtnpbuicd11(String pVhsyudisptkhtnpbuicd11) {
        vhsyudisptkhtnpbuicd11 = pVhsyudisptkhtnpbuicd11;
    }

    private String vhsyudisptkhtnpbuinm11;

    public String getVhsyudisptkhtnpbuinm11() {
        return vhsyudisptkhtnpbuinm11;
    }

    public void setVhsyudisptkhtnpbuinm11(String pVhsyudisptkhtnpbuinm11) {
        vhsyudisptkhtnpbuinm11 = pVhsyudisptkhtnpbuinm11;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn11;

    public C_Htnpkkn getVhsyudisptkhtnpkkn11() {
        return vhsyudisptkhtnpkkn11;
    }

    public void setVhsyudisptkhtnpkkn11(C_Htnpkkn pVhsyudisptkhtnpkkn11) {
        vhsyudisptkhtnpkkn11 = pVhsyudisptkhtnpkkn11;
    }

    private String vhsyudisptkhtnpbuicd21;

    public String getVhsyudisptkhtnpbuicd21() {
        return vhsyudisptkhtnpbuicd21;
    }

    public void setVhsyudisptkhtnpbuicd21(String pVhsyudisptkhtnpbuicd21) {
        vhsyudisptkhtnpbuicd21 = pVhsyudisptkhtnpbuicd21;
    }

    private String vhsyudisptkhtnpbuinm21;

    public String getVhsyudisptkhtnpbuinm21() {
        return vhsyudisptkhtnpbuinm21;
    }

    public void setVhsyudisptkhtnpbuinm21(String pVhsyudisptkhtnpbuinm21) {
        vhsyudisptkhtnpbuinm21 = pVhsyudisptkhtnpbuinm21;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn21;

    public C_Htnpkkn getVhsyudisptkhtnpkkn21() {
        return vhsyudisptkhtnpkkn21;
    }

    public void setVhsyudisptkhtnpkkn21(C_Htnpkkn pVhsyudisptkhtnpkkn21) {
        vhsyudisptkhtnpkkn21 = pVhsyudisptkhtnpkkn21;
    }

    private String vhsyudisptkhtnpbuicd31;

    public String getVhsyudisptkhtnpbuicd31() {
        return vhsyudisptkhtnpbuicd31;
    }

    public void setVhsyudisptkhtnpbuicd31(String pVhsyudisptkhtnpbuicd31) {
        vhsyudisptkhtnpbuicd31 = pVhsyudisptkhtnpbuicd31;
    }

    private String vhsyudisptkhtnpbuinm31;

    public String getVhsyudisptkhtnpbuinm31() {
        return vhsyudisptkhtnpbuinm31;
    }

    public void setVhsyudisptkhtnpbuinm31(String pVhsyudisptkhtnpbuinm31) {
        vhsyudisptkhtnpbuinm31 = pVhsyudisptkhtnpbuinm31;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn31;

    public C_Htnpkkn getVhsyudisptkhtnpkkn31() {
        return vhsyudisptkhtnpkkn31;
    }

    public void setVhsyudisptkhtnpkkn31(C_Htnpkkn pVhsyudisptkhtnpkkn31) {
        vhsyudisptkhtnpkkn31 = pVhsyudisptkhtnpkkn31;
    }

    private String vhsyudisptkhtnpbuicd41;

    public String getVhsyudisptkhtnpbuicd41() {
        return vhsyudisptkhtnpbuicd41;
    }

    public void setVhsyudisptkhtnpbuicd41(String pVhsyudisptkhtnpbuicd41) {
        vhsyudisptkhtnpbuicd41 = pVhsyudisptkhtnpbuicd41;
    }

    private String vhsyudisptkhtnpbuinm41;

    public String getVhsyudisptkhtnpbuinm41() {
        return vhsyudisptkhtnpbuinm41;
    }

    public void setVhsyudisptkhtnpbuinm41(String pVhsyudisptkhtnpbuinm41) {
        vhsyudisptkhtnpbuinm41 = pVhsyudisptkhtnpbuinm41;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn41;

    public C_Htnpkkn getVhsyudisptkhtnpkkn41() {
        return vhsyudisptkhtnpkkn41;
    }

    public void setVhsyudisptkhtnpkkn41(C_Htnpkkn pVhsyudisptkhtnpkkn41) {
        vhsyudisptkhtnpkkn41 = pVhsyudisptkhtnpkkn41;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn1;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn1() {
        return vhsyudisptktkkdsghtpkbn1;
    }

    public void setVhsyudisptktkkdsghtpkbn1(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn1) {
        vhsyudisptktkkdsghtpkbn1 = pVhsyudisptktkkdsghtpkbn1;
    }

    private String vhsyudisptksyouhnnm2;

    public String getVhsyudisptksyouhnnm2() {
        return vhsyudisptksyouhnnm2;
    }

    public void setVhsyudisptksyouhnnm2(String pVhsyudisptksyouhnnm2) {
        vhsyudisptksyouhnnm2 = pVhsyudisptksyouhnnm2;
    }

    private Integer vhsyudisptkhknkkn2;

    public Integer getVhsyudisptkhknkkn2() {
        return vhsyudisptkhknkkn2;
    }

    public void setVhsyudisptkhknkkn2(Integer pVhsyudisptkhknkkn2) {
        vhsyudisptkhknkkn2 = pVhsyudisptkhknkkn2;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn2;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn2() {
        return vhsyudisptkhknkknsmnkbn2;
    }

    public void setVhsyudisptkhknkknsmnkbn2(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn2) {
        vhsyudisptkhknkknsmnkbn2 = pVhsyudisptkhknkknsmnkbn2;
    }

    private Integer vhsyudisptkhrkkkn2;

    public Integer getVhsyudisptkhrkkkn2() {
        return vhsyudisptkhrkkkn2;
    }

    public void setVhsyudisptkhrkkkn2(Integer pVhsyudisptkhrkkkn2) {
        vhsyudisptkhrkkkn2 = pVhsyudisptkhrkkkn2;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn2;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn2() {
        return vhsyudisptkhrkkknsmnkbn2;
    }

    public void setVhsyudisptkhrkkknsmnkbn2(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn2) {
        vhsyudisptkhrkkknsmnkbn2 = pVhsyudisptkhrkkknsmnkbn2;
    }

    private BizDate vhsyudisptkkykymd2;

    public BizDate getVhsyudisptkkykymd2() {
        return vhsyudisptkkykymd2;
    }

    public void setVhsyudisptkkykymd2(BizDate pVhsyudisptkkykymd2) {
        vhsyudisptkkykymd2 = pVhsyudisptkkykymd2;
    }

    private BizDate vhsyudisptksknnkaisiymd2;

    public BizDate getVhsyudisptksknnkaisiymd2() {
        return vhsyudisptksknnkaisiymd2;
    }

    public void setVhsyudisptksknnkaisiymd2(BizDate pVhsyudisptksknnkaisiymd2) {
        vhsyudisptksknnkaisiymd2 = pVhsyudisptksknnkaisiymd2;
    }

    private BizDate vhsyudisptkhkskkaisiymd2;

    public BizDate getVhsyudisptkhkskkaisiymd2() {
        return vhsyudisptkhkskkaisiymd2;
    }

    public void setVhsyudisptkhkskkaisiymd2(BizDate pVhsyudisptkhkskkaisiymd2) {
        vhsyudisptkhkskkaisiymd2 = pVhsyudisptkhkskkaisiymd2;
    }

    private BizCurrency vhsyudisptkkihons2;

    public BizCurrency getVhsyudisptkkihons2() {
        return vhsyudisptkkihons2;
    }

    public void setVhsyudisptkkihons2(BizCurrency pVhsyudisptkkihons2) {
        vhsyudisptkkihons2 = pVhsyudisptkkihons2;
    }

    private BizCurrency vhsyudisptktkjyp2;

    public BizCurrency getVhsyudisptktkjyp2() {
        return vhsyudisptktkjyp2;
    }

    public void setVhsyudisptktkjyp2(BizCurrency pVhsyudisptktkjyp2) {
        vhsyudisptktkjyp2 = pVhsyudisptktkjyp2;
    }

    private String vhsyudisptkhtnpbuicd12;

    public String getVhsyudisptkhtnpbuicd12() {
        return vhsyudisptkhtnpbuicd12;
    }

    public void setVhsyudisptkhtnpbuicd12(String pVhsyudisptkhtnpbuicd12) {
        vhsyudisptkhtnpbuicd12 = pVhsyudisptkhtnpbuicd12;
    }

    private String vhsyudisptkhtnpbuinm12;

    public String getVhsyudisptkhtnpbuinm12() {
        return vhsyudisptkhtnpbuinm12;
    }

    public void setVhsyudisptkhtnpbuinm12(String pVhsyudisptkhtnpbuinm12) {
        vhsyudisptkhtnpbuinm12 = pVhsyudisptkhtnpbuinm12;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn12;

    public C_Htnpkkn getVhsyudisptkhtnpkkn12() {
        return vhsyudisptkhtnpkkn12;
    }

    public void setVhsyudisptkhtnpkkn12(C_Htnpkkn pVhsyudisptkhtnpkkn12) {
        vhsyudisptkhtnpkkn12 = pVhsyudisptkhtnpkkn12;
    }

    private String vhsyudisptkhtnpbuicd22;

    public String getVhsyudisptkhtnpbuicd22() {
        return vhsyudisptkhtnpbuicd22;
    }

    public void setVhsyudisptkhtnpbuicd22(String pVhsyudisptkhtnpbuicd22) {
        vhsyudisptkhtnpbuicd22 = pVhsyudisptkhtnpbuicd22;
    }

    private String vhsyudisptkhtnpbuinm22;

    public String getVhsyudisptkhtnpbuinm22() {
        return vhsyudisptkhtnpbuinm22;
    }

    public void setVhsyudisptkhtnpbuinm22(String pVhsyudisptkhtnpbuinm22) {
        vhsyudisptkhtnpbuinm22 = pVhsyudisptkhtnpbuinm22;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn22;

    public C_Htnpkkn getVhsyudisptkhtnpkkn22() {
        return vhsyudisptkhtnpkkn22;
    }

    public void setVhsyudisptkhtnpkkn22(C_Htnpkkn pVhsyudisptkhtnpkkn22) {
        vhsyudisptkhtnpkkn22 = pVhsyudisptkhtnpkkn22;
    }

    private String vhsyudisptkhtnpbuicd32;

    public String getVhsyudisptkhtnpbuicd32() {
        return vhsyudisptkhtnpbuicd32;
    }

    public void setVhsyudisptkhtnpbuicd32(String pVhsyudisptkhtnpbuicd32) {
        vhsyudisptkhtnpbuicd32 = pVhsyudisptkhtnpbuicd32;
    }

    private String vhsyudisptkhtnpbuinm32;

    public String getVhsyudisptkhtnpbuinm32() {
        return vhsyudisptkhtnpbuinm32;
    }

    public void setVhsyudisptkhtnpbuinm32(String pVhsyudisptkhtnpbuinm32) {
        vhsyudisptkhtnpbuinm32 = pVhsyudisptkhtnpbuinm32;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn32;

    public C_Htnpkkn getVhsyudisptkhtnpkkn32() {
        return vhsyudisptkhtnpkkn32;
    }

    public void setVhsyudisptkhtnpkkn32(C_Htnpkkn pVhsyudisptkhtnpkkn32) {
        vhsyudisptkhtnpkkn32 = pVhsyudisptkhtnpkkn32;
    }

    private String vhsyudisptkhtnpbuicd42;

    public String getVhsyudisptkhtnpbuicd42() {
        return vhsyudisptkhtnpbuicd42;
    }

    public void setVhsyudisptkhtnpbuicd42(String pVhsyudisptkhtnpbuicd42) {
        vhsyudisptkhtnpbuicd42 = pVhsyudisptkhtnpbuicd42;
    }

    private String vhsyudisptkhtnpbuinm42;

    public String getVhsyudisptkhtnpbuinm42() {
        return vhsyudisptkhtnpbuinm42;
    }

    public void setVhsyudisptkhtnpbuinm42(String pVhsyudisptkhtnpbuinm42) {
        vhsyudisptkhtnpbuinm42 = pVhsyudisptkhtnpbuinm42;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn42;

    public C_Htnpkkn getVhsyudisptkhtnpkkn42() {
        return vhsyudisptkhtnpkkn42;
    }

    public void setVhsyudisptkhtnpkkn42(C_Htnpkkn pVhsyudisptkhtnpkkn42) {
        vhsyudisptkhtnpkkn42 = pVhsyudisptkhtnpkkn42;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn2;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn2() {
        return vhsyudisptktkkdsghtpkbn2;
    }

    public void setVhsyudisptktkkdsghtpkbn2(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn2) {
        vhsyudisptktkkdsghtpkbn2 = pVhsyudisptktkkdsghtpkbn2;
    }

    private String vhsyudisptksyouhnnm3;

    public String getVhsyudisptksyouhnnm3() {
        return vhsyudisptksyouhnnm3;
    }

    public void setVhsyudisptksyouhnnm3(String pVhsyudisptksyouhnnm3) {
        vhsyudisptksyouhnnm3 = pVhsyudisptksyouhnnm3;
    }

    private Integer vhsyudisptkhknkkn3;

    public Integer getVhsyudisptkhknkkn3() {
        return vhsyudisptkhknkkn3;
    }

    public void setVhsyudisptkhknkkn3(Integer pVhsyudisptkhknkkn3) {
        vhsyudisptkhknkkn3 = pVhsyudisptkhknkkn3;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn3;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn3() {
        return vhsyudisptkhknkknsmnkbn3;
    }

    public void setVhsyudisptkhknkknsmnkbn3(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn3) {
        vhsyudisptkhknkknsmnkbn3 = pVhsyudisptkhknkknsmnkbn3;
    }

    private Integer vhsyudisptkhrkkkn3;

    public Integer getVhsyudisptkhrkkkn3() {
        return vhsyudisptkhrkkkn3;
    }

    public void setVhsyudisptkhrkkkn3(Integer pVhsyudisptkhrkkkn3) {
        vhsyudisptkhrkkkn3 = pVhsyudisptkhrkkkn3;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn3;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn3() {
        return vhsyudisptkhrkkknsmnkbn3;
    }

    public void setVhsyudisptkhrkkknsmnkbn3(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn3) {
        vhsyudisptkhrkkknsmnkbn3 = pVhsyudisptkhrkkknsmnkbn3;
    }

    private BizDate vhsyudisptkkykymd3;

    public BizDate getVhsyudisptkkykymd3() {
        return vhsyudisptkkykymd3;
    }

    public void setVhsyudisptkkykymd3(BizDate pVhsyudisptkkykymd3) {
        vhsyudisptkkykymd3 = pVhsyudisptkkykymd3;
    }

    private BizDate vhsyudisptksknnkaisiymd3;

    public BizDate getVhsyudisptksknnkaisiymd3() {
        return vhsyudisptksknnkaisiymd3;
    }

    public void setVhsyudisptksknnkaisiymd3(BizDate pVhsyudisptksknnkaisiymd3) {
        vhsyudisptksknnkaisiymd3 = pVhsyudisptksknnkaisiymd3;
    }

    private BizDate vhsyudisptkhkskkaisiymd3;

    public BizDate getVhsyudisptkhkskkaisiymd3() {
        return vhsyudisptkhkskkaisiymd3;
    }

    public void setVhsyudisptkhkskkaisiymd3(BizDate pVhsyudisptkhkskkaisiymd3) {
        vhsyudisptkhkskkaisiymd3 = pVhsyudisptkhkskkaisiymd3;
    }

    private BizCurrency vhsyudisptkkihons3;

    public BizCurrency getVhsyudisptkkihons3() {
        return vhsyudisptkkihons3;
    }

    public void setVhsyudisptkkihons3(BizCurrency pVhsyudisptkkihons3) {
        vhsyudisptkkihons3 = pVhsyudisptkkihons3;
    }

    private BizCurrency vhsyudisptktkjyp3;

    public BizCurrency getVhsyudisptktkjyp3() {
        return vhsyudisptktkjyp3;
    }

    public void setVhsyudisptktkjyp3(BizCurrency pVhsyudisptktkjyp3) {
        vhsyudisptktkjyp3 = pVhsyudisptktkjyp3;
    }

    private String vhsyudisptkhtnpbuicd13;

    public String getVhsyudisptkhtnpbuicd13() {
        return vhsyudisptkhtnpbuicd13;
    }

    public void setVhsyudisptkhtnpbuicd13(String pVhsyudisptkhtnpbuicd13) {
        vhsyudisptkhtnpbuicd13 = pVhsyudisptkhtnpbuicd13;
    }

    private String vhsyudisptkhtnpbuinm13;

    public String getVhsyudisptkhtnpbuinm13() {
        return vhsyudisptkhtnpbuinm13;
    }

    public void setVhsyudisptkhtnpbuinm13(String pVhsyudisptkhtnpbuinm13) {
        vhsyudisptkhtnpbuinm13 = pVhsyudisptkhtnpbuinm13;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn13;

    public C_Htnpkkn getVhsyudisptkhtnpkkn13() {
        return vhsyudisptkhtnpkkn13;
    }

    public void setVhsyudisptkhtnpkkn13(C_Htnpkkn pVhsyudisptkhtnpkkn13) {
        vhsyudisptkhtnpkkn13 = pVhsyudisptkhtnpkkn13;
    }

    private String vhsyudisptkhtnpbuicd23;

    public String getVhsyudisptkhtnpbuicd23() {
        return vhsyudisptkhtnpbuicd23;
    }

    public void setVhsyudisptkhtnpbuicd23(String pVhsyudisptkhtnpbuicd23) {
        vhsyudisptkhtnpbuicd23 = pVhsyudisptkhtnpbuicd23;
    }

    private String vhsyudisptkhtnpbuinm23;

    public String getVhsyudisptkhtnpbuinm23() {
        return vhsyudisptkhtnpbuinm23;
    }

    public void setVhsyudisptkhtnpbuinm23(String pVhsyudisptkhtnpbuinm23) {
        vhsyudisptkhtnpbuinm23 = pVhsyudisptkhtnpbuinm23;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn23;

    public C_Htnpkkn getVhsyudisptkhtnpkkn23() {
        return vhsyudisptkhtnpkkn23;
    }

    public void setVhsyudisptkhtnpkkn23(C_Htnpkkn pVhsyudisptkhtnpkkn23) {
        vhsyudisptkhtnpkkn23 = pVhsyudisptkhtnpkkn23;
    }

    private String vhsyudisptkhtnpbuicd33;

    public String getVhsyudisptkhtnpbuicd33() {
        return vhsyudisptkhtnpbuicd33;
    }

    public void setVhsyudisptkhtnpbuicd33(String pVhsyudisptkhtnpbuicd33) {
        vhsyudisptkhtnpbuicd33 = pVhsyudisptkhtnpbuicd33;
    }

    private String vhsyudisptkhtnpbuinm33;

    public String getVhsyudisptkhtnpbuinm33() {
        return vhsyudisptkhtnpbuinm33;
    }

    public void setVhsyudisptkhtnpbuinm33(String pVhsyudisptkhtnpbuinm33) {
        vhsyudisptkhtnpbuinm33 = pVhsyudisptkhtnpbuinm33;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn33;

    public C_Htnpkkn getVhsyudisptkhtnpkkn33() {
        return vhsyudisptkhtnpkkn33;
    }

    public void setVhsyudisptkhtnpkkn33(C_Htnpkkn pVhsyudisptkhtnpkkn33) {
        vhsyudisptkhtnpkkn33 = pVhsyudisptkhtnpkkn33;
    }

    private String vhsyudisptkhtnpbuicd43;

    public String getVhsyudisptkhtnpbuicd43() {
        return vhsyudisptkhtnpbuicd43;
    }

    public void setVhsyudisptkhtnpbuicd43(String pVhsyudisptkhtnpbuicd43) {
        vhsyudisptkhtnpbuicd43 = pVhsyudisptkhtnpbuicd43;
    }

    private String vhsyudisptkhtnpbuinm43;

    public String getVhsyudisptkhtnpbuinm43() {
        return vhsyudisptkhtnpbuinm43;
    }

    public void setVhsyudisptkhtnpbuinm43(String pVhsyudisptkhtnpbuinm43) {
        vhsyudisptkhtnpbuinm43 = pVhsyudisptkhtnpbuinm43;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn43;

    public C_Htnpkkn getVhsyudisptkhtnpkkn43() {
        return vhsyudisptkhtnpkkn43;
    }

    public void setVhsyudisptkhtnpkkn43(C_Htnpkkn pVhsyudisptkhtnpkkn43) {
        vhsyudisptkhtnpkkn43 = pVhsyudisptkhtnpkkn43;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn3;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn3() {
        return vhsyudisptktkkdsghtpkbn3;
    }

    public void setVhsyudisptktkkdsghtpkbn3(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn3) {
        vhsyudisptktkkdsghtpkbn3 = pVhsyudisptktkkdsghtpkbn3;
    }

    private String vhsyudisptksyouhnnm4;

    public String getVhsyudisptksyouhnnm4() {
        return vhsyudisptksyouhnnm4;
    }

    public void setVhsyudisptksyouhnnm4(String pVhsyudisptksyouhnnm4) {
        vhsyudisptksyouhnnm4 = pVhsyudisptksyouhnnm4;
    }

    private Integer vhsyudisptkhknkkn4;

    public Integer getVhsyudisptkhknkkn4() {
        return vhsyudisptkhknkkn4;
    }

    public void setVhsyudisptkhknkkn4(Integer pVhsyudisptkhknkkn4) {
        vhsyudisptkhknkkn4 = pVhsyudisptkhknkkn4;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn4;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn4() {
        return vhsyudisptkhknkknsmnkbn4;
    }

    public void setVhsyudisptkhknkknsmnkbn4(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn4) {
        vhsyudisptkhknkknsmnkbn4 = pVhsyudisptkhknkknsmnkbn4;
    }

    private Integer vhsyudisptkhrkkkn4;

    public Integer getVhsyudisptkhrkkkn4() {
        return vhsyudisptkhrkkkn4;
    }

    public void setVhsyudisptkhrkkkn4(Integer pVhsyudisptkhrkkkn4) {
        vhsyudisptkhrkkkn4 = pVhsyudisptkhrkkkn4;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn4;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn4() {
        return vhsyudisptkhrkkknsmnkbn4;
    }

    public void setVhsyudisptkhrkkknsmnkbn4(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn4) {
        vhsyudisptkhrkkknsmnkbn4 = pVhsyudisptkhrkkknsmnkbn4;
    }

    private BizDate vhsyudisptkkykymd4;

    public BizDate getVhsyudisptkkykymd4() {
        return vhsyudisptkkykymd4;
    }

    public void setVhsyudisptkkykymd4(BizDate pVhsyudisptkkykymd4) {
        vhsyudisptkkykymd4 = pVhsyudisptkkykymd4;
    }

    private BizDate vhsyudisptksknnkaisiymd4;

    public BizDate getVhsyudisptksknnkaisiymd4() {
        return vhsyudisptksknnkaisiymd4;
    }

    public void setVhsyudisptksknnkaisiymd4(BizDate pVhsyudisptksknnkaisiymd4) {
        vhsyudisptksknnkaisiymd4 = pVhsyudisptksknnkaisiymd4;
    }

    private BizDate vhsyudisptkhkskkaisiymd4;

    public BizDate getVhsyudisptkhkskkaisiymd4() {
        return vhsyudisptkhkskkaisiymd4;
    }

    public void setVhsyudisptkhkskkaisiymd4(BizDate pVhsyudisptkhkskkaisiymd4) {
        vhsyudisptkhkskkaisiymd4 = pVhsyudisptkhkskkaisiymd4;
    }

    private BizCurrency vhsyudisptkkihons4;

    public BizCurrency getVhsyudisptkkihons4() {
        return vhsyudisptkkihons4;
    }

    public void setVhsyudisptkkihons4(BizCurrency pVhsyudisptkkihons4) {
        vhsyudisptkkihons4 = pVhsyudisptkkihons4;
    }

    private BizCurrency vhsyudisptktkjyp4;

    public BizCurrency getVhsyudisptktkjyp4() {
        return vhsyudisptktkjyp4;
    }

    public void setVhsyudisptktkjyp4(BizCurrency pVhsyudisptktkjyp4) {
        vhsyudisptktkjyp4 = pVhsyudisptktkjyp4;
    }

    private String vhsyudisptkhtnpbuicd14;

    public String getVhsyudisptkhtnpbuicd14() {
        return vhsyudisptkhtnpbuicd14;
    }

    public void setVhsyudisptkhtnpbuicd14(String pVhsyudisptkhtnpbuicd14) {
        vhsyudisptkhtnpbuicd14 = pVhsyudisptkhtnpbuicd14;
    }

    private String vhsyudisptkhtnpbuinm14;

    public String getVhsyudisptkhtnpbuinm14() {
        return vhsyudisptkhtnpbuinm14;
    }

    public void setVhsyudisptkhtnpbuinm14(String pVhsyudisptkhtnpbuinm14) {
        vhsyudisptkhtnpbuinm14 = pVhsyudisptkhtnpbuinm14;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn14;

    public C_Htnpkkn getVhsyudisptkhtnpkkn14() {
        return vhsyudisptkhtnpkkn14;
    }

    public void setVhsyudisptkhtnpkkn14(C_Htnpkkn pVhsyudisptkhtnpkkn14) {
        vhsyudisptkhtnpkkn14 = pVhsyudisptkhtnpkkn14;
    }

    private String vhsyudisptkhtnpbuicd24;

    public String getVhsyudisptkhtnpbuicd24() {
        return vhsyudisptkhtnpbuicd24;
    }

    public void setVhsyudisptkhtnpbuicd24(String pVhsyudisptkhtnpbuicd24) {
        vhsyudisptkhtnpbuicd24 = pVhsyudisptkhtnpbuicd24;
    }

    private String vhsyudisptkhtnpbuinm24;

    public String getVhsyudisptkhtnpbuinm24() {
        return vhsyudisptkhtnpbuinm24;
    }

    public void setVhsyudisptkhtnpbuinm24(String pVhsyudisptkhtnpbuinm24) {
        vhsyudisptkhtnpbuinm24 = pVhsyudisptkhtnpbuinm24;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn24;

    public C_Htnpkkn getVhsyudisptkhtnpkkn24() {
        return vhsyudisptkhtnpkkn24;
    }

    public void setVhsyudisptkhtnpkkn24(C_Htnpkkn pVhsyudisptkhtnpkkn24) {
        vhsyudisptkhtnpkkn24 = pVhsyudisptkhtnpkkn24;
    }

    private String vhsyudisptkhtnpbuicd34;

    public String getVhsyudisptkhtnpbuicd34() {
        return vhsyudisptkhtnpbuicd34;
    }

    public void setVhsyudisptkhtnpbuicd34(String pVhsyudisptkhtnpbuicd34) {
        vhsyudisptkhtnpbuicd34 = pVhsyudisptkhtnpbuicd34;
    }

    private String vhsyudisptkhtnpbuinm34;

    public String getVhsyudisptkhtnpbuinm34() {
        return vhsyudisptkhtnpbuinm34;
    }

    public void setVhsyudisptkhtnpbuinm34(String pVhsyudisptkhtnpbuinm34) {
        vhsyudisptkhtnpbuinm34 = pVhsyudisptkhtnpbuinm34;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn34;

    public C_Htnpkkn getVhsyudisptkhtnpkkn34() {
        return vhsyudisptkhtnpkkn34;
    }

    public void setVhsyudisptkhtnpkkn34(C_Htnpkkn pVhsyudisptkhtnpkkn34) {
        vhsyudisptkhtnpkkn34 = pVhsyudisptkhtnpkkn34;
    }

    private String vhsyudisptkhtnpbuicd44;

    public String getVhsyudisptkhtnpbuicd44() {
        return vhsyudisptkhtnpbuicd44;
    }

    public void setVhsyudisptkhtnpbuicd44(String pVhsyudisptkhtnpbuicd44) {
        vhsyudisptkhtnpbuicd44 = pVhsyudisptkhtnpbuicd44;
    }

    private String vhsyudisptkhtnpbuinm44;

    public String getVhsyudisptkhtnpbuinm44() {
        return vhsyudisptkhtnpbuinm44;
    }

    public void setVhsyudisptkhtnpbuinm44(String pVhsyudisptkhtnpbuinm44) {
        vhsyudisptkhtnpbuinm44 = pVhsyudisptkhtnpbuinm44;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn44;

    public C_Htnpkkn getVhsyudisptkhtnpkkn44() {
        return vhsyudisptkhtnpkkn44;
    }

    public void setVhsyudisptkhtnpkkn44(C_Htnpkkn pVhsyudisptkhtnpkkn44) {
        vhsyudisptkhtnpkkn44 = pVhsyudisptkhtnpkkn44;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn4;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn4() {
        return vhsyudisptktkkdsghtpkbn4;
    }

    public void setVhsyudisptktkkdsghtpkbn4(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn4) {
        vhsyudisptktkkdsghtpkbn4 = pVhsyudisptktkkdsghtpkbn4;
    }

    private String vhsyudisptksyouhnnm5;

    public String getVhsyudisptksyouhnnm5() {
        return vhsyudisptksyouhnnm5;
    }

    public void setVhsyudisptksyouhnnm5(String pVhsyudisptksyouhnnm5) {
        vhsyudisptksyouhnnm5 = pVhsyudisptksyouhnnm5;
    }

    private Integer vhsyudisptkhknkkn5;

    public Integer getVhsyudisptkhknkkn5() {
        return vhsyudisptkhknkkn5;
    }

    public void setVhsyudisptkhknkkn5(Integer pVhsyudisptkhknkkn5) {
        vhsyudisptkhknkkn5 = pVhsyudisptkhknkkn5;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn5;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn5() {
        return vhsyudisptkhknkknsmnkbn5;
    }

    public void setVhsyudisptkhknkknsmnkbn5(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn5) {
        vhsyudisptkhknkknsmnkbn5 = pVhsyudisptkhknkknsmnkbn5;
    }

    private Integer vhsyudisptkhrkkkn5;

    public Integer getVhsyudisptkhrkkkn5() {
        return vhsyudisptkhrkkkn5;
    }

    public void setVhsyudisptkhrkkkn5(Integer pVhsyudisptkhrkkkn5) {
        vhsyudisptkhrkkkn5 = pVhsyudisptkhrkkkn5;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn5;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn5() {
        return vhsyudisptkhrkkknsmnkbn5;
    }

    public void setVhsyudisptkhrkkknsmnkbn5(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn5) {
        vhsyudisptkhrkkknsmnkbn5 = pVhsyudisptkhrkkknsmnkbn5;
    }

    private BizDate vhsyudisptkkykymd5;

    public BizDate getVhsyudisptkkykymd5() {
        return vhsyudisptkkykymd5;
    }

    public void setVhsyudisptkkykymd5(BizDate pVhsyudisptkkykymd5) {
        vhsyudisptkkykymd5 = pVhsyudisptkkykymd5;
    }

    private BizDate vhsyudisptksknnkaisiymd5;

    public BizDate getVhsyudisptksknnkaisiymd5() {
        return vhsyudisptksknnkaisiymd5;
    }

    public void setVhsyudisptksknnkaisiymd5(BizDate pVhsyudisptksknnkaisiymd5) {
        vhsyudisptksknnkaisiymd5 = pVhsyudisptksknnkaisiymd5;
    }

    private BizDate vhsyudisptkhkskkaisiymd5;

    public BizDate getVhsyudisptkhkskkaisiymd5() {
        return vhsyudisptkhkskkaisiymd5;
    }

    public void setVhsyudisptkhkskkaisiymd5(BizDate pVhsyudisptkhkskkaisiymd5) {
        vhsyudisptkhkskkaisiymd5 = pVhsyudisptkhkskkaisiymd5;
    }

    private BizCurrency vhsyudisptkkihons5;

    public BizCurrency getVhsyudisptkkihons5() {
        return vhsyudisptkkihons5;
    }

    public void setVhsyudisptkkihons5(BizCurrency pVhsyudisptkkihons5) {
        vhsyudisptkkihons5 = pVhsyudisptkkihons5;
    }

    private BizCurrency vhsyudisptktkjyp5;

    public BizCurrency getVhsyudisptktkjyp5() {
        return vhsyudisptktkjyp5;
    }

    public void setVhsyudisptktkjyp5(BizCurrency pVhsyudisptktkjyp5) {
        vhsyudisptktkjyp5 = pVhsyudisptktkjyp5;
    }

    private String vhsyudisptkhtnpbuicd15;

    public String getVhsyudisptkhtnpbuicd15() {
        return vhsyudisptkhtnpbuicd15;
    }

    public void setVhsyudisptkhtnpbuicd15(String pVhsyudisptkhtnpbuicd15) {
        vhsyudisptkhtnpbuicd15 = pVhsyudisptkhtnpbuicd15;
    }

    private String vhsyudisptkhtnpbuinm15;

    public String getVhsyudisptkhtnpbuinm15() {
        return vhsyudisptkhtnpbuinm15;
    }

    public void setVhsyudisptkhtnpbuinm15(String pVhsyudisptkhtnpbuinm15) {
        vhsyudisptkhtnpbuinm15 = pVhsyudisptkhtnpbuinm15;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn15;

    public C_Htnpkkn getVhsyudisptkhtnpkkn15() {
        return vhsyudisptkhtnpkkn15;
    }

    public void setVhsyudisptkhtnpkkn15(C_Htnpkkn pVhsyudisptkhtnpkkn15) {
        vhsyudisptkhtnpkkn15 = pVhsyudisptkhtnpkkn15;
    }

    private String vhsyudisptkhtnpbuicd25;

    public String getVhsyudisptkhtnpbuicd25() {
        return vhsyudisptkhtnpbuicd25;
    }

    public void setVhsyudisptkhtnpbuicd25(String pVhsyudisptkhtnpbuicd25) {
        vhsyudisptkhtnpbuicd25 = pVhsyudisptkhtnpbuicd25;
    }

    private String vhsyudisptkhtnpbuinm25;

    public String getVhsyudisptkhtnpbuinm25() {
        return vhsyudisptkhtnpbuinm25;
    }

    public void setVhsyudisptkhtnpbuinm25(String pVhsyudisptkhtnpbuinm25) {
        vhsyudisptkhtnpbuinm25 = pVhsyudisptkhtnpbuinm25;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn25;

    public C_Htnpkkn getVhsyudisptkhtnpkkn25() {
        return vhsyudisptkhtnpkkn25;
    }

    public void setVhsyudisptkhtnpkkn25(C_Htnpkkn pVhsyudisptkhtnpkkn25) {
        vhsyudisptkhtnpkkn25 = pVhsyudisptkhtnpkkn25;
    }

    private String vhsyudisptkhtnpbuicd35;

    public String getVhsyudisptkhtnpbuicd35() {
        return vhsyudisptkhtnpbuicd35;
    }

    public void setVhsyudisptkhtnpbuicd35(String pVhsyudisptkhtnpbuicd35) {
        vhsyudisptkhtnpbuicd35 = pVhsyudisptkhtnpbuicd35;
    }

    private String vhsyudisptkhtnpbuinm35;

    public String getVhsyudisptkhtnpbuinm35() {
        return vhsyudisptkhtnpbuinm35;
    }

    public void setVhsyudisptkhtnpbuinm35(String pVhsyudisptkhtnpbuinm35) {
        vhsyudisptkhtnpbuinm35 = pVhsyudisptkhtnpbuinm35;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn35;

    public C_Htnpkkn getVhsyudisptkhtnpkkn35() {
        return vhsyudisptkhtnpkkn35;
    }

    public void setVhsyudisptkhtnpkkn35(C_Htnpkkn pVhsyudisptkhtnpkkn35) {
        vhsyudisptkhtnpkkn35 = pVhsyudisptkhtnpkkn35;
    }

    private String vhsyudisptkhtnpbuicd45;

    public String getVhsyudisptkhtnpbuicd45() {
        return vhsyudisptkhtnpbuicd45;
    }

    public void setVhsyudisptkhtnpbuicd45(String pVhsyudisptkhtnpbuicd45) {
        vhsyudisptkhtnpbuicd45 = pVhsyudisptkhtnpbuicd45;
    }

    private String vhsyudisptkhtnpbuinm45;

    public String getVhsyudisptkhtnpbuinm45() {
        return vhsyudisptkhtnpbuinm45;
    }

    public void setVhsyudisptkhtnpbuinm45(String pVhsyudisptkhtnpbuinm45) {
        vhsyudisptkhtnpbuinm45 = pVhsyudisptkhtnpbuinm45;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn45;

    public C_Htnpkkn getVhsyudisptkhtnpkkn45() {
        return vhsyudisptkhtnpkkn45;
    }

    public void setVhsyudisptkhtnpkkn45(C_Htnpkkn pVhsyudisptkhtnpkkn45) {
        vhsyudisptkhtnpkkn45 = pVhsyudisptkhtnpkkn45;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn5;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn5() {
        return vhsyudisptktkkdsghtpkbn5;
    }

    public void setVhsyudisptktkkdsghtpkbn5(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn5) {
        vhsyudisptktkkdsghtpkbn5 = pVhsyudisptktkkdsghtpkbn5;
    }

    private String vhsyudisptksyouhnnm6;

    public String getVhsyudisptksyouhnnm6() {
        return vhsyudisptksyouhnnm6;
    }

    public void setVhsyudisptksyouhnnm6(String pVhsyudisptksyouhnnm6) {
        vhsyudisptksyouhnnm6 = pVhsyudisptksyouhnnm6;
    }

    private Integer vhsyudisptkhknkkn6;

    public Integer getVhsyudisptkhknkkn6() {
        return vhsyudisptkhknkkn6;
    }

    public void setVhsyudisptkhknkkn6(Integer pVhsyudisptkhknkkn6) {
        vhsyudisptkhknkkn6 = pVhsyudisptkhknkkn6;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn6;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn6() {
        return vhsyudisptkhknkknsmnkbn6;
    }

    public void setVhsyudisptkhknkknsmnkbn6(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn6) {
        vhsyudisptkhknkknsmnkbn6 = pVhsyudisptkhknkknsmnkbn6;
    }

    private Integer vhsyudisptkhrkkkn6;

    public Integer getVhsyudisptkhrkkkn6() {
        return vhsyudisptkhrkkkn6;
    }

    public void setVhsyudisptkhrkkkn6(Integer pVhsyudisptkhrkkkn6) {
        vhsyudisptkhrkkkn6 = pVhsyudisptkhrkkkn6;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn6;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn6() {
        return vhsyudisptkhrkkknsmnkbn6;
    }

    public void setVhsyudisptkhrkkknsmnkbn6(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn6) {
        vhsyudisptkhrkkknsmnkbn6 = pVhsyudisptkhrkkknsmnkbn6;
    }

    private BizDate vhsyudisptkkykymd6;

    public BizDate getVhsyudisptkkykymd6() {
        return vhsyudisptkkykymd6;
    }

    public void setVhsyudisptkkykymd6(BizDate pVhsyudisptkkykymd6) {
        vhsyudisptkkykymd6 = pVhsyudisptkkykymd6;
    }

    private BizDate vhsyudisptksknnkaisiymd6;

    public BizDate getVhsyudisptksknnkaisiymd6() {
        return vhsyudisptksknnkaisiymd6;
    }

    public void setVhsyudisptksknnkaisiymd6(BizDate pVhsyudisptksknnkaisiymd6) {
        vhsyudisptksknnkaisiymd6 = pVhsyudisptksknnkaisiymd6;
    }

    private BizDate vhsyudisptkhkskkaisiymd6;

    public BizDate getVhsyudisptkhkskkaisiymd6() {
        return vhsyudisptkhkskkaisiymd6;
    }

    public void setVhsyudisptkhkskkaisiymd6(BizDate pVhsyudisptkhkskkaisiymd6) {
        vhsyudisptkhkskkaisiymd6 = pVhsyudisptkhkskkaisiymd6;
    }

    private BizCurrency vhsyudisptkkihons6;

    public BizCurrency getVhsyudisptkkihons6() {
        return vhsyudisptkkihons6;
    }

    public void setVhsyudisptkkihons6(BizCurrency pVhsyudisptkkihons6) {
        vhsyudisptkkihons6 = pVhsyudisptkkihons6;
    }

    private BizCurrency vhsyudisptktkjyp6;

    public BizCurrency getVhsyudisptktkjyp6() {
        return vhsyudisptktkjyp6;
    }

    public void setVhsyudisptktkjyp6(BizCurrency pVhsyudisptktkjyp6) {
        vhsyudisptktkjyp6 = pVhsyudisptktkjyp6;
    }

    private String vhsyudisptkhtnpbuicd16;

    public String getVhsyudisptkhtnpbuicd16() {
        return vhsyudisptkhtnpbuicd16;
    }

    public void setVhsyudisptkhtnpbuicd16(String pVhsyudisptkhtnpbuicd16) {
        vhsyudisptkhtnpbuicd16 = pVhsyudisptkhtnpbuicd16;
    }

    private String vhsyudisptkhtnpbuinm16;

    public String getVhsyudisptkhtnpbuinm16() {
        return vhsyudisptkhtnpbuinm16;
    }

    public void setVhsyudisptkhtnpbuinm16(String pVhsyudisptkhtnpbuinm16) {
        vhsyudisptkhtnpbuinm16 = pVhsyudisptkhtnpbuinm16;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn16;

    public C_Htnpkkn getVhsyudisptkhtnpkkn16() {
        return vhsyudisptkhtnpkkn16;
    }

    public void setVhsyudisptkhtnpkkn16(C_Htnpkkn pVhsyudisptkhtnpkkn16) {
        vhsyudisptkhtnpkkn16 = pVhsyudisptkhtnpkkn16;
    }

    private String vhsyudisptkhtnpbuicd26;

    public String getVhsyudisptkhtnpbuicd26() {
        return vhsyudisptkhtnpbuicd26;
    }

    public void setVhsyudisptkhtnpbuicd26(String pVhsyudisptkhtnpbuicd26) {
        vhsyudisptkhtnpbuicd26 = pVhsyudisptkhtnpbuicd26;
    }

    private String vhsyudisptkhtnpbuinm26;

    public String getVhsyudisptkhtnpbuinm26() {
        return vhsyudisptkhtnpbuinm26;
    }

    public void setVhsyudisptkhtnpbuinm26(String pVhsyudisptkhtnpbuinm26) {
        vhsyudisptkhtnpbuinm26 = pVhsyudisptkhtnpbuinm26;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn26;

    public C_Htnpkkn getVhsyudisptkhtnpkkn26() {
        return vhsyudisptkhtnpkkn26;
    }

    public void setVhsyudisptkhtnpkkn26(C_Htnpkkn pVhsyudisptkhtnpkkn26) {
        vhsyudisptkhtnpkkn26 = pVhsyudisptkhtnpkkn26;
    }

    private String vhsyudisptkhtnpbuicd36;

    public String getVhsyudisptkhtnpbuicd36() {
        return vhsyudisptkhtnpbuicd36;
    }

    public void setVhsyudisptkhtnpbuicd36(String pVhsyudisptkhtnpbuicd36) {
        vhsyudisptkhtnpbuicd36 = pVhsyudisptkhtnpbuicd36;
    }

    private String vhsyudisptkhtnpbuinm36;

    public String getVhsyudisptkhtnpbuinm36() {
        return vhsyudisptkhtnpbuinm36;
    }

    public void setVhsyudisptkhtnpbuinm36(String pVhsyudisptkhtnpbuinm36) {
        vhsyudisptkhtnpbuinm36 = pVhsyudisptkhtnpbuinm36;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn36;

    public C_Htnpkkn getVhsyudisptkhtnpkkn36() {
        return vhsyudisptkhtnpkkn36;
    }

    public void setVhsyudisptkhtnpkkn36(C_Htnpkkn pVhsyudisptkhtnpkkn36) {
        vhsyudisptkhtnpkkn36 = pVhsyudisptkhtnpkkn36;
    }

    private String vhsyudisptkhtnpbuicd46;

    public String getVhsyudisptkhtnpbuicd46() {
        return vhsyudisptkhtnpbuicd46;
    }

    public void setVhsyudisptkhtnpbuicd46(String pVhsyudisptkhtnpbuicd46) {
        vhsyudisptkhtnpbuicd46 = pVhsyudisptkhtnpbuicd46;
    }

    private String vhsyudisptkhtnpbuinm46;

    public String getVhsyudisptkhtnpbuinm46() {
        return vhsyudisptkhtnpbuinm46;
    }

    public void setVhsyudisptkhtnpbuinm46(String pVhsyudisptkhtnpbuinm46) {
        vhsyudisptkhtnpbuinm46 = pVhsyudisptkhtnpbuinm46;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn46;

    public C_Htnpkkn getVhsyudisptkhtnpkkn46() {
        return vhsyudisptkhtnpkkn46;
    }

    public void setVhsyudisptkhtnpkkn46(C_Htnpkkn pVhsyudisptkhtnpkkn46) {
        vhsyudisptkhtnpkkn46 = pVhsyudisptkhtnpkkn46;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn6;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn6() {
        return vhsyudisptktkkdsghtpkbn6;
    }

    public void setVhsyudisptktkkdsghtpkbn6(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn6) {
        vhsyudisptktkkdsghtpkbn6 = pVhsyudisptktkkdsghtpkbn6;
    }

    private String vhsyudisptksyouhnnm7;

    public String getVhsyudisptksyouhnnm7() {
        return vhsyudisptksyouhnnm7;
    }

    public void setVhsyudisptksyouhnnm7(String pVhsyudisptksyouhnnm7) {
        vhsyudisptksyouhnnm7 = pVhsyudisptksyouhnnm7;
    }

    private Integer vhsyudisptkhknkkn7;

    public Integer getVhsyudisptkhknkkn7() {
        return vhsyudisptkhknkkn7;
    }

    public void setVhsyudisptkhknkkn7(Integer pVhsyudisptkhknkkn7) {
        vhsyudisptkhknkkn7 = pVhsyudisptkhknkkn7;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn7;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn7() {
        return vhsyudisptkhknkknsmnkbn7;
    }

    public void setVhsyudisptkhknkknsmnkbn7(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn7) {
        vhsyudisptkhknkknsmnkbn7 = pVhsyudisptkhknkknsmnkbn7;
    }

    private Integer vhsyudisptkhrkkkn7;

    public Integer getVhsyudisptkhrkkkn7() {
        return vhsyudisptkhrkkkn7;
    }

    public void setVhsyudisptkhrkkkn7(Integer pVhsyudisptkhrkkkn7) {
        vhsyudisptkhrkkkn7 = pVhsyudisptkhrkkkn7;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn7;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn7() {
        return vhsyudisptkhrkkknsmnkbn7;
    }

    public void setVhsyudisptkhrkkknsmnkbn7(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn7) {
        vhsyudisptkhrkkknsmnkbn7 = pVhsyudisptkhrkkknsmnkbn7;
    }

    private BizDate vhsyudisptkkykymd7;

    public BizDate getVhsyudisptkkykymd7() {
        return vhsyudisptkkykymd7;
    }

    public void setVhsyudisptkkykymd7(BizDate pVhsyudisptkkykymd7) {
        vhsyudisptkkykymd7 = pVhsyudisptkkykymd7;
    }

    private BizDate vhsyudisptksknnkaisiymd7;

    public BizDate getVhsyudisptksknnkaisiymd7() {
        return vhsyudisptksknnkaisiymd7;
    }

    public void setVhsyudisptksknnkaisiymd7(BizDate pVhsyudisptksknnkaisiymd7) {
        vhsyudisptksknnkaisiymd7 = pVhsyudisptksknnkaisiymd7;
    }

    private BizDate vhsyudisptkhkskkaisiymd7;

    public BizDate getVhsyudisptkhkskkaisiymd7() {
        return vhsyudisptkhkskkaisiymd7;
    }

    public void setVhsyudisptkhkskkaisiymd7(BizDate pVhsyudisptkhkskkaisiymd7) {
        vhsyudisptkhkskkaisiymd7 = pVhsyudisptkhkskkaisiymd7;
    }

    private BizCurrency vhsyudisptkkihons7;

    public BizCurrency getVhsyudisptkkihons7() {
        return vhsyudisptkkihons7;
    }

    public void setVhsyudisptkkihons7(BizCurrency pVhsyudisptkkihons7) {
        vhsyudisptkkihons7 = pVhsyudisptkkihons7;
    }

    private BizCurrency vhsyudisptktkjyp7;

    public BizCurrency getVhsyudisptktkjyp7() {
        return vhsyudisptktkjyp7;
    }

    public void setVhsyudisptktkjyp7(BizCurrency pVhsyudisptktkjyp7) {
        vhsyudisptktkjyp7 = pVhsyudisptktkjyp7;
    }

    private String vhsyudisptkhtnpbuicd17;

    public String getVhsyudisptkhtnpbuicd17() {
        return vhsyudisptkhtnpbuicd17;
    }

    public void setVhsyudisptkhtnpbuicd17(String pVhsyudisptkhtnpbuicd17) {
        vhsyudisptkhtnpbuicd17 = pVhsyudisptkhtnpbuicd17;
    }

    private String vhsyudisptkhtnpbuinm17;

    public String getVhsyudisptkhtnpbuinm17() {
        return vhsyudisptkhtnpbuinm17;
    }

    public void setVhsyudisptkhtnpbuinm17(String pVhsyudisptkhtnpbuinm17) {
        vhsyudisptkhtnpbuinm17 = pVhsyudisptkhtnpbuinm17;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn17;

    public C_Htnpkkn getVhsyudisptkhtnpkkn17() {
        return vhsyudisptkhtnpkkn17;
    }

    public void setVhsyudisptkhtnpkkn17(C_Htnpkkn pVhsyudisptkhtnpkkn17) {
        vhsyudisptkhtnpkkn17 = pVhsyudisptkhtnpkkn17;
    }

    private String vhsyudisptkhtnpbuicd27;

    public String getVhsyudisptkhtnpbuicd27() {
        return vhsyudisptkhtnpbuicd27;
    }

    public void setVhsyudisptkhtnpbuicd27(String pVhsyudisptkhtnpbuicd27) {
        vhsyudisptkhtnpbuicd27 = pVhsyudisptkhtnpbuicd27;
    }

    private String vhsyudisptkhtnpbuinm27;

    public String getVhsyudisptkhtnpbuinm27() {
        return vhsyudisptkhtnpbuinm27;
    }

    public void setVhsyudisptkhtnpbuinm27(String pVhsyudisptkhtnpbuinm27) {
        vhsyudisptkhtnpbuinm27 = pVhsyudisptkhtnpbuinm27;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn27;

    public C_Htnpkkn getVhsyudisptkhtnpkkn27() {
        return vhsyudisptkhtnpkkn27;
    }

    public void setVhsyudisptkhtnpkkn27(C_Htnpkkn pVhsyudisptkhtnpkkn27) {
        vhsyudisptkhtnpkkn27 = pVhsyudisptkhtnpkkn27;
    }

    private String vhsyudisptkhtnpbuicd37;

    public String getVhsyudisptkhtnpbuicd37() {
        return vhsyudisptkhtnpbuicd37;
    }

    public void setVhsyudisptkhtnpbuicd37(String pVhsyudisptkhtnpbuicd37) {
        vhsyudisptkhtnpbuicd37 = pVhsyudisptkhtnpbuicd37;
    }

    private String vhsyudisptkhtnpbuinm37;

    public String getVhsyudisptkhtnpbuinm37() {
        return vhsyudisptkhtnpbuinm37;
    }

    public void setVhsyudisptkhtnpbuinm37(String pVhsyudisptkhtnpbuinm37) {
        vhsyudisptkhtnpbuinm37 = pVhsyudisptkhtnpbuinm37;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn37;

    public C_Htnpkkn getVhsyudisptkhtnpkkn37() {
        return vhsyudisptkhtnpkkn37;
    }

    public void setVhsyudisptkhtnpkkn37(C_Htnpkkn pVhsyudisptkhtnpkkn37) {
        vhsyudisptkhtnpkkn37 = pVhsyudisptkhtnpkkn37;
    }

    private String vhsyudisptkhtnpbuicd47;

    public String getVhsyudisptkhtnpbuicd47() {
        return vhsyudisptkhtnpbuicd47;
    }

    public void setVhsyudisptkhtnpbuicd47(String pVhsyudisptkhtnpbuicd47) {
        vhsyudisptkhtnpbuicd47 = pVhsyudisptkhtnpbuicd47;
    }

    private String vhsyudisptkhtnpbuinm47;

    public String getVhsyudisptkhtnpbuinm47() {
        return vhsyudisptkhtnpbuinm47;
    }

    public void setVhsyudisptkhtnpbuinm47(String pVhsyudisptkhtnpbuinm47) {
        vhsyudisptkhtnpbuinm47 = pVhsyudisptkhtnpbuinm47;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn47;

    public C_Htnpkkn getVhsyudisptkhtnpkkn47() {
        return vhsyudisptkhtnpkkn47;
    }

    public void setVhsyudisptkhtnpkkn47(C_Htnpkkn pVhsyudisptkhtnpkkn47) {
        vhsyudisptkhtnpkkn47 = pVhsyudisptkhtnpkkn47;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn7;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn7() {
        return vhsyudisptktkkdsghtpkbn7;
    }

    public void setVhsyudisptktkkdsghtpkbn7(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn7) {
        vhsyudisptktkkdsghtpkbn7 = pVhsyudisptktkkdsghtpkbn7;
    }

    private String vhsyudisptksyouhnnm8;

    public String getVhsyudisptksyouhnnm8() {
        return vhsyudisptksyouhnnm8;
    }

    public void setVhsyudisptksyouhnnm8(String pVhsyudisptksyouhnnm8) {
        vhsyudisptksyouhnnm8 = pVhsyudisptksyouhnnm8;
    }

    private Integer vhsyudisptkhknkkn8;

    public Integer getVhsyudisptkhknkkn8() {
        return vhsyudisptkhknkkn8;
    }

    public void setVhsyudisptkhknkkn8(Integer pVhsyudisptkhknkkn8) {
        vhsyudisptkhknkkn8 = pVhsyudisptkhknkkn8;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn8;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn8() {
        return vhsyudisptkhknkknsmnkbn8;
    }

    public void setVhsyudisptkhknkknsmnkbn8(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn8) {
        vhsyudisptkhknkknsmnkbn8 = pVhsyudisptkhknkknsmnkbn8;
    }

    private Integer vhsyudisptkhrkkkn8;

    public Integer getVhsyudisptkhrkkkn8() {
        return vhsyudisptkhrkkkn8;
    }

    public void setVhsyudisptkhrkkkn8(Integer pVhsyudisptkhrkkkn8) {
        vhsyudisptkhrkkkn8 = pVhsyudisptkhrkkkn8;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn8;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn8() {
        return vhsyudisptkhrkkknsmnkbn8;
    }

    public void setVhsyudisptkhrkkknsmnkbn8(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn8) {
        vhsyudisptkhrkkknsmnkbn8 = pVhsyudisptkhrkkknsmnkbn8;
    }

    private BizDate vhsyudisptkkykymd8;

    public BizDate getVhsyudisptkkykymd8() {
        return vhsyudisptkkykymd8;
    }

    public void setVhsyudisptkkykymd8(BizDate pVhsyudisptkkykymd8) {
        vhsyudisptkkykymd8 = pVhsyudisptkkykymd8;
    }

    private BizDate vhsyudisptksknnkaisiymd8;

    public BizDate getVhsyudisptksknnkaisiymd8() {
        return vhsyudisptksknnkaisiymd8;
    }

    public void setVhsyudisptksknnkaisiymd8(BizDate pVhsyudisptksknnkaisiymd8) {
        vhsyudisptksknnkaisiymd8 = pVhsyudisptksknnkaisiymd8;
    }

    private BizDate vhsyudisptkhkskkaisiymd8;

    public BizDate getVhsyudisptkhkskkaisiymd8() {
        return vhsyudisptkhkskkaisiymd8;
    }

    public void setVhsyudisptkhkskkaisiymd8(BizDate pVhsyudisptkhkskkaisiymd8) {
        vhsyudisptkhkskkaisiymd8 = pVhsyudisptkhkskkaisiymd8;
    }

    private BizCurrency vhsyudisptkkihons8;

    public BizCurrency getVhsyudisptkkihons8() {
        return vhsyudisptkkihons8;
    }

    public void setVhsyudisptkkihons8(BizCurrency pVhsyudisptkkihons8) {
        vhsyudisptkkihons8 = pVhsyudisptkkihons8;
    }

    private BizCurrency vhsyudisptktkjyp8;

    public BizCurrency getVhsyudisptktkjyp8() {
        return vhsyudisptktkjyp8;
    }

    public void setVhsyudisptktkjyp8(BizCurrency pVhsyudisptktkjyp8) {
        vhsyudisptktkjyp8 = pVhsyudisptktkjyp8;
    }

    private String vhsyudisptkhtnpbuicd18;

    public String getVhsyudisptkhtnpbuicd18() {
        return vhsyudisptkhtnpbuicd18;
    }

    public void setVhsyudisptkhtnpbuicd18(String pVhsyudisptkhtnpbuicd18) {
        vhsyudisptkhtnpbuicd18 = pVhsyudisptkhtnpbuicd18;
    }

    private String vhsyudisptkhtnpbuinm18;

    public String getVhsyudisptkhtnpbuinm18() {
        return vhsyudisptkhtnpbuinm18;
    }

    public void setVhsyudisptkhtnpbuinm18(String pVhsyudisptkhtnpbuinm18) {
        vhsyudisptkhtnpbuinm18 = pVhsyudisptkhtnpbuinm18;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn18;

    public C_Htnpkkn getVhsyudisptkhtnpkkn18() {
        return vhsyudisptkhtnpkkn18;
    }

    public void setVhsyudisptkhtnpkkn18(C_Htnpkkn pVhsyudisptkhtnpkkn18) {
        vhsyudisptkhtnpkkn18 = pVhsyudisptkhtnpkkn18;
    }

    private String vhsyudisptkhtnpbuicd28;

    public String getVhsyudisptkhtnpbuicd28() {
        return vhsyudisptkhtnpbuicd28;
    }

    public void setVhsyudisptkhtnpbuicd28(String pVhsyudisptkhtnpbuicd28) {
        vhsyudisptkhtnpbuicd28 = pVhsyudisptkhtnpbuicd28;
    }

    private String vhsyudisptkhtnpbuinm28;

    public String getVhsyudisptkhtnpbuinm28() {
        return vhsyudisptkhtnpbuinm28;
    }

    public void setVhsyudisptkhtnpbuinm28(String pVhsyudisptkhtnpbuinm28) {
        vhsyudisptkhtnpbuinm28 = pVhsyudisptkhtnpbuinm28;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn28;

    public C_Htnpkkn getVhsyudisptkhtnpkkn28() {
        return vhsyudisptkhtnpkkn28;
    }

    public void setVhsyudisptkhtnpkkn28(C_Htnpkkn pVhsyudisptkhtnpkkn28) {
        vhsyudisptkhtnpkkn28 = pVhsyudisptkhtnpkkn28;
    }

    private String vhsyudisptkhtnpbuicd38;

    public String getVhsyudisptkhtnpbuicd38() {
        return vhsyudisptkhtnpbuicd38;
    }

    public void setVhsyudisptkhtnpbuicd38(String pVhsyudisptkhtnpbuicd38) {
        vhsyudisptkhtnpbuicd38 = pVhsyudisptkhtnpbuicd38;
    }

    private String vhsyudisptkhtnpbuinm38;

    public String getVhsyudisptkhtnpbuinm38() {
        return vhsyudisptkhtnpbuinm38;
    }

    public void setVhsyudisptkhtnpbuinm38(String pVhsyudisptkhtnpbuinm38) {
        vhsyudisptkhtnpbuinm38 = pVhsyudisptkhtnpbuinm38;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn38;

    public C_Htnpkkn getVhsyudisptkhtnpkkn38() {
        return vhsyudisptkhtnpkkn38;
    }

    public void setVhsyudisptkhtnpkkn38(C_Htnpkkn pVhsyudisptkhtnpkkn38) {
        vhsyudisptkhtnpkkn38 = pVhsyudisptkhtnpkkn38;
    }

    private String vhsyudisptkhtnpbuicd48;

    public String getVhsyudisptkhtnpbuicd48() {
        return vhsyudisptkhtnpbuicd48;
    }

    public void setVhsyudisptkhtnpbuicd48(String pVhsyudisptkhtnpbuicd48) {
        vhsyudisptkhtnpbuicd48 = pVhsyudisptkhtnpbuicd48;
    }

    private String vhsyudisptkhtnpbuinm48;

    public String getVhsyudisptkhtnpbuinm48() {
        return vhsyudisptkhtnpbuinm48;
    }

    public void setVhsyudisptkhtnpbuinm48(String pVhsyudisptkhtnpbuinm48) {
        vhsyudisptkhtnpbuinm48 = pVhsyudisptkhtnpbuinm48;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn48;

    public C_Htnpkkn getVhsyudisptkhtnpkkn48() {
        return vhsyudisptkhtnpkkn48;
    }

    public void setVhsyudisptkhtnpkkn48(C_Htnpkkn pVhsyudisptkhtnpkkn48) {
        vhsyudisptkhtnpkkn48 = pVhsyudisptkhtnpkkn48;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn8;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn8() {
        return vhsyudisptktkkdsghtpkbn8;
    }

    public void setVhsyudisptktkkdsghtpkbn8(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn8) {
        vhsyudisptktkkdsghtpkbn8 = pVhsyudisptktkkdsghtpkbn8;
    }

    private String vhsyudisptksyouhnnm9;

    public String getVhsyudisptksyouhnnm9() {
        return vhsyudisptksyouhnnm9;
    }

    public void setVhsyudisptksyouhnnm9(String pVhsyudisptksyouhnnm9) {
        vhsyudisptksyouhnnm9 = pVhsyudisptksyouhnnm9;
    }

    private Integer vhsyudisptkhknkkn9;

    public Integer getVhsyudisptkhknkkn9() {
        return vhsyudisptkhknkkn9;
    }

    public void setVhsyudisptkhknkkn9(Integer pVhsyudisptkhknkkn9) {
        vhsyudisptkhknkkn9 = pVhsyudisptkhknkkn9;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn9;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn9() {
        return vhsyudisptkhknkknsmnkbn9;
    }

    public void setVhsyudisptkhknkknsmnkbn9(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn9) {
        vhsyudisptkhknkknsmnkbn9 = pVhsyudisptkhknkknsmnkbn9;
    }

    private Integer vhsyudisptkhrkkkn9;

    public Integer getVhsyudisptkhrkkkn9() {
        return vhsyudisptkhrkkkn9;
    }

    public void setVhsyudisptkhrkkkn9(Integer pVhsyudisptkhrkkkn9) {
        vhsyudisptkhrkkkn9 = pVhsyudisptkhrkkkn9;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn9;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn9() {
        return vhsyudisptkhrkkknsmnkbn9;
    }

    public void setVhsyudisptkhrkkknsmnkbn9(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn9) {
        vhsyudisptkhrkkknsmnkbn9 = pVhsyudisptkhrkkknsmnkbn9;
    }

    private BizDate vhsyudisptkkykymd9;

    public BizDate getVhsyudisptkkykymd9() {
        return vhsyudisptkkykymd9;
    }

    public void setVhsyudisptkkykymd9(BizDate pVhsyudisptkkykymd9) {
        vhsyudisptkkykymd9 = pVhsyudisptkkykymd9;
    }

    private BizDate vhsyudisptksknnkaisiymd9;

    public BizDate getVhsyudisptksknnkaisiymd9() {
        return vhsyudisptksknnkaisiymd9;
    }

    public void setVhsyudisptksknnkaisiymd9(BizDate pVhsyudisptksknnkaisiymd9) {
        vhsyudisptksknnkaisiymd9 = pVhsyudisptksknnkaisiymd9;
    }

    private BizDate vhsyudisptkhkskkaisiymd9;

    public BizDate getVhsyudisptkhkskkaisiymd9() {
        return vhsyudisptkhkskkaisiymd9;
    }

    public void setVhsyudisptkhkskkaisiymd9(BizDate pVhsyudisptkhkskkaisiymd9) {
        vhsyudisptkhkskkaisiymd9 = pVhsyudisptkhkskkaisiymd9;
    }

    private BizCurrency vhsyudisptkkihons9;

    public BizCurrency getVhsyudisptkkihons9() {
        return vhsyudisptkkihons9;
    }

    public void setVhsyudisptkkihons9(BizCurrency pVhsyudisptkkihons9) {
        vhsyudisptkkihons9 = pVhsyudisptkkihons9;
    }

    private BizCurrency vhsyudisptktkjyp9;

    public BizCurrency getVhsyudisptktkjyp9() {
        return vhsyudisptktkjyp9;
    }

    public void setVhsyudisptktkjyp9(BizCurrency pVhsyudisptktkjyp9) {
        vhsyudisptktkjyp9 = pVhsyudisptktkjyp9;
    }

    private String vhsyudisptkhtnpbuicd19;

    public String getVhsyudisptkhtnpbuicd19() {
        return vhsyudisptkhtnpbuicd19;
    }

    public void setVhsyudisptkhtnpbuicd19(String pVhsyudisptkhtnpbuicd19) {
        vhsyudisptkhtnpbuicd19 = pVhsyudisptkhtnpbuicd19;
    }

    private String vhsyudisptkhtnpbuinm19;

    public String getVhsyudisptkhtnpbuinm19() {
        return vhsyudisptkhtnpbuinm19;
    }

    public void setVhsyudisptkhtnpbuinm19(String pVhsyudisptkhtnpbuinm19) {
        vhsyudisptkhtnpbuinm19 = pVhsyudisptkhtnpbuinm19;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn19;

    public C_Htnpkkn getVhsyudisptkhtnpkkn19() {
        return vhsyudisptkhtnpkkn19;
    }

    public void setVhsyudisptkhtnpkkn19(C_Htnpkkn pVhsyudisptkhtnpkkn19) {
        vhsyudisptkhtnpkkn19 = pVhsyudisptkhtnpkkn19;
    }

    private String vhsyudisptkhtnpbuicd29;

    public String getVhsyudisptkhtnpbuicd29() {
        return vhsyudisptkhtnpbuicd29;
    }

    public void setVhsyudisptkhtnpbuicd29(String pVhsyudisptkhtnpbuicd29) {
        vhsyudisptkhtnpbuicd29 = pVhsyudisptkhtnpbuicd29;
    }

    private String vhsyudisptkhtnpbuinm29;

    public String getVhsyudisptkhtnpbuinm29() {
        return vhsyudisptkhtnpbuinm29;
    }

    public void setVhsyudisptkhtnpbuinm29(String pVhsyudisptkhtnpbuinm29) {
        vhsyudisptkhtnpbuinm29 = pVhsyudisptkhtnpbuinm29;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn29;

    public C_Htnpkkn getVhsyudisptkhtnpkkn29() {
        return vhsyudisptkhtnpkkn29;
    }

    public void setVhsyudisptkhtnpkkn29(C_Htnpkkn pVhsyudisptkhtnpkkn29) {
        vhsyudisptkhtnpkkn29 = pVhsyudisptkhtnpkkn29;
    }

    private String vhsyudisptkhtnpbuicd39;

    public String getVhsyudisptkhtnpbuicd39() {
        return vhsyudisptkhtnpbuicd39;
    }

    public void setVhsyudisptkhtnpbuicd39(String pVhsyudisptkhtnpbuicd39) {
        vhsyudisptkhtnpbuicd39 = pVhsyudisptkhtnpbuicd39;
    }

    private String vhsyudisptkhtnpbuinm39;

    public String getVhsyudisptkhtnpbuinm39() {
        return vhsyudisptkhtnpbuinm39;
    }

    public void setVhsyudisptkhtnpbuinm39(String pVhsyudisptkhtnpbuinm39) {
        vhsyudisptkhtnpbuinm39 = pVhsyudisptkhtnpbuinm39;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn39;

    public C_Htnpkkn getVhsyudisptkhtnpkkn39() {
        return vhsyudisptkhtnpkkn39;
    }

    public void setVhsyudisptkhtnpkkn39(C_Htnpkkn pVhsyudisptkhtnpkkn39) {
        vhsyudisptkhtnpkkn39 = pVhsyudisptkhtnpkkn39;
    }

    private String vhsyudisptkhtnpbuicd49;

    public String getVhsyudisptkhtnpbuicd49() {
        return vhsyudisptkhtnpbuicd49;
    }

    public void setVhsyudisptkhtnpbuicd49(String pVhsyudisptkhtnpbuicd49) {
        vhsyudisptkhtnpbuicd49 = pVhsyudisptkhtnpbuicd49;
    }

    private String vhsyudisptkhtnpbuinm49;

    public String getVhsyudisptkhtnpbuinm49() {
        return vhsyudisptkhtnpbuinm49;
    }

    public void setVhsyudisptkhtnpbuinm49(String pVhsyudisptkhtnpbuinm49) {
        vhsyudisptkhtnpbuinm49 = pVhsyudisptkhtnpbuinm49;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn49;

    public C_Htnpkkn getVhsyudisptkhtnpkkn49() {
        return vhsyudisptkhtnpkkn49;
    }

    public void setVhsyudisptkhtnpkkn49(C_Htnpkkn pVhsyudisptkhtnpkkn49) {
        vhsyudisptkhtnpkkn49 = pVhsyudisptkhtnpkkn49;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn9;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn9() {
        return vhsyudisptktkkdsghtpkbn9;
    }

    public void setVhsyudisptktkkdsghtpkbn9(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn9) {
        vhsyudisptktkkdsghtpkbn9 = pVhsyudisptktkkdsghtpkbn9;
    }

    private String vhsyudisptksyouhnnm10;

    public String getVhsyudisptksyouhnnm10() {
        return vhsyudisptksyouhnnm10;
    }

    public void setVhsyudisptksyouhnnm10(String pVhsyudisptksyouhnnm10) {
        vhsyudisptksyouhnnm10 = pVhsyudisptksyouhnnm10;
    }

    private Integer vhsyudisptkhknkkn10;

    public Integer getVhsyudisptkhknkkn10() {
        return vhsyudisptkhknkkn10;
    }

    public void setVhsyudisptkhknkkn10(Integer pVhsyudisptkhknkkn10) {
        vhsyudisptkhknkkn10 = pVhsyudisptkhknkkn10;
    }

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn10;

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn10() {
        return vhsyudisptkhknkknsmnkbn10;
    }

    public void setVhsyudisptkhknkknsmnkbn10(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn10) {
        vhsyudisptkhknkknsmnkbn10 = pVhsyudisptkhknkknsmnkbn10;
    }

    private Integer vhsyudisptkhrkkkn10;

    public Integer getVhsyudisptkhrkkkn10() {
        return vhsyudisptkhrkkkn10;
    }

    public void setVhsyudisptkhrkkkn10(Integer pVhsyudisptkhrkkkn10) {
        vhsyudisptkhrkkkn10 = pVhsyudisptkhrkkkn10;
    }

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn10;

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn10() {
        return vhsyudisptkhrkkknsmnkbn10;
    }

    public void setVhsyudisptkhrkkknsmnkbn10(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn10) {
        vhsyudisptkhrkkknsmnkbn10 = pVhsyudisptkhrkkknsmnkbn10;
    }

    private BizDate vhsyudisptkkykymd10;

    public BizDate getVhsyudisptkkykymd10() {
        return vhsyudisptkkykymd10;
    }

    public void setVhsyudisptkkykymd10(BizDate pVhsyudisptkkykymd10) {
        vhsyudisptkkykymd10 = pVhsyudisptkkykymd10;
    }

    private BizDate vhsyudisptksknnkaisiymd10;

    public BizDate getVhsyudisptksknnkaisiymd10() {
        return vhsyudisptksknnkaisiymd10;
    }

    public void setVhsyudisptksknnkaisiymd10(BizDate pVhsyudisptksknnkaisiymd10) {
        vhsyudisptksknnkaisiymd10 = pVhsyudisptksknnkaisiymd10;
    }

    private BizDate vhsyudisptkhkskkaisiymd10;

    public BizDate getVhsyudisptkhkskkaisiymd10() {
        return vhsyudisptkhkskkaisiymd10;
    }

    public void setVhsyudisptkhkskkaisiymd10(BizDate pVhsyudisptkhkskkaisiymd10) {
        vhsyudisptkhkskkaisiymd10 = pVhsyudisptkhkskkaisiymd10;
    }

    private BizCurrency vhsyudisptkkihons10;

    public BizCurrency getVhsyudisptkkihons10() {
        return vhsyudisptkkihons10;
    }

    public void setVhsyudisptkkihons10(BizCurrency pVhsyudisptkkihons10) {
        vhsyudisptkkihons10 = pVhsyudisptkkihons10;
    }

    private BizCurrency vhsyudisptktkjyp10;

    public BizCurrency getVhsyudisptktkjyp10() {
        return vhsyudisptktkjyp10;
    }

    public void setVhsyudisptktkjyp10(BizCurrency pVhsyudisptktkjyp10) {
        vhsyudisptktkjyp10 = pVhsyudisptktkjyp10;
    }

    private String vhsyudisptkhtnpbuicd110;

    public String getVhsyudisptkhtnpbuicd110() {
        return vhsyudisptkhtnpbuicd110;
    }

    public void setVhsyudisptkhtnpbuicd110(String pVhsyudisptkhtnpbuicd110) {
        vhsyudisptkhtnpbuicd110 = pVhsyudisptkhtnpbuicd110;
    }

    private String vhsyudisptkhtnpbuinm110;

    public String getVhsyudisptkhtnpbuinm110() {
        return vhsyudisptkhtnpbuinm110;
    }

    public void setVhsyudisptkhtnpbuinm110(String pVhsyudisptkhtnpbuinm110) {
        vhsyudisptkhtnpbuinm110 = pVhsyudisptkhtnpbuinm110;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn110;

    public C_Htnpkkn getVhsyudisptkhtnpkkn110() {
        return vhsyudisptkhtnpkkn110;
    }

    public void setVhsyudisptkhtnpkkn110(C_Htnpkkn pVhsyudisptkhtnpkkn110) {
        vhsyudisptkhtnpkkn110 = pVhsyudisptkhtnpkkn110;
    }

    private String vhsyudisptkhtnpbuicd210;

    public String getVhsyudisptkhtnpbuicd210() {
        return vhsyudisptkhtnpbuicd210;
    }

    public void setVhsyudisptkhtnpbuicd210(String pVhsyudisptkhtnpbuicd210) {
        vhsyudisptkhtnpbuicd210 = pVhsyudisptkhtnpbuicd210;
    }

    private String vhsyudisptkhtnpbuinm210;

    public String getVhsyudisptkhtnpbuinm210() {
        return vhsyudisptkhtnpbuinm210;
    }

    public void setVhsyudisptkhtnpbuinm210(String pVhsyudisptkhtnpbuinm210) {
        vhsyudisptkhtnpbuinm210 = pVhsyudisptkhtnpbuinm210;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn210;

    public C_Htnpkkn getVhsyudisptkhtnpkkn210() {
        return vhsyudisptkhtnpkkn210;
    }

    public void setVhsyudisptkhtnpkkn210(C_Htnpkkn pVhsyudisptkhtnpkkn210) {
        vhsyudisptkhtnpkkn210 = pVhsyudisptkhtnpkkn210;
    }

    private String vhsyudisptkhtnpbuicd310;

    public String getVhsyudisptkhtnpbuicd310() {
        return vhsyudisptkhtnpbuicd310;
    }

    public void setVhsyudisptkhtnpbuicd310(String pVhsyudisptkhtnpbuicd310) {
        vhsyudisptkhtnpbuicd310 = pVhsyudisptkhtnpbuicd310;
    }

    private String vhsyudisptkhtnpbuinm310;

    public String getVhsyudisptkhtnpbuinm310() {
        return vhsyudisptkhtnpbuinm310;
    }

    public void setVhsyudisptkhtnpbuinm310(String pVhsyudisptkhtnpbuinm310) {
        vhsyudisptkhtnpbuinm310 = pVhsyudisptkhtnpbuinm310;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn310;

    public C_Htnpkkn getVhsyudisptkhtnpkkn310() {
        return vhsyudisptkhtnpkkn310;
    }

    public void setVhsyudisptkhtnpkkn310(C_Htnpkkn pVhsyudisptkhtnpkkn310) {
        vhsyudisptkhtnpkkn310 = pVhsyudisptkhtnpkkn310;
    }

    private String vhsyudisptkhtnpbuicd410;

    public String getVhsyudisptkhtnpbuicd410() {
        return vhsyudisptkhtnpbuicd410;
    }

    public void setVhsyudisptkhtnpbuicd410(String pVhsyudisptkhtnpbuicd410) {
        vhsyudisptkhtnpbuicd410 = pVhsyudisptkhtnpbuicd410;
    }

    private String vhsyudisptkhtnpbuinm410;

    public String getVhsyudisptkhtnpbuinm410() {
        return vhsyudisptkhtnpbuinm410;
    }

    public void setVhsyudisptkhtnpbuinm410(String pVhsyudisptkhtnpbuinm410) {
        vhsyudisptkhtnpbuinm410 = pVhsyudisptkhtnpbuinm410;
    }

    private C_Htnpkkn vhsyudisptkhtnpkkn410;

    public C_Htnpkkn getVhsyudisptkhtnpkkn410() {
        return vhsyudisptkhtnpkkn410;
    }

    public void setVhsyudisptkhtnpkkn410(C_Htnpkkn pVhsyudisptkhtnpkkn410) {
        vhsyudisptkhtnpkkn410 = pVhsyudisptkhtnpkkn410;
    }

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn10;

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn10() {
        return vhsyudisptktkkdsghtpkbn10;
    }

    public void setVhsyudisptktkkdsghtpkbn10(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn10) {
        vhsyudisptktkkdsghtpkbn10 = pVhsyudisptktkkdsghtpkbn10;
    }

    private String vsntkdisptkhukainfo;

    public String getVsntkdisptkhukainfo() {
        return vsntkdisptkhukainfo;
    }

    public void setVsntkdisptkhukainfo(String pVsntkdisptkhukainfo) {
        vsntkdisptkhukainfo = pVsntkdisptkhukainfo;
    }

    @Range(min="0", max="99")
    private Integer vshktsbuktnin;

    public Integer getVshktsbuktnin() {
        return vshktsbuktnin;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setVshktsbuktnin(Integer pVshktsbuktnin) {
        vshktsbuktnin = pVshktsbuktnin;
    }

    private C_UktKbn vshktdispsbuktkbn1;

    public C_UktKbn getVshktdispsbuktkbn1() {
        return vshktdispsbuktkbn1;
    }

    public void setVshktdispsbuktkbn1(C_UktKbn pVshktdispsbuktkbn1) {
        vshktdispsbuktkbn1 = pVshktdispsbuktkbn1;
    }

    private String vshktdispsbuktnmkn1;

    public String getVshktdispsbuktnmkn1() {
        return vshktdispsbuktnmkn1;
    }

    public void setVshktdispsbuktnmkn1(String pVshktdispsbuktnmkn1) {
        vshktdispsbuktnmkn1 = pVshktdispsbuktnmkn1;
    }

    private String vshktdispsbuktnmkj1;

    public String getVshktdispsbuktnmkj1() {
        return vshktdispsbuktnmkj1;
    }

    public void setVshktdispsbuktnmkj1(String pVshktdispsbuktnmkj1) {
        vshktdispsbuktnmkj1 = pVshktdispsbuktnmkj1;
    }

    private BizDate vshktdispsbuktseiymd1;

    public BizDate getVshktdispsbuktseiymd1() {
        return vshktdispsbuktseiymd1;
    }

    public void setVshktdispsbuktseiymd1(BizDate pVshktdispsbuktseiymd1) {
        vshktdispsbuktseiymd1 = pVshktdispsbuktseiymd1;
    }

    private String dispmskmjskjuktnen1;

    public String getDispmskmjskjuktnen1() {
        return dispmskmjskjuktnen1;
    }

    public void setDispmskmjskjuktnen1(String pDispmskmjskjuktnen1) {
        dispmskmjskjuktnen1 = pDispmskmjskjuktnen1;
    }

    private BizNumber vshktdispsbuktbnwari1;

    public BizNumber getVshktdispsbuktbnwari1() {
        return vshktdispsbuktbnwari1;
    }

    public void setVshktdispsbuktbnwari1(BizNumber pVshktdispsbuktbnwari1) {
        vshktdispsbuktbnwari1 = pVshktdispsbuktbnwari1;
    }

    private String vshktdispsbuktnmkn2;

    public String getVshktdispsbuktnmkn2() {
        return vshktdispsbuktnmkn2;
    }

    public void setVshktdispsbuktnmkn2(String pVshktdispsbuktnmkn2) {
        vshktdispsbuktnmkn2 = pVshktdispsbuktnmkn2;
    }

    private String vshktdispsbuktnmkj2;

    public String getVshktdispsbuktnmkj2() {
        return vshktdispsbuktnmkj2;
    }

    public void setVshktdispsbuktnmkj2(String pVshktdispsbuktnmkj2) {
        vshktdispsbuktnmkj2 = pVshktdispsbuktnmkj2;
    }

    private BizDate vshktdispsbuktseiymd2;

    public BizDate getVshktdispsbuktseiymd2() {
        return vshktdispsbuktseiymd2;
    }

    public void setVshktdispsbuktseiymd2(BizDate pVshktdispsbuktseiymd2) {
        vshktdispsbuktseiymd2 = pVshktdispsbuktseiymd2;
    }

    private String dispmskmjskjuktnen2;

    public String getDispmskmjskjuktnen2() {
        return dispmskmjskjuktnen2;
    }

    public void setDispmskmjskjuktnen2(String pDispmskmjskjuktnen2) {
        dispmskmjskjuktnen2 = pDispmskmjskjuktnen2;
    }

    private BizNumber vshktdispsbuktbnwari2;

    public BizNumber getVshktdispsbuktbnwari2() {
        return vshktdispsbuktbnwari2;
    }

    public void setVshktdispsbuktbnwari2(BizNumber pVshktdispsbuktbnwari2) {
        vshktdispsbuktbnwari2 = pVshktdispsbuktbnwari2;
    }

    private String vshktdispsbuktnmkn3;

    public String getVshktdispsbuktnmkn3() {
        return vshktdispsbuktnmkn3;
    }

    public void setVshktdispsbuktnmkn3(String pVshktdispsbuktnmkn3) {
        vshktdispsbuktnmkn3 = pVshktdispsbuktnmkn3;
    }

    private String vshktdispsbuktnmkj3;

    public String getVshktdispsbuktnmkj3() {
        return vshktdispsbuktnmkj3;
    }

    public void setVshktdispsbuktnmkj3(String pVshktdispsbuktnmkj3) {
        vshktdispsbuktnmkj3 = pVshktdispsbuktnmkj3;
    }

    private BizDate vshktdispsbuktseiymd3;

    public BizDate getVshktdispsbuktseiymd3() {
        return vshktdispsbuktseiymd3;
    }

    public void setVshktdispsbuktseiymd3(BizDate pVshktdispsbuktseiymd3) {
        vshktdispsbuktseiymd3 = pVshktdispsbuktseiymd3;
    }

    private String dispmskmjskjuktnen3;

    public String getDispmskmjskjuktnen3() {
        return dispmskmjskjuktnen3;
    }

    public void setDispmskmjskjuktnen3(String pDispmskmjskjuktnen3) {
        dispmskmjskjuktnen3 = pDispmskmjskjuktnen3;
    }

    private BizNumber vshktdispsbuktbnwari3;

    public BizNumber getVshktdispsbuktbnwari3() {
        return vshktdispsbuktbnwari3;
    }

    public void setVshktdispsbuktbnwari3(BizNumber pVshktdispsbuktbnwari3) {
        vshktdispsbuktbnwari3 = pVshktdispsbuktbnwari3;
    }

    private String vshktdispsbuktnmkn4;

    public String getVshktdispsbuktnmkn4() {
        return vshktdispsbuktnmkn4;
    }

    public void setVshktdispsbuktnmkn4(String pVshktdispsbuktnmkn4) {
        vshktdispsbuktnmkn4 = pVshktdispsbuktnmkn4;
    }

    private String vshktdispsbuktnmkj4;

    public String getVshktdispsbuktnmkj4() {
        return vshktdispsbuktnmkj4;
    }

    public void setVshktdispsbuktnmkj4(String pVshktdispsbuktnmkj4) {
        vshktdispsbuktnmkj4 = pVshktdispsbuktnmkj4;
    }

    private BizDate vshktdispsbuktseiymd4;

    public BizDate getVshktdispsbuktseiymd4() {
        return vshktdispsbuktseiymd4;
    }

    public void setVshktdispsbuktseiymd4(BizDate pVshktdispsbuktseiymd4) {
        vshktdispsbuktseiymd4 = pVshktdispsbuktseiymd4;
    }

    private String dispmskmjskjuktnen4;

    public String getDispmskmjskjuktnen4() {
        return dispmskmjskjuktnen4;
    }

    public void setDispmskmjskjuktnen4(String pDispmskmjskjuktnen4) {
        dispmskmjskjuktnen4 = pDispmskmjskjuktnen4;
    }

    private BizNumber vshktdispsbuktbnwari4;

    public BizNumber getVshktdispsbuktbnwari4() {
        return vshktdispsbuktbnwari4;
    }

    public void setVshktdispsbuktbnwari4(BizNumber pVshktdispsbuktbnwari4) {
        vshktdispsbuktbnwari4 = pVshktdispsbuktbnwari4;
    }

    private C_UktKbn vstsksiteidruktkbn;

    public C_UktKbn getVstsksiteidruktkbn() {
        return vstsksiteidruktkbn;
    }

    public void setVstsksiteidruktkbn(C_UktKbn pVstsksiteidruktkbn) {
        vstsksiteidruktkbn = pVstsksiteidruktkbn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    private String vstskstdrsknmkn;

    public String getVstskstdrsknmkn() {
        return vstskstdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVstskstdrsknmkn(String pVstskstdrsknmkn) {
        vstskstdrsknmkn = pVstskstdrsknmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String vstskstdrsknmkj;

    public String getVstskstdrsknmkj() {
        return vstskstdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVstskstdrsknmkj(String pVstskstdrsknmkj) {
        vstskstdrsknmkj = pVstskstdrsknmkj;
    }

    private String dispdrtencd1;

    public String getDispdrtencd1() {
        return dispdrtencd1;
    }

    public void setDispdrtencd1(String pDispdrtencd1) {
        dispdrtencd1 = pDispdrtencd1;
    }

    private String dispdrtennm1;

    public String getDispdrtennm1() {
        return dispdrtennm1;
    }

    public void setDispdrtennm1(String pDispdrtennm1) {
        dispdrtennm1 = pDispdrtennm1;
    }

    private String dispbosyuucd1;

    public String getDispbosyuucd1() {
        return dispbosyuucd1;
    }

    public void setDispbosyuucd1(String pDispbosyuucd1) {
        dispbosyuucd1 = pDispbosyuucd1;
    }

    private String dispbosyuunm1;

    public String getDispbosyuunm1() {
        return dispbosyuunm1;
    }

    public void setDispbosyuunm1(String pDispbosyuunm1) {
        dispbosyuunm1 = pDispbosyuunm1;
    }

    private BizNumber dispbunwari1;

    public BizNumber getDispbunwari1() {
        return dispbunwari1;
    }

    public void setDispbunwari1(BizNumber pDispbunwari1) {
        dispbunwari1 = pDispbunwari1;
    }

    private String dispdrtencd2;

    public String getDispdrtencd2() {
        return dispdrtencd2;
    }

    public void setDispdrtencd2(String pDispdrtencd2) {
        dispdrtencd2 = pDispdrtencd2;
    }

    private String dispdrtennm2;

    public String getDispdrtennm2() {
        return dispdrtennm2;
    }

    public void setDispdrtennm2(String pDispdrtennm2) {
        dispdrtennm2 = pDispdrtennm2;
    }

    private String dispbosyuucd2;

    public String getDispbosyuucd2() {
        return dispbosyuucd2;
    }

    public void setDispbosyuucd2(String pDispbosyuucd2) {
        dispbosyuucd2 = pDispbosyuucd2;
    }

    private String dispbosyuunm2;

    public String getDispbosyuunm2() {
        return dispbosyuunm2;
    }

    public void setDispbosyuunm2(String pDispbosyuunm2) {
        dispbosyuunm2 = pDispbosyuunm2;
    }

    private BizNumber dispbunwari2;

    public BizNumber getDispbunwari2() {
        return dispbunwari2;
    }

    public void setDispbunwari2(BizNumber pDispbunwari2) {
        dispbunwari2 = pDispbunwari2;
    }

    @ValidDateYm
    private BizDateYM bosyuuym;

    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDateYM dairitenseisekiym;

    public BizDateYM getDairitenseisekiym() {
        return dairitenseisekiym;
    }

    @Trim("both")
    public void setDairitenseisekiym(BizDateYM pDairitenseisekiym) {
        dairitenseisekiym = pDairitenseisekiym;
    }

    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    private String cifcd;

    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private C_Boskykjyoutai boskykjyoutai;

    public C_Boskykjyoutai getBoskykjyoutai() {
        return boskykjyoutai;
    }

    public void setBoskykjyoutai(C_Boskykjyoutai pBoskykjyoutai) {
        boskykjyoutai = pBoskykjyoutai;
    }

    private String smbckanriid;

    public String getSmbckanriid() {
        return smbckanriid;
    }

    public void setSmbckanriid(String pSmbckanriid) {
        smbckanriid = pSmbckanriid;
    }

    private C_KktyuitaKbn vtdktkktyuitakbn;

    public C_KktyuitaKbn getVtdktkktyuitakbn() {
        return vtdktkktyuitakbn;
    }

    public void setVtdktkktyuitakbn(C_KktyuitaKbn pVtdktkktyuitakbn) {
        vtdktkktyuitakbn = pVtdktkktyuitakbn;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String vtdktttdktyuuinaiyou1;

    public String getVtdktttdktyuuinaiyou1() {
        return vtdktttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtdktttdktyuuinaiyou1(String pVtdktttdktyuuinaiyou1) {
        vtdktttdktyuuinaiyou1 = pVtdktttdktyuuinaiyou1;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String vtdktttdktyuuinaiyou2;

    public String getVtdktttdktyuuinaiyou2() {
        return vtdktttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtdktttdktyuuinaiyou2(String pVtdktttdktyuuinaiyou2) {
        vtdktttdktyuuinaiyou2 = pVtdktttdktyuuinaiyou2;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String vtdktttdktyuuinaiyou3;

    public String getVtdktttdktyuuinaiyou3() {
        return vtdktttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtdktttdktyuuinaiyou3(String pVtdktttdktyuuinaiyou3) {
        vtdktttdktyuuinaiyou3 = pVtdktttdktyuuinaiyou3;
    }

    private C_StknsetKbn vtdktstknsetkbn;

    public C_StknsetKbn getVtdktstknsetkbn() {
        return vtdktstknsetkbn;
    }

    public void setVtdktstknsetkbn(C_StknsetKbn pVtdktstknsetkbn) {
        vtdktstknsetkbn = pVtdktstknsetkbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sinsatyuuisetnm;

    public String getSinsatyuuisetnm() {
        return sinsatyuuisetnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSinsatyuuisetnm(String pSinsatyuuisetnm) {
        sinsatyuuisetnm = pSinsatyuuisetnm;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sosikinm;

    public String getSosikinm() {
        return sosikinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSosikinm(String pSosikinm) {
        sosikinm = pSosikinm;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String sinsatyuui;

    public String getSinsatyuui() {
        return sinsatyuui;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSinsatyuui(String pSinsatyuui) {
        sinsatyuui = pSinsatyuui;
    }

    private BizDate vtdktdispsyoriymd1;

    public BizDate getVtdktdispsyoriymd1() {
        return vtdktdispsyoriymd1;
    }

    public void setVtdktdispsyoriymd1(BizDate pVtdktdispsyoriymd1) {
        vtdktdispsyoriymd1 = pVtdktdispsyoriymd1;
    }

    private C_FatcasnsiKbn vtdktdispfatcasnsikbn1;

    public C_FatcasnsiKbn getVtdktdispfatcasnsikbn1() {
        return vtdktdispfatcasnsikbn1;
    }

    public void setVtdktdispfatcasnsikbn1(C_FatcasnsiKbn pVtdktdispfatcasnsikbn1) {
        vtdktdispfatcasnsikbn1 = pVtdktdispfatcasnsikbn1;
    }

    private C_BikkjnssinfoKbn vtdktdispbikkjnssinfokbn1;

    public C_BikkjnssinfoKbn getVtdktdispbikkjnssinfokbn1() {
        return vtdktdispbikkjnssinfokbn1;
    }

    public void setVtdktdispbikkjnssinfokbn1(C_BikkjnssinfoKbn pVtdktdispbikkjnssinfokbn1) {
        vtdktdispbikkjnssinfokbn1 = pVtdktdispbikkjnssinfokbn1;
    }

    private C_FatcakekKbn vtdktdispfatcakekkbn1;

    public C_FatcakekKbn getVtdktdispfatcakekkbn1() {
        return vtdktdispfatcakekkbn1;
    }

    public void setVtdktdispfatcakekkbn1(C_FatcakekKbn pVtdktdispfatcakekkbn1) {
        vtdktdispfatcakekkbn1 = pVtdktdispfatcakekkbn1;
    }

    private C_FatcahankeiiKbn vtdktdispfatcahankeiikbn1;

    public C_FatcahankeiiKbn getVtdktdispfatcahankeiikbn1() {
        return vtdktdispfatcahankeiikbn1;
    }

    public void setVtdktdispfatcahankeiikbn1(C_FatcahankeiiKbn pVtdktdispfatcahankeiikbn1) {
        vtdktdispfatcahankeiikbn1 = pVtdktdispfatcahankeiikbn1;
    }

    private String vtdktdispbikknzsyno1;

    public String getVtdktdispbikknzsyno1() {
        return vtdktdispbikknzsyno1;
    }

    public void setVtdktdispbikknzsyno1(String pVtdktdispbikknzsyno1) {
        vtdktdispbikknzsyno1 = pVtdktdispbikknzsyno1;
    }

    private BizDate vtdktdispsyomeiymd1;

    public BizDate getVtdktdispsyomeiymd1() {
        return vtdktdispsyomeiymd1;
    }

    public void setVtdktdispsyomeiymd1(BizDate pVtdktdispsyomeiymd1) {
        vtdktdispsyomeiymd1 = pVtdktdispsyomeiymd1;
    }

    private C_FatcatgKbn vtdktdispfatcatgkbn1;

    public C_FatcatgKbn getVtdktdispfatcatgkbn1() {
        return vtdktdispfatcatgkbn1;
    }

    public void setVtdktdispfatcatgkbn1(C_FatcatgKbn pVtdktdispfatcatgkbn1) {
        vtdktdispfatcatgkbn1 = pVtdktdispfatcatgkbn1;
    }

    private String vtdktdispnmkn1;

    public String getVtdktdispnmkn1() {
        return vtdktdispnmkn1;
    }

    public void setVtdktdispnmkn1(String pVtdktdispnmkn1) {
        vtdktdispnmkn1 = pVtdktdispnmkn1;
    }

    private String vtdktdispnmkj1;

    public String getVtdktdispnmkj1() {
        return vtdktdispnmkj1;
    }

    public void setVtdktdispnmkj1(String pVtdktdispnmkj1) {
        vtdktdispnmkj1 = pVtdktdispnmkj1;
    }

    private BizDate vtdktdispseiymd1;

    public BizDate getVtdktdispseiymd1() {
        return vtdktdispseiymd1;
    }

    public void setVtdktdispseiymd1(BizDate pVtdktdispseiymd1) {
        vtdktdispseiymd1 = pVtdktdispseiymd1;
    }

    private C_Seibetu vtdktdispsei1;

    public C_Seibetu getVtdktdispsei1() {
        return vtdktdispsei1;
    }

    public void setVtdktdispsei1(C_Seibetu pVtdktdispsei1) {
        vtdktdispsei1 = pVtdktdispsei1;
    }

    private BizDate vtdktdispkouryokuendymd1;

    public BizDate getVtdktdispkouryokuendymd1() {
        return vtdktdispkouryokuendymd1;
    }

    public void setVtdktdispkouryokuendymd1(BizDate pVtdktdispkouryokuendymd1) {
        vtdktdispkouryokuendymd1 = pVtdktdispkouryokuendymd1;
    }

    private BizDate vtdktdispsyoriymd2;

    public BizDate getVtdktdispsyoriymd2() {
        return vtdktdispsyoriymd2;
    }

    public void setVtdktdispsyoriymd2(BizDate pVtdktdispsyoriymd2) {
        vtdktdispsyoriymd2 = pVtdktdispsyoriymd2;
    }

    private C_FatcasnsiKbn vtdktdispfatcasnsikbn2;

    public C_FatcasnsiKbn getVtdktdispfatcasnsikbn2() {
        return vtdktdispfatcasnsikbn2;
    }

    public void setVtdktdispfatcasnsikbn2(C_FatcasnsiKbn pVtdktdispfatcasnsikbn2) {
        vtdktdispfatcasnsikbn2 = pVtdktdispfatcasnsikbn2;
    }

    private C_BikkjnssinfoKbn vtdktdispbikkjnssinfokbn2;

    public C_BikkjnssinfoKbn getVtdktdispbikkjnssinfokbn2() {
        return vtdktdispbikkjnssinfokbn2;
    }

    public void setVtdktdispbikkjnssinfokbn2(C_BikkjnssinfoKbn pVtdktdispbikkjnssinfokbn2) {
        vtdktdispbikkjnssinfokbn2 = pVtdktdispbikkjnssinfokbn2;
    }

    private C_FatcakekKbn vtdktdispfatcakekkbn2;

    public C_FatcakekKbn getVtdktdispfatcakekkbn2() {
        return vtdktdispfatcakekkbn2;
    }

    public void setVtdktdispfatcakekkbn2(C_FatcakekKbn pVtdktdispfatcakekkbn2) {
        vtdktdispfatcakekkbn2 = pVtdktdispfatcakekkbn2;
    }

    private C_FatcahankeiiKbn vtdktdispfatcahankeiikbn2;

    public C_FatcahankeiiKbn getVtdktdispfatcahankeiikbn2() {
        return vtdktdispfatcahankeiikbn2;
    }

    public void setVtdktdispfatcahankeiikbn2(C_FatcahankeiiKbn pVtdktdispfatcahankeiikbn2) {
        vtdktdispfatcahankeiikbn2 = pVtdktdispfatcahankeiikbn2;
    }

    private String vtdktdispbikknzsyno2;

    public String getVtdktdispbikknzsyno2() {
        return vtdktdispbikknzsyno2;
    }

    public void setVtdktdispbikknzsyno2(String pVtdktdispbikknzsyno2) {
        vtdktdispbikknzsyno2 = pVtdktdispbikknzsyno2;
    }

    private BizDate vtdktdispsyomeiymd2;

    public BizDate getVtdktdispsyomeiymd2() {
        return vtdktdispsyomeiymd2;
    }

    public void setVtdktdispsyomeiymd2(BizDate pVtdktdispsyomeiymd2) {
        vtdktdispsyomeiymd2 = pVtdktdispsyomeiymd2;
    }

    private C_FatcatgKbn vtdktdispfatcatgkbn2;

    public C_FatcatgKbn getVtdktdispfatcatgkbn2() {
        return vtdktdispfatcatgkbn2;
    }

    public void setVtdktdispfatcatgkbn2(C_FatcatgKbn pVtdktdispfatcatgkbn2) {
        vtdktdispfatcatgkbn2 = pVtdktdispfatcatgkbn2;
    }

    private String vtdktdispnmkn2;

    public String getVtdktdispnmkn2() {
        return vtdktdispnmkn2;
    }

    public void setVtdktdispnmkn2(String pVtdktdispnmkn2) {
        vtdktdispnmkn2 = pVtdktdispnmkn2;
    }

    private String vtdktdispnmkj2;

    public String getVtdktdispnmkj2() {
        return vtdktdispnmkj2;
    }

    public void setVtdktdispnmkj2(String pVtdktdispnmkj2) {
        vtdktdispnmkj2 = pVtdktdispnmkj2;
    }

    private BizDate vtdktdispseiymd2;

    public BizDate getVtdktdispseiymd2() {
        return vtdktdispseiymd2;
    }

    public void setVtdktdispseiymd2(BizDate pVtdktdispseiymd2) {
        vtdktdispseiymd2 = pVtdktdispseiymd2;
    }

    private C_Seibetu vtdktdispsei2;

    public C_Seibetu getVtdktdispsei2() {
        return vtdktdispsei2;
    }

    public void setVtdktdispsei2(C_Seibetu pVtdktdispsei2) {
        vtdktdispsei2 = pVtdktdispsei2;
    }

    private BizDate vtdktdispkouryokuendymd2;

    public BizDate getVtdktdispkouryokuendymd2() {
        return vtdktdispkouryokuendymd2;
    }

    public void setVtdktdispkouryokuendymd2(BizDate pVtdktdispkouryokuendymd2) {
        vtdktdispkouryokuendymd2 = pVtdktdispkouryokuendymd2;
    }

    private BizDate vtdktdispsyoriymd3;

    public BizDate getVtdktdispsyoriymd3() {
        return vtdktdispsyoriymd3;
    }

    public void setVtdktdispsyoriymd3(BizDate pVtdktdispsyoriymd3) {
        vtdktdispsyoriymd3 = pVtdktdispsyoriymd3;
    }

    private C_FatcasnsiKbn vtdktdispfatcasnsikbn3;

    public C_FatcasnsiKbn getVtdktdispfatcasnsikbn3() {
        return vtdktdispfatcasnsikbn3;
    }

    public void setVtdktdispfatcasnsikbn3(C_FatcasnsiKbn pVtdktdispfatcasnsikbn3) {
        vtdktdispfatcasnsikbn3 = pVtdktdispfatcasnsikbn3;
    }

    private C_BikkjnssinfoKbn vtdktdispbikkjnssinfokbn3;

    public C_BikkjnssinfoKbn getVtdktdispbikkjnssinfokbn3() {
        return vtdktdispbikkjnssinfokbn3;
    }

    public void setVtdktdispbikkjnssinfokbn3(C_BikkjnssinfoKbn pVtdktdispbikkjnssinfokbn3) {
        vtdktdispbikkjnssinfokbn3 = pVtdktdispbikkjnssinfokbn3;
    }

    private C_FatcakekKbn vtdktdispfatcakekkbn3;

    public C_FatcakekKbn getVtdktdispfatcakekkbn3() {
        return vtdktdispfatcakekkbn3;
    }

    public void setVtdktdispfatcakekkbn3(C_FatcakekKbn pVtdktdispfatcakekkbn3) {
        vtdktdispfatcakekkbn3 = pVtdktdispfatcakekkbn3;
    }

    private C_FatcahankeiiKbn vtdktdispfatcahankeiikbn3;

    public C_FatcahankeiiKbn getVtdktdispfatcahankeiikbn3() {
        return vtdktdispfatcahankeiikbn3;
    }

    public void setVtdktdispfatcahankeiikbn3(C_FatcahankeiiKbn pVtdktdispfatcahankeiikbn3) {
        vtdktdispfatcahankeiikbn3 = pVtdktdispfatcahankeiikbn3;
    }

    private String vtdktdispbikknzsyno3;

    public String getVtdktdispbikknzsyno3() {
        return vtdktdispbikknzsyno3;
    }

    public void setVtdktdispbikknzsyno3(String pVtdktdispbikknzsyno3) {
        vtdktdispbikknzsyno3 = pVtdktdispbikknzsyno3;
    }

    private BizDate vtdktdispsyomeiymd3;

    public BizDate getVtdktdispsyomeiymd3() {
        return vtdktdispsyomeiymd3;
    }

    public void setVtdktdispsyomeiymd3(BizDate pVtdktdispsyomeiymd3) {
        vtdktdispsyomeiymd3 = pVtdktdispsyomeiymd3;
    }

    private C_FatcatgKbn vtdktdispfatcatgkbn3;

    public C_FatcatgKbn getVtdktdispfatcatgkbn3() {
        return vtdktdispfatcatgkbn3;
    }

    public void setVtdktdispfatcatgkbn3(C_FatcatgKbn pVtdktdispfatcatgkbn3) {
        vtdktdispfatcatgkbn3 = pVtdktdispfatcatgkbn3;
    }

    private String vtdktdispnmkn3;

    public String getVtdktdispnmkn3() {
        return vtdktdispnmkn3;
    }

    public void setVtdktdispnmkn3(String pVtdktdispnmkn3) {
        vtdktdispnmkn3 = pVtdktdispnmkn3;
    }

    private String vtdktdispnmkj3;

    public String getVtdktdispnmkj3() {
        return vtdktdispnmkj3;
    }

    public void setVtdktdispnmkj3(String pVtdktdispnmkj3) {
        vtdktdispnmkj3 = pVtdktdispnmkj3;
    }

    private BizDate vtdktdispseiymd3;

    public BizDate getVtdktdispseiymd3() {
        return vtdktdispseiymd3;
    }

    public void setVtdktdispseiymd3(BizDate pVtdktdispseiymd3) {
        vtdktdispseiymd3 = pVtdktdispseiymd3;
    }

    private C_Seibetu vtdktdispsei3;

    public C_Seibetu getVtdktdispsei3() {
        return vtdktdispsei3;
    }

    public void setVtdktdispsei3(C_Seibetu pVtdktdispsei3) {
        vtdktdispsei3 = pVtdktdispsei3;
    }

    private BizDate vtdktdispkouryokuendymd3;

    public BizDate getVtdktdispkouryokuendymd3() {
        return vtdktdispkouryokuendymd3;
    }

    public void setVtdktdispkouryokuendymd3(BizDate pVtdktdispkouryokuendymd3) {
        vtdktdispkouryokuendymd3 = pVtdktdispkouryokuendymd3;
    }

    private BizDate vtdktdispsyoriymd4;

    public BizDate getVtdktdispsyoriymd4() {
        return vtdktdispsyoriymd4;
    }

    public void setVtdktdispsyoriymd4(BizDate pVtdktdispsyoriymd4) {
        vtdktdispsyoriymd4 = pVtdktdispsyoriymd4;
    }

    private C_FatcasnsiKbn vtdktdispfatcasnsikbn4;

    public C_FatcasnsiKbn getVtdktdispfatcasnsikbn4() {
        return vtdktdispfatcasnsikbn4;
    }

    public void setVtdktdispfatcasnsikbn4(C_FatcasnsiKbn pVtdktdispfatcasnsikbn4) {
        vtdktdispfatcasnsikbn4 = pVtdktdispfatcasnsikbn4;
    }

    private C_BikkjnssinfoKbn vtdktdispbikkjnssinfokbn4;

    public C_BikkjnssinfoKbn getVtdktdispbikkjnssinfokbn4() {
        return vtdktdispbikkjnssinfokbn4;
    }

    public void setVtdktdispbikkjnssinfokbn4(C_BikkjnssinfoKbn pVtdktdispbikkjnssinfokbn4) {
        vtdktdispbikkjnssinfokbn4 = pVtdktdispbikkjnssinfokbn4;
    }

    private C_FatcakekKbn vtdktdispfatcakekkbn4;

    public C_FatcakekKbn getVtdktdispfatcakekkbn4() {
        return vtdktdispfatcakekkbn4;
    }

    public void setVtdktdispfatcakekkbn4(C_FatcakekKbn pVtdktdispfatcakekkbn4) {
        vtdktdispfatcakekkbn4 = pVtdktdispfatcakekkbn4;
    }

    private C_FatcahankeiiKbn vtdktdispfatcahankeiikbn4;

    public C_FatcahankeiiKbn getVtdktdispfatcahankeiikbn4() {
        return vtdktdispfatcahankeiikbn4;
    }

    public void setVtdktdispfatcahankeiikbn4(C_FatcahankeiiKbn pVtdktdispfatcahankeiikbn4) {
        vtdktdispfatcahankeiikbn4 = pVtdktdispfatcahankeiikbn4;
    }

    private String vtdktdispbikknzsyno4;

    public String getVtdktdispbikknzsyno4() {
        return vtdktdispbikknzsyno4;
    }

    public void setVtdktdispbikknzsyno4(String pVtdktdispbikknzsyno4) {
        vtdktdispbikknzsyno4 = pVtdktdispbikknzsyno4;
    }

    private BizDate vtdktdispsyomeiymd4;

    public BizDate getVtdktdispsyomeiymd4() {
        return vtdktdispsyomeiymd4;
    }

    public void setVtdktdispsyomeiymd4(BizDate pVtdktdispsyomeiymd4) {
        vtdktdispsyomeiymd4 = pVtdktdispsyomeiymd4;
    }

    private C_FatcatgKbn vtdktdispfatcatgkbn4;

    public C_FatcatgKbn getVtdktdispfatcatgkbn4() {
        return vtdktdispfatcatgkbn4;
    }

    public void setVtdktdispfatcatgkbn4(C_FatcatgKbn pVtdktdispfatcatgkbn4) {
        vtdktdispfatcatgkbn4 = pVtdktdispfatcatgkbn4;
    }

    private String vtdktdispnmkn4;

    public String getVtdktdispnmkn4() {
        return vtdktdispnmkn4;
    }

    public void setVtdktdispnmkn4(String pVtdktdispnmkn4) {
        vtdktdispnmkn4 = pVtdktdispnmkn4;
    }

    private String vtdktdispnmkj4;

    public String getVtdktdispnmkj4() {
        return vtdktdispnmkj4;
    }

    public void setVtdktdispnmkj4(String pVtdktdispnmkj4) {
        vtdktdispnmkj4 = pVtdktdispnmkj4;
    }

    private BizDate vtdktdispseiymd4;

    public BizDate getVtdktdispseiymd4() {
        return vtdktdispseiymd4;
    }

    public void setVtdktdispseiymd4(BizDate pVtdktdispseiymd4) {
        vtdktdispseiymd4 = pVtdktdispseiymd4;
    }

    private C_Seibetu vtdktdispsei4;

    public C_Seibetu getVtdktdispsei4() {
        return vtdktdispsei4;
    }

    public void setVtdktdispsei4(C_Seibetu pVtdktdispsei4) {
        vtdktdispsei4 = pVtdktdispsei4;
    }

    private BizDate vtdktdispkouryokuendymd4;

    public BizDate getVtdktdispkouryokuendymd4() {
        return vtdktdispkouryokuendymd4;
    }

    public void setVtdktdispkouryokuendymd4(BizDate pVtdktdispkouryokuendymd4) {
        vtdktdispkouryokuendymd4 = pVtdktdispkouryokuendymd4;
    }

    private BizDate vtdktdispsyoriymd5;

    public BizDate getVtdktdispsyoriymd5() {
        return vtdktdispsyoriymd5;
    }

    public void setVtdktdispsyoriymd5(BizDate pVtdktdispsyoriymd5) {
        vtdktdispsyoriymd5 = pVtdktdispsyoriymd5;
    }

    private C_FatcasnsiKbn vtdktdispfatcasnsikbn5;

    public C_FatcasnsiKbn getVtdktdispfatcasnsikbn5() {
        return vtdktdispfatcasnsikbn5;
    }

    public void setVtdktdispfatcasnsikbn5(C_FatcasnsiKbn pVtdktdispfatcasnsikbn5) {
        vtdktdispfatcasnsikbn5 = pVtdktdispfatcasnsikbn5;
    }

    private C_BikkjnssinfoKbn vtdktdispbikkjnssinfokbn5;

    public C_BikkjnssinfoKbn getVtdktdispbikkjnssinfokbn5() {
        return vtdktdispbikkjnssinfokbn5;
    }

    public void setVtdktdispbikkjnssinfokbn5(C_BikkjnssinfoKbn pVtdktdispbikkjnssinfokbn5) {
        vtdktdispbikkjnssinfokbn5 = pVtdktdispbikkjnssinfokbn5;
    }

    private C_FatcakekKbn vtdktdispfatcakekkbn5;

    public C_FatcakekKbn getVtdktdispfatcakekkbn5() {
        return vtdktdispfatcakekkbn5;
    }

    public void setVtdktdispfatcakekkbn5(C_FatcakekKbn pVtdktdispfatcakekkbn5) {
        vtdktdispfatcakekkbn5 = pVtdktdispfatcakekkbn5;
    }

    private C_FatcahankeiiKbn vtdktdispfatcahankeiikbn5;

    public C_FatcahankeiiKbn getVtdktdispfatcahankeiikbn5() {
        return vtdktdispfatcahankeiikbn5;
    }

    public void setVtdktdispfatcahankeiikbn5(C_FatcahankeiiKbn pVtdktdispfatcahankeiikbn5) {
        vtdktdispfatcahankeiikbn5 = pVtdktdispfatcahankeiikbn5;
    }

    private String vtdktdispbikknzsyno5;

    public String getVtdktdispbikknzsyno5() {
        return vtdktdispbikknzsyno5;
    }

    public void setVtdktdispbikknzsyno5(String pVtdktdispbikknzsyno5) {
        vtdktdispbikknzsyno5 = pVtdktdispbikknzsyno5;
    }

    private BizDate vtdktdispsyomeiymd5;

    public BizDate getVtdktdispsyomeiymd5() {
        return vtdktdispsyomeiymd5;
    }

    public void setVtdktdispsyomeiymd5(BizDate pVtdktdispsyomeiymd5) {
        vtdktdispsyomeiymd5 = pVtdktdispsyomeiymd5;
    }

    private C_FatcatgKbn vtdktdispfatcatgkbn5;

    public C_FatcatgKbn getVtdktdispfatcatgkbn5() {
        return vtdktdispfatcatgkbn5;
    }

    public void setVtdktdispfatcatgkbn5(C_FatcatgKbn pVtdktdispfatcatgkbn5) {
        vtdktdispfatcatgkbn5 = pVtdktdispfatcatgkbn5;
    }

    private String vtdktdispnmkn5;

    public String getVtdktdispnmkn5() {
        return vtdktdispnmkn5;
    }

    public void setVtdktdispnmkn5(String pVtdktdispnmkn5) {
        vtdktdispnmkn5 = pVtdktdispnmkn5;
    }

    private String vtdktdispnmkj5;

    public String getVtdktdispnmkj5() {
        return vtdktdispnmkj5;
    }

    public void setVtdktdispnmkj5(String pVtdktdispnmkj5) {
        vtdktdispnmkj5 = pVtdktdispnmkj5;
    }

    private BizDate vtdktdispseiymd5;

    public BizDate getVtdktdispseiymd5() {
        return vtdktdispseiymd5;
    }

    public void setVtdktdispseiymd5(BizDate pVtdktdispseiymd5) {
        vtdktdispseiymd5 = pVtdktdispseiymd5;
    }

    private C_Seibetu vtdktdispsei5;

    public C_Seibetu getVtdktdispsei5() {
        return vtdktdispsei5;
    }

    public void setVtdktdispsei5(C_Seibetu pVtdktdispsei5) {
        vtdktdispsei5 = pVtdktdispsei5;
    }

    private BizDate vtdktdispkouryokuendymd5;

    public BizDate getVtdktdispkouryokuendymd5() {
        return vtdktdispkouryokuendymd5;
    }

    public void setVtdktdispkouryokuendymd5(BizDate pVtdktdispkouryokuendymd5) {
        vtdktdispkouryokuendymd5 = pVtdktdispkouryokuendymd5;
    }

    private C_UmuKbn kykmrumu;

    public C_UmuKbn getKykmrumu() {
        return kykmrumu;
    }

    public void setKykmrumu(C_UmuKbn pKykmrumu) {
        kykmrumu = pKykmrumu;
    }

    private C_UmuKbn kykhnsyumu;

    public C_UmuKbn getKykhnsyumu() {
        return kykhnsyumu;
    }

    public void setKykhnsyumu(C_UmuKbn pKykhnsyumu) {
        kykhnsyumu = pKykhnsyumu;
    }

    private C_UmuKbn hhknmrumu;

    public C_UmuKbn getHhknmrumu() {
        return hhknmrumu;
    }

    public void setHhknmrumu(C_UmuKbn pHhknmrumu) {
        hhknmrumu = pHhknmrumu;
    }

    private C_UmuKbn hhknhnsyumu;

    public C_UmuKbn getHhknhnsyumu() {
        return hhknhnsyumu;
    }

    public void setHhknhnsyumu(C_UmuKbn pHhknhnsyumu) {
        hhknhnsyumu = pHhknhnsyumu;
    }
}
