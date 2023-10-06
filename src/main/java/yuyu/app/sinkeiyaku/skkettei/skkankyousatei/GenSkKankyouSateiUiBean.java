package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
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
import yuyu.def.classification.C_LinckakKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 環境査定 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkKankyouSateiUiBean extends AbstractUiBean {

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

    private DataSource<MosTenkenRirekiDataSourceBean> mosTenkenRirekiDataSource = new DataSource<>();
    public DataSource<MosTenkenRirekiDataSourceBean> getMosTenkenRirekiDataSource() {
        return mosTenkenRirekiDataSource;
    }

    @Deprecated
    public List<MosTenkenRirekiDataSourceBean> getMosTenkenRireki() {
        return mosTenkenRirekiDataSource.getDatas();
    }

    public void setMosTenkenRireki(List<MosTenkenRirekiDataSourceBean> pMosTenkenRireki) {
        mosTenkenRirekiDataSource.setDatas(pMosTenkenRireki);
    }

    private DataSource<TasyaKanyuuJoukyouDataSourceBean> tasyaKanyuuJoukyouDataSource = new DataSource<>();
    public DataSource<TasyaKanyuuJoukyouDataSourceBean> getTasyaKanyuuJoukyouDataSource() {
        return tasyaKanyuuJoukyouDataSource;
    }

    @Deprecated
    public List<TasyaKanyuuJoukyouDataSourceBean> getTasyaKanyuuJoukyou() {
        return tasyaKanyuuJoukyouDataSource.getDatas();
    }

    public void setTasyaKanyuuJoukyou(List<TasyaKanyuuJoukyouDataSourceBean> pTasyaKanyuuJoukyou) {
        tasyaKanyuuJoukyouDataSource.setDatas(pTasyaKanyuuJoukyou);
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

    private String knksateisjnaiyou;

    public String getKnksateisjnaiyou() {
        return knksateisjnaiyou;
    }

    public void setKnksateisjnaiyou(String pKnksateisjnaiyou) {
        knksateisjnaiyou = pKnksateisjnaiyou;
    }

    private String zenkaiknksateicomnt;

    public String getZenkaiknksateicomnt() {
        return zenkaiknksateicomnt;
    }

    public void setZenkaiknksateicomnt(String pZenkaiknksateicomnt) {
        zenkaiknksateicomnt = pZenkaiknksateicomnt;
    }

    private Boolean linckak;

    public Boolean getLinckak() {
        return (linckak == null) ? Boolean.FALSE : linckak;
    }

    public void setLinckak(Boolean pLinckak) {
        linckak = (pLinckak == null) ? Boolean.FALSE : pLinckak;
    }

    private C_LinckakKbn linckakkbn;

    public C_LinckakKbn getLinckakkbn() {
        return linckakkbn;
    }

    public void setLinckakkbn(C_LinckakKbn pLinckakkbn) {
        linckakkbn = pLinckakkbn;
    }

    private C_SyorikekkaKbn knksateisateikekka;

    public C_SyorikekkaKbn getKnksateisateikekka() {
        return knksateisateikekka;
    }

    public void setKnksateisateikekka(C_SyorikekkaKbn pKnksateisateikekka) {
        knksateisateikekka = pKnksateisateikekka;
    }

    private String knktnsketsyacd;

    public String getKnktnsketsyacd() {
        return knktnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnktnsketsyacd(String pKnktnsketsyacd) {
        knktnsketsyacd = pKnktnsketsyacd;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String knksateicommentgamen;

    public String getKnksateicommentgamen() {
        return knksateicommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnksateicommentgamen(String pKnksateicommentgamen) {
        knksateicommentgamen = pKnksateicommentgamen;
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

    private C_MrRiyuucdKbn mrriyuucdkbn;

    public C_MrRiyuucdKbn getMrriyuucdkbn() {
        return mrriyuucdkbn;
    }

    public void setMrriyuucdkbn(C_MrRiyuucdKbn pMrriyuucdkbn) {
        mrriyuucdkbn = pMrriyuucdkbn;
    }

    private C_TorikesisyousairiyuuCd torikesisyousairiyuucd;

    public C_TorikesisyousairiyuuCd getTorikesisyousairiyuucd() {
        return torikesisyousairiyuucd;
    }

    public void setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd pTorikesisyousairiyuucd) {
        torikesisyousairiyuucd = pTorikesisyousairiyuucd;
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

    private BizNumber tasyatsn;

    public BizNumber getTasyatsn() {
        return tasyatsn;
    }

    public void setTasyatsn(BizNumber pTasyatsn) {
        tasyatsn = pTasyatsn;
    }

    private BizNumber tousyatsn;

    public BizNumber getTousyatsn() {
        return tousyatsn;
    }

    public void setTousyatsn(BizNumber pTousyatsn) {
        tousyatsn = pTousyatsn;
    }

    private BizNumber tousyatsnfundnotinc;

    public BizNumber getTousyatsnfundnotinc() {
        return tousyatsnfundnotinc;
    }

    public void setTousyatsnfundnotinc(BizNumber pTousyatsnfundnotinc) {
        tousyatsnfundnotinc = pTousyatsnfundnotinc;
    }

    private BizNumber toutasyatsn;

    public BizNumber getToutasyatsn() {
        return toutasyatsn;
    }

    public void setToutasyatsn(BizNumber pToutasyatsn) {
        toutasyatsn = pToutasyatsn;
    }

    private BizNumber toutasyatsnfundnotinc;

    public BizNumber getToutasyatsnfundnotinc() {
        return toutasyatsnfundnotinc;
    }

    public void setToutasyatsnfundnotinc(BizNumber pToutasyatsnfundnotinc) {
        toutasyatsnfundnotinc = pToutasyatsnfundnotinc;
    }

    private BizNumber toutasyatsnkessaitgk;

    public BizNumber getToutasyatsnkessaitgk() {
        return toutasyatsnkessaitgk;
    }

    public void setToutasyatsnkessaitgk(BizNumber pToutasyatsnkessaitgk) {
        toutasyatsnkessaitgk = pToutasyatsnkessaitgk;
    }

    private C_NensyuuKbn nensyuukbn;

    public C_NensyuuKbn getNensyuukbn() {
        return nensyuukbn;
    }

    public void setNensyuukbn(C_NensyuuKbn pNensyuukbn) {
        nensyuukbn = pNensyuukbn;
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

    private LoopChain<UserDefsList> knktnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getKnktnsketsyacdOptionBeanList() {
        return knktnsketsyacdOptionBeanList.get();
    }

    public void setKnktnsketsyacdOptionBeanList(UserDefsList pKnktnsketsyacdOptionBeanList) {
        clearKnktnsketsyacdOptionBeanList();
        knktnsketsyacdOptionBeanList.add(pKnktnsketsyacdOptionBeanList);
    }

    public void clearKnktnsketsyacdOptionBeanList() {
        knktnsketsyacdOptionBeanList.clear();
    }
}
