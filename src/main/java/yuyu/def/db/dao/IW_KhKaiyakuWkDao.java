package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.db.meta.QIW_KhKaiyakuWk;

/**
 * 解約ワークテーブル(IW_KhKaiyakuWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhKaiyakuWkDao extends AbstractDao<IW_KhKaiyakuWk> {

    public IW_KhKaiyakuWkDao() {
        super(IW_KhKaiyakuWk.class);
    }

    public IW_KhKaiyakuWk getKhKaiyakuWk(String pKouteikanriid){
        IW_KhKaiyakuWk iW_KhKaiyakuWk =  new IW_KhKaiyakuWk();
        iW_KhKaiyakuWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhKaiyakuWk);
    }

    public ExDBResults<IW_KhKaiyakuWk> getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(BizDate pSkssakuseiymd) {


        QIW_KhKaiyakuWk qIW_KhKaiyakuWk = new QIW_KhKaiyakuWk();


        String querySql = $SELECT + qIW_KhKaiyakuWk +
            $FROM + qIW_KhKaiyakuWk.IW_KhKaiyakuWk() +
            $WHERE + qIW_KhKaiyakuWk.skssakuseiymd.eq(pSkssakuseiymd);

        return em.createJPQL(querySql).bind(qIW_KhKaiyakuWk).getResults();
    }
}
