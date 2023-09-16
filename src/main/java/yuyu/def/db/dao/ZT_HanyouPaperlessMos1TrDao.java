package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;

/**
 * 汎用ペーパーレス申込情報１テーブル（取）(ZT_HanyouPaperlessMos1TrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HanyouPaperlessMos1TrDao extends AbstractDao<ZT_HanyouPaperlessMos1Tr> {

    public ZT_HanyouPaperlessMos1TrDao() {
        super(ZT_HanyouPaperlessMos1Tr.class);
    }

    public ZT_HanyouPaperlessMos1Tr getHanyouPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        ZT_HanyouPaperlessMos1Tr zT_HanyouPaperlessMos1Tr =  new ZT_HanyouPaperlessMos1Tr();
        zT_HanyouPaperlessMos1Tr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_HanyouPaperlessMos1Tr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_HanyouPaperlessMos1Tr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_HanyouPaperlessMos1Tr.setZtrseihowebseknoc(pZtrseihowebseknoc);
        return this.selectOne(zT_HanyouPaperlessMos1Tr);
    }

    public ExDBResults<ZT_HanyouPaperlessMos1Tr> selectAllZT_HanyouPaperlessMos1Tr() {
        StringBuilder jpql = new StringBuilder();
        QZT_HanyouPaperlessMos1Tr qZT_HanyouPaperlessMos1Tr =  new QZT_HanyouPaperlessMos1Tr();
        jpql.append($SELECT);
        jpql.append(qZT_HanyouPaperlessMos1Tr);
        jpql.append($FROM);
        jpql.append(qZT_HanyouPaperlessMos1Tr.ZT_HanyouPaperlessMos1Tr());
        jpql.append($ORDER_BY(qZT_HanyouPaperlessMos1Tr.ztrseihowebidkbn.asc(), qZT_HanyouPaperlessMos1Tr.ztrseihowebkojincd.asc(), qZT_HanyouPaperlessMos1Tr.ztrseihowebitijihozonhyouji.asc(), qZT_HanyouPaperlessMos1Tr.ztrseihowebseknoc.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HanyouPaperlessMos1Tr).getResults();
    }
}
