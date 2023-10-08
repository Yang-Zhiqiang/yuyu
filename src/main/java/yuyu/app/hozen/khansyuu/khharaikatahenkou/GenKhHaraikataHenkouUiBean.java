package yuyu.app.hozen.khansyuu.khharaikatahenkou;

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
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_AuthorikakyhKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 払方変更 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhHaraikataHenkouUiBean extends AbstractUiBean {

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

    private DataSource<TbktInfoDataSourceBean> tbktInfoDataSource = new DataSource<>();
    public DataSource<TbktInfoDataSourceBean> getTbktInfoDataSource() {
        return tbktInfoDataSource;
    }

    @Deprecated
    public List<TbktInfoDataSourceBean> getTbktInfo() {
        return tbktInfoDataSource.getDatas();
    }

    public void setTbktInfo(List<TbktInfoDataSourceBean> pTbktInfo) {
        tbktInfoDataSource.setDatas(pTbktInfo);
    }

    private DataSource<KariukekinInfoDataSourceBean> kariukekinInfoDataSource = new DataSource<>();
    public DataSource<KariukekinInfoDataSourceBean> getKariukekinInfoDataSource() {
        return kariukekinInfoDataSource;
    }

    @Deprecated
    public List<KariukekinInfoDataSourceBean> getKariukekinInfo() {
        return kariukekinInfoDataSource.getDatas();
    }

    public void setKariukekinInfo(List<KariukekinInfoDataSourceBean> pKariukekinInfo) {
        kariukekinInfoDataSource.setDatas(pKariukekinInfo);
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

    private String vhsyusyusyouhnnm;

    public String getVhsyusyusyouhnnm() {
        return vhsyusyusyouhnnm;
    }

    public void setVhsyusyusyouhnnm(String pVhsyusyusyouhnnm) {
        vhsyusyusyouhnnm = pVhsyusyusyouhnnm;
    }

    private C_AisyoumeiKbn vhsyuaisyoumeikbn;

    public C_AisyoumeiKbn getVhsyuaisyoumeikbn() {
        return vhsyuaisyoumeikbn;
    }

    public void setVhsyuaisyoumeikbn(C_AisyoumeiKbn pVhsyuaisyoumeikbn) {
        vhsyuaisyoumeikbn = pVhsyuaisyoumeikbn;
    }

    private C_Tuukasyu vhsyusyukyktuukasyu;

    public C_Tuukasyu getVhsyusyukyktuukasyu() {
        return vhsyusyukyktuukasyu;
    }

    public void setVhsyusyukyktuukasyu(C_Tuukasyu pVhsyusyukyktuukasyu) {
        vhsyusyukyktuukasyu = pVhsyusyukyktuukasyu;
    }

    private C_Tuukasyu vhsyusyukykjisiteituukasyu;

    public C_Tuukasyu getVhsyusyukykjisiteituukasyu() {
        return vhsyusyukykjisiteituukasyu;
    }

    public void setVhsyusyukykjisiteituukasyu(C_Tuukasyu pVhsyusyukykjisiteituukasyu) {
        vhsyusyukykjisiteituukasyu = pVhsyusyukykjisiteituukasyu;
    }

    private C_KataKbn vhsyusyukatakbn;

    public C_KataKbn getVhsyusyukatakbn() {
        return vhsyusyukatakbn;
    }

    public void setVhsyusyukatakbn(C_KataKbn pVhsyusyukatakbn) {
        vhsyusyukatakbn = pVhsyusyukatakbn;
    }

    private C_KyhgndkataKbn vhsyusyukyhgndkatakbn;

    public C_KyhgndkataKbn getVhsyusyukyhgndkatakbn() {
        return vhsyusyukyhgndkatakbn;
    }

    public void setVhsyusyukyhgndkatakbn(C_KyhgndkataKbn pVhsyusyukyhgndkatakbn) {
        vhsyusyukyhgndkatakbn = pVhsyusyukyhgndkatakbn;
    }

    private Integer vhsyusyuhhknnen;

    public Integer getVhsyusyuhhknnen() {
        return vhsyusyuhhknnen;
    }

    public void setVhsyusyuhhknnen(Integer pVhsyusyuhhknnen) {
        vhsyusyuhhknnen = pVhsyusyuhhknnen;
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

    private BizDate vhsyugansknnkaisiymd;

    public BizDate getVhsyugansknnkaisiymd() {
        return vhsyugansknnkaisiymd;
    }

    public void setVhsyugansknnkaisiymd(BizDate pVhsyugansknnkaisiymd) {
        vhsyugansknnkaisiymd = pVhsyugansknnkaisiymd;
    }

    private BizDate vhsyusyufktsknnkaisiymd;

    public BizDate getVhsyusyufktsknnkaisiymd() {
        return vhsyusyufktsknnkaisiymd;
    }

    public void setVhsyusyufktsknnkaisiymd(BizDate pVhsyusyufktsknnkaisiymd) {
        vhsyusyufktsknnkaisiymd = pVhsyusyufktsknnkaisiymd;
    }

    private BizDate vhsyuhkgogansknnkaisiymd;

    public BizDate getVhsyuhkgogansknnkaisiymd() {
        return vhsyuhkgogansknnkaisiymd;
    }

    public void setVhsyuhkgogansknnkaisiymd(BizDate pVhsyuhkgogansknnkaisiymd) {
        vhsyuhkgogansknnkaisiymd = pVhsyuhkgogansknnkaisiymd;
    }

    private BizDate vhsyuyendthnkymd;

    public BizDate getVhsyuyendthnkymd() {
        return vhsyuyendthnkymd;
    }

    public void setVhsyuyendthnkymd(BizDate pVhsyuyendthnkymd) {
        vhsyuyendthnkymd = pVhsyuyendthnkymd;
    }

    private BizDate vhsyutmttknitenymd;

    public BizDate getVhsyutmttknitenymd() {
        return vhsyutmttknitenymd;
    }

    public void setVhsyutmttknitenymd(BizDate pVhsyutmttknitenymd) {
        vhsyutmttknitenymd = pVhsyutmttknitenymd;
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

    private C_Sdpd vhsyusdpdkbn;

    public C_Sdpd getVhsyusdpdkbn() {
        return vhsyusdpdkbn;
    }

    public void setVhsyusdpdkbn(C_Sdpd pVhsyusdpdkbn) {
        vhsyusdpdkbn = pVhsyusdpdkbn;
    }

    private C_KihonssyuruiKbn vhsyusyukihonssyuruikbn;

    public C_KihonssyuruiKbn getVhsyusyukihonssyuruikbn() {
        return vhsyusyukihonssyuruikbn;
    }

    public void setVhsyusyukihonssyuruikbn(C_KihonssyuruiKbn pVhsyusyukihonssyuruikbn) {
        vhsyusyukihonssyuruikbn = pVhsyusyukihonssyuruikbn;
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

    private BizCurrency vhsyudispsyutsnshrgndgk;

    public BizCurrency getVhsyudispsyutsnshrgndgk() {
        return vhsyudispsyutsnshrgndgk;
    }

    public void setVhsyudispsyutsnshrgndgk(BizCurrency pVhsyudispsyutsnshrgndgk) {
        vhsyudispsyutsnshrgndgk = pVhsyudispsyutsnshrgndgk;
    }

    private BizCurrency vhsyusyup;

    public BizCurrency getVhsyusyup() {
        return vhsyusyup;
    }

    public void setVhsyusyup(BizCurrency pVhsyusyup) {
        vhsyusyup = pVhsyusyup;
    }

    private BizCurrency vhsyusyukykkjnkngk;

    public BizCurrency getVhsyusyukykkjnkngk() {
        return vhsyusyukykkjnkngk;
    }

    public void setVhsyusyukykkjnkngk(BizCurrency pVhsyusyukykkjnkngk) {
        vhsyusyukykkjnkngk = pVhsyusyukykkjnkngk;
    }

    private BizCurrency vhsyugenzaisbhknkngaku;

    public BizCurrency getVhsyugenzaisbhknkngaku() {
        return vhsyugenzaisbhknkngaku;
    }

    public void setVhsyugenzaisbhknkngaku(BizCurrency pVhsyugenzaisbhknkngaku) {
        vhsyugenzaisbhknkngaku = pVhsyugenzaisbhknkngaku;
    }

    private BizCurrency vhsyusaigaisbhknkngaku;

    public BizCurrency getVhsyusaigaisbhknkngaku() {
        return vhsyusaigaisbhknkngaku;
    }

    public void setVhsyusaigaisbhknkngaku(BizCurrency pVhsyusaigaisbhknkngaku) {
        vhsyusaigaisbhknkngaku = pVhsyusaigaisbhknkngaku;
    }

    @PositiveNumberBizCalcble
    private BizCurrency vhsyusyukihonkyhgk;

    public BizCurrency getVhsyusyukihonkyhgk() {
        return vhsyusyukihonkyhgk;
    }

    public void setVhsyusyukihonkyhgk(BizCurrency pVhsyusyukihonkyhgk) {
        vhsyusyukihonkyhgk = pVhsyusyukihonkyhgk;
    }

    private BizCurrency vhsyusyunextkosgop;

    public BizCurrency getVhsyusyunextkosgop() {
        return vhsyusyunextkosgop;
    }

    public void setVhsyusyunextkosgop(BizCurrency pVhsyusyunextkosgop) {
        vhsyusyunextkosgop = pVhsyusyunextkosgop;
    }

    private C_SyukyhkinkataKbn vhsyusyusyukyhkinkatakbn;

    public C_SyukyhkinkataKbn getVhsyusyusyukyhkinkatakbn() {
        return vhsyusyusyukyhkinkatakbn;
    }

    public void setVhsyusyusyukyhkinkatakbn(C_SyukyhkinkataKbn pVhsyusyusyukyhkinkatakbn) {
        vhsyusyusyukyhkinkatakbn = pVhsyusyusyukyhkinkatakbn;
    }

    private C_6daiLdKbn vhsyusyurokudaildkbn;

    public C_6daiLdKbn getVhsyusyurokudaildkbn() {
        return vhsyusyurokudaildkbn;
    }

    public void setVhsyusyurokudaildkbn(C_6daiLdKbn pVhsyusyurokudaildkbn) {
        vhsyusyurokudaildkbn = pVhsyusyurokudaildkbn;
    }

    private BizCurrency vhsyusyugannyukyhntgk;

    public BizCurrency getVhsyusyugannyukyhntgk() {
        return vhsyusyugannyukyhntgk;
    }

    public void setVhsyusyugannyukyhntgk(BizCurrency pVhsyusyugannyukyhntgk) {
        vhsyusyugannyukyhntgk = pVhsyusyugannyukyhntgk;
    }

    private BizDate vhsyusyushrskgnstartymd;

    public BizDate getVhsyusyushrskgnstartymd() {
        return vhsyusyushrskgnstartymd;
    }

    public void setVhsyusyushrskgnstartymd(BizDate pVhsyusyushrskgnstartymd) {
        vhsyusyushrskgnstartymd = pVhsyusyushrskgnstartymd;
    }

    private BizDate vhsyusyushrskgnendymd;

    public BizDate getVhsyusyushrskgnendymd() {
        return vhsyusyushrskgnendymd;
    }

    public void setVhsyusyushrskgnendymd(BizDate pVhsyusyushrskgnendymd) {
        vhsyusyushrskgnendymd = pVhsyusyushrskgnendymd;
    }

    private BizCurrency vhsyusyushrskgngos;

    public BizCurrency getVhsyusyushrskgngos() {
        return vhsyusyushrskgngos;
    }

    public void setVhsyusyushrskgngos(BizCurrency pVhsyusyushrskgngos) {
        vhsyusyushrskgngos = pVhsyusyushrskgngos;
    }

    private BizDate vhsyusyunkshrstartymd;

    public BizDate getVhsyusyunkshrstartymd() {
        return vhsyusyunkshrstartymd;
    }

    public void setVhsyusyunkshrstartymd(BizDate pVhsyusyunkshrstartymd) {
        vhsyusyunkshrstartymd = pVhsyusyunkshrstartymd;
    }

    private C_Nenkinsyu vhsyusyunnkinsyukbn;

    public C_Nenkinsyu getVhsyusyunnkinsyukbn() {
        return vhsyusyunnkinsyukbn;
    }

    public void setVhsyusyunnkinsyukbn(C_Nenkinsyu pVhsyusyunnkinsyukbn) {
        vhsyusyunnkinsyukbn = pVhsyusyunnkinsyukbn;
    }

    private Integer vhsyusyunenkinkkn;

    public Integer getVhsyusyunenkinkkn() {
        return vhsyusyunenkinkkn;
    }

    public void setVhsyusyunenkinkkn(Integer pVhsyusyunenkinkkn) {
        vhsyusyunenkinkkn = pVhsyusyunenkinkkn;
    }

    private BizCurrency vhsyugenzaitmttkngk;

    public BizCurrency getVhsyugenzaitmttkngk() {
        return vhsyugenzaitmttkngk;
    }

    public void setVhsyugenzaitmttkngk(BizCurrency pVhsyugenzaitmttkngk) {
        vhsyugenzaitmttkngk = pVhsyugenzaitmttkngk;
    }

    private BizCurrency vhsyuteiritutmttkngk;

    public BizCurrency getVhsyuteiritutmttkngk() {
        return vhsyuteiritutmttkngk;
    }

    public void setVhsyuteiritutmttkngk(BizCurrency pVhsyuteiritutmttkngk) {
        vhsyuteiritutmttkngk = pVhsyuteiritutmttkngk;
    }

    private BizNumber vhsyuteiritutmttrate;

    public BizNumber getVhsyuteiritutmttrate() {
        return vhsyuteiritutmttrate;
    }

    public void setVhsyuteiritutmttrate(BizNumber pVhsyuteiritutmttrate) {
        vhsyuteiritutmttrate = pVhsyuteiritutmttrate;
    }

    private BizCurrency vhsyusisuurendoutmttkngk;

    public BizCurrency getVhsyusisuurendoutmttkngk() {
        return vhsyusisuurendoutmttkngk;
    }

    public void setVhsyusisuurendoutmttkngk(BizCurrency pVhsyusisuurendoutmttkngk) {
        vhsyusisuurendoutmttkngk = pVhsyusisuurendoutmttkngk;
    }

    private BizNumber vhsyusisuurendourate;

    public BizNumber getVhsyusisuurendourate() {
        return vhsyusisuurendourate;
    }

    public void setVhsyusisuurendourate(BizNumber pVhsyusisuurendourate) {
        vhsyusisuurendourate = pVhsyusisuurendourate;
    }

    private String vhsyusisuunm;

    public String getVhsyusisuunm() {
        return vhsyusisuunm;
    }

    public void setVhsyusisuunm(String pVhsyusisuunm) {
        vhsyusisuunm = pVhsyusisuunm;
    }

    private BizNumber vhsyusetteibairitu;

    public BizNumber getVhsyusetteibairitu() {
        return vhsyusetteibairitu;
    }

    public void setVhsyusetteibairitu(BizNumber pVhsyusetteibairitu) {
        vhsyusetteibairitu = pVhsyusetteibairitu;
    }

    private BizNumber vhsyuyoteiriritu;

    public BizNumber getVhsyuyoteiriritu() {
        return vhsyuyoteiriritu;
    }

    public void setVhsyuyoteiriritu(BizNumber pVhsyuyoteiriritu) {
        vhsyuyoteiriritu = pVhsyuyoteiriritu;
    }

    private BizNumber vhsyutumitateriritu;

    public BizNumber getVhsyutumitateriritu() {
        return vhsyutumitateriritu;
    }

    public void setVhsyutumitateriritu(BizNumber pVhsyutumitateriritu) {
        vhsyutumitateriritu = pVhsyutumitateriritu;
    }

    private BizNumber vhsyukyktumitateriritu;

    public BizNumber getVhsyukyktumitateriritu() {
        return vhsyukyktumitateriritu;
    }

    @DataConvert("toSingleByte")
    public void setVhsyukyktumitateriritu(BizNumber pVhsyukyktumitateriritu) {
        vhsyukyktumitateriritu = pVhsyukyktumitateriritu;
    }

    private BizNumber vhsyu10nentumitateriritu;

    public BizNumber getVhsyu10nentumitateriritu() {
        return vhsyu10nentumitateriritu;
    }

    @DataConvert("toSingleByte")
    public void setVhsyu10nentumitateriritu(BizNumber pVhsyu10nentumitateriritu) {
        vhsyu10nentumitateriritu = pVhsyu10nentumitateriritu;
    }

    private BizNumber vhsyukyksjkkktyouseiriritu;

    public BizNumber getVhsyukyksjkkktyouseiriritu() {
        return vhsyukyksjkkktyouseiriritu;
    }

    public void setVhsyukyksjkkktyouseiriritu(BizNumber pVhsyukyksjkkktyouseiriritu) {
        vhsyukyksjkkktyouseiriritu = pVhsyukyksjkkktyouseiriritu;
    }

    private BizNumber vhsyuskisjkkktyouseiriritu;

    public BizNumber getVhsyuskisjkkktyouseiriritu() {
        return vhsyuskisjkkktyouseiriritu;
    }

    public void setVhsyuskisjkkktyouseiriritu(BizNumber pVhsyuskisjkkktyouseiriritu) {
        vhsyuskisjkkktyouseiriritu = pVhsyuskisjkkktyouseiriritu;
    }

    private C_Tkjyskgnkkn vhsyusyutkjyskgnkkn;

    public C_Tkjyskgnkkn getVhsyusyutkjyskgnkkn() {
        return vhsyusyutkjyskgnkkn;
    }

    public void setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn pVhsyusyutkjyskgnkkn) {
        vhsyusyutkjyskgnkkn = pVhsyusyutkjyskgnkkn;
    }

    private BizDate vhsyusyutkjyskgnhkndsymd1;

    public BizDate getVhsyusyutkjyskgnhkndsymd1() {
        return vhsyusyutkjyskgnhkndsymd1;
    }

    public void setVhsyusyutkjyskgnhkndsymd1(BizDate pVhsyusyutkjyskgnhkndsymd1) {
        vhsyusyutkjyskgnhkndsymd1 = pVhsyusyutkjyskgnhkndsymd1;
    }

    private BizDate vhsyusyutkjyskgnhkndeymd1;

    public BizDate getVhsyusyutkjyskgnhkndeymd1() {
        return vhsyusyutkjyskgnhkndeymd1;
    }

    public void setVhsyusyutkjyskgnhkndeymd1(BizDate pVhsyusyutkjyskgnhkndeymd1) {
        vhsyusyutkjyskgnhkndeymd1 = pVhsyusyutkjyskgnhkndeymd1;
    }

    private BizCurrency vhsyusyutkjyskgns1;

    public BizCurrency getVhsyusyutkjyskgns1() {
        return vhsyusyutkjyskgns1;
    }

    public void setVhsyusyutkjyskgns1(BizCurrency pVhsyusyutkjyskgns1) {
        vhsyusyutkjyskgns1 = pVhsyusyutkjyskgns1;
    }

    private BizDate vhsyusyutkjyskgnhkndsymd2;

    public BizDate getVhsyusyutkjyskgnhkndsymd2() {
        return vhsyusyutkjyskgnhkndsymd2;
    }

    public void setVhsyusyutkjyskgnhkndsymd2(BizDate pVhsyusyutkjyskgnhkndsymd2) {
        vhsyusyutkjyskgnhkndsymd2 = pVhsyusyutkjyskgnhkndsymd2;
    }

    private BizDate vhsyusyutkjyskgnhkndeymd2;

    public BizDate getVhsyusyutkjyskgnhkndeymd2() {
        return vhsyusyutkjyskgnhkndeymd2;
    }

    public void setVhsyusyutkjyskgnhkndeymd2(BizDate pVhsyusyutkjyskgnhkndeymd2) {
        vhsyusyutkjyskgnhkndeymd2 = pVhsyusyutkjyskgnhkndeymd2;
    }

    private BizCurrency vhsyusyutkjyskgns2;

    public BizCurrency getVhsyusyutkjyskgns2() {
        return vhsyusyutkjyskgns2;
    }

    public void setVhsyusyutkjyskgns2(BizCurrency pVhsyusyutkjyskgns2) {
        vhsyusyutkjyskgns2 = pVhsyusyutkjyskgns2;
    }

    private BizDate vhsyusyutkjyskgnhkndsymd3;

    public BizDate getVhsyusyutkjyskgnhkndsymd3() {
        return vhsyusyutkjyskgnhkndsymd3;
    }

    public void setVhsyusyutkjyskgnhkndsymd3(BizDate pVhsyusyutkjyskgnhkndsymd3) {
        vhsyusyutkjyskgnhkndsymd3 = pVhsyusyutkjyskgnhkndsymd3;
    }

    private BizDate vhsyusyutkjyskgnhkndeymd3;

    public BizDate getVhsyusyutkjyskgnhkndeymd3() {
        return vhsyusyutkjyskgnhkndeymd3;
    }

    public void setVhsyusyutkjyskgnhkndeymd3(BizDate pVhsyusyutkjyskgnhkndeymd3) {
        vhsyusyutkjyskgnhkndeymd3 = pVhsyusyutkjyskgnhkndeymd3;
    }

    private BizCurrency vhsyusyutkjyskgns3;

    public BizCurrency getVhsyusyutkjyskgns3() {
        return vhsyusyutkjyskgns3;
    }

    public void setVhsyusyutkjyskgns3(BizCurrency pVhsyusyutkjyskgns3) {
        vhsyusyutkjyskgns3 = pVhsyusyutkjyskgns3;
    }

    private BizDate vhsyusyutkjyskgnhkndsymd4;

    public BizDate getVhsyusyutkjyskgnhkndsymd4() {
        return vhsyusyutkjyskgnhkndsymd4;
    }

    public void setVhsyusyutkjyskgnhkndsymd4(BizDate pVhsyusyutkjyskgnhkndsymd4) {
        vhsyusyutkjyskgnhkndsymd4 = pVhsyusyutkjyskgnhkndsymd4;
    }

    private BizDate vhsyusyutkjyskgnhkndeymd4;

    public BizDate getVhsyusyutkjyskgnhkndeymd4() {
        return vhsyusyutkjyskgnhkndeymd4;
    }

    public void setVhsyusyutkjyskgnhkndeymd4(BizDate pVhsyusyutkjyskgnhkndeymd4) {
        vhsyusyutkjyskgnhkndeymd4 = pVhsyusyutkjyskgnhkndeymd4;
    }

    private BizCurrency vhsyusyutkjyskgns4;

    public BizCurrency getVhsyusyutkjyskgns4() {
        return vhsyusyutkjyskgns4;
    }

    public void setVhsyusyutkjyskgns4(BizCurrency pVhsyusyutkjyskgns4) {
        vhsyusyutkjyskgns4 = pVhsyusyutkjyskgns4;
    }

    private BizDate vhsyusyutkjyskgnhkndsymd5;

    public BizDate getVhsyusyutkjyskgnhkndsymd5() {
        return vhsyusyutkjyskgnhkndsymd5;
    }

    public void setVhsyusyutkjyskgnhkndsymd5(BizDate pVhsyusyutkjyskgnhkndsymd5) {
        vhsyusyutkjyskgnhkndsymd5 = pVhsyusyutkjyskgnhkndsymd5;
    }

    private BizDate vhsyusyutkjyskgnhkndeymd5;

    public BizDate getVhsyusyutkjyskgnhkndeymd5() {
        return vhsyusyutkjyskgnhkndeymd5;
    }

    public void setVhsyusyutkjyskgnhkndeymd5(BizDate pVhsyusyutkjyskgnhkndeymd5) {
        vhsyusyutkjyskgnhkndeymd5 = pVhsyusyutkjyskgnhkndeymd5;
    }

    private BizCurrency vhsyusyutkjyskgns5;

    public BizCurrency getVhsyusyutkjyskgns5() {
        return vhsyusyutkjyskgns5;
    }

    public void setVhsyusyutkjyskgns5(BizCurrency pVhsyusyutkjyskgns5) {
        vhsyusyutkjyskgns5 = pVhsyusyutkjyskgns5;
    }

    private C_Tkjyhyouten vhsyusyutkjyhyouten;

    public C_Tkjyhyouten getVhsyusyutkjyhyouten() {
        return vhsyusyutkjyhyouten;
    }

    public void setVhsyusyutkjyhyouten(C_Tkjyhyouten pVhsyusyutkjyhyouten) {
        vhsyusyutkjyhyouten = pVhsyusyutkjyhyouten;
    }

    private BizCurrency vhsyusyutkjyp;

    public BizCurrency getVhsyusyutkjyp() {
        return vhsyusyutkjyp;
    }

    public void setVhsyusyutkjyp(BizCurrency pVhsyusyutkjyp) {
        vhsyusyutkjyp = pVhsyusyutkjyp;
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

    private BizCurrency vhsyusyututakngk;

    public BizCurrency getVhsyusyututakngk() {
        return vhsyusyututakngk;
    }

    public void setVhsyusyututakngk(BizCurrency pVhsyusyututakngk) {
        vhsyusyututakngk = pVhsyusyututakngk;
    }

    private BizDate vhsyusyukouryokuhasseiymd;

    public BizDate getVhsyusyukouryokuhasseiymd() {
        return vhsyusyukouryokuhasseiymd;
    }

    public void setVhsyusyukouryokuhasseiymd(BizDate pVhsyusyukouryokuhasseiymd) {
        vhsyusyukouryokuhasseiymd = pVhsyusyukouryokuhasseiymd;
    }

    private String vhsyudisptksyouhnnm;

    public String getVhsyudisptksyouhnnm() {
        return vhsyudisptksyouhnnm;
    }

    public void setVhsyudisptksyouhnnm(String pVhsyudisptksyouhnnm) {
        vhsyudisptksyouhnnm = pVhsyudisptksyouhnnm;
    }

    private C_Nstknsyu vhsyunkshrtkyknksyukbn;

    public C_Nstknsyu getVhsyunkshrtkyknksyukbn() {
        return vhsyunkshrtkyknksyukbn;
    }

    public void setVhsyunkshrtkyknksyukbn(C_Nstknsyu pVhsyunkshrtkyknksyukbn) {
        vhsyunkshrtkyknksyukbn = pVhsyunkshrtkyknksyukbn;
    }

    @Range(min="0", max="99")
    private Integer vhsyunkshrtkyknksyukkn;

    public Integer getVhsyunkshrtkyknksyukkn() {
        return vhsyunkshrtkyknksyukkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVhsyunkshrtkyknksyukkn(Integer pVhsyunkshrtkyknksyukkn) {
        vhsyunkshrtkyknksyukkn = pVhsyunkshrtkyknksyukkn;
    }

    private String vhsyudisptksyouhnnm1;

    public String getVhsyudisptksyouhnnm1() {
        return vhsyudisptksyouhnnm1;
    }

    public void setVhsyudisptksyouhnnm1(String pVhsyudisptksyouhnnm1) {
        vhsyudisptksyouhnnm1 = pVhsyudisptksyouhnnm1;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu1;

    public C_Tuukasyu getVhsyudisptkktuukasyu1() {
        return vhsyudisptkktuukasyu1;
    }

    public void setVhsyudisptkktuukasyu1(C_Tuukasyu pVhsyudisptkktuukasyu1) {
        vhsyudisptkktuukasyu1 = pVhsyudisptkktuukasyu1;
    }

    private C_KataKbn vhsyudisptokyakukatakbn1;

    public C_KataKbn getVhsyudisptokyakukatakbn1() {
        return vhsyudisptokyakukatakbn1;
    }

    public void setVhsyudisptokyakukatakbn1(C_KataKbn pVhsyudisptokyakukatakbn1) {
        vhsyudisptokyakukatakbn1 = pVhsyudisptokyakukatakbn1;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn1;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn1() {
        return vhsyudisptkkyhgdkatakbn1;
    }

    public void setVhsyudisptkkyhgdkatakbn1(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn1) {
        vhsyudisptkkyhgdkatakbn1 = pVhsyudisptkkyhgdkatakbn1;
    }

    private Integer vhsyudisptkhhknnen1;

    public Integer getVhsyudisptkhhknnen1() {
        return vhsyudisptkhhknnen1;
    }

    public void setVhsyudisptkhhknnen1(Integer pVhsyudisptkhhknnen1) {
        vhsyudisptkhhknnen1 = pVhsyudisptkhhknnen1;
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

    private BizDate vhsyudisptkgaskkaisiymd1;

    public BizDate getVhsyudisptkgaskkaisiymd1() {
        return vhsyudisptkgaskkaisiymd1;
    }

    public void setVhsyudisptkgaskkaisiymd1(BizDate pVhsyudisptkgaskkaisiymd1) {
        vhsyudisptkgaskkaisiymd1 = pVhsyudisptkgaskkaisiymd1;
    }

    private BizDate vhsyudisptkhkskkaisiymd1;

    public BizDate getVhsyudisptkhkskkaisiymd1() {
        return vhsyudisptkhkskkaisiymd1;
    }

    public void setVhsyudisptkhkskkaisiymd1(BizDate pVhsyudisptkhkskkaisiymd1) {
        vhsyudisptkhkskkaisiymd1 = pVhsyudisptkhkskkaisiymd1;
    }

    private BizDate vhsyudisptkhkgskksiymd1;

    public BizDate getVhsyudisptkhkgskksiymd1() {
        return vhsyudisptkhkgskksiymd1;
    }

    public void setVhsyudisptkhkgskksiymd1(BizDate pVhsyudisptkhkgskksiymd1) {
        vhsyudisptkhkgskksiymd1 = pVhsyudisptkhkgskksiymd1;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn1;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn1() {
        return vhsyudisptkkihsyuruikbn1;
    }

    public void setVhsyudisptkkihsyuruikbn1(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn1) {
        vhsyudisptkkihsyuruikbn1 = pVhsyudisptkkihsyuruikbn1;
    }

    private BizCurrency vhsyudisptkkihons1;

    public BizCurrency getVhsyudisptkkihons1() {
        return vhsyudisptkkihons1;
    }

    public void setVhsyudisptkkihons1(BizCurrency pVhsyudisptkkihons1) {
        vhsyudisptkkihons1 = pVhsyudisptkkihons1;
    }

    private BizCurrency vhsyudisptktsnshrgndgk1;

    public BizCurrency getVhsyudisptktsnshrgndgk1() {
        return vhsyudisptktsnshrgndgk1;
    }

    public void setVhsyudisptktsnshrgndgk1(BizCurrency pVhsyudisptktsnshrgndgk1) {
        vhsyudisptktsnshrgndgk1 = pVhsyudisptktsnshrgndgk1;
    }

    private BizCurrency vhsyudisptkp1;

    public BizCurrency getVhsyudisptkp1() {
        return vhsyudisptkp1;
    }

    public void setVhsyudisptkp1(BizCurrency pVhsyudisptkp1) {
        vhsyudisptkp1 = pVhsyudisptkp1;
    }

    private BizCurrency vhsyudisptkkihonkyhgk1;

    public BizCurrency getVhsyudisptkkihonkyhgk1() {
        return vhsyudisptkkihonkyhgk1;
    }

    public void setVhsyudisptkkihonkyhgk1(BizCurrency pVhsyudisptkkihonkyhgk1) {
        vhsyudisptkkihonkyhgk1 = pVhsyudisptkkihonkyhgk1;
    }

    private BizCurrency vhsyudisptknextkosgop1;

    public BizCurrency getVhsyudisptknextkosgop1() {
        return vhsyudisptknextkosgop1;
    }

    public void setVhsyudisptknextkosgop1(BizCurrency pVhsyudisptknextkosgop1) {
        vhsyudisptknextkosgop1 = pVhsyudisptknextkosgop1;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn1;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn1() {
        return vhsyudisptksykyhkatakbn1;
    }

    public void setVhsyudisptksykyhkatakbn1(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn1) {
        vhsyudisptksykyhkatakbn1 = pVhsyudisptksykyhkatakbn1;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn1;

    public C_6daiLdKbn getVhsyudisptk6daildkbn1() {
        return vhsyudisptk6daildkbn1;
    }

    public void setVhsyudisptk6daildkbn1(C_6daiLdKbn pVhsyudisptk6daildkbn1) {
        vhsyudisptk6daildkbn1 = pVhsyudisptk6daildkbn1;
    }

    private BizCurrency vhsyudisptkganyukyhntgk1;

    public BizCurrency getVhsyudisptkganyukyhntgk1() {
        return vhsyudisptkganyukyhntgk1;
    }

    public void setVhsyudisptkganyukyhntgk1(BizCurrency pVhsyudisptkganyukyhntgk1) {
        vhsyudisptkganyukyhntgk1 = pVhsyudisptkganyukyhntgk1;
    }

    private BizDate vhsyudisptkshrskgstrymd1;

    public BizDate getVhsyudisptkshrskgstrymd1() {
        return vhsyudisptkshrskgstrymd1;
    }

    public void setVhsyudisptkshrskgstrymd1(BizDate pVhsyudisptkshrskgstrymd1) {
        vhsyudisptkshrskgstrymd1 = pVhsyudisptkshrskgstrymd1;
    }

    private BizDate vhsyudisptkshrskgnedymd1;

    public BizDate getVhsyudisptkshrskgnedymd1() {
        return vhsyudisptkshrskgnedymd1;
    }

    public void setVhsyudisptkshrskgnedymd1(BizDate pVhsyudisptkshrskgnedymd1) {
        vhsyudisptkshrskgnedymd1 = pVhsyudisptkshrskgnedymd1;
    }

    private BizCurrency vhsyudisptkshrskgngos1;

    public BizCurrency getVhsyudisptkshrskgngos1() {
        return vhsyudisptkshrskgngos1;
    }

    public void setVhsyudisptkshrskgngos1(BizCurrency pVhsyudisptkshrskgngos1) {
        vhsyudisptkshrskgngos1 = pVhsyudisptkshrskgngos1;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn1;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn1() {
        return vhsyudisptknenkinsyukbn1;
    }

    public void setVhsyudisptknenkinsyukbn1(C_Nenkinsyu pVhsyudisptknenkinsyukbn1) {
        vhsyudisptknenkinsyukbn1 = pVhsyudisptknenkinsyukbn1;
    }

    private Integer vhsyudisptknenkinkkn1;

    public Integer getVhsyudisptknenkinkkn1() {
        return vhsyudisptknenkinkkn1;
    }

    public void setVhsyudisptknenkinkkn1(Integer pVhsyudisptknenkinkkn1) {
        vhsyudisptknenkinkkn1 = pVhsyudisptknenkinkkn1;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn1;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn1() {
        return vhsyudisptktkjyskgnkkn1;
    }

    public void setVhsyudisptktkjyskgnkkn1(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn1) {
        vhsyudisptktkjyskgnkkn1 = pVhsyudisptktkjyskgnkkn1;
    }

    private BizDate vhsyudisptktkjkhkdsymd11;

    public BizDate getVhsyudisptktkjkhkdsymd11() {
        return vhsyudisptktkjkhkdsymd11;
    }

    public void setVhsyudisptktkjkhkdsymd11(BizDate pVhsyudisptktkjkhkdsymd11) {
        vhsyudisptktkjkhkdsymd11 = pVhsyudisptktkjkhkdsymd11;
    }

    private BizDate vhsyudisptktkjkhkdeymd11;

    public BizDate getVhsyudisptktkjkhkdeymd11() {
        return vhsyudisptktkjkhkdeymd11;
    }

    public void setVhsyudisptktkjkhkdeymd11(BizDate pVhsyudisptktkjkhkdeymd11) {
        vhsyudisptktkjkhkdeymd11 = pVhsyudisptktkjkhkdeymd11;
    }

    private BizCurrency vhsyudisptktkjyskgns11;

    public BizCurrency getVhsyudisptktkjyskgns11() {
        return vhsyudisptktkjyskgns11;
    }

    public void setVhsyudisptktkjyskgns11(BizCurrency pVhsyudisptktkjyskgns11) {
        vhsyudisptktkjyskgns11 = pVhsyudisptktkjyskgns11;
    }

    private BizDate vhsyudisptktkjkhkdsymd21;

    public BizDate getVhsyudisptktkjkhkdsymd21() {
        return vhsyudisptktkjkhkdsymd21;
    }

    public void setVhsyudisptktkjkhkdsymd21(BizDate pVhsyudisptktkjkhkdsymd21) {
        vhsyudisptktkjkhkdsymd21 = pVhsyudisptktkjkhkdsymd21;
    }

    private BizDate vhsyudisptktkjkhkdeymd21;

    public BizDate getVhsyudisptktkjkhkdeymd21() {
        return vhsyudisptktkjkhkdeymd21;
    }

    public void setVhsyudisptktkjkhkdeymd21(BizDate pVhsyudisptktkjkhkdeymd21) {
        vhsyudisptktkjkhkdeymd21 = pVhsyudisptktkjkhkdeymd21;
    }

    private BizCurrency vhsyudisptktkjyskgns21;

    public BizCurrency getVhsyudisptktkjyskgns21() {
        return vhsyudisptktkjyskgns21;
    }

    public void setVhsyudisptktkjyskgns21(BizCurrency pVhsyudisptktkjyskgns21) {
        vhsyudisptktkjyskgns21 = pVhsyudisptktkjyskgns21;
    }

    private BizDate vhsyudisptktkjkhkdsymd31;

    public BizDate getVhsyudisptktkjkhkdsymd31() {
        return vhsyudisptktkjkhkdsymd31;
    }

    public void setVhsyudisptktkjkhkdsymd31(BizDate pVhsyudisptktkjkhkdsymd31) {
        vhsyudisptktkjkhkdsymd31 = pVhsyudisptktkjkhkdsymd31;
    }

    private BizDate vhsyudisptktkjkhkdeymd31;

    public BizDate getVhsyudisptktkjkhkdeymd31() {
        return vhsyudisptktkjkhkdeymd31;
    }

    public void setVhsyudisptktkjkhkdeymd31(BizDate pVhsyudisptktkjkhkdeymd31) {
        vhsyudisptktkjkhkdeymd31 = pVhsyudisptktkjkhkdeymd31;
    }

    private BizCurrency vhsyudisptktkjyskgns31;

    public BizCurrency getVhsyudisptktkjyskgns31() {
        return vhsyudisptktkjyskgns31;
    }

    public void setVhsyudisptktkjyskgns31(BizCurrency pVhsyudisptktkjyskgns31) {
        vhsyudisptktkjyskgns31 = pVhsyudisptktkjyskgns31;
    }

    private BizDate vhsyudisptktkjkhkdsymd41;

    public BizDate getVhsyudisptktkjkhkdsymd41() {
        return vhsyudisptktkjkhkdsymd41;
    }

    public void setVhsyudisptktkjkhkdsymd41(BizDate pVhsyudisptktkjkhkdsymd41) {
        vhsyudisptktkjkhkdsymd41 = pVhsyudisptktkjkhkdsymd41;
    }

    private BizDate vhsyudisptktkjkhkdeymd41;

    public BizDate getVhsyudisptktkjkhkdeymd41() {
        return vhsyudisptktkjkhkdeymd41;
    }

    public void setVhsyudisptktkjkhkdeymd41(BizDate pVhsyudisptktkjkhkdeymd41) {
        vhsyudisptktkjkhkdeymd41 = pVhsyudisptktkjkhkdeymd41;
    }

    private BizCurrency vhsyudisptktkjyskgns41;

    public BizCurrency getVhsyudisptktkjyskgns41() {
        return vhsyudisptktkjyskgns41;
    }

    public void setVhsyudisptktkjyskgns41(BizCurrency pVhsyudisptktkjyskgns41) {
        vhsyudisptktkjyskgns41 = pVhsyudisptktkjyskgns41;
    }

    private BizDate vhsyudisptktkjkhkdsymd51;

    public BizDate getVhsyudisptktkjkhkdsymd51() {
        return vhsyudisptktkjkhkdsymd51;
    }

    public void setVhsyudisptktkjkhkdsymd51(BizDate pVhsyudisptktkjkhkdsymd51) {
        vhsyudisptktkjkhkdsymd51 = pVhsyudisptktkjkhkdsymd51;
    }

    private BizDate vhsyudisptktkjkhkdeymd51;

    public BizDate getVhsyudisptktkjkhkdeymd51() {
        return vhsyudisptktkjkhkdeymd51;
    }

    public void setVhsyudisptktkjkhkdeymd51(BizDate pVhsyudisptktkjkhkdeymd51) {
        vhsyudisptktkjkhkdeymd51 = pVhsyudisptktkjkhkdeymd51;
    }

    private BizCurrency vhsyudisptktkjyskgns51;

    public BizCurrency getVhsyudisptktkjyskgns51() {
        return vhsyudisptktkjyskgns51;
    }

    public void setVhsyudisptktkjyskgns51(BizCurrency pVhsyudisptktkjyskgns51) {
        vhsyudisptktkjyskgns51 = pVhsyudisptktkjyskgns51;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten1;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten1() {
        return vhsyudisptktkjyhyouten1;
    }

    public void setVhsyudisptktkjyhyouten1(C_Tkjyhyouten pVhsyudisptktkjyhyouten1) {
        vhsyudisptktkjyhyouten1 = pVhsyudisptktkjyhyouten1;
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

    private BizCurrency vhsyudisptktutakngk1;

    public BizCurrency getVhsyudisptktutakngk1() {
        return vhsyudisptktutakngk1;
    }

    public void setVhsyudisptktutakngk1(BizCurrency pVhsyudisptktutakngk1) {
        vhsyudisptktutakngk1 = pVhsyudisptktutakngk1;
    }

    private BizDate vhsyudisptkkrkhasseiymd1;

    public BizDate getVhsyudisptkkrkhasseiymd1() {
        return vhsyudisptkkrkhasseiymd1;
    }

    public void setVhsyudisptkkrkhasseiymd1(BizDate pVhsyudisptkkrkhasseiymd1) {
        vhsyudisptkkrkhasseiymd1 = pVhsyudisptkkrkhasseiymd1;
    }

    private String vhsyudisptksyouhnnm2;

    public String getVhsyudisptksyouhnnm2() {
        return vhsyudisptksyouhnnm2;
    }

    public void setVhsyudisptksyouhnnm2(String pVhsyudisptksyouhnnm2) {
        vhsyudisptksyouhnnm2 = pVhsyudisptksyouhnnm2;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu2;

    public C_Tuukasyu getVhsyudisptkktuukasyu2() {
        return vhsyudisptkktuukasyu2;
    }

    public void setVhsyudisptkktuukasyu2(C_Tuukasyu pVhsyudisptkktuukasyu2) {
        vhsyudisptkktuukasyu2 = pVhsyudisptkktuukasyu2;
    }

    private C_KataKbn vhsyudisptokyakukatakbn2;

    public C_KataKbn getVhsyudisptokyakukatakbn2() {
        return vhsyudisptokyakukatakbn2;
    }

    public void setVhsyudisptokyakukatakbn2(C_KataKbn pVhsyudisptokyakukatakbn2) {
        vhsyudisptokyakukatakbn2 = pVhsyudisptokyakukatakbn2;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn2;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn2() {
        return vhsyudisptkkyhgdkatakbn2;
    }

    public void setVhsyudisptkkyhgdkatakbn2(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn2) {
        vhsyudisptkkyhgdkatakbn2 = pVhsyudisptkkyhgdkatakbn2;
    }

    private Integer vhsyudisptkhhknnen2;

    public Integer getVhsyudisptkhhknnen2() {
        return vhsyudisptkhhknnen2;
    }

    public void setVhsyudisptkhhknnen2(Integer pVhsyudisptkhhknnen2) {
        vhsyudisptkhhknnen2 = pVhsyudisptkhhknnen2;
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

    private BizDate vhsyudisptkgaskkaisiymd2;

    public BizDate getVhsyudisptkgaskkaisiymd2() {
        return vhsyudisptkgaskkaisiymd2;
    }

    public void setVhsyudisptkgaskkaisiymd2(BizDate pVhsyudisptkgaskkaisiymd2) {
        vhsyudisptkgaskkaisiymd2 = pVhsyudisptkgaskkaisiymd2;
    }

    private BizDate vhsyudisptkhkskkaisiymd2;

    public BizDate getVhsyudisptkhkskkaisiymd2() {
        return vhsyudisptkhkskkaisiymd2;
    }

    public void setVhsyudisptkhkskkaisiymd2(BizDate pVhsyudisptkhkskkaisiymd2) {
        vhsyudisptkhkskkaisiymd2 = pVhsyudisptkhkskkaisiymd2;
    }

    private BizDate vhsyudisptkhkgskksiymd2;

    public BizDate getVhsyudisptkhkgskksiymd2() {
        return vhsyudisptkhkgskksiymd2;
    }

    public void setVhsyudisptkhkgskksiymd2(BizDate pVhsyudisptkhkgskksiymd2) {
        vhsyudisptkhkgskksiymd2 = pVhsyudisptkhkgskksiymd2;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn2;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn2() {
        return vhsyudisptkkihsyuruikbn2;
    }

    public void setVhsyudisptkkihsyuruikbn2(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn2) {
        vhsyudisptkkihsyuruikbn2 = pVhsyudisptkkihsyuruikbn2;
    }

    private BizCurrency vhsyudisptkkihons2;

    public BizCurrency getVhsyudisptkkihons2() {
        return vhsyudisptkkihons2;
    }

    public void setVhsyudisptkkihons2(BizCurrency pVhsyudisptkkihons2) {
        vhsyudisptkkihons2 = pVhsyudisptkkihons2;
    }

    private BizCurrency vhsyudisptktsnshrgndgk2;

    public BizCurrency getVhsyudisptktsnshrgndgk2() {
        return vhsyudisptktsnshrgndgk2;
    }

    public void setVhsyudisptktsnshrgndgk2(BizCurrency pVhsyudisptktsnshrgndgk2) {
        vhsyudisptktsnshrgndgk2 = pVhsyudisptktsnshrgndgk2;
    }

    private BizCurrency vhsyudisptkp2;

    public BizCurrency getVhsyudisptkp2() {
        return vhsyudisptkp2;
    }

    public void setVhsyudisptkp2(BizCurrency pVhsyudisptkp2) {
        vhsyudisptkp2 = pVhsyudisptkp2;
    }

    private BizCurrency vhsyudisptkkihonkyhgk2;

    public BizCurrency getVhsyudisptkkihonkyhgk2() {
        return vhsyudisptkkihonkyhgk2;
    }

    public void setVhsyudisptkkihonkyhgk2(BizCurrency pVhsyudisptkkihonkyhgk2) {
        vhsyudisptkkihonkyhgk2 = pVhsyudisptkkihonkyhgk2;
    }

    private BizCurrency vhsyudisptknextkosgop2;

    public BizCurrency getVhsyudisptknextkosgop2() {
        return vhsyudisptknextkosgop2;
    }

    public void setVhsyudisptknextkosgop2(BizCurrency pVhsyudisptknextkosgop2) {
        vhsyudisptknextkosgop2 = pVhsyudisptknextkosgop2;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn2;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn2() {
        return vhsyudisptksykyhkatakbn2;
    }

    public void setVhsyudisptksykyhkatakbn2(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn2) {
        vhsyudisptksykyhkatakbn2 = pVhsyudisptksykyhkatakbn2;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn2;

    public C_6daiLdKbn getVhsyudisptk6daildkbn2() {
        return vhsyudisptk6daildkbn2;
    }

    public void setVhsyudisptk6daildkbn2(C_6daiLdKbn pVhsyudisptk6daildkbn2) {
        vhsyudisptk6daildkbn2 = pVhsyudisptk6daildkbn2;
    }

    private BizCurrency vhsyudisptkganyukyhntgk2;

    public BizCurrency getVhsyudisptkganyukyhntgk2() {
        return vhsyudisptkganyukyhntgk2;
    }

    public void setVhsyudisptkganyukyhntgk2(BizCurrency pVhsyudisptkganyukyhntgk2) {
        vhsyudisptkganyukyhntgk2 = pVhsyudisptkganyukyhntgk2;
    }

    private BizDate vhsyudisptkshrskgstrymd2;

    public BizDate getVhsyudisptkshrskgstrymd2() {
        return vhsyudisptkshrskgstrymd2;
    }

    public void setVhsyudisptkshrskgstrymd2(BizDate pVhsyudisptkshrskgstrymd2) {
        vhsyudisptkshrskgstrymd2 = pVhsyudisptkshrskgstrymd2;
    }

    private BizDate vhsyudisptkshrskgnedymd2;

    public BizDate getVhsyudisptkshrskgnedymd2() {
        return vhsyudisptkshrskgnedymd2;
    }

    public void setVhsyudisptkshrskgnedymd2(BizDate pVhsyudisptkshrskgnedymd2) {
        vhsyudisptkshrskgnedymd2 = pVhsyudisptkshrskgnedymd2;
    }

    private BizCurrency vhsyudisptkshrskgngos2;

    public BizCurrency getVhsyudisptkshrskgngos2() {
        return vhsyudisptkshrskgngos2;
    }

    public void setVhsyudisptkshrskgngos2(BizCurrency pVhsyudisptkshrskgngos2) {
        vhsyudisptkshrskgngos2 = pVhsyudisptkshrskgngos2;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn2;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn2() {
        return vhsyudisptknenkinsyukbn2;
    }

    public void setVhsyudisptknenkinsyukbn2(C_Nenkinsyu pVhsyudisptknenkinsyukbn2) {
        vhsyudisptknenkinsyukbn2 = pVhsyudisptknenkinsyukbn2;
    }

    private Integer vhsyudisptknenkinkkn2;

    public Integer getVhsyudisptknenkinkkn2() {
        return vhsyudisptknenkinkkn2;
    }

    public void setVhsyudisptknenkinkkn2(Integer pVhsyudisptknenkinkkn2) {
        vhsyudisptknenkinkkn2 = pVhsyudisptknenkinkkn2;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn2;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn2() {
        return vhsyudisptktkjyskgnkkn2;
    }

    public void setVhsyudisptktkjyskgnkkn2(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn2) {
        vhsyudisptktkjyskgnkkn2 = pVhsyudisptktkjyskgnkkn2;
    }

    private BizDate vhsyudisptktkjkhkdsymd12;

    public BizDate getVhsyudisptktkjkhkdsymd12() {
        return vhsyudisptktkjkhkdsymd12;
    }

    public void setVhsyudisptktkjkhkdsymd12(BizDate pVhsyudisptktkjkhkdsymd12) {
        vhsyudisptktkjkhkdsymd12 = pVhsyudisptktkjkhkdsymd12;
    }

    private BizDate vhsyudisptktkjkhkdeymd12;

    public BizDate getVhsyudisptktkjkhkdeymd12() {
        return vhsyudisptktkjkhkdeymd12;
    }

    public void setVhsyudisptktkjkhkdeymd12(BizDate pVhsyudisptktkjkhkdeymd12) {
        vhsyudisptktkjkhkdeymd12 = pVhsyudisptktkjkhkdeymd12;
    }

    private BizCurrency vhsyudisptktkjyskgns12;

    public BizCurrency getVhsyudisptktkjyskgns12() {
        return vhsyudisptktkjyskgns12;
    }

    public void setVhsyudisptktkjyskgns12(BizCurrency pVhsyudisptktkjyskgns12) {
        vhsyudisptktkjyskgns12 = pVhsyudisptktkjyskgns12;
    }

    private BizDate vhsyudisptktkjkhkdsymd22;

    public BizDate getVhsyudisptktkjkhkdsymd22() {
        return vhsyudisptktkjkhkdsymd22;
    }

    public void setVhsyudisptktkjkhkdsymd22(BizDate pVhsyudisptktkjkhkdsymd22) {
        vhsyudisptktkjkhkdsymd22 = pVhsyudisptktkjkhkdsymd22;
    }

    private BizDate vhsyudisptktkjkhkdeymd22;

    public BizDate getVhsyudisptktkjkhkdeymd22() {
        return vhsyudisptktkjkhkdeymd22;
    }

    public void setVhsyudisptktkjkhkdeymd22(BizDate pVhsyudisptktkjkhkdeymd22) {
        vhsyudisptktkjkhkdeymd22 = pVhsyudisptktkjkhkdeymd22;
    }

    private BizCurrency vhsyudisptktkjyskgns22;

    public BizCurrency getVhsyudisptktkjyskgns22() {
        return vhsyudisptktkjyskgns22;
    }

    public void setVhsyudisptktkjyskgns22(BizCurrency pVhsyudisptktkjyskgns22) {
        vhsyudisptktkjyskgns22 = pVhsyudisptktkjyskgns22;
    }

    private BizDate vhsyudisptktkjkhkdsymd32;

    public BizDate getVhsyudisptktkjkhkdsymd32() {
        return vhsyudisptktkjkhkdsymd32;
    }

    public void setVhsyudisptktkjkhkdsymd32(BizDate pVhsyudisptktkjkhkdsymd32) {
        vhsyudisptktkjkhkdsymd32 = pVhsyudisptktkjkhkdsymd32;
    }

    private BizDate vhsyudisptktkjkhkdeymd32;

    public BizDate getVhsyudisptktkjkhkdeymd32() {
        return vhsyudisptktkjkhkdeymd32;
    }

    public void setVhsyudisptktkjkhkdeymd32(BizDate pVhsyudisptktkjkhkdeymd32) {
        vhsyudisptktkjkhkdeymd32 = pVhsyudisptktkjkhkdeymd32;
    }

    private BizCurrency vhsyudisptktkjyskgns32;

    public BizCurrency getVhsyudisptktkjyskgns32() {
        return vhsyudisptktkjyskgns32;
    }

    public void setVhsyudisptktkjyskgns32(BizCurrency pVhsyudisptktkjyskgns32) {
        vhsyudisptktkjyskgns32 = pVhsyudisptktkjyskgns32;
    }

    private BizDate vhsyudisptktkjkhkdsymd42;

    public BizDate getVhsyudisptktkjkhkdsymd42() {
        return vhsyudisptktkjkhkdsymd42;
    }

    public void setVhsyudisptktkjkhkdsymd42(BizDate pVhsyudisptktkjkhkdsymd42) {
        vhsyudisptktkjkhkdsymd42 = pVhsyudisptktkjkhkdsymd42;
    }

    private BizDate vhsyudisptktkjkhkdeymd42;

    public BizDate getVhsyudisptktkjkhkdeymd42() {
        return vhsyudisptktkjkhkdeymd42;
    }

    public void setVhsyudisptktkjkhkdeymd42(BizDate pVhsyudisptktkjkhkdeymd42) {
        vhsyudisptktkjkhkdeymd42 = pVhsyudisptktkjkhkdeymd42;
    }

    private BizCurrency vhsyudisptktkjyskgns42;

    public BizCurrency getVhsyudisptktkjyskgns42() {
        return vhsyudisptktkjyskgns42;
    }

    public void setVhsyudisptktkjyskgns42(BizCurrency pVhsyudisptktkjyskgns42) {
        vhsyudisptktkjyskgns42 = pVhsyudisptktkjyskgns42;
    }

    private BizDate vhsyudisptktkjkhkdsymd52;

    public BizDate getVhsyudisptktkjkhkdsymd52() {
        return vhsyudisptktkjkhkdsymd52;
    }

    public void setVhsyudisptktkjkhkdsymd52(BizDate pVhsyudisptktkjkhkdsymd52) {
        vhsyudisptktkjkhkdsymd52 = pVhsyudisptktkjkhkdsymd52;
    }

    private BizDate vhsyudisptktkjkhkdeymd52;

    public BizDate getVhsyudisptktkjkhkdeymd52() {
        return vhsyudisptktkjkhkdeymd52;
    }

    public void setVhsyudisptktkjkhkdeymd52(BizDate pVhsyudisptktkjkhkdeymd52) {
        vhsyudisptktkjkhkdeymd52 = pVhsyudisptktkjkhkdeymd52;
    }

    private BizCurrency vhsyudisptktkjyskgns52;

    public BizCurrency getVhsyudisptktkjyskgns52() {
        return vhsyudisptktkjyskgns52;
    }

    public void setVhsyudisptktkjyskgns52(BizCurrency pVhsyudisptktkjyskgns52) {
        vhsyudisptktkjyskgns52 = pVhsyudisptktkjyskgns52;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten2;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten2() {
        return vhsyudisptktkjyhyouten2;
    }

    public void setVhsyudisptktkjyhyouten2(C_Tkjyhyouten pVhsyudisptktkjyhyouten2) {
        vhsyudisptktkjyhyouten2 = pVhsyudisptktkjyhyouten2;
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

    private BizCurrency vhsyudisptktutakngk2;

    public BizCurrency getVhsyudisptktutakngk2() {
        return vhsyudisptktutakngk2;
    }

    public void setVhsyudisptktutakngk2(BizCurrency pVhsyudisptktutakngk2) {
        vhsyudisptktutakngk2 = pVhsyudisptktutakngk2;
    }

    private BizDate vhsyudisptkkrkhasseiymd2;

    public BizDate getVhsyudisptkkrkhasseiymd2() {
        return vhsyudisptkkrkhasseiymd2;
    }

    public void setVhsyudisptkkrkhasseiymd2(BizDate pVhsyudisptkkrkhasseiymd2) {
        vhsyudisptkkrkhasseiymd2 = pVhsyudisptkkrkhasseiymd2;
    }

    private String vhsyudisptksyouhnnm3;

    public String getVhsyudisptksyouhnnm3() {
        return vhsyudisptksyouhnnm3;
    }

    public void setVhsyudisptksyouhnnm3(String pVhsyudisptksyouhnnm3) {
        vhsyudisptksyouhnnm3 = pVhsyudisptksyouhnnm3;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu3;

    public C_Tuukasyu getVhsyudisptkktuukasyu3() {
        return vhsyudisptkktuukasyu3;
    }

    public void setVhsyudisptkktuukasyu3(C_Tuukasyu pVhsyudisptkktuukasyu3) {
        vhsyudisptkktuukasyu3 = pVhsyudisptkktuukasyu3;
    }

    private C_KataKbn vhsyudisptokyakukatakbn3;

    public C_KataKbn getVhsyudisptokyakukatakbn3() {
        return vhsyudisptokyakukatakbn3;
    }

    public void setVhsyudisptokyakukatakbn3(C_KataKbn pVhsyudisptokyakukatakbn3) {
        vhsyudisptokyakukatakbn3 = pVhsyudisptokyakukatakbn3;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn3;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn3() {
        return vhsyudisptkkyhgdkatakbn3;
    }

    public void setVhsyudisptkkyhgdkatakbn3(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn3) {
        vhsyudisptkkyhgdkatakbn3 = pVhsyudisptkkyhgdkatakbn3;
    }

    private Integer vhsyudisptkhhknnen3;

    public Integer getVhsyudisptkhhknnen3() {
        return vhsyudisptkhhknnen3;
    }

    public void setVhsyudisptkhhknnen3(Integer pVhsyudisptkhhknnen3) {
        vhsyudisptkhhknnen3 = pVhsyudisptkhhknnen3;
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

    private BizDate vhsyudisptkgaskkaisiymd3;

    public BizDate getVhsyudisptkgaskkaisiymd3() {
        return vhsyudisptkgaskkaisiymd3;
    }

    public void setVhsyudisptkgaskkaisiymd3(BizDate pVhsyudisptkgaskkaisiymd3) {
        vhsyudisptkgaskkaisiymd3 = pVhsyudisptkgaskkaisiymd3;
    }

    private BizDate vhsyudisptkhkskkaisiymd3;

    public BizDate getVhsyudisptkhkskkaisiymd3() {
        return vhsyudisptkhkskkaisiymd3;
    }

    public void setVhsyudisptkhkskkaisiymd3(BizDate pVhsyudisptkhkskkaisiymd3) {
        vhsyudisptkhkskkaisiymd3 = pVhsyudisptkhkskkaisiymd3;
    }

    private BizDate vhsyudisptkhkgskksiymd3;

    public BizDate getVhsyudisptkhkgskksiymd3() {
        return vhsyudisptkhkgskksiymd3;
    }

    public void setVhsyudisptkhkgskksiymd3(BizDate pVhsyudisptkhkgskksiymd3) {
        vhsyudisptkhkgskksiymd3 = pVhsyudisptkhkgskksiymd3;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn3;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn3() {
        return vhsyudisptkkihsyuruikbn3;
    }

    public void setVhsyudisptkkihsyuruikbn3(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn3) {
        vhsyudisptkkihsyuruikbn3 = pVhsyudisptkkihsyuruikbn3;
    }

    private BizCurrency vhsyudisptkkihons3;

    public BizCurrency getVhsyudisptkkihons3() {
        return vhsyudisptkkihons3;
    }

    public void setVhsyudisptkkihons3(BizCurrency pVhsyudisptkkihons3) {
        vhsyudisptkkihons3 = pVhsyudisptkkihons3;
    }

    private BizCurrency vhsyudisptktsnshrgndgk3;

    public BizCurrency getVhsyudisptktsnshrgndgk3() {
        return vhsyudisptktsnshrgndgk3;
    }

    public void setVhsyudisptktsnshrgndgk3(BizCurrency pVhsyudisptktsnshrgndgk3) {
        vhsyudisptktsnshrgndgk3 = pVhsyudisptktsnshrgndgk3;
    }

    private BizCurrency vhsyudisptkp3;

    public BizCurrency getVhsyudisptkp3() {
        return vhsyudisptkp3;
    }

    public void setVhsyudisptkp3(BizCurrency pVhsyudisptkp3) {
        vhsyudisptkp3 = pVhsyudisptkp3;
    }

    private BizCurrency vhsyudisptkkihonkyhgk3;

    public BizCurrency getVhsyudisptkkihonkyhgk3() {
        return vhsyudisptkkihonkyhgk3;
    }

    public void setVhsyudisptkkihonkyhgk3(BizCurrency pVhsyudisptkkihonkyhgk3) {
        vhsyudisptkkihonkyhgk3 = pVhsyudisptkkihonkyhgk3;
    }

    private BizCurrency vhsyudisptknextkosgop3;

    public BizCurrency getVhsyudisptknextkosgop3() {
        return vhsyudisptknextkosgop3;
    }

    public void setVhsyudisptknextkosgop3(BizCurrency pVhsyudisptknextkosgop3) {
        vhsyudisptknextkosgop3 = pVhsyudisptknextkosgop3;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn3;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn3() {
        return vhsyudisptksykyhkatakbn3;
    }

    public void setVhsyudisptksykyhkatakbn3(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn3) {
        vhsyudisptksykyhkatakbn3 = pVhsyudisptksykyhkatakbn3;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn3;

    public C_6daiLdKbn getVhsyudisptk6daildkbn3() {
        return vhsyudisptk6daildkbn3;
    }

    public void setVhsyudisptk6daildkbn3(C_6daiLdKbn pVhsyudisptk6daildkbn3) {
        vhsyudisptk6daildkbn3 = pVhsyudisptk6daildkbn3;
    }

    private BizCurrency vhsyudisptkganyukyhntgk3;

    public BizCurrency getVhsyudisptkganyukyhntgk3() {
        return vhsyudisptkganyukyhntgk3;
    }

    public void setVhsyudisptkganyukyhntgk3(BizCurrency pVhsyudisptkganyukyhntgk3) {
        vhsyudisptkganyukyhntgk3 = pVhsyudisptkganyukyhntgk3;
    }

    private BizDate vhsyudisptkshrskgstrymd3;

    public BizDate getVhsyudisptkshrskgstrymd3() {
        return vhsyudisptkshrskgstrymd3;
    }

    public void setVhsyudisptkshrskgstrymd3(BizDate pVhsyudisptkshrskgstrymd3) {
        vhsyudisptkshrskgstrymd3 = pVhsyudisptkshrskgstrymd3;
    }

    private BizDate vhsyudisptkshrskgnedymd3;

    public BizDate getVhsyudisptkshrskgnedymd3() {
        return vhsyudisptkshrskgnedymd3;
    }

    public void setVhsyudisptkshrskgnedymd3(BizDate pVhsyudisptkshrskgnedymd3) {
        vhsyudisptkshrskgnedymd3 = pVhsyudisptkshrskgnedymd3;
    }

    private BizCurrency vhsyudisptkshrskgngos3;

    public BizCurrency getVhsyudisptkshrskgngos3() {
        return vhsyudisptkshrskgngos3;
    }

    public void setVhsyudisptkshrskgngos3(BizCurrency pVhsyudisptkshrskgngos3) {
        vhsyudisptkshrskgngos3 = pVhsyudisptkshrskgngos3;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn3;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn3() {
        return vhsyudisptknenkinsyukbn3;
    }

    public void setVhsyudisptknenkinsyukbn3(C_Nenkinsyu pVhsyudisptknenkinsyukbn3) {
        vhsyudisptknenkinsyukbn3 = pVhsyudisptknenkinsyukbn3;
    }

    private Integer vhsyudisptknenkinkkn3;

    public Integer getVhsyudisptknenkinkkn3() {
        return vhsyudisptknenkinkkn3;
    }

    public void setVhsyudisptknenkinkkn3(Integer pVhsyudisptknenkinkkn3) {
        vhsyudisptknenkinkkn3 = pVhsyudisptknenkinkkn3;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn3;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn3() {
        return vhsyudisptktkjyskgnkkn3;
    }

    public void setVhsyudisptktkjyskgnkkn3(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn3) {
        vhsyudisptktkjyskgnkkn3 = pVhsyudisptktkjyskgnkkn3;
    }

    private BizDate vhsyudisptktkjkhkdsymd13;

    public BizDate getVhsyudisptktkjkhkdsymd13() {
        return vhsyudisptktkjkhkdsymd13;
    }

    public void setVhsyudisptktkjkhkdsymd13(BizDate pVhsyudisptktkjkhkdsymd13) {
        vhsyudisptktkjkhkdsymd13 = pVhsyudisptktkjkhkdsymd13;
    }

    private BizDate vhsyudisptktkjkhkdeymd13;

    public BizDate getVhsyudisptktkjkhkdeymd13() {
        return vhsyudisptktkjkhkdeymd13;
    }

    public void setVhsyudisptktkjkhkdeymd13(BizDate pVhsyudisptktkjkhkdeymd13) {
        vhsyudisptktkjkhkdeymd13 = pVhsyudisptktkjkhkdeymd13;
    }

    private BizCurrency vhsyudisptktkjyskgns13;

    public BizCurrency getVhsyudisptktkjyskgns13() {
        return vhsyudisptktkjyskgns13;
    }

    public void setVhsyudisptktkjyskgns13(BizCurrency pVhsyudisptktkjyskgns13) {
        vhsyudisptktkjyskgns13 = pVhsyudisptktkjyskgns13;
    }

    private BizDate vhsyudisptktkjkhkdsymd23;

    public BizDate getVhsyudisptktkjkhkdsymd23() {
        return vhsyudisptktkjkhkdsymd23;
    }

    public void setVhsyudisptktkjkhkdsymd23(BizDate pVhsyudisptktkjkhkdsymd23) {
        vhsyudisptktkjkhkdsymd23 = pVhsyudisptktkjkhkdsymd23;
    }

    private BizDate vhsyudisptktkjkhkdeymd23;

    public BizDate getVhsyudisptktkjkhkdeymd23() {
        return vhsyudisptktkjkhkdeymd23;
    }

    public void setVhsyudisptktkjkhkdeymd23(BizDate pVhsyudisptktkjkhkdeymd23) {
        vhsyudisptktkjkhkdeymd23 = pVhsyudisptktkjkhkdeymd23;
    }

    private BizCurrency vhsyudisptktkjyskgns23;

    public BizCurrency getVhsyudisptktkjyskgns23() {
        return vhsyudisptktkjyskgns23;
    }

    public void setVhsyudisptktkjyskgns23(BizCurrency pVhsyudisptktkjyskgns23) {
        vhsyudisptktkjyskgns23 = pVhsyudisptktkjyskgns23;
    }

    private BizDate vhsyudisptktkjkhkdsymd33;

    public BizDate getVhsyudisptktkjkhkdsymd33() {
        return vhsyudisptktkjkhkdsymd33;
    }

    public void setVhsyudisptktkjkhkdsymd33(BizDate pVhsyudisptktkjkhkdsymd33) {
        vhsyudisptktkjkhkdsymd33 = pVhsyudisptktkjkhkdsymd33;
    }

    private BizDate vhsyudisptktkjkhkdeymd33;

    public BizDate getVhsyudisptktkjkhkdeymd33() {
        return vhsyudisptktkjkhkdeymd33;
    }

    public void setVhsyudisptktkjkhkdeymd33(BizDate pVhsyudisptktkjkhkdeymd33) {
        vhsyudisptktkjkhkdeymd33 = pVhsyudisptktkjkhkdeymd33;
    }

    private BizCurrency vhsyudisptktkjyskgns33;

    public BizCurrency getVhsyudisptktkjyskgns33() {
        return vhsyudisptktkjyskgns33;
    }

    public void setVhsyudisptktkjyskgns33(BizCurrency pVhsyudisptktkjyskgns33) {
        vhsyudisptktkjyskgns33 = pVhsyudisptktkjyskgns33;
    }

    private BizDate vhsyudisptktkjkhkdsymd43;

    public BizDate getVhsyudisptktkjkhkdsymd43() {
        return vhsyudisptktkjkhkdsymd43;
    }

    public void setVhsyudisptktkjkhkdsymd43(BizDate pVhsyudisptktkjkhkdsymd43) {
        vhsyudisptktkjkhkdsymd43 = pVhsyudisptktkjkhkdsymd43;
    }

    private BizDate vhsyudisptktkjkhkdeymd43;

    public BizDate getVhsyudisptktkjkhkdeymd43() {
        return vhsyudisptktkjkhkdeymd43;
    }

    public void setVhsyudisptktkjkhkdeymd43(BizDate pVhsyudisptktkjkhkdeymd43) {
        vhsyudisptktkjkhkdeymd43 = pVhsyudisptktkjkhkdeymd43;
    }

    private BizCurrency vhsyudisptktkjyskgns43;

    public BizCurrency getVhsyudisptktkjyskgns43() {
        return vhsyudisptktkjyskgns43;
    }

    public void setVhsyudisptktkjyskgns43(BizCurrency pVhsyudisptktkjyskgns43) {
        vhsyudisptktkjyskgns43 = pVhsyudisptktkjyskgns43;
    }

    private BizDate vhsyudisptktkjkhkdsymd53;

    public BizDate getVhsyudisptktkjkhkdsymd53() {
        return vhsyudisptktkjkhkdsymd53;
    }

    public void setVhsyudisptktkjkhkdsymd53(BizDate pVhsyudisptktkjkhkdsymd53) {
        vhsyudisptktkjkhkdsymd53 = pVhsyudisptktkjkhkdsymd53;
    }

    private BizDate vhsyudisptktkjkhkdeymd53;

    public BizDate getVhsyudisptktkjkhkdeymd53() {
        return vhsyudisptktkjkhkdeymd53;
    }

    public void setVhsyudisptktkjkhkdeymd53(BizDate pVhsyudisptktkjkhkdeymd53) {
        vhsyudisptktkjkhkdeymd53 = pVhsyudisptktkjkhkdeymd53;
    }

    private BizCurrency vhsyudisptktkjyskgns53;

    public BizCurrency getVhsyudisptktkjyskgns53() {
        return vhsyudisptktkjyskgns53;
    }

    public void setVhsyudisptktkjyskgns53(BizCurrency pVhsyudisptktkjyskgns53) {
        vhsyudisptktkjyskgns53 = pVhsyudisptktkjyskgns53;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten3;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten3() {
        return vhsyudisptktkjyhyouten3;
    }

    public void setVhsyudisptktkjyhyouten3(C_Tkjyhyouten pVhsyudisptktkjyhyouten3) {
        vhsyudisptktkjyhyouten3 = pVhsyudisptktkjyhyouten3;
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

    private BizCurrency vhsyudisptktutakngk3;

    public BizCurrency getVhsyudisptktutakngk3() {
        return vhsyudisptktutakngk3;
    }

    public void setVhsyudisptktutakngk3(BizCurrency pVhsyudisptktutakngk3) {
        vhsyudisptktutakngk3 = pVhsyudisptktutakngk3;
    }

    private BizDate vhsyudisptkkrkhasseiymd3;

    public BizDate getVhsyudisptkkrkhasseiymd3() {
        return vhsyudisptkkrkhasseiymd3;
    }

    public void setVhsyudisptkkrkhasseiymd3(BizDate pVhsyudisptkkrkhasseiymd3) {
        vhsyudisptkkrkhasseiymd3 = pVhsyudisptkkrkhasseiymd3;
    }

    private String vhsyudisptksyouhnnm4;

    public String getVhsyudisptksyouhnnm4() {
        return vhsyudisptksyouhnnm4;
    }

    public void setVhsyudisptksyouhnnm4(String pVhsyudisptksyouhnnm4) {
        vhsyudisptksyouhnnm4 = pVhsyudisptksyouhnnm4;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu4;

    public C_Tuukasyu getVhsyudisptkktuukasyu4() {
        return vhsyudisptkktuukasyu4;
    }

    public void setVhsyudisptkktuukasyu4(C_Tuukasyu pVhsyudisptkktuukasyu4) {
        vhsyudisptkktuukasyu4 = pVhsyudisptkktuukasyu4;
    }

    private C_KataKbn vhsyudisptokyakukatakbn4;

    public C_KataKbn getVhsyudisptokyakukatakbn4() {
        return vhsyudisptokyakukatakbn4;
    }

    public void setVhsyudisptokyakukatakbn4(C_KataKbn pVhsyudisptokyakukatakbn4) {
        vhsyudisptokyakukatakbn4 = pVhsyudisptokyakukatakbn4;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn4;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn4() {
        return vhsyudisptkkyhgdkatakbn4;
    }

    public void setVhsyudisptkkyhgdkatakbn4(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn4) {
        vhsyudisptkkyhgdkatakbn4 = pVhsyudisptkkyhgdkatakbn4;
    }

    private Integer vhsyudisptkhhknnen4;

    public Integer getVhsyudisptkhhknnen4() {
        return vhsyudisptkhhknnen4;
    }

    public void setVhsyudisptkhhknnen4(Integer pVhsyudisptkhhknnen4) {
        vhsyudisptkhhknnen4 = pVhsyudisptkhhknnen4;
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

    private BizDate vhsyudisptkgaskkaisiymd4;

    public BizDate getVhsyudisptkgaskkaisiymd4() {
        return vhsyudisptkgaskkaisiymd4;
    }

    public void setVhsyudisptkgaskkaisiymd4(BizDate pVhsyudisptkgaskkaisiymd4) {
        vhsyudisptkgaskkaisiymd4 = pVhsyudisptkgaskkaisiymd4;
    }

    private BizDate vhsyudisptkhkskkaisiymd4;

    public BizDate getVhsyudisptkhkskkaisiymd4() {
        return vhsyudisptkhkskkaisiymd4;
    }

    public void setVhsyudisptkhkskkaisiymd4(BizDate pVhsyudisptkhkskkaisiymd4) {
        vhsyudisptkhkskkaisiymd4 = pVhsyudisptkhkskkaisiymd4;
    }

    private BizDate vhsyudisptkhkgskksiymd4;

    public BizDate getVhsyudisptkhkgskksiymd4() {
        return vhsyudisptkhkgskksiymd4;
    }

    public void setVhsyudisptkhkgskksiymd4(BizDate pVhsyudisptkhkgskksiymd4) {
        vhsyudisptkhkgskksiymd4 = pVhsyudisptkhkgskksiymd4;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn4;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn4() {
        return vhsyudisptkkihsyuruikbn4;
    }

    public void setVhsyudisptkkihsyuruikbn4(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn4) {
        vhsyudisptkkihsyuruikbn4 = pVhsyudisptkkihsyuruikbn4;
    }

    private BizCurrency vhsyudisptkkihons4;

    public BizCurrency getVhsyudisptkkihons4() {
        return vhsyudisptkkihons4;
    }

    public void setVhsyudisptkkihons4(BizCurrency pVhsyudisptkkihons4) {
        vhsyudisptkkihons4 = pVhsyudisptkkihons4;
    }

    private BizCurrency vhsyudisptktsnshrgndgk4;

    public BizCurrency getVhsyudisptktsnshrgndgk4() {
        return vhsyudisptktsnshrgndgk4;
    }

    public void setVhsyudisptktsnshrgndgk4(BizCurrency pVhsyudisptktsnshrgndgk4) {
        vhsyudisptktsnshrgndgk4 = pVhsyudisptktsnshrgndgk4;
    }

    private BizCurrency vhsyudisptkp4;

    public BizCurrency getVhsyudisptkp4() {
        return vhsyudisptkp4;
    }

    public void setVhsyudisptkp4(BizCurrency pVhsyudisptkp4) {
        vhsyudisptkp4 = pVhsyudisptkp4;
    }

    private BizCurrency vhsyudisptkkihonkyhgk4;

    public BizCurrency getVhsyudisptkkihonkyhgk4() {
        return vhsyudisptkkihonkyhgk4;
    }

    public void setVhsyudisptkkihonkyhgk4(BizCurrency pVhsyudisptkkihonkyhgk4) {
        vhsyudisptkkihonkyhgk4 = pVhsyudisptkkihonkyhgk4;
    }

    private BizCurrency vhsyudisptknextkosgop4;

    public BizCurrency getVhsyudisptknextkosgop4() {
        return vhsyudisptknextkosgop4;
    }

    public void setVhsyudisptknextkosgop4(BizCurrency pVhsyudisptknextkosgop4) {
        vhsyudisptknextkosgop4 = pVhsyudisptknextkosgop4;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn4;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn4() {
        return vhsyudisptksykyhkatakbn4;
    }

    public void setVhsyudisptksykyhkatakbn4(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn4) {
        vhsyudisptksykyhkatakbn4 = pVhsyudisptksykyhkatakbn4;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn4;

    public C_6daiLdKbn getVhsyudisptk6daildkbn4() {
        return vhsyudisptk6daildkbn4;
    }

    public void setVhsyudisptk6daildkbn4(C_6daiLdKbn pVhsyudisptk6daildkbn4) {
        vhsyudisptk6daildkbn4 = pVhsyudisptk6daildkbn4;
    }

    private BizCurrency vhsyudisptkganyukyhntgk4;

    public BizCurrency getVhsyudisptkganyukyhntgk4() {
        return vhsyudisptkganyukyhntgk4;
    }

    public void setVhsyudisptkganyukyhntgk4(BizCurrency pVhsyudisptkganyukyhntgk4) {
        vhsyudisptkganyukyhntgk4 = pVhsyudisptkganyukyhntgk4;
    }

    private BizDate vhsyudisptkshrskgstrymd4;

    public BizDate getVhsyudisptkshrskgstrymd4() {
        return vhsyudisptkshrskgstrymd4;
    }

    public void setVhsyudisptkshrskgstrymd4(BizDate pVhsyudisptkshrskgstrymd4) {
        vhsyudisptkshrskgstrymd4 = pVhsyudisptkshrskgstrymd4;
    }

    private BizDate vhsyudisptkshrskgnedymd4;

    public BizDate getVhsyudisptkshrskgnedymd4() {
        return vhsyudisptkshrskgnedymd4;
    }

    public void setVhsyudisptkshrskgnedymd4(BizDate pVhsyudisptkshrskgnedymd4) {
        vhsyudisptkshrskgnedymd4 = pVhsyudisptkshrskgnedymd4;
    }

    private BizCurrency vhsyudisptkshrskgngos4;

    public BizCurrency getVhsyudisptkshrskgngos4() {
        return vhsyudisptkshrskgngos4;
    }

    public void setVhsyudisptkshrskgngos4(BizCurrency pVhsyudisptkshrskgngos4) {
        vhsyudisptkshrskgngos4 = pVhsyudisptkshrskgngos4;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn4;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn4() {
        return vhsyudisptknenkinsyukbn4;
    }

    public void setVhsyudisptknenkinsyukbn4(C_Nenkinsyu pVhsyudisptknenkinsyukbn4) {
        vhsyudisptknenkinsyukbn4 = pVhsyudisptknenkinsyukbn4;
    }

    private Integer vhsyudisptknenkinkkn4;

    public Integer getVhsyudisptknenkinkkn4() {
        return vhsyudisptknenkinkkn4;
    }

    public void setVhsyudisptknenkinkkn4(Integer pVhsyudisptknenkinkkn4) {
        vhsyudisptknenkinkkn4 = pVhsyudisptknenkinkkn4;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn4;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn4() {
        return vhsyudisptktkjyskgnkkn4;
    }

    public void setVhsyudisptktkjyskgnkkn4(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn4) {
        vhsyudisptktkjyskgnkkn4 = pVhsyudisptktkjyskgnkkn4;
    }

    private BizDate vhsyudisptktkjkhkdsymd14;

    public BizDate getVhsyudisptktkjkhkdsymd14() {
        return vhsyudisptktkjkhkdsymd14;
    }

    public void setVhsyudisptktkjkhkdsymd14(BizDate pVhsyudisptktkjkhkdsymd14) {
        vhsyudisptktkjkhkdsymd14 = pVhsyudisptktkjkhkdsymd14;
    }

    private BizDate vhsyudisptktkjkhkdeymd14;

    public BizDate getVhsyudisptktkjkhkdeymd14() {
        return vhsyudisptktkjkhkdeymd14;
    }

    public void setVhsyudisptktkjkhkdeymd14(BizDate pVhsyudisptktkjkhkdeymd14) {
        vhsyudisptktkjkhkdeymd14 = pVhsyudisptktkjkhkdeymd14;
    }

    private BizCurrency vhsyudisptktkjyskgns14;

    public BizCurrency getVhsyudisptktkjyskgns14() {
        return vhsyudisptktkjyskgns14;
    }

    public void setVhsyudisptktkjyskgns14(BizCurrency pVhsyudisptktkjyskgns14) {
        vhsyudisptktkjyskgns14 = pVhsyudisptktkjyskgns14;
    }

    private BizDate vhsyudisptktkjkhkdsymd24;

    public BizDate getVhsyudisptktkjkhkdsymd24() {
        return vhsyudisptktkjkhkdsymd24;
    }

    public void setVhsyudisptktkjkhkdsymd24(BizDate pVhsyudisptktkjkhkdsymd24) {
        vhsyudisptktkjkhkdsymd24 = pVhsyudisptktkjkhkdsymd24;
    }

    private BizDate vhsyudisptktkjkhkdeymd24;

    public BizDate getVhsyudisptktkjkhkdeymd24() {
        return vhsyudisptktkjkhkdeymd24;
    }

    public void setVhsyudisptktkjkhkdeymd24(BizDate pVhsyudisptktkjkhkdeymd24) {
        vhsyudisptktkjkhkdeymd24 = pVhsyudisptktkjkhkdeymd24;
    }

    private BizCurrency vhsyudisptktkjyskgns24;

    public BizCurrency getVhsyudisptktkjyskgns24() {
        return vhsyudisptktkjyskgns24;
    }

    public void setVhsyudisptktkjyskgns24(BizCurrency pVhsyudisptktkjyskgns24) {
        vhsyudisptktkjyskgns24 = pVhsyudisptktkjyskgns24;
    }

    private BizDate vhsyudisptktkjkhkdsymd34;

    public BizDate getVhsyudisptktkjkhkdsymd34() {
        return vhsyudisptktkjkhkdsymd34;
    }

    public void setVhsyudisptktkjkhkdsymd34(BizDate pVhsyudisptktkjkhkdsymd34) {
        vhsyudisptktkjkhkdsymd34 = pVhsyudisptktkjkhkdsymd34;
    }

    private BizDate vhsyudisptktkjkhkdeymd34;

    public BizDate getVhsyudisptktkjkhkdeymd34() {
        return vhsyudisptktkjkhkdeymd34;
    }

    public void setVhsyudisptktkjkhkdeymd34(BizDate pVhsyudisptktkjkhkdeymd34) {
        vhsyudisptktkjkhkdeymd34 = pVhsyudisptktkjkhkdeymd34;
    }

    private BizCurrency vhsyudisptktkjyskgns34;

    public BizCurrency getVhsyudisptktkjyskgns34() {
        return vhsyudisptktkjyskgns34;
    }

    public void setVhsyudisptktkjyskgns34(BizCurrency pVhsyudisptktkjyskgns34) {
        vhsyudisptktkjyskgns34 = pVhsyudisptktkjyskgns34;
    }

    private BizDate vhsyudisptktkjkhkdsymd44;

    public BizDate getVhsyudisptktkjkhkdsymd44() {
        return vhsyudisptktkjkhkdsymd44;
    }

    public void setVhsyudisptktkjkhkdsymd44(BizDate pVhsyudisptktkjkhkdsymd44) {
        vhsyudisptktkjkhkdsymd44 = pVhsyudisptktkjkhkdsymd44;
    }

    private BizDate vhsyudisptktkjkhkdeymd44;

    public BizDate getVhsyudisptktkjkhkdeymd44() {
        return vhsyudisptktkjkhkdeymd44;
    }

    public void setVhsyudisptktkjkhkdeymd44(BizDate pVhsyudisptktkjkhkdeymd44) {
        vhsyudisptktkjkhkdeymd44 = pVhsyudisptktkjkhkdeymd44;
    }

    private BizCurrency vhsyudisptktkjyskgns44;

    public BizCurrency getVhsyudisptktkjyskgns44() {
        return vhsyudisptktkjyskgns44;
    }

    public void setVhsyudisptktkjyskgns44(BizCurrency pVhsyudisptktkjyskgns44) {
        vhsyudisptktkjyskgns44 = pVhsyudisptktkjyskgns44;
    }

    private BizDate vhsyudisptktkjkhkdsymd54;

    public BizDate getVhsyudisptktkjkhkdsymd54() {
        return vhsyudisptktkjkhkdsymd54;
    }

    public void setVhsyudisptktkjkhkdsymd54(BizDate pVhsyudisptktkjkhkdsymd54) {
        vhsyudisptktkjkhkdsymd54 = pVhsyudisptktkjkhkdsymd54;
    }

    private BizDate vhsyudisptktkjkhkdeymd54;

    public BizDate getVhsyudisptktkjkhkdeymd54() {
        return vhsyudisptktkjkhkdeymd54;
    }

    public void setVhsyudisptktkjkhkdeymd54(BizDate pVhsyudisptktkjkhkdeymd54) {
        vhsyudisptktkjkhkdeymd54 = pVhsyudisptktkjkhkdeymd54;
    }

    private BizCurrency vhsyudisptktkjyskgns54;

    public BizCurrency getVhsyudisptktkjyskgns54() {
        return vhsyudisptktkjyskgns54;
    }

    public void setVhsyudisptktkjyskgns54(BizCurrency pVhsyudisptktkjyskgns54) {
        vhsyudisptktkjyskgns54 = pVhsyudisptktkjyskgns54;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten4;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten4() {
        return vhsyudisptktkjyhyouten4;
    }

    public void setVhsyudisptktkjyhyouten4(C_Tkjyhyouten pVhsyudisptktkjyhyouten4) {
        vhsyudisptktkjyhyouten4 = pVhsyudisptktkjyhyouten4;
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

    private BizCurrency vhsyudisptktutakngk4;

    public BizCurrency getVhsyudisptktutakngk4() {
        return vhsyudisptktutakngk4;
    }

    public void setVhsyudisptktutakngk4(BizCurrency pVhsyudisptktutakngk4) {
        vhsyudisptktutakngk4 = pVhsyudisptktutakngk4;
    }

    private BizDate vhsyudisptkkrkhasseiymd4;

    public BizDate getVhsyudisptkkrkhasseiymd4() {
        return vhsyudisptkkrkhasseiymd4;
    }

    public void setVhsyudisptkkrkhasseiymd4(BizDate pVhsyudisptkkrkhasseiymd4) {
        vhsyudisptkkrkhasseiymd4 = pVhsyudisptkkrkhasseiymd4;
    }

    private String vhsyudisptksyouhnnm5;

    public String getVhsyudisptksyouhnnm5() {
        return vhsyudisptksyouhnnm5;
    }

    public void setVhsyudisptksyouhnnm5(String pVhsyudisptksyouhnnm5) {
        vhsyudisptksyouhnnm5 = pVhsyudisptksyouhnnm5;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu5;

    public C_Tuukasyu getVhsyudisptkktuukasyu5() {
        return vhsyudisptkktuukasyu5;
    }

    public void setVhsyudisptkktuukasyu5(C_Tuukasyu pVhsyudisptkktuukasyu5) {
        vhsyudisptkktuukasyu5 = pVhsyudisptkktuukasyu5;
    }

    private C_KataKbn vhsyudisptokyakukatakbn5;

    public C_KataKbn getVhsyudisptokyakukatakbn5() {
        return vhsyudisptokyakukatakbn5;
    }

    public void setVhsyudisptokyakukatakbn5(C_KataKbn pVhsyudisptokyakukatakbn5) {
        vhsyudisptokyakukatakbn5 = pVhsyudisptokyakukatakbn5;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn5;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn5() {
        return vhsyudisptkkyhgdkatakbn5;
    }

    public void setVhsyudisptkkyhgdkatakbn5(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn5) {
        vhsyudisptkkyhgdkatakbn5 = pVhsyudisptkkyhgdkatakbn5;
    }

    private Integer vhsyudisptkhhknnen5;

    public Integer getVhsyudisptkhhknnen5() {
        return vhsyudisptkhhknnen5;
    }

    public void setVhsyudisptkhhknnen5(Integer pVhsyudisptkhhknnen5) {
        vhsyudisptkhhknnen5 = pVhsyudisptkhhknnen5;
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

    private BizDate vhsyudisptkgaskkaisiymd5;

    public BizDate getVhsyudisptkgaskkaisiymd5() {
        return vhsyudisptkgaskkaisiymd5;
    }

    public void setVhsyudisptkgaskkaisiymd5(BizDate pVhsyudisptkgaskkaisiymd5) {
        vhsyudisptkgaskkaisiymd5 = pVhsyudisptkgaskkaisiymd5;
    }

    private BizDate vhsyudisptkhkskkaisiymd5;

    public BizDate getVhsyudisptkhkskkaisiymd5() {
        return vhsyudisptkhkskkaisiymd5;
    }

    public void setVhsyudisptkhkskkaisiymd5(BizDate pVhsyudisptkhkskkaisiymd5) {
        vhsyudisptkhkskkaisiymd5 = pVhsyudisptkhkskkaisiymd5;
    }

    private BizDate vhsyudisptkhkgskksiymd5;

    public BizDate getVhsyudisptkhkgskksiymd5() {
        return vhsyudisptkhkgskksiymd5;
    }

    public void setVhsyudisptkhkgskksiymd5(BizDate pVhsyudisptkhkgskksiymd5) {
        vhsyudisptkhkgskksiymd5 = pVhsyudisptkhkgskksiymd5;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn5;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn5() {
        return vhsyudisptkkihsyuruikbn5;
    }

    public void setVhsyudisptkkihsyuruikbn5(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn5) {
        vhsyudisptkkihsyuruikbn5 = pVhsyudisptkkihsyuruikbn5;
    }

    private BizCurrency vhsyudisptkkihons5;

    public BizCurrency getVhsyudisptkkihons5() {
        return vhsyudisptkkihons5;
    }

    public void setVhsyudisptkkihons5(BizCurrency pVhsyudisptkkihons5) {
        vhsyudisptkkihons5 = pVhsyudisptkkihons5;
    }

    private BizCurrency vhsyudisptktsnshrgndgk5;

    public BizCurrency getVhsyudisptktsnshrgndgk5() {
        return vhsyudisptktsnshrgndgk5;
    }

    public void setVhsyudisptktsnshrgndgk5(BizCurrency pVhsyudisptktsnshrgndgk5) {
        vhsyudisptktsnshrgndgk5 = pVhsyudisptktsnshrgndgk5;
    }

    private BizCurrency vhsyudisptkp5;

    public BizCurrency getVhsyudisptkp5() {
        return vhsyudisptkp5;
    }

    public void setVhsyudisptkp5(BizCurrency pVhsyudisptkp5) {
        vhsyudisptkp5 = pVhsyudisptkp5;
    }

    private BizCurrency vhsyudisptkkihonkyhgk5;

    public BizCurrency getVhsyudisptkkihonkyhgk5() {
        return vhsyudisptkkihonkyhgk5;
    }

    public void setVhsyudisptkkihonkyhgk5(BizCurrency pVhsyudisptkkihonkyhgk5) {
        vhsyudisptkkihonkyhgk5 = pVhsyudisptkkihonkyhgk5;
    }

    private BizCurrency vhsyudisptknextkosgop5;

    public BizCurrency getVhsyudisptknextkosgop5() {
        return vhsyudisptknextkosgop5;
    }

    public void setVhsyudisptknextkosgop5(BizCurrency pVhsyudisptknextkosgop5) {
        vhsyudisptknextkosgop5 = pVhsyudisptknextkosgop5;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn5;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn5() {
        return vhsyudisptksykyhkatakbn5;
    }

    public void setVhsyudisptksykyhkatakbn5(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn5) {
        vhsyudisptksykyhkatakbn5 = pVhsyudisptksykyhkatakbn5;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn5;

    public C_6daiLdKbn getVhsyudisptk6daildkbn5() {
        return vhsyudisptk6daildkbn5;
    }

    public void setVhsyudisptk6daildkbn5(C_6daiLdKbn pVhsyudisptk6daildkbn5) {
        vhsyudisptk6daildkbn5 = pVhsyudisptk6daildkbn5;
    }

    private BizCurrency vhsyudisptkganyukyhntgk5;

    public BizCurrency getVhsyudisptkganyukyhntgk5() {
        return vhsyudisptkganyukyhntgk5;
    }

    public void setVhsyudisptkganyukyhntgk5(BizCurrency pVhsyudisptkganyukyhntgk5) {
        vhsyudisptkganyukyhntgk5 = pVhsyudisptkganyukyhntgk5;
    }

    private BizDate vhsyudisptkshrskgstrymd5;

    public BizDate getVhsyudisptkshrskgstrymd5() {
        return vhsyudisptkshrskgstrymd5;
    }

    public void setVhsyudisptkshrskgstrymd5(BizDate pVhsyudisptkshrskgstrymd5) {
        vhsyudisptkshrskgstrymd5 = pVhsyudisptkshrskgstrymd5;
    }

    private BizDate vhsyudisptkshrskgnedymd5;

    public BizDate getVhsyudisptkshrskgnedymd5() {
        return vhsyudisptkshrskgnedymd5;
    }

    public void setVhsyudisptkshrskgnedymd5(BizDate pVhsyudisptkshrskgnedymd5) {
        vhsyudisptkshrskgnedymd5 = pVhsyudisptkshrskgnedymd5;
    }

    private BizCurrency vhsyudisptkshrskgngos5;

    public BizCurrency getVhsyudisptkshrskgngos5() {
        return vhsyudisptkshrskgngos5;
    }

    public void setVhsyudisptkshrskgngos5(BizCurrency pVhsyudisptkshrskgngos5) {
        vhsyudisptkshrskgngos5 = pVhsyudisptkshrskgngos5;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn5;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn5() {
        return vhsyudisptknenkinsyukbn5;
    }

    public void setVhsyudisptknenkinsyukbn5(C_Nenkinsyu pVhsyudisptknenkinsyukbn5) {
        vhsyudisptknenkinsyukbn5 = pVhsyudisptknenkinsyukbn5;
    }

    private Integer vhsyudisptknenkinkkn5;

    public Integer getVhsyudisptknenkinkkn5() {
        return vhsyudisptknenkinkkn5;
    }

    public void setVhsyudisptknenkinkkn5(Integer pVhsyudisptknenkinkkn5) {
        vhsyudisptknenkinkkn5 = pVhsyudisptknenkinkkn5;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn5;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn5() {
        return vhsyudisptktkjyskgnkkn5;
    }

    public void setVhsyudisptktkjyskgnkkn5(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn5) {
        vhsyudisptktkjyskgnkkn5 = pVhsyudisptktkjyskgnkkn5;
    }

    private BizDate vhsyudisptktkjkhkdsymd15;

    public BizDate getVhsyudisptktkjkhkdsymd15() {
        return vhsyudisptktkjkhkdsymd15;
    }

    public void setVhsyudisptktkjkhkdsymd15(BizDate pVhsyudisptktkjkhkdsymd15) {
        vhsyudisptktkjkhkdsymd15 = pVhsyudisptktkjkhkdsymd15;
    }

    private BizDate vhsyudisptktkjkhkdeymd15;

    public BizDate getVhsyudisptktkjkhkdeymd15() {
        return vhsyudisptktkjkhkdeymd15;
    }

    public void setVhsyudisptktkjkhkdeymd15(BizDate pVhsyudisptktkjkhkdeymd15) {
        vhsyudisptktkjkhkdeymd15 = pVhsyudisptktkjkhkdeymd15;
    }

    private BizCurrency vhsyudisptktkjyskgns15;

    public BizCurrency getVhsyudisptktkjyskgns15() {
        return vhsyudisptktkjyskgns15;
    }

    public void setVhsyudisptktkjyskgns15(BizCurrency pVhsyudisptktkjyskgns15) {
        vhsyudisptktkjyskgns15 = pVhsyudisptktkjyskgns15;
    }

    private BizDate vhsyudisptktkjkhkdsymd25;

    public BizDate getVhsyudisptktkjkhkdsymd25() {
        return vhsyudisptktkjkhkdsymd25;
    }

    public void setVhsyudisptktkjkhkdsymd25(BizDate pVhsyudisptktkjkhkdsymd25) {
        vhsyudisptktkjkhkdsymd25 = pVhsyudisptktkjkhkdsymd25;
    }

    private BizDate vhsyudisptktkjkhkdeymd25;

    public BizDate getVhsyudisptktkjkhkdeymd25() {
        return vhsyudisptktkjkhkdeymd25;
    }

    public void setVhsyudisptktkjkhkdeymd25(BizDate pVhsyudisptktkjkhkdeymd25) {
        vhsyudisptktkjkhkdeymd25 = pVhsyudisptktkjkhkdeymd25;
    }

    private BizCurrency vhsyudisptktkjyskgns25;

    public BizCurrency getVhsyudisptktkjyskgns25() {
        return vhsyudisptktkjyskgns25;
    }

    public void setVhsyudisptktkjyskgns25(BizCurrency pVhsyudisptktkjyskgns25) {
        vhsyudisptktkjyskgns25 = pVhsyudisptktkjyskgns25;
    }

    private BizDate vhsyudisptktkjkhkdsymd35;

    public BizDate getVhsyudisptktkjkhkdsymd35() {
        return vhsyudisptktkjkhkdsymd35;
    }

    public void setVhsyudisptktkjkhkdsymd35(BizDate pVhsyudisptktkjkhkdsymd35) {
        vhsyudisptktkjkhkdsymd35 = pVhsyudisptktkjkhkdsymd35;
    }

    private BizDate vhsyudisptktkjkhkdeymd35;

    public BizDate getVhsyudisptktkjkhkdeymd35() {
        return vhsyudisptktkjkhkdeymd35;
    }

    public void setVhsyudisptktkjkhkdeymd35(BizDate pVhsyudisptktkjkhkdeymd35) {
        vhsyudisptktkjkhkdeymd35 = pVhsyudisptktkjkhkdeymd35;
    }

    private BizCurrency vhsyudisptktkjyskgns35;

    public BizCurrency getVhsyudisptktkjyskgns35() {
        return vhsyudisptktkjyskgns35;
    }

    public void setVhsyudisptktkjyskgns35(BizCurrency pVhsyudisptktkjyskgns35) {
        vhsyudisptktkjyskgns35 = pVhsyudisptktkjyskgns35;
    }

    private BizDate vhsyudisptktkjkhkdsymd45;

    public BizDate getVhsyudisptktkjkhkdsymd45() {
        return vhsyudisptktkjkhkdsymd45;
    }

    public void setVhsyudisptktkjkhkdsymd45(BizDate pVhsyudisptktkjkhkdsymd45) {
        vhsyudisptktkjkhkdsymd45 = pVhsyudisptktkjkhkdsymd45;
    }

    private BizDate vhsyudisptktkjkhkdeymd45;

    public BizDate getVhsyudisptktkjkhkdeymd45() {
        return vhsyudisptktkjkhkdeymd45;
    }

    public void setVhsyudisptktkjkhkdeymd45(BizDate pVhsyudisptktkjkhkdeymd45) {
        vhsyudisptktkjkhkdeymd45 = pVhsyudisptktkjkhkdeymd45;
    }

    private BizCurrency vhsyudisptktkjyskgns45;

    public BizCurrency getVhsyudisptktkjyskgns45() {
        return vhsyudisptktkjyskgns45;
    }

    public void setVhsyudisptktkjyskgns45(BizCurrency pVhsyudisptktkjyskgns45) {
        vhsyudisptktkjyskgns45 = pVhsyudisptktkjyskgns45;
    }

    private BizDate vhsyudisptktkjkhkdsymd55;

    public BizDate getVhsyudisptktkjkhkdsymd55() {
        return vhsyudisptktkjkhkdsymd55;
    }

    public void setVhsyudisptktkjkhkdsymd55(BizDate pVhsyudisptktkjkhkdsymd55) {
        vhsyudisptktkjkhkdsymd55 = pVhsyudisptktkjkhkdsymd55;
    }

    private BizDate vhsyudisptktkjkhkdeymd55;

    public BizDate getVhsyudisptktkjkhkdeymd55() {
        return vhsyudisptktkjkhkdeymd55;
    }

    public void setVhsyudisptktkjkhkdeymd55(BizDate pVhsyudisptktkjkhkdeymd55) {
        vhsyudisptktkjkhkdeymd55 = pVhsyudisptktkjkhkdeymd55;
    }

    private BizCurrency vhsyudisptktkjyskgns55;

    public BizCurrency getVhsyudisptktkjyskgns55() {
        return vhsyudisptktkjyskgns55;
    }

    public void setVhsyudisptktkjyskgns55(BizCurrency pVhsyudisptktkjyskgns55) {
        vhsyudisptktkjyskgns55 = pVhsyudisptktkjyskgns55;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten5;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten5() {
        return vhsyudisptktkjyhyouten5;
    }

    public void setVhsyudisptktkjyhyouten5(C_Tkjyhyouten pVhsyudisptktkjyhyouten5) {
        vhsyudisptktkjyhyouten5 = pVhsyudisptktkjyhyouten5;
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

    private BizCurrency vhsyudisptktutakngk5;

    public BizCurrency getVhsyudisptktutakngk5() {
        return vhsyudisptktutakngk5;
    }

    public void setVhsyudisptktutakngk5(BizCurrency pVhsyudisptktutakngk5) {
        vhsyudisptktutakngk5 = pVhsyudisptktutakngk5;
    }

    private BizDate vhsyudisptkkrkhasseiymd5;

    public BizDate getVhsyudisptkkrkhasseiymd5() {
        return vhsyudisptkkrkhasseiymd5;
    }

    public void setVhsyudisptkkrkhasseiymd5(BizDate pVhsyudisptkkrkhasseiymd5) {
        vhsyudisptkkrkhasseiymd5 = pVhsyudisptkkrkhasseiymd5;
    }

    private String vhsyudisptksyouhnnm6;

    public String getVhsyudisptksyouhnnm6() {
        return vhsyudisptksyouhnnm6;
    }

    public void setVhsyudisptksyouhnnm6(String pVhsyudisptksyouhnnm6) {
        vhsyudisptksyouhnnm6 = pVhsyudisptksyouhnnm6;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu6;

    public C_Tuukasyu getVhsyudisptkktuukasyu6() {
        return vhsyudisptkktuukasyu6;
    }

    public void setVhsyudisptkktuukasyu6(C_Tuukasyu pVhsyudisptkktuukasyu6) {
        vhsyudisptkktuukasyu6 = pVhsyudisptkktuukasyu6;
    }

    private C_KataKbn vhsyudisptokyakukatakbn6;

    public C_KataKbn getVhsyudisptokyakukatakbn6() {
        return vhsyudisptokyakukatakbn6;
    }

    public void setVhsyudisptokyakukatakbn6(C_KataKbn pVhsyudisptokyakukatakbn6) {
        vhsyudisptokyakukatakbn6 = pVhsyudisptokyakukatakbn6;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn6;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn6() {
        return vhsyudisptkkyhgdkatakbn6;
    }

    public void setVhsyudisptkkyhgdkatakbn6(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn6) {
        vhsyudisptkkyhgdkatakbn6 = pVhsyudisptkkyhgdkatakbn6;
    }

    private Integer vhsyudisptkhhknnen6;

    public Integer getVhsyudisptkhhknnen6() {
        return vhsyudisptkhhknnen6;
    }

    public void setVhsyudisptkhhknnen6(Integer pVhsyudisptkhhknnen6) {
        vhsyudisptkhhknnen6 = pVhsyudisptkhhknnen6;
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

    private BizDate vhsyudisptkgaskkaisiymd6;

    public BizDate getVhsyudisptkgaskkaisiymd6() {
        return vhsyudisptkgaskkaisiymd6;
    }

    public void setVhsyudisptkgaskkaisiymd6(BizDate pVhsyudisptkgaskkaisiymd6) {
        vhsyudisptkgaskkaisiymd6 = pVhsyudisptkgaskkaisiymd6;
    }

    private BizDate vhsyudisptkhkskkaisiymd6;

    public BizDate getVhsyudisptkhkskkaisiymd6() {
        return vhsyudisptkhkskkaisiymd6;
    }

    public void setVhsyudisptkhkskkaisiymd6(BizDate pVhsyudisptkhkskkaisiymd6) {
        vhsyudisptkhkskkaisiymd6 = pVhsyudisptkhkskkaisiymd6;
    }

    private BizDate vhsyudisptkhkgskksiymd6;

    public BizDate getVhsyudisptkhkgskksiymd6() {
        return vhsyudisptkhkgskksiymd6;
    }

    public void setVhsyudisptkhkgskksiymd6(BizDate pVhsyudisptkhkgskksiymd6) {
        vhsyudisptkhkgskksiymd6 = pVhsyudisptkhkgskksiymd6;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn6;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn6() {
        return vhsyudisptkkihsyuruikbn6;
    }

    public void setVhsyudisptkkihsyuruikbn6(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn6) {
        vhsyudisptkkihsyuruikbn6 = pVhsyudisptkkihsyuruikbn6;
    }

    private BizCurrency vhsyudisptkkihons6;

    public BizCurrency getVhsyudisptkkihons6() {
        return vhsyudisptkkihons6;
    }

    public void setVhsyudisptkkihons6(BizCurrency pVhsyudisptkkihons6) {
        vhsyudisptkkihons6 = pVhsyudisptkkihons6;
    }

    private BizCurrency vhsyudisptktsnshrgndgk6;

    public BizCurrency getVhsyudisptktsnshrgndgk6() {
        return vhsyudisptktsnshrgndgk6;
    }

    public void setVhsyudisptktsnshrgndgk6(BizCurrency pVhsyudisptktsnshrgndgk6) {
        vhsyudisptktsnshrgndgk6 = pVhsyudisptktsnshrgndgk6;
    }

    private BizCurrency vhsyudisptkp6;

    public BizCurrency getVhsyudisptkp6() {
        return vhsyudisptkp6;
    }

    public void setVhsyudisptkp6(BizCurrency pVhsyudisptkp6) {
        vhsyudisptkp6 = pVhsyudisptkp6;
    }

    private BizCurrency vhsyudisptkkihonkyhgk6;

    public BizCurrency getVhsyudisptkkihonkyhgk6() {
        return vhsyudisptkkihonkyhgk6;
    }

    public void setVhsyudisptkkihonkyhgk6(BizCurrency pVhsyudisptkkihonkyhgk6) {
        vhsyudisptkkihonkyhgk6 = pVhsyudisptkkihonkyhgk6;
    }

    private BizCurrency vhsyudisptknextkosgop6;

    public BizCurrency getVhsyudisptknextkosgop6() {
        return vhsyudisptknextkosgop6;
    }

    public void setVhsyudisptknextkosgop6(BizCurrency pVhsyudisptknextkosgop6) {
        vhsyudisptknextkosgop6 = pVhsyudisptknextkosgop6;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn6;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn6() {
        return vhsyudisptksykyhkatakbn6;
    }

    public void setVhsyudisptksykyhkatakbn6(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn6) {
        vhsyudisptksykyhkatakbn6 = pVhsyudisptksykyhkatakbn6;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn6;

    public C_6daiLdKbn getVhsyudisptk6daildkbn6() {
        return vhsyudisptk6daildkbn6;
    }

    public void setVhsyudisptk6daildkbn6(C_6daiLdKbn pVhsyudisptk6daildkbn6) {
        vhsyudisptk6daildkbn6 = pVhsyudisptk6daildkbn6;
    }

    private BizCurrency vhsyudisptkganyukyhntgk6;

    public BizCurrency getVhsyudisptkganyukyhntgk6() {
        return vhsyudisptkganyukyhntgk6;
    }

    public void setVhsyudisptkganyukyhntgk6(BizCurrency pVhsyudisptkganyukyhntgk6) {
        vhsyudisptkganyukyhntgk6 = pVhsyudisptkganyukyhntgk6;
    }

    private BizDate vhsyudisptkshrskgstrymd6;

    public BizDate getVhsyudisptkshrskgstrymd6() {
        return vhsyudisptkshrskgstrymd6;
    }

    public void setVhsyudisptkshrskgstrymd6(BizDate pVhsyudisptkshrskgstrymd6) {
        vhsyudisptkshrskgstrymd6 = pVhsyudisptkshrskgstrymd6;
    }

    private BizDate vhsyudisptkshrskgnedymd6;

    public BizDate getVhsyudisptkshrskgnedymd6() {
        return vhsyudisptkshrskgnedymd6;
    }

    public void setVhsyudisptkshrskgnedymd6(BizDate pVhsyudisptkshrskgnedymd6) {
        vhsyudisptkshrskgnedymd6 = pVhsyudisptkshrskgnedymd6;
    }

    private BizCurrency vhsyudisptkshrskgngos6;

    public BizCurrency getVhsyudisptkshrskgngos6() {
        return vhsyudisptkshrskgngos6;
    }

    public void setVhsyudisptkshrskgngos6(BizCurrency pVhsyudisptkshrskgngos6) {
        vhsyudisptkshrskgngos6 = pVhsyudisptkshrskgngos6;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn6;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn6() {
        return vhsyudisptknenkinsyukbn6;
    }

    public void setVhsyudisptknenkinsyukbn6(C_Nenkinsyu pVhsyudisptknenkinsyukbn6) {
        vhsyudisptknenkinsyukbn6 = pVhsyudisptknenkinsyukbn6;
    }

    private Integer vhsyudisptknenkinkkn6;

    public Integer getVhsyudisptknenkinkkn6() {
        return vhsyudisptknenkinkkn6;
    }

    public void setVhsyudisptknenkinkkn6(Integer pVhsyudisptknenkinkkn6) {
        vhsyudisptknenkinkkn6 = pVhsyudisptknenkinkkn6;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn6;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn6() {
        return vhsyudisptktkjyskgnkkn6;
    }

    public void setVhsyudisptktkjyskgnkkn6(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn6) {
        vhsyudisptktkjyskgnkkn6 = pVhsyudisptktkjyskgnkkn6;
    }

    private BizDate vhsyudisptktkjkhkdsymd16;

    public BizDate getVhsyudisptktkjkhkdsymd16() {
        return vhsyudisptktkjkhkdsymd16;
    }

    public void setVhsyudisptktkjkhkdsymd16(BizDate pVhsyudisptktkjkhkdsymd16) {
        vhsyudisptktkjkhkdsymd16 = pVhsyudisptktkjkhkdsymd16;
    }

    private BizDate vhsyudisptktkjkhkdeymd16;

    public BizDate getVhsyudisptktkjkhkdeymd16() {
        return vhsyudisptktkjkhkdeymd16;
    }

    public void setVhsyudisptktkjkhkdeymd16(BizDate pVhsyudisptktkjkhkdeymd16) {
        vhsyudisptktkjkhkdeymd16 = pVhsyudisptktkjkhkdeymd16;
    }

    private BizCurrency vhsyudisptktkjyskgns16;

    public BizCurrency getVhsyudisptktkjyskgns16() {
        return vhsyudisptktkjyskgns16;
    }

    public void setVhsyudisptktkjyskgns16(BizCurrency pVhsyudisptktkjyskgns16) {
        vhsyudisptktkjyskgns16 = pVhsyudisptktkjyskgns16;
    }

    private BizDate vhsyudisptktkjkhkdsymd26;

    public BizDate getVhsyudisptktkjkhkdsymd26() {
        return vhsyudisptktkjkhkdsymd26;
    }

    public void setVhsyudisptktkjkhkdsymd26(BizDate pVhsyudisptktkjkhkdsymd26) {
        vhsyudisptktkjkhkdsymd26 = pVhsyudisptktkjkhkdsymd26;
    }

    private BizDate vhsyudisptktkjkhkdeymd26;

    public BizDate getVhsyudisptktkjkhkdeymd26() {
        return vhsyudisptktkjkhkdeymd26;
    }

    public void setVhsyudisptktkjkhkdeymd26(BizDate pVhsyudisptktkjkhkdeymd26) {
        vhsyudisptktkjkhkdeymd26 = pVhsyudisptktkjkhkdeymd26;
    }

    private BizCurrency vhsyudisptktkjyskgns26;

    public BizCurrency getVhsyudisptktkjyskgns26() {
        return vhsyudisptktkjyskgns26;
    }

    public void setVhsyudisptktkjyskgns26(BizCurrency pVhsyudisptktkjyskgns26) {
        vhsyudisptktkjyskgns26 = pVhsyudisptktkjyskgns26;
    }

    private BizDate vhsyudisptktkjkhkdsymd36;

    public BizDate getVhsyudisptktkjkhkdsymd36() {
        return vhsyudisptktkjkhkdsymd36;
    }

    public void setVhsyudisptktkjkhkdsymd36(BizDate pVhsyudisptktkjkhkdsymd36) {
        vhsyudisptktkjkhkdsymd36 = pVhsyudisptktkjkhkdsymd36;
    }

    private BizDate vhsyudisptktkjkhkdeymd36;

    public BizDate getVhsyudisptktkjkhkdeymd36() {
        return vhsyudisptktkjkhkdeymd36;
    }

    public void setVhsyudisptktkjkhkdeymd36(BizDate pVhsyudisptktkjkhkdeymd36) {
        vhsyudisptktkjkhkdeymd36 = pVhsyudisptktkjkhkdeymd36;
    }

    private BizCurrency vhsyudisptktkjyskgns36;

    public BizCurrency getVhsyudisptktkjyskgns36() {
        return vhsyudisptktkjyskgns36;
    }

    public void setVhsyudisptktkjyskgns36(BizCurrency pVhsyudisptktkjyskgns36) {
        vhsyudisptktkjyskgns36 = pVhsyudisptktkjyskgns36;
    }

    private BizDate vhsyudisptktkjkhkdsymd46;

    public BizDate getVhsyudisptktkjkhkdsymd46() {
        return vhsyudisptktkjkhkdsymd46;
    }

    public void setVhsyudisptktkjkhkdsymd46(BizDate pVhsyudisptktkjkhkdsymd46) {
        vhsyudisptktkjkhkdsymd46 = pVhsyudisptktkjkhkdsymd46;
    }

    private BizDate vhsyudisptktkjkhkdeymd46;

    public BizDate getVhsyudisptktkjkhkdeymd46() {
        return vhsyudisptktkjkhkdeymd46;
    }

    public void setVhsyudisptktkjkhkdeymd46(BizDate pVhsyudisptktkjkhkdeymd46) {
        vhsyudisptktkjkhkdeymd46 = pVhsyudisptktkjkhkdeymd46;
    }

    private BizCurrency vhsyudisptktkjyskgns46;

    public BizCurrency getVhsyudisptktkjyskgns46() {
        return vhsyudisptktkjyskgns46;
    }

    public void setVhsyudisptktkjyskgns46(BizCurrency pVhsyudisptktkjyskgns46) {
        vhsyudisptktkjyskgns46 = pVhsyudisptktkjyskgns46;
    }

    private BizDate vhsyudisptktkjkhkdsymd56;

    public BizDate getVhsyudisptktkjkhkdsymd56() {
        return vhsyudisptktkjkhkdsymd56;
    }

    public void setVhsyudisptktkjkhkdsymd56(BizDate pVhsyudisptktkjkhkdsymd56) {
        vhsyudisptktkjkhkdsymd56 = pVhsyudisptktkjkhkdsymd56;
    }

    private BizDate vhsyudisptktkjkhkdeymd56;

    public BizDate getVhsyudisptktkjkhkdeymd56() {
        return vhsyudisptktkjkhkdeymd56;
    }

    public void setVhsyudisptktkjkhkdeymd56(BizDate pVhsyudisptktkjkhkdeymd56) {
        vhsyudisptktkjkhkdeymd56 = pVhsyudisptktkjkhkdeymd56;
    }

    private BizCurrency vhsyudisptktkjyskgns56;

    public BizCurrency getVhsyudisptktkjyskgns56() {
        return vhsyudisptktkjyskgns56;
    }

    public void setVhsyudisptktkjyskgns56(BizCurrency pVhsyudisptktkjyskgns56) {
        vhsyudisptktkjyskgns56 = pVhsyudisptktkjyskgns56;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten6;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten6() {
        return vhsyudisptktkjyhyouten6;
    }

    public void setVhsyudisptktkjyhyouten6(C_Tkjyhyouten pVhsyudisptktkjyhyouten6) {
        vhsyudisptktkjyhyouten6 = pVhsyudisptktkjyhyouten6;
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

    private BizCurrency vhsyudisptktutakngk6;

    public BizCurrency getVhsyudisptktutakngk6() {
        return vhsyudisptktutakngk6;
    }

    public void setVhsyudisptktutakngk6(BizCurrency pVhsyudisptktutakngk6) {
        vhsyudisptktutakngk6 = pVhsyudisptktutakngk6;
    }

    private BizDate vhsyudisptkkrkhasseiymd6;

    public BizDate getVhsyudisptkkrkhasseiymd6() {
        return vhsyudisptkkrkhasseiymd6;
    }

    public void setVhsyudisptkkrkhasseiymd6(BizDate pVhsyudisptkkrkhasseiymd6) {
        vhsyudisptkkrkhasseiymd6 = pVhsyudisptkkrkhasseiymd6;
    }

    private String vhsyudisptksyouhnnm7;

    public String getVhsyudisptksyouhnnm7() {
        return vhsyudisptksyouhnnm7;
    }

    public void setVhsyudisptksyouhnnm7(String pVhsyudisptksyouhnnm7) {
        vhsyudisptksyouhnnm7 = pVhsyudisptksyouhnnm7;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu7;

    public C_Tuukasyu getVhsyudisptkktuukasyu7() {
        return vhsyudisptkktuukasyu7;
    }

    public void setVhsyudisptkktuukasyu7(C_Tuukasyu pVhsyudisptkktuukasyu7) {
        vhsyudisptkktuukasyu7 = pVhsyudisptkktuukasyu7;
    }

    private C_KataKbn vhsyudisptokyakukatakbn7;

    public C_KataKbn getVhsyudisptokyakukatakbn7() {
        return vhsyudisptokyakukatakbn7;
    }

    public void setVhsyudisptokyakukatakbn7(C_KataKbn pVhsyudisptokyakukatakbn7) {
        vhsyudisptokyakukatakbn7 = pVhsyudisptokyakukatakbn7;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn7;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn7() {
        return vhsyudisptkkyhgdkatakbn7;
    }

    public void setVhsyudisptkkyhgdkatakbn7(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn7) {
        vhsyudisptkkyhgdkatakbn7 = pVhsyudisptkkyhgdkatakbn7;
    }

    private Integer vhsyudisptkhhknnen7;

    public Integer getVhsyudisptkhhknnen7() {
        return vhsyudisptkhhknnen7;
    }

    public void setVhsyudisptkhhknnen7(Integer pVhsyudisptkhhknnen7) {
        vhsyudisptkhhknnen7 = pVhsyudisptkhhknnen7;
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

    private BizDate vhsyudisptkgaskkaisiymd7;

    public BizDate getVhsyudisptkgaskkaisiymd7() {
        return vhsyudisptkgaskkaisiymd7;
    }

    public void setVhsyudisptkgaskkaisiymd7(BizDate pVhsyudisptkgaskkaisiymd7) {
        vhsyudisptkgaskkaisiymd7 = pVhsyudisptkgaskkaisiymd7;
    }

    private BizDate vhsyudisptkhkskkaisiymd7;

    public BizDate getVhsyudisptkhkskkaisiymd7() {
        return vhsyudisptkhkskkaisiymd7;
    }

    public void setVhsyudisptkhkskkaisiymd7(BizDate pVhsyudisptkhkskkaisiymd7) {
        vhsyudisptkhkskkaisiymd7 = pVhsyudisptkhkskkaisiymd7;
    }

    private BizDate vhsyudisptkhkgskksiymd7;

    public BizDate getVhsyudisptkhkgskksiymd7() {
        return vhsyudisptkhkgskksiymd7;
    }

    public void setVhsyudisptkhkgskksiymd7(BizDate pVhsyudisptkhkgskksiymd7) {
        vhsyudisptkhkgskksiymd7 = pVhsyudisptkhkgskksiymd7;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn7;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn7() {
        return vhsyudisptkkihsyuruikbn7;
    }

    public void setVhsyudisptkkihsyuruikbn7(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn7) {
        vhsyudisptkkihsyuruikbn7 = pVhsyudisptkkihsyuruikbn7;
    }

    private BizCurrency vhsyudisptkkihons7;

    public BizCurrency getVhsyudisptkkihons7() {
        return vhsyudisptkkihons7;
    }

    public void setVhsyudisptkkihons7(BizCurrency pVhsyudisptkkihons7) {
        vhsyudisptkkihons7 = pVhsyudisptkkihons7;
    }

    private BizCurrency vhsyudisptktsnshrgndgk7;

    public BizCurrency getVhsyudisptktsnshrgndgk7() {
        return vhsyudisptktsnshrgndgk7;
    }

    public void setVhsyudisptktsnshrgndgk7(BizCurrency pVhsyudisptktsnshrgndgk7) {
        vhsyudisptktsnshrgndgk7 = pVhsyudisptktsnshrgndgk7;
    }

    private BizCurrency vhsyudisptkp7;

    public BizCurrency getVhsyudisptkp7() {
        return vhsyudisptkp7;
    }

    public void setVhsyudisptkp7(BizCurrency pVhsyudisptkp7) {
        vhsyudisptkp7 = pVhsyudisptkp7;
    }

    private BizCurrency vhsyudisptkkihonkyhgk7;

    public BizCurrency getVhsyudisptkkihonkyhgk7() {
        return vhsyudisptkkihonkyhgk7;
    }

    public void setVhsyudisptkkihonkyhgk7(BizCurrency pVhsyudisptkkihonkyhgk7) {
        vhsyudisptkkihonkyhgk7 = pVhsyudisptkkihonkyhgk7;
    }

    private BizCurrency vhsyudisptknextkosgop7;

    public BizCurrency getVhsyudisptknextkosgop7() {
        return vhsyudisptknextkosgop7;
    }

    public void setVhsyudisptknextkosgop7(BizCurrency pVhsyudisptknextkosgop7) {
        vhsyudisptknextkosgop7 = pVhsyudisptknextkosgop7;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn7;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn7() {
        return vhsyudisptksykyhkatakbn7;
    }

    public void setVhsyudisptksykyhkatakbn7(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn7) {
        vhsyudisptksykyhkatakbn7 = pVhsyudisptksykyhkatakbn7;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn7;

    public C_6daiLdKbn getVhsyudisptk6daildkbn7() {
        return vhsyudisptk6daildkbn7;
    }

    public void setVhsyudisptk6daildkbn7(C_6daiLdKbn pVhsyudisptk6daildkbn7) {
        vhsyudisptk6daildkbn7 = pVhsyudisptk6daildkbn7;
    }

    private BizCurrency vhsyudisptkganyukyhntgk7;

    public BizCurrency getVhsyudisptkganyukyhntgk7() {
        return vhsyudisptkganyukyhntgk7;
    }

    public void setVhsyudisptkganyukyhntgk7(BizCurrency pVhsyudisptkganyukyhntgk7) {
        vhsyudisptkganyukyhntgk7 = pVhsyudisptkganyukyhntgk7;
    }

    private BizDate vhsyudisptkshrskgstrymd7;

    public BizDate getVhsyudisptkshrskgstrymd7() {
        return vhsyudisptkshrskgstrymd7;
    }

    public void setVhsyudisptkshrskgstrymd7(BizDate pVhsyudisptkshrskgstrymd7) {
        vhsyudisptkshrskgstrymd7 = pVhsyudisptkshrskgstrymd7;
    }

    private BizDate vhsyudisptkshrskgnedymd7;

    public BizDate getVhsyudisptkshrskgnedymd7() {
        return vhsyudisptkshrskgnedymd7;
    }

    public void setVhsyudisptkshrskgnedymd7(BizDate pVhsyudisptkshrskgnedymd7) {
        vhsyudisptkshrskgnedymd7 = pVhsyudisptkshrskgnedymd7;
    }

    private BizCurrency vhsyudisptkshrskgngos7;

    public BizCurrency getVhsyudisptkshrskgngos7() {
        return vhsyudisptkshrskgngos7;
    }

    public void setVhsyudisptkshrskgngos7(BizCurrency pVhsyudisptkshrskgngos7) {
        vhsyudisptkshrskgngos7 = pVhsyudisptkshrskgngos7;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn7;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn7() {
        return vhsyudisptknenkinsyukbn7;
    }

    public void setVhsyudisptknenkinsyukbn7(C_Nenkinsyu pVhsyudisptknenkinsyukbn7) {
        vhsyudisptknenkinsyukbn7 = pVhsyudisptknenkinsyukbn7;
    }

    private Integer vhsyudisptknenkinkkn7;

    public Integer getVhsyudisptknenkinkkn7() {
        return vhsyudisptknenkinkkn7;
    }

    public void setVhsyudisptknenkinkkn7(Integer pVhsyudisptknenkinkkn7) {
        vhsyudisptknenkinkkn7 = pVhsyudisptknenkinkkn7;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn7;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn7() {
        return vhsyudisptktkjyskgnkkn7;
    }

    public void setVhsyudisptktkjyskgnkkn7(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn7) {
        vhsyudisptktkjyskgnkkn7 = pVhsyudisptktkjyskgnkkn7;
    }

    private BizDate vhsyudisptktkjkhkdsymd17;

    public BizDate getVhsyudisptktkjkhkdsymd17() {
        return vhsyudisptktkjkhkdsymd17;
    }

    public void setVhsyudisptktkjkhkdsymd17(BizDate pVhsyudisptktkjkhkdsymd17) {
        vhsyudisptktkjkhkdsymd17 = pVhsyudisptktkjkhkdsymd17;
    }

    private BizDate vhsyudisptktkjkhkdeymd17;

    public BizDate getVhsyudisptktkjkhkdeymd17() {
        return vhsyudisptktkjkhkdeymd17;
    }

    public void setVhsyudisptktkjkhkdeymd17(BizDate pVhsyudisptktkjkhkdeymd17) {
        vhsyudisptktkjkhkdeymd17 = pVhsyudisptktkjkhkdeymd17;
    }

    private BizCurrency vhsyudisptktkjyskgns17;

    public BizCurrency getVhsyudisptktkjyskgns17() {
        return vhsyudisptktkjyskgns17;
    }

    public void setVhsyudisptktkjyskgns17(BizCurrency pVhsyudisptktkjyskgns17) {
        vhsyudisptktkjyskgns17 = pVhsyudisptktkjyskgns17;
    }

    private BizDate vhsyudisptktkjkhkdsymd27;

    public BizDate getVhsyudisptktkjkhkdsymd27() {
        return vhsyudisptktkjkhkdsymd27;
    }

    public void setVhsyudisptktkjkhkdsymd27(BizDate pVhsyudisptktkjkhkdsymd27) {
        vhsyudisptktkjkhkdsymd27 = pVhsyudisptktkjkhkdsymd27;
    }

    private BizDate vhsyudisptktkjkhkdeymd27;

    public BizDate getVhsyudisptktkjkhkdeymd27() {
        return vhsyudisptktkjkhkdeymd27;
    }

    public void setVhsyudisptktkjkhkdeymd27(BizDate pVhsyudisptktkjkhkdeymd27) {
        vhsyudisptktkjkhkdeymd27 = pVhsyudisptktkjkhkdeymd27;
    }

    private BizCurrency vhsyudisptktkjyskgns27;

    public BizCurrency getVhsyudisptktkjyskgns27() {
        return vhsyudisptktkjyskgns27;
    }

    public void setVhsyudisptktkjyskgns27(BizCurrency pVhsyudisptktkjyskgns27) {
        vhsyudisptktkjyskgns27 = pVhsyudisptktkjyskgns27;
    }

    private BizDate vhsyudisptktkjkhkdsymd37;

    public BizDate getVhsyudisptktkjkhkdsymd37() {
        return vhsyudisptktkjkhkdsymd37;
    }

    public void setVhsyudisptktkjkhkdsymd37(BizDate pVhsyudisptktkjkhkdsymd37) {
        vhsyudisptktkjkhkdsymd37 = pVhsyudisptktkjkhkdsymd37;
    }

    private BizDate vhsyudisptktkjkhkdeymd37;

    public BizDate getVhsyudisptktkjkhkdeymd37() {
        return vhsyudisptktkjkhkdeymd37;
    }

    public void setVhsyudisptktkjkhkdeymd37(BizDate pVhsyudisptktkjkhkdeymd37) {
        vhsyudisptktkjkhkdeymd37 = pVhsyudisptktkjkhkdeymd37;
    }

    private BizCurrency vhsyudisptktkjyskgns37;

    public BizCurrency getVhsyudisptktkjyskgns37() {
        return vhsyudisptktkjyskgns37;
    }

    public void setVhsyudisptktkjyskgns37(BizCurrency pVhsyudisptktkjyskgns37) {
        vhsyudisptktkjyskgns37 = pVhsyudisptktkjyskgns37;
    }

    private BizDate vhsyudisptktkjkhkdsymd47;

    public BizDate getVhsyudisptktkjkhkdsymd47() {
        return vhsyudisptktkjkhkdsymd47;
    }

    public void setVhsyudisptktkjkhkdsymd47(BizDate pVhsyudisptktkjkhkdsymd47) {
        vhsyudisptktkjkhkdsymd47 = pVhsyudisptktkjkhkdsymd47;
    }

    private BizDate vhsyudisptktkjkhkdeymd47;

    public BizDate getVhsyudisptktkjkhkdeymd47() {
        return vhsyudisptktkjkhkdeymd47;
    }

    public void setVhsyudisptktkjkhkdeymd47(BizDate pVhsyudisptktkjkhkdeymd47) {
        vhsyudisptktkjkhkdeymd47 = pVhsyudisptktkjkhkdeymd47;
    }

    private BizCurrency vhsyudisptktkjyskgns47;

    public BizCurrency getVhsyudisptktkjyskgns47() {
        return vhsyudisptktkjyskgns47;
    }

    public void setVhsyudisptktkjyskgns47(BizCurrency pVhsyudisptktkjyskgns47) {
        vhsyudisptktkjyskgns47 = pVhsyudisptktkjyskgns47;
    }

    private BizDate vhsyudisptktkjkhkdsymd57;

    public BizDate getVhsyudisptktkjkhkdsymd57() {
        return vhsyudisptktkjkhkdsymd57;
    }

    public void setVhsyudisptktkjkhkdsymd57(BizDate pVhsyudisptktkjkhkdsymd57) {
        vhsyudisptktkjkhkdsymd57 = pVhsyudisptktkjkhkdsymd57;
    }

    private BizDate vhsyudisptktkjkhkdeymd57;

    public BizDate getVhsyudisptktkjkhkdeymd57() {
        return vhsyudisptktkjkhkdeymd57;
    }

    public void setVhsyudisptktkjkhkdeymd57(BizDate pVhsyudisptktkjkhkdeymd57) {
        vhsyudisptktkjkhkdeymd57 = pVhsyudisptktkjkhkdeymd57;
    }

    private BizCurrency vhsyudisptktkjyskgns57;

    public BizCurrency getVhsyudisptktkjyskgns57() {
        return vhsyudisptktkjyskgns57;
    }

    public void setVhsyudisptktkjyskgns57(BizCurrency pVhsyudisptktkjyskgns57) {
        vhsyudisptktkjyskgns57 = pVhsyudisptktkjyskgns57;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten7;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten7() {
        return vhsyudisptktkjyhyouten7;
    }

    public void setVhsyudisptktkjyhyouten7(C_Tkjyhyouten pVhsyudisptktkjyhyouten7) {
        vhsyudisptktkjyhyouten7 = pVhsyudisptktkjyhyouten7;
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

    private BizCurrency vhsyudisptktutakngk7;

    public BizCurrency getVhsyudisptktutakngk7() {
        return vhsyudisptktutakngk7;
    }

    public void setVhsyudisptktutakngk7(BizCurrency pVhsyudisptktutakngk7) {
        vhsyudisptktutakngk7 = pVhsyudisptktutakngk7;
    }

    private BizDate vhsyudisptkkrkhasseiymd7;

    public BizDate getVhsyudisptkkrkhasseiymd7() {
        return vhsyudisptkkrkhasseiymd7;
    }

    public void setVhsyudisptkkrkhasseiymd7(BizDate pVhsyudisptkkrkhasseiymd7) {
        vhsyudisptkkrkhasseiymd7 = pVhsyudisptkkrkhasseiymd7;
    }

    private String vhsyudisptksyouhnnm8;

    public String getVhsyudisptksyouhnnm8() {
        return vhsyudisptksyouhnnm8;
    }

    public void setVhsyudisptksyouhnnm8(String pVhsyudisptksyouhnnm8) {
        vhsyudisptksyouhnnm8 = pVhsyudisptksyouhnnm8;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu8;

    public C_Tuukasyu getVhsyudisptkktuukasyu8() {
        return vhsyudisptkktuukasyu8;
    }

    public void setVhsyudisptkktuukasyu8(C_Tuukasyu pVhsyudisptkktuukasyu8) {
        vhsyudisptkktuukasyu8 = pVhsyudisptkktuukasyu8;
    }

    private C_KataKbn vhsyudisptokyakukatakbn8;

    public C_KataKbn getVhsyudisptokyakukatakbn8() {
        return vhsyudisptokyakukatakbn8;
    }

    public void setVhsyudisptokyakukatakbn8(C_KataKbn pVhsyudisptokyakukatakbn8) {
        vhsyudisptokyakukatakbn8 = pVhsyudisptokyakukatakbn8;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn8;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn8() {
        return vhsyudisptkkyhgdkatakbn8;
    }

    public void setVhsyudisptkkyhgdkatakbn8(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn8) {
        vhsyudisptkkyhgdkatakbn8 = pVhsyudisptkkyhgdkatakbn8;
    }

    private Integer vhsyudisptkhhknnen8;

    public Integer getVhsyudisptkhhknnen8() {
        return vhsyudisptkhhknnen8;
    }

    public void setVhsyudisptkhhknnen8(Integer pVhsyudisptkhhknnen8) {
        vhsyudisptkhhknnen8 = pVhsyudisptkhhknnen8;
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

    private BizDate vhsyudisptkgaskkaisiymd8;

    public BizDate getVhsyudisptkgaskkaisiymd8() {
        return vhsyudisptkgaskkaisiymd8;
    }

    public void setVhsyudisptkgaskkaisiymd8(BizDate pVhsyudisptkgaskkaisiymd8) {
        vhsyudisptkgaskkaisiymd8 = pVhsyudisptkgaskkaisiymd8;
    }

    private BizDate vhsyudisptkhkskkaisiymd8;

    public BizDate getVhsyudisptkhkskkaisiymd8() {
        return vhsyudisptkhkskkaisiymd8;
    }

    public void setVhsyudisptkhkskkaisiymd8(BizDate pVhsyudisptkhkskkaisiymd8) {
        vhsyudisptkhkskkaisiymd8 = pVhsyudisptkhkskkaisiymd8;
    }

    private BizDate vhsyudisptkhkgskksiymd8;

    public BizDate getVhsyudisptkhkgskksiymd8() {
        return vhsyudisptkhkgskksiymd8;
    }

    public void setVhsyudisptkhkgskksiymd8(BizDate pVhsyudisptkhkgskksiymd8) {
        vhsyudisptkhkgskksiymd8 = pVhsyudisptkhkgskksiymd8;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn8;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn8() {
        return vhsyudisptkkihsyuruikbn8;
    }

    public void setVhsyudisptkkihsyuruikbn8(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn8) {
        vhsyudisptkkihsyuruikbn8 = pVhsyudisptkkihsyuruikbn8;
    }

    private BizCurrency vhsyudisptkkihons8;

    public BizCurrency getVhsyudisptkkihons8() {
        return vhsyudisptkkihons8;
    }

    public void setVhsyudisptkkihons8(BizCurrency pVhsyudisptkkihons8) {
        vhsyudisptkkihons8 = pVhsyudisptkkihons8;
    }

    private BizCurrency vhsyudisptktsnshrgndgk8;

    public BizCurrency getVhsyudisptktsnshrgndgk8() {
        return vhsyudisptktsnshrgndgk8;
    }

    public void setVhsyudisptktsnshrgndgk8(BizCurrency pVhsyudisptktsnshrgndgk8) {
        vhsyudisptktsnshrgndgk8 = pVhsyudisptktsnshrgndgk8;
    }

    private BizCurrency vhsyudisptkp8;

    public BizCurrency getVhsyudisptkp8() {
        return vhsyudisptkp8;
    }

    public void setVhsyudisptkp8(BizCurrency pVhsyudisptkp8) {
        vhsyudisptkp8 = pVhsyudisptkp8;
    }

    private BizCurrency vhsyudisptkkihonkyhgk8;

    public BizCurrency getVhsyudisptkkihonkyhgk8() {
        return vhsyudisptkkihonkyhgk8;
    }

    public void setVhsyudisptkkihonkyhgk8(BizCurrency pVhsyudisptkkihonkyhgk8) {
        vhsyudisptkkihonkyhgk8 = pVhsyudisptkkihonkyhgk8;
    }

    private BizCurrency vhsyudisptknextkosgop8;

    public BizCurrency getVhsyudisptknextkosgop8() {
        return vhsyudisptknextkosgop8;
    }

    public void setVhsyudisptknextkosgop8(BizCurrency pVhsyudisptknextkosgop8) {
        vhsyudisptknextkosgop8 = pVhsyudisptknextkosgop8;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn8;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn8() {
        return vhsyudisptksykyhkatakbn8;
    }

    public void setVhsyudisptksykyhkatakbn8(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn8) {
        vhsyudisptksykyhkatakbn8 = pVhsyudisptksykyhkatakbn8;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn8;

    public C_6daiLdKbn getVhsyudisptk6daildkbn8() {
        return vhsyudisptk6daildkbn8;
    }

    public void setVhsyudisptk6daildkbn8(C_6daiLdKbn pVhsyudisptk6daildkbn8) {
        vhsyudisptk6daildkbn8 = pVhsyudisptk6daildkbn8;
    }

    private BizCurrency vhsyudisptkganyukyhntgk8;

    public BizCurrency getVhsyudisptkganyukyhntgk8() {
        return vhsyudisptkganyukyhntgk8;
    }

    public void setVhsyudisptkganyukyhntgk8(BizCurrency pVhsyudisptkganyukyhntgk8) {
        vhsyudisptkganyukyhntgk8 = pVhsyudisptkganyukyhntgk8;
    }

    private BizDate vhsyudisptkshrskgstrymd8;

    public BizDate getVhsyudisptkshrskgstrymd8() {
        return vhsyudisptkshrskgstrymd8;
    }

    public void setVhsyudisptkshrskgstrymd8(BizDate pVhsyudisptkshrskgstrymd8) {
        vhsyudisptkshrskgstrymd8 = pVhsyudisptkshrskgstrymd8;
    }

    private BizDate vhsyudisptkshrskgnedymd8;

    public BizDate getVhsyudisptkshrskgnedymd8() {
        return vhsyudisptkshrskgnedymd8;
    }

    public void setVhsyudisptkshrskgnedymd8(BizDate pVhsyudisptkshrskgnedymd8) {
        vhsyudisptkshrskgnedymd8 = pVhsyudisptkshrskgnedymd8;
    }

    private BizCurrency vhsyudisptkshrskgngos8;

    public BizCurrency getVhsyudisptkshrskgngos8() {
        return vhsyudisptkshrskgngos8;
    }

    public void setVhsyudisptkshrskgngos8(BizCurrency pVhsyudisptkshrskgngos8) {
        vhsyudisptkshrskgngos8 = pVhsyudisptkshrskgngos8;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn8;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn8() {
        return vhsyudisptknenkinsyukbn8;
    }

    public void setVhsyudisptknenkinsyukbn8(C_Nenkinsyu pVhsyudisptknenkinsyukbn8) {
        vhsyudisptknenkinsyukbn8 = pVhsyudisptknenkinsyukbn8;
    }

    private Integer vhsyudisptknenkinkkn8;

    public Integer getVhsyudisptknenkinkkn8() {
        return vhsyudisptknenkinkkn8;
    }

    public void setVhsyudisptknenkinkkn8(Integer pVhsyudisptknenkinkkn8) {
        vhsyudisptknenkinkkn8 = pVhsyudisptknenkinkkn8;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn8;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn8() {
        return vhsyudisptktkjyskgnkkn8;
    }

    public void setVhsyudisptktkjyskgnkkn8(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn8) {
        vhsyudisptktkjyskgnkkn8 = pVhsyudisptktkjyskgnkkn8;
    }

    private BizDate vhsyudisptktkjkhkdsymd18;

    public BizDate getVhsyudisptktkjkhkdsymd18() {
        return vhsyudisptktkjkhkdsymd18;
    }

    public void setVhsyudisptktkjkhkdsymd18(BizDate pVhsyudisptktkjkhkdsymd18) {
        vhsyudisptktkjkhkdsymd18 = pVhsyudisptktkjkhkdsymd18;
    }

    private BizDate vhsyudisptktkjkhkdeymd18;

    public BizDate getVhsyudisptktkjkhkdeymd18() {
        return vhsyudisptktkjkhkdeymd18;
    }

    public void setVhsyudisptktkjkhkdeymd18(BizDate pVhsyudisptktkjkhkdeymd18) {
        vhsyudisptktkjkhkdeymd18 = pVhsyudisptktkjkhkdeymd18;
    }

    private BizCurrency vhsyudisptktkjyskgns18;

    public BizCurrency getVhsyudisptktkjyskgns18() {
        return vhsyudisptktkjyskgns18;
    }

    public void setVhsyudisptktkjyskgns18(BizCurrency pVhsyudisptktkjyskgns18) {
        vhsyudisptktkjyskgns18 = pVhsyudisptktkjyskgns18;
    }

    private BizDate vhsyudisptktkjkhkdsymd28;

    public BizDate getVhsyudisptktkjkhkdsymd28() {
        return vhsyudisptktkjkhkdsymd28;
    }

    public void setVhsyudisptktkjkhkdsymd28(BizDate pVhsyudisptktkjkhkdsymd28) {
        vhsyudisptktkjkhkdsymd28 = pVhsyudisptktkjkhkdsymd28;
    }

    private BizDate vhsyudisptktkjkhkdeymd28;

    public BizDate getVhsyudisptktkjkhkdeymd28() {
        return vhsyudisptktkjkhkdeymd28;
    }

    public void setVhsyudisptktkjkhkdeymd28(BizDate pVhsyudisptktkjkhkdeymd28) {
        vhsyudisptktkjkhkdeymd28 = pVhsyudisptktkjkhkdeymd28;
    }

    private BizCurrency vhsyudisptktkjyskgns28;

    public BizCurrency getVhsyudisptktkjyskgns28() {
        return vhsyudisptktkjyskgns28;
    }

    public void setVhsyudisptktkjyskgns28(BizCurrency pVhsyudisptktkjyskgns28) {
        vhsyudisptktkjyskgns28 = pVhsyudisptktkjyskgns28;
    }

    private BizDate vhsyudisptktkjkhkdsymd38;

    public BizDate getVhsyudisptktkjkhkdsymd38() {
        return vhsyudisptktkjkhkdsymd38;
    }

    public void setVhsyudisptktkjkhkdsymd38(BizDate pVhsyudisptktkjkhkdsymd38) {
        vhsyudisptktkjkhkdsymd38 = pVhsyudisptktkjkhkdsymd38;
    }

    private BizDate vhsyudisptktkjkhkdeymd38;

    public BizDate getVhsyudisptktkjkhkdeymd38() {
        return vhsyudisptktkjkhkdeymd38;
    }

    public void setVhsyudisptktkjkhkdeymd38(BizDate pVhsyudisptktkjkhkdeymd38) {
        vhsyudisptktkjkhkdeymd38 = pVhsyudisptktkjkhkdeymd38;
    }

    private BizCurrency vhsyudisptktkjyskgns38;

    public BizCurrency getVhsyudisptktkjyskgns38() {
        return vhsyudisptktkjyskgns38;
    }

    public void setVhsyudisptktkjyskgns38(BizCurrency pVhsyudisptktkjyskgns38) {
        vhsyudisptktkjyskgns38 = pVhsyudisptktkjyskgns38;
    }

    private BizDate vhsyudisptktkjkhkdsymd48;

    public BizDate getVhsyudisptktkjkhkdsymd48() {
        return vhsyudisptktkjkhkdsymd48;
    }

    public void setVhsyudisptktkjkhkdsymd48(BizDate pVhsyudisptktkjkhkdsymd48) {
        vhsyudisptktkjkhkdsymd48 = pVhsyudisptktkjkhkdsymd48;
    }

    private BizDate vhsyudisptktkjkhkdeymd48;

    public BizDate getVhsyudisptktkjkhkdeymd48() {
        return vhsyudisptktkjkhkdeymd48;
    }

    public void setVhsyudisptktkjkhkdeymd48(BizDate pVhsyudisptktkjkhkdeymd48) {
        vhsyudisptktkjkhkdeymd48 = pVhsyudisptktkjkhkdeymd48;
    }

    private BizCurrency vhsyudisptktkjyskgns48;

    public BizCurrency getVhsyudisptktkjyskgns48() {
        return vhsyudisptktkjyskgns48;
    }

    public void setVhsyudisptktkjyskgns48(BizCurrency pVhsyudisptktkjyskgns48) {
        vhsyudisptktkjyskgns48 = pVhsyudisptktkjyskgns48;
    }

    private BizDate vhsyudisptktkjkhkdsymd58;

    public BizDate getVhsyudisptktkjkhkdsymd58() {
        return vhsyudisptktkjkhkdsymd58;
    }

    public void setVhsyudisptktkjkhkdsymd58(BizDate pVhsyudisptktkjkhkdsymd58) {
        vhsyudisptktkjkhkdsymd58 = pVhsyudisptktkjkhkdsymd58;
    }

    private BizDate vhsyudisptktkjkhkdeymd58;

    public BizDate getVhsyudisptktkjkhkdeymd58() {
        return vhsyudisptktkjkhkdeymd58;
    }

    public void setVhsyudisptktkjkhkdeymd58(BizDate pVhsyudisptktkjkhkdeymd58) {
        vhsyudisptktkjkhkdeymd58 = pVhsyudisptktkjkhkdeymd58;
    }

    private BizCurrency vhsyudisptktkjyskgns58;

    public BizCurrency getVhsyudisptktkjyskgns58() {
        return vhsyudisptktkjyskgns58;
    }

    public void setVhsyudisptktkjyskgns58(BizCurrency pVhsyudisptktkjyskgns58) {
        vhsyudisptktkjyskgns58 = pVhsyudisptktkjyskgns58;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten8;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten8() {
        return vhsyudisptktkjyhyouten8;
    }

    public void setVhsyudisptktkjyhyouten8(C_Tkjyhyouten pVhsyudisptktkjyhyouten8) {
        vhsyudisptktkjyhyouten8 = pVhsyudisptktkjyhyouten8;
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

    private BizCurrency vhsyudisptktutakngk8;

    public BizCurrency getVhsyudisptktutakngk8() {
        return vhsyudisptktutakngk8;
    }

    public void setVhsyudisptktutakngk8(BizCurrency pVhsyudisptktutakngk8) {
        vhsyudisptktutakngk8 = pVhsyudisptktutakngk8;
    }

    private BizDate vhsyudisptkkrkhasseiymd8;

    public BizDate getVhsyudisptkkrkhasseiymd8() {
        return vhsyudisptkkrkhasseiymd8;
    }

    public void setVhsyudisptkkrkhasseiymd8(BizDate pVhsyudisptkkrkhasseiymd8) {
        vhsyudisptkkrkhasseiymd8 = pVhsyudisptkkrkhasseiymd8;
    }

    private String vhsyudisptksyouhnnm9;

    public String getVhsyudisptksyouhnnm9() {
        return vhsyudisptksyouhnnm9;
    }

    public void setVhsyudisptksyouhnnm9(String pVhsyudisptksyouhnnm9) {
        vhsyudisptksyouhnnm9 = pVhsyudisptksyouhnnm9;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu9;

    public C_Tuukasyu getVhsyudisptkktuukasyu9() {
        return vhsyudisptkktuukasyu9;
    }

    public void setVhsyudisptkktuukasyu9(C_Tuukasyu pVhsyudisptkktuukasyu9) {
        vhsyudisptkktuukasyu9 = pVhsyudisptkktuukasyu9;
    }

    private C_KataKbn vhsyudisptokyakukatakbn9;

    public C_KataKbn getVhsyudisptokyakukatakbn9() {
        return vhsyudisptokyakukatakbn9;
    }

    public void setVhsyudisptokyakukatakbn9(C_KataKbn pVhsyudisptokyakukatakbn9) {
        vhsyudisptokyakukatakbn9 = pVhsyudisptokyakukatakbn9;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn9;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn9() {
        return vhsyudisptkkyhgdkatakbn9;
    }

    public void setVhsyudisptkkyhgdkatakbn9(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn9) {
        vhsyudisptkkyhgdkatakbn9 = pVhsyudisptkkyhgdkatakbn9;
    }

    private Integer vhsyudisptkhhknnen9;

    public Integer getVhsyudisptkhhknnen9() {
        return vhsyudisptkhhknnen9;
    }

    public void setVhsyudisptkhhknnen9(Integer pVhsyudisptkhhknnen9) {
        vhsyudisptkhhknnen9 = pVhsyudisptkhhknnen9;
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

    private BizDate vhsyudisptkgaskkaisiymd9;

    public BizDate getVhsyudisptkgaskkaisiymd9() {
        return vhsyudisptkgaskkaisiymd9;
    }

    public void setVhsyudisptkgaskkaisiymd9(BizDate pVhsyudisptkgaskkaisiymd9) {
        vhsyudisptkgaskkaisiymd9 = pVhsyudisptkgaskkaisiymd9;
    }

    private BizDate vhsyudisptkhkskkaisiymd9;

    public BizDate getVhsyudisptkhkskkaisiymd9() {
        return vhsyudisptkhkskkaisiymd9;
    }

    public void setVhsyudisptkhkskkaisiymd9(BizDate pVhsyudisptkhkskkaisiymd9) {
        vhsyudisptkhkskkaisiymd9 = pVhsyudisptkhkskkaisiymd9;
    }

    private BizDate vhsyudisptkhkgskksiymd9;

    public BizDate getVhsyudisptkhkgskksiymd9() {
        return vhsyudisptkhkgskksiymd9;
    }

    public void setVhsyudisptkhkgskksiymd9(BizDate pVhsyudisptkhkgskksiymd9) {
        vhsyudisptkhkgskksiymd9 = pVhsyudisptkhkgskksiymd9;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn9;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn9() {
        return vhsyudisptkkihsyuruikbn9;
    }

    public void setVhsyudisptkkihsyuruikbn9(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn9) {
        vhsyudisptkkihsyuruikbn9 = pVhsyudisptkkihsyuruikbn9;
    }

    private BizCurrency vhsyudisptkkihons9;

    public BizCurrency getVhsyudisptkkihons9() {
        return vhsyudisptkkihons9;
    }

    public void setVhsyudisptkkihons9(BizCurrency pVhsyudisptkkihons9) {
        vhsyudisptkkihons9 = pVhsyudisptkkihons9;
    }

    private BizCurrency vhsyudisptktsnshrgndgk9;

    public BizCurrency getVhsyudisptktsnshrgndgk9() {
        return vhsyudisptktsnshrgndgk9;
    }

    public void setVhsyudisptktsnshrgndgk9(BizCurrency pVhsyudisptktsnshrgndgk9) {
        vhsyudisptktsnshrgndgk9 = pVhsyudisptktsnshrgndgk9;
    }

    private BizCurrency vhsyudisptkp9;

    public BizCurrency getVhsyudisptkp9() {
        return vhsyudisptkp9;
    }

    public void setVhsyudisptkp9(BizCurrency pVhsyudisptkp9) {
        vhsyudisptkp9 = pVhsyudisptkp9;
    }

    private BizCurrency vhsyudisptkkihonkyhgk9;

    public BizCurrency getVhsyudisptkkihonkyhgk9() {
        return vhsyudisptkkihonkyhgk9;
    }

    public void setVhsyudisptkkihonkyhgk9(BizCurrency pVhsyudisptkkihonkyhgk9) {
        vhsyudisptkkihonkyhgk9 = pVhsyudisptkkihonkyhgk9;
    }

    private BizCurrency vhsyudisptknextkosgop9;

    public BizCurrency getVhsyudisptknextkosgop9() {
        return vhsyudisptknextkosgop9;
    }

    public void setVhsyudisptknextkosgop9(BizCurrency pVhsyudisptknextkosgop9) {
        vhsyudisptknextkosgop9 = pVhsyudisptknextkosgop9;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn9;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn9() {
        return vhsyudisptksykyhkatakbn9;
    }

    public void setVhsyudisptksykyhkatakbn9(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn9) {
        vhsyudisptksykyhkatakbn9 = pVhsyudisptksykyhkatakbn9;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn9;

    public C_6daiLdKbn getVhsyudisptk6daildkbn9() {
        return vhsyudisptk6daildkbn9;
    }

    public void setVhsyudisptk6daildkbn9(C_6daiLdKbn pVhsyudisptk6daildkbn9) {
        vhsyudisptk6daildkbn9 = pVhsyudisptk6daildkbn9;
    }

    private BizCurrency vhsyudisptkganyukyhntgk9;

    public BizCurrency getVhsyudisptkganyukyhntgk9() {
        return vhsyudisptkganyukyhntgk9;
    }

    public void setVhsyudisptkganyukyhntgk9(BizCurrency pVhsyudisptkganyukyhntgk9) {
        vhsyudisptkganyukyhntgk9 = pVhsyudisptkganyukyhntgk9;
    }

    private BizDate vhsyudisptkshrskgstrymd9;

    public BizDate getVhsyudisptkshrskgstrymd9() {
        return vhsyudisptkshrskgstrymd9;
    }

    public void setVhsyudisptkshrskgstrymd9(BizDate pVhsyudisptkshrskgstrymd9) {
        vhsyudisptkshrskgstrymd9 = pVhsyudisptkshrskgstrymd9;
    }

    private BizDate vhsyudisptkshrskgnedymd9;

    public BizDate getVhsyudisptkshrskgnedymd9() {
        return vhsyudisptkshrskgnedymd9;
    }

    public void setVhsyudisptkshrskgnedymd9(BizDate pVhsyudisptkshrskgnedymd9) {
        vhsyudisptkshrskgnedymd9 = pVhsyudisptkshrskgnedymd9;
    }

    private BizCurrency vhsyudisptkshrskgngos9;

    public BizCurrency getVhsyudisptkshrskgngos9() {
        return vhsyudisptkshrskgngos9;
    }

    public void setVhsyudisptkshrskgngos9(BizCurrency pVhsyudisptkshrskgngos9) {
        vhsyudisptkshrskgngos9 = pVhsyudisptkshrskgngos9;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn9;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn9() {
        return vhsyudisptknenkinsyukbn9;
    }

    public void setVhsyudisptknenkinsyukbn9(C_Nenkinsyu pVhsyudisptknenkinsyukbn9) {
        vhsyudisptknenkinsyukbn9 = pVhsyudisptknenkinsyukbn9;
    }

    private Integer vhsyudisptknenkinkkn9;

    public Integer getVhsyudisptknenkinkkn9() {
        return vhsyudisptknenkinkkn9;
    }

    public void setVhsyudisptknenkinkkn9(Integer pVhsyudisptknenkinkkn9) {
        vhsyudisptknenkinkkn9 = pVhsyudisptknenkinkkn9;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn9;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn9() {
        return vhsyudisptktkjyskgnkkn9;
    }

    public void setVhsyudisptktkjyskgnkkn9(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn9) {
        vhsyudisptktkjyskgnkkn9 = pVhsyudisptktkjyskgnkkn9;
    }

    private BizDate vhsyudisptktkjkhkdsymd19;

    public BizDate getVhsyudisptktkjkhkdsymd19() {
        return vhsyudisptktkjkhkdsymd19;
    }

    public void setVhsyudisptktkjkhkdsymd19(BizDate pVhsyudisptktkjkhkdsymd19) {
        vhsyudisptktkjkhkdsymd19 = pVhsyudisptktkjkhkdsymd19;
    }

    private BizDate vhsyudisptktkjkhkdeymd19;

    public BizDate getVhsyudisptktkjkhkdeymd19() {
        return vhsyudisptktkjkhkdeymd19;
    }

    public void setVhsyudisptktkjkhkdeymd19(BizDate pVhsyudisptktkjkhkdeymd19) {
        vhsyudisptktkjkhkdeymd19 = pVhsyudisptktkjkhkdeymd19;
    }

    private BizCurrency vhsyudisptktkjyskgns19;

    public BizCurrency getVhsyudisptktkjyskgns19() {
        return vhsyudisptktkjyskgns19;
    }

    public void setVhsyudisptktkjyskgns19(BizCurrency pVhsyudisptktkjyskgns19) {
        vhsyudisptktkjyskgns19 = pVhsyudisptktkjyskgns19;
    }

    private BizDate vhsyudisptktkjkhkdsymd29;

    public BizDate getVhsyudisptktkjkhkdsymd29() {
        return vhsyudisptktkjkhkdsymd29;
    }

    public void setVhsyudisptktkjkhkdsymd29(BizDate pVhsyudisptktkjkhkdsymd29) {
        vhsyudisptktkjkhkdsymd29 = pVhsyudisptktkjkhkdsymd29;
    }

    private BizDate vhsyudisptktkjkhkdeymd29;

    public BizDate getVhsyudisptktkjkhkdeymd29() {
        return vhsyudisptktkjkhkdeymd29;
    }

    public void setVhsyudisptktkjkhkdeymd29(BizDate pVhsyudisptktkjkhkdeymd29) {
        vhsyudisptktkjkhkdeymd29 = pVhsyudisptktkjkhkdeymd29;
    }

    private BizCurrency vhsyudisptktkjyskgns29;

    public BizCurrency getVhsyudisptktkjyskgns29() {
        return vhsyudisptktkjyskgns29;
    }

    public void setVhsyudisptktkjyskgns29(BizCurrency pVhsyudisptktkjyskgns29) {
        vhsyudisptktkjyskgns29 = pVhsyudisptktkjyskgns29;
    }

    private BizDate vhsyudisptktkjkhkdsymd39;

    public BizDate getVhsyudisptktkjkhkdsymd39() {
        return vhsyudisptktkjkhkdsymd39;
    }

    public void setVhsyudisptktkjkhkdsymd39(BizDate pVhsyudisptktkjkhkdsymd39) {
        vhsyudisptktkjkhkdsymd39 = pVhsyudisptktkjkhkdsymd39;
    }

    private BizDate vhsyudisptktkjkhkdeymd39;

    public BizDate getVhsyudisptktkjkhkdeymd39() {
        return vhsyudisptktkjkhkdeymd39;
    }

    public void setVhsyudisptktkjkhkdeymd39(BizDate pVhsyudisptktkjkhkdeymd39) {
        vhsyudisptktkjkhkdeymd39 = pVhsyudisptktkjkhkdeymd39;
    }

    private BizCurrency vhsyudisptktkjyskgns39;

    public BizCurrency getVhsyudisptktkjyskgns39() {
        return vhsyudisptktkjyskgns39;
    }

    public void setVhsyudisptktkjyskgns39(BizCurrency pVhsyudisptktkjyskgns39) {
        vhsyudisptktkjyskgns39 = pVhsyudisptktkjyskgns39;
    }

    private BizDate vhsyudisptktkjkhkdsymd49;

    public BizDate getVhsyudisptktkjkhkdsymd49() {
        return vhsyudisptktkjkhkdsymd49;
    }

    public void setVhsyudisptktkjkhkdsymd49(BizDate pVhsyudisptktkjkhkdsymd49) {
        vhsyudisptktkjkhkdsymd49 = pVhsyudisptktkjkhkdsymd49;
    }

    private BizDate vhsyudisptktkjkhkdeymd49;

    public BizDate getVhsyudisptktkjkhkdeymd49() {
        return vhsyudisptktkjkhkdeymd49;
    }

    public void setVhsyudisptktkjkhkdeymd49(BizDate pVhsyudisptktkjkhkdeymd49) {
        vhsyudisptktkjkhkdeymd49 = pVhsyudisptktkjkhkdeymd49;
    }

    private BizCurrency vhsyudisptktkjyskgns49;

    public BizCurrency getVhsyudisptktkjyskgns49() {
        return vhsyudisptktkjyskgns49;
    }

    public void setVhsyudisptktkjyskgns49(BizCurrency pVhsyudisptktkjyskgns49) {
        vhsyudisptktkjyskgns49 = pVhsyudisptktkjyskgns49;
    }

    private BizDate vhsyudisptktkjkhkdsymd59;

    public BizDate getVhsyudisptktkjkhkdsymd59() {
        return vhsyudisptktkjkhkdsymd59;
    }

    public void setVhsyudisptktkjkhkdsymd59(BizDate pVhsyudisptktkjkhkdsymd59) {
        vhsyudisptktkjkhkdsymd59 = pVhsyudisptktkjkhkdsymd59;
    }

    private BizDate vhsyudisptktkjkhkdeymd59;

    public BizDate getVhsyudisptktkjkhkdeymd59() {
        return vhsyudisptktkjkhkdeymd59;
    }

    public void setVhsyudisptktkjkhkdeymd59(BizDate pVhsyudisptktkjkhkdeymd59) {
        vhsyudisptktkjkhkdeymd59 = pVhsyudisptktkjkhkdeymd59;
    }

    private BizCurrency vhsyudisptktkjyskgns59;

    public BizCurrency getVhsyudisptktkjyskgns59() {
        return vhsyudisptktkjyskgns59;
    }

    public void setVhsyudisptktkjyskgns59(BizCurrency pVhsyudisptktkjyskgns59) {
        vhsyudisptktkjyskgns59 = pVhsyudisptktkjyskgns59;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten9;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten9() {
        return vhsyudisptktkjyhyouten9;
    }

    public void setVhsyudisptktkjyhyouten9(C_Tkjyhyouten pVhsyudisptktkjyhyouten9) {
        vhsyudisptktkjyhyouten9 = pVhsyudisptktkjyhyouten9;
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

    private BizCurrency vhsyudisptktutakngk9;

    public BizCurrency getVhsyudisptktutakngk9() {
        return vhsyudisptktutakngk9;
    }

    public void setVhsyudisptktutakngk9(BizCurrency pVhsyudisptktutakngk9) {
        vhsyudisptktutakngk9 = pVhsyudisptktutakngk9;
    }

    private BizDate vhsyudisptkkrkhasseiymd9;

    public BizDate getVhsyudisptkkrkhasseiymd9() {
        return vhsyudisptkkrkhasseiymd9;
    }

    public void setVhsyudisptkkrkhasseiymd9(BizDate pVhsyudisptkkrkhasseiymd9) {
        vhsyudisptkkrkhasseiymd9 = pVhsyudisptkkrkhasseiymd9;
    }

    private String vhsyudisptksyouhnnm10;

    public String getVhsyudisptksyouhnnm10() {
        return vhsyudisptksyouhnnm10;
    }

    public void setVhsyudisptksyouhnnm10(String pVhsyudisptksyouhnnm10) {
        vhsyudisptksyouhnnm10 = pVhsyudisptksyouhnnm10;
    }

    private C_Tuukasyu vhsyudisptkktuukasyu10;

    public C_Tuukasyu getVhsyudisptkktuukasyu10() {
        return vhsyudisptkktuukasyu10;
    }

    public void setVhsyudisptkktuukasyu10(C_Tuukasyu pVhsyudisptkktuukasyu10) {
        vhsyudisptkktuukasyu10 = pVhsyudisptkktuukasyu10;
    }

    private C_KataKbn vhsyudisptokyakukatakbn10;

    public C_KataKbn getVhsyudisptokyakukatakbn10() {
        return vhsyudisptokyakukatakbn10;
    }

    public void setVhsyudisptokyakukatakbn10(C_KataKbn pVhsyudisptokyakukatakbn10) {
        vhsyudisptokyakukatakbn10 = pVhsyudisptokyakukatakbn10;
    }

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn10;

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn10() {
        return vhsyudisptkkyhgdkatakbn10;
    }

    public void setVhsyudisptkkyhgdkatakbn10(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn10) {
        vhsyudisptkkyhgdkatakbn10 = pVhsyudisptkkyhgdkatakbn10;
    }

    private Integer vhsyudisptkhhknnen10;

    public Integer getVhsyudisptkhhknnen10() {
        return vhsyudisptkhhknnen10;
    }

    public void setVhsyudisptkhhknnen10(Integer pVhsyudisptkhhknnen10) {
        vhsyudisptkhhknnen10 = pVhsyudisptkhhknnen10;
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

    private BizDate vhsyudisptkgaskkaisiymd10;

    public BizDate getVhsyudisptkgaskkaisiymd10() {
        return vhsyudisptkgaskkaisiymd10;
    }

    public void setVhsyudisptkgaskkaisiymd10(BizDate pVhsyudisptkgaskkaisiymd10) {
        vhsyudisptkgaskkaisiymd10 = pVhsyudisptkgaskkaisiymd10;
    }

    private BizDate vhsyudisptkhkskkaisiymd10;

    public BizDate getVhsyudisptkhkskkaisiymd10() {
        return vhsyudisptkhkskkaisiymd10;
    }

    public void setVhsyudisptkhkskkaisiymd10(BizDate pVhsyudisptkhkskkaisiymd10) {
        vhsyudisptkhkskkaisiymd10 = pVhsyudisptkhkskkaisiymd10;
    }

    private BizDate vhsyudisptkhkgskksiymd10;

    public BizDate getVhsyudisptkhkgskksiymd10() {
        return vhsyudisptkhkgskksiymd10;
    }

    public void setVhsyudisptkhkgskksiymd10(BizDate pVhsyudisptkhkgskksiymd10) {
        vhsyudisptkhkgskksiymd10 = pVhsyudisptkhkgskksiymd10;
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

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn10;

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn10() {
        return vhsyudisptkkihsyuruikbn10;
    }

    public void setVhsyudisptkkihsyuruikbn10(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn10) {
        vhsyudisptkkihsyuruikbn10 = pVhsyudisptkkihsyuruikbn10;
    }

    private BizCurrency vhsyudisptkkihons10;

    public BizCurrency getVhsyudisptkkihons10() {
        return vhsyudisptkkihons10;
    }

    public void setVhsyudisptkkihons10(BizCurrency pVhsyudisptkkihons10) {
        vhsyudisptkkihons10 = pVhsyudisptkkihons10;
    }

    private BizCurrency vhsyudisptktsnshrgndgk10;

    public BizCurrency getVhsyudisptktsnshrgndgk10() {
        return vhsyudisptktsnshrgndgk10;
    }

    public void setVhsyudisptktsnshrgndgk10(BizCurrency pVhsyudisptktsnshrgndgk10) {
        vhsyudisptktsnshrgndgk10 = pVhsyudisptktsnshrgndgk10;
    }

    private BizCurrency vhsyudisptkp10;

    public BizCurrency getVhsyudisptkp10() {
        return vhsyudisptkp10;
    }

    public void setVhsyudisptkp10(BizCurrency pVhsyudisptkp10) {
        vhsyudisptkp10 = pVhsyudisptkp10;
    }

    private BizCurrency vhsyudisptkkihonkyhgk10;

    public BizCurrency getVhsyudisptkkihonkyhgk10() {
        return vhsyudisptkkihonkyhgk10;
    }

    public void setVhsyudisptkkihonkyhgk10(BizCurrency pVhsyudisptkkihonkyhgk10) {
        vhsyudisptkkihonkyhgk10 = pVhsyudisptkkihonkyhgk10;
    }

    private BizCurrency vhsyudisptknextkosgop10;

    public BizCurrency getVhsyudisptknextkosgop10() {
        return vhsyudisptknextkosgop10;
    }

    public void setVhsyudisptknextkosgop10(BizCurrency pVhsyudisptknextkosgop10) {
        vhsyudisptknextkosgop10 = pVhsyudisptknextkosgop10;
    }

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn10;

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn10() {
        return vhsyudisptksykyhkatakbn10;
    }

    public void setVhsyudisptksykyhkatakbn10(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn10) {
        vhsyudisptksykyhkatakbn10 = pVhsyudisptksykyhkatakbn10;
    }

    private C_6daiLdKbn vhsyudisptk6daildkbn10;

    public C_6daiLdKbn getVhsyudisptk6daildkbn10() {
        return vhsyudisptk6daildkbn10;
    }

    public void setVhsyudisptk6daildkbn10(C_6daiLdKbn pVhsyudisptk6daildkbn10) {
        vhsyudisptk6daildkbn10 = pVhsyudisptk6daildkbn10;
    }

    private BizCurrency vhsyudisptkganyukyhntgk10;

    public BizCurrency getVhsyudisptkganyukyhntgk10() {
        return vhsyudisptkganyukyhntgk10;
    }

    public void setVhsyudisptkganyukyhntgk10(BizCurrency pVhsyudisptkganyukyhntgk10) {
        vhsyudisptkganyukyhntgk10 = pVhsyudisptkganyukyhntgk10;
    }

    private BizDate vhsyudisptkshrskgstrymd10;

    public BizDate getVhsyudisptkshrskgstrymd10() {
        return vhsyudisptkshrskgstrymd10;
    }

    public void setVhsyudisptkshrskgstrymd10(BizDate pVhsyudisptkshrskgstrymd10) {
        vhsyudisptkshrskgstrymd10 = pVhsyudisptkshrskgstrymd10;
    }

    private BizDate vhsyudisptkshrskgnedymd10;

    public BizDate getVhsyudisptkshrskgnedymd10() {
        return vhsyudisptkshrskgnedymd10;
    }

    public void setVhsyudisptkshrskgnedymd10(BizDate pVhsyudisptkshrskgnedymd10) {
        vhsyudisptkshrskgnedymd10 = pVhsyudisptkshrskgnedymd10;
    }

    private BizCurrency vhsyudisptkshrskgngos10;

    public BizCurrency getVhsyudisptkshrskgngos10() {
        return vhsyudisptkshrskgngos10;
    }

    public void setVhsyudisptkshrskgngos10(BizCurrency pVhsyudisptkshrskgngos10) {
        vhsyudisptkshrskgngos10 = pVhsyudisptkshrskgngos10;
    }

    private C_Nenkinsyu vhsyudisptknenkinsyukbn10;

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn10() {
        return vhsyudisptknenkinsyukbn10;
    }

    public void setVhsyudisptknenkinsyukbn10(C_Nenkinsyu pVhsyudisptknenkinsyukbn10) {
        vhsyudisptknenkinsyukbn10 = pVhsyudisptknenkinsyukbn10;
    }

    private Integer vhsyudisptknenkinkkn10;

    public Integer getVhsyudisptknenkinkkn10() {
        return vhsyudisptknenkinkkn10;
    }

    public void setVhsyudisptknenkinkkn10(Integer pVhsyudisptknenkinkkn10) {
        vhsyudisptknenkinkkn10 = pVhsyudisptknenkinkkn10;
    }

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn10;

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn10() {
        return vhsyudisptktkjyskgnkkn10;
    }

    public void setVhsyudisptktkjyskgnkkn10(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn10) {
        vhsyudisptktkjyskgnkkn10 = pVhsyudisptktkjyskgnkkn10;
    }

    private BizDate vhsyudisptktkjkhkdsymd110;

    public BizDate getVhsyudisptktkjkhkdsymd110() {
        return vhsyudisptktkjkhkdsymd110;
    }

    public void setVhsyudisptktkjkhkdsymd110(BizDate pVhsyudisptktkjkhkdsymd110) {
        vhsyudisptktkjkhkdsymd110 = pVhsyudisptktkjkhkdsymd110;
    }

    private BizDate vhsyudisptktkjkhkdeymd110;

    public BizDate getVhsyudisptktkjkhkdeymd110() {
        return vhsyudisptktkjkhkdeymd110;
    }

    public void setVhsyudisptktkjkhkdeymd110(BizDate pVhsyudisptktkjkhkdeymd110) {
        vhsyudisptktkjkhkdeymd110 = pVhsyudisptktkjkhkdeymd110;
    }

    private BizCurrency vhsyudisptktkjyskgns110;

    public BizCurrency getVhsyudisptktkjyskgns110() {
        return vhsyudisptktkjyskgns110;
    }

    public void setVhsyudisptktkjyskgns110(BizCurrency pVhsyudisptktkjyskgns110) {
        vhsyudisptktkjyskgns110 = pVhsyudisptktkjyskgns110;
    }

    private BizDate vhsyudisptktkjkhkdsymd210;

    public BizDate getVhsyudisptktkjkhkdsymd210() {
        return vhsyudisptktkjkhkdsymd210;
    }

    public void setVhsyudisptktkjkhkdsymd210(BizDate pVhsyudisptktkjkhkdsymd210) {
        vhsyudisptktkjkhkdsymd210 = pVhsyudisptktkjkhkdsymd210;
    }

    private BizDate vhsyudisptktkjkhkdeymd210;

    public BizDate getVhsyudisptktkjkhkdeymd210() {
        return vhsyudisptktkjkhkdeymd210;
    }

    public void setVhsyudisptktkjkhkdeymd210(BizDate pVhsyudisptktkjkhkdeymd210) {
        vhsyudisptktkjkhkdeymd210 = pVhsyudisptktkjkhkdeymd210;
    }

    private BizCurrency vhsyudisptktkjyskgns210;

    public BizCurrency getVhsyudisptktkjyskgns210() {
        return vhsyudisptktkjyskgns210;
    }

    public void setVhsyudisptktkjyskgns210(BizCurrency pVhsyudisptktkjyskgns210) {
        vhsyudisptktkjyskgns210 = pVhsyudisptktkjyskgns210;
    }

    private BizDate vhsyudisptktkjkhkdsymd310;

    public BizDate getVhsyudisptktkjkhkdsymd310() {
        return vhsyudisptktkjkhkdsymd310;
    }

    public void setVhsyudisptktkjkhkdsymd310(BizDate pVhsyudisptktkjkhkdsymd310) {
        vhsyudisptktkjkhkdsymd310 = pVhsyudisptktkjkhkdsymd310;
    }

    private BizDate vhsyudisptktkjkhkdeymd310;

    public BizDate getVhsyudisptktkjkhkdeymd310() {
        return vhsyudisptktkjkhkdeymd310;
    }

    public void setVhsyudisptktkjkhkdeymd310(BizDate pVhsyudisptktkjkhkdeymd310) {
        vhsyudisptktkjkhkdeymd310 = pVhsyudisptktkjkhkdeymd310;
    }

    private BizCurrency vhsyudisptktkjyskgns310;

    public BizCurrency getVhsyudisptktkjyskgns310() {
        return vhsyudisptktkjyskgns310;
    }

    public void setVhsyudisptktkjyskgns310(BizCurrency pVhsyudisptktkjyskgns310) {
        vhsyudisptktkjyskgns310 = pVhsyudisptktkjyskgns310;
    }

    private BizDate vhsyudisptktkjkhkdsymd410;

    public BizDate getVhsyudisptktkjkhkdsymd410() {
        return vhsyudisptktkjkhkdsymd410;
    }

    public void setVhsyudisptktkjkhkdsymd410(BizDate pVhsyudisptktkjkhkdsymd410) {
        vhsyudisptktkjkhkdsymd410 = pVhsyudisptktkjkhkdsymd410;
    }

    private BizDate vhsyudisptktkjkhkdeymd410;

    public BizDate getVhsyudisptktkjkhkdeymd410() {
        return vhsyudisptktkjkhkdeymd410;
    }

    public void setVhsyudisptktkjkhkdeymd410(BizDate pVhsyudisptktkjkhkdeymd410) {
        vhsyudisptktkjkhkdeymd410 = pVhsyudisptktkjkhkdeymd410;
    }

    private BizCurrency vhsyudisptktkjyskgns410;

    public BizCurrency getVhsyudisptktkjyskgns410() {
        return vhsyudisptktkjyskgns410;
    }

    public void setVhsyudisptktkjyskgns410(BizCurrency pVhsyudisptktkjyskgns410) {
        vhsyudisptktkjyskgns410 = pVhsyudisptktkjyskgns410;
    }

    private BizDate vhsyudisptktkjkhkdsymd510;

    public BizDate getVhsyudisptktkjkhkdsymd510() {
        return vhsyudisptktkjkhkdsymd510;
    }

    public void setVhsyudisptktkjkhkdsymd510(BizDate pVhsyudisptktkjkhkdsymd510) {
        vhsyudisptktkjkhkdsymd510 = pVhsyudisptktkjkhkdsymd510;
    }

    private BizDate vhsyudisptktkjkhkdeymd510;

    public BizDate getVhsyudisptktkjkhkdeymd510() {
        return vhsyudisptktkjkhkdeymd510;
    }

    public void setVhsyudisptktkjkhkdeymd510(BizDate pVhsyudisptktkjkhkdeymd510) {
        vhsyudisptktkjkhkdeymd510 = pVhsyudisptktkjkhkdeymd510;
    }

    private BizCurrency vhsyudisptktkjyskgns510;

    public BizCurrency getVhsyudisptktkjyskgns510() {
        return vhsyudisptktkjyskgns510;
    }

    public void setVhsyudisptktkjyskgns510(BizCurrency pVhsyudisptktkjyskgns510) {
        vhsyudisptktkjyskgns510 = pVhsyudisptktkjyskgns510;
    }

    private C_Tkjyhyouten vhsyudisptktkjyhyouten10;

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten10() {
        return vhsyudisptktkjyhyouten10;
    }

    public void setVhsyudisptktkjyhyouten10(C_Tkjyhyouten pVhsyudisptktkjyhyouten10) {
        vhsyudisptktkjyhyouten10 = pVhsyudisptktkjyhyouten10;
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

    private BizCurrency vhsyudisptktutakngk10;

    public BizCurrency getVhsyudisptktutakngk10() {
        return vhsyudisptktutakngk10;
    }

    public void setVhsyudisptktutakngk10(BizCurrency pVhsyudisptktutakngk10) {
        vhsyudisptktutakngk10 = pVhsyudisptktutakngk10;
    }

    private BizDate vhsyudisptkkrkhasseiymd10;

    public BizDate getVhsyudisptkkrkhasseiymd10() {
        return vhsyudisptkkrkhasseiymd10;
    }

    public void setVhsyudisptkkrkhasseiymd10(BizDate pVhsyudisptkkrkhasseiymd10) {
        vhsyudisptkkrkhasseiymd10 = pVhsyudisptkkrkhasseiymd10;
    }

    private C_UmuKbn vhsyuitijibrumu;

    public C_UmuKbn getVhsyuitijibrumu() {
        return vhsyuitijibrumu;
    }

    public void setVhsyuitijibrumu(C_UmuKbn pVhsyuitijibrumu) {
        vhsyuitijibrumu = pVhsyuitijibrumu;
    }

    private C_UmuKbn vhsyugenzaikngkhyjfukaumu;

    public C_UmuKbn getVhsyugenzaikngkhyjfukaumu() {
        return vhsyugenzaikngkhyjfukaumu;
    }

    public void setVhsyugenzaikngkhyjfukaumu(C_UmuKbn pVhsyugenzaikngkhyjfukaumu) {
        vhsyugenzaikngkhyjfukaumu = pVhsyugenzaikngkhyjfukaumu;
    }

    private C_YendthnkJyoutaiKbn vhsyuyendthnkjyoutaikbn;

    public C_YendthnkJyoutaiKbn getVhsyuyendthnkjyoutaikbn() {
        return vhsyuyendthnkjyoutaikbn;
    }

    public void setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn pVhsyuyendthnkjyoutaikbn) {
        vhsyuyendthnkjyoutaikbn = pVhsyuyendthnkjyoutaikbn;
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

    private C_Hrkkeiro newhrkkeiro;

    public C_Hrkkeiro getNewhrkkeiro() {
        return newhrkkeiro;
    }

    public void setNewhrkkeiro(C_Hrkkeiro pNewhrkkeiro) {
        newhrkkeiro = pNewhrkkeiro;
    }

    private C_TkiktbrisyuruiKbn newtikiktbrisyuruikbn;

    public C_TkiktbrisyuruiKbn getNewtikiktbrisyuruikbn() {
        return newtikiktbrisyuruikbn;
    }

    public void setNewtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pNewtikiktbrisyuruikbn) {
        newtikiktbrisyuruikbn = pNewtikiktbrisyuruikbn;
    }

    private C_Hrkkaisuu newhrkkaisuu;

    public C_Hrkkaisuu getNewhrkkaisuu() {
        return newhrkkaisuu;
    }

    public void setNewhrkkaisuu(C_Hrkkaisuu pNewhrkkaisuu) {
        newhrkkaisuu = pNewhrkkaisuu;
    }

    @ValidDateYm
    private BizDateYM henkouyoteiym;

    public BizDateYM getHenkouyoteiym() {
        return henkouyoteiym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHenkouyoteiym(BizDateYM pHenkouyoteiym) {
        henkouyoteiym = pHenkouyoteiym;
    }

    private BizCurrency newtikiktbrihrkp;

    public BizCurrency getNewtikiktbrihrkp() {
        return newtikiktbrihrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtikiktbrihrkp(BizCurrency pNewtikiktbrihrkp) {
        newtikiktbrihrkp = pNewtikiktbrihrkp;
    }

    private BizCurrency newhrkp;

    public BizCurrency getNewhrkp() {
        return newhrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewhrkp(BizCurrency pNewhrkp) {
        newhrkp = pNewhrkp;
    }

    private BizCurrency disphrhnkyoup;

    public BizCurrency getDisphrhnkyoup() {
        return disphrhnkyoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisphrhnkyoup(BizCurrency pDisphrhnkyoup) {
        disphrhnkyoup = pDisphrhnkyoup;
    }

    private BizCurrency yenkahrhnkyoup;

    public BizCurrency getYenkahrhnkyoup() {
        return yenkahrhnkyoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkahrhnkyoup(BizCurrency pYenkahrhnkyoup) {
        yenkahrhnkyoup = pYenkahrhnkyoup;
    }

    private BizDate hrhnkyoupkwsratekjymd;

    public BizDate getHrhnkyoupkwsratekjymd() {
        return hrhnkyoupkwsratekjymd;
    }

    public void setHrhnkyoupkwsratekjymd(BizDate pHrhnkyoupkwsratekjymd) {
        hrhnkyoupkwsratekjymd = pHrhnkyoupkwsratekjymd;
    }

    private BizNumber hrhnkyoupkwsrate;

    public BizNumber getHrhnkyoupkwsrate() {
        return hrhnkyoupkwsrate;
    }

    public void setHrhnkyoupkwsrate(BizNumber pHrhnkyoupkwsrate) {
        hrhnkyoupkwsrate = pHrhnkyoupkwsrate;
    }

    private C_Tuukasyu rstuukasyu;

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private C_Tuukasyu ptuukasyu;

    public C_Tuukasyu getPtuukasyu() {
        return ptuukasyu;
    }

    public void setPtuukasyu(C_Tuukasyu pPtuukasyu) {
        ptuukasyu = pPtuukasyu;
    }

    private BizDateYM hrhnkyoupzytym;

    public BizDateYM getHrhnkyoupzytym() {
        return hrhnkyoupzytym;
    }

    public void setHrhnkyoupzytym(BizDateYM pHrhnkyoupzytym) {
        hrhnkyoupzytym = pHrhnkyoupzytym;
    }

    private Integer hrhnkyoupzytm;

    public Integer getHrhnkyoupzytm() {
        return hrhnkyoupzytm;
    }

    public void setHrhnkyoupzytm(Integer pHrhnkyoupzytm) {
        hrhnkyoupzytm = pHrhnkyoupzytm;
    }

    private BizCurrency newnextkosgohrkp;

    public BizCurrency getNewnextkosgohrkp() {
        return newnextkosgohrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnextkosgohrkp(BizCurrency pNewnextkosgohrkp) {
        newnextkosgohrkp = pNewnextkosgohrkp;
    }

    private String dispsaibancreditkessaiyouno;

    public String getDispsaibancreditkessaiyouno() {
        return dispsaibancreditkessaiyouno;
    }

    public void setDispsaibancreditkessaiyouno(String pDispsaibancreditkessaiyouno) {
        dispsaibancreditkessaiyouno = pDispsaibancreditkessaiyouno;
    }

    private String vhtysdisphtysyorui;

    public String getVhtysdisphtysyorui() {
        return vhtysdisphtysyorui;
    }

    public void setVhtysdisphtysyorui(String pVhtysdisphtysyorui) {
        vhtysdisphtysyorui = pVhtysdisphtysyorui;
    }

    private String syoukainomibtn;

    public String getSyoukainomibtn() {
        return syoukainomibtn;
    }

    public void setSyoukainomibtn(String pSyoukainomibtn) {
        syoukainomibtn = pSyoukainomibtn;
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

    private C_KzkykdouKbn kzkykdoukbn;

    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
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

    private C_AuthorikakyhKbn authorikakyhkbn;

    public C_AuthorikakyhKbn getAuthorikakyhkbn() {
        return authorikakyhkbn;
    }

    public void setAuthorikakyhkbn(C_AuthorikakyhKbn pAuthorikakyhkbn) {
        authorikakyhkbn = pAuthorikakyhkbn;
    }

    private C_YykidouuktkKbn yykidouuktkkbn;

    public C_YykidouuktkKbn getYykidouuktkkbn() {
        return yykidouuktkkbn;
    }

    public void setYykidouuktkkbn(C_YykidouuktkKbn pYykidouuktkkbn) {
        yykidouuktkkbn = pYykidouuktkkbn;
    }

    private C_KyuukouzaAnnaiKbn kyuukouzaannaikbn;

    public C_KyuukouzaAnnaiKbn getKyuukouzaannaikbn() {
        return kyuukouzaannaikbn;
    }

    public void setKyuukouzaannaikbn(C_KyuukouzaAnnaiKbn pKyuukouzaannaikbn) {
        kyuukouzaannaikbn = pKyuukouzaannaikbn;
    }

    private C_KanryotuutioutKbn kanryotuutioutkbn;

    public C_KanryotuutioutKbn getKanryotuutioutkbn() {
        return kanryotuutioutkbn;
    }

    public void setKanryotuutioutkbn(C_KanryotuutioutKbn pKanryotuutioutkbn) {
        kanryotuutioutkbn = pKanryotuutioutkbn;
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
