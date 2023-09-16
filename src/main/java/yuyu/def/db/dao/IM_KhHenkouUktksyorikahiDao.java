package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;

/**
 * 契約保全変更受付中処理可否マスタ(IM_KhHenkouUktksyorikahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhHenkouUktksyorikahiDao extends AbstractDao<IM_KhHenkouUktksyorikahi> {

    public IM_KhHenkouUktksyorikahiDao() {
        super(IM_KhHenkouUktksyorikahi.class);
    }

    public IM_KhHenkouUktksyorikahi getKhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn) {
        IM_KhHenkouUktksyorikahi iM_KhHenkouUktksyorikahi =  new IM_KhHenkouUktksyorikahi();
        iM_KhHenkouUktksyorikahi.setKinouId(pKinouId);
        iM_KhHenkouUktksyorikahi.setUktksyorikbn(pUktksyorikbn);
        return this.selectOne(iM_KhHenkouUktksyorikahi);
    }
}
