package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouTy;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（中）(ZT_SmbcSkMeisaiRendouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcSkMeisaiRendouTyDao extends AbstractDao<ZT_SmbcSkMeisaiRendouTy> {

    public ZT_SmbcSkMeisaiRendouTyDao() {
        super(ZT_SmbcSkMeisaiRendouTy.class);
    }

    public ZT_SmbcSkMeisaiRendouTy getSmbcSkMeisaiRendouTy(String pZtysmbcdatakbn, String pZtysmbcdatasakuseiymd, String pZtysmbchknkaisyacd, String pZtysmbcuktkkanriid) {
        ZT_SmbcSkMeisaiRendouTy zT_SmbcSkMeisaiRendouTy =  new ZT_SmbcSkMeisaiRendouTy();
        zT_SmbcSkMeisaiRendouTy.setZtysmbcdatakbn(pZtysmbcdatakbn);
        zT_SmbcSkMeisaiRendouTy.setZtysmbcdatasakuseiymd(pZtysmbcdatasakuseiymd);
        zT_SmbcSkMeisaiRendouTy.setZtysmbchknkaisyacd(pZtysmbchknkaisyacd);
        zT_SmbcSkMeisaiRendouTy.setZtysmbcuktkkanriid(pZtysmbcuktkkanriid);
        return this.selectOne(zT_SmbcSkMeisaiRendouTy);
    }

    public ExDBResults<ZT_SmbcSkMeisaiRendouTy> selectAllZT_SmbcSkMeisaiRendouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcSkMeisaiRendouTy qZT_SmbcSkMeisaiRendouTy =  new QZT_SmbcSkMeisaiRendouTy();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcSkMeisaiRendouTy);
        jpql.append($FROM);
        jpql.append(qZT_SmbcSkMeisaiRendouTy.ZT_SmbcSkMeisaiRendouTy());
        jpql.append($ORDER_BY(qZT_SmbcSkMeisaiRendouTy.ztysmbcdatakbn.asc(), qZT_SmbcSkMeisaiRendouTy.ztysmbcdatasakuseiymd.asc(), qZT_SmbcSkMeisaiRendouTy.ztysmbchknkaisyacd.asc(), qZT_SmbcSkMeisaiRendouTy.ztysmbcuktkkanriid.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcSkMeisaiRendouTy).getResults();
    }
}
