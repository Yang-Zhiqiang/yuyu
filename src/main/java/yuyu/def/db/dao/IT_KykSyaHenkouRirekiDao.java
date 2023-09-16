package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;

/**
 * 契約者変更履歴テーブル(IT_KykSyaHenkouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSyaHenkouRirekiDao extends AbstractDao<IT_KykSyaHenkouRireki> {

    public IT_KykSyaHenkouRirekiDao() {
        super(IT_KykSyaHenkouRireki.class);
    }

    @Deprecated
    public IT_KykSyaHenkouRireki getKykSyaHenkouRireki(String pSyono, String pHenkousikibetukey) {
        IT_KykSyaHenkouRireki iT_KykSyaHenkouRireki =  new IT_KykSyaHenkouRireki( pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_KykSyaHenkouRireki);
    }

    @Override
    @Deprecated
    public List<IT_KykSyaHenkouRireki> selectAll() {
        return super.selectAll();
    }

    public List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(String pSyono,
        C_Meigihnkjiyuu pMeigihnkjiyuu) {
        IT_KykSyaHenkouRireki iT_KykSyaHenkouRireki =  new IT_KykSyaHenkouRireki();
        iT_KykSyaHenkouRireki.setSyono(pSyono);
        iT_KykSyaHenkouRireki.setMeigihnkjiyuu(pMeigihnkjiyuu);
        return this.select(iT_KykSyaHenkouRireki);
    }

    public List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyono(String pSyono) {
        IT_KykSyaHenkouRireki iT_KykSyaHenkouRireki =  new IT_KykSyaHenkouRireki();
        iT_KykSyaHenkouRireki.setSyono(pSyono);
        return this.select(iT_KykSyaHenkouRireki);
    }
}
