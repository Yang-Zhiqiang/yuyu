package yuyu.common.siharai.sicommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金仕訳共通処理入力Bean
 */
public class SiCommonSiwakeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private BizDate denYmd;

    private C_Tuukasyu tuukasyu;

    private C_Tuukasyu keiyakuTuukasyu;

    private C_InputShrhousiteiKbn inputShrhousiteiKbn;

    private C_ShrhousiteiKbn shrhousiteiKbn;

    private BizDate syoriYmd;

    private String syoriCd;

    private String syoriSosikiCd;

    private boolean kakoKawaserateShiteiFlg;

    private BizDate kakoKawaserateShiteiYmd;

    private String syouhnCd;

    private Integer syouhnsdNo;

    private C_UmuKbn nkRendouUmu;

    private List<SiharaigakuBean> siharaigakuBeanList;

    private BizCurrency sindansyo;

    private BizCurrency haitoukin;

    private BizCurrency yenkaHaitoukin;

    private BizCurrency sonotaHaitoukin;

    private BizCurrency yenkaSonotaHaitoukin;

    private BizCurrency misyuup;

    private BizCurrency yenkaMisyuup;

    private List<SiDetailMisyuupBean> siDetailMisyuupBeanLst;

    private BizDateYM mikeikapJyuutouym;

    private BizCurrency mikeikap;

    private BizCurrency yenkaMikeikap;

    private List<SiDetailMikeikapBean> siDetailMikeikapBeanLst;

    private BizDate zennouryosyuymd;

    private BizCurrency zennouseisank;

    private BizCurrency yenkaZennouseisank;

    private BizCurrency azukarikingk;

    private BizCurrency yenkaAzukarikingk;

    private BizCurrency zitkAzukarikingkSiteituuka;

    private BizCurrency yenZitkAzukarikingkSttk;

    private BizCurrency zitkAzukarikingkYen;

    private BizCurrency gaikknsnZitkAzukarikingkYen;

    private BizCurrency krkgk;

    private BizCurrency yenkaKrkgk;

    private BizCurrency shrtienRsk;

    private BizCurrency keiyakuShrtienRsk;

    private BizCurrency shrgkkei;

    private C_UmuKbn itijibrumu;

    private BizNumber kawaserate;

    private BizNumber gaikaknsnKwsrate;

    private BizDate kykymd;

    private BizDateYM nexthrkym;

    private C_Hrkkaisuu hrkkaisuu;

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;


    public SiCommonSiwakeBean() {
        keiyakuTuukasyu = C_Tuukasyu.JPY;
        keiyakuShrtienRsk = BizCurrency.valueOf(0);
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public C_Tuukasyu getKeiyakuTuukasyu() {
        return keiyakuTuukasyu;
    }

    public void setKeiyakuTuukasyu(C_Tuukasyu pKeiyakuTuukasyu) {
        keiyakuTuukasyu = pKeiyakuTuukasyu;
    }

    public C_InputShrhousiteiKbn getInputShrhousiteiKbn() {
        return inputShrhousiteiKbn;
    }

    public void setInputShrhousiteiKbn(C_InputShrhousiteiKbn pInputShrhousiteiKbn) {
        inputShrhousiteiKbn = pInputShrhousiteiKbn;
    }

    public C_ShrhousiteiKbn getShrhousiteiKbn() {
        return shrhousiteiKbn;
    }

    public void setShrhousiteiKbn(C_ShrhousiteiKbn pShrhousiteiKbn) {
        shrhousiteiKbn = pShrhousiteiKbn;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public String getSyoriCd() {
        return syoriCd;
    }

    public void setSyoriCd(String pSyoriCd) {
        syoriCd = pSyoriCd;
    }

    public String getSyoriSosikiCd() {
        return syoriSosikiCd;
    }

    public void setSyoriSosikiCd(String pSyoriSosikiCd) {
        syoriSosikiCd = pSyoriSosikiCd;
    }

    public boolean getKakoKawaserateShiteiFlg() {
        return kakoKawaserateShiteiFlg;
    }

    public void setKakoKawaserateShiteiFlg(boolean pKakoKawaserateShiteiFlg) {
        kakoKawaserateShiteiFlg = pKakoKawaserateShiteiFlg;
    }

    public BizDate getKakoKawaserateShiteiYmd() {
        return kakoKawaserateShiteiYmd;
    }

    public void setKakoKawaserateShiteiYmd(BizDate pKakoKawaserateShiteiYmd) {
        kakoKawaserateShiteiYmd = pKakoKawaserateShiteiYmd;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }

    public Integer getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(Integer pSyouhnsdNo) {
        syouhnsdNo = pSyouhnsdNo;
    }

    public C_UmuKbn getNkRendouUmu() {
        return nkRendouUmu;
    }

    public void setNkRendouUmu(C_UmuKbn pNkRendouUmu) {
        nkRendouUmu = pNkRendouUmu;
    }

    public List<SiharaigakuBean> getSiharaigakuBeanList() {
        return siharaigakuBeanList;
    }

    public void setSiharaigakuBeanList(List<SiharaigakuBean> pSiharaigakuBeanList) {
        siharaigakuBeanList = pSiharaigakuBeanList;
    }

    public BizCurrency getSindansyo() {
        return sindansyo;
    }

    public void setSindansyo(BizCurrency pSindansyo) {
        sindansyo = pSindansyo;
    }

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
    }

    public BizCurrency getYenkaHaitoukin() {
        return yenkaHaitoukin;
    }

    public void setYenkaHaitoukin(BizCurrency pYenkaHaitoukin) {
        yenkaHaitoukin = pYenkaHaitoukin;
    }

    public BizCurrency getSonotaHaitoukin() {
        return sonotaHaitoukin;
    }

    public void setSonotaHaitoukin(BizCurrency pSonotaHaitoukin) {
        sonotaHaitoukin = pSonotaHaitoukin;
    }

    public BizCurrency getYenkaSonotaHaitoukin() {
        return yenkaSonotaHaitoukin;
    }

    public void setYenkaSonotaHaitoukin(BizCurrency pYenkaSonotaHaitoukin) {
        yenkaSonotaHaitoukin = pYenkaSonotaHaitoukin;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    public BizCurrency getYenkaMisyuup() {
        return yenkaMisyuup;
    }

    public void setYenkaMisyuup(BizCurrency pYenkaMisyuup) {
        yenkaMisyuup = pYenkaMisyuup;
    }

    public List<SiDetailMisyuupBean> getSiDetailMisyuupBeanLst() {
        return siDetailMisyuupBeanLst;
    }

    public void setSiDetailMisyuupBeanLst(List<SiDetailMisyuupBean> pSiDetailMisyuupBeanLst) {
        siDetailMisyuupBeanLst = pSiDetailMisyuupBeanLst;
    }

    public BizDateYM getMikeikapJyuutouym() {
        return mikeikapJyuutouym;
    }

    public void setMikeikapJyuutouym(BizDateYM pMikeikapJyuutouym) {
        mikeikapJyuutouym = pMikeikapJyuutouym;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    public BizCurrency getYenkaMikeikap() {
        return yenkaMikeikap;
    }

    public void setYenkaMikeikap(BizCurrency pYenkaMikeikap) {
        yenkaMikeikap = pYenkaMikeikap;
    }

    public List<SiDetailMikeikapBean> getSiDetailMikeikapBeanLst() {
        return siDetailMikeikapBeanLst;
    }

    public void setSiDetailMikeikapBeanLst(List<SiDetailMikeikapBean> pSiDetailMikeikapBeanLst) {
        siDetailMikeikapBeanLst = pSiDetailMikeikapBeanLst;
    }

    public BizDate getZennouryosyuymd() {
        return zennouryosyuymd;
    }

    public void setZennouryosyuymd(BizDate pZennouryosyuymd) {
        zennouryosyuymd = pZennouryosyuymd;
    }

    public BizCurrency getZennouseisank() {
        return zennouseisank;
    }

    public void setZennouseisank(BizCurrency pZennouseisank) {
        zennouseisank = pZennouseisank;
    }

    public BizCurrency getYenkaZennouseisank() {
        return yenkaZennouseisank;
    }

    public void setYenkaZennouseisank(BizCurrency pYenkaZennouseisank) {
        yenkaZennouseisank = pYenkaZennouseisank;
    }

    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
    }

    public BizCurrency getYenkaAzukarikingk() {
        return yenkaAzukarikingk;
    }

    public void setYenkaAzukarikingk(BizCurrency pYenkaAzukarikingk) {
        yenkaAzukarikingk = pYenkaAzukarikingk;
    }

    public BizCurrency getZitkAzukarikingkSiteituuka() {
        return zitkAzukarikingkSiteituuka;
    }

    public void setZitkAzukarikingkSiteituuka(BizCurrency pZitkAzukarikingkSiteituuka) {
        zitkAzukarikingkSiteituuka = pZitkAzukarikingkSiteituuka;
    }

    public BizCurrency getYenZitkAzukarikingkSttk() {
        return yenZitkAzukarikingkSttk;
    }

    public void setYenZitkAzukarikingkSttk(BizCurrency pYenZitkAzukarikingkSttk) {
        yenZitkAzukarikingkSttk = pYenZitkAzukarikingkSttk;
    }

    public BizCurrency getZitkAzukarikingkYen() {
        return zitkAzukarikingkYen;
    }

    public void setZitkAzukarikingkYen(BizCurrency pZitkAzukarikingkYen) {
        zitkAzukarikingkYen = pZitkAzukarikingkYen;
    }

    public BizCurrency getGaikknsnZitkAzukarikingkYen() {
        return gaikknsnZitkAzukarikingkYen;
    }

    public void setGaikknsnZitkAzukarikingkYen(BizCurrency pGaikknsnZitkAzukarikingkYen) {
        gaikknsnZitkAzukarikingkYen = pGaikknsnZitkAzukarikingkYen;
    }

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }

    public BizCurrency getYenkaKrkgk() {
        return yenkaKrkgk;
    }

    public void setYenkaKrkgk(BizCurrency pYenkaKrkgk) {
        yenkaKrkgk = pYenkaKrkgk;
    }

    public BizCurrency getShrtienRsk() {
        return shrtienRsk;
    }

    public void setShrtienRsk(BizCurrency pShrtienRsk) {
        shrtienRsk = pShrtienRsk;
    }

    public BizCurrency getKeiyakuShrtienRsk() {
        return keiyakuShrtienRsk;
    }

    public void setKeiyakuShrtienRsk(BizCurrency pKeiyakuShrtienRsk) {
        keiyakuShrtienRsk = pKeiyakuShrtienRsk;
    }

    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    public C_UmuKbn getItijibrumu() {
        return itijibrumu;
    }

    public void setItijibrumu(C_UmuKbn pItijibrumu) {
        itijibrumu = pItijibrumu;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    public BizNumber getGaikaknsnKwsrate() {
        return gaikaknsnKwsrate;
    }

    public void setGaikaknsnKwsrate(BizNumber pGaikaknsnKwsrate) {
        gaikaknsnKwsrate = pGaikaknsnKwsrate;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public BizDateYM getNexthrkym() {
        return nexthrkym;
    }

    public void setNexthrkym(BizDateYM pNexthrkym) {
        nexthrkym = pNexthrkym;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }
}
