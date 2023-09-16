package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJT_MisyuupRendo;


/**
 * 未収Ｐ連動テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_MisyuupRendo} の JavaDoc を参照してください。<br />
 * @see     GenJT_MisyuupRendo<br />
 * @see     PKJT_MisyuupRendo<br />
 * @see     QJT_MisyuupRendo<br />
 * @see     GenQJT_MisyuupRendo<br />
 */
@Entity
public class JT_MisyuupRendo extends GenJT_MisyuupRendo {

    private static final long serialVersionUID = 1L;

    public JT_MisyuupRendo() {
    }

    public JT_MisyuupRendo(String pSyono,Integer pDatarenno) {
        super(pSyono,pDatarenno);
    }



}

