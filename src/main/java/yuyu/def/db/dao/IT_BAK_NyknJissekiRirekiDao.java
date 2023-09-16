package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_BAK_NyknJissekiRireki;

/**
 * 入金実績履歴バックアップテーブル(IT_BAK_NyknJissekiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_NyknJissekiRirekiDao extends AbstractDao<IT_BAK_NyknJissekiRireki> {

    public IT_BAK_NyknJissekiRirekiDao() {
        super(IT_BAK_NyknJissekiRireki.class);
    }

    @Deprecated
    public IT_BAK_NyknJissekiRireki getBAKNyknJissekiRireki(String pSyono,
         String pTrkssikibetukey,
         BizDateYM pJyutoustartym,
         Integer pRenno){
        IT_BAK_NyknJissekiRireki iT_BAK_NyknJissekiRireki =  new IT_BAK_NyknJissekiRireki();
        iT_BAK_NyknJissekiRireki.setSyono(pSyono);
        iT_BAK_NyknJissekiRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_NyknJissekiRireki.setJyutoustartym(pJyutoustartym);
        iT_BAK_NyknJissekiRireki.setRenno(pRenno);
        return this.selectOne(iT_BAK_NyknJissekiRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_NyknJissekiRireki> selectAll() {
        return super.selectAll();
    }
}
