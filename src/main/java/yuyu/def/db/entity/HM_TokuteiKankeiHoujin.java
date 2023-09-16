package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenHM_TokuteiKankeiHoujin;


/**
 * 特定関係法人マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_TokuteiKankeiHoujin} の JavaDoc を参照してください。<br />
 * @see     GenHM_TokuteiKankeiHoujin<br />
 * @see     PKHM_TokuteiKankeiHoujin<br />
 * @see     QHM_TokuteiKankeiHoujin<br />
 * @see     GenQHM_TokuteiKankeiHoujin<br />
 */
@Entity
public class HM_TokuteiKankeiHoujin extends GenHM_TokuteiKankeiHoujin {

    private static final long serialVersionUID = 1L;

    public HM_TokuteiKankeiHoujin() {
    }

    public HM_TokuteiKankeiHoujin(String pTkhjnkinyuucd,BizNumber pMeisaino) {
        super(pTkhjnkinyuucd,pMeisaino);
    }



}

