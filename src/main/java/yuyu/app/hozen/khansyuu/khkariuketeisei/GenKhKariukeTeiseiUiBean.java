package yuyu.app.hozen.khansyuu.khkariuketeisei;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_KrkteiseiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 仮受訂正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhKariukeTeiseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KikeiyakuInfoDataSourceBean> kikeiyakuInfoDataSource = new DataSource<>();
    public DataSource<KikeiyakuInfoDataSourceBean> getKikeiyakuInfoDataSource() {
        return kikeiyakuInfoDataSource;
    }

    @Deprecated
    public List<KikeiyakuInfoDataSourceBean> getKikeiyakuInfo() {
        return kikeiyakuInfoDataSource.getDatas();
    }

    public void setKikeiyakuInfo(List<KikeiyakuInfoDataSourceBean> pKikeiyakuInfo) {
        kikeiyakuInfoDataSource.setDatas(pKikeiyakuInfo);
    }

    private DataSource<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfoDataSource = new DataSource<>();
    public DataSource<NenkinsiharaiInfoDataSourceBean> getNenkinsiharaiInfoDataSource() {
        return nenkinsiharaiInfoDataSource;
    }

    @Deprecated
    public List<NenkinsiharaiInfoDataSourceBean> getNenkinsiharaiInfo() {
        return nenkinsiharaiInfoDataSource.getDatas();
    }

    public void setNenkinsiharaiInfo(List<NenkinsiharaiInfoDataSourceBean> pNenkinsiharaiInfo) {
        nenkinsiharaiInfoDataSource.setDatas(pNenkinsiharaiInfo);
    }

    private DataSource<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfoDataSource = new DataSource<>();
    public DataSource<PalkikeiyakuInfoDataSourceBean> getPalkikeiyakuInfoDataSource() {
        return palkikeiyakuInfoDataSource;
    }

    @Deprecated
    public List<PalkikeiyakuInfoDataSourceBean> getPalkikeiyakuInfo() {
        return palkikeiyakuInfoDataSource.getDatas();
    }

    public void setPalkikeiyakuInfo(List<PalkikeiyakuInfoDataSourceBean> pPalkikeiyakuInfo) {
        palkikeiyakuInfoDataSource.setDatas(pPalkikeiyakuInfo);
    }

    private DataSource<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfoDataSource = new DataSource<>();
    public DataSource<PalnenkinsiharaiInfoDataSourceBean> getPalnenkinsiharaiInfoDataSource() {
        return palnenkinsiharaiInfoDataSource;
    }

    @Deprecated
    public List<PalnenkinsiharaiInfoDataSourceBean> getPalnenkinsiharaiInfo() {
        return palnenkinsiharaiInfoDataSource.getDatas();
    }

    public void setPalnenkinsiharaiInfo(List<PalnenkinsiharaiInfoDataSourceBean> pPalnenkinsiharaiInfo) {
        palnenkinsiharaiInfoDataSource.setDatas(pPalnenkinsiharaiInfo);
    }

    private DataSource<PalsueokiInfoDataSourceBean> palsueokiInfoDataSource = new DataSource<>();
    public DataSource<PalsueokiInfoDataSourceBean> getPalsueokiInfoDataSource() {
        return palsueokiInfoDataSource;
    }

    @Deprecated
    public List<PalsueokiInfoDataSourceBean> getPalsueokiInfo() {
        return palsueokiInfoDataSource.getDatas();
    }

    public void setPalsueokiInfo(List<PalsueokiInfoDataSourceBean> pPalsueokiInfo) {
        palsueokiInfoDataSource.setDatas(pPalsueokiInfo);
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

    private C_KjkhukaKbn vkykskyknmkjkhukakbn;

    public C_KjkhukaKbn getVkykskyknmkjkhukakbn() {
        return vkykskyknmkjkhukakbn;
    }

    public void setVkykskyknmkjkhukakbn(C_KjkhukaKbn pVkykskyknmkjkhukakbn) {
        vkykskyknmkjkhukakbn = pVkykskyknmkjkhukakbn;
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

    private C_Kyksei vkykskyksei;

    public C_Kyksei getVkykskyksei() {
        return vkykskyksei;
    }

    public void setVkykskyksei(C_Kyksei pVkykskyksei) {
        vkykskyksei = pVkykskyksei;
    }

    private C_Tdk vkykskkkyktdk;

    public C_Tdk getVkykskkkyktdk() {
        return vkykskkkyktdk;
    }

    public void setVkykskkkyktdk(C_Tdk pVkykskkkyktdk) {
        vkykskkkyktdk = pVkykskkkyktdk;
    }

    private C_HjndaiykKbn vkykshjndaiykkbn;

    public C_HjndaiykKbn getVkykshjndaiykkbn() {
        return vkykshjndaiykkbn;
    }

    public void setVkykshjndaiykkbn(C_HjndaiykKbn pVkykshjndaiykkbn) {
        vkykshjndaiykkbn = pVkykshjndaiykkbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vkykshjndaiyknm;

    public String getVkykshjndaiyknm() {
        return vkykshjndaiyknm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVkykshjndaiyknm(String pVkykshjndaiyknm) {
        vkykshjndaiyknm = pVkykshjndaiyknm;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vkykshjndainmkn;

    public String getVkykshjndainmkn() {
        return vkykshjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVkykshjndainmkn(String pVkykshjndainmkn) {
        vkykshjndainmkn = pVkykshjndainmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String vkykshjndainmkj;

    public String getVkykshjndainmkj() {
        return vkykshjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVkykshjndainmkj(String pVkykshjndainmkj) {
        vkykshjndainmkj = pVkykshjndainmkj;
    }

    private C_FstphrkkeiroKbn vhrkifstphrkkeirokbn;

    public C_FstphrkkeiroKbn getVhrkifstphrkkeirokbn() {
        return vhrkifstphrkkeirokbn;
    }

    public void setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn pVhrkifstphrkkeirokbn) {
        vhrkifstphrkkeirokbn = pVhrkifstphrkkeirokbn;
    }

    private C_Hrkkaisuu vhrkihrkkaisuu;

    public C_Hrkkaisuu getVhrkihrkkaisuu() {
        return vhrkihrkkaisuu;
    }

    public void setVhrkihrkkaisuu(C_Hrkkaisuu pVhrkihrkkaisuu) {
        vhrkihrkkaisuu = pVhrkihrkkaisuu;
    }

    private C_Hrkkeiro vhrkihrkkeiro;

    public C_Hrkkeiro getVhrkihrkkeiro() {
        return vhrkihrkkeiro;
    }

    public void setVhrkihrkkeiro(C_Hrkkeiro pVhrkihrkkeiro) {
        vhrkihrkkeiro = pVhrkihrkkeiro;
    }

    private C_TkiktbrisyuruiKbn vhrkitikiktbrijk;

    public C_TkiktbrisyuruiKbn getVhrkitikiktbrijk() {
        return vhrkitikiktbrijk;
    }

    public void setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn pVhrkitikiktbrijk) {
        vhrkitikiktbrijk = pVhrkitikiktbrijk;
    }

    @ValidDateYm
    private BizDateYM vhrkijkipjytym;

    public BizDateYM getVhrkijkipjytym() {
        return vhrkijkipjytym;
    }

    @Trim("both")
    public void setVhrkijkipjytym(BizDateYM pVhrkijkipjytym) {
        vhrkijkipjytym = pVhrkijkipjytym;
    }

    private BizCurrency vhrkihrkp;

    public BizCurrency getVhrkihrkp() {
        return vhrkihrkp;
    }

    public void setVhrkihrkp(BizCurrency pVhrkihrkp) {
        vhrkihrkp = pVhrkihrkp;
    }

    private BizCurrency vhrkiitijibrp;

    public BizCurrency getVhrkiitijibrp() {
        return vhrkiitijibrp;
    }

    public void setVhrkiitijibrp(BizCurrency pVhrkiitijibrp) {
        vhrkiitijibrp = pVhrkiitijibrp;
    }

    private BizCurrency vhrkikihrkp;

    public BizCurrency getVhrkikihrkp() {
        return vhrkikihrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhrkikihrkp(BizCurrency pVhrkikihrkp) {
        vhrkikihrkp = pVhrkikihrkp;
    }

    private BizCurrency vhrkinextkosgohrkp;

    public BizCurrency getVhrkinextkosgohrkp() {
        return vhrkinextkosgohrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhrkinextkosgohrkp(BizCurrency pVhrkinextkosgohrkp) {
        vhrkinextkosgohrkp = pVhrkinextkosgohrkp;
    }

    private BizCurrency vhrkiyenkansannyknkingk;

    public BizCurrency getVhrkiyenkansannyknkingk() {
        return vhrkiyenkansannyknkingk;
    }

    public void setVhrkiyenkansannyknkingk(BizCurrency pVhrkiyenkansannyknkingk) {
        vhrkiyenkansannyknkingk = pVhrkiyenkansannyknkingk;
    }

    private BizDate vhrkiyentkykwsrateymd;

    public BizDate getVhrkiyentkykwsrateymd() {
        return vhrkiyentkykwsrateymd;
    }

    public void setVhrkiyentkykwsrateymd(BizDate pVhrkiyentkykwsrateymd) {
        vhrkiyentkykwsrateymd = pVhrkiyentkykwsrateymd;
    }

    private BizNumber vhrkiyentkykwsrate;

    public BizNumber getVhrkiyentkykwsrate() {
        return vhrkiyentkykwsrate;
    }

    public void setVhrkiyentkykwsrate(BizNumber pVhrkiyentkykwsrate) {
        vhrkiyentkykwsrate = pVhrkiyentkykwsrate;
    }

    private C_Tuukasyu vhrkiyentkykwsratetuukasyu;

    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu() {
        return vhrkiyentkykwsratetuukasyu;
    }

    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu) {
        vhrkiyentkykwsratetuukasyu = pVhrkiyentkykwsratetuukasyu;
    }

    private String vhrkihrkinfobankcd;

    public String getVhrkihrkinfobankcd() {
        return vhrkihrkinfobankcd;
    }

    public void setVhrkihrkinfobankcd(String pVhrkihrkinfobankcd) {
        vhrkihrkinfobankcd = pVhrkihrkinfobankcd;
    }

    private String vhrkihrkinfobanknmkj;

    public String getVhrkihrkinfobanknmkj() {
        return vhrkihrkinfobanknmkj;
    }

    public void setVhrkihrkinfobanknmkj(String pVhrkihrkinfobanknmkj) {
        vhrkihrkinfobanknmkj = pVhrkihrkinfobanknmkj;
    }

    private String vhrkihrkinfositencd;

    public String getVhrkihrkinfositencd() {
        return vhrkihrkinfositencd;
    }

    public void setVhrkihrkinfositencd(String pVhrkihrkinfositencd) {
        vhrkihrkinfositencd = pVhrkihrkinfositencd;
    }

    private String vhrkihrkinfositennmkj;

    public String getVhrkihrkinfositennmkj() {
        return vhrkihrkinfositennmkj;
    }

    public void setVhrkihrkinfositennmkj(String pVhrkihrkinfositennmkj) {
        vhrkihrkinfositennmkj = pVhrkihrkinfositennmkj;
    }

    private String vhrkihrkinfotuutyoukigou;

    public String getVhrkihrkinfotuutyoukigou() {
        return vhrkihrkinfotuutyoukigou;
    }

    public void setVhrkihrkinfotuutyoukigou(String pVhrkihrkinfotuutyoukigou) {
        vhrkihrkinfotuutyoukigou = pVhrkihrkinfotuutyoukigou;
    }

    private C_YokinKbn vhrkihrkinfoyokinkbn;

    public C_YokinKbn getVhrkihrkinfoyokinkbn() {
        return vhrkihrkinfoyokinkbn;
    }

    public void setVhrkihrkinfoyokinkbn(C_YokinKbn pVhrkihrkinfoyokinkbn) {
        vhrkihrkinfoyokinkbn = pVhrkihrkinfoyokinkbn;
    }

    private String vhrkihrkinfokouzano;

    public String getVhrkihrkinfokouzano() {
        return vhrkihrkinfokouzano;
    }

    public void setVhrkihrkinfokouzano(String pVhrkihrkinfokouzano) {
        vhrkihrkinfokouzano = pVhrkihrkinfokouzano;
    }

    private C_SinkeizkKbn vhrkihrkinfosinkeizkkbn;

    public C_SinkeizkKbn getVhrkihrkinfosinkeizkkbn() {
        return vhrkihrkinfosinkeizkkbn;
    }

    public void setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn pVhrkihrkinfosinkeizkkbn) {
        vhrkihrkinfosinkeizkkbn = pVhrkihrkinfosinkeizkkbn;
    }

    @HostInvalidCharacter
    private String vhrkihrkinfokzmeiginmkn;

    public String getVhrkihrkinfokzmeiginmkn() {
        return vhrkihrkinfokzmeiginmkn;
    }

    public void setVhrkihrkinfokzmeiginmkn(String pVhrkihrkinfokzmeiginmkn) {
        vhrkihrkinfokzmeiginmkn = pVhrkihrkinfokzmeiginmkn;
    }

    private C_KzkykdouKbn vhrkikzdoukbn;

    public C_KzkykdouKbn getVhrkikzdoukbn() {
        return vhrkikzdoukbn;
    }

    public void setVhrkikzdoukbn(C_KzkykdouKbn pVhrkikzdoukbn) {
        vhrkikzdoukbn = pVhrkikzdoukbn;
    }

    private String vhrkidispcreditkessaiyouno;

    public String getVhrkidispcreditkessaiyouno() {
        return vhrkidispcreditkessaiyouno;
    }

    public void setVhrkidispcreditkessaiyouno(String pVhrkidispcreditkessaiyouno) {
        vhrkidispcreditkessaiyouno = pVhrkidispcreditkessaiyouno;
    }

    private C_Yuukoukakkekka vhrkicredityuukoukakkekka;

    public C_Yuukoukakkekka getVhrkicredityuukoukakkekka() {
        return vhrkicredityuukoukakkekka;
    }

    public void setVhrkicredityuukoukakkekka(C_Yuukoukakkekka pVhrkicredityuukoukakkekka) {
        vhrkicredityuukoukakkekka = pVhrkicredityuukoukakkekka;
    }

    @ValidDateYm
    private BizDateYM vhrkicredityuukoukakym;

    public BizDateYM getVhrkicredityuukoukakym() {
        return vhrkicredityuukoukakym;
    }

    @Trim("both")
    public void setVhrkicredityuukoukakym(BizDateYM pVhrkicredityuukoukakym) {
        vhrkicredityuukoukakym = pVhrkicredityuukoukakym;
    }

    @ValidDateYm
    private BizDateYM vhrkizennoustartym;

    public BizDateYM getVhrkizennoustartym() {
        return vhrkizennoustartym;
    }

    @Trim("both")
    public void setVhrkizennoustartym(BizDateYM pVhrkizennoustartym) {
        vhrkizennoustartym = pVhrkizennoustartym;
    }

    private String vhrkizennoukkn;

    public String getVhrkizennoukkn() {
        return vhrkizennoukkn;
    }

    public void setVhrkizennoukkn(String pVhrkizennoukkn) {
        vhrkizennoukkn = pVhrkizennoukkn;
    }

    private BizCurrency vhrkizennounyuukingk;

    public BizCurrency getVhrkizennounyuukingk() {
        return vhrkizennounyuukingk;
    }

    public void setVhrkizennounyuukingk(BizCurrency pVhrkizennounyuukingk) {
        vhrkizennounyuukingk = pVhrkizennounyuukingk;
    }

    @ValidDate
    private BizDate vhrkizennounyuukinymd;

    public BizDate getVhrkizennounyuukinymd() {
        return vhrkizennounyuukinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhrkizennounyuukinymd(BizDate pVhrkizennounyuukinymd) {
        vhrkizennounyuukinymd = pVhrkizennounyuukinymd;
    }

    private C_Kykjyoutai vhrkikykjyoutai;

    public C_Kykjyoutai getVhrkikykjyoutai() {
        return vhrkikykjyoutai;
    }

    public void setVhrkikykjyoutai(C_Kykjyoutai pVhrkikykjyoutai) {
        vhrkikykjyoutai = pVhrkikykjyoutai;
    }

    private C_UmuKbn vhrkizenkizennouumu;

    public C_UmuKbn getVhrkizenkizennouumu() {
        return vhrkizenkizennouumu;
    }

    public void setVhrkizenkizennouumu(C_UmuKbn pVhrkizenkizennouumu) {
        vhrkizenkizennouumu = pVhrkizenkizennouumu;
    }

    private String vhrkicreditkessaiyouno;

    public String getVhrkicreditkessaiyouno() {
        return vhrkicreditkessaiyouno;
    }

    public void setVhrkicreditkessaiyouno(String pVhrkicreditkessaiyouno) {
        vhrkicreditkessaiyouno = pVhrkicreditkessaiyouno;
    }

    private C_TokusinKbn vtstokusinkbn;

    public C_TokusinKbn getVtstokusinkbn() {
        return vtstokusinkbn;
    }

    public void setVtstokusinkbn(C_TokusinKbn pVtstokusinkbn) {
        vtstokusinkbn = pVtstokusinkbn;
    }

    @ValidDate
    private BizDate vtshsgymd;

    public BizDate getVtshsgymd() {
        return vtshsgymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVtshsgymd(BizDate pVtshsgymd) {
        vtshsgymd = pVtshsgymd;
    }

    @ValidDate
    private BizDate vtstokusinendymd;

    public BizDate getVtstokusinendymd() {
        return vtstokusinendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVtstokusinendymd(BizDate pVtstokusinendymd) {
        vtstokusinendymd = pVtstokusinendymd;
    }

    private C_UmuKbn vtsumukbn;

    public C_UmuKbn getVtsumukbn() {
        return vtsumukbn;
    }

    public void setVtsumukbn(C_UmuKbn pVtsumukbn) {
        vtsumukbn = pVtsumukbn;
    }

    @ValidDate
    private BizDate vdtdattaisyoriymd;

    public BizDate getVdtdattaisyoriymd() {
        return vdtdattaisyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVdtdattaisyoriymd(BizDate pVdtdattaisyoriymd) {
        vdtdattaisyoriymd = pVdtdattaisyoriymd;
    }

    private C_DattairiyuuKbn vdtdattairiyuukbn;

    public C_DattairiyuuKbn getVdtdattairiyuukbn() {
        return vdtdattairiyuukbn;
    }

    public void setVdtdattairiyuukbn(C_DattairiyuuKbn pVdtdattairiyuukbn) {
        vdtdattairiyuukbn = pVdtdattairiyuukbn;
    }

    private String vdtcomment;

    public String getVdtcomment() {
        return vdtcomment;
    }

    @Trim("right")
    public void setVdtcomment(String pVdtcomment) {
        vdtcomment = pVdtcomment;
    }

    private C_UmuKbn vdtumukbn;

    public C_UmuKbn getVdtumukbn() {
        return vdtumukbn;
    }

    public void setVdtumukbn(C_UmuKbn pVdtumukbn) {
        vdtumukbn = pVdtumukbn;
    }

    private String vtrkkzktrkkzknmkn1;

    public String getVtrkkzktrkkzknmkn1() {
        return vtrkkzktrkkzknmkn1;
    }

    public void setVtrkkzktrkkzknmkn1(String pVtrkkzktrkkzknmkn1) {
        vtrkkzktrkkzknmkn1 = pVtrkkzktrkkzknmkn1;
    }

    private String vtrkkzktrkkzknmkj1;

    public String getVtrkkzktrkkzknmkj1() {
        return vtrkkzktrkkzknmkj1;
    }

    public void setVtrkkzktrkkzknmkj1(String pVtrkkzktrkkzknmkj1) {
        vtrkkzktrkkzknmkj1 = pVtrkkzktrkkzknmkj1;
    }

    private C_KjkhukaKbn vtrkkzktrkkzknmkjkhukakbn1;

    public C_KjkhukaKbn getVtrkkzktrkkzknmkjkhukakbn1() {
        return vtrkkzktrkkzknmkjkhukakbn1;
    }

    public void setVtrkkzktrkkzknmkjkhukakbn1(C_KjkhukaKbn pVtrkkzktrkkzknmkjkhukakbn1) {
        vtrkkzktrkkzknmkjkhukakbn1 = pVtrkkzktrkkzknmkjkhukakbn1;
    }

    private BizDate vtrkkzktrkkzkseiymd1;

    public BizDate getVtrkkzktrkkzkseiymd1() {
        return vtrkkzktrkkzkseiymd1;
    }

    public void setVtrkkzktrkkzkseiymd1(BizDate pVtrkkzktrkkzkseiymd1) {
        vtrkkzktrkkzkseiymd1 = pVtrkkzktrkkzkseiymd1;
    }

    private C_Seibetu vtrkkzktrkkzksei1;

    public C_Seibetu getVtrkkzktrkkzksei1() {
        return vtrkkzktrkkzksei1;
    }

    public void setVtrkkzktrkkzksei1(C_Seibetu pVtrkkzktrkkzksei1) {
        vtrkkzktrkkzksei1 = pVtrkkzktrkkzksei1;
    }

    private C_Tdk vtrkkzktrkkzktdk1;

    public C_Tdk getVtrkkzktrkkzktdk1() {
        return vtrkkzktrkkzktdk1;
    }

    public void setVtrkkzktrkkzktdk1(C_Tdk pVtrkkzktrkkzktdk1) {
        vtrkkzktrkkzktdk1 = pVtrkkzktrkkzktdk1;
    }

    private String vtrkkzktrkkzkyno1;

    public String getVtrkkzktrkkzkyno1() {
        return vtrkkzktrkkzkyno1;
    }

    public void setVtrkkzktrkkzkyno1(String pVtrkkzktrkkzkyno1) {
        vtrkkzktrkkzkyno1 = pVtrkkzktrkkzkyno1;
    }

    private String vtrkkzktrkkzkadr1kj1;

    public String getVtrkkzktrkkzkadr1kj1() {
        return vtrkkzktrkkzkadr1kj1;
    }

    public void setVtrkkzktrkkzkadr1kj1(String pVtrkkzktrkkzkadr1kj1) {
        vtrkkzktrkkzkadr1kj1 = pVtrkkzktrkkzkadr1kj1;
    }

    private String vtrkkzktrkkzkadr2kj1;

    public String getVtrkkzktrkkzkadr2kj1() {
        return vtrkkzktrkkzkadr2kj1;
    }

    public void setVtrkkzktrkkzkadr2kj1(String pVtrkkzktrkkzkadr2kj1) {
        vtrkkzktrkkzkadr2kj1 = pVtrkkzktrkkzkadr2kj1;
    }

    private String vtrkkzktrkkzkadr3kj1;

    public String getVtrkkzktrkkzkadr3kj1() {
        return vtrkkzktrkkzkadr3kj1;
    }

    public void setVtrkkzktrkkzkadr3kj1(String pVtrkkzktrkkzkadr3kj1) {
        vtrkkzktrkkzkadr3kj1 = pVtrkkzktrkkzkadr3kj1;
    }

    private String vtrkkzktrkkzktelno1;

    public String getVtrkkzktrkkzktelno1() {
        return vtrkkzktrkkzktelno1;
    }

    public void setVtrkkzktrkkzktelno1(String pVtrkkzktrkkzktelno1) {
        vtrkkzktrkkzktelno1 = pVtrkkzktrkkzktelno1;
    }

    private C_UmuKbn vtrkkzktrkkzkumukbn1;

    public C_UmuKbn getVtrkkzktrkkzkumukbn1() {
        return vtrkkzktrkkzkumukbn1;
    }

    public void setVtrkkzktrkkzkumukbn1(C_UmuKbn pVtrkkzktrkkzkumukbn1) {
        vtrkkzktrkkzkumukbn1 = pVtrkkzktrkkzkumukbn1;
    }

    private String vtrkkzktrkkzknmkn2;

    public String getVtrkkzktrkkzknmkn2() {
        return vtrkkzktrkkzknmkn2;
    }

    public void setVtrkkzktrkkzknmkn2(String pVtrkkzktrkkzknmkn2) {
        vtrkkzktrkkzknmkn2 = pVtrkkzktrkkzknmkn2;
    }

    private String vtrkkzktrkkzknmkj2;

    public String getVtrkkzktrkkzknmkj2() {
        return vtrkkzktrkkzknmkj2;
    }

    public void setVtrkkzktrkkzknmkj2(String pVtrkkzktrkkzknmkj2) {
        vtrkkzktrkkzknmkj2 = pVtrkkzktrkkzknmkj2;
    }

    private C_KjkhukaKbn vtrkkzktrkkzknmkjkhukakbn2;

    public C_KjkhukaKbn getVtrkkzktrkkzknmkjkhukakbn2() {
        return vtrkkzktrkkzknmkjkhukakbn2;
    }

    public void setVtrkkzktrkkzknmkjkhukakbn2(C_KjkhukaKbn pVtrkkzktrkkzknmkjkhukakbn2) {
        vtrkkzktrkkzknmkjkhukakbn2 = pVtrkkzktrkkzknmkjkhukakbn2;
    }

    private BizDate vtrkkzktrkkzkseiymd2;

    public BizDate getVtrkkzktrkkzkseiymd2() {
        return vtrkkzktrkkzkseiymd2;
    }

    public void setVtrkkzktrkkzkseiymd2(BizDate pVtrkkzktrkkzkseiymd2) {
        vtrkkzktrkkzkseiymd2 = pVtrkkzktrkkzkseiymd2;
    }

    private C_Seibetu vtrkkzktrkkzksei2;

    public C_Seibetu getVtrkkzktrkkzksei2() {
        return vtrkkzktrkkzksei2;
    }

    public void setVtrkkzktrkkzksei2(C_Seibetu pVtrkkzktrkkzksei2) {
        vtrkkzktrkkzksei2 = pVtrkkzktrkkzksei2;
    }

    private C_Tdk vtrkkzktrkkzktdk2;

    public C_Tdk getVtrkkzktrkkzktdk2() {
        return vtrkkzktrkkzktdk2;
    }

    public void setVtrkkzktrkkzktdk2(C_Tdk pVtrkkzktrkkzktdk2) {
        vtrkkzktrkkzktdk2 = pVtrkkzktrkkzktdk2;
    }

    private String vtrkkzktrkkzkyno2;

    public String getVtrkkzktrkkzkyno2() {
        return vtrkkzktrkkzkyno2;
    }

    public void setVtrkkzktrkkzkyno2(String pVtrkkzktrkkzkyno2) {
        vtrkkzktrkkzkyno2 = pVtrkkzktrkkzkyno2;
    }

    private String vtrkkzktrkkzkadr1kj2;

    public String getVtrkkzktrkkzkadr1kj2() {
        return vtrkkzktrkkzkadr1kj2;
    }

    public void setVtrkkzktrkkzkadr1kj2(String pVtrkkzktrkkzkadr1kj2) {
        vtrkkzktrkkzkadr1kj2 = pVtrkkzktrkkzkadr1kj2;
    }

    private String vtrkkzktrkkzkadr2kj2;

    public String getVtrkkzktrkkzkadr2kj2() {
        return vtrkkzktrkkzkadr2kj2;
    }

    public void setVtrkkzktrkkzkadr2kj2(String pVtrkkzktrkkzkadr2kj2) {
        vtrkkzktrkkzkadr2kj2 = pVtrkkzktrkkzkadr2kj2;
    }

    private String vtrkkzktrkkzkadr3kj2;

    public String getVtrkkzktrkkzkadr3kj2() {
        return vtrkkzktrkkzkadr3kj2;
    }

    public void setVtrkkzktrkkzkadr3kj2(String pVtrkkzktrkkzkadr3kj2) {
        vtrkkzktrkkzkadr3kj2 = pVtrkkzktrkkzkadr3kj2;
    }

    private String vtrkkzktrkkzktelno2;

    public String getVtrkkzktrkkzktelno2() {
        return vtrkkzktrkkzktelno2;
    }

    public void setVtrkkzktrkkzktelno2(String pVtrkkzktrkkzktelno2) {
        vtrkkzktrkkzktelno2 = pVtrkkzktrkkzktelno2;
    }

    private C_UmuKbn vtrkkzktrkkzkumukbn2;

    public C_UmuKbn getVtrkkzktrkkzkumukbn2() {
        return vtrkkzktrkkzkumukbn2;
    }

    public void setVtrkkzktrkkzkumukbn2(C_UmuKbn pVtrkkzktrkkzkumukbn2) {
        vtrkkzktrkkzkumukbn2 = pVtrkkzktrkkzkumukbn2;
    }

    private C_UktKbn vkykdrkykdrkbn;

    public C_UktKbn getVkykdrkykdrkbn() {
        return vkykdrkykdrkbn;
    }

    public void setVkykdrkykdrkbn(C_UktKbn pVkykdrkykdrkbn) {
        vkykdrkykdrkbn = pVkykdrkykdrkbn;
    }

    private String vkykdrkykdrnmkn;

    public String getVkykdrkykdrnmkn() {
        return vkykdrkykdrnmkn;
    }

    public void setVkykdrkykdrnmkn(String pVkykdrkykdrnmkn) {
        vkykdrkykdrnmkn = pVkykdrkykdrnmkn;
    }

    private String vkykdrkykdrnmkj;

    public String getVkykdrkykdrnmkj() {
        return vkykdrkykdrnmkj;
    }

    public void setVkykdrkykdrnmkj(String pVkykdrkykdrnmkj) {
        vkykdrkykdrnmkj = pVkykdrkykdrnmkj;
    }

    private C_KjkhukaKbn vkykdrkykdrnmkjkhukakbn;

    public C_KjkhukaKbn getVkykdrkykdrnmkjkhukakbn() {
        return vkykdrkykdrnmkjkhukakbn;
    }

    public void setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn pVkykdrkykdrnmkjkhukakbn) {
        vkykdrkykdrnmkjkhukakbn = pVkykdrkykdrnmkjkhukakbn;
    }

    private BizDate vkykdrkykdrseiymd;

    public BizDate getVkykdrkykdrseiymd() {
        return vkykdrkykdrseiymd;
    }

    public void setVkykdrkykdrseiymd(BizDate pVkykdrkykdrseiymd) {
        vkykdrkykdrseiymd = pVkykdrkykdrseiymd;
    }

    private String vkykdrkykdryno;

    public String getVkykdrkykdryno() {
        return vkykdrkykdryno;
    }

    public void setVkykdrkykdryno(String pVkykdrkykdryno) {
        vkykdrkykdryno = pVkykdrkykdryno;
    }

    private String vkykdrkykdradr1kj;

    public String getVkykdrkykdradr1kj() {
        return vkykdrkykdradr1kj;
    }

    public void setVkykdrkykdradr1kj(String pVkykdrkykdradr1kj) {
        vkykdrkykdradr1kj = pVkykdrkykdradr1kj;
    }

    private String vkykdrkykdradr2kj;

    public String getVkykdrkykdradr2kj() {
        return vkykdrkykdradr2kj;
    }

    public void setVkykdrkykdradr2kj(String pVkykdrkykdradr2kj) {
        vkykdrkykdradr2kj = pVkykdrkykdradr2kj;
    }

    private String vkykdrkykdradr3kj;

    public String getVkykdrkykdradr3kj() {
        return vkykdrkykdradr3kj;
    }

    public void setVkykdrkykdradr3kj(String pVkykdrkykdradr3kj) {
        vkykdrkykdradr3kj = pVkykdrkykdradr3kj;
    }

    @Range(min="0", max="99999")
    private Integer krkno;

    public Integer getKrkno() {
        return krkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        krkno = pKrkno;
    }

    private BizDate krkkeijyoymd;

    public BizDate getKrkkeijyoymd() {
        return krkkeijyoymd;
    }

    @Trim("both")
    public void setKrkkeijyoymd(BizDate pKrkkeijyoymd) {
        krkkeijyoymd = pKrkkeijyoymd;
    }

    private C_KrkriyuuKbn krkriyuukbn;

    public C_KrkriyuuKbn getKrkriyuukbn() {
        return krkriyuukbn;
    }

    public void setKrkriyuukbn(C_KrkriyuuKbn pKrkriyuukbn) {
        krkriyuukbn = pKrkriyuukbn;
    }

    private BizDate hasseidenymd;

    public BizDate getHasseidenymd() {
        return hasseidenymd;
    }

    @Trim("both")
    public void setHasseidenymd(BizDate pHasseidenymd) {
        hasseidenymd = pHasseidenymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_Nykkeiro nykkeiro;

    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    @ValidDateYm
    private BizDateYM jyuutouym;

    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    @Range(min="0", max="99")
    private Integer jyutoukaisuuy;

    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    @Range(min="0", max="12")
    private Integer jyutoukaisuum;

    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    @ValidDate
    private BizDate ryosyuymd;

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizCurrency krkgk;

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }

    private String dispcreditkessaiyouno;

    public String getDispcreditkessaiyouno() {
        return dispcreditkessaiyouno;
    }

    public void setDispcreditkessaiyouno(String pDispcreditkessaiyouno) {
        dispcreditkessaiyouno = pDispcreditkessaiyouno;
    }

    private C_KrkteiseiKbn krkteiseikbn;

    public C_KrkteiseiKbn getKrkteiseikbn() {
        return krkteiseikbn;
    }

    public void setKrkteiseikbn(C_KrkteiseiKbn pKrkteiseikbn) {
        krkteiseikbn = pKrkteiseikbn;
    }

    @Length(length=5)
    @Digit
    private String denkarikanjyono;

    public String getDenkarikanjyono() {
        return denkarikanjyono;
    }

    public void setDenkarikanjyono(String pDenkarikanjyono) {
        denkarikanjyono = pDenkarikanjyono;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
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

    private String disphnknsakicreditkessaiyouno;

    public String getDisphnknsakicreditkessaiyouno() {
        return disphnknsakicreditkessaiyouno;
    }

    public void setDisphnknsakicreditkessaiyouno(String pDisphnknsakicreditkessaiyouno) {
        disphnknsakicreditkessaiyouno = pDisphnknsakicreditkessaiyouno;
    }

    private C_HassouKbn hassoukbn;

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_ShrriyuuKbn shrriyuukbn;

    public C_ShrriyuuKbn getShrriyuukbn() {
        return shrriyuukbn;
    }

    public void setShrriyuukbn(C_ShrriyuuKbn pShrriyuukbn) {
        shrriyuukbn = pShrriyuukbn;
    }
}
