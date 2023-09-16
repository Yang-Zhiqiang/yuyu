package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;

/**
 * 手術給付マスタ(JM_SyujyutuKyuuhuDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SyujyutuKyuuhuDao extends AbstractDao<JM_SyujyutuKyuuhu> {

    public JM_SyujyutuKyuuhuDao() {
        super(JM_SyujyutuKyuuhu.class);
    }

    public JM_SyujyutuKyuuhu getSyujyutuKyuuhu(String pSyujyutubunruicd,
         String pSyouhncd,
         Integer pSyouhnsdno,
         String pKyuuhucd,
         BizDate pSyujyututekiyoukkanfrom,
         BizDate pSyujyututekiyoukkanto){
        JM_SyujyutuKyuuhu jM_SyujyutuKyuuhu =  new JM_SyujyutuKyuuhu();
        jM_SyujyutuKyuuhu.setSyujyutubunruicd(pSyujyutubunruicd);
        jM_SyujyutuKyuuhu.setSyouhncd(pSyouhncd);
        jM_SyujyutuKyuuhu.setSyouhnsdno(pSyouhnsdno);
        jM_SyujyutuKyuuhu.setKyuuhucd(pKyuuhucd);
        jM_SyujyutuKyuuhu.setSyujyututekiyoukkanfrom(pSyujyututekiyoukkanfrom);
        jM_SyujyutuKyuuhu.setSyujyututekiyoukkanto(pSyujyututekiyoukkanto);
        return this.selectOne(jM_SyujyutuKyuuhu);
    }
}
