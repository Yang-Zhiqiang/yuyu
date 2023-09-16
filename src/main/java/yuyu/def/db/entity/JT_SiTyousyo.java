package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenJT_SiTyousyo;


/**
 * 保険金給付金支払調書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiTyousyo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiTyousyo<br />
 * @see     PKJT_SiTyousyo<br />
 * @see     QJT_SiTyousyo<br />
 * @see     GenQJT_SiTyousyo<br />
 */
@Entity
public class JT_SiTyousyo extends GenJT_SiTyousyo {

    private static final long serialVersionUID = 1L;

    public JT_SiTyousyo() {
    }

    public JT_SiTyousyo(String pSyono,BizDate pTyouhyouymd,Long pShrtysyrenno) {
        super(pSyono,pTyouhyouymd,pShrtysyrenno);
    }



}

