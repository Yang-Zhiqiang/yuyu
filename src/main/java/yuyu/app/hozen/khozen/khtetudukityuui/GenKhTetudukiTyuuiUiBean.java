package yuyu.app.hozen.khozen.khtetudukityuui;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
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
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全手続注意設定 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhTetudukiTyuuiUiBean extends AbstractUiBean {

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

    private DataSource<TtdkTyuui1DataSourceBean> ttdkTyuui1DataSource = new DataSource<>();
    public DataSource<TtdkTyuui1DataSourceBean> getTtdkTyuui1DataSource() {
        return ttdkTyuui1DataSource;
    }

    @Deprecated
    public List<TtdkTyuui1DataSourceBean> getTtdkTyuui1() {
        return ttdkTyuui1DataSource.getDatas();
    }

    public void setTtdkTyuui1(List<TtdkTyuui1DataSourceBean> pTtdkTyuui1) {
        ttdkTyuui1DataSource.setDatas(pTtdkTyuui1);
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

    private C_KktyuitaKbn kktyuitakbn;

    public C_KktyuitaKbn getKktyuitakbn() {
        return kktyuitakbn;
    }

    public void setKktyuitakbn(C_KktyuitaKbn pKktyuitakbn) {
        kktyuitakbn = pKktyuitakbn;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou1;

    public String getTtdktyuuinaiyou1() {
        return ttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou1(String pTtdktyuuinaiyou1) {
        ttdktyuuinaiyou1 = pTtdktyuuinaiyou1;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou2;

    public String getTtdktyuuinaiyou2() {
        return ttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou2(String pTtdktyuuinaiyou2) {
        ttdktyuuinaiyou2 = pTtdktyuuinaiyou2;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou3;

    public String getTtdktyuuinaiyou3() {
        return ttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou3(String pTtdktyuuinaiyou3) {
        ttdktyuuinaiyou3 = pTtdktyuuinaiyou3;
    }

    private C_StknsetKbn stknsetkbn;

    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutai;

    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutai() {
        return kykdrknhatudoujyoutai;
    }

    public void setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        kykdrknhatudoujyoutai = pKykdrknhatudoujyoutai;
    }

    private C_KykdrDouiYouhiKbn kykdrdouiyouhi;

    public C_KykdrDouiYouhiKbn getKykdrdouiyouhi() {
        return kykdrdouiyouhi;
    }

    public void setKykdrdouiyouhi(C_KykdrDouiYouhiKbn pKykdrdouiyouhi) {
        kykdrdouiyouhi = pKykdrdouiyouhi;
    }

    @ValidDate
    private BizDate dispsyoriymd1;

    public BizDate getDispsyoriymd1() {
        return dispsyoriymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoriymd1(BizDate pDispsyoriymd1) {
        dispsyoriymd1 = pDispsyoriymd1;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn1;

    public C_FatcasnsiKbn getDispfatcasnsikbn1() {
        return dispfatcasnsikbn1;
    }

    public void setDispfatcasnsikbn1(C_FatcasnsiKbn pDispfatcasnsikbn1) {
        dispfatcasnsikbn1 = pDispfatcasnsikbn1;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn1;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn1() {
        return dispbikkjnssinfokbn1;
    }

    public void setDispbikkjnssinfokbn1(C_BikkjnssinfoKbn pDispbikkjnssinfokbn1) {
        dispbikkjnssinfokbn1 = pDispbikkjnssinfokbn1;
    }

    private C_FatcakekKbn dispfatcakekkbn1;

    public C_FatcakekKbn getDispfatcakekkbn1() {
        return dispfatcakekkbn1;
    }

    public void setDispfatcakekkbn1(C_FatcakekKbn pDispfatcakekkbn1) {
        dispfatcakekkbn1 = pDispfatcakekkbn1;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn1;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn1() {
        return dispfatcahankeiikbn1;
    }

    public void setDispfatcahankeiikbn1(C_FatcahankeiiKbn pDispfatcahankeiikbn1) {
        dispfatcahankeiikbn1 = pDispfatcahankeiikbn1;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno1;

    public String getDispbikknzsyno1() {
        return dispbikknzsyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno1(String pDispbikknzsyno1) {
        dispbikknzsyno1 = pDispbikknzsyno1;
    }

    @ValidDate
    private BizDate dispsyomeiymd1;

    public BizDate getDispsyomeiymd1() {
        return dispsyomeiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd1(BizDate pDispsyomeiymd1) {
        dispsyomeiymd1 = pDispsyomeiymd1;
    }

    private C_FatcatgKbn dispfatcatgkbn1;

    public C_FatcatgKbn getDispfatcatgkbn1() {
        return dispfatcatgkbn1;
    }

    public void setDispfatcatgkbn1(C_FatcatgKbn pDispfatcatgkbn1) {
        dispfatcatgkbn1 = pDispfatcatgkbn1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dispnmkn1;

    public String getDispnmkn1() {
        return dispnmkn1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn1(String pDispnmkn1) {
        dispnmkn1 = pDispnmkn1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj1;

    public String getDispnmkj1() {
        return dispnmkj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj1(String pDispnmkj1) {
        dispnmkj1 = pDispnmkj1;
    }

    @ValidDate
    private BizDate dispseiymd1;

    public BizDate getDispseiymd1() {
        return dispseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd1(BizDate pDispseiymd1) {
        dispseiymd1 = pDispseiymd1;
    }

    private C_Seibetu dispsei1;

    public C_Seibetu getDispsei1() {
        return dispsei1;
    }

    public void setDispsei1(C_Seibetu pDispsei1) {
        dispsei1 = pDispsei1;
    }

    @ValidDate
    private BizDate dispkouryokuendymd1;

    public BizDate getDispkouryokuendymd1() {
        return dispkouryokuendymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkouryokuendymd1(BizDate pDispkouryokuendymd1) {
        dispkouryokuendymd1 = pDispkouryokuendymd1;
    }

    private Boolean dispfatcasakujyo1;

    public Boolean getDispfatcasakujyo1() {
        return (dispfatcasakujyo1 == null) ? Boolean.FALSE : dispfatcasakujyo1;
    }

    public void setDispfatcasakujyo1(Boolean pDispfatcasakujyo1) {
        dispfatcasakujyo1 = (pDispfatcasakujyo1 == null) ? Boolean.FALSE : pDispfatcasakujyo1;
    }

    @ValidDate
    private BizDate dispsyoriymd2;

    public BizDate getDispsyoriymd2() {
        return dispsyoriymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoriymd2(BizDate pDispsyoriymd2) {
        dispsyoriymd2 = pDispsyoriymd2;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn2;

    public C_FatcasnsiKbn getDispfatcasnsikbn2() {
        return dispfatcasnsikbn2;
    }

    public void setDispfatcasnsikbn2(C_FatcasnsiKbn pDispfatcasnsikbn2) {
        dispfatcasnsikbn2 = pDispfatcasnsikbn2;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn2;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn2() {
        return dispbikkjnssinfokbn2;
    }

    public void setDispbikkjnssinfokbn2(C_BikkjnssinfoKbn pDispbikkjnssinfokbn2) {
        dispbikkjnssinfokbn2 = pDispbikkjnssinfokbn2;
    }

    private C_FatcakekKbn dispfatcakekkbn2;

    public C_FatcakekKbn getDispfatcakekkbn2() {
        return dispfatcakekkbn2;
    }

    public void setDispfatcakekkbn2(C_FatcakekKbn pDispfatcakekkbn2) {
        dispfatcakekkbn2 = pDispfatcakekkbn2;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn2;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn2() {
        return dispfatcahankeiikbn2;
    }

    public void setDispfatcahankeiikbn2(C_FatcahankeiiKbn pDispfatcahankeiikbn2) {
        dispfatcahankeiikbn2 = pDispfatcahankeiikbn2;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno2;

    public String getDispbikknzsyno2() {
        return dispbikknzsyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno2(String pDispbikknzsyno2) {
        dispbikknzsyno2 = pDispbikknzsyno2;
    }

    @ValidDate
    private BizDate dispsyomeiymd2;

    public BizDate getDispsyomeiymd2() {
        return dispsyomeiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd2(BizDate pDispsyomeiymd2) {
        dispsyomeiymd2 = pDispsyomeiymd2;
    }

    private C_FatcatgKbn dispfatcatgkbn2;

    public C_FatcatgKbn getDispfatcatgkbn2() {
        return dispfatcatgkbn2;
    }

    public void setDispfatcatgkbn2(C_FatcatgKbn pDispfatcatgkbn2) {
        dispfatcatgkbn2 = pDispfatcatgkbn2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dispnmkn2;

    public String getDispnmkn2() {
        return dispnmkn2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn2(String pDispnmkn2) {
        dispnmkn2 = pDispnmkn2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj2;

    public String getDispnmkj2() {
        return dispnmkj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj2(String pDispnmkj2) {
        dispnmkj2 = pDispnmkj2;
    }

    @ValidDate
    private BizDate dispseiymd2;

    public BizDate getDispseiymd2() {
        return dispseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd2(BizDate pDispseiymd2) {
        dispseiymd2 = pDispseiymd2;
    }

    private C_Seibetu dispsei2;

    public C_Seibetu getDispsei2() {
        return dispsei2;
    }

    public void setDispsei2(C_Seibetu pDispsei2) {
        dispsei2 = pDispsei2;
    }

    @ValidDate
    private BizDate dispkouryokuendymd2;

    public BizDate getDispkouryokuendymd2() {
        return dispkouryokuendymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkouryokuendymd2(BizDate pDispkouryokuendymd2) {
        dispkouryokuendymd2 = pDispkouryokuendymd2;
    }

    private Boolean dispfatcasakujyo2;

    public Boolean getDispfatcasakujyo2() {
        return (dispfatcasakujyo2 == null) ? Boolean.FALSE : dispfatcasakujyo2;
    }

    public void setDispfatcasakujyo2(Boolean pDispfatcasakujyo2) {
        dispfatcasakujyo2 = (pDispfatcasakujyo2 == null) ? Boolean.FALSE : pDispfatcasakujyo2;
    }

    @ValidDate
    private BizDate dispsyoriymd3;

    public BizDate getDispsyoriymd3() {
        return dispsyoriymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoriymd3(BizDate pDispsyoriymd3) {
        dispsyoriymd3 = pDispsyoriymd3;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn3;

    public C_FatcasnsiKbn getDispfatcasnsikbn3() {
        return dispfatcasnsikbn3;
    }

    public void setDispfatcasnsikbn3(C_FatcasnsiKbn pDispfatcasnsikbn3) {
        dispfatcasnsikbn3 = pDispfatcasnsikbn3;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn3;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn3() {
        return dispbikkjnssinfokbn3;
    }

    public void setDispbikkjnssinfokbn3(C_BikkjnssinfoKbn pDispbikkjnssinfokbn3) {
        dispbikkjnssinfokbn3 = pDispbikkjnssinfokbn3;
    }

    private C_FatcakekKbn dispfatcakekkbn3;

    public C_FatcakekKbn getDispfatcakekkbn3() {
        return dispfatcakekkbn3;
    }

    public void setDispfatcakekkbn3(C_FatcakekKbn pDispfatcakekkbn3) {
        dispfatcakekkbn3 = pDispfatcakekkbn3;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn3;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn3() {
        return dispfatcahankeiikbn3;
    }

    public void setDispfatcahankeiikbn3(C_FatcahankeiiKbn pDispfatcahankeiikbn3) {
        dispfatcahankeiikbn3 = pDispfatcahankeiikbn3;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno3;

    public String getDispbikknzsyno3() {
        return dispbikknzsyno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno3(String pDispbikknzsyno3) {
        dispbikknzsyno3 = pDispbikknzsyno3;
    }

    @ValidDate
    private BizDate dispsyomeiymd3;

    public BizDate getDispsyomeiymd3() {
        return dispsyomeiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd3(BizDate pDispsyomeiymd3) {
        dispsyomeiymd3 = pDispsyomeiymd3;
    }

    private C_FatcatgKbn dispfatcatgkbn3;

    public C_FatcatgKbn getDispfatcatgkbn3() {
        return dispfatcatgkbn3;
    }

    public void setDispfatcatgkbn3(C_FatcatgKbn pDispfatcatgkbn3) {
        dispfatcatgkbn3 = pDispfatcatgkbn3;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dispnmkn3;

    public String getDispnmkn3() {
        return dispnmkn3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn3(String pDispnmkn3) {
        dispnmkn3 = pDispnmkn3;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj3;

    public String getDispnmkj3() {
        return dispnmkj3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj3(String pDispnmkj3) {
        dispnmkj3 = pDispnmkj3;
    }

    @ValidDate
    private BizDate dispseiymd3;

    public BizDate getDispseiymd3() {
        return dispseiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd3(BizDate pDispseiymd3) {
        dispseiymd3 = pDispseiymd3;
    }

    private C_Seibetu dispsei3;

    public C_Seibetu getDispsei3() {
        return dispsei3;
    }

    public void setDispsei3(C_Seibetu pDispsei3) {
        dispsei3 = pDispsei3;
    }

    @ValidDate
    private BizDate dispkouryokuendymd3;

    public BizDate getDispkouryokuendymd3() {
        return dispkouryokuendymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkouryokuendymd3(BizDate pDispkouryokuendymd3) {
        dispkouryokuendymd3 = pDispkouryokuendymd3;
    }

    private Boolean dispfatcasakujyo3;

    public Boolean getDispfatcasakujyo3() {
        return (dispfatcasakujyo3 == null) ? Boolean.FALSE : dispfatcasakujyo3;
    }

    public void setDispfatcasakujyo3(Boolean pDispfatcasakujyo3) {
        dispfatcasakujyo3 = (pDispfatcasakujyo3 == null) ? Boolean.FALSE : pDispfatcasakujyo3;
    }

    @ValidDate
    private BizDate dispsyoriymd4;

    public BizDate getDispsyoriymd4() {
        return dispsyoriymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoriymd4(BizDate pDispsyoriymd4) {
        dispsyoriymd4 = pDispsyoriymd4;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn4;

    public C_FatcasnsiKbn getDispfatcasnsikbn4() {
        return dispfatcasnsikbn4;
    }

    public void setDispfatcasnsikbn4(C_FatcasnsiKbn pDispfatcasnsikbn4) {
        dispfatcasnsikbn4 = pDispfatcasnsikbn4;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn4;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn4() {
        return dispbikkjnssinfokbn4;
    }

    public void setDispbikkjnssinfokbn4(C_BikkjnssinfoKbn pDispbikkjnssinfokbn4) {
        dispbikkjnssinfokbn4 = pDispbikkjnssinfokbn4;
    }

    private C_FatcakekKbn dispfatcakekkbn4;

    public C_FatcakekKbn getDispfatcakekkbn4() {
        return dispfatcakekkbn4;
    }

    public void setDispfatcakekkbn4(C_FatcakekKbn pDispfatcakekkbn4) {
        dispfatcakekkbn4 = pDispfatcakekkbn4;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn4;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn4() {
        return dispfatcahankeiikbn4;
    }

    public void setDispfatcahankeiikbn4(C_FatcahankeiiKbn pDispfatcahankeiikbn4) {
        dispfatcahankeiikbn4 = pDispfatcahankeiikbn4;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno4;

    public String getDispbikknzsyno4() {
        return dispbikknzsyno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno4(String pDispbikknzsyno4) {
        dispbikknzsyno4 = pDispbikknzsyno4;
    }

    @ValidDate
    private BizDate dispsyomeiymd4;

    public BizDate getDispsyomeiymd4() {
        return dispsyomeiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd4(BizDate pDispsyomeiymd4) {
        dispsyomeiymd4 = pDispsyomeiymd4;
    }

    private C_FatcatgKbn dispfatcatgkbn4;

    public C_FatcatgKbn getDispfatcatgkbn4() {
        return dispfatcatgkbn4;
    }

    public void setDispfatcatgkbn4(C_FatcatgKbn pDispfatcatgkbn4) {
        dispfatcatgkbn4 = pDispfatcatgkbn4;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dispnmkn4;

    public String getDispnmkn4() {
        return dispnmkn4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn4(String pDispnmkn4) {
        dispnmkn4 = pDispnmkn4;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj4;

    public String getDispnmkj4() {
        return dispnmkj4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj4(String pDispnmkj4) {
        dispnmkj4 = pDispnmkj4;
    }

    @ValidDate
    private BizDate dispseiymd4;

    public BizDate getDispseiymd4() {
        return dispseiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd4(BizDate pDispseiymd4) {
        dispseiymd4 = pDispseiymd4;
    }

    private C_Seibetu dispsei4;

    public C_Seibetu getDispsei4() {
        return dispsei4;
    }

    public void setDispsei4(C_Seibetu pDispsei4) {
        dispsei4 = pDispsei4;
    }

    @ValidDate
    private BizDate dispkouryokuendymd4;

    public BizDate getDispkouryokuendymd4() {
        return dispkouryokuendymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkouryokuendymd4(BizDate pDispkouryokuendymd4) {
        dispkouryokuendymd4 = pDispkouryokuendymd4;
    }

    private Boolean dispfatcasakujyo4;

    public Boolean getDispfatcasakujyo4() {
        return (dispfatcasakujyo4 == null) ? Boolean.FALSE : dispfatcasakujyo4;
    }

    public void setDispfatcasakujyo4(Boolean pDispfatcasakujyo4) {
        dispfatcasakujyo4 = (pDispfatcasakujyo4 == null) ? Boolean.FALSE : pDispfatcasakujyo4;
    }

    @ValidDate
    private BizDate dispsyoriymd5;

    public BizDate getDispsyoriymd5() {
        return dispsyoriymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoriymd5(BizDate pDispsyoriymd5) {
        dispsyoriymd5 = pDispsyoriymd5;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn5;

    public C_FatcasnsiKbn getDispfatcasnsikbn5() {
        return dispfatcasnsikbn5;
    }

    public void setDispfatcasnsikbn5(C_FatcasnsiKbn pDispfatcasnsikbn5) {
        dispfatcasnsikbn5 = pDispfatcasnsikbn5;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn5;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn5() {
        return dispbikkjnssinfokbn5;
    }

    public void setDispbikkjnssinfokbn5(C_BikkjnssinfoKbn pDispbikkjnssinfokbn5) {
        dispbikkjnssinfokbn5 = pDispbikkjnssinfokbn5;
    }

    private C_FatcakekKbn dispfatcakekkbn5;

    public C_FatcakekKbn getDispfatcakekkbn5() {
        return dispfatcakekkbn5;
    }

    public void setDispfatcakekkbn5(C_FatcakekKbn pDispfatcakekkbn5) {
        dispfatcakekkbn5 = pDispfatcakekkbn5;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn5;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn5() {
        return dispfatcahankeiikbn5;
    }

    public void setDispfatcahankeiikbn5(C_FatcahankeiiKbn pDispfatcahankeiikbn5) {
        dispfatcahankeiikbn5 = pDispfatcahankeiikbn5;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno5;

    public String getDispbikknzsyno5() {
        return dispbikknzsyno5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno5(String pDispbikknzsyno5) {
        dispbikknzsyno5 = pDispbikknzsyno5;
    }

    @ValidDate
    private BizDate dispsyomeiymd5;

    public BizDate getDispsyomeiymd5() {
        return dispsyomeiymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd5(BizDate pDispsyomeiymd5) {
        dispsyomeiymd5 = pDispsyomeiymd5;
    }

    private C_FatcatgKbn dispfatcatgkbn5;

    public C_FatcatgKbn getDispfatcatgkbn5() {
        return dispfatcatgkbn5;
    }

    public void setDispfatcatgkbn5(C_FatcatgKbn pDispfatcatgkbn5) {
        dispfatcatgkbn5 = pDispfatcatgkbn5;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dispnmkn5;

    public String getDispnmkn5() {
        return dispnmkn5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn5(String pDispnmkn5) {
        dispnmkn5 = pDispnmkn5;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj5;

    public String getDispnmkj5() {
        return dispnmkj5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj5(String pDispnmkj5) {
        dispnmkj5 = pDispnmkj5;
    }

    @ValidDate
    private BizDate dispseiymd5;

    public BizDate getDispseiymd5() {
        return dispseiymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd5(BizDate pDispseiymd5) {
        dispseiymd5 = pDispseiymd5;
    }

    private C_Seibetu dispsei5;

    public C_Seibetu getDispsei5() {
        return dispsei5;
    }

    public void setDispsei5(C_Seibetu pDispsei5) {
        dispsei5 = pDispsei5;
    }

    @ValidDate
    private BizDate dispkouryokuendymd5;

    public BizDate getDispkouryokuendymd5() {
        return dispkouryokuendymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkouryokuendymd5(BizDate pDispkouryokuendymd5) {
        dispkouryokuendymd5 = pDispkouryokuendymd5;
    }

    private Boolean dispfatcasakujyo5;

    public Boolean getDispfatcasakujyo5() {
        return (dispfatcasakujyo5 == null) ? Boolean.FALSE : dispfatcasakujyo5;
    }

    public void setDispfatcasakujyo5(Boolean pDispfatcasakujyo5) {
        dispfatcasakujyo5 = (pDispfatcasakujyo5 == null) ? Boolean.FALSE : pDispfatcasakujyo5;
    }

    private Integer recordkensuu;

    public Integer getRecordkensuu() {
        return recordkensuu;
    }

    public void setRecordkensuu(Integer pRecordkensuu) {
        recordkensuu = pRecordkensuu;
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

    private Boolean dispaeoisakujyo1;

    public Boolean getDispaeoisakujyo1() {
        return (dispaeoisakujyo1 == null) ? Boolean.FALSE : dispaeoisakujyo1;
    }

    public void setDispaeoisakujyo1(Boolean pDispaeoisakujyo1) {
        dispaeoisakujyo1 = (pDispaeoisakujyo1 == null) ? Boolean.FALSE : pDispaeoisakujyo1;
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

    private Boolean dispaeoisakujyo2;

    public Boolean getDispaeoisakujyo2() {
        return (dispaeoisakujyo2 == null) ? Boolean.FALSE : dispaeoisakujyo2;
    }

    public void setDispaeoisakujyo2(Boolean pDispaeoisakujyo2) {
        dispaeoisakujyo2 = (pDispaeoisakujyo2 == null) ? Boolean.FALSE : pDispaeoisakujyo2;
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

    private Boolean dispaeoisakujyo3;

    public Boolean getDispaeoisakujyo3() {
        return (dispaeoisakujyo3 == null) ? Boolean.FALSE : dispaeoisakujyo3;
    }

    public void setDispaeoisakujyo3(Boolean pDispaeoisakujyo3) {
        dispaeoisakujyo3 = (pDispaeoisakujyo3 == null) ? Boolean.FALSE : pDispaeoisakujyo3;
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

    private Boolean dispaeoisakujyo4;

    public Boolean getDispaeoisakujyo4() {
        return (dispaeoisakujyo4 == null) ? Boolean.FALSE : dispaeoisakujyo4;
    }

    public void setDispaeoisakujyo4(Boolean pDispaeoisakujyo4) {
        dispaeoisakujyo4 = (pDispaeoisakujyo4 == null) ? Boolean.FALSE : pDispaeoisakujyo4;
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

    private Boolean dispaeoisakujyo5;

    public Boolean getDispaeoisakujyo5() {
        return (dispaeoisakujyo5 == null) ? Boolean.FALSE : dispaeoisakujyo5;
    }

    public void setDispaeoisakujyo5(Boolean pDispaeoisakujyo5) {
        dispaeoisakujyo5 = (pDispaeoisakujyo5 == null) ? Boolean.FALSE : pDispaeoisakujyo5;
    }

    private Integer aeoirecordkensuu;

    public Integer getAeoirecordkensuu() {
        return aeoirecordkensuu;
    }

    public void setAeoirecordkensuu(Integer pAeoirecordkensuu) {
        aeoirecordkensuu = pAeoirecordkensuu;
    }
}
