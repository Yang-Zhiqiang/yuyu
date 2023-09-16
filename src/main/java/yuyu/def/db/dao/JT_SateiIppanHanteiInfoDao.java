package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;

/**
 * 査定一般判定情報テーブル(JT_SateiIppanHanteiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiIppanHanteiInfoDao extends AbstractDao<JT_SateiIppanHanteiInfo> {

    public JT_SateiIppanHanteiInfoDao() {
        super(JT_SateiIppanHanteiInfo.class);
    }

    @Deprecated
    public JT_SateiIppanHanteiInfo getSateiIppanHanteiInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SateiIppanHanteiInfo jT_SateiIppanHanteiInfo =  new JT_SateiIppanHanteiInfo();
        jT_SateiIppanHanteiInfo.setSkno(pSkno);
        jT_SateiIppanHanteiInfo.setSyono(pSyono);
        jT_SateiIppanHanteiInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SateiIppanHanteiInfo);
    }

    @Override
    @Deprecated
    public List<JT_SateiIppanHanteiInfo> selectAll() {
        return super.selectAll();
    }
}
