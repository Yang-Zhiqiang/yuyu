package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;

/**
 * 年金種類チェックマスタ(BM_ChkNenkinSyuruiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNenkinSyuruiDao extends AbstractDao<BM_ChkNenkinSyurui> {

    public BM_ChkNenkinSyuruiDao() {
        super(BM_ChkNenkinSyurui.class);
    }

    public BM_ChkNenkinSyurui getChkNenkinSyurui(String pSyouhncd,
         Integer pSyusyouhnsdnofrom,
         Integer pSyusyouhnsdnoto,
         C_Sknenkinsyu pSknenkinsyu){
        BM_ChkNenkinSyurui bM_ChkNenkinSyurui =  new BM_ChkNenkinSyurui();
        bM_ChkNenkinSyurui.setSyouhncd(pSyouhncd);
        bM_ChkNenkinSyurui.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkNenkinSyurui.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkNenkinSyurui.setSknenkinsyu(pSknenkinsyu);
        return this.selectOne(bM_ChkNenkinSyurui);
    }
}
