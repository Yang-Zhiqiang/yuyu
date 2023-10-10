package yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;

/**
 * ＤＳ送金用口座情報取得DAOクラスです。
 */
public class DwGetSoukinyouKouzaInfoDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<MT_DsSoukinyouKouza> getDsSoukinyouKouzasByDskoknoSyono(String pDskokno, String pSyono) {

        QMT_DsSoukinyouKouza qMT_DsSoukinyouKouza = new QMT_DsSoukinyouKouza("qMT_DsSoukinyouKouza");

        String strSql = $SELECT + qMT_DsSoukinyouKouza +
            $FROM(qMT_DsSoukinyouKouza) +
            $WHERE + qMT_DsSoukinyouKouza.dskokno.eq(pDskokno) +
            $AND + qMT_DsSoukinyouKouza.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsSoukinyouKouza).getResultList();
    }

    public List<MT_DsSoukinyouKouza> detachDsSoukinyouKouza(List<MT_DsSoukinyouKouza> pDsSoukinyouKouzas) {

        for (MT_DsSoukinyouKouza entity : pDsSoukinyouKouzas) {
            entity.detach();
        }

        return pDsSoukinyouKouzas;
    }
}
