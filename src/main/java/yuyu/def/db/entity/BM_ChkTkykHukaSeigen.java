package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkTkykHukaSeigen;


/**
 * 特約付加制限チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkTkykHukaSeigen} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkTkykHukaSeigen<br />
 * @see     PKBM_ChkTkykHukaSeigen<br />
 * @see     QBM_ChkTkykHukaSeigen<br />
 * @see     GenQBM_ChkTkykHukaSeigen<br />
 */
@Entity
public class BM_ChkTkykHukaSeigen extends GenBM_ChkTkykHukaSeigen {

    private static final long serialVersionUID = 1L;

    public BM_ChkTkykHukaSeigen() {
    }

    public BM_ChkTkykHukaSeigen(String pSyusyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,Integer pSntkhoukbnfrom,Integer pSntkhoukbnto,BizNumber pHhknfromnen,BizNumber pHhkntonen,String pTksyouhncd) {
        super(pSyusyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pSntkhoukbnfrom,pSntkhoukbnto,pHhknfromnen,pHhkntonen,pTksyouhncd);
    }



}

