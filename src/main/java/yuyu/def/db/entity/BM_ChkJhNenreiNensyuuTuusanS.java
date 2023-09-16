package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkJhNenreiNensyuuTuusanS;


/**
 * 年齢年収制限通算限度Ｓ事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhNenreiNensyuuTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkJhNenreiNensyuuTuusanS<br />
 * @see     PKBM_ChkJhNenreiNensyuuTuusanS<br />
 * @see     QBM_ChkJhNenreiNensyuuTuusanS<br />
 * @see     GenQBM_ChkJhNenreiNensyuuTuusanS<br />
 */
@Entity
public class BM_ChkJhNenreiNensyuuTuusanS extends GenBM_ChkJhNenreiNensyuuTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhNenreiNensyuuTuusanS() {
    }

    public BM_ChkJhNenreiNensyuuTuusanS(BizNumber pHhknfromnen,BizNumber pHhkntonen,Integer pHhknfromnensyuu,Integer pHhkntonensyuu) {
        super(pHhknfromnen,pHhkntonen,pHhknfromnensyuu,pHhkntonensyuu);
    }



}

