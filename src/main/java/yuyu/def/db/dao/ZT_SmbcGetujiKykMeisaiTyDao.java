package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiTy;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（中）(ZT_SmbcGetujiKykMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcGetujiKykMeisaiTyDao extends AbstractDao<ZT_SmbcGetujiKykMeisaiTy> {

    public ZT_SmbcGetujiKykMeisaiTyDao() {
        super(ZT_SmbcGetujiKykMeisaiTy.class);
    }

    public ZT_SmbcGetujiKykMeisaiTy getSmbcGetujiKykMeisaiTy(String pZtydatakijyunymd, String pZtydatakijyunym, String pZtysyono) {
        ZT_SmbcGetujiKykMeisaiTy zT_SmbcGetujiKykMeisaiTy =  new ZT_SmbcGetujiKykMeisaiTy();
        zT_SmbcGetujiKykMeisaiTy.setZtydatakijyunymd(pZtydatakijyunymd);
        zT_SmbcGetujiKykMeisaiTy.setZtydatakijyunym(pZtydatakijyunym);
        zT_SmbcGetujiKykMeisaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SmbcGetujiKykMeisaiTy);
    }

    public ExDBResults<ZT_SmbcGetujiKykMeisaiTy> selectAllZT_SmbcGetujiKykMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcGetujiKykMeisaiTy qZT_SmbcGetujiKykMeisaiTy =  new QZT_SmbcGetujiKykMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcGetujiKykMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_SmbcGetujiKykMeisaiTy.ZT_SmbcGetujiKykMeisaiTy());
        jpql.append($ORDER_BY(qZT_SmbcGetujiKykMeisaiTy.ztydatakijyunymd.asc(), qZT_SmbcGetujiKykMeisaiTy.ztydatakijyunym.asc(), qZT_SmbcGetujiKykMeisaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcGetujiKykMeisaiTy).getResults();
    }
}
