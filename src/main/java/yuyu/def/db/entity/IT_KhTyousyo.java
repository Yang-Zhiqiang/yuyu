package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenIT_KhTyousyo;
import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全支払調書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhTyousyo} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhTyousyo<br />
 * @see     PKIT_KhTyousyo<br />
 * @see     QIT_KhTyousyo<br />
 * @see     GenQIT_KhTyousyo<br />
 */
@Entity
public class IT_KhTyousyo extends GenIT_KhTyousyo {

    private static final long serialVersionUID = 1L;

    public IT_KhTyousyo() {
    }

    public IT_KhTyousyo(String pSyono,BizDate pTyouhyouymd,Long pShrtysyrenno) {
        super(pSyono,pTyouhyouymd,pShrtysyrenno);
    }



}

