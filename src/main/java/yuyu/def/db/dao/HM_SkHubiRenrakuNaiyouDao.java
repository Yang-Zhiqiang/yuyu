package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;

/**
 * 新契約不備連絡内容マスタ(HM_SkHubiRenrakuNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkHubiRenrakuNaiyouDao extends AbstractDao<HM_SkHubiRenrakuNaiyou> {

    public HM_SkHubiRenrakuNaiyouDao() {
        super(HM_SkHubiRenrakuNaiyou.class);
    }

    public HM_SkHubiRenrakuNaiyou getSkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {
        HM_SkHubiRenrakuNaiyou hM_SkHubiRenrakuNaiyou =  new HM_SkHubiRenrakuNaiyou();
        hM_SkHubiRenrakuNaiyou.setSkhubirenrakunaiyoucd(pSkhubirenrakunaiyoucd);
        return this.selectOne(hM_SkHubiRenrakuNaiyou);
    }
}
