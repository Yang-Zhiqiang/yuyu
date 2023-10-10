package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 受取割合を保持するビーンです。<br />
 */
public class UktrWariaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizNumber uktrwraibunsi;

    private BizNumber uktrwraibunbo;

    UktrWariaiBean(int pUktrwraibunsi, int pUktrwraibunbo){
        this.uktrwraibunsi = BizNumber.valueOf(pUktrwraibunsi);
        this.uktrwraibunbo = BizNumber.valueOf(pUktrwraibunbo);
    }

    public UktrWariaiBean() {
    }

    public BizNumber getUktrwraibunsi() {
        return uktrwraibunsi;
    }

    public void setUktrwraibunsi(BizNumber uktrwraibunsi) {
        this.uktrwraibunsi = uktrwraibunsi;
    }

    public BizNumber getUktrwraibunbo() {
        return uktrwraibunbo;
    }

    public void setUktrwraibunbo(BizNumber uktrwraibunbo) {
        this.uktrwraibunbo = uktrwraibunbo;
    }


}
