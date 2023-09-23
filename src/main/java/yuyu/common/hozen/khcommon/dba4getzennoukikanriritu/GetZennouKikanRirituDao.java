package yuyu.common.hozen.khcommon.dba4getzennoukikanriritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu;

/**
 * 前納期間利率取得処理DAOクラス
 */
public class GetZennouKikanRirituDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_ZennouTumitateRitu> getZennouTumitateRitus(BizDate pKijyunymd) {

        QBM_ZennouTumitateRitu qBM_ZennouTumitateRitu = new QBM_ZennouTumitateRitu("qBM_ZennouTumitateRitu");

        String query = $SELECT + qBM_ZennouTumitateRitu +
            $FROM(qBM_ZennouTumitateRitu) +
            $WHERE + qBM_ZennouTumitateRitu.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouTumitateRitu.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouTumitateRitu).getResultList();
    }
}
