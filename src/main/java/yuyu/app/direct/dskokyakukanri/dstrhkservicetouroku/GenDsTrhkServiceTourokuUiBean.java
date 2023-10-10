package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_Inputtaisyou;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.classification.C_TrksriyuuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 取引サービス登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsTrhkServiceTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TrhkServiceInfoDataSourceBean> trhkServiceInfoDataSource = new DataSource<>();
    public DataSource<TrhkServiceInfoDataSourceBean> getTrhkServiceInfoDataSource() {
        return trhkServiceInfoDataSource;
    }

    @Deprecated
    public List<TrhkServiceInfoDataSourceBean> getTrhkServiceInfo() {
        return trhkServiceInfoDataSource.getDatas();
    }

    public void setTrhkServiceInfo(List<TrhkServiceInfoDataSourceBean> pTrhkServiceInfo) {
        trhkServiceInfoDataSource.setDatas(pTrhkServiceInfo, 10);
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

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private String syoukaibtn;

    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    @ValidDate
    private BizDate srchdsjimustartymdfrom;

    public BizDate getSrchdsjimustartymdfrom() {
        return srchdsjimustartymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdsjimustartymdfrom(BizDate pSrchdsjimustartymdfrom) {
        srchdsjimustartymdfrom = pSrchdsjimustartymdfrom;
    }

    @ValidDate
    private BizDate srchdsjimustartymdto;

    public BizDate getSrchdsjimustartymdto() {
        return srchdsjimustartymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdsjimustartymdto(BizDate pSrchdsjimustartymdto) {
        srchdsjimustartymdto = pSrchdsjimustartymdto;
    }

    private C_TourokustatusKbn srchtourokustatus;

    public C_TourokustatusKbn getSrchtourokustatus() {
        return srchtourokustatus;
    }

    public void setSrchtourokustatus(C_TourokustatusKbn pSrchtourokustatus) {
        srchtourokustatus = pSrchtourokustatus;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kyknmkn;

    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    @ValidDate
    private BizDate kykseiymd;

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_DsTrhkserviceKanyukeiroKbn dstrhkservicekanyukeirokbn;

    public C_DsTrhkserviceKanyukeiroKbn getDstrhkservicekanyukeirokbn() {
        return dstrhkservicekanyukeirokbn;
    }

    public void setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn pDstrhkservicekanyukeirokbn) {
        dstrhkservicekanyukeirokbn = pDstrhkservicekanyukeirokbn;
    }

    private C_TourokustatusKbn tourokustatus;

    public C_TourokustatusKbn getTourokustatus() {
        return tourokustatus;
    }

    public void setTourokustatus(C_TourokustatusKbn pTourokustatus) {
        tourokustatus = pTourokustatus;
    }

    private C_TrksriyuuKbn trksriyuukbn;

    public C_TrksriyuuKbn getTrksriyuukbn() {
        return trksriyuukbn;
    }

    public void setTrksriyuukbn(C_TrksriyuuKbn pTrksriyuukbn) {
        trksriyuukbn = pTrksriyuukbn;
    }

    private C_Inputtaisyou inputtaisyoutokuteitrhkkz;

    public C_Inputtaisyou getInputtaisyoutokuteitrhkkz() {
        return inputtaisyoutokuteitrhkkz;
    }

    public void setInputtaisyoutokuteitrhkkz(C_Inputtaisyou pInputtaisyoutokuteitrhkkz) {
        inputtaisyoutokuteitrhkkz = pInputtaisyoutokuteitrhkkz;
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

    private C_Inputtaisyou inputtaisyoutoktrhkansyono;

    public C_Inputtaisyou getInputtaisyoutoktrhkansyono() {
        return inputtaisyoutoktrhkansyono;
    }

    public void setInputtaisyoutoktrhkansyono(C_Inputtaisyou pInputtaisyoutoktrhkansyono) {
        inputtaisyoutoktrhkansyono = pInputtaisyoutoktrhkansyono;
    }

    private String disptokuteitrhkansyono;

    public String getDisptokuteitrhkansyono() {
        return disptokuteitrhkansyono;
    }

    public void setDisptokuteitrhkansyono(String pDisptokuteitrhkansyono) {
        disptokuteitrhkansyono = pDisptokuteitrhkansyono;
    }

    @Length(length=4)
    @Digit
    private String tokuteitrhkansyonoinput;

    public String getTokuteitrhkansyonoinput() {
        return tokuteitrhkansyonoinput;
    }

    @DataConvert("toSingleByte")
    public void setTokuteitrhkansyonoinput(String pTokuteitrhkansyonoinput) {
        tokuteitrhkansyonoinput = pTokuteitrhkansyonoinput;
    }

    @Length(length=4)
    @Digit
    private String tokuteitrhkansyonokakunin;

    public String getTokuteitrhkansyonokakunin() {
        return tokuteitrhkansyonokakunin;
    }

    @DataConvert("toSingleByte")
    public void setTokuteitrhkansyonokakunin(String pTokuteitrhkansyonokakunin) {
        tokuteitrhkansyonokakunin = pTokuteitrhkansyonokakunin;
    }
}
