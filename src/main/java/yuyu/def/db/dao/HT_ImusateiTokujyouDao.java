package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_ImusateiTokujyou;

/**
 * 医務査定特条テーブル(HT_ImusateiTokujyouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_ImusateiTokujyouDao extends AbstractDao<HT_ImusateiTokujyou> {

    public HT_ImusateiTokujyouDao() {
        super(HT_ImusateiTokujyou.class);
    }

    @Deprecated
    public HT_ImusateiTokujyou getImusateiTokujyou(String pMosno,
         Integer pRenno){
        HT_ImusateiTokujyou hT_ImusateiTokujyou =  new HT_ImusateiTokujyou();
        hT_ImusateiTokujyou.setMosno(pMosno);
        hT_ImusateiTokujyou.setRenno(pRenno);
        return this.selectOne(hT_ImusateiTokujyou);
    }

    @Override
    @Deprecated
    public List<HT_ImusateiTokujyou> selectAll() {
        return super.selectAll();
    }
}
