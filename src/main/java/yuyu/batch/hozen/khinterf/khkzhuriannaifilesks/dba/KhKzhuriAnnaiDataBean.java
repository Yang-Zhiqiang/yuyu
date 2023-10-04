package yuyu.batch.hozen.khinterf.khkzhuriannaifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 インターフェイス 口座振替案内データBean
 */
public class KhKzhuriAnnaiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_AnsyuusysKbn ansyuusysKbn;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyouKbn;

    @Getter @Setter
    private BizDateYM jyuutouYm;

    @Getter @Setter
    private Integer jyutouKaisuuy;

    @Getter @Setter
    private Integer jyutouKaisuum;

    @Getter @Setter
    private BizCurrency rsGaku;

    @Getter @Setter
    private BizDate hurikaeYmd;

    @Getter @Setter
    private C_Syuudaikocd syuudaikoCd;

    @Getter @Setter
    private String bankCd;

    @Getter @Setter
    private String sitenCd;

    @Getter @Setter
    private C_YokinKbn yokinKbn;

    @Getter @Setter
    private String kouzaNo;

    @Getter @Setter
    private String kzMeiginmKn;

    @Getter @Setter
    private C_SinkeizkKbn sinkeizkKbn;

    @Getter @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter @Setter
    private String dantaikobetuKbn;

    @Getter @Setter
    private BizDate kykYmd;

    public KhKzhuriAnnaiDataBean(String pKbnkey,
        C_AnsyuusysKbn pAnsyuusysKbn,
        BizDate pSyoriYmd,
        String pSyono,
        C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pJyuutouYm,
        Integer pJyutouKaisuuy,
        Integer pJyutouKaisuum,
        String pType,
        BigDecimal pValue,
        BizDate pHurikaeYmd,
        C_Syuudaikocd pSyuudaikoCd,
        String pBankCd,
        String pSitenCd,
        C_YokinKbn pYokinKbn,
        String pKouzaNo,
        String pKzMeiginmKn,
        C_SinkeizkKbn pSinkeizkKbn,
        C_Hrkkaisuu pHrkKaisuu,
        String pDantaikobetuKbn,
        BizDate pKykYmd) {

        kbnkey = pKbnkey;
        ansyuusysKbn = pAnsyuusysKbn;
        syoriYmd = pSyoriYmd;
        syono = pSyono;
        nyknaiyouKbn = pNyknaiyouKbn;
        jyuutouYm = pJyuutouYm;
        jyutouKaisuuy = pJyutouKaisuuy;
        jyutouKaisuum = pJyutouKaisuum;
        rsGaku = new BizCurrencySum(pType, pValue).toBizCurrency();
        hurikaeYmd = pHurikaeYmd;
        syuudaikoCd = pSyuudaikoCd;
        bankCd = pBankCd;
        sitenCd = pSitenCd;
        yokinKbn = pYokinKbn;
        kouzaNo = pKouzaNo;
        kzMeiginmKn = pKzMeiginmKn;
        sinkeizkKbn = pSinkeizkKbn;
        hrkKaisuu = pHrkKaisuu;
        dantaikobetuKbn = pDantaikobetuKbn;
        kykYmd = pKykYmd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
