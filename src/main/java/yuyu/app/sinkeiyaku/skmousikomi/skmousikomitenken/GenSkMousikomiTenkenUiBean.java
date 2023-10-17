package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込点検 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkMousikomiTenkenUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private DataSource<MousikomiTenkenRirekiDataSourceBean> mousikomiTenkenRirekiDataSource = new DataSource<>();
    public DataSource<MousikomiTenkenRirekiDataSourceBean> getMousikomiTenkenRirekiDataSource() {
        return mousikomiTenkenRirekiDataSource;
    }

    @Deprecated
    public List<MousikomiTenkenRirekiDataSourceBean> getMousikomiTenkenRireki() {
        return mousikomiTenkenRirekiDataSource.getDatas();
    }

    public void setMousikomiTenkenRireki(List<MousikomiTenkenRirekiDataSourceBean> pMousikomiTenkenRireki) {
        mousikomiTenkenRirekiDataSource.setDatas(pMousikomiTenkenRireki);
    }

    private DataSource<SkToriatukaiTyuuiJouhouDataSourceBean> skToriatukaiTyuuiJouhouDataSource = new DataSource<>();
    public DataSource<SkToriatukaiTyuuiJouhouDataSourceBean> getSkToriatukaiTyuuiJouhouDataSource() {
        return skToriatukaiTyuuiJouhouDataSource;
    }

    @Deprecated
    public List<SkToriatukaiTyuuiJouhouDataSourceBean> getSkToriatukaiTyuuiJouhou() {
        return skToriatukaiTyuuiJouhouDataSource.getDatas();
    }

    public void setSkToriatukaiTyuuiJouhou(List<SkToriatukaiTyuuiJouhouDataSourceBean> pSkToriatukaiTyuuiJouhou) {
        skToriatukaiTyuuiJouhouDataSource.setDatas(pSkToriatukaiTyuuiJouhou);
    }

    private DataSource<KankyouSateiRirekiDataSourceBean> kankyouSateiRirekiDataSource = new DataSource<>();
    public DataSource<KankyouSateiRirekiDataSourceBean> getKankyouSateiRirekiDataSource() {
        return kankyouSateiRirekiDataSource;
    }

    @Deprecated
    public List<KankyouSateiRirekiDataSourceBean> getKankyouSateiRireki() {
        return kankyouSateiRirekiDataSource.getDatas();
    }

    public void setKankyouSateiRireki(List<KankyouSateiRirekiDataSourceBean> pKankyouSateiRireki) {
        kankyouSateiRirekiDataSource.setDatas(pKankyouSateiRireki);
    }

    private DataSource<ImuSateiRirekiDataSourceBean> imuSateiRirekiDataSource = new DataSource<>();
    public DataSource<ImuSateiRirekiDataSourceBean> getImuSateiRirekiDataSource() {
        return imuSateiRirekiDataSource;
    }

    @Deprecated
    public List<ImuSateiRirekiDataSourceBean> getImuSateiRireki() {
        return imuSateiRirekiDataSource.getDatas();
    }

    public void setImuSateiRireki(List<ImuSateiRirekiDataSourceBean> pImuSateiRireki) {
        imuSateiRirekiDataSource.setDatas(pImuSateiRireki);
    }

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
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

    private String mostenkensjnaiyou;

    public String getMostenkensjnaiyou() {
        return mostenkensjnaiyou;
    }

    public void setMostenkensjnaiyou(String pMostenkensjnaiyou) {
        mostenkensjnaiyou = pMostenkensjnaiyou;
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

    private String zenkaiknksateicomnt;

    public String getZenkaiknksateicomnt() {
        return zenkaiknksateicomnt;
    }

    public void setZenkaiknksateicomnt(String pZenkaiknksateicomnt) {
        zenkaiknksateicomnt = pZenkaiknksateicomnt;
    }

    private C_TkhjnKbn tkhjnkbn;

    public C_TkhjnKbn getTkhjnkbn() {
        return tkhjnkbn;
    }

    public void setTkhjnkbn(C_TkhjnKbn pTkhjnkbn) {
        tkhjnkbn = pTkhjnkbn;
    }

    private C_FatcakakkekkaKbn fatcakakkekkakbn;

    public C_FatcakakkekkaKbn getFatcakakkekkakbn() {
        return fatcakakkekkakbn;
    }

    public void setFatcakakkekkakbn(C_FatcakakkekkaKbn pFatcakakkekkakbn) {
        fatcakakkekkakbn = pFatcakakkekkakbn;
    }

    private C_AeoiKekkaKbn aeoikekkakbn;

    public C_AeoiKekkaKbn getAeoikekkakbn() {
        return aeoikekkakbn;
    }

    public void setAeoikekkakbn(C_AeoiKekkaKbn pAeoikekkakbn) {
        aeoikekkakbn = pAeoikekkakbn;
    }

    private Boolean uktkak;

    public Boolean getUktkak() {
        return (uktkak == null) ? Boolean.FALSE : uktkak;
    }

    public void setUktkak(Boolean pUktkak) {
        uktkak = (pUktkak == null) ? Boolean.FALSE : pUktkak;
    }

    private C_UktkakKbn uktkakkbn;

    public C_UktkakKbn getUktkakkbn() {
        return uktkakkbn;
    }

    public void setUktkakkbn(C_UktkakKbn pUktkakkbn) {
        uktkakkbn = pUktkakkbn;
    }

    private Boolean tkhsyouryaku;

    public Boolean getTkhsyouryaku() {
        return (tkhsyouryaku == null) ? Boolean.FALSE : tkhsyouryaku;
    }

    public void setTkhsyouryaku(Boolean pTkhsyouryaku) {
        tkhsyouryaku = (pTkhsyouryaku == null) ? Boolean.FALSE : pTkhsyouryaku;
    }

    private C_UmuKbn tkhsyouryakuumukbn;

    public C_UmuKbn getTkhsyouryakuumukbn() {
        return tkhsyouryakuumukbn;
    }

    public void setTkhsyouryakuumukbn(C_UmuKbn pTkhsyouryakuumukbn) {
        tkhsyouryakuumukbn = pTkhsyouryakuumukbn;
    }

    private C_KoureisyaTaiouKbn koureitaioukbn;

    public C_KoureisyaTaiouKbn getKoureitaioukbn() {
        return koureitaioukbn;
    }

    public void setKoureitaioukbn(C_KoureisyaTaiouKbn pKoureitaioukbn) {
        koureitaioukbn = pKoureitaioukbn;
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

    private C_SyorikekkaKbn mostenkenkekkakbn;

    public C_SyorikekkaKbn getMostenkenkekkakbn() {
        return mostenkenkekkakbn;
    }

    public void setMostenkenkekkakbn(C_SyorikekkaKbn pMostenkenkekkakbn) {
        mostenkenkekkakbn = pMostenkenkekkakbn;
    }

    private String mostenkentnsketsyacd;

    public String getMostenkentnsketsyacd() {
        return mostenkentnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMostenkentnsketsyacd(String pMostenkentnsketsyacd) {
        mostenkentnsketsyacd = pMostenkentnsketsyacd;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String mostenkencommentgamen;

    public String getMostenkencommentgamen() {
        return mostenkencommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setMostenkencommentgamen(String pMostenkencommentgamen) {
        mostenkencommentgamen = pMostenkencommentgamen;
    }

    private C_SyorikekkaKbn knksateikekkakbn;

    public C_SyorikekkaKbn getKnksateikekkakbn() {
        return knksateikekkakbn;
    }

    public void setKnksateikekkakbn(C_SyorikekkaKbn pKnksateikekkakbn) {
        knksateikekkakbn = pKnksateikekkakbn;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String knksateiiraicomment;

    public String getKnksateiiraicomment() {
        return knksateiiraicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnksateiiraicomment(String pKnksateiiraicomment) {
        knksateiiraicomment = pKnksateiiraicomment;
    }

    private C_SyorikekkaKbn imusateikekkakbn;

    public C_SyorikekkaKbn getImusateikekkakbn() {
        return imusateikekkakbn;
    }

    public void setImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        imusateikekkakbn = pImusateikekkakbn;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String imusateiiraicomment;

    public String getImusateiiraicomment() {
        return imusateiiraicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setImusateiiraicomment(String pImusateiiraicomment) {
        imusateiiraicomment = pImusateiiraicomment;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String hbcmntkkt;

    public String getHbcmntkkt() {
        return hbcmntkkt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHbcmntkkt(String pHbcmntkkt) {
        hbcmntkkt = pHbcmntkkt;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    private String uniqueid2;

    public String getUniqueid2() {
        return uniqueid2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueid2(String pUniqueid2) {
        uniqueid2 = pUniqueid2;
    }

    private String hubitourokumode;

    public String getHubitourokumode() {
        return hubitourokumode;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubitourokumode(String pHubitourokumode) {
        hubitourokumode = pHubitourokumode;
    }

    private LoopChain<UserDefsList> mostenkentnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getMostenkentnsketsyacdOptionBeanList() {
        return mostenkentnsketsyacdOptionBeanList.get();
    }

    public void setMostenkentnsketsyacdOptionBeanList(UserDefsList pMostenkentnsketsyacdOptionBeanList) {
        clearMostenkentnsketsyacdOptionBeanList();
        mostenkentnsketsyacdOptionBeanList.add(pMostenkentnsketsyacdOptionBeanList);
    }

    public void clearMostenkentnsketsyacdOptionBeanList() {
        mostenkentnsketsyacdOptionBeanList.clear();
    }
}
