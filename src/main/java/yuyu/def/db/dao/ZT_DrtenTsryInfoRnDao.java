package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.QZT_DrtenTsryInfoRn;

/**
 * 代理店手数料情報Ｆテーブル（連）(ZT_DrtenTsryInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenTsryInfoRnDao extends AbstractDao<ZT_DrtenTsryInfoRn> {

    public ZT_DrtenTsryInfoRnDao() {
        super(ZT_DrtenTsryInfoRn.class);
    }

    public ZT_DrtenTsryInfoRn getDrtenTsryInfoRn(String pZrndairitencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnkikaisyoriymd, Long pZrnkykmfksnctrlkh, String pZrnsikibetujyunjyo) {
        ZT_DrtenTsryInfoRn zT_DrtenTsryInfoRn =  new ZT_DrtenTsryInfoRn();
        zT_DrtenTsryInfoRn.setZrndairitencd(pZrndairitencd);
        zT_DrtenTsryInfoRn.setZrnbosyuunincd(pZrnbosyuunincd);
        zT_DrtenTsryInfoRn.setZrnsyono(pZrnsyono);
        zT_DrtenTsryInfoRn.setZrnkikaisyoriymd(pZrnkikaisyoriymd);
        zT_DrtenTsryInfoRn.setZrnkykmfksnctrlkh(pZrnkykmfksnctrlkh);
        zT_DrtenTsryInfoRn.setZrnsikibetujyunjyo(pZrnsikibetujyunjyo);
        return this.selectOne(zT_DrtenTsryInfoRn);
    }

    public ExDBResults<ZT_DrtenTsryInfoRn> selectAllZT_DrtenTsryInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenTsryInfoRn qZT_DrtenTsryInfoRn =  new QZT_DrtenTsryInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenTsryInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenTsryInfoRn.ZT_DrtenTsryInfoRn());
        jpql.append($ORDER_BY(qZT_DrtenTsryInfoRn.zrndairitencd.asc(), qZT_DrtenTsryInfoRn.zrnbosyuunincd.asc(), qZT_DrtenTsryInfoRn.zrnsyono.asc(), qZT_DrtenTsryInfoRn.zrnkikaisyoriymd.asc(), qZT_DrtenTsryInfoRn.zrnkykmfksnctrlkh.asc(), qZT_DrtenTsryInfoRn.zrnsikibetujyunjyo.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenTsryInfoRn).getResults();
    }
}
