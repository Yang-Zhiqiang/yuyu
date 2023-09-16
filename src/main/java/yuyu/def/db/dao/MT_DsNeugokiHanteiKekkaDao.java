package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import java.util.List;

/**
 * ＤＳ値動き判定結果テーブル(MT_DsNeugokiHanteiKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsNeugokiHanteiKekkaDao extends AbstractDao<MT_DsNeugokiHanteiKekka> {

    public MT_DsNeugokiHanteiKekkaDao() {
        super(MT_DsNeugokiHanteiKekka.class);
    }

    @Deprecated
    public MT_DsNeugokiHanteiKekka getDsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono) {
        MT_DsNeugokiHanteiKekka mT_DsNeugokiHanteiKekka =  new MT_DsNeugokiHanteiKekka();
        mT_DsNeugokiHanteiKekka.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsNeugokiHanteiKekka.setSyono(pSyono);
        return this.selectOne(mT_DsNeugokiHanteiKekka);
    }

    @Override
    @Deprecated
    public List<MT_DsNeugokiHanteiKekka> selectAll() {
        return super.selectAll();
    }
}
