package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJT_SinsaTyuui;


/**
 * 審査注意テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SinsaTyuui} の JavaDoc を参照してください。<br />
 * @see     GenJT_SinsaTyuui<br />
 * @see     PKJT_SinsaTyuui<br />
 * @see     QJT_SinsaTyuui<br />
 * @see     GenQJT_SinsaTyuui<br />
 */
@Entity
public class JT_SinsaTyuui extends GenJT_SinsaTyuui {

    private static final long serialVersionUID = 1L;

    public JT_SinsaTyuui() {
    }

    public JT_SinsaTyuui(String pSyono) {
        super(pSyono);
    }



}

