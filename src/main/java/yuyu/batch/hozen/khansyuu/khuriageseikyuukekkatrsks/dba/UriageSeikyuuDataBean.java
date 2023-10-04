package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba;

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
 * 契約保全 案内収納 売上請求データBeanクラス<br />
 */
public class UriageSeikyuuDataBean implements Serializable {

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
    private String recordno;

    @Getter
    @Setter
    private BizCurrency credituriagegk;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    public UriageSeikyuuDataBean(String pSyono, String pCreditkessaiyouNo,
        BizDate pUriageNengappi, Integer pRenno3keta, String pRecordNo, String pCredituriagegkType,
        BigDecimal pCredituriagegkValue, BizDateYM pJyuutouYm) {

        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouNo;
        uriagenengappi = pUriageNengappi;
        renno3keta = pRenno3keta;
        recordno = pRecordNo;
        credituriagegk = new BizCurrencySum(pCredituriagegkType, pCredituriagegkValue).toBizCurrency();
        jyuutouym = pJyuutouYm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
