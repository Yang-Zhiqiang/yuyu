package yuyu.batch.siharai.simaster.sibyoumeitorikomi;

import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 病名マスタのホスト不可文字変換に使用するビーンです。<br />
 */
public class SiByoumeiHnknBean {

    @HostInvalidCharacter
    private String byoumeiknkensakuHnkn;

    public String getByoumeiknkensakuHnkn() {
        return byoumeiknkensakuHnkn;
    }

    public void setByoumeiknkensakuHnkn(String byoumeiknkensakuHnkn) {
        this.byoumeiknkensakuHnkn = byoumeiknkensakuHnkn;
    }
}
