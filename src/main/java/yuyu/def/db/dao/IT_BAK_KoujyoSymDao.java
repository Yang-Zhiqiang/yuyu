package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_KoujyoSym;
/**
 * 控除証明書バックアップテーブル(IT_BAK_KoujyoSymDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KoujyoSymDao extends AbstractDao<IT_BAK_KoujyoSym> {

    public IT_BAK_KoujyoSymDao() {
        super(IT_BAK_KoujyoSym.class);
    }

    @Deprecated
    public IT_BAK_KoujyoSym getBAKKoujyoSym(String pSyono,
         String pTrkssikibetukey,
         String pNendo,
         BizDate pTyouhyouymd,
         Integer pRenno){
        IT_BAK_KoujyoSym iT_BAK_KoujyoSym =  new IT_BAK_KoujyoSym();
        iT_BAK_KoujyoSym.setSyono(pSyono);
        iT_BAK_KoujyoSym.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KoujyoSym.setNendo(pNendo);
        iT_BAK_KoujyoSym.setTyouhyouymd(pTyouhyouymd);
        iT_BAK_KoujyoSym.setRenno(pRenno);
        return this.selectOne(iT_BAK_KoujyoSym);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KoujyoSym> selectAll() {
        return super.selectAll();
    }
}
