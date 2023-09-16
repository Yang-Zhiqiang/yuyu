package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.QMT_DsMailAddressSpiralYyk;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル(MT_DsMailAddressSpiralYykDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsMailAddressSpiralYykDao extends AbstractDao<MT_DsMailAddressSpiralYyk> {

    public MT_DsMailAddressSpiralYykDao() {
        super(MT_DsMailAddressSpiralYyk.class);
    }

    @Deprecated
    public MT_DsMailAddressSpiralYyk getDsMailAddressSpiralYyk(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailaddressrenban) {
        MT_DsMailAddressSpiralYyk mT_DsMailAddressSpiralYyk =  new MT_DsMailAddressSpiralYyk();
        mT_DsMailAddressSpiralYyk.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsMailAddressSpiralYyk.setDskokno(pDskokno);
        mT_DsMailAddressSpiralYyk.setDsmailaddressrenban(pDsmailaddressrenban);
        return this.selectOne(mT_DsMailAddressSpiralYyk);
    }

    @Override
    @Deprecated
    public List<MT_DsMailAddressSpiralYyk> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<MT_DsMailAddressSpiralYyk> getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {


        QMT_DsMailAddressSpiralYyk qMT_DsMailAddressSpiralYyk = new QMT_DsMailAddressSpiralYyk();


        String strSql = $SELECT + qMT_DsMailAddressSpiralYyk +
            $FROM + qMT_DsMailAddressSpiralYyk.MT_DsMailAddressSpiralYyk() +
            $WHERE + qMT_DsMailAddressSpiralYyk.dsdatasakuseiymd.eq(pDsdatasakuseiymd) +
            $AND + qMT_DsMailAddressSpiralYyk.dsrendoutaisyoukbn.eq(C_DsRendouTaisyouKbn.RENDOUTAISYOU) +
            $ORDER_BY(qMT_DsMailAddressSpiralYyk.dskokno.asc(),
                qMT_DsMailAddressSpiralYyk.dsmailaddressrenban.asc());

        return em.createJPQL(strSql).bind(qMT_DsMailAddressSpiralYyk).getResults();
    }
}
