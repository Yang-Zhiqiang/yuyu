package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DrtnCdKensakuKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SkykymdKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申込状況照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkMosSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KensakuKekkaDataSourceBean> kensakuKekkaDataSource = new DataSource<>();
    public DataSource<KensakuKekkaDataSourceBean> getKensakuKekkaDataSource() {
        return kensakuKekkaDataSource;
    }

    @Deprecated
    public List<KensakuKekkaDataSourceBean> getKensakuKekka() {
        return kensakuKekkaDataSource.getDatas();
    }

    public void setKensakuKekka(List<KensakuKekkaDataSourceBean> pKensakuKekka) {
        kensakuKekkaDataSource.setDatas(pKensakuKekka, 10);
    }

    private DataSource<KetteiHoryuuHubiDataSourceBean> ketteiHoryuuHubiDataSource = new DataSource<>();
    public DataSource<KetteiHoryuuHubiDataSourceBean> getKetteiHoryuuHubiDataSource() {
        return ketteiHoryuuHubiDataSource;
    }

    @Deprecated
    public List<KetteiHoryuuHubiDataSourceBean> getKetteiHoryuuHubi() {
        return ketteiHoryuuHubiDataSource.getDatas();
    }

    public void setKetteiHoryuuHubi(List<KetteiHoryuuHubiDataSourceBean> pKetteiHoryuuHubi) {
        ketteiHoryuuHubiDataSource.setDatas(pKetteiHoryuuHubi);
    }

    private DataSource<SeirituHoryuuHubiDataSourceBean> seirituHoryuuHubiDataSource = new DataSource<>();
    public DataSource<SeirituHoryuuHubiDataSourceBean> getSeirituHoryuuHubiDataSource() {
        return seirituHoryuuHubiDataSource;
    }

    @Deprecated
    public List<SeirituHoryuuHubiDataSourceBean> getSeirituHoryuuHubi() {
        return seirituHoryuuHubiDataSource.getDatas();
    }

    public void setSeirituHoryuuHubi(List<SeirituHoryuuHubiDataSourceBean> pSeirituHoryuuHubi) {
        seirituHoryuuHubiDataSource.setDatas(pSeirituHoryuuHubi);
    }

    private DataSource<WarningDataSourceBean> warningDataSource = new DataSource<>();
    public DataSource<WarningDataSourceBean> getWarningDataSource() {
        return warningDataSource;
    }

    @Deprecated
    public List<WarningDataSourceBean> getWarning() {
        return warningDataSource.getDatas();
    }

    public void setWarning(List<WarningDataSourceBean> pWarning) {
        warningDataSource.setDatas(pWarning);
    }

    private DataSource<KihonHubiDataSourceBean> kihonHubiDataSource = new DataSource<>();
    public DataSource<KihonHubiDataSourceBean> getKihonHubiDataSource() {
        return kihonHubiDataSource;
    }

    @Deprecated
    public List<KihonHubiDataSourceBean> getKihonHubi() {
        return kihonHubiDataSource.getDatas();
    }

    public void setKihonHubi(List<KihonHubiDataSourceBean> pKihonHubi) {
        kihonHubiDataSource.setDatas(pKihonHubi);
    }

    private DataSource<SkToriatukaiTyuuiInfoDataSourceBean> skToriatukaiTyuuiInfoDataSource = new DataSource<>();
    public DataSource<SkToriatukaiTyuuiInfoDataSourceBean> getSkToriatukaiTyuuiInfoDataSource() {
        return skToriatukaiTyuuiInfoDataSource;
    }

    @Deprecated
    public List<SkToriatukaiTyuuiInfoDataSourceBean> getSkToriatukaiTyuuiInfo() {
        return skToriatukaiTyuuiInfoDataSource.getDatas();
    }

    public void setSkToriatukaiTyuuiInfo(List<SkToriatukaiTyuuiInfoDataSourceBean> pSkToriatukaiTyuuiInfo) {
        skToriatukaiTyuuiInfoDataSource.setDatas(pSkToriatukaiTyuuiInfo);
    }

    private DataSource<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoDataSource = new DataSource<>();
    public DataSource<SonotaTyuuiInfoDataSourceBean> getSonotaTyuuiInfoDataSource() {
        return sonotaTyuuiInfoDataSource;
    }

    @Deprecated
    public List<SonotaTyuuiInfoDataSourceBean> getSonotaTyuuiInfo() {
        return sonotaTyuuiInfoDataSource.getDatas();
    }

    public void setSonotaTyuuiInfo(List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfo) {
        sonotaTyuuiInfoDataSource.setDatas(pSonotaTyuuiInfo);
    }

    private DataSource<HubiItiranDataSourceBean> hubiItiranDataSource = new DataSource<>();
    public DataSource<HubiItiranDataSourceBean> getHubiItiranDataSource() {
        return hubiItiranDataSource;
    }

    @Deprecated
    public List<HubiItiranDataSourceBean> getHubiItiran() {
        return hubiItiranDataSource.getDatas();
    }

    public void setHubiItiran(List<HubiItiranDataSourceBean> pHubiItiran) {
        hubiItiranDataSource.setDatas(pHubiItiran);
    }

    private DataSource<NyuukinInfoDataSourceBean> nyuukinInfoDataSource = new DataSource<>();
    public DataSource<NyuukinInfoDataSourceBean> getNyuukinInfoDataSource() {
        return nyuukinInfoDataSource;
    }

    @Deprecated
    public List<NyuukinInfoDataSourceBean> getNyuukinInfo() {
        return nyuukinInfoDataSource.getDatas();
    }

    public void setNyuukinInfo(List<NyuukinInfoDataSourceBean> pNyuukinInfo) {
        nyuukinInfoDataSource.setDatas(pNyuukinInfo);
    }

    private DataSource<PkakinInfoDataSourceBean> pkakinInfoDataSource = new DataSource<>();
    public DataSource<PkakinInfoDataSourceBean> getPkakinInfoDataSource() {
        return pkakinInfoDataSource;
    }

    @Deprecated
    public List<PkakinInfoDataSourceBean> getPkakinInfo() {
        return pkakinInfoDataSource.getDatas();
    }

    public void setPkakinInfo(List<PkakinInfoDataSourceBean> pPkakinInfo) {
        pkakinInfoDataSource.setDatas(pPkakinInfo);
    }

    private DataSource<HenkinInfoDataSourceBean> henkinInfoDataSource = new DataSource<>();
    public DataSource<HenkinInfoDataSourceBean> getHenkinInfoDataSource() {
        return henkinInfoDataSource;
    }

    @Deprecated
    public List<HenkinInfoDataSourceBean> getHenkinInfo() {
        return henkinInfoDataSource.getDatas();
    }

    public void setHenkinInfo(List<HenkinInfoDataSourceBean> pHenkinInfo) {
        henkinInfoDataSource.setDatas(pHenkinInfo);
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

    private DataSource<TeiseiRirekiInfoItiranDataSourceBean> teiseiRirekiInfoItiranDataSource = new DataSource<>();
    public DataSource<TeiseiRirekiInfoItiranDataSourceBean> getTeiseiRirekiInfoItiranDataSource() {
        return teiseiRirekiInfoItiranDataSource;
    }

    @Deprecated
    public List<TeiseiRirekiInfoItiranDataSourceBean> getTeiseiRirekiInfoItiran() {
        return teiseiRirekiInfoItiranDataSource.getDatas();
    }

    public void setTeiseiRirekiInfoItiran(List<TeiseiRirekiInfoItiranDataSourceBean> pTeiseiRirekiInfoItiran) {
        teiseiRirekiInfoItiranDataSource.setDatas(pTeiseiRirekiInfoItiran);
    }

    private DataSource<KykSakuinInfoDataSourceBean> kykSakuinInfoDataSource = new DataSource<>();
    public DataSource<KykSakuinInfoDataSourceBean> getKykSakuinInfoDataSource() {
        return kykSakuinInfoDataSource;
    }

    @Deprecated
    public List<KykSakuinInfoDataSourceBean> getKykSakuinInfo() {
        return kykSakuinInfoDataSource.getDatas();
    }

    public void setKykSakuinInfo(List<KykSakuinInfoDataSourceBean> pKykSakuinInfo) {
        kykSakuinInfoDataSource.setDatas(pKykSakuinInfo);
    }

    private DataSource<HhknSakuinInfoDataSourceBean> hhknSakuinInfoDataSource = new DataSource<>();
    public DataSource<HhknSakuinInfoDataSourceBean> getHhknSakuinInfoDataSource() {
        return hhknSakuinInfoDataSource;
    }

    @Deprecated
    public List<HhknSakuinInfoDataSourceBean> getHhknSakuinInfo() {
        return hhknSakuinInfoDataSource.getDatas();
    }

    public void setHhknSakuinInfo(List<HhknSakuinInfoDataSourceBean> pHhknSakuinInfo) {
        hhknSakuinInfoDataSource.setDatas(pHhknSakuinInfo);
    }

    private DataSource<KouteiJyoukyouBaseInfoDataSourceBean> kouteiJyoukyouBaseInfoDataSource = new DataSource<>();
    public DataSource<KouteiJyoukyouBaseInfoDataSourceBean> getKouteiJyoukyouBaseInfoDataSource() {
        return kouteiJyoukyouBaseInfoDataSource;
    }

    @Deprecated
    public List<KouteiJyoukyouBaseInfoDataSourceBean> getKouteiJyoukyouBaseInfo() {
        return kouteiJyoukyouBaseInfoDataSource.getDatas();
    }

    public void setKouteiJyoukyouBaseInfo(List<KouteiJyoukyouBaseInfoDataSourceBean> pKouteiJyoukyouBaseInfo) {
        kouteiJyoukyouBaseInfoDataSource.setDatas(pKouteiJyoukyouBaseInfo);
    }

    private String kihonjouhoubtn;

    public String getKihonjouhoubtn() {
        return kihonjouhoubtn;
    }

    public void setKihonjouhoubtn(String pKihonjouhoubtn) {
        kihonjouhoubtn = pKihonjouhoubtn;
    }

    private String keiyakusyajouhoubtn;

    public String getKeiyakusyajouhoubtn() {
        return keiyakusyajouhoubtn;
    }

    public void setKeiyakusyajouhoubtn(String pKeiyakusyajouhoubtn) {
        keiyakusyajouhoubtn = pKeiyakusyajouhoubtn;
    }

    private String tusinsakijouhoubtn;

    public String getTusinsakijouhoubtn() {
        return tusinsakijouhoubtn;
    }

    public void setTusinsakijouhoubtn(String pTusinsakijouhoubtn) {
        tusinsakijouhoubtn = pTusinsakijouhoubtn;
    }

    private String hihokensyajouhoubtn;

    public String getHihokensyajouhoubtn() {
        return hihokensyajouhoubtn;
    }

    public void setHihokensyajouhoubtn(String pHihokensyajouhoubtn) {
        hihokensyajouhoubtn = pHihokensyajouhoubtn;
    }

    private String uketorininbtn;

    public String getUketorininbtn() {
        return uketorininbtn;
    }

    public void setUketorininbtn(String pUketorininbtn) {
        uketorininbtn = pUketorininbtn;
    }

    private String hosyouinfobtn;

    public String getHosyouinfobtn() {
        return hosyouinfobtn;
    }

    public void setHosyouinfobtn(String pHosyouinfobtn) {
        hosyouinfobtn = pHosyouinfobtn;
    }

    private String siteidairininbtn;

    public String getSiteidairininbtn() {
        return siteidairininbtn;
    }

    public void setSiteidairininbtn(String pSiteidairininbtn) {
        siteidairininbtn = pSiteidairininbtn;
    }

    private String dairitenjouhoubtn;

    public String getDairitenjouhoubtn() {
        return dairitenjouhoubtn;
    }

    public void setDairitenjouhoubtn(String pDairitenjouhoubtn) {
        dairitenjouhoubtn = pDairitenjouhoubtn;
    }

    private C_SateijtKbn sateijtkbn;

    public C_SateijtKbn getSateijtkbn() {
        return sateijtkbn;
    }

    public void setSateijtkbn(C_SateijtKbn pSateijtkbn) {
        sateijtkbn = pSateijtkbn;
    }

    private BizDate sateizumiymd;

    public BizDate getSateizumiymd() {
        return sateizumiymd;
    }

    @Trim("both")
    public void setSateizumiymd(BizDate pSateizumiymd) {
        sateizumiymd = pSateizumiymd;
    }

    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    private String jimuyoucd;

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private BizDate lastrsymd;

    public BizDate getLastrsymd() {
        return lastrsymd;
    }

    public void setLastrsymd(BizDate pLastrsymd) {
        lastrsymd = pLastrsymd;
    }

    private C_ZenhnknKbn zenhnknkbn;

    public C_ZenhnknKbn getZenhnknkbn() {
        return zenhnknkbn;
    }

    public void setZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {
        zenhnknkbn = pZenhnknkbn;
    }

    private C_UmuKbn mosnrkumu;

    public C_UmuKbn getMosnrkumu() {
        return mosnrkumu;
    }

    public void setMosnrkumu(C_UmuKbn pMosnrkumu) {
        mosnrkumu = pMosnrkumu;
    }

    private C_KkthjyKbn kkthjykbn;

    public C_KkthjyKbn getKkthjykbn() {
        return kkthjykbn;
    }

    public void setKkthjykbn(C_KkthjyKbn pKkthjykbn) {
        kkthjykbn = pKkthjykbn;
    }

    private C_UmuKbn nyknnrkumu;

    public C_UmuKbn getNyknnrkumu() {
        return nyknnrkumu;
    }

    public void setNyknnrkumu(C_UmuKbn pNyknnrkumu) {
        nyknnrkumu = pNyknnrkumu;
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

    private C_MostenkenjyouKbn mostenkenjoukbn;

    public C_MostenkenjyouKbn getMostenkenjoukbn() {
        return mostenkenjoukbn;
    }

    public void setMostenkenjoukbn(C_MostenkenjyouKbn pMostenkenjoukbn) {
        mostenkenjoukbn = pMostenkenjoukbn;
    }

    private C_UmuKbn hubiumu;

    public C_UmuKbn getHubiumu() {
        return hubiumu;
    }

    public void setHubiumu(C_UmuKbn pHubiumu) {
        hubiumu = pHubiumu;
    }

    private C_KykkakjkKbn kykkakjkkbn;

    public C_KykkakjkKbn getKykkakjkkbn() {
        return kykkakjkkbn;
    }

    public void setKykkakjkkbn(C_KykkakjkKbn pKykkakjkkbn) {
        kykkakjkkbn = pKykkakjkkbn;
    }

    private C_LincjkKbn lincjkkbn;

    public C_LincjkKbn getLincjkkbn() {
        return lincjkkbn;
    }

    public void setLincjkkbn(C_LincjkKbn pLincjkkbn) {
        lincjkkbn = pLincjkkbn;
    }

    private C_LinckknnjkKbn linckknnjkkbn;

    public C_LinckknnjkKbn getLinckknnjkkbn() {
        return linckknnjkkbn;
    }

    public void setLinckknnjkkbn(C_LinckknnjkKbn pLinckknnjkkbn) {
        linckknnjkkbn = pLinckknnjkkbn;
    }

    private C_KnkysateijyouKbn knkysateijyoukbn;

    public C_KnkysateijyouKbn getKnkysateijyoukbn() {
        return knkysateijyoukbn;
    }

    public void setKnkysateijyoukbn(C_KnkysateijyouKbn pKnkysateijyoukbn) {
        knkysateijyoukbn = pKnkysateijyoukbn;
    }

    private C_ImusateijyouKbn imusateijyoukbn;

    public C_ImusateijyouKbn getImusateijyoukbn() {
        return imusateijyoukbn;
    }

    public void setImusateijyoukbn(C_ImusateijyouKbn pImusateijyoukbn) {
        imusateijyoukbn = pImusateijyoukbn;
    }

    private C_KetteiKbn ketteikbn;

    public C_KetteiKbn getKetteikbn() {
        return ketteikbn;
    }

    public void setKetteikbn(C_KetteiKbn pKetteikbn) {
        ketteikbn = pKetteikbn;
    }

    private C_JimusrhKbn jimusrhkbn;

    public C_JimusrhKbn getJimusrhkbn() {
        return jimusrhkbn;
    }

    public void setJimusrhkbn(C_JimusrhKbn pJimusrhkbn) {
        jimusrhkbn = pJimusrhkbn;
    }

    private C_SeirituKbn seiritukbn;

    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate syohakkouymd;

    public BizDate getSyohakkouymd() {
        return syohakkouymd;
    }

    public void setSyohakkouymd(BizDate pSyohakkouymd) {
        syohakkouymd = pSyohakkouymd;
    }

    private C_MostenkenyhKbn mostenken1jiyhkbn;

    public C_MostenkenyhKbn getMostenken1jiyhkbn() {
        return mostenken1jiyhkbn;
    }

    public void setMostenken1jiyhkbn(C_MostenkenyhKbn pMostenken1jiyhkbn) {
        mostenken1jiyhkbn = pMostenken1jiyhkbn;
    }

    private C_MostenkenyhKbn mostenken2jiyhkbn;

    public C_MostenkenyhKbn getMostenken2jiyhkbn() {
        return mostenken2jiyhkbn;
    }

    public void setMostenken2jiyhkbn(C_MostenkenyhKbn pMostenken2jiyhkbn) {
        mostenken2jiyhkbn = pMostenken2jiyhkbn;
    }

    private C_Knkysatei1jiyhKbn knkysatei1jiyhkbn;

    public C_Knkysatei1jiyhKbn getKnkysatei1jiyhkbn() {
        return knkysatei1jiyhkbn;
    }

    public void setKnkysatei1jiyhkbn(C_Knkysatei1jiyhKbn pKnkysatei1jiyhkbn) {
        knkysatei1jiyhkbn = pKnkysatei1jiyhkbn;
    }

    private C_Knkysatei2jiyhKbn knkysatei2jiyhkbn;

    public C_Knkysatei2jiyhKbn getKnkysatei2jiyhkbn() {
        return knkysatei2jiyhkbn;
    }

    public void setKnkysatei2jiyhkbn(C_Knkysatei2jiyhKbn pKnkysatei2jiyhkbn) {
        knkysatei2jiyhkbn = pKnkysatei2jiyhkbn;
    }

    private C_ImusateikaniyhKbn imusateikaniyhkbn;

    public C_ImusateikaniyhKbn getImusateikaniyhkbn() {
        return imusateikaniyhkbn;
    }

    public void setImusateikaniyhkbn(C_ImusateikaniyhKbn pImusateikaniyhkbn) {
        imusateikaniyhkbn = pImusateikaniyhkbn;
    }

    private C_LincgthtkekKbn lincgthtkekkbn;

    public C_LincgthtkekKbn getLincgthtkekkbn() {
        return lincgthtkekkbn;
    }

    public void setLincgthtkekkbn(C_LincgthtkekKbn pLincgthtkekkbn) {
        lincgthtkekkbn = pLincgthtkekkbn;
    }

    private C_VrfjkKbn mosnrkvrfjkkbn;

    public C_VrfjkKbn getMosnrkvrfjkkbn() {
        return mosnrkvrfjkkbn;
    }

    public void setMosnrkvrfjkkbn(C_VrfjkKbn pMosnrkvrfjkkbn) {
        mosnrkvrfjkkbn = pMosnrkvrfjkkbn;
    }

    private C_VrfjkKbn kktnrkvrfjkkbn;

    public C_VrfjkKbn getKktnrkvrfjkkbn() {
        return kktnrkvrfjkkbn;
    }

    public void setKktnrkvrfjkkbn(C_VrfjkKbn pKktnrkvrfjkkbn) {
        kktnrkvrfjkkbn = pKktnrkvrfjkkbn;
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
    private String aitemosno;

    public String getAitemosno() {
        return aitemosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
    }

    @SyoukenNo
    private String doujikaiyakusyono;

    public String getDoujikaiyakusyono() {
        return doujikaiyakusyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDoujikaiyakusyono(String pDoujikaiyakusyono) {
        doujikaiyakusyono = pDoujikaiyakusyono;
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
    private BizDate ssyukeymd;

    public BizDate getSsyukeymd() {
        return ssyukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSsyukeymd(BizDate pSsyukeymd) {
        ssyukeymd = pSsyukeymd;
    }

    private BizDate kykymd;

    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_SkykymdKbn skykymdkbn;

    public C_SkykymdKbn getSkykymdkbn() {
        return skykymdkbn;
    }

    public void setSkykymdkbn(C_SkykymdKbn pSkykymdkbn) {
        skykymdkbn = pSkykymdkbn;
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

    private BizDate sknnkaisiymd;

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM seisekiym;

    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private C_MosUketukeKbn mosuketukekbn;

    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private String hknsyuruinm;

    public String getHknsyuruinm() {
        return hknsyuruinm;
    }

    public void setHknsyuruinm(String pHknsyuruinm) {
        hknsyuruinm = pHknsyuruinm;
    }

    private String aisyoumei;

    public String getAisyoumei() {
        return aisyoumei;
    }

    public void setAisyoumei(String pAisyoumei) {
        aisyoumei = pAisyoumei;
    }

    private String snshuhusyurui;

    public String getSnshuhusyurui() {
        return snshuhusyurui;
    }

    public void setSnshuhusyurui(String pSnshuhusyurui) {
        snshuhusyurui = pSnshuhusyurui;
    }

    @MousikomiNo
    private String srchmosno;

    public String getSrchmosno() {
        return srchmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmosno(String pSrchmosno) {
        srchmosno = pSrchmosno;
    }

    @SyoukenNo
    private String srchsyono;

    public String getSrchsyono() {
        return srchsyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyono(String pSrchsyono) {
        srchsyono = pSrchsyono;
    }

    @Length(length=11)
    @AlphaDigit
    private String srchkanriid;

    public String getSrchkanriid() {
        return srchkanriid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkanriid(String pSrchkanriid) {
        srchkanriid = pSrchkanriid;
    }

    private String syoukaibtn;

    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    @ValidDate
    private BizDate srchmosfromymd;

    public BizDate getSrchmosfromymd() {
        return srchmosfromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmosfromymd(BizDate pSrchmosfromymd) {
        srchmosfromymd = pSrchmosfromymd;
    }

    @ValidDate
    private BizDate srchmostoymd;

    public BizDate getSrchmostoymd() {
        return srchmostoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmostoymd(BizDate pSrchmostoymd) {
        srchmostoymd = pSrchmostoymd;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private C_DrtnCdKensakuKbn drtncdkensakukbn;

    public C_DrtnCdKensakuKbn getDrtncdkensakukbn() {
        return drtncdkensakukbn;
    }

    public void setDrtncdkensakukbn(C_DrtnCdKensakuKbn pDrtncdkensakukbn) {
        drtncdkensakukbn = pDrtncdkensakukbn;
    }

    @MaxLength(max=4)
    @AlphaDigit
    private String srchkinyuucd;

    public String getSrchkinyuucd() {
        return srchkinyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkinyuucd(String pSrchkinyuucd) {
        srchkinyuucd = pSrchkinyuucd;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String srchkyknmkn;

    public String getSrchkyknmkn() {
        return srchkyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchkyknmkn(String pSrchkyknmkn) {
        srchkyknmkn = pSrchkyknmkn;
    }

    @ValidDate
    private BizDate srchkykseiymd;

    public BizDate getSrchkykseiymd() {
        return srchkykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkykseiymd(BizDate pSrchkykseiymd) {
        srchkykseiymd = pSrchkykseiymd;
    }

    private C_BlnktkumuKbn srchnyknumu;

    public C_BlnktkumuKbn getSrchnyknumu() {
        return srchnyknumu;
    }

    public void setSrchnyknumu(C_BlnktkumuKbn pSrchnyknumu) {
        srchnyknumu = pSrchnyknumu;
    }

    private C_KetteiKbn srchketteikbn;

    public C_KetteiKbn getSrchketteikbn() {
        return srchketteikbn;
    }

    public void setSrchketteikbn(C_KetteiKbn pSrchketteikbn) {
        srchketteikbn = pSrchketteikbn;
    }

    private C_SeirituKbn srchseiritukbn;

    public C_SeirituKbn getSrchseiritukbn() {
        return srchseiritukbn;
    }

    public void setSrchseiritukbn(C_SeirituKbn pSrchseiritukbn) {
        srchseiritukbn = pSrchseiritukbn;
    }

    private Boolean srchkthhbari;

    public Boolean getSrchkthhbari() {
        return (srchkthhbari == null) ? Boolean.FALSE : srchkthhbari;
    }

    public void setSrchkthhbari(Boolean pSrchkthhbari) {
        srchkthhbari = (pSrchkthhbari == null) ? Boolean.FALSE : pSrchkthhbari;
    }

    private Boolean srchsrhhbari;

    public Boolean getSrchsrhhbari() {
        return (srchsrhhbari == null) ? Boolean.FALSE : srchsrhhbari;
    }

    public void setSrchsrhhbari(Boolean pSrchsrhhbari) {
        srchsrhhbari = (pSrchsrhhbari == null) ? Boolean.FALSE : pSrchsrhhbari;
    }

    private Boolean srchmkshbari;

    public Boolean getSrchmkshbari() {
        return (srchmkshbari == null) ? Boolean.FALSE : srchmkshbari;
    }

    public void setSrchmkshbari(Boolean pSrchmkshbari) {
        srchmkshbari = (pSrchmkshbari == null) ? Boolean.FALSE : pSrchmkshbari;
    }

    private C_HknsyuruiNo hknsyuruino;

    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private C_KykKbn kykkbn;

    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private String yakkanbunsyono;

    public String getYakkanbunsyono() {
        return yakkanbunsyono;
    }

    public void setYakkanbunsyono(String pYakkanbunsyono) {
        yakkanbunsyono = pYakkanbunsyono;
    }

    private C_FatcasnsiKbn fatcasnsikbn;

    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn pFatcasnsikbn) {
        fatcasnsikbn = pFatcasnsikbn;
    }

    private C_BikkjnssinfoKbn bikkjnssinfokbn;

    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn pBikkjnssinfokbn) {
        bikkjnssinfokbn = pBikkjnssinfokbn;
    }

    private C_FatcakakkekkaKbn fatcakakkekkakbn;

    public C_FatcakakkekkaKbn getFatcakakkekkakbn() {
        return fatcakakkekkakbn;
    }

    public void setFatcakakkekkakbn(C_FatcakakkekkaKbn pFatcakakkekkakbn) {
        fatcakakkekkakbn = pFatcakakkekkakbn;
    }

    private C_AeoisnsiKbn aeoisnsikbn;

    public C_AeoisnsiKbn getAeoisnsikbn() {
        return aeoisnsikbn;
    }

    public void setAeoisnsikbn(C_AeoisnsiKbn pAeoisnsikbn) {
        aeoisnsikbn = pAeoisnsikbn;
    }

    private C_AeoiKekkaKbn aeoikekkakbn;

    public C_AeoiKekkaKbn getAeoikekkakbn() {
        return aeoikekkakbn;
    }

    public void setAeoikekkakbn(C_AeoiKekkaKbn pAeoikekkakbn) {
        aeoikekkakbn = pAeoikekkakbn;
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

    private C_KjkhukaKbn kyknmkjkhukakbn;

    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
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

    private Integer kyknen;

    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Tdk kyktdk;

    public C_Tdk getKyktdk() {
        return kyktdk;
    }

    public void setKyktdk(C_Tdk pKyktdk) {
        kyktdk = pKyktdk;
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

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
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

    @NaturalNumber
    private Integer hhknnen;

    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_TsindousiteiKbn tsindousiteikbn;

    public C_TsindousiteiKbn getTsindousiteikbn() {
        return tsindousiteikbn;
    }

    public void setTsindousiteikbn(C_TsindousiteiKbn pTsindousiteikbn) {
        tsindousiteikbn = pTsindousiteikbn;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String hhknyno;

    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr1kj;

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr2kj;

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr3kj;

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String hhkntelno;

    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
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

    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    private String hhknsykgycd;

    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private String hhknsykgynm;

    public String getHhknsykgynm() {
        return hhknsykgynm;
    }

    public void setHhknsykgynm(String pHhknsykgynm) {
        hhknsykgynm = pHhknsykgynm;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private C_UktKbn nenkinuktkbn;

    public C_UktKbn getNenkinuktkbn() {
        return nenkinuktkbn;
    }

    public void setNenkinuktkbn(C_UktKbn pNenkinuktkbn) {
        nenkinuktkbn = pNenkinuktkbn;
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

    private C_KjkhukaKbn dispsbuktnmkjhukakbn1;

    public C_KjkhukaKbn getDispsbuktnmkjhukakbn1() {
        return dispsbuktnmkjhukakbn1;
    }

    public void setDispsbuktnmkjhukakbn1(C_KjkhukaKbn pDispsbuktnmkjhukakbn1) {
        dispsbuktnmkjhukakbn1 = pDispsbuktnmkjhukakbn1;
    }

    private BizDate dispsbuktseiymd1;

    public BizDate getDispsbuktseiymd1() {
        return dispsbuktseiymd1;
    }

    public void setDispsbuktseiymd1(BizDate pDispsbuktseiymd1) {
        dispsbuktseiymd1 = pDispsbuktseiymd1;
    }

    private C_Tdk dispsbukttdk1;

    public C_Tdk getDispsbukttdk1() {
        return dispsbukttdk1;
    }

    public void setDispsbukttdk1(C_Tdk pDispsbukttdk1) {
        dispsbukttdk1 = pDispsbukttdk1;
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

    private C_KjkhukaKbn dispsbuktnmkjhukakbn2;

    public C_KjkhukaKbn getDispsbuktnmkjhukakbn2() {
        return dispsbuktnmkjhukakbn2;
    }

    public void setDispsbuktnmkjhukakbn2(C_KjkhukaKbn pDispsbuktnmkjhukakbn2) {
        dispsbuktnmkjhukakbn2 = pDispsbuktnmkjhukakbn2;
    }

    private BizDate dispsbuktseiymd2;

    public BizDate getDispsbuktseiymd2() {
        return dispsbuktseiymd2;
    }

    public void setDispsbuktseiymd2(BizDate pDispsbuktseiymd2) {
        dispsbuktseiymd2 = pDispsbuktseiymd2;
    }

    private C_Tdk dispsbukttdk2;

    public C_Tdk getDispsbukttdk2() {
        return dispsbukttdk2;
    }

    public void setDispsbukttdk2(C_Tdk pDispsbukttdk2) {
        dispsbukttdk2 = pDispsbukttdk2;
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

    private C_KjkhukaKbn dispsbuktnmkjhukakbn3;

    public C_KjkhukaKbn getDispsbuktnmkjhukakbn3() {
        return dispsbuktnmkjhukakbn3;
    }

    public void setDispsbuktnmkjhukakbn3(C_KjkhukaKbn pDispsbuktnmkjhukakbn3) {
        dispsbuktnmkjhukakbn3 = pDispsbuktnmkjhukakbn3;
    }

    private BizDate dispsbuktseiymd3;

    public BizDate getDispsbuktseiymd3() {
        return dispsbuktseiymd3;
    }

    public void setDispsbuktseiymd3(BizDate pDispsbuktseiymd3) {
        dispsbuktseiymd3 = pDispsbuktseiymd3;
    }

    private C_Tdk dispsbukttdk3;

    public C_Tdk getDispsbukttdk3() {
        return dispsbukttdk3;
    }

    public void setDispsbukttdk3(C_Tdk pDispsbukttdk3) {
        dispsbukttdk3 = pDispsbukttdk3;
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

    private C_KjkhukaKbn dispsbuktnmkjhukakbn4;

    public C_KjkhukaKbn getDispsbuktnmkjhukakbn4() {
        return dispsbuktnmkjhukakbn4;
    }

    public void setDispsbuktnmkjhukakbn4(C_KjkhukaKbn pDispsbuktnmkjhukakbn4) {
        dispsbuktnmkjhukakbn4 = pDispsbuktnmkjhukakbn4;
    }

    private BizDate dispsbuktseiymd4;

    public BizDate getDispsbuktseiymd4() {
        return dispsbuktseiymd4;
    }

    public void setDispsbuktseiymd4(BizDate pDispsbuktseiymd4) {
        dispsbuktseiymd4 = pDispsbuktseiymd4;
    }

    private C_Tdk dispsbukttdk4;

    public C_Tdk getDispsbukttdk4() {
        return dispsbukttdk4;
    }

    public void setDispsbukttdk4(C_Tdk pDispsbukttdk4) {
        dispsbukttdk4 = pDispsbukttdk4;
    }

    private BizNumber dispsbuktbnwari4;

    public BizNumber getDispsbuktbnwari4() {
        return dispsbuktbnwari4;
    }

    public void setDispsbuktbnwari4(BizNumber pDispsbuktbnwari4) {
        dispsbuktbnwari4 = pDispsbuktbnwari4;
    }

    @Range(min="0", max="99")
    private Integer syuhrkkkn;

    public Integer getSyuhrkkkn() {
        return syuhrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhrkkkn(Integer pSyuhrkkkn) {
        syuhrkkkn = pSyuhrkkkn;
    }

    private C_HrkkknsmnKbn syuhrkkknsmnkbn;

    public C_HrkkknsmnKbn getSyuhrkkknsmnkbn() {
        return syuhrkkknsmnkbn;
    }

    public void setSyuhrkkknsmnkbn(C_HrkkknsmnKbn pSyuhrkkknsmnkbn) {
        syuhrkkknsmnkbn = pSyuhrkkknsmnkbn;
    }

    @Range(min="0", max="99")
    private Integer syuhknkkn;

    public Integer getSyuhknkkn() {
        return syuhknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhknkkn(Integer pSyuhknkkn) {
        syuhknkkn = pSyuhknkkn;
    }

    private C_HknkknsmnKbn syuhknkknsmnkbn;

    public C_HknkknsmnKbn getSyuhknkknsmnkbn() {
        return syuhknkknsmnkbn;
    }

    public void setSyuhknkknsmnkbn(C_HknkknsmnKbn pSyuhknkknsmnkbn) {
        syuhknkknsmnkbn = pSyuhknkknsmnkbn;
    }

    private Integer nkshrstartnen;

    public Integer getNkshrstartnen() {
        return nkshrstartnen;
    }

    public void setNkshrstartnen(Integer pNkshrstartnen) {
        nkshrstartnen = pNkshrstartnen;
    }

    private Integer sueokikkn;

    public Integer getSueokikkn() {
        return sueokikkn;
    }

    public void setSueokikkn(Integer pSueokikkn) {
        sueokikkn = pSueokikkn;
    }

    @Range(min="0", max="99")
    private Integer syudai1hknkkn;

    public Integer getSyudai1hknkkn() {
        return syudai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyudai1hknkkn(Integer pSyudai1hknkkn) {
        syudai1hknkkn = pSyudai1hknkkn;
    }

    private C_Sdpd sdpdkbn;

    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_HaitouKbn haitoukbn;

    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_Sknenkinsyu sknenkinsyu;

    public C_Sknenkinsyu getSknenkinsyu() {
        return sknenkinsyu;
    }

    public void setSknenkinsyu(C_Sknenkinsyu pSknenkinsyu) {
        sknenkinsyu = pSknenkinsyu;
    }

    private C_BlnktkumuKbn zenkizennouumu;

    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        zenkizennouumu = pZenkizennouumu;
    }

    @Range(min="0", max="999")
    private Integer znnkai;

    public Integer getZnnkai() {
        return znnkai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnkai(Integer pZnnkai) {
        znnkai = pZnnkai;
    }

    private C_Hrkkaisuu hrkkaisuu;

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private C_Tuukasyu kyktuukasyu;

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency syup;

    public BizCurrency getSyup() {
        return syup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyup(BizCurrency pSyup) {
        syup = pSyup;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mossyup;

    public BizCurrency getMossyup() {
        return mossyup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossyup(BizCurrency pMossyup) {
        mossyup = pMossyup;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency hrktuukasyukykp;

    public BizCurrency getHrktuukasyukykp() {
        return hrktuukasyukykp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukasyukykp(BizCurrency pHrktuukasyukykp) {
        hrktuukasyukykp = pHrktuukasyukykp;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency syukihons;

    public BizCurrency getSyukihons() {
        return syukihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyukihons(BizCurrency pSyukihons) {
        syukihons = pSyukihons;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency syumoskihons;

    public BizCurrency getSyumoskihons() {
        return syumoskihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyumoskihons(BizCurrency pSyumoskihons) {
        syumoskihons = pSyumoskihons;
    }

    private BizDate nyknkwsratekijyunymd;

    public BizDate getNyknkwsratekijyunymd() {
        return nyknkwsratekijyunymd;
    }

    public void setNyknkwsratekijyunymd(BizDate pNyknkwsratekijyunymd) {
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
    }

    private String tyuuimongon1;

    public String getTyuuimongon1() {
        return tyuuimongon1;
    }

    public void setTyuuimongon1(String pTyuuimongon1) {
        tyuuimongon1 = pTyuuimongon1;
    }

    private BizNumber nyknkwsrate;

    public BizNumber getNyknkwsrate() {
        return nyknkwsrate;
    }

    public void setNyknkwsrate(BizNumber pNyknkwsrate) {
        nyknkwsrate = pNyknkwsrate;
    }

    private String tyuuimongon2;

    public String getTyuuimongon2() {
        return tyuuimongon2;
    }

    public void setTyuuimongon2(String pTyuuimongon2) {
        tyuuimongon2 = pTyuuimongon2;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    private String sisuunm;

    public String getSisuunm() {
        return sisuunm;
    }

    @Trim("both")
    public void setSisuunm(String pSisuunm) {
        sisuunm = pSisuunm;
    }

    private C_TumitatekinHaibunWariKbn teirituhaibunwarikbn;

    public C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn() {
        return teirituhaibunwarikbn;
    }

    public void setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn pTeirituhaibunwarikbn) {
        teirituhaibunwarikbn = pTeirituhaibunwarikbn;
    }

    private C_NkgnsHosyourituKbn nkgnshosyouritukbn;

    public C_NkgnsHosyourituKbn getNkgnshosyouritukbn() {
        return nkgnshosyouritukbn;
    }

    public void setNkgnshosyouritukbn(C_NkgnsHosyourituKbn pNkgnshosyouritukbn) {
        nkgnshosyouritukbn = pNkgnshosyouritukbn;
    }

    private C_PWaribikitekiyouKbn pwaribikitekiyoukbn;

    public C_PWaribikitekiyouKbn getPwaribikitekiyoukbn() {
        return pwaribikitekiyoukbn;
    }

    public void setPwaribikitekiyoukbn(C_PWaribikitekiyouKbn pPwaribikitekiyoukbn) {
        pwaribikitekiyoukbn = pPwaribikitekiyoukbn;
    }

    private String inquiryyoteiriritu;

    public String getInquiryyoteiriritu() {
        return inquiryyoteiriritu;
    }

    public void setInquiryyoteiriritu(String pInquiryyoteiriritu) {
        inquiryyoteiriritu = pInquiryyoteiriritu;
    }

    private String tyuuimongon3;

    public String getTyuuimongon3() {
        return tyuuimongon3;
    }

    public void setTyuuimongon3(String pTyuuimongon3) {
        tyuuimongon3 = pTyuuimongon3;
    }

    private String inquirytumitateriritu;

    public String getInquirytumitateriritu() {
        return inquirytumitateriritu;
    }

    public void setInquirytumitateriritu(String pInquirytumitateriritu) {
        inquirytumitateriritu = pInquirytumitateriritu;
    }

    private String inquiryloadinghnkgtmttrrt;

    public String getInquiryloadinghnkgtmttrrt() {
        return inquiryloadinghnkgtmttrrt;
    }

    public void setInquiryloadinghnkgtmttrrt(String pInquiryloadinghnkgtmttrrt) {
        inquiryloadinghnkgtmttrrt = pInquiryloadinghnkgtmttrrt;
    }

    private String tyuuimongon4;

    public String getTyuuimongon4() {
        return tyuuimongon4;
    }

    public void setTyuuimongon4(String pTyuuimongon4) {
        tyuuimongon4 = pTyuuimongon4;
    }

    private String inquirytmttknzoukaritujygn;

    public String getInquirytmttknzoukaritujygn() {
        return inquirytmttknzoukaritujygn;
    }

    public void setInquirytmttknzoukaritujygn(String pInquirytmttknzoukaritujygn) {
        inquirytmttknzoukaritujygn = pInquirytmttknzoukaritujygn;
    }

    private String tyuuimongon5;

    public String getTyuuimongon5() {
        return tyuuimongon5;
    }

    public void setTyuuimongon5(String pTyuuimongon5) {
        tyuuimongon5 = pTyuuimongon5;
    }

    private String inquirysetteibairitu;

    public String getInquirysetteibairitu() {
        return inquirysetteibairitu;
    }

    public void setInquirysetteibairitu(String pInquirysetteibairitu) {
        inquirysetteibairitu = pInquirysetteibairitu;
    }

    private String tyuuimongon6;

    public String getTyuuimongon6() {
        return tyuuimongon6;
    }

    public void setTyuuimongon6(String pTyuuimongon6) {
        tyuuimongon6 = pTyuuimongon6;
    }

    private String inquiryrendouritu;

    public String getInquiryrendouritu() {
        return inquiryrendouritu;
    }

    public void setInquiryrendouritu(String pInquiryrendouritu) {
        inquiryrendouritu = pInquiryrendouritu;
    }

    private String tyuuimongon7;

    public String getTyuuimongon7() {
        return tyuuimongon7;
    }

    public void setTyuuimongon7(String pTyuuimongon7) {
        tyuuimongon7 = pTyuuimongon7;
    }

    private BizCurrency dispfstphrkgk;

    public BizCurrency getDispfstphrkgk() {
        return dispfstphrkgk;
    }

    public void setDispfstphrkgk(BizCurrency pDispfstphrkgk) {
        dispfstphrkgk = pDispfstphrkgk;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mosfstpkei;

    public BizCurrency getMosfstpkei() {
        return mosfstpkei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosfstpkei(BizCurrency pMosfstpkei) {
        mosfstpkei = pMosfstpkei;
    }

    private BizCurrency ikkatup;

    public BizCurrency getIkkatup() {
        return ikkatup;
    }

    public void setIkkatup(BizCurrency pIkkatup) {
        ikkatup = pIkkatup;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mosikkatup;

    public BizCurrency getMosikkatup() {
        return mosikkatup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup(BizCurrency pMosikkatup) {
        mosikkatup = pMosikkatup;
    }

    private BizCurrency zennoup;

    public BizCurrency getZennoup() {
        return zennoup;
    }

    public void setZennoup(BizCurrency pZennoup) {
        zennoup = pZennoup;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency zennouphrkgk;

    public BizCurrency getZennouphrkgk() {
        return zennouphrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouphrkgk(BizCurrency pZennouphrkgk) {
        zennouphrkgk = pZennouphrkgk;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency moszennoupsyokaiari;

    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari(BizCurrency pMoszennoupsyokaiari) {
        moszennoupsyokaiari = pMoszennoupsyokaiari;
    }

    private BizCurrency pharaikomisougaku;

    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        pharaikomisougaku = pPharaikomisougaku;
    }

    private C_Tkhukaumu teikisiharaitkykhkkbn;

    public C_Tkhukaumu getTeikisiharaitkykhkkbn() {
        return teikisiharaitkykhkkbn;
    }

    public void setTeikisiharaitkykhkkbn(C_Tkhukaumu pTeikisiharaitkykhkkbn) {
        teikisiharaitkykhkkbn = pTeikisiharaitkykhkkbn;
    }

    private BizCurrency teikisiharaikin;

    public BizCurrency getTeikisiharaikin() {
        return teikisiharaikin;
    }

    public void setTeikisiharaikin(BizCurrency pTeikisiharaikin) {
        teikisiharaikin = pTeikisiharaikin;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
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

    private C_Tkhukaumu syksbyensitihsyutkhkkbn;

    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu pSyksbyensitihsyutkhkkbn) {
        syksbyensitihsyutkhkkbn = pSyksbyensitihsyutkhkkbn;
    }

    private C_Tkhukaumu jyudkaigomehrtkhkkbn;

    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu pJyudkaigomehrtkhkkbn) {
        jyudkaigomehrtkhkkbn = pJyudkaigomehrtkhkkbn;
    }

    private C_Tkhukaumu nstkhkkbn;

    public C_Tkhukaumu getNstkhkkbn() {
        return nstkhkkbn;
    }

    public void setNstkhkkbn(C_Tkhukaumu pNstkhkkbn) {
        nstkhkkbn = pNstkhkkbn;
    }

    @Range(min="0", max="99")
    private Integer nstksbnkkn;

    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstksbnkkn(Integer pNstksbnkkn) {
        nstksbnkkn = pNstksbnkkn;
    }

    private C_Tkhukaumu targettkhkkbn;

    public C_Tkhukaumu getTargettkhkkbn() {
        return targettkhkkbn;
    }

    public void setTargettkhkkbn(C_Tkhukaumu pTargettkhkkbn) {
        targettkhkkbn = pTargettkhkkbn;
    }

    private C_TargetTkMokuhyoutiKbn targettkmkhtkbn;

    public C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn() {
        return targettkmkhtkbn;
    }

    public void setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn pTargettkmkhtkbn) {
        targettkmkhtkbn = pTargettkmkhtkbn;
    }

    private BizCurrency mkhyouyensysnikougk;

    public BizCurrency getMkhyouyensysnikougk() {
        return mkhyouyensysnikougk;
    }

    public void setMkhyouyensysnikougk(BizCurrency pMkhyouyensysnikougk) {
        mkhyouyensysnikougk = pMkhyouyensysnikougk;
    }

    private BizCurrency targettkykkijyungk;

    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn;

    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn() {
        return kjnnkpzeitekitkhukakbn;
    }

    public void setKjnnkpzeitekitkhukakbn(C_Tkhukaumu pKjnnkpzeitekitkhukakbn) {
        kjnnkpzeitekitkhukakbn = pKjnnkpzeitekitkhukakbn;
    }

    private C_Tkhukaumu yennykntkhkkbn;

    public C_Tkhukaumu getYennykntkhkkbn() {
        return yennykntkhkkbn;
    }

    public void setYennykntkhkkbn(C_Tkhukaumu pYennykntkhkkbn) {
        yennykntkhkkbn = pYennykntkhkkbn;
    }

    private C_Tkhukaumu gaikanykntkhkkbn;

    public C_Tkhukaumu getGaikanykntkhkkbn() {
        return gaikanykntkhkkbn;
    }

    public void setGaikanykntkhkkbn(C_Tkhukaumu pGaikanykntkhkkbn) {
        gaikanykntkhkkbn = pGaikanykntkhkkbn;
    }

    private C_KzktourokuserviceTourokuKbn kzktourokuservicetourokukbn;

    public C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn() {
        return kzktourokuservicetourokukbn;
    }

    public void setKzktourokuservicetourokukbn(C_KzktourokuserviceTourokuKbn pKzktourokuservicetourokukbn) {
        kzktourokuservicetourokukbn = pKzktourokuservicetourokukbn;
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

    private C_Seibetu trkkzksei1;

    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private C_Tdk trkkzktdk1;

    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
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

    private C_Seibetu trkkzksei2;

    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private C_Tdk trkkzktdk2;

    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
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

    private C_Tkhukaumu kykdrtkykhukakbn;

    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_UktKbn kykdrkbn;

    public C_UktKbn getKykdrkbn() {
        return kykdrkbn;
    }

    public void setKykdrkbn(C_UktKbn pKykdrkbn) {
        kykdrkbn = pKykdrkbn;
    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn) {
        stdrsktkyhkkbn = pStdrsktkyhkkbn;
    }

    private C_UktKbn stdruktkbn;

    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktkbn = pStdruktkbn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String siteidruktnmkn;

    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkn(String pSiteidruktnmkn) {
        siteidruktnmkn = pSiteidruktnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String siteidruktnmkj;

    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkj(String pSiteidruktnmkj) {
        siteidruktnmkj = pSiteidruktnmkj;
    }

    private C_KjkhukaKbn stdrsknmkjhukakbn;

    public C_KjkhukaKbn getStdrsknmkjhukakbn() {
        return stdrsknmkjhukakbn;
    }

    public void setStdrsknmkjhukakbn(C_KjkhukaKbn pStdrsknmkjhukakbn) {
        stdrsknmkjhukakbn = pStdrsknmkjhukakbn;
    }

    @ValidDate
    private BizDate siteidrseiymd;

    public BizDate getSiteidrseiymd() {
        return siteidrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiteidrseiymd(BizDate pSiteidrseiymd) {
        siteidrseiymd = pSiteidrseiymd;
    }

    private C_Tdk siteidrukttdk;

    public C_Tdk getSiteidrukttdk() {
        return siteidrukttdk;
    }

    public void setSiteidrukttdk(C_Tdk pSiteidrukttdk) {
        siteidrukttdk = pSiteidrukttdk;
    }

    private C_KzhuritourokuhouKbn kzhuritourokuhoukbn;

    public C_KzhuritourokuhouKbn getKzhuritourokuhoukbn() {
        return kzhuritourokuhoukbn;
    }

    public void setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn pKzhuritourokuhoukbn) {
        kzhuritourokuhoukbn = pKzhuritourokuhoukbn;
    }

    @Length(length=4)
    @Digit
    private String kouhurikouzainfobankcd;

    public String getKouhurikouzainfobankcd() {
        return kouhurikouzainfobankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfobankcd(String pKouhurikouzainfobankcd) {
        kouhurikouzainfobankcd = pKouhurikouzainfobankcd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String kouhurikouzainfobanknmkj;

    public String getKouhurikouzainfobanknmkj() {
        return kouhurikouzainfobanknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfobanknmkj(String pKouhurikouzainfobanknmkj) {
        kouhurikouzainfobanknmkj = pKouhurikouzainfobanknmkj;
    }

    @Length(length=3)
    @Digit
    private String kouhurikouzainfositencd;

    public String getKouhurikouzainfositencd() {
        return kouhurikouzainfositencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfositencd(String pKouhurikouzainfositencd) {
        kouhurikouzainfositencd = pKouhurikouzainfositencd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String kouhurikouzainfositennmkj;

    public String getKouhurikouzainfositennmkj() {
        return kouhurikouzainfositennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfositennmkj(String pKouhurikouzainfositennmkj) {
        kouhurikouzainfositennmkj = pKouhurikouzainfositennmkj;
    }

    private C_YokinKbn kouhurikouzainfoyokinkbn;

    public C_YokinKbn getKouhurikouzainfoyokinkbn() {
        return kouhurikouzainfoyokinkbn;
    }

    public void setKouhurikouzainfoyokinkbn(C_YokinKbn pKouhurikouzainfoyokinkbn) {
        kouhurikouzainfoyokinkbn = pKouhurikouzainfoyokinkbn;
    }

    @MaxLength(max=12)
    @HostInvalidCharacter
    private String kouhurikouzainfokouzano;

    public String getKouhurikouzainfokouzano() {
        return kouhurikouzainfokouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfokouzano(String pKouhurikouzainfokouzano) {
        kouhurikouzainfokouzano = pKouhurikouzainfokouzano;
    }

    private C_KzkykdouKbn kouhurikouzainfokzdoukbn;

    public C_KzkykdouKbn getKouhurikouzainfokzdoukbn() {
        return kouhurikouzainfokzdoukbn;
    }

    public void setKouhurikouzainfokzdoukbn(C_KzkykdouKbn pKouhurikouzainfokzdoukbn) {
        kouhurikouzainfokzdoukbn = pKouhurikouzainfokzdoukbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kouhurikouzainfokzmeiginmkn;

    public String getKouhurikouzainfokzmeiginmkn() {
        return kouhurikouzainfokzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfokzmeiginmkn(String pKouhurikouzainfokzmeiginmkn) {
        kouhurikouzainfokzmeiginmkn = pKouhurikouzainfokzmeiginmkn;
    }

    private C_YouhiblnkKbn kouzakakuniniraikbn;

    public C_YouhiblnkKbn getKouzakakuniniraikbn() {
        return kouzakakuniniraikbn;
    }

    public void setKouzakakuniniraikbn(C_YouhiblnkKbn pKouzakakuniniraikbn) {
        kouzakakuniniraikbn = pKouzakakuniniraikbn;
    }

    @ValidDate
    private BizDate authorikakymd;

    public BizDate getAuthorikakymd() {
        return authorikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikakymd(BizDate pAuthorikakymd) {
        authorikakymd = pAuthorikakymd;
    }

    private C_CardBrandKbn cardbrandkbn;

    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private String credittrkjk;

    public String getCredittrkjk() {
        return credittrkjk;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCredittrkjk(String pCredittrkjk) {
        credittrkjk = pCredittrkjk;
    }

    private String dispcreditkessaiyouno;

    public String getDispcreditkessaiyouno() {
        return dispcreditkessaiyouno;
    }

    public void setDispcreditkessaiyouno(String pDispcreditkessaiyouno) {
        dispcreditkessaiyouno = pDispcreditkessaiyouno;
    }

    private C_CreditTrkhouKbn credittrkhoukbn;

    public C_CreditTrkhouKbn getCredittrkhoukbn() {
        return credittrkhoukbn;
    }

    public void setCredittrkhoukbn(C_CreditTrkhouKbn pCredittrkhoukbn) {
        credittrkhoukbn = pCredittrkhoukbn;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;

    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pSkskknhonninkakninsyoruikbn) {
        skskknhonninkakninsyoruikbn = pSkskknhonninkakninsyoruikbn;
    }

    private C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn;

    public C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn() {
        return koureikzksetumeihoukbn;
    }

    public void setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn pKoureikzksetumeihoukbn) {
        koureikzksetumeihoukbn = pKoureikzksetumeihoukbn;
    }

    private C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn;

    public C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn() {
        return koureimndnhukusuukaikbn;
    }

    public void setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn pKoureimndnhukusuukaikbn) {
        koureimndnhukusuukaikbn = pKoureimndnhukusuukaikbn;
    }

    private C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn;

    public C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn() {
        return koureitratkisyaigidskkbn;
    }

    public void setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn pKoureitratkisyaigidskkbn) {
        koureitratkisyaigidskkbn = pKoureitratkisyaigidskkbn;
    }

    private String dispjimusyocd1;

    public String getDispjimusyocd1() {
        return dispjimusyocd1;
    }

    public void setDispjimusyocd1(String pDispjimusyocd1) {
        dispjimusyocd1 = pDispjimusyocd1;
    }

    private String dispkinyuucd1;

    public String getDispkinyuucd1() {
        return dispkinyuucd1;
    }

    public void setDispkinyuucd1(String pDispkinyuucd1) {
        dispkinyuucd1 = pDispkinyuucd1;
    }

    private String dispkinyuusitencd1;

    public String getDispkinyuusitencd1() {
        return dispkinyuusitencd1;
    }

    public void setDispkinyuusitencd1(String pDispkinyuusitencd1) {
        dispkinyuusitencd1 = pDispkinyuusitencd1;
    }

    private String disptratkikouinncd1;

    public String getDisptratkikouinncd1() {
        return disptratkikouinncd1;
    }

    public void setDisptratkikouinncd1(String pDisptratkikouinncd1) {
        disptratkikouinncd1 = pDisptratkikouinncd1;
    }

    private String dispinputbosyuucd1;

    public String getDispinputbosyuucd1() {
        return dispinputbosyuucd1;
    }

    public void setDispinputbosyuucd1(String pDispinputbosyuucd1) {
        dispinputbosyuucd1 = pDispinputbosyuucd1;
    }

    private String dispbosyuutrkno1;

    public String getDispbosyuutrkno1() {
        return dispbosyuutrkno1;
    }

    public void setDispbosyuutrkno1(String pDispbosyuutrkno1) {
        dispbosyuutrkno1 = pDispbosyuutrkno1;
    }

    private String disptratkiagcd1;

    public String getDisptratkiagcd1() {
        return disptratkiagcd1;
    }

    public void setDisptratkiagcd1(String pDisptratkiagcd1) {
        disptratkiagcd1 = pDisptratkiagcd1;
    }

    private String disptratkiagnm1;

    public String getDisptratkiagnm1() {
        return disptratkiagnm1;
    }

    public void setDisptratkiagnm1(String pDisptratkiagnm1) {
        disptratkiagnm1 = pDisptratkiagnm1;
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

    private String dispgyskkjsakisosikicd1;

    public String getDispgyskkjsakisosikicd1() {
        return dispgyskkjsakisosikicd1;
    }

    public void setDispgyskkjsakisosikicd1(String pDispgyskkjsakisosikicd1) {
        dispgyskkjsakisosikicd1 = pDispgyskkjsakisosikicd1;
    }

    private String dispgyskkjsakisosikinmkj1;

    public String getDispgyskkjsakisosikinmkj1() {
        return dispgyskkjsakisosikinmkj1;
    }

    public void setDispgyskkjsakisosikinmkj1(String pDispgyskkjsakisosikinmkj1) {
        dispgyskkjsakisosikinmkj1 = pDispgyskkjsakisosikinmkj1;
    }

    private BizNumber dispbunwari1;

    public BizNumber getDispbunwari1() {
        return dispbunwari1;
    }

    public void setDispbunwari1(BizNumber pDispbunwari1) {
        dispbunwari1 = pDispbunwari1;
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

    @Length(length=11)
    @AlphaDigit
    @HostInvalidCharacter
    private String uktkid;

    public String getUktkid() {
        return uktkid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktkid(String pUktkid) {
        uktkid = pUktkid;
    }

    private String dispjimusyocd2;

    public String getDispjimusyocd2() {
        return dispjimusyocd2;
    }

    public void setDispjimusyocd2(String pDispjimusyocd2) {
        dispjimusyocd2 = pDispjimusyocd2;
    }

    private String dispkinyuucd2;

    public String getDispkinyuucd2() {
        return dispkinyuucd2;
    }

    public void setDispkinyuucd2(String pDispkinyuucd2) {
        dispkinyuucd2 = pDispkinyuucd2;
    }

    private String dispkinyuusitencd2;

    public String getDispkinyuusitencd2() {
        return dispkinyuusitencd2;
    }

    public void setDispkinyuusitencd2(String pDispkinyuusitencd2) {
        dispkinyuusitencd2 = pDispkinyuusitencd2;
    }

    private String disptratkikouinncd2;

    public String getDisptratkikouinncd2() {
        return disptratkikouinncd2;
    }

    public void setDisptratkikouinncd2(String pDisptratkikouinncd2) {
        disptratkikouinncd2 = pDisptratkikouinncd2;
    }

    private String dispinputbosyuucd2;

    public String getDispinputbosyuucd2() {
        return dispinputbosyuucd2;
    }

    public void setDispinputbosyuucd2(String pDispinputbosyuucd2) {
        dispinputbosyuucd2 = pDispinputbosyuucd2;
    }

    private String dispbosyuutrkno2;

    public String getDispbosyuutrkno2() {
        return dispbosyuutrkno2;
    }

    public void setDispbosyuutrkno2(String pDispbosyuutrkno2) {
        dispbosyuutrkno2 = pDispbosyuutrkno2;
    }

    private String disptratkiagcd2;

    public String getDisptratkiagcd2() {
        return disptratkiagcd2;
    }

    public void setDisptratkiagcd2(String pDisptratkiagcd2) {
        disptratkiagcd2 = pDisptratkiagcd2;
    }

    private String disptratkiagnm2;

    public String getDisptratkiagnm2() {
        return disptratkiagnm2;
    }

    public void setDisptratkiagnm2(String pDisptratkiagnm2) {
        disptratkiagnm2 = pDisptratkiagnm2;
    }

    private String dispoyadrtencd2;

    public String getDispoyadrtencd2() {
        return dispoyadrtencd2;
    }

    public void setDispoyadrtencd2(String pDispoyadrtencd2) {
        dispoyadrtencd2 = pDispoyadrtencd2;
    }

    private String dispoyadrtennm2;

    public String getDispoyadrtennm2() {
        return dispoyadrtennm2;
    }

    public void setDispoyadrtennm2(String pDispoyadrtennm2) {
        dispoyadrtennm2 = pDispoyadrtennm2;
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

    private String dispgyskkjsakisosikicd2;

    public String getDispgyskkjsakisosikicd2() {
        return dispgyskkjsakisosikicd2;
    }

    public void setDispgyskkjsakisosikicd2(String pDispgyskkjsakisosikicd2) {
        dispgyskkjsakisosikicd2 = pDispgyskkjsakisosikicd2;
    }

    private String dispgyskkjsakisosikinmkj2;

    public String getDispgyskkjsakisosikinmkj2() {
        return dispgyskkjsakisosikinmkj2;
    }

    public void setDispgyskkjsakisosikinmkj2(String pDispgyskkjsakisosikinmkj2) {
        dispgyskkjsakisosikinmkj2 = pDispgyskkjsakisosikinmkj2;
    }

    private BizNumber dispbunwari2;

    public BizNumber getDispbunwari2() {
        return dispbunwari2;
    }

    public void setDispbunwari2(BizNumber pDispbunwari2) {
        dispbunwari2 = pDispbunwari2;
    }

    private C_KouseiinkykKbn kouseiinkykkbn;

    public C_KouseiinkykKbn getKouseiinkykkbn() {
        return kouseiinkykkbn;
    }

    public void setKouseiinkykkbn(C_KouseiinkykKbn pKouseiinkykkbn) {
        kouseiinkykkbn = pKouseiinkykkbn;
    }

    private C_BlnktkumuKbn kouseiinkyktkjkumukbn;

    public C_BlnktkumuKbn getKouseiinkyktkjkumukbn() {
        return kouseiinkyktkjkumukbn;
    }

    public void setKouseiinkyktkjkumukbn(C_BlnktkumuKbn pKouseiinkyktkjkumukbn) {
        kouseiinkyktkjkumukbn = pKouseiinkyktkjkumukbn;
    }

    private C_KoukankykKbn koukankykkbn;

    public C_KoukankykKbn getKoukankykkbn() {
        return koukankykkbn;
    }

    public void setKoukankykkbn(C_KoukankykKbn pKoukankykkbn) {
        koukankykkbn = pKoukankykkbn;
    }

    @MaxLength(max=35)
    @MultiByteStrings
    @InvalidCharacter
    private String koukankykkinmusakinm;

    public String getKoukankykkinmusakinm() {
        return koukankykkinmusakinm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKoukankykkinmusakinm(String pKoukankykkinmusakinm) {
        koukankykkinmusakinm = pKoukankykkinmusakinm;
    }

    @MaxLength(max=35)
    @MultiByteStrings
    @InvalidCharacter
    private String koukankyksyokumunaiyou;

    public String getKoukankyksyokumunaiyou() {
        return koukankyksyokumunaiyou;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKoukankyksyokumunaiyou(String pKoukankyksyokumunaiyou) {
        koukankyksyokumunaiyou = pKoukankyksyokumunaiyou;
    }

    private C_BlnktkumuKbn koukankyktkjkumukbn;

    public C_BlnktkumuKbn getKoukankyktkjkumukbn() {
        return koukankyktkjkumukbn;
    }

    public void setKoukankyktkjkumukbn(C_BlnktkumuKbn pKoukankyktkjkumukbn) {
        koukankyktkjkumukbn = pKoukankyktkjkumukbn;
    }

    private C_UmuKbn tsryhshrkykumukbn;

    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn pTsryhshrkykumukbn) {
        tsryhshrkykumukbn = pTsryhshrkykumukbn;
    }

    private C_UmuKbn syosisyatodokeumukbn;

    public C_UmuKbn getSyosisyatodokeumukbn() {
        return syosisyatodokeumukbn;
    }

    public void setSyosisyatodokeumukbn(C_UmuKbn pSyosisyatodokeumukbn) {
        syosisyatodokeumukbn = pSyosisyatodokeumukbn;
    }

    private C_UmuKbn kakukisyouryakukbumukbn;

    public C_UmuKbn getKakukisyouryakukbumukbn() {
        return kakukisyouryakukbumukbn;
    }

    public void setKakukisyouryakukbumukbn(C_UmuKbn pKakukisyouryakukbumukbn) {
        kakukisyouryakukbumukbn = pKakukisyouryakukbumukbn;
    }

    private C_UmuKbn seiymdmosseitouumukbn;

    public C_UmuKbn getSeiymdmosseitouumukbn() {
        return seiymdmosseitouumukbn;
    }

    public void setSeiymdmosseitouumukbn(C_UmuKbn pSeiymdmosseitouumukbn) {
        seiymdmosseitouumukbn = pSeiymdmosseitouumukbn;
    }

    private C_DirectServiceMosKbn drctservicemoskbn;

    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn pDrctservicemoskbn) {
        drctservicemoskbn = pDrctservicemoskbn;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    private String dsmailaddress;

    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    @Length(length=4)
    @Digit
    private String dsbankcd;

    public String getDsbankcd() {
        return dsbankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsbankcd(String pDsbankcd) {
        dsbankcd = pDsbankcd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String dsbanknmkj;

    public String getDsbanknmkj() {
        return dsbanknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDsbanknmkj(String pDsbanknmkj) {
        dsbanknmkj = pDsbanknmkj;
    }

    @Length(length=3)
    @Digit
    private String dssitencd;

    public String getDssitencd() {
        return dssitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDssitencd(String pDssitencd) {
        dssitencd = pDssitencd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String dssitennmkj;

    public String getDssitennmkj() {
        return dssitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDssitennmkj(String pDssitennmkj) {
        dssitennmkj = pDssitennmkj;
    }

    private C_YokinKbn dsyokinkbn;

    public C_YokinKbn getDsyokinkbn() {
        return dsyokinkbn;
    }

    public void setDsyokinkbn(C_YokinKbn pDsyokinkbn) {
        dsyokinkbn = pDsyokinkbn;
    }

    @MaxLength(max=12)
    @HostInvalidCharacter
    private String dskouzano;

    public String getDskouzano() {
        return dskouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDskouzano(String pDskouzano) {
        dskouzano = pDskouzano;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dskzmeiginmkn;

    public String getDskzmeiginmkn() {
        return dskzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDskzmeiginmkn(String pDskzmeiginmkn) {
        dskzmeiginmkn = pDskzmeiginmkn;
    }

    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn) {
        ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
    }

    private C_TkhjnKbn tkhjnkbn;

    public C_TkhjnKbn getTkhjnkbn() {
        return tkhjnkbn;
    }

    public void setTkhjnkbn(C_TkhjnKbn pTkhjnkbn) {
        tkhjnkbn = pTkhjnkbn;
    }

    private C_UmuKbn tkhsyouryakuumukbn;

    public C_UmuKbn getTkhsyouryakuumukbn() {
        return tkhsyouryakuumukbn;
    }

    public void setTkhsyouryakuumukbn(C_UmuKbn pTkhsyouryakuumukbn) {
        tkhsyouryakuumukbn = pTkhsyouryakuumukbn;
    }

    private C_UmuKbn kthhbkbn;

    public C_UmuKbn getKthhbkbn() {
        return kthhbkbn;
    }

    public void setKthhbkbn(C_UmuKbn pKthhbkbn) {
        kthhbkbn = pKthhbkbn;
    }

    private C_UmuKbn srhhbkbn;

    public C_UmuKbn getSrhhbkbn() {
        return srhhbkbn;
    }

    public void setSrhhbkbn(C_UmuKbn pSrhhbkbn) {
        srhhbkbn = pSrhhbkbn;
    }

    private C_UmuKbn khnhbkbn;

    public C_UmuKbn getKhnhbkbn() {
        return khnhbkbn;
    }

    public void setKhnhbkbn(C_UmuKbn pKhnhbkbn) {
        khnhbkbn = pKhnhbkbn;
    }

    private C_YouhiKbn skeittdkkinkyuyouhikbn;

    public C_YouhiKbn getSkeittdkkinkyuyouhikbn() {
        return skeittdkkinkyuyouhikbn;
    }

    public void setSkeittdkkinkyuyouhikbn(C_YouhiKbn pSkeittdkkinkyuyouhikbn) {
        skeittdkkinkyuyouhikbn = pSkeittdkkinkyuyouhikbn;
    }

    private C_YouhiKbn skeittdktyuuiyouhikbn;

    public C_YouhiKbn getSkeittdktyuuiyouhikbn() {
        return skeittdktyuuiyouhikbn;
    }

    public void setSkeittdktyuuiyouhikbn(C_YouhiKbn pSkeittdktyuuiyouhikbn) {
        skeittdktyuuiyouhikbn = pSkeittdktyuuiyouhikbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm1kj;

    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm2kj;

    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String tuutisakitantounmkj;

    public String getTuutisakitantounmkj() {
        return tuutisakitantounmkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTuutisakitantounmkj(String pTuutisakitantounmkj) {
        tuutisakitantounmkj = pTuutisakitantounmkj;
    }

    @ValidTextArea(length=60, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String commentareagamen;

    public String getCommentareagamen() {
        return commentareagamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCommentareagamen(String pCommentareagamen) {
        commentareagamen = pCommentareagamen;
    }

    private BizDate kktkktymd;

    public BizDate getKktkktymd() {
        return kktkktymd;
    }

    public void setKktkktymd(BizDate pKktkktymd) {
        kktkktymd = pKktkktymd;
    }

    @Range(min="0", max="999")
    private Integer sintyou;

    public Integer getSintyou() {
        return sintyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }

    @Range(min="0", max="999")
    private Integer taijyuu;

    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
    }

    private C_KituenKbn kituenkbn;

    public C_KituenKbn getKituenkbn() {
        return kituenkbn;
    }

    public void setKituenkbn(C_KituenKbn pKituenkbn) {
        kituenkbn = pKituenkbn;
    }

    @Range(min="0", max="99")
    private Integer kituenhon;

    public Integer getKituenhon() {
        return kituenhon;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKituenhon(Integer pKituenhon) {
        kituenhon = pKituenhon;
    }

    private C_KijiKbn kijikbn;

    public C_KijiKbn getKijikbn() {
        return kijikbn;
    }

    public void setKijikbn(C_KijiKbn pKijikbn) {
        kijikbn = pKijikbn;
    }

    private C_KzkkijiKbn kzkkijikbn;

    public C_KzkkijiKbn getKzkkijikbn() {
        return kzkkijikbn;
    }

    public void setKzkkijikbn(C_KzkkijiKbn pKzkkijikbn) {
        kzkkijikbn = pKzkkijikbn;
    }

    @MultiByteStringsReturnable
    @InvalidCharacter
    @ValidTextArea(length=40, rows=10)
    private String khnchkcmnt;

    public String getKhnchkcmnt() {
        return khnchkcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKhnchkcmnt(String pKhnchkcmnt) {
        khnchkcmnt = pKhnchkcmnt;
    }

    private String mostenkensjnaiyou;

    public String getMostenkensjnaiyou() {
        return mostenkensjnaiyou;
    }

    public void setMostenkensjnaiyou(String pMostenkensjnaiyou) {
        mostenkensjnaiyou = pMostenkensjnaiyou;
    }

    private BizDate dispmostenkensyoriymd1;

    public BizDate getDispmostenkensyoriymd1() {
        return dispmostenkensyoriymd1;
    }

    public void setDispmostenkensyoriymd1(BizDate pDispmostenkensyoriymd1) {
        dispmostenkensyoriymd1 = pDispmostenkensyoriymd1;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn1;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn1() {
        return dispmostnknstktsyorinmkbn1;
    }

    public void setDispmostnknstktsyorinmkbn1(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn1) {
        dispmostnknstktsyorinmkbn1 = pDispmostnknstktsyorinmkbn1;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn1;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn1() {
        return dispmostenkenkekkakbn1;
    }

    public void setDispmostenkenkekkakbn1(C_SyorikekkaKbn pDispmostenkenkekkakbn1) {
        dispmostenkenkekkakbn1 = pDispmostenkenkekkakbn1;
    }

    private String dispmostns1;

    public String getDispmostns1() {
        return dispmostns1;
    }

    public void setDispmostns1(String pDispmostns1) {
        dispmostns1 = pDispmostns1;
    }

    private String dispmostenkenktnm1;

    public String getDispmostenkenktnm1() {
        return dispmostenkenktnm1;
    }

    public void setDispmostenkenktnm1(String pDispmostenkenktnm1) {
        dispmostenkenktnm1 = pDispmostenkenktnm1;
    }

    private String dispmostenkencomment1;

    public String getDispmostenkencomment1() {
        return dispmostenkencomment1;
    }

    public void setDispmostenkencomment1(String pDispmostenkencomment1) {
        dispmostenkencomment1 = pDispmostenkencomment1;
    }

    private BizDate dispmostenkensyoriymd2;

    public BizDate getDispmostenkensyoriymd2() {
        return dispmostenkensyoriymd2;
    }

    public void setDispmostenkensyoriymd2(BizDate pDispmostenkensyoriymd2) {
        dispmostenkensyoriymd2 = pDispmostenkensyoriymd2;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn2;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn2() {
        return dispmostnknstktsyorinmkbn2;
    }

    public void setDispmostnknstktsyorinmkbn2(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn2) {
        dispmostnknstktsyorinmkbn2 = pDispmostnknstktsyorinmkbn2;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn2;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn2() {
        return dispmostenkenkekkakbn2;
    }

    public void setDispmostenkenkekkakbn2(C_SyorikekkaKbn pDispmostenkenkekkakbn2) {
        dispmostenkenkekkakbn2 = pDispmostenkenkekkakbn2;
    }

    private String dispmostns2;

    public String getDispmostns2() {
        return dispmostns2;
    }

    public void setDispmostns2(String pDispmostns2) {
        dispmostns2 = pDispmostns2;
    }

    private String dispmostenkenktnm2;

    public String getDispmostenkenktnm2() {
        return dispmostenkenktnm2;
    }

    public void setDispmostenkenktnm2(String pDispmostenkenktnm2) {
        dispmostenkenktnm2 = pDispmostenkenktnm2;
    }

    private String dispmostenkencomment2;

    public String getDispmostenkencomment2() {
        return dispmostenkencomment2;
    }

    public void setDispmostenkencomment2(String pDispmostenkencomment2) {
        dispmostenkencomment2 = pDispmostenkencomment2;
    }

    private BizDate dispmostenkensyoriymd3;

    public BizDate getDispmostenkensyoriymd3() {
        return dispmostenkensyoriymd3;
    }

    public void setDispmostenkensyoriymd3(BizDate pDispmostenkensyoriymd3) {
        dispmostenkensyoriymd3 = pDispmostenkensyoriymd3;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn3;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn3() {
        return dispmostnknstktsyorinmkbn3;
    }

    public void setDispmostnknstktsyorinmkbn3(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn3) {
        dispmostnknstktsyorinmkbn3 = pDispmostnknstktsyorinmkbn3;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn3;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn3() {
        return dispmostenkenkekkakbn3;
    }

    public void setDispmostenkenkekkakbn3(C_SyorikekkaKbn pDispmostenkenkekkakbn3) {
        dispmostenkenkekkakbn3 = pDispmostenkenkekkakbn3;
    }

    private String dispmostns3;

    public String getDispmostns3() {
        return dispmostns3;
    }

    public void setDispmostns3(String pDispmostns3) {
        dispmostns3 = pDispmostns3;
    }

    private String dispmostenkenktnm3;

    public String getDispmostenkenktnm3() {
        return dispmostenkenktnm3;
    }

    public void setDispmostenkenktnm3(String pDispmostenkenktnm3) {
        dispmostenkenktnm3 = pDispmostenkenktnm3;
    }

    private String dispmostenkencomment3;

    public String getDispmostenkencomment3() {
        return dispmostenkencomment3;
    }

    public void setDispmostenkencomment3(String pDispmostenkencomment3) {
        dispmostenkencomment3 = pDispmostenkencomment3;
    }

    private BizDate dispmostenkensyoriymd4;

    public BizDate getDispmostenkensyoriymd4() {
        return dispmostenkensyoriymd4;
    }

    public void setDispmostenkensyoriymd4(BizDate pDispmostenkensyoriymd4) {
        dispmostenkensyoriymd4 = pDispmostenkensyoriymd4;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn4;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn4() {
        return dispmostnknstktsyorinmkbn4;
    }

    public void setDispmostnknstktsyorinmkbn4(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn4) {
        dispmostnknstktsyorinmkbn4 = pDispmostnknstktsyorinmkbn4;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn4;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn4() {
        return dispmostenkenkekkakbn4;
    }

    public void setDispmostenkenkekkakbn4(C_SyorikekkaKbn pDispmostenkenkekkakbn4) {
        dispmostenkenkekkakbn4 = pDispmostenkenkekkakbn4;
    }

    private String dispmostns4;

    public String getDispmostns4() {
        return dispmostns4;
    }

    public void setDispmostns4(String pDispmostns4) {
        dispmostns4 = pDispmostns4;
    }

    private String dispmostenkenktnm4;

    public String getDispmostenkenktnm4() {
        return dispmostenkenktnm4;
    }

    public void setDispmostenkenktnm4(String pDispmostenkenktnm4) {
        dispmostenkenktnm4 = pDispmostenkenktnm4;
    }

    private String dispmostenkencomment4;

    public String getDispmostenkencomment4() {
        return dispmostenkencomment4;
    }

    public void setDispmostenkencomment4(String pDispmostenkencomment4) {
        dispmostenkencomment4 = pDispmostenkencomment4;
    }

    private BizDate dispmostenkensyoriymd5;

    public BizDate getDispmostenkensyoriymd5() {
        return dispmostenkensyoriymd5;
    }

    public void setDispmostenkensyoriymd5(BizDate pDispmostenkensyoriymd5) {
        dispmostenkensyoriymd5 = pDispmostenkensyoriymd5;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn5;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn5() {
        return dispmostnknstktsyorinmkbn5;
    }

    public void setDispmostnknstktsyorinmkbn5(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn5) {
        dispmostnknstktsyorinmkbn5 = pDispmostnknstktsyorinmkbn5;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn5;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn5() {
        return dispmostenkenkekkakbn5;
    }

    public void setDispmostenkenkekkakbn5(C_SyorikekkaKbn pDispmostenkenkekkakbn5) {
        dispmostenkenkekkakbn5 = pDispmostenkenkekkakbn5;
    }

    private String dispmostns5;

    public String getDispmostns5() {
        return dispmostns5;
    }

    public void setDispmostns5(String pDispmostns5) {
        dispmostns5 = pDispmostns5;
    }

    private String dispmostenkenktnm5;

    public String getDispmostenkenktnm5() {
        return dispmostenkenktnm5;
    }

    public void setDispmostenkenktnm5(String pDispmostenkenktnm5) {
        dispmostenkenktnm5 = pDispmostenkenktnm5;
    }

    private String dispmostenkencomment5;

    public String getDispmostenkencomment5() {
        return dispmostenkencomment5;
    }

    public void setDispmostenkencomment5(String pDispmostenkencomment5) {
        dispmostenkencomment5 = pDispmostenkencomment5;
    }

    private BizDate dispmostenkensyoriymd6;

    public BizDate getDispmostenkensyoriymd6() {
        return dispmostenkensyoriymd6;
    }

    public void setDispmostenkensyoriymd6(BizDate pDispmostenkensyoriymd6) {
        dispmostenkensyoriymd6 = pDispmostenkensyoriymd6;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn6;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn6() {
        return dispmostnknstktsyorinmkbn6;
    }

    public void setDispmostnknstktsyorinmkbn6(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn6) {
        dispmostnknstktsyorinmkbn6 = pDispmostnknstktsyorinmkbn6;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn6;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn6() {
        return dispmostenkenkekkakbn6;
    }

    public void setDispmostenkenkekkakbn6(C_SyorikekkaKbn pDispmostenkenkekkakbn6) {
        dispmostenkenkekkakbn6 = pDispmostenkenkekkakbn6;
    }

    private String dispmostns6;

    public String getDispmostns6() {
        return dispmostns6;
    }

    public void setDispmostns6(String pDispmostns6) {
        dispmostns6 = pDispmostns6;
    }

    private String dispmostenkenktnm6;

    public String getDispmostenkenktnm6() {
        return dispmostenkenktnm6;
    }

    public void setDispmostenkenktnm6(String pDispmostenkenktnm6) {
        dispmostenkenktnm6 = pDispmostenkenktnm6;
    }

    private String dispmostenkencomment6;

    public String getDispmostenkencomment6() {
        return dispmostenkencomment6;
    }

    public void setDispmostenkencomment6(String pDispmostenkencomment6) {
        dispmostenkencomment6 = pDispmostenkencomment6;
    }

    private BizDate dispmostenkensyoriymd7;

    public BizDate getDispmostenkensyoriymd7() {
        return dispmostenkensyoriymd7;
    }

    public void setDispmostenkensyoriymd7(BizDate pDispmostenkensyoriymd7) {
        dispmostenkensyoriymd7 = pDispmostenkensyoriymd7;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn7;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn7() {
        return dispmostnknstktsyorinmkbn7;
    }

    public void setDispmostnknstktsyorinmkbn7(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn7) {
        dispmostnknstktsyorinmkbn7 = pDispmostnknstktsyorinmkbn7;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn7;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn7() {
        return dispmostenkenkekkakbn7;
    }

    public void setDispmostenkenkekkakbn7(C_SyorikekkaKbn pDispmostenkenkekkakbn7) {
        dispmostenkenkekkakbn7 = pDispmostenkenkekkakbn7;
    }

    private String dispmostns7;

    public String getDispmostns7() {
        return dispmostns7;
    }

    public void setDispmostns7(String pDispmostns7) {
        dispmostns7 = pDispmostns7;
    }

    private String dispmostenkenktnm7;

    public String getDispmostenkenktnm7() {
        return dispmostenkenktnm7;
    }

    public void setDispmostenkenktnm7(String pDispmostenkenktnm7) {
        dispmostenkenktnm7 = pDispmostenkenktnm7;
    }

    private String dispmostenkencomment7;

    public String getDispmostenkencomment7() {
        return dispmostenkencomment7;
    }

    public void setDispmostenkencomment7(String pDispmostenkencomment7) {
        dispmostenkencomment7 = pDispmostenkencomment7;
    }

    private BizDate dispmostenkensyoriymd8;

    public BizDate getDispmostenkensyoriymd8() {
        return dispmostenkensyoriymd8;
    }

    public void setDispmostenkensyoriymd8(BizDate pDispmostenkensyoriymd8) {
        dispmostenkensyoriymd8 = pDispmostenkensyoriymd8;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn8;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn8() {
        return dispmostnknstktsyorinmkbn8;
    }

    public void setDispmostnknstktsyorinmkbn8(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn8) {
        dispmostnknstktsyorinmkbn8 = pDispmostnknstktsyorinmkbn8;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn8;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn8() {
        return dispmostenkenkekkakbn8;
    }

    public void setDispmostenkenkekkakbn8(C_SyorikekkaKbn pDispmostenkenkekkakbn8) {
        dispmostenkenkekkakbn8 = pDispmostenkenkekkakbn8;
    }

    private String dispmostns8;

    public String getDispmostns8() {
        return dispmostns8;
    }

    public void setDispmostns8(String pDispmostns8) {
        dispmostns8 = pDispmostns8;
    }

    private String dispmostenkenktnm8;

    public String getDispmostenkenktnm8() {
        return dispmostenkenktnm8;
    }

    public void setDispmostenkenktnm8(String pDispmostenkenktnm8) {
        dispmostenkenktnm8 = pDispmostenkenktnm8;
    }

    private String dispmostenkencomment8;

    public String getDispmostenkencomment8() {
        return dispmostenkencomment8;
    }

    public void setDispmostenkencomment8(String pDispmostenkencomment8) {
        dispmostenkencomment8 = pDispmostenkencomment8;
    }

    private BizDate dispmostenkensyoriymd9;

    public BizDate getDispmostenkensyoriymd9() {
        return dispmostenkensyoriymd9;
    }

    public void setDispmostenkensyoriymd9(BizDate pDispmostenkensyoriymd9) {
        dispmostenkensyoriymd9 = pDispmostenkensyoriymd9;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn9;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn9() {
        return dispmostnknstktsyorinmkbn9;
    }

    public void setDispmostnknstktsyorinmkbn9(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn9) {
        dispmostnknstktsyorinmkbn9 = pDispmostnknstktsyorinmkbn9;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn9;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn9() {
        return dispmostenkenkekkakbn9;
    }

    public void setDispmostenkenkekkakbn9(C_SyorikekkaKbn pDispmostenkenkekkakbn9) {
        dispmostenkenkekkakbn9 = pDispmostenkenkekkakbn9;
    }

    private String dispmostns9;

    public String getDispmostns9() {
        return dispmostns9;
    }

    public void setDispmostns9(String pDispmostns9) {
        dispmostns9 = pDispmostns9;
    }

    private String dispmostenkenktnm9;

    public String getDispmostenkenktnm9() {
        return dispmostenkenktnm9;
    }

    public void setDispmostenkenktnm9(String pDispmostenkenktnm9) {
        dispmostenkenktnm9 = pDispmostenkenktnm9;
    }

    private String dispmostenkencomment9;

    public String getDispmostenkencomment9() {
        return dispmostenkencomment9;
    }

    public void setDispmostenkencomment9(String pDispmostenkencomment9) {
        dispmostenkencomment9 = pDispmostenkencomment9;
    }

    private BizDate dispmostenkensyoriymd10;

    public BizDate getDispmostenkensyoriymd10() {
        return dispmostenkensyoriymd10;
    }

    public void setDispmostenkensyoriymd10(BizDate pDispmostenkensyoriymd10) {
        dispmostenkensyoriymd10 = pDispmostenkensyoriymd10;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn10;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn10() {
        return dispmostnknstktsyorinmkbn10;
    }

    public void setDispmostnknstktsyorinmkbn10(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn10) {
        dispmostnknstktsyorinmkbn10 = pDispmostnknstktsyorinmkbn10;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn10;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn10() {
        return dispmostenkenkekkakbn10;
    }

    public void setDispmostenkenkekkakbn10(C_SyorikekkaKbn pDispmostenkenkekkakbn10) {
        dispmostenkenkekkakbn10 = pDispmostenkenkekkakbn10;
    }

    private String dispmostns10;

    public String getDispmostns10() {
        return dispmostns10;
    }

    public void setDispmostns10(String pDispmostns10) {
        dispmostns10 = pDispmostns10;
    }

    private String dispmostenkenktnm10;

    public String getDispmostenkenktnm10() {
        return dispmostenkenktnm10;
    }

    public void setDispmostenkenktnm10(String pDispmostenkenktnm10) {
        dispmostenkenktnm10 = pDispmostenkenktnm10;
    }

    private String dispmostenkencomment10;

    public String getDispmostenkencomment10() {
        return dispmostenkencomment10;
    }

    public void setDispmostenkencomment10(String pDispmostenkencomment10) {
        dispmostenkencomment10 = pDispmostenkencomment10;
    }

    private BizDate dispmostenkensyoriymd11;

    public BizDate getDispmostenkensyoriymd11() {
        return dispmostenkensyoriymd11;
    }

    public void setDispmostenkensyoriymd11(BizDate pDispmostenkensyoriymd11) {
        dispmostenkensyoriymd11 = pDispmostenkensyoriymd11;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn11;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn11() {
        return dispmostnknstktsyorinmkbn11;
    }

    public void setDispmostnknstktsyorinmkbn11(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn11) {
        dispmostnknstktsyorinmkbn11 = pDispmostnknstktsyorinmkbn11;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn11;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn11() {
        return dispmostenkenkekkakbn11;
    }

    public void setDispmostenkenkekkakbn11(C_SyorikekkaKbn pDispmostenkenkekkakbn11) {
        dispmostenkenkekkakbn11 = pDispmostenkenkekkakbn11;
    }

    private String dispmostns11;

    public String getDispmostns11() {
        return dispmostns11;
    }

    public void setDispmostns11(String pDispmostns11) {
        dispmostns11 = pDispmostns11;
    }

    private String dispmostenkenktnm11;

    public String getDispmostenkenktnm11() {
        return dispmostenkenktnm11;
    }

    public void setDispmostenkenktnm11(String pDispmostenkenktnm11) {
        dispmostenkenktnm11 = pDispmostenkenktnm11;
    }

    private String dispmostenkencomment11;

    public String getDispmostenkencomment11() {
        return dispmostenkencomment11;
    }

    public void setDispmostenkencomment11(String pDispmostenkencomment11) {
        dispmostenkencomment11 = pDispmostenkencomment11;
    }

    private BizDate dispmostenkensyoriymd12;

    public BizDate getDispmostenkensyoriymd12() {
        return dispmostenkensyoriymd12;
    }

    public void setDispmostenkensyoriymd12(BizDate pDispmostenkensyoriymd12) {
        dispmostenkensyoriymd12 = pDispmostenkensyoriymd12;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn12;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn12() {
        return dispmostnknstktsyorinmkbn12;
    }

    public void setDispmostnknstktsyorinmkbn12(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn12) {
        dispmostnknstktsyorinmkbn12 = pDispmostnknstktsyorinmkbn12;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn12;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn12() {
        return dispmostenkenkekkakbn12;
    }

    public void setDispmostenkenkekkakbn12(C_SyorikekkaKbn pDispmostenkenkekkakbn12) {
        dispmostenkenkekkakbn12 = pDispmostenkenkekkakbn12;
    }

    private String dispmostns12;

    public String getDispmostns12() {
        return dispmostns12;
    }

    public void setDispmostns12(String pDispmostns12) {
        dispmostns12 = pDispmostns12;
    }

    private String dispmostenkenktnm12;

    public String getDispmostenkenktnm12() {
        return dispmostenkenktnm12;
    }

    public void setDispmostenkenktnm12(String pDispmostenkenktnm12) {
        dispmostenkenktnm12 = pDispmostenkenktnm12;
    }

    private String dispmostenkencomment12;

    public String getDispmostenkencomment12() {
        return dispmostenkencomment12;
    }

    public void setDispmostenkencomment12(String pDispmostenkencomment12) {
        dispmostenkencomment12 = pDispmostenkencomment12;
    }

    private BizDate dispmostenkensyoriymd13;

    public BizDate getDispmostenkensyoriymd13() {
        return dispmostenkensyoriymd13;
    }

    public void setDispmostenkensyoriymd13(BizDate pDispmostenkensyoriymd13) {
        dispmostenkensyoriymd13 = pDispmostenkensyoriymd13;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn13;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn13() {
        return dispmostnknstktsyorinmkbn13;
    }

    public void setDispmostnknstktsyorinmkbn13(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn13) {
        dispmostnknstktsyorinmkbn13 = pDispmostnknstktsyorinmkbn13;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn13;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn13() {
        return dispmostenkenkekkakbn13;
    }

    public void setDispmostenkenkekkakbn13(C_SyorikekkaKbn pDispmostenkenkekkakbn13) {
        dispmostenkenkekkakbn13 = pDispmostenkenkekkakbn13;
    }

    private String dispmostns13;

    public String getDispmostns13() {
        return dispmostns13;
    }

    public void setDispmostns13(String pDispmostns13) {
        dispmostns13 = pDispmostns13;
    }

    private String dispmostenkenktnm13;

    public String getDispmostenkenktnm13() {
        return dispmostenkenktnm13;
    }

    public void setDispmostenkenktnm13(String pDispmostenkenktnm13) {
        dispmostenkenktnm13 = pDispmostenkenktnm13;
    }

    private String dispmostenkencomment13;

    public String getDispmostenkencomment13() {
        return dispmostenkencomment13;
    }

    public void setDispmostenkencomment13(String pDispmostenkencomment13) {
        dispmostenkencomment13 = pDispmostenkencomment13;
    }

    private BizDate dispmostenkensyoriymd14;

    public BizDate getDispmostenkensyoriymd14() {
        return dispmostenkensyoriymd14;
    }

    public void setDispmostenkensyoriymd14(BizDate pDispmostenkensyoriymd14) {
        dispmostenkensyoriymd14 = pDispmostenkensyoriymd14;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn14;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn14() {
        return dispmostnknstktsyorinmkbn14;
    }

    public void setDispmostnknstktsyorinmkbn14(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn14) {
        dispmostnknstktsyorinmkbn14 = pDispmostnknstktsyorinmkbn14;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn14;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn14() {
        return dispmostenkenkekkakbn14;
    }

    public void setDispmostenkenkekkakbn14(C_SyorikekkaKbn pDispmostenkenkekkakbn14) {
        dispmostenkenkekkakbn14 = pDispmostenkenkekkakbn14;
    }

    private String dispmostns14;

    public String getDispmostns14() {
        return dispmostns14;
    }

    public void setDispmostns14(String pDispmostns14) {
        dispmostns14 = pDispmostns14;
    }

    private String dispmostenkenktnm14;

    public String getDispmostenkenktnm14() {
        return dispmostenkenktnm14;
    }

    public void setDispmostenkenktnm14(String pDispmostenkenktnm14) {
        dispmostenkenktnm14 = pDispmostenkenktnm14;
    }

    private String dispmostenkencomment14;

    public String getDispmostenkencomment14() {
        return dispmostenkencomment14;
    }

    public void setDispmostenkencomment14(String pDispmostenkencomment14) {
        dispmostenkencomment14 = pDispmostenkencomment14;
    }

    private BizDate dispmostenkensyoriymd15;

    public BizDate getDispmostenkensyoriymd15() {
        return dispmostenkensyoriymd15;
    }

    public void setDispmostenkensyoriymd15(BizDate pDispmostenkensyoriymd15) {
        dispmostenkensyoriymd15 = pDispmostenkensyoriymd15;
    }

    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn15;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn15() {
        return dispmostnknstktsyorinmkbn15;
    }

    public void setDispmostnknstktsyorinmkbn15(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn15) {
        dispmostnknstktsyorinmkbn15 = pDispmostnknstktsyorinmkbn15;
    }

    private C_SyorikekkaKbn dispmostenkenkekkakbn15;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn15() {
        return dispmostenkenkekkakbn15;
    }

    public void setDispmostenkenkekkakbn15(C_SyorikekkaKbn pDispmostenkenkekkakbn15) {
        dispmostenkenkekkakbn15 = pDispmostenkenkekkakbn15;
    }

    private String dispmostns15;

    public String getDispmostns15() {
        return dispmostns15;
    }

    public void setDispmostns15(String pDispmostns15) {
        dispmostns15 = pDispmostns15;
    }

    private String dispmostenkenktnm15;

    public String getDispmostenkenktnm15() {
        return dispmostenkenktnm15;
    }

    public void setDispmostenkenktnm15(String pDispmostenkenktnm15) {
        dispmostenkenktnm15 = pDispmostenkenktnm15;
    }

    private String dispmostenkencomment15;

    public String getDispmostenkencomment15() {
        return dispmostenkencomment15;
    }

    public void setDispmostenkencomment15(String pDispmostenkencomment15) {
        dispmostenkencomment15 = pDispmostenkencomment15;
    }

    private String knksateisjnaiyou;

    public String getKnksateisjnaiyou() {
        return knksateisjnaiyou;
    }

    public void setKnksateisjnaiyou(String pKnksateisjnaiyou) {
        knksateisjnaiyou = pKnksateisjnaiyou;
    }

    private BizDate dispknksyoriymd1;

    public BizDate getDispknksyoriymd1() {
        return dispknksyoriymd1;
    }

    public void setDispknksyoriymd1(BizDate pDispknksyoriymd1) {
        dispknksyoriymd1 = pDispknksyoriymd1;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn1;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn1() {
        return dispknkstktsyorinmkbn1;
    }

    public void setDispknkstktsyorinmkbn1(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn1) {
        dispknkstktsyorinmkbn1 = pDispknkstktsyorinmkbn1;
    }

    private C_SyorikekkaKbn dispknkkekkakbn1;

    public C_SyorikekkaKbn getDispknkkekkakbn1() {
        return dispknkkekkakbn1;
    }

    public void setDispknkkekkakbn1(C_SyorikekkaKbn pDispknkkekkakbn1) {
        dispknkkekkakbn1 = pDispknkkekkakbn1;
    }

    private String dispknktns1;

    public String getDispknktns1() {
        return dispknktns1;
    }

    public void setDispknktns1(String pDispknktns1) {
        dispknktns1 = pDispknktns1;
    }

    private String dispknkktnm1;

    public String getDispknkktnm1() {
        return dispknkktnm1;
    }

    public void setDispknkktnm1(String pDispknkktnm1) {
        dispknkktnm1 = pDispknkktnm1;
    }

    private String dispknkcomment1;

    public String getDispknkcomment1() {
        return dispknkcomment1;
    }

    public void setDispknkcomment1(String pDispknkcomment1) {
        dispknkcomment1 = pDispknkcomment1;
    }

    private C_Ketkekkacd dispknkktkkcd1;

    public C_Ketkekkacd getDispknkktkkcd1() {
        return dispknkktkkcd1;
    }

    public void setDispknkktkkcd1(C_Ketkekkacd pDispknkktkkcd1) {
        dispknkktkkcd1 = pDispknkktkkcd1;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu1;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu1() {
        return dispknktrkssyousairiyuu1;
    }

    public void setDispknktrkssyousairiyuu1(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu1) {
        dispknktrkssyousairiyuu1 = pDispknktrkssyousairiyuu1;
    }

    private String dispknkketriyuucd11;

    public String getDispknkketriyuucd11() {
        return dispknkketriyuucd11;
    }

    public void setDispknkketriyuucd11(String pDispknkketriyuucd11) {
        dispknkketriyuucd11 = pDispknkketriyuucd11;
    }

    private String dispknkketriyuunaiyou11;

    public String getDispknkketriyuunaiyou11() {
        return dispknkketriyuunaiyou11;
    }

    public void setDispknkketriyuunaiyou11(String pDispknkketriyuunaiyou11) {
        dispknkketriyuunaiyou11 = pDispknkketriyuunaiyou11;
    }

    private String dispknkketriyuucd21;

    public String getDispknkketriyuucd21() {
        return dispknkketriyuucd21;
    }

    public void setDispknkketriyuucd21(String pDispknkketriyuucd21) {
        dispknkketriyuucd21 = pDispknkketriyuucd21;
    }

    private String dispknkketriyuunaiyou21;

    public String getDispknkketriyuunaiyou21() {
        return dispknkketriyuunaiyou21;
    }

    public void setDispknkketriyuunaiyou21(String pDispknkketriyuunaiyou21) {
        dispknkketriyuunaiyou21 = pDispknkketriyuunaiyou21;
    }

    private String dispknkketriyuucd31;

    public String getDispknkketriyuucd31() {
        return dispknkketriyuucd31;
    }

    public void setDispknkketriyuucd31(String pDispknkketriyuucd31) {
        dispknkketriyuucd31 = pDispknkketriyuucd31;
    }

    private String dispknkketriyuunaiyou31;

    public String getDispknkketriyuunaiyou31() {
        return dispknkketriyuunaiyou31;
    }

    public void setDispknkketriyuunaiyou31(String pDispknkketriyuunaiyou31) {
        dispknkketriyuunaiyou31 = pDispknkketriyuunaiyou31;
    }

    private String dispknkketriyuucd41;

    public String getDispknkketriyuucd41() {
        return dispknkketriyuucd41;
    }

    public void setDispknkketriyuucd41(String pDispknkketriyuucd41) {
        dispknkketriyuucd41 = pDispknkketriyuucd41;
    }

    private String dispknkketriyuunaiyou41;

    public String getDispknkketriyuunaiyou41() {
        return dispknkketriyuunaiyou41;
    }

    public void setDispknkketriyuunaiyou41(String pDispknkketriyuunaiyou41) {
        dispknkketriyuunaiyou41 = pDispknkketriyuunaiyou41;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou1;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou1() {
        return dispknkmrriyuucdnaiyou1;
    }

    public void setDispknkmrriyuucdnaiyou1(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou1) {
        dispknkmrriyuucdnaiyou1 = pDispknkmrriyuucdnaiyou1;
    }

    private BizDate dispknksyoriymd2;

    public BizDate getDispknksyoriymd2() {
        return dispknksyoriymd2;
    }

    public void setDispknksyoriymd2(BizDate pDispknksyoriymd2) {
        dispknksyoriymd2 = pDispknksyoriymd2;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn2;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn2() {
        return dispknkstktsyorinmkbn2;
    }

    public void setDispknkstktsyorinmkbn2(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn2) {
        dispknkstktsyorinmkbn2 = pDispknkstktsyorinmkbn2;
    }

    private C_SyorikekkaKbn dispknkkekkakbn2;

    public C_SyorikekkaKbn getDispknkkekkakbn2() {
        return dispknkkekkakbn2;
    }

    public void setDispknkkekkakbn2(C_SyorikekkaKbn pDispknkkekkakbn2) {
        dispknkkekkakbn2 = pDispknkkekkakbn2;
    }

    private String dispknktns2;

    public String getDispknktns2() {
        return dispknktns2;
    }

    public void setDispknktns2(String pDispknktns2) {
        dispknktns2 = pDispknktns2;
    }

    private String dispknkktnm2;

    public String getDispknkktnm2() {
        return dispknkktnm2;
    }

    public void setDispknkktnm2(String pDispknkktnm2) {
        dispknkktnm2 = pDispknkktnm2;
    }

    private String dispknkcomment2;

    public String getDispknkcomment2() {
        return dispknkcomment2;
    }

    public void setDispknkcomment2(String pDispknkcomment2) {
        dispknkcomment2 = pDispknkcomment2;
    }

    private C_Ketkekkacd dispknkktkkcd2;

    public C_Ketkekkacd getDispknkktkkcd2() {
        return dispknkktkkcd2;
    }

    public void setDispknkktkkcd2(C_Ketkekkacd pDispknkktkkcd2) {
        dispknkktkkcd2 = pDispknkktkkcd2;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu2;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu2() {
        return dispknktrkssyousairiyuu2;
    }

    public void setDispknktrkssyousairiyuu2(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu2) {
        dispknktrkssyousairiyuu2 = pDispknktrkssyousairiyuu2;
    }

    private String dispknkketriyuucd12;

    public String getDispknkketriyuucd12() {
        return dispknkketriyuucd12;
    }

    public void setDispknkketriyuucd12(String pDispknkketriyuucd12) {
        dispknkketriyuucd12 = pDispknkketriyuucd12;
    }

    private String dispknkketriyuunaiyou12;

    public String getDispknkketriyuunaiyou12() {
        return dispknkketriyuunaiyou12;
    }

    public void setDispknkketriyuunaiyou12(String pDispknkketriyuunaiyou12) {
        dispknkketriyuunaiyou12 = pDispknkketriyuunaiyou12;
    }

    private String dispknkketriyuucd22;

    public String getDispknkketriyuucd22() {
        return dispknkketriyuucd22;
    }

    public void setDispknkketriyuucd22(String pDispknkketriyuucd22) {
        dispknkketriyuucd22 = pDispknkketriyuucd22;
    }

    private String dispknkketriyuunaiyou22;

    public String getDispknkketriyuunaiyou22() {
        return dispknkketriyuunaiyou22;
    }

    public void setDispknkketriyuunaiyou22(String pDispknkketriyuunaiyou22) {
        dispknkketriyuunaiyou22 = pDispknkketriyuunaiyou22;
    }

    private String dispknkketriyuucd32;

    public String getDispknkketriyuucd32() {
        return dispknkketriyuucd32;
    }

    public void setDispknkketriyuucd32(String pDispknkketriyuucd32) {
        dispknkketriyuucd32 = pDispknkketriyuucd32;
    }

    private String dispknkketriyuunaiyou32;

    public String getDispknkketriyuunaiyou32() {
        return dispknkketriyuunaiyou32;
    }

    public void setDispknkketriyuunaiyou32(String pDispknkketriyuunaiyou32) {
        dispknkketriyuunaiyou32 = pDispknkketriyuunaiyou32;
    }

    private String dispknkketriyuucd42;

    public String getDispknkketriyuucd42() {
        return dispknkketriyuucd42;
    }

    public void setDispknkketriyuucd42(String pDispknkketriyuucd42) {
        dispknkketriyuucd42 = pDispknkketriyuucd42;
    }

    private String dispknkketriyuunaiyou42;

    public String getDispknkketriyuunaiyou42() {
        return dispknkketriyuunaiyou42;
    }

    public void setDispknkketriyuunaiyou42(String pDispknkketriyuunaiyou42) {
        dispknkketriyuunaiyou42 = pDispknkketriyuunaiyou42;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou2;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou2() {
        return dispknkmrriyuucdnaiyou2;
    }

    public void setDispknkmrriyuucdnaiyou2(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou2) {
        dispknkmrriyuucdnaiyou2 = pDispknkmrriyuucdnaiyou2;
    }

    private BizDate dispknksyoriymd3;

    public BizDate getDispknksyoriymd3() {
        return dispknksyoriymd3;
    }

    public void setDispknksyoriymd3(BizDate pDispknksyoriymd3) {
        dispknksyoriymd3 = pDispknksyoriymd3;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn3;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn3() {
        return dispknkstktsyorinmkbn3;
    }

    public void setDispknkstktsyorinmkbn3(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn3) {
        dispknkstktsyorinmkbn3 = pDispknkstktsyorinmkbn3;
    }

    private C_SyorikekkaKbn dispknkkekkakbn3;

    public C_SyorikekkaKbn getDispknkkekkakbn3() {
        return dispknkkekkakbn3;
    }

    public void setDispknkkekkakbn3(C_SyorikekkaKbn pDispknkkekkakbn3) {
        dispknkkekkakbn3 = pDispknkkekkakbn3;
    }

    private String dispknktns3;

    public String getDispknktns3() {
        return dispknktns3;
    }

    public void setDispknktns3(String pDispknktns3) {
        dispknktns3 = pDispknktns3;
    }

    private String dispknkktnm3;

    public String getDispknkktnm3() {
        return dispknkktnm3;
    }

    public void setDispknkktnm3(String pDispknkktnm3) {
        dispknkktnm3 = pDispknkktnm3;
    }

    private String dispknkcomment3;

    public String getDispknkcomment3() {
        return dispknkcomment3;
    }

    public void setDispknkcomment3(String pDispknkcomment3) {
        dispknkcomment3 = pDispknkcomment3;
    }

    private C_Ketkekkacd dispknkktkkcd3;

    public C_Ketkekkacd getDispknkktkkcd3() {
        return dispknkktkkcd3;
    }

    public void setDispknkktkkcd3(C_Ketkekkacd pDispknkktkkcd3) {
        dispknkktkkcd3 = pDispknkktkkcd3;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu3;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu3() {
        return dispknktrkssyousairiyuu3;
    }

    public void setDispknktrkssyousairiyuu3(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu3) {
        dispknktrkssyousairiyuu3 = pDispknktrkssyousairiyuu3;
    }

    private String dispknkketriyuucd13;

    public String getDispknkketriyuucd13() {
        return dispknkketriyuucd13;
    }

    public void setDispknkketriyuucd13(String pDispknkketriyuucd13) {
        dispknkketriyuucd13 = pDispknkketriyuucd13;
    }

    private String dispknkketriyuunaiyou13;

    public String getDispknkketriyuunaiyou13() {
        return dispknkketriyuunaiyou13;
    }

    public void setDispknkketriyuunaiyou13(String pDispknkketriyuunaiyou13) {
        dispknkketriyuunaiyou13 = pDispknkketriyuunaiyou13;
    }

    private String dispknkketriyuucd23;

    public String getDispknkketriyuucd23() {
        return dispknkketriyuucd23;
    }

    public void setDispknkketriyuucd23(String pDispknkketriyuucd23) {
        dispknkketriyuucd23 = pDispknkketriyuucd23;
    }

    private String dispknkketriyuunaiyou23;

    public String getDispknkketriyuunaiyou23() {
        return dispknkketriyuunaiyou23;
    }

    public void setDispknkketriyuunaiyou23(String pDispknkketriyuunaiyou23) {
        dispknkketriyuunaiyou23 = pDispknkketriyuunaiyou23;
    }

    private String dispknkketriyuucd33;

    public String getDispknkketriyuucd33() {
        return dispknkketriyuucd33;
    }

    public void setDispknkketriyuucd33(String pDispknkketriyuucd33) {
        dispknkketriyuucd33 = pDispknkketriyuucd33;
    }

    private String dispknkketriyuunaiyou33;

    public String getDispknkketriyuunaiyou33() {
        return dispknkketriyuunaiyou33;
    }

    public void setDispknkketriyuunaiyou33(String pDispknkketriyuunaiyou33) {
        dispknkketriyuunaiyou33 = pDispknkketriyuunaiyou33;
    }

    private String dispknkketriyuucd43;

    public String getDispknkketriyuucd43() {
        return dispknkketriyuucd43;
    }

    public void setDispknkketriyuucd43(String pDispknkketriyuucd43) {
        dispknkketriyuucd43 = pDispknkketriyuucd43;
    }

    private String dispknkketriyuunaiyou43;

    public String getDispknkketriyuunaiyou43() {
        return dispknkketriyuunaiyou43;
    }

    public void setDispknkketriyuunaiyou43(String pDispknkketriyuunaiyou43) {
        dispknkketriyuunaiyou43 = pDispknkketriyuunaiyou43;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou3;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou3() {
        return dispknkmrriyuucdnaiyou3;
    }

    public void setDispknkmrriyuucdnaiyou3(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou3) {
        dispknkmrriyuucdnaiyou3 = pDispknkmrriyuucdnaiyou3;
    }

    private BizDate dispknksyoriymd4;

    public BizDate getDispknksyoriymd4() {
        return dispknksyoriymd4;
    }

    public void setDispknksyoriymd4(BizDate pDispknksyoriymd4) {
        dispknksyoriymd4 = pDispknksyoriymd4;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn4;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn4() {
        return dispknkstktsyorinmkbn4;
    }

    public void setDispknkstktsyorinmkbn4(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn4) {
        dispknkstktsyorinmkbn4 = pDispknkstktsyorinmkbn4;
    }

    private C_SyorikekkaKbn dispknkkekkakbn4;

    public C_SyorikekkaKbn getDispknkkekkakbn4() {
        return dispknkkekkakbn4;
    }

    public void setDispknkkekkakbn4(C_SyorikekkaKbn pDispknkkekkakbn4) {
        dispknkkekkakbn4 = pDispknkkekkakbn4;
    }

    private String dispknktns4;

    public String getDispknktns4() {
        return dispknktns4;
    }

    public void setDispknktns4(String pDispknktns4) {
        dispknktns4 = pDispknktns4;
    }

    private String dispknkktnm4;

    public String getDispknkktnm4() {
        return dispknkktnm4;
    }

    public void setDispknkktnm4(String pDispknkktnm4) {
        dispknkktnm4 = pDispknkktnm4;
    }

    private String dispknkcomment4;

    public String getDispknkcomment4() {
        return dispknkcomment4;
    }

    public void setDispknkcomment4(String pDispknkcomment4) {
        dispknkcomment4 = pDispknkcomment4;
    }

    private C_Ketkekkacd dispknkktkkcd4;

    public C_Ketkekkacd getDispknkktkkcd4() {
        return dispknkktkkcd4;
    }

    public void setDispknkktkkcd4(C_Ketkekkacd pDispknkktkkcd4) {
        dispknkktkkcd4 = pDispknkktkkcd4;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu4;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu4() {
        return dispknktrkssyousairiyuu4;
    }

    public void setDispknktrkssyousairiyuu4(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu4) {
        dispknktrkssyousairiyuu4 = pDispknktrkssyousairiyuu4;
    }

    private String dispknkketriyuucd14;

    public String getDispknkketriyuucd14() {
        return dispknkketriyuucd14;
    }

    public void setDispknkketriyuucd14(String pDispknkketriyuucd14) {
        dispknkketriyuucd14 = pDispknkketriyuucd14;
    }

    private String dispknkketriyuunaiyou14;

    public String getDispknkketriyuunaiyou14() {
        return dispknkketriyuunaiyou14;
    }

    public void setDispknkketriyuunaiyou14(String pDispknkketriyuunaiyou14) {
        dispknkketriyuunaiyou14 = pDispknkketriyuunaiyou14;
    }

    private String dispknkketriyuucd24;

    public String getDispknkketriyuucd24() {
        return dispknkketriyuucd24;
    }

    public void setDispknkketriyuucd24(String pDispknkketriyuucd24) {
        dispknkketriyuucd24 = pDispknkketriyuucd24;
    }

    private String dispknkketriyuunaiyou24;

    public String getDispknkketriyuunaiyou24() {
        return dispknkketriyuunaiyou24;
    }

    public void setDispknkketriyuunaiyou24(String pDispknkketriyuunaiyou24) {
        dispknkketriyuunaiyou24 = pDispknkketriyuunaiyou24;
    }

    private String dispknkketriyuucd34;

    public String getDispknkketriyuucd34() {
        return dispknkketriyuucd34;
    }

    public void setDispknkketriyuucd34(String pDispknkketriyuucd34) {
        dispknkketriyuucd34 = pDispknkketriyuucd34;
    }

    private String dispknkketriyuunaiyou34;

    public String getDispknkketriyuunaiyou34() {
        return dispknkketriyuunaiyou34;
    }

    public void setDispknkketriyuunaiyou34(String pDispknkketriyuunaiyou34) {
        dispknkketriyuunaiyou34 = pDispknkketriyuunaiyou34;
    }

    private String dispknkketriyuucd44;

    public String getDispknkketriyuucd44() {
        return dispknkketriyuucd44;
    }

    public void setDispknkketriyuucd44(String pDispknkketriyuucd44) {
        dispknkketriyuucd44 = pDispknkketriyuucd44;
    }

    private String dispknkketriyuunaiyou44;

    public String getDispknkketriyuunaiyou44() {
        return dispknkketriyuunaiyou44;
    }

    public void setDispknkketriyuunaiyou44(String pDispknkketriyuunaiyou44) {
        dispknkketriyuunaiyou44 = pDispknkketriyuunaiyou44;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou4;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou4() {
        return dispknkmrriyuucdnaiyou4;
    }

    public void setDispknkmrriyuucdnaiyou4(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou4) {
        dispknkmrriyuucdnaiyou4 = pDispknkmrriyuucdnaiyou4;
    }

    private BizDate dispknksyoriymd5;

    public BizDate getDispknksyoriymd5() {
        return dispknksyoriymd5;
    }

    public void setDispknksyoriymd5(BizDate pDispknksyoriymd5) {
        dispknksyoriymd5 = pDispknksyoriymd5;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn5;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn5() {
        return dispknkstktsyorinmkbn5;
    }

    public void setDispknkstktsyorinmkbn5(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn5) {
        dispknkstktsyorinmkbn5 = pDispknkstktsyorinmkbn5;
    }

    private C_SyorikekkaKbn dispknkkekkakbn5;

    public C_SyorikekkaKbn getDispknkkekkakbn5() {
        return dispknkkekkakbn5;
    }

    public void setDispknkkekkakbn5(C_SyorikekkaKbn pDispknkkekkakbn5) {
        dispknkkekkakbn5 = pDispknkkekkakbn5;
    }

    private String dispknktns5;

    public String getDispknktns5() {
        return dispknktns5;
    }

    public void setDispknktns5(String pDispknktns5) {
        dispknktns5 = pDispknktns5;
    }

    private String dispknkktnm5;

    public String getDispknkktnm5() {
        return dispknkktnm5;
    }

    public void setDispknkktnm5(String pDispknkktnm5) {
        dispknkktnm5 = pDispknkktnm5;
    }

    private String dispknkcomment5;

    public String getDispknkcomment5() {
        return dispknkcomment5;
    }

    public void setDispknkcomment5(String pDispknkcomment5) {
        dispknkcomment5 = pDispknkcomment5;
    }

    private C_Ketkekkacd dispknkktkkcd5;

    public C_Ketkekkacd getDispknkktkkcd5() {
        return dispknkktkkcd5;
    }

    public void setDispknkktkkcd5(C_Ketkekkacd pDispknkktkkcd5) {
        dispknkktkkcd5 = pDispknkktkkcd5;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu5;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu5() {
        return dispknktrkssyousairiyuu5;
    }

    public void setDispknktrkssyousairiyuu5(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu5) {
        dispknktrkssyousairiyuu5 = pDispknktrkssyousairiyuu5;
    }

    private String dispknkketriyuucd15;

    public String getDispknkketriyuucd15() {
        return dispknkketriyuucd15;
    }

    public void setDispknkketriyuucd15(String pDispknkketriyuucd15) {
        dispknkketriyuucd15 = pDispknkketriyuucd15;
    }

    private String dispknkketriyuunaiyou15;

    public String getDispknkketriyuunaiyou15() {
        return dispknkketriyuunaiyou15;
    }

    public void setDispknkketriyuunaiyou15(String pDispknkketriyuunaiyou15) {
        dispknkketriyuunaiyou15 = pDispknkketriyuunaiyou15;
    }

    private String dispknkketriyuucd25;

    public String getDispknkketriyuucd25() {
        return dispknkketriyuucd25;
    }

    public void setDispknkketriyuucd25(String pDispknkketriyuucd25) {
        dispknkketriyuucd25 = pDispknkketriyuucd25;
    }

    private String dispknkketriyuunaiyou25;

    public String getDispknkketriyuunaiyou25() {
        return dispknkketriyuunaiyou25;
    }

    public void setDispknkketriyuunaiyou25(String pDispknkketriyuunaiyou25) {
        dispknkketriyuunaiyou25 = pDispknkketriyuunaiyou25;
    }

    private String dispknkketriyuucd35;

    public String getDispknkketriyuucd35() {
        return dispknkketriyuucd35;
    }

    public void setDispknkketriyuucd35(String pDispknkketriyuucd35) {
        dispknkketriyuucd35 = pDispknkketriyuucd35;
    }

    private String dispknkketriyuunaiyou35;

    public String getDispknkketriyuunaiyou35() {
        return dispknkketriyuunaiyou35;
    }

    public void setDispknkketriyuunaiyou35(String pDispknkketriyuunaiyou35) {
        dispknkketriyuunaiyou35 = pDispknkketriyuunaiyou35;
    }

    private String dispknkketriyuucd45;

    public String getDispknkketriyuucd45() {
        return dispknkketriyuucd45;
    }

    public void setDispknkketriyuucd45(String pDispknkketriyuucd45) {
        dispknkketriyuucd45 = pDispknkketriyuucd45;
    }

    private String dispknkketriyuunaiyou45;

    public String getDispknkketriyuunaiyou45() {
        return dispknkketriyuunaiyou45;
    }

    public void setDispknkketriyuunaiyou45(String pDispknkketriyuunaiyou45) {
        dispknkketriyuunaiyou45 = pDispknkketriyuunaiyou45;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou5;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou5() {
        return dispknkmrriyuucdnaiyou5;
    }

    public void setDispknkmrriyuucdnaiyou5(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou5) {
        dispknkmrriyuucdnaiyou5 = pDispknkmrriyuucdnaiyou5;
    }

    private BizDate dispknksyoriymd6;

    public BizDate getDispknksyoriymd6() {
        return dispknksyoriymd6;
    }

    public void setDispknksyoriymd6(BizDate pDispknksyoriymd6) {
        dispknksyoriymd6 = pDispknksyoriymd6;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn6;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn6() {
        return dispknkstktsyorinmkbn6;
    }

    public void setDispknkstktsyorinmkbn6(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn6) {
        dispknkstktsyorinmkbn6 = pDispknkstktsyorinmkbn6;
    }

    private C_SyorikekkaKbn dispknkkekkakbn6;

    public C_SyorikekkaKbn getDispknkkekkakbn6() {
        return dispknkkekkakbn6;
    }

    public void setDispknkkekkakbn6(C_SyorikekkaKbn pDispknkkekkakbn6) {
        dispknkkekkakbn6 = pDispknkkekkakbn6;
    }

    private String dispknktns6;

    public String getDispknktns6() {
        return dispknktns6;
    }

    public void setDispknktns6(String pDispknktns6) {
        dispknktns6 = pDispknktns6;
    }

    private String dispknkktnm6;

    public String getDispknkktnm6() {
        return dispknkktnm6;
    }

    public void setDispknkktnm6(String pDispknkktnm6) {
        dispknkktnm6 = pDispknkktnm6;
    }

    private String dispknkcomment6;

    public String getDispknkcomment6() {
        return dispknkcomment6;
    }

    public void setDispknkcomment6(String pDispknkcomment6) {
        dispknkcomment6 = pDispknkcomment6;
    }

    private C_Ketkekkacd dispknkktkkcd6;

    public C_Ketkekkacd getDispknkktkkcd6() {
        return dispknkktkkcd6;
    }

    public void setDispknkktkkcd6(C_Ketkekkacd pDispknkktkkcd6) {
        dispknkktkkcd6 = pDispknkktkkcd6;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu6;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu6() {
        return dispknktrkssyousairiyuu6;
    }

    public void setDispknktrkssyousairiyuu6(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu6) {
        dispknktrkssyousairiyuu6 = pDispknktrkssyousairiyuu6;
    }

    private String dispknkketriyuucd16;

    public String getDispknkketriyuucd16() {
        return dispknkketriyuucd16;
    }

    public void setDispknkketriyuucd16(String pDispknkketriyuucd16) {
        dispknkketriyuucd16 = pDispknkketriyuucd16;
    }

    private String dispknkketriyuunaiyou16;

    public String getDispknkketriyuunaiyou16() {
        return dispknkketriyuunaiyou16;
    }

    public void setDispknkketriyuunaiyou16(String pDispknkketriyuunaiyou16) {
        dispknkketriyuunaiyou16 = pDispknkketriyuunaiyou16;
    }

    private String dispknkketriyuucd26;

    public String getDispknkketriyuucd26() {
        return dispknkketriyuucd26;
    }

    public void setDispknkketriyuucd26(String pDispknkketriyuucd26) {
        dispknkketriyuucd26 = pDispknkketriyuucd26;
    }

    private String dispknkketriyuunaiyou26;

    public String getDispknkketriyuunaiyou26() {
        return dispknkketriyuunaiyou26;
    }

    public void setDispknkketriyuunaiyou26(String pDispknkketriyuunaiyou26) {
        dispknkketriyuunaiyou26 = pDispknkketriyuunaiyou26;
    }

    private String dispknkketriyuucd36;

    public String getDispknkketriyuucd36() {
        return dispknkketriyuucd36;
    }

    public void setDispknkketriyuucd36(String pDispknkketriyuucd36) {
        dispknkketriyuucd36 = pDispknkketriyuucd36;
    }

    private String dispknkketriyuunaiyou36;

    public String getDispknkketriyuunaiyou36() {
        return dispknkketriyuunaiyou36;
    }

    public void setDispknkketriyuunaiyou36(String pDispknkketriyuunaiyou36) {
        dispknkketriyuunaiyou36 = pDispknkketriyuunaiyou36;
    }

    private String dispknkketriyuucd46;

    public String getDispknkketriyuucd46() {
        return dispknkketriyuucd46;
    }

    public void setDispknkketriyuucd46(String pDispknkketriyuucd46) {
        dispknkketriyuucd46 = pDispknkketriyuucd46;
    }

    private String dispknkketriyuunaiyou46;

    public String getDispknkketriyuunaiyou46() {
        return dispknkketriyuunaiyou46;
    }

    public void setDispknkketriyuunaiyou46(String pDispknkketriyuunaiyou46) {
        dispknkketriyuunaiyou46 = pDispknkketriyuunaiyou46;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou6;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou6() {
        return dispknkmrriyuucdnaiyou6;
    }

    public void setDispknkmrriyuucdnaiyou6(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou6) {
        dispknkmrriyuucdnaiyou6 = pDispknkmrriyuucdnaiyou6;
    }

    private BizDate dispknksyoriymd7;

    public BizDate getDispknksyoriymd7() {
        return dispknksyoriymd7;
    }

    public void setDispknksyoriymd7(BizDate pDispknksyoriymd7) {
        dispknksyoriymd7 = pDispknksyoriymd7;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn7;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn7() {
        return dispknkstktsyorinmkbn7;
    }

    public void setDispknkstktsyorinmkbn7(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn7) {
        dispknkstktsyorinmkbn7 = pDispknkstktsyorinmkbn7;
    }

    private C_SyorikekkaKbn dispknkkekkakbn7;

    public C_SyorikekkaKbn getDispknkkekkakbn7() {
        return dispknkkekkakbn7;
    }

    public void setDispknkkekkakbn7(C_SyorikekkaKbn pDispknkkekkakbn7) {
        dispknkkekkakbn7 = pDispknkkekkakbn7;
    }

    private String dispknktns7;

    public String getDispknktns7() {
        return dispknktns7;
    }

    public void setDispknktns7(String pDispknktns7) {
        dispknktns7 = pDispknktns7;
    }

    private String dispknkktnm7;

    public String getDispknkktnm7() {
        return dispknkktnm7;
    }

    public void setDispknkktnm7(String pDispknkktnm7) {
        dispknkktnm7 = pDispknkktnm7;
    }

    private String dispknkcomment7;

    public String getDispknkcomment7() {
        return dispknkcomment7;
    }

    public void setDispknkcomment7(String pDispknkcomment7) {
        dispknkcomment7 = pDispknkcomment7;
    }

    private C_Ketkekkacd dispknkktkkcd7;

    public C_Ketkekkacd getDispknkktkkcd7() {
        return dispknkktkkcd7;
    }

    public void setDispknkktkkcd7(C_Ketkekkacd pDispknkktkkcd7) {
        dispknkktkkcd7 = pDispknkktkkcd7;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu7;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu7() {
        return dispknktrkssyousairiyuu7;
    }

    public void setDispknktrkssyousairiyuu7(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu7) {
        dispknktrkssyousairiyuu7 = pDispknktrkssyousairiyuu7;
    }

    private String dispknkketriyuucd17;

    public String getDispknkketriyuucd17() {
        return dispknkketriyuucd17;
    }

    public void setDispknkketriyuucd17(String pDispknkketriyuucd17) {
        dispknkketriyuucd17 = pDispknkketriyuucd17;
    }

    private String dispknkketriyuunaiyou17;

    public String getDispknkketriyuunaiyou17() {
        return dispknkketriyuunaiyou17;
    }

    public void setDispknkketriyuunaiyou17(String pDispknkketriyuunaiyou17) {
        dispknkketriyuunaiyou17 = pDispknkketriyuunaiyou17;
    }

    private String dispknkketriyuucd27;

    public String getDispknkketriyuucd27() {
        return dispknkketriyuucd27;
    }

    public void setDispknkketriyuucd27(String pDispknkketriyuucd27) {
        dispknkketriyuucd27 = pDispknkketriyuucd27;
    }

    private String dispknkketriyuunaiyou27;

    public String getDispknkketriyuunaiyou27() {
        return dispknkketriyuunaiyou27;
    }

    public void setDispknkketriyuunaiyou27(String pDispknkketriyuunaiyou27) {
        dispknkketriyuunaiyou27 = pDispknkketriyuunaiyou27;
    }

    private String dispknkketriyuucd37;

    public String getDispknkketriyuucd37() {
        return dispknkketriyuucd37;
    }

    public void setDispknkketriyuucd37(String pDispknkketriyuucd37) {
        dispknkketriyuucd37 = pDispknkketriyuucd37;
    }

    private String dispknkketriyuunaiyou37;

    public String getDispknkketriyuunaiyou37() {
        return dispknkketriyuunaiyou37;
    }

    public void setDispknkketriyuunaiyou37(String pDispknkketriyuunaiyou37) {
        dispknkketriyuunaiyou37 = pDispknkketriyuunaiyou37;
    }

    private String dispknkketriyuucd47;

    public String getDispknkketriyuucd47() {
        return dispknkketriyuucd47;
    }

    public void setDispknkketriyuucd47(String pDispknkketriyuucd47) {
        dispknkketriyuucd47 = pDispknkketriyuucd47;
    }

    private String dispknkketriyuunaiyou47;

    public String getDispknkketriyuunaiyou47() {
        return dispknkketriyuunaiyou47;
    }

    public void setDispknkketriyuunaiyou47(String pDispknkketriyuunaiyou47) {
        dispknkketriyuunaiyou47 = pDispknkketriyuunaiyou47;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou7;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou7() {
        return dispknkmrriyuucdnaiyou7;
    }

    public void setDispknkmrriyuucdnaiyou7(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou7) {
        dispknkmrriyuucdnaiyou7 = pDispknkmrriyuucdnaiyou7;
    }

    private BizDate dispknksyoriymd8;

    public BizDate getDispknksyoriymd8() {
        return dispknksyoriymd8;
    }

    public void setDispknksyoriymd8(BizDate pDispknksyoriymd8) {
        dispknksyoriymd8 = pDispknksyoriymd8;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn8;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn8() {
        return dispknkstktsyorinmkbn8;
    }

    public void setDispknkstktsyorinmkbn8(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn8) {
        dispknkstktsyorinmkbn8 = pDispknkstktsyorinmkbn8;
    }

    private C_SyorikekkaKbn dispknkkekkakbn8;

    public C_SyorikekkaKbn getDispknkkekkakbn8() {
        return dispknkkekkakbn8;
    }

    public void setDispknkkekkakbn8(C_SyorikekkaKbn pDispknkkekkakbn8) {
        dispknkkekkakbn8 = pDispknkkekkakbn8;
    }

    private String dispknktns8;

    public String getDispknktns8() {
        return dispknktns8;
    }

    public void setDispknktns8(String pDispknktns8) {
        dispknktns8 = pDispknktns8;
    }

    private String dispknkktnm8;

    public String getDispknkktnm8() {
        return dispknkktnm8;
    }

    public void setDispknkktnm8(String pDispknkktnm8) {
        dispknkktnm8 = pDispknkktnm8;
    }

    private String dispknkcomment8;

    public String getDispknkcomment8() {
        return dispknkcomment8;
    }

    public void setDispknkcomment8(String pDispknkcomment8) {
        dispknkcomment8 = pDispknkcomment8;
    }

    private C_Ketkekkacd dispknkktkkcd8;

    public C_Ketkekkacd getDispknkktkkcd8() {
        return dispknkktkkcd8;
    }

    public void setDispknkktkkcd8(C_Ketkekkacd pDispknkktkkcd8) {
        dispknkktkkcd8 = pDispknkktkkcd8;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu8;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu8() {
        return dispknktrkssyousairiyuu8;
    }

    public void setDispknktrkssyousairiyuu8(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu8) {
        dispknktrkssyousairiyuu8 = pDispknktrkssyousairiyuu8;
    }

    private String dispknkketriyuucd18;

    public String getDispknkketriyuucd18() {
        return dispknkketriyuucd18;
    }

    public void setDispknkketriyuucd18(String pDispknkketriyuucd18) {
        dispknkketriyuucd18 = pDispknkketriyuucd18;
    }

    private String dispknkketriyuunaiyou18;

    public String getDispknkketriyuunaiyou18() {
        return dispknkketriyuunaiyou18;
    }

    public void setDispknkketriyuunaiyou18(String pDispknkketriyuunaiyou18) {
        dispknkketriyuunaiyou18 = pDispknkketriyuunaiyou18;
    }

    private String dispknkketriyuucd28;

    public String getDispknkketriyuucd28() {
        return dispknkketriyuucd28;
    }

    public void setDispknkketriyuucd28(String pDispknkketriyuucd28) {
        dispknkketriyuucd28 = pDispknkketriyuucd28;
    }

    private String dispknkketriyuunaiyou28;

    public String getDispknkketriyuunaiyou28() {
        return dispknkketriyuunaiyou28;
    }

    public void setDispknkketriyuunaiyou28(String pDispknkketriyuunaiyou28) {
        dispknkketriyuunaiyou28 = pDispknkketriyuunaiyou28;
    }

    private String dispknkketriyuucd38;

    public String getDispknkketriyuucd38() {
        return dispknkketriyuucd38;
    }

    public void setDispknkketriyuucd38(String pDispknkketriyuucd38) {
        dispknkketriyuucd38 = pDispknkketriyuucd38;
    }

    private String dispknkketriyuunaiyou38;

    public String getDispknkketriyuunaiyou38() {
        return dispknkketriyuunaiyou38;
    }

    public void setDispknkketriyuunaiyou38(String pDispknkketriyuunaiyou38) {
        dispknkketriyuunaiyou38 = pDispknkketriyuunaiyou38;
    }

    private String dispknkketriyuucd48;

    public String getDispknkketriyuucd48() {
        return dispknkketriyuucd48;
    }

    public void setDispknkketriyuucd48(String pDispknkketriyuucd48) {
        dispknkketriyuucd48 = pDispknkketriyuucd48;
    }

    private String dispknkketriyuunaiyou48;

    public String getDispknkketriyuunaiyou48() {
        return dispknkketriyuunaiyou48;
    }

    public void setDispknkketriyuunaiyou48(String pDispknkketriyuunaiyou48) {
        dispknkketriyuunaiyou48 = pDispknkketriyuunaiyou48;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou8;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou8() {
        return dispknkmrriyuucdnaiyou8;
    }

    public void setDispknkmrriyuucdnaiyou8(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou8) {
        dispknkmrriyuucdnaiyou8 = pDispknkmrriyuucdnaiyou8;
    }

    private BizDate dispknksyoriymd9;

    public BizDate getDispknksyoriymd9() {
        return dispknksyoriymd9;
    }

    public void setDispknksyoriymd9(BizDate pDispknksyoriymd9) {
        dispknksyoriymd9 = pDispknksyoriymd9;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn9;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn9() {
        return dispknkstktsyorinmkbn9;
    }

    public void setDispknkstktsyorinmkbn9(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn9) {
        dispknkstktsyorinmkbn9 = pDispknkstktsyorinmkbn9;
    }

    private C_SyorikekkaKbn dispknkkekkakbn9;

    public C_SyorikekkaKbn getDispknkkekkakbn9() {
        return dispknkkekkakbn9;
    }

    public void setDispknkkekkakbn9(C_SyorikekkaKbn pDispknkkekkakbn9) {
        dispknkkekkakbn9 = pDispknkkekkakbn9;
    }

    private String dispknktns9;

    public String getDispknktns9() {
        return dispknktns9;
    }

    public void setDispknktns9(String pDispknktns9) {
        dispknktns9 = pDispknktns9;
    }

    private String dispknkktnm9;

    public String getDispknkktnm9() {
        return dispknkktnm9;
    }

    public void setDispknkktnm9(String pDispknkktnm9) {
        dispknkktnm9 = pDispknkktnm9;
    }

    private String dispknkcomment9;

    public String getDispknkcomment9() {
        return dispknkcomment9;
    }

    public void setDispknkcomment9(String pDispknkcomment9) {
        dispknkcomment9 = pDispknkcomment9;
    }

    private C_Ketkekkacd dispknkktkkcd9;

    public C_Ketkekkacd getDispknkktkkcd9() {
        return dispknkktkkcd9;
    }

    public void setDispknkktkkcd9(C_Ketkekkacd pDispknkktkkcd9) {
        dispknkktkkcd9 = pDispknkktkkcd9;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu9;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu9() {
        return dispknktrkssyousairiyuu9;
    }

    public void setDispknktrkssyousairiyuu9(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu9) {
        dispknktrkssyousairiyuu9 = pDispknktrkssyousairiyuu9;
    }

    private String dispknkketriyuucd19;

    public String getDispknkketriyuucd19() {
        return dispknkketriyuucd19;
    }

    public void setDispknkketriyuucd19(String pDispknkketriyuucd19) {
        dispknkketriyuucd19 = pDispknkketriyuucd19;
    }

    private String dispknkketriyuunaiyou19;

    public String getDispknkketriyuunaiyou19() {
        return dispknkketriyuunaiyou19;
    }

    public void setDispknkketriyuunaiyou19(String pDispknkketriyuunaiyou19) {
        dispknkketriyuunaiyou19 = pDispknkketriyuunaiyou19;
    }

    private String dispknkketriyuucd29;

    public String getDispknkketriyuucd29() {
        return dispknkketriyuucd29;
    }

    public void setDispknkketriyuucd29(String pDispknkketriyuucd29) {
        dispknkketriyuucd29 = pDispknkketriyuucd29;
    }

    private String dispknkketriyuunaiyou29;

    public String getDispknkketriyuunaiyou29() {
        return dispknkketriyuunaiyou29;
    }

    public void setDispknkketriyuunaiyou29(String pDispknkketriyuunaiyou29) {
        dispknkketriyuunaiyou29 = pDispknkketriyuunaiyou29;
    }

    private String dispknkketriyuucd39;

    public String getDispknkketriyuucd39() {
        return dispknkketriyuucd39;
    }

    public void setDispknkketriyuucd39(String pDispknkketriyuucd39) {
        dispknkketriyuucd39 = pDispknkketriyuucd39;
    }

    private String dispknkketriyuunaiyou39;

    public String getDispknkketriyuunaiyou39() {
        return dispknkketriyuunaiyou39;
    }

    public void setDispknkketriyuunaiyou39(String pDispknkketriyuunaiyou39) {
        dispknkketriyuunaiyou39 = pDispknkketriyuunaiyou39;
    }

    private String dispknkketriyuucd49;

    public String getDispknkketriyuucd49() {
        return dispknkketriyuucd49;
    }

    public void setDispknkketriyuucd49(String pDispknkketriyuucd49) {
        dispknkketriyuucd49 = pDispknkketriyuucd49;
    }

    private String dispknkketriyuunaiyou49;

    public String getDispknkketriyuunaiyou49() {
        return dispknkketriyuunaiyou49;
    }

    public void setDispknkketriyuunaiyou49(String pDispknkketriyuunaiyou49) {
        dispknkketriyuunaiyou49 = pDispknkketriyuunaiyou49;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou9;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou9() {
        return dispknkmrriyuucdnaiyou9;
    }

    public void setDispknkmrriyuucdnaiyou9(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou9) {
        dispknkmrriyuucdnaiyou9 = pDispknkmrriyuucdnaiyou9;
    }

    private BizDate dispknksyoriymd10;

    public BizDate getDispknksyoriymd10() {
        return dispknksyoriymd10;
    }

    public void setDispknksyoriymd10(BizDate pDispknksyoriymd10) {
        dispknksyoriymd10 = pDispknksyoriymd10;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn10;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn10() {
        return dispknkstktsyorinmkbn10;
    }

    public void setDispknkstktsyorinmkbn10(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn10) {
        dispknkstktsyorinmkbn10 = pDispknkstktsyorinmkbn10;
    }

    private C_SyorikekkaKbn dispknkkekkakbn10;

    public C_SyorikekkaKbn getDispknkkekkakbn10() {
        return dispknkkekkakbn10;
    }

    public void setDispknkkekkakbn10(C_SyorikekkaKbn pDispknkkekkakbn10) {
        dispknkkekkakbn10 = pDispknkkekkakbn10;
    }

    private String dispknktns10;

    public String getDispknktns10() {
        return dispknktns10;
    }

    public void setDispknktns10(String pDispknktns10) {
        dispknktns10 = pDispknktns10;
    }

    private String dispknkktnm10;

    public String getDispknkktnm10() {
        return dispknkktnm10;
    }

    public void setDispknkktnm10(String pDispknkktnm10) {
        dispknkktnm10 = pDispknkktnm10;
    }

    private String dispknkcomment10;

    public String getDispknkcomment10() {
        return dispknkcomment10;
    }

    public void setDispknkcomment10(String pDispknkcomment10) {
        dispknkcomment10 = pDispknkcomment10;
    }

    private C_Ketkekkacd dispknkktkkcd10;

    public C_Ketkekkacd getDispknkktkkcd10() {
        return dispknkktkkcd10;
    }

    public void setDispknkktkkcd10(C_Ketkekkacd pDispknkktkkcd10) {
        dispknkktkkcd10 = pDispknkktkkcd10;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu10;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu10() {
        return dispknktrkssyousairiyuu10;
    }

    public void setDispknktrkssyousairiyuu10(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu10) {
        dispknktrkssyousairiyuu10 = pDispknktrkssyousairiyuu10;
    }

    private String dispknkketriyuucd110;

    public String getDispknkketriyuucd110() {
        return dispknkketriyuucd110;
    }

    public void setDispknkketriyuucd110(String pDispknkketriyuucd110) {
        dispknkketriyuucd110 = pDispknkketriyuucd110;
    }

    private String dispknkketriyuunaiyou110;

    public String getDispknkketriyuunaiyou110() {
        return dispknkketriyuunaiyou110;
    }

    public void setDispknkketriyuunaiyou110(String pDispknkketriyuunaiyou110) {
        dispknkketriyuunaiyou110 = pDispknkketriyuunaiyou110;
    }

    private String dispknkketriyuucd210;

    public String getDispknkketriyuucd210() {
        return dispknkketriyuucd210;
    }

    public void setDispknkketriyuucd210(String pDispknkketriyuucd210) {
        dispknkketriyuucd210 = pDispknkketriyuucd210;
    }

    private String dispknkketriyuunaiyou210;

    public String getDispknkketriyuunaiyou210() {
        return dispknkketriyuunaiyou210;
    }

    public void setDispknkketriyuunaiyou210(String pDispknkketriyuunaiyou210) {
        dispknkketriyuunaiyou210 = pDispknkketriyuunaiyou210;
    }

    private String dispknkketriyuucd310;

    public String getDispknkketriyuucd310() {
        return dispknkketriyuucd310;
    }

    public void setDispknkketriyuucd310(String pDispknkketriyuucd310) {
        dispknkketriyuucd310 = pDispknkketriyuucd310;
    }

    private String dispknkketriyuunaiyou310;

    public String getDispknkketriyuunaiyou310() {
        return dispknkketriyuunaiyou310;
    }

    public void setDispknkketriyuunaiyou310(String pDispknkketriyuunaiyou310) {
        dispknkketriyuunaiyou310 = pDispknkketriyuunaiyou310;
    }

    private String dispknkketriyuucd410;

    public String getDispknkketriyuucd410() {
        return dispknkketriyuucd410;
    }

    public void setDispknkketriyuucd410(String pDispknkketriyuucd410) {
        dispknkketriyuucd410 = pDispknkketriyuucd410;
    }

    private String dispknkketriyuunaiyou410;

    public String getDispknkketriyuunaiyou410() {
        return dispknkketriyuunaiyou410;
    }

    public void setDispknkketriyuunaiyou410(String pDispknkketriyuunaiyou410) {
        dispknkketriyuunaiyou410 = pDispknkketriyuunaiyou410;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou10;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou10() {
        return dispknkmrriyuucdnaiyou10;
    }

    public void setDispknkmrriyuucdnaiyou10(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou10) {
        dispknkmrriyuucdnaiyou10 = pDispknkmrriyuucdnaiyou10;
    }

    private BizDate dispknksyoriymd11;

    public BizDate getDispknksyoriymd11() {
        return dispknksyoriymd11;
    }

    public void setDispknksyoriymd11(BizDate pDispknksyoriymd11) {
        dispknksyoriymd11 = pDispknksyoriymd11;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn11;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn11() {
        return dispknkstktsyorinmkbn11;
    }

    public void setDispknkstktsyorinmkbn11(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn11) {
        dispknkstktsyorinmkbn11 = pDispknkstktsyorinmkbn11;
    }

    private C_SyorikekkaKbn dispknkkekkakbn11;

    public C_SyorikekkaKbn getDispknkkekkakbn11() {
        return dispknkkekkakbn11;
    }

    public void setDispknkkekkakbn11(C_SyorikekkaKbn pDispknkkekkakbn11) {
        dispknkkekkakbn11 = pDispknkkekkakbn11;
    }

    private String dispknktns11;

    public String getDispknktns11() {
        return dispknktns11;
    }

    public void setDispknktns11(String pDispknktns11) {
        dispknktns11 = pDispknktns11;
    }

    private String dispknkktnm11;

    public String getDispknkktnm11() {
        return dispknkktnm11;
    }

    public void setDispknkktnm11(String pDispknkktnm11) {
        dispknkktnm11 = pDispknkktnm11;
    }

    private String dispknkcomment11;

    public String getDispknkcomment11() {
        return dispknkcomment11;
    }

    public void setDispknkcomment11(String pDispknkcomment11) {
        dispknkcomment11 = pDispknkcomment11;
    }

    private C_Ketkekkacd dispknkktkkcd11;

    public C_Ketkekkacd getDispknkktkkcd11() {
        return dispknkktkkcd11;
    }

    public void setDispknkktkkcd11(C_Ketkekkacd pDispknkktkkcd11) {
        dispknkktkkcd11 = pDispknkktkkcd11;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu11;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu11() {
        return dispknktrkssyousairiyuu11;
    }

    public void setDispknktrkssyousairiyuu11(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu11) {
        dispknktrkssyousairiyuu11 = pDispknktrkssyousairiyuu11;
    }

    private String dispknkketriyuucd111;

    public String getDispknkketriyuucd111() {
        return dispknkketriyuucd111;
    }

    public void setDispknkketriyuucd111(String pDispknkketriyuucd111) {
        dispknkketriyuucd111 = pDispknkketriyuucd111;
    }

    private String dispknkketriyuunaiyou111;

    public String getDispknkketriyuunaiyou111() {
        return dispknkketriyuunaiyou111;
    }

    public void setDispknkketriyuunaiyou111(String pDispknkketriyuunaiyou111) {
        dispknkketriyuunaiyou111 = pDispknkketriyuunaiyou111;
    }

    private String dispknkketriyuucd211;

    public String getDispknkketriyuucd211() {
        return dispknkketriyuucd211;
    }

    public void setDispknkketriyuucd211(String pDispknkketriyuucd211) {
        dispknkketriyuucd211 = pDispknkketriyuucd211;
    }

    private String dispknkketriyuunaiyou211;

    public String getDispknkketriyuunaiyou211() {
        return dispknkketriyuunaiyou211;
    }

    public void setDispknkketriyuunaiyou211(String pDispknkketriyuunaiyou211) {
        dispknkketriyuunaiyou211 = pDispknkketriyuunaiyou211;
    }

    private String dispknkketriyuucd311;

    public String getDispknkketriyuucd311() {
        return dispknkketriyuucd311;
    }

    public void setDispknkketriyuucd311(String pDispknkketriyuucd311) {
        dispknkketriyuucd311 = pDispknkketriyuucd311;
    }

    private String dispknkketriyuunaiyou311;

    public String getDispknkketriyuunaiyou311() {
        return dispknkketriyuunaiyou311;
    }

    public void setDispknkketriyuunaiyou311(String pDispknkketriyuunaiyou311) {
        dispknkketriyuunaiyou311 = pDispknkketriyuunaiyou311;
    }

    private String dispknkketriyuucd411;

    public String getDispknkketriyuucd411() {
        return dispknkketriyuucd411;
    }

    public void setDispknkketriyuucd411(String pDispknkketriyuucd411) {
        dispknkketriyuucd411 = pDispknkketriyuucd411;
    }

    private String dispknkketriyuunaiyou411;

    public String getDispknkketriyuunaiyou411() {
        return dispknkketriyuunaiyou411;
    }

    public void setDispknkketriyuunaiyou411(String pDispknkketriyuunaiyou411) {
        dispknkketriyuunaiyou411 = pDispknkketriyuunaiyou411;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou11;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou11() {
        return dispknkmrriyuucdnaiyou11;
    }

    public void setDispknkmrriyuucdnaiyou11(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou11) {
        dispknkmrriyuucdnaiyou11 = pDispknkmrriyuucdnaiyou11;
    }

    private BizDate dispknksyoriymd12;

    public BizDate getDispknksyoriymd12() {
        return dispknksyoriymd12;
    }

    public void setDispknksyoriymd12(BizDate pDispknksyoriymd12) {
        dispknksyoriymd12 = pDispknksyoriymd12;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn12;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn12() {
        return dispknkstktsyorinmkbn12;
    }

    public void setDispknkstktsyorinmkbn12(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn12) {
        dispknkstktsyorinmkbn12 = pDispknkstktsyorinmkbn12;
    }

    private C_SyorikekkaKbn dispknkkekkakbn12;

    public C_SyorikekkaKbn getDispknkkekkakbn12() {
        return dispknkkekkakbn12;
    }

    public void setDispknkkekkakbn12(C_SyorikekkaKbn pDispknkkekkakbn12) {
        dispknkkekkakbn12 = pDispknkkekkakbn12;
    }

    private String dispknktns12;

    public String getDispknktns12() {
        return dispknktns12;
    }

    public void setDispknktns12(String pDispknktns12) {
        dispknktns12 = pDispknktns12;
    }

    private String dispknkktnm12;

    public String getDispknkktnm12() {
        return dispknkktnm12;
    }

    public void setDispknkktnm12(String pDispknkktnm12) {
        dispknkktnm12 = pDispknkktnm12;
    }

    private String dispknkcomment12;

    public String getDispknkcomment12() {
        return dispknkcomment12;
    }

    public void setDispknkcomment12(String pDispknkcomment12) {
        dispknkcomment12 = pDispknkcomment12;
    }

    private C_Ketkekkacd dispknkktkkcd12;

    public C_Ketkekkacd getDispknkktkkcd12() {
        return dispknkktkkcd12;
    }

    public void setDispknkktkkcd12(C_Ketkekkacd pDispknkktkkcd12) {
        dispknkktkkcd12 = pDispknkktkkcd12;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu12;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu12() {
        return dispknktrkssyousairiyuu12;
    }

    public void setDispknktrkssyousairiyuu12(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu12) {
        dispknktrkssyousairiyuu12 = pDispknktrkssyousairiyuu12;
    }

    private String dispknkketriyuucd112;

    public String getDispknkketriyuucd112() {
        return dispknkketriyuucd112;
    }

    public void setDispknkketriyuucd112(String pDispknkketriyuucd112) {
        dispknkketriyuucd112 = pDispknkketriyuucd112;
    }

    private String dispknkketriyuunaiyou112;

    public String getDispknkketriyuunaiyou112() {
        return dispknkketriyuunaiyou112;
    }

    public void setDispknkketriyuunaiyou112(String pDispknkketriyuunaiyou112) {
        dispknkketriyuunaiyou112 = pDispknkketriyuunaiyou112;
    }

    private String dispknkketriyuucd212;

    public String getDispknkketriyuucd212() {
        return dispknkketriyuucd212;
    }

    public void setDispknkketriyuucd212(String pDispknkketriyuucd212) {
        dispknkketriyuucd212 = pDispknkketriyuucd212;
    }

    private String dispknkketriyuunaiyou212;

    public String getDispknkketriyuunaiyou212() {
        return dispknkketriyuunaiyou212;
    }

    public void setDispknkketriyuunaiyou212(String pDispknkketriyuunaiyou212) {
        dispknkketriyuunaiyou212 = pDispknkketriyuunaiyou212;
    }

    private String dispknkketriyuucd312;

    public String getDispknkketriyuucd312() {
        return dispknkketriyuucd312;
    }

    public void setDispknkketriyuucd312(String pDispknkketriyuucd312) {
        dispknkketriyuucd312 = pDispknkketriyuucd312;
    }

    private String dispknkketriyuunaiyou312;

    public String getDispknkketriyuunaiyou312() {
        return dispknkketriyuunaiyou312;
    }

    public void setDispknkketriyuunaiyou312(String pDispknkketriyuunaiyou312) {
        dispknkketriyuunaiyou312 = pDispknkketriyuunaiyou312;
    }

    private String dispknkketriyuucd412;

    public String getDispknkketriyuucd412() {
        return dispknkketriyuucd412;
    }

    public void setDispknkketriyuucd412(String pDispknkketriyuucd412) {
        dispknkketriyuucd412 = pDispknkketriyuucd412;
    }

    private String dispknkketriyuunaiyou412;

    public String getDispknkketriyuunaiyou412() {
        return dispknkketriyuunaiyou412;
    }

    public void setDispknkketriyuunaiyou412(String pDispknkketriyuunaiyou412) {
        dispknkketriyuunaiyou412 = pDispknkketriyuunaiyou412;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou12;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou12() {
        return dispknkmrriyuucdnaiyou12;
    }

    public void setDispknkmrriyuucdnaiyou12(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou12) {
        dispknkmrriyuucdnaiyou12 = pDispknkmrriyuucdnaiyou12;
    }

    private BizDate dispknksyoriymd13;

    public BizDate getDispknksyoriymd13() {
        return dispknksyoriymd13;
    }

    public void setDispknksyoriymd13(BizDate pDispknksyoriymd13) {
        dispknksyoriymd13 = pDispknksyoriymd13;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn13;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn13() {
        return dispknkstktsyorinmkbn13;
    }

    public void setDispknkstktsyorinmkbn13(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn13) {
        dispknkstktsyorinmkbn13 = pDispknkstktsyorinmkbn13;
    }

    private C_SyorikekkaKbn dispknkkekkakbn13;

    public C_SyorikekkaKbn getDispknkkekkakbn13() {
        return dispknkkekkakbn13;
    }

    public void setDispknkkekkakbn13(C_SyorikekkaKbn pDispknkkekkakbn13) {
        dispknkkekkakbn13 = pDispknkkekkakbn13;
    }

    private String dispknktns13;

    public String getDispknktns13() {
        return dispknktns13;
    }

    public void setDispknktns13(String pDispknktns13) {
        dispknktns13 = pDispknktns13;
    }

    private String dispknkktnm13;

    public String getDispknkktnm13() {
        return dispknkktnm13;
    }

    public void setDispknkktnm13(String pDispknkktnm13) {
        dispknkktnm13 = pDispknkktnm13;
    }

    private String dispknkcomment13;

    public String getDispknkcomment13() {
        return dispknkcomment13;
    }

    public void setDispknkcomment13(String pDispknkcomment13) {
        dispknkcomment13 = pDispknkcomment13;
    }

    private C_Ketkekkacd dispknkktkkcd13;

    public C_Ketkekkacd getDispknkktkkcd13() {
        return dispknkktkkcd13;
    }

    public void setDispknkktkkcd13(C_Ketkekkacd pDispknkktkkcd13) {
        dispknkktkkcd13 = pDispknkktkkcd13;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu13;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu13() {
        return dispknktrkssyousairiyuu13;
    }

    public void setDispknktrkssyousairiyuu13(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu13) {
        dispknktrkssyousairiyuu13 = pDispknktrkssyousairiyuu13;
    }

    private String dispknkketriyuucd113;

    public String getDispknkketriyuucd113() {
        return dispknkketriyuucd113;
    }

    public void setDispknkketriyuucd113(String pDispknkketriyuucd113) {
        dispknkketriyuucd113 = pDispknkketriyuucd113;
    }

    private String dispknkketriyuunaiyou113;

    public String getDispknkketriyuunaiyou113() {
        return dispknkketriyuunaiyou113;
    }

    public void setDispknkketriyuunaiyou113(String pDispknkketriyuunaiyou113) {
        dispknkketriyuunaiyou113 = pDispknkketriyuunaiyou113;
    }

    private String dispknkketriyuucd213;

    public String getDispknkketriyuucd213() {
        return dispknkketriyuucd213;
    }

    public void setDispknkketriyuucd213(String pDispknkketriyuucd213) {
        dispknkketriyuucd213 = pDispknkketriyuucd213;
    }

    private String dispknkketriyuunaiyou213;

    public String getDispknkketriyuunaiyou213() {
        return dispknkketriyuunaiyou213;
    }

    public void setDispknkketriyuunaiyou213(String pDispknkketriyuunaiyou213) {
        dispknkketriyuunaiyou213 = pDispknkketriyuunaiyou213;
    }

    private String dispknkketriyuucd313;

    public String getDispknkketriyuucd313() {
        return dispknkketriyuucd313;
    }

    public void setDispknkketriyuucd313(String pDispknkketriyuucd313) {
        dispknkketriyuucd313 = pDispknkketriyuucd313;
    }

    private String dispknkketriyuunaiyou313;

    public String getDispknkketriyuunaiyou313() {
        return dispknkketriyuunaiyou313;
    }

    public void setDispknkketriyuunaiyou313(String pDispknkketriyuunaiyou313) {
        dispknkketriyuunaiyou313 = pDispknkketriyuunaiyou313;
    }

    private String dispknkketriyuucd413;

    public String getDispknkketriyuucd413() {
        return dispknkketriyuucd413;
    }

    public void setDispknkketriyuucd413(String pDispknkketriyuucd413) {
        dispknkketriyuucd413 = pDispknkketriyuucd413;
    }

    private String dispknkketriyuunaiyou413;

    public String getDispknkketriyuunaiyou413() {
        return dispknkketriyuunaiyou413;
    }

    public void setDispknkketriyuunaiyou413(String pDispknkketriyuunaiyou413) {
        dispknkketriyuunaiyou413 = pDispknkketriyuunaiyou413;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou13;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou13() {
        return dispknkmrriyuucdnaiyou13;
    }

    public void setDispknkmrriyuucdnaiyou13(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou13) {
        dispknkmrriyuucdnaiyou13 = pDispknkmrriyuucdnaiyou13;
    }

    private BizDate dispknksyoriymd14;

    public BizDate getDispknksyoriymd14() {
        return dispknksyoriymd14;
    }

    public void setDispknksyoriymd14(BizDate pDispknksyoriymd14) {
        dispknksyoriymd14 = pDispknksyoriymd14;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn14;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn14() {
        return dispknkstktsyorinmkbn14;
    }

    public void setDispknkstktsyorinmkbn14(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn14) {
        dispknkstktsyorinmkbn14 = pDispknkstktsyorinmkbn14;
    }

    private C_SyorikekkaKbn dispknkkekkakbn14;

    public C_SyorikekkaKbn getDispknkkekkakbn14() {
        return dispknkkekkakbn14;
    }

    public void setDispknkkekkakbn14(C_SyorikekkaKbn pDispknkkekkakbn14) {
        dispknkkekkakbn14 = pDispknkkekkakbn14;
    }

    private String dispknktns14;

    public String getDispknktns14() {
        return dispknktns14;
    }

    public void setDispknktns14(String pDispknktns14) {
        dispknktns14 = pDispknktns14;
    }

    private String dispknkktnm14;

    public String getDispknkktnm14() {
        return dispknkktnm14;
    }

    public void setDispknkktnm14(String pDispknkktnm14) {
        dispknkktnm14 = pDispknkktnm14;
    }

    private String dispknkcomment14;

    public String getDispknkcomment14() {
        return dispknkcomment14;
    }

    public void setDispknkcomment14(String pDispknkcomment14) {
        dispknkcomment14 = pDispknkcomment14;
    }

    private C_Ketkekkacd dispknkktkkcd14;

    public C_Ketkekkacd getDispknkktkkcd14() {
        return dispknkktkkcd14;
    }

    public void setDispknkktkkcd14(C_Ketkekkacd pDispknkktkkcd14) {
        dispknkktkkcd14 = pDispknkktkkcd14;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu14;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu14() {
        return dispknktrkssyousairiyuu14;
    }

    public void setDispknktrkssyousairiyuu14(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu14) {
        dispknktrkssyousairiyuu14 = pDispknktrkssyousairiyuu14;
    }

    private String dispknkketriyuucd114;

    public String getDispknkketriyuucd114() {
        return dispknkketriyuucd114;
    }

    public void setDispknkketriyuucd114(String pDispknkketriyuucd114) {
        dispknkketriyuucd114 = pDispknkketriyuucd114;
    }

    private String dispknkketriyuunaiyou114;

    public String getDispknkketriyuunaiyou114() {
        return dispknkketriyuunaiyou114;
    }

    public void setDispknkketriyuunaiyou114(String pDispknkketriyuunaiyou114) {
        dispknkketriyuunaiyou114 = pDispknkketriyuunaiyou114;
    }

    private String dispknkketriyuucd214;

    public String getDispknkketriyuucd214() {
        return dispknkketriyuucd214;
    }

    public void setDispknkketriyuucd214(String pDispknkketriyuucd214) {
        dispknkketriyuucd214 = pDispknkketriyuucd214;
    }

    private String dispknkketriyuunaiyou214;

    public String getDispknkketriyuunaiyou214() {
        return dispknkketriyuunaiyou214;
    }

    public void setDispknkketriyuunaiyou214(String pDispknkketriyuunaiyou214) {
        dispknkketriyuunaiyou214 = pDispknkketriyuunaiyou214;
    }

    private String dispknkketriyuucd314;

    public String getDispknkketriyuucd314() {
        return dispknkketriyuucd314;
    }

    public void setDispknkketriyuucd314(String pDispknkketriyuucd314) {
        dispknkketriyuucd314 = pDispknkketriyuucd314;
    }

    private String dispknkketriyuunaiyou314;

    public String getDispknkketriyuunaiyou314() {
        return dispknkketriyuunaiyou314;
    }

    public void setDispknkketriyuunaiyou314(String pDispknkketriyuunaiyou314) {
        dispknkketriyuunaiyou314 = pDispknkketriyuunaiyou314;
    }

    private String dispknkketriyuucd414;

    public String getDispknkketriyuucd414() {
        return dispknkketriyuucd414;
    }

    public void setDispknkketriyuucd414(String pDispknkketriyuucd414) {
        dispknkketriyuucd414 = pDispknkketriyuucd414;
    }

    private String dispknkketriyuunaiyou414;

    public String getDispknkketriyuunaiyou414() {
        return dispknkketriyuunaiyou414;
    }

    public void setDispknkketriyuunaiyou414(String pDispknkketriyuunaiyou414) {
        dispknkketriyuunaiyou414 = pDispknkketriyuunaiyou414;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou14;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou14() {
        return dispknkmrriyuucdnaiyou14;
    }

    public void setDispknkmrriyuucdnaiyou14(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou14) {
        dispknkmrriyuucdnaiyou14 = pDispknkmrriyuucdnaiyou14;
    }

    private BizDate dispknksyoriymd15;

    public BizDate getDispknksyoriymd15() {
        return dispknksyoriymd15;
    }

    public void setDispknksyoriymd15(BizDate pDispknksyoriymd15) {
        dispknksyoriymd15 = pDispknksyoriymd15;
    }

    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn15;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn15() {
        return dispknkstktsyorinmkbn15;
    }

    public void setDispknkstktsyorinmkbn15(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn15) {
        dispknkstktsyorinmkbn15 = pDispknkstktsyorinmkbn15;
    }

    private C_SyorikekkaKbn dispknkkekkakbn15;

    public C_SyorikekkaKbn getDispknkkekkakbn15() {
        return dispknkkekkakbn15;
    }

    public void setDispknkkekkakbn15(C_SyorikekkaKbn pDispknkkekkakbn15) {
        dispknkkekkakbn15 = pDispknkkekkakbn15;
    }

    private String dispknktns15;

    public String getDispknktns15() {
        return dispknktns15;
    }

    public void setDispknktns15(String pDispknktns15) {
        dispknktns15 = pDispknktns15;
    }

    private String dispknkktnm15;

    public String getDispknkktnm15() {
        return dispknkktnm15;
    }

    public void setDispknkktnm15(String pDispknkktnm15) {
        dispknkktnm15 = pDispknkktnm15;
    }

    private String dispknkcomment15;

    public String getDispknkcomment15() {
        return dispknkcomment15;
    }

    public void setDispknkcomment15(String pDispknkcomment15) {
        dispknkcomment15 = pDispknkcomment15;
    }

    private C_Ketkekkacd dispknkktkkcd15;

    public C_Ketkekkacd getDispknkktkkcd15() {
        return dispknkktkkcd15;
    }

    public void setDispknkktkkcd15(C_Ketkekkacd pDispknkktkkcd15) {
        dispknkktkkcd15 = pDispknkktkkcd15;
    }

    private C_TorikesisyousairiyuuCd dispknktrkssyousairiyuu15;

    public C_TorikesisyousairiyuuCd getDispknktrkssyousairiyuu15() {
        return dispknktrkssyousairiyuu15;
    }

    public void setDispknktrkssyousairiyuu15(C_TorikesisyousairiyuuCd pDispknktrkssyousairiyuu15) {
        dispknktrkssyousairiyuu15 = pDispknktrkssyousairiyuu15;
    }

    private String dispknkketriyuucd115;

    public String getDispknkketriyuucd115() {
        return dispknkketriyuucd115;
    }

    public void setDispknkketriyuucd115(String pDispknkketriyuucd115) {
        dispknkketriyuucd115 = pDispknkketriyuucd115;
    }

    private String dispknkketriyuunaiyou115;

    public String getDispknkketriyuunaiyou115() {
        return dispknkketriyuunaiyou115;
    }

    public void setDispknkketriyuunaiyou115(String pDispknkketriyuunaiyou115) {
        dispknkketriyuunaiyou115 = pDispknkketriyuunaiyou115;
    }

    private String dispknkketriyuucd215;

    public String getDispknkketriyuucd215() {
        return dispknkketriyuucd215;
    }

    public void setDispknkketriyuucd215(String pDispknkketriyuucd215) {
        dispknkketriyuucd215 = pDispknkketriyuucd215;
    }

    private String dispknkketriyuunaiyou215;

    public String getDispknkketriyuunaiyou215() {
        return dispknkketriyuunaiyou215;
    }

    public void setDispknkketriyuunaiyou215(String pDispknkketriyuunaiyou215) {
        dispknkketriyuunaiyou215 = pDispknkketriyuunaiyou215;
    }

    private String dispknkketriyuucd315;

    public String getDispknkketriyuucd315() {
        return dispknkketriyuucd315;
    }

    public void setDispknkketriyuucd315(String pDispknkketriyuucd315) {
        dispknkketriyuucd315 = pDispknkketriyuucd315;
    }

    private String dispknkketriyuunaiyou315;

    public String getDispknkketriyuunaiyou315() {
        return dispknkketriyuunaiyou315;
    }

    public void setDispknkketriyuunaiyou315(String pDispknkketriyuunaiyou315) {
        dispknkketriyuunaiyou315 = pDispknkketriyuunaiyou315;
    }

    private String dispknkketriyuucd415;

    public String getDispknkketriyuucd415() {
        return dispknkketriyuucd415;
    }

    public void setDispknkketriyuucd415(String pDispknkketriyuucd415) {
        dispknkketriyuucd415 = pDispknkketriyuucd415;
    }

    private String dispknkketriyuunaiyou415;

    public String getDispknkketriyuunaiyou415() {
        return dispknkketriyuunaiyou415;
    }

    public void setDispknkketriyuunaiyou415(String pDispknkketriyuunaiyou415) {
        dispknkketriyuunaiyou415 = pDispknkketriyuunaiyou415;
    }

    private C_MrRiyuucdKbn dispknkmrriyuucdnaiyou15;

    public C_MrRiyuucdKbn getDispknkmrriyuucdnaiyou15() {
        return dispknkmrriyuucdnaiyou15;
    }

    public void setDispknkmrriyuucdnaiyou15(C_MrRiyuucdKbn pDispknkmrriyuucdnaiyou15) {
        dispknkmrriyuucdnaiyou15 = pDispknkmrriyuucdnaiyou15;
    }

    private String imusateisijinaiyou;

    public String getImusateisijinaiyou() {
        return imusateisijinaiyou;
    }

    public void setImusateisijinaiyou(String pImusateisijinaiyou) {
        imusateisijinaiyou = pImusateisijinaiyou;
    }

    private BizDate dispimusyoriymd1;

    public BizDate getDispimusyoriymd1() {
        return dispimusyoriymd1;
    }

    public void setDispimusyoriymd1(BizDate pDispimusyoriymd1) {
        dispimusyoriymd1 = pDispimusyoriymd1;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn1;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn1() {
        return dispimustktsyorinmkbn1;
    }

    public void setDispimustktsyorinmkbn1(C_SateiketsyorinmKbn pDispimustktsyorinmkbn1) {
        dispimustktsyorinmkbn1 = pDispimustktsyorinmkbn1;
    }

    private C_SyorikekkaKbn dispimukekkakbn1;

    public C_SyorikekkaKbn getDispimukekkakbn1() {
        return dispimukekkakbn1;
    }

    public void setDispimukekkakbn1(C_SyorikekkaKbn pDispimukekkakbn1) {
        dispimukekkakbn1 = pDispimukekkakbn1;
    }

    private String dispimutns1;

    public String getDispimutns1() {
        return dispimutns1;
    }

    public void setDispimutns1(String pDispimutns1) {
        dispimutns1 = pDispimutns1;
    }

    private String dispimuktnm1;

    public String getDispimuktnm1() {
        return dispimuktnm1;
    }

    public void setDispimuktnm1(String pDispimuktnm1) {
        dispimuktnm1 = pDispimuktnm1;
    }

    private String dispimucomment1;

    public String getDispimucomment1() {
        return dispimucomment1;
    }

    public void setDispimucomment1(String pDispimucomment1) {
        dispimucomment1 = pDispimucomment1;
    }

    private C_Ketkekkacd dispimuketkekkacd1;

    public C_Ketkekkacd getDispimuketkekkacd1() {
        return dispimuketkekkacd1;
    }

    public void setDispimuketkekkacd1(C_Ketkekkacd pDispimuketkekkacd1) {
        dispimuketkekkacd1 = pDispimuketkekkacd1;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh1;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh1() {
        return dispimusntksakuseiyh1;
    }

    public void setDispimusntksakuseiyh1(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh1) {
        dispimusntksakuseiyh1 = pDispimusntksakuseiyh1;
    }

    private String dispimuketriyuucd11;

    public String getDispimuketriyuucd11() {
        return dispimuketriyuucd11;
    }

    public void setDispimuketriyuucd11(String pDispimuketriyuucd11) {
        dispimuketriyuucd11 = pDispimuketriyuucd11;
    }

    private String dispimuketriyuunaiyou11;

    public String getDispimuketriyuunaiyou11() {
        return dispimuketriyuunaiyou11;
    }

    public void setDispimuketriyuunaiyou11(String pDispimuketriyuunaiyou11) {
        dispimuketriyuunaiyou11 = pDispimuketriyuunaiyou11;
    }

    private String dispimusyoubyoucd11;

    public String getDispimusyoubyoucd11() {
        return dispimusyoubyoucd11;
    }

    public void setDispimusyoubyoucd11(String pDispimusyoubyoucd11) {
        dispimusyoubyoucd11 = pDispimusyoubyoucd11;
    }

    private String dispimusyoubyounm11;

    public String getDispimusyoubyounm11() {
        return dispimusyoubyounm11;
    }

    public void setDispimusyoubyounm11(String pDispimusyoubyounm11) {
        dispimusyoubyounm11 = pDispimusyoubyounm11;
    }

    private String dispimuketriyuucd21;

    public String getDispimuketriyuucd21() {
        return dispimuketriyuucd21;
    }

    public void setDispimuketriyuucd21(String pDispimuketriyuucd21) {
        dispimuketriyuucd21 = pDispimuketriyuucd21;
    }

    private String dispimuketriyuunaiyou21;

    public String getDispimuketriyuunaiyou21() {
        return dispimuketriyuunaiyou21;
    }

    public void setDispimuketriyuunaiyou21(String pDispimuketriyuunaiyou21) {
        dispimuketriyuunaiyou21 = pDispimuketriyuunaiyou21;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai11;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai11() {
        return dispimusyoubyoujyoutai11;
    }

    public void setDispimusyoubyoujyoutai11(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai11) {
        dispimusyoubyoujyoutai11 = pDispimusyoubyoujyoutai11;
    }

    private BizDateYM dispimukantiym11;

    public BizDateYM getDispimukantiym11() {
        return dispimukantiym11;
    }

    public void setDispimukantiym11(BizDateYM pDispimukantiym11) {
        dispimukantiym11 = pDispimukantiym11;
    }

    private String dispimuketriyuucd31;

    public String getDispimuketriyuucd31() {
        return dispimuketriyuucd31;
    }

    public void setDispimuketriyuucd31(String pDispimuketriyuucd31) {
        dispimuketriyuucd31 = pDispimuketriyuucd31;
    }

    private String dispimuketriyuunaiyou31;

    public String getDispimuketriyuunaiyou31() {
        return dispimuketriyuunaiyou31;
    }

    public void setDispimuketriyuunaiyou31(String pDispimuketriyuunaiyou31) {
        dispimuketriyuunaiyou31 = pDispimuketriyuunaiyou31;
    }

    private String dispimusyoubyoucd21;

    public String getDispimusyoubyoucd21() {
        return dispimusyoubyoucd21;
    }

    public void setDispimusyoubyoucd21(String pDispimusyoubyoucd21) {
        dispimusyoubyoucd21 = pDispimusyoubyoucd21;
    }

    private String dispimusyoubyounm21;

    public String getDispimusyoubyounm21() {
        return dispimusyoubyounm21;
    }

    public void setDispimusyoubyounm21(String pDispimusyoubyounm21) {
        dispimusyoubyounm21 = pDispimusyoubyounm21;
    }

    private String dispimuketriyuucd41;

    public String getDispimuketriyuucd41() {
        return dispimuketriyuucd41;
    }

    public void setDispimuketriyuucd41(String pDispimuketriyuucd41) {
        dispimuketriyuucd41 = pDispimuketriyuucd41;
    }

    private String dispimuketriyuunaiyou41;

    public String getDispimuketriyuunaiyou41() {
        return dispimuketriyuunaiyou41;
    }

    public void setDispimuketriyuunaiyou41(String pDispimuketriyuunaiyou41) {
        dispimuketriyuunaiyou41 = pDispimuketriyuunaiyou41;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai21;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai21() {
        return dispimusyoubyoujyoutai21;
    }

    public void setDispimusyoubyoujyoutai21(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai21) {
        dispimusyoubyoujyoutai21 = pDispimusyoubyoujyoutai21;
    }

    private BizDateYM dispimukantiym21;

    public BizDateYM getDispimukantiym21() {
        return dispimukantiym21;
    }

    public void setDispimukantiym21(BizDateYM pDispimukantiym21) {
        dispimukantiym21 = pDispimukantiym21;
    }

    private BizDate dispimusyoriymd2;

    public BizDate getDispimusyoriymd2() {
        return dispimusyoriymd2;
    }

    public void setDispimusyoriymd2(BizDate pDispimusyoriymd2) {
        dispimusyoriymd2 = pDispimusyoriymd2;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn2;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn2() {
        return dispimustktsyorinmkbn2;
    }

    public void setDispimustktsyorinmkbn2(C_SateiketsyorinmKbn pDispimustktsyorinmkbn2) {
        dispimustktsyorinmkbn2 = pDispimustktsyorinmkbn2;
    }

    private C_SyorikekkaKbn dispimukekkakbn2;

    public C_SyorikekkaKbn getDispimukekkakbn2() {
        return dispimukekkakbn2;
    }

    public void setDispimukekkakbn2(C_SyorikekkaKbn pDispimukekkakbn2) {
        dispimukekkakbn2 = pDispimukekkakbn2;
    }

    private String dispimutns2;

    public String getDispimutns2() {
        return dispimutns2;
    }

    public void setDispimutns2(String pDispimutns2) {
        dispimutns2 = pDispimutns2;
    }

    private String dispimuktnm2;

    public String getDispimuktnm2() {
        return dispimuktnm2;
    }

    public void setDispimuktnm2(String pDispimuktnm2) {
        dispimuktnm2 = pDispimuktnm2;
    }

    private String dispimucomment2;

    public String getDispimucomment2() {
        return dispimucomment2;
    }

    public void setDispimucomment2(String pDispimucomment2) {
        dispimucomment2 = pDispimucomment2;
    }

    private C_Ketkekkacd dispimuketkekkacd2;

    public C_Ketkekkacd getDispimuketkekkacd2() {
        return dispimuketkekkacd2;
    }

    public void setDispimuketkekkacd2(C_Ketkekkacd pDispimuketkekkacd2) {
        dispimuketkekkacd2 = pDispimuketkekkacd2;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh2;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh2() {
        return dispimusntksakuseiyh2;
    }

    public void setDispimusntksakuseiyh2(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh2) {
        dispimusntksakuseiyh2 = pDispimusntksakuseiyh2;
    }

    private String dispimuketriyuucd12;

    public String getDispimuketriyuucd12() {
        return dispimuketriyuucd12;
    }

    public void setDispimuketriyuucd12(String pDispimuketriyuucd12) {
        dispimuketriyuucd12 = pDispimuketriyuucd12;
    }

    private String dispimuketriyuunaiyou12;

    public String getDispimuketriyuunaiyou12() {
        return dispimuketriyuunaiyou12;
    }

    public void setDispimuketriyuunaiyou12(String pDispimuketriyuunaiyou12) {
        dispimuketriyuunaiyou12 = pDispimuketriyuunaiyou12;
    }

    private String dispimusyoubyoucd12;

    public String getDispimusyoubyoucd12() {
        return dispimusyoubyoucd12;
    }

    public void setDispimusyoubyoucd12(String pDispimusyoubyoucd12) {
        dispimusyoubyoucd12 = pDispimusyoubyoucd12;
    }

    private String dispimusyoubyounm12;

    public String getDispimusyoubyounm12() {
        return dispimusyoubyounm12;
    }

    public void setDispimusyoubyounm12(String pDispimusyoubyounm12) {
        dispimusyoubyounm12 = pDispimusyoubyounm12;
    }

    private String dispimuketriyuucd22;

    public String getDispimuketriyuucd22() {
        return dispimuketriyuucd22;
    }

    public void setDispimuketriyuucd22(String pDispimuketriyuucd22) {
        dispimuketriyuucd22 = pDispimuketriyuucd22;
    }

    private String dispimuketriyuunaiyou22;

    public String getDispimuketriyuunaiyou22() {
        return dispimuketriyuunaiyou22;
    }

    public void setDispimuketriyuunaiyou22(String pDispimuketriyuunaiyou22) {
        dispimuketriyuunaiyou22 = pDispimuketriyuunaiyou22;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai12;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai12() {
        return dispimusyoubyoujyoutai12;
    }

    public void setDispimusyoubyoujyoutai12(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai12) {
        dispimusyoubyoujyoutai12 = pDispimusyoubyoujyoutai12;
    }

    private BizDateYM dispimukantiym12;

    public BizDateYM getDispimukantiym12() {
        return dispimukantiym12;
    }

    public void setDispimukantiym12(BizDateYM pDispimukantiym12) {
        dispimukantiym12 = pDispimukantiym12;
    }

    private String dispimuketriyuucd32;

    public String getDispimuketriyuucd32() {
        return dispimuketriyuucd32;
    }

    public void setDispimuketriyuucd32(String pDispimuketriyuucd32) {
        dispimuketriyuucd32 = pDispimuketriyuucd32;
    }

    private String dispimuketriyuunaiyou32;

    public String getDispimuketriyuunaiyou32() {
        return dispimuketriyuunaiyou32;
    }

    public void setDispimuketriyuunaiyou32(String pDispimuketriyuunaiyou32) {
        dispimuketriyuunaiyou32 = pDispimuketriyuunaiyou32;
    }

    private String dispimusyoubyoucd22;

    public String getDispimusyoubyoucd22() {
        return dispimusyoubyoucd22;
    }

    public void setDispimusyoubyoucd22(String pDispimusyoubyoucd22) {
        dispimusyoubyoucd22 = pDispimusyoubyoucd22;
    }

    private String dispimusyoubyounm22;

    public String getDispimusyoubyounm22() {
        return dispimusyoubyounm22;
    }

    public void setDispimusyoubyounm22(String pDispimusyoubyounm22) {
        dispimusyoubyounm22 = pDispimusyoubyounm22;
    }

    private String dispimuketriyuucd42;

    public String getDispimuketriyuucd42() {
        return dispimuketriyuucd42;
    }

    public void setDispimuketriyuucd42(String pDispimuketriyuucd42) {
        dispimuketriyuucd42 = pDispimuketriyuucd42;
    }

    private String dispimuketriyuunaiyou42;

    public String getDispimuketriyuunaiyou42() {
        return dispimuketriyuunaiyou42;
    }

    public void setDispimuketriyuunaiyou42(String pDispimuketriyuunaiyou42) {
        dispimuketriyuunaiyou42 = pDispimuketriyuunaiyou42;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai22;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai22() {
        return dispimusyoubyoujyoutai22;
    }

    public void setDispimusyoubyoujyoutai22(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai22) {
        dispimusyoubyoujyoutai22 = pDispimusyoubyoujyoutai22;
    }

    private BizDateYM dispimukantiym22;

    public BizDateYM getDispimukantiym22() {
        return dispimukantiym22;
    }

    public void setDispimukantiym22(BizDateYM pDispimukantiym22) {
        dispimukantiym22 = pDispimukantiym22;
    }

    private BizDate dispimusyoriymd3;

    public BizDate getDispimusyoriymd3() {
        return dispimusyoriymd3;
    }

    public void setDispimusyoriymd3(BizDate pDispimusyoriymd3) {
        dispimusyoriymd3 = pDispimusyoriymd3;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn3;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn3() {
        return dispimustktsyorinmkbn3;
    }

    public void setDispimustktsyorinmkbn3(C_SateiketsyorinmKbn pDispimustktsyorinmkbn3) {
        dispimustktsyorinmkbn3 = pDispimustktsyorinmkbn3;
    }

    private C_SyorikekkaKbn dispimukekkakbn3;

    public C_SyorikekkaKbn getDispimukekkakbn3() {
        return dispimukekkakbn3;
    }

    public void setDispimukekkakbn3(C_SyorikekkaKbn pDispimukekkakbn3) {
        dispimukekkakbn3 = pDispimukekkakbn3;
    }

    private String dispimutns3;

    public String getDispimutns3() {
        return dispimutns3;
    }

    public void setDispimutns3(String pDispimutns3) {
        dispimutns3 = pDispimutns3;
    }

    private String dispimuktnm3;

    public String getDispimuktnm3() {
        return dispimuktnm3;
    }

    public void setDispimuktnm3(String pDispimuktnm3) {
        dispimuktnm3 = pDispimuktnm3;
    }

    private String dispimucomment3;

    public String getDispimucomment3() {
        return dispimucomment3;
    }

    public void setDispimucomment3(String pDispimucomment3) {
        dispimucomment3 = pDispimucomment3;
    }

    private C_Ketkekkacd dispimuketkekkacd3;

    public C_Ketkekkacd getDispimuketkekkacd3() {
        return dispimuketkekkacd3;
    }

    public void setDispimuketkekkacd3(C_Ketkekkacd pDispimuketkekkacd3) {
        dispimuketkekkacd3 = pDispimuketkekkacd3;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh3;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh3() {
        return dispimusntksakuseiyh3;
    }

    public void setDispimusntksakuseiyh3(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh3) {
        dispimusntksakuseiyh3 = pDispimusntksakuseiyh3;
    }

    private String dispimuketriyuucd13;

    public String getDispimuketriyuucd13() {
        return dispimuketriyuucd13;
    }

    public void setDispimuketriyuucd13(String pDispimuketriyuucd13) {
        dispimuketriyuucd13 = pDispimuketriyuucd13;
    }

    private String dispimuketriyuunaiyou13;

    public String getDispimuketriyuunaiyou13() {
        return dispimuketriyuunaiyou13;
    }

    public void setDispimuketriyuunaiyou13(String pDispimuketriyuunaiyou13) {
        dispimuketriyuunaiyou13 = pDispimuketriyuunaiyou13;
    }

    private String dispimusyoubyoucd13;

    public String getDispimusyoubyoucd13() {
        return dispimusyoubyoucd13;
    }

    public void setDispimusyoubyoucd13(String pDispimusyoubyoucd13) {
        dispimusyoubyoucd13 = pDispimusyoubyoucd13;
    }

    private String dispimusyoubyounm13;

    public String getDispimusyoubyounm13() {
        return dispimusyoubyounm13;
    }

    public void setDispimusyoubyounm13(String pDispimusyoubyounm13) {
        dispimusyoubyounm13 = pDispimusyoubyounm13;
    }

    private String dispimuketriyuucd23;

    public String getDispimuketriyuucd23() {
        return dispimuketriyuucd23;
    }

    public void setDispimuketriyuucd23(String pDispimuketriyuucd23) {
        dispimuketriyuucd23 = pDispimuketriyuucd23;
    }

    private String dispimuketriyuunaiyou23;

    public String getDispimuketriyuunaiyou23() {
        return dispimuketriyuunaiyou23;
    }

    public void setDispimuketriyuunaiyou23(String pDispimuketriyuunaiyou23) {
        dispimuketriyuunaiyou23 = pDispimuketriyuunaiyou23;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai13;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai13() {
        return dispimusyoubyoujyoutai13;
    }

    public void setDispimusyoubyoujyoutai13(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai13) {
        dispimusyoubyoujyoutai13 = pDispimusyoubyoujyoutai13;
    }

    private BizDateYM dispimukantiym13;

    public BizDateYM getDispimukantiym13() {
        return dispimukantiym13;
    }

    public void setDispimukantiym13(BizDateYM pDispimukantiym13) {
        dispimukantiym13 = pDispimukantiym13;
    }

    private String dispimuketriyuucd33;

    public String getDispimuketriyuucd33() {
        return dispimuketriyuucd33;
    }

    public void setDispimuketriyuucd33(String pDispimuketriyuucd33) {
        dispimuketriyuucd33 = pDispimuketriyuucd33;
    }

    private String dispimuketriyuunaiyou33;

    public String getDispimuketriyuunaiyou33() {
        return dispimuketriyuunaiyou33;
    }

    public void setDispimuketriyuunaiyou33(String pDispimuketriyuunaiyou33) {
        dispimuketriyuunaiyou33 = pDispimuketriyuunaiyou33;
    }

    private String dispimusyoubyoucd23;

    public String getDispimusyoubyoucd23() {
        return dispimusyoubyoucd23;
    }

    public void setDispimusyoubyoucd23(String pDispimusyoubyoucd23) {
        dispimusyoubyoucd23 = pDispimusyoubyoucd23;
    }

    private String dispimusyoubyounm23;

    public String getDispimusyoubyounm23() {
        return dispimusyoubyounm23;
    }

    public void setDispimusyoubyounm23(String pDispimusyoubyounm23) {
        dispimusyoubyounm23 = pDispimusyoubyounm23;
    }

    private String dispimuketriyuucd43;

    public String getDispimuketriyuucd43() {
        return dispimuketriyuucd43;
    }

    public void setDispimuketriyuucd43(String pDispimuketriyuucd43) {
        dispimuketriyuucd43 = pDispimuketriyuucd43;
    }

    private String dispimuketriyuunaiyou43;

    public String getDispimuketriyuunaiyou43() {
        return dispimuketriyuunaiyou43;
    }

    public void setDispimuketriyuunaiyou43(String pDispimuketriyuunaiyou43) {
        dispimuketriyuunaiyou43 = pDispimuketriyuunaiyou43;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai23;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai23() {
        return dispimusyoubyoujyoutai23;
    }

    public void setDispimusyoubyoujyoutai23(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai23) {
        dispimusyoubyoujyoutai23 = pDispimusyoubyoujyoutai23;
    }

    private BizDateYM dispimukantiym23;

    public BizDateYM getDispimukantiym23() {
        return dispimukantiym23;
    }

    public void setDispimukantiym23(BizDateYM pDispimukantiym23) {
        dispimukantiym23 = pDispimukantiym23;
    }

    private BizDate dispimusyoriymd4;

    public BizDate getDispimusyoriymd4() {
        return dispimusyoriymd4;
    }

    public void setDispimusyoriymd4(BizDate pDispimusyoriymd4) {
        dispimusyoriymd4 = pDispimusyoriymd4;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn4;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn4() {
        return dispimustktsyorinmkbn4;
    }

    public void setDispimustktsyorinmkbn4(C_SateiketsyorinmKbn pDispimustktsyorinmkbn4) {
        dispimustktsyorinmkbn4 = pDispimustktsyorinmkbn4;
    }

    private C_SyorikekkaKbn dispimukekkakbn4;

    public C_SyorikekkaKbn getDispimukekkakbn4() {
        return dispimukekkakbn4;
    }

    public void setDispimukekkakbn4(C_SyorikekkaKbn pDispimukekkakbn4) {
        dispimukekkakbn4 = pDispimukekkakbn4;
    }

    private String dispimutns4;

    public String getDispimutns4() {
        return dispimutns4;
    }

    public void setDispimutns4(String pDispimutns4) {
        dispimutns4 = pDispimutns4;
    }

    private String dispimuktnm4;

    public String getDispimuktnm4() {
        return dispimuktnm4;
    }

    public void setDispimuktnm4(String pDispimuktnm4) {
        dispimuktnm4 = pDispimuktnm4;
    }

    private String dispimucomment4;

    public String getDispimucomment4() {
        return dispimucomment4;
    }

    public void setDispimucomment4(String pDispimucomment4) {
        dispimucomment4 = pDispimucomment4;
    }

    private C_Ketkekkacd dispimuketkekkacd4;

    public C_Ketkekkacd getDispimuketkekkacd4() {
        return dispimuketkekkacd4;
    }

    public void setDispimuketkekkacd4(C_Ketkekkacd pDispimuketkekkacd4) {
        dispimuketkekkacd4 = pDispimuketkekkacd4;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh4;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh4() {
        return dispimusntksakuseiyh4;
    }

    public void setDispimusntksakuseiyh4(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh4) {
        dispimusntksakuseiyh4 = pDispimusntksakuseiyh4;
    }

    private String dispimuketriyuucd14;

    public String getDispimuketriyuucd14() {
        return dispimuketriyuucd14;
    }

    public void setDispimuketriyuucd14(String pDispimuketriyuucd14) {
        dispimuketriyuucd14 = pDispimuketriyuucd14;
    }

    private String dispimuketriyuunaiyou14;

    public String getDispimuketriyuunaiyou14() {
        return dispimuketriyuunaiyou14;
    }

    public void setDispimuketriyuunaiyou14(String pDispimuketriyuunaiyou14) {
        dispimuketriyuunaiyou14 = pDispimuketriyuunaiyou14;
    }

    private String dispimusyoubyoucd14;

    public String getDispimusyoubyoucd14() {
        return dispimusyoubyoucd14;
    }

    public void setDispimusyoubyoucd14(String pDispimusyoubyoucd14) {
        dispimusyoubyoucd14 = pDispimusyoubyoucd14;
    }

    private String dispimusyoubyounm14;

    public String getDispimusyoubyounm14() {
        return dispimusyoubyounm14;
    }

    public void setDispimusyoubyounm14(String pDispimusyoubyounm14) {
        dispimusyoubyounm14 = pDispimusyoubyounm14;
    }

    private String dispimuketriyuucd24;

    public String getDispimuketriyuucd24() {
        return dispimuketriyuucd24;
    }

    public void setDispimuketriyuucd24(String pDispimuketriyuucd24) {
        dispimuketriyuucd24 = pDispimuketriyuucd24;
    }

    private String dispimuketriyuunaiyou24;

    public String getDispimuketriyuunaiyou24() {
        return dispimuketriyuunaiyou24;
    }

    public void setDispimuketriyuunaiyou24(String pDispimuketriyuunaiyou24) {
        dispimuketriyuunaiyou24 = pDispimuketriyuunaiyou24;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai14;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai14() {
        return dispimusyoubyoujyoutai14;
    }

    public void setDispimusyoubyoujyoutai14(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai14) {
        dispimusyoubyoujyoutai14 = pDispimusyoubyoujyoutai14;
    }

    private BizDateYM dispimukantiym14;

    public BizDateYM getDispimukantiym14() {
        return dispimukantiym14;
    }

    public void setDispimukantiym14(BizDateYM pDispimukantiym14) {
        dispimukantiym14 = pDispimukantiym14;
    }

    private String dispimuketriyuucd34;

    public String getDispimuketriyuucd34() {
        return dispimuketriyuucd34;
    }

    public void setDispimuketriyuucd34(String pDispimuketriyuucd34) {
        dispimuketriyuucd34 = pDispimuketriyuucd34;
    }

    private String dispimuketriyuunaiyou34;

    public String getDispimuketriyuunaiyou34() {
        return dispimuketriyuunaiyou34;
    }

    public void setDispimuketriyuunaiyou34(String pDispimuketriyuunaiyou34) {
        dispimuketriyuunaiyou34 = pDispimuketriyuunaiyou34;
    }

    private String dispimusyoubyoucd24;

    public String getDispimusyoubyoucd24() {
        return dispimusyoubyoucd24;
    }

    public void setDispimusyoubyoucd24(String pDispimusyoubyoucd24) {
        dispimusyoubyoucd24 = pDispimusyoubyoucd24;
    }

    private String dispimusyoubyounm24;

    public String getDispimusyoubyounm24() {
        return dispimusyoubyounm24;
    }

    public void setDispimusyoubyounm24(String pDispimusyoubyounm24) {
        dispimusyoubyounm24 = pDispimusyoubyounm24;
    }

    private String dispimuketriyuucd44;

    public String getDispimuketriyuucd44() {
        return dispimuketriyuucd44;
    }

    public void setDispimuketriyuucd44(String pDispimuketriyuucd44) {
        dispimuketriyuucd44 = pDispimuketriyuucd44;
    }

    private String dispimuketriyuunaiyou44;

    public String getDispimuketriyuunaiyou44() {
        return dispimuketriyuunaiyou44;
    }

    public void setDispimuketriyuunaiyou44(String pDispimuketriyuunaiyou44) {
        dispimuketriyuunaiyou44 = pDispimuketriyuunaiyou44;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai24;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai24() {
        return dispimusyoubyoujyoutai24;
    }

    public void setDispimusyoubyoujyoutai24(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai24) {
        dispimusyoubyoujyoutai24 = pDispimusyoubyoujyoutai24;
    }

    private BizDateYM dispimukantiym24;

    public BizDateYM getDispimukantiym24() {
        return dispimukantiym24;
    }

    public void setDispimukantiym24(BizDateYM pDispimukantiym24) {
        dispimukantiym24 = pDispimukantiym24;
    }

    private BizDate dispimusyoriymd5;

    public BizDate getDispimusyoriymd5() {
        return dispimusyoriymd5;
    }

    public void setDispimusyoriymd5(BizDate pDispimusyoriymd5) {
        dispimusyoriymd5 = pDispimusyoriymd5;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn5;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn5() {
        return dispimustktsyorinmkbn5;
    }

    public void setDispimustktsyorinmkbn5(C_SateiketsyorinmKbn pDispimustktsyorinmkbn5) {
        dispimustktsyorinmkbn5 = pDispimustktsyorinmkbn5;
    }

    private C_SyorikekkaKbn dispimukekkakbn5;

    public C_SyorikekkaKbn getDispimukekkakbn5() {
        return dispimukekkakbn5;
    }

    public void setDispimukekkakbn5(C_SyorikekkaKbn pDispimukekkakbn5) {
        dispimukekkakbn5 = pDispimukekkakbn5;
    }

    private String dispimutns5;

    public String getDispimutns5() {
        return dispimutns5;
    }

    public void setDispimutns5(String pDispimutns5) {
        dispimutns5 = pDispimutns5;
    }

    private String dispimuktnm5;

    public String getDispimuktnm5() {
        return dispimuktnm5;
    }

    public void setDispimuktnm5(String pDispimuktnm5) {
        dispimuktnm5 = pDispimuktnm5;
    }

    private String dispimucomment5;

    public String getDispimucomment5() {
        return dispimucomment5;
    }

    public void setDispimucomment5(String pDispimucomment5) {
        dispimucomment5 = pDispimucomment5;
    }

    private C_Ketkekkacd dispimuketkekkacd5;

    public C_Ketkekkacd getDispimuketkekkacd5() {
        return dispimuketkekkacd5;
    }

    public void setDispimuketkekkacd5(C_Ketkekkacd pDispimuketkekkacd5) {
        dispimuketkekkacd5 = pDispimuketkekkacd5;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh5;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh5() {
        return dispimusntksakuseiyh5;
    }

    public void setDispimusntksakuseiyh5(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh5) {
        dispimusntksakuseiyh5 = pDispimusntksakuseiyh5;
    }

    private String dispimuketriyuucd15;

    public String getDispimuketriyuucd15() {
        return dispimuketriyuucd15;
    }

    public void setDispimuketriyuucd15(String pDispimuketriyuucd15) {
        dispimuketriyuucd15 = pDispimuketriyuucd15;
    }

    private String dispimuketriyuunaiyou15;

    public String getDispimuketriyuunaiyou15() {
        return dispimuketriyuunaiyou15;
    }

    public void setDispimuketriyuunaiyou15(String pDispimuketriyuunaiyou15) {
        dispimuketriyuunaiyou15 = pDispimuketriyuunaiyou15;
    }

    private String dispimusyoubyoucd15;

    public String getDispimusyoubyoucd15() {
        return dispimusyoubyoucd15;
    }

    public void setDispimusyoubyoucd15(String pDispimusyoubyoucd15) {
        dispimusyoubyoucd15 = pDispimusyoubyoucd15;
    }

    private String dispimusyoubyounm15;

    public String getDispimusyoubyounm15() {
        return dispimusyoubyounm15;
    }

    public void setDispimusyoubyounm15(String pDispimusyoubyounm15) {
        dispimusyoubyounm15 = pDispimusyoubyounm15;
    }

    private String dispimuketriyuucd25;

    public String getDispimuketriyuucd25() {
        return dispimuketriyuucd25;
    }

    public void setDispimuketriyuucd25(String pDispimuketriyuucd25) {
        dispimuketriyuucd25 = pDispimuketriyuucd25;
    }

    private String dispimuketriyuunaiyou25;

    public String getDispimuketriyuunaiyou25() {
        return dispimuketriyuunaiyou25;
    }

    public void setDispimuketriyuunaiyou25(String pDispimuketriyuunaiyou25) {
        dispimuketriyuunaiyou25 = pDispimuketriyuunaiyou25;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai15;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai15() {
        return dispimusyoubyoujyoutai15;
    }

    public void setDispimusyoubyoujyoutai15(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai15) {
        dispimusyoubyoujyoutai15 = pDispimusyoubyoujyoutai15;
    }

    private BizDateYM dispimukantiym15;

    public BizDateYM getDispimukantiym15() {
        return dispimukantiym15;
    }

    public void setDispimukantiym15(BizDateYM pDispimukantiym15) {
        dispimukantiym15 = pDispimukantiym15;
    }

    private String dispimuketriyuucd35;

    public String getDispimuketriyuucd35() {
        return dispimuketriyuucd35;
    }

    public void setDispimuketriyuucd35(String pDispimuketriyuucd35) {
        dispimuketriyuucd35 = pDispimuketriyuucd35;
    }

    private String dispimuketriyuunaiyou35;

    public String getDispimuketriyuunaiyou35() {
        return dispimuketriyuunaiyou35;
    }

    public void setDispimuketriyuunaiyou35(String pDispimuketriyuunaiyou35) {
        dispimuketriyuunaiyou35 = pDispimuketriyuunaiyou35;
    }

    private String dispimusyoubyoucd25;

    public String getDispimusyoubyoucd25() {
        return dispimusyoubyoucd25;
    }

    public void setDispimusyoubyoucd25(String pDispimusyoubyoucd25) {
        dispimusyoubyoucd25 = pDispimusyoubyoucd25;
    }

    private String dispimusyoubyounm25;

    public String getDispimusyoubyounm25() {
        return dispimusyoubyounm25;
    }

    public void setDispimusyoubyounm25(String pDispimusyoubyounm25) {
        dispimusyoubyounm25 = pDispimusyoubyounm25;
    }

    private String dispimuketriyuucd45;

    public String getDispimuketriyuucd45() {
        return dispimuketriyuucd45;
    }

    public void setDispimuketriyuucd45(String pDispimuketriyuucd45) {
        dispimuketriyuucd45 = pDispimuketriyuucd45;
    }

    private String dispimuketriyuunaiyou45;

    public String getDispimuketriyuunaiyou45() {
        return dispimuketriyuunaiyou45;
    }

    public void setDispimuketriyuunaiyou45(String pDispimuketriyuunaiyou45) {
        dispimuketriyuunaiyou45 = pDispimuketriyuunaiyou45;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai25;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai25() {
        return dispimusyoubyoujyoutai25;
    }

    public void setDispimusyoubyoujyoutai25(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai25) {
        dispimusyoubyoujyoutai25 = pDispimusyoubyoujyoutai25;
    }

    private BizDateYM dispimukantiym25;

    public BizDateYM getDispimukantiym25() {
        return dispimukantiym25;
    }

    public void setDispimukantiym25(BizDateYM pDispimukantiym25) {
        dispimukantiym25 = pDispimukantiym25;
    }

    private BizDate dispimusyoriymd6;

    public BizDate getDispimusyoriymd6() {
        return dispimusyoriymd6;
    }

    public void setDispimusyoriymd6(BizDate pDispimusyoriymd6) {
        dispimusyoriymd6 = pDispimusyoriymd6;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn6;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn6() {
        return dispimustktsyorinmkbn6;
    }

    public void setDispimustktsyorinmkbn6(C_SateiketsyorinmKbn pDispimustktsyorinmkbn6) {
        dispimustktsyorinmkbn6 = pDispimustktsyorinmkbn6;
    }

    private C_SyorikekkaKbn dispimukekkakbn6;

    public C_SyorikekkaKbn getDispimukekkakbn6() {
        return dispimukekkakbn6;
    }

    public void setDispimukekkakbn6(C_SyorikekkaKbn pDispimukekkakbn6) {
        dispimukekkakbn6 = pDispimukekkakbn6;
    }

    private String dispimutns6;

    public String getDispimutns6() {
        return dispimutns6;
    }

    public void setDispimutns6(String pDispimutns6) {
        dispimutns6 = pDispimutns6;
    }

    private String dispimuktnm6;

    public String getDispimuktnm6() {
        return dispimuktnm6;
    }

    public void setDispimuktnm6(String pDispimuktnm6) {
        dispimuktnm6 = pDispimuktnm6;
    }

    private String dispimucomment6;

    public String getDispimucomment6() {
        return dispimucomment6;
    }

    public void setDispimucomment6(String pDispimucomment6) {
        dispimucomment6 = pDispimucomment6;
    }

    private C_Ketkekkacd dispimuketkekkacd6;

    public C_Ketkekkacd getDispimuketkekkacd6() {
        return dispimuketkekkacd6;
    }

    public void setDispimuketkekkacd6(C_Ketkekkacd pDispimuketkekkacd6) {
        dispimuketkekkacd6 = pDispimuketkekkacd6;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh6;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh6() {
        return dispimusntksakuseiyh6;
    }

    public void setDispimusntksakuseiyh6(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh6) {
        dispimusntksakuseiyh6 = pDispimusntksakuseiyh6;
    }

    private String dispimuketriyuucd16;

    public String getDispimuketriyuucd16() {
        return dispimuketriyuucd16;
    }

    public void setDispimuketriyuucd16(String pDispimuketriyuucd16) {
        dispimuketriyuucd16 = pDispimuketriyuucd16;
    }

    private String dispimuketriyuunaiyou16;

    public String getDispimuketriyuunaiyou16() {
        return dispimuketriyuunaiyou16;
    }

    public void setDispimuketriyuunaiyou16(String pDispimuketriyuunaiyou16) {
        dispimuketriyuunaiyou16 = pDispimuketriyuunaiyou16;
    }

    private String dispimusyoubyoucd16;

    public String getDispimusyoubyoucd16() {
        return dispimusyoubyoucd16;
    }

    public void setDispimusyoubyoucd16(String pDispimusyoubyoucd16) {
        dispimusyoubyoucd16 = pDispimusyoubyoucd16;
    }

    private String dispimusyoubyounm16;

    public String getDispimusyoubyounm16() {
        return dispimusyoubyounm16;
    }

    public void setDispimusyoubyounm16(String pDispimusyoubyounm16) {
        dispimusyoubyounm16 = pDispimusyoubyounm16;
    }

    private String dispimuketriyuucd26;

    public String getDispimuketriyuucd26() {
        return dispimuketriyuucd26;
    }

    public void setDispimuketriyuucd26(String pDispimuketriyuucd26) {
        dispimuketriyuucd26 = pDispimuketriyuucd26;
    }

    private String dispimuketriyuunaiyou26;

    public String getDispimuketriyuunaiyou26() {
        return dispimuketriyuunaiyou26;
    }

    public void setDispimuketriyuunaiyou26(String pDispimuketriyuunaiyou26) {
        dispimuketriyuunaiyou26 = pDispimuketriyuunaiyou26;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai16;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai16() {
        return dispimusyoubyoujyoutai16;
    }

    public void setDispimusyoubyoujyoutai16(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai16) {
        dispimusyoubyoujyoutai16 = pDispimusyoubyoujyoutai16;
    }

    private BizDateYM dispimukantiym16;

    public BizDateYM getDispimukantiym16() {
        return dispimukantiym16;
    }

    public void setDispimukantiym16(BizDateYM pDispimukantiym16) {
        dispimukantiym16 = pDispimukantiym16;
    }

    private String dispimuketriyuucd36;

    public String getDispimuketriyuucd36() {
        return dispimuketriyuucd36;
    }

    public void setDispimuketriyuucd36(String pDispimuketriyuucd36) {
        dispimuketriyuucd36 = pDispimuketriyuucd36;
    }

    private String dispimuketriyuunaiyou36;

    public String getDispimuketriyuunaiyou36() {
        return dispimuketriyuunaiyou36;
    }

    public void setDispimuketriyuunaiyou36(String pDispimuketriyuunaiyou36) {
        dispimuketriyuunaiyou36 = pDispimuketriyuunaiyou36;
    }

    private String dispimusyoubyoucd26;

    public String getDispimusyoubyoucd26() {
        return dispimusyoubyoucd26;
    }

    public void setDispimusyoubyoucd26(String pDispimusyoubyoucd26) {
        dispimusyoubyoucd26 = pDispimusyoubyoucd26;
    }

    private String dispimusyoubyounm26;

    public String getDispimusyoubyounm26() {
        return dispimusyoubyounm26;
    }

    public void setDispimusyoubyounm26(String pDispimusyoubyounm26) {
        dispimusyoubyounm26 = pDispimusyoubyounm26;
    }

    private String dispimuketriyuucd46;

    public String getDispimuketriyuucd46() {
        return dispimuketriyuucd46;
    }

    public void setDispimuketriyuucd46(String pDispimuketriyuucd46) {
        dispimuketriyuucd46 = pDispimuketriyuucd46;
    }

    private String dispimuketriyuunaiyou46;

    public String getDispimuketriyuunaiyou46() {
        return dispimuketriyuunaiyou46;
    }

    public void setDispimuketriyuunaiyou46(String pDispimuketriyuunaiyou46) {
        dispimuketriyuunaiyou46 = pDispimuketriyuunaiyou46;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai26;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai26() {
        return dispimusyoubyoujyoutai26;
    }

    public void setDispimusyoubyoujyoutai26(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai26) {
        dispimusyoubyoujyoutai26 = pDispimusyoubyoujyoutai26;
    }

    private BizDateYM dispimukantiym26;

    public BizDateYM getDispimukantiym26() {
        return dispimukantiym26;
    }

    public void setDispimukantiym26(BizDateYM pDispimukantiym26) {
        dispimukantiym26 = pDispimukantiym26;
    }

    private BizDate dispimusyoriymd7;

    public BizDate getDispimusyoriymd7() {
        return dispimusyoriymd7;
    }

    public void setDispimusyoriymd7(BizDate pDispimusyoriymd7) {
        dispimusyoriymd7 = pDispimusyoriymd7;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn7;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn7() {
        return dispimustktsyorinmkbn7;
    }

    public void setDispimustktsyorinmkbn7(C_SateiketsyorinmKbn pDispimustktsyorinmkbn7) {
        dispimustktsyorinmkbn7 = pDispimustktsyorinmkbn7;
    }

    private C_SyorikekkaKbn dispimukekkakbn7;

    public C_SyorikekkaKbn getDispimukekkakbn7() {
        return dispimukekkakbn7;
    }

    public void setDispimukekkakbn7(C_SyorikekkaKbn pDispimukekkakbn7) {
        dispimukekkakbn7 = pDispimukekkakbn7;
    }

    private String dispimutns7;

    public String getDispimutns7() {
        return dispimutns7;
    }

    public void setDispimutns7(String pDispimutns7) {
        dispimutns7 = pDispimutns7;
    }

    private String dispimuktnm7;

    public String getDispimuktnm7() {
        return dispimuktnm7;
    }

    public void setDispimuktnm7(String pDispimuktnm7) {
        dispimuktnm7 = pDispimuktnm7;
    }

    private String dispimucomment7;

    public String getDispimucomment7() {
        return dispimucomment7;
    }

    public void setDispimucomment7(String pDispimucomment7) {
        dispimucomment7 = pDispimucomment7;
    }

    private C_Ketkekkacd dispimuketkekkacd7;

    public C_Ketkekkacd getDispimuketkekkacd7() {
        return dispimuketkekkacd7;
    }

    public void setDispimuketkekkacd7(C_Ketkekkacd pDispimuketkekkacd7) {
        dispimuketkekkacd7 = pDispimuketkekkacd7;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh7;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh7() {
        return dispimusntksakuseiyh7;
    }

    public void setDispimusntksakuseiyh7(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh7) {
        dispimusntksakuseiyh7 = pDispimusntksakuseiyh7;
    }

    private String dispimuketriyuucd17;

    public String getDispimuketriyuucd17() {
        return dispimuketriyuucd17;
    }

    public void setDispimuketriyuucd17(String pDispimuketriyuucd17) {
        dispimuketriyuucd17 = pDispimuketriyuucd17;
    }

    private String dispimuketriyuunaiyou17;

    public String getDispimuketriyuunaiyou17() {
        return dispimuketriyuunaiyou17;
    }

    public void setDispimuketriyuunaiyou17(String pDispimuketriyuunaiyou17) {
        dispimuketriyuunaiyou17 = pDispimuketriyuunaiyou17;
    }

    private String dispimusyoubyoucd17;

    public String getDispimusyoubyoucd17() {
        return dispimusyoubyoucd17;
    }

    public void setDispimusyoubyoucd17(String pDispimusyoubyoucd17) {
        dispimusyoubyoucd17 = pDispimusyoubyoucd17;
    }

    private String dispimusyoubyounm17;

    public String getDispimusyoubyounm17() {
        return dispimusyoubyounm17;
    }

    public void setDispimusyoubyounm17(String pDispimusyoubyounm17) {
        dispimusyoubyounm17 = pDispimusyoubyounm17;
    }

    private String dispimuketriyuucd27;

    public String getDispimuketriyuucd27() {
        return dispimuketriyuucd27;
    }

    public void setDispimuketriyuucd27(String pDispimuketriyuucd27) {
        dispimuketriyuucd27 = pDispimuketriyuucd27;
    }

    private String dispimuketriyuunaiyou27;

    public String getDispimuketriyuunaiyou27() {
        return dispimuketriyuunaiyou27;
    }

    public void setDispimuketriyuunaiyou27(String pDispimuketriyuunaiyou27) {
        dispimuketriyuunaiyou27 = pDispimuketriyuunaiyou27;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai17;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai17() {
        return dispimusyoubyoujyoutai17;
    }

    public void setDispimusyoubyoujyoutai17(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai17) {
        dispimusyoubyoujyoutai17 = pDispimusyoubyoujyoutai17;
    }

    private BizDateYM dispimukantiym17;

    public BizDateYM getDispimukantiym17() {
        return dispimukantiym17;
    }

    public void setDispimukantiym17(BizDateYM pDispimukantiym17) {
        dispimukantiym17 = pDispimukantiym17;
    }

    private String dispimuketriyuucd37;

    public String getDispimuketriyuucd37() {
        return dispimuketriyuucd37;
    }

    public void setDispimuketriyuucd37(String pDispimuketriyuucd37) {
        dispimuketriyuucd37 = pDispimuketriyuucd37;
    }

    private String dispimuketriyuunaiyou37;

    public String getDispimuketriyuunaiyou37() {
        return dispimuketriyuunaiyou37;
    }

    public void setDispimuketriyuunaiyou37(String pDispimuketriyuunaiyou37) {
        dispimuketriyuunaiyou37 = pDispimuketriyuunaiyou37;
    }

    private String dispimusyoubyoucd27;

    public String getDispimusyoubyoucd27() {
        return dispimusyoubyoucd27;
    }

    public void setDispimusyoubyoucd27(String pDispimusyoubyoucd27) {
        dispimusyoubyoucd27 = pDispimusyoubyoucd27;
    }

    private String dispimusyoubyounm27;

    public String getDispimusyoubyounm27() {
        return dispimusyoubyounm27;
    }

    public void setDispimusyoubyounm27(String pDispimusyoubyounm27) {
        dispimusyoubyounm27 = pDispimusyoubyounm27;
    }

    private String dispimuketriyuucd47;

    public String getDispimuketriyuucd47() {
        return dispimuketriyuucd47;
    }

    public void setDispimuketriyuucd47(String pDispimuketriyuucd47) {
        dispimuketriyuucd47 = pDispimuketriyuucd47;
    }

    private String dispimuketriyuunaiyou47;

    public String getDispimuketriyuunaiyou47() {
        return dispimuketriyuunaiyou47;
    }

    public void setDispimuketriyuunaiyou47(String pDispimuketriyuunaiyou47) {
        dispimuketriyuunaiyou47 = pDispimuketriyuunaiyou47;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai27;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai27() {
        return dispimusyoubyoujyoutai27;
    }

    public void setDispimusyoubyoujyoutai27(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai27) {
        dispimusyoubyoujyoutai27 = pDispimusyoubyoujyoutai27;
    }

    private BizDateYM dispimukantiym27;

    public BizDateYM getDispimukantiym27() {
        return dispimukantiym27;
    }

    public void setDispimukantiym27(BizDateYM pDispimukantiym27) {
        dispimukantiym27 = pDispimukantiym27;
    }

    private BizDate dispimusyoriymd8;

    public BizDate getDispimusyoriymd8() {
        return dispimusyoriymd8;
    }

    public void setDispimusyoriymd8(BizDate pDispimusyoriymd8) {
        dispimusyoriymd8 = pDispimusyoriymd8;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn8;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn8() {
        return dispimustktsyorinmkbn8;
    }

    public void setDispimustktsyorinmkbn8(C_SateiketsyorinmKbn pDispimustktsyorinmkbn8) {
        dispimustktsyorinmkbn8 = pDispimustktsyorinmkbn8;
    }

    private C_SyorikekkaKbn dispimukekkakbn8;

    public C_SyorikekkaKbn getDispimukekkakbn8() {
        return dispimukekkakbn8;
    }

    public void setDispimukekkakbn8(C_SyorikekkaKbn pDispimukekkakbn8) {
        dispimukekkakbn8 = pDispimukekkakbn8;
    }

    private String dispimutns8;

    public String getDispimutns8() {
        return dispimutns8;
    }

    public void setDispimutns8(String pDispimutns8) {
        dispimutns8 = pDispimutns8;
    }

    private String dispimuktnm8;

    public String getDispimuktnm8() {
        return dispimuktnm8;
    }

    public void setDispimuktnm8(String pDispimuktnm8) {
        dispimuktnm8 = pDispimuktnm8;
    }

    private String dispimucomment8;

    public String getDispimucomment8() {
        return dispimucomment8;
    }

    public void setDispimucomment8(String pDispimucomment8) {
        dispimucomment8 = pDispimucomment8;
    }

    private C_Ketkekkacd dispimuketkekkacd8;

    public C_Ketkekkacd getDispimuketkekkacd8() {
        return dispimuketkekkacd8;
    }

    public void setDispimuketkekkacd8(C_Ketkekkacd pDispimuketkekkacd8) {
        dispimuketkekkacd8 = pDispimuketkekkacd8;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh8;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh8() {
        return dispimusntksakuseiyh8;
    }

    public void setDispimusntksakuseiyh8(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh8) {
        dispimusntksakuseiyh8 = pDispimusntksakuseiyh8;
    }

    private String dispimuketriyuucd18;

    public String getDispimuketriyuucd18() {
        return dispimuketriyuucd18;
    }

    public void setDispimuketriyuucd18(String pDispimuketriyuucd18) {
        dispimuketriyuucd18 = pDispimuketriyuucd18;
    }

    private String dispimuketriyuunaiyou18;

    public String getDispimuketriyuunaiyou18() {
        return dispimuketriyuunaiyou18;
    }

    public void setDispimuketriyuunaiyou18(String pDispimuketriyuunaiyou18) {
        dispimuketriyuunaiyou18 = pDispimuketriyuunaiyou18;
    }

    private String dispimusyoubyoucd18;

    public String getDispimusyoubyoucd18() {
        return dispimusyoubyoucd18;
    }

    public void setDispimusyoubyoucd18(String pDispimusyoubyoucd18) {
        dispimusyoubyoucd18 = pDispimusyoubyoucd18;
    }

    private String dispimusyoubyounm18;

    public String getDispimusyoubyounm18() {
        return dispimusyoubyounm18;
    }

    public void setDispimusyoubyounm18(String pDispimusyoubyounm18) {
        dispimusyoubyounm18 = pDispimusyoubyounm18;
    }

    private String dispimuketriyuucd28;

    public String getDispimuketriyuucd28() {
        return dispimuketriyuucd28;
    }

    public void setDispimuketriyuucd28(String pDispimuketriyuucd28) {
        dispimuketriyuucd28 = pDispimuketriyuucd28;
    }

    private String dispimuketriyuunaiyou28;

    public String getDispimuketriyuunaiyou28() {
        return dispimuketriyuunaiyou28;
    }

    public void setDispimuketriyuunaiyou28(String pDispimuketriyuunaiyou28) {
        dispimuketriyuunaiyou28 = pDispimuketriyuunaiyou28;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai18;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai18() {
        return dispimusyoubyoujyoutai18;
    }

    public void setDispimusyoubyoujyoutai18(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai18) {
        dispimusyoubyoujyoutai18 = pDispimusyoubyoujyoutai18;
    }

    private BizDateYM dispimukantiym18;

    public BizDateYM getDispimukantiym18() {
        return dispimukantiym18;
    }

    public void setDispimukantiym18(BizDateYM pDispimukantiym18) {
        dispimukantiym18 = pDispimukantiym18;
    }

    private String dispimuketriyuucd38;

    public String getDispimuketriyuucd38() {
        return dispimuketriyuucd38;
    }

    public void setDispimuketriyuucd38(String pDispimuketriyuucd38) {
        dispimuketriyuucd38 = pDispimuketriyuucd38;
    }

    private String dispimuketriyuunaiyou38;

    public String getDispimuketriyuunaiyou38() {
        return dispimuketriyuunaiyou38;
    }

    public void setDispimuketriyuunaiyou38(String pDispimuketriyuunaiyou38) {
        dispimuketriyuunaiyou38 = pDispimuketriyuunaiyou38;
    }

    private String dispimusyoubyoucd28;

    public String getDispimusyoubyoucd28() {
        return dispimusyoubyoucd28;
    }

    public void setDispimusyoubyoucd28(String pDispimusyoubyoucd28) {
        dispimusyoubyoucd28 = pDispimusyoubyoucd28;
    }

    private String dispimusyoubyounm28;

    public String getDispimusyoubyounm28() {
        return dispimusyoubyounm28;
    }

    public void setDispimusyoubyounm28(String pDispimusyoubyounm28) {
        dispimusyoubyounm28 = pDispimusyoubyounm28;
    }

    private String dispimuketriyuucd48;

    public String getDispimuketriyuucd48() {
        return dispimuketriyuucd48;
    }

    public void setDispimuketriyuucd48(String pDispimuketriyuucd48) {
        dispimuketriyuucd48 = pDispimuketriyuucd48;
    }

    private String dispimuketriyuunaiyou48;

    public String getDispimuketriyuunaiyou48() {
        return dispimuketriyuunaiyou48;
    }

    public void setDispimuketriyuunaiyou48(String pDispimuketriyuunaiyou48) {
        dispimuketriyuunaiyou48 = pDispimuketriyuunaiyou48;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai28;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai28() {
        return dispimusyoubyoujyoutai28;
    }

    public void setDispimusyoubyoujyoutai28(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai28) {
        dispimusyoubyoujyoutai28 = pDispimusyoubyoujyoutai28;
    }

    private BizDateYM dispimukantiym28;

    public BizDateYM getDispimukantiym28() {
        return dispimukantiym28;
    }

    public void setDispimukantiym28(BizDateYM pDispimukantiym28) {
        dispimukantiym28 = pDispimukantiym28;
    }

    private BizDate dispimusyoriymd9;

    public BizDate getDispimusyoriymd9() {
        return dispimusyoriymd9;
    }

    public void setDispimusyoriymd9(BizDate pDispimusyoriymd9) {
        dispimusyoriymd9 = pDispimusyoriymd9;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn9;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn9() {
        return dispimustktsyorinmkbn9;
    }

    public void setDispimustktsyorinmkbn9(C_SateiketsyorinmKbn pDispimustktsyorinmkbn9) {
        dispimustktsyorinmkbn9 = pDispimustktsyorinmkbn9;
    }

    private C_SyorikekkaKbn dispimukekkakbn9;

    public C_SyorikekkaKbn getDispimukekkakbn9() {
        return dispimukekkakbn9;
    }

    public void setDispimukekkakbn9(C_SyorikekkaKbn pDispimukekkakbn9) {
        dispimukekkakbn9 = pDispimukekkakbn9;
    }

    private String dispimutns9;

    public String getDispimutns9() {
        return dispimutns9;
    }

    public void setDispimutns9(String pDispimutns9) {
        dispimutns9 = pDispimutns9;
    }

    private String dispimuktnm9;

    public String getDispimuktnm9() {
        return dispimuktnm9;
    }

    public void setDispimuktnm9(String pDispimuktnm9) {
        dispimuktnm9 = pDispimuktnm9;
    }

    private String dispimucomment9;

    public String getDispimucomment9() {
        return dispimucomment9;
    }

    public void setDispimucomment9(String pDispimucomment9) {
        dispimucomment9 = pDispimucomment9;
    }

    private C_Ketkekkacd dispimuketkekkacd9;

    public C_Ketkekkacd getDispimuketkekkacd9() {
        return dispimuketkekkacd9;
    }

    public void setDispimuketkekkacd9(C_Ketkekkacd pDispimuketkekkacd9) {
        dispimuketkekkacd9 = pDispimuketkekkacd9;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh9;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh9() {
        return dispimusntksakuseiyh9;
    }

    public void setDispimusntksakuseiyh9(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh9) {
        dispimusntksakuseiyh9 = pDispimusntksakuseiyh9;
    }

    private String dispimuketriyuucd19;

    public String getDispimuketriyuucd19() {
        return dispimuketriyuucd19;
    }

    public void setDispimuketriyuucd19(String pDispimuketriyuucd19) {
        dispimuketriyuucd19 = pDispimuketriyuucd19;
    }

    private String dispimuketriyuunaiyou19;

    public String getDispimuketriyuunaiyou19() {
        return dispimuketriyuunaiyou19;
    }

    public void setDispimuketriyuunaiyou19(String pDispimuketriyuunaiyou19) {
        dispimuketriyuunaiyou19 = pDispimuketriyuunaiyou19;
    }

    private String dispimusyoubyoucd19;

    public String getDispimusyoubyoucd19() {
        return dispimusyoubyoucd19;
    }

    public void setDispimusyoubyoucd19(String pDispimusyoubyoucd19) {
        dispimusyoubyoucd19 = pDispimusyoubyoucd19;
    }

    private String dispimusyoubyounm19;

    public String getDispimusyoubyounm19() {
        return dispimusyoubyounm19;
    }

    public void setDispimusyoubyounm19(String pDispimusyoubyounm19) {
        dispimusyoubyounm19 = pDispimusyoubyounm19;
    }

    private String dispimuketriyuucd29;

    public String getDispimuketriyuucd29() {
        return dispimuketriyuucd29;
    }

    public void setDispimuketriyuucd29(String pDispimuketriyuucd29) {
        dispimuketriyuucd29 = pDispimuketriyuucd29;
    }

    private String dispimuketriyuunaiyou29;

    public String getDispimuketriyuunaiyou29() {
        return dispimuketriyuunaiyou29;
    }

    public void setDispimuketriyuunaiyou29(String pDispimuketriyuunaiyou29) {
        dispimuketriyuunaiyou29 = pDispimuketriyuunaiyou29;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai19;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai19() {
        return dispimusyoubyoujyoutai19;
    }

    public void setDispimusyoubyoujyoutai19(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai19) {
        dispimusyoubyoujyoutai19 = pDispimusyoubyoujyoutai19;
    }

    private BizDateYM dispimukantiym19;

    public BizDateYM getDispimukantiym19() {
        return dispimukantiym19;
    }

    public void setDispimukantiym19(BizDateYM pDispimukantiym19) {
        dispimukantiym19 = pDispimukantiym19;
    }

    private String dispimuketriyuucd39;

    public String getDispimuketriyuucd39() {
        return dispimuketriyuucd39;
    }

    public void setDispimuketriyuucd39(String pDispimuketriyuucd39) {
        dispimuketriyuucd39 = pDispimuketriyuucd39;
    }

    private String dispimuketriyuunaiyou39;

    public String getDispimuketriyuunaiyou39() {
        return dispimuketriyuunaiyou39;
    }

    public void setDispimuketriyuunaiyou39(String pDispimuketriyuunaiyou39) {
        dispimuketriyuunaiyou39 = pDispimuketriyuunaiyou39;
    }

    private String dispimusyoubyoucd29;

    public String getDispimusyoubyoucd29() {
        return dispimusyoubyoucd29;
    }

    public void setDispimusyoubyoucd29(String pDispimusyoubyoucd29) {
        dispimusyoubyoucd29 = pDispimusyoubyoucd29;
    }

    private String dispimusyoubyounm29;

    public String getDispimusyoubyounm29() {
        return dispimusyoubyounm29;
    }

    public void setDispimusyoubyounm29(String pDispimusyoubyounm29) {
        dispimusyoubyounm29 = pDispimusyoubyounm29;
    }

    private String dispimuketriyuucd49;

    public String getDispimuketriyuucd49() {
        return dispimuketriyuucd49;
    }

    public void setDispimuketriyuucd49(String pDispimuketriyuucd49) {
        dispimuketriyuucd49 = pDispimuketriyuucd49;
    }

    private String dispimuketriyuunaiyou49;

    public String getDispimuketriyuunaiyou49() {
        return dispimuketriyuunaiyou49;
    }

    public void setDispimuketriyuunaiyou49(String pDispimuketriyuunaiyou49) {
        dispimuketriyuunaiyou49 = pDispimuketriyuunaiyou49;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai29;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai29() {
        return dispimusyoubyoujyoutai29;
    }

    public void setDispimusyoubyoujyoutai29(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai29) {
        dispimusyoubyoujyoutai29 = pDispimusyoubyoujyoutai29;
    }

    private BizDateYM dispimukantiym29;

    public BizDateYM getDispimukantiym29() {
        return dispimukantiym29;
    }

    public void setDispimukantiym29(BizDateYM pDispimukantiym29) {
        dispimukantiym29 = pDispimukantiym29;
    }

    private BizDate dispimusyoriymd10;

    public BizDate getDispimusyoriymd10() {
        return dispimusyoriymd10;
    }

    public void setDispimusyoriymd10(BizDate pDispimusyoriymd10) {
        dispimusyoriymd10 = pDispimusyoriymd10;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn10;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn10() {
        return dispimustktsyorinmkbn10;
    }

    public void setDispimustktsyorinmkbn10(C_SateiketsyorinmKbn pDispimustktsyorinmkbn10) {
        dispimustktsyorinmkbn10 = pDispimustktsyorinmkbn10;
    }

    private C_SyorikekkaKbn dispimukekkakbn10;

    public C_SyorikekkaKbn getDispimukekkakbn10() {
        return dispimukekkakbn10;
    }

    public void setDispimukekkakbn10(C_SyorikekkaKbn pDispimukekkakbn10) {
        dispimukekkakbn10 = pDispimukekkakbn10;
    }

    private String dispimutns10;

    public String getDispimutns10() {
        return dispimutns10;
    }

    public void setDispimutns10(String pDispimutns10) {
        dispimutns10 = pDispimutns10;
    }

    private String dispimuktnm10;

    public String getDispimuktnm10() {
        return dispimuktnm10;
    }

    public void setDispimuktnm10(String pDispimuktnm10) {
        dispimuktnm10 = pDispimuktnm10;
    }

    private String dispimucomment10;

    public String getDispimucomment10() {
        return dispimucomment10;
    }

    public void setDispimucomment10(String pDispimucomment10) {
        dispimucomment10 = pDispimucomment10;
    }

    private C_Ketkekkacd dispimuketkekkacd10;

    public C_Ketkekkacd getDispimuketkekkacd10() {
        return dispimuketkekkacd10;
    }

    public void setDispimuketkekkacd10(C_Ketkekkacd pDispimuketkekkacd10) {
        dispimuketkekkacd10 = pDispimuketkekkacd10;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh10;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh10() {
        return dispimusntksakuseiyh10;
    }

    public void setDispimusntksakuseiyh10(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh10) {
        dispimusntksakuseiyh10 = pDispimusntksakuseiyh10;
    }

    private String dispimuketriyuucd110;

    public String getDispimuketriyuucd110() {
        return dispimuketriyuucd110;
    }

    public void setDispimuketriyuucd110(String pDispimuketriyuucd110) {
        dispimuketriyuucd110 = pDispimuketriyuucd110;
    }

    private String dispimuketriyuunaiyou110;

    public String getDispimuketriyuunaiyou110() {
        return dispimuketriyuunaiyou110;
    }

    public void setDispimuketriyuunaiyou110(String pDispimuketriyuunaiyou110) {
        dispimuketriyuunaiyou110 = pDispimuketriyuunaiyou110;
    }

    private String dispimusyoubyoucd110;

    public String getDispimusyoubyoucd110() {
        return dispimusyoubyoucd110;
    }

    public void setDispimusyoubyoucd110(String pDispimusyoubyoucd110) {
        dispimusyoubyoucd110 = pDispimusyoubyoucd110;
    }

    private String dispimusyoubyounm110;

    public String getDispimusyoubyounm110() {
        return dispimusyoubyounm110;
    }

    public void setDispimusyoubyounm110(String pDispimusyoubyounm110) {
        dispimusyoubyounm110 = pDispimusyoubyounm110;
    }

    private String dispimuketriyuucd210;

    public String getDispimuketriyuucd210() {
        return dispimuketriyuucd210;
    }

    public void setDispimuketriyuucd210(String pDispimuketriyuucd210) {
        dispimuketriyuucd210 = pDispimuketriyuucd210;
    }

    private String dispimuketriyuunaiyou210;

    public String getDispimuketriyuunaiyou210() {
        return dispimuketriyuunaiyou210;
    }

    public void setDispimuketriyuunaiyou210(String pDispimuketriyuunaiyou210) {
        dispimuketriyuunaiyou210 = pDispimuketriyuunaiyou210;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai110;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai110() {
        return dispimusyoubyoujyoutai110;
    }

    public void setDispimusyoubyoujyoutai110(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai110) {
        dispimusyoubyoujyoutai110 = pDispimusyoubyoujyoutai110;
    }

    private BizDateYM dispimukantiym110;

    public BizDateYM getDispimukantiym110() {
        return dispimukantiym110;
    }

    public void setDispimukantiym110(BizDateYM pDispimukantiym110) {
        dispimukantiym110 = pDispimukantiym110;
    }

    private String dispimuketriyuucd310;

    public String getDispimuketriyuucd310() {
        return dispimuketriyuucd310;
    }

    public void setDispimuketriyuucd310(String pDispimuketriyuucd310) {
        dispimuketriyuucd310 = pDispimuketriyuucd310;
    }

    private String dispimuketriyuunaiyou310;

    public String getDispimuketriyuunaiyou310() {
        return dispimuketriyuunaiyou310;
    }

    public void setDispimuketriyuunaiyou310(String pDispimuketriyuunaiyou310) {
        dispimuketriyuunaiyou310 = pDispimuketriyuunaiyou310;
    }

    private String dispimusyoubyoucd210;

    public String getDispimusyoubyoucd210() {
        return dispimusyoubyoucd210;
    }

    public void setDispimusyoubyoucd210(String pDispimusyoubyoucd210) {
        dispimusyoubyoucd210 = pDispimusyoubyoucd210;
    }

    private String dispimusyoubyounm210;

    public String getDispimusyoubyounm210() {
        return dispimusyoubyounm210;
    }

    public void setDispimusyoubyounm210(String pDispimusyoubyounm210) {
        dispimusyoubyounm210 = pDispimusyoubyounm210;
    }

    private String dispimuketriyuucd410;

    public String getDispimuketriyuucd410() {
        return dispimuketriyuucd410;
    }

    public void setDispimuketriyuucd410(String pDispimuketriyuucd410) {
        dispimuketriyuucd410 = pDispimuketriyuucd410;
    }

    private String dispimuketriyuunaiyou410;

    public String getDispimuketriyuunaiyou410() {
        return dispimuketriyuunaiyou410;
    }

    public void setDispimuketriyuunaiyou410(String pDispimuketriyuunaiyou410) {
        dispimuketriyuunaiyou410 = pDispimuketriyuunaiyou410;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai210;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai210() {
        return dispimusyoubyoujyoutai210;
    }

    public void setDispimusyoubyoujyoutai210(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai210) {
        dispimusyoubyoujyoutai210 = pDispimusyoubyoujyoutai210;
    }

    private BizDateYM dispimukantiym210;

    public BizDateYM getDispimukantiym210() {
        return dispimukantiym210;
    }

    public void setDispimukantiym210(BizDateYM pDispimukantiym210) {
        dispimukantiym210 = pDispimukantiym210;
    }

    private BizDate dispimusyoriymd11;

    public BizDate getDispimusyoriymd11() {
        return dispimusyoriymd11;
    }

    public void setDispimusyoriymd11(BizDate pDispimusyoriymd11) {
        dispimusyoriymd11 = pDispimusyoriymd11;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn11;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn11() {
        return dispimustktsyorinmkbn11;
    }

    public void setDispimustktsyorinmkbn11(C_SateiketsyorinmKbn pDispimustktsyorinmkbn11) {
        dispimustktsyorinmkbn11 = pDispimustktsyorinmkbn11;
    }

    private C_SyorikekkaKbn dispimukekkakbn11;

    public C_SyorikekkaKbn getDispimukekkakbn11() {
        return dispimukekkakbn11;
    }

    public void setDispimukekkakbn11(C_SyorikekkaKbn pDispimukekkakbn11) {
        dispimukekkakbn11 = pDispimukekkakbn11;
    }

    private String dispimutns11;

    public String getDispimutns11() {
        return dispimutns11;
    }

    public void setDispimutns11(String pDispimutns11) {
        dispimutns11 = pDispimutns11;
    }

    private String dispimuktnm11;

    public String getDispimuktnm11() {
        return dispimuktnm11;
    }

    public void setDispimuktnm11(String pDispimuktnm11) {
        dispimuktnm11 = pDispimuktnm11;
    }

    private String dispimucomment11;

    public String getDispimucomment11() {
        return dispimucomment11;
    }

    public void setDispimucomment11(String pDispimucomment11) {
        dispimucomment11 = pDispimucomment11;
    }

    private C_Ketkekkacd dispimuketkekkacd11;

    public C_Ketkekkacd getDispimuketkekkacd11() {
        return dispimuketkekkacd11;
    }

    public void setDispimuketkekkacd11(C_Ketkekkacd pDispimuketkekkacd11) {
        dispimuketkekkacd11 = pDispimuketkekkacd11;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh11;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh11() {
        return dispimusntksakuseiyh11;
    }

    public void setDispimusntksakuseiyh11(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh11) {
        dispimusntksakuseiyh11 = pDispimusntksakuseiyh11;
    }

    private String dispimuketriyuucd111;

    public String getDispimuketriyuucd111() {
        return dispimuketriyuucd111;
    }

    public void setDispimuketriyuucd111(String pDispimuketriyuucd111) {
        dispimuketriyuucd111 = pDispimuketriyuucd111;
    }

    private String dispimuketriyuunaiyou111;

    public String getDispimuketriyuunaiyou111() {
        return dispimuketriyuunaiyou111;
    }

    public void setDispimuketriyuunaiyou111(String pDispimuketriyuunaiyou111) {
        dispimuketriyuunaiyou111 = pDispimuketriyuunaiyou111;
    }

    private String dispimusyoubyoucd111;

    public String getDispimusyoubyoucd111() {
        return dispimusyoubyoucd111;
    }

    public void setDispimusyoubyoucd111(String pDispimusyoubyoucd111) {
        dispimusyoubyoucd111 = pDispimusyoubyoucd111;
    }

    private String dispimusyoubyounm111;

    public String getDispimusyoubyounm111() {
        return dispimusyoubyounm111;
    }

    public void setDispimusyoubyounm111(String pDispimusyoubyounm111) {
        dispimusyoubyounm111 = pDispimusyoubyounm111;
    }

    private String dispimuketriyuucd211;

    public String getDispimuketriyuucd211() {
        return dispimuketriyuucd211;
    }

    public void setDispimuketriyuucd211(String pDispimuketriyuucd211) {
        dispimuketriyuucd211 = pDispimuketriyuucd211;
    }

    private String dispimuketriyuunaiyou211;

    public String getDispimuketriyuunaiyou211() {
        return dispimuketriyuunaiyou211;
    }

    public void setDispimuketriyuunaiyou211(String pDispimuketriyuunaiyou211) {
        dispimuketriyuunaiyou211 = pDispimuketriyuunaiyou211;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai111;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai111() {
        return dispimusyoubyoujyoutai111;
    }

    public void setDispimusyoubyoujyoutai111(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai111) {
        dispimusyoubyoujyoutai111 = pDispimusyoubyoujyoutai111;
    }

    private BizDateYM dispimukantiym111;

    public BizDateYM getDispimukantiym111() {
        return dispimukantiym111;
    }

    public void setDispimukantiym111(BizDateYM pDispimukantiym111) {
        dispimukantiym111 = pDispimukantiym111;
    }

    private String dispimuketriyuucd311;

    public String getDispimuketriyuucd311() {
        return dispimuketriyuucd311;
    }

    public void setDispimuketriyuucd311(String pDispimuketriyuucd311) {
        dispimuketriyuucd311 = pDispimuketriyuucd311;
    }

    private String dispimuketriyuunaiyou311;

    public String getDispimuketriyuunaiyou311() {
        return dispimuketriyuunaiyou311;
    }

    public void setDispimuketriyuunaiyou311(String pDispimuketriyuunaiyou311) {
        dispimuketriyuunaiyou311 = pDispimuketriyuunaiyou311;
    }

    private String dispimusyoubyoucd211;

    public String getDispimusyoubyoucd211() {
        return dispimusyoubyoucd211;
    }

    public void setDispimusyoubyoucd211(String pDispimusyoubyoucd211) {
        dispimusyoubyoucd211 = pDispimusyoubyoucd211;
    }

    private String dispimusyoubyounm211;

    public String getDispimusyoubyounm211() {
        return dispimusyoubyounm211;
    }

    public void setDispimusyoubyounm211(String pDispimusyoubyounm211) {
        dispimusyoubyounm211 = pDispimusyoubyounm211;
    }

    private String dispimuketriyuucd411;

    public String getDispimuketriyuucd411() {
        return dispimuketriyuucd411;
    }

    public void setDispimuketriyuucd411(String pDispimuketriyuucd411) {
        dispimuketriyuucd411 = pDispimuketriyuucd411;
    }

    private String dispimuketriyuunaiyou411;

    public String getDispimuketriyuunaiyou411() {
        return dispimuketriyuunaiyou411;
    }

    public void setDispimuketriyuunaiyou411(String pDispimuketriyuunaiyou411) {
        dispimuketriyuunaiyou411 = pDispimuketriyuunaiyou411;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai211;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai211() {
        return dispimusyoubyoujyoutai211;
    }

    public void setDispimusyoubyoujyoutai211(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai211) {
        dispimusyoubyoujyoutai211 = pDispimusyoubyoujyoutai211;
    }

    private BizDateYM dispimukantiym211;

    public BizDateYM getDispimukantiym211() {
        return dispimukantiym211;
    }

    public void setDispimukantiym211(BizDateYM pDispimukantiym211) {
        dispimukantiym211 = pDispimukantiym211;
    }

    private BizDate dispimusyoriymd12;

    public BizDate getDispimusyoriymd12() {
        return dispimusyoriymd12;
    }

    public void setDispimusyoriymd12(BizDate pDispimusyoriymd12) {
        dispimusyoriymd12 = pDispimusyoriymd12;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn12;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn12() {
        return dispimustktsyorinmkbn12;
    }

    public void setDispimustktsyorinmkbn12(C_SateiketsyorinmKbn pDispimustktsyorinmkbn12) {
        dispimustktsyorinmkbn12 = pDispimustktsyorinmkbn12;
    }

    private C_SyorikekkaKbn dispimukekkakbn12;

    public C_SyorikekkaKbn getDispimukekkakbn12() {
        return dispimukekkakbn12;
    }

    public void setDispimukekkakbn12(C_SyorikekkaKbn pDispimukekkakbn12) {
        dispimukekkakbn12 = pDispimukekkakbn12;
    }

    private String dispimutns12;

    public String getDispimutns12() {
        return dispimutns12;
    }

    public void setDispimutns12(String pDispimutns12) {
        dispimutns12 = pDispimutns12;
    }

    private String dispimuktnm12;

    public String getDispimuktnm12() {
        return dispimuktnm12;
    }

    public void setDispimuktnm12(String pDispimuktnm12) {
        dispimuktnm12 = pDispimuktnm12;
    }

    private String dispimucomment12;

    public String getDispimucomment12() {
        return dispimucomment12;
    }

    public void setDispimucomment12(String pDispimucomment12) {
        dispimucomment12 = pDispimucomment12;
    }

    private C_Ketkekkacd dispimuketkekkacd12;

    public C_Ketkekkacd getDispimuketkekkacd12() {
        return dispimuketkekkacd12;
    }

    public void setDispimuketkekkacd12(C_Ketkekkacd pDispimuketkekkacd12) {
        dispimuketkekkacd12 = pDispimuketkekkacd12;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh12;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh12() {
        return dispimusntksakuseiyh12;
    }

    public void setDispimusntksakuseiyh12(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh12) {
        dispimusntksakuseiyh12 = pDispimusntksakuseiyh12;
    }

    private String dispimuketriyuucd112;

    public String getDispimuketriyuucd112() {
        return dispimuketriyuucd112;
    }

    public void setDispimuketriyuucd112(String pDispimuketriyuucd112) {
        dispimuketriyuucd112 = pDispimuketriyuucd112;
    }

    private String dispimuketriyuunaiyou112;

    public String getDispimuketriyuunaiyou112() {
        return dispimuketriyuunaiyou112;
    }

    public void setDispimuketriyuunaiyou112(String pDispimuketriyuunaiyou112) {
        dispimuketriyuunaiyou112 = pDispimuketriyuunaiyou112;
    }

    private String dispimusyoubyoucd112;

    public String getDispimusyoubyoucd112() {
        return dispimusyoubyoucd112;
    }

    public void setDispimusyoubyoucd112(String pDispimusyoubyoucd112) {
        dispimusyoubyoucd112 = pDispimusyoubyoucd112;
    }

    private String dispimusyoubyounm112;

    public String getDispimusyoubyounm112() {
        return dispimusyoubyounm112;
    }

    public void setDispimusyoubyounm112(String pDispimusyoubyounm112) {
        dispimusyoubyounm112 = pDispimusyoubyounm112;
    }

    private String dispimuketriyuucd212;

    public String getDispimuketriyuucd212() {
        return dispimuketriyuucd212;
    }

    public void setDispimuketriyuucd212(String pDispimuketriyuucd212) {
        dispimuketriyuucd212 = pDispimuketriyuucd212;
    }

    private String dispimuketriyuunaiyou212;

    public String getDispimuketriyuunaiyou212() {
        return dispimuketriyuunaiyou212;
    }

    public void setDispimuketriyuunaiyou212(String pDispimuketriyuunaiyou212) {
        dispimuketriyuunaiyou212 = pDispimuketriyuunaiyou212;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai112;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai112() {
        return dispimusyoubyoujyoutai112;
    }

    public void setDispimusyoubyoujyoutai112(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai112) {
        dispimusyoubyoujyoutai112 = pDispimusyoubyoujyoutai112;
    }

    private BizDateYM dispimukantiym112;

    public BizDateYM getDispimukantiym112() {
        return dispimukantiym112;
    }

    public void setDispimukantiym112(BizDateYM pDispimukantiym112) {
        dispimukantiym112 = pDispimukantiym112;
    }

    private String dispimuketriyuucd312;

    public String getDispimuketriyuucd312() {
        return dispimuketriyuucd312;
    }

    public void setDispimuketriyuucd312(String pDispimuketriyuucd312) {
        dispimuketriyuucd312 = pDispimuketriyuucd312;
    }

    private String dispimuketriyuunaiyou312;

    public String getDispimuketriyuunaiyou312() {
        return dispimuketriyuunaiyou312;
    }

    public void setDispimuketriyuunaiyou312(String pDispimuketriyuunaiyou312) {
        dispimuketriyuunaiyou312 = pDispimuketriyuunaiyou312;
    }

    private String dispimusyoubyoucd212;

    public String getDispimusyoubyoucd212() {
        return dispimusyoubyoucd212;
    }

    public void setDispimusyoubyoucd212(String pDispimusyoubyoucd212) {
        dispimusyoubyoucd212 = pDispimusyoubyoucd212;
    }

    private String dispimusyoubyounm212;

    public String getDispimusyoubyounm212() {
        return dispimusyoubyounm212;
    }

    public void setDispimusyoubyounm212(String pDispimusyoubyounm212) {
        dispimusyoubyounm212 = pDispimusyoubyounm212;
    }

    private String dispimuketriyuucd412;

    public String getDispimuketriyuucd412() {
        return dispimuketriyuucd412;
    }

    public void setDispimuketriyuucd412(String pDispimuketriyuucd412) {
        dispimuketriyuucd412 = pDispimuketriyuucd412;
    }

    private String dispimuketriyuunaiyou412;

    public String getDispimuketriyuunaiyou412() {
        return dispimuketriyuunaiyou412;
    }

    public void setDispimuketriyuunaiyou412(String pDispimuketriyuunaiyou412) {
        dispimuketriyuunaiyou412 = pDispimuketriyuunaiyou412;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai212;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai212() {
        return dispimusyoubyoujyoutai212;
    }

    public void setDispimusyoubyoujyoutai212(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai212) {
        dispimusyoubyoujyoutai212 = pDispimusyoubyoujyoutai212;
    }

    private BizDateYM dispimukantiym212;

    public BizDateYM getDispimukantiym212() {
        return dispimukantiym212;
    }

    public void setDispimukantiym212(BizDateYM pDispimukantiym212) {
        dispimukantiym212 = pDispimukantiym212;
    }

    private BizDate dispimusyoriymd13;

    public BizDate getDispimusyoriymd13() {
        return dispimusyoriymd13;
    }

    public void setDispimusyoriymd13(BizDate pDispimusyoriymd13) {
        dispimusyoriymd13 = pDispimusyoriymd13;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn13;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn13() {
        return dispimustktsyorinmkbn13;
    }

    public void setDispimustktsyorinmkbn13(C_SateiketsyorinmKbn pDispimustktsyorinmkbn13) {
        dispimustktsyorinmkbn13 = pDispimustktsyorinmkbn13;
    }

    private C_SyorikekkaKbn dispimukekkakbn13;

    public C_SyorikekkaKbn getDispimukekkakbn13() {
        return dispimukekkakbn13;
    }

    public void setDispimukekkakbn13(C_SyorikekkaKbn pDispimukekkakbn13) {
        dispimukekkakbn13 = pDispimukekkakbn13;
    }

    private String dispimutns13;

    public String getDispimutns13() {
        return dispimutns13;
    }

    public void setDispimutns13(String pDispimutns13) {
        dispimutns13 = pDispimutns13;
    }

    private String dispimuktnm13;

    public String getDispimuktnm13() {
        return dispimuktnm13;
    }

    public void setDispimuktnm13(String pDispimuktnm13) {
        dispimuktnm13 = pDispimuktnm13;
    }

    private String dispimucomment13;

    public String getDispimucomment13() {
        return dispimucomment13;
    }

    public void setDispimucomment13(String pDispimucomment13) {
        dispimucomment13 = pDispimucomment13;
    }

    private C_Ketkekkacd dispimuketkekkacd13;

    public C_Ketkekkacd getDispimuketkekkacd13() {
        return dispimuketkekkacd13;
    }

    public void setDispimuketkekkacd13(C_Ketkekkacd pDispimuketkekkacd13) {
        dispimuketkekkacd13 = pDispimuketkekkacd13;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh13;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh13() {
        return dispimusntksakuseiyh13;
    }

    public void setDispimusntksakuseiyh13(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh13) {
        dispimusntksakuseiyh13 = pDispimusntksakuseiyh13;
    }

    private String dispimuketriyuucd113;

    public String getDispimuketriyuucd113() {
        return dispimuketriyuucd113;
    }

    public void setDispimuketriyuucd113(String pDispimuketriyuucd113) {
        dispimuketriyuucd113 = pDispimuketriyuucd113;
    }

    private String dispimuketriyuunaiyou113;

    public String getDispimuketriyuunaiyou113() {
        return dispimuketriyuunaiyou113;
    }

    public void setDispimuketriyuunaiyou113(String pDispimuketriyuunaiyou113) {
        dispimuketriyuunaiyou113 = pDispimuketriyuunaiyou113;
    }

    private String dispimusyoubyoucd113;

    public String getDispimusyoubyoucd113() {
        return dispimusyoubyoucd113;
    }

    public void setDispimusyoubyoucd113(String pDispimusyoubyoucd113) {
        dispimusyoubyoucd113 = pDispimusyoubyoucd113;
    }

    private String dispimusyoubyounm113;

    public String getDispimusyoubyounm113() {
        return dispimusyoubyounm113;
    }

    public void setDispimusyoubyounm113(String pDispimusyoubyounm113) {
        dispimusyoubyounm113 = pDispimusyoubyounm113;
    }

    private String dispimuketriyuucd213;

    public String getDispimuketriyuucd213() {
        return dispimuketriyuucd213;
    }

    public void setDispimuketriyuucd213(String pDispimuketriyuucd213) {
        dispimuketriyuucd213 = pDispimuketriyuucd213;
    }

    private String dispimuketriyuunaiyou213;

    public String getDispimuketriyuunaiyou213() {
        return dispimuketriyuunaiyou213;
    }

    public void setDispimuketriyuunaiyou213(String pDispimuketriyuunaiyou213) {
        dispimuketriyuunaiyou213 = pDispimuketriyuunaiyou213;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai113;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai113() {
        return dispimusyoubyoujyoutai113;
    }

    public void setDispimusyoubyoujyoutai113(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai113) {
        dispimusyoubyoujyoutai113 = pDispimusyoubyoujyoutai113;
    }

    private BizDateYM dispimukantiym113;

    public BizDateYM getDispimukantiym113() {
        return dispimukantiym113;
    }

    public void setDispimukantiym113(BizDateYM pDispimukantiym113) {
        dispimukantiym113 = pDispimukantiym113;
    }

    private String dispimuketriyuucd313;

    public String getDispimuketriyuucd313() {
        return dispimuketriyuucd313;
    }

    public void setDispimuketriyuucd313(String pDispimuketriyuucd313) {
        dispimuketriyuucd313 = pDispimuketriyuucd313;
    }

    private String dispimuketriyuunaiyou313;

    public String getDispimuketriyuunaiyou313() {
        return dispimuketriyuunaiyou313;
    }

    public void setDispimuketriyuunaiyou313(String pDispimuketriyuunaiyou313) {
        dispimuketriyuunaiyou313 = pDispimuketriyuunaiyou313;
    }

    private String dispimusyoubyoucd213;

    public String getDispimusyoubyoucd213() {
        return dispimusyoubyoucd213;
    }

    public void setDispimusyoubyoucd213(String pDispimusyoubyoucd213) {
        dispimusyoubyoucd213 = pDispimusyoubyoucd213;
    }

    private String dispimusyoubyounm213;

    public String getDispimusyoubyounm213() {
        return dispimusyoubyounm213;
    }

    public void setDispimusyoubyounm213(String pDispimusyoubyounm213) {
        dispimusyoubyounm213 = pDispimusyoubyounm213;
    }

    private String dispimuketriyuucd413;

    public String getDispimuketriyuucd413() {
        return dispimuketriyuucd413;
    }

    public void setDispimuketriyuucd413(String pDispimuketriyuucd413) {
        dispimuketriyuucd413 = pDispimuketriyuucd413;
    }

    private String dispimuketriyuunaiyou413;

    public String getDispimuketriyuunaiyou413() {
        return dispimuketriyuunaiyou413;
    }

    public void setDispimuketriyuunaiyou413(String pDispimuketriyuunaiyou413) {
        dispimuketriyuunaiyou413 = pDispimuketriyuunaiyou413;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai213;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai213() {
        return dispimusyoubyoujyoutai213;
    }

    public void setDispimusyoubyoujyoutai213(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai213) {
        dispimusyoubyoujyoutai213 = pDispimusyoubyoujyoutai213;
    }

    private BizDateYM dispimukantiym213;

    public BizDateYM getDispimukantiym213() {
        return dispimukantiym213;
    }

    public void setDispimukantiym213(BizDateYM pDispimukantiym213) {
        dispimukantiym213 = pDispimukantiym213;
    }

    private BizDate dispimusyoriymd14;

    public BizDate getDispimusyoriymd14() {
        return dispimusyoriymd14;
    }

    public void setDispimusyoriymd14(BizDate pDispimusyoriymd14) {
        dispimusyoriymd14 = pDispimusyoriymd14;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn14;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn14() {
        return dispimustktsyorinmkbn14;
    }

    public void setDispimustktsyorinmkbn14(C_SateiketsyorinmKbn pDispimustktsyorinmkbn14) {
        dispimustktsyorinmkbn14 = pDispimustktsyorinmkbn14;
    }

    private C_SyorikekkaKbn dispimukekkakbn14;

    public C_SyorikekkaKbn getDispimukekkakbn14() {
        return dispimukekkakbn14;
    }

    public void setDispimukekkakbn14(C_SyorikekkaKbn pDispimukekkakbn14) {
        dispimukekkakbn14 = pDispimukekkakbn14;
    }

    private String dispimutns14;

    public String getDispimutns14() {
        return dispimutns14;
    }

    public void setDispimutns14(String pDispimutns14) {
        dispimutns14 = pDispimutns14;
    }

    private String dispimuktnm14;

    public String getDispimuktnm14() {
        return dispimuktnm14;
    }

    public void setDispimuktnm14(String pDispimuktnm14) {
        dispimuktnm14 = pDispimuktnm14;
    }

    private String dispimucomment14;

    public String getDispimucomment14() {
        return dispimucomment14;
    }

    public void setDispimucomment14(String pDispimucomment14) {
        dispimucomment14 = pDispimucomment14;
    }

    private C_Ketkekkacd dispimuketkekkacd14;

    public C_Ketkekkacd getDispimuketkekkacd14() {
        return dispimuketkekkacd14;
    }

    public void setDispimuketkekkacd14(C_Ketkekkacd pDispimuketkekkacd14) {
        dispimuketkekkacd14 = pDispimuketkekkacd14;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh14;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh14() {
        return dispimusntksakuseiyh14;
    }

    public void setDispimusntksakuseiyh14(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh14) {
        dispimusntksakuseiyh14 = pDispimusntksakuseiyh14;
    }

    private String dispimuketriyuucd114;

    public String getDispimuketriyuucd114() {
        return dispimuketriyuucd114;
    }

    public void setDispimuketriyuucd114(String pDispimuketriyuucd114) {
        dispimuketriyuucd114 = pDispimuketriyuucd114;
    }

    private String dispimuketriyuunaiyou114;

    public String getDispimuketriyuunaiyou114() {
        return dispimuketriyuunaiyou114;
    }

    public void setDispimuketriyuunaiyou114(String pDispimuketriyuunaiyou114) {
        dispimuketriyuunaiyou114 = pDispimuketriyuunaiyou114;
    }

    private String dispimusyoubyoucd114;

    public String getDispimusyoubyoucd114() {
        return dispimusyoubyoucd114;
    }

    public void setDispimusyoubyoucd114(String pDispimusyoubyoucd114) {
        dispimusyoubyoucd114 = pDispimusyoubyoucd114;
    }

    private String dispimusyoubyounm114;

    public String getDispimusyoubyounm114() {
        return dispimusyoubyounm114;
    }

    public void setDispimusyoubyounm114(String pDispimusyoubyounm114) {
        dispimusyoubyounm114 = pDispimusyoubyounm114;
    }

    private String dispimuketriyuucd214;

    public String getDispimuketriyuucd214() {
        return dispimuketriyuucd214;
    }

    public void setDispimuketriyuucd214(String pDispimuketriyuucd214) {
        dispimuketriyuucd214 = pDispimuketriyuucd214;
    }

    private String dispimuketriyuunaiyou214;

    public String getDispimuketriyuunaiyou214() {
        return dispimuketriyuunaiyou214;
    }

    public void setDispimuketriyuunaiyou214(String pDispimuketriyuunaiyou214) {
        dispimuketriyuunaiyou214 = pDispimuketriyuunaiyou214;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai114;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai114() {
        return dispimusyoubyoujyoutai114;
    }

    public void setDispimusyoubyoujyoutai114(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai114) {
        dispimusyoubyoujyoutai114 = pDispimusyoubyoujyoutai114;
    }

    private BizDateYM dispimukantiym114;

    public BizDateYM getDispimukantiym114() {
        return dispimukantiym114;
    }

    public void setDispimukantiym114(BizDateYM pDispimukantiym114) {
        dispimukantiym114 = pDispimukantiym114;
    }

    private String dispimuketriyuucd314;

    public String getDispimuketriyuucd314() {
        return dispimuketriyuucd314;
    }

    public void setDispimuketriyuucd314(String pDispimuketriyuucd314) {
        dispimuketriyuucd314 = pDispimuketriyuucd314;
    }

    private String dispimuketriyuunaiyou314;

    public String getDispimuketriyuunaiyou314() {
        return dispimuketriyuunaiyou314;
    }

    public void setDispimuketriyuunaiyou314(String pDispimuketriyuunaiyou314) {
        dispimuketriyuunaiyou314 = pDispimuketriyuunaiyou314;
    }

    private String dispimusyoubyoucd214;

    public String getDispimusyoubyoucd214() {
        return dispimusyoubyoucd214;
    }

    public void setDispimusyoubyoucd214(String pDispimusyoubyoucd214) {
        dispimusyoubyoucd214 = pDispimusyoubyoucd214;
    }

    private String dispimusyoubyounm214;

    public String getDispimusyoubyounm214() {
        return dispimusyoubyounm214;
    }

    public void setDispimusyoubyounm214(String pDispimusyoubyounm214) {
        dispimusyoubyounm214 = pDispimusyoubyounm214;
    }

    private String dispimuketriyuucd414;

    public String getDispimuketriyuucd414() {
        return dispimuketriyuucd414;
    }

    public void setDispimuketriyuucd414(String pDispimuketriyuucd414) {
        dispimuketriyuucd414 = pDispimuketriyuucd414;
    }

    private String dispimuketriyuunaiyou414;

    public String getDispimuketriyuunaiyou414() {
        return dispimuketriyuunaiyou414;
    }

    public void setDispimuketriyuunaiyou414(String pDispimuketriyuunaiyou414) {
        dispimuketriyuunaiyou414 = pDispimuketriyuunaiyou414;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai214;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai214() {
        return dispimusyoubyoujyoutai214;
    }

    public void setDispimusyoubyoujyoutai214(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai214) {
        dispimusyoubyoujyoutai214 = pDispimusyoubyoujyoutai214;
    }

    private BizDateYM dispimukantiym214;

    public BizDateYM getDispimukantiym214() {
        return dispimukantiym214;
    }

    public void setDispimukantiym214(BizDateYM pDispimukantiym214) {
        dispimukantiym214 = pDispimukantiym214;
    }

    private BizDate dispimusyoriymd15;

    public BizDate getDispimusyoriymd15() {
        return dispimusyoriymd15;
    }

    public void setDispimusyoriymd15(BizDate pDispimusyoriymd15) {
        dispimusyoriymd15 = pDispimusyoriymd15;
    }

    private C_SateiketsyorinmKbn dispimustktsyorinmkbn15;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn15() {
        return dispimustktsyorinmkbn15;
    }

    public void setDispimustktsyorinmkbn15(C_SateiketsyorinmKbn pDispimustktsyorinmkbn15) {
        dispimustktsyorinmkbn15 = pDispimustktsyorinmkbn15;
    }

    private C_SyorikekkaKbn dispimukekkakbn15;

    public C_SyorikekkaKbn getDispimukekkakbn15() {
        return dispimukekkakbn15;
    }

    public void setDispimukekkakbn15(C_SyorikekkaKbn pDispimukekkakbn15) {
        dispimukekkakbn15 = pDispimukekkakbn15;
    }

    private String dispimutns15;

    public String getDispimutns15() {
        return dispimutns15;
    }

    public void setDispimutns15(String pDispimutns15) {
        dispimutns15 = pDispimutns15;
    }

    private String dispimuktnm15;

    public String getDispimuktnm15() {
        return dispimuktnm15;
    }

    public void setDispimuktnm15(String pDispimuktnm15) {
        dispimuktnm15 = pDispimuktnm15;
    }

    private String dispimucomment15;

    public String getDispimucomment15() {
        return dispimucomment15;
    }

    public void setDispimucomment15(String pDispimucomment15) {
        dispimucomment15 = pDispimucomment15;
    }

    private C_Ketkekkacd dispimuketkekkacd15;

    public C_Ketkekkacd getDispimuketkekkacd15() {
        return dispimuketkekkacd15;
    }

    public void setDispimuketkekkacd15(C_Ketkekkacd pDispimuketkekkacd15) {
        dispimuketkekkacd15 = pDispimuketkekkacd15;
    }

    private C_SntkinfosakuseiyhKbn dispimusntksakuseiyh15;

    public C_SntkinfosakuseiyhKbn getDispimusntksakuseiyh15() {
        return dispimusntksakuseiyh15;
    }

    public void setDispimusntksakuseiyh15(C_SntkinfosakuseiyhKbn pDispimusntksakuseiyh15) {
        dispimusntksakuseiyh15 = pDispimusntksakuseiyh15;
    }

    private String dispimuketriyuucd115;

    public String getDispimuketriyuucd115() {
        return dispimuketriyuucd115;
    }

    public void setDispimuketriyuucd115(String pDispimuketriyuucd115) {
        dispimuketriyuucd115 = pDispimuketriyuucd115;
    }

    private String dispimuketriyuunaiyou115;

    public String getDispimuketriyuunaiyou115() {
        return dispimuketriyuunaiyou115;
    }

    public void setDispimuketriyuunaiyou115(String pDispimuketriyuunaiyou115) {
        dispimuketriyuunaiyou115 = pDispimuketriyuunaiyou115;
    }

    private String dispimusyoubyoucd115;

    public String getDispimusyoubyoucd115() {
        return dispimusyoubyoucd115;
    }

    public void setDispimusyoubyoucd115(String pDispimusyoubyoucd115) {
        dispimusyoubyoucd115 = pDispimusyoubyoucd115;
    }

    private String dispimusyoubyounm115;

    public String getDispimusyoubyounm115() {
        return dispimusyoubyounm115;
    }

    public void setDispimusyoubyounm115(String pDispimusyoubyounm115) {
        dispimusyoubyounm115 = pDispimusyoubyounm115;
    }

    private String dispimuketriyuucd215;

    public String getDispimuketriyuucd215() {
        return dispimuketriyuucd215;
    }

    public void setDispimuketriyuucd215(String pDispimuketriyuucd215) {
        dispimuketriyuucd215 = pDispimuketriyuucd215;
    }

    private String dispimuketriyuunaiyou215;

    public String getDispimuketriyuunaiyou215() {
        return dispimuketriyuunaiyou215;
    }

    public void setDispimuketriyuunaiyou215(String pDispimuketriyuunaiyou215) {
        dispimuketriyuunaiyou215 = pDispimuketriyuunaiyou215;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai115;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai115() {
        return dispimusyoubyoujyoutai115;
    }

    public void setDispimusyoubyoujyoutai115(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai115) {
        dispimusyoubyoujyoutai115 = pDispimusyoubyoujyoutai115;
    }

    private BizDateYM dispimukantiym115;

    public BizDateYM getDispimukantiym115() {
        return dispimukantiym115;
    }

    public void setDispimukantiym115(BizDateYM pDispimukantiym115) {
        dispimukantiym115 = pDispimukantiym115;
    }

    private String dispimuketriyuucd315;

    public String getDispimuketriyuucd315() {
        return dispimuketriyuucd315;
    }

    public void setDispimuketriyuucd315(String pDispimuketriyuucd315) {
        dispimuketriyuucd315 = pDispimuketriyuucd315;
    }

    private String dispimuketriyuunaiyou315;

    public String getDispimuketriyuunaiyou315() {
        return dispimuketriyuunaiyou315;
    }

    public void setDispimuketriyuunaiyou315(String pDispimuketriyuunaiyou315) {
        dispimuketriyuunaiyou315 = pDispimuketriyuunaiyou315;
    }

    private String dispimusyoubyoucd215;

    public String getDispimusyoubyoucd215() {
        return dispimusyoubyoucd215;
    }

    public void setDispimusyoubyoucd215(String pDispimusyoubyoucd215) {
        dispimusyoubyoucd215 = pDispimusyoubyoucd215;
    }

    private String dispimusyoubyounm215;

    public String getDispimusyoubyounm215() {
        return dispimusyoubyounm215;
    }

    public void setDispimusyoubyounm215(String pDispimusyoubyounm215) {
        dispimusyoubyounm215 = pDispimusyoubyounm215;
    }

    private String dispimuketriyuucd415;

    public String getDispimuketriyuucd415() {
        return dispimuketriyuucd415;
    }

    public void setDispimuketriyuucd415(String pDispimuketriyuucd415) {
        dispimuketriyuucd415 = pDispimuketriyuucd415;
    }

    private String dispimuketriyuunaiyou415;

    public String getDispimuketriyuunaiyou415() {
        return dispimuketriyuunaiyou415;
    }

    public void setDispimuketriyuunaiyou415(String pDispimuketriyuunaiyou415) {
        dispimuketriyuunaiyou415 = pDispimuketriyuunaiyou415;
    }

    private C_SyoubyoujyoutaiKbn dispimusyoubyoujyoutai215;

    public C_SyoubyoujyoutaiKbn getDispimusyoubyoujyoutai215() {
        return dispimusyoubyoujyoutai215;
    }

    public void setDispimusyoubyoujyoutai215(C_SyoubyoujyoutaiKbn pDispimusyoubyoujyoutai215) {
        dispimusyoubyoujyoutai215 = pDispimusyoubyoujyoutai215;
    }

    private BizDateYM dispimukantiym215;

    public BizDateYM getDispimukantiym215() {
        return dispimukantiym215;
    }

    public void setDispimukantiym215(BizDateYM pDispimukantiym215) {
        dispimukantiym215 = pDispimukantiym215;
    }

    private Integer disprenno1;

    public Integer getDisprenno1() {
        return disprenno1;
    }

    public void setDisprenno1(Integer pDisprenno1) {
        disprenno1 = pDisprenno1;
    }

    private BizDate dispketymd1;

    public BizDate getDispketymd1() {
        return dispketymd1;
    }

    public void setDispketymd1(BizDate pDispketymd1) {
        dispketymd1 = pDispketymd1;
    }

    private C_Ketkekkacd dispketkekkacd1;

    public C_Ketkekkacd getDispketkekkacd1() {
        return dispketkekkacd1;
    }

    public void setDispketkekkacd1(C_Ketkekkacd pDispketkekkacd1) {
        dispketkekkacd1 = pDispketkekkacd1;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh1;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh1() {
        return dispsntksakuseiyh1;
    }

    public void setDispsntksakuseiyh1(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh1) {
        dispsntksakuseiyh1 = pDispsntksakuseiyh1;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu1;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu1() {
        return disptorikesisyousairiyuu1;
    }

    public void setDisptorikesisyousairiyuu1(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu1) {
        disptorikesisyousairiyuu1 = pDisptorikesisyousairiyuu1;
    }

    private String dispketriyuucd11;

    public String getDispketriyuucd11() {
        return dispketriyuucd11;
    }

    public void setDispketriyuucd11(String pDispketriyuucd11) {
        dispketriyuucd11 = pDispketriyuucd11;
    }

    private String dispketteiriyuunaiyou11;

    public String getDispketteiriyuunaiyou11() {
        return dispketteiriyuunaiyou11;
    }

    public void setDispketteiriyuunaiyou11(String pDispketteiriyuunaiyou11) {
        dispketteiriyuunaiyou11 = pDispketteiriyuunaiyou11;
    }

    private String dispsyoubyoucd11;

    public String getDispsyoubyoucd11() {
        return dispsyoubyoucd11;
    }

    public void setDispsyoubyoucd11(String pDispsyoubyoucd11) {
        dispsyoubyoucd11 = pDispsyoubyoucd11;
    }

    private String dispsyoubyounm11;

    public String getDispsyoubyounm11() {
        return dispsyoubyounm11;
    }

    public void setDispsyoubyounm11(String pDispsyoubyounm11) {
        dispsyoubyounm11 = pDispsyoubyounm11;
    }

    private String dispketriyuucd21;

    public String getDispketriyuucd21() {
        return dispketriyuucd21;
    }

    public void setDispketriyuucd21(String pDispketriyuucd21) {
        dispketriyuucd21 = pDispketriyuucd21;
    }

    private String dispketteiriyuunaiyou21;

    public String getDispketteiriyuunaiyou21() {
        return dispketteiriyuunaiyou21;
    }

    public void setDispketteiriyuunaiyou21(String pDispketteiriyuunaiyou21) {
        dispketteiriyuunaiyou21 = pDispketteiriyuunaiyou21;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai11;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai11() {
        return dispsyoubyoujyoutai11;
    }

    public void setDispsyoubyoujyoutai11(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai11) {
        dispsyoubyoujyoutai11 = pDispsyoubyoujyoutai11;
    }

    private BizDateYM dispkantiym11;

    public BizDateYM getDispkantiym11() {
        return dispkantiym11;
    }

    public void setDispkantiym11(BizDateYM pDispkantiym11) {
        dispkantiym11 = pDispkantiym11;
    }

    private String dispketriyuucd31;

    public String getDispketriyuucd31() {
        return dispketriyuucd31;
    }

    public void setDispketriyuucd31(String pDispketriyuucd31) {
        dispketriyuucd31 = pDispketriyuucd31;
    }

    private String dispketteiriyuunaiyou31;

    public String getDispketteiriyuunaiyou31() {
        return dispketteiriyuunaiyou31;
    }

    public void setDispketteiriyuunaiyou31(String pDispketteiriyuunaiyou31) {
        dispketteiriyuunaiyou31 = pDispketteiriyuunaiyou31;
    }

    private String dispsyoubyoucd21;

    public String getDispsyoubyoucd21() {
        return dispsyoubyoucd21;
    }

    public void setDispsyoubyoucd21(String pDispsyoubyoucd21) {
        dispsyoubyoucd21 = pDispsyoubyoucd21;
    }

    private String dispsyoubyounm21;

    public String getDispsyoubyounm21() {
        return dispsyoubyounm21;
    }

    public void setDispsyoubyounm21(String pDispsyoubyounm21) {
        dispsyoubyounm21 = pDispsyoubyounm21;
    }

    private String dispketriyuucd41;

    public String getDispketriyuucd41() {
        return dispketriyuucd41;
    }

    public void setDispketriyuucd41(String pDispketriyuucd41) {
        dispketriyuucd41 = pDispketriyuucd41;
    }

    private String dispketteiriyuunaiyou41;

    public String getDispketteiriyuunaiyou41() {
        return dispketteiriyuunaiyou41;
    }

    public void setDispketteiriyuunaiyou41(String pDispketteiriyuunaiyou41) {
        dispketteiriyuunaiyou41 = pDispketteiriyuunaiyou41;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai21;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai21() {
        return dispsyoubyoujyoutai21;
    }

    public void setDispsyoubyoujyoutai21(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai21) {
        dispsyoubyoujyoutai21 = pDispsyoubyoujyoutai21;
    }

    private BizDateYM dispkantiym21;

    public BizDateYM getDispkantiym21() {
        return dispkantiym21;
    }

    public void setDispkantiym21(BizDateYM pDispkantiym21) {
        dispkantiym21 = pDispkantiym21;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou1;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou1() {
        return dispmrriyuucdnaiyou1;
    }

    public void setDispmrriyuucdnaiyou1(C_MrRiyuucdKbn pDispmrriyuucdnaiyou1) {
        dispmrriyuucdnaiyou1 = pDispmrriyuucdnaiyou1;
    }

    private Integer disprenno2;

    public Integer getDisprenno2() {
        return disprenno2;
    }

    public void setDisprenno2(Integer pDisprenno2) {
        disprenno2 = pDisprenno2;
    }

    private BizDate dispketymd2;

    public BizDate getDispketymd2() {
        return dispketymd2;
    }

    public void setDispketymd2(BizDate pDispketymd2) {
        dispketymd2 = pDispketymd2;
    }

    private C_Ketkekkacd dispketkekkacd2;

    public C_Ketkekkacd getDispketkekkacd2() {
        return dispketkekkacd2;
    }

    public void setDispketkekkacd2(C_Ketkekkacd pDispketkekkacd2) {
        dispketkekkacd2 = pDispketkekkacd2;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh2;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh2() {
        return dispsntksakuseiyh2;
    }

    public void setDispsntksakuseiyh2(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh2) {
        dispsntksakuseiyh2 = pDispsntksakuseiyh2;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu2;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu2() {
        return disptorikesisyousairiyuu2;
    }

    public void setDisptorikesisyousairiyuu2(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu2) {
        disptorikesisyousairiyuu2 = pDisptorikesisyousairiyuu2;
    }

    private String dispketriyuucd12;

    public String getDispketriyuucd12() {
        return dispketriyuucd12;
    }

    public void setDispketriyuucd12(String pDispketriyuucd12) {
        dispketriyuucd12 = pDispketriyuucd12;
    }

    private String dispketteiriyuunaiyou12;

    public String getDispketteiriyuunaiyou12() {
        return dispketteiriyuunaiyou12;
    }

    public void setDispketteiriyuunaiyou12(String pDispketteiriyuunaiyou12) {
        dispketteiriyuunaiyou12 = pDispketteiriyuunaiyou12;
    }

    private String dispsyoubyoucd12;

    public String getDispsyoubyoucd12() {
        return dispsyoubyoucd12;
    }

    public void setDispsyoubyoucd12(String pDispsyoubyoucd12) {
        dispsyoubyoucd12 = pDispsyoubyoucd12;
    }

    private String dispsyoubyounm12;

    public String getDispsyoubyounm12() {
        return dispsyoubyounm12;
    }

    public void setDispsyoubyounm12(String pDispsyoubyounm12) {
        dispsyoubyounm12 = pDispsyoubyounm12;
    }

    private String dispketriyuucd22;

    public String getDispketriyuucd22() {
        return dispketriyuucd22;
    }

    public void setDispketriyuucd22(String pDispketriyuucd22) {
        dispketriyuucd22 = pDispketriyuucd22;
    }

    private String dispketteiriyuunaiyou22;

    public String getDispketteiriyuunaiyou22() {
        return dispketteiriyuunaiyou22;
    }

    public void setDispketteiriyuunaiyou22(String pDispketteiriyuunaiyou22) {
        dispketteiriyuunaiyou22 = pDispketteiriyuunaiyou22;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai12;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai12() {
        return dispsyoubyoujyoutai12;
    }

    public void setDispsyoubyoujyoutai12(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai12) {
        dispsyoubyoujyoutai12 = pDispsyoubyoujyoutai12;
    }

    private BizDateYM dispkantiym12;

    public BizDateYM getDispkantiym12() {
        return dispkantiym12;
    }

    public void setDispkantiym12(BizDateYM pDispkantiym12) {
        dispkantiym12 = pDispkantiym12;
    }

    private String dispketriyuucd32;

    public String getDispketriyuucd32() {
        return dispketriyuucd32;
    }

    public void setDispketriyuucd32(String pDispketriyuucd32) {
        dispketriyuucd32 = pDispketriyuucd32;
    }

    private String dispketteiriyuunaiyou32;

    public String getDispketteiriyuunaiyou32() {
        return dispketteiriyuunaiyou32;
    }

    public void setDispketteiriyuunaiyou32(String pDispketteiriyuunaiyou32) {
        dispketteiriyuunaiyou32 = pDispketteiriyuunaiyou32;
    }

    private String dispsyoubyoucd22;

    public String getDispsyoubyoucd22() {
        return dispsyoubyoucd22;
    }

    public void setDispsyoubyoucd22(String pDispsyoubyoucd22) {
        dispsyoubyoucd22 = pDispsyoubyoucd22;
    }

    private String dispsyoubyounm22;

    public String getDispsyoubyounm22() {
        return dispsyoubyounm22;
    }

    public void setDispsyoubyounm22(String pDispsyoubyounm22) {
        dispsyoubyounm22 = pDispsyoubyounm22;
    }

    private String dispketriyuucd42;

    public String getDispketriyuucd42() {
        return dispketriyuucd42;
    }

    public void setDispketriyuucd42(String pDispketriyuucd42) {
        dispketriyuucd42 = pDispketriyuucd42;
    }

    private String dispketteiriyuunaiyou42;

    public String getDispketteiriyuunaiyou42() {
        return dispketteiriyuunaiyou42;
    }

    public void setDispketteiriyuunaiyou42(String pDispketteiriyuunaiyou42) {
        dispketteiriyuunaiyou42 = pDispketteiriyuunaiyou42;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai22;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai22() {
        return dispsyoubyoujyoutai22;
    }

    public void setDispsyoubyoujyoutai22(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai22) {
        dispsyoubyoujyoutai22 = pDispsyoubyoujyoutai22;
    }

    private BizDateYM dispkantiym22;

    public BizDateYM getDispkantiym22() {
        return dispkantiym22;
    }

    public void setDispkantiym22(BizDateYM pDispkantiym22) {
        dispkantiym22 = pDispkantiym22;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou2;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou2() {
        return dispmrriyuucdnaiyou2;
    }

    public void setDispmrriyuucdnaiyou2(C_MrRiyuucdKbn pDispmrriyuucdnaiyou2) {
        dispmrriyuucdnaiyou2 = pDispmrriyuucdnaiyou2;
    }

    private Integer disprenno3;

    public Integer getDisprenno3() {
        return disprenno3;
    }

    public void setDisprenno3(Integer pDisprenno3) {
        disprenno3 = pDisprenno3;
    }

    private BizDate dispketymd3;

    public BizDate getDispketymd3() {
        return dispketymd3;
    }

    public void setDispketymd3(BizDate pDispketymd3) {
        dispketymd3 = pDispketymd3;
    }

    private C_Ketkekkacd dispketkekkacd3;

    public C_Ketkekkacd getDispketkekkacd3() {
        return dispketkekkacd3;
    }

    public void setDispketkekkacd3(C_Ketkekkacd pDispketkekkacd3) {
        dispketkekkacd3 = pDispketkekkacd3;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh3;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh3() {
        return dispsntksakuseiyh3;
    }

    public void setDispsntksakuseiyh3(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh3) {
        dispsntksakuseiyh3 = pDispsntksakuseiyh3;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu3;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu3() {
        return disptorikesisyousairiyuu3;
    }

    public void setDisptorikesisyousairiyuu3(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu3) {
        disptorikesisyousairiyuu3 = pDisptorikesisyousairiyuu3;
    }

    private String dispketriyuucd13;

    public String getDispketriyuucd13() {
        return dispketriyuucd13;
    }

    public void setDispketriyuucd13(String pDispketriyuucd13) {
        dispketriyuucd13 = pDispketriyuucd13;
    }

    private String dispketteiriyuunaiyou13;

    public String getDispketteiriyuunaiyou13() {
        return dispketteiriyuunaiyou13;
    }

    public void setDispketteiriyuunaiyou13(String pDispketteiriyuunaiyou13) {
        dispketteiriyuunaiyou13 = pDispketteiriyuunaiyou13;
    }

    private String dispsyoubyoucd13;

    public String getDispsyoubyoucd13() {
        return dispsyoubyoucd13;
    }

    public void setDispsyoubyoucd13(String pDispsyoubyoucd13) {
        dispsyoubyoucd13 = pDispsyoubyoucd13;
    }

    private String dispsyoubyounm13;

    public String getDispsyoubyounm13() {
        return dispsyoubyounm13;
    }

    public void setDispsyoubyounm13(String pDispsyoubyounm13) {
        dispsyoubyounm13 = pDispsyoubyounm13;
    }

    private String dispketriyuucd23;

    public String getDispketriyuucd23() {
        return dispketriyuucd23;
    }

    public void setDispketriyuucd23(String pDispketriyuucd23) {
        dispketriyuucd23 = pDispketriyuucd23;
    }

    private String dispketteiriyuunaiyou23;

    public String getDispketteiriyuunaiyou23() {
        return dispketteiriyuunaiyou23;
    }

    public void setDispketteiriyuunaiyou23(String pDispketteiriyuunaiyou23) {
        dispketteiriyuunaiyou23 = pDispketteiriyuunaiyou23;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai13;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai13() {
        return dispsyoubyoujyoutai13;
    }

    public void setDispsyoubyoujyoutai13(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai13) {
        dispsyoubyoujyoutai13 = pDispsyoubyoujyoutai13;
    }

    private BizDateYM dispkantiym13;

    public BizDateYM getDispkantiym13() {
        return dispkantiym13;
    }

    public void setDispkantiym13(BizDateYM pDispkantiym13) {
        dispkantiym13 = pDispkantiym13;
    }

    private String dispketriyuucd33;

    public String getDispketriyuucd33() {
        return dispketriyuucd33;
    }

    public void setDispketriyuucd33(String pDispketriyuucd33) {
        dispketriyuucd33 = pDispketriyuucd33;
    }

    private String dispketteiriyuunaiyou33;

    public String getDispketteiriyuunaiyou33() {
        return dispketteiriyuunaiyou33;
    }

    public void setDispketteiriyuunaiyou33(String pDispketteiriyuunaiyou33) {
        dispketteiriyuunaiyou33 = pDispketteiriyuunaiyou33;
    }

    private String dispsyoubyoucd23;

    public String getDispsyoubyoucd23() {
        return dispsyoubyoucd23;
    }

    public void setDispsyoubyoucd23(String pDispsyoubyoucd23) {
        dispsyoubyoucd23 = pDispsyoubyoucd23;
    }

    private String dispsyoubyounm23;

    public String getDispsyoubyounm23() {
        return dispsyoubyounm23;
    }

    public void setDispsyoubyounm23(String pDispsyoubyounm23) {
        dispsyoubyounm23 = pDispsyoubyounm23;
    }

    private String dispketriyuucd43;

    public String getDispketriyuucd43() {
        return dispketriyuucd43;
    }

    public void setDispketriyuucd43(String pDispketriyuucd43) {
        dispketriyuucd43 = pDispketriyuucd43;
    }

    private String dispketteiriyuunaiyou43;

    public String getDispketteiriyuunaiyou43() {
        return dispketteiriyuunaiyou43;
    }

    public void setDispketteiriyuunaiyou43(String pDispketteiriyuunaiyou43) {
        dispketteiriyuunaiyou43 = pDispketteiriyuunaiyou43;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai23;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai23() {
        return dispsyoubyoujyoutai23;
    }

    public void setDispsyoubyoujyoutai23(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai23) {
        dispsyoubyoujyoutai23 = pDispsyoubyoujyoutai23;
    }

    private BizDateYM dispkantiym23;

    public BizDateYM getDispkantiym23() {
        return dispkantiym23;
    }

    public void setDispkantiym23(BizDateYM pDispkantiym23) {
        dispkantiym23 = pDispkantiym23;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou3;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou3() {
        return dispmrriyuucdnaiyou3;
    }

    public void setDispmrriyuucdnaiyou3(C_MrRiyuucdKbn pDispmrriyuucdnaiyou3) {
        dispmrriyuucdnaiyou3 = pDispmrriyuucdnaiyou3;
    }

    private Integer disprenno4;

    public Integer getDisprenno4() {
        return disprenno4;
    }

    public void setDisprenno4(Integer pDisprenno4) {
        disprenno4 = pDisprenno4;
    }

    private BizDate dispketymd4;

    public BizDate getDispketymd4() {
        return dispketymd4;
    }

    public void setDispketymd4(BizDate pDispketymd4) {
        dispketymd4 = pDispketymd4;
    }

    private C_Ketkekkacd dispketkekkacd4;

    public C_Ketkekkacd getDispketkekkacd4() {
        return dispketkekkacd4;
    }

    public void setDispketkekkacd4(C_Ketkekkacd pDispketkekkacd4) {
        dispketkekkacd4 = pDispketkekkacd4;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh4;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh4() {
        return dispsntksakuseiyh4;
    }

    public void setDispsntksakuseiyh4(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh4) {
        dispsntksakuseiyh4 = pDispsntksakuseiyh4;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu4;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu4() {
        return disptorikesisyousairiyuu4;
    }

    public void setDisptorikesisyousairiyuu4(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu4) {
        disptorikesisyousairiyuu4 = pDisptorikesisyousairiyuu4;
    }

    private String dispketriyuucd14;

    public String getDispketriyuucd14() {
        return dispketriyuucd14;
    }

    public void setDispketriyuucd14(String pDispketriyuucd14) {
        dispketriyuucd14 = pDispketriyuucd14;
    }

    private String dispketteiriyuunaiyou14;

    public String getDispketteiriyuunaiyou14() {
        return dispketteiriyuunaiyou14;
    }

    public void setDispketteiriyuunaiyou14(String pDispketteiriyuunaiyou14) {
        dispketteiriyuunaiyou14 = pDispketteiriyuunaiyou14;
    }

    private String dispsyoubyoucd14;

    public String getDispsyoubyoucd14() {
        return dispsyoubyoucd14;
    }

    public void setDispsyoubyoucd14(String pDispsyoubyoucd14) {
        dispsyoubyoucd14 = pDispsyoubyoucd14;
    }

    private String dispsyoubyounm14;

    public String getDispsyoubyounm14() {
        return dispsyoubyounm14;
    }

    public void setDispsyoubyounm14(String pDispsyoubyounm14) {
        dispsyoubyounm14 = pDispsyoubyounm14;
    }

    private String dispketriyuucd24;

    public String getDispketriyuucd24() {
        return dispketriyuucd24;
    }

    public void setDispketriyuucd24(String pDispketriyuucd24) {
        dispketriyuucd24 = pDispketriyuucd24;
    }

    private String dispketteiriyuunaiyou24;

    public String getDispketteiriyuunaiyou24() {
        return dispketteiriyuunaiyou24;
    }

    public void setDispketteiriyuunaiyou24(String pDispketteiriyuunaiyou24) {
        dispketteiriyuunaiyou24 = pDispketteiriyuunaiyou24;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai14;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai14() {
        return dispsyoubyoujyoutai14;
    }

    public void setDispsyoubyoujyoutai14(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai14) {
        dispsyoubyoujyoutai14 = pDispsyoubyoujyoutai14;
    }

    private BizDateYM dispkantiym14;

    public BizDateYM getDispkantiym14() {
        return dispkantiym14;
    }

    public void setDispkantiym14(BizDateYM pDispkantiym14) {
        dispkantiym14 = pDispkantiym14;
    }

    private String dispketriyuucd34;

    public String getDispketriyuucd34() {
        return dispketriyuucd34;
    }

    public void setDispketriyuucd34(String pDispketriyuucd34) {
        dispketriyuucd34 = pDispketriyuucd34;
    }

    private String dispketteiriyuunaiyou34;

    public String getDispketteiriyuunaiyou34() {
        return dispketteiriyuunaiyou34;
    }

    public void setDispketteiriyuunaiyou34(String pDispketteiriyuunaiyou34) {
        dispketteiriyuunaiyou34 = pDispketteiriyuunaiyou34;
    }

    private String dispsyoubyoucd24;

    public String getDispsyoubyoucd24() {
        return dispsyoubyoucd24;
    }

    public void setDispsyoubyoucd24(String pDispsyoubyoucd24) {
        dispsyoubyoucd24 = pDispsyoubyoucd24;
    }

    private String dispsyoubyounm24;

    public String getDispsyoubyounm24() {
        return dispsyoubyounm24;
    }

    public void setDispsyoubyounm24(String pDispsyoubyounm24) {
        dispsyoubyounm24 = pDispsyoubyounm24;
    }

    private String dispketriyuucd44;

    public String getDispketriyuucd44() {
        return dispketriyuucd44;
    }

    public void setDispketriyuucd44(String pDispketriyuucd44) {
        dispketriyuucd44 = pDispketriyuucd44;
    }

    private String dispketteiriyuunaiyou44;

    public String getDispketteiriyuunaiyou44() {
        return dispketteiriyuunaiyou44;
    }

    public void setDispketteiriyuunaiyou44(String pDispketteiriyuunaiyou44) {
        dispketteiriyuunaiyou44 = pDispketteiriyuunaiyou44;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai24;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai24() {
        return dispsyoubyoujyoutai24;
    }

    public void setDispsyoubyoujyoutai24(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai24) {
        dispsyoubyoujyoutai24 = pDispsyoubyoujyoutai24;
    }

    private BizDateYM dispkantiym24;

    public BizDateYM getDispkantiym24() {
        return dispkantiym24;
    }

    public void setDispkantiym24(BizDateYM pDispkantiym24) {
        dispkantiym24 = pDispkantiym24;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou4;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou4() {
        return dispmrriyuucdnaiyou4;
    }

    public void setDispmrriyuucdnaiyou4(C_MrRiyuucdKbn pDispmrriyuucdnaiyou4) {
        dispmrriyuucdnaiyou4 = pDispmrriyuucdnaiyou4;
    }

    private Integer disprenno5;

    public Integer getDisprenno5() {
        return disprenno5;
    }

    public void setDisprenno5(Integer pDisprenno5) {
        disprenno5 = pDisprenno5;
    }

    private BizDate dispketymd5;

    public BizDate getDispketymd5() {
        return dispketymd5;
    }

    public void setDispketymd5(BizDate pDispketymd5) {
        dispketymd5 = pDispketymd5;
    }

    private C_Ketkekkacd dispketkekkacd5;

    public C_Ketkekkacd getDispketkekkacd5() {
        return dispketkekkacd5;
    }

    public void setDispketkekkacd5(C_Ketkekkacd pDispketkekkacd5) {
        dispketkekkacd5 = pDispketkekkacd5;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh5;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh5() {
        return dispsntksakuseiyh5;
    }

    public void setDispsntksakuseiyh5(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh5) {
        dispsntksakuseiyh5 = pDispsntksakuseiyh5;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu5;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu5() {
        return disptorikesisyousairiyuu5;
    }

    public void setDisptorikesisyousairiyuu5(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu5) {
        disptorikesisyousairiyuu5 = pDisptorikesisyousairiyuu5;
    }

    private String dispketriyuucd15;

    public String getDispketriyuucd15() {
        return dispketriyuucd15;
    }

    public void setDispketriyuucd15(String pDispketriyuucd15) {
        dispketriyuucd15 = pDispketriyuucd15;
    }

    private String dispketteiriyuunaiyou15;

    public String getDispketteiriyuunaiyou15() {
        return dispketteiriyuunaiyou15;
    }

    public void setDispketteiriyuunaiyou15(String pDispketteiriyuunaiyou15) {
        dispketteiriyuunaiyou15 = pDispketteiriyuunaiyou15;
    }

    private String dispsyoubyoucd15;

    public String getDispsyoubyoucd15() {
        return dispsyoubyoucd15;
    }

    public void setDispsyoubyoucd15(String pDispsyoubyoucd15) {
        dispsyoubyoucd15 = pDispsyoubyoucd15;
    }

    private String dispsyoubyounm15;

    public String getDispsyoubyounm15() {
        return dispsyoubyounm15;
    }

    public void setDispsyoubyounm15(String pDispsyoubyounm15) {
        dispsyoubyounm15 = pDispsyoubyounm15;
    }

    private String dispketriyuucd25;

    public String getDispketriyuucd25() {
        return dispketriyuucd25;
    }

    public void setDispketriyuucd25(String pDispketriyuucd25) {
        dispketriyuucd25 = pDispketriyuucd25;
    }

    private String dispketteiriyuunaiyou25;

    public String getDispketteiriyuunaiyou25() {
        return dispketteiriyuunaiyou25;
    }

    public void setDispketteiriyuunaiyou25(String pDispketteiriyuunaiyou25) {
        dispketteiriyuunaiyou25 = pDispketteiriyuunaiyou25;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai15;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai15() {
        return dispsyoubyoujyoutai15;
    }

    public void setDispsyoubyoujyoutai15(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai15) {
        dispsyoubyoujyoutai15 = pDispsyoubyoujyoutai15;
    }

    private BizDateYM dispkantiym15;

    public BizDateYM getDispkantiym15() {
        return dispkantiym15;
    }

    public void setDispkantiym15(BizDateYM pDispkantiym15) {
        dispkantiym15 = pDispkantiym15;
    }

    private String dispketriyuucd35;

    public String getDispketriyuucd35() {
        return dispketriyuucd35;
    }

    public void setDispketriyuucd35(String pDispketriyuucd35) {
        dispketriyuucd35 = pDispketriyuucd35;
    }

    private String dispketteiriyuunaiyou35;

    public String getDispketteiriyuunaiyou35() {
        return dispketteiriyuunaiyou35;
    }

    public void setDispketteiriyuunaiyou35(String pDispketteiriyuunaiyou35) {
        dispketteiriyuunaiyou35 = pDispketteiriyuunaiyou35;
    }

    private String dispsyoubyoucd25;

    public String getDispsyoubyoucd25() {
        return dispsyoubyoucd25;
    }

    public void setDispsyoubyoucd25(String pDispsyoubyoucd25) {
        dispsyoubyoucd25 = pDispsyoubyoucd25;
    }

    private String dispsyoubyounm25;

    public String getDispsyoubyounm25() {
        return dispsyoubyounm25;
    }

    public void setDispsyoubyounm25(String pDispsyoubyounm25) {
        dispsyoubyounm25 = pDispsyoubyounm25;
    }

    private String dispketriyuucd45;

    public String getDispketriyuucd45() {
        return dispketriyuucd45;
    }

    public void setDispketriyuucd45(String pDispketriyuucd45) {
        dispketriyuucd45 = pDispketriyuucd45;
    }

    private String dispketteiriyuunaiyou45;

    public String getDispketteiriyuunaiyou45() {
        return dispketteiriyuunaiyou45;
    }

    public void setDispketteiriyuunaiyou45(String pDispketteiriyuunaiyou45) {
        dispketteiriyuunaiyou45 = pDispketteiriyuunaiyou45;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai25;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai25() {
        return dispsyoubyoujyoutai25;
    }

    public void setDispsyoubyoujyoutai25(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai25) {
        dispsyoubyoujyoutai25 = pDispsyoubyoujyoutai25;
    }

    private BizDateYM dispkantiym25;

    public BizDateYM getDispkantiym25() {
        return dispkantiym25;
    }

    public void setDispkantiym25(BizDateYM pDispkantiym25) {
        dispkantiym25 = pDispkantiym25;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou5;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou5() {
        return dispmrriyuucdnaiyou5;
    }

    public void setDispmrriyuucdnaiyou5(C_MrRiyuucdKbn pDispmrriyuucdnaiyou5) {
        dispmrriyuucdnaiyou5 = pDispmrriyuucdnaiyou5;
    }

    private Integer disprenno6;

    public Integer getDisprenno6() {
        return disprenno6;
    }

    public void setDisprenno6(Integer pDisprenno6) {
        disprenno6 = pDisprenno6;
    }

    private BizDate dispketymd6;

    public BizDate getDispketymd6() {
        return dispketymd6;
    }

    public void setDispketymd6(BizDate pDispketymd6) {
        dispketymd6 = pDispketymd6;
    }

    private C_Ketkekkacd dispketkekkacd6;

    public C_Ketkekkacd getDispketkekkacd6() {
        return dispketkekkacd6;
    }

    public void setDispketkekkacd6(C_Ketkekkacd pDispketkekkacd6) {
        dispketkekkacd6 = pDispketkekkacd6;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh6;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh6() {
        return dispsntksakuseiyh6;
    }

    public void setDispsntksakuseiyh6(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh6) {
        dispsntksakuseiyh6 = pDispsntksakuseiyh6;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu6;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu6() {
        return disptorikesisyousairiyuu6;
    }

    public void setDisptorikesisyousairiyuu6(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu6) {
        disptorikesisyousairiyuu6 = pDisptorikesisyousairiyuu6;
    }

    private String dispketriyuucd16;

    public String getDispketriyuucd16() {
        return dispketriyuucd16;
    }

    public void setDispketriyuucd16(String pDispketriyuucd16) {
        dispketriyuucd16 = pDispketriyuucd16;
    }

    private String dispketteiriyuunaiyou16;

    public String getDispketteiriyuunaiyou16() {
        return dispketteiriyuunaiyou16;
    }

    public void setDispketteiriyuunaiyou16(String pDispketteiriyuunaiyou16) {
        dispketteiriyuunaiyou16 = pDispketteiriyuunaiyou16;
    }

    private String dispsyoubyoucd16;

    public String getDispsyoubyoucd16() {
        return dispsyoubyoucd16;
    }

    public void setDispsyoubyoucd16(String pDispsyoubyoucd16) {
        dispsyoubyoucd16 = pDispsyoubyoucd16;
    }

    private String dispsyoubyounm16;

    public String getDispsyoubyounm16() {
        return dispsyoubyounm16;
    }

    public void setDispsyoubyounm16(String pDispsyoubyounm16) {
        dispsyoubyounm16 = pDispsyoubyounm16;
    }

    private String dispketriyuucd26;

    public String getDispketriyuucd26() {
        return dispketriyuucd26;
    }

    public void setDispketriyuucd26(String pDispketriyuucd26) {
        dispketriyuucd26 = pDispketriyuucd26;
    }

    private String dispketteiriyuunaiyou26;

    public String getDispketteiriyuunaiyou26() {
        return dispketteiriyuunaiyou26;
    }

    public void setDispketteiriyuunaiyou26(String pDispketteiriyuunaiyou26) {
        dispketteiriyuunaiyou26 = pDispketteiriyuunaiyou26;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai16;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai16() {
        return dispsyoubyoujyoutai16;
    }

    public void setDispsyoubyoujyoutai16(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai16) {
        dispsyoubyoujyoutai16 = pDispsyoubyoujyoutai16;
    }

    private BizDateYM dispkantiym16;

    public BizDateYM getDispkantiym16() {
        return dispkantiym16;
    }

    public void setDispkantiym16(BizDateYM pDispkantiym16) {
        dispkantiym16 = pDispkantiym16;
    }

    private String dispketriyuucd36;

    public String getDispketriyuucd36() {
        return dispketriyuucd36;
    }

    public void setDispketriyuucd36(String pDispketriyuucd36) {
        dispketriyuucd36 = pDispketriyuucd36;
    }

    private String dispketteiriyuunaiyou36;

    public String getDispketteiriyuunaiyou36() {
        return dispketteiriyuunaiyou36;
    }

    public void setDispketteiriyuunaiyou36(String pDispketteiriyuunaiyou36) {
        dispketteiriyuunaiyou36 = pDispketteiriyuunaiyou36;
    }

    private String dispsyoubyoucd26;

    public String getDispsyoubyoucd26() {
        return dispsyoubyoucd26;
    }

    public void setDispsyoubyoucd26(String pDispsyoubyoucd26) {
        dispsyoubyoucd26 = pDispsyoubyoucd26;
    }

    private String dispsyoubyounm26;

    public String getDispsyoubyounm26() {
        return dispsyoubyounm26;
    }

    public void setDispsyoubyounm26(String pDispsyoubyounm26) {
        dispsyoubyounm26 = pDispsyoubyounm26;
    }

    private String dispketriyuucd46;

    public String getDispketriyuucd46() {
        return dispketriyuucd46;
    }

    public void setDispketriyuucd46(String pDispketriyuucd46) {
        dispketriyuucd46 = pDispketriyuucd46;
    }

    private String dispketteiriyuunaiyou46;

    public String getDispketteiriyuunaiyou46() {
        return dispketteiriyuunaiyou46;
    }

    public void setDispketteiriyuunaiyou46(String pDispketteiriyuunaiyou46) {
        dispketteiriyuunaiyou46 = pDispketteiriyuunaiyou46;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai26;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai26() {
        return dispsyoubyoujyoutai26;
    }

    public void setDispsyoubyoujyoutai26(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai26) {
        dispsyoubyoujyoutai26 = pDispsyoubyoujyoutai26;
    }

    private BizDateYM dispkantiym26;

    public BizDateYM getDispkantiym26() {
        return dispkantiym26;
    }

    public void setDispkantiym26(BizDateYM pDispkantiym26) {
        dispkantiym26 = pDispkantiym26;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou6;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou6() {
        return dispmrriyuucdnaiyou6;
    }

    public void setDispmrriyuucdnaiyou6(C_MrRiyuucdKbn pDispmrriyuucdnaiyou6) {
        dispmrriyuucdnaiyou6 = pDispmrriyuucdnaiyou6;
    }

    private Integer disprenno7;

    public Integer getDisprenno7() {
        return disprenno7;
    }

    public void setDisprenno7(Integer pDisprenno7) {
        disprenno7 = pDisprenno7;
    }

    private BizDate dispketymd7;

    public BizDate getDispketymd7() {
        return dispketymd7;
    }

    public void setDispketymd7(BizDate pDispketymd7) {
        dispketymd7 = pDispketymd7;
    }

    private C_Ketkekkacd dispketkekkacd7;

    public C_Ketkekkacd getDispketkekkacd7() {
        return dispketkekkacd7;
    }

    public void setDispketkekkacd7(C_Ketkekkacd pDispketkekkacd7) {
        dispketkekkacd7 = pDispketkekkacd7;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh7;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh7() {
        return dispsntksakuseiyh7;
    }

    public void setDispsntksakuseiyh7(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh7) {
        dispsntksakuseiyh7 = pDispsntksakuseiyh7;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu7;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu7() {
        return disptorikesisyousairiyuu7;
    }

    public void setDisptorikesisyousairiyuu7(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu7) {
        disptorikesisyousairiyuu7 = pDisptorikesisyousairiyuu7;
    }

    private String dispketriyuucd17;

    public String getDispketriyuucd17() {
        return dispketriyuucd17;
    }

    public void setDispketriyuucd17(String pDispketriyuucd17) {
        dispketriyuucd17 = pDispketriyuucd17;
    }

    private String dispketteiriyuunaiyou17;

    public String getDispketteiriyuunaiyou17() {
        return dispketteiriyuunaiyou17;
    }

    public void setDispketteiriyuunaiyou17(String pDispketteiriyuunaiyou17) {
        dispketteiriyuunaiyou17 = pDispketteiriyuunaiyou17;
    }

    private String dispsyoubyoucd17;

    public String getDispsyoubyoucd17() {
        return dispsyoubyoucd17;
    }

    public void setDispsyoubyoucd17(String pDispsyoubyoucd17) {
        dispsyoubyoucd17 = pDispsyoubyoucd17;
    }

    private String dispsyoubyounm17;

    public String getDispsyoubyounm17() {
        return dispsyoubyounm17;
    }

    public void setDispsyoubyounm17(String pDispsyoubyounm17) {
        dispsyoubyounm17 = pDispsyoubyounm17;
    }

    private String dispketriyuucd27;

    public String getDispketriyuucd27() {
        return dispketriyuucd27;
    }

    public void setDispketriyuucd27(String pDispketriyuucd27) {
        dispketriyuucd27 = pDispketriyuucd27;
    }

    private String dispketteiriyuunaiyou27;

    public String getDispketteiriyuunaiyou27() {
        return dispketteiriyuunaiyou27;
    }

    public void setDispketteiriyuunaiyou27(String pDispketteiriyuunaiyou27) {
        dispketteiriyuunaiyou27 = pDispketteiriyuunaiyou27;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai17;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai17() {
        return dispsyoubyoujyoutai17;
    }

    public void setDispsyoubyoujyoutai17(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai17) {
        dispsyoubyoujyoutai17 = pDispsyoubyoujyoutai17;
    }

    private BizDateYM dispkantiym17;

    public BizDateYM getDispkantiym17() {
        return dispkantiym17;
    }

    public void setDispkantiym17(BizDateYM pDispkantiym17) {
        dispkantiym17 = pDispkantiym17;
    }

    private String dispketriyuucd37;

    public String getDispketriyuucd37() {
        return dispketriyuucd37;
    }

    public void setDispketriyuucd37(String pDispketriyuucd37) {
        dispketriyuucd37 = pDispketriyuucd37;
    }

    private String dispketteiriyuunaiyou37;

    public String getDispketteiriyuunaiyou37() {
        return dispketteiriyuunaiyou37;
    }

    public void setDispketteiriyuunaiyou37(String pDispketteiriyuunaiyou37) {
        dispketteiriyuunaiyou37 = pDispketteiriyuunaiyou37;
    }

    private String dispsyoubyoucd27;

    public String getDispsyoubyoucd27() {
        return dispsyoubyoucd27;
    }

    public void setDispsyoubyoucd27(String pDispsyoubyoucd27) {
        dispsyoubyoucd27 = pDispsyoubyoucd27;
    }

    private String dispsyoubyounm27;

    public String getDispsyoubyounm27() {
        return dispsyoubyounm27;
    }

    public void setDispsyoubyounm27(String pDispsyoubyounm27) {
        dispsyoubyounm27 = pDispsyoubyounm27;
    }

    private String dispketriyuucd47;

    public String getDispketriyuucd47() {
        return dispketriyuucd47;
    }

    public void setDispketriyuucd47(String pDispketriyuucd47) {
        dispketriyuucd47 = pDispketriyuucd47;
    }

    private String dispketteiriyuunaiyou47;

    public String getDispketteiriyuunaiyou47() {
        return dispketteiriyuunaiyou47;
    }

    public void setDispketteiriyuunaiyou47(String pDispketteiriyuunaiyou47) {
        dispketteiriyuunaiyou47 = pDispketteiriyuunaiyou47;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai27;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai27() {
        return dispsyoubyoujyoutai27;
    }

    public void setDispsyoubyoujyoutai27(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai27) {
        dispsyoubyoujyoutai27 = pDispsyoubyoujyoutai27;
    }

    private BizDateYM dispkantiym27;

    public BizDateYM getDispkantiym27() {
        return dispkantiym27;
    }

    public void setDispkantiym27(BizDateYM pDispkantiym27) {
        dispkantiym27 = pDispkantiym27;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou7;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou7() {
        return dispmrriyuucdnaiyou7;
    }

    public void setDispmrriyuucdnaiyou7(C_MrRiyuucdKbn pDispmrriyuucdnaiyou7) {
        dispmrriyuucdnaiyou7 = pDispmrriyuucdnaiyou7;
    }

    private Integer disprenno8;

    public Integer getDisprenno8() {
        return disprenno8;
    }

    public void setDisprenno8(Integer pDisprenno8) {
        disprenno8 = pDisprenno8;
    }

    private BizDate dispketymd8;

    public BizDate getDispketymd8() {
        return dispketymd8;
    }

    public void setDispketymd8(BizDate pDispketymd8) {
        dispketymd8 = pDispketymd8;
    }

    private C_Ketkekkacd dispketkekkacd8;

    public C_Ketkekkacd getDispketkekkacd8() {
        return dispketkekkacd8;
    }

    public void setDispketkekkacd8(C_Ketkekkacd pDispketkekkacd8) {
        dispketkekkacd8 = pDispketkekkacd8;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh8;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh8() {
        return dispsntksakuseiyh8;
    }

    public void setDispsntksakuseiyh8(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh8) {
        dispsntksakuseiyh8 = pDispsntksakuseiyh8;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu8;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu8() {
        return disptorikesisyousairiyuu8;
    }

    public void setDisptorikesisyousairiyuu8(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu8) {
        disptorikesisyousairiyuu8 = pDisptorikesisyousairiyuu8;
    }

    private String dispketriyuucd18;

    public String getDispketriyuucd18() {
        return dispketriyuucd18;
    }

    public void setDispketriyuucd18(String pDispketriyuucd18) {
        dispketriyuucd18 = pDispketriyuucd18;
    }

    private String dispketteiriyuunaiyou18;

    public String getDispketteiriyuunaiyou18() {
        return dispketteiriyuunaiyou18;
    }

    public void setDispketteiriyuunaiyou18(String pDispketteiriyuunaiyou18) {
        dispketteiriyuunaiyou18 = pDispketteiriyuunaiyou18;
    }

    private String dispsyoubyoucd18;

    public String getDispsyoubyoucd18() {
        return dispsyoubyoucd18;
    }

    public void setDispsyoubyoucd18(String pDispsyoubyoucd18) {
        dispsyoubyoucd18 = pDispsyoubyoucd18;
    }

    private String dispsyoubyounm18;

    public String getDispsyoubyounm18() {
        return dispsyoubyounm18;
    }

    public void setDispsyoubyounm18(String pDispsyoubyounm18) {
        dispsyoubyounm18 = pDispsyoubyounm18;
    }

    private String dispketriyuucd28;

    public String getDispketriyuucd28() {
        return dispketriyuucd28;
    }

    public void setDispketriyuucd28(String pDispketriyuucd28) {
        dispketriyuucd28 = pDispketriyuucd28;
    }

    private String dispketteiriyuunaiyou28;

    public String getDispketteiriyuunaiyou28() {
        return dispketteiriyuunaiyou28;
    }

    public void setDispketteiriyuunaiyou28(String pDispketteiriyuunaiyou28) {
        dispketteiriyuunaiyou28 = pDispketteiriyuunaiyou28;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai18;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai18() {
        return dispsyoubyoujyoutai18;
    }

    public void setDispsyoubyoujyoutai18(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai18) {
        dispsyoubyoujyoutai18 = pDispsyoubyoujyoutai18;
    }

    private BizDateYM dispkantiym18;

    public BizDateYM getDispkantiym18() {
        return dispkantiym18;
    }

    public void setDispkantiym18(BizDateYM pDispkantiym18) {
        dispkantiym18 = pDispkantiym18;
    }

    private String dispketriyuucd38;

    public String getDispketriyuucd38() {
        return dispketriyuucd38;
    }

    public void setDispketriyuucd38(String pDispketriyuucd38) {
        dispketriyuucd38 = pDispketriyuucd38;
    }

    private String dispketteiriyuunaiyou38;

    public String getDispketteiriyuunaiyou38() {
        return dispketteiriyuunaiyou38;
    }

    public void setDispketteiriyuunaiyou38(String pDispketteiriyuunaiyou38) {
        dispketteiriyuunaiyou38 = pDispketteiriyuunaiyou38;
    }

    private String dispsyoubyoucd28;

    public String getDispsyoubyoucd28() {
        return dispsyoubyoucd28;
    }

    public void setDispsyoubyoucd28(String pDispsyoubyoucd28) {
        dispsyoubyoucd28 = pDispsyoubyoucd28;
    }

    private String dispsyoubyounm28;

    public String getDispsyoubyounm28() {
        return dispsyoubyounm28;
    }

    public void setDispsyoubyounm28(String pDispsyoubyounm28) {
        dispsyoubyounm28 = pDispsyoubyounm28;
    }

    private String dispketriyuucd48;

    public String getDispketriyuucd48() {
        return dispketriyuucd48;
    }

    public void setDispketriyuucd48(String pDispketriyuucd48) {
        dispketriyuucd48 = pDispketriyuucd48;
    }

    private String dispketteiriyuunaiyou48;

    public String getDispketteiriyuunaiyou48() {
        return dispketteiriyuunaiyou48;
    }

    public void setDispketteiriyuunaiyou48(String pDispketteiriyuunaiyou48) {
        dispketteiriyuunaiyou48 = pDispketteiriyuunaiyou48;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai28;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai28() {
        return dispsyoubyoujyoutai28;
    }

    public void setDispsyoubyoujyoutai28(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai28) {
        dispsyoubyoujyoutai28 = pDispsyoubyoujyoutai28;
    }

    private BizDateYM dispkantiym28;

    public BizDateYM getDispkantiym28() {
        return dispkantiym28;
    }

    public void setDispkantiym28(BizDateYM pDispkantiym28) {
        dispkantiym28 = pDispkantiym28;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou8;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou8() {
        return dispmrriyuucdnaiyou8;
    }

    public void setDispmrriyuucdnaiyou8(C_MrRiyuucdKbn pDispmrriyuucdnaiyou8) {
        dispmrriyuucdnaiyou8 = pDispmrriyuucdnaiyou8;
    }

    private Integer disprenno9;

    public Integer getDisprenno9() {
        return disprenno9;
    }

    public void setDisprenno9(Integer pDisprenno9) {
        disprenno9 = pDisprenno9;
    }

    private BizDate dispketymd9;

    public BizDate getDispketymd9() {
        return dispketymd9;
    }

    public void setDispketymd9(BizDate pDispketymd9) {
        dispketymd9 = pDispketymd9;
    }

    private C_Ketkekkacd dispketkekkacd9;

    public C_Ketkekkacd getDispketkekkacd9() {
        return dispketkekkacd9;
    }

    public void setDispketkekkacd9(C_Ketkekkacd pDispketkekkacd9) {
        dispketkekkacd9 = pDispketkekkacd9;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh9;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh9() {
        return dispsntksakuseiyh9;
    }

    public void setDispsntksakuseiyh9(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh9) {
        dispsntksakuseiyh9 = pDispsntksakuseiyh9;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu9;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu9() {
        return disptorikesisyousairiyuu9;
    }

    public void setDisptorikesisyousairiyuu9(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu9) {
        disptorikesisyousairiyuu9 = pDisptorikesisyousairiyuu9;
    }

    private String dispketriyuucd19;

    public String getDispketriyuucd19() {
        return dispketriyuucd19;
    }

    public void setDispketriyuucd19(String pDispketriyuucd19) {
        dispketriyuucd19 = pDispketriyuucd19;
    }

    private String dispketteiriyuunaiyou19;

    public String getDispketteiriyuunaiyou19() {
        return dispketteiriyuunaiyou19;
    }

    public void setDispketteiriyuunaiyou19(String pDispketteiriyuunaiyou19) {
        dispketteiriyuunaiyou19 = pDispketteiriyuunaiyou19;
    }

    private String dispsyoubyoucd19;

    public String getDispsyoubyoucd19() {
        return dispsyoubyoucd19;
    }

    public void setDispsyoubyoucd19(String pDispsyoubyoucd19) {
        dispsyoubyoucd19 = pDispsyoubyoucd19;
    }

    private String dispsyoubyounm19;

    public String getDispsyoubyounm19() {
        return dispsyoubyounm19;
    }

    public void setDispsyoubyounm19(String pDispsyoubyounm19) {
        dispsyoubyounm19 = pDispsyoubyounm19;
    }

    private String dispketriyuucd29;

    public String getDispketriyuucd29() {
        return dispketriyuucd29;
    }

    public void setDispketriyuucd29(String pDispketriyuucd29) {
        dispketriyuucd29 = pDispketriyuucd29;
    }

    private String dispketteiriyuunaiyou29;

    public String getDispketteiriyuunaiyou29() {
        return dispketteiriyuunaiyou29;
    }

    public void setDispketteiriyuunaiyou29(String pDispketteiriyuunaiyou29) {
        dispketteiriyuunaiyou29 = pDispketteiriyuunaiyou29;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai19;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai19() {
        return dispsyoubyoujyoutai19;
    }

    public void setDispsyoubyoujyoutai19(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai19) {
        dispsyoubyoujyoutai19 = pDispsyoubyoujyoutai19;
    }

    private BizDateYM dispkantiym19;

    public BizDateYM getDispkantiym19() {
        return dispkantiym19;
    }

    public void setDispkantiym19(BizDateYM pDispkantiym19) {
        dispkantiym19 = pDispkantiym19;
    }

    private String dispketriyuucd39;

    public String getDispketriyuucd39() {
        return dispketriyuucd39;
    }

    public void setDispketriyuucd39(String pDispketriyuucd39) {
        dispketriyuucd39 = pDispketriyuucd39;
    }

    private String dispketteiriyuunaiyou39;

    public String getDispketteiriyuunaiyou39() {
        return dispketteiriyuunaiyou39;
    }

    public void setDispketteiriyuunaiyou39(String pDispketteiriyuunaiyou39) {
        dispketteiriyuunaiyou39 = pDispketteiriyuunaiyou39;
    }

    private String dispsyoubyoucd29;

    public String getDispsyoubyoucd29() {
        return dispsyoubyoucd29;
    }

    public void setDispsyoubyoucd29(String pDispsyoubyoucd29) {
        dispsyoubyoucd29 = pDispsyoubyoucd29;
    }

    private String dispsyoubyounm29;

    public String getDispsyoubyounm29() {
        return dispsyoubyounm29;
    }

    public void setDispsyoubyounm29(String pDispsyoubyounm29) {
        dispsyoubyounm29 = pDispsyoubyounm29;
    }

    private String dispketriyuucd49;

    public String getDispketriyuucd49() {
        return dispketriyuucd49;
    }

    public void setDispketriyuucd49(String pDispketriyuucd49) {
        dispketriyuucd49 = pDispketriyuucd49;
    }

    private String dispketteiriyuunaiyou49;

    public String getDispketteiriyuunaiyou49() {
        return dispketteiriyuunaiyou49;
    }

    public void setDispketteiriyuunaiyou49(String pDispketteiriyuunaiyou49) {
        dispketteiriyuunaiyou49 = pDispketteiriyuunaiyou49;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai29;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai29() {
        return dispsyoubyoujyoutai29;
    }

    public void setDispsyoubyoujyoutai29(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai29) {
        dispsyoubyoujyoutai29 = pDispsyoubyoujyoutai29;
    }

    private BizDateYM dispkantiym29;

    public BizDateYM getDispkantiym29() {
        return dispkantiym29;
    }

    public void setDispkantiym29(BizDateYM pDispkantiym29) {
        dispkantiym29 = pDispkantiym29;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou9;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou9() {
        return dispmrriyuucdnaiyou9;
    }

    public void setDispmrriyuucdnaiyou9(C_MrRiyuucdKbn pDispmrriyuucdnaiyou9) {
        dispmrriyuucdnaiyou9 = pDispmrriyuucdnaiyou9;
    }

    private Integer disprenno10;

    public Integer getDisprenno10() {
        return disprenno10;
    }

    public void setDisprenno10(Integer pDisprenno10) {
        disprenno10 = pDisprenno10;
    }

    private BizDate dispketymd10;

    public BizDate getDispketymd10() {
        return dispketymd10;
    }

    public void setDispketymd10(BizDate pDispketymd10) {
        dispketymd10 = pDispketymd10;
    }

    private C_Ketkekkacd dispketkekkacd10;

    public C_Ketkekkacd getDispketkekkacd10() {
        return dispketkekkacd10;
    }

    public void setDispketkekkacd10(C_Ketkekkacd pDispketkekkacd10) {
        dispketkekkacd10 = pDispketkekkacd10;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh10;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh10() {
        return dispsntksakuseiyh10;
    }

    public void setDispsntksakuseiyh10(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh10) {
        dispsntksakuseiyh10 = pDispsntksakuseiyh10;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu10;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu10() {
        return disptorikesisyousairiyuu10;
    }

    public void setDisptorikesisyousairiyuu10(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu10) {
        disptorikesisyousairiyuu10 = pDisptorikesisyousairiyuu10;
    }

    private String dispketriyuucd110;

    public String getDispketriyuucd110() {
        return dispketriyuucd110;
    }

    public void setDispketriyuucd110(String pDispketriyuucd110) {
        dispketriyuucd110 = pDispketriyuucd110;
    }

    private String dispketteiriyuunaiyou110;

    public String getDispketteiriyuunaiyou110() {
        return dispketteiriyuunaiyou110;
    }

    public void setDispketteiriyuunaiyou110(String pDispketteiriyuunaiyou110) {
        dispketteiriyuunaiyou110 = pDispketteiriyuunaiyou110;
    }

    private String dispsyoubyoucd110;

    public String getDispsyoubyoucd110() {
        return dispsyoubyoucd110;
    }

    public void setDispsyoubyoucd110(String pDispsyoubyoucd110) {
        dispsyoubyoucd110 = pDispsyoubyoucd110;
    }

    private String dispsyoubyounm110;

    public String getDispsyoubyounm110() {
        return dispsyoubyounm110;
    }

    public void setDispsyoubyounm110(String pDispsyoubyounm110) {
        dispsyoubyounm110 = pDispsyoubyounm110;
    }

    private String dispketriyuucd210;

    public String getDispketriyuucd210() {
        return dispketriyuucd210;
    }

    public void setDispketriyuucd210(String pDispketriyuucd210) {
        dispketriyuucd210 = pDispketriyuucd210;
    }

    private String dispketteiriyuunaiyou210;

    public String getDispketteiriyuunaiyou210() {
        return dispketteiriyuunaiyou210;
    }

    public void setDispketteiriyuunaiyou210(String pDispketteiriyuunaiyou210) {
        dispketteiriyuunaiyou210 = pDispketteiriyuunaiyou210;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai110;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai110() {
        return dispsyoubyoujyoutai110;
    }

    public void setDispsyoubyoujyoutai110(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai110) {
        dispsyoubyoujyoutai110 = pDispsyoubyoujyoutai110;
    }

    private BizDateYM dispkantiym110;

    public BizDateYM getDispkantiym110() {
        return dispkantiym110;
    }

    public void setDispkantiym110(BizDateYM pDispkantiym110) {
        dispkantiym110 = pDispkantiym110;
    }

    private String dispketriyuucd310;

    public String getDispketriyuucd310() {
        return dispketriyuucd310;
    }

    public void setDispketriyuucd310(String pDispketriyuucd310) {
        dispketriyuucd310 = pDispketriyuucd310;
    }

    private String dispketteiriyuunaiyou310;

    public String getDispketteiriyuunaiyou310() {
        return dispketteiriyuunaiyou310;
    }

    public void setDispketteiriyuunaiyou310(String pDispketteiriyuunaiyou310) {
        dispketteiriyuunaiyou310 = pDispketteiriyuunaiyou310;
    }

    private String dispsyoubyoucd210;

    public String getDispsyoubyoucd210() {
        return dispsyoubyoucd210;
    }

    public void setDispsyoubyoucd210(String pDispsyoubyoucd210) {
        dispsyoubyoucd210 = pDispsyoubyoucd210;
    }

    private String dispsyoubyounm210;

    public String getDispsyoubyounm210() {
        return dispsyoubyounm210;
    }

    public void setDispsyoubyounm210(String pDispsyoubyounm210) {
        dispsyoubyounm210 = pDispsyoubyounm210;
    }

    private String dispketriyuucd410;

    public String getDispketriyuucd410() {
        return dispketriyuucd410;
    }

    public void setDispketriyuucd410(String pDispketriyuucd410) {
        dispketriyuucd410 = pDispketriyuucd410;
    }

    private String dispketteiriyuunaiyou410;

    public String getDispketteiriyuunaiyou410() {
        return dispketteiriyuunaiyou410;
    }

    public void setDispketteiriyuunaiyou410(String pDispketteiriyuunaiyou410) {
        dispketteiriyuunaiyou410 = pDispketteiriyuunaiyou410;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai210;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai210() {
        return dispsyoubyoujyoutai210;
    }

    public void setDispsyoubyoujyoutai210(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai210) {
        dispsyoubyoujyoutai210 = pDispsyoubyoujyoutai210;
    }

    private BizDateYM dispkantiym210;

    public BizDateYM getDispkantiym210() {
        return dispkantiym210;
    }

    public void setDispkantiym210(BizDateYM pDispkantiym210) {
        dispkantiym210 = pDispkantiym210;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou10;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou10() {
        return dispmrriyuucdnaiyou10;
    }

    public void setDispmrriyuucdnaiyou10(C_MrRiyuucdKbn pDispmrriyuucdnaiyou10) {
        dispmrriyuucdnaiyou10 = pDispmrriyuucdnaiyou10;
    }

    private Integer disprenno11;

    public Integer getDisprenno11() {
        return disprenno11;
    }

    public void setDisprenno11(Integer pDisprenno11) {
        disprenno11 = pDisprenno11;
    }

    private BizDate dispketymd11;

    public BizDate getDispketymd11() {
        return dispketymd11;
    }

    public void setDispketymd11(BizDate pDispketymd11) {
        dispketymd11 = pDispketymd11;
    }

    private C_Ketkekkacd dispketkekkacd11;

    public C_Ketkekkacd getDispketkekkacd11() {
        return dispketkekkacd11;
    }

    public void setDispketkekkacd11(C_Ketkekkacd pDispketkekkacd11) {
        dispketkekkacd11 = pDispketkekkacd11;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh11;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh11() {
        return dispsntksakuseiyh11;
    }

    public void setDispsntksakuseiyh11(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh11) {
        dispsntksakuseiyh11 = pDispsntksakuseiyh11;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu11;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu11() {
        return disptorikesisyousairiyuu11;
    }

    public void setDisptorikesisyousairiyuu11(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu11) {
        disptorikesisyousairiyuu11 = pDisptorikesisyousairiyuu11;
    }

    private String dispketriyuucd111;

    public String getDispketriyuucd111() {
        return dispketriyuucd111;
    }

    public void setDispketriyuucd111(String pDispketriyuucd111) {
        dispketriyuucd111 = pDispketriyuucd111;
    }

    private String dispketteiriyuunaiyou111;

    public String getDispketteiriyuunaiyou111() {
        return dispketteiriyuunaiyou111;
    }

    public void setDispketteiriyuunaiyou111(String pDispketteiriyuunaiyou111) {
        dispketteiriyuunaiyou111 = pDispketteiriyuunaiyou111;
    }

    private String dispsyoubyoucd111;

    public String getDispsyoubyoucd111() {
        return dispsyoubyoucd111;
    }

    public void setDispsyoubyoucd111(String pDispsyoubyoucd111) {
        dispsyoubyoucd111 = pDispsyoubyoucd111;
    }

    private String dispsyoubyounm111;

    public String getDispsyoubyounm111() {
        return dispsyoubyounm111;
    }

    public void setDispsyoubyounm111(String pDispsyoubyounm111) {
        dispsyoubyounm111 = pDispsyoubyounm111;
    }

    private String dispketriyuucd211;

    public String getDispketriyuucd211() {
        return dispketriyuucd211;
    }

    public void setDispketriyuucd211(String pDispketriyuucd211) {
        dispketriyuucd211 = pDispketriyuucd211;
    }

    private String dispketteiriyuunaiyou211;

    public String getDispketteiriyuunaiyou211() {
        return dispketteiriyuunaiyou211;
    }

    public void setDispketteiriyuunaiyou211(String pDispketteiriyuunaiyou211) {
        dispketteiriyuunaiyou211 = pDispketteiriyuunaiyou211;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai111;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai111() {
        return dispsyoubyoujyoutai111;
    }

    public void setDispsyoubyoujyoutai111(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai111) {
        dispsyoubyoujyoutai111 = pDispsyoubyoujyoutai111;
    }

    private BizDateYM dispkantiym111;

    public BizDateYM getDispkantiym111() {
        return dispkantiym111;
    }

    public void setDispkantiym111(BizDateYM pDispkantiym111) {
        dispkantiym111 = pDispkantiym111;
    }

    private String dispketriyuucd311;

    public String getDispketriyuucd311() {
        return dispketriyuucd311;
    }

    public void setDispketriyuucd311(String pDispketriyuucd311) {
        dispketriyuucd311 = pDispketriyuucd311;
    }

    private String dispketteiriyuunaiyou311;

    public String getDispketteiriyuunaiyou311() {
        return dispketteiriyuunaiyou311;
    }

    public void setDispketteiriyuunaiyou311(String pDispketteiriyuunaiyou311) {
        dispketteiriyuunaiyou311 = pDispketteiriyuunaiyou311;
    }

    private String dispsyoubyoucd211;

    public String getDispsyoubyoucd211() {
        return dispsyoubyoucd211;
    }

    public void setDispsyoubyoucd211(String pDispsyoubyoucd211) {
        dispsyoubyoucd211 = pDispsyoubyoucd211;
    }

    private String dispsyoubyounm211;

    public String getDispsyoubyounm211() {
        return dispsyoubyounm211;
    }

    public void setDispsyoubyounm211(String pDispsyoubyounm211) {
        dispsyoubyounm211 = pDispsyoubyounm211;
    }

    private String dispketriyuucd411;

    public String getDispketriyuucd411() {
        return dispketriyuucd411;
    }

    public void setDispketriyuucd411(String pDispketriyuucd411) {
        dispketriyuucd411 = pDispketriyuucd411;
    }

    private String dispketteiriyuunaiyou411;

    public String getDispketteiriyuunaiyou411() {
        return dispketteiriyuunaiyou411;
    }

    public void setDispketteiriyuunaiyou411(String pDispketteiriyuunaiyou411) {
        dispketteiriyuunaiyou411 = pDispketteiriyuunaiyou411;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai211;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai211() {
        return dispsyoubyoujyoutai211;
    }

    public void setDispsyoubyoujyoutai211(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai211) {
        dispsyoubyoujyoutai211 = pDispsyoubyoujyoutai211;
    }

    private BizDateYM dispkantiym211;

    public BizDateYM getDispkantiym211() {
        return dispkantiym211;
    }

    public void setDispkantiym211(BizDateYM pDispkantiym211) {
        dispkantiym211 = pDispkantiym211;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou11;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou11() {
        return dispmrriyuucdnaiyou11;
    }

    public void setDispmrriyuucdnaiyou11(C_MrRiyuucdKbn pDispmrriyuucdnaiyou11) {
        dispmrriyuucdnaiyou11 = pDispmrriyuucdnaiyou11;
    }

    private Integer disprenno12;

    public Integer getDisprenno12() {
        return disprenno12;
    }

    public void setDisprenno12(Integer pDisprenno12) {
        disprenno12 = pDisprenno12;
    }

    private BizDate dispketymd12;

    public BizDate getDispketymd12() {
        return dispketymd12;
    }

    public void setDispketymd12(BizDate pDispketymd12) {
        dispketymd12 = pDispketymd12;
    }

    private C_Ketkekkacd dispketkekkacd12;

    public C_Ketkekkacd getDispketkekkacd12() {
        return dispketkekkacd12;
    }

    public void setDispketkekkacd12(C_Ketkekkacd pDispketkekkacd12) {
        dispketkekkacd12 = pDispketkekkacd12;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh12;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh12() {
        return dispsntksakuseiyh12;
    }

    public void setDispsntksakuseiyh12(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh12) {
        dispsntksakuseiyh12 = pDispsntksakuseiyh12;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu12;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu12() {
        return disptorikesisyousairiyuu12;
    }

    public void setDisptorikesisyousairiyuu12(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu12) {
        disptorikesisyousairiyuu12 = pDisptorikesisyousairiyuu12;
    }

    private String dispketriyuucd112;

    public String getDispketriyuucd112() {
        return dispketriyuucd112;
    }

    public void setDispketriyuucd112(String pDispketriyuucd112) {
        dispketriyuucd112 = pDispketriyuucd112;
    }

    private String dispketteiriyuunaiyou112;

    public String getDispketteiriyuunaiyou112() {
        return dispketteiriyuunaiyou112;
    }

    public void setDispketteiriyuunaiyou112(String pDispketteiriyuunaiyou112) {
        dispketteiriyuunaiyou112 = pDispketteiriyuunaiyou112;
    }

    private String dispsyoubyoucd112;

    public String getDispsyoubyoucd112() {
        return dispsyoubyoucd112;
    }

    public void setDispsyoubyoucd112(String pDispsyoubyoucd112) {
        dispsyoubyoucd112 = pDispsyoubyoucd112;
    }

    private String dispsyoubyounm112;

    public String getDispsyoubyounm112() {
        return dispsyoubyounm112;
    }

    public void setDispsyoubyounm112(String pDispsyoubyounm112) {
        dispsyoubyounm112 = pDispsyoubyounm112;
    }

    private String dispketriyuucd212;

    public String getDispketriyuucd212() {
        return dispketriyuucd212;
    }

    public void setDispketriyuucd212(String pDispketriyuucd212) {
        dispketriyuucd212 = pDispketriyuucd212;
    }

    private String dispketteiriyuunaiyou212;

    public String getDispketteiriyuunaiyou212() {
        return dispketteiriyuunaiyou212;
    }

    public void setDispketteiriyuunaiyou212(String pDispketteiriyuunaiyou212) {
        dispketteiriyuunaiyou212 = pDispketteiriyuunaiyou212;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai112;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai112() {
        return dispsyoubyoujyoutai112;
    }

    public void setDispsyoubyoujyoutai112(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai112) {
        dispsyoubyoujyoutai112 = pDispsyoubyoujyoutai112;
    }

    private BizDateYM dispkantiym112;

    public BizDateYM getDispkantiym112() {
        return dispkantiym112;
    }

    public void setDispkantiym112(BizDateYM pDispkantiym112) {
        dispkantiym112 = pDispkantiym112;
    }

    private String dispketriyuucd312;

    public String getDispketriyuucd312() {
        return dispketriyuucd312;
    }

    public void setDispketriyuucd312(String pDispketriyuucd312) {
        dispketriyuucd312 = pDispketriyuucd312;
    }

    private String dispketteiriyuunaiyou312;

    public String getDispketteiriyuunaiyou312() {
        return dispketteiriyuunaiyou312;
    }

    public void setDispketteiriyuunaiyou312(String pDispketteiriyuunaiyou312) {
        dispketteiriyuunaiyou312 = pDispketteiriyuunaiyou312;
    }

    private String dispsyoubyoucd212;

    public String getDispsyoubyoucd212() {
        return dispsyoubyoucd212;
    }

    public void setDispsyoubyoucd212(String pDispsyoubyoucd212) {
        dispsyoubyoucd212 = pDispsyoubyoucd212;
    }

    private String dispsyoubyounm212;

    public String getDispsyoubyounm212() {
        return dispsyoubyounm212;
    }

    public void setDispsyoubyounm212(String pDispsyoubyounm212) {
        dispsyoubyounm212 = pDispsyoubyounm212;
    }

    private String dispketriyuucd412;

    public String getDispketriyuucd412() {
        return dispketriyuucd412;
    }

    public void setDispketriyuucd412(String pDispketriyuucd412) {
        dispketriyuucd412 = pDispketriyuucd412;
    }

    private String dispketteiriyuunaiyou412;

    public String getDispketteiriyuunaiyou412() {
        return dispketteiriyuunaiyou412;
    }

    public void setDispketteiriyuunaiyou412(String pDispketteiriyuunaiyou412) {
        dispketteiriyuunaiyou412 = pDispketteiriyuunaiyou412;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai212;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai212() {
        return dispsyoubyoujyoutai212;
    }

    public void setDispsyoubyoujyoutai212(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai212) {
        dispsyoubyoujyoutai212 = pDispsyoubyoujyoutai212;
    }

    private BizDateYM dispkantiym212;

    public BizDateYM getDispkantiym212() {
        return dispkantiym212;
    }

    public void setDispkantiym212(BizDateYM pDispkantiym212) {
        dispkantiym212 = pDispkantiym212;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou12;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou12() {
        return dispmrriyuucdnaiyou12;
    }

    public void setDispmrriyuucdnaiyou12(C_MrRiyuucdKbn pDispmrriyuucdnaiyou12) {
        dispmrriyuucdnaiyou12 = pDispmrriyuucdnaiyou12;
    }

    private Integer disprenno13;

    public Integer getDisprenno13() {
        return disprenno13;
    }

    public void setDisprenno13(Integer pDisprenno13) {
        disprenno13 = pDisprenno13;
    }

    private BizDate dispketymd13;

    public BizDate getDispketymd13() {
        return dispketymd13;
    }

    public void setDispketymd13(BizDate pDispketymd13) {
        dispketymd13 = pDispketymd13;
    }

    private C_Ketkekkacd dispketkekkacd13;

    public C_Ketkekkacd getDispketkekkacd13() {
        return dispketkekkacd13;
    }

    public void setDispketkekkacd13(C_Ketkekkacd pDispketkekkacd13) {
        dispketkekkacd13 = pDispketkekkacd13;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh13;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh13() {
        return dispsntksakuseiyh13;
    }

    public void setDispsntksakuseiyh13(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh13) {
        dispsntksakuseiyh13 = pDispsntksakuseiyh13;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu13;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu13() {
        return disptorikesisyousairiyuu13;
    }

    public void setDisptorikesisyousairiyuu13(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu13) {
        disptorikesisyousairiyuu13 = pDisptorikesisyousairiyuu13;
    }

    private String dispketriyuucd113;

    public String getDispketriyuucd113() {
        return dispketriyuucd113;
    }

    public void setDispketriyuucd113(String pDispketriyuucd113) {
        dispketriyuucd113 = pDispketriyuucd113;
    }

    private String dispketteiriyuunaiyou113;

    public String getDispketteiriyuunaiyou113() {
        return dispketteiriyuunaiyou113;
    }

    public void setDispketteiriyuunaiyou113(String pDispketteiriyuunaiyou113) {
        dispketteiriyuunaiyou113 = pDispketteiriyuunaiyou113;
    }

    private String dispsyoubyoucd113;

    public String getDispsyoubyoucd113() {
        return dispsyoubyoucd113;
    }

    public void setDispsyoubyoucd113(String pDispsyoubyoucd113) {
        dispsyoubyoucd113 = pDispsyoubyoucd113;
    }

    private String dispsyoubyounm113;

    public String getDispsyoubyounm113() {
        return dispsyoubyounm113;
    }

    public void setDispsyoubyounm113(String pDispsyoubyounm113) {
        dispsyoubyounm113 = pDispsyoubyounm113;
    }

    private String dispketriyuucd213;

    public String getDispketriyuucd213() {
        return dispketriyuucd213;
    }

    public void setDispketriyuucd213(String pDispketriyuucd213) {
        dispketriyuucd213 = pDispketriyuucd213;
    }

    private String dispketteiriyuunaiyou213;

    public String getDispketteiriyuunaiyou213() {
        return dispketteiriyuunaiyou213;
    }

    public void setDispketteiriyuunaiyou213(String pDispketteiriyuunaiyou213) {
        dispketteiriyuunaiyou213 = pDispketteiriyuunaiyou213;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai113;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai113() {
        return dispsyoubyoujyoutai113;
    }

    public void setDispsyoubyoujyoutai113(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai113) {
        dispsyoubyoujyoutai113 = pDispsyoubyoujyoutai113;
    }

    private BizDateYM dispkantiym113;

    public BizDateYM getDispkantiym113() {
        return dispkantiym113;
    }

    public void setDispkantiym113(BizDateYM pDispkantiym113) {
        dispkantiym113 = pDispkantiym113;
    }

    private String dispketriyuucd313;

    public String getDispketriyuucd313() {
        return dispketriyuucd313;
    }

    public void setDispketriyuucd313(String pDispketriyuucd313) {
        dispketriyuucd313 = pDispketriyuucd313;
    }

    private String dispketteiriyuunaiyou313;

    public String getDispketteiriyuunaiyou313() {
        return dispketteiriyuunaiyou313;
    }

    public void setDispketteiriyuunaiyou313(String pDispketteiriyuunaiyou313) {
        dispketteiriyuunaiyou313 = pDispketteiriyuunaiyou313;
    }

    private String dispsyoubyoucd213;

    public String getDispsyoubyoucd213() {
        return dispsyoubyoucd213;
    }

    public void setDispsyoubyoucd213(String pDispsyoubyoucd213) {
        dispsyoubyoucd213 = pDispsyoubyoucd213;
    }

    private String dispsyoubyounm213;

    public String getDispsyoubyounm213() {
        return dispsyoubyounm213;
    }

    public void setDispsyoubyounm213(String pDispsyoubyounm213) {
        dispsyoubyounm213 = pDispsyoubyounm213;
    }

    private String dispketriyuucd413;

    public String getDispketriyuucd413() {
        return dispketriyuucd413;
    }

    public void setDispketriyuucd413(String pDispketriyuucd413) {
        dispketriyuucd413 = pDispketriyuucd413;
    }

    private String dispketteiriyuunaiyou413;

    public String getDispketteiriyuunaiyou413() {
        return dispketteiriyuunaiyou413;
    }

    public void setDispketteiriyuunaiyou413(String pDispketteiriyuunaiyou413) {
        dispketteiriyuunaiyou413 = pDispketteiriyuunaiyou413;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai213;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai213() {
        return dispsyoubyoujyoutai213;
    }

    public void setDispsyoubyoujyoutai213(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai213) {
        dispsyoubyoujyoutai213 = pDispsyoubyoujyoutai213;
    }

    private BizDateYM dispkantiym213;

    public BizDateYM getDispkantiym213() {
        return dispkantiym213;
    }

    public void setDispkantiym213(BizDateYM pDispkantiym213) {
        dispkantiym213 = pDispkantiym213;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou13;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou13() {
        return dispmrriyuucdnaiyou13;
    }

    public void setDispmrriyuucdnaiyou13(C_MrRiyuucdKbn pDispmrriyuucdnaiyou13) {
        dispmrriyuucdnaiyou13 = pDispmrriyuucdnaiyou13;
    }

    private Integer disprenno14;

    public Integer getDisprenno14() {
        return disprenno14;
    }

    public void setDisprenno14(Integer pDisprenno14) {
        disprenno14 = pDisprenno14;
    }

    private BizDate dispketymd14;

    public BizDate getDispketymd14() {
        return dispketymd14;
    }

    public void setDispketymd14(BizDate pDispketymd14) {
        dispketymd14 = pDispketymd14;
    }

    private C_Ketkekkacd dispketkekkacd14;

    public C_Ketkekkacd getDispketkekkacd14() {
        return dispketkekkacd14;
    }

    public void setDispketkekkacd14(C_Ketkekkacd pDispketkekkacd14) {
        dispketkekkacd14 = pDispketkekkacd14;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh14;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh14() {
        return dispsntksakuseiyh14;
    }

    public void setDispsntksakuseiyh14(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh14) {
        dispsntksakuseiyh14 = pDispsntksakuseiyh14;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu14;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu14() {
        return disptorikesisyousairiyuu14;
    }

    public void setDisptorikesisyousairiyuu14(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu14) {
        disptorikesisyousairiyuu14 = pDisptorikesisyousairiyuu14;
    }

    private String dispketriyuucd114;

    public String getDispketriyuucd114() {
        return dispketriyuucd114;
    }

    public void setDispketriyuucd114(String pDispketriyuucd114) {
        dispketriyuucd114 = pDispketriyuucd114;
    }

    private String dispketteiriyuunaiyou114;

    public String getDispketteiriyuunaiyou114() {
        return dispketteiriyuunaiyou114;
    }

    public void setDispketteiriyuunaiyou114(String pDispketteiriyuunaiyou114) {
        dispketteiriyuunaiyou114 = pDispketteiriyuunaiyou114;
    }

    private String dispsyoubyoucd114;

    public String getDispsyoubyoucd114() {
        return dispsyoubyoucd114;
    }

    public void setDispsyoubyoucd114(String pDispsyoubyoucd114) {
        dispsyoubyoucd114 = pDispsyoubyoucd114;
    }

    private String dispsyoubyounm114;

    public String getDispsyoubyounm114() {
        return dispsyoubyounm114;
    }

    public void setDispsyoubyounm114(String pDispsyoubyounm114) {
        dispsyoubyounm114 = pDispsyoubyounm114;
    }

    private String dispketriyuucd214;

    public String getDispketriyuucd214() {
        return dispketriyuucd214;
    }

    public void setDispketriyuucd214(String pDispketriyuucd214) {
        dispketriyuucd214 = pDispketriyuucd214;
    }

    private String dispketteiriyuunaiyou214;

    public String getDispketteiriyuunaiyou214() {
        return dispketteiriyuunaiyou214;
    }

    public void setDispketteiriyuunaiyou214(String pDispketteiriyuunaiyou214) {
        dispketteiriyuunaiyou214 = pDispketteiriyuunaiyou214;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai114;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai114() {
        return dispsyoubyoujyoutai114;
    }

    public void setDispsyoubyoujyoutai114(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai114) {
        dispsyoubyoujyoutai114 = pDispsyoubyoujyoutai114;
    }

    private BizDateYM dispkantiym114;

    public BizDateYM getDispkantiym114() {
        return dispkantiym114;
    }

    public void setDispkantiym114(BizDateYM pDispkantiym114) {
        dispkantiym114 = pDispkantiym114;
    }

    private String dispketriyuucd314;

    public String getDispketriyuucd314() {
        return dispketriyuucd314;
    }

    public void setDispketriyuucd314(String pDispketriyuucd314) {
        dispketriyuucd314 = pDispketriyuucd314;
    }

    private String dispketteiriyuunaiyou314;

    public String getDispketteiriyuunaiyou314() {
        return dispketteiriyuunaiyou314;
    }

    public void setDispketteiriyuunaiyou314(String pDispketteiriyuunaiyou314) {
        dispketteiriyuunaiyou314 = pDispketteiriyuunaiyou314;
    }

    private String dispsyoubyoucd214;

    public String getDispsyoubyoucd214() {
        return dispsyoubyoucd214;
    }

    public void setDispsyoubyoucd214(String pDispsyoubyoucd214) {
        dispsyoubyoucd214 = pDispsyoubyoucd214;
    }

    private String dispsyoubyounm214;

    public String getDispsyoubyounm214() {
        return dispsyoubyounm214;
    }

    public void setDispsyoubyounm214(String pDispsyoubyounm214) {
        dispsyoubyounm214 = pDispsyoubyounm214;
    }

    private String dispketriyuucd414;

    public String getDispketriyuucd414() {
        return dispketriyuucd414;
    }

    public void setDispketriyuucd414(String pDispketriyuucd414) {
        dispketriyuucd414 = pDispketriyuucd414;
    }

    private String dispketteiriyuunaiyou414;

    public String getDispketteiriyuunaiyou414() {
        return dispketteiriyuunaiyou414;
    }

    public void setDispketteiriyuunaiyou414(String pDispketteiriyuunaiyou414) {
        dispketteiriyuunaiyou414 = pDispketteiriyuunaiyou414;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai214;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai214() {
        return dispsyoubyoujyoutai214;
    }

    public void setDispsyoubyoujyoutai214(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai214) {
        dispsyoubyoujyoutai214 = pDispsyoubyoujyoutai214;
    }

    private BizDateYM dispkantiym214;

    public BizDateYM getDispkantiym214() {
        return dispkantiym214;
    }

    public void setDispkantiym214(BizDateYM pDispkantiym214) {
        dispkantiym214 = pDispkantiym214;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou14;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou14() {
        return dispmrriyuucdnaiyou14;
    }

    public void setDispmrriyuucdnaiyou14(C_MrRiyuucdKbn pDispmrriyuucdnaiyou14) {
        dispmrriyuucdnaiyou14 = pDispmrriyuucdnaiyou14;
    }

    private Integer disprenno15;

    public Integer getDisprenno15() {
        return disprenno15;
    }

    public void setDisprenno15(Integer pDisprenno15) {
        disprenno15 = pDisprenno15;
    }

    private BizDate dispketymd15;

    public BizDate getDispketymd15() {
        return dispketymd15;
    }

    public void setDispketymd15(BizDate pDispketymd15) {
        dispketymd15 = pDispketymd15;
    }

    private C_Ketkekkacd dispketkekkacd15;

    public C_Ketkekkacd getDispketkekkacd15() {
        return dispketkekkacd15;
    }

    public void setDispketkekkacd15(C_Ketkekkacd pDispketkekkacd15) {
        dispketkekkacd15 = pDispketkekkacd15;
    }

    private C_SntkinfosakuseiyhKbn dispsntksakuseiyh15;

    public C_SntkinfosakuseiyhKbn getDispsntksakuseiyh15() {
        return dispsntksakuseiyh15;
    }

    public void setDispsntksakuseiyh15(C_SntkinfosakuseiyhKbn pDispsntksakuseiyh15) {
        dispsntksakuseiyh15 = pDispsntksakuseiyh15;
    }

    private C_TorikesisyousairiyuuCd disptorikesisyousairiyuu15;

    public C_TorikesisyousairiyuuCd getDisptorikesisyousairiyuu15() {
        return disptorikesisyousairiyuu15;
    }

    public void setDisptorikesisyousairiyuu15(C_TorikesisyousairiyuuCd pDisptorikesisyousairiyuu15) {
        disptorikesisyousairiyuu15 = pDisptorikesisyousairiyuu15;
    }

    private String dispketriyuucd115;

    public String getDispketriyuucd115() {
        return dispketriyuucd115;
    }

    public void setDispketriyuucd115(String pDispketriyuucd115) {
        dispketriyuucd115 = pDispketriyuucd115;
    }

    private String dispketteiriyuunaiyou115;

    public String getDispketteiriyuunaiyou115() {
        return dispketteiriyuunaiyou115;
    }

    public void setDispketteiriyuunaiyou115(String pDispketteiriyuunaiyou115) {
        dispketteiriyuunaiyou115 = pDispketteiriyuunaiyou115;
    }

    private String dispsyoubyoucd115;

    public String getDispsyoubyoucd115() {
        return dispsyoubyoucd115;
    }

    public void setDispsyoubyoucd115(String pDispsyoubyoucd115) {
        dispsyoubyoucd115 = pDispsyoubyoucd115;
    }

    private String dispsyoubyounm115;

    public String getDispsyoubyounm115() {
        return dispsyoubyounm115;
    }

    public void setDispsyoubyounm115(String pDispsyoubyounm115) {
        dispsyoubyounm115 = pDispsyoubyounm115;
    }

    private String dispketriyuucd215;

    public String getDispketriyuucd215() {
        return dispketriyuucd215;
    }

    public void setDispketriyuucd215(String pDispketriyuucd215) {
        dispketriyuucd215 = pDispketriyuucd215;
    }

    private String dispketteiriyuunaiyou215;

    public String getDispketteiriyuunaiyou215() {
        return dispketteiriyuunaiyou215;
    }

    public void setDispketteiriyuunaiyou215(String pDispketteiriyuunaiyou215) {
        dispketteiriyuunaiyou215 = pDispketteiriyuunaiyou215;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai115;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai115() {
        return dispsyoubyoujyoutai115;
    }

    public void setDispsyoubyoujyoutai115(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai115) {
        dispsyoubyoujyoutai115 = pDispsyoubyoujyoutai115;
    }

    private BizDateYM dispkantiym115;

    public BizDateYM getDispkantiym115() {
        return dispkantiym115;
    }

    public void setDispkantiym115(BizDateYM pDispkantiym115) {
        dispkantiym115 = pDispkantiym115;
    }

    private String dispketriyuucd315;

    public String getDispketriyuucd315() {
        return dispketriyuucd315;
    }

    public void setDispketriyuucd315(String pDispketriyuucd315) {
        dispketriyuucd315 = pDispketriyuucd315;
    }

    private String dispketteiriyuunaiyou315;

    public String getDispketteiriyuunaiyou315() {
        return dispketteiriyuunaiyou315;
    }

    public void setDispketteiriyuunaiyou315(String pDispketteiriyuunaiyou315) {
        dispketteiriyuunaiyou315 = pDispketteiriyuunaiyou315;
    }

    private String dispsyoubyoucd215;

    public String getDispsyoubyoucd215() {
        return dispsyoubyoucd215;
    }

    public void setDispsyoubyoucd215(String pDispsyoubyoucd215) {
        dispsyoubyoucd215 = pDispsyoubyoucd215;
    }

    private String dispsyoubyounm215;

    public String getDispsyoubyounm215() {
        return dispsyoubyounm215;
    }

    public void setDispsyoubyounm215(String pDispsyoubyounm215) {
        dispsyoubyounm215 = pDispsyoubyounm215;
    }

    private String dispketriyuucd415;

    public String getDispketriyuucd415() {
        return dispketriyuucd415;
    }

    public void setDispketriyuucd415(String pDispketriyuucd415) {
        dispketriyuucd415 = pDispketriyuucd415;
    }

    private String dispketteiriyuunaiyou415;

    public String getDispketteiriyuunaiyou415() {
        return dispketteiriyuunaiyou415;
    }

    public void setDispketteiriyuunaiyou415(String pDispketteiriyuunaiyou415) {
        dispketteiriyuunaiyou415 = pDispketteiriyuunaiyou415;
    }

    private C_SyoubyoujyoutaiKbn dispsyoubyoujyoutai215;

    public C_SyoubyoujyoutaiKbn getDispsyoubyoujyoutai215() {
        return dispsyoubyoujyoutai215;
    }

    public void setDispsyoubyoujyoutai215(C_SyoubyoujyoutaiKbn pDispsyoubyoujyoutai215) {
        dispsyoubyoujyoutai215 = pDispsyoubyoujyoutai215;
    }

    private BizDateYM dispkantiym215;

    public BizDateYM getDispkantiym215() {
        return dispkantiym215;
    }

    public void setDispkantiym215(BizDateYM pDispkantiym215) {
        dispkantiym215 = pDispkantiym215;
    }

    private C_MrRiyuucdKbn dispmrriyuucdnaiyou15;

    public C_MrRiyuucdKbn getDispmrriyuucdnaiyou15() {
        return dispmrriyuucdnaiyou15;
    }

    public void setDispmrriyuucdnaiyou15(C_MrRiyuucdKbn pDispmrriyuucdnaiyou15) {
        dispmrriyuucdnaiyou15 = pDispmrriyuucdnaiyou15;
    }

    private C_NyuukinjyoutaiKbn nyuukinjoutaikbn;

    public C_NyuukinjyoutaiKbn getNyuukinjoutaikbn() {
        return nyuukinjoutaikbn;
    }

    public void setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn pNyuukinjoutaikbn) {
        nyuukinjoutaikbn = pNyuukinjoutaikbn;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency fstphrkgk;

    public BizCurrency getFstphrkgk() {
        return fstphrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFstphrkgk(BizCurrency pFstphrkgk) {
        fstphrkgk = pFstphrkgk;
    }

    @CurrencyLenght(length=12)
    @PositiveNumberBizCalcble
    private BizCurrency rsgakukei;

    public BizCurrency getRsgakukei() {
        return rsgakukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgakukei(BizCurrency pRsgakukei) {
        rsgakukei = pRsgakukei;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency fstphrkgkhrktuuka;

    public BizCurrency getFstphrkgkhrktuuka() {
        return fstphrkgkhrktuuka;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFstphrkgkhrktuuka(BizCurrency pFstphrkgkhrktuuka) {
        fstphrkgkhrktuuka = pFstphrkgkhrktuuka;
    }

    private BizDate nyknkwsratetkyymd;

    public BizDate getNyknkwsratetkyymd() {
        return nyknkwsratetkyymd;
    }

    public void setNyknkwsratetkyymd(BizDate pNyknkwsratetkyymd) {
        nyknkwsratetkyymd = pNyknkwsratetkyymd;
    }

    private BizNumber nyknkwsrate2;

    public BizNumber getNyknkwsrate2() {
        return nyknkwsrate2;
    }

    public void setNyknkwsrate2(BizNumber pNyknkwsrate2) {
        nyknkwsrate2 = pNyknkwsrate2;
    }

    private BizDate fstpryosyuymd;

    public BizDate getFstpryosyuymd() {
        return fstpryosyuymd;
    }

    public void setFstpryosyuymd(BizDate pFstpryosyuymd) {
        fstpryosyuymd = pFstpryosyuymd;
    }

    private BizNumber denkawaserate;

    public BizNumber getDenkawaserate() {
        return denkawaserate;
    }

    public void setDenkawaserate(BizNumber pDenkawaserate) {
        denkawaserate = pDenkawaserate;
    }

    private C_BlnktkumuKbn dispzenkizennouumu;

    public C_BlnktkumuKbn getDispzenkizennouumu() {
        return dispzenkizennouumu;
    }

    public void setDispzenkizennouumu(C_BlnktkumuKbn pDispzenkizennouumu) {
        dispzenkizennouumu = pDispzenkizennouumu;
    }

    private Integer dispznnkai;

    public Integer getDispznnkai() {
        return dispznnkai;
    }

    public void setDispznnkai(Integer pDispznnkai) {
        dispznnkai = pDispznnkai;
    }

    private C_Hrkkaisuu disphrkkaisuu;

    public C_Hrkkaisuu getDisphrkkaisuu() {
        return disphrkkaisuu;
    }

    public void setDisphrkkaisuu(C_Hrkkaisuu pDisphrkkaisuu) {
        disphrkkaisuu = pDisphrkkaisuu;
    }

    private C_Hrkkeiro disphrkkeiro;

    public C_Hrkkeiro getDisphrkkeiro() {
        return disphrkkeiro;
    }

    public void setDisphrkkeiro(C_Hrkkeiro pDisphrkkeiro) {
        disphrkkeiro = pDisphrkkeiro;
    }

    private C_FstphrkkeiroKbn dispfstphrkkeirokbn;

    public C_FstphrkkeiroKbn getDispfstphrkkeirokbn() {
        return dispfstphrkkeirokbn;
    }

    public void setDispfstphrkkeirokbn(C_FstphrkkeiroKbn pDispfstphrkkeirokbn) {
        dispfstphrkkeirokbn = pDispfstphrkkeirokbn;
    }

    private C_IkkatubaraiKaisuuKbn dispteikiikkatubaraikaisuu;

    public C_IkkatubaraiKaisuuKbn getDispteikiikkatubaraikaisuu() {
        return dispteikiikkatubaraikaisuu;
    }

    public void setDispteikiikkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pDispteikiikkatubaraikaisuu) {
        dispteikiikkatubaraikaisuu = pDispteikiikkatubaraikaisuu;
    }

    private BizCurrency hituyouikkatup;

    public BizCurrency getHituyouikkatup() {
        return hituyouikkatup;
    }

    public void setHituyouikkatup(BizCurrency pHituyouikkatup) {
        hituyouikkatup = pHituyouikkatup;
    }

    private BizCurrency husokuikkatup;

    public BizCurrency getHusokuikkatup() {
        return husokuikkatup;
    }

    public void setHusokuikkatup(BizCurrency pHusokuikkatup) {
        husokuikkatup = pHusokuikkatup;
    }

    private Integer ikkatuyoupkaisuu;

    public Integer getIkkatuyoupkaisuu() {
        return ikkatuyoupkaisuu;
    }

    public void setIkkatuyoupkaisuu(Integer pIkkatuyoupkaisuu) {
        ikkatuyoupkaisuu = pIkkatuyoupkaisuu;
    }

    private Integer genzaiikkatukaisuu;

    public Integer getGenzaiikkatukaisuu() {
        return genzaiikkatukaisuu;
    }

    public void setGenzaiikkatukaisuu(Integer pGenzaiikkatukaisuu) {
        genzaiikkatukaisuu = pGenzaiikkatukaisuu;
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

    private String modorubtnbykensaku;

    public String getModorubtnbykensaku() {
        return modorubtnbykensaku;
    }

    public void setModorubtnbykensaku(String pModorubtnbykensaku) {
        modorubtnbykensaku = pModorubtnbykensaku;
    }
}
