package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.mapping.GenBM_ChkKyuuhuKata;


/**
 * 給付型チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKyuuhuKata} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKyuuhuKata<br />
 * @see     PKBM_ChkKyuuhuKata<br />
 * @see     QBM_ChkKyuuhuKata<br />
 * @see     GenQBM_ChkKyuuhuKata<br />
 */
@Entity
public class BM_ChkKyuuhuKata extends GenBM_ChkKyuuhuKata {

    private static final long serialVersionUID = 1L;

    public BM_ChkKyuuhuKata() {
    }

    public BM_ChkKyuuhuKata(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,C_KyhgndkataKbn pKyhkatakbn) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pKyhkatakbn);
    }



}

