package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import java.util.List;

/**
 * 査定重過失チェック情報テーブル(JT_SateiJyuukasituChkInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiJyuukasituChkInfoDao extends AbstractDao<JT_SateiJyuukasituChkInfo> {

    public JT_SateiJyuukasituChkInfoDao() {
        super(JT_SateiJyuukasituChkInfo.class);
    }

    @Deprecated
    public JT_SateiJyuukasituChkInfo getSateiJyuukasituChkInfo(String pSkno, String pSyono, Integer pSeikyuurirekino) {
        JT_SateiJyuukasituChkInfo jT_SateiJyuukasituChkInfo =  new JT_SateiJyuukasituChkInfo();
        jT_SateiJyuukasituChkInfo.setSkno(pSkno);
        jT_SateiJyuukasituChkInfo.setSyono(pSyono);
        jT_SateiJyuukasituChkInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SateiJyuukasituChkInfo);
    }

    @Override
    @Deprecated
    public List<JT_SateiJyuukasituChkInfo> selectAll() {
        return super.selectAll();
    }
}
