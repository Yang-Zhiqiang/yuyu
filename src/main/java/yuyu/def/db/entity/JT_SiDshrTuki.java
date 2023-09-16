package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJT_SiDshrTuki;
import yuyu.def.db.mapping.GenJT_SiDshrTuki;
import yuyu.def.db.meta.GenQJT_SiDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;

/**
 * 保険金給付金Ｄ支払統計テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiDshrTuki} の JavaDoc を参照してください。
 * @see     GenJT_SiDshrTuki
 * @see     PKJT_SiDshrTuki
 * @see     QJT_SiDshrTuki
 * @see     GenQJT_SiDshrTuki
 */
@Entity
public class JT_SiDshrTuki extends GenJT_SiDshrTuki {

    private static final long serialVersionUID = 1L;

    public JT_SiDshrTuki() {
    }

    public JT_SiDshrTuki(String pDshrtoukeisikibetukey) {
        super(pDshrtoukeisikibetukey);
    }

}
