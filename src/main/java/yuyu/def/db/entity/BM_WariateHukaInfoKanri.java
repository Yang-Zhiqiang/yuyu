package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_WariateHukaInfoKanri;


/**
 * 割当不可情報管理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_WariateHukaInfoKanri} の JavaDoc を参照してください。<br />
 * @see     GenBM_WariateHukaInfoKanri<br />
 * @see     PKBM_WariateHukaInfoKanri<br />
 * @see     QBM_WariateHukaInfoKanri<br />
 * @see     GenQBM_WariateHukaInfoKanri<br />
 */
@Entity
public class BM_WariateHukaInfoKanri extends GenBM_WariateHukaInfoKanri {

    private static final long serialVersionUID = 1L;

    public BM_WariateHukaInfoKanri() {
    }

    public BM_WariateHukaInfoKanri(String pSubSystemId,String pJimutetuzukicd,String pCurrenttskid,Integer pRenno) {
        super(pSubSystemId,pJimutetuzukicd,pCurrenttskid,pRenno);
    }



}

