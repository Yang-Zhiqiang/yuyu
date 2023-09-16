package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyou;

/**
 * 控除証明内容バックアップテーブル(IT_BAK_KoujyoSymNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KoujyoSymNaiyouDao extends AbstractDao<IT_BAK_KoujyoSymNaiyou> {

    public IT_BAK_KoujyoSymNaiyouDao() {
        super(IT_BAK_KoujyoSymNaiyou.class);
    }

    @Deprecated
    public IT_BAK_KoujyoSymNaiyou getBAKKoujyoSymNaiyou(String pSyono,
         String pTrkssikibetukey,
         String pSyouhncd,
         Integer pRenno3keta){
        IT_BAK_KoujyoSymNaiyou iT_BAK_KoujyoSymNaiyou =  new IT_BAK_KoujyoSymNaiyou();
        iT_BAK_KoujyoSymNaiyou.setSyono(pSyono);
        iT_BAK_KoujyoSymNaiyou.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KoujyoSymNaiyou.setSyouhncd(pSyouhncd);
        iT_BAK_KoujyoSymNaiyou.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_BAK_KoujyoSymNaiyou);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KoujyoSymNaiyou> selectAll() {
        return super.selectAll();
    }
}
