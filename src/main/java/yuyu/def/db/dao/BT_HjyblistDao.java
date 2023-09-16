package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.meta.QBT_Hjyblist;

/**
 * 補助簿リスト用テーブル(BT_HjyblistDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HjyblistDao extends AbstractDao<BT_Hjyblist> {

    public BT_HjyblistDao() {
        super(BT_Hjyblist.class);
    }

    public BT_Hjyblist getHjyblist(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, String pSyorisyokantantcd, BizDate pDenymd) {
        BT_Hjyblist bT_Hjyblist =  new BT_Hjyblist();
        bT_Hjyblist.setHjybtantositucd(pHjybtantositucd);
        bT_Hjyblist.setKanjyoukmkcd(pKanjyoukmkcd);
        bT_Hjyblist.setSyorisyokantantcd(pSyorisyokantantcd);
        bT_Hjyblist.setDenymd(pDenymd);
        return this.selectOne(bT_Hjyblist);
    }

    public ExDBResults<BT_Hjyblist> getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(BizDate pDenymdFrom, BizDate pDenymdTo) {


        QBT_Hjyblist qBT_Hjyblist = new QBT_Hjyblist();


        String strSql = $SELECT + qBT_Hjyblist +
            $FROM(qBT_Hjyblist) +
            $WHERE + qBT_Hjyblist.denymd.ge(pDenymdFrom) +
            $AND + qBT_Hjyblist.denymd.le(pDenymdTo) +
            $ORDER_BY(qBT_Hjyblist.hjybtantositucd.asc(),
                qBT_Hjyblist.kanjyoukmkcd.asc(),
                qBT_Hjyblist.syorisyokantantcd.asc(),
                qBT_Hjyblist.denymd.asc());

        return em.createJPQL(strSql).bind(qBT_Hjyblist).getResults();
    }
}
