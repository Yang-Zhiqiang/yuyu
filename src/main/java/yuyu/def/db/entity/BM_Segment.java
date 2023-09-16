package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Segcd;
import yuyu.def.db.mapping.GenBM_Segment;


/**
 * セグメントマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Segment} の JavaDoc を参照してください。<br />
 * @see     GenBM_Segment<br />
 * @see     PKBM_Segment<br />
 * @see     QBM_Segment<br />
 * @see     GenQBM_Segment<br />
 */
@Entity
public class BM_Segment extends GenBM_Segment {

    private static final long serialVersionUID = 1L;

    public BM_Segment() {
    }

    public BM_Segment(C_Segcd pSegcd) {
        super(pSegcd);
    }



}

