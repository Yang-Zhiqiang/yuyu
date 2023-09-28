package yuyu.common.biz.bzdairiten.dba4bzgetdairitenitakusyouhn;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;

/**
 * 代理店委託商品情報取得の機能DAOクラス<br />
 */

public class BzGetDairitenItakuSyouhnDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BT_DairitenItakuSyouhn> getDairitenItakuSyouhnsByDrtencdItems(String pDrtenCd, String pSyouhinSikibetuKbn,
        String pHrkhouhouKbn, String pPlannmKbn) {

        QBT_DairitenItakuSyouhn qBT_DairitenItakuSyouhn = new QBT_DairitenItakuSyouhn("qBT_DairitenItakuSyouhn");

        String strSql = $SELECT + qBT_DairitenItakuSyouhn +
            $FROM (qBT_DairitenItakuSyouhn) +
            $WHERE + qBT_DairitenItakuSyouhn.drtencd.eq(pDrtenCd) +
            $AND + qBT_DairitenItakuSyouhn.drtsyouhinsikibetukbnstr.eq(pSyouhinSikibetuKbn) +
            $AND + qBT_DairitenItakuSyouhn.drthrkhouhoukbn.eq(pHrkhouhouKbn) +
            $AND + qBT_DairitenItakuSyouhn.drtplannmkbn.eq(pPlannmKbn) +
            $ORDER_BY(qBT_DairitenItakuSyouhn.itakuhknhnbkaisiymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qBT_DairitenItakuSyouhn).getResultList();
    }
}