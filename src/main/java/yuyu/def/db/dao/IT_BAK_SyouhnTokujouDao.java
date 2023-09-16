package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujou;

/**
 * 商品特条バックアップテーブル(IT_BAK_SyouhnTokujouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_SyouhnTokujouDao extends AbstractDao<IT_BAK_SyouhnTokujou> {

    public IT_BAK_SyouhnTokujouDao() {
        super(IT_BAK_SyouhnTokujou.class);
    }

    @Deprecated
    public IT_BAK_SyouhnTokujou getBAKSyouhnTokujou(String pSyono,
         String pTrkssikibetukey,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_BAK_SyouhnTokujou iT_BAK_SyouhnTokujou =  new IT_BAK_SyouhnTokujou();
        iT_BAK_SyouhnTokujou.setSyono(pSyono);
        iT_BAK_SyouhnTokujou.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_SyouhnTokujou.setSyutkkbn(pSyutkkbn);
        iT_BAK_SyouhnTokujou.setSyouhncd(pSyouhncd);
        iT_BAK_SyouhnTokujou.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_SyouhnTokujou.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_BAK_SyouhnTokujou);
    }

    @Override
    @Deprecated
    public List<IT_BAK_SyouhnTokujou> selectAll() {
        return super.selectAll();
    }
}
