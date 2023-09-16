package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhKaiyakuWk;


/**
 * 解約ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhKaiyakuWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhKaiyakuWk<br />
 * @see     PKIW_KhKaiyakuWk<br />
 * @see     QIW_KhKaiyakuWk<br />
 * @see     GenQIW_KhKaiyakuWk<br />
 */
@Entity
public class IW_KhKaiyakuWk extends GenIW_KhKaiyakuWk {

    private static final long serialVersionUID = 1L;

    public IW_KhKaiyakuWk() {
    }

    public IW_KhKaiyakuWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

