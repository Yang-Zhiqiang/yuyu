package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhGengakuWk;


/**
 * 減額ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhGengakuWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhGengakuWk<br />
 * @see     PKIW_KhGengakuWk<br />
 * @see     QIW_KhGengakuWk<br />
 * @see     GenQIW_KhGengakuWk<br />
 */
@Entity
public class IW_KhGengakuWk extends GenIW_KhGengakuWk {

    private static final long serialVersionUID = 1L;

    public IW_KhGengakuWk() {
    }

    public IW_KhGengakuWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

