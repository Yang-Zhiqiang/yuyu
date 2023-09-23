package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KhDengkSyuruiKbn;

/**
 * 契約保全 契約保全共通 案内収納用対象金額Bean
 */
public class AnsyuuTaisyouGkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KhDengkSyuruiKbn khDengkSyuruiKbn;

    private BizCurrency taisyouGk;

    private BizCurrency keiyakutuukaGk;

    private BizDate nykdenYmd;

    private C_Hrkkaisuu hrkkaisuu;

    private BizDateYM jyutouStartYm;

    private Integer jyutouKaisuuY;

    private Integer jyutouKaisuuM;

    private String denkarikanjyono;

    public C_KhDengkSyuruiKbn getKhDengkSyuruiKbn() {
        return khDengkSyuruiKbn;
    }

    public void setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn pKhDengkSyuruiKbn) {
        khDengkSyuruiKbn = pKhDengkSyuruiKbn;
    }

    public BizCurrency getTaisyouGk() {
        return taisyouGk;
    }

    public void setTaisyouGk(BizCurrency pTaisyouGk) {
        taisyouGk = pTaisyouGk;
    }

    public BizCurrency getKeiyakutuukaGk() {
        return keiyakutuukaGk;
    }

    public void setKeiyakutuukaGk(BizCurrency pKeiyakutuukaGk) {
        keiyakutuukaGk = pKeiyakutuukaGk;
    }

    public BizDate getNykdenYmd() {
        return nykdenYmd;
    }

    public void setNykdenYmd(BizDate pNykdenYmd) {
        nykdenYmd = pNykdenYmd;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public BizDateYM getJyutouStartYm() {
        return jyutouStartYm;
    }

    public void setJyutouStartYm(BizDateYM pJyutouStartYm) {
        jyutouStartYm = pJyutouStartYm;
    }

    public Integer getJyutouKaisuuY() {
        return jyutouKaisuuY;
    }

    public void setJyutouKaisuuY(Integer pJyutouKaisuuY) {
        jyutouKaisuuY = pJyutouKaisuuY;
    }

    public Integer getJyutouKaisuuM() {
        return jyutouKaisuuM;
    }

    public void setJyutouKaisuuM(Integer pJyutouKaisuuM) {
        jyutouKaisuuM = pJyutouKaisuuM;
    }

    public String getDenkarikanjyono() {
        return denkarikanjyono;
    }

    public void setDenkarikanjyono(String pDenkarikanjyono) {
        denkarikanjyono = pDenkarikanjyono;
    }

}
