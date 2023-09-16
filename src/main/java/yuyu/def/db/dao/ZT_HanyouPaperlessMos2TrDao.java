package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos2Tr;

/**
 * 汎用ペーパーレス申込情報２テーブル（取）(ZT_HanyouPaperlessMos2TrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HanyouPaperlessMos2TrDao extends AbstractDao<ZT_HanyouPaperlessMos2Tr> {

    public ZT_HanyouPaperlessMos2TrDao() {
        super(ZT_HanyouPaperlessMos2Tr.class);
    }

    public ZT_HanyouPaperlessMos2Tr getHanyouPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        ZT_HanyouPaperlessMos2Tr zT_HanyouPaperlessMos2Tr =  new ZT_HanyouPaperlessMos2Tr();
        zT_HanyouPaperlessMos2Tr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_HanyouPaperlessMos2Tr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_HanyouPaperlessMos2Tr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_HanyouPaperlessMos2Tr.setZtrseihowebseknoc(pZtrseihowebseknoc);
        return this.selectOne(zT_HanyouPaperlessMos2Tr);
    }

    public ExDBResults<ZT_HanyouPaperlessMos2Tr> selectAllZT_HanyouPaperlessMos2Tr() {
        StringBuilder jpql = new StringBuilder();
        QZT_HanyouPaperlessMos2Tr qZT_HanyouPaperlessMos2Tr =  new QZT_HanyouPaperlessMos2Tr();
        jpql.append($SELECT);
        jpql.append(qZT_HanyouPaperlessMos2Tr);
        jpql.append($FROM);
        jpql.append(qZT_HanyouPaperlessMos2Tr.ZT_HanyouPaperlessMos2Tr());
        jpql.append($ORDER_BY(qZT_HanyouPaperlessMos2Tr.ztrseihowebidkbn.asc(), qZT_HanyouPaperlessMos2Tr.ztrseihowebkojincd.asc(), qZT_HanyouPaperlessMos2Tr.ztrseihowebitijihozonhyouji.asc(), qZT_HanyouPaperlessMos2Tr.ztrseihowebseknoc.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HanyouPaperlessMos2Tr).getResults();
    }
}
