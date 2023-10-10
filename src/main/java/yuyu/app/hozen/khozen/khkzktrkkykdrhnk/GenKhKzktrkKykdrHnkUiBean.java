package yuyu.app.hozen.khozen.khkzktrkkykdrhnk;

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
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TeiseiKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 家族登録／契約者代理特約変更 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhKzktrkKykdrHnkUiBean extends AbstractUiBean {

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

    private C_KjkhukaKbn vhhkshhknnmkjkhukakbn;

    public C_KjkhukaKbn getVhhkshhknnmkjkhukakbn() {
        return vhhkshhknnmkjkhukakbn;
    }

    public void setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn pVhhkshhknnmkjkhukakbn) {
        vhhkshhknnmkjkhukakbn = pVhhkshhknnmkjkhukakbn;
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

    private C_KjkhukaKbn vstskstdrsknmkjhukakbn;

    public C_KjkhukaKbn getVstskstdrsknmkjhukakbn() {
        return vstskstdrsknmkjhukakbn;
    }

    public void setVstskstdrsknmkjhukakbn(C_KjkhukaKbn pVstskstdrsknmkjhukakbn) {
        vstskstdrsknmkjhukakbn = pVstskstdrsknmkjhukakbn;
    }

    private BizDate vstskstdrskseiymd;

    public BizDate getVstskstdrskseiymd() {
        return vstskstdrskseiymd;
    }

    public void setVstskstdrskseiymd(BizDate pVstskstdrskseiymd) {
        vstskstdrskseiymd = pVstskstdrskseiymd;
    }

    private C_MousideninKbn mousideninkbn;

    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    private C_TeiseiKbn teiseikbn;

    public C_TeiseiKbn getTeiseikbn() {
        return teiseikbn;
    }

    public void setTeiseikbn(C_TeiseiKbn pTeiseikbn) {
        teiseikbn = pTeiseikbn;
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

    private String dummykmk3;

    public String getDummykmk3() {
        return dummykmk3;
    }

    public void setDummykmk3(String pDummykmk3) {
        dummykmk3 = pDummykmk3;
    }

    private C_TrkkzkttdkKbn trkkzkttdkkbn1;

    public C_TrkkzkttdkKbn getTrkkzkttdkkbn1() {
        return trkkzkttdkkbn1;
    }

    public void setTrkkzkttdkkbn1(C_TrkkzkttdkKbn pTrkkzkttdkkbn1) {
        trkkzkttdkkbn1 = pTrkkzkttdkkbn1;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String trkkzknmkn1;

    public String getTrkkzknmkn1() {
        return trkkzknmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn1(String pTrkkzknmkn1) {
        trkkzknmkn1 = pTrkkzknmkn1;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newtrkkzknmkn1;

    public String getNewtrkkzknmkn1() {
        return newtrkkzknmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewtrkkzknmkn1(String pNewtrkkzknmkn1) {
        newtrkkzknmkn1 = pNewtrkkzknmkn1;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzknmkj1;

    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj1(String pTrkkzknmkj1) {
        trkkzknmkj1 = pTrkkzknmkj1;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn1;

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn1() {
        return trkkzknmkjkhukakbn1;
    }

    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn pTrkkzknmkjkhukakbn1) {
        trkkzknmkjkhukakbn1 = pTrkkzknmkjkhukakbn1;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzknmkj1;

    public String getNewtrkkzknmkj1() {
        return newtrkkzknmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewtrkkzknmkj1(String pNewtrkkzknmkj1) {
        newtrkkzknmkj1 = pNewtrkkzknmkj1;
    }

    private Boolean newtrkkzknmkjkhuka1;

    public Boolean getNewtrkkzknmkjkhuka1() {
        return (newtrkkzknmkjkhuka1 == null) ? Boolean.FALSE : newtrkkzknmkjkhuka1;
    }

    public void setNewtrkkzknmkjkhuka1(Boolean pNewtrkkzknmkjkhuka1) {
        newtrkkzknmkjkhuka1 = (pNewtrkkzknmkjkhuka1 == null) ? Boolean.FALSE : pNewtrkkzknmkjkhuka1;
    }

    private C_KjkhukaKbn newtrkkzknmkjkhukakbn1;

    public C_KjkhukaKbn getNewtrkkzknmkjkhukakbn1() {
        return newtrkkzknmkjkhukakbn1;
    }

    public void setNewtrkkzknmkjkhukakbn1(C_KjkhukaKbn pNewtrkkzknmkjkhukakbn1) {
        newtrkkzknmkjkhukakbn1 = pNewtrkkzknmkjkhukakbn1;
    }

    @ValidDate
    private BizDate trkkzkseiymd1;

    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd1(BizDate pTrkkzkseiymd1) {
        trkkzkseiymd1 = pTrkkzkseiymd1;
    }

    @ValidDate
    private BizDate newtrkkzkseiymd1;

    public BizDate getNewtrkkzkseiymd1() {
        return newtrkkzkseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzkseiymd1(BizDate pNewtrkkzkseiymd1) {
        newtrkkzkseiymd1 = pNewtrkkzkseiymd1;
    }

    private C_Seibetu trkkzksei1;

    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private C_Seibetu newtrkkzksei1;

    public C_Seibetu getNewtrkkzksei1() {
        return newtrkkzksei1;
    }

    public void setNewtrkkzksei1(C_Seibetu pNewtrkkzksei1) {
        newtrkkzksei1 = pNewtrkkzksei1;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    private C_TsindousiteiKbn newtrkkzktsindousiteikbn1;

    public C_TsindousiteiKbn getNewtrkkzktsindousiteikbn1() {
        return newtrkkzktsindousiteikbn1;
    }

    public void setNewtrkkzktsindousiteikbn1(C_TsindousiteiKbn pNewtrkkzktsindousiteikbn1) {
        newtrkkzktsindousiteikbn1 = pNewtrkkzktsindousiteikbn1;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String trkkzkyno1;

    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno1(String pTrkkzkyno1) {
        trkkzkyno1 = pTrkkzkyno1;
    }

    @Length(length=7)
    @Digit
    private String newtrkkzkyno1;

    public String getNewtrkkzkyno1() {
        return newtrkkzkyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzkyno1(String pNewtrkkzkyno1) {
        newtrkkzkyno1 = pNewtrkkzkyno1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr1kj1;

    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr2kj1;

    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr3kj1;

    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr1kj1;

    public String getNewtrkkzkadr1kj1() {
        return newtrkkzkadr1kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr1kj1(String pNewtrkkzkadr1kj1) {
        newtrkkzkadr1kj1 = pNewtrkkzkadr1kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr2kj1;

    public String getNewtrkkzkadr2kj1() {
        return newtrkkzkadr2kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr2kj1(String pNewtrkkzkadr2kj1) {
        newtrkkzkadr2kj1 = pNewtrkkzkadr2kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr3kj1;

    public String getNewtrkkzkadr3kj1() {
        return newtrkkzkadr3kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr3kj1(String pNewtrkkzkadr3kj1) {
        newtrkkzkadr3kj1 = pNewtrkkzkadr3kj1;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String trkkzktelno1;

    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno1(String pTrkkzktelno1) {
        trkkzktelno1 = pTrkkzktelno1;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String newtrkkzktelno1;

    public String getNewtrkkzktelno1() {
        return newtrkkzktelno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzktelno1(String pNewtrkkzktelno1) {
        newtrkkzktelno1 = pNewtrkkzktelno1;
    }

    private C_Tdk trkkzktdk1;

    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    private C_Tdk newtrkkzktdk1;

    public C_Tdk getNewtrkkzktdk1() {
        return newtrkkzktdk1;
    }

    public void setNewtrkkzktdk1(C_Tdk pNewtrkkzktdk1) {
        newtrkkzktdk1 = pNewtrkkzktdk1;
    }

    private String dummykmk4;

    public String getDummykmk4() {
        return dummykmk4;
    }

    public void setDummykmk4(String pDummykmk4) {
        dummykmk4 = pDummykmk4;
    }

    private C_TrkkzkttdkKbn trkkzkttdkkbn2;

    public C_TrkkzkttdkKbn getTrkkzkttdkkbn2() {
        return trkkzkttdkkbn2;
    }

    public void setTrkkzkttdkkbn2(C_TrkkzkttdkKbn pTrkkzkttdkkbn2) {
        trkkzkttdkkbn2 = pTrkkzkttdkkbn2;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String trkkzknmkn2;

    public String getTrkkzknmkn2() {
        return trkkzknmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn2(String pTrkkzknmkn2) {
        trkkzknmkn2 = pTrkkzknmkn2;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newtrkkzknmkn2;

    public String getNewtrkkzknmkn2() {
        return newtrkkzknmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewtrkkzknmkn2(String pNewtrkkzknmkn2) {
        newtrkkzknmkn2 = pNewtrkkzknmkn2;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzknmkj2;

    public String getTrkkzknmkj2() {
        return trkkzknmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj2(String pTrkkzknmkj2) {
        trkkzknmkj2 = pTrkkzknmkj2;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn2;

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn2() {
        return trkkzknmkjkhukakbn2;
    }

    public void setTrkkzknmkjkhukakbn2(C_KjkhukaKbn pTrkkzknmkjkhukakbn2) {
        trkkzknmkjkhukakbn2 = pTrkkzknmkjkhukakbn2;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzknmkj2;

    public String getNewtrkkzknmkj2() {
        return newtrkkzknmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewtrkkzknmkj2(String pNewtrkkzknmkj2) {
        newtrkkzknmkj2 = pNewtrkkzknmkj2;
    }

    private Boolean newtrkkzknmkjkhuka2;

    public Boolean getNewtrkkzknmkjkhuka2() {
        return (newtrkkzknmkjkhuka2 == null) ? Boolean.FALSE : newtrkkzknmkjkhuka2;
    }

    public void setNewtrkkzknmkjkhuka2(Boolean pNewtrkkzknmkjkhuka2) {
        newtrkkzknmkjkhuka2 = (pNewtrkkzknmkjkhuka2 == null) ? Boolean.FALSE : pNewtrkkzknmkjkhuka2;
    }

    private C_KjkhukaKbn newtrkkzknmkjkhukakbn2;

    public C_KjkhukaKbn getNewtrkkzknmkjkhukakbn2() {
        return newtrkkzknmkjkhukakbn2;
    }

    public void setNewtrkkzknmkjkhukakbn2(C_KjkhukaKbn pNewtrkkzknmkjkhukakbn2) {
        newtrkkzknmkjkhukakbn2 = pNewtrkkzknmkjkhukakbn2;
    }

    @ValidDate
    private BizDate trkkzkseiymd2;

    public BizDate getTrkkzkseiymd2() {
        return trkkzkseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd2(BizDate pTrkkzkseiymd2) {
        trkkzkseiymd2 = pTrkkzkseiymd2;
    }

    @ValidDate
    private BizDate newtrkkzkseiymd2;

    public BizDate getNewtrkkzkseiymd2() {
        return newtrkkzkseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzkseiymd2(BizDate pNewtrkkzkseiymd2) {
        newtrkkzkseiymd2 = pNewtrkkzkseiymd2;
    }

    private C_Seibetu trkkzksei2;

    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private C_Seibetu newtrkkzksei2;

    public C_Seibetu getNewtrkkzksei2() {
        return newtrkkzksei2;
    }

    public void setNewtrkkzksei2(C_Seibetu pNewtrkkzksei2) {
        newtrkkzksei2 = pNewtrkkzksei2;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }

    private C_TsindousiteiKbn newtrkkzktsindousiteikbn2;

    public C_TsindousiteiKbn getNewtrkkzktsindousiteikbn2() {
        return newtrkkzktsindousiteikbn2;
    }

    public void setNewtrkkzktsindousiteikbn2(C_TsindousiteiKbn pNewtrkkzktsindousiteikbn2) {
        newtrkkzktsindousiteikbn2 = pNewtrkkzktsindousiteikbn2;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String trkkzkyno2;

    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno2(String pTrkkzkyno2) {
        trkkzkyno2 = pTrkkzkyno2;
    }

    @Length(length=7)
    @Digit
    private String newtrkkzkyno2;

    public String getNewtrkkzkyno2() {
        return newtrkkzkyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzkyno2(String pNewtrkkzkyno2) {
        newtrkkzkyno2 = pNewtrkkzkyno2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr1kj2;

    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr2kj2;

    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr3kj2;

    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr1kj2;

    public String getNewtrkkzkadr1kj2() {
        return newtrkkzkadr1kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr1kj2(String pNewtrkkzkadr1kj2) {
        newtrkkzkadr1kj2 = pNewtrkkzkadr1kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr2kj2;

    public String getNewtrkkzkadr2kj2() {
        return newtrkkzkadr2kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr2kj2(String pNewtrkkzkadr2kj2) {
        newtrkkzkadr2kj2 = pNewtrkkzkadr2kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newtrkkzkadr3kj2;

    public String getNewtrkkzkadr3kj2() {
        return newtrkkzkadr3kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewtrkkzkadr3kj2(String pNewtrkkzkadr3kj2) {
        newtrkkzkadr3kj2 = pNewtrkkzkadr3kj2;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String trkkzktelno2;

    public String getTrkkzktelno2() {
        return trkkzktelno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno2(String pTrkkzktelno2) {
        trkkzktelno2 = pTrkkzktelno2;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String newtrkkzktelno2;

    public String getNewtrkkzktelno2() {
        return newtrkkzktelno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtrkkzktelno2(String pNewtrkkzktelno2) {
        newtrkkzktelno2 = pNewtrkkzktelno2;
    }

    private C_Tdk trkkzktdk2;

    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    private C_Tdk newtrkkzktdk2;

    public C_Tdk getNewtrkkzktdk2() {
        return newtrkkzktdk2;
    }

    public void setNewtrkkzktdk2(C_Tdk pNewtrkkzktdk2) {
        newtrkkzktdk2 = pNewtrkkzktdk2;
    }

    private String dummykmk5;

    public String getDummykmk5() {
        return dummykmk5;
    }

    public void setDummykmk5(String pDummykmk5) {
        dummykmk5 = pDummykmk5;
    }

    private C_KykdrtkykttdkKbn kykdrtkykttdkkbn;

    public C_KykdrtkykttdkKbn getKykdrtkykttdkkbn() {
        return kykdrtkykttdkkbn;
    }

    public void setKykdrtkykttdkkbn(C_KykdrtkykttdkKbn pKykdrtkykttdkkbn) {
        kykdrtkykttdkkbn = pKykdrtkykttdkkbn;
    }

    private C_UktKbn kykdrkbn;

    public C_UktKbn getKykdrkbn() {
        return kykdrkbn;
    }

    public void setKykdrkbn(C_UktKbn pKykdrkbn) {
        kykdrkbn = pKykdrkbn;
    }

    private C_UktKbn newkykdrkbn;

    public C_UktKbn getNewkykdrkbn() {
        return newkykdrkbn;
    }

    public void setNewkykdrkbn(C_UktKbn pNewkykdrkbn) {
        newkykdrkbn = pNewkykdrkbn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kykdairinmkn;

    public String getKykdairinmkn() {
        return kykdairinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkn(String pKykdairinmkn) {
        kykdairinmkn = pKykdairinmkn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String newkykdrnmkn;

    public String getNewkykdrnmkn() {
        return newkykdrnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkykdrnmkn(String pNewkykdrnmkn) {
        newkykdrnmkn = pNewkykdrnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kykdairinmkj;

    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    private C_KjkhukaKbn kykdrnmkjkhukakbn;

    public C_KjkhukaKbn getKykdrnmkjkhukakbn() {
        return kykdrnmkjkhukakbn;
    }

    public void setKykdrnmkjkhukakbn(C_KjkhukaKbn pKykdrnmkjkhukakbn) {
        kykdrnmkjkhukakbn = pKykdrnmkjkhukakbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String newkykdrnmkj;

    public String getNewkykdrnmkj() {
        return newkykdrnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNewkykdrnmkj(String pNewkykdrnmkj) {
        newkykdrnmkj = pNewkykdrnmkj;
    }

    private Boolean newkykdrnmkjkhuka;

    public Boolean getNewkykdrnmkjkhuka() {
        return (newkykdrnmkjkhuka == null) ? Boolean.FALSE : newkykdrnmkjkhuka;
    }

    public void setNewkykdrnmkjkhuka(Boolean pNewkykdrnmkjkhuka) {
        newkykdrnmkjkhuka = (pNewkykdrnmkjkhuka == null) ? Boolean.FALSE : pNewkykdrnmkjkhuka;
    }

    private C_KjkhukaKbn newkykdrnmkjkhukakbn;

    public C_KjkhukaKbn getNewkykdrnmkjkhukakbn() {
        return newkykdrnmkjkhukakbn;
    }

    public void setNewkykdrnmkjkhukakbn(C_KjkhukaKbn pNewkykdrnmkjkhukakbn) {
        newkykdrnmkjkhukakbn = pNewkykdrnmkjkhukakbn;
    }

    @ValidDate
    private BizDate kykdrseiymd;

    public BizDate getKykdrseiymd() {
        return kykdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrseiymd(BizDate pKykdrseiymd) {
        kykdrseiymd = pKykdrseiymd;
    }

    @ValidDate
    private BizDate newkykdrseiymd;

    public BizDate getNewkykdrseiymd() {
        return newkykdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewkykdrseiymd(BizDate pNewkykdrseiymd) {
        newkykdrseiymd = pNewkykdrseiymd;
    }

    @Length(length=7)
    @Digit
    private String kykdryno;

    public String getKykdryno() {
        return kykdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdryno(String pKykdryno) {
        kykdryno = pKykdryno;
    }

    @Length(length=7)
    @Digit
    private String newkykdryno;

    public String getNewkykdryno() {
        return newkykdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewkykdryno(String pNewkykdryno) {
        newkykdryno = pNewkykdryno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String kykdradr1kj;

    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr1kj(String pKykdradr1kj) {
        kykdradr1kj = pKykdradr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String kykdradr2kj;

    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr2kj(String pKykdradr2kj) {
        kykdradr2kj = pKykdradr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String kykdradr3kj;

    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr3kj(String pKykdradr3kj) {
        kykdradr3kj = pKykdradr3kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newkykdradr1kj;

    public String getNewkykdradr1kj() {
        return newkykdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewkykdradr1kj(String pNewkykdradr1kj) {
        newkykdradr1kj = pNewkykdradr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newkykdradr2kj;

    public String getNewkykdradr2kj() {
        return newkykdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewkykdradr2kj(String pNewkykdradr2kj) {
        newkykdradr2kj = pNewkykdradr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String newkykdradr3kj;

    public String getNewkykdradr3kj() {
        return newkykdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNewkykdradr3kj(String pNewkykdradr3kj) {
        newkykdradr3kj = pNewkykdradr3kj;
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
