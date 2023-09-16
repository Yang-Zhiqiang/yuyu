package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 支払契約商品テーブル(JT_SiKykSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiKykSyouhnDao extends AbstractDao<JT_SiKykSyouhn> {

    public JT_SiKykSyouhnDao() {
        super(JT_SiKykSyouhn.class);
    }

    @Deprecated
    public JT_SiKykSyouhn getSiKykSyouhn(String pSyono,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         C_KyhgndkataKbn pKyhgndkatakbn,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        JT_SiKykSyouhn jT_SiKykSyouhn =  new JT_SiKykSyouhn();
        jT_SiKykSyouhn.setSyono(pSyono);
        jT_SiKykSyouhn.setSyutkkbn(pSyutkkbn);
        jT_SiKykSyouhn.setSyouhncd(pSyouhncd);
        jT_SiKykSyouhn.setKyhgndkatakbn(pKyhgndkatakbn);
        jT_SiKykSyouhn.setSyouhnsdno(pSyouhnsdno);
        jT_SiKykSyouhn.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(jT_SiKykSyouhn);
    }

    @Override
    @Deprecated
    public List<JT_SiKykSyouhn> selectAll() {
        return super.selectAll();
    }
}
