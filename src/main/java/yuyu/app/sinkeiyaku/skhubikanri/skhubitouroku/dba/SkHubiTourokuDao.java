package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;

/**
 * 新契約 不備管理 新契約不備登録DAOクラス
 */
public class SkHubiTourokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<HM_SkSeibiSijiNaiyou> getSkSeibiSijiNaiyou() {

        QHM_SkSeibiSijiNaiyou qHM_SkSeibiSijiNaiyou = new QHM_SkSeibiSijiNaiyou("qHM_SkSeibiSijiNaiyou");

        String strSql = $SELECT + qHM_SkSeibiSijiNaiyou +
            $FROM(qHM_SkSeibiSijiNaiyou) +
            $WHERE + qHM_SkSeibiSijiNaiyou.hyoujikahikbn.eq(C_KahiKbn.KA) +
            $ORDER_BY(qHM_SkSeibiSijiNaiyou.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHM_SkSeibiSijiNaiyou).getResultList();
    }
}
