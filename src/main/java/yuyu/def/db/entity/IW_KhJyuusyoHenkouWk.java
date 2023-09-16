package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhJyuusyoHenkouWk;


/**
 * 住所変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhJyuusyoHenkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhJyuusyoHenkouWk<br />
 * @see     PKIW_KhJyuusyoHenkouWk<br />
 * @see     QIW_KhJyuusyoHenkouWk<br />
 * @see     GenQIW_KhJyuusyoHenkouWk<br />
 */
@Entity
public class IW_KhJyuusyoHenkouWk extends GenIW_KhJyuusyoHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhJyuusyoHenkouWk() {
    }

    public IW_KhJyuusyoHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

