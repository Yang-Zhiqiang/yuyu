package yuyu.common.hozen.khcommon.dba4credituriageseikyuudatasks;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_UriageSeikyuuData;

import com.google.common.base.Predicate;

/**
 * 売上請求データテーブル用Predicateクラス
 */
public class FilterUriageSeikyuuData2 implements Predicate<IT_UriageSeikyuuData> {

    String syono;

    String creditkessaiyouno;

    BizDate uriagenengappi;

    C_CreditUriageSeikyuuKbn creditUriageSeikyuuKbn;

    public  FilterUriageSeikyuuData2 (String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi ,
        C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn) {

        super();

        this.syono = pSyono;

        this.creditkessaiyouno = pCreditkessaiyouno;

        this.uriagenengappi = pUriagenengappi;

        this.creditUriageSeikyuuKbn = pCreditUriageSeikyuuKbn;
    }

    @Override
    public boolean apply(IT_UriageSeikyuuData pUriageSeikyuuDatai) {

        if(creditkessaiyouno.equals(pUriageSeikyuuDatai.getCreditkessaiyouno()) &&
            uriagenengappi.compareTo(pUriageSeikyuuDatai.getUriagenengappi()) == 0 &&
            creditUriageSeikyuuKbn.eq(pUriageSeikyuuDatai.getCredituriageseikyuukbn()) &&
            syono.equals(pUriageSeikyuuDatai.getSyono())){

            return true;
        }

        return false;
    }
}
