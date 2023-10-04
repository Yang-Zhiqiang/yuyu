package yuyu.batch.hozen.khansyuu.khkzhuriannaidel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIT_KhKouzahuriAnnaiData;


/**
 * 契約保全 案内収納 口座振替案内データ削除機能DAOクラスです。
 */
public class KhKzhuriAnnaiDelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getKhKouzahuriAnnaiDataCount() {
        QIT_KhKouzahuriAnnaiData qIT_KhKouzahuriAnnaiData = new QIT_KhKouzahuriAnnaiData("qIT_KhKouzahuriAnnaiData");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhKouzahuriAnnaiData);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhKouzahuriAnnaiData).getSingleResult();
    }

    public int deleteKhKouzahuriAnnaiData() {

        QIT_KhKouzahuriAnnaiData qIT_KhKouzahuriAnnaiData = new QIT_KhKouzahuriAnnaiData("q");

        String strSql = $DELETE_FROM(qIT_KhKouzahuriAnnaiData);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhKouzahuriAnnaiData).executeUpdate();

    }
}
