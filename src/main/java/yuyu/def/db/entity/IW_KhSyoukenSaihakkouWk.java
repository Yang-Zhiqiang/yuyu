package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhSyoukenSaihakkouWk;


/**
 * 証券再発行ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhSyoukenSaihakkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhSyoukenSaihakkouWk<br />
 * @see     PKIW_KhSyoukenSaihakkouWk<br />
 * @see     QIW_KhSyoukenSaihakkouWk<br />
 * @see     GenQIW_KhSyoukenSaihakkouWk<br />
 */
@Entity
public class IW_KhSyoukenSaihakkouWk extends GenIW_KhSyoukenSaihakkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhSyoukenSaihakkouWk() {
    }

    public IW_KhSyoukenSaihakkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

