package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_KetteiSya;


/**
 * 決定者マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_KetteiSya} の JavaDoc を参照してください。<br />
 * @see     GenHM_KetteiSya<br />
 * @see     PKHM_KetteiSya<br />
 * @see     QHM_KetteiSya<br />
 * @see     GenQHM_KetteiSya<br />
 */
@Entity
public class HM_KetteiSya extends GenHM_KetteiSya {

    private static final long serialVersionUID = 1L;

    public HM_KetteiSya() {
    }

    public HM_KetteiSya(String pKetsyacd) {
        super(pKetsyacd);
    }



}

