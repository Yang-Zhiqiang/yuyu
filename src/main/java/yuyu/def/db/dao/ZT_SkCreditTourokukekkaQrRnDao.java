package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrRn;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（連）(ZT_SkCreditTourokukekkaQrRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkCreditTourokukekkaQrRnDao extends AbstractDao<ZT_SkCreditTourokukekkaQrRn> {

    public ZT_SkCreditTourokukekkaQrRnDao() {
        super(ZT_SkCreditTourokukekkaQrRn.class);
    }

    public ZT_SkCreditTourokukekkaQrRn getSkCreditTourokukekkaQrRn(String pZrnsystemjyusinymd, String pZrnsystemjyusintime, String pZrncreditkessaiyouno) {
        ZT_SkCreditTourokukekkaQrRn zT_SkCreditTourokukekkaQrRn =  new ZT_SkCreditTourokukekkaQrRn();
        zT_SkCreditTourokukekkaQrRn.setZrnsystemjyusinymd(pZrnsystemjyusinymd);
        zT_SkCreditTourokukekkaQrRn.setZrnsystemjyusintime(pZrnsystemjyusintime);
        zT_SkCreditTourokukekkaQrRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        return this.selectOne(zT_SkCreditTourokukekkaQrRn);
    }

    public ExDBResults<ZT_SkCreditTourokukekkaQrRn> selectAllZT_SkCreditTourokukekkaQrRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkCreditTourokukekkaQrRn qZT_SkCreditTourokukekkaQrRn =  new QZT_SkCreditTourokukekkaQrRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkCreditTourokukekkaQrRn);
        jpql.append($FROM);
        jpql.append(qZT_SkCreditTourokukekkaQrRn.ZT_SkCreditTourokukekkaQrRn());
        jpql.append($ORDER_BY(qZT_SkCreditTourokukekkaQrRn.zrnsystemjyusinymd.asc(), qZT_SkCreditTourokukekkaQrRn.zrnsystemjyusintime.asc(), qZT_SkCreditTourokukekkaQrRn.zrncreditkessaiyouno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkCreditTourokukekkaQrRn).getResults();
    }
}
