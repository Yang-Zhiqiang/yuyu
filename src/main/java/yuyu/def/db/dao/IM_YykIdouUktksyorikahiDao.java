package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;

/**
 * 予約異動受付中処理可否マスタ(IM_YykIdouUktksyorikahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_YykIdouUktksyorikahiDao extends AbstractDao<IM_YykIdouUktksyorikahi> {

    public IM_YykIdouUktksyorikahiDao() {
        super(IM_YykIdouUktksyorikahi.class);
    }

    public IM_YykIdouUktksyorikahi getYykIdouUktksyorikahi(String pKinouId,
         String pYykuktkkinouid){
        IM_YykIdouUktksyorikahi iM_YykIdouUktksyorikahi =  new IM_YykIdouUktksyorikahi();
        iM_YykIdouUktksyorikahi.setKinouId(pKinouId);
        iM_YykIdouUktksyorikahi.setYykuktkkinouid(pYykuktkkinouid);
        return this.selectOne(iM_YykIdouUktksyorikahi);
    }
}
