package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.meta.QBT_BuntanInfo;

/**
 * 分担情報テーブル(BT_BuntanInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_BuntanInfoDao extends AbstractDao<BT_BuntanInfo> {

    public BT_BuntanInfoDao() {
        super(BT_BuntanInfo.class);
    }

    public BT_BuntanInfo getBuntanInfo(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pTesuuryoubuntanstartym) {
        BT_BuntanInfo bT_BuntanInfo =  new BT_BuntanInfo();
        bT_BuntanInfo.setDrtencd(pDrtencd);
        bT_BuntanInfo.setDairitensyouhincd(pDairitensyouhincd);
        bT_BuntanInfo.setTesuuryoubuntandrtencd(pTesuuryoubuntandrtencd);
        bT_BuntanInfo.setTesuuryoubuntanstartym(pTesuuryoubuntanstartym);
        return this.selectOne(bT_BuntanInfo);
    }

    public List<BT_BuntanInfo> getBuntanInfosByPK(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntanaitedrtencd, BizDateYM pSyutokukijyunym) {
        QBT_BuntanInfo qBT_BuntanInfo = new QBT_BuntanInfo();
        String strSql = $SELECT + qBT_BuntanInfo +
                $FROM + qBT_BuntanInfo.BT_BuntanInfo() +
                $WHERE + qBT_BuntanInfo.drtencd.eq(pDrtencd)+
                $AND + qBT_BuntanInfo.dairitensyouhincd.eq(pDairitensyouhincd) +
                $AND + qBT_BuntanInfo.tesuuryoubuntandrtencd.eq(pTesuuryoubuntanaitedrtencd) +
                $AND + qBT_BuntanInfo.tesuuryoubuntanstartym.le(pSyutokukijyunym) +
                $AND + "(" + qBT_BuntanInfo.tesuuryoubuntanendym.ge(pSyutokukijyunym) +
                $OR + qBT_BuntanInfo.tesuuryoubuntanendym.isNull() + ")";

        return em.createJPQL(strSql).bind(qBT_BuntanInfo).getResultList();

    }

    public List<BT_BuntanInfo> getBuntanInfosAitedrtenSiteinasi(String pDrtencd, String pDairitensyouhincd, BizDateYM pSyutokukijyunym) {
        QBT_BuntanInfo qBT_BuntanInfo = new QBT_BuntanInfo();
        String strSql = $SELECT + qBT_BuntanInfo +
                $FROM + qBT_BuntanInfo.BT_BuntanInfo() +
                $WHERE + qBT_BuntanInfo.drtencd.eq(pDrtencd)+
                $AND + qBT_BuntanInfo.dairitensyouhincd.eq(pDairitensyouhincd) +
                $AND + qBT_BuntanInfo.tesuuryoubuntanstartym.le(pSyutokukijyunym) +
                $AND + "(" + qBT_BuntanInfo.tesuuryoubuntanendym.ge(pSyutokukijyunym) +
                $OR + qBT_BuntanInfo.tesuuryoubuntanendym.isNull() + ")";

        return em.createJPQL(strSql).bind(qBT_BuntanInfo).getResultList();

    }
}
