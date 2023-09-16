package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_TmttkinYskWk;


/**
 * 積立金予測ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_TmttkinYskWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_TmttkinYskWk<br />
 * @see     PKIW_TmttkinYskWk<br />
 * @see     QIW_TmttkinYskWk<br />
 * @see     GenQIW_TmttkinYskWk<br />
 */
@Entity
public class IW_TmttkinYskWk extends GenIW_TmttkinYskWk {

    private static final long serialVersionUID = 1L;

    public IW_TmttkinYskWk() {
    }

    public IW_TmttkinYskWk(String pSyono) {
        super(pSyono);
    }



}

