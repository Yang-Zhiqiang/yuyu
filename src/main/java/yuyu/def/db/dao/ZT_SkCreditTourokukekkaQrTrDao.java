package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（取）(ZT_SkCreditTourokukekkaQrTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkCreditTourokukekkaQrTrDao extends AbstractDao<ZT_SkCreditTourokukekkaQrTr> {

    public ZT_SkCreditTourokukekkaQrTrDao() {
        super(ZT_SkCreditTourokukekkaQrTr.class);
    }

    public ZT_SkCreditTourokukekkaQrTr getSkCreditTourokukekkaQrTr(String pZtrsystemjyusinymd, String pZtrsystemjyusintime, String pZtrcreditkessaiyouno) {
        ZT_SkCreditTourokukekkaQrTr zT_SkCreditTourokukekkaQrTr =  new ZT_SkCreditTourokukekkaQrTr();
        zT_SkCreditTourokukekkaQrTr.setZtrsystemjyusinymd(pZtrsystemjyusinymd);
        zT_SkCreditTourokukekkaQrTr.setZtrsystemjyusintime(pZtrsystemjyusintime);
        zT_SkCreditTourokukekkaQrTr.setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
        return this.selectOne(zT_SkCreditTourokukekkaQrTr);
    }

    public ExDBResults<ZT_SkCreditTourokukekkaQrTr> selectAllZT_SkCreditTourokukekkaQrTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkCreditTourokukekkaQrTr qZT_SkCreditTourokukekkaQrTr =  new QZT_SkCreditTourokukekkaQrTr();
        jpql.append($SELECT);
        jpql.append(qZT_SkCreditTourokukekkaQrTr);
        jpql.append($FROM);
        jpql.append(qZT_SkCreditTourokukekkaQrTr.ZT_SkCreditTourokukekkaQrTr());
        jpql.append($ORDER_BY(qZT_SkCreditTourokukekkaQrTr.ztrsystemjyusinymd.asc(), qZT_SkCreditTourokukekkaQrTr.ztrsystemjyusintime.asc(), qZT_SkCreditTourokukekkaQrTr.ztrcreditkessaiyouno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkCreditTourokukekkaQrTr).getResults();
    }
}
