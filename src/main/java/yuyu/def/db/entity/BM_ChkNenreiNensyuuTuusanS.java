package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkNenreiNensyuuTuusanS;


/**
 * 年齢年収制限通算限度Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNenreiNensyuuTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkNenreiNensyuuTuusanS<br />
 * @see     PKBM_ChkNenreiNensyuuTuusanS<br />
 * @see     QBM_ChkNenreiNensyuuTuusanS<br />
 * @see     GenQBM_ChkNenreiNensyuuTuusanS<br />
 */
@Entity
public class BM_ChkNenreiNensyuuTuusanS extends GenBM_ChkNenreiNensyuuTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkNenreiNensyuuTuusanS() {
    }

    public BM_ChkNenreiNensyuuTuusanS(BizNumber pHhknfromnen,BizNumber pHhkntonen,Integer pHhknfromnensyuu,Integer pHhkntonensyuu) {
        super(pHhknfromnen,pHhkntonen,pHhknfromnensyuu,pHhkntonensyuu);
    }



}

