package yuyu.batch.biz.bzinterf.bzsikinidoulistcsvfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.entity.BM_SikinIdouListCsvFLayout;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.QBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.QBT_SikinIdouListCsvFSks;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 業務共通 経理・会計 資金移動リストＣＳＶファイル作成の機能DAOクラスです
 */
public class BzSikinIdouListCsvFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SikinIdouMeisaigkDataBean> getSikinIdouMeisaigkData(BizDate pSikinidouYmd) {

        QBT_SikinIdouListCsvFSks qBT_SikinIdouListCsvFSks = new QBT_SikinIdouListCsvFSks("qBT_SikinIdouListCsvFSks");

        String strSql = $SELECT + $NEW(SikinIdouMeisaigkDataBean.class,
            qBT_SikinIdouListCsvFSks.sikinidoulistkbn,
            qBT_SikinIdouListCsvFSks.syukkinkouzatuukasyu,
            qBT_SikinIdouListCsvFSks.syukkinkouzano,
            qBT_SikinIdouListCsvFSks.nyuukinkouzatuukasyu,
            qBT_SikinIdouListCsvFSks.nyuukinkouzano,
            qBT_SikinIdouListCsvFSks.sikinidoumeisaigk.getTypeFieldName(),
            $SUM + $(qBT_SikinIdouListCsvFSks.sikinidoumeisaigk.getValueFieldName())) +
            $FROM(qBT_SikinIdouListCsvFSks) +
            $WHERE + qBT_SikinIdouListCsvFSks.sikinidouymd.eq(pSikinidouYmd) +
            $GROUP_BY + qBT_SikinIdouListCsvFSks.sikinidoulistkbn + "," +
            qBT_SikinIdouListCsvFSks.syukkinkouzatuukasyu + "," +
            qBT_SikinIdouListCsvFSks.syukkinkouzano + "," +
            qBT_SikinIdouListCsvFSks.nyuukinkouzatuukasyu + "," +
            qBT_SikinIdouListCsvFSks.nyuukinkouzano + "," +
            qBT_SikinIdouListCsvFSks.sikinidoumeisaigk.getTypeFieldName();

        return exDBEntityManager.createJPQL(strSql, SikinIdouMeisaigkDataBean.class)
            .bind(qBT_SikinIdouListCsvFSks).getResults();
    }

    public List<BM_SikinIdouListCsvFLayout> getSikinIdouListCsvFLayout() {

        QBM_SikinIdouListCsvFLayout qBM_SikinIdouListCsvFLayout = new QBM_SikinIdouListCsvFLayout("qBM_SikinIdouListCsvFLayout");

        String strSql = $SELECT + qBM_SikinIdouListCsvFLayout +
            $FROM(qBM_SikinIdouListCsvFLayout) +
            $ORDER_BY(qBM_SikinIdouListCsvFLayout.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_SikinIdouListCsvFLayout).getResultList();
    }

    public List<BT_SikinIdouListCsvFSks> getSksMotoData(BizDate pSikinidouYmd) {

        QBT_SikinIdouListCsvFSks qBT_SikinIdouListCsvFSks = new QBT_SikinIdouListCsvFSks("qBT_SikinIdouListCsvFSks");

        String strSql = $SELECT + qBT_SikinIdouListCsvFSks +
            $FROM(qBT_SikinIdouListCsvFSks) +
            $WHERE + qBT_SikinIdouListCsvFSks.sikinidouymd.eq(pSikinidouYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qBT_SikinIdouListCsvFSks).getResultList();
    }
}
