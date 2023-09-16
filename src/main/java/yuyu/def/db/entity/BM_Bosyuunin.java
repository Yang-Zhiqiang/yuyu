package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_Bosyuunin;


/**
 * 募集人マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Bosyuunin} の JavaDoc を参照してください。<br />
 * @see     GenBM_Bosyuunin<br />
 * @see     PKBM_Bosyuunin<br />
 * @see     QBM_Bosyuunin<br />
 * @see     GenQBM_Bosyuunin<br />
 */
@Entity
public class BM_Bosyuunin extends GenBM_Bosyuunin {

    private static final long serialVersionUID = 1L;

    public BM_Bosyuunin() {
    }

    public BM_Bosyuunin(String pBosyuucd) {
        super(pBosyuucd);
    }



}

