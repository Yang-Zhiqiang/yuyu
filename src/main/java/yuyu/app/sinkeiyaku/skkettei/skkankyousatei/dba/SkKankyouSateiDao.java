package yuyu.app.sinkeiyaku.skkettei.skkankyousatei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QHT_SkLincSyoukaikekka;

/**
 * 新契約 決定 環境査定機能DAOクラス
 */
public class SkKankyouSateiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public String getHT_SkLincSyoukaikekkaMaxLincJyusinTrRenno(String pMosno) {

        QHT_SkLincSyoukaikekka qHT_SkLincSyoukaikekka = new QHT_SkLincSyoukaikekka("qHT_SkLincSyoukaikekka");

        String strSql = $SELECT + $MAX(qHT_SkLincSyoukaikekka.lincjyusintrrenno) +
            $FROM(qHT_SkLincSyoukaikekka) +
            $WHERE + qHT_SkLincSyoukaikekka.mosno.eq(pMosno) +
            $GROUP_BY + $(qHT_SkLincSyoukaikekka.mosno);

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SkLincSyoukaikekka).getSingleResult();
    }
}