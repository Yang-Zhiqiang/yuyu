package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenBM_SyoruiKtg;


/**
 * 書類結合マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SyoruiKtg} の JavaDoc を参照してください。<br />
 * @see     GenBM_SyoruiKtg<br />
 * @see     PKBM_SyoruiKtg<br />
 * @see     QBM_SyoruiKtg<br />
 * @see     GenQBM_SyoruiKtg<br />
 */
@Entity
public class BM_SyoruiKtg extends GenBM_SyoruiKtg {

    private static final long serialVersionUID = 1L;

    public BM_SyoruiKtg() {
    }

    public BM_SyoruiKtg(C_SyoruiCdKbn pSyoruiCd,String pKtgsyoruicd) {
        super(pSyoruiCd,pKtgsyoruicd);
    }



}

