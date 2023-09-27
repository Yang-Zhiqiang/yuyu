package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 特約情報Bean。<br/>
 */
public class TokuyakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_UmuKbn kykdrTkykhukaumu;

    private C_UmuKbn stdrskTkyhkumu;

    private C_UmuKbn yenNyknThkumu;

    private C_UmuKbn gaikaNyknTkhkumu;

    private C_UmuKbn targetTkhkumu;

    private C_UmuKbn initSbjiYenSitiHsyTkhukaumu;

    private C_UmuKbn jyudKaigoMeharaiTkhukaumu;

    private C_UmuKbn zeiseiTkkkTkykhukaumu;

    private C_UmuKbn teikiShrTkykhukaumu;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_UmuKbn getKykdrTkykhukaumu() {
        return kykdrTkykhukaumu;
    }

    public void setKykdrTkykhukaumu(C_UmuKbn pKykdrTkykhukaumu) {
        this.kykdrTkykhukaumu = pKykdrTkykhukaumu;
    }

    public C_UmuKbn getStdrskTkyhkumu() {
        return stdrskTkyhkumu;
    }

    public void setStdrskTkyhkumu(C_UmuKbn pStdrskTkyhkumu) {
        this.stdrskTkyhkumu = pStdrskTkyhkumu;
    }

    public C_UmuKbn getYenNyknThkumu() {
        return yenNyknThkumu;
    }

    public void setYenNyknThkumu(C_UmuKbn pYenNyknThkumu) {
        this.yenNyknThkumu = pYenNyknThkumu;
    }

    public C_UmuKbn getGaikaNyknTkhkumu() {
        return gaikaNyknTkhkumu;
    }

    public void setGaikaNyknTkhkumu(C_UmuKbn pGaikaNyknTkhkumu) {
        this.gaikaNyknTkhkumu = pGaikaNyknTkhkumu;
    }

    public C_UmuKbn getTargetTkhkumu() {
        return targetTkhkumu;
    }

    public void setTargetTkhkumu(C_UmuKbn pTargetTkhkumu) {
        this.targetTkhkumu = pTargetTkhkumu;
    }

    public C_UmuKbn getInitSbjiYenSitiHsyTkhukaumu() {
        return initSbjiYenSitiHsyTkhukaumu;
    }

    public void setInitSbjiYenSitiHsyTkhukaumu(C_UmuKbn pInitSbjiYenSitiHsyTkhukaumu) {
        this.initSbjiYenSitiHsyTkhukaumu = pInitSbjiYenSitiHsyTkhukaumu;
    }

    public C_UmuKbn getJyudKaigoMeharaiTkhukaumu() {
        return jyudKaigoMeharaiTkhukaumu;
    }

    public void setJyudKaigoMeharaiTkhukaumu(C_UmuKbn pJyudKaigoMeharaiTkhukaumu) {
        this.jyudKaigoMeharaiTkhukaumu = pJyudKaigoMeharaiTkhukaumu;
    }

    public C_UmuKbn getZeiseiTkkkTkykhukaumu() {
        return zeiseiTkkkTkykhukaumu;
    }

    public void setZeiseiTkkkTkykhukaumu(C_UmuKbn pZeiseiTkkkTkykhukaumu) {
        this.zeiseiTkkkTkykhukaumu = pZeiseiTkkkTkykhukaumu;
    }

    public C_UmuKbn getTeikiShrTkykhukaumu() {
        return teikiShrTkykhukaumu;
    }

    public void setTeikiShrTkykhukaumu(C_UmuKbn pTeikiShrTkykhukaumu) {
        this.teikiShrTkykhukaumu = pTeikiShrTkykhukaumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
