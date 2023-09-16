package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKeiyaku;
import java.util.List;

/**
 * ＤＳ顧客契約バックアップテーブル(MT_BAK_DsKokyakuKeiyakuDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsKokyakuKeiyakuDao extends AbstractDao<MT_BAK_DsKokyakuKeiyaku> {

    public MT_BAK_DsKokyakuKeiyakuDao() {
        super(MT_BAK_DsKokyakuKeiyaku.class);
    }

    @Deprecated
    public MT_BAK_DsKokyakuKeiyaku getBAKDsKokyakuKeiyaku(String pDskokno, String pSyono, String pTrkssikibetukey) {
        MT_BAK_DsKokyakuKeiyaku mT_BAK_DsKokyakuKeiyaku =  new MT_BAK_DsKokyakuKeiyaku();
        mT_BAK_DsKokyakuKeiyaku.setDskokno(pDskokno);
        mT_BAK_DsKokyakuKeiyaku.setSyono(pSyono);
        mT_BAK_DsKokyakuKeiyaku.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsKokyakuKeiyaku);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsKokyakuKeiyaku> selectAll() {
        return super.selectAll();
    }
}
