package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;

/**
 * ＳＰ２連動用総成立情報ビュー(SV_Sp2RnduyuSouseirituDao) アクセス用の DAO クラスです。<br />
 */
public class SV_Sp2RnduyuSouseirituDao extends AbstractDao<SV_Sp2RnduyuSouseiritu> {

    public SV_Sp2RnduyuSouseirituDao() {
        super(SV_Sp2RnduyuSouseiritu.class);
    }

    public SV_Sp2RnduyuSouseiritu getSp2RnduyuSouseiritu(String pMosno) {
        SV_Sp2RnduyuSouseiritu sV_Sp2RnduyuSouseiritu =  new SV_Sp2RnduyuSouseiritu();
        sV_Sp2RnduyuSouseiritu.setMosno(pMosno);
        return this.selectOne(sV_Sp2RnduyuSouseiritu);
    }
}
