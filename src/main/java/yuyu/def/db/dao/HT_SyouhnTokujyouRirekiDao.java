package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SyouhnTokujyouRireki;

/**
 * 商品別特条条件付履歴テーブル(HT_SyouhnTokujyouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SyouhnTokujyouRirekiDao extends AbstractDao<HT_SyouhnTokujyouRireki> {

    public HT_SyouhnTokujyouRirekiDao() {
        super(HT_SyouhnTokujyouRireki.class);
    }

    @Deprecated
    public HT_SyouhnTokujyouRireki getSyouhnTokujyouRireki(String pMosno,
         Integer pDakuhiktrenno,
         String pSyouhncd){
        HT_SyouhnTokujyouRireki hT_SyouhnTokujyouRireki =  new HT_SyouhnTokujyouRireki();
        hT_SyouhnTokujyouRireki.setMosno(pMosno);
        hT_SyouhnTokujyouRireki.setDakuhiktrenno(pDakuhiktrenno);
        hT_SyouhnTokujyouRireki.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_SyouhnTokujyouRireki);
    }

    @Override
    @Deprecated
    public List<HT_SyouhnTokujyouRireki> selectAll() {
        return super.selectAll();
    }
}
