package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;

/**
 * 主契約複合疾患増幅ワークテーブル(HW_SyuHukugouSikkanZhkWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_SyuHukugouSikkanZhkWkDao extends AbstractDao<HW_SyuHukugouSikkanZhkWk> {

    public HW_SyuHukugouSikkanZhkWkDao() {
        super(HW_SyuHukugouSikkanZhkWk.class);
    }

    public HW_SyuHukugouSikkanZhkWk getSyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {
        HW_SyuHukugouSikkanZhkWk hW_SyuHukugouSikkanZhkWk =  new HW_SyuHukugouSikkanZhkWk();
        hW_SyuHukugouSikkanZhkWk.setSyono(pSyono);
        hW_SyuHukugouSikkanZhkWk.setHknnendo(pHknnendo);
        return this.selectOne(hW_SyuHukugouSikkanZhkWk);
    }

}
