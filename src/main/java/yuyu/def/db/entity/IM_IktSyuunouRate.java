package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIM_IktSyuunouRate;


/**
 * 一括収納率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_IktSyuunouRate} の JavaDoc を参照してください。<br />
 * @see     GenIM_IktSyuunouRate<br />
 * @see     PKIM_IktSyuunouRate<br />
 * @see     QIM_IktSyuunouRate<br />
 * @see     GenQIM_IktSyuunouRate<br />
 */
@Entity
public class IM_IktSyuunouRate extends GenIM_IktSyuunouRate {

    private static final long serialVersionUID = 1L;

    public IM_IktSyuunouRate() {
    }

    public IM_IktSyuunouRate(String pSyouhncd,Integer pSyouhnsdno,Integer pIktkaisuu) {
        super(pSyouhncd,pSyouhnsdno,pIktkaisuu);
    }



}

