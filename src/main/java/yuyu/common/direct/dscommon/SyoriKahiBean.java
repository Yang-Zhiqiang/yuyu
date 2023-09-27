package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DsPhrkhouhenkouKahiSeigyoKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;

/**
 * 処理可否情報のBeanです。<br/>
 */
public class SyoriKahiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_KahiKbn kjsmSaihakkouKahiKbn;

    private C_KahiKbn kykMeigihnkKahiKbn;

    private C_KahiKbn syoukenSaihkKahiKbn;

    private C_KahiKbn stdrskTkyTthkKahiKbn;

    private C_KahiKbn targetTkhkKahiKbn;

    private C_KahiKbn kykNiyuSyoukaiKahiKbn;

    private C_KahiKbn tumitatekinItenKahiKbn;

    private C_KahiKbn dsKaiyakuKahiKbn;

    private C_KahiKbn adrHenkouKahiKbn;

    private C_DsPhrkhouhenkouKahiSeigyoKbn phrkhouHenkouKahiKbn;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_KahiKbn getKjsmSaihakkouKahiKbn() {
        return kjsmSaihakkouKahiKbn;
    }

    public void setKjsmSaihakkouKahiKbn(C_KahiKbn pKjsmSaihakkouKahiKbn) {
        this.kjsmSaihakkouKahiKbn = pKjsmSaihakkouKahiKbn;
    }

    public C_KahiKbn getKykMeigihnkKahiKbn() {
        return kykMeigihnkKahiKbn;
    }

    public void setKykMeigihnkKahiKbn(C_KahiKbn pKykMeigihnkKahiKbn) {
        this.kykMeigihnkKahiKbn = pKykMeigihnkKahiKbn;
    }

    public C_KahiKbn getSyoukenSaihkKahiKbn() {
        return syoukenSaihkKahiKbn;
    }

    public void setSyoukenSaihkKahiKbn(C_KahiKbn pSyoukenSaihkKahiKbn) {
        this.syoukenSaihkKahiKbn = pSyoukenSaihkKahiKbn;
    }

    public C_KahiKbn getStdrskTkyTthkKahiKbn() {
        return stdrskTkyTthkKahiKbn;
    }

    public void setStdrskTkyTthkKahiKbn(C_KahiKbn pStdrskTkyTthkKahiKbn) {
        this.stdrskTkyTthkKahiKbn = pStdrskTkyTthkKahiKbn;
    }

    public C_KahiKbn getTargetTkhkKahiKbn() {
        return targetTkhkKahiKbn;
    }

    public void setTargetTkhkKahiKbn(C_KahiKbn pTargetTkhkKahiKbn) {
        this.targetTkhkKahiKbn = pTargetTkhkKahiKbn;
    }

    public C_KahiKbn getKykNiyuSyoukaiKahiKbn() {
        return kykNiyuSyoukaiKahiKbn;
    }

    public void setKykNiyuSyoukaiKahiKbn(C_KahiKbn pKykNiyuSyoukaiKahiKbn) {
        this.kykNiyuSyoukaiKahiKbn = pKykNiyuSyoukaiKahiKbn;
    }

    public C_KahiKbn getTumitatekinItenKahiKbn() {
        return tumitatekinItenKahiKbn;
    }

    public void setTumitatekinItenKahiKbn(C_KahiKbn pTumitatekinItenKahiKbn) {
        this.tumitatekinItenKahiKbn = pTumitatekinItenKahiKbn;
    }

    public C_KahiKbn getDsKaiyakuKahiKbn() {
        return dsKaiyakuKahiKbn;
    }

    public void setDsKaiyakuKahiKbn(C_KahiKbn pDsKaiyakuKahiKbn) {
        this.dsKaiyakuKahiKbn = pDsKaiyakuKahiKbn;
    }

    public C_KahiKbn getAdrHenkouKahiKbn() {
        return adrHenkouKahiKbn;
    }

    public void setAdrHenkouKahiKbn(C_KahiKbn pAdrHenkouKahiKbn) {
        this.adrHenkouKahiKbn = pAdrHenkouKahiKbn;
    }

    public C_DsPhrkhouhenkouKahiSeigyoKbn getPhrkhouHenkouKahiKbn() {
        return phrkhouHenkouKahiKbn;
    }

    public void setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn pPhrkhouHenkouKahiKbn) {
        this.phrkhouHenkouKahiKbn = pPhrkhouHenkouKahiKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
