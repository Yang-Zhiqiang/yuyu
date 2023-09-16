package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_Syonokanri;


/**
 * 証券番号管理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Syonokanri} の JavaDoc を参照してください。<br />
 * @see     GenBM_Syonokanri<br />
 * @see     PKBM_Syonokanri<br />
 * @see     QBM_Syonokanri<br />
 * @see     GenQBM_Syonokanri<br />
 */
@Entity
public class BM_Syonokanri extends GenBM_Syonokanri {

    private static final long serialVersionUID = 1L;

    public BM_Syonokanri() {
    }

    public BM_Syonokanri(String pSeirekinen2keta,String pBosyuusosikicd,Integer pSyonorenno) {
        super(pSeirekinen2keta,pBosyuusosikicd,pSyonorenno);
    }



}

