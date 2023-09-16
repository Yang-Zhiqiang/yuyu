package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiinHantei;

/**
 * 死因判定マスタ(JM_SiinHanteiDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SiinHanteiDao extends AbstractDao<JM_SiinHantei> {

    public JM_SiinHanteiDao() {
        super(JM_SiinHantei.class);
    }

    public JM_SiinHantei getSiinHantei(C_GeninKbn pSiboukariuketukejigeninkbn, C_GeninKbn pSeikyuuuketukejigeninkbn, C_UmuKbn pKansensyouumukbn, C_UmuKbn pSaigaikanouseiumukbn, C_UmuKbn pHusyounosiumukbn, C_UmuKbn pSateikaksaigaikanouseikbn, C_UmuKbn pSateikakhusyousikbn) {
        JM_SiinHantei jM_SiinHantei =  new JM_SiinHantei();
        jM_SiinHantei.setSiboukariuketukejigeninkbn(pSiboukariuketukejigeninkbn);
        jM_SiinHantei.setSeikyuuuketukejigeninkbn(pSeikyuuuketukejigeninkbn);
        jM_SiinHantei.setKansensyouumukbn(pKansensyouumukbn);
        jM_SiinHantei.setSaigaikanouseiumukbn(pSaigaikanouseiumukbn);
        jM_SiinHantei.setHusyounosiumukbn(pHusyounosiumukbn);
        jM_SiinHantei.setSateikaksaigaikanouseikbn(pSateikaksaigaikanouseikbn);
        jM_SiinHantei.setSateikakhusyousikbn(pSateikakhusyousikbn);
        return this.selectOne(jM_SiinHantei);
    }
}
