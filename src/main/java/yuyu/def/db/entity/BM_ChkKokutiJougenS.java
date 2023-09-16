package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkKokutiJougenS;


/**
 * 告知上限Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKokutiJougenS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKokutiJougenS<br />
 * @see     PKBM_ChkKokutiJougenS<br />
 * @see     QBM_ChkKokutiJougenS<br />
 * @see     GenQBM_ChkKokutiJougenS<br />
 */
@Entity
public class BM_ChkKokutiJougenS extends GenBM_ChkKokutiJougenS {

    private static final long serialVersionUID = 1L;

    public BM_ChkKokutiJougenS() {
    }

    public BM_ChkKokutiJougenS(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,BizNumber pHhknfromnen,BizNumber pHhkntonen,Integer pMoskbnfrom,Integer pMoskbnto) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pHhknfromnen,pHhkntonen,pMoskbnfrom,pMoskbnto);
    }



}

