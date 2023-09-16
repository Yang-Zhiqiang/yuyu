package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;

/**
 * 死亡率統計整備後情報ビュー(SV_SibourituToukeiSeibigoDao) アクセス用の DAO クラスです。<br />
 */
public class SV_SibourituToukeiSeibigoDao extends AbstractDao<SV_SibourituToukeiSeibigo> {

    public SV_SibourituToukeiSeibigoDao() {
        super(SV_SibourituToukeiSeibigo.class);
    }

    public SV_SibourituToukeiSeibigo getSibourituToukeiSeibigo(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        SV_SibourituToukeiSeibigo sV_SibourituToukeiSeibigo =  new SV_SibourituToukeiSeibigo();
        sV_SibourituToukeiSeibigo.setSyono(pSyono);
        sV_SibourituToukeiSeibigo.setGyoumuKousinKinou(pGyoumuKousinKinou);
        sV_SibourituToukeiSeibigo.setGyoumuKousinTime(pGyoumuKousinTime);
        return this.selectOne(sV_SibourituToukeiSeibigo);
    }
}
