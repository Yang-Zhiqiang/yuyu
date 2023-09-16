package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkSyouhnKokutiJougenS;


/**
 * 商品単位告知上限Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSyouhnKokutiJougenS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkSyouhnKokutiJougenS<br />
 * @see     PKBM_ChkSyouhnKokutiJougenS<br />
 * @see     QBM_ChkSyouhnKokutiJougenS<br />
 * @see     GenQBM_ChkSyouhnKokutiJougenS<br />
 */
@Entity
public class BM_ChkSyouhnKokutiJougenS extends GenBM_ChkSyouhnKokutiJougenS {

    private static final long serialVersionUID = 1L;

    public BM_ChkSyouhnKokutiJougenS() {
    }

    public BM_ChkSyouhnKokutiJougenS(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,BizNumber pHhknfromnen,BizNumber pHhkntonen,Integer pMoskbnfrom,Integer pMoskbnto) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pHhknfromnen,pHhkntonen,pMoskbnfrom,pMoskbnto);
    }



}

