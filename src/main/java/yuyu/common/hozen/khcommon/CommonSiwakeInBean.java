package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 仕訳共通処理入力Bean
 */
public class CommonSiwakeInBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String kinouId;

    private BizDate denYmd;

    private C_Tuukasyu tuukasyu;

    private BizDate syoriYmd;

    private BizDate kykYmd;

    private String syouhnCd;

    private int syouhnsdNo;

    private C_SyoriKbn syoriKbn;

    private C_ShrhousiteiKbn shrhousiteiKbn;

    private C_Tuukasyu kyktuukaSyu;

    private BizNumber tuukasyuKansanKawaserate;

    private C_UmuKbn gstszeigkUmuKbn;

    private C_UmuKbn azukarikinUmuKbn;

    private List<TaisyouGkBean> taisyouGkBeanLst;

    private C_DseisantetudukimeiKbn haitoukinTuibaraiHanteiKbn;

    private C_HijynbrKanritukaHantKbn hijynbrKanritukaHantKbn;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
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

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }

    public int getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(int pSyouhnsdNo) {
        syouhnsdNo = pSyouhnsdNo;
    }

    public C_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(C_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public C_ShrhousiteiKbn getShrhousiteiKbn() {
        return shrhousiteiKbn;
    }

    public void setShrhousiteiKbn(C_ShrhousiteiKbn pShrhousiteiKbn) {
        shrhousiteiKbn = pShrhousiteiKbn;
    }

    public C_Tuukasyu getKyktuukaSyu() {
        return kyktuukaSyu;
    }

    public void setKyktuukaSyu(C_Tuukasyu pKyktuukaSyu) {
        kyktuukaSyu = pKyktuukaSyu;
    }

    public BizNumber getTuukasyuKansanKawaserate() {
        return tuukasyuKansanKawaserate;
    }

    public void setTuukasyuKansanKawaserate(BizNumber pTuukasyuKansanKawaserate) {
        tuukasyuKansanKawaserate = pTuukasyuKansanKawaserate;
    }

    public C_UmuKbn getGstszeigkUmuKbn() {
        return gstszeigkUmuKbn;
    }

    public void setGstszeigkUmuKbn(C_UmuKbn pGstszeigkUmuKbn) {
        gstszeigkUmuKbn = pGstszeigkUmuKbn;
    }

    public C_UmuKbn getAzukarikinUmuKbn() {
        return azukarikinUmuKbn;
    }

    public void setAzukarikinUmuKbn(C_UmuKbn pAzukarikinUmuKbn) {
        azukarikinUmuKbn = pAzukarikinUmuKbn;
    }

    public List<TaisyouGkBean> getTaisyouGkBeanLst() {
        return taisyouGkBeanLst;
    }

    public void setTaisyouGkBeanLst(List<TaisyouGkBean> pTaisyouGkBeanLst) {
        taisyouGkBeanLst = pTaisyouGkBeanLst;
    }

    public C_DseisantetudukimeiKbn getHaitoukinTuibaraiHanteiKbn() {
        return haitoukinTuibaraiHanteiKbn;
    }

    public void setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn  pHaitoukinTuibaraiHanteiKbn) {
        haitoukinTuibaraiHanteiKbn = pHaitoukinTuibaraiHanteiKbn;
    }

    public C_HijynbrKanritukaHantKbn getHijynbrKanritukaHantKbn() {
        return hijynbrKanritukaHantKbn;
    }

    public void setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn pHijynbrKanritukaHantKbn) {
        hijynbrKanritukaHantKbn = pHijynbrKanritukaHantKbn;
    }
}
