package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 ご提出書類Bean
 */
public class EditTeisyutusyoruiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String syoNo;

    private boolean kykHhknDou;

    private int sbuktNin;

    private C_MousideninKbn mousideninKbn;

    private C_UketorininSibouUmuKbn uketorininsibouUmukbn;

    private C_KyksyaSibouUmuKbn kyksyasibouUmukbn;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private C_UmuKbn nstkhkUmu;

    private C_UmuKbn stdrsktkyhkUmu;

    private BizDate lastsyosaihkYmd;

    private C_UktKbn uktKbn;

    private BizCurrency hokenKngk;

    private boolean jisatuMenseki;

    private C_UmuKbn jikojyoukyouhksUmu;

    private C_KykdrknHtdjytKbn kykdrknHtdjyt;

    private C_UmuKbn mynumbertksUmuKbn;

    public EditTeisyutusyoruiBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public boolean getKykHhknDou() {
        return kykHhknDou;
    }

    public void setKykHhknDou(boolean pKykHhknDou) {
        kykHhknDou = pKykHhknDou;
    }

    public int getSbuktNin() {
        return sbuktNin;
    }

    public void setSbuktNin(int pSbuktNin) {
        sbuktNin = pSbuktNin;
    }

    public C_MousideninKbn getMousideninKbn() {
        return mousideninKbn;
    }

    public void setMousideninKbn(C_MousideninKbn pMousideninKbn) {
        mousideninKbn = pMousideninKbn;
    }

    public C_UketorininSibouUmuKbn getUketorininsibouUmukbn() {
        return uketorininsibouUmukbn;
    }

    public void setUketorininsibouUmukbn(C_UketorininSibouUmuKbn pUketorininsibouUmukbn) {
        uketorininsibouUmukbn = pUketorininsibouUmukbn;
    }

    public C_KyksyaSibouUmuKbn getKyksyasibouUmukbn() {
        return kyksyasibouUmukbn;
    }

    public void setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn pKyksyasibouUmukbn) {
        kyksyasibouUmukbn = pKyksyasibouUmukbn;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public C_UmuKbn getNstkhkUmu() {
        return nstkhkUmu;
    }

    public void setNstkhkUmu(C_UmuKbn pNstkhkUmu) {
        nstkhkUmu = pNstkhkUmu;
    }

    public C_UmuKbn getStdrsktkyhkUmu() {
        return stdrsktkyhkUmu;
    }

    public void setStdrsktkyhkUmu(C_UmuKbn pStdrsktkyhkUmu) {
        stdrsktkyhkUmu = pStdrsktkyhkUmu;
    }

    public BizDate getLastsyosaihkYmd() {
        return lastsyosaihkYmd;
    }

    public void setLastsyosaihkYmd(BizDate pLastsyosaihkYmd) {
        lastsyosaihkYmd = pLastsyosaihkYmd;
    }

    public C_UktKbn getUktKbn() {
        return uktKbn;
    }

    public void setUktKbn(C_UktKbn pUktKbn) {
        uktKbn = pUktKbn;
    }

    public BizCurrency getHokenKngk() {
        return hokenKngk;
    }

    public void setHokenKngk(BizCurrency pHokenKngk) {
        hokenKngk = pHokenKngk;
    }

    public boolean getJisatuMenseki() {
        return jisatuMenseki;
    }

    public void setJisatuMenseki(boolean pJisatuMenseki) {
        jisatuMenseki = pJisatuMenseki;
    }

    public C_UmuKbn getJikojyoukyouhksUmu() {
        return jikojyoukyouhksUmu;
    }

    public void setJikojyoukyouhksUmu(C_UmuKbn pJikojyoukyouhksUmu) {
        jikojyoukyouhksUmu = pJikojyoukyouhksUmu;
    }

    public C_KykdrknHtdjytKbn getKykdrknHtdjyt() {
        return kykdrknHtdjyt;
    }

    public void setKykdrknHtdjyt(C_KykdrknHtdjytKbn pKykdrknHtdjyt) {
        kykdrknHtdjyt = pKykdrknHtdjyt;
    }

    public C_UmuKbn getMynumbertksUmuKbn() {
        return mynumbertksUmuKbn;
    }

    public void setMynumbertksUmuKbn(C_UmuKbn mynumbertksUmuKbn) {
        this.mynumbertksUmuKbn = mynumbertksUmuKbn;
    }

}
