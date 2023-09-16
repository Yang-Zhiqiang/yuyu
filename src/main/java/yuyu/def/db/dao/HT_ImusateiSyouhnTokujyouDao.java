package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;

/**
 * 医務査定商品別特条条件付テーブル(HT_ImusateiSyouhnTokujyouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_ImusateiSyouhnTokujyouDao extends AbstractDao<HT_ImusateiSyouhnTokujyou> {

    public HT_ImusateiSyouhnTokujyouDao() {
        super(HT_ImusateiSyouhnTokujyou.class);
    }

    @Deprecated
    public HT_ImusateiSyouhnTokujyou getImusateiSyouhnTokujyou(String pMosno,
         Integer pRenno,
         String pSyouhncd){
        HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou =  new HT_ImusateiSyouhnTokujyou();
        hT_ImusateiSyouhnTokujyou.setMosno(pMosno);
        hT_ImusateiSyouhnTokujyou.setRenno(pRenno);
        hT_ImusateiSyouhnTokujyou.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_ImusateiSyouhnTokujyou);
    }

    @Override
    @Deprecated
    public List<HT_ImusateiSyouhnTokujyou> selectAll() {
        return super.selectAll();
    }
}
