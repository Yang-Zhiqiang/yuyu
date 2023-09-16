package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhTargetTokuyakuHenkouWk;


/**
 * ターゲット特約変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhTargetTokuyakuHenkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhTargetTokuyakuHenkouWk<br />
 * @see     PKIW_KhTargetTokuyakuHenkouWk<br />
 * @see     QIW_KhTargetTokuyakuHenkouWk<br />
 * @see     GenQIW_KhTargetTokuyakuHenkouWk<br />
 */
@Entity
public class IW_KhTargetTokuyakuHenkouWk extends GenIW_KhTargetTokuyakuHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhTargetTokuyakuHenkouWk() {
    }

    public IW_KhTargetTokuyakuHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

