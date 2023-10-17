package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkImuSateiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private DataSource<SentakuJouhouDataSourceBean> sentakuJouhouDataSource = new DataSource<>();
    public DataSource<SentakuJouhouDataSourceBean> getSentakuJouhouDataSource() {
        return sentakuJouhouDataSource;
    }

    @Deprecated
    public List<SentakuJouhouDataSourceBean> getSentakuJouhou() {
        return sentakuJouhouDataSource.getDatas();
    }

    public void setSentakuJouhou(List<SentakuJouhouDataSourceBean> pSentakuJouhou) {
        sentakuJouhouDataSource.setDatas(pSentakuJouhou);
    }

    private DataSource<ToriatukaiTyuuiJouhouDataSourceBean> toriatukaiTyuuiJouhouDataSource = new DataSource<>();
    public DataSource<ToriatukaiTyuuiJouhouDataSourceBean> getToriatukaiTyuuiJouhouDataSource() {
        return toriatukaiTyuuiJouhouDataSource;
    }

    @Deprecated
    public List<ToriatukaiTyuuiJouhouDataSourceBean> getToriatukaiTyuuiJouhou() {
        return toriatukaiTyuuiJouhouDataSource.getDatas();
    }

    public void setToriatukaiTyuuiJouhou(List<ToriatukaiTyuuiJouhouDataSourceBean> pToriatukaiTyuuiJouhou) {
        toriatukaiTyuuiJouhouDataSource.setDatas(pToriatukaiTyuuiJouhou);
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

    private DataSource<MoushiTenkenRirekiDataSourceBean> moushiTenkenRirekiDataSource = new DataSource<>();
    public DataSource<MoushiTenkenRirekiDataSourceBean> getMoushiTenkenRirekiDataSource() {
        return moushiTenkenRirekiDataSource;
    }

    @Deprecated
    public List<MoushiTenkenRirekiDataSourceBean> getMoushiTenkenRireki() {
        return moushiTenkenRirekiDataSource.getDatas();
    }

    public void setMoushiTenkenRireki(List<MoushiTenkenRirekiDataSourceBean> pMoushiTenkenRireki) {
        moushiTenkenRirekiDataSource.setDatas(pMoushiTenkenRireki);
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

    private String imusateisijinaiyou;

    public String getImusateisijinaiyou() {
        return imusateisijinaiyou;
    }

    public void setImusateisijinaiyou(String pImusateisijinaiyou) {
        imusateisijinaiyou = pImusateisijinaiyou;
    }

    private String zenimusateicomment;

    public String getZenimusateicomment() {
        return zenimusateicomment;
    }

    public void setZenimusateicomment(String pZenimusateicomment) {
        zenimusateicomment = pZenimusateicomment;
    }

    private BizNumber bmi;

    public BizNumber getBmi() {
        return bmi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBmi(BizNumber pBmi) {
        bmi = pBmi;
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

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private C_SyorikekkaKbn imusateikekkakbn;

    public C_SyorikekkaKbn getImusateikekkakbn() {
        return imusateikekkakbn;
    }

    public void setImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        imusateikekkakbn = pImusateikekkakbn;
    }

    private String imutnsketsyacd;

    public String getImutnsketsyacd() {
        return imutnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setImutnsketsyacd(String pImutnsketsyacd) {
        imutnsketsyacd = pImutnsketsyacd;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String imusateicommentgamen;

    public String getImusateicommentgamen() {
        return imusateicommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setImusateicommentgamen(String pImusateicommentgamen) {
        imusateicommentgamen = pImusateicommentgamen;
    }

    private Boolean hubihassintns;

    public Boolean getHubihassintns() {
        return (hubihassintns == null) ? Boolean.FALSE : hubihassintns;
    }

    public void setHubihassintns(Boolean pHubihassintns) {
        hubihassintns = (pHubihassintns == null) ? Boolean.FALSE : pHubihassintns;
    }

    private C_HubihassintnsKbn hubihassintnskbn;

    public C_HubihassintnsKbn getHubihassintnskbn() {
        return hubihassintnskbn;
    }

    public void setHubihassintnskbn(C_HubihassintnsKbn pHubihassintnskbn) {
        hubihassintnskbn = pHubihassintnskbn;
    }

    private C_Ketkekkacd ketkekkacd;

    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String syoubyoucd1;

    public String getSyoubyoucd1() {
        return syoubyoucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd1(String pSyoubyoucd1) {
        syoubyoucd1 = pSyoubyoucd1;
    }

    private String syoubyounm1;

    public String getSyoubyounm1() {
        return syoubyounm1;
    }

    @DataConvert("toMultiByte")
    public void setSyoubyounm1(String pSyoubyounm1) {
        syoubyounm1 = pSyoubyounm1;
    }

    @MaxLength(max=2)
    @AlphaDigit
    @HostInvalidCharacter
    private String ketriyuucd1gamen;

    public String getKetriyuucd1gamen() {
        return ketriyuucd1gamen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetriyuucd1gamen(String pKetriyuucd1gamen) {
        ketriyuucd1gamen = pKetriyuucd1gamen;
    }

    private C_Ketriyuucd ketteiriyuunaiyou1;

    public C_Ketriyuucd getKetteiriyuunaiyou1() {
        return ketteiriyuunaiyou1;
    }

    public void setKetteiriyuunaiyou1(C_Ketriyuucd pKetteiriyuunaiyou1) {
        ketteiriyuunaiyou1 = pKetteiriyuunaiyou1;
    }

    private C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1;

    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn1() {
        return syoubyoujyoutaikbn1;
    }

    public void setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn1) {
        syoubyoujyoutaikbn1 = pSyoubyoujyoutaikbn1;
    }

    @ValidDateYm
    private BizDateYM kantiym1;

    public BizDateYM getKantiym1() {
        return kantiym1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym1(BizDateYM pKantiym1) {
        kantiym1 = pKantiym1;
    }

    @MaxLength(max=2)
    @AlphaDigit
    @HostInvalidCharacter
    private String ketriyuucd2gamen;

    public String getKetriyuucd2gamen() {
        return ketriyuucd2gamen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetriyuucd2gamen(String pKetriyuucd2gamen) {
        ketriyuucd2gamen = pKetriyuucd2gamen;
    }

    private C_Ketriyuucd ketteiriyuunaiyou2;

    public C_Ketriyuucd getKetteiriyuunaiyou2() {
        return ketteiriyuunaiyou2;
    }

    public void setKetteiriyuunaiyou2(C_Ketriyuucd pKetteiriyuunaiyou2) {
        ketteiriyuunaiyou2 = pKetteiriyuunaiyou2;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String syoubyoucd2;

    public String getSyoubyoucd2() {
        return syoubyoucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd2(String pSyoubyoucd2) {
        syoubyoucd2 = pSyoubyoucd2;
    }

    private String syoubyounm2;

    public String getSyoubyounm2() {
        return syoubyounm2;
    }

    @DataConvert("toMultiByte")
    public void setSyoubyounm2(String pSyoubyounm2) {
        syoubyounm2 = pSyoubyounm2;
    }

    @MaxLength(max=2)
    @AlphaDigit
    @HostInvalidCharacter
    private String ketriyuucd3gamen;

    public String getKetriyuucd3gamen() {
        return ketriyuucd3gamen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetriyuucd3gamen(String pKetriyuucd3gamen) {
        ketriyuucd3gamen = pKetriyuucd3gamen;
    }

    private C_Ketriyuucd ketteiriyuunaiyou3;

    public C_Ketriyuucd getKetteiriyuunaiyou3() {
        return ketteiriyuunaiyou3;
    }

    public void setKetteiriyuunaiyou3(C_Ketriyuucd pKetteiriyuunaiyou3) {
        ketteiriyuunaiyou3 = pKetteiriyuunaiyou3;
    }

    private C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2;

    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn2() {
        return syoubyoujyoutaikbn2;
    }

    public void setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn2) {
        syoubyoujyoutaikbn2 = pSyoubyoujyoutaikbn2;
    }

    @ValidDateYm
    private BizDateYM kantiym2;

    public BizDateYM getKantiym2() {
        return kantiym2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym2(BizDateYM pKantiym2) {
        kantiym2 = pKantiym2;
    }

    @MaxLength(max=2)
    @AlphaDigit
    @HostInvalidCharacter
    private String ketriyuucd4gamen;

    public String getKetriyuucd4gamen() {
        return ketriyuucd4gamen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetriyuucd4gamen(String pKetriyuucd4gamen) {
        ketriyuucd4gamen = pKetriyuucd4gamen;
    }

    private C_Ketriyuucd ketteiriyuunaiyou4;

    public C_Ketriyuucd getKetteiriyuunaiyou4() {
        return ketteiriyuunaiyou4;
    }

    public void setKetteiriyuunaiyou4(C_Ketriyuucd pKetteiriyuunaiyou4) {
        ketteiriyuunaiyou4 = pKetteiriyuunaiyou4;
    }

    private C_SntkinfosakuseiyhKbn sntkinfosakuseiyhkbn;

    public C_SntkinfosakuseiyhKbn getSntkinfosakuseiyhkbn() {
        return sntkinfosakuseiyhkbn;
    }

    public void setSntkinfosakuseiyhkbn(C_SntkinfosakuseiyhKbn pSntkinfosakuseiyhkbn) {
        sntkinfosakuseiyhkbn = pSntkinfosakuseiyhkbn;
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

    private C_SyorikekkaKbn mostenkenkekkakbn;

    public C_SyorikekkaKbn getMostenkenkekkakbn() {
        return mostenkenkekkakbn;
    }

    public void setMostenkenkekkakbn(C_SyorikekkaKbn pMostenkenkekkakbn) {
        mostenkenkekkakbn = pMostenkenkekkakbn;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String mostenkeniraicomment;

    public String getMostenkeniraicomment() {
        return mostenkeniraicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setMostenkeniraicomment(String pMostenkeniraicomment) {
        mostenkeniraicomment = pMostenkeniraicomment;
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

    private LoopChain<UserDefsList> imutnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getImutnsketsyacdOptionBeanList() {
        return imutnsketsyacdOptionBeanList.get();
    }

    public void setImutnsketsyacdOptionBeanList(UserDefsList pImutnsketsyacdOptionBeanList) {
        clearImutnsketsyacdOptionBeanList();
        imutnsketsyacdOptionBeanList.add(pImutnsketsyacdOptionBeanList);
    }

    public void clearImutnsketsyacdOptionBeanList() {
        imutnsketsyacdOptionBeanList.clear();
    }
}
