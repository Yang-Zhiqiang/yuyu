package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenAM_Sosiki;


/**
 * 組織マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_Sosiki} の JavaDoc を参照してください。<br />
 * @see     GenAM_Sosiki<br />
 * @see     PKAM_Sosiki<br />
 * @see     QAM_Sosiki<br />
 * @see     GenQAM_Sosiki<br />
 */
@Entity
public class AM_Sosiki extends GenAM_Sosiki {

    private static final long serialVersionUID = 1L;

    public AM_Sosiki() {
    }

    public AM_Sosiki(String pSosikicd) {
        super(pSosikicd);
    }



}

