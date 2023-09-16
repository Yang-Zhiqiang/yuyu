package yuyu.def.db.dao;

import java.util.List;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.QMT_DsKouzokuJimuKakunin;

/**
 * ＤＳ後続事務確認テーブル(MT_DsKouzokuJimuKakuninDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsKouzokuJimuKakuninDao extends AbstractDao<MT_DsKouzokuJimuKakunin> {

    public MT_DsKouzokuJimuKakuninDao() {
        super(MT_DsKouzokuJimuKakunin.class);
    }

    @Deprecated
    public MT_DsKouzokuJimuKakunin getDsKouzokuJimuKakunin(BizDate pHasseiymd, C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn, String pSyono) {
        MT_DsKouzokuJimuKakunin mT_DsKouzokuJimuKakunin =  new MT_DsKouzokuJimuKakunin();
        mT_DsKouzokuJimuKakunin.setHasseiymd(pHasseiymd);
        mT_DsKouzokuJimuKakunin.setDskzkjmkknhsjykbn(pDskzkjmkknhsjykbn);
        mT_DsKouzokuJimuKakunin.setSyono(pSyono);
        return this.selectOne(mT_DsKouzokuJimuKakunin);
    }

    @Override
    @Deprecated
    public List<MT_DsKouzokuJimuKakunin> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<MT_DsKouzokuJimuKakunin> getDsKouzokuJimuKakuninsByHasseiymd(BizDate pHasseiymd) {

        QMT_DsKouzokuJimuKakunin qMT_DsKouzokuJimuKakunin = new QMT_DsKouzokuJimuKakunin();


        String  strSql = $SELECT + qMT_DsKouzokuJimuKakunin +
            $FROM + qMT_DsKouzokuJimuKakunin.MT_DsKouzokuJimuKakunin() +
            $WHERE + qMT_DsKouzokuJimuKakunin.hasseiymd.eq(pHasseiymd)+
            $ORDER_BY(qMT_DsKouzokuJimuKakunin.dskzkjmkknhsjykbn.asc() ,
                qMT_DsKouzokuJimuKakunin.syono.asc());


        return em.createJPQL(strSql).bind(qMT_DsKouzokuJimuKakunin).getResults();
    }

}
