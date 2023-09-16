package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_HutanpoBui;


/**
 * 不担保部位マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_HutanpoBui} の JavaDoc を参照してください。<br />
 * @see     GenBM_HutanpoBui<br />
 * @see     PKBM_HutanpoBui<br />
 * @see     QBM_HutanpoBui<br />
 * @see     GenQBM_HutanpoBui<br />
 */
@Entity
public class BM_HutanpoBui extends GenBM_HutanpoBui {

    private static final long serialVersionUID = 1L;

    public BM_HutanpoBui() {
    }

    public BM_HutanpoBui(String pHtnpbuicd) {
        super(pHtnpbuicd);
    }



}

