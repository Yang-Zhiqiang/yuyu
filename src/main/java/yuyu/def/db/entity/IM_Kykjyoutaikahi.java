package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.db.mapping.GenIM_Kykjyoutaikahi;


/**
 * 契約状態処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_Kykjyoutaikahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_Kykjyoutaikahi<br />
 * @see     PKIM_Kykjyoutaikahi<br />
 * @see     QIM_Kykjyoutaikahi<br />
 * @see     GenQIM_Kykjyoutaikahi<br />
 */
@Entity
public class IM_Kykjyoutaikahi extends GenIM_Kykjyoutaikahi {

    private static final long serialVersionUID = 1L;

    public IM_Kykjyoutaikahi() {
    }

    public IM_Kykjyoutaikahi(String pKinouId,C_Kykjyoutai pKykjyoutai) {
        super(pKinouId,pKykjyoutai);
    }



}

