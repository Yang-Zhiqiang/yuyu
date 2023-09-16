package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkHubiNaiyou;

/**
 * 新契約不備内容マスタ(HM_SkHubiNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkHubiNaiyouDao extends AbstractDao<HM_SkHubiNaiyou> {

    public HM_SkHubiNaiyouDao() {
        super(HM_SkHubiNaiyou.class);
    }

    public HM_SkHubiNaiyou getSkHubiNaiyou(String pSkhubikoumokucd,
        String pSkhubinaiyoucd){
        HM_SkHubiNaiyou hM_SkHubiNaiyou =  new HM_SkHubiNaiyou();
        hM_SkHubiNaiyou.setSkhubikoumokucd(pSkhubikoumokucd);
        hM_SkHubiNaiyou.setSkhubinaiyoucd(pSkhubinaiyoucd);
        return this.selectOne(hM_SkHubiNaiyou);
    }

    public List<HM_SkHubiNaiyou> getSkHubiNaiyousBySkhubikoumokucd(
        String pSkhubikoumokucd) {

        HM_SkHubiNaiyou hM_SkHubiNaiyou = new HM_SkHubiNaiyou();
        hM_SkHubiNaiyou.setSkhubikoumokucd(pSkhubikoumokucd);
        hM_SkHubiNaiyou.setHyoujikahikbn(C_KahiKbn.KA);
        return this.select(hM_SkHubiNaiyou);
    }
}
