package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_BAK_KhDshrTuki;
import yuyu.def.db.mapping.GenIT_BAK_KhDshrTuki;
import yuyu.def.db.meta.GenQIT_BAK_KhDshrTuki;
import yuyu.def.db.meta.QIT_BAK_KhDshrTuki;

/**
 * 契約保全Ｄ支払統計バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhDshrTuki} の JavaDoc を参照してください。
 * @see     GenIT_BAK_KhDshrTuki
 * @see     PKIT_BAK_KhDshrTuki
 * @see     QIT_BAK_KhDshrTuki
 * @see     GenQIT_BAK_KhDshrTuki
 */
@Entity
public class IT_BAK_KhDshrTuki extends GenIT_BAK_KhDshrTuki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhDshrTuki() {
    }

    public IT_BAK_KhDshrTuki(
        String pDshrtoukeisikibetukey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        super(
            pDshrtoukeisikibetukey,
            pSyono,
            pTrkssikibetukey
        );
    }

}
