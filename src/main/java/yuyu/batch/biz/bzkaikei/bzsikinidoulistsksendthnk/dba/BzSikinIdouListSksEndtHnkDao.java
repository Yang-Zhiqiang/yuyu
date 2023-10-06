package yuyu.batch.biz.bzkaikei.bzsikinidoulistsksendthnk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouListSks;

/**
 * 業務共通 経理・会計 資金移動リスト作成（円建変更）機能DAOクラス
 */
public class BzSikinIdouListSksEndtHnkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<EndtHnkSikinIdouListSksBySyoriYmdBean> getEndtHnkSikinIdouListSksBySyoriYmd(BizDate pSyoriYmd) {

        QBT_YendthnkSikinIdouListSks qBT_YendthnkSikinIdouListSks =
            new QBT_YendthnkSikinIdouListSks("qBT_YendthnkSikinIdouListSks");

        String querySql = $SELECT + $NEW(EndtHnkSikinIdouListSksBySyoriYmdBean.class,
            qBT_YendthnkSikinIdouListSks.sikinidougroupkbn,
            qBT_YendthnkSikinIdouListSks.siteituuka,
            qBT_YendthnkSikinIdouListSks.siteituukagk.getTypeFieldName(),
            $SUM + $(qBT_YendthnkSikinIdouListSks.siteituukagk.getValueFieldName()),
            qBT_YendthnkSikinIdouListSks.trhktuuka,
            qBT_YendthnkSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            $SUM + $(qBT_YendthnkSikinIdouListSks.trhktuukagk.getValueFieldName()),
            qBT_YendthnkSikinIdouListSks.kbnkeirisegcd,
            qBT_YendthnkSikinIdouListSks.keiriyendthnkkbn) +
            $FROM(qBT_YendthnkSikinIdouListSks) +
            $WHERE + qBT_YendthnkSikinIdouListSks.syoriYmd.eq(pSyoriYmd) +
            $GROUP_BY +qBT_YendthnkSikinIdouListSks.sikinidougroupkbn + "," +
            qBT_YendthnkSikinIdouListSks.siteituuka + "," +
            qBT_YendthnkSikinIdouListSks.siteituukagk.getTypeFieldName() + "," +
            qBT_YendthnkSikinIdouListSks.trhktuuka + "," +
            qBT_YendthnkSikinIdouListSks.trhktuukagk.getTypeFieldName() + "," +
            qBT_YendthnkSikinIdouListSks.kbnkeirisegcd + "," +
            qBT_YendthnkSikinIdouListSks.keiriyendthnkkbn +
            $ORDER_BY(qBT_YendthnkSikinIdouListSks.sikinidougroupkbn.asc(),
                qBT_YendthnkSikinIdouListSks.siteituuka.asc(),
                qBT_YendthnkSikinIdouListSks.siteituukagk.typeAsc(),
                qBT_YendthnkSikinIdouListSks.trhktuuka.asc(),
                qBT_YendthnkSikinIdouListSks.trhktuukagk.typeAsc(),
                qBT_YendthnkSikinIdouListSks.kbnkeirisegcd.asc(),
                qBT_YendthnkSikinIdouListSks.keiriyendthnkkbn.asc());

        return exDBEntityManager.createJPQL(querySql, EndtHnkSikinIdouListSksBySyoriYmdBean.class).bind(
            qBT_YendthnkSikinIdouListSks).getResults();
    }
}
