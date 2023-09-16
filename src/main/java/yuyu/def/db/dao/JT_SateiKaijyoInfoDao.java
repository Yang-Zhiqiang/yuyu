package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;

/**
 * 査定解除情報テーブル(JT_SateiKaijyoInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiKaijyoInfoDao extends AbstractDao<JT_SateiKaijyoInfo> {

    public JT_SateiKaijyoInfoDao() {
        super(JT_SateiKaijyoInfo.class);
    }

    @Deprecated
    public JT_SateiKaijyoInfo getSateiKaijyoInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SateiKaijyoInfo jT_SateiKaijyoInfo =  new JT_SateiKaijyoInfo();
        jT_SateiKaijyoInfo.setSkno(pSkno);
        jT_SateiKaijyoInfo.setSyono(pSyono);
        jT_SateiKaijyoInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SateiKaijyoInfo);
    }

    @Override
    @Deprecated
    public List<JT_SateiKaijyoInfo> selectAll() {
        return super.selectAll();
    }
}
