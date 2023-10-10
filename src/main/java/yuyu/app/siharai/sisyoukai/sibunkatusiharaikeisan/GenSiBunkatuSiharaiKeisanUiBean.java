package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_BunkatuHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 分割支払計算 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiBunkatuSiharaiKeisanUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<UktrInfoDataSourceBean> uktrInfoDataSource = new DataSource<>();
    public DataSource<UktrInfoDataSourceBean> getUktrInfoDataSource() {
        return uktrInfoDataSource;
    }

    @Deprecated
    public List<UktrInfoDataSourceBean> getUktrInfo() {
        return uktrInfoDataSource.getDatas();
    }

    public void setUktrInfo(List<UktrInfoDataSourceBean> pUktrInfo) {
        uktrInfoDataSource.setDatas(pUktrInfo);
    }

    private DataSource<BunkatuKeisanKekka1DataSourceBean> bunkatuKeisanKekka1DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka1DataSourceBean> getBunkatuKeisanKekka1DataSource() {
        return bunkatuKeisanKekka1DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka1DataSourceBean> getBunkatuKeisanKekka1() {
        return bunkatuKeisanKekka1DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka1(List<BunkatuKeisanKekka1DataSourceBean> pBunkatuKeisanKekka1) {
        bunkatuKeisanKekka1DataSource.setDatas(pBunkatuKeisanKekka1);
    }

    private DataSource<BunkatuKeisanKekka2DataSourceBean> bunkatuKeisanKekka2DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka2DataSourceBean> getBunkatuKeisanKekka2DataSource() {
        return bunkatuKeisanKekka2DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka2DataSourceBean> getBunkatuKeisanKekka2() {
        return bunkatuKeisanKekka2DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka2(List<BunkatuKeisanKekka2DataSourceBean> pBunkatuKeisanKekka2) {
        bunkatuKeisanKekka2DataSource.setDatas(pBunkatuKeisanKekka2);
    }

    private DataSource<BunkatuKeisanKekka3DataSourceBean> bunkatuKeisanKekka3DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka3DataSourceBean> getBunkatuKeisanKekka3DataSource() {
        return bunkatuKeisanKekka3DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka3DataSourceBean> getBunkatuKeisanKekka3() {
        return bunkatuKeisanKekka3DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka3(List<BunkatuKeisanKekka3DataSourceBean> pBunkatuKeisanKekka3) {
        bunkatuKeisanKekka3DataSource.setDatas(pBunkatuKeisanKekka3);
    }

    private DataSource<BunkatuKeisanKekka4DataSourceBean> bunkatuKeisanKekka4DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka4DataSourceBean> getBunkatuKeisanKekka4DataSource() {
        return bunkatuKeisanKekka4DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka4DataSourceBean> getBunkatuKeisanKekka4() {
        return bunkatuKeisanKekka4DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka4(List<BunkatuKeisanKekka4DataSourceBean> pBunkatuKeisanKekka4) {
        bunkatuKeisanKekka4DataSource.setDatas(pBunkatuKeisanKekka4);
    }

    private DataSource<BunkatuKeisanKekka5DataSourceBean> bunkatuKeisanKekka5DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka5DataSourceBean> getBunkatuKeisanKekka5DataSource() {
        return bunkatuKeisanKekka5DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka5DataSourceBean> getBunkatuKeisanKekka5() {
        return bunkatuKeisanKekka5DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka5(List<BunkatuKeisanKekka5DataSourceBean> pBunkatuKeisanKekka5) {
        bunkatuKeisanKekka5DataSource.setDatas(pBunkatuKeisanKekka5);
    }

    private DataSource<BunkatuKeisanKekka6DataSourceBean> bunkatuKeisanKekka6DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka6DataSourceBean> getBunkatuKeisanKekka6DataSource() {
        return bunkatuKeisanKekka6DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka6DataSourceBean> getBunkatuKeisanKekka6() {
        return bunkatuKeisanKekka6DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka6(List<BunkatuKeisanKekka6DataSourceBean> pBunkatuKeisanKekka6) {
        bunkatuKeisanKekka6DataSource.setDatas(pBunkatuKeisanKekka6);
    }

    private DataSource<BunkatuKeisanKekka7DataSourceBean> bunkatuKeisanKekka7DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka7DataSourceBean> getBunkatuKeisanKekka7DataSource() {
        return bunkatuKeisanKekka7DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka7DataSourceBean> getBunkatuKeisanKekka7() {
        return bunkatuKeisanKekka7DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka7(List<BunkatuKeisanKekka7DataSourceBean> pBunkatuKeisanKekka7) {
        bunkatuKeisanKekka7DataSource.setDatas(pBunkatuKeisanKekka7);
    }

    private DataSource<BunkatuKeisanKekka8DataSourceBean> bunkatuKeisanKekka8DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka8DataSourceBean> getBunkatuKeisanKekka8DataSource() {
        return bunkatuKeisanKekka8DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka8DataSourceBean> getBunkatuKeisanKekka8() {
        return bunkatuKeisanKekka8DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka8(List<BunkatuKeisanKekka8DataSourceBean> pBunkatuKeisanKekka8) {
        bunkatuKeisanKekka8DataSource.setDatas(pBunkatuKeisanKekka8);
    }

    private DataSource<BunkatuKeisanKekka9DataSourceBean> bunkatuKeisanKekka9DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka9DataSourceBean> getBunkatuKeisanKekka9DataSource() {
        return bunkatuKeisanKekka9DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka9DataSourceBean> getBunkatuKeisanKekka9() {
        return bunkatuKeisanKekka9DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka9(List<BunkatuKeisanKekka9DataSourceBean> pBunkatuKeisanKekka9) {
        bunkatuKeisanKekka9DataSource.setDatas(pBunkatuKeisanKekka9);
    }

    private DataSource<BunkatuKeisanKekka10DataSourceBean> bunkatuKeisanKekka10DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka10DataSourceBean> getBunkatuKeisanKekka10DataSource() {
        return bunkatuKeisanKekka10DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka10DataSourceBean> getBunkatuKeisanKekka10() {
        return bunkatuKeisanKekka10DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka10(List<BunkatuKeisanKekka10DataSourceBean> pBunkatuKeisanKekka10) {
        bunkatuKeisanKekka10DataSource.setDatas(pBunkatuKeisanKekka10);
    }

    private DataSource<BunkatuKeisanKekka11DataSourceBean> bunkatuKeisanKekka11DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka11DataSourceBean> getBunkatuKeisanKekka11DataSource() {
        return bunkatuKeisanKekka11DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka11DataSourceBean> getBunkatuKeisanKekka11() {
        return bunkatuKeisanKekka11DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka11(List<BunkatuKeisanKekka11DataSourceBean> pBunkatuKeisanKekka11) {
        bunkatuKeisanKekka11DataSource.setDatas(pBunkatuKeisanKekka11);
    }

    private DataSource<BunkatuKeisanKekka12DataSourceBean> bunkatuKeisanKekka12DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka12DataSourceBean> getBunkatuKeisanKekka12DataSource() {
        return bunkatuKeisanKekka12DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka12DataSourceBean> getBunkatuKeisanKekka12() {
        return bunkatuKeisanKekka12DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka12(List<BunkatuKeisanKekka12DataSourceBean> pBunkatuKeisanKekka12) {
        bunkatuKeisanKekka12DataSource.setDatas(pBunkatuKeisanKekka12);
    }

    private DataSource<BunkatuKeisanKekka13DataSourceBean> bunkatuKeisanKekka13DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka13DataSourceBean> getBunkatuKeisanKekka13DataSource() {
        return bunkatuKeisanKekka13DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka13DataSourceBean> getBunkatuKeisanKekka13() {
        return bunkatuKeisanKekka13DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka13(List<BunkatuKeisanKekka13DataSourceBean> pBunkatuKeisanKekka13) {
        bunkatuKeisanKekka13DataSource.setDatas(pBunkatuKeisanKekka13);
    }

    private DataSource<BunkatuKeisanKekka14DataSourceBean> bunkatuKeisanKekka14DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka14DataSourceBean> getBunkatuKeisanKekka14DataSource() {
        return bunkatuKeisanKekka14DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka14DataSourceBean> getBunkatuKeisanKekka14() {
        return bunkatuKeisanKekka14DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka14(List<BunkatuKeisanKekka14DataSourceBean> pBunkatuKeisanKekka14) {
        bunkatuKeisanKekka14DataSource.setDatas(pBunkatuKeisanKekka14);
    }

    private DataSource<BunkatuKeisanKekka15DataSourceBean> bunkatuKeisanKekka15DataSource = new DataSource<>();
    public DataSource<BunkatuKeisanKekka15DataSourceBean> getBunkatuKeisanKekka15DataSource() {
        return bunkatuKeisanKekka15DataSource;
    }

    @Deprecated
    public List<BunkatuKeisanKekka15DataSourceBean> getBunkatuKeisanKekka15() {
        return bunkatuKeisanKekka15DataSource.getDatas();
    }

    public void setBunkatuKeisanKekka15(List<BunkatuKeisanKekka15DataSourceBean> pBunkatuKeisanKekka15) {
        bunkatuKeisanKekka15DataSource.setDatas(pBunkatuKeisanKekka15);
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

    private BizCurrency bnktmaegaikagoukei;

    public BizCurrency getBnktmaegaikagoukei() {
        return bnktmaegaikagoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaegaikagoukei(BizCurrency pBnktmaegaikagoukei) {
        bnktmaegaikagoukei = pBnktmaegaikagoukei;
    }

    private BizCurrency bnktmaehokenkngkgoukei;

    public BizCurrency getBnktmaehokenkngkgoukei() {
        return bnktmaehokenkngkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaehokenkngkgoukei(BizCurrency pBnktmaehokenkngkgoukei) {
        bnktmaehokenkngkgoukei = pBnktmaehokenkngkgoukei;
    }

    private String mikeikapgaitoukkn;

    public String getMikeikapgaitoukkn() {
        return mikeikapgaitoukkn;
    }

    public void setMikeikapgaitoukkn(String pMikeikapgaitoukkn) {
        mikeikapgaitoukkn = pMikeikapgaitoukkn;
    }

    private BizCurrency bnktmaemikeikap;

    public BizCurrency getBnktmaemikeikap() {
        return bnktmaemikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaemikeikap(BizCurrency pBnktmaemikeikap) {
        bnktmaemikeikap = pBnktmaemikeikap;
    }

    private String misyuupgaitoukkn;

    public String getMisyuupgaitoukkn() {
        return misyuupgaitoukkn;
    }

    public void setMisyuupgaitoukkn(String pMisyuupgaitoukkn) {
        misyuupgaitoukkn = pMisyuupgaitoukkn;
    }

    private BizCurrency bnktmaemisyuup;

    public BizCurrency getBnktmaemisyuup() {
        return bnktmaemisyuup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaemisyuup(BizCurrency pBnktmaemisyuup) {
        bnktmaemisyuup = pBnktmaemisyuup;
    }

    private BizCurrency bnktmaeznnusisnkgk;

    public BizCurrency getBnktmaeznnusisnkgk() {
        return bnktmaeznnusisnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeznnusisnkgk(BizCurrency pBnktmaeznnusisnkgk) {
        bnktmaeznnusisnkgk = pBnktmaeznnusisnkgk;
    }

    private BizCurrency bnkatmaezitkazkrknstituka;

    public BizCurrency getBnkatmaezitkazkrknstituka() {
        return bnkatmaezitkazkrknstituka;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnkatmaezitkazkrknstituka(BizCurrency pBnkatmaezitkazkrknstituka) {
        bnkatmaezitkazkrknstituka = pBnkatmaezitkazkrknstituka;
    }

    private BizCurrency bnktmaeyengoukei;

    public BizCurrency getBnktmaeyengoukei() {
        return bnktmaeyengoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyengoukei(BizCurrency pBnktmaeyengoukei) {
        bnktmaeyengoukei = pBnktmaeyengoukei;
    }

    private BizCurrency bnktmaeyenhknkngkguki;

    public BizCurrency getBnktmaeyenhknkngkguki() {
        return bnktmaeyenhknkngkguki;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenhknkngkguki(BizCurrency pBnktmaeyenhknkngkguki) {
        bnktmaeyenhknkngkguki = pBnktmaeyenhknkngkguki;
    }

    private BizCurrency bnktmaeyenhaitoukin;

    public BizCurrency getBnktmaeyenhaitoukin() {
        return bnktmaeyenhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenhaitoukin(BizCurrency pBnktmaeyenhaitoukin) {
        bnktmaeyenhaitoukin = pBnktmaeyenhaitoukin;
    }

    private BizCurrency bnktmaeyensonotahaitoukin;

    public BizCurrency getBnktmaeyensonotahaitoukin() {
        return bnktmaeyensonotahaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyensonotahaitoukin(BizCurrency pBnktmaeyensonotahaitoukin) {
        bnktmaeyensonotahaitoukin = pBnktmaeyensonotahaitoukin;
    }

    private String yenkamikeikapgaitoukkn;

    public String getYenkamikeikapgaitoukkn() {
        return yenkamikeikapgaitoukkn;
    }

    public void setYenkamikeikapgaitoukkn(String pYenkamikeikapgaitoukkn) {
        yenkamikeikapgaitoukkn = pYenkamikeikapgaitoukkn;
    }

    private BizCurrency bnktmaeyenmikeikap;

    public BizCurrency getBnktmaeyenmikeikap() {
        return bnktmaeyenmikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenmikeikap(BizCurrency pBnktmaeyenmikeikap) {
        bnktmaeyenmikeikap = pBnktmaeyenmikeikap;
    }

    private String yenkamisyuupgaitoukkn;

    public String getYenkamisyuupgaitoukkn() {
        return yenkamisyuupgaitoukkn;
    }

    public void setYenkamisyuupgaitoukkn(String pYenkamisyuupgaitoukkn) {
        yenkamisyuupgaitoukkn = pYenkamisyuupgaitoukkn;
    }

    private BizCurrency bnktmaeyenmisyuup;

    public BizCurrency getBnktmaeyenmisyuup() {
        return bnktmaeyenmisyuup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenmisyuup(BizCurrency pBnktmaeyenmisyuup) {
        bnktmaeyenmisyuup = pBnktmaeyenmisyuup;
    }

    private BizCurrency bnktmaeyenznnusisnkgk;

    public BizCurrency getBnktmaeyenznnusisnkgk() {
        return bnktmaeyenznnusisnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenznnusisnkgk(BizCurrency pBnktmaeyenznnusisnkgk) {
        bnktmaeyenznnusisnkgk = pBnktmaeyenznnusisnkgk;
    }

    private BizCurrency bnktmaezitkazkrknyen;

    public BizCurrency getBnktmaezitkazkrknyen() {
        return bnktmaezitkazkrknyen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaezitkazkrknyen(BizCurrency pBnktmaezitkazkrknyen) {
        bnktmaezitkazkrknyen = pBnktmaezitkazkrknyen;
    }

    private BizCurrency bnktmaeyenkrkgk;

    public BizCurrency getBnktmaeyenkrkgk() {
        return bnktmaeyenkrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktmaeyenkrkgk(BizCurrency pBnktmaeyenkrkgk) {
        bnktmaeyenkrkgk = pBnktmaeyenkrkgk;
    }

    private String sbuktninmoji;

    public String getSbuktninmoji() {
        return sbuktninmoji;
    }

    public void setSbuktninmoji(String pSbuktninmoji) {
        sbuktninmoji = pSbuktninmoji;
    }

    private C_BunkatuHouhouKbn bunkatuhouhoukbn;

    public C_BunkatuHouhouKbn getBunkatuhouhoukbn() {
        return bunkatuhouhoukbn;
    }

    public void setBunkatuhouhoukbn(C_BunkatuHouhouKbn pBunkatuhouhoukbn) {
        bunkatuhouhoukbn = pBunkatuhouhoukbn;
    }

    @Range(min="0", max="99")
    private Integer shrtaisyouuktrjuni;

    public Integer getShrtaisyouuktrjuni() {
        return shrtaisyouuktrjuni;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrtaisyouuktrjuni(Integer pShrtaisyouuktrjuni) {
        shrtaisyouuktrjuni = pShrtaisyouuktrjuni;
    }

    private BizCurrency gaikaknrgoukei1;

    public BizCurrency getGaikaknrgoukei1() {
        return gaikaknrgoukei1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei1(BizCurrency pGaikaknrgoukei1) {
        gaikaknrgoukei1 = pGaikaknrgoukei1;
    }

    private BizCurrency hokenkngkgoukei1;

    public BizCurrency getHokenkngkgoukei1() {
        return hokenkngkgoukei1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei1(BizCurrency pHokenkngkgoukei1) {
        hokenkngkgoukei1 = pHokenkngkgoukei1;
    }

    private BizCurrency mikeikap1;

    public BizCurrency getMikeikap1() {
        return mikeikap1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap1(BizCurrency pMikeikap1) {
        mikeikap1 = pMikeikap1;
    }

    private BizCurrency misyuup1;

    public BizCurrency getMisyuup1() {
        return misyuup1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup1(BizCurrency pMisyuup1) {
        misyuup1 = pMisyuup1;
    }

    private BizCurrency znnusisnkgk1;

    public BizCurrency getZnnusisnkgk1() {
        return znnusisnkgk1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk1(BizCurrency pZnnusisnkgk1) {
        znnusisnkgk1 = pZnnusisnkgk1;
    }

    private BizCurrency zitkazkrknstituka1;

    public BizCurrency getZitkazkrknstituka1() {
        return zitkazkrknstituka1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka1(BizCurrency pZitkazkrknstituka1) {
        zitkazkrknstituka1 = pZitkazkrknstituka1;
    }

    private BizCurrency yenkaknrgoukei1;

    public BizCurrency getYenkaknrgoukei1() {
        return yenkaknrgoukei1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei1(BizCurrency pYenkaknrgoukei1) {
        yenkaknrgoukei1 = pYenkaknrgoukei1;
    }

    private BizCurrency yenhknkngkguki1;

    public BizCurrency getYenhknkngkguki1() {
        return yenhknkngkguki1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki1(BizCurrency pYenhknkngkguki1) {
        yenhknkngkguki1 = pYenhknkngkguki1;
    }

    private BizCurrency yenhaitoukin1;

    public BizCurrency getYenhaitoukin1() {
        return yenhaitoukin1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin1(BizCurrency pYenhaitoukin1) {
        yenhaitoukin1 = pYenhaitoukin1;
    }

    private BizCurrency yensonotahaitoukin1;

    public BizCurrency getYensonotahaitoukin1() {
        return yensonotahaitoukin1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin1(BizCurrency pYensonotahaitoukin1) {
        yensonotahaitoukin1 = pYensonotahaitoukin1;
    }

    private BizCurrency yenmikeikap1;

    public BizCurrency getYenmikeikap1() {
        return yenmikeikap1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap1(BizCurrency pYenmikeikap1) {
        yenmikeikap1 = pYenmikeikap1;
    }

    private BizCurrency yenmisyuup1;

    public BizCurrency getYenmisyuup1() {
        return yenmisyuup1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup1(BizCurrency pYenmisyuup1) {
        yenmisyuup1 = pYenmisyuup1;
    }

    private BizCurrency yenznnusisnkgk1;

    public BizCurrency getYenznnusisnkgk1() {
        return yenznnusisnkgk1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk1(BizCurrency pYenznnusisnkgk1) {
        yenznnusisnkgk1 = pYenznnusisnkgk1;
    }

    private BizCurrency zitkazkrknyen1;

    public BizCurrency getZitkazkrknyen1() {
        return zitkazkrknyen1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen1(BizCurrency pZitkazkrknyen1) {
        zitkazkrknyen1 = pZitkazkrknyen1;
    }

    private BizCurrency yenkrkgk1;

    public BizCurrency getYenkrkgk1() {
        return yenkrkgk1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk1(BizCurrency pYenkrkgk1) {
        yenkrkgk1 = pYenkrkgk1;
    }

    private BizCurrency gaikaknrgoukei2;

    public BizCurrency getGaikaknrgoukei2() {
        return gaikaknrgoukei2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei2(BizCurrency pGaikaknrgoukei2) {
        gaikaknrgoukei2 = pGaikaknrgoukei2;
    }

    private BizCurrency hokenkngkgoukei2;

    public BizCurrency getHokenkngkgoukei2() {
        return hokenkngkgoukei2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei2(BizCurrency pHokenkngkgoukei2) {
        hokenkngkgoukei2 = pHokenkngkgoukei2;
    }

    private BizCurrency mikeikap2;

    public BizCurrency getMikeikap2() {
        return mikeikap2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap2(BizCurrency pMikeikap2) {
        mikeikap2 = pMikeikap2;
    }

    private BizCurrency misyuup2;

    public BizCurrency getMisyuup2() {
        return misyuup2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup2(BizCurrency pMisyuup2) {
        misyuup2 = pMisyuup2;
    }

    private BizCurrency znnusisnkgk2;

    public BizCurrency getZnnusisnkgk2() {
        return znnusisnkgk2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk2(BizCurrency pZnnusisnkgk2) {
        znnusisnkgk2 = pZnnusisnkgk2;
    }

    private BizCurrency zitkazkrknstituka2;

    public BizCurrency getZitkazkrknstituka2() {
        return zitkazkrknstituka2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka2(BizCurrency pZitkazkrknstituka2) {
        zitkazkrknstituka2 = pZitkazkrknstituka2;
    }

    private BizCurrency yenkaknrgoukei2;

    public BizCurrency getYenkaknrgoukei2() {
        return yenkaknrgoukei2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei2(BizCurrency pYenkaknrgoukei2) {
        yenkaknrgoukei2 = pYenkaknrgoukei2;
    }

    private BizCurrency yenhknkngkguki2;

    public BizCurrency getYenhknkngkguki2() {
        return yenhknkngkguki2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki2(BizCurrency pYenhknkngkguki2) {
        yenhknkngkguki2 = pYenhknkngkguki2;
    }

    private BizCurrency yenhaitoukin2;

    public BizCurrency getYenhaitoukin2() {
        return yenhaitoukin2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin2(BizCurrency pYenhaitoukin2) {
        yenhaitoukin2 = pYenhaitoukin2;
    }

    private BizCurrency yensonotahaitoukin2;

    public BizCurrency getYensonotahaitoukin2() {
        return yensonotahaitoukin2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin2(BizCurrency pYensonotahaitoukin2) {
        yensonotahaitoukin2 = pYensonotahaitoukin2;
    }

    private BizCurrency yenmikeikap2;

    public BizCurrency getYenmikeikap2() {
        return yenmikeikap2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap2(BizCurrency pYenmikeikap2) {
        yenmikeikap2 = pYenmikeikap2;
    }

    private BizCurrency yenmisyuup2;

    public BizCurrency getYenmisyuup2() {
        return yenmisyuup2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup2(BizCurrency pYenmisyuup2) {
        yenmisyuup2 = pYenmisyuup2;
    }

    private BizCurrency yenznnusisnkgk2;

    public BizCurrency getYenznnusisnkgk2() {
        return yenznnusisnkgk2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk2(BizCurrency pYenznnusisnkgk2) {
        yenznnusisnkgk2 = pYenznnusisnkgk2;
    }

    private BizCurrency zitkazkrknyen2;

    public BizCurrency getZitkazkrknyen2() {
        return zitkazkrknyen2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen2(BizCurrency pZitkazkrknyen2) {
        zitkazkrknyen2 = pZitkazkrknyen2;
    }

    private BizCurrency yenkrkgk2;

    public BizCurrency getYenkrkgk2() {
        return yenkrkgk2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk2(BizCurrency pYenkrkgk2) {
        yenkrkgk2 = pYenkrkgk2;
    }

    private BizCurrency gaikaknrgoukei3;

    public BizCurrency getGaikaknrgoukei3() {
        return gaikaknrgoukei3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei3(BizCurrency pGaikaknrgoukei3) {
        gaikaknrgoukei3 = pGaikaknrgoukei3;
    }

    private BizCurrency hokenkngkgoukei3;

    public BizCurrency getHokenkngkgoukei3() {
        return hokenkngkgoukei3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei3(BizCurrency pHokenkngkgoukei3) {
        hokenkngkgoukei3 = pHokenkngkgoukei3;
    }

    private BizCurrency mikeikap3;

    public BizCurrency getMikeikap3() {
        return mikeikap3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap3(BizCurrency pMikeikap3) {
        mikeikap3 = pMikeikap3;
    }

    private BizCurrency misyuup3;

    public BizCurrency getMisyuup3() {
        return misyuup3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup3(BizCurrency pMisyuup3) {
        misyuup3 = pMisyuup3;
    }

    private BizCurrency znnusisnkgk3;

    public BizCurrency getZnnusisnkgk3() {
        return znnusisnkgk3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk3(BizCurrency pZnnusisnkgk3) {
        znnusisnkgk3 = pZnnusisnkgk3;
    }

    private BizCurrency zitkazkrknstituka3;

    public BizCurrency getZitkazkrknstituka3() {
        return zitkazkrknstituka3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka3(BizCurrency pZitkazkrknstituka3) {
        zitkazkrknstituka3 = pZitkazkrknstituka3;
    }

    private BizCurrency yenkaknrgoukei3;

    public BizCurrency getYenkaknrgoukei3() {
        return yenkaknrgoukei3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei3(BizCurrency pYenkaknrgoukei3) {
        yenkaknrgoukei3 = pYenkaknrgoukei3;
    }

    private BizCurrency yenhknkngkguki3;

    public BizCurrency getYenhknkngkguki3() {
        return yenhknkngkguki3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki3(BizCurrency pYenhknkngkguki3) {
        yenhknkngkguki3 = pYenhknkngkguki3;
    }

    private BizCurrency yenhaitoukin3;

    public BizCurrency getYenhaitoukin3() {
        return yenhaitoukin3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin3(BizCurrency pYenhaitoukin3) {
        yenhaitoukin3 = pYenhaitoukin3;
    }

    private BizCurrency yensonotahaitoukin3;

    public BizCurrency getYensonotahaitoukin3() {
        return yensonotahaitoukin3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin3(BizCurrency pYensonotahaitoukin3) {
        yensonotahaitoukin3 = pYensonotahaitoukin3;
    }

    private BizCurrency yenmikeikap3;

    public BizCurrency getYenmikeikap3() {
        return yenmikeikap3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap3(BizCurrency pYenmikeikap3) {
        yenmikeikap3 = pYenmikeikap3;
    }

    private BizCurrency yenmisyuup3;

    public BizCurrency getYenmisyuup3() {
        return yenmisyuup3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup3(BizCurrency pYenmisyuup3) {
        yenmisyuup3 = pYenmisyuup3;
    }

    private BizCurrency yenznnusisnkgk3;

    public BizCurrency getYenznnusisnkgk3() {
        return yenznnusisnkgk3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk3(BizCurrency pYenznnusisnkgk3) {
        yenznnusisnkgk3 = pYenznnusisnkgk3;
    }

    private BizCurrency zitkazkrknyen3;

    public BizCurrency getZitkazkrknyen3() {
        return zitkazkrknyen3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen3(BizCurrency pZitkazkrknyen3) {
        zitkazkrknyen3 = pZitkazkrknyen3;
    }

    private BizCurrency yenkrkgk3;

    public BizCurrency getYenkrkgk3() {
        return yenkrkgk3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk3(BizCurrency pYenkrkgk3) {
        yenkrkgk3 = pYenkrkgk3;
    }

    private BizCurrency gaikaknrgoukei4;

    public BizCurrency getGaikaknrgoukei4() {
        return gaikaknrgoukei4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei4(BizCurrency pGaikaknrgoukei4) {
        gaikaknrgoukei4 = pGaikaknrgoukei4;
    }

    private BizCurrency hokenkngkgoukei4;

    public BizCurrency getHokenkngkgoukei4() {
        return hokenkngkgoukei4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei4(BizCurrency pHokenkngkgoukei4) {
        hokenkngkgoukei4 = pHokenkngkgoukei4;
    }

    private BizCurrency mikeikap4;

    public BizCurrency getMikeikap4() {
        return mikeikap4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap4(BizCurrency pMikeikap4) {
        mikeikap4 = pMikeikap4;
    }

    private BizCurrency misyuup4;

    public BizCurrency getMisyuup4() {
        return misyuup4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup4(BizCurrency pMisyuup4) {
        misyuup4 = pMisyuup4;
    }

    private BizCurrency znnusisnkgk4;

    public BizCurrency getZnnusisnkgk4() {
        return znnusisnkgk4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk4(BizCurrency pZnnusisnkgk4) {
        znnusisnkgk4 = pZnnusisnkgk4;
    }

    private BizCurrency zitkazkrknstituka4;

    public BizCurrency getZitkazkrknstituka4() {
        return zitkazkrknstituka4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka4(BizCurrency pZitkazkrknstituka4) {
        zitkazkrknstituka4 = pZitkazkrknstituka4;
    }

    private BizCurrency yenkaknrgoukei4;

    public BizCurrency getYenkaknrgoukei4() {
        return yenkaknrgoukei4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei4(BizCurrency pYenkaknrgoukei4) {
        yenkaknrgoukei4 = pYenkaknrgoukei4;
    }

    private BizCurrency yenhknkngkguki4;

    public BizCurrency getYenhknkngkguki4() {
        return yenhknkngkguki4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki4(BizCurrency pYenhknkngkguki4) {
        yenhknkngkguki4 = pYenhknkngkguki4;
    }

    private BizCurrency yenhaitoukin4;

    public BizCurrency getYenhaitoukin4() {
        return yenhaitoukin4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin4(BizCurrency pYenhaitoukin4) {
        yenhaitoukin4 = pYenhaitoukin4;
    }

    private BizCurrency yensonotahaitoukin4;

    public BizCurrency getYensonotahaitoukin4() {
        return yensonotahaitoukin4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin4(BizCurrency pYensonotahaitoukin4) {
        yensonotahaitoukin4 = pYensonotahaitoukin4;
    }

    private BizCurrency yenmikeikap4;

    public BizCurrency getYenmikeikap4() {
        return yenmikeikap4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap4(BizCurrency pYenmikeikap4) {
        yenmikeikap4 = pYenmikeikap4;
    }

    private BizCurrency yenmisyuup4;

    public BizCurrency getYenmisyuup4() {
        return yenmisyuup4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup4(BizCurrency pYenmisyuup4) {
        yenmisyuup4 = pYenmisyuup4;
    }

    private BizCurrency yenznnusisnkgk4;

    public BizCurrency getYenznnusisnkgk4() {
        return yenznnusisnkgk4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk4(BizCurrency pYenznnusisnkgk4) {
        yenznnusisnkgk4 = pYenznnusisnkgk4;
    }

    private BizCurrency zitkazkrknyen4;

    public BizCurrency getZitkazkrknyen4() {
        return zitkazkrknyen4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen4(BizCurrency pZitkazkrknyen4) {
        zitkazkrknyen4 = pZitkazkrknyen4;
    }

    private BizCurrency yenkrkgk4;

    public BizCurrency getYenkrkgk4() {
        return yenkrkgk4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk4(BizCurrency pYenkrkgk4) {
        yenkrkgk4 = pYenkrkgk4;
    }

    private BizCurrency gaikaknrgoukei5;

    public BizCurrency getGaikaknrgoukei5() {
        return gaikaknrgoukei5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei5(BizCurrency pGaikaknrgoukei5) {
        gaikaknrgoukei5 = pGaikaknrgoukei5;
    }

    private BizCurrency hokenkngkgoukei5;

    public BizCurrency getHokenkngkgoukei5() {
        return hokenkngkgoukei5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei5(BizCurrency pHokenkngkgoukei5) {
        hokenkngkgoukei5 = pHokenkngkgoukei5;
    }

    private BizCurrency mikeikap5;

    public BizCurrency getMikeikap5() {
        return mikeikap5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap5(BizCurrency pMikeikap5) {
        mikeikap5 = pMikeikap5;
    }

    private BizCurrency misyuup5;

    public BizCurrency getMisyuup5() {
        return misyuup5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup5(BizCurrency pMisyuup5) {
        misyuup5 = pMisyuup5;
    }

    private BizCurrency znnusisnkgk5;

    public BizCurrency getZnnusisnkgk5() {
        return znnusisnkgk5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk5(BizCurrency pZnnusisnkgk5) {
        znnusisnkgk5 = pZnnusisnkgk5;
    }

    private BizCurrency zitkazkrknstituka5;

    public BizCurrency getZitkazkrknstituka5() {
        return zitkazkrknstituka5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka5(BizCurrency pZitkazkrknstituka5) {
        zitkazkrknstituka5 = pZitkazkrknstituka5;
    }

    private BizCurrency yenkaknrgoukei5;

    public BizCurrency getYenkaknrgoukei5() {
        return yenkaknrgoukei5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei5(BizCurrency pYenkaknrgoukei5) {
        yenkaknrgoukei5 = pYenkaknrgoukei5;
    }

    private BizCurrency yenhknkngkguki5;

    public BizCurrency getYenhknkngkguki5() {
        return yenhknkngkguki5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki5(BizCurrency pYenhknkngkguki5) {
        yenhknkngkguki5 = pYenhknkngkguki5;
    }

    private BizCurrency yenhaitoukin5;

    public BizCurrency getYenhaitoukin5() {
        return yenhaitoukin5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin5(BizCurrency pYenhaitoukin5) {
        yenhaitoukin5 = pYenhaitoukin5;
    }

    private BizCurrency yensonotahaitoukin5;

    public BizCurrency getYensonotahaitoukin5() {
        return yensonotahaitoukin5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin5(BizCurrency pYensonotahaitoukin5) {
        yensonotahaitoukin5 = pYensonotahaitoukin5;
    }

    private BizCurrency yenmikeikap5;

    public BizCurrency getYenmikeikap5() {
        return yenmikeikap5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap5(BizCurrency pYenmikeikap5) {
        yenmikeikap5 = pYenmikeikap5;
    }

    private BizCurrency yenmisyuup5;

    public BizCurrency getYenmisyuup5() {
        return yenmisyuup5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup5(BizCurrency pYenmisyuup5) {
        yenmisyuup5 = pYenmisyuup5;
    }

    private BizCurrency yenznnusisnkgk5;

    public BizCurrency getYenznnusisnkgk5() {
        return yenznnusisnkgk5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk5(BizCurrency pYenznnusisnkgk5) {
        yenznnusisnkgk5 = pYenznnusisnkgk5;
    }

    private BizCurrency zitkazkrknyen5;

    public BizCurrency getZitkazkrknyen5() {
        return zitkazkrknyen5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen5(BizCurrency pZitkazkrknyen5) {
        zitkazkrknyen5 = pZitkazkrknyen5;
    }

    private BizCurrency yenkrkgk5;

    public BizCurrency getYenkrkgk5() {
        return yenkrkgk5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk5(BizCurrency pYenkrkgk5) {
        yenkrkgk5 = pYenkrkgk5;
    }

    private BizCurrency gaikaknrgoukei6;

    public BizCurrency getGaikaknrgoukei6() {
        return gaikaknrgoukei6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei6(BizCurrency pGaikaknrgoukei6) {
        gaikaknrgoukei6 = pGaikaknrgoukei6;
    }

    private BizCurrency hokenkngkgoukei6;

    public BizCurrency getHokenkngkgoukei6() {
        return hokenkngkgoukei6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei6(BizCurrency pHokenkngkgoukei6) {
        hokenkngkgoukei6 = pHokenkngkgoukei6;
    }

    private BizCurrency mikeikap6;

    public BizCurrency getMikeikap6() {
        return mikeikap6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap6(BizCurrency pMikeikap6) {
        mikeikap6 = pMikeikap6;
    }

    private BizCurrency misyuup6;

    public BizCurrency getMisyuup6() {
        return misyuup6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup6(BizCurrency pMisyuup6) {
        misyuup6 = pMisyuup6;
    }

    private BizCurrency znnusisnkgk6;

    public BizCurrency getZnnusisnkgk6() {
        return znnusisnkgk6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk6(BizCurrency pZnnusisnkgk6) {
        znnusisnkgk6 = pZnnusisnkgk6;
    }

    private BizCurrency zitkazkrknstituka6;

    public BizCurrency getZitkazkrknstituka6() {
        return zitkazkrknstituka6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka6(BizCurrency pZitkazkrknstituka6) {
        zitkazkrknstituka6 = pZitkazkrknstituka6;
    }

    private BizCurrency yenkaknrgoukei6;

    public BizCurrency getYenkaknrgoukei6() {
        return yenkaknrgoukei6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei6(BizCurrency pYenkaknrgoukei6) {
        yenkaknrgoukei6 = pYenkaknrgoukei6;
    }

    private BizCurrency yenhknkngkguki6;

    public BizCurrency getYenhknkngkguki6() {
        return yenhknkngkguki6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki6(BizCurrency pYenhknkngkguki6) {
        yenhknkngkguki6 = pYenhknkngkguki6;
    }

    private BizCurrency yenhaitoukin6;

    public BizCurrency getYenhaitoukin6() {
        return yenhaitoukin6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin6(BizCurrency pYenhaitoukin6) {
        yenhaitoukin6 = pYenhaitoukin6;
    }

    private BizCurrency yensonotahaitoukin6;

    public BizCurrency getYensonotahaitoukin6() {
        return yensonotahaitoukin6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin6(BizCurrency pYensonotahaitoukin6) {
        yensonotahaitoukin6 = pYensonotahaitoukin6;
    }

    private BizCurrency yenmikeikap6;

    public BizCurrency getYenmikeikap6() {
        return yenmikeikap6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap6(BizCurrency pYenmikeikap6) {
        yenmikeikap6 = pYenmikeikap6;
    }

    private BizCurrency yenmisyuup6;

    public BizCurrency getYenmisyuup6() {
        return yenmisyuup6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup6(BizCurrency pYenmisyuup6) {
        yenmisyuup6 = pYenmisyuup6;
    }

    private BizCurrency yenznnusisnkgk6;

    public BizCurrency getYenznnusisnkgk6() {
        return yenznnusisnkgk6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk6(BizCurrency pYenznnusisnkgk6) {
        yenznnusisnkgk6 = pYenznnusisnkgk6;
    }

    private BizCurrency zitkazkrknyen6;

    public BizCurrency getZitkazkrknyen6() {
        return zitkazkrknyen6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen6(BizCurrency pZitkazkrknyen6) {
        zitkazkrknyen6 = pZitkazkrknyen6;
    }

    private BizCurrency yenkrkgk6;

    public BizCurrency getYenkrkgk6() {
        return yenkrkgk6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk6(BizCurrency pYenkrkgk6) {
        yenkrkgk6 = pYenkrkgk6;
    }

    private BizCurrency gaikaknrgoukei7;

    public BizCurrency getGaikaknrgoukei7() {
        return gaikaknrgoukei7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei7(BizCurrency pGaikaknrgoukei7) {
        gaikaknrgoukei7 = pGaikaknrgoukei7;
    }

    private BizCurrency hokenkngkgoukei7;

    public BizCurrency getHokenkngkgoukei7() {
        return hokenkngkgoukei7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei7(BizCurrency pHokenkngkgoukei7) {
        hokenkngkgoukei7 = pHokenkngkgoukei7;
    }

    private BizCurrency mikeikap7;

    public BizCurrency getMikeikap7() {
        return mikeikap7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap7(BizCurrency pMikeikap7) {
        mikeikap7 = pMikeikap7;
    }

    private BizCurrency misyuup7;

    public BizCurrency getMisyuup7() {
        return misyuup7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup7(BizCurrency pMisyuup7) {
        misyuup7 = pMisyuup7;
    }

    private BizCurrency znnusisnkgk7;

    public BizCurrency getZnnusisnkgk7() {
        return znnusisnkgk7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk7(BizCurrency pZnnusisnkgk7) {
        znnusisnkgk7 = pZnnusisnkgk7;
    }

    private BizCurrency zitkazkrknstituka7;

    public BizCurrency getZitkazkrknstituka7() {
        return zitkazkrknstituka7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka7(BizCurrency pZitkazkrknstituka7) {
        zitkazkrknstituka7 = pZitkazkrknstituka7;
    }

    private BizCurrency yenkaknrgoukei7;

    public BizCurrency getYenkaknrgoukei7() {
        return yenkaknrgoukei7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei7(BizCurrency pYenkaknrgoukei7) {
        yenkaknrgoukei7 = pYenkaknrgoukei7;
    }

    private BizCurrency yenhknkngkguki7;

    public BizCurrency getYenhknkngkguki7() {
        return yenhknkngkguki7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki7(BizCurrency pYenhknkngkguki7) {
        yenhknkngkguki7 = pYenhknkngkguki7;
    }

    private BizCurrency yenhaitoukin7;

    public BizCurrency getYenhaitoukin7() {
        return yenhaitoukin7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin7(BizCurrency pYenhaitoukin7) {
        yenhaitoukin7 = pYenhaitoukin7;
    }

    private BizCurrency yensonotahaitoukin7;

    public BizCurrency getYensonotahaitoukin7() {
        return yensonotahaitoukin7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin7(BizCurrency pYensonotahaitoukin7) {
        yensonotahaitoukin7 = pYensonotahaitoukin7;
    }

    private BizCurrency yenmikeikap7;

    public BizCurrency getYenmikeikap7() {
        return yenmikeikap7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap7(BizCurrency pYenmikeikap7) {
        yenmikeikap7 = pYenmikeikap7;
    }

    private BizCurrency yenmisyuup7;

    public BizCurrency getYenmisyuup7() {
        return yenmisyuup7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup7(BizCurrency pYenmisyuup7) {
        yenmisyuup7 = pYenmisyuup7;
    }

    private BizCurrency yenznnusisnkgk7;

    public BizCurrency getYenznnusisnkgk7() {
        return yenznnusisnkgk7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk7(BizCurrency pYenznnusisnkgk7) {
        yenznnusisnkgk7 = pYenznnusisnkgk7;
    }

    private BizCurrency zitkazkrknyen7;

    public BizCurrency getZitkazkrknyen7() {
        return zitkazkrknyen7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen7(BizCurrency pZitkazkrknyen7) {
        zitkazkrknyen7 = pZitkazkrknyen7;
    }

    private BizCurrency yenkrkgk7;

    public BizCurrency getYenkrkgk7() {
        return yenkrkgk7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk7(BizCurrency pYenkrkgk7) {
        yenkrkgk7 = pYenkrkgk7;
    }

    private BizCurrency gaikaknrgoukei8;

    public BizCurrency getGaikaknrgoukei8() {
        return gaikaknrgoukei8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei8(BizCurrency pGaikaknrgoukei8) {
        gaikaknrgoukei8 = pGaikaknrgoukei8;
    }

    private BizCurrency hokenkngkgoukei8;

    public BizCurrency getHokenkngkgoukei8() {
        return hokenkngkgoukei8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei8(BizCurrency pHokenkngkgoukei8) {
        hokenkngkgoukei8 = pHokenkngkgoukei8;
    }

    private BizCurrency mikeikap8;

    public BizCurrency getMikeikap8() {
        return mikeikap8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap8(BizCurrency pMikeikap8) {
        mikeikap8 = pMikeikap8;
    }

    private BizCurrency misyuup8;

    public BizCurrency getMisyuup8() {
        return misyuup8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup8(BizCurrency pMisyuup8) {
        misyuup8 = pMisyuup8;
    }

    private BizCurrency znnusisnkgk8;

    public BizCurrency getZnnusisnkgk8() {
        return znnusisnkgk8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk8(BizCurrency pZnnusisnkgk8) {
        znnusisnkgk8 = pZnnusisnkgk8;
    }

    private BizCurrency zitkazkrknstituka8;

    public BizCurrency getZitkazkrknstituka8() {
        return zitkazkrknstituka8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka8(BizCurrency pZitkazkrknstituka8) {
        zitkazkrknstituka8 = pZitkazkrknstituka8;
    }

    private BizCurrency yenkaknrgoukei8;

    public BizCurrency getYenkaknrgoukei8() {
        return yenkaknrgoukei8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei8(BizCurrency pYenkaknrgoukei8) {
        yenkaknrgoukei8 = pYenkaknrgoukei8;
    }

    private BizCurrency yenhknkngkguki8;

    public BizCurrency getYenhknkngkguki8() {
        return yenhknkngkguki8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki8(BizCurrency pYenhknkngkguki8) {
        yenhknkngkguki8 = pYenhknkngkguki8;
    }

    private BizCurrency yenhaitoukin8;

    public BizCurrency getYenhaitoukin8() {
        return yenhaitoukin8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin8(BizCurrency pYenhaitoukin8) {
        yenhaitoukin8 = pYenhaitoukin8;
    }

    private BizCurrency yensonotahaitoukin8;

    public BizCurrency getYensonotahaitoukin8() {
        return yensonotahaitoukin8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin8(BizCurrency pYensonotahaitoukin8) {
        yensonotahaitoukin8 = pYensonotahaitoukin8;
    }

    private BizCurrency yenmikeikap8;

    public BizCurrency getYenmikeikap8() {
        return yenmikeikap8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap8(BizCurrency pYenmikeikap8) {
        yenmikeikap8 = pYenmikeikap8;
    }

    private BizCurrency yenmisyuup8;

    public BizCurrency getYenmisyuup8() {
        return yenmisyuup8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup8(BizCurrency pYenmisyuup8) {
        yenmisyuup8 = pYenmisyuup8;
    }

    private BizCurrency yenznnusisnkgk8;

    public BizCurrency getYenznnusisnkgk8() {
        return yenznnusisnkgk8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk8(BizCurrency pYenznnusisnkgk8) {
        yenznnusisnkgk8 = pYenznnusisnkgk8;
    }

    private BizCurrency zitkazkrknyen8;

    public BizCurrency getZitkazkrknyen8() {
        return zitkazkrknyen8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen8(BizCurrency pZitkazkrknyen8) {
        zitkazkrknyen8 = pZitkazkrknyen8;
    }

    private BizCurrency yenkrkgk8;

    public BizCurrency getYenkrkgk8() {
        return yenkrkgk8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk8(BizCurrency pYenkrkgk8) {
        yenkrkgk8 = pYenkrkgk8;
    }

    private BizCurrency gaikaknrgoukei9;

    public BizCurrency getGaikaknrgoukei9() {
        return gaikaknrgoukei9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei9(BizCurrency pGaikaknrgoukei9) {
        gaikaknrgoukei9 = pGaikaknrgoukei9;
    }

    private BizCurrency hokenkngkgoukei9;

    public BizCurrency getHokenkngkgoukei9() {
        return hokenkngkgoukei9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei9(BizCurrency pHokenkngkgoukei9) {
        hokenkngkgoukei9 = pHokenkngkgoukei9;
    }

    private BizCurrency mikeikap9;

    public BizCurrency getMikeikap9() {
        return mikeikap9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap9(BizCurrency pMikeikap9) {
        mikeikap9 = pMikeikap9;
    }

    private BizCurrency misyuup9;

    public BizCurrency getMisyuup9() {
        return misyuup9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup9(BizCurrency pMisyuup9) {
        misyuup9 = pMisyuup9;
    }

    private BizCurrency znnusisnkgk9;

    public BizCurrency getZnnusisnkgk9() {
        return znnusisnkgk9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk9(BizCurrency pZnnusisnkgk9) {
        znnusisnkgk9 = pZnnusisnkgk9;
    }

    private BizCurrency zitkazkrknstituka9;

    public BizCurrency getZitkazkrknstituka9() {
        return zitkazkrknstituka9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka9(BizCurrency pZitkazkrknstituka9) {
        zitkazkrknstituka9 = pZitkazkrknstituka9;
    }

    private BizCurrency yenkaknrgoukei9;

    public BizCurrency getYenkaknrgoukei9() {
        return yenkaknrgoukei9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei9(BizCurrency pYenkaknrgoukei9) {
        yenkaknrgoukei9 = pYenkaknrgoukei9;
    }

    private BizCurrency yenhknkngkguki9;

    public BizCurrency getYenhknkngkguki9() {
        return yenhknkngkguki9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki9(BizCurrency pYenhknkngkguki9) {
        yenhknkngkguki9 = pYenhknkngkguki9;
    }

    private BizCurrency yenhaitoukin9;

    public BizCurrency getYenhaitoukin9() {
        return yenhaitoukin9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin9(BizCurrency pYenhaitoukin9) {
        yenhaitoukin9 = pYenhaitoukin9;
    }

    private BizCurrency yensonotahaitoukin9;

    public BizCurrency getYensonotahaitoukin9() {
        return yensonotahaitoukin9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin9(BizCurrency pYensonotahaitoukin9) {
        yensonotahaitoukin9 = pYensonotahaitoukin9;
    }

    private BizCurrency yenmikeikap9;

    public BizCurrency getYenmikeikap9() {
        return yenmikeikap9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap9(BizCurrency pYenmikeikap9) {
        yenmikeikap9 = pYenmikeikap9;
    }

    private BizCurrency yenmisyuup9;

    public BizCurrency getYenmisyuup9() {
        return yenmisyuup9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup9(BizCurrency pYenmisyuup9) {
        yenmisyuup9 = pYenmisyuup9;
    }

    private BizCurrency yenznnusisnkgk9;

    public BizCurrency getYenznnusisnkgk9() {
        return yenznnusisnkgk9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk9(BizCurrency pYenznnusisnkgk9) {
        yenznnusisnkgk9 = pYenznnusisnkgk9;
    }

    private BizCurrency zitkazkrknyen9;

    public BizCurrency getZitkazkrknyen9() {
        return zitkazkrknyen9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen9(BizCurrency pZitkazkrknyen9) {
        zitkazkrknyen9 = pZitkazkrknyen9;
    }

    private BizCurrency yenkrkgk9;

    public BizCurrency getYenkrkgk9() {
        return yenkrkgk9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk9(BizCurrency pYenkrkgk9) {
        yenkrkgk9 = pYenkrkgk9;
    }

    private BizCurrency gaikaknrgoukei10;

    public BizCurrency getGaikaknrgoukei10() {
        return gaikaknrgoukei10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei10(BizCurrency pGaikaknrgoukei10) {
        gaikaknrgoukei10 = pGaikaknrgoukei10;
    }

    private BizCurrency hokenkngkgoukei10;

    public BizCurrency getHokenkngkgoukei10() {
        return hokenkngkgoukei10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei10(BizCurrency pHokenkngkgoukei10) {
        hokenkngkgoukei10 = pHokenkngkgoukei10;
    }

    private BizCurrency mikeikap10;

    public BizCurrency getMikeikap10() {
        return mikeikap10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap10(BizCurrency pMikeikap10) {
        mikeikap10 = pMikeikap10;
    }

    private BizCurrency misyuup10;

    public BizCurrency getMisyuup10() {
        return misyuup10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup10(BizCurrency pMisyuup10) {
        misyuup10 = pMisyuup10;
    }

    private BizCurrency znnusisnkgk10;

    public BizCurrency getZnnusisnkgk10() {
        return znnusisnkgk10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk10(BizCurrency pZnnusisnkgk10) {
        znnusisnkgk10 = pZnnusisnkgk10;
    }

    private BizCurrency zitkazkrknstituka10;

    public BizCurrency getZitkazkrknstituka10() {
        return zitkazkrknstituka10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka10(BizCurrency pZitkazkrknstituka10) {
        zitkazkrknstituka10 = pZitkazkrknstituka10;
    }

    private BizCurrency yenkaknrgoukei10;

    public BizCurrency getYenkaknrgoukei10() {
        return yenkaknrgoukei10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei10(BizCurrency pYenkaknrgoukei10) {
        yenkaknrgoukei10 = pYenkaknrgoukei10;
    }

    private BizCurrency yenhknkngkguki10;

    public BizCurrency getYenhknkngkguki10() {
        return yenhknkngkguki10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki10(BizCurrency pYenhknkngkguki10) {
        yenhknkngkguki10 = pYenhknkngkguki10;
    }

    private BizCurrency yenhaitoukin10;

    public BizCurrency getYenhaitoukin10() {
        return yenhaitoukin10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin10(BizCurrency pYenhaitoukin10) {
        yenhaitoukin10 = pYenhaitoukin10;
    }

    private BizCurrency yensonotahaitoukin10;

    public BizCurrency getYensonotahaitoukin10() {
        return yensonotahaitoukin10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin10(BizCurrency pYensonotahaitoukin10) {
        yensonotahaitoukin10 = pYensonotahaitoukin10;
    }

    private BizCurrency yenmikeikap10;

    public BizCurrency getYenmikeikap10() {
        return yenmikeikap10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap10(BizCurrency pYenmikeikap10) {
        yenmikeikap10 = pYenmikeikap10;
    }

    private BizCurrency yenmisyuup10;

    public BizCurrency getYenmisyuup10() {
        return yenmisyuup10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup10(BizCurrency pYenmisyuup10) {
        yenmisyuup10 = pYenmisyuup10;
    }

    private BizCurrency yenznnusisnkgk10;

    public BizCurrency getYenznnusisnkgk10() {
        return yenznnusisnkgk10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk10(BizCurrency pYenznnusisnkgk10) {
        yenznnusisnkgk10 = pYenznnusisnkgk10;
    }

    private BizCurrency zitkazkrknyen10;

    public BizCurrency getZitkazkrknyen10() {
        return zitkazkrknyen10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen10(BizCurrency pZitkazkrknyen10) {
        zitkazkrknyen10 = pZitkazkrknyen10;
    }

    private BizCurrency yenkrkgk10;

    public BizCurrency getYenkrkgk10() {
        return yenkrkgk10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk10(BizCurrency pYenkrkgk10) {
        yenkrkgk10 = pYenkrkgk10;
    }

    private BizCurrency gaikaknrgoukei11;

    public BizCurrency getGaikaknrgoukei11() {
        return gaikaknrgoukei11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei11(BizCurrency pGaikaknrgoukei11) {
        gaikaknrgoukei11 = pGaikaknrgoukei11;
    }

    private BizCurrency hokenkngkgoukei11;

    public BizCurrency getHokenkngkgoukei11() {
        return hokenkngkgoukei11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei11(BizCurrency pHokenkngkgoukei11) {
        hokenkngkgoukei11 = pHokenkngkgoukei11;
    }

    private BizCurrency mikeikap11;

    public BizCurrency getMikeikap11() {
        return mikeikap11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap11(BizCurrency pMikeikap11) {
        mikeikap11 = pMikeikap11;
    }

    private BizCurrency misyuup11;

    public BizCurrency getMisyuup11() {
        return misyuup11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup11(BizCurrency pMisyuup11) {
        misyuup11 = pMisyuup11;
    }

    private BizCurrency znnusisnkgk11;

    public BizCurrency getZnnusisnkgk11() {
        return znnusisnkgk11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk11(BizCurrency pZnnusisnkgk11) {
        znnusisnkgk11 = pZnnusisnkgk11;
    }

    private BizCurrency zitkazkrknstituka11;

    public BizCurrency getZitkazkrknstituka11() {
        return zitkazkrknstituka11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka11(BizCurrency pZitkazkrknstituka11) {
        zitkazkrknstituka11 = pZitkazkrknstituka11;
    }

    private BizCurrency yenkaknrgoukei11;

    public BizCurrency getYenkaknrgoukei11() {
        return yenkaknrgoukei11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei11(BizCurrency pYenkaknrgoukei11) {
        yenkaknrgoukei11 = pYenkaknrgoukei11;
    }

    private BizCurrency yenhknkngkguki11;

    public BizCurrency getYenhknkngkguki11() {
        return yenhknkngkguki11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki11(BizCurrency pYenhknkngkguki11) {
        yenhknkngkguki11 = pYenhknkngkguki11;
    }

    private BizCurrency yenhaitoukin11;

    public BizCurrency getYenhaitoukin11() {
        return yenhaitoukin11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin11(BizCurrency pYenhaitoukin11) {
        yenhaitoukin11 = pYenhaitoukin11;
    }

    private BizCurrency yensonotahaitoukin11;

    public BizCurrency getYensonotahaitoukin11() {
        return yensonotahaitoukin11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin11(BizCurrency pYensonotahaitoukin11) {
        yensonotahaitoukin11 = pYensonotahaitoukin11;
    }

    private BizCurrency yenmikeikap11;

    public BizCurrency getYenmikeikap11() {
        return yenmikeikap11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap11(BizCurrency pYenmikeikap11) {
        yenmikeikap11 = pYenmikeikap11;
    }

    private BizCurrency yenmisyuup11;

    public BizCurrency getYenmisyuup11() {
        return yenmisyuup11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup11(BizCurrency pYenmisyuup11) {
        yenmisyuup11 = pYenmisyuup11;
    }

    private BizCurrency yenznnusisnkgk11;

    public BizCurrency getYenznnusisnkgk11() {
        return yenznnusisnkgk11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk11(BizCurrency pYenznnusisnkgk11) {
        yenznnusisnkgk11 = pYenznnusisnkgk11;
    }

    private BizCurrency zitkazkrknyen11;

    public BizCurrency getZitkazkrknyen11() {
        return zitkazkrknyen11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen11(BizCurrency pZitkazkrknyen11) {
        zitkazkrknyen11 = pZitkazkrknyen11;
    }

    private BizCurrency yenkrkgk11;

    public BizCurrency getYenkrkgk11() {
        return yenkrkgk11;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk11(BizCurrency pYenkrkgk11) {
        yenkrkgk11 = pYenkrkgk11;
    }

    private BizCurrency gaikaknrgoukei12;

    public BizCurrency getGaikaknrgoukei12() {
        return gaikaknrgoukei12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei12(BizCurrency pGaikaknrgoukei12) {
        gaikaknrgoukei12 = pGaikaknrgoukei12;
    }

    private BizCurrency hokenkngkgoukei12;

    public BizCurrency getHokenkngkgoukei12() {
        return hokenkngkgoukei12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei12(BizCurrency pHokenkngkgoukei12) {
        hokenkngkgoukei12 = pHokenkngkgoukei12;
    }

    private BizCurrency mikeikap12;

    public BizCurrency getMikeikap12() {
        return mikeikap12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap12(BizCurrency pMikeikap12) {
        mikeikap12 = pMikeikap12;
    }

    private BizCurrency misyuup12;

    public BizCurrency getMisyuup12() {
        return misyuup12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup12(BizCurrency pMisyuup12) {
        misyuup12 = pMisyuup12;
    }

    private BizCurrency znnusisnkgk12;

    public BizCurrency getZnnusisnkgk12() {
        return znnusisnkgk12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk12(BizCurrency pZnnusisnkgk12) {
        znnusisnkgk12 = pZnnusisnkgk12;
    }

    private BizCurrency zitkazkrknstituka12;

    public BizCurrency getZitkazkrknstituka12() {
        return zitkazkrknstituka12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka12(BizCurrency pZitkazkrknstituka12) {
        zitkazkrknstituka12 = pZitkazkrknstituka12;
    }

    private BizCurrency yenkaknrgoukei12;

    public BizCurrency getYenkaknrgoukei12() {
        return yenkaknrgoukei12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei12(BizCurrency pYenkaknrgoukei12) {
        yenkaknrgoukei12 = pYenkaknrgoukei12;
    }

    private BizCurrency yenhknkngkguki12;

    public BizCurrency getYenhknkngkguki12() {
        return yenhknkngkguki12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki12(BizCurrency pYenhknkngkguki12) {
        yenhknkngkguki12 = pYenhknkngkguki12;
    }

    private BizCurrency yenhaitoukin12;

    public BizCurrency getYenhaitoukin12() {
        return yenhaitoukin12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin12(BizCurrency pYenhaitoukin12) {
        yenhaitoukin12 = pYenhaitoukin12;
    }

    private BizCurrency yensonotahaitoukin12;

    public BizCurrency getYensonotahaitoukin12() {
        return yensonotahaitoukin12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin12(BizCurrency pYensonotahaitoukin12) {
        yensonotahaitoukin12 = pYensonotahaitoukin12;
    }

    private BizCurrency yenmikeikap12;

    public BizCurrency getYenmikeikap12() {
        return yenmikeikap12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap12(BizCurrency pYenmikeikap12) {
        yenmikeikap12 = pYenmikeikap12;
    }

    private BizCurrency yenmisyuup12;

    public BizCurrency getYenmisyuup12() {
        return yenmisyuup12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup12(BizCurrency pYenmisyuup12) {
        yenmisyuup12 = pYenmisyuup12;
    }

    private BizCurrency yenznnusisnkgk12;

    public BizCurrency getYenznnusisnkgk12() {
        return yenznnusisnkgk12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk12(BizCurrency pYenznnusisnkgk12) {
        yenznnusisnkgk12 = pYenznnusisnkgk12;
    }

    private BizCurrency zitkazkrknyen12;

    public BizCurrency getZitkazkrknyen12() {
        return zitkazkrknyen12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen12(BizCurrency pZitkazkrknyen12) {
        zitkazkrknyen12 = pZitkazkrknyen12;
    }

    private BizCurrency yenkrkgk12;

    public BizCurrency getYenkrkgk12() {
        return yenkrkgk12;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk12(BizCurrency pYenkrkgk12) {
        yenkrkgk12 = pYenkrkgk12;
    }

    private BizCurrency gaikaknrgoukei13;

    public BizCurrency getGaikaknrgoukei13() {
        return gaikaknrgoukei13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei13(BizCurrency pGaikaknrgoukei13) {
        gaikaknrgoukei13 = pGaikaknrgoukei13;
    }

    private BizCurrency hokenkngkgoukei13;

    public BizCurrency getHokenkngkgoukei13() {
        return hokenkngkgoukei13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei13(BizCurrency pHokenkngkgoukei13) {
        hokenkngkgoukei13 = pHokenkngkgoukei13;
    }

    private BizCurrency mikeikap13;

    public BizCurrency getMikeikap13() {
        return mikeikap13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap13(BizCurrency pMikeikap13) {
        mikeikap13 = pMikeikap13;
    }

    private BizCurrency misyuup13;

    public BizCurrency getMisyuup13() {
        return misyuup13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup13(BizCurrency pMisyuup13) {
        misyuup13 = pMisyuup13;
    }

    private BizCurrency znnusisnkgk13;

    public BizCurrency getZnnusisnkgk13() {
        return znnusisnkgk13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk13(BizCurrency pZnnusisnkgk13) {
        znnusisnkgk13 = pZnnusisnkgk13;
    }

    private BizCurrency zitkazkrknstituka13;

    public BizCurrency getZitkazkrknstituka13() {
        return zitkazkrknstituka13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka13(BizCurrency pZitkazkrknstituka13) {
        zitkazkrknstituka13 = pZitkazkrknstituka13;
    }

    private BizCurrency yenkaknrgoukei13;

    public BizCurrency getYenkaknrgoukei13() {
        return yenkaknrgoukei13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei13(BizCurrency pYenkaknrgoukei13) {
        yenkaknrgoukei13 = pYenkaknrgoukei13;
    }

    private BizCurrency yenhknkngkguki13;

    public BizCurrency getYenhknkngkguki13() {
        return yenhknkngkguki13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki13(BizCurrency pYenhknkngkguki13) {
        yenhknkngkguki13 = pYenhknkngkguki13;
    }

    private BizCurrency yenhaitoukin13;

    public BizCurrency getYenhaitoukin13() {
        return yenhaitoukin13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin13(BizCurrency pYenhaitoukin13) {
        yenhaitoukin13 = pYenhaitoukin13;
    }

    private BizCurrency yensonotahaitoukin13;

    public BizCurrency getYensonotahaitoukin13() {
        return yensonotahaitoukin13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin13(BizCurrency pYensonotahaitoukin13) {
        yensonotahaitoukin13 = pYensonotahaitoukin13;
    }

    private BizCurrency yenmikeikap13;

    public BizCurrency getYenmikeikap13() {
        return yenmikeikap13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap13(BizCurrency pYenmikeikap13) {
        yenmikeikap13 = pYenmikeikap13;
    }

    private BizCurrency yenmisyuup13;

    public BizCurrency getYenmisyuup13() {
        return yenmisyuup13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup13(BizCurrency pYenmisyuup13) {
        yenmisyuup13 = pYenmisyuup13;
    }

    private BizCurrency yenznnusisnkgk13;

    public BizCurrency getYenznnusisnkgk13() {
        return yenznnusisnkgk13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk13(BizCurrency pYenznnusisnkgk13) {
        yenznnusisnkgk13 = pYenznnusisnkgk13;
    }

    private BizCurrency zitkazkrknyen13;

    public BizCurrency getZitkazkrknyen13() {
        return zitkazkrknyen13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen13(BizCurrency pZitkazkrknyen13) {
        zitkazkrknyen13 = pZitkazkrknyen13;
    }

    private BizCurrency yenkrkgk13;

    public BizCurrency getYenkrkgk13() {
        return yenkrkgk13;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk13(BizCurrency pYenkrkgk13) {
        yenkrkgk13 = pYenkrkgk13;
    }

    private BizCurrency gaikaknrgoukei14;

    public BizCurrency getGaikaknrgoukei14() {
        return gaikaknrgoukei14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei14(BizCurrency pGaikaknrgoukei14) {
        gaikaknrgoukei14 = pGaikaknrgoukei14;
    }

    private BizCurrency hokenkngkgoukei14;

    public BizCurrency getHokenkngkgoukei14() {
        return hokenkngkgoukei14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei14(BizCurrency pHokenkngkgoukei14) {
        hokenkngkgoukei14 = pHokenkngkgoukei14;
    }

    private BizCurrency mikeikap14;

    public BizCurrency getMikeikap14() {
        return mikeikap14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap14(BizCurrency pMikeikap14) {
        mikeikap14 = pMikeikap14;
    }

    private BizCurrency misyuup14;

    public BizCurrency getMisyuup14() {
        return misyuup14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup14(BizCurrency pMisyuup14) {
        misyuup14 = pMisyuup14;
    }

    private BizCurrency znnusisnkgk14;

    public BizCurrency getZnnusisnkgk14() {
        return znnusisnkgk14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk14(BizCurrency pZnnusisnkgk14) {
        znnusisnkgk14 = pZnnusisnkgk14;
    }

    private BizCurrency zitkazkrknstituka14;

    public BizCurrency getZitkazkrknstituka14() {
        return zitkazkrknstituka14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka14(BizCurrency pZitkazkrknstituka14) {
        zitkazkrknstituka14 = pZitkazkrknstituka14;
    }

    private BizCurrency yenkaknrgoukei14;

    public BizCurrency getYenkaknrgoukei14() {
        return yenkaknrgoukei14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei14(BizCurrency pYenkaknrgoukei14) {
        yenkaknrgoukei14 = pYenkaknrgoukei14;
    }

    private BizCurrency yenhknkngkguki14;

    public BizCurrency getYenhknkngkguki14() {
        return yenhknkngkguki14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki14(BizCurrency pYenhknkngkguki14) {
        yenhknkngkguki14 = pYenhknkngkguki14;
    }

    private BizCurrency yenhaitoukin14;

    public BizCurrency getYenhaitoukin14() {
        return yenhaitoukin14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin14(BizCurrency pYenhaitoukin14) {
        yenhaitoukin14 = pYenhaitoukin14;
    }

    private BizCurrency yensonotahaitoukin14;

    public BizCurrency getYensonotahaitoukin14() {
        return yensonotahaitoukin14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin14(BizCurrency pYensonotahaitoukin14) {
        yensonotahaitoukin14 = pYensonotahaitoukin14;
    }

    private BizCurrency yenmikeikap14;

    public BizCurrency getYenmikeikap14() {
        return yenmikeikap14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap14(BizCurrency pYenmikeikap14) {
        yenmikeikap14 = pYenmikeikap14;
    }

    private BizCurrency yenmisyuup14;

    public BizCurrency getYenmisyuup14() {
        return yenmisyuup14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup14(BizCurrency pYenmisyuup14) {
        yenmisyuup14 = pYenmisyuup14;
    }

    private BizCurrency yenznnusisnkgk14;

    public BizCurrency getYenznnusisnkgk14() {
        return yenznnusisnkgk14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk14(BizCurrency pYenznnusisnkgk14) {
        yenznnusisnkgk14 = pYenznnusisnkgk14;
    }

    private BizCurrency zitkazkrknyen14;

    public BizCurrency getZitkazkrknyen14() {
        return zitkazkrknyen14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen14(BizCurrency pZitkazkrknyen14) {
        zitkazkrknyen14 = pZitkazkrknyen14;
    }

    private BizCurrency yenkrkgk14;

    public BizCurrency getYenkrkgk14() {
        return yenkrkgk14;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk14(BizCurrency pYenkrkgk14) {
        yenkrkgk14 = pYenkrkgk14;
    }

    private BizCurrency gaikaknrgoukei15;

    public BizCurrency getGaikaknrgoukei15() {
        return gaikaknrgoukei15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknrgoukei15(BizCurrency pGaikaknrgoukei15) {
        gaikaknrgoukei15 = pGaikaknrgoukei15;
    }

    private BizCurrency hokenkngkgoukei15;

    public BizCurrency getHokenkngkgoukei15() {
        return hokenkngkgoukei15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngkgoukei15(BizCurrency pHokenkngkgoukei15) {
        hokenkngkgoukei15 = pHokenkngkgoukei15;
    }

    private BizCurrency mikeikap15;

    public BizCurrency getMikeikap15() {
        return mikeikap15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMikeikap15(BizCurrency pMikeikap15) {
        mikeikap15 = pMikeikap15;
    }

    private BizCurrency misyuup15;

    public BizCurrency getMisyuup15() {
        return misyuup15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuup15(BizCurrency pMisyuup15) {
        misyuup15 = pMisyuup15;
    }

    private BizCurrency znnusisnkgk15;

    public BizCurrency getZnnusisnkgk15() {
        return znnusisnkgk15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnusisnkgk15(BizCurrency pZnnusisnkgk15) {
        znnusisnkgk15 = pZnnusisnkgk15;
    }

    private BizCurrency zitkazkrknstituka15;

    public BizCurrency getZitkazkrknstituka15() {
        return zitkazkrknstituka15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknstituka15(BizCurrency pZitkazkrknstituka15) {
        zitkazkrknstituka15 = pZitkazkrknstituka15;
    }

    private BizCurrency yenkaknrgoukei15;

    public BizCurrency getYenkaknrgoukei15() {
        return yenkaknrgoukei15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknrgoukei15(BizCurrency pYenkaknrgoukei15) {
        yenkaknrgoukei15 = pYenkaknrgoukei15;
    }

    private BizCurrency yenhknkngkguki15;

    public BizCurrency getYenhknkngkguki15() {
        return yenhknkngkguki15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhknkngkguki15(BizCurrency pYenhknkngkguki15) {
        yenhknkngkguki15 = pYenhknkngkguki15;
    }

    private BizCurrency yenhaitoukin15;

    public BizCurrency getYenhaitoukin15() {
        return yenhaitoukin15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhaitoukin15(BizCurrency pYenhaitoukin15) {
        yenhaitoukin15 = pYenhaitoukin15;
    }

    private BizCurrency yensonotahaitoukin15;

    public BizCurrency getYensonotahaitoukin15() {
        return yensonotahaitoukin15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensonotahaitoukin15(BizCurrency pYensonotahaitoukin15) {
        yensonotahaitoukin15 = pYensonotahaitoukin15;
    }

    private BizCurrency yenmikeikap15;

    public BizCurrency getYenmikeikap15() {
        return yenmikeikap15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap15(BizCurrency pYenmikeikap15) {
        yenmikeikap15 = pYenmikeikap15;
    }

    private BizCurrency yenmisyuup15;

    public BizCurrency getYenmisyuup15() {
        return yenmisyuup15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmisyuup15(BizCurrency pYenmisyuup15) {
        yenmisyuup15 = pYenmisyuup15;
    }

    private BizCurrency yenznnusisnkgk15;

    public BizCurrency getYenznnusisnkgk15() {
        return yenznnusisnkgk15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenznnusisnkgk15(BizCurrency pYenznnusisnkgk15) {
        yenznnusisnkgk15 = pYenznnusisnkgk15;
    }

    private BizCurrency zitkazkrknyen15;

    public BizCurrency getZitkazkrknyen15() {
        return zitkazkrknyen15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZitkazkrknyen15(BizCurrency pZitkazkrknyen15) {
        zitkazkrknyen15 = pZitkazkrknyen15;
    }

    private BizCurrency yenkrkgk15;

    public BizCurrency getYenkrkgk15() {
        return yenkrkgk15;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkrkgk15(BizCurrency pYenkrkgk15) {
        yenkrkgk15 = pYenkrkgk15;
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

    private C_SiharaiTuukaKbn siharaituukakbn;

    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    @ValidDate
    private BizDate shrymd;

    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate shrkwsratekjnymd;

    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate gaikaknsnkwsratekjymd;

    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    private BizNumber gaikaknsnkwsrate;

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    private BizCurrency bnktgogaikagoukei;

    public BizCurrency getBnktgogaikagoukei() {
        return bnktgogaikagoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgogaikagoukei(BizCurrency pBnktgogaikagoukei) {
        bnktgogaikagoukei = pBnktgogaikagoukei;
    }

    private BizCurrency bnktgogaikaknsntkgk;

    public BizCurrency getBnktgogaikaknsntkgk() {
        return bnktgogaikaknsntkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgogaikaknsntkgk(BizCurrency pBnktgogaikaknsntkgk) {
        bnktgogaikaknsntkgk = pBnktgogaikaknsntkgk;
    }

    private BizCurrency bnktgohokenkngkgoukei;

    public BizCurrency getBnktgohokenkngkgoukei() {
        return bnktgohokenkngkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgohokenkngkgoukei(BizCurrency pBnktgohokenkngkgoukei) {
        bnktgohokenkngkgoukei = pBnktgohokenkngkgoukei;
    }

    private BizCurrency bnktgomikeikap;

    public BizCurrency getBnktgomikeikap() {
        return bnktgomikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgomikeikap(BizCurrency pBnktgomikeikap) {
        bnktgomikeikap = pBnktgomikeikap;
    }

    private BizCurrency bnktgomisyuup;

    public BizCurrency getBnktgomisyuup() {
        return bnktgomisyuup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgomisyuup(BizCurrency pBnktgomisyuup) {
        bnktgomisyuup = pBnktgomisyuup;
    }

    private BizCurrency bnktgoznnusisnkgk;

    public BizCurrency getBnktgoznnusisnkgk() {
        return bnktgoznnusisnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoznnusisnkgk(BizCurrency pBnktgoznnusisnkgk) {
        bnktgoznnusisnkgk = pBnktgoznnusisnkgk;
    }

    private BizCurrency bnktgozitkazkrknstituka;

    public BizCurrency getBnktgozitkazkrknstituka() {
        return bnktgozitkazkrknstituka;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgozitkazkrknstituka(BizCurrency pBnktgozitkazkrknstituka) {
        bnktgozitkazkrknstituka = pBnktgozitkazkrknstituka;
    }

    @ValidDate
    private BizDate tienrisokukisanymd;

    public BizDate getTienrisokukisanymd() {
        return tienrisokukisanymd;
    }

    @Trim("both")
    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd) {
        tienrisokukisanymd = pTienrisokukisanymd;
    }

    @Range(min="0", max="99999")
    @NaturalNumber
    private Integer tienrsknissuu;

    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    private BizCurrency shrtienrsk;

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    private BizCurrency bnktgoyengoukei;

    public BizCurrency getBnktgoyengoukei() {
        return bnktgoyengoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyengoukei(BizCurrency pBnktgoyengoukei) {
        bnktgoyengoukei = pBnktgoyengoukei;
    }

    private BizCurrency bnktgoyenkaknsntkgk;

    public BizCurrency getBnktgoyenkaknsntkgk() {
        return bnktgoyenkaknsntkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenkaknsntkgk(BizCurrency pBnktgoyenkaknsntkgk) {
        bnktgoyenkaknsntkgk = pBnktgoyenkaknsntkgk;
    }

    private BizCurrency bnktgoyenhknkngkguki;

    public BizCurrency getBnktgoyenhknkngkguki() {
        return bnktgoyenhknkngkguki;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenhknkngkguki(BizCurrency pBnktgoyenhknkngkguki) {
        bnktgoyenhknkngkguki = pBnktgoyenhknkngkguki;
    }

    private BizCurrency bnktgoyenhaitoukin;

    public BizCurrency getBnktgoyenhaitoukin() {
        return bnktgoyenhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenhaitoukin(BizCurrency pBnktgoyenhaitoukin) {
        bnktgoyenhaitoukin = pBnktgoyenhaitoukin;
    }

    private BizCurrency bnktgoyensonotahaitoukin;

    public BizCurrency getBnktgoyensonotahaitoukin() {
        return bnktgoyensonotahaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyensonotahaitoukin(BizCurrency pBnktgoyensonotahaitoukin) {
        bnktgoyensonotahaitoukin = pBnktgoyensonotahaitoukin;
    }

    private BizCurrency bnktgoyenmikeikap;

    public BizCurrency getBnktgoyenmikeikap() {
        return bnktgoyenmikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenmikeikap(BizCurrency pBnktgoyenmikeikap) {
        bnktgoyenmikeikap = pBnktgoyenmikeikap;
    }

    private BizCurrency bnktgoyenmisyuup;

    public BizCurrency getBnktgoyenmisyuup() {
        return bnktgoyenmisyuup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenmisyuup(BizCurrency pBnktgoyenmisyuup) {
        bnktgoyenmisyuup = pBnktgoyenmisyuup;
    }

    private BizCurrency bnktgoyenznnusisnkgk;

    public BizCurrency getBnktgoyenznnusisnkgk() {
        return bnktgoyenznnusisnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenznnusisnkgk(BizCurrency pBnktgoyenznnusisnkgk) {
        bnktgoyenznnusisnkgk = pBnktgoyenznnusisnkgk;
    }

    private BizCurrency bnktgozitkazkrknyen;

    public BizCurrency getBnktgozitkazkrknyen() {
        return bnktgozitkazkrknyen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgozitkazkrknyen(BizCurrency pBnktgozitkazkrknyen) {
        bnktgozitkazkrknyen = pBnktgozitkazkrknyen;
    }

    private BizCurrency bnktgoyenkrkgk;

    public BizCurrency getBnktgoyenkrkgk() {
        return bnktgoyenkrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktgoyenkrkgk(BizCurrency pBnktgoyenkrkgk) {
        bnktgoyenkrkgk = pBnktgoyenkrkgk;
    }

    @ValidDate
    private BizDate yentienrisokukisanymd;

    public BizDate getYentienrisokukisanymd() {
        return yentienrisokukisanymd;
    }

    @Trim("both")
    public void setYentienrisokukisanymd(BizDate pYentienrisokukisanymd) {
        yentienrisokukisanymd = pYentienrisokukisanymd;
    }

    @Range(min="0", max="99999")
    @NaturalNumber
    private Integer yentienrsknissuu;

    public Integer getYentienrsknissuu() {
        return yentienrsknissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYentienrsknissuu(Integer pYentienrsknissuu) {
        yentienrsknissuu = pYentienrsknissuu;
    }

    private BizCurrency yenshrtienrsk;

    public BizCurrency getYenshrtienrsk() {
        return yenshrtienrsk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk) {
        yenshrtienrsk = pYenshrtienrsk;
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

    private LoopChain<UserDefsList> sbuktninmojiOptionBeanList = new LoopChain<>();
    public UserDefsList getSbuktninmojiOptionBeanList() {
        return sbuktninmojiOptionBeanList.get();
    }

    public void setSbuktninmojiOptionBeanList(UserDefsList pSbuktninmojiOptionBeanList) {
        clearSbuktninmojiOptionBeanList();
        sbuktninmojiOptionBeanList.add(pSbuktninmojiOptionBeanList);
    }

    public void clearSbuktninmojiOptionBeanList() {
        sbuktninmojiOptionBeanList.clear();
    }
}
