package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_SibourituRendou;

/**
 * 死亡率用連動情報ビュー(SV_SibourituRendouDao) アクセス用の DAO クラスです。<br />
 */
public class SV_SibourituRendouDao extends AbstractDao<SV_SibourituRendou> {

    public SV_SibourituRendouDao() {
        super(SV_SibourituRendou.class);
    }

    public SV_SibourituRendou getSibourituRendou(String pMosno) {
        SV_SibourituRendou sV_SibourituRendou =  new SV_SibourituRendou();
        sV_SibourituRendou.setMosno(pMosno);
        return this.selectOne(sV_SibourituRendou);
    }
}
