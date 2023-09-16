package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;

/**
 * 新契約不備項目マスタ(HM_SkHubiKoumokuDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkHubiKoumokuDao extends AbstractDao<HM_SkHubiKoumoku> {

    public HM_SkHubiKoumokuDao() {
        super(HM_SkHubiKoumoku.class);
    }

    public HM_SkHubiKoumoku getSkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd,
        String pSkhubikoumokucd){
        HM_SkHubiKoumoku hM_SkHubiKoumoku =  new HM_SkHubiKoumoku();
        hM_SkHubiKoumoku.setSyoruiCd(pSyoruiCd);
        hM_SkHubiKoumoku.setSkhubikoumokucd(pSkhubikoumokucd);
        return this.selectOne(hM_SkHubiKoumoku);
    }

    public List<HM_SkHubiKoumoku> getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        HM_SkHubiKoumoku hM_SkHubiKoumoku =  new HM_SkHubiKoumoku();
        hM_SkHubiKoumoku.setSyoruiCd(pSyoruiCd);
        hM_SkHubiKoumoku.setHyoujikahikbn(C_KahiKbn.KA);
        return this.select(hM_SkHubiKoumoku);
    }
}
