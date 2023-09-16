package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.mapping.GenBM_TantouCd;


/**
 * 担当コードマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TantouCd} の JavaDoc を参照してください。<br />
 * @see     GenBM_TantouCd<br />
 * @see     PKBM_TantouCd<br />
 * @see     QBM_TantouCd<br />
 * @see     GenQBM_TantouCd<br />
 */
@Entity
public class BM_TantouCd extends GenBM_TantouCd {

    private static final long serialVersionUID = 1L;

    public BM_TantouCd() {
    }

    public BM_TantouCd(C_TantouCdKbn pTantocd) {
        super(pTantocd);
    }



}

