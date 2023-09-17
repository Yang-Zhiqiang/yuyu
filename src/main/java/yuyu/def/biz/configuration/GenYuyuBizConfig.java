package yuyu.def.biz.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_EncryptKbn;
import yuyu.def.classification.C_KyjthsnnyKbn;
import yuyu.def.classification.C_SaitaiknkflagKbn;
import yuyu.def.classification.C_Tienrskhasuusyori;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * bizパッケージ用 システム情報格納部品です。<br />
 * このソースはツールにより自動生成されたものです。業務静的定義に変更があると上書きされてしまいます。
 */
public class GenYuyuBizConfig {

    public GenYuyuBizConfig() {
    }

    private List<String> projectList = new ArrayList<>();

    public List<String> getProjectList() {
        return Collections.unmodifiableList(projectList);
    }

    public void addProject(String pProject) {
        projectList.add(pProject);
    }

    private BizCurrency lincGtHutuuSbS;

    public BizCurrency getLincGtHutuuSbS() {
        return lincGtHutuuSbS;
    }

    public void setLincGtHutuuSbS(BizCurrency pLincGtHutuuSbS) {
        lincGtHutuuSbS = pLincGtHutuuSbS;
    }

    private BizCurrency lincGtHutuuSbSSgSbSGoukeiTeinen;

    public BizCurrency getLincGtHutuuSbSSgSbSGoukeiTeinen() {
        return lincGtHutuuSbSSgSbSGoukeiTeinen;
    }

    public void setLincGtHutuuSbSSgSbSGoukeiTeinen(BizCurrency pLincGtHutuuSbSSgSbSGoukeiTeinen) {
        lincGtHutuuSbSSgSbSGoukeiTeinen = pLincGtHutuuSbSSgSbSGoukeiTeinen;
    }

    private Integer lincGtHntiyuTeinenKijyun;

    public Integer getLincGtHntiyuTeinenKijyun() {
        return lincGtHntiyuTeinenKijyun;
    }

    public void setLincGtHntiyuTeinenKijyun(Integer pLincGtHntiyuTeinenKijyun) {
        lincGtHntiyuTeinenKijyun = pLincGtHntiyuTeinenKijyun;
    }

    private BizCurrency lincGtNyuKyhkin;

    public BizCurrency getLincGtNyuKyhkin() {
        return lincGtNyuKyhkin;
    }

    public void setLincGtNyuKyhkin(BizCurrency pLincGtNyuKyhkin) {
        lincGtNyuKyhkin = pLincGtNyuKyhkin;
    }

    private Integer lincrecordsyubetusnkiykmuskmsyuki;

    public Integer getLincrecordsyubetusnkiykmuskmsyuki() {
        return lincrecordsyubetusnkiykmuskmsyuki;
    }

    public void setLincrecordsyubetusnkiykmuskmsyuki(Integer pLincrecordsyubetusnkiykmuskmsyuki) {
        lincrecordsyubetusnkiykmuskmsyuki = pLincrecordsyubetusnkiykmuskmsyuki;
    }

    private Integer lincrecordsyubetusirtsyurkmusd;

    public Integer getLincrecordsyubetusirtsyurkmusd() {
        return lincrecordsyubetusirtsyurkmusd;
    }

    public void setLincrecordsyubetusirtsyurkmusd(Integer pLincrecordsyubetusirtsyurkmusd) {
        lincrecordsyubetusirtsyurkmusd = pLincrecordsyubetusirtsyurkmusd;
    }

    private Integer lincrecordsyubetuturkniyuhnkumusd;

    public Integer getLincrecordsyubetuturkniyuhnkumusd() {
        return lincrecordsyubetuturkniyuhnkumusd;
    }

    public void setLincrecordsyubetuturkniyuhnkumusd(Integer pLincrecordsyubetuturkniyuhnkumusd) {
        lincrecordsyubetuturkniyuhnkumusd = pLincrecordsyubetuturkniyuhnkumusd;
    }

    private String linchenkoutypetuika;

    public String getLinchenkoutypetuika() {
        return linchenkoutypetuika;
    }

    public void setLinchenkoutypetuika(String pLinchenkoutypetuika) {
        linchenkoutypetuika = pLinchenkoutypetuika;
    }

    private String linchenkoutypekousin;

    public String getLinchenkoutypekousin() {
        return linchenkoutypekousin;
    }

    public void setLinchenkoutypekousin(String pLinchenkoutypekousin) {
        linchenkoutypekousin = pLinchenkoutypekousin;
    }

    private String linchenkoutypesakujyo;

    public String getLinchenkoutypesakujyo() {
        return linchenkoutypesakujyo;
    }

    public void setLinchenkoutypesakujyo(String pLinchenkoutypesakujyo) {
        linchenkoutypesakujyo = pLinchenkoutypesakujyo;
    }

    private BizNumber taiHyoujyunMin;

    public BizNumber getTaiHyoujyunMin() {
        return taiHyoujyunMin;
    }

    public void setTaiHyoujyunMin(BizNumber pTaiHyoujyunMin) {
        taiHyoujyunMin = pTaiHyoujyunMin;
    }

    private BizNumber taiHyoujyunMax;

    public BizNumber getTaiHyoujyunMax() {
        return taiHyoujyunMax;
    }

    public void setTaiHyoujyunMax(BizNumber pTaiHyoujyunMax) {
        taiHyoujyunMax = pTaiHyoujyunMax;
    }

    private Integer fbTknbiKsnNissuu;

    public Integer getFbTknbiKsnNissuu() {
        return fbTknbiKsnNissuu;
    }

    public void setFbTknbiKsnNissuu(Integer pFbTknbiKsnNissuu) {
        fbTknbiKsnNissuu = pFbTknbiKsnNissuu;
    }

    private String multiCsvFileOut;

    public String getMultiCsvFileOut() {
        return multiCsvFileOut;
    }

    public void setMultiCsvFileOut(String pMultiCsvFileOut) {
        multiCsvFileOut = pMultiCsvFileOut;
    }

    private String skeiTaskKanriCsvFileOut;

    public String getSkeiTaskKanriCsvFileOut() {
        return skeiTaskKanriCsvFileOut;
    }

    public void setSkeiTaskKanriCsvFileOut(String pSkeiTaskKanriCsvFileOut) {
        skeiTaskKanriCsvFileOut = pSkeiTaskKanriCsvFileOut;
    }

    private String batchFileIn;

    public String getBatchFileIn() {
        return batchFileIn;
    }

    public void setBatchFileIn(String pBatchFileIn) {
        batchFileIn = pBatchFileIn;
    }

    private String batchFileOut;

    public String getBatchFileOut() {
        return batchFileOut;
    }

    public void setBatchFileOut(String pBatchFileOut) {
        batchFileOut = pBatchFileOut;
    }

    private Integer kanaNmKyoyou;

    public Integer getKanaNmKyoyou() {
        return kanaNmKyoyou;
    }

    public void setKanaNmKyoyou(Integer pKanaNmKyoyou) {
        kanaNmKyoyou = pKanaNmKyoyou;
    }

    private Integer kzmeigiKanaNmKyoyou;

    public Integer getKzmeigiKanaNmKyoyou() {
        return kzmeigiKanaNmKyoyou;
    }

    public void setKzmeigiKanaNmKyoyou(Integer pKzmeigiKanaNmKyoyou) {
        kzmeigiKanaNmKyoyou = pKzmeigiKanaNmKyoyou;
    }

    private Integer kanaAdrKyoyou;

    public Integer getKanaAdrKyoyou() {
        return kanaAdrKyoyou;
    }

    public void setKanaAdrKyoyou(Integer pKanaAdrKyoyou) {
        kanaAdrKyoyou = pKanaAdrKyoyou;
    }

    private Long haitaHosyouTime;

    public Long getHaitaHosyouTime() {
        return haitaHosyouTime;
    }

    public void setHaitaHosyouTime(Long pHaitaHosyouTime) {
        haitaHosyouTime = pHaitaHosyouTime;
    }

    private String hikanHaitaYuukouKbn;

    public String getHikanHaitaYuukouKbn() {
        return hikanHaitaYuukouKbn;
    }

    public void setHikanHaitaYuukouKbn(String pHikanHaitaYuukouKbn) {
        hikanHaitaYuukouKbn = pHikanHaitaYuukouKbn;
    }

    private Long hikanHaitaYuukouTime;

    public Long getHikanHaitaYuukouTime() {
        return hikanHaitaYuukouTime;
    }

    public void setHikanHaitaYuukouTime(Long pHikanHaitaYuukouTime) {
        hikanHaitaYuukouTime = pHikanHaitaYuukouTime;
    }

    private String serviceRoot;

    public String getServiceRoot() {
        return serviceRoot;
    }

    public void setServiceRoot(String pServiceRoot) {
        serviceRoot = pServiceRoot;
    }

    private String lincKaisyaCd;

    public String getLincKaisyaCd() {
        return lincKaisyaCd;
    }

    public void setLincKaisyaCd(String pLincKaisyaCd) {
        lincKaisyaCd = pLincKaisyaCd;
    }

    private String creditSyuuDaikoCd;

    public String getCreditSyuuDaikoCd() {
        return creditSyuuDaikoCd;
    }

    public void setCreditSyuuDaikoCd(String pCreditSyuuDaikoCd) {
        creditSyuuDaikoCd = pCreditSyuuDaikoCd;
    }

    private String batchDoujiCtlKbn;

    public String getBatchDoujiCtlKbn() {
        return batchDoujiCtlKbn;
    }

    public void setBatchDoujiCtlKbn(String pBatchDoujiCtlKbn) {
        batchDoujiCtlKbn = pBatchDoujiCtlKbn;
    }

    private String sokinKaisyaCd;

    public String getSokinKaisyaCd() {
        return sokinKaisyaCd;
    }

    public void setSokinKaisyaCd(String pSokinKaisyaCd) {
        sokinKaisyaCd = pSokinKaisyaCd;
    }

    private String sokinKaisyaNmkn;

    public String getSokinKaisyaNmkn() {
        return sokinKaisyaNmkn;
    }

    public void setSokinKaisyaNmkn(String pSokinKaisyaNmkn) {
        sokinKaisyaNmkn = pSokinKaisyaNmkn;
    }

    private String sokinBankCd;

    public String getSokinBankCd() {
        return sokinBankCd;
    }

    public void setSokinBankCd(String pSokinBankCd) {
        sokinBankCd = pSokinBankCd;
    }

    private String sokinBankNmkn;

    public String getSokinBankNmkn() {
        return sokinBankNmkn;
    }

    public void setSokinBankNmkn(String pSokinBankNmkn) {
        sokinBankNmkn = pSokinBankNmkn;
    }

    private String sokinSitenCd;

    public String getSokinSitenCd() {
        return sokinSitenCd;
    }

    public void setSokinSitenCd(String pSokinSitenCd) {
        sokinSitenCd = pSokinSitenCd;
    }

    private String sokinSitenNmkn;

    public String getSokinSitenNmkn() {
        return sokinSitenNmkn;
    }

    public void setSokinSitenNmkn(String pSokinSitenNmkn) {
        sokinSitenNmkn = pSokinSitenNmkn;
    }

    private C_YokinKbn sokinYokinKbn;

    public C_YokinKbn getSokinYokinKbn() {
        return sokinYokinKbn;
    }

    public void setSokinYokinKbn(C_YokinKbn pSokinYokinKbn) {
        sokinYokinKbn = pSokinYokinKbn;
    }

    private String sokinKzNo;

    public String getSokinKzNo() {
        return sokinKzNo;
    }

    public void setSokinKzNo(String pSokinKzNo) {
        sokinKzNo = pSokinKzNo;
    }

    private String gksokinKaisyaCd;

    public String getGksokinKaisyaCd() {
        return gksokinKaisyaCd;
    }

    public void setGksokinKaisyaCd(String pGksokinKaisyaCd) {
        gksokinKaisyaCd = pGksokinKaisyaCd;
    }

    private String gksokinKaisyaNmej;

    public String getGksokinKaisyaNmej() {
        return gksokinKaisyaNmej;
    }

    public void setGksokinKaisyaNmej(String pGksokinKaisyaNmej) {
        gksokinKaisyaNmej = pGksokinKaisyaNmej;
    }

    private String gksokinBankCd;

    public String getGksokinBankCd() {
        return gksokinBankCd;
    }

    public void setGksokinBankCd(String pGksokinBankCd) {
        gksokinBankCd = pGksokinBankCd;
    }

    private String gksokinBankNmej;

    public String getGksokinBankNmej() {
        return gksokinBankNmej;
    }

    public void setGksokinBankNmej(String pGksokinBankNmej) {
        gksokinBankNmej = pGksokinBankNmej;
    }

    private String gksokinSitenCd;

    public String getGksokinSitenCd() {
        return gksokinSitenCd;
    }

    public void setGksokinSitenCd(String pGksokinSitenCd) {
        gksokinSitenCd = pGksokinSitenCd;
    }

    private String gksokinSitenNmej;

    public String getGksokinSitenNmej() {
        return gksokinSitenNmej;
    }

    public void setGksokinSitenNmej(String pGksokinSitenNmej) {
        gksokinSitenNmej = pGksokinSitenNmej;
    }

    private String gksoukinmokutekicd;

    public String getGksoukinmokutekicd() {
        return gksoukinmokutekicd;
    }

    public void setGksoukinmokutekicd(String pGksoukinmokutekicd) {
        gksoukinmokutekicd = pGksoukinmokutekicd;
    }

    private String gksoukinmokutekinaiyou;

    public String getGksoukinmokutekinaiyou() {
        return gksoukinmokutekinaiyou;
    }

    public void setGksoukinmokutekinaiyou(String pGksoukinmokutekinaiyou) {
        gksoukinmokutekinaiyou = pGksoukinmokutekinaiyou;
    }

    private C_Tuukasyu gkkouzatuukasyu;

    public C_Tuukasyu getGkkouzatuukasyu() {
        return gkkouzatuukasyu;
    }

    public void setGkkouzatuukasyu(C_Tuukasyu pGkkouzatuukasyu) {
        gkkouzatuukasyu = pGkkouzatuukasyu;
    }

    private String gksokinYokinKbn;

    public String getGksokinYokinKbn() {
        return gksokinYokinKbn;
    }

    public void setGksokinYokinKbn(String pGksokinYokinKbn) {
        gksokinYokinKbn = pGksokinYokinKbn;
    }

    private String gksokinKzNo;

    public String getGksokinKzNo() {
        return gksokinKzNo;
    }

    public void setGksokinKzNo(String pGksokinKzNo) {
        gksokinKzNo = pGksokinKzNo;
    }

    private C_Tuukasyu gkkouzatuukasyu2;

    public C_Tuukasyu getGkkouzatuukasyu2() {
        return gkkouzatuukasyu2;
    }

    public void setGkkouzatuukasyu2(C_Tuukasyu pGkkouzatuukasyu2) {
        gkkouzatuukasyu2 = pGkkouzatuukasyu2;
    }

    private String gksokinYokinKbn2;

    public String getGksokinYokinKbn2() {
        return gksokinYokinKbn2;
    }

    public void setGksokinYokinKbn2(String pGksokinYokinKbn2) {
        gksokinYokinKbn2 = pGksokinYokinKbn2;
    }

    private String gksokinKzNo2;

    public String getGksokinKzNo2() {
        return gksokinKzNo2;
    }

    public void setGksokinKzNo2(String pGksokinKzNo2) {
        gksokinKzNo2 = pGksokinKzNo2;
    }

    private String gndTyoukaBankCd;

    public String getGndTyoukaBankCd() {
        return gndTyoukaBankCd;
    }

    public void setGndTyoukaBankCd(String pGndTyoukaBankCd) {
        gndTyoukaBankCd = pGndTyoukaBankCd;
    }

    private String gndTyoukaSitenCd;

    public String getGndTyoukaSitenCd() {
        return gndTyoukaSitenCd;
    }

    public void setGndTyoukaSitenCd(String pGndTyoukaSitenCd) {
        gndTyoukaSitenCd = pGndTyoukaSitenCd;
    }

    private C_YokinKbn gndTyoukaYokinKbn;

    public C_YokinKbn getGndTyoukaYokinKbn() {
        return gndTyoukaYokinKbn;
    }

    public void setGndTyoukaYokinKbn(C_YokinKbn pGndTyoukaYokinKbn) {
        gndTyoukaYokinKbn = pGndTyoukaYokinKbn;
    }

    private String gndTyoukaKzNo;

    public String getGndTyoukaKzNo() {
        return gndTyoukaKzNo;
    }

    public void setGndTyoukaKzNo(String pGndTyoukaKzNo) {
        gndTyoukaKzNo = pGndTyoukaKzNo;
    }

    private List<String> kensakuIdList = new ArrayList<>();

    public List<String> getKensakuIdList() {
        return Collections.unmodifiableList(kensakuIdList);
    }

    public void addKensakuId(String pKensakuId) {
        kensakuIdList.add(pKensakuId);
    }

    private List<String> kensakunmList = new ArrayList<>();

    public List<String> getKensakunmList() {
        return Collections.unmodifiableList(kensakunmList);
    }

    public void addKensakunm(String pKensakunm) {
        kensakunmList.add(pKensakunm);
    }

    private BizCurrency floorLimitKingaku;

    public BizCurrency getFloorLimitKingaku() {
        return floorLimitKingaku;
    }

    public void setFloorLimitKingaku(BizCurrency pFloorLimitKingaku) {
        floorLimitKingaku = pFloorLimitKingaku;
    }

    private List<String> hisiyouSubsystemList = new ArrayList<>();

    public List<String> getHisiyouSubsystemList() {
        return Collections.unmodifiableList(hisiyouSubsystemList);
    }

    public void addHisiyouSubsystem(String pHisiyouSubsystem) {
        hisiyouSubsystemList.add(pHisiyouSubsystem);
    }

    private String deleteDataFileOut;

    public String getDeleteDataFileOut() {
        return deleteDataFileOut;
    }

    public void setDeleteDataFileOut(String pDeleteDataFileOut) {
        deleteDataFileOut = pDeleteDataFileOut;
    }

    private String contextName;

    public String getContextName() {
        return contextName;
    }

    public void setContextName(String pContextName) {
        contextName = pContextName;
    }

    private String impPath;

    public String getImpPath() {
        return impPath;
    }

    public void setImpPath(String pImpPath) {
        impPath = pImpPath;
    }

    private String expPath;

    public String getExpPath() {
        return expPath;
    }

    public void setExpPath(String pExpPath) {
        expPath = pExpPath;
    }

    private String dbServiceName;

    public String getDbServiceName() {
        return dbServiceName;
    }

    public void setDbServiceName(String pDbServiceName) {
        dbServiceName = pDbServiceName;
    }

    private C_EncryptKbn encryptKbn;

    public C_EncryptKbn getEncryptKbn() {
        return encryptKbn;
    }

    public void setEncryptKbn(C_EncryptKbn pEncryptKbn) {
        encryptKbn = pEncryptKbn;
    }

    private String excelTemplate;

    public String getExcelTemplate() {
        return excelTemplate;
    }

    public void setExcelTemplate(String pExcelTemplate) {
        excelTemplate = pExcelTemplate;
    }

    private BizDate htbStartYmd3DaiSphsyTykShop;

    public BizDate getHtbStartYmd3DaiSphsyTykShop() {
        return htbStartYmd3DaiSphsyTykShop;
    }

    public void setHtbStartYmd3DaiSphsyTykShop(BizDate pHtbStartYmd3DaiSphsyTykShop) {
        htbStartYmd3DaiSphsyTykShop = pHtbStartYmd3DaiSphsyTykShop;
    }

    private BizDate htbStartYmd3DaiSphsyTykShopiGai;

    public BizDate getHtbStartYmd3DaiSphsyTykShopiGai() {
        return htbStartYmd3DaiSphsyTykShopiGai;
    }

    public void setHtbStartYmd3DaiSphsyTykShopiGai(BizDate pHtbStartYmd3DaiSphsyTykShopiGai) {
        htbStartYmd3DaiSphsyTykShopiGai = pHtbStartYmd3DaiSphsyTykShopiGai;
    }

    private C_SaitaiknkflagKbn saitaiKnkFlag;

    public C_SaitaiknkflagKbn getSaitaiKnkFlag() {
        return saitaiKnkFlag;
    }

    public void setSaitaiKnkFlag(C_SaitaiknkflagKbn pSaitaiKnkFlag) {
        saitaiKnkFlag = pSaitaiKnkFlag;
    }

    private BizCurrency shrtysyTsytHuyou;

    public BizCurrency getShrtysyTsytHuyou() {
        return shrtysyTsytHuyou;
    }

    public void setShrtysyTsytHuyou(BizCurrency pShrtysyTsytHuyou) {
        shrtysyTsytHuyou = pShrtysyTsytHuyou;
    }

    private Integer shrKkn;

    public Integer getShrKkn() {
        return shrKkn;
    }

    public void setShrKkn(Integer pShrKkn) {
        shrKkn = pShrKkn;
    }

    private BizNumber tienRrtNenri;

    public BizNumber getTienRrtNenri() {
        return tienRrtNenri;
    }

    public void setTienRrtNenri(BizNumber pTienRrtNenri) {
        tienRrtNenri = pTienRrtNenri;
    }

    private C_KyjthsnnyKbn tienRskKyjtHsnny;

    public C_KyjthsnnyKbn getTienRskKyjtHsnny() {
        return tienRskKyjtHsnny;
    }

    public void setTienRskKyjtHsnny(C_KyjthsnnyKbn pTienRskKyjtHsnny) {
        tienRskKyjtHsnny = pTienRskKyjtHsnny;
    }

    private C_Tienrskhasuusyori tienRskHasuusyori;

    public C_Tienrskhasuusyori getTienRskHasuusyori() {
        return tienRskHasuusyori;
    }

    public void setTienRskHasuusyori(C_Tienrskhasuusyori pTienRskHasuusyori) {
        tienRskHasuusyori = pTienRskHasuusyori;
    }

    private BizCurrency gsntysySaiteigk;

    public BizCurrency getGsntysySaiteigk() {
        return gsntysySaiteigk;
    }

    public void setGsntysySaiteigk(BizCurrency pGsntysySaiteigk) {
        gsntysySaiteigk = pGsntysySaiteigk;
    }

    private BizNumber gsntysyZeiritu;

    public BizNumber getGsntysyZeiritu() {
        return gsntysyZeiritu;
    }

    public void setGsntysyZeiritu(BizNumber pGsntysyZeiritu) {
        gsntysyZeiritu = pGsntysyZeiritu;
    }

    private BizNumber gsntysyZeirituKg;

    public BizNumber getGsntysyZeirituKg() {
        return gsntysyZeirituKg;
    }

    public void setGsntysyZeirituKg(BizNumber pGsntysyZeirituKg) {
        gsntysyZeirituKg = pGsntysyZeirituKg;
    }

    private BizNumber gensenbunrikazeiZeiritu;

    public BizNumber getGensenbunrikazeiZeiritu() {
        return gensenbunrikazeiZeiritu;
    }

    public void setGensenbunrikazeiZeiritu(BizNumber pGensenbunrikazeiZeiritu) {
        gensenbunrikazeiZeiritu = pGensenbunrikazeiZeiritu;
    }

    private BizNumber gsbunrikzZeirituNationaltax;

    public BizNumber getGsbunrikzZeirituNationaltax() {
        return gsbunrikzZeirituNationaltax;
    }

    public void setGsbunrikzZeirituNationaltax(BizNumber pGsbunrikzZeirituNationaltax) {
        gsbunrikzZeirituNationaltax = pGsbunrikzZeirituNationaltax;
    }

    private BizNumber gsbunrikzZeirituLocaltax;

    public BizNumber getGsbunrikzZeirituLocaltax() {
        return gsbunrikzZeirituLocaltax;
    }

    public void setGsbunrikzZeirituLocaltax(BizNumber pGsbunrikzZeirituLocaltax) {
        gsbunrikzZeirituLocaltax = pGsbunrikzZeirituLocaltax;
    }

    private Integer kztKeikanensuu;

    public Integer getKztKeikanensuu() {
        return kztKeikanensuu;
    }

    public void setKztKeikanensuu(Integer pKztKeikanensuu) {
        kztKeikanensuu = pKztKeikanensuu;
    }

    private String hokenKaisyaAdr;

    public String getHokenKaisyaAdr() {
        return hokenKaisyaAdr;
    }

    public void setHokenKaisyaAdr(String pHokenKaisyaAdr) {
        hokenKaisyaAdr = pHokenKaisyaAdr;
    }

    private String hokenKaisyaTelno;

    public String getHokenKaisyaTelno() {
        return hokenKaisyaTelno;
    }

    public void setHokenKaisyaTelno(String pHokenKaisyaTelno) {
        hokenKaisyaTelno = pHokenKaisyaTelno;
    }

    private String hokenKaisyaNmKanji;

    public String getHokenKaisyaNmKanji() {
        return hokenKaisyaNmKanji;
    }

    public void setHokenKaisyaNmKanji(String pHokenKaisyaNmKanji) {
        hokenKaisyaNmKanji = pHokenKaisyaNmKanji;
    }

    private String seirino1;

    public String getSeirino1() {
        return seirino1;
    }

    public void setSeirino1(String pSeirino1) {
        seirino1 = pSeirino1;
    }

    private Integer searchResultMaxCnt;

    public Integer getSearchResultMaxCnt() {
        return searchResultMaxCnt;
    }

    public void setSearchResultMaxCnt(Integer pSearchResultMaxCnt) {
        searchResultMaxCnt = pSearchResultMaxCnt;
    }

    private Integer jyuusyoNyuuryokuJyougenCnt;

    public Integer getJyuusyoNyuuryokuJyougenCnt() {
        return jyuusyoNyuuryokuJyougenCnt;
    }

    public void setJyuusyoNyuuryokuJyougenCnt(Integer pJyuusyoNyuuryokuJyougenCnt) {
        jyuusyoNyuuryokuJyougenCnt = pJyuusyoNyuuryokuJyougenCnt;
    }

    private String seirino2;

    public String getSeirino2() {
        return seirino2;
    }

    public void setSeirino2(String pSeirino2) {
        seirino2 = pSeirino2;
    }

    private BizDate tekiyouKaisiYmd;

    public BizDate getTekiyouKaisiYmd() {
        return tekiyouKaisiYmd;
    }

    public void setTekiyouKaisiYmd(BizDate pTekiyouKaisiYmd) {
        tekiyouKaisiYmd = pTekiyouKaisiYmd;
    }

    private BizNumber syouhizeiritu;

    public BizNumber getSyouhizeiritu() {
        return syouhizeiritu;
    }

    public void setSyouhizeiritu(BizNumber pSyouhizeiritu) {
        syouhizeiritu = pSyouhizeiritu;
    }

    private BizNumber sinsyouhizeiritu;

    public BizNumber getSinsyouhizeiritu() {
        return sinsyouhizeiritu;
    }

    public void setSinsyouhizeiritu(BizNumber pSinsyouhizeiritu) {
        sinsyouhizeiritu = pSinsyouhizeiritu;
    }

    private Integer yenkaKouzaKetasuu;

    public Integer getYenkaKouzaKetasuu() {
        return yenkaKouzaKetasuu;
    }

    public void setYenkaKouzaKetasuu(Integer pYenkaKouzaKetasuu) {
        yenkaKouzaKetasuu = pYenkaKouzaKetasuu;
    }

    private Integer gaikaKouzaKetasuu;

    public Integer getGaikaKouzaKetasuu() {
        return gaikaKouzaKetasuu;
    }

    public void setGaikaKouzaKetasuu(Integer pGaikaKouzaKetasuu) {
        gaikaKouzaKetasuu = pGaikaKouzaKetasuu;
    }

    private String imiBangouChkPtn;

    public String getImiBangouChkPtn() {
        return imiBangouChkPtn;
    }

    public void setImiBangouChkPtn(String pImiBangouChkPtn) {
        imiBangouChkPtn = pImiBangouChkPtn;
    }

    private String itijiFileHozonsaki;

    public String getItijiFileHozonsaki() {
        return itijiFileHozonsaki;
    }

    public void setItijiFileHozonsaki(String pItijiFileHozonsaki) {
        itijiFileHozonsaki = pItijiFileHozonsaki;
    }

    private BizNumber nkshrtkyknksyukknFrom;

    public BizNumber getNkshrtkyknksyukknFrom() {
        return nkshrtkyknksyukknFrom;
    }

    public void setNkshrtkyknksyukknFrom(BizNumber pNkshrtkyknksyukknFrom) {
        nkshrtkyknksyukknFrom = pNkshrtkyknksyukknFrom;
    }

    private BizNumber nkshrtkyknksyukknTo;

    public BizNumber getNkshrtkyknksyukknTo() {
        return nkshrtkyknksyukknTo;
    }

    public void setNkshrtkyknksyukknTo(BizNumber pNkshrtkyknksyukknTo) {
        nkshrtkyknksyukknTo = pNkshrtkyknksyukknTo;
    }

    private String smbcOyadrtencd;

    public String getSmbcOyadrtencd() {
        return smbcOyadrtencd;
    }

    public void setSmbcOyadrtencd(String pSmbcOyadrtencd) {
        smbcOyadrtencd = pSmbcOyadrtencd;
    }

    private String mizuhoOyadrtencd;

    public String getMizuhoOyadrtencd() {
        return mizuhoOyadrtencd;
    }

    public void setMizuhoOyadrtencd(String pMizuhoOyadrtencd) {
        mizuhoOyadrtencd = pMizuhoOyadrtencd;
    }

    private String kanposeimeiOyadrtencd;

    public String getKanposeimeiOyadrtencd() {
        return kanposeimeiOyadrtencd;
    }

    public void setKanposeimeiOyadrtencd(String pKanposeimeiOyadrtencd) {
        kanposeimeiOyadrtencd = pKanposeimeiOyadrtencd;
    }

    private String yuutyoginkouOyadrtencd;

    public String getYuutyoginkouOyadrtencd() {
        return yuutyoginkouOyadrtencd;
    }

    public void setYuutyoginkouOyadrtencd(String pYuutyoginkouOyadrtencd) {
        yuutyoginkouOyadrtencd = pYuutyoginkouOyadrtencd;
    }

    private String nihonyuubinOyadrtencd;

    public String getNihonyuubinOyadrtencd() {
        return nihonyuubinOyadrtencd;
    }

    public void setNihonyuubinOyadrtencd(String pNihonyuubinOyadrtencd) {
        nihonyuubinOyadrtencd = pNihonyuubinOyadrtencd;
    }

    private String smtbOyadrtencd;

    public String getSmtbOyadrtencd() {
        return smtbOyadrtencd;
    }

    public void setSmtbOyadrtencd(String pSmtbOyadrtencd) {
        smtbOyadrtencd = pSmtbOyadrtencd;
    }

    private List<String> mrfkouzatoriatukaiOyadrtencdList = new ArrayList<>();

    public List<String> getMrfkouzatoriatukaiOyadrtencdList() {
        return Collections.unmodifiableList(mrfkouzatoriatukaiOyadrtencdList);
    }

    public void addMrfkouzatoriatukaiOyadrtencd(String pMrfkouzatoriatukaiOyadrtencd) {
        mrfkouzatoriatukaiOyadrtencdList.add(pMrfkouzatoriatukaiOyadrtencd);
    }

    private String sikinkoubaibukacd;

    public String getSikinkoubaibukacd() {
        return sikinkoubaibukacd;
    }

    public void setSikinkoubaibukacd(String pSikinkoubaibukacd) {
        sikinkoubaibukacd = pSikinkoubaibukacd;
    }

    private String callcentersosikicd;

    public String getCallcentersosikicd() {
        return callcentersosikicd;
    }

    public void setCallcentersosikicd(String pCallcentersosikicd) {
        callcentersosikicd = pCallcentersosikicd;
    }

    private List<String> hanteiyouCallcentersosikicdList = new ArrayList<>();

    public List<String> getHanteiyouCallcentersosikicdList() {
        return Collections.unmodifiableList(hanteiyouCallcentersosikicdList);
    }

    public void addHanteiyouCallcentersosikicd(String pHanteiyouCallcentersosikicd) {
        hanteiyouCallcentersosikicdList.add(pHanteiyouCallcentersosikicd);
    }

    private String uketimecallcenter1;

    public String getUketimecallcenter1() {
        return uketimecallcenter1;
    }

    public void setUketimecallcenter1(String pUketimecallcenter1) {
        uketimecallcenter1 = pUketimecallcenter1;
    }

    private String uketimecallcenter2;

    public String getUketimecallcenter2() {
        return uketimecallcenter2;
    }

    public void setUketimecallcenter2(String pUketimecallcenter2) {
        uketimecallcenter2 = pUketimecallcenter2;
    }

    private String uketimetantousitu1;

    public String getUketimetantousitu1() {
        return uketimetantousitu1;
    }

    public void setUketimetantousitu1(String pUketimetantousitu1) {
        uketimetantousitu1 = pUketimetantousitu1;
    }

    private String uketimetantousitu2;

    public String getUketimetantousitu2() {
        return uketimetantousitu2;
    }

    public void setUketimetantousitu2(String pUketimetantousitu2) {
        uketimetantousitu2 = pUketimetantousitu2;
    }

    private String kariukesiharaisosikicd1;

    public String getKariukesiharaisosikicd1() {
        return kariukesiharaisosikicd1;
    }

    public void setKariukesiharaisosikicd1(String pKariukesiharaisosikicd1) {
        kariukesiharaisosikicd1 = pKariukesiharaisosikicd1;
    }

    private String kariukesiharaisosikicd21;

    public String getKariukesiharaisosikicd21() {
        return kariukesiharaisosikicd21;
    }

    public void setKariukesiharaisosikicd21(String pKariukesiharaisosikicd21) {
        kariukesiharaisosikicd21 = pKariukesiharaisosikicd21;
    }

    private String kariukesiharaisosikicd22;

    public String getKariukesiharaisosikicd22() {
        return kariukesiharaisosikicd22;
    }

    public void setKariukesiharaisosikicd22(String pKariukesiharaisosikicd22) {
        kariukesiharaisosikicd22 = pKariukesiharaisosikicd22;
    }

    private String kariukesiharaisosikicd23;

    public String getKariukesiharaisosikicd23() {
        return kariukesiharaisosikicd23;
    }

    public void setKariukesiharaisosikicd23(String pKariukesiharaisosikicd23) {
        kariukesiharaisosikicd23 = pKariukesiharaisosikicd23;
    }

    private String kariukesiharaisosikicd3;

    public String getKariukesiharaisosikicd3() {
        return kariukesiharaisosikicd3;
    }

    public void setKariukesiharaisosikicd3(String pKariukesiharaisosikicd3) {
        kariukesiharaisosikicd3 = pKariukesiharaisosikicd3;
    }

    private String kariukesiharaisosikicd4;

    public String getKariukesiharaisosikicd4() {
        return kariukesiharaisosikicd4;
    }

    public void setKariukesiharaisosikicd4(String pKariukesiharaisosikicd4) {
        kariukesiharaisosikicd4 = pKariukesiharaisosikicd4;
    }

    private String kariukesiharaisosikicd5;

    public String getKariukesiharaisosikicd5() {
        return kariukesiharaisosikicd5;
    }

    public void setKariukesiharaisosikicd5(String pKariukesiharaisosikicd5) {
        kariukesiharaisosikicd5 = pKariukesiharaisosikicd5;
    }

    private String kariukesiharaisosikicd6;

    public String getKariukesiharaisosikicd6() {
        return kariukesiharaisosikicd6;
    }

    public void setKariukesiharaisosikicd6(String pKariukesiharaisosikicd6) {
        kariukesiharaisosikicd6 = pKariukesiharaisosikicd6;
    }

    private String hjybtantositucd1;

    public String getHjybtantositucd1() {
        return hjybtantositucd1;
    }

    public void setHjybtantositucd1(String pHjybtantositucd1) {
        hjybtantositucd1 = pHjybtantositucd1;
    }

    private String hjybtantositucd2;

    public String getHjybtantositucd2() {
        return hjybtantositucd2;
    }

    public void setHjybtantositucd2(String pHjybtantositucd2) {
        hjybtantositucd2 = pHjybtantositucd2;
    }

    private String hjybtantositucd3;

    public String getHjybtantositucd3() {
        return hjybtantositucd3;
    }

    public void setHjybtantositucd3(String pHjybtantositucd3) {
        hjybtantositucd3 = pHjybtantositucd3;
    }

    private String hjybtantositucd4;

    public String getHjybtantositucd4() {
        return hjybtantositucd4;
    }

    public void setHjybtantositucd4(String pHjybtantositucd4) {
        hjybtantositucd4 = pHjybtantositucd4;
    }

    private String hjybtantositucd5;

    public String getHjybtantositucd5() {
        return hjybtantositucd5;
    }

    public void setHjybtantositucd5(String pHjybtantositucd5) {
        hjybtantositucd5 = pHjybtantositucd5;
    }

    private String hjybtantositucd6;

    public String getHjybtantositucd6() {
        return hjybtantositucd6;
    }

    public void setHjybtantositucd6(String pHjybtantositucd6) {
        hjybtantositucd6 = pHjybtantositucd6;
    }

    private String hjybtantositucd7;

    public String getHjybtantositucd7() {
        return hjybtantositucd7;
    }

    public void setHjybtantositucd7(String pHjybtantositucd7) {
        hjybtantositucd7 = pHjybtantositucd7;
    }

    private String tableTeigiInfoKakunouPass;

    public String getTableTeigiInfoKakunouPass() {
        return tableTeigiInfoKakunouPass;
    }

    public void setTableTeigiInfoKakunouPass(String pTableTeigiInfoKakunouPass) {
        tableTeigiInfoKakunouPass = pTableTeigiInfoKakunouPass;
    }

    private String teigiInfoKakunouRootPass;

    public String getTeigiInfoKakunouRootPass() {
        return teigiInfoKakunouRootPass;
    }

    public void setTeigiInfoKakunouRootPass(String pTeigiInfoKakunouRootPass) {
        teigiInfoKakunouRootPass = pTeigiInfoKakunouRootPass;
    }

    private Integer hubianswernissuu;

    public Integer getHubianswernissuu() {
        return hubianswernissuu;
    }

    public void setHubianswernissuu(Integer pHubianswernissuu) {
        hubianswernissuu = pHubianswernissuu;
    }

    private Integer douhassinsakihubimaxkensuu;

    public Integer getDouhassinsakihubimaxkensuu() {
        return douhassinsakihubimaxkensuu;
    }

    public void setDouhassinsakihubimaxkensuu(Integer pDouhassinsakihubimaxkensuu) {
        douhassinsakihubimaxkensuu = pDouhassinsakihubimaxkensuu;
    }

    private Integer tyoukihubihanteinissuu;

    public Integer getTyoukihubihanteinissuu() {
        return tyoukihubihanteinissuu;
    }

    public void setTyoukihubihanteinissuu(Integer pTyoukihubihanteinissuu) {
        tyoukihubihanteinissuu = pTyoukihubihanteinissuu;
    }

    private String huridenyouhassoukbn1tantousitucd;

    public String getHuridenyouhassoukbn1tantousitucd() {
        return huridenyouhassoukbn1tantousitucd;
    }

    public void setHuridenyouhassoukbn1tantousitucd(String pHuridenyouhassoukbn1tantousitucd) {
        huridenyouhassoukbn1tantousitucd = pHuridenyouhassoukbn1tantousitucd;
    }

    private String huridenyouhassoukbn2tantousitucd;

    public String getHuridenyouhassoukbn2tantousitucd() {
        return huridenyouhassoukbn2tantousitucd;
    }

    public void setHuridenyouhassoukbn2tantousitucd(String pHuridenyouhassoukbn2tantousitucd) {
        huridenyouhassoukbn2tantousitucd = pHuridenyouhassoukbn2tantousitucd;
    }

    private String huridenyouhassoukbn3tantousitucd;

    public String getHuridenyouhassoukbn3tantousitucd() {
        return huridenyouhassoukbn3tantousitucd;
    }

    public void setHuridenyouhassoukbn3tantousitucd(String pHuridenyouhassoukbn3tantousitucd) {
        huridenyouhassoukbn3tantousitucd = pHuridenyouhassoukbn3tantousitucd;
    }

    private String huridenyouhassoukbn4tantousitucd;

    public String getHuridenyouhassoukbn4tantousitucd() {
        return huridenyouhassoukbn4tantousitucd;
    }

    public void setHuridenyouhassoukbn4tantousitucd(String pHuridenyouhassoukbn4tantousitucd) {
        huridenyouhassoukbn4tantousitucd = pHuridenyouhassoukbn4tantousitucd;
    }

    private String huridenyouhassoukbn5tantousitucd;

    public String getHuridenyouhassoukbn5tantousitucd() {
        return huridenyouhassoukbn5tantousitucd;
    }

    public void setHuridenyouhassoukbn5tantousitucd(String pHuridenyouhassoukbn5tantousitucd) {
        huridenyouhassoukbn5tantousitucd = pHuridenyouhassoukbn5tantousitucd;
    }

    private String huridenyouhassoukbn6tantousitucd;

    public String getHuridenyouhassoukbn6tantousitucd() {
        return huridenyouhassoukbn6tantousitucd;
    }

    public void setHuridenyouhassoukbn6tantousitucd(String pHuridenyouhassoukbn6tantousitucd) {
        huridenyouhassoukbn6tantousitucd = pHuridenyouhassoukbn6tantousitucd;
    }

    private String huridenyouhassoukbn7tantousitucd;

    public String getHuridenyouhassoukbn7tantousitucd() {
        return huridenyouhassoukbn7tantousitucd;
    }

    public void setHuridenyouhassoukbn7tantousitucd(String pHuridenyouhassoukbn7tantousitucd) {
        huridenyouhassoukbn7tantousitucd = pHuridenyouhassoukbn7tantousitucd;
    }

    private String huridenyouhassoukbn8tantousitucd;

    public String getHuridenyouhassoukbn8tantousitucd() {
        return huridenyouhassoukbn8tantousitucd;
    }

    public void setHuridenyouhassoukbn8tantousitucd(String pHuridenyouhassoukbn8tantousitucd) {
        huridenyouhassoukbn8tantousitucd = pHuridenyouhassoukbn8tantousitucd;
    }

    private List<String> hnsyaSyoukaiSosikiyouRoleCdList = new ArrayList<>();

    public List<String> getHnsyaSyoukaiSosikiyouRoleCdList() {
        return Collections.unmodifiableList(hnsyaSyoukaiSosikiyouRoleCdList);
    }

    public void addHnsyaSyoukaiSosikiyouRoleCd(String pHnsyaSyoukaiSosikiyouRoleCd) {
        hnsyaSyoukaiSosikiyouRoleCdList.add(pHnsyaSyoukaiSosikiyouRoleCd);
    }

    private List<String> sisyayouRoleCdList = new ArrayList<>();

    public List<String> getSisyayouRoleCdList() {
        return Collections.unmodifiableList(sisyayouRoleCdList);
    }

    public void addSisyayouRoleCd(String pSisyayouRoleCd) {
        sisyayouRoleCdList.add(pSisyayouRoleCd);
    }

    private List<String> sisyaReigaiSosikiCdList = new ArrayList<>();

    public List<String> getSisyaReigaiSosikiCdList() {
        return Collections.unmodifiableList(sisyaReigaiSosikiCdList);
    }

    public void addSisyaReigaiSosikiCd(String pSisyaReigaiSosikiCd) {
        sisyaReigaiSosikiCdList.add(pSisyaReigaiSosikiCd);
    }

    private List<String> fileDownloadAbleMachineKindList = new ArrayList<>();

    public List<String> getFileDownloadAbleMachineKindList() {
        return Collections.unmodifiableList(fileDownloadAbleMachineKindList);
    }

    public void addFileDownloadAbleMachineKind(String pFileDownloadAbleMachineKind) {
        fileDownloadAbleMachineKindList.add(pFileDownloadAbleMachineKind);
    }

    private String provideKinouId;

    public String getProvideKinouId() {
        return provideKinouId;
    }

    public void setProvideKinouId(String pProvideKinouId) {
        provideKinouId = pProvideKinouId;
    }

    private List<String> sisyaAtukaiSosikiCdList = new ArrayList<>();

    public List<String> getSisyaAtukaiSosikiCdList() {
        return Collections.unmodifiableList(sisyaAtukaiSosikiCdList);
    }

    public void addSisyaAtukaiSosikiCd(String pSisyaAtukaiSosikiCd) {
        sisyaAtukaiSosikiCdList.add(pSisyaAtukaiSosikiCd);
    }

    private String aplLogOutputDir;

    public String getAplLogOutputDir() {
        return aplLogOutputDir;
    }

    public void setAplLogOutputDir(String pAplLogOutputDir) {
        aplLogOutputDir = pAplLogOutputDir;
    }

    private List<String> insatukaKinouIdList = new ArrayList<>();

    public List<String> getInsatukaKinouIdList() {
        return Collections.unmodifiableList(insatukaKinouIdList);
    }

    public void addInsatukaKinouId(String pInsatukaKinouId) {
        insatukaKinouIdList.add(pInsatukaKinouId);
    }

    private List<String> myNumberSyoruiCdList = new ArrayList<>();

    public List<String> getMyNumberSyoruiCdList() {
        return Collections.unmodifiableList(myNumberSyoruiCdList);
    }

    public void addMyNumberSyoruiCd(String pMyNumberSyoruiCd) {
        myNumberSyoruiCdList.add(pMyNumberSyoruiCd);
    }

    private List<String> tableSyoukaiSansyouHukaList = new ArrayList<>();

    public List<String> getTableSyoukaiSansyouHukaList() {
        return Collections.unmodifiableList(tableSyoukaiSansyouHukaList);
    }

    public void addTableSyoukaiSansyouHuka(String pTableSyoukaiSansyouHuka) {
        tableSyoukaiSansyouHukaList.add(pTableSyoukaiSansyouHuka);
    }

    private List<String> htkinSikinIdouDataTrkTsyJobcdList = new ArrayList<>();

    public List<String> getHtkinSikinIdouDataTrkTsyJobcdList() {
        return Collections.unmodifiableList(htkinSikinIdouDataTrkTsyJobcdList);
    }

    public void addHtkinSikinIdouDataTrkTsyJobcd(String pHtkinSikinIdouDataTrkTsyJobcd) {
        htkinSikinIdouDataTrkTsyJobcdList.add(pHtkinSikinIdouDataTrkTsyJobcd);
    }

    private List<String> syoruiToutyakuErrorTsgList = new ArrayList<>();

    public List<String> getSyoruiToutyakuErrorTsgList() {
        return Collections.unmodifiableList(syoruiToutyakuErrorTsgList);
    }

    public void addSyoruiToutyakuErrorTsg(String pSyoruiToutyakuErrorTsg) {
        syoruiToutyakuErrorTsgList.add(pSyoruiToutyakuErrorTsg);
    }
}
