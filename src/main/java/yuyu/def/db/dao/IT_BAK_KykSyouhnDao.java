package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;

/**
 * 契約商品バックアップテーブル(IT_BAK_KykSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykSyouhnDao extends AbstractDao<IT_BAK_KykSyouhn> {

    public IT_BAK_KykSyouhnDao() {
        super(IT_BAK_KykSyouhn.class);
    }

    @Deprecated
    public IT_BAK_KykSyouhn getBAKKykSyouhn(String pSyono,
         String pTrkssikibetukey,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_BAK_KykSyouhn iT_BAK_KykSyouhn =  new IT_BAK_KykSyouhn();
        iT_BAK_KykSyouhn.setSyono(pSyono);
        iT_BAK_KykSyouhn.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KykSyouhn.setSyutkkbn(pSyutkkbn);
        iT_BAK_KykSyouhn.setSyouhncd(pSyouhncd);
        iT_BAK_KykSyouhn.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_KykSyouhn.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_BAK_KykSyouhn);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykSyouhn> selectAll() {
        return super.selectAll();
    }
}
