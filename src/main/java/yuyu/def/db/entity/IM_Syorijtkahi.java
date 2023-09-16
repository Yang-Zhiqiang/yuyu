package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIM_Syorijtkahi;


/**
 * 処理状態処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_Syorijtkahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_Syorijtkahi<br />
 * @see     PKIM_Syorijtkahi<br />
 * @see     QIM_Syorijtkahi<br />
 * @see     GenQIM_Syorijtkahi<br />
 */
@Entity
public class IM_Syorijtkahi extends GenIM_Syorijtkahi {

    private static final long serialVersionUID = 1L;

    public IM_Syorijtkahi() {
    }

    public IM_Syorijtkahi(String pKinouId,String pSyorijimuttdkcd,String pSyoritaskid) {
        super(pKinouId,pSyorijimuttdkcd,pSyoritaskid);
    }



}

