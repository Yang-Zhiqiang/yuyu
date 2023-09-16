package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;

/**
 * 請求内容チェック判定マスタ(JM_SkNaiyouChkDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SkNaiyouChkDao extends AbstractDao<JM_SkNaiyouChk> {

    public JM_SkNaiyouChkDao() {
        super(JM_SkNaiyouChk.class);
    }

    public JM_SkNaiyouChk getSkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn,
         C_YobidasimotoTaskKbn pYobidasimototaskkbn){
        JM_SkNaiyouChk jM_SkNaiyouChk =  new JM_SkNaiyouChk();
        jM_SkNaiyouChk.setSknaiyouchkkbn(pSknaiyouchkkbn);
        jM_SkNaiyouChk.setYobidasimototaskkbn(pYobidasimototaskkbn);
        return this.selectOne(jM_SkNaiyouChk);
    }
}
