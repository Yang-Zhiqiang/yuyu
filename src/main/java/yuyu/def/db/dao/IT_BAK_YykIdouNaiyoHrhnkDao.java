package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_YykIdouNaiyoHrhnk;

/**
 * 予約異動受付内容（払方変更）バックアップテーブル(IT_BAK_YykIdouNaiyoHrhnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_YykIdouNaiyoHrhnkDao extends AbstractDao<IT_BAK_YykIdouNaiyoHrhnk> {

    public IT_BAK_YykIdouNaiyoHrhnkDao() {
        super(IT_BAK_YykIdouNaiyoHrhnk.class);
    }

    @Deprecated
    public IT_BAK_YykIdouNaiyoHrhnk getBAKYykIdouNaiyoHrhnk(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey){
        IT_BAK_YykIdouNaiyoHrhnk iT_BAK_YykIdouNaiyoHrhnk =  new IT_BAK_YykIdouNaiyoHrhnk();
        iT_BAK_YykIdouNaiyoHrhnk.setSyono(pSyono);
        iT_BAK_YykIdouNaiyoHrhnk.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_YykIdouNaiyoHrhnk.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_YykIdouNaiyoHrhnk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_YykIdouNaiyoHrhnk> selectAll() {
        return super.selectAll();
    }
}
