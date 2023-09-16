package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_TuusanToutatu;

/**
 * 通算到達テーブル(JT_TuusanToutatuDao) アクセス用の DAO クラスです。<br />
 */
public class JT_TuusanToutatuDao extends AbstractDao<JT_TuusanToutatu> {

    public JT_TuusanToutatuDao() {
        super(JT_TuusanToutatu.class);
    }

    @Deprecated
    public JT_TuusanToutatu getTuusanToutatu(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         String pKyuuhucd){
        JT_TuusanToutatu jT_TuusanToutatu =  new JT_TuusanToutatu();
        jT_TuusanToutatu.setSkno(pSkno);
        jT_TuusanToutatu.setSyono(pSyono);
        jT_TuusanToutatu.setSeikyuurirekino(pSeikyuurirekino);
        jT_TuusanToutatu.setKyuuhucd(pKyuuhucd);
        return this.selectOne(jT_TuusanToutatu);
    }

    @Override
    @Deprecated
    public List<JT_TuusanToutatu> selectAll() {
        return super.selectAll();
    }
}
