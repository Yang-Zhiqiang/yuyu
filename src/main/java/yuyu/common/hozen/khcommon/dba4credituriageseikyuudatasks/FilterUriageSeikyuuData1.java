package yuyu.common.hozen.khcommon.dba4credituriageseikyuudatasks;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_UriageSeikyuuData;

import com.google.common.base.Predicate;

/**
 * 売上請求データテーブル用Predicateクラス
 */
public class FilterUriageSeikyuuData1 implements Predicate<IT_UriageSeikyuuData> {

    String syono;

    String creditkessaiyouno;

    BizDate uriagenengappi;

    public  FilterUriageSeikyuuData1 (String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi ) {

        super();

        this.syono = pSyono;

        this.creditkessaiyouno = pCreditkessaiyouno;

        this.uriagenengappi = pUriagenengappi;
    }

    @Override
    public boolean apply(IT_UriageSeikyuuData pUriageSeikyuuDatai) {

        if(creditkessaiyouno.equals(pUriageSeikyuuDatai.getCreditkessaiyouno()) &&
            (uriagenengappi.compareTo(pUriageSeikyuuDatai.getUriagenengappi()) == 0) &&
            syono.equals(pUriageSeikyuuDatai.getSyono())){

            return true;
        }

        return false;
    }
}
