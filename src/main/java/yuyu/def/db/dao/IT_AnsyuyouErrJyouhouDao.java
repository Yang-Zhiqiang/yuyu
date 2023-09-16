package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_AnsyuyouErrJyouhou;

/**
 * 案内収納用エラー情報テーブル(IT_AnsyuyouErrJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AnsyuyouErrJyouhouDao extends AbstractDao<IT_AnsyuyouErrJyouhou> {

    public IT_AnsyuyouErrJyouhouDao() {
        super(IT_AnsyuyouErrJyouhou.class);
    }

    public IT_AnsyuyouErrJyouhou getAnsyuyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pAnsyuyouerrnaiyou) {
        IT_AnsyuyouErrJyouhou iT_AnsyuyouErrJyouhou =  new IT_AnsyuyouErrJyouhou();
        iT_AnsyuyouErrJyouhou.setSyoriYmd(pSyoriYmd);
        iT_AnsyuyouErrJyouhou.setKakutyoujobcd(pKakutyoujobcd);
        iT_AnsyuyouErrJyouhou.setSyono(pSyono);
        iT_AnsyuyouErrJyouhou.setGyoumuKousinTime(pGyoumuKousinTime);
        iT_AnsyuyouErrJyouhou.setAnsyuyouerrnaiyou(pAnsyuyouerrnaiyou);
        return this.selectOne(iT_AnsyuyouErrJyouhou);
    }

}
