package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_WariateHukaInfo;


/**
 * 割当不可情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_WariateHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_WariateHukaInfo<br />
 * @see     PKBT_WariateHukaInfo<br />
 * @see     QBT_WariateHukaInfo<br />
 * @see     GenQBT_WariateHukaInfo<br />
 */
@Entity
public class BT_WariateHukaInfo extends GenBT_WariateHukaInfo {

    private static final long serialVersionUID = 1L;

    public BT_WariateHukaInfo() {
    }

    public BT_WariateHukaInfo(String pKouteikanriid,String pSubSystemId,String pJimutetuzukicd,String pWrthukatskid,String pUserId) {
        super(pKouteikanriid,pSubSystemId,pJimutetuzukicd,pWrthukatskid,pUserId);
    }



}

