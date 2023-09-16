package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KhDshrTuki;
import yuyu.def.db.mapping.GenIT_KhDshrTuki;
import yuyu.def.db.meta.GenQIT_KhDshrTuki;
import yuyu.def.db.meta.QIT_KhDshrTuki;

/**
 * 契約保全Ｄ支払統計テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhDshrTuki} の JavaDoc を参照してください。
 * @see     GenIT_KhDshrTuki
 * @see     PKIT_KhDshrTuki
 * @see     QIT_KhDshrTuki
 * @see     GenQIT_KhDshrTuki
 */
@Entity
public class IT_KhDshrTuki extends GenIT_KhDshrTuki {

    private static final long serialVersionUID = 1L;

    public IT_KhDshrTuki() {
    }

    public IT_KhDshrTuki(String pDshrtoukeisikibetukey, String pSyono) {
        super(pDshrtoukeisikibetukey, pSyono);
    }

}
