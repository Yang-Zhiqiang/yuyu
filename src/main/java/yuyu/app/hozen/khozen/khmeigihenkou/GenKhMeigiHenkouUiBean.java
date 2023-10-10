package yuyu.app.hozen.khozen.khmeigihenkou;

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
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkaijyoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 名義変更／契約者等生年月日訂正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhMeigiHenkouUiBean extends AbstractUiBean {

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

    @ValidDate
    private BizDate dispaeoisyoriymd1;

    public BizDate getDispaeoisyoriymd1() {
        return dispaeoisyoriymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyoriymd1(BizDate pDispaeoisyoriymd1) {
        dispaeoisyoriymd1 = pDispaeoisyoriymd1;
    }

    @Length(length=7)
    private String dispaeoisyorisosikicd1;

    public String getDispaeoisyorisosikicd1() {
        return dispaeoisyorisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyorisosikicd1(String pDispaeoisyorisosikicd1) {
        dispaeoisyorisosikicd1 = pDispaeoisyorisosikicd1;
    }

    private C_AeoiKekkaKbn dispaeoikekkakbn1;

    public C_AeoiKekkaKbn getDispaeoikekkakbn1() {
        return dispaeoikekkakbn1;
    }

    public void setDispaeoikekkakbn1(C_AeoiKekkaKbn pDispaeoikekkakbn1) {
        dispaeoikekkakbn1 = pDispaeoikekkakbn1;
    }

    private C_AeoiSyoriKbn dispaeoisyorikbn1;

    public C_AeoiSyoriKbn getDispaeoisyorikbn1() {
        return dispaeoisyorikbn1;
    }

    public void setDispaeoisyorikbn1(C_AeoiSyoriKbn pDispaeoisyorikbn1) {
        dispaeoisyorikbn1 = pDispaeoisyorikbn1;
    }

    private C_AeoiTaisyousyaKbn dispaeoitaisyousyakbn1;

    public C_AeoiTaisyousyaKbn getDispaeoitaisyousyakbn1() {
        return dispaeoitaisyousyakbn1;
    }

    public void setDispaeoitaisyousyakbn1(C_AeoiTaisyousyaKbn pDispaeoitaisyousyakbn1) {
        dispaeoitaisyousyakbn1 = pDispaeoitaisyousyakbn1;
    }

    private C_AeoiHoujinSyuruiKbn dispaeoihoujinsyuruikbn1;

    public C_AeoiHoujinSyuruiKbn getDispaeoihoujinsyuruikbn1() {
        return dispaeoihoujinsyuruikbn1;
    }

    public void setDispaeoihoujinsyuruikbn1(C_AeoiHoujinSyuruiKbn pDispaeoihoujinsyuruikbn1) {
        dispaeoihoujinsyuruikbn1 = pDispaeoihoujinsyuruikbn1;
    }

    @ValidDate
    private BizDate dispaeoikouryokusttymd1;

    public BizDate getDispaeoikouryokusttymd1() {
        return dispaeoikouryokusttymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokusttymd1(BizDate pDispaeoikouryokusttymd1) {
        dispaeoikouryokusttymd1 = pDispaeoikouryokusttymd1;
    }

    @ValidDate
    private BizDate dispaeoikouryokuendymd1;

    public BizDate getDispaeoikouryokuendymd1() {
        return dispaeoikouryokuendymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokuendymd1(BizDate pDispaeoikouryokuendymd1) {
        dispaeoikouryokuendymd1 = pDispaeoikouryokuendymd1;
    }

    @ValidDate
    private BizDate dispaeoisyoriymd2;

    public BizDate getDispaeoisyoriymd2() {
        return dispaeoisyoriymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyoriymd2(BizDate pDispaeoisyoriymd2) {
        dispaeoisyoriymd2 = pDispaeoisyoriymd2;
    }

    @Length(length=7)
    private String dispaeoisyorisosikicd2;

    public String getDispaeoisyorisosikicd2() {
        return dispaeoisyorisosikicd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyorisosikicd2(String pDispaeoisyorisosikicd2) {
        dispaeoisyorisosikicd2 = pDispaeoisyorisosikicd2;
    }

    private C_AeoiKekkaKbn dispaeoikekkakbn2;

    public C_AeoiKekkaKbn getDispaeoikekkakbn2() {
        return dispaeoikekkakbn2;
    }

    public void setDispaeoikekkakbn2(C_AeoiKekkaKbn pDispaeoikekkakbn2) {
        dispaeoikekkakbn2 = pDispaeoikekkakbn2;
    }

    private C_AeoiSyoriKbn dispaeoisyorikbn2;

    public C_AeoiSyoriKbn getDispaeoisyorikbn2() {
        return dispaeoisyorikbn2;
    }

    public void setDispaeoisyorikbn2(C_AeoiSyoriKbn pDispaeoisyorikbn2) {
        dispaeoisyorikbn2 = pDispaeoisyorikbn2;
    }

    private C_AeoiTaisyousyaKbn dispaeoitaisyousyakbn2;

    public C_AeoiTaisyousyaKbn getDispaeoitaisyousyakbn2() {
        return dispaeoitaisyousyakbn2;
    }

    public void setDispaeoitaisyousyakbn2(C_AeoiTaisyousyaKbn pDispaeoitaisyousyakbn2) {
        dispaeoitaisyousyakbn2 = pDispaeoitaisyousyakbn2;
    }

    private C_AeoiHoujinSyuruiKbn dispaeoihoujinsyuruikbn2;

    public C_AeoiHoujinSyuruiKbn getDispaeoihoujinsyuruikbn2() {
        return dispaeoihoujinsyuruikbn2;
    }

    public void setDispaeoihoujinsyuruikbn2(C_AeoiHoujinSyuruiKbn pDispaeoihoujinsyuruikbn2) {
        dispaeoihoujinsyuruikbn2 = pDispaeoihoujinsyuruikbn2;
    }

    @ValidDate
    private BizDate dispaeoikouryokusttymd2;

    public BizDate getDispaeoikouryokusttymd2() {
        return dispaeoikouryokusttymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokusttymd2(BizDate pDispaeoikouryokusttymd2) {
        dispaeoikouryokusttymd2 = pDispaeoikouryokusttymd2;
    }

    @ValidDate
    private BizDate dispaeoikouryokuendymd2;

    public BizDate getDispaeoikouryokuendymd2() {
        return dispaeoikouryokuendymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokuendymd2(BizDate pDispaeoikouryokuendymd2) {
        dispaeoikouryokuendymd2 = pDispaeoikouryokuendymd2;
    }

    @ValidDate
    private BizDate dispaeoisyoriymd3;

    public BizDate getDispaeoisyoriymd3() {
        return dispaeoisyoriymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyoriymd3(BizDate pDispaeoisyoriymd3) {
        dispaeoisyoriymd3 = pDispaeoisyoriymd3;
    }

    @Length(length=7)
    private String dispaeoisyorisosikicd3;

    public String getDispaeoisyorisosikicd3() {
        return dispaeoisyorisosikicd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyorisosikicd3(String pDispaeoisyorisosikicd3) {
        dispaeoisyorisosikicd3 = pDispaeoisyorisosikicd3;
    }

    private C_AeoiKekkaKbn dispaeoikekkakbn3;

    public C_AeoiKekkaKbn getDispaeoikekkakbn3() {
        return dispaeoikekkakbn3;
    }

    public void setDispaeoikekkakbn3(C_AeoiKekkaKbn pDispaeoikekkakbn3) {
        dispaeoikekkakbn3 = pDispaeoikekkakbn3;
    }

    private C_AeoiSyoriKbn dispaeoisyorikbn3;

    public C_AeoiSyoriKbn getDispaeoisyorikbn3() {
        return dispaeoisyorikbn3;
    }

    public void setDispaeoisyorikbn3(C_AeoiSyoriKbn pDispaeoisyorikbn3) {
        dispaeoisyorikbn3 = pDispaeoisyorikbn3;
    }

    private C_AeoiTaisyousyaKbn dispaeoitaisyousyakbn3;

    public C_AeoiTaisyousyaKbn getDispaeoitaisyousyakbn3() {
        return dispaeoitaisyousyakbn3;
    }

    public void setDispaeoitaisyousyakbn3(C_AeoiTaisyousyaKbn pDispaeoitaisyousyakbn3) {
        dispaeoitaisyousyakbn3 = pDispaeoitaisyousyakbn3;
    }

    private C_AeoiHoujinSyuruiKbn dispaeoihoujinsyuruikbn3;

    public C_AeoiHoujinSyuruiKbn getDispaeoihoujinsyuruikbn3() {
        return dispaeoihoujinsyuruikbn3;
    }

    public void setDispaeoihoujinsyuruikbn3(C_AeoiHoujinSyuruiKbn pDispaeoihoujinsyuruikbn3) {
        dispaeoihoujinsyuruikbn3 = pDispaeoihoujinsyuruikbn3;
    }

    @ValidDate
    private BizDate dispaeoikouryokusttymd3;

    public BizDate getDispaeoikouryokusttymd3() {
        return dispaeoikouryokusttymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokusttymd3(BizDate pDispaeoikouryokusttymd3) {
        dispaeoikouryokusttymd3 = pDispaeoikouryokusttymd3;
    }

    @ValidDate
    private BizDate dispaeoikouryokuendymd3;

    public BizDate getDispaeoikouryokuendymd3() {
        return dispaeoikouryokuendymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokuendymd3(BizDate pDispaeoikouryokuendymd3) {
        dispaeoikouryokuendymd3 = pDispaeoikouryokuendymd3;
    }

    @ValidDate
    private BizDate dispaeoisyoriymd4;

    public BizDate getDispaeoisyoriymd4() {
        return dispaeoisyoriymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyoriymd4(BizDate pDispaeoisyoriymd4) {
        dispaeoisyoriymd4 = pDispaeoisyoriymd4;
    }

    @Length(length=7)
    private String dispaeoisyorisosikicd4;

    public String getDispaeoisyorisosikicd4() {
        return dispaeoisyorisosikicd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyorisosikicd4(String pDispaeoisyorisosikicd4) {
        dispaeoisyorisosikicd4 = pDispaeoisyorisosikicd4;
    }

    private C_AeoiKekkaKbn dispaeoikekkakbn4;

    public C_AeoiKekkaKbn getDispaeoikekkakbn4() {
        return dispaeoikekkakbn4;
    }

    public void setDispaeoikekkakbn4(C_AeoiKekkaKbn pDispaeoikekkakbn4) {
        dispaeoikekkakbn4 = pDispaeoikekkakbn4;
    }

    private C_AeoiSyoriKbn dispaeoisyorikbn4;

    public C_AeoiSyoriKbn getDispaeoisyorikbn4() {
        return dispaeoisyorikbn4;
    }

    public void setDispaeoisyorikbn4(C_AeoiSyoriKbn pDispaeoisyorikbn4) {
        dispaeoisyorikbn4 = pDispaeoisyorikbn4;
    }

    private C_AeoiTaisyousyaKbn dispaeoitaisyousyakbn4;

    public C_AeoiTaisyousyaKbn getDispaeoitaisyousyakbn4() {
        return dispaeoitaisyousyakbn4;
    }

    public void setDispaeoitaisyousyakbn4(C_AeoiTaisyousyaKbn pDispaeoitaisyousyakbn4) {
        dispaeoitaisyousyakbn4 = pDispaeoitaisyousyakbn4;
    }

    private C_AeoiHoujinSyuruiKbn dispaeoihoujinsyuruikbn4;

    public C_AeoiHoujinSyuruiKbn getDispaeoihoujinsyuruikbn4() {
        return dispaeoihoujinsyuruikbn4;
    }

    public void setDispaeoihoujinsyuruikbn4(C_AeoiHoujinSyuruiKbn pDispaeoihoujinsyuruikbn4) {
        dispaeoihoujinsyuruikbn4 = pDispaeoihoujinsyuruikbn4;
    }

    @ValidDate
    private BizDate dispaeoikouryokusttymd4;

    public BizDate getDispaeoikouryokusttymd4() {
        return dispaeoikouryokusttymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokusttymd4(BizDate pDispaeoikouryokusttymd4) {
        dispaeoikouryokusttymd4 = pDispaeoikouryokusttymd4;
    }

    @ValidDate
    private BizDate dispaeoikouryokuendymd4;

    public BizDate getDispaeoikouryokuendymd4() {
        return dispaeoikouryokuendymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokuendymd4(BizDate pDispaeoikouryokuendymd4) {
        dispaeoikouryokuendymd4 = pDispaeoikouryokuendymd4;
    }

    @ValidDate
    private BizDate dispaeoisyoriymd5;

    public BizDate getDispaeoisyoriymd5() {
        return dispaeoisyoriymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyoriymd5(BizDate pDispaeoisyoriymd5) {
        dispaeoisyoriymd5 = pDispaeoisyoriymd5;
    }

    @Length(length=7)
    private String dispaeoisyorisosikicd5;

    public String getDispaeoisyorisosikicd5() {
        return dispaeoisyorisosikicd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoisyorisosikicd5(String pDispaeoisyorisosikicd5) {
        dispaeoisyorisosikicd5 = pDispaeoisyorisosikicd5;
    }

    private C_AeoiKekkaKbn dispaeoikekkakbn5;

    public C_AeoiKekkaKbn getDispaeoikekkakbn5() {
        return dispaeoikekkakbn5;
    }

    public void setDispaeoikekkakbn5(C_AeoiKekkaKbn pDispaeoikekkakbn5) {
        dispaeoikekkakbn5 = pDispaeoikekkakbn5;
    }

    private C_AeoiSyoriKbn dispaeoisyorikbn5;

    public C_AeoiSyoriKbn getDispaeoisyorikbn5() {
        return dispaeoisyorikbn5;
    }

    public void setDispaeoisyorikbn5(C_AeoiSyoriKbn pDispaeoisyorikbn5) {
        dispaeoisyorikbn5 = pDispaeoisyorikbn5;
    }

    private C_AeoiTaisyousyaKbn dispaeoitaisyousyakbn5;

    public C_AeoiTaisyousyaKbn getDispaeoitaisyousyakbn5() {
        return dispaeoitaisyousyakbn5;
    }

    public void setDispaeoitaisyousyakbn5(C_AeoiTaisyousyaKbn pDispaeoitaisyousyakbn5) {
        dispaeoitaisyousyakbn5 = pDispaeoitaisyousyakbn5;
    }

    private C_AeoiHoujinSyuruiKbn dispaeoihoujinsyuruikbn5;

    public C_AeoiHoujinSyuruiKbn getDispaeoihoujinsyuruikbn5() {
        return dispaeoihoujinsyuruikbn5;
    }

    public void setDispaeoihoujinsyuruikbn5(C_AeoiHoujinSyuruiKbn pDispaeoihoujinsyuruikbn5) {
        dispaeoihoujinsyuruikbn5 = pDispaeoihoujinsyuruikbn5;
    }

    @ValidDate
    private BizDate dispaeoikouryokusttymd5;

    public BizDate getDispaeoikouryokusttymd5() {
        return dispaeoikouryokusttymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokusttymd5(BizDate pDispaeoikouryokusttymd5) {
        dispaeoikouryokusttymd5 = pDispaeoikouryokusttymd5;
    }

    @ValidDate
    private BizDate dispaeoikouryokuendymd5;

    public BizDate getDispaeoikouryokuendymd5() {
        return dispaeoikouryokuendymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispaeoikouryokuendymd5(BizDate pDispaeoikouryokuendymd5) {
        dispaeoikouryokuendymd5 = pDispaeoikouryokuendymd5;
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

    private C_Meigihnkjiyuu meigihnkjiyuu;

    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkjiyuu = pMeigihnkjiyuu;
    }

    private String dummykmk1;

    public String getDummykmk1() {
        return dummykmk1;
    }

    public void setDummykmk1(String pDummykmk1) {
        dummykmk1 = pDummykmk1;
    }

    private String dummykmk2;

    public String getDummykmk2() {
        return dummykmk2;
    }

    public void setDummykmk2(String pDummykmk2) {
        dummykmk2 = pDummykmk2;
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

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newkyknmkn;

    public String getNewkyknmkn() {
        return newkyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkyknmkn(String pNewkyknmkn) {
        newkyknmkn = pNewkyknmkn;
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

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newkyknmkj;

    public String getNewkyknmkj() {
        return newkyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkyknmkj(String pNewkyknmkj) {
        newkyknmkj = pNewkyknmkj;
    }

    private Boolean newkyknmkjkhuka;

    public Boolean getNewkyknmkjkhuka() {
        return (newkyknmkjkhuka == null) ? Boolean.FALSE : newkyknmkjkhuka;
    }

    public void setNewkyknmkjkhuka(Boolean pNewkyknmkjkhuka) {
        newkyknmkjkhuka = (pNewkyknmkjkhuka == null) ? Boolean.FALSE : pNewkyknmkjkhuka;
    }

    private C_KjkhukaKbn newkyknmkjkhukakbn;

    public C_KjkhukaKbn getNewkyknmkjkhukakbn() {
        return newkyknmkjkhukakbn;
    }

    public void setNewkyknmkjkhukakbn(C_KjkhukaKbn pNewkyknmkjkhukakbn) {
        newkyknmkjkhukakbn = pNewkyknmkjkhukakbn;
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

    @ValidDate
    private BizDate newkykseiymd;

    public BizDate getNewkykseiymd() {
        return newkykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewkykseiymd(BizDate pNewkykseiymd) {
        newkykseiymd = pNewkykseiymd;
    }

    private C_Kyksei vkykskyksei;

    public C_Kyksei getVkykskyksei() {
        return vkykskyksei;
    }

    public void setVkykskyksei(C_Kyksei pVkykskyksei) {
        vkykskyksei = pVkykskyksei;
    }

    private C_Kyksei newkyksei;

    public C_Kyksei getNewkyksei() {
        return newkyksei;
    }

    public void setNewkyksei(C_Kyksei pNewkyksei) {
        newkyksei = pNewkyksei;
    }

    private C_Tdk vkykskkkyktdk;

    public C_Tdk getVkykskkkyktdk() {
        return vkykskkkyktdk;
    }

    public void setVkykskkkyktdk(C_Tdk pVkykskkkyktdk) {
        vkykskkkyktdk = pVkykskkkyktdk;
    }

    private C_Tdk newkkkyktdk;

    public C_Tdk getNewkkkyktdk() {
        return newkkkyktdk;
    }

    public void setNewkkkyktdk(C_Tdk pNewkkkyktdk) {
        newkkkyktdk = pNewkkkyktdk;
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

    private C_HjndaiykKbn newhjndaiykkbn;

    public C_HjndaiykKbn getNewhjndaiykkbn() {
        return newhjndaiykkbn;
    }

    public void setNewhjndaiykkbn(C_HjndaiykKbn pNewhjndaiykkbn) {
        newhjndaiykkbn = pNewhjndaiykkbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newhjndaiyknm;

    public String getNewhjndaiyknm() {
        return newhjndaiyknm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewhjndaiyknm(String pNewhjndaiyknm) {
        newhjndaiyknm = pNewhjndaiyknm;
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
    @HostInvalidCharacter
    private String newhjndainmkn;

    public String getNewhjndainmkn() {
        return newhjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewhjndainmkn(String pNewhjndainmkn) {
        newhjndainmkn = pNewhjndainmkn;
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

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newhjndainmkj;

    public String getNewhjndainmkj() {
        return newhjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewhjndainmkj(String pNewhjndainmkj) {
        newhjndainmkj = pNewhjndainmkj;
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

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newhhknnmkn;

    public String getNewhhknnmkn() {
        return newhhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewhhknnmkn(String pNewhhknnmkn) {
        newhhknnmkn = pNewhhknnmkn;
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

    private C_KjkhukaKbn vhhkshhknnmkjkhukakbn;

    public C_KjkhukaKbn getVhhkshhknnmkjkhukakbn() {
        return vhhkshhknnmkjkhukakbn;
    }

    public void setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn pVhhkshhknnmkjkhukakbn) {
        vhhkshhknnmkjkhukakbn = pVhhkshhknnmkjkhukakbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newhhknnmkj;

    public String getNewhhknnmkj() {
        return newhhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewhhknnmkj(String pNewhhknnmkj) {
        newhhknnmkj = pNewhhknnmkj;
    }

    private Boolean newhhknnmkjkhuka;

    public Boolean getNewhhknnmkjkhuka() {
        return (newhhknnmkjkhuka == null) ? Boolean.FALSE : newhhknnmkjkhuka;
    }

    public void setNewhhknnmkjkhuka(Boolean pNewhhknnmkjkhuka) {
        newhhknnmkjkhuka = (pNewhhknnmkjkhuka == null) ? Boolean.FALSE : pNewhhknnmkjkhuka;
    }

    private C_KjkhukaKbn newhhknnmkjkhukakbn;

    public C_KjkhukaKbn getNewhhknnmkjkhukakbn() {
        return newhhknnmkjkhukakbn;
    }

    public void setNewhhknnmkjkhukakbn(C_KjkhukaKbn pNewhhknnmkjkhukakbn) {
        newhhknnmkjkhukakbn = pNewhhknnmkjkhukakbn;
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

    private C_Hhknsei vhhkshhknsei;

    public C_Hhknsei getVhhkshhknsei() {
        return vhhkshhknsei;
    }

    public void setVhhkshhknsei(C_Hhknsei pVhhkshhknsei) {
        vhhkshhknsei = pVhhkshhknsei;
    }

    private C_UktKbn vnkuknenkinuktkbn;

    public C_UktKbn getVnkuknenkinuktkbn() {
        return vnkuknenkinuktkbn;
    }

    public void setVnkuknenkinuktkbn(C_UktKbn pVnkuknenkinuktkbn) {
        vnkuknenkinuktkbn = pVnkuknenkinuktkbn;
    }

    private C_UktKbn newnenkinuktkbn;

    public C_UktKbn getNewnenkinuktkbn() {
        return newnenkinuktkbn;
    }

    public void setNewnenkinuktkbn(C_UktKbn pNewnenkinuktkbn) {
        newnenkinuktkbn = pNewnenkinuktkbn;
    }

    private C_UktkaijyoKbn kzuktkaijyokbn;

    public C_UktkaijyoKbn getKzuktkaijyokbn() {
        return kzuktkaijyokbn;
    }

    public void setKzuktkaijyokbn(C_UktkaijyoKbn pKzuktkaijyokbn) {
        kzuktkaijyokbn = pKzuktkaijyokbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String keizknkuktnmkn;

    public String getKeizknkuktnmkn() {
        return keizknkuktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKeizknkuktnmkn(String pKeizknkuktnmkn) {
        keizknkuktnmkn = pKeizknkuktnmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newkzuktnmkn;

    public String getNewkzuktnmkn() {
        return newkzuktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkzuktnmkn(String pNewkzuktnmkn) {
        newkzuktnmkn = pNewkzuktnmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String keizknkuktnmkj;

    public String getKeizknkuktnmkj() {
        return keizknkuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKeizknkuktnmkj(String pKeizknkuktnmkj) {
        keizknkuktnmkj = pKeizknkuktnmkj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newkzuktnmkj;

    public String getNewkzuktnmkj() {
        return newkzuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkzuktnmkj(String pNewkzuktnmkj) {
        newkzuktnmkj = pNewkzuktnmkj;
    }

    @ValidDate
    private BizDate keizknenkiuktseiymd;

    public BizDate getKeizknenkiuktseiymd() {
        return keizknenkiuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeizknenkiuktseiymd(BizDate pKeizknenkiuktseiymd) {
        keizknenkiuktseiymd = pKeizknenkiuktseiymd;
    }

    @ValidDate
    private BizDate newkzuktseiymd;

    public BizDate getNewkzuktseiymd() {
        return newkzuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewkzuktseiymd(BizDate pNewkzuktseiymd) {
        newkzuktseiymd = pNewkzuktseiymd;
    }

    private C_Tdk keizknenkinukttdk;

    public C_Tdk getKeizknenkinukttdk() {
        return keizknenkinukttdk;
    }

    public void setKeizknenkinukttdk(C_Tdk pKeizknenkinukttdk) {
        keizknenkinukttdk = pKeizknenkinukttdk;
    }

    private C_Tdk newkzukttdk;

    public C_Tdk getNewkzukttdk() {
        return newkzukttdk;
    }

    public void setNewkzukttdk(C_Tdk pNewkzukttdk) {
        newkzukttdk = pNewkzukttdk;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbhenkanuktnmkn;

    public String getSbhenkanuktnmkn() {
        return sbhenkanuktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbhenkanuktnmkn(String pSbhenkanuktnmkn) {
        sbhenkanuktnmkn = pSbhenkanuktnmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newsbhenkanuktnmkn;

    public String getNewsbhenkanuktnmkn() {
        return newsbhenkanuktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewsbhenkanuktnmkn(String pNewsbhenkanuktnmkn) {
        newsbhenkanuktnmkn = pNewsbhenkanuktnmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String sbhenkanuktnmkj;

    public String getSbhenkanuktnmkj() {
        return sbhenkanuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbhenkanuktnmkj(String pSbhenkanuktnmkj) {
        sbhenkanuktnmkj = pSbhenkanuktnmkj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newsbhenkanuktnmkj;

    public String getNewsbhenkanuktnmkj() {
        return newsbhenkanuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewsbhenkanuktnmkj(String pNewsbhenkanuktnmkj) {
        newsbhenkanuktnmkj = pNewsbhenkanuktnmkj;
    }

    @ValidDate
    private BizDate sibouhenkankinuktseiymd;

    public BizDate getSibouhenkankinuktseiymd() {
        return sibouhenkankinuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouhenkankinuktseiymd(BizDate pSibouhenkankinuktseiymd) {
        sibouhenkankinuktseiymd = pSibouhenkankinuktseiymd;
    }

    @ValidDate
    private BizDate newsbhenkanuktseiymd;

    public BizDate getNewsbhenkanuktseiymd() {
        return newsbhenkanuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsbhenkanuktseiymd(BizDate pNewsbhenkanuktseiymd) {
        newsbhenkanuktseiymd = pNewsbhenkanuktseiymd;
    }

    private C_Tdk sibouhenkankinukttdk;

    public C_Tdk getSibouhenkankinukttdk() {
        return sibouhenkankinukttdk;
    }

    public void setSibouhenkankinukttdk(C_Tdk pSibouhenkankinukttdk) {
        sibouhenkankinukttdk = pSibouhenkankinukttdk;
    }

    private C_Tdk newsbhenkanukttdk;

    public C_Tdk getNewsbhenkanukttdk() {
        return newsbhenkanukttdk;
    }

    public void setNewsbhenkanukttdk(C_Tdk pNewsbhenkanukttdk) {
        newsbhenkanukttdk = pNewsbhenkanukttdk;
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

    private C_UktkaijyoKbn sbuktkaijyokbn1;

    public C_UktkaijyoKbn getSbuktkaijyokbn1() {
        return sbuktkaijyokbn1;
    }

    public void setSbuktkaijyokbn1(C_UktkaijyoKbn pSbuktkaijyokbn1) {
        sbuktkaijyokbn1 = pSbuktkaijyokbn1;
    }

    private C_UktKbn vshktdispsbuktkbn1;

    public C_UktKbn getVshktdispsbuktkbn1() {
        return vshktdispsbuktkbn1;
    }

    public void setVshktdispsbuktkbn1(C_UktKbn pVshktdispsbuktkbn1) {
        vshktdispsbuktkbn1 = pVshktdispsbuktkbn1;
    }

    private C_UktKbn sbuktkbn1;

    public C_UktKbn getSbuktkbn1() {
        return sbuktkbn1;
    }

    public void setSbuktkbn1(C_UktKbn pSbuktkbn1) {
        sbuktkbn1 = pSbuktkbn1;
    }

    private String vshktdispsbuktnmkn1;

    public String getVshktdispsbuktnmkn1() {
        return vshktdispsbuktnmkn1;
    }

    public void setVshktdispsbuktnmkn1(String pVshktdispsbuktnmkn1) {
        vshktdispsbuktnmkn1 = pVshktdispsbuktnmkn1;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn1;

    public String getSbuktnmkn1() {
        return sbuktnmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn1(String pSbuktnmkn1) {
        sbuktnmkn1 = pSbuktnmkn1;
    }

    private String vshktdispsbuktnmkj1;

    public String getVshktdispsbuktnmkj1() {
        return vshktdispsbuktnmkj1;
    }

    public void setVshktdispsbuktnmkj1(String pVshktdispsbuktnmkj1) {
        vshktdispsbuktnmkj1 = pVshktdispsbuktnmkj1;
    }

    private C_KjkhukaKbn vshktdispsbuktnmkjhukakbn1;

    public C_KjkhukaKbn getVshktdispsbuktnmkjhukakbn1() {
        return vshktdispsbuktnmkjhukakbn1;
    }

    public void setVshktdispsbuktnmkjhukakbn1(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn1) {
        vshktdispsbuktnmkjhukakbn1 = pVshktdispsbuktnmkjhukakbn1;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj1;

    public String getSbuktnmkj1() {
        return sbuktnmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj1(String pSbuktnmkj1) {
        sbuktnmkj1 = pSbuktnmkj1;
    }

    private Boolean sbuktnmkjkhuka1;

    public Boolean getSbuktnmkjkhuka1() {
        return (sbuktnmkjkhuka1 == null) ? Boolean.FALSE : sbuktnmkjkhuka1;
    }

    public void setSbuktnmkjkhuka1(Boolean pSbuktnmkjkhuka1) {
        sbuktnmkjkhuka1 = (pSbuktnmkjkhuka1 == null) ? Boolean.FALSE : pSbuktnmkjkhuka1;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn1;

    public C_KjkhukaKbn getSbuktnmkjhukakbn1() {
        return sbuktnmkjhukakbn1;
    }

    public void setSbuktnmkjhukakbn1(C_KjkhukaKbn pSbuktnmkjhukakbn1) {
        sbuktnmkjhukakbn1 = pSbuktnmkjhukakbn1;
    }

    private BizDate vshktdispsbuktseiymd1;

    public BizDate getVshktdispsbuktseiymd1() {
        return vshktdispsbuktseiymd1;
    }

    public void setVshktdispsbuktseiymd1(BizDate pVshktdispsbuktseiymd1) {
        vshktdispsbuktseiymd1 = pVshktdispsbuktseiymd1;
    }

    @ValidDate
    private BizDate sbuktseiymd1;

    public BizDate getSbuktseiymd1() {
        return sbuktseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd1(BizDate pSbuktseiymd1) {
        sbuktseiymd1 = pSbuktseiymd1;
    }

    private BizNumber vshktdispsbuktbnwari1;

    public BizNumber getVshktdispsbuktbnwari1() {
        return vshktdispsbuktbnwari1;
    }

    public void setVshktdispsbuktbnwari1(BizNumber pVshktdispsbuktbnwari1) {
        vshktdispsbuktbnwari1 = pVshktdispsbuktbnwari1;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber newsbuktbnwari1;

    public BizNumber getNewsbuktbnwari1() {
        return newsbuktbnwari1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsbuktbnwari1(BizNumber pNewsbuktbnwari1) {
        newsbuktbnwari1 = pNewsbuktbnwari1;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn2;

    public C_UktkaijyoKbn getSbuktkaijyokbn2() {
        return sbuktkaijyokbn2;
    }

    public void setSbuktkaijyokbn2(C_UktkaijyoKbn pSbuktkaijyokbn2) {
        sbuktkaijyokbn2 = pSbuktkaijyokbn2;
    }

    private String vshktdispsbuktnmkn2;

    public String getVshktdispsbuktnmkn2() {
        return vshktdispsbuktnmkn2;
    }

    public void setVshktdispsbuktnmkn2(String pVshktdispsbuktnmkn2) {
        vshktdispsbuktnmkn2 = pVshktdispsbuktnmkn2;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn2;

    public String getSbuktnmkn2() {
        return sbuktnmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn2(String pSbuktnmkn2) {
        sbuktnmkn2 = pSbuktnmkn2;
    }

    private String vshktdispsbuktnmkj2;

    public String getVshktdispsbuktnmkj2() {
        return vshktdispsbuktnmkj2;
    }

    public void setVshktdispsbuktnmkj2(String pVshktdispsbuktnmkj2) {
        vshktdispsbuktnmkj2 = pVshktdispsbuktnmkj2;
    }

    private C_KjkhukaKbn vshktdispsbuktnmkjhukakbn2;

    public C_KjkhukaKbn getVshktdispsbuktnmkjhukakbn2() {
        return vshktdispsbuktnmkjhukakbn2;
    }

    public void setVshktdispsbuktnmkjhukakbn2(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn2) {
        vshktdispsbuktnmkjhukakbn2 = pVshktdispsbuktnmkjhukakbn2;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj2;

    public String getSbuktnmkj2() {
        return sbuktnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj2(String pSbuktnmkj2) {
        sbuktnmkj2 = pSbuktnmkj2;
    }

    private Boolean sbuktnmkjkhuka2;

    public Boolean getSbuktnmkjkhuka2() {
        return (sbuktnmkjkhuka2 == null) ? Boolean.FALSE : sbuktnmkjkhuka2;
    }

    public void setSbuktnmkjkhuka2(Boolean pSbuktnmkjkhuka2) {
        sbuktnmkjkhuka2 = (pSbuktnmkjkhuka2 == null) ? Boolean.FALSE : pSbuktnmkjkhuka2;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn2;

    public C_KjkhukaKbn getSbuktnmkjhukakbn2() {
        return sbuktnmkjhukakbn2;
    }

    public void setSbuktnmkjhukakbn2(C_KjkhukaKbn pSbuktnmkjhukakbn2) {
        sbuktnmkjhukakbn2 = pSbuktnmkjhukakbn2;
    }

    private BizDate vshktdispsbuktseiymd2;

    public BizDate getVshktdispsbuktseiymd2() {
        return vshktdispsbuktseiymd2;
    }

    public void setVshktdispsbuktseiymd2(BizDate pVshktdispsbuktseiymd2) {
        vshktdispsbuktseiymd2 = pVshktdispsbuktseiymd2;
    }

    @ValidDate
    private BizDate sbuktseiymd2;

    public BizDate getSbuktseiymd2() {
        return sbuktseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd2(BizDate pSbuktseiymd2) {
        sbuktseiymd2 = pSbuktseiymd2;
    }

    private BizNumber vshktdispsbuktbnwari2;

    public BizNumber getVshktdispsbuktbnwari2() {
        return vshktdispsbuktbnwari2;
    }

    public void setVshktdispsbuktbnwari2(BizNumber pVshktdispsbuktbnwari2) {
        vshktdispsbuktbnwari2 = pVshktdispsbuktbnwari2;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber newsbuktbnwari2;

    public BizNumber getNewsbuktbnwari2() {
        return newsbuktbnwari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsbuktbnwari2(BizNumber pNewsbuktbnwari2) {
        newsbuktbnwari2 = pNewsbuktbnwari2;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn3;

    public C_UktkaijyoKbn getSbuktkaijyokbn3() {
        return sbuktkaijyokbn3;
    }

    public void setSbuktkaijyokbn3(C_UktkaijyoKbn pSbuktkaijyokbn3) {
        sbuktkaijyokbn3 = pSbuktkaijyokbn3;
    }

    private String vshktdispsbuktnmkn3;

    public String getVshktdispsbuktnmkn3() {
        return vshktdispsbuktnmkn3;
    }

    public void setVshktdispsbuktnmkn3(String pVshktdispsbuktnmkn3) {
        vshktdispsbuktnmkn3 = pVshktdispsbuktnmkn3;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn3;

    public String getSbuktnmkn3() {
        return sbuktnmkn3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn3(String pSbuktnmkn3) {
        sbuktnmkn3 = pSbuktnmkn3;
    }

    private String vshktdispsbuktnmkj3;

    public String getVshktdispsbuktnmkj3() {
        return vshktdispsbuktnmkj3;
    }

    public void setVshktdispsbuktnmkj3(String pVshktdispsbuktnmkj3) {
        vshktdispsbuktnmkj3 = pVshktdispsbuktnmkj3;
    }

    private C_KjkhukaKbn vshktdispsbuktnmkjhukakbn3;

    public C_KjkhukaKbn getVshktdispsbuktnmkjhukakbn3() {
        return vshktdispsbuktnmkjhukakbn3;
    }

    public void setVshktdispsbuktnmkjhukakbn3(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn3) {
        vshktdispsbuktnmkjhukakbn3 = pVshktdispsbuktnmkjhukakbn3;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj3;

    public String getSbuktnmkj3() {
        return sbuktnmkj3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj3(String pSbuktnmkj3) {
        sbuktnmkj3 = pSbuktnmkj3;
    }

    private Boolean sbuktnmkjkhuka3;

    public Boolean getSbuktnmkjkhuka3() {
        return (sbuktnmkjkhuka3 == null) ? Boolean.FALSE : sbuktnmkjkhuka3;
    }

    public void setSbuktnmkjkhuka3(Boolean pSbuktnmkjkhuka3) {
        sbuktnmkjkhuka3 = (pSbuktnmkjkhuka3 == null) ? Boolean.FALSE : pSbuktnmkjkhuka3;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn3;

    public C_KjkhukaKbn getSbuktnmkjhukakbn3() {
        return sbuktnmkjhukakbn3;
    }

    public void setSbuktnmkjhukakbn3(C_KjkhukaKbn pSbuktnmkjhukakbn3) {
        sbuktnmkjhukakbn3 = pSbuktnmkjhukakbn3;
    }

    private BizDate vshktdispsbuktseiymd3;

    public BizDate getVshktdispsbuktseiymd3() {
        return vshktdispsbuktseiymd3;
    }

    public void setVshktdispsbuktseiymd3(BizDate pVshktdispsbuktseiymd3) {
        vshktdispsbuktseiymd3 = pVshktdispsbuktseiymd3;
    }

    @ValidDate
    private BizDate sbuktseiymd3;

    public BizDate getSbuktseiymd3() {
        return sbuktseiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd3(BizDate pSbuktseiymd3) {
        sbuktseiymd3 = pSbuktseiymd3;
    }

    private BizNumber vshktdispsbuktbnwari3;

    public BizNumber getVshktdispsbuktbnwari3() {
        return vshktdispsbuktbnwari3;
    }

    public void setVshktdispsbuktbnwari3(BizNumber pVshktdispsbuktbnwari3) {
        vshktdispsbuktbnwari3 = pVshktdispsbuktbnwari3;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber newsbuktbnwari3;

    public BizNumber getNewsbuktbnwari3() {
        return newsbuktbnwari3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsbuktbnwari3(BizNumber pNewsbuktbnwari3) {
        newsbuktbnwari3 = pNewsbuktbnwari3;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn4;

    public C_UktkaijyoKbn getSbuktkaijyokbn4() {
        return sbuktkaijyokbn4;
    }

    public void setSbuktkaijyokbn4(C_UktkaijyoKbn pSbuktkaijyokbn4) {
        sbuktkaijyokbn4 = pSbuktkaijyokbn4;
    }

    private String vshktdispsbuktnmkn4;

    public String getVshktdispsbuktnmkn4() {
        return vshktdispsbuktnmkn4;
    }

    public void setVshktdispsbuktnmkn4(String pVshktdispsbuktnmkn4) {
        vshktdispsbuktnmkn4 = pVshktdispsbuktnmkn4;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn4;

    public String getSbuktnmkn4() {
        return sbuktnmkn4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn4(String pSbuktnmkn4) {
        sbuktnmkn4 = pSbuktnmkn4;
    }

    private String vshktdispsbuktnmkj4;

    public String getVshktdispsbuktnmkj4() {
        return vshktdispsbuktnmkj4;
    }

    public void setVshktdispsbuktnmkj4(String pVshktdispsbuktnmkj4) {
        vshktdispsbuktnmkj4 = pVshktdispsbuktnmkj4;
    }

    private C_KjkhukaKbn vshktdispsbuktnmkjhukakbn4;

    public C_KjkhukaKbn getVshktdispsbuktnmkjhukakbn4() {
        return vshktdispsbuktnmkjhukakbn4;
    }

    public void setVshktdispsbuktnmkjhukakbn4(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn4) {
        vshktdispsbuktnmkjhukakbn4 = pVshktdispsbuktnmkjhukakbn4;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj4;

    public String getSbuktnmkj4() {
        return sbuktnmkj4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj4(String pSbuktnmkj4) {
        sbuktnmkj4 = pSbuktnmkj4;
    }

    private Boolean sbuktnmkjkhuka4;

    public Boolean getSbuktnmkjkhuka4() {
        return (sbuktnmkjkhuka4 == null) ? Boolean.FALSE : sbuktnmkjkhuka4;
    }

    public void setSbuktnmkjkhuka4(Boolean pSbuktnmkjkhuka4) {
        sbuktnmkjkhuka4 = (pSbuktnmkjkhuka4 == null) ? Boolean.FALSE : pSbuktnmkjkhuka4;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn4;

    public C_KjkhukaKbn getSbuktnmkjhukakbn4() {
        return sbuktnmkjhukakbn4;
    }

    public void setSbuktnmkjhukakbn4(C_KjkhukaKbn pSbuktnmkjhukakbn4) {
        sbuktnmkjhukakbn4 = pSbuktnmkjhukakbn4;
    }

    private BizDate vshktdispsbuktseiymd4;

    public BizDate getVshktdispsbuktseiymd4() {
        return vshktdispsbuktseiymd4;
    }

    public void setVshktdispsbuktseiymd4(BizDate pVshktdispsbuktseiymd4) {
        vshktdispsbuktseiymd4 = pVshktdispsbuktseiymd4;
    }

    @ValidDate
    private BizDate sbuktseiymd4;

    public BizDate getSbuktseiymd4() {
        return sbuktseiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd4(BizDate pSbuktseiymd4) {
        sbuktseiymd4 = pSbuktseiymd4;
    }

    private BizNumber vshktdispsbuktbnwari4;

    public BizNumber getVshktdispsbuktbnwari4() {
        return vshktdispsbuktbnwari4;
    }

    public void setVshktdispsbuktbnwari4(BizNumber pVshktdispsbuktbnwari4) {
        vshktdispsbuktbnwari4 = pVshktdispsbuktbnwari4;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber newsbuktbnwari4;

    public BizNumber getNewsbuktbnwari4() {
        return newsbuktbnwari4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsbuktbnwari4(BizNumber pNewsbuktbnwari4) {
        newsbuktbnwari4 = pNewsbuktbnwari4;
    }

    private C_UktkaijyoKbn stdrskkaijyokbn;

    public C_UktkaijyoKbn getStdrskkaijyokbn() {
        return stdrskkaijyokbn;
    }

    public void setStdrskkaijyokbn(C_UktkaijyoKbn pStdrskkaijyokbn) {
        stdrskkaijyokbn = pStdrskkaijyokbn;
    }

    private C_UktKbn vstsksiteidruktkbn;

    public C_UktKbn getVstsksiteidruktkbn() {
        return vstsksiteidruktkbn;
    }

    public void setVstsksiteidruktkbn(C_UktKbn pVstsksiteidruktkbn) {
        vstsksiteidruktkbn = pVstsksiteidruktkbn;
    }

    private C_UktKbn newstdruktkbn;

    public C_UktKbn getNewstdruktkbn() {
        return newstdruktkbn;
    }

    public void setNewstdruktkbn(C_UktKbn pNewstdruktkbn) {
        newstdruktkbn = pNewstdruktkbn;
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

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newstdrsknmkn;

    public String getNewstdrsknmkn() {
        return newstdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewstdrsknmkn(String pNewstdrsknmkn) {
        newstdrsknmkn = pNewstdrsknmkn;
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

    private C_KjkhukaKbn vstskstdrsknmkjhukakbn;

    public C_KjkhukaKbn getVstskstdrsknmkjhukakbn() {
        return vstskstdrsknmkjhukakbn;
    }

    public void setVstskstdrsknmkjhukakbn(C_KjkhukaKbn pVstskstdrsknmkjhukakbn) {
        vstskstdrsknmkjhukakbn = pVstskstdrsknmkjhukakbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newstdrsknmkj;

    public String getNewstdrsknmkj() {
        return newstdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewstdrsknmkj(String pNewstdrsknmkj) {
        newstdrsknmkj = pNewstdrsknmkj;
    }

    private Boolean newstdrsknmkjhuka;

    public Boolean getNewstdrsknmkjhuka() {
        return (newstdrsknmkjhuka == null) ? Boolean.FALSE : newstdrsknmkjhuka;
    }

    public void setNewstdrsknmkjhuka(Boolean pNewstdrsknmkjhuka) {
        newstdrsknmkjhuka = (pNewstdrsknmkjhuka == null) ? Boolean.FALSE : pNewstdrsknmkjhuka;
    }

    private C_KjkhukaKbn newstdrsknmkjhukakbn;

    public C_KjkhukaKbn getNewstdrsknmkjhukakbn() {
        return newstdrsknmkjhukakbn;
    }

    public void setNewstdrsknmkjhukakbn(C_KjkhukaKbn pNewstdrsknmkjhukakbn) {
        newstdrsknmkjhukakbn = pNewstdrsknmkjhukakbn;
    }

    private BizDate vstskstdrskseiymd;

    public BizDate getVstskstdrskseiymd() {
        return vstskstdrskseiymd;
    }

    public void setVstskstdrskseiymd(BizDate pVstskstdrskseiymd) {
        vstskstdrskseiymd = pVstskstdrskseiymd;
    }

    @ValidDate
    private BizDate newstdrskseiymd;

    public BizDate getNewstdrskseiymd() {
        return newstdrskseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewstdrskseiymd(BizDate pNewstdrskseiymd) {
        newstdrskseiymd = pNewstdrskseiymd;
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

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String vtsskdai2tsintelno;

    public String getVtsskdai2tsintelno() {
        return vtsskdai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setVtsskdai2tsintelno(String pVtsskdai2tsintelno) {
        vtsskdai2tsintelno = pVtsskdai2tsintelno;
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

    private String vhtysdisphtysyorui;

    public String getVhtysdisphtysyorui() {
        return vhtysdisphtysyorui;
    }

    public void setVhtysdisphtysyorui(String pVhtysdisphtysyorui) {
        vhtysdisphtysyorui = pVhtysdisphtysyorui;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String shsnmkj;

    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    @Length(length=7)
    @Digit
    private String shskyno;

    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr1kj;

    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr2kj;

    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr3kj;

    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String syoukainomibtn;

    public String getSyoukainomibtn() {
        return syoukainomibtn;
    }

    public void setSyoukainomibtn(String pSyoukainomibtn) {
        syoukainomibtn = pSyoukainomibtn;
    }

    private C_UmuKbn adrhenkouumu;

    public C_UmuKbn getAdrhenkouumu() {
        return adrhenkouumu;
    }

    public void setAdrhenkouumu(C_UmuKbn pAdrhenkouumu) {
        adrhenkouumu = pAdrhenkouumu;
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

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String dai2tsintelno;

    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    @ValidDate
    private BizDate oldkyksibouymd;

    public BizDate getOldkyksibouymd() {
        return oldkyksibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkyksibouymd(BizDate pOldkyksibouymd) {
        oldkyksibouymd = pOldkyksibouymd;
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

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_TyhysakuseiyhKbn tyhysakuseiyhkbn;

    public C_TyhysakuseiyhKbn getTyhysakuseiyhkbn() {
        return tyhysakuseiyhkbn;
    }

    public void setTyhysakuseiyhkbn(C_TyhysakuseiyhKbn pTyhysakuseiyhkbn) {
        tyhysakuseiyhkbn = pTyhysakuseiyhkbn;
    }

    private C_HassouKbn hassoukbn;

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn syorikekkakbn;

    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    private C_SasimodosisakiKbn sasimodosisakikbn;

    public C_SasimodosisakiKbn getSasimodosisakikbn() {
        return sasimodosisakikbn;
    }

    public void setSasimodosisakikbn(C_SasimodosisakiKbn pSasimodosisakikbn) {
        sasimodosisakikbn = pSasimodosisakikbn;
    }

    @ValidTextArea(length=40, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String syanaicommentkh;

    public String getSyanaicommentkh() {
        return syanaicommentkh;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicommentkh(String pSyanaicommentkh) {
        syanaicommentkh = pSyanaicommentkh;
    }
}
