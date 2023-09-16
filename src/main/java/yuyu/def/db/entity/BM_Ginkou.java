package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_Ginkou;


/**
 * 銀行マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Ginkou} の JavaDoc を参照してください。<br />
 * @see     GenBM_Ginkou<br />
 * @see     PKBM_Ginkou<br />
 * @see     QBM_Ginkou<br />
 * @see     GenQBM_Ginkou<br />
 */
@Entity
public class BM_Ginkou extends GenBM_Ginkou {

    private static final long serialVersionUID = 1L;

    public BM_Ginkou() {
    }

    public BM_Ginkou(String pBankcd,String pSitencd) {
        super(pBankcd,pSitencd);
    }



}

