package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;

/**
 * 予約異動受付内容（払方変更）テーブル(IT_YykIdouNaiyoHrhnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YykIdouNaiyoHrhnkDao extends AbstractDao<IT_YykIdouNaiyoHrhnk> {

    public IT_YykIdouNaiyoHrhnkDao() {
        super(IT_YykIdouNaiyoHrhnk.class);
    }

    @Deprecated
    public IT_YykIdouNaiyoHrhnk getYykIdouNaiyoHrhnk(String pSyono,
         String pHenkousikibetukey){
        IT_YykIdouNaiyoHrhnk iT_YykIdouNaiyoHrhnk =  new IT_YykIdouNaiyoHrhnk();
        iT_YykIdouNaiyoHrhnk.setSyono(pSyono);
        iT_YykIdouNaiyoHrhnk.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_YykIdouNaiyoHrhnk);
    }

    @Override
    @Deprecated
    public List<IT_YykIdouNaiyoHrhnk> selectAll() {
        return super.selectAll();
    }
}
