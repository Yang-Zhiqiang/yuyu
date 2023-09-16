package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_FBSoukinListKanri;

/**
 * ＦＢ送金リスト管理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FBSoukinListKanri} の JavaDoc を参照してください。<br />
 * @see     GenBM_FBSoukinListKanri<br />
 * @see     PKBM_FBSoukinListKanri<br />
 * @see     QBM_FBSoukinListKanri<br />
 * @see     GenQBM_FBSoukinListKanri<br />
 */
@Entity
public class BM_FBSoukinListKanri extends GenBM_FBSoukinListKanri {

    private static final long serialVersionUID = 1L;

    public BM_FBSoukinListKanri() {
    }

    public BM_FBSoukinListKanri(String pSyoricd,String pSyorisosikicd) {
        super(pSyoricd,pSyorisosikicd);
    }



}

