package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_ChkKykDairitenTuusanS;
import yuyu.def.classification.C_KihonssyuruiKbn;

/**
 * 契約者同一代理店通算Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKykDairitenTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkKykDairitenTuusanS<br />
 * @see     PKBM_ChkKykDairitenTuusanS<br />
 * @see     QBM_ChkKykDairitenTuusanS<br />
 * @see     GenQBM_ChkKykDairitenTuusanS<br />
 */
@Entity
public class BM_ChkKykDairitenTuusanS extends GenBM_ChkKykDairitenTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkKykDairitenTuusanS() {
    }

    public BM_ChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {
        super(pKihonssyuruikbn);
    }

}
