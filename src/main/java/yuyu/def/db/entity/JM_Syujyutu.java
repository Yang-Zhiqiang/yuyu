package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJM_Syujyutu;


/**
 * 手術マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_Syujyutu} の JavaDoc を参照してください。<br />
 * @see     GenJM_Syujyutu<br />
 * @see     PKJM_Syujyutu<br />
 * @see     QJM_Syujyutu<br />
 * @see     GenQJM_Syujyutu<br />
 */
@Entity
public class JM_Syujyutu extends GenJM_Syujyutu {

    private static final long serialVersionUID = 1L;

    public JM_Syujyutu() {
    }

    public JM_Syujyutu(String pSyujyututourokuno) {
        super(pSyujyututourokuno);
    }



}

