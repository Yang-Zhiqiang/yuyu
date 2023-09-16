package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_ChkKeiyakuTaniSaikouS;


/**
 * 契約単位最高Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKeiyakuTaniSaikouS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKeiyakuTaniSaikouS<br />
 * @see     PKBM_ChkKeiyakuTaniSaikouS<br />
 * @see     QBM_ChkKeiyakuTaniSaikouS<br />
 * @see     GenQBM_ChkKeiyakuTaniSaikouS<br />
 */
@Entity
public class BM_ChkKeiyakuTaniSaikouS extends GenBM_ChkKeiyakuTaniSaikouS {

    private static final long serialVersionUID = 1L;

    public BM_ChkKeiyakuTaniSaikouS() {
    }

    public BM_ChkKeiyakuTaniSaikouS(String pSyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto) {
        super(pSyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto);
    }



}

