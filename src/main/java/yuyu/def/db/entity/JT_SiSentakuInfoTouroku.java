package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJT_SiSentakuInfoTouroku;


/**
 * 保険金給付金選択情報登録テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiSentakuInfoTouroku} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiSentakuInfoTouroku<br />
 * @see     PKJT_SiSentakuInfoTouroku<br />
 * @see     QJT_SiSentakuInfoTouroku<br />
 * @see     GenQJT_SiSentakuInfoTouroku<br />
 */
@Entity
public class JT_SiSentakuInfoTouroku extends GenJT_SiSentakuInfoTouroku {

    private static final long serialVersionUID = 1L;

    public JT_SiSentakuInfoTouroku() {
    }

    public JT_SiSentakuInfoTouroku(String pSyono,Integer pRenno) {
        super(pSyono,pRenno);
    }



}

