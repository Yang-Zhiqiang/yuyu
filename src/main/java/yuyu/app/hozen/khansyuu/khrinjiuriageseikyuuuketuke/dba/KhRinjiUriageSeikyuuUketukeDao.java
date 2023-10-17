package yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;

/**
 * 契約保全 案内収納 臨時売上請求受付機能Daoクラス
 */
public class KhRinjiUriageSeikyuuUketukeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public IT_UriageSeikyuuData getUriageSeikyuuData(String pSyono, String pCreditkessaiyouno,
        BizDate pUriagenengappi) {

        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");

        String strSql = $SELECT + qIT_UriageSeikyuuData +
            $FROM(qIT_UriageSeikyuuData) +
            $WHERE + qIT_UriageSeikyuuData.syono.eq(pSyono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(pCreditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(pUriagenengappi) +
            $AND + qIT_UriageSeikyuuData.credituriageseikyuukbn.eq(C_CreditUriageSeikyuuKbn.RINJI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_UriageSeikyuuData).getSingleResult();
    }
}
