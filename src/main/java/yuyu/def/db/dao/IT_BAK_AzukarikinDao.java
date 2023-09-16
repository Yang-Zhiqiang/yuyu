package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_Azukarikin;

/**
 * 預り金バックアップテーブル(IT_BAK_AzukarikinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_AzukarikinDao extends AbstractDao<IT_BAK_Azukarikin> {

    public IT_BAK_AzukarikinDao() {
        super(IT_BAK_Azukarikin.class);
    }

    public IT_BAK_Azukarikin getBAKAzukarikin(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {
        IT_BAK_Azukarikin iT_BAK_Azukarikin =  new IT_BAK_Azukarikin( pSyono,  pTrkssikibetukey,  pHenkousikibetukey,  pTuukasyu);
        return this.selectOne(iT_BAK_Azukarikin);
    }

}
