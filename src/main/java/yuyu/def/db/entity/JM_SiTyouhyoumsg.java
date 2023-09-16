package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJM_SiTyouhyoumsg;


/**
 * 支払帳票メッセージマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SiTyouhyoumsg} の JavaDoc を参照してください。<br />
 * @see     GenJM_SiTyouhyoumsg<br />
 * @see     PKJM_SiTyouhyoumsg<br />
 * @see     QJM_SiTyouhyoumsg<br />
 * @see     GenQJM_SiTyouhyoumsg<br />
 */
@Entity
public class JM_SiTyouhyoumsg extends GenJM_SiTyouhyoumsg {

    private static final long serialVersionUID = 1L;

    public JM_SiTyouhyoumsg() {
    }

    public JM_SiTyouhyoumsg(String pBunrui1,String pBunrui2,Integer pTyouhyoulineno) {
        super(pBunrui1,pBunrui2,pTyouhyoulineno);
    }



}

