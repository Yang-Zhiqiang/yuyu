package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_SyouhnTokujou;

/**
 * 商品特条テーブル(IT_SyouhnTokujouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SyouhnTokujouDao extends AbstractDao<IT_SyouhnTokujou> {

    public IT_SyouhnTokujouDao() {
        super(IT_SyouhnTokujou.class);
    }

    @Deprecated
    public IT_SyouhnTokujou getSyouhnTokujou(String pSyono,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_SyouhnTokujou iT_SyouhnTokujou =  new IT_SyouhnTokujou();
        iT_SyouhnTokujou.setSyono(pSyono);
        iT_SyouhnTokujou.setSyutkkbn(pSyutkkbn);
        iT_SyouhnTokujou.setSyouhncd(pSyouhncd);
        iT_SyouhnTokujou.setSyouhnsdno(pSyouhnsdno);
        iT_SyouhnTokujou.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_SyouhnTokujou);
    }

    @Override
    @Deprecated
    public List<IT_SyouhnTokujou> selectAll() {
        return super.selectAll();
    }
}
