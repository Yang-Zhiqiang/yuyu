package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJT_Outai;


/**
 * 応対テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_Outai} の JavaDoc を参照してください。<br />
 * @see     GenJT_Outai<br />
 * @see     PKJT_Outai<br />
 * @see     QJT_Outai<br />
 * @see     GenQJT_Outai<br />
 */
@Entity
public class JT_Outai extends GenJT_Outai {

    private static final long serialVersionUID = 1L;

    public JT_Outai() {
    }

    public JT_Outai(String pSyono,Integer pRenno) {
        super(pSyono,pRenno);
    }



}

