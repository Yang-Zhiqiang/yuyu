package yuyu.app.hozen.khozen.khdairiteninfosyuusei;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DairitenInfoSyoriKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Modulus10w21;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 代理店情報修正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhDairitenInfoSyuuseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    @SyoukenNo
    private String vkihnsyono;

    public String getVkihnsyono() {
        return vkihnsyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVkihnsyono(String pVkihnsyono) {
        vkihnsyono = pVkihnsyono;
    }

    private C_DairitenInfoSyoriKbn drteninfosyuuseitaisyou;

    public C_DairitenInfoSyoriKbn getDrteninfosyuuseitaisyou() {
        return drteninfosyuuseitaisyou;
    }

    public void setDrteninfosyuuseitaisyou(C_DairitenInfoSyoriKbn pDrteninfosyuuseitaisyou) {
        drteninfosyuuseitaisyou = pDrteninfosyuuseitaisyou;
    }

    private C_YuukousyoumetuKbn vkihnyuukousyoumetukbn;

    public C_YuukousyoumetuKbn getVkihnyuukousyoumetukbn() {
        return vkihnyuukousyoumetukbn;
    }

    public void setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn pVkihnyuukousyoumetukbn) {
        vkihnyuukousyoumetukbn = pVkihnyuukousyoumetukbn;
    }

    private C_Kykjyoutai vkihnkykjyoutai;

    public C_Kykjyoutai getVkihnkykjyoutai() {
        return vkihnkykjyoutai;
    }

    public void setVkihnkykjyoutai(C_Kykjyoutai pVkihnkykjyoutai) {
        vkihnkykjyoutai = pVkihnkykjyoutai;
    }

    private C_Syoumetujiyuu vkihnsyoumetujiyuu;

    public C_Syoumetujiyuu getVkihnsyoumetujiyuu() {
        return vkihnsyoumetujiyuu;
    }

    public void setVkihnsyoumetujiyuu(C_Syoumetujiyuu pVkihnsyoumetujiyuu) {
        vkihnsyoumetujiyuu = pVkihnsyoumetujiyuu;
    }

    private BizDate vkihnsyoumetuymd;

    public BizDate getVkihnsyoumetuymd() {
        return vkihnsyoumetuymd;
    }

    @Trim("both")
    public void setVkihnsyoumetuymd(BizDate pVkihnsyoumetuymd) {
        vkihnsyoumetuymd = pVkihnsyoumetuymd;
    }

    private BizDate vkihnlastsyosaihkymd;

    public BizDate getVkihnlastsyosaihkymd() {
        return vkihnlastsyosaihkymd;
    }

    @Trim("both")
    public void setVkihnlastsyosaihkymd(BizDate pVkihnlastsyosaihkymd) {
        vkihnlastsyosaihkymd = pVkihnlastsyosaihkymd;
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

    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }

    private String dispoyadrtencd1;

    public String getDispoyadrtencd1() {
        return dispoyadrtencd1;
    }

    public void setDispoyadrtencd1(String pDispoyadrtencd1) {
        dispoyadrtencd1 = pDispoyadrtencd1;
    }

    private String dispoyadrtennm1;

    public String getDispoyadrtennm1() {
        return dispoyadrtennm1;
    }

    public void setDispoyadrtennm1(String pDispoyadrtennm1) {
        dispoyadrtennm1 = pDispoyadrtennm1;
    }

    @HostInvalidCharacter
    private String cifcd1;

    public String getCifcd1() {
        return cifcd1;
    }

    public void setCifcd1(String pCifcd1) {
        cifcd1 = pCifcd1;
    }

    @HostInvalidCharacter
    private String uktkid1;

    public String getUktkid1() {
        return uktkid1;
    }

    public void setUktkid1(String pUktkid1) {
        uktkid1 = pUktkid1;
    }

    @Length(length=4)
    @SingleByteStrings
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd1;

    public String getDrtenjimcd1() {
        return drtenjimcd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd1(String pDrtenjimcd1) {
        drtenjimcd1 = pDrtenjimcd1;
    }

    @MaxLength(max=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno1;

    public String getBosyuunintourokuno1() {
        return bosyuunintourokuno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno1(String pBosyuunintourokuno1) {
        bosyuunintourokuno1 = pBosyuunintourokuno1;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd1;

    public String getDairitenkinyuukikancd1() {
        return dairitenkinyuukikancd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd1(String pDairitenkinyuukikancd1) {
        dairitenkinyuukikancd1 = pDairitenkinyuukikancd1;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd1;

    public String getDairitenkinyuukikansitencd1() {
        return dairitenkinyuukikansitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd1(String pDairitenkinyuukikansitencd1) {
        dairitenkinyuukikansitencd1 = pDairitenkinyuukikansitencd1;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd1;

    public String getDairitentoriatukaikouincd1() {
        return dairitentoriatukaikouincd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd1(String pDairitentoriatukaikouincd1) {
        dairitentoriatukaikouincd1 = pDairitentoriatukaikouincd1;
    }

    @MaxLength(max=10)
    @AlphaDigit
    private String toriatukaidairitencd1;

    public String getToriatukaidairitencd1() {
        return toriatukaidairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setToriatukaidairitencd1(String pToriatukaidairitencd1) {
        toriatukaidairitencd1 = pToriatukaidairitencd1;
    }

    private String kanjitoriatukaidairitennm1;

    public String getKanjitoriatukaidairitennm1() {
        return kanjitoriatukaidairitennm1;
    }

    public void setKanjitoriatukaidairitennm1(String pKanjitoriatukaidairitennm1) {
        kanjitoriatukaidairitennm1 = pKanjitoriatukaidairitennm1;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String oyadairitencd1;

    public String getOyadairitencd1() {
        return oyadairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd1(String pOyadairitencd1) {
        oyadairitencd1 = pOyadairitencd1;
    }

    private String kanjioyadrtennm1;

    public String getKanjioyadrtennm1() {
        return kanjioyadrtennm1;
    }

    public void setKanjioyadrtennm1(String pKanjioyadrtennm1) {
        kanjioyadrtennm1 = pKanjioyadrtennm1;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuucd1;

    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm1;

    public String getBosyuuninnm1() {
        return bosyuuninnm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm1(String pBosyuuninnm1) {
        bosyuuninnm1 = pBosyuuninnm1;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd1;

    public String getGyskkjsakisosikicd1() {
        return gyskkjsakisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd1(String pGyskkjsakisosikicd1) {
        gyskkjsakisosikicd1 = pGyskkjsakisosikicd1;
    }

    private String gyskkjsakisosikinmkj1;

    public String getGyskkjsakisosikinmkj1() {
        return gyskkjsakisosikinmkj1;
    }

    public void setGyskkjsakisosikinmkj1(String pGyskkjsakisosikinmkj1) {
        gyskkjsakisosikinmkj1 = pGyskkjsakisosikinmkj1;
    }

    private BizNumber bunwari1;

    public BizNumber getBunwari1() {
        return bunwari1;
    }

    public void setBunwari1(BizNumber pBunwari1) {
        bunwari1 = pBunwari1;
    }

    @Length(length=4)
    @SingleByteStrings
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd2;

    public String getDrtenjimcd2() {
        return drtenjimcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd2(String pDrtenjimcd2) {
        drtenjimcd2 = pDrtenjimcd2;
    }

    @MaxLength(max=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno2;

    public String getBosyuunintourokuno2() {
        return bosyuunintourokuno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno2(String pBosyuunintourokuno2) {
        bosyuunintourokuno2 = pBosyuunintourokuno2;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd2;

    public String getDairitenkinyuukikancd2() {
        return dairitenkinyuukikancd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd2(String pDairitenkinyuukikancd2) {
        dairitenkinyuukikancd2 = pDairitenkinyuukikancd2;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd2;

    public String getDairitenkinyuukikansitencd2() {
        return dairitenkinyuukikansitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd2(String pDairitenkinyuukikansitencd2) {
        dairitenkinyuukikansitencd2 = pDairitenkinyuukikansitencd2;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd2;

    public String getDairitentoriatukaikouincd2() {
        return dairitentoriatukaikouincd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd2(String pDairitentoriatukaikouincd2) {
        dairitentoriatukaikouincd2 = pDairitentoriatukaikouincd2;
    }

    @MaxLength(max=10)
    @AlphaDigit
    private String toriatukaidairitencd2;

    public String getToriatukaidairitencd2() {
        return toriatukaidairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setToriatukaidairitencd2(String pToriatukaidairitencd2) {
        toriatukaidairitencd2 = pToriatukaidairitencd2;
    }

    private String kanjitoriatukaidairitennm2;

    public String getKanjitoriatukaidairitennm2() {
        return kanjitoriatukaidairitennm2;
    }

    public void setKanjitoriatukaidairitennm2(String pKanjitoriatukaidairitennm2) {
        kanjitoriatukaidairitennm2 = pKanjitoriatukaidairitennm2;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String oyadairitencd2;

    public String getOyadairitencd2() {
        return oyadairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd2(String pOyadairitencd2) {
        oyadairitencd2 = pOyadairitencd2;
    }

    private String kanjioyadrtennm2;

    public String getKanjioyadrtennm2() {
        return kanjioyadrtennm2;
    }

    public void setKanjioyadrtennm2(String pKanjioyadrtennm2) {
        kanjioyadrtennm2 = pKanjioyadrtennm2;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuucd2;

    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm2;

    public String getBosyuuninnm2() {
        return bosyuuninnm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm2(String pBosyuuninnm2) {
        bosyuuninnm2 = pBosyuuninnm2;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd2;

    public String getGyskkjsakisosikicd2() {
        return gyskkjsakisosikicd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd2(String pGyskkjsakisosikicd2) {
        gyskkjsakisosikicd2 = pGyskkjsakisosikicd2;
    }

    private String gyskkjsakisosikinmkj2;

    public String getGyskkjsakisosikinmkj2() {
        return gyskkjsakisosikinmkj2;
    }

    public void setGyskkjsakisosikinmkj2(String pGyskkjsakisosikinmkj2) {
        gyskkjsakisosikinmkj2 = pGyskkjsakisosikinmkj2;
    }

    private BizNumber bunwari2;

    public BizNumber getBunwari2() {
        return bunwari2;
    }

    public void setBunwari2(BizNumber pBunwari2) {
        bunwari2 = pBunwari2;
    }

    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    private String cifcd2;

    public String getCifcd2() {
        return cifcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd2(String pCifcd2) {
        cifcd2 = pCifcd2;
    }

    @Length(length=11)
    @AlphaDigit
    @HostInvalidCharacter
    private String uktkid2;

    public String getUktkid2() {
        return uktkid2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktkid2(String pUktkid2) {
        uktkid2 = pUktkid2;
    }

    @Length(length=4)
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd3;

    public String getDrtenjimcd3() {
        return drtenjimcd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd3(String pDrtenjimcd3) {
        drtenjimcd3 = pDrtenjimcd3;
    }

    @Length(length=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno3;

    public String getBosyuunintourokuno3() {
        return bosyuunintourokuno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno3(String pBosyuunintourokuno3) {
        bosyuunintourokuno3 = pBosyuunintourokuno3;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd3;

    public String getDairitenkinyuukikancd3() {
        return dairitenkinyuukikancd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd3(String pDairitenkinyuukikancd3) {
        dairitenkinyuukikancd3 = pDairitenkinyuukikancd3;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd3;

    public String getDairitenkinyuukikansitencd3() {
        return dairitenkinyuukikansitencd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd3(String pDairitenkinyuukikansitencd3) {
        dairitenkinyuukikansitencd3 = pDairitenkinyuukikansitencd3;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd3;

    public String getDairitentoriatukaikouincd3() {
        return dairitentoriatukaikouincd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd3(String pDairitentoriatukaikouincd3) {
        dairitentoriatukaikouincd3 = pDairitentoriatukaikouincd3;
    }

    private String toriatukaidairitencd3;

    public String getToriatukaidairitencd3() {
        return toriatukaidairitencd3;
    }

    public void setToriatukaidairitencd3(String pToriatukaidairitencd3) {
        toriatukaidairitencd3 = pToriatukaidairitencd3;
    }

    private String kanjitoriatukaidairitennm3;

    public String getKanjitoriatukaidairitennm3() {
        return kanjitoriatukaidairitennm3;
    }

    public void setKanjitoriatukaidairitennm3(String pKanjitoriatukaidairitennm3) {
        kanjitoriatukaidairitennm3 = pKanjitoriatukaidairitennm3;
    }

    private String oyadairitencd3;

    public String getOyadairitencd3() {
        return oyadairitencd3;
    }

    public void setOyadairitencd3(String pOyadairitencd3) {
        oyadairitencd3 = pOyadairitencd3;
    }

    private String kanjioyadrtennm3;

    public String getKanjioyadrtennm3() {
        return kanjioyadrtennm3;
    }

    public void setKanjioyadrtennm3(String pKanjioyadrtennm3) {
        kanjioyadrtennm3 = pKanjioyadrtennm3;
    }

    @Length(length=7)
    @Digit
    @Modulus10w21
    @HostInvalidCharacter
    private String bosyuucd3;

    public String getBosyuucd3() {
        return bosyuucd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd3(String pBosyuucd3) {
        bosyuucd3 = pBosyuucd3;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm3;

    public String getBosyuuninnm3() {
        return bosyuuninnm3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm3(String pBosyuuninnm3) {
        bosyuuninnm3 = pBosyuuninnm3;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd3;

    public String getGyskkjsakisosikicd3() {
        return gyskkjsakisosikicd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd3(String pGyskkjsakisosikicd3) {
        gyskkjsakisosikicd3 = pGyskkjsakisosikicd3;
    }

    private String gyskkjsakisosikinmkj3;

    public String getGyskkjsakisosikinmkj3() {
        return gyskkjsakisosikinmkj3;
    }

    public void setGyskkjsakisosikinmkj3(String pGyskkjsakisosikinmkj3) {
        gyskkjsakisosikinmkj3 = pGyskkjsakisosikinmkj3;
    }

    @NaturalNumberBizCalcable
    @RangeBizCalcable(min="1", max="100")
    private BizNumber bunwari3;

    public BizNumber getBunwari3() {
        return bunwari3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBunwari3(BizNumber pBunwari3) {
        bunwari3 = pBunwari3;
    }

    @Length(length=4)
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd4;

    public String getDrtenjimcd4() {
        return drtenjimcd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd4(String pDrtenjimcd4) {
        drtenjimcd4 = pDrtenjimcd4;
    }

    @Length(length=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno4;

    public String getBosyuunintourokuno4() {
        return bosyuunintourokuno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno4(String pBosyuunintourokuno4) {
        bosyuunintourokuno4 = pBosyuunintourokuno4;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd4;

    public String getDairitenkinyuukikancd4() {
        return dairitenkinyuukikancd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd4(String pDairitenkinyuukikancd4) {
        dairitenkinyuukikancd4 = pDairitenkinyuukikancd4;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd4;

    public String getDairitenkinyuukikansitencd4() {
        return dairitenkinyuukikansitencd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd4(String pDairitenkinyuukikansitencd4) {
        dairitenkinyuukikansitencd4 = pDairitenkinyuukikansitencd4;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd4;

    public String getDairitentoriatukaikouincd4() {
        return dairitentoriatukaikouincd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd4(String pDairitentoriatukaikouincd4) {
        dairitentoriatukaikouincd4 = pDairitentoriatukaikouincd4;
    }

    private String toriatukaidairitencd4;

    public String getToriatukaidairitencd4() {
        return toriatukaidairitencd4;
    }

    public void setToriatukaidairitencd4(String pToriatukaidairitencd4) {
        toriatukaidairitencd4 = pToriatukaidairitencd4;
    }

    private String kanjitoriatukaidairitennm4;

    public String getKanjitoriatukaidairitennm4() {
        return kanjitoriatukaidairitennm4;
    }

    public void setKanjitoriatukaidairitennm4(String pKanjitoriatukaidairitennm4) {
        kanjitoriatukaidairitennm4 = pKanjitoriatukaidairitennm4;
    }

    private String oyadairitencd4;

    public String getOyadairitencd4() {
        return oyadairitencd4;
    }

    public void setOyadairitencd4(String pOyadairitencd4) {
        oyadairitencd4 = pOyadairitencd4;
    }

    private String kanjioyadrtennm4;

    public String getKanjioyadrtennm4() {
        return kanjioyadrtennm4;
    }

    public void setKanjioyadrtennm4(String pKanjioyadrtennm4) {
        kanjioyadrtennm4 = pKanjioyadrtennm4;
    }

    @Length(length=7)
    @Digit
    @Modulus10w21
    @HostInvalidCharacter
    private String bosyuucd4;

    public String getBosyuucd4() {
        return bosyuucd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd4(String pBosyuucd4) {
        bosyuucd4 = pBosyuucd4;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm4;

    public String getBosyuuninnm4() {
        return bosyuuninnm4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm4(String pBosyuuninnm4) {
        bosyuuninnm4 = pBosyuuninnm4;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd4;

    public String getGyskkjsakisosikicd4() {
        return gyskkjsakisosikicd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd4(String pGyskkjsakisosikicd4) {
        gyskkjsakisosikicd4 = pGyskkjsakisosikicd4;
    }

    private String gyskkjsakisosikinmkj4;

    public String getGyskkjsakisosikinmkj4() {
        return gyskkjsakisosikinmkj4;
    }

    public void setGyskkjsakisosikinmkj4(String pGyskkjsakisosikinmkj4) {
        gyskkjsakisosikinmkj4 = pGyskkjsakisosikinmkj4;
    }

    private BizNumber bunwari4;

    public BizNumber getBunwari4() {
        return bunwari4;
    }

    public void setBunwari4(BizNumber pBunwari4) {
        bunwari4 = pBunwari4;
    }
}
