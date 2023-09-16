package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouRn;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（連）(ZT_SmbcSkMeisaiRendouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcSkMeisaiRendouRnDao extends AbstractDao<ZT_SmbcSkMeisaiRendouRn> {

    public ZT_SmbcSkMeisaiRendouRnDao() {
        super(ZT_SmbcSkMeisaiRendouRn.class);
    }

    public ZT_SmbcSkMeisaiRendouRn getSmbcSkMeisaiRendouRn(String pZrnsmbcdatakbn, String pZrnsmbcdatasakuseiymd, String pZrnsmbchknkaisyacd, String pZrnsmbcuktkkanriid) {
        ZT_SmbcSkMeisaiRendouRn zT_SmbcSkMeisaiRendouRn =  new ZT_SmbcSkMeisaiRendouRn();
        zT_SmbcSkMeisaiRendouRn.setZrnsmbcdatakbn(pZrnsmbcdatakbn);
        zT_SmbcSkMeisaiRendouRn.setZrnsmbcdatasakuseiymd(pZrnsmbcdatasakuseiymd);
        zT_SmbcSkMeisaiRendouRn.setZrnsmbchknkaisyacd(pZrnsmbchknkaisyacd);
        zT_SmbcSkMeisaiRendouRn.setZrnsmbcuktkkanriid(pZrnsmbcuktkkanriid);
        return this.selectOne(zT_SmbcSkMeisaiRendouRn);
    }

    public ExDBResults<ZT_SmbcSkMeisaiRendouRn> selectAllZT_SmbcSkMeisaiRendouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcSkMeisaiRendouRn qZT_SmbcSkMeisaiRendouRn =  new QZT_SmbcSkMeisaiRendouRn();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcSkMeisaiRendouRn);
        jpql.append($FROM);
        jpql.append(qZT_SmbcSkMeisaiRendouRn.ZT_SmbcSkMeisaiRendouRn());
        jpql.append($ORDER_BY(qZT_SmbcSkMeisaiRendouRn.zrnsmbcdatakbn.asc(), qZT_SmbcSkMeisaiRendouRn.zrnsmbcdatasakuseiymd.asc(), qZT_SmbcSkMeisaiRendouRn.zrnsmbchknkaisyacd.asc(), qZT_SmbcSkMeisaiRendouRn.zrnsmbcuktkkanriid.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcSkMeisaiRendouRn).getResults();
    }
}
