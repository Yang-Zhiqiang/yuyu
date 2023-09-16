package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenBT_NenkinInfoRendou;


/**
 * 年金情報連動テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_NenkinInfoRendou} の JavaDoc を参照してください。<br />
 * @see     GenBT_NenkinInfoRendou<br />
 * @see     PKBT_NenkinInfoRendou<br />
 * @see     QBT_NenkinInfoRendou<br />
 * @see     GenQBT_NenkinInfoRendou<br />
 */
@Entity
public class BT_NenkinInfoRendou extends GenBT_NenkinInfoRendou {

    private static final long serialVersionUID = 1L;

    public BT_NenkinInfoRendou() {
    }

    public BT_NenkinInfoRendou(BizDate pSyoriYmd,String pSyono,Integer pRenno) {
        super(pSyoriYmd,pSyono,pRenno);
    }



}

