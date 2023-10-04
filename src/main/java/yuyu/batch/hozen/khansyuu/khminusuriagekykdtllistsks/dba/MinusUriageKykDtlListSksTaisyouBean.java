package yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * マイナス売上契約明細リスト作成対象Beanクラスです。<br />
 */
public class MinusUriageKykDtlListSksTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private BizDate uriagenengappi;

    @Getter
    @Setter
    private Integer renno3keta;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private BizCurrency credituriagegk;

    @Getter
    @Setter
    private String kinouid;


    public MinusUriageKykDtlListSksTaisyouBean(String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta,
        BizDateYM pJyuutouym,
        BizDate pSyoriYmd,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        String pKinouid) {

        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouno;
        uriagenengappi = pUriagenengappi;
        renno3keta = pRenno3keta;
        jyuutouym = pJyuutouym;
        syoriYmd = pSyoriYmd;
        credituriagegk = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        kinouid = pKinouid;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
