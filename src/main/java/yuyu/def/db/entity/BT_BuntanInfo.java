package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.mapping.GenBT_BuntanInfo;


/**
 * 分担情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_BuntanInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_BuntanInfo<br />
 * @see     PKBT_BuntanInfo<br />
 * @see     QBT_BuntanInfo<br />
 * @see     GenQBT_BuntanInfo<br />
 */
@Entity
public class BT_BuntanInfo extends GenBT_BuntanInfo {

    private static final long serialVersionUID = 1L;

    public BT_BuntanInfo() {
    }

    public BT_BuntanInfo(String pDrtencd,String pDairitensyouhincd,String pTesuuryoubuntandrtencd,BizDateYM pTesuuryoubuntanstartym) {
        super(pDrtencd,pDairitensyouhincd,pTesuuryoubuntandrtencd,pTesuuryoubuntanstartym);
    }



}

