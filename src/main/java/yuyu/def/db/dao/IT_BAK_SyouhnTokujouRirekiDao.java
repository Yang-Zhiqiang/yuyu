package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujouRireki;

/**
 * 商品特条履歴バックアップテーブル(IT_BAK_SyouhnTokujouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_SyouhnTokujouRirekiDao extends AbstractDao<IT_BAK_SyouhnTokujouRireki> {

    public IT_BAK_SyouhnTokujouRirekiDao() {
        super(IT_BAK_SyouhnTokujouRireki.class);
    }

    @Deprecated
    public IT_BAK_SyouhnTokujouRireki getBAKSyouhnTokujouRireki(String pSyono,
         String pTrkssikibetukey,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno,
         String pHenkousikibetukey){
        IT_BAK_SyouhnTokujouRireki iT_BAK_SyouhnTokujouRireki =  new IT_BAK_SyouhnTokujouRireki();
        iT_BAK_SyouhnTokujouRireki.setSyono(pSyono);
        iT_BAK_SyouhnTokujouRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_SyouhnTokujouRireki.setSyutkkbn(pSyutkkbn);
        iT_BAK_SyouhnTokujouRireki.setSyouhncd(pSyouhncd);
        iT_BAK_SyouhnTokujouRireki.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_SyouhnTokujouRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        iT_BAK_SyouhnTokujouRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_SyouhnTokujouRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_SyouhnTokujouRireki> selectAll() {
        return super.selectAll();
    }
}
