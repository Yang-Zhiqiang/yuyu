package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;

/**
 * 解約返戻金相当額情報ビュー(SV_KiykHnriknSutugkDao) アクセス用の DAO クラスです。<br />
 */
public class SV_KiykHnriknSutugkDao extends AbstractDao<SV_KiykHnriknSutugk> {

    public SV_KiykHnriknSutugkDao() {
        super(SV_KiykHnriknSutugk.class);
    }

    public SV_KiykHnriknSutugk getKiykHnriknSutugk(String pSyono) {
        SV_KiykHnriknSutugk sV_KiykHnriknSutugk =  new SV_KiykHnriknSutugk();
        sV_KiykHnriknSutugk.setSyono(pSyono);
        return this.selectOne(sV_KiykHnriknSutugk);
    }
}
