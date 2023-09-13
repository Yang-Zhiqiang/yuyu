package yuyu.def.hozen.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * hozenパッケージ用 システム情報格納部品です。<br />
 * このソースはツールにより自動生成されたものです。業務静的定義に変更があると上書きされてしまいます。
 */
public class GenYuyuHozenConfig {

    public GenYuyuHozenConfig() {
    }

    private String sekDataFile;

    public String getSekDataFile() {
        return sekDataFile;
    }

    public void setSekDataFile(String pSekDataFile) {
        sekDataFile = pSekDataFile;
    }

    private String backupTblClassNames;

    public String getBackupTblClassNames() {
        return backupTblClassNames;
    }

    public void setBackupTblClassNames(String pBackupTblClassNames) {
        backupTblClassNames = pBackupTblClassNames;
    }

    private String saitorikomiDelTblClassNames;

    public String getSaitorikomiDelTblClassNames() {
        return saitorikomiDelTblClassNames;
    }

    public void setSaitorikomiDelTblClassNames(String pSaitorikomiDelTblClassNames) {
        saitorikomiDelTblClassNames = pSaitorikomiDelTblClassNames;
    }

    private String teigakuDummyFundcd;

    public String getTeigakuDummyFundcd() {
        return teigakuDummyFundcd;
    }

    public void setTeigakuDummyFundcd(String pTeigakuDummyFundcd) {
        teigakuDummyFundcd = pTeigakuDummyFundcd;
    }

    private Integer yenRateSyousuuKeta;

    public Integer getYenRateSyousuuKeta() {
        return yenRateSyousuuKeta;
    }

    public void setYenRateSyousuuKeta(Integer pYenRateSyousuuKeta) {
        yenRateSyousuuKeta = pYenRateSyousuuKeta;
    }

    private Integer rirituSyousuuKeta;

    public Integer getRirituSyousuuKeta() {
        return rirituSyousuuKeta;
    }

    public void setRirituSyousuuKeta(Integer pRirituSyousuuKeta) {
        rirituSyousuuKeta = pRirituSyousuuKeta;
    }

    private String hokenKaisyaNmKana;

    public String getHokenKaisyaNmKana() {
        return hokenKaisyaNmKana;
    }

    public void setHokenKaisyaNmKana(String pHokenKaisyaNmKana) {
        hokenKaisyaNmKana = pHokenKaisyaNmKana;
    }

    private Integer syonoYuukouKetasuu;

    public Integer getSyonoYuukouKetasuu() {
        return syonoYuukouKetasuu;
    }

    public void setSyonoYuukouKetasuu(Integer pSyonoYuukouKetasuu) {
        syonoYuukouKetasuu = pSyonoYuukouKetasuu;
    }

    private Integer koujoSyomeiNendoHyojiNensuu;

    public Integer getKoujoSyomeiNendoHyojiNensuu() {
        return koujoSyomeiNendoHyojiNensuu;
    }

    public void setKoujoSyomeiNendoHyojiNensuu(Integer pKoujoSyomeiNendoHyojiNensuu) {
        koujoSyomeiNendoHyojiNensuu = pKoujoSyomeiNendoHyojiNensuu;
    }

    private Integer ryousyuuKyoyouNissuu;

    public Integer getRyousyuuKyoyouNissuu() {
        return ryousyuuKyoyouNissuu;
    }

    public void setRyousyuuKyoyouNissuu(Integer pRyousyuuKyoyouNissuu) {
        ryousyuuKyoyouNissuu = pRyousyuuKyoyouNissuu;
    }

    private Integer tyouseiYouPTukisuuKouza;

    public Integer getTyouseiYouPTukisuuKouza() {
        return tyouseiYouPTukisuuKouza;
    }

    public void setTyouseiYouPTukisuuKouza(Integer pTyouseiYouPTukisuuKouza) {
        tyouseiYouPTukisuuKouza = pTyouseiYouPTukisuuKouza;
    }

    private Integer tyouseiYouPTukisuuCredit;

    public Integer getTyouseiYouPTukisuuCredit() {
        return tyouseiYouPTukisuuCredit;
    }

    public void setTyouseiYouPTukisuuCredit(Integer pTyouseiYouPTukisuuCredit) {
        tyouseiYouPTukisuuCredit = pTyouseiYouPTukisuuCredit;
    }

    private Integer hukkatuTyouseiYouPTukisuuKouza;

    public Integer getHukkatuTyouseiYouPTukisuuKouza() {
        return hukkatuTyouseiYouPTukisuuKouza;
    }

    public void setHukkatuTyouseiYouPTukisuuKouza(Integer pHukkatuTyouseiYouPTukisuuKouza) {
        hukkatuTyouseiYouPTukisuuKouza = pHukkatuTyouseiYouPTukisuuKouza;
    }

    private Integer hukkatuTyouseiYouPTukisuuCredit;

    public Integer getHukkatuTyouseiYouPTukisuuCredit() {
        return hukkatuTyouseiYouPTukisuuCredit;
    }

    public void setHukkatuTyouseiYouPTukisuuCredit(Integer pHukkatuTyouseiYouPTukisuuCredit) {
        hukkatuTyouseiYouPTukisuuCredit = pHukkatuTyouseiYouPTukisuuCredit;
    }

    private String kessanKijunbi;

    public String getKessanKijunbi() {
        return kessanKijunbi;
    }

    public void setKessanKijunbi(String pKessanKijunbi) {
        kessanKijunbi = pKessanKijunbi;
    }

    private String henkouRrkList;

    public String getHenkouRrkList() {
        return henkouRrkList;
    }

    public void setHenkouRrkList(String pHenkouRrkList) {
        henkouRrkList = pHenkouRrkList;
    }

    private Integer syoruiUkeKyoyou;

    public Integer getSyoruiUkeKyoyou() {
        return syoruiUkeKyoyou;
    }

    public void setSyoruiUkeKyoyou(Integer pSyoruiUkeKyoyou) {
        syoruiUkeKyoyou = pSyoruiUkeKyoyou;
    }

    private Integer lincHozonKigen;

    public Integer getLincHozonKigen() {
        return lincHozonKigen;
    }

    public void setLincHozonKigen(Integer pLincHozonKigen) {
        lincHozonKigen = pLincHozonKigen;
    }

    private BizDate nenHannenStartYmd;

    public BizDate getNenHannenStartYmd() {
        return nenHannenStartYmd;
    }

    public void setNenHannenStartYmd(BizDate pNenHannenStartYmd) {
        nenHannenStartYmd = pNenHannenStartYmd;
    }

    private String sougouTuutiTaisyoTukihi;

    public String getSougouTuutiTaisyoTukihi() {
        return sougouTuutiTaisyoTukihi;
    }

    public void setSougouTuutiTaisyoTukihi(String pSougouTuutiTaisyoTukihi) {
        sougouTuutiTaisyoTukihi = pSougouTuutiTaisyoTukihi;
    }

    private BizDate koujyoSymZeiseiKaiseiYmd;

    public BizDate getKoujyoSymZeiseiKaiseiYmd() {
        return koujyoSymZeiseiKaiseiYmd;
    }

    public void setKoujyoSymZeiseiKaiseiYmd(BizDate pKoujyoSymZeiseiKaiseiYmd) {
        koujyoSymZeiseiKaiseiYmd = pKoujyoSymZeiseiKaiseiYmd;
    }

    private Integer pmnjtkGansknnkaisiKeikanisuu;

    public Integer getPmnjtkGansknnkaisiKeikanisuu() {
        return pmnjtkGansknnkaisiKeikanisuu;
    }

    public void setPmnjtkGansknnkaisiKeikanisuu(Integer pPmnjtkGansknnkaisiKeikanisuu) {
        pmnjtkGansknnkaisiKeikanisuu = pPmnjtkGansknnkaisiKeikanisuu;
    }

    private Integer targetTkMokuhyouMax;

    public Integer getTargetTkMokuhyouMax() {
        return targetTkMokuhyouMax;
    }

    public void setTargetTkMokuhyouMax(Integer pTargetTkMokuhyouMax) {
        targetTkMokuhyouMax = pTargetTkMokuhyouMax;
    }

    private Integer targetTkMokuhyouMin;

    public Integer getTargetTkMokuhyouMin() {
        return targetTkMokuhyouMin;
    }

    public void setTargetTkMokuhyouMin(Integer pTargetTkMokuhyouMin) {
        targetTkMokuhyouMin = pTargetTkMokuhyouMin;
    }

    private Integer targetTkMokuhyouMinTani;

    public Integer getTargetTkMokuhyouMinTani() {
        return targetTkMokuhyouMinTani;
    }

    public void setTargetTkMokuhyouMinTani(Integer pTargetTkMokuhyouMinTani) {
        targetTkMokuhyouMinTani = pTargetTkMokuhyouMinTani;
    }

    private Integer syohakkoubiHanteiKijyunbi;

    public Integer getSyohakkoubiHanteiKijyunbi() {
        return syohakkoubiHanteiKijyunbi;
    }

    public void setSyohakkoubiHanteiKijyunbi(Integer pSyohakkoubiHanteiKijyunbi) {
        syohakkoubiHanteiKijyunbi = pSyohakkoubiHanteiKijyunbi;
    }

    private BizNumber suiihyouYoteirirituUp;

    public BizNumber getSuiihyouYoteirirituUp() {
        return suiihyouYoteirirituUp;
    }

    public void setSuiihyouYoteirirituUp(BizNumber pSuiihyouYoteirirituUp) {
        suiihyouYoteirirituUp = pSuiihyouYoteirirituUp;
    }

    private BizNumber suiihyouYoteirirituDown;

    public BizNumber getSuiihyouYoteirirituDown() {
        return suiihyouYoteirirituDown;
    }

    public void setSuiihyouYoteirirituDown(BizNumber pSuiihyouYoteirirituDown) {
        suiihyouYoteirirituDown = pSuiihyouYoteirirituDown;
    }

    private BizCurrency shrgkwarningkijyun;

    public BizCurrency getShrgkwarningkijyun() {
        return shrgkwarningkijyun;
    }

    public void setShrgkwarningkijyun(BizCurrency pShrgkwarningkijyun) {
        shrgkwarningkijyun = pShrgkwarningkijyun;
    }

    private BizNumber kawaserateHendouYenup;

    public BizNumber getKawaserateHendouYenup() {
        return kawaserateHendouYenup;
    }

    public void setKawaserateHendouYenup(BizNumber pKawaserateHendouYenup) {
        kawaserateHendouYenup = pKawaserateHendouYenup;
    }

    private BizNumber kawaserateHendouYendown;

    public BizNumber getKawaserateHendouYendown() {
        return kawaserateHendouYendown;
    }

    public void setKawaserateHendouYendown(BizNumber pKawaserateHendouYendown) {
        kawaserateHendouYendown = pKawaserateHendouYendown;
    }

    private String myNumberFilePath;

    public String getMyNumberFilePath() {
        return myNumberFilePath;
    }

    public void setMyNumberFilePath(String pMyNumberFilePath) {
        myNumberFilePath = pMyNumberFilePath;
    }

    private String jyudKaigomaebaraiTkYakkanFilePath;

    public String getJyudKaigomaebaraiTkYakkanFilePath() {
        return jyudKaigomaebaraiTkYakkanFilePath;
    }

    public void setJyudKaigomaebaraiTkYakkanFilePath(String pJyudKaigomaebaraiTkYakkanFilePath) {
        jyudKaigomaebaraiTkYakkanFilePath = pJyudKaigomaebaraiTkYakkanFilePath;
    }

    private String siteidairiTkYakkanFilePath;

    public String getSiteidairiTkYakkanFilePath() {
        return siteidairiTkYakkanFilePath;
    }

    public void setSiteidairiTkYakkanFilePath(String pSiteidairiTkYakkanFilePath) {
        siteidairiTkYakkanFilePath = pSiteidairiTkYakkanFilePath;
    }

    private String meigihnkSksMihonBetsuzinFilePath;

    public String getMeigihnkSksMihonBetsuzinFilePath() {
        return meigihnkSksMihonBetsuzinFilePath;
    }

    public void setMeigihnkSksMihonBetsuzinFilePath(String pMeigihnkSksMihonBetsuzinFilePath) {
        meigihnkSksMihonBetsuzinFilePath = pMeigihnkSksMihonBetsuzinFilePath;
    }

    private String meigihnkSksMihonBetsuzinNenkinFilePath;

    public String getMeigihnkSksMihonBetsuzinNenkinFilePath() {
        return meigihnkSksMihonBetsuzinNenkinFilePath;
    }

    public void setMeigihnkSksMihonBetsuzinNenkinFilePath(String pMeigihnkSksMihonBetsuzinNenkinFilePath) {
        meigihnkSksMihonBetsuzinNenkinFilePath = pMeigihnkSksMihonBetsuzinNenkinFilePath;
    }

    private String meigihnkSksMihonKaiseiFilePath;

    public String getMeigihnkSksMihonKaiseiFilePath() {
        return meigihnkSksMihonKaiseiFilePath;
    }

    public void setMeigihnkSksMihonKaiseiFilePath(String pMeigihnkSksMihonKaiseiFilePath) {
        meigihnkSksMihonKaiseiFilePath = pMeigihnkSksMihonKaiseiFilePath;
    }

    private String meigihnkSksMihonKaiseiNenkinFilePath;

    public String getMeigihnkSksMihonKaiseiNenkinFilePath() {
        return meigihnkSksMihonKaiseiNenkinFilePath;
    }

    public void setMeigihnkSksMihonKaiseiNenkinFilePath(String pMeigihnkSksMihonKaiseiNenkinFilePath) {
        meigihnkSksMihonKaiseiNenkinFilePath = pMeigihnkSksMihonKaiseiNenkinFilePath;
    }

    private String meigihnkSksMihonKykSibouFilePath;

    public String getMeigihnkSksMihonKykSibouFilePath() {
        return meigihnkSksMihonKykSibouFilePath;
    }

    public void setMeigihnkSksMihonKykSibouFilePath(String pMeigihnkSksMihonKykSibouFilePath) {
        meigihnkSksMihonKykSibouFilePath = pMeigihnkSksMihonKykSibouFilePath;
    }

    private String meigihnkSksMihonKykSibouNenkinFilePath;

    public String getMeigihnkSksMihonKykSibouNenkinFilePath() {
        return meigihnkSksMihonKykSibouNenkinFilePath;
    }

    public void setMeigihnkSksMihonKykSibouNenkinFilePath(String pMeigihnkSksMihonKykSibouNenkinFilePath) {
        meigihnkSksMihonKykSibouNenkinFilePath = pMeigihnkSksMihonKykSibouNenkinFilePath;
    }

    private String meigihnkSksMihonHhknsyaKaiseiFilePath;

    public String getMeigihnkSksMihonHhknsyaKaiseiFilePath() {
        return meigihnkSksMihonHhknsyaKaiseiFilePath;
    }

    public void setMeigihnkSksMihonHhknsyaKaiseiFilePath(String pMeigihnkSksMihonHhknsyaKaiseiFilePath) {
        meigihnkSksMihonHhknsyaKaiseiFilePath = pMeigihnkSksMihonHhknsyaKaiseiFilePath;
    }

    private String meigihnkSksMihonHhknsyaKaiseiNenkinFilePath;

    public String getMeigihnkSksMihonHhknsyaKaiseiNenkinFilePath() {
        return meigihnkSksMihonHhknsyaKaiseiNenkinFilePath;
    }

    public void setMeigihnkSksMihonHhknsyaKaiseiNenkinFilePath(String pMeigihnkSksMihonHhknsyaKaiseiNenkinFilePath) {
        meigihnkSksMihonHhknsyaKaiseiNenkinFilePath = pMeigihnkSksMihonHhknsyaKaiseiNenkinFilePath;
    }

    private String meigihnkTrhkkakSecondFilePath;

    public String getMeigihnkTrhkkakSecondFilePath() {
        return meigihnkTrhkkakSecondFilePath;
    }

    public void setMeigihnkTrhkkakSecondFilePath(String pMeigihnkTrhkkakSecondFilePath) {
        meigihnkTrhkkakSecondFilePath = pMeigihnkTrhkkakSecondFilePath;
    }

    private String pkzhrikeIraisyoKinyuureiFilePath;

    public String getPkzhrikeIraisyoKinyuureiFilePath() {
        return pkzhrikeIraisyoKinyuureiFilePath;
    }

    public void setPkzhrikeIraisyoKinyuureiFilePath(String pPkzhrikeIraisyoKinyuureiFilePath) {
        pkzhrikeIraisyoKinyuureiFilePath = pPkzhrikeIraisyoKinyuureiFilePath;
    }

    private String creditcardSioriFilePath;

    public String getCreditcardSioriFilePath() {
        return creditcardSioriFilePath;
    }

    public void setCreditcardSioriFilePath(String pCreditcardSioriFilePath) {
        creditcardSioriFilePath = pCreditcardSioriFilePath;
    }

    private Integer seijinNenrei;

    public Integer getSeijinNenrei() {
        return seijinNenrei;
    }

    public void setSeijinNenrei(Integer pSeijinNenrei) {
        seijinNenrei = pSeijinNenrei;
    }

    private BizNumber suiihyouSjkkktusirrtUp;

    public BizNumber getSuiihyouSjkkktusirrtUp() {
        return suiihyouSjkkktusirrtUp;
    }

    public void setSuiihyouSjkkktusirrtUp(BizNumber pSuiihyouSjkkktusirrtUp) {
        suiihyouSjkkktusirrtUp = pSuiihyouSjkkktusirrtUp;
    }

    private BizNumber suiihyouSjkkktusirrtDown;

    public BizNumber getSuiihyouSjkkktusirrtDown() {
        return suiihyouSjkkktusirrtDown;
    }

    public void setSuiihyouSjkkktusirrtDown(BizNumber pSuiihyouSjkkktusirrtDown) {
        suiihyouSjkkktusirrtDown = pSuiihyouSjkkktusirrtDown;
    }

    private String drateRendouMd;

    public String getDrateRendouMd() {
        return drateRendouMd;
    }

    public void setDrateRendouMd(String pDrateRendouMd) {
        drateRendouMd = pDrateRendouMd;
    }

    private String drateKakuteiMd;

    public String getDrateKakuteiMd() {
        return drateKakuteiMd;
    }

    public void setDrateKakuteiMd(String pDrateKakuteiMd) {
        drateKakuteiMd = pDrateKakuteiMd;
    }

    private String myNumberKyksibouFilePath;

    public String getMyNumberKyksibouFilePath() {
        return myNumberKyksibouFilePath;
    }

    public void setMyNumberKyksibouFilePath(String pMyNumberKyksibouFilePath) {
        myNumberKyksibouFilePath = pMyNumberKyksibouFilePath;
    }

    private Integer tmttknItenUkeKigenNissuu;

    public Integer getTmttknItenUkeKigenNissuu() {
        return tmttknItenUkeKigenNissuu;
    }

    public void setTmttknItenUkeKigenNissuu(Integer pTmttknItenUkeKigenNissuu) {
        tmttknItenUkeKigenNissuu = pTmttknItenUkeKigenNissuu;
    }

    private BizDate dsKaiyakuServiceStartYmd;

    public BizDate getDsKaiyakuServiceStartYmd() {
        return dsKaiyakuServiceStartYmd;
    }

    public void setDsKaiyakuServiceStartYmd(BizDate pDsKaiyakuServiceStartYmd) {
        dsKaiyakuServiceStartYmd = pDsKaiyakuServiceStartYmd;
    }

    private Integer tmttknItenUkeKaisiTukisuu;

    public Integer getTmttknItenUkeKaisiTukisuu() {
        return tmttknItenUkeKaisiTukisuu;
    }

    public void setTmttknItenUkeKaisiTukisuu(Integer pTmttknItenUkeKaisiTukisuu) {
        tmttknItenUkeKaisiTukisuu = pTmttknItenUkeKaisiTukisuu;
    }

    private String kykdrtkykYakkanFilePath;

    public String getKykdrtkykYakkanFilePath() {
        return kykdrtkykYakkanFilePath;
    }

    public void setKykdrtkykYakkanFilePath(String pKykdrtkykYakkanFilePath) {
        kykdrtkykYakkanFilePath = pKykdrtkykYakkanFilePath;
    }

    private String kzktrkServiceKiyakuFilePath;

    public String getKzktrkServiceKiyakuFilePath() {
        return kzktrkServiceKiyakuFilePath;
    }

    public void setKzktrkServiceKiyakuFilePath(String pKzktrkServiceKiyakuFilePath) {
        kzktrkServiceKiyakuFilePath = pKzktrkServiceKiyakuFilePath;
    }

    private List<HsigiTksnTeigiBean> hsigiTksnTeigiBeanList = new ArrayList<>();

    public List<HsigiTksnTeigiBean> getHsigiTksnTeigiBeanList() {
        return Collections.unmodifiableList(hsigiTksnTeigiBeanList);
    }

    public void addHsigiTksnTeigiBean(HsigiTksnTeigiBean pHsigiTksnTeigiBean) {
        hsigiTksnTeigiBeanList.add(pHsigiTksnTeigiBean);
    }

    private BizCurrency ippanKoujyoGndgk;

    public BizCurrency getIppanKoujyoGndgk() {
        return ippanKoujyoGndgk;
    }

    public void setIppanKoujyoGndgk(BizCurrency pIppanKoujyoGndgk) {
        ippanKoujyoGndgk = pIppanKoujyoGndgk;
    }
}
