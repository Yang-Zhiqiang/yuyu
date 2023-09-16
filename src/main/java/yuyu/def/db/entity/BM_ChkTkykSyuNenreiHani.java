package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.mapping.GenBM_ChkTkykSyuNenreiHani;


/**
 * 特約種類年齢範囲チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkTkykSyuNenreiHani} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkTkykSyuNenreiHani<br />
 * @see     PKBM_ChkTkykSyuNenreiHani<br />
 * @see     QBM_ChkTkykSyuNenreiHani<br />
 * @see     GenQBM_ChkTkykSyuNenreiHani<br />
 */
@Entity
public class BM_ChkTkykSyuNenreiHani extends GenBM_ChkTkykSyuNenreiHani {

    private static final long serialVersionUID = 1L;

    public BM_ChkTkykSyuNenreiHani() {
    }

    public BM_ChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn) {
        super(pPmnjtkkbn);
    }



}

