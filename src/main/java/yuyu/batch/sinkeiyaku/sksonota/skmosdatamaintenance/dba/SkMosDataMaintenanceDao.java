package yuyu.batch.sinkeiyaku.sksonota.skmosdatamaintenance.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.meta.QBT_GyoumuKouteiInfo;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 申込データメンテナンス用の機能DAOクラスです。<br />
 */
public class SkMosDataMaintenanceDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    private final String COMMA = ",";

    private final String SINGLEQUOTATION = "'";

    public List<String> getGyoumuKouteiInfoKouteikanriidByMosnoJimutetuzukicd(String[] pMosno, String pJimutetuzukiCd) {

        QBT_GyoumuKouteiInfo QBT_GyoumuKouteiInfo = new QBT_GyoumuKouteiInfo();

        String querySql = $SELECT + QBT_GyoumuKouteiInfo.kouteikanriid +
            $FROM +
            QBT_GyoumuKouteiInfo.BT_GyoumuKouteiInfo() +
            $WHERE +
            QBT_GyoumuKouteiInfo.mosno.in(pMosno) +
            $AND +
            QBT_GyoumuKouteiInfo.jimutetuzukicd.eq(pJimutetuzukiCd);

        return exDBEntityManager.createJPQL(querySql).bind(QBT_GyoumuKouteiInfo).getResultList();
    }

    public int delSkTableByDeleteKey(String pTableId, String pDeleteKeyNm, String[] pDeleteKey) {

        String querySql = $DELETE_FROM + pTableId +
            $WHERE +
            pDeleteKeyNm + " IN " +
            makeInQuery(pDeleteKey);

        return exDBEntityManager.createJPQL(querySql).executeUpdate();

    }

    private String makeInQuery(String[] pValues) {

        StringBuilder sb = new StringBuilder();

        sb.append("(");

        if (pValues.length > 0) {
            for (String value : pValues) {
                if (sb.length() > 1) {
                    sb.append(COMMA);
                }
                sb.append(SINGLEQUOTATION);
                sb.append(value);
                sb.append(SINGLEQUOTATION);
            }
        } else {
            sb.append(SINGLEQUOTATION);
            sb.append(SINGLEQUOTATION);
        }

        sb.append(")");

        return sb.toString();
    }

}
