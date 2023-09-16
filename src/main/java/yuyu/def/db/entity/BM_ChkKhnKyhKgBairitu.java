package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.mapping.GenBM_ChkKhnKyhKgBairitu;


/**
 * 基本給付金額倍率チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKhnKyhKgBairitu} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKhnKyhKgBairitu<br />
 * @see     PKBM_ChkKhnKyhKgBairitu<br />
 * @see     QBM_ChkKhnKyhKgBairitu<br />
 * @see     GenQBM_ChkKhnKyhKgBairitu<br />
 */
@Entity
public class BM_ChkKhnKyhKgBairitu extends GenBM_ChkKhnKyhKgBairitu {

    private static final long serialVersionUID = 1L;

    public BM_ChkKhnKyhKgBairitu() {
    }

    public BM_ChkKhnKyhKgBairitu(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pKhnkyhkgbairitukbn);
    }



}

