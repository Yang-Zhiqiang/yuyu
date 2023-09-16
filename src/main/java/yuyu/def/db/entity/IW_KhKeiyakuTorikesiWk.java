package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhKeiyakuTorikesiWk;


/**
 * 契約取消ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhKeiyakuTorikesiWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhKeiyakuTorikesiWk<br />
 * @see     PKIW_KhKeiyakuTorikesiWk<br />
 * @see     QIW_KhKeiyakuTorikesiWk<br />
 * @see     GenQIW_KhKeiyakuTorikesiWk<br />
 */
@Entity
public class IW_KhKeiyakuTorikesiWk extends GenIW_KhKeiyakuTorikesiWk {

    private static final long serialVersionUID = 1L;

    public IW_KhKeiyakuTorikesiWk() {
    }

    public IW_KhKeiyakuTorikesiWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

