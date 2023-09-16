package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SyouhnTokujyou;

/**
 * 商品別特条条件付テーブル(HT_SyouhnTokujyouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SyouhnTokujyouDao extends AbstractDao<HT_SyouhnTokujyou> {

    public HT_SyouhnTokujyouDao() {
        super(HT_SyouhnTokujyou.class);
    }

    @Deprecated
    public HT_SyouhnTokujyou getSyouhnTokujyou(String pMosno,
         String pSyouhncd){
        HT_SyouhnTokujyou hT_SyouhnTokujyou =  new HT_SyouhnTokujyou();
        hT_SyouhnTokujyou.setMosno(pMosno);
        hT_SyouhnTokujyou.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_SyouhnTokujyou);
    }

    @Override
    @Deprecated
    public List<HT_SyouhnTokujyou> selectAll() {
        return super.selectAll();
    }
}
