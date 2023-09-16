package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;

/**
 * 案内収納備金管理テーブル(IT_AsBikinkanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AsBikinkanriDao extends AbstractDao<IT_AsBikinkanri> {

    public IT_AsBikinkanriDao() {
        super(IT_AsBikinkanri.class);
    }

    public IT_AsBikinkanri getAsBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno) {
        IT_AsBikinkanri iT_AsBikinkanri =  new IT_AsBikinkanri();
        iT_AsBikinkanri.setSyono(pSyono);
        iT_AsBikinkanri.setKessankijyunymd(pKessankijyunymd);
        iT_AsBikinkanri.setBkncdkbn(pBkncdkbn);
        iT_AsBikinkanri.setBknkktymd(pBknkktymd);
        iT_AsBikinkanri.setRenno(pRenno);
        return this.selectOne(iT_AsBikinkanri);
    }
}
