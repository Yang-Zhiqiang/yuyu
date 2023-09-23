package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 仕訳判定用入金実績履歴項目
 */
public class SiwakeHanteiNyknJissekiRirekiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency rsgaku;

    private BizCurrency hrkp;

    private int jyutoukaisuum;

    private BizDateYM jyutoustartym;

    private BizDateYM jyutouendym;

    public SiwakeHanteiNyknJissekiRirekiBean() {
        super();
    }

    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    public void setRsgaku(BizCurrency pRsgaku) {
        this.rsgaku = pRsgaku;
    }

    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        this.hrkp = pHrkp;
    }

    public int getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    public void setJyutoukaisuum(int pJyutoukaisuum) {
        this.jyutoukaisuum = pJyutoukaisuum;
    }

    public BizDateYM getJyutoustartym() {
        return jyutoustartym;
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        this.jyutoustartym = pJyutoustartym;
    }

    public BizDateYM getJyutouendym() {
        return jyutouendym;
    }

    public void setJyutouendym(BizDateYM pJyutouendym) {
        this.jyutouendym = pJyutouendym;
    }


}
