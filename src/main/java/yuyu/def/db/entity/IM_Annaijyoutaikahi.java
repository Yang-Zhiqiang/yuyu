package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.db.mapping.GenIM_Annaijyoutaikahi;


/**
 * 案内状態処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_Annaijyoutaikahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_Annaijyoutaikahi<br />
 * @see     PKIM_Annaijyoutaikahi<br />
 * @see     QIM_Annaijyoutaikahi<br />
 * @see     GenQIM_Annaijyoutaikahi<br />
 */
@Entity
public class IM_Annaijyoutaikahi extends GenIM_Annaijyoutaikahi {

    private static final long serialVersionUID = 1L;

    public IM_Annaijyoutaikahi() {
    }

    public IM_Annaijyoutaikahi(String pKinouId,C_AnnaijyoutaiKbn pAnnaijyoutaikbn) {
        super(pKinouId,pAnnaijyoutaikbn);
    }



}

