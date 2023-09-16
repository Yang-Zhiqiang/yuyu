package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.mapping.GenBM_ChkKata;


/**
 * 型区分チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKata} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKata<br />
 * @see     PKBM_ChkKata<br />
 * @see     QBM_ChkKata<br />
 * @see     GenQBM_ChkKata<br />
 */
@Entity
public class BM_ChkKata extends GenBM_ChkKata {

    private static final long serialVersionUID = 1L;

    public BM_ChkKata() {
    }

    public BM_ChkKata(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,C_UmuKbn pTktanbrumu,C_KataKbn pKatakbn) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pTktanbrumu,pKatakbn);
    }



}

