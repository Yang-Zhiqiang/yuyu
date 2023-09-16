package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiRn;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（連）(ZT_SmbcGetujiKykMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcGetujiKykMeisaiRnDao extends AbstractDao<ZT_SmbcGetujiKykMeisaiRn> {

    public ZT_SmbcGetujiKykMeisaiRnDao() {
        super(ZT_SmbcGetujiKykMeisaiRn.class);
    }

    public ZT_SmbcGetujiKykMeisaiRn getSmbcGetujiKykMeisaiRn(String pZrndatakijyunymd, String pZrndatakijyunym, String pZrnsyono) {
        ZT_SmbcGetujiKykMeisaiRn zT_SmbcGetujiKykMeisaiRn =  new ZT_SmbcGetujiKykMeisaiRn();
        zT_SmbcGetujiKykMeisaiRn.setZrndatakijyunymd(pZrndatakijyunymd);
        zT_SmbcGetujiKykMeisaiRn.setZrndatakijyunym(pZrndatakijyunym);
        zT_SmbcGetujiKykMeisaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SmbcGetujiKykMeisaiRn);
    }

    public ExDBResults<ZT_SmbcGetujiKykMeisaiRn> selectAllZT_SmbcGetujiKykMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcGetujiKykMeisaiRn qZT_SmbcGetujiKykMeisaiRn =  new QZT_SmbcGetujiKykMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcGetujiKykMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_SmbcGetujiKykMeisaiRn.ZT_SmbcGetujiKykMeisaiRn());
        jpql.append($ORDER_BY(qZT_SmbcGetujiKykMeisaiRn.zrndatakijyunymd.asc(), qZT_SmbcGetujiKykMeisaiRn.zrndatakijyunym.asc(), qZT_SmbcGetujiKykMeisaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcGetujiKykMeisaiRn).getResults();
    }
}
