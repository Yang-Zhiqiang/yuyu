package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_KykSyouhnRireki;

/**
 * 契約商品履歴バックアップテーブル(IT_BAK_KykSyouhnRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykSyouhnRirekiDao extends AbstractDao<IT_BAK_KykSyouhnRireki> {

    public IT_BAK_KykSyouhnRirekiDao() {
        super(IT_BAK_KykSyouhnRireki.class);
    }

    @Deprecated
    public IT_BAK_KykSyouhnRireki getBAKKykSyouhnRireki(String pSyono,
         String pTrkssikibetukey,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno,
         String pHenkousikibetukey){
        IT_BAK_KykSyouhnRireki iT_BAK_KykSyouhnRireki =  new IT_BAK_KykSyouhnRireki();
        iT_BAK_KykSyouhnRireki.setSyono(pSyono);
        iT_BAK_KykSyouhnRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KykSyouhnRireki.setSyutkkbn(pSyutkkbn);
        iT_BAK_KykSyouhnRireki.setSyouhncd(pSyouhncd);
        iT_BAK_KykSyouhnRireki.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_KykSyouhnRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        iT_BAK_KykSyouhnRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_KykSyouhnRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykSyouhnRireki> selectAll() {
        return super.selectAll();
    }
}
