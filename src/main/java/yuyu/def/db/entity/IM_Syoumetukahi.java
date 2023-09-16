package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.mapping.GenIM_Syoumetukahi;


/**
 * 消滅状態処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_Syoumetukahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_Syoumetukahi<br />
 * @see     PKIM_Syoumetukahi<br />
 * @see     QIM_Syoumetukahi<br />
 * @see     GenQIM_Syoumetukahi<br />
 */
@Entity
public class IM_Syoumetukahi extends GenIM_Syoumetukahi {

    private static final long serialVersionUID = 1L;

    public IM_Syoumetukahi() {
    }

    public IM_Syoumetukahi(String pKinouId,C_Syoumetujiyuu pSyoumetujiyuu) {
        super(pKinouId,pSyoumetujiyuu);
    }



}

