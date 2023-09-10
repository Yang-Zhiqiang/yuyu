package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 不備未解消情報Beanクラスです。<br />
 */
public class HubimikaishoInfosBean implements Serializable {

    public HubimikaishoInfosBean(String pMosnoSkHubi,
        String pHubisikibetukey,
        String pUtdskknnm1kj,
        String pMosnoSyoriCTL,
        C_KetteiKbn pKetteikbn,
        BizDate pMosnrkymd,
        C_KykKbn pKykkbn,
        String pHhknnmkj,
        String pKyknmkj,
        C_HknsyuruiNo pHknsyuruino,
        String pMosfstpkeiType,
        BigDecimal pMosfstpkeiValue,
        C_Tuukasyu pHrktuukasyu,
        String pOyadrtencd,
        String pTratkiagcd) {

        mosnoSkHubi = pMosnoSkHubi;
        hubisikibetukey = pHubisikibetukey;
        utdskknnm1kj = pUtdskknnm1kj;
        mosnoSyoriCTL = pMosnoSyoriCTL;
        ketteikbn = pKetteikbn;
        mosnrkymd = pMosnrkymd;
        kykkbn = pKykkbn;
        hhknnmkj = pHhknnmkj;
        kyknmkj = pKyknmkj;
        hknsyuruino = pHknsyuruino;
        mosfstpkei = new BizCurrencySum(pMosfstpkeiType, pMosfstpkeiValue).toBizCurrency();
        hrktuukasyu = pHrktuukasyu;
        oyadrtencd = pOyadrtencd;
        tratkiagcd = pTratkiagcd;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String mosnoSkHubi;

    @Getter @Setter
    private String hubisikibetukey;

    @Getter @Setter
    private String utdskknnm1kj;

    @Getter @Setter
    private String mosnoSyoriCTL;

    @Getter @Setter
    private C_KetteiKbn ketteikbn;

    @Getter @Setter
    private BizDate mosnrkymd;

    @Getter @Setter
    private C_KykKbn kykkbn;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private C_HknsyuruiNo hknsyuruino;

    @Getter @Setter
    private BizCurrency mosfstpkei;

    @Getter @Setter
    private C_Tuukasyu hrktuukasyu;

    @Getter @Setter
    private String oyadrtencd;

    @Getter @Setter
    private String tratkiagcd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
