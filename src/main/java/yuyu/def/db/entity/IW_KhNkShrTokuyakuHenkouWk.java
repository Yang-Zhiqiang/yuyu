package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhNkShrTokuyakuHenkouWk;


/**
 * 年金支払特約変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhNkShrTokuyakuHenkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhNkShrTokuyakuHenkouWk<br />
 * @see     PKIW_KhNkShrTokuyakuHenkouWk<br />
 * @see     QIW_KhNkShrTokuyakuHenkouWk<br />
 * @see     GenQIW_KhNkShrTokuyakuHenkouWk<br />
 */
@Entity
public class IW_KhNkShrTokuyakuHenkouWk extends GenIW_KhNkShrTokuyakuHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhNkShrTokuyakuHenkouWk() {
    }

    public IW_KhNkShrTokuyakuHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

