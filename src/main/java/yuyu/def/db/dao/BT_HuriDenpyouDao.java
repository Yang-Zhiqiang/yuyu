package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.meta.QBT_HuriDenpyou;

/**
 * 振替伝票作成用テーブル(BT_HuriDenpyouDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HuriDenpyouDao extends AbstractDao<BT_HuriDenpyou> {

    public BT_HuriDenpyouDao() {
        super(BT_HuriDenpyou.class);
    }

    public BT_HuriDenpyou getHuriDenpyou(C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano){
        BT_HuriDenpyou bT_HuriDenpyou =  new BT_HuriDenpyou();
        bT_HuriDenpyou.setDensyskbn(pDensyskbn);
        bT_HuriDenpyou.setDenrenno(pDenrenno);
        bT_HuriDenpyou.setEdano(pEdano);
        return this.selectOne(bT_HuriDenpyou);
    }

    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {



        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();

        String queryStr = $SELECT + qBT_HuriDenpyou +
            $FROM + qBT_HuriDenpyou.BT_HuriDenpyou() +
            $WHERE + qBT_HuriDenpyou.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_HuriDenpyou.torihikino.isNotNull() +
            $AND + qBT_HuriDenpyou.torihikino.ne("") +
            $ORDER_BY(qBT_HuriDenpyou.torihikino.asc(),
                qBT_HuriDenpyou.huridenatesakicd.asc(),
                qBT_HuriDenpyou.tantocd.asc(),
                qBT_HuriDenpyou.denymd.asc(),
                qBT_HuriDenpyou.huridenskskbn.asc(),
                qBT_HuriDenpyou.taisyakukbn.asc(),
                qBT_HuriDenpyou.denkanjokamokucd.asc(),
                qBT_HuriDenpyou.jigyouhiutiwakecd.asc());

        return em.createJPQL(queryStr).bind(qBT_HuriDenpyou).getResults();
    }

    public ExDBUpdatableResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(BizDate pSyoriYmd) {


        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();



        String strSql = $SELECT + qBT_HuriDenpyou +
            $FROM + qBT_HuriDenpyou.BT_HuriDenpyou() +
            $WHERE + qBT_HuriDenpyou.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qBT_HuriDenpyou.huridenskskbn.asc(),
                qBT_HuriDenpyou.huridenatesakicd.asc(),
                qBT_HuriDenpyou.tantocd.asc(),
                qBT_HuriDenpyou.denymd.asc(),
                qBT_HuriDenpyou.huridenpyoukyktuukakbn.asc(),
                qBT_HuriDenpyou.tuukasyu.asc(),
                qBT_HuriDenpyou.dengyoumucd.asc(),
                qBT_HuriDenpyou.denshrhoukbn.asc(),
                qBT_HuriDenpyou.densyorisyousaikbn.asc(),
                qBT_HuriDenpyou.syoricd.asc(),
                qBT_HuriDenpyou.keirisyono.asc(),
                qBT_HuriDenpyou.sougoukobetukbn.asc(),
                qBT_HuriDenpyou.furikaedenpyouitirenno.asc());


        return em.createJPQL(strSql).bind(qBT_HuriDenpyou).getUpdatableResults();
    }

    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(BizDate pSyoriYmd) {


        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();


        String strSql = $SELECT + qBT_HuriDenpyou +
            $FROM + qBT_HuriDenpyou.BT_HuriDenpyou() +
            $WHERE + qBT_HuriDenpyou.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_HuriDenpyou.torihikino.isNotNull() +
            $AND + qBT_HuriDenpyou.torihikino.ne("") +
            $ORDER_BY (qBT_HuriDenpyou.torihikino.asc(),
                qBT_HuriDenpyou.huridenatesakicd.asc(),
                qBT_HuriDenpyou.tantocd.asc(),
                qBT_HuriDenpyou.denymd.asc(),
                qBT_HuriDenpyou.huridenskskbn.asc(),
                qBT_HuriDenpyou.denkanjokamokucd.asc(),
                qBT_HuriDenpyou.taisyakukbn.asc(),
                qBT_HuriDenpyou.jigyouhiutiwakecd.asc());

        return em.createJPQL(strSql).bind(qBT_HuriDenpyou).getResults();
    }

    public ExDBResults<BT_HuriDenpyou> getHuriDenpyousBySyoriYmd(BizDate pSyoriYmd) {


        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();


        String strSql = $SELECT + qBT_HuriDenpyou +
            $FROM + qBT_HuriDenpyou.BT_HuriDenpyou() +
            $WHERE + qBT_HuriDenpyou.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_HuriDenpyou.torihikino.isNotNull() +
            $AND + qBT_HuriDenpyou.torihikino.ne("") +
            $ORDER_BY (qBT_HuriDenpyou.torihikino.asc(),
                qBT_HuriDenpyou.huridenatesakicd.asc(),
                qBT_HuriDenpyou.tantocd.asc(),
                qBT_HuriDenpyou.denymd.asc(),
                qBT_HuriDenpyou.huridenskskbn.asc(),
                qBT_HuriDenpyou.taisyakukbn.asc(),
                qBT_HuriDenpyou.denkanjokamokucd.asc(),
                qBT_HuriDenpyou.jigyouhiutiwakecd.asc());

        return em.createJPQL(strSql).bind(qBT_HuriDenpyou).getResults();
    }
}
