package yuyu.common.hozen.khcommon.dba4keisanzennounyuukingk;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu;

/**
 * 前納入金額計算DAOクラスです
 */
public class KeisanZennouNyuukinGkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_ZennouKeikaRiritu getZennouKeikaRiritu(Integer pKeikatukisuu, BizDate pKijyunymd) {

        QBM_ZennouKeikaRiritu qBM_ZennouKeikaRiritu = new QBM_ZennouKeikaRiritu("t1");

        String query = $SELECT + qBM_ZennouKeikaRiritu +
            $FROM(qBM_ZennouKeikaRiritu) +
            $WHERE + qBM_ZennouKeikaRiritu.keikatukisuu.eq(pKeikatukisuu) +
            $AND + qBM_ZennouKeikaRiritu.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouKeikaRiritu.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouKeikaRiritu).getSingleResult();
    }

    public BM_ZennouGenkaRitu getZennouGenkaRitu(Integer pZennounensuu, BizDate pKijyunymd) {

        QBM_ZennouGenkaRitu qBM_ZennouGenkaRitu = new QBM_ZennouGenkaRitu("t1");

        String query = $SELECT + qBM_ZennouGenkaRitu +
            $FROM(qBM_ZennouGenkaRitu) +
            $WHERE + qBM_ZennouGenkaRitu.zennounensuu.eq(pZennounensuu) +
            $AND + qBM_ZennouGenkaRitu.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouGenkaRitu.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouGenkaRitu).getSingleResult();
    }
}
