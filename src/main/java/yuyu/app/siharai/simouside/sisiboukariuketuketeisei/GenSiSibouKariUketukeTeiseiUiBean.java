package yuyu.app.siharai.simouside.sisiboukariuketuketeisei;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡仮受付訂正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiSibouKariUketukeTeiseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private C_Kyksei kyksei;

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String hhknnmkn;

    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    @ValidDate
    private BizDate hhknseiymd;

    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    @Range(min="0", max="99")
    private Integer sbuktnin;

    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktKbn dispsbuktkbn1;

    public C_UktKbn getDispsbuktkbn1() {
        return dispsbuktkbn1;
    }

    public void setDispsbuktkbn1(C_UktKbn pDispsbuktkbn1) {
        dispsbuktkbn1 = pDispsbuktkbn1;
    }

    private String dispsbuktnmkn1;

    public String getDispsbuktnmkn1() {
        return dispsbuktnmkn1;
    }

    public void setDispsbuktnmkn1(String pDispsbuktnmkn1) {
        dispsbuktnmkn1 = pDispsbuktnmkn1;
    }

    private String dispsbuktnmkj1;

    public String getDispsbuktnmkj1() {
        return dispsbuktnmkj1;
    }

    public void setDispsbuktnmkj1(String pDispsbuktnmkj1) {
        dispsbuktnmkj1 = pDispsbuktnmkj1;
    }

    private BizDate dispsbuktseiymd1;

    public BizDate getDispsbuktseiymd1() {
        return dispsbuktseiymd1;
    }

    public void setDispsbuktseiymd1(BizDate pDispsbuktseiymd1) {
        dispsbuktseiymd1 = pDispsbuktseiymd1;
    }

    private String dispmskmjskjuktnen1;

    public String getDispmskmjskjuktnen1() {
        return dispmskmjskjuktnen1;
    }

    public void setDispmskmjskjuktnen1(String pDispmskmjskjuktnen1) {
        dispmskmjskjuktnen1 = pDispmskmjskjuktnen1;
    }

    private BizNumber dispsbuktbnwari1;

    public BizNumber getDispsbuktbnwari1() {
        return dispsbuktbnwari1;
    }

    public void setDispsbuktbnwari1(BizNumber pDispsbuktbnwari1) {
        dispsbuktbnwari1 = pDispsbuktbnwari1;
    }

    private C_UktKbn dispsbuktkbn2;

    public C_UktKbn getDispsbuktkbn2() {
        return dispsbuktkbn2;
    }

    public void setDispsbuktkbn2(C_UktKbn pDispsbuktkbn2) {
        dispsbuktkbn2 = pDispsbuktkbn2;
    }

    private String dispsbuktnmkn2;

    public String getDispsbuktnmkn2() {
        return dispsbuktnmkn2;
    }

    public void setDispsbuktnmkn2(String pDispsbuktnmkn2) {
        dispsbuktnmkn2 = pDispsbuktnmkn2;
    }

    private String dispsbuktnmkj2;

    public String getDispsbuktnmkj2() {
        return dispsbuktnmkj2;
    }

    public void setDispsbuktnmkj2(String pDispsbuktnmkj2) {
        dispsbuktnmkj2 = pDispsbuktnmkj2;
    }

    private BizDate dispsbuktseiymd2;

    public BizDate getDispsbuktseiymd2() {
        return dispsbuktseiymd2;
    }

    public void setDispsbuktseiymd2(BizDate pDispsbuktseiymd2) {
        dispsbuktseiymd2 = pDispsbuktseiymd2;
    }

    private String dispmskmjskjuktnen2;

    public String getDispmskmjskjuktnen2() {
        return dispmskmjskjuktnen2;
    }

    public void setDispmskmjskjuktnen2(String pDispmskmjskjuktnen2) {
        dispmskmjskjuktnen2 = pDispmskmjskjuktnen2;
    }

    private BizNumber dispsbuktbnwari2;

    public BizNumber getDispsbuktbnwari2() {
        return dispsbuktbnwari2;
    }

    public void setDispsbuktbnwari2(BizNumber pDispsbuktbnwari2) {
        dispsbuktbnwari2 = pDispsbuktbnwari2;
    }

    private C_UktKbn dispsbuktkbn3;

    public C_UktKbn getDispsbuktkbn3() {
        return dispsbuktkbn3;
    }

    public void setDispsbuktkbn3(C_UktKbn pDispsbuktkbn3) {
        dispsbuktkbn3 = pDispsbuktkbn3;
    }

    private String dispsbuktnmkn3;

    public String getDispsbuktnmkn3() {
        return dispsbuktnmkn3;
    }

    public void setDispsbuktnmkn3(String pDispsbuktnmkn3) {
        dispsbuktnmkn3 = pDispsbuktnmkn3;
    }

    private String dispsbuktnmkj3;

    public String getDispsbuktnmkj3() {
        return dispsbuktnmkj3;
    }

    public void setDispsbuktnmkj3(String pDispsbuktnmkj3) {
        dispsbuktnmkj3 = pDispsbuktnmkj3;
    }

    private BizDate dispsbuktseiymd3;

    public BizDate getDispsbuktseiymd3() {
        return dispsbuktseiymd3;
    }

    public void setDispsbuktseiymd3(BizDate pDispsbuktseiymd3) {
        dispsbuktseiymd3 = pDispsbuktseiymd3;
    }

    private String dispmskmjskjuktnen3;

    public String getDispmskmjskjuktnen3() {
        return dispmskmjskjuktnen3;
    }

    public void setDispmskmjskjuktnen3(String pDispmskmjskjuktnen3) {
        dispmskmjskjuktnen3 = pDispmskmjskjuktnen3;
    }

    private BizNumber dispsbuktbnwari3;

    public BizNumber getDispsbuktbnwari3() {
        return dispsbuktbnwari3;
    }

    public void setDispsbuktbnwari3(BizNumber pDispsbuktbnwari3) {
        dispsbuktbnwari3 = pDispsbuktbnwari3;
    }

    private C_UktKbn dispsbuktkbn4;

    public C_UktKbn getDispsbuktkbn4() {
        return dispsbuktkbn4;
    }

    public void setDispsbuktkbn4(C_UktKbn pDispsbuktkbn4) {
        dispsbuktkbn4 = pDispsbuktkbn4;
    }

    private String dispsbuktnmkn4;

    public String getDispsbuktnmkn4() {
        return dispsbuktnmkn4;
    }

    public void setDispsbuktnmkn4(String pDispsbuktnmkn4) {
        dispsbuktnmkn4 = pDispsbuktnmkn4;
    }

    private String dispsbuktnmkj4;

    public String getDispsbuktnmkj4() {
        return dispsbuktnmkj4;
    }

    public void setDispsbuktnmkj4(String pDispsbuktnmkj4) {
        dispsbuktnmkj4 = pDispsbuktnmkj4;
    }

    private BizDate dispsbuktseiymd4;

    public BizDate getDispsbuktseiymd4() {
        return dispsbuktseiymd4;
    }

    public void setDispsbuktseiymd4(BizDate pDispsbuktseiymd4) {
        dispsbuktseiymd4 = pDispsbuktseiymd4;
    }

    private String dispmskmjskjuktnen4;

    public String getDispmskmjskjuktnen4() {
        return dispmskmjskjuktnen4;
    }

    public void setDispmskmjskjuktnen4(String pDispmskmjskjuktnen4) {
        dispmskmjskjuktnen4 = pDispmskmjskjuktnen4;
    }

    private BizNumber dispsbuktbnwari4;

    public BizNumber getDispsbuktbnwari4() {
        return dispsbuktbnwari4;
    }

    public void setDispsbuktbnwari4(BizNumber pDispsbuktbnwari4) {
        dispsbuktbnwari4 = pDispsbuktbnwari4;
    }

    @ValidDate
    private BizDate bfrsibouymd;

    public BizDate getBfrsibouymd() {
        return bfrsibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBfrsibouymd(BizDate pBfrsibouymd) {
        bfrsibouymd = pBfrsibouymd;
    }

    private C_GeninKbn bfrgeninkbn;

    public C_GeninKbn getBfrgeninkbn() {
        return bfrgeninkbn;
    }

    public void setBfrgeninkbn(C_GeninKbn pBfrgeninkbn) {
        bfrgeninkbn = pBfrgeninkbn;
    }

    private String bfrtntnm;

    public String getBfrtntnm() {
        return bfrtntnm;
    }

    public void setBfrtntnm(String pBfrtntnm) {
        bfrtntnm = pBfrtntnm;
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

    private C_GeninKbn geninkbn;

    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private String tntnm;

    public String getTntnm() {
        return tntnm;
    }

    public void setTntnm(String pTntnm) {
        tntnm = pTntnm;
    }
}
