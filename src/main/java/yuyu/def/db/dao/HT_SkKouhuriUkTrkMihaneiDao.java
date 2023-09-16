package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;

/**
 * 新契約口振受付登録結果未反映テーブル(HT_SkKouhuriUkTrkMihaneiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkKouhuriUkTrkMihaneiDao extends AbstractDao<HT_SkKouhuriUkTrkMihanei> {

    public HT_SkKouhuriUkTrkMihaneiDao() {
        super(HT_SkKouhuriUkTrkMihanei.class);
    }

    public HT_SkKouhuriUkTrkMihanei getSkKouhuriUkTrkMihanei(BizDate pSyoriYmd, String pSyukkncd, String pKinyuucd8keta, BizDate pKinyuukkntratkiymd, String pKinyuukkntratkitime, String pKouhuriokyakusamano) {
        HT_SkKouhuriUkTrkMihanei hT_SkKouhuriUkTrkMihanei =  new HT_SkKouhuriUkTrkMihanei();
        hT_SkKouhuriUkTrkMihanei.setSyoriYmd(pSyoriYmd);
        hT_SkKouhuriUkTrkMihanei.setSyukkncd(pSyukkncd);
        hT_SkKouhuriUkTrkMihanei.setKinyuucd8keta(pKinyuucd8keta);
        hT_SkKouhuriUkTrkMihanei.setKinyuukkntratkiymd(pKinyuukkntratkiymd);
        hT_SkKouhuriUkTrkMihanei.setKinyuukkntratkitime(pKinyuukkntratkitime);
        hT_SkKouhuriUkTrkMihanei.setKouhuriokyakusamano(pKouhuriokyakusamano);
        return this.selectOne(hT_SkKouhuriUkTrkMihanei);
    }
}
