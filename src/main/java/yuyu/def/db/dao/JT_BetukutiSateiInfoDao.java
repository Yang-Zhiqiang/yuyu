package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;

/**
 * 別口査定情報テーブル(JT_BetukutiSateiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_BetukutiSateiInfoDao extends AbstractDao<JT_BetukutiSateiInfo> {

    public JT_BetukutiSateiInfoDao() {
        super(JT_BetukutiSateiInfo.class);
    }

    @Deprecated
    public JT_BetukutiSateiInfo getBetukutiSateiInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_BetukutiSateiInfo jT_BetukutiSateiInfo =  new JT_BetukutiSateiInfo();
        jT_BetukutiSateiInfo.setSkno(pSkno);
        jT_BetukutiSateiInfo.setSyono(pSyono);
        jT_BetukutiSateiInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_BetukutiSateiInfo);
    }

    @Override
    @Deprecated
    public List<JT_BetukutiSateiInfo> selectAll() {
        return super.selectAll();
    }
}
