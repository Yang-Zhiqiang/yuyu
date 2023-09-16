package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import java.util.List;

/**
 * ＤＳ値動き判定結果ワークテーブル(MW_DsNeugokiHanteiKekkaWkDao) アクセス用の DAO クラスです。<br />
 */
public class MW_DsNeugokiHanteiKekkaWkDao extends AbstractDao<MW_DsNeugokiHanteiKekkaWk> {

    public MW_DsNeugokiHanteiKekkaWkDao() {
        super(MW_DsNeugokiHanteiKekkaWk.class);
    }

    @Deprecated
    public MW_DsNeugokiHanteiKekkaWk getDsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono) {
        MW_DsNeugokiHanteiKekkaWk mW_DsNeugokiHanteiKekkaWk =  new MW_DsNeugokiHanteiKekkaWk();
        mW_DsNeugokiHanteiKekkaWk.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mW_DsNeugokiHanteiKekkaWk.setSyono(pSyono);
        return this.selectOne(mW_DsNeugokiHanteiKekkaWk);
    }

    @Override
    @Deprecated
    public List<MW_DsNeugokiHanteiKekkaWk> selectAll() {
        return super.selectAll();
    }
}
