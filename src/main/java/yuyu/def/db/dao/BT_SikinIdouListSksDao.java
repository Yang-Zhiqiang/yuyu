package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.bean.SokujiSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.TyakkinSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.def.db.meta.QBT_SikinIdouListSks;

/**
 * 資金移動リスト作成用テーブル(BT_SikinIdouListSksDao) アクセス用の DAO クラスです。<br />
 */
public class BT_SikinIdouListSksDao extends AbstractDao<BT_SikinIdouListSks> {

    public BT_SikinIdouListSksDao() {
        super(BT_SikinIdouListSks.class);
    }

    public BT_SikinIdouListSks getSikinIdouListSks(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        BT_SikinIdouListSks bT_SikinIdouListSks =  new BT_SikinIdouListSks();
        bT_SikinIdouListSks.setDensyskbn(pDensyskbn);
        bT_SikinIdouListSks.setDenrenno(pDenrenno);
        bT_SikinIdouListSks.setEdano(pEdano);
        return this.selectOne(bT_SikinIdouListSks);
    }

    public ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> getSokujiSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {


        QBT_SikinIdouListSks qBT_SikinIdouListSks = new QBT_SikinIdouListSks();


        String querySql = $SELECT + $NEW(SokujiSikinIdouListSkssBySyoriYmdBean.class,
            qBT_SikinIdouListSks.seg1cd,
            qBT_SikinIdouListSks.kyktuukasyu,
            qBT_SikinIdouListSks.keiyakutuukagk.getTypeFieldName(),
            $SUM + $(qBT_SikinIdouListSks.keiyakutuukagk.getValueFieldName()),
            qBT_SikinIdouListSks.sikinidoukbn,
            qBT_SikinIdouListSks.sikinidougroupkbn,
            qBT_SikinIdouListSks.sikinidoumeisaikbn) +
            $FROM + qBT_SikinIdouListSks.BT_SikinIdouListSks() +
            $WHERE + qBT_SikinIdouListSks.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_SikinIdouListSks.kyktuukasyu.ne(qBT_SikinIdouListSks.shrtuukasyu) +
            $GROUP_BY +qBT_SikinIdouListSks.seg1cd + "," +
            qBT_SikinIdouListSks.kyktuukasyu + "," +
            qBT_SikinIdouListSks.keiyakutuukagk.getTypeFieldName() + "," +
            qBT_SikinIdouListSks.sikinidoukbn + "," +
            qBT_SikinIdouListSks.sikinidougroupkbn + "," +
            qBT_SikinIdouListSks.sikinidoumeisaikbn +
            $ORDER_BY(qBT_SikinIdouListSks.sikinidoukbn.asc(),
                qBT_SikinIdouListSks.sikinidougroupkbn.asc(),
                qBT_SikinIdouListSks.kyktuukasyu.asc(),
                qBT_SikinIdouListSks.keiyakutuukagk.typeAsc(),
                qBT_SikinIdouListSks.seg1cd.asc(),
                qBT_SikinIdouListSks.sikinidoumeisaikbn.asc());

        return em.createJPQL(querySql, SokujiSikinIdouListSkssBySyoriYmdBean.class).bind(qBT_SikinIdouListSks).getResults();
    }

    public ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> getTyakkinSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {


        QBT_SikinIdouListSks qBT_SikinIdouListSks = new QBT_SikinIdouListSks();


        String querySql = $SELECT + $NEW(TyakkinSikinIdouListSkssBySyoriYmdBean.class,
            qBT_SikinIdouListSks.tyakkinymd,
            qBT_SikinIdouListSks.seg1cd,
            qBT_SikinIdouListSks.kyktuukasyu,
            qBT_SikinIdouListSks.keiyakutuukagk.getTypeFieldName(),
            $SUM + $(qBT_SikinIdouListSks.keiyakutuukagk.getValueFieldName()),
            qBT_SikinIdouListSks.sikinidoukbn,
            qBT_SikinIdouListSks.sikinidougroupkbn,
            qBT_SikinIdouListSks.sikinidoumeisaikbn) +
            $FROM + qBT_SikinIdouListSks.BT_SikinIdouListSks() +
            $WHERE + qBT_SikinIdouListSks.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_SikinIdouListSks.kyktuukasyu.eq(qBT_SikinIdouListSks.shrtuukasyu) +
            $GROUP_BY + qBT_SikinIdouListSks.tyakkinymd + "," +
            qBT_SikinIdouListSks.seg1cd + "," +
            qBT_SikinIdouListSks.kyktuukasyu + "," +
            qBT_SikinIdouListSks.keiyakutuukagk.getTypeFieldName() + "," +
            qBT_SikinIdouListSks.sikinidoukbn + "," +
            qBT_SikinIdouListSks.sikinidougroupkbn + "," +
            qBT_SikinIdouListSks.sikinidoumeisaikbn +
            $ORDER_BY(qBT_SikinIdouListSks.sikinidoukbn.asc(),
                qBT_SikinIdouListSks.tyakkinymd.asc(),
                qBT_SikinIdouListSks.sikinidougroupkbn.asc(),
                qBT_SikinIdouListSks.kyktuukasyu.asc(),
                qBT_SikinIdouListSks.keiyakutuukagk.typeAsc(),
                qBT_SikinIdouListSks.seg1cd.asc(),
                qBT_SikinIdouListSks.sikinidoumeisaikbn.asc());

        return em.createJPQL(querySql, TyakkinSikinIdouListSkssBySyoriYmdBean.class).bind(qBT_SikinIdouListSks).getResults();
    }
}
